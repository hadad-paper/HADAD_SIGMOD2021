package hadad.base.compiler.exceptions;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Used when an exception occurs on runtime during return template construction.
 *
 *   
 */
public final class ReturnConstructException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new return construct exception with the specified detail
     * message.
     *
     * @param msg
     *            the detail message.
     */
    public ReturnConstructException(String msg) {
        super(checkNotNull(msg));
    }
}
