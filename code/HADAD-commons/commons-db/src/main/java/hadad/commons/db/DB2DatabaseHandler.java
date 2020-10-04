package hadad.commons.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DB2 database handler implementation.
 */
public class DB2DatabaseHandler extends DatabaseHandler {
	/**
	 * Default constructor.
	 * @param conn
	 */
	public DB2DatabaseHandler(final Connection conn) {
		super(conn);
	}
	
	/**
	 * Default constructor with dictionary.
	 * Enables dictionary-decode of resultsets.
	 * @param conn
	 * @param dictionary
	 */
	public DB2DatabaseHandler(final Connection conn, Dictionary dictionary) {
		super(conn, dictionary);
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see hadad.db.DatabaseHandler#createStatement(int)
	 */
	public Statement createStatement(final int fetchSize) throws SQLException {
		Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		stmt.setFetchSize(fetchSize);
		return stmt;
	}
}