package hadad.commons.db;

import java.sql.SQLException;

/**
 * Database handler factory.
 * Creates the corresponding database handler for the given engine.
 */
public class DatabaseHandlerFactory {
	/**
	 * Attempts to creates a database handler.
	 * @param ds
	 * @return a new database handler
	 * @throws UnsupportedDatabaseEngineException
	 * @throws SQLException 
	 */
	public static final DatabaseHandler createDatabaseHandler(final DataSource ds) 
			throws UnsupportedDatabaseEngineException, SQLException {
		switch (ds.engine) {
			case POSTGRESQL:
				return new PostgresDatabaseHandler(ds.getConnection());
			case DB2:
				return new DB2DatabaseHandler(ds.getConnection());
			case MYSQL:
				return new MySQLDatabaseHandler(ds.getConnection());
			case VIRTUOSO:
				return new VirtuosoDatabaseHandler(ds.getConnection());
			default:
				throw new UnsupportedDatabaseEngineException(ds.engine);
		}
	}
	
	/**
	 * Attempts to creates a database handler with dictionary (enables dictionary-decode of resultsets).
	 * @param ds
	 * @param dictionary
	 * @return a new database handler with dictionary
	 * @throws UnsupportedDatabaseEngineException
	 * @throws SQLException 
	 */
	public static final DatabaseHandler createDatabaseHandler(final DataSource ds, final Dictionary dictionary) 
			throws UnsupportedDatabaseEngineException, SQLException {
		switch (ds.engine) {
			case POSTGRESQL:
				return new PostgresDatabaseHandler(ds.getConnection(), dictionary);
			case DB2:
				return new DB2DatabaseHandler(ds.getConnection(), dictionary);
			case MYSQL:
				return new MySQLDatabaseHandler(ds.getConnection(), dictionary);
			case VIRTUOSO:
				return new VirtuosoDatabaseHandler(ds.getConnection());
			default:
				throw new UnsupportedDatabaseEngineException(ds.engine);
		}
	}
}
