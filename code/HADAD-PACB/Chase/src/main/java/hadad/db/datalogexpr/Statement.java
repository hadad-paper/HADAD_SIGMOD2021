package hadad.db.datalogexpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import hadad.db.canonicaldb.CanonicalSchema;

/**
 * This class represents a query statement. This can represent a
 * conjunctive query with parentheses that specify the order in which
 * the joins have to be executed. It is a declarative query specification,
 * missing physical query evaluation information, such as projection
 * operators.
 */
public class Statement extends StatementOp {

    /**
     * The query head
     */
    private Predicate pred;

    /**
     * The query body represented by a single operator (which can in
     * turn have children)
     */
    private StatementOp childOp;

    /**
     * The list of predicates in the query body
     */
    private List<Predicate> predicates;

    /**
     * Constructor
     * 
     * @param pred
     *            the predicate
     * @param childOp
     *            the child operator
     */
    public Statement(final Predicate pred, final StatementOp childOp) {
        parent = null;
        this.pred = pred;
        this.childOp = childOp;
        childOp.parent = this;
    }

    /**
     * Get statement child
     * 
     * @return statement operator
     */
    public StatementOp getChildOp() {
        return childOp;
    }

    /**
     * Get predicate head
     * 
     * @return the head
     */
    public Predicate head() {
        return pred;
    }

    /**
     * Get statement's predicate
     * 
     * @return predicates
     */
    public List<Predicate> getPredicates() {
        if (predicates == null)
            setPredicates();

        return predicates;
    }

    /**
     * Set statement's predicates
     */
    public void setPredicates() {
        predicates = new ArrayList<Predicate>();
        StatementOp curOp, prevOp;
        Stack<StatementOp> opStack = new Stack<StatementOp>();
        opStack.push(childOp);
        curOp = null;
        while (!opStack.isEmpty()) {
            prevOp = curOp;
            curOp = opStack.pop();
            if (curOp instanceof StatementScan)
                predicates.add(((StatementScan) curOp).getPredicate());
            else if (curOp instanceof StatementBinaryOp) {
                if (prevOp == ((StatementBinaryOp) curOp).childOp1) {
                    opStack.push(curOp);
                    opStack.push(((StatementBinaryOp) curOp).childOp2);
                } else if (prevOp != ((StatementBinaryOp) curOp).childOp2) {
                    opStack.push(curOp);
                    opStack.push(((StatementBinaryOp) curOp).childOp1);
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    protected void setAllAttribsUpToThisLevel() {
        allAttribsUpToThisLevel = union(childOp.getAllAttribsUpToThisLevel(), this.getRequiredAttribsByThisLevel());
    }

    @Override
    protected void setRequiredAttribsByThisLevel() {
        Value val;
        requiredAttribsByThisLevel = new CanonicalSchema();
        for (int k = 0; k < pred.size(); k++) {
            val = pred.variableI(k);
            if (!val.isAnyConstant()) {
                requiredAttribsByThisLevel.addColumnName(val.getValueStr());
            }
        }
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer(pred.toString());
        str.append(" :- ");
        str.append(childOp.toString());
        return str.toString();
    }
}
