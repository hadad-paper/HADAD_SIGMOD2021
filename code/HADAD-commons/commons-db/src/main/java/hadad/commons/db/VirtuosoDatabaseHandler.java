package hadad.commons.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import virtuoso.jdbc4.VirtuosoResultSet;

import com.google.common.base.CharMatcher;

/**
 * Virtuoso database handler implementation.
 * Virtuoso supports multiple languages and therefore the user must prefix the query with the query language being use when
 * executing (directly or indirectly) a statement. For example, given a Virtuoso database handler <code>virtuosoDbHandler</code>,
 * a SPARQL query <code>sparqlQuery</code> and the fetch size <code>fetchSize</code>:
 * 		<code>virtuosoDbHandler.getStatementResultsCount("SPARQL " + sparqlQuery, fetchSize)</code>
 */
public class VirtuosoDatabaseHandler extends DatabaseHandler {

	/**
	 * Constructs a VirtuosoDatabaseHandler with the specified connection.
	 *
	 * @param conn
	 */
	public VirtuosoDatabaseHandler(final Connection conn) {
		super(conn);
	}

	/**
	 * Currently supports SPARQL only!
	 */
	@Override
	/*
	 * (non-Javadoc)
	 * @see hadad.db.DatabaseHandler#getNumberOfSelectedFields(java.lang.String)
	 * TODO: Implement with support for different languages!
	 */
	public int getNumberOfSelectedFields(final String query) {
		final String upperCaseSqlQuery = query.toUpperCase();
		final String attributes = upperCaseSqlQuery.substring(
				upperCaseSqlQuery.indexOf("SELECT "),
				upperCaseSqlQuery.indexOf(" FROM "));
		return CharMatcher.is('?').countIn(attributes);
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see hadad.db.DatabaseHandler#createStatement(int)
	 */
	public Statement createStatement(final int fetchSize) throws SQLException {
		Statement stmt = conn.createStatement(VirtuosoResultSet.TYPE_FORWARD_ONLY, VirtuosoResultSet.CONCUR_READ_ONLY);
		stmt.setFetchSize(fetchSize);
		return stmt;
	}
}