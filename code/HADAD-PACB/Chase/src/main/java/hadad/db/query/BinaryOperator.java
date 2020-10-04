package hadad.db.query;

import java.util.LinkedList;

import hadad.db.canonicaldb.Tuple;

/**
 * Represents a relational operator having two child operators.
 */
public abstract class BinaryOperator extends Operator {

	/**
	 * Left child operator.
	 */
	Operator leftChildOp;

	/**
	 * Right child operator.
	 */
	Operator rightChildOp;

	/**
	 * Queue with the output tuples of the left child operator.
	 */
	LinkedList<Tuple> leftInputQueue = new LinkedList<Tuple>();

	/**
	 * Queue with the output tuples of the right child operator.
	 */
	LinkedList<Tuple> rightInputQueue = new LinkedList<Tuple>();
	
	private Tuple leftInput;
	private Tuple rightInput;


	public BinaryOperator(Operator _leftChildOp, Operator _rightChildOp) {
		setLeftChildOperator(_leftChildOp);
		setRightChildOperator(_rightChildOp);
	}

	/**
	 * @return the left child operator
	 */
	public Operator childOp1() {
		return leftChildOp;
	}

	/**
	 * @return the right child operator
	 */
	public Operator childOp2() {
		return rightChildOp;
	}

	/**
	 * Sets the argument as the left child of the current operator.
	 * It also assigns the current operator as the parent of the argument.
	 * 
	 * @param _leftChildOp
	 */
	protected void setLeftChildOperator(Operator _leftChildOp) {
		leftChildOp = _leftChildOp;
		leftChildOp.setParentOperator(this);
	}

	/**
	 * Sets the argument as the right child of the current operator.
	 * It also assigns the current operator as the parent of the argument.
	 * 
	 * @param _rightChildOp
	 */
	protected void setRightChildOperator(Operator _rightChildOp) {
		rightChildOp = _rightChildOp;
		rightChildOp.setParentOperator(this);
	}

	// TODO: See comment in unary operator
	/**
	 * Adds tuples output by the child operators to the right input queue of the
	 * current operator, depending on whether it was called by the left or right
	 * child operator.
	 */
	public void enQueue(LinkedList<Tuple> tuples, Object caller) {
		if (caller == leftChildOp)
			leftInputQueue.addAll(tuples);
		else if (caller == rightChildOp)
			rightInputQueue.addAll(tuples);
		else
			throw new QueryEvaluationException("Enqueue operation in "
					+ this.getClass().getName() + " called by non-child object");
	}
	
	public void enQueue(Tuple tuple, Object caller) {
		if (caller == leftChildOp)
			leftInputQueue.add(tuple);
		else if (caller == rightChildOp)
			rightInputQueue.add(tuple);
		else
			throw new QueryEvaluationException("Enqueue operation in "
					+ this.getClass().getName() + " called by non-child object");		
	}
	
	public void enQueueSingle(Tuple tuple, Object caller) {
		if (caller == leftChildOp)
			leftInput = tuple;
		else if (caller == rightChildOp)
			rightInput = tuple;
		else
			throw new QueryEvaluationException("Enqueue operation in "
					+ this.getClass().getName() + " called by non-child object");	
	}
	
	protected Tuple getRightInput() {
		Tuple result = rightInput;
		rightInput = null;
		
		return result;
	}
	
	protected Tuple getLeftInput() {
		Tuple result = leftInput;
		leftInput = null;
		
		return result;
	}

}
