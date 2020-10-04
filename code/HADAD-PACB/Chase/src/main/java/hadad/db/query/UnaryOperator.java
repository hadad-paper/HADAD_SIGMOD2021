package hadad.db.query;

import java.util.LinkedList;
import java.util.logging.Logger;

import hadad.db.canonicaldb.Tuple;
import hadad.db.chase.Constraint;

/**
 * Represents a relational operator having a single child operator (unary operator).
 */
public abstract class UnaryOperator extends Operator {

    /** Logger */
    private final static Logger LOGGER = Logger.getLogger(UnaryOperator.class.getName());
    /** Child operator */
    private Operator childOp;
    /** Operator's input queue */
    private LinkedList<Tuple> inputQueue = new LinkedList<Tuple>();
    /** input tuple */
    private Tuple input;

    /**
     * Constructor
     * 
     * @param childOp
     *            the child operator
     */
    public UnaryOperator(final Operator childOp) {
        super();
        setChildOperator(childOp);
    }

    /**
     * Sets the argument as the current operator's child. It also sets the
     * current operator as the argument's parent.
     * 
     * @param childOp
     *            the child operator
     */
    protected void setChildOperator(Operator childOp) {
        this.childOp = childOp;
        this.childOp.setParentOperator(this);
    }

    /**
     * Adds the output tuples returned by the child operator to the current
     * operator's input queue.
     */
    public void enQueue(final LinkedList<Tuple> tuples, final Object caller) {
        if (caller != childOp)
            throw new QueryEvaluationException(
                    "Enqueue operation in " + this.getClass().getName() + " called by non-child object");
        inputQueue.addAll(tuples);
    }

    public void enQueue(final Tuple tuple, final Object caller) {
        if (caller != childOp)
            throw new QueryEvaluationException(
                    "Enqueue operation in " + this.getClass().getName() + " called by non-child object");
        inputQueue.add(tuple);
    }

    public void enQueueSingle(final Tuple tuple, final Object caller) {
        if (caller != childOp)
            throw new QueryEvaluationException(
                    "Enqueue operation in " + this.getClass().getName() + " called by non-child object");
        input = tuple;
    }

    /**
     * Get the child operator of this operator.
     * 
     * @return the child operator
     */
    public Operator childOperator() {
        return childOp;
    }

    /**
     * Get input tuple
     * 
     * @return input tuple
     */
    protected Tuple getInput() {
        Tuple result = input;
        input = null;
        return result;
    }

}
