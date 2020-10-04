package hadad.db.query;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import hadad.db.canonicaldb.CanonicalSchema;
import hadad.db.canonicaldb.Tuple;

/**
 * Represents an abstract hash join operator, without specifying the exact
 * type of join.
 */
public abstract class AbstractJoin extends BinaryOperator {

	/**
	 * The column names and positions of the join columns of the schema for
	 * which a hash table will be created
	 */
	CanonicalSchema leftJoinSchema;

	/**
	 * The column names and positions of the join columns of the schema for
	 * which a linear scan of the tuples will be done
	 */
	CanonicalSchema rightJoinSchema;
	
	HashMap<String, List<Tuple>> leftTuples = new HashMap<>();
	HashMap<String, List<Tuple>> rightTuples = new HashMap<>();
	
	ArrayList<Integer> leftTupleKey;
	ArrayList<Integer> rightTupleKey;

	protected AbstractJoin(Operator leftChildOp, Operator rightChildOp) {
		super(leftChildOp, rightChildOp);

		// Find the join columns for both child tuple schemas
		findJoinColumns();
	}

	/**
	 * Find the join columns and assign them to the canonical schemas
	 * 
	 * @param hashChildOp
	 * @param scanChildOp
	 */
	private void findJoinColumns() {

		String leftJoinCol;
		int leftJoinPos, rightJoinPos;
		leftJoinSchema = new CanonicalSchema();
		rightJoinSchema = new CanonicalSchema();

		Iterator<String> iterleftCols = leftChildOp.getOutSchema().getColumnNames();
		while (iterleftCols.hasNext()) {
			leftJoinCol = (String) iterleftCols.next();
			if (rightChildOp.getOutSchema().hasColumnName(leftJoinCol)) {
				leftJoinPos = leftChildOp.getOutSchema().getPosition(
						leftJoinCol);
				leftJoinSchema.addColumnName(leftJoinCol, leftJoinPos);
				rightJoinPos = rightChildOp.getOutSchema().getPosition(
						leftJoinCol);
				rightJoinSchema.addColumnName(leftJoinCol, rightJoinPos);
			}
		}
		
		createTables();
	}
	
	private void createTables() {
		int i;
		Iterator<Integer> posIter;
		
		leftTupleKey = new ArrayList<Integer>();
		rightTupleKey = new ArrayList<Integer>();
		
		posIter = leftJoinSchema.getPositions();
		i = 0;
		
		while (posIter.hasNext()) {
			leftTupleKey.add(posIter.next());
			i++;
		}
		
		posIter = rightJoinSchema.getPositions();
		i = 0;
		
		while (posIter.hasNext()) {
			rightTupleKey.add(posIter.next());
			i++;
		}		
	}

	
	protected String insertLeft(Tuple tuple) {
		return insert(tuple, leftTuples, leftTupleKey);
	}
	
	protected String insertRight(Tuple tuple) {
		return insert(tuple, rightTuples, rightTupleKey);
	}
	
	protected String insert(Tuple tuple, HashMap<String, List<Tuple>> hashTable, List<Integer> keyPos) {
		StringBuffer keyBuf = new StringBuffer();
		List<Tuple> bucket;
		int keySize = keyPos.size();
		
		for (int i = 0; i < keySize; i++)
			keyBuf.append(tuple.getValue(keyPos.get(i)).getValueStr());
		
		String key = keyBuf.toString();
		
		// TODO: We add a tuple in the hash table even if the same tuple
		// already exists
		if (!hashTable.containsKey(key)) {
			bucket = new ArrayList<Tuple>();
			bucket.add(tuple);
			hashTable.put(key, bucket);
		} else {
			bucket = hashTable.get(key);
			bucket.add(tuple);
		}
		
		return key;
	}
	
	// TODO: What happens if the joinschema is empty?
	protected String insert(Tuple tuple, HashMap<String, ArrayList<Tuple>> hashTable,
							CanonicalSchema joinSchema) {
		StringBuffer keyBuf;
		int pos;
		ArrayList<Tuple> bucket;
		
		Iterator<Integer> joinPosIter = joinSchema.getPositions();
		
		keyBuf = new StringBuffer();
		while (joinPosIter.hasNext()) {
			pos = joinPosIter.next();
			keyBuf.append(tuple.getValue(pos).getValueStr());
		}

		String key = keyBuf.toString();
		
		// TODO: We add a tuple in the hash table even if the same tuple
		// already exists
		if (!hashTable.containsKey(key)) {
			bucket = new ArrayList<Tuple>();
			bucket.add(tuple);
			hashTable.put(key, bucket);
		} else {
			bucket = hashTable.get(key);
			bucket.add(tuple);
		}
		
		return key;
	}
}
