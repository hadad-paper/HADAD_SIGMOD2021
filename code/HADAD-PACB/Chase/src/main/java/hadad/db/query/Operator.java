package hadad.db.query;

import java.util.LinkedList;

import hadad.db.canonicaldb.CanonicalSchema;
import hadad.db.canonicaldb.Tuple;

/**
 * Represents a physical relational operator.
 * 
 * The current implementation uses a push-based approach in query evaluation
 * where each operator computes its output and pushes them to the input queue of
 * its parent operator. However the implementation can be very easily converted
 * to a pull-based approach, where the parent operator asks its child operators
 * to provide tuples. To make this feasible, every operator has a function
 * <code>next()</code> returning its next output tuple. The two approaches can
 * be implemented by simply changing the caller of the function. If the operator
 * calls it itself, it leads to the push approach. On the other hand, if its
 * parent calls it during the evaluation of its results, then it leads to the
 * pull-based approach.
 */
public abstract class Operator {

    /** The schema of the tuples this operator outputs */
    CanonicalSchema outSchema = new CanonicalSchema();

    /** The parent of the current operator */
    Operator parentOp;

    /**
     * Whether the operator outputs tuples now or not. It is used for operators,
     * which can only output tuples when they know that their inputs are
     * finalized (e.g. antisemijoin op).
     */
    protected boolean blocked;
    /** Flag if the operator is top operator */
    protected boolean isTopOperator;
    /** Flag if the operator changed to be top operator */
    protected boolean changed;

    /**
     * Constructor
     */
    public Operator() {
        isTopOperator = false;
        blocked = isBlockedDefault();
        changed = false;
    }

    /**
     * Unblock operator
     */
    public void unblock() {
        blocked = false;
    }

    /**
     * Block operator
     */
    public void block() {
        blocked = true;
    }

    /**
     * Set top operator
     * 
     * @param isTopOperator
     *            the top operator flag
     */
    public void setTopOperator(boolean isTopOperator) {
        this.isTopOperator = isTopOperator;
    }

    /**
     * Gets the schema of the tuples this operator outputs.
     */
    public CanonicalSchema getOutSchema() {
        if (outSchema.isEmpty())
            setOutSchema();

        return outSchema;
    }

    /**
     * Sets the argument as the current operator's parent.
     * 
     * @param parentOp
     *            the parent operator
     */
    protected void setParentOperator(final Operator parentOp) {
        this.parentOp = parentOp;
    }

    protected LinkedList<Tuple> all() {
        final LinkedList<Tuple> output = new LinkedList<Tuple>();
        Tuple childTuple;
        if (!blocked) {
            while (!hasEmptyInput()) {
                childTuple = this.next();
                if (childTuple != null)
                    output.add(childTuple);
            }
        }
        changed = false;

        return output;
    }

    /**
     * Generates all output tuples and pushes them to its parent operator.
     */
    public void pushAll() {
        if (isTopOperator) {
            changed = true;
            return;
        }
        Tuple childTuple;
        boolean createdNewTuple = false;

        if (!blocked) {
            while (!hasEmptyInput()) {
                childTuple = this.next();
                if (childTuple != null) {
                    parentOp.enQueue(childTuple, this);
                    createdNewTuple = true;
                }
            }
        }
        if (createdNewTuple) {
            parentOp.pushAll();
        }
    }

    /**
     * Gets the next <code>Tuple</code> produced by this operator.
     * 
     * @return a <code>Tuple</code>object
     * @throws QueryEvaluationException
     *             if there is no next <code>Tuple</code>
     */
    protected abstract Tuple next();

    /**
     * Enqueue the list of tuples to the input queue of the operator based on the caller operator
     * 
     * @param tuples
     *            the list tuples to be enqueued
     * @param caller
     *            the caller operator
     */
    public abstract void enQueue(final LinkedList<Tuple> tuples, final Object caller);

    /**
     * Enqueue the tuple to the input queue of the operator based on the caller operator
     * 
     * @param tuple
     *            the tuple to be enqueued
     * @param caller
     *            the caller operator
     */
    public abstract void enQueue(final Tuple tuple, final Object caller);

    /**
     * Check if the operator input is empty or not
     * 
     * @return <code> True </code> if input are empty, otherwise <code> False </code>
     */
    protected abstract boolean hasEmptyInput();

    /**
     * Sets the schema of the tuples this operator outputs.
     */
    protected abstract void setOutSchema();

    /** Print operator */
    protected abstract StringBuffer printString();

    /**
     * Get the default blocking status of the current type of operator
     * 
     * @return <code> True </code> if the operator is a blocking operator, otherwise <code> False </code>
     */
    protected abstract boolean isBlockedDefault();

    /** Flush all operator tuples */
    protected abstract void flush();

}
