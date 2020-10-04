package hadad.commons.db;


/**
 * Thrown when the dictionary relying data cannot be accessed.
 * Provides storage layer abstraction for different dictionary implementations exceptions (SQLException, etc)
 */
public final class DictionaryException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 * @param msg
	 */
	public DictionaryException(final String msg) {
        super("Cannot access dictionary data: (" + msg + ")");
    }
}
