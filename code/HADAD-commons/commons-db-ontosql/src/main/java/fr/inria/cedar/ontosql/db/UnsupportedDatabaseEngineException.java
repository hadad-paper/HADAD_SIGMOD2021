package fr.inria.cedar.ontosql.db;

/**
 * Thrown when the specified database engine is not supported.
 * @author Damian Bursztyn
 */
public final class UnsupportedDatabaseEngineException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 * @param engine
	 */
	public UnsupportedDatabaseEngineException(final DatabaseEngine engine) {
        super("The database engine " + engine.toString() + " is not supported.");
    }
}
