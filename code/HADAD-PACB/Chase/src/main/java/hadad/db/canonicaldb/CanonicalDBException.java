package hadad.db.canonicaldb;

/**
 * Implementation of <strong>Exception</strong> that handles
 * all exceptions thrown by the <code>CanonicalInstance</code>.
 */
public class CanonicalDBException extends RuntimeException {

	private static final long serialVersionUID = -6978824926739678135L;

	public CanonicalDBException() {
        super();
    }

    public CanonicalDBException(final String message) {
        super(message);
    }

}
