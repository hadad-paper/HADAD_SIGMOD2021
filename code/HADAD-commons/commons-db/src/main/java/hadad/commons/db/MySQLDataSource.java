package hadad.commons.db;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

/**
 * MySQL datasource implementation.
 */
public class MySQLDataSource extends DataSource {
	/**
	 * Default constructor.
	 * @param serverName
	 * @param portNumber
	 * @param databaseName
	 * @param user
	 * @param password
	 */
	public MySQLDataSource(final String serverName, final int portNumber, 
			final String databaseName, final String user, final String password) {
		super(DatabaseEngine.MYSQL, serverName, portNumber, databaseName, user, password);
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see hadad.db.DataSource#getConnection()
	 */
	public Connection getConnection() throws SQLException {
		final MysqlConnectionPoolDataSource ds = new MysqlConnectionPoolDataSource();
		ds.setServerName(serverName);
		ds.setDatabaseName(databaseName);
		ds.setUser(user);
		ds.setPassword(password);

		return ds.getConnection();
	}
}
