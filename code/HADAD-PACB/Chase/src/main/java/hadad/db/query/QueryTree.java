package hadad.db.query;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Logger;

import hadad.db.canonicaldb.CanonicalSchema;
import hadad.db.canonicaldb.Database;
import hadad.db.datalogexpr.Statement;
import hadad.db.datalogexpr.StatementBinaryOp;
import hadad.db.datalogexpr.StatementJoin;
import hadad.db.datalogexpr.StatementOp;
import hadad.db.datalogexpr.StatementScan;
import hadad.db.datalogexpr.Value;

/**
 * This class implements a physical query tree. It contains methods
 * to construct a query tree out of a <code>Statement</code>
 */
public class QueryTree {

    /** Logger */
    private final static Logger LOGGER = Logger.getLogger(QueryTree.class.getName());

    private static final int PRINTING_INDENT = 4;

    /** The query tree root */
    private Operator root;
    /** The leaves of the tree */
    private List<MapPredicates> leaves;
    /** The blocking operators in the tree */
    private List<Operator> blockingOps;

    /**
     * Constructor.
     * 
     * @param topOp
     *            The root of the tree
     */
    private QueryTree(final Operator topOp) {
        root = topOp;
        topOp.setTopOperator(true);
        computeLeavesAndBlocks();
        initialize();
    }

    /**
     * Constructor
     * 
     * @param statement
     *            query statement
     * @param db
     *            the database
     */
    public QueryTree(final Statement statement, final Database db) {

        Operator leftChild;
        Operator rightChild;
        Operator newOperator;
        CanonicalSchema project;
        LinkedHashMap<Integer, Value> newValuesMap;

        Stack<StatementOp> parentStOp = new Stack<StatementOp>();
        Stack<Operator> childrenOp = new Stack<Operator>();

        StatementOp oldStOp = null;
        StatementOp currStOp = statement;
        parentStOp.push(null);

        while (currStOp != null) {
            if (currStOp instanceof Statement) {
                currStOp = ((Statement) currStOp).getChildOp();
            } else if (currStOp instanceof StatementScan) {
                if (parentStOp.size() == 1) {
                    project = statement.head().getCanonicalSchema();
                    newValuesMap = statement.head().getPosToValueCorrespondence();
                } else {
                    project = currStOp.getAttribsToProject();
                    newValuesMap = new LinkedHashMap<Integer, Value>();
                }
                newOperator = new MapPredicates(((StatementScan) currStOp).getPredicate(), db, project, newValuesMap);
                childrenOp.push(newOperator);
                oldStOp = currStOp;
                currStOp = parentStOp.pop();
            } else if (currStOp instanceof StatementBinaryOp) {
                if (((StatementBinaryOp) currStOp).getChildOp1() == oldStOp) {
                    parentStOp.push(currStOp);
                    currStOp = ((StatementBinaryOp) currStOp).getChildOp2();
                } else if (((StatementBinaryOp) currStOp).getChildOp2() == oldStOp) {
                    rightChild = childrenOp.pop();
                    leftChild = childrenOp.pop();

                    if (parentStOp.size() == 1) {
                        project = statement.head().getCanonicalSchema();
                        newValuesMap = statement.head().getPosToValueCorrespondence();
                    } else {
                        project = currStOp.getAttribsToProject();
                        newValuesMap = new LinkedHashMap<Integer, Value>();
                    }

                    if (currStOp instanceof StatementJoin)
                        newOperator = new NaturalJoin(leftChild, rightChild, project, newValuesMap);
                    else
                        newOperator = null;

                    childrenOp.push(newOperator);

                    oldStOp = currStOp;
                    currStOp = parentStOp.pop();
                } else {
                    parentStOp.push(currStOp);
                    currStOp = ((StatementBinaryOp) currStOp).getChildOp1();
                }
            }

        }

        if (!childrenOp.isEmpty()) {
            root = childrenOp.pop();
            root.setTopOperator(true);
        }
        computeLeavesAndBlocks();
        initialize();
    }

    /**
     * Create a query tree using a given query <code> Statement </code> and <code> Database </code>
     * 
     * @param statement
     *            the query statement
     * @param db
     *            the database
     * @return the newly created query tree
     */
    public static QueryTree CreateQueryTree(final Statement statement, final Database db) {
        return new QueryTree(statement, db);
    }

    /**
     * Create a query tree using a given query <code> Statement </code>(s) (left and right) and <code> Database </code>
     * 
     * @param left
     *            the left query statement
     * @param right
     *            the right query statement
     * @param db
     *            the database
     * @return the newly created query tree
     */
    public static QueryTree CreateQueryTreeForDifference(final Statement left, final Statement right, Database db) {
        final QueryTree leftTree = CreateQueryTree(left, db);
        final QueryTree rightTree = CreateQueryTree(right, db);
        final Difference diffOp = new Difference(leftTree.root, rightTree.root, leftTree.root.outSchema,
                new LinkedHashMap<Integer, Value>());
        leftTree.root.setTopOperator(false);
        rightTree.root.setTopOperator(false);
        diffOp.setTopOperator(true);
        return new QueryTree(diffOp);
    }

    /**
     * Initial query evaluation
     */
    protected void initialize() {
        int numOfLeaves = leaves.size();
        for (int i = 0; i < numOfLeaves; i++)
            leaves.get(i).pushAll();
    }

    /**
     * Compute query leavers and block ops
     */
    private void computeLeavesAndBlocks() {
        leaves = new ArrayList<MapPredicates>();
        blockingOps = new ArrayList<Operator>();

        LinkedList<Operator> opQueue = new LinkedList<Operator>();
        opQueue.addFirst(root);

        while (!opQueue.isEmpty()) {
            Operator currentOp = opQueue.removeFirst();
            if (currentOp instanceof MapPredicates)
                leaves.add((MapPredicates) currentOp);
            else if (currentOp instanceof UnaryOperator)
                opQueue.addLast(((UnaryOperator) currentOp).childOperator());
            else if (currentOp instanceof BinaryOperator) {
                opQueue.addLast(((BinaryOperator) currentOp).childOp1());
                opQueue.addLast(((BinaryOperator) currentOp).childOp2());
            }
            if (currentOp.isBlockedDefault())
                blockingOps.add(0, currentOp);
        }
    }

    /**
     * Get leaves
     * 
     * @return query leaves
     */
    public List<MapPredicates> getLeaves() {
        return leaves;
    }

    /**
     * Get blocking operators
     * 
     * @return blocking operators
     */
    public List<Operator> getBlockingOps() {
        return blockingOps;
    }

    /**
     * Get query root
     * 
     * @return
     */
    public Operator getRoot() {
        return root;
    }

    /**
     * Flushes the query tree by calling the <code>flush()</code> function of the
     * root
     */
    public void flush() {
        root.flush();
    }

    @Override
    public String toString() {
        final StringBuffer str = new StringBuffer("");
        Stack<OperatorNode> stack;
        OperatorNode curNode;
        Operator curOp;
        int curDepth;
        if (root == null)
            return str.toString();

        stack = new Stack<OperatorNode>();
        stack.push(new OperatorNode(root, 0));

        while (!stack.isEmpty()) {
            curNode = stack.pop();
            curOp = curNode.getOperator();
            curDepth = curNode.getDepth();

            for (int i = 0; i < curDepth * PRINTING_INDENT; i++)
                str.append(" ");
            str.append(curOp.printString() + "\n");

            if (curOp instanceof UnaryOperator)
                stack.push(new OperatorNode(((UnaryOperator) curOp).childOperator(), curDepth + 1));
            else if (curOp instanceof BinaryOperator) {
                stack.push(new OperatorNode(((BinaryOperator) curOp).childOp2(), curDepth + 1));
                stack.push(new OperatorNode(((BinaryOperator) curOp).childOp1(), curDepth + 1));
            }
        }
        return str.toString();
    }

    private class OperatorNode {
        Operator op;
        int depth;

        public OperatorNode(final Operator op, int depth) {
            this.op = op;
            this.depth = depth;
        }

        public int getDepth() {
            return depth;
        }

        public Operator getOperator() {
            return op;
        }
    }
}
