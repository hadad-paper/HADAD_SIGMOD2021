package hadad.commons.conjunctivequery;

/**
 * Term defines basic elements of an CQ.s
 */
public interface Term {
	/**
	 * @return true, if the term is a constant
	 */
	public boolean isConstant();

	/**
	 * @return true, if the term is a variable
	 */
	public boolean isVariable();
}
