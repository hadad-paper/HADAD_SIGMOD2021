package hadad.db.datalogexpr;

/**
 * This class represents a binary operator.
 */
public abstract class StatementBinaryOp extends StatementOp {
	
	/**
	 * The left child operator
	 */
	StatementOp childOp1;

	/**
	 * The right child operator
	 */
	StatementOp childOp2;

	public StatementBinaryOp(StatementOp _childOp1, StatementOp _childOp2) {
		setChildOp1(_childOp1);
		setChildOp2(_childOp2);
	}

	public void setChildOp1(StatementOp _childOp1) {
		childOp1 = _childOp1;
		childOp1.parent = this;
	}

	public void setChildOp2(StatementOp _childOp2) {
		childOp2 = _childOp2;
		childOp2.parent = this;
	}

	public StatementOp getChildOp1() {
		return childOp1;
	}

	public StatementOp getChildOp2() {
		return childOp2;
	}

	protected void setAllAttribsUpToThisLevel() {
		allAttribsUpToThisLevel = union(childOp1.getAllAttribsUpToThisLevel(),
				childOp2.getAllAttribsUpToThisLevel());
	}

}
