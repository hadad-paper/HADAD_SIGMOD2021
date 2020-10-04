package fr.inria.cedar.ontosql.db;


/**
 * Thrown when the specified value is not contained in the given dictionary.
 * @author Damian Bursztyn
 */
public final class InexistentValueException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 * @param value
	 */
	public InexistentValueException(final String value) {
        super("The dictionary does not contains the value: " + value);
    }



}
