package hadad.base.compiler.model.la.exception;

import org.apache.log4j.Logger;

/**
 * la Exception
 */
public class LAException extends Exception {
    private static final Logger LOGGER = Logger.getLogger(LAException.class);

    private static final long serialVersionUID = -3819688241961585279L;

    public LAException(final Exception e) {
        super(e);
    }

    public LAException(final String e) {
        super(e);
    }
}
