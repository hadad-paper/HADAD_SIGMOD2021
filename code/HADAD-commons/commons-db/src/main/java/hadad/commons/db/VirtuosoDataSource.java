package hadad.commons.db;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Virtuoso datasource implementation.
 */
public class VirtuosoDataSource extends DataSource {
	/**
	 * Default constructor.
	 * @param serverName
	 * @param portNumber
	 * @param databaseName
	 * @param user
	 * @param password
	 */
	public VirtuosoDataSource(final String serverName, final int portNumber, 
			final String databaseName, final String user, final String password) {
		super(DatabaseEngine.VIRTUOSO, serverName, portNumber, databaseName, user, password);
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see hadad.db.DataSource#getConnection()
	 * TODO Check VirtuosoConnectionPoolDatasource
	 * TODO Check ds.setDatabaseName
	 */
	public Connection getConnection() throws SQLException {
		final virtuoso.jdbc4.VirtuosoDataSource ds = new virtuoso.jdbc4.VirtuosoDataSource();
		ds.setServerName(serverName);
		if (!databaseName.isEmpty()) {
			ds.setDatabaseName(databaseName);
		}
		ds.setPortNumber(portNumber);
		ds.setUser(user);
		ds.setPassword(password);
		
		final Connection conn = ds.getConnection();

		return conn;
	}
}
