package hadad.db.datalogexpr;

import hadad.db.canonicaldb.CanonicalSchema;

/**
 * This class represents an abstract join operator.
 */
public abstract class StatementAbstractJoin extends StatementBinaryOp {

	CanonicalSchema joinAttribs = null;
	
	public StatementAbstractJoin(StatementOp _childOp1, StatementOp _childOp2) {
		super(_childOp1, _childOp2);
	}
	
	protected void setRequiredAttribsByThisLevel() {
		requiredAttribsByThisLevel = intersection(childOp1
				.getAllAttribsUpToThisLevel(), childOp2
				.getAllAttribsUpToThisLevel());
	}	
}
