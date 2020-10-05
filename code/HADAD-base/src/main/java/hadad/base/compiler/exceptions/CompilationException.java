package hadad.base.compiler.exceptions;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Used when an exception occurs on runtime during compilation.
 *
 *   
 *   
 */
public final class CompilationException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new compilation exception with the specified detail message.
     *
     * @param msg
     *            the detail message.
     */
    public CompilationException(String msg) {
        super(checkNotNull(msg));
    }

    /**
     * Constructs a new compilation exception with the specified cause.
     *
     * @param e
     *            the cause.
     */
    public CompilationException(Exception e) {
        super(e);
    }
}
