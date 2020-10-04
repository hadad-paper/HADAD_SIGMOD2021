package fr.inria.cedar.ontosql.db;

import org.postgresql.ds.PGConnectionPoolDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * Postgres datasource implementation.
 * @author Damian Bursztyn
 */
public class PostgresDataSource extends DataSource {
	private final String schema;

	/**
	 * Default constructor.
	 * @param serverName
	 * @param portNumber
	 * @param databaseName
	 * @param user
	 * @param password
	 */
	public PostgresDataSource(final String serverName, final int portNumber,
			final String databaseName, final String user, final String password) {
		this(serverName, portNumber, databaseName, null, user, password);
	}

	public PostgresDataSource(final String serverName, final int portNumber, final String databaseName,
			final String schema, final String user, final String password) {
		super(DatabaseEngine.POSTGRESQL, serverName, portNumber, databaseName, user, password);
		this.schema = schema;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see fr.inria.cedar.db.DataSource#getConnection()
	 */
	public Connection getConnection() throws SQLException {
		final PGConnectionPoolDataSource ds = new PGConnectionPoolDataSource();
		ds.setServerName(serverName);
		ds.setDatabaseName(databaseName);
		ds.setUser(user);
		ds.setPassword(password);
		ds.setPortNumber(portNumber);
		final Connection conn = ds.getConnection();
		if (schema != null && !schema.isEmpty()) {
			final Statement statement = conn.createStatement();
			try {
				statement.execute("set search_path to '" + schema + "'");
			} finally {
				statement.close();
			}
		}
		return conn;
	}
}
