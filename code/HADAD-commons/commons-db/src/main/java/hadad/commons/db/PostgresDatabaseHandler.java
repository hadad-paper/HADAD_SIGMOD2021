package hadad.commons.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;

/**
 * Postgres database handler implementation.
 */
public class PostgresDatabaseHandler extends DatabaseHandler {
	
	/**
	 * Default constructor.
	 * @param conn
	 */
	public PostgresDatabaseHandler(final Connection conn) {
		super(conn);
	}
	
	/**
	 * Default constructor with dictionary.
	 * Enables dictionary-decode of resultsets.
	 * @param conn
	 * @param dictionary
	 */
	public PostgresDatabaseHandler(final Connection conn, Dictionary dictionary) {
		super(conn, dictionary);
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see hadad.db.DatabaseHandler#createStatement(int)
	 */
	public Statement createStatement(final int fetchSize) throws SQLException {
		final Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		stmt.setFetchSize(fetchSize);
		return stmt;
	}
	
	/**
	 * Create a new CopyManager (psql) for bulk copy management
	 * @return A CopyManager
	 *  Benjamin DJAHANDIDEH
	 * @throws SQLException
	 */
	public CopyManager createCopyManager() throws SQLException {
		return new CopyManager((BaseConnection) conn);
	}
	
	public DatabaseMetaData getDatabaseMetaData() throws SQLException {
		return conn.getMetaData();
	}
	
}
