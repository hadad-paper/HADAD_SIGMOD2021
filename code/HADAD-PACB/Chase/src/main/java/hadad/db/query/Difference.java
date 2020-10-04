package hadad.db.query;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Vector;
import hadad.db.canonicaldb.CanonicalSchema;
import hadad.db.canonicaldb.Tuple;
import hadad.db.datalogexpr.Value;

/**
 * This class implements the difference operator together with a projection
 * operator its output.
 */
public class Difference extends BinaryOperator {

    HashMap<String, Vector<Tuple>> leftTuples = new HashMap<String, Vector<Tuple>>();
    HashMap<String, Vector<Tuple>> rightTuples = new HashMap<String, Vector<Tuple>>();

    UnaryProjectComponent project;

    public Difference(Operator leftChildOp, Operator rightChildOp, CanonicalSchema outputSchema,
            LinkedHashMap<Integer, Value> newVars) {
        super(leftChildOp, rightChildOp);
        CanonicalSchema childSchema = leftChildOp.getOutSchema();
        project = new UnaryProjectComponent(outputSchema, childSchema, newVars);

        outSchema = project.outSchema;
    }

    protected Tuple nextSingle() {
        Tuple left = getLeftInput();
        Tuple right = getRightInput();
        if (right != null) {
            insertRight(right);
        }
        if (left != null) {
            String newlyInsertedTupleKey = insertLeft(left);

            if (!rightTuples.containsKey(newlyInsertedTupleKey))
                return left;
        }
        return null;
    }

    protected String insertLeft(Tuple tuple) {
        return insert(tuple, leftTuples);
    }

    protected String insertRight(Tuple tuple) {
        return insert(tuple, rightTuples);
    }

    protected String insert(Tuple tuple, HashMap<String, Vector<Tuple>> hashTable) {
        final StringBuffer keyBuf = new StringBuffer();
        Vector<Tuple> bucket;

        int outSchemaSize = outSchema.size();

        for (int i = 0; i < outSchemaSize; i++)
            keyBuf.append(tuple.getValue(i).getValueStr());

        final String key = keyBuf.toString();
        if (!hashTable.containsKey(key)) {
            bucket = new Vector<Tuple>();
            bucket.add(tuple);
            hashTable.put(key, bucket);
        } else {
            bucket = hashTable.get(key);
            bucket.add(tuple);
        }

        return key;
    }

    @Override
    protected Tuple next() {
        Tuple inputTuple, tupleAfterProjection;
        String newlyInsertedTupleKey;
        while (!rightInputQueue.isEmpty()) {
            inputTuple = rightInputQueue.removeFirst();
            insertRight(inputTuple);
        }
        while (!leftInputQueue.isEmpty()) {
            inputTuple = leftInputQueue.removeFirst();
            newlyInsertedTupleKey = insertLeft(inputTuple);

            if (!rightTuples.containsKey(newlyInsertedTupleKey)) {
                tupleAfterProjection = project.projectTuple(inputTuple);
                if (tupleAfterProjection != null)
                    return tupleAfterProjection;
            }
        }
        return null;
    }

    @Override
    protected boolean hasEmptyInput() {
        return leftInputQueue.isEmpty() && rightInputQueue.isEmpty();
    }

    @Override
    protected boolean isBlockedDefault() {
        return true;
    }

    @Override
    protected StringBuffer printString() {
        StringBuffer retVal = new StringBuffer(project.toString());
        retVal.append(" Difference");

        return retVal;
    }

    @Override
    protected void setOutSchema() {

    }

    @Override
    protected void flush() {
        project.flush();
        leftTuples.clear();
        rightTuples.clear();
        childOp1().flush();
        childOp2().flush();
    }

}
