package hadad.db.datalogexpr;

/**
 * This class represents a natural join operator
 */
public class StatementJoin extends StatementAbstractJoin {

	public StatementJoin(StatementOp _childOp1, StatementOp _childOp2) {
		super(_childOp1, _childOp2);
	}
		
	public String toString() {
		StringBuffer buffer = new StringBuffer("(");
		
		buffer.append(childOp1.toString());
		buffer.append(", ");
		buffer.append(childOp2.toString());
		buffer.append(")");
		
		return buffer.toString();
	}
	
}
