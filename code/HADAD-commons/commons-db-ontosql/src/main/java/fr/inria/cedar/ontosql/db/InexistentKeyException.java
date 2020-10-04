package fr.inria.cedar.ontosql.db;


/**
 * Thrown when the specified key is not contained in the given dictionary.
 * @author Damian Bursztyn
 */
public final class InexistentKeyException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 * @param key
	 */
	public InexistentKeyException(final Integer key) {
        super("The dictionary does not contains the key: " + key.toString());
    }

}
