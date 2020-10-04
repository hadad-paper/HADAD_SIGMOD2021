package hadad.db.datalogexpr;

/**
 * Implementation of <strong>Exception</strong> that handles all schema
 * validation exceptions thrown by an <code>Atom</code>.
 * 
 */
public class DatalogException extends RuntimeException {

	private static final long serialVersionUID = -1042850631273296781L;

	public DatalogException() {
		super();
	}

	public DatalogException(String message) {
		super(message);
	}

}
