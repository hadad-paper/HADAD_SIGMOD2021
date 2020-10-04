package hadad.commons.db;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

/**
 * Caches datasource according to the URL.
 */
public abstract class DataSource {	
	protected static final Logger log = Logger.getLogger(DataSource.class);

	public final DatabaseEngine engine;
	protected final String serverName;
	protected final int portNumber;
	protected final String databaseName;
	protected final String user;
	protected final String password;

	/**
	 * Default constructor.
	 * @param engine
	 * @param serverName
	 * @param portNumber
	 * @param databaseName
	 * @param user
	 * @param password
	 */
	public DataSource(final DatabaseEngine engine, final String serverName, 
			final int portNumber, final String databaseName, final String user, final String password) {
		this.engine = engine;
		this.serverName = serverName;
		this.portNumber = portNumber;
		this.databaseName = databaseName;
		this.user = user;
		this.password = password;
	}

	/**
	 * Attempts to establish a connection to this datasource.
	 * @return a new connection to this datasource.
	 * @throws SQLException
	 */
	public abstract Connection getConnection() throws SQLException; 
}
