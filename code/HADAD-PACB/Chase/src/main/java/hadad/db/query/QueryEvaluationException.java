package hadad.db.query;

/**
 * Implementation of <strong>Exception</strong> that handles
 * all exceptions thrown by the <code>QueryEvaluation</code>.
 */
public class QueryEvaluationException extends RuntimeException {

	private static final long serialVersionUID = -6978824926739678135L;

	public QueryEvaluationException() {
        super();
    }

    public QueryEvaluationException(String message) {
        super(message);
    }

}
