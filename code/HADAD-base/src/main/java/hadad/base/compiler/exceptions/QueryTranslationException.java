package hadad.base.compiler.exceptions;

/**
 * Thrown when an error occurs during CQ to SQL translation.
 *
 *  Julien Leblay
 *   
 */
public class QueryTranslationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * @param e
	 */
	public QueryTranslationException(Exception e) {
		super(e);
	}

	/**
	 * @param msg
	 *            the detail message
	 */
	public QueryTranslationException(String msg) {
		super(msg);
	}
}
