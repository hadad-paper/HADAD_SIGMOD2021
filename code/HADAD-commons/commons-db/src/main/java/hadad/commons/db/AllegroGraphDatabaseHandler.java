package hadad.commons.db;

import org.apache.log4j.Logger;
import org.openrdf.query.BindingSet;
import org.openrdf.query.QueryEvaluationException;
import org.openrdf.query.QueryLanguage;
import org.openrdf.query.TupleQueryResult;
import org.openrdf.repository.RepositoryConnection;
import org.openrdf.repository.RepositoryException;

import com.franz.agraph.repository.AGRepositoryConnection;
import com.franz.agraph.repository.AGTupleQuery;
import com.google.common.base.CharMatcher;

/**
 * Virtuoso database handler implementation.
 * Virtuoso supports multiple languages and therefore the user must prefix the query with the query language being use when
 * executing (directly or indirectly) a statement. For example, given a Virtuoso database handler <code>virtuosoDbHandler</code>,
 * a SPARQL query <code>sparqlQuery</code> and the fetch size <code>fetchSize</code>:
 * 		<code>virtuosoDbHandler.getStatementResultsCount("SPARQL " + sparqlQuery, fetchSize)</code>
 *   
 */
public class AllegroGraphDatabaseHandler {
	protected static final Logger log = Logger.getLogger(DatabaseHandler.class);

	protected final AllegroGraphDataSource dataSource;
	protected final AGRepositoryConnection conn;

	/**
	 * Constructs a AllegroGraphDatabaseHandler with the specified data source.
	 *
	 * @param ds
	 * @throws RepositoryException
	 */
	public AllegroGraphDatabaseHandler(final AllegroGraphDataSource dataSource)
			throws RepositoryException {
		this.dataSource = dataSource;
		this.conn = this.dataSource.getConnection();
	}

	/**
	 * Constructs a AllegroGraphDatabaseHandler with the specified connection.
	 *
	 * @param conn
	 */
	public AllegroGraphDatabaseHandler(final AGRepositoryConnection conn) {
		dataSource = null;
		this.conn = conn;
	}

	/**
	 * Currently supports SPARQL only!
	 */
	/*
	 * (non-Javadoc)
	 * @see hadad.db.DatabaseHandler#getNumberOfSelectedFields(java.lang.String)
	 * TODO: Implement with support for different languages!
	 */
	public int getNumberOfSelectedFields(final String query) {
		final String upperCaseSqlQuery = query.toUpperCase();
		final String attributes = upperCaseSqlQuery.substring(
				upperCaseSqlQuery.indexOf("SELECT "),
				upperCaseSqlQuery.indexOf(" WHERE "));
		return CharMatcher.is('?').countIn(attributes);
	}

	public AGTupleQuery createStatement(final String query) {
		final AGTupleQuery stmt = conn.prepareTupleQuery(QueryLanguage.SPARQL,
				query);
		return stmt;
	}

	/**
	 * Gets the results count for the given SQL query against the RDBMS.
	 *
	 * @param query
	 *            SPARQL query to execute
	 * @return SQL query results count
	 * @throws QueryEvaluationException
	 */
	public int getStatementResultsCount(final String query)
			throws QueryEvaluationException {
		int resultsCount = 0;
		final AGTupleQuery tupleQuery = createStatement(query);
		TupleQueryResult result = null;
		try {
			result = tupleQuery.evaluate();
			while (result.hasNext()) {
				resultsCount++;
			}
		} finally {
			tryClose(result);
		}

		return resultsCount;
	}

	/**
	 * Gets the execution time, in milliseconds, of a given SQL query execution
	 * against the RDBMS.
	 *
	 * @param query
	 *            SPARQL query to execute
	 * @param fetchAttributesFlag
	 * @return SQL query execution time against the RDBMS in milliseconds
	 * @throws QueryEvaluationException
	 */
	public long getStatementExecutionTimeInMilliseconds(final String query,
			final boolean fetchAttributesFlag) throws QueryEvaluationException {
		return getStatementExecutionTimeInMilliseconds(query,
				fetchAttributesFlag, null);
	}

	/**
	 * Gets the execution time, in milliseconds, of a given SQL query execution
	 * against the RDBMS.
	 *
	 * @param query
	 *            SPARQL query to execute
	 * @param fetchAttributesFlag
	 * @param numberOfSelectedFields
	 * @return SQL query execution time against the RDBMS in milliseconds
	 * @throws QueryEvaluationException
	 */
	public long getStatementExecutionTimeInMilliseconds(final String query,
			final boolean fetchAttributesFlag, Integer numberOfSelectedFields)
					throws QueryEvaluationException {
		if (numberOfSelectedFields == null) {
			numberOfSelectedFields = getNumberOfSelectedFields(query);
		}
		long start = 0;
		final AGTupleQuery tupleQuery = createStatement(query);
		TupleQueryResult result = null;
		try {
			result = tupleQuery.evaluate();
			if (fetchAttributesFlag) {
				final BindingSet bindingSet = result.next();
				bindingSet.getValue("s");
				bindingSet.getValue("p");
				bindingSet.getValue("o");
			}
		} finally {
			tryClose(result);
		}
		final long executionTimeInMilliseconds = System.currentTimeMillis()
				- start;

		return executionTimeInMilliseconds;
	}

	/**
	 * Close the connection.
	 */
	public void close() {
		tryClose(conn);
	}

	/**
	 * Attempts to close the given connection.
	 *
	 * @param c
	 */
	public static void tryClose(RepositoryConnection c) {
		try {
			if (c != null) {
				c.close();
			}
		} catch (Exception e) {
			log.error("Failed to close connection.", e);
		}
	}

	/**
	 * Attempts to close the given result.
	 *
	 * @param result
	 */
	public static void tryClose(TupleQueryResult result) {
		try {
			if (result != null) {
				result.close();
			}
		} catch (Exception e) {
			log.error("Failed to close result.", e);
		}
	}
}