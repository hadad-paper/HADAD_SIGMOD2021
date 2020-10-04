package fr.inria.cedar.ontosql.db;

import java.sql.*;

/**
 * MySQL database handler implementation.
 * @author Damian Bursztyn
 */
public class MySQLDatabaseHandler extends DatabaseHandler {
	/**
	 * Default constructor.
	 * @param conn
	 */
	public MySQLDatabaseHandler(final Connection conn) {
		super(conn);
	}
	
	/**
	 * Default constructor with dictionary.
	 * Enables dictionary-decode of resultsets.
	 * @param conn
	 * @param dictionary
	 */
	public MySQLDatabaseHandler(final Connection conn, Dictionary dictionary) {
		super(conn, dictionary);
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see fr.inria.cedar.db.DatabaseHandler#createStatement(int)
	 * @link http://dev.mysql.com/doc/connector-j/en/connector-j-reference-implementation-notes.html
	 */
	public Statement createStatement(final int fetchSize) throws SQLException {
		Statement stmt = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
		stmt.setFetchSize(Integer.MIN_VALUE);
		return stmt;
	}




}
