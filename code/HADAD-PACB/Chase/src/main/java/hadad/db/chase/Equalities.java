package hadad.db.chase;

import hadad.db.datalogexpr.Value;

/**
 * This interface represents a collection of
 * <code>Equality<code> objects of a given <code>CanonicalDB<code>.
 */
public interface Equalities {

	/**
	 * Gets the representative <code>Value<code> of a given <code>Value<code>.
	 * 
	 * @param value the <code>Value<code> to look for
	 * @return the representative <code>Value<code>, or the <code>Value<code> provided if none is found.
	 */
	public Value getRepresentative(Value value);

	/**
	 * Adds an <code>Equality<code>.
	 * 
	 * @param equality the <code>Equality<code> to add
	 * @return the representatinve <code>Value<code>.
	 */
	public Value addEquality(Equality equality);

}
