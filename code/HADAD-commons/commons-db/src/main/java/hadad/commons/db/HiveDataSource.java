package hadad.commons.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HiveDataSource extends DataSource {
	/**
	 * Default constructor.
	 * 
	 * @param serverName
	 * @param portNumber
	 * @param databaseName
	 * @param user
	 * @param password
	 */
	public HiveDataSource(final String serverName, final int portNumber, final String databaseName, final String user,
			final String password) {
		super(DatabaseEngine.HIVE, serverName, portNumber, databaseName, user, password);
	}

	private static String driverName = "org.apache.hive.jdbc.HiveDriver";

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 */
	public Connection getConnection() throws SQLException {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		final Connection conn = DriverManager.getConnection("jdbc:hive2://" + serverName + ":" + portNumber, user,
				password);
		return conn;
	}
}
