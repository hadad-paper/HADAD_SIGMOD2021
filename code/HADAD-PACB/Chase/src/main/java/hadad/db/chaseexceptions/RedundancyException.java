package hadad.db.chaseexceptions;

import hadad.db.chase.Chase;

/**
 * 
 * Implementation of <strong>Exception</strong> that handles the case when the
 * {@link Chase} execution detects that the current mapping is redundant.
 * 
 */
public class RedundancyException extends Exception {

	private static final long serialVersionUID = -6978824926739678135L;

	public RedundancyException() {
		super();
	}

	public RedundancyException(String message) {
		super(message);
	}

}
