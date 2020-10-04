package hadad.commons.miscellaneous;

import java.util.Properties;

import hadad.commons.db.DataSource;
import hadad.commons.db.DataSourceFactory;
import hadad.commons.db.DatabaseEngine;
import hadad.commons.db.UnsupportedDatabaseEngineException;

/**
 * Base Config for programs that use a RDBMS engine.
 */
public class Config {
	/**
	 * Database engine
	 *
	 * <ul>
	 * <li>Property :"database.engine"</li>
	 * </ul>
	 */
	private final String databaseEngine;
	/**
	 * Database host
	 *
	 * <ul>
	 * <li>Property :"database.host"</li>
	 * </ul>
	 */
	private final String databaseHost;
	/**
	 * Database port
	 *
	 * <ul>
	 * <li>Property :"database.port"</li>
	 * </ul>
	 */
	private final int databasePort;
	/**
	 * Database name
	 *
	 * <ul>
	 * <li>Property :"database.name"</li>
	 * </ul>
	 */
	private final String databaseName;
	/**
	 * Database user
	 *
	 * <ul>
	 * <li>Property :"database.user"</li>
	 * </ul>
	 */
	private final String databaseUser;
	/**
	 * Database password
	 *
	 * <ul>
	 * <li>Property :"database.password"</li>
	 * </ul>
	 */
	private final String databasePassword;

	/**
	 * Default constructor with properties file.
	 *
	 * @param props
	 */
	public Config(final Properties props) {
		this(new Props(props));
	}

	/**
	 * Default constructor.
	 *
	 * @param props
	 */
	public Config(final Props props) {
		databaseEngine = props.getString("database.engine");
		databaseHost = props.getString("database.host");
		databasePort = props.getInt("database.port");
		databaseName = props.getString("database.name");
		databaseUser = props.getString("database.user");
		databasePassword = props.getString("database.password");
	}

	/**
	 * Returns the configured database engine.
	 *
	 * @return database engine
	 */
	public final DatabaseEngine getDatabaseEngine() {
		return DatabaseEngine.valueOf(databaseEngine);
	}

	/**
	 * Returns the configured database host.
	 *
	 * @return database host
	 */
	private final String getDatabaseHost() {
		return databaseHost;
	}

	/**
	 * Returns the configured database port.
	 *
	 * @return database port
	 */
	private final int getDatabasePort() {
		return databasePort;
	}

	/**
	 * Returns the configured database name.
	 *
	 * @return database name
	 */
	private final String getDatabaseName() {
		return databaseName;
	}

	/**
	 * Returns the configured database user.
	 *
	 * @return database user
	 */
	private final String getDatabaseUser() {
		return databaseUser;
	}

	/**
	 * Returns the configured database password.
	 *
	 * @return database password
	 */
	private final String getDatabasePassword() {
		return databasePassword;
	}

	/**
	 * Creates a new data source instance.
	 *
	 * @return data source instance
	 * @throws UnsupportedDatabaseEngineException
	 */
	public final DataSource createDataSource()
			throws UnsupportedDatabaseEngineException {
		return DataSourceFactory.createDataSource(getDatabaseEngine(),
				getDatabaseHost(), getDatabasePort(), getDatabaseName(),
				getDatabaseUser(), getDatabasePassword());
	}
}
