package hadad.db.query;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import hadad.db.canonicaldb.CanonicalSchema;
import hadad.db.canonicaldb.Tuple;
import hadad.db.datalogexpr.Value;

/**
 * A <code>ProjectComponent</code> for an <code>BinaryOperator</code> which
 * can output values from both its left and right child. This component also
 * does duplicate elimination if required.
 */
public class BinaryProjectComponent extends ProjectComponent {

	LinkedHashMap<Integer, Integer> newPosToOldLeftPos;
	LinkedHashMap<Integer, Integer> newPosToOldRightPos;
	
	private boolean eliminateDuplicates;
	
	CanonicalSchema outSchema = new CanonicalSchema();
	
	CanonicalSchema leftChildSchema;
	CanonicalSchema rightChildSchema;
	
	int outSchemaSize;
	
	// Auxiliary arrays
	boolean[] isNewValue, isVarInLeft;
	int[] oldPosition;
	Value[] newValue;

	public BinaryProjectComponent(CanonicalSchema outputSchema,
			CanonicalSchema leftChildSchema, CanonicalSchema rightChildSchema, 
			LinkedHashMap<Integer, Value> _newVars) {
		// TODO: Can we simply assign the entire canSchema to the outSchema?

		newPosToOldLeftPos = new LinkedHashMap<Integer, Integer>();
		newPosToOldRightPos = new LinkedHashMap<Integer, Integer>();
		newPosToValue = new LinkedHashMap<Integer, Value>();

		this.leftChildSchema = leftChildSchema;
		this.rightChildSchema = rightChildSchema;

		Iterator<Entry<Integer, String>> outputSchemaIter = outputSchema
				.getEntries();

		// TODO: Do we gain anything from these structures?

		// Create output schema and auxiliary structures
		while (outputSchemaIter.hasNext()) {
			Entry<Integer, String> entry = outputSchemaIter.next();
			int pos = entry.getKey();
			String colName = entry.getValue();

			if (leftChildSchema.hasColumnName(colName)) {
				newPosToOldLeftPos.put(pos, leftChildSchema.getPosition(colName));
				outSchema.addColumnName(colName);
			} else if (rightChildSchema.hasColumnName(colName)) {
				newPosToOldRightPos.put(pos, rightChildSchema.getPosition(colName));
				outSchema.addColumnName(colName);
			}
			else if	(_newVars.containsKey(pos)) {
				newPosToValue.put(pos, _newVars.get(pos));
				outSchema.addColumnName(colName);
			} else
				throw new QueryEvaluationException("Cannot project in column "
						+ colName + ": Column does neither exist in the child "
						+ "operator, nor is it newly defined");
		}
		
		outSchemaSize = outputSchema.size();
		
		// Create auxiliary arrays to speed up projection
		createAuxArrays();
		
		// Set duplicate elimination
		eliminateDuplicates = needsDuplicateElimination();
		
		if (eliminateDuplicates)
			keySet = new HashSet<String>();
	}

	public Tuple projectTuple(Tuple leftChildTuple, Tuple rightChildTuple) {
		String key;

		if (this.eliminateDuplicates) {
			key = getKeyAfterProjectionWithoutNewValues(leftChildTuple, rightChildTuple);

			if (keySet.contains(key))
				return null;
			else
				keySet.add(key);
		}

		return createProjectedTuple(leftChildTuple, rightChildTuple);
	}

	private String getKeyAfterProjectionWithoutNewValues(Tuple leftTuple, Tuple rightTuple) {
		int oldPos;
		StringBuffer keyBuf = new StringBuffer();

		for (int pos = 0; pos < outSchemaSize; pos++) {
			if (isVarInLeft[pos]) {
				oldPos = oldPosition[pos];
				keyBuf.append(leftTuple.getValue(oldPos).getValueStr());
			}
			else if (!isNewValue[pos]) {
				oldPos = oldPosition[pos];
				keyBuf.append(rightTuple.getValue(oldPos).getValueStr());
			}
		}

		return keyBuf.toString();
	}

	private Tuple createProjectedTuple(Tuple leftTuple, Tuple rightTuple) {
		Tuple newTuple = new Tuple(outSchemaSize);
		int oldPos;
		
		for (int pos = 0; pos < outSchemaSize; pos++) {
			if (isNewValue[pos])
				newTuple.addValue(newValue[pos]);
			else if (isVarInLeft[pos])
				newTuple.addValue(leftTuple.getValue(oldPosition[pos]));
			else
				newTuple.addValue(rightTuple.getValue(oldPosition[pos]));
		}

		return newTuple;
	}
	
	protected boolean needsDuplicateElimination() {
		Iterator<String> leftChildSchemaIter = leftChildSchema.getColumnNames();

		while (leftChildSchemaIter.hasNext()) {
			String childCol = leftChildSchemaIter.next();
			if (!outSchema.hasColumnName(childCol))
				return true;
		}
		
		Iterator<String> rightChildSchemaIter = rightChildSchema.getColumnNames();
		
		while (rightChildSchemaIter.hasNext()) {
			String childCol = rightChildSchemaIter.next();
			if (!outSchema.hasColumnName(childCol))
				return true;
		}

		return false;
	}
	
	private void createAuxArrays() {
		isNewValue = new boolean[outSchemaSize];
		isVarInLeft = new boolean[outSchemaSize];
		oldPosition = new int[outSchemaSize];
		newValue = new Value[outSchemaSize];
		
		int oldPos;
		Value value;
		
		for (int pos = 0; pos < outSchemaSize; pos++) {
			if (newPosToOldLeftPos.containsKey(pos)) {
				oldPos = newPosToOldLeftPos.get(pos);
				oldPosition[pos] = oldPos;
				isVarInLeft[pos] = true;
				isNewValue[pos] = false;
			}
			else if (newPosToOldRightPos.containsKey(pos)) {
				oldPos = newPosToOldRightPos.get(pos);
				oldPosition[pos] = oldPos;
				isVarInLeft[pos] = false;
				isNewValue[pos] = false;
			}
			else if (newPosToValue.containsKey(pos)) {
				value = newPosToValue.get(pos);
				newValue[pos] = value;
				isVarInLeft[pos] = false;
				isNewValue[pos] = true;
			}
			else
				throw new QueryEvaluationException(
						"Cannot find column in position " + pos
								+ " of the output schema in either of the "
								+ "auxiliary data structures");
		}		
	}
	
	public String printString() {
		int pos;
		String colName;
		StringBuffer retVal = new StringBuffer();
		
		if (eliminateDuplicates)
			retVal.append("DuplicateElimination ");
		
		
		// Populate table with columns
		String[] columns = new String[outSchemaSize];
		
		Iterator<Entry<Integer, String>> outSchemaIter = outSchema.getEntries();
		
		while (outSchemaIter.hasNext()) {
			Entry<Integer, String> entry = outSchemaIter.next();
			pos = entry.getKey();
			colName = entry.getValue();
			
			if (isNewValue[pos])
				columns[pos] = newPosToValue.get(pos).getValueStr();
			else
				columns[pos] = colName;
		}
		
		// Print columns
		retVal.append("Project(");
		
		for (int i = 0; i < outSchemaSize - 1; i++) {
			retVal.append(columns[i]);
			retVal.append(",");
		}
		
		if (outSchema.size() > 0)
			retVal.append(columns[outSchemaSize - 1]);
		
		retVal.append(")");
		
		return retVal.toString();
	}

}
