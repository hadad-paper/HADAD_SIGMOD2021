package hadad.commons.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.ibm.db2.jcc.DB2SimpleDataSource;

/**
 * DB2 datasource implementation.
 */
public class DB2DataSource extends DataSource {
	private final String schema;

	/**
	 * Default constructor.
	 * @param serverName
	 * @param portNumber
	 * @param databaseName
	 * @param user
	 * @param password
	 */
	public DB2DataSource(final String serverName, final int portNumber,
			final String databaseName, final String user, final String password) {
		this(serverName, portNumber, databaseName, databaseName, user, password);
	}

	/**
	 * Default constructor.
	 *
	 * @param serverName
	 * @param portNumber
	 * @param databaseName
	 * @param schema
	 * @param user
	 * @param password
	 */
	public DB2DataSource(final String serverName, final int portNumber, final String databaseName, final String schema,
			final String user, final String password) {
		super(DatabaseEngine.DB2, serverName, portNumber, databaseName, user, password);
		this.schema = schema;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see hadad.db.DataSource#getConnection()
	 */
	public Connection getConnection() throws SQLException {
		final DB2SimpleDataSource ds = new DB2SimpleDataSource();
		ds.setDriverType(4);
		ds.setServerName(serverName);
		ds.setDatabaseName(databaseName);
		ds.setPortNumber(portNumber);
		ds.setUser(user);
		ds.setPassword(password);
		ds.setCurrentSchema(schema);

		final Connection conn = ds.getConnection();

		return conn;
	}
}
