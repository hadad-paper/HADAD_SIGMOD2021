package hadad.db.query;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import hadad.db.canonicaldb.CanonicalSchema;
import hadad.db.canonicaldb.Tuple;
import hadad.db.datalogexpr.Value;

/**
 * This operator implements the NaturalJoin (simple hash join) algorithm.
 */
public class NaturalJoin extends AbstractJoin {

    /** Logger */
    private final static Logger LOGGER = Logger.getLogger(QueryTree.class.getName());

    /** The current bucket of the hashtable that produces join tuples. */
    private List<Tuple> currentBucket;

    /** The current bucket position that produced the last join tuple. */
    private int currentBucketPos;

    /** The current right tuple that produced the last join tuple. */

    private Tuple newlyInsertedTuple;

    /** join look-up tuple */
    private Tuple lookupTuple;

    /** Newly inserted tuple key */
    private String newlyInsertedTupleKey;

    /** addTupleTable */
    private Map<String, List<Tuple>> addTupleTable;

    /** Join look-up hastable */
    private Map<String, List<Tuple>> lookupTable;

    /** Which join side the tuple is added */
    private Side newlyInsertedTupleSide;

    /** In the case of cartesian product, this is the iterator over the buckets that hold the left tuples. */
    private Iterator<List<Tuple>> currentBucketIter;

    /** Proejct */
    private BinaryProjectComponent project;

    /**
     * Constructor.
     * 
     * @param leftChildOp
     *            the left child operator.
     * @param rightChildOp
     *            the right child operator.
     */
    public NaturalJoin(Operator leftChildOp, Operator rightChildOp, CanonicalSchema outputSchema,
            LinkedHashMap<Integer, Value> newVars) {
        super(leftChildOp, rightChildOp);

        CanonicalSchema leftChildSchema = leftChildOp.getOutSchema();
        CanonicalSchema rightChildSchema = rightChildOp.getOutSchema();
        project = new BinaryProjectComponent(outputSchema, leftChildSchema, rightChildSchema, newVars);

        outSchema = project.outSchema;
    }

    /**
     * Get join projected tuple
     * 
     * @return projected tuple
     */
    private Tuple getProjectedTuple() {
        Tuple tupleAfterProjection;
        if (lookupTable == leftTuples) {
            tupleAfterProjection = project.projectTuple(lookupTuple, newlyInsertedTuple);
        } else {
            tupleAfterProjection = project.projectTuple(newlyInsertedTuple, lookupTuple);
        }
        return tupleAfterProjection;
    }

    /**
     * Evaluate the join and check if there is a match or not
     * 
     * @return the status <code>  MATCH </code> if there is a match and join is outputting a tuple,
     *         otherwise <code> NO_MATCH </code>
     */
    protected NextStatus nextTuple() {

        if (lookupTable.isEmpty()) {
            currentBucket = null;
            return NextStatus.NO_MATCH;
        }

        if (leftJoinSchema.isEmpty()) {

            if (currentBucket == null) {
                currentBucketIter = lookupTable.values().iterator();
                currentBucket = currentBucketIter.next();
                currentBucketPos = 0;
                lookupTuple = currentBucket.get(currentBucketPos);

            } else if ((currentBucketPos + 1) == currentBucket.size() && currentBucketIter.hasNext()) {
                currentBucket = currentBucketIter.next();
                currentBucketPos = 0;
                lookupTuple = currentBucket.get(currentBucketPos);
            } else if ((currentBucketPos + 1) != currentBucket.size()) {
                currentBucketPos++;
                lookupTuple = currentBucket.get(currentBucketPos);
            } else {
                currentBucket = null;
                return NextStatus.NO_MATCH;
            }

            return NextStatus.MATCH;
        }
        lookupTuple = null;

        if (currentBucket == null) {
            if (lookupTable.containsKey(newlyInsertedTupleKey)) {
                currentBucket = lookupTable.get(newlyInsertedTupleKey);
                currentBucketPos = 0;
                lookupTuple = currentBucket.get(currentBucketPos);
                return NextStatus.MATCH;
            }
        } else if (currentBucketPos + 1 < currentBucket.size()) {
            currentBucketPos++;
            lookupTuple = currentBucket.get(currentBucketPos);
            return NextStatus.MATCH;
        }

        currentBucket = null;
        newlyInsertedTuple = null;
        return NextStatus.NO_MATCH;
    }

    @Override
    protected Tuple next() {
        Tuple inputTuple, tupleAfterProjection;
        NextStatus nextStatus;
        while (!hasEmptyInput()) {
            if (newlyInsertedTuple != null) {

            } else if (!leftInputQueue.isEmpty()) {
                inputTuple = leftInputQueue.removeFirst();
                addTupleTable = leftTuples;
                lookupTable = rightTuples;
                newlyInsertedTuple = inputTuple;
                newlyInsertedTupleKey = insertLeft(inputTuple);
            } else {
                inputTuple = rightInputQueue.removeFirst();
                addTupleTable = rightTuples;
                lookupTable = leftTuples;
                newlyInsertedTuple = inputTuple;
                newlyInsertedTupleKey = insertRight(inputTuple);
            }

            nextStatus = nextTuple();

            if (nextStatus == NextStatus.MATCH) {
                tupleAfterProjection = getProjectedTuple();
                if (tupleAfterProjection != null)
                    return tupleAfterProjection;
            } else
                newlyInsertedTuple = null;
        }

        return null;
    }

    @Override
    protected boolean hasEmptyInput() {
        return (leftInputQueue.isEmpty() && rightInputQueue.isEmpty()
                && ((currentBucket == null) || (currentBucket != null && currentBucketPos == currentBucket.size())));
    }

    @Override
    protected StringBuffer printString() {
        StringBuffer retVal = new StringBuffer(project.printString());
        retVal.append(" Join");

        return retVal;
    }

    @Override
    protected boolean isBlockedDefault() {
        return false;
    }

    @Override
    protected void flush() {
        project.flush();
        leftTuples.clear();
        rightTuples.clear();
        childOp1().flush();
        childOp2().flush();
    }

    @Override
    protected void setOutSchema() {
    }

    public enum Side {
        LEFT,
        RIGHT
    };

    private enum NextStatus {
        MATCH,
        NO_MATCH
    };
}
