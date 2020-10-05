package hadad.base.compiler.exceptions;

/**
 * 
 * {@code HadadException} is the superclass of those
 * exceptions that can be thrown by hadad components.
 * 
 *   
 *
 */
public class HadadException extends RuntimeException {
    static final long serialVersionUID = 6924186540900115003L;

    /**
     * Constructs a new hadad exception with {@code null} as its
     * detail message.
     */
    public HadadException() {
        super();
    }

    /**
     * Constructs a new hadad exception with the specified detail message.
     * 
     * @param message
     *            the detail message.
     */
    public HadadException(String message) {
        super(message);
    }

    /**
     * Constructs a new hadad exception with the specified detail message and
     * cause.
     * 
     * @param message
     *            the detail message.
     * @param cause
     *            the cause. (A <tt>null</tt> value is
     *            permitted, and indicates that the cause is nonexistent or
     *            unknown.)
     */
    public HadadException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new hadad exception with the specified cause and a
     * detail message.
     *
     * @param cause
     *            the cause. (A <tt>null</tt> value is
     *            permitted, and indicates that the cause is nonexistent or
     *            unknown.)
     */
    public HadadException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new hadad exception with the specified detail
     * message, cause, suppression enabled or disabled, and writable
     * stack trace enabled or disabled.
     *
     * @param message
     *            the detail message.
     * @param cause
     *            the cause.
     * @param enableSuppression
     *            whether or not suppression is enabled
     *            or disabled
     * @param writableStackTrace
     *            whether or not the stack trace should
     *            be writable
     *
     */
    protected HadadException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
