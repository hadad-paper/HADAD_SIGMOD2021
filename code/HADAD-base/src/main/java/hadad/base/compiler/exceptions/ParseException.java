package hadad.base.compiler.exceptions;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Used when an exception occurs on runtime during query syntax parsing.
 *
 *   
 *   
 */
public final class ParseException extends HadadException {
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new parse exception with the specified illegal state
     * exception.
     *
     * @param msg
     *            the detail message.
     */
    public ParseException(Exception e) {
        super(checkNotNull(e));
    }
}
