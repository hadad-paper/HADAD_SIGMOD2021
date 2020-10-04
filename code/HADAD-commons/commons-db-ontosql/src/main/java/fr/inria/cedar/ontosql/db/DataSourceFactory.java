package fr.inria.cedar.ontosql.db;


/**
 * Datasource factory.
 * Creates the corresponding datasource for the given engine.
 * @author Damian Bursztyn
 */
public class DataSourceFactory {
	/**
	 * Attempts to creates a datasource.
	 * @param engine
	 * @param serverName
	 * @param portNumber
	 * @param databaseName
	 * @param user
	 * @param password
	 * @return a new datasource.
	 * @throws UnsupportedDatabaseEngineException
	 */
	public static final DataSource createDataSource(final DatabaseEngine engine, final String serverName, 
			final int portNumber, final String databaseName, final String user, final String password) 
			throws UnsupportedDatabaseEngineException {
		switch (engine) {
			case POSTGRESQL:
				return new PostgresDataSource(serverName, portNumber, databaseName, user, password);
			case DB2:
				return new DB2DataSource(serverName, portNumber, databaseName, user, password);
			case MYSQL:
				return new MySQLDataSource(serverName, portNumber, databaseName, user, password);
			case VIRTUOSO:
				return new VirtuosoDataSource(serverName, portNumber, databaseName, user, password);
			case HIVE:
				return new HiveDataSource(serverName, portNumber, databaseName, user, password);
			default:
				throw new UnsupportedDatabaseEngineException(engine);
		}
	}
}
