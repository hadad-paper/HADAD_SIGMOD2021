package hadad.db.query;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.logging.Logger;

import hadad.db.canonicaldb.CanonicalSchema;
import hadad.db.canonicaldb.Tuple;
import hadad.db.datalogexpr.Value;

/**
 * This class presents Unary Project Component, which extends {@link ProjectComponent}
 */
public class UnaryProjectComponent extends ProjectComponent {

    /** Logger */
    private final static Logger LOGGER = Logger.getLogger(UnaryProjectComponent.class.getName());

    private final LinkedHashMap<Integer, Integer> newPosToOldPos;
    private boolean eliminateDuplicates;
    private CanonicalSchema childSchema;
    CanonicalSchema outSchema = new CanonicalSchema();
    int outSchemaSize;

    /** Auxiliary arrays */
    boolean[] isNewValue;
    int[] oldPosition;
    Value[] newValue;

    /**
     * Constructor
     * 
     * @param outputSchema
     *            the output schema
     * @param childSchema
     *            the child schema
     * @param newPosToValue
     *            the value position mapping
     */
    public UnaryProjectComponent(final CanonicalSchema outputSchema, final CanonicalSchema childSchema,
            final LinkedHashMap<Integer, Value> newPosToValue) {

        this.childSchema = childSchema;
        newPosToOldPos = new LinkedHashMap<Integer, Integer>();
        this.newPosToValue = new LinkedHashMap<Integer, Value>();
        Iterator<Entry<Integer, String>> outputSchemaIter = outputSchema.getEntries();
        while (outputSchemaIter.hasNext()) {
            Entry<Integer, String> entry = outputSchemaIter.next();
            int pos = entry.getKey();
            String colName = entry.getValue();

            if (childSchema.hasColumnName(colName)) {
                newPosToOldPos.put(pos, childSchema.getPosition(colName));
                outSchema.addColumnName(colName);
            } else if (newPosToValue.containsKey(pos)) {
                this.newPosToValue.put(pos, newPosToValue.get(pos));
                outSchema.addColumnName(colName);
            } else
                throw new QueryEvaluationException("Cannot project in column " + colName
                        + ": Column does neither exist in the child operator, nor is it newly defined");
        }

        outSchemaSize = outputSchema.size();
        createAuxArrays();
        eliminateDuplicates = needsDuplicateElimination();
        if (eliminateDuplicates)
            keySet = new HashSet<String>();
    }

    /**
     * Project the tuple
     * 
     * @param childTuple
     *            the tuple to be projected
     * @return the projected tuple
     */
    public Tuple projectTuple(final Tuple childTuple) {
        String key;
        if (this.eliminateDuplicates) {
            key = getKeyAfterProjectionWithoutNewValues(childTuple);

            if (keySet.contains(key))
                return null;
            else
                keySet.add(key);
        }
        return createProjectedTuple(childTuple);
    }

    /**
     * Get Key
     * 
     * @param currentTuple
     *            the current tuple
     * @return the key after projection
     */
    private String getKeyAfterProjectionWithoutNewValues(final Tuple currentTuple) {
        int oldPos;
        final StringBuffer keyBuf = new StringBuffer();

        for (int pos = 0; pos < outSchemaSize; pos++) {
            if (!isNewValue[pos]) {
                oldPos = oldPosition[pos];
                keyBuf.append(currentTuple.getValue(oldPos).getValueStr());
            }
        }
        return keyBuf.toString();
    }

    /**
     * Create the projected tuple
     * 
     * @param currentTuple
     * @return the created tuple
     */
    private Tuple createProjectedTuple(final Tuple currentTuple) {
        Tuple newTuple = new Tuple(outSchemaSize);

        for (int pos = 0; pos < outSchemaSize; pos++) {
            if (isNewValue[pos])
                newTuple.addValue(newValue[pos]);
            else
                newTuple.addValue(currentTuple.getValue(oldPosition[pos]));
        }

        return newTuple;
    }

    /**
     * Check if duplicates need to be eliminated
     * 
     * @return <code> True </code> if duplicates need to be eliminated, otherwise <code> False </code>
     */
    protected boolean needsDuplicateElimination() {
        final Iterator<String> childSchemaIter = childSchema.getColumnNames();
        while (childSchemaIter.hasNext()) {
            String childCol = childSchemaIter.next();
            if (!outSchema.hasColumnName(childCol))
                return true;
        }
        return false;
    }

    /**
     * Create auxiliary arrays to speed up projection
     */
    private void createAuxArrays() {
        isNewValue = new boolean[outSchemaSize];
        oldPosition = new int[outSchemaSize];
        newValue = new Value[outSchemaSize];
        int oldPos;
        Value value;
        for (int pos = 0; pos < outSchemaSize; pos++) {
            if (newPosToOldPos.containsKey(pos)) {
                oldPos = newPosToOldPos.get(pos);
                oldPosition[pos] = oldPos;
                isNewValue[pos] = false;
            } else if (newPosToValue.containsKey(pos)) {
                value = newPosToValue.get(pos);
                newValue[pos] = value;
                isNewValue[pos] = true;
            } else
                throw new QueryEvaluationException("Cannot find column in position " + pos
                        + " of the output schema in either of the auxiliary data structures");
        }
    }

    @Override
    public String toString() {
        final StringBuffer retVal = new StringBuffer();
        int pos;
        String colName;

        if (eliminateDuplicates)
            retVal.append("DuplicateElimination ");
        final String[] columns = new String[outSchemaSize];

        final Iterator<Entry<Integer, String>> outSchemaIter = outSchema.getEntries();

        while (outSchemaIter.hasNext()) {
            Entry<Integer, String> entry = outSchemaIter.next();
            pos = entry.getKey();
            colName = entry.getValue();

            if (isNewValue[pos])
                columns[pos] = newPosToValue.get(pos).getValueStr();
            else
                columns[pos] = colName;
        }
        retVal.append("Project(");
        for (int i = 0; i < outSchemaSize - 1; i++) {
            retVal.append(columns[i]);
            retVal.append(",");
        }
        if (outSchemaSize > 0)
            retVal.append(columns[outSchemaSize - 1]);

        retVal.append(")");

        return retVal.toString();
    }
}
