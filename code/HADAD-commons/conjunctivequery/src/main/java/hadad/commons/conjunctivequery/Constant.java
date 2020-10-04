package hadad.commons.conjunctivequery;


/**
 * Constants are used to represent constant objects in the CQs.
 */
public abstract class Constant implements Term,java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	/*
	 * (non-Javadoc)
	 *
	 * @see hadad.commons.conjunctivequery.Term#isConstant()
	 */
	public boolean isConstant() {
		return true;
	}

	@Override
	/*
	 * (non-Javadoc)
	 *
	 * @see hadad.commons.conjunctivequery.Term#isVariable()
	 */
	public boolean isVariable() {
		return false;
	}

	public abstract Object getValue();
}
