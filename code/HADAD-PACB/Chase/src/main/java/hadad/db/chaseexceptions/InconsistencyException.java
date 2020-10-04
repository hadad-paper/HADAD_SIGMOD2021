package hadad.db.chaseexceptions;

import hadad.db.canonicaldb.Database;
import hadad.db.datalogexpr.Value;

/**
 * Implementation of <strong>Exception</strong> that handles the case when the
 * {@link Chase} execution detects that the current mapping is inconsistent.
 * 
 */
public class InconsistencyException extends Exception {

	private static final long serialVersionUID = -1040249612823264825L;

//	protected ArrayList<Tuple> inconsistentTuples;
	
	private Value v1;
	private Value v2;
	private Database db;

	public InconsistencyException(Value v1, Value v2, Database db) {
		super();
		this.v1 = v1;
		this.v2 = v2;
		this.db = db;		
		System.err.println("INCONSISTENCY EXCEPTION");
//		inconsistentTuples = new ArrayList<Tuple>();
//		inconsistentTuples.addAll(db.getTuplesContainingValue(v1));
//		inconsistentTuples.addAll(db.getTuplesContainingValue(v1));
//		System.err.println("Inconsistency: " + inconsistentTuples.toString());
	}
	
	public Value getValue1() {
		return v1;
	}
	public Value getValue2() {
		return v2;
	}
	
	public Database getDB() {
		return db;
	}
	
//	public InconsistencyException(String message) {
//		super(message);
//	}
//
//	public ArrayList<Tuple> getInconsistentTuples() {
//		return inconsistentTuples;
//	}
//
//	public void addInconsistentTuple(Tuple tuple) {
//		inconsistentTuples.add(tuple);
//	}

}
