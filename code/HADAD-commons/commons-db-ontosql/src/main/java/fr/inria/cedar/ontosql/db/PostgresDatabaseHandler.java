package fr.inria.cedar.ontosql.db;

import org.postgresql.copy.CopyManager;
import org.postgresql.core.BaseConnection;

import java.sql.*;

/**
 * Postgres database handler implementation.
 * @author Damian Bursztyn
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
		super (conn, dictionary);
	}


	public PreparedStatement prepareStatement(final int fetchSize,String sql) throws SQLException {
		final PreparedStatement prstmt = conn.prepareStatement (sql);
		prstmt.setFetchSize (fetchSize);
		return prstmt;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see fr.inria.cedar.db.DatabaseHandler#createStatement(int)
	 */
	public Statement createStatement(final int fetchSize) throws SQLException {
		final Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY,ResultSet.HOLD_CURSORS_OVER_COMMIT);
		stmt.setFetchSize (fetchSize);
		return stmt;
	}
	
	/**
	 * Create a new CopyManager (psql) for bulk copy management
	 * @return A CopyManager
	 * @author Benjamin DJAHANDIDEH
	 * @throws SQLException
	 */
	public CopyManager createCopyManager() throws SQLException {
		return new CopyManager((BaseConnection) conn);
	}
	
	public DatabaseMetaData getDatabaseMetaData() throws SQLException {
		return conn.getMetaData();
	}
	
}
