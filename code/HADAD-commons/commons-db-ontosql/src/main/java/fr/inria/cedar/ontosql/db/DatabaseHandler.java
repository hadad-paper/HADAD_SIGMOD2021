package fr.inria.cedar.ontosql.db;

import com.google.common.base.CharMatcher;
import org.apache.log4j.Logger;
import org.postgresql.PGConnection;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Damian Bursztyn
 */
public abstract class DatabaseHandler {
	protected  final Logger log = Logger.getLogger(DatabaseHandler.class);


	protected final Connection conn;
	private final Dictionary dictionary;

	/**
	 * Constructs a DatabaseHandler with the specified connection.
	 *
	 * @param conn
	 */
	public DatabaseHandler(final Connection conn) {
		this(conn, null);
	}

	/**
	 * Constructs a DatabaseHandler with the specified connection and dictionary.
	 * Enables dictionary-decode of resultsets.
	 *
	 * @param conn
	 * @param dictionary
	 */
	public DatabaseHandler(final Connection conn, final Dictionary dictionary) {
		this.conn = conn;
		this.dictionary = dictionary;
	}

	/**
	 * Attempts to create an statement with the given fetch size.
	 * @return statement with fetch size
	 * @throws SQLException
	 */
	public abstract Statement createStatement(final int fetchSize) throws SQLException;



	/**
	 * Attempts to return the tables in the database.
	 *
	 * @return the tables in the database
	 * @throws SQLException
	 */
	public List<String> getTableNames() throws SQLException {
		final List<String> tables = new ArrayList<>();
		ResultSet rs = null;
		try {
			DatabaseMetaData dbmd = conn.getMetaData();
			final String[] types = { "TABLE" };
			rs = dbmd.getTables(null, null, "%", types);
			while (rs.next()) {
				tables.add(rs.getString("TABLE_NAME"));
			}
		} finally {
			DatabaseUtils.tryClose(rs);
		}
		return tables;
	}

	/**
	 * Returns true if the connection is closed.
	 */
	public boolean isClosed() throws SQLException {
		return conn.isClosed();
	}

	/**
	 * Close the connection.
	 */
	public void close() {
		DatabaseUtils.tryClose(conn);
	}

	/**
	 * Gets the results count for the given SQL query against the RDBMS.
	 * @param sqlQuery SQL query to execute
	 * @return SQL query results count
	 * @throws SQLException
	 */
	public int getStatementResultsCount(final String sqlQuery, final int fetchSize) throws SQLException {
		int resultsCount = 0;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = createStatement(fetchSize);
			rs = stmt.executeQuery(sqlQuery);
			while (rs.next()) {
				resultsCount++;
			}
		} finally {
			DatabaseUtils.tryClose(rs);
			DatabaseUtils.tryClose(stmt);
		}

		return resultsCount;
	}

	/**
	 * Gets the execution time, in milliseconds, of SQL query execution against the RDBMS.
	 * @param sqlQuery SQL query to execute
	 * @return SQL query execution time against the RDBMS in milliseconds
	 * @throws SQLException
	 */
	public long getManipulationStatementExecutionTimeInMilliseconds(final String sqlQuery)
			throws SQLException {
		Statement stmt = null;
		long start = 0;
		try {
			stmt = conn.createStatement();
			start = System.currentTimeMillis();
			stmt.execute(sqlQuery);
		} finally {
			DatabaseUtils.tryClose(stmt);
		}
		final long executionTimeInMilliseconds = System.currentTimeMillis() - start;
		System.out.println ("execution "+executionTimeInMilliseconds);
		return executionTimeInMilliseconds;
	}

	/**
	 * Gets the execution time, in milliseconds, of a given SQL query execution against the RDBMS.
	 * @param sqlQuery SQL query to execute
	 * @param fetchSize
	 * @param fetchAttributesFlag
	 * @return SQL query execution time against the RDBMS in milliseconds
	 * @throws SQLException
	 */
	public long getStatementExecutionTimeInMilliseconds(final String sqlQuery, final int fetchSize, final boolean fetchAttributesFlag) throws SQLException {
		return getStatementExecutionTimeInMilliseconds(sqlQuery, fetchSize, fetchAttributesFlag, null);
	}



	/**
	 * Gets the execution time, in milliseconds, of a given SQL query execution against the RDBMS.
	 * @param fetchSize
	 * @param fetchAttributesFlag
	 * @param numberOfSelectedFields
	 * @return SQL query execution time against the RDBMS in milliseconds
	 * @throws SQLException
	 */
	public long getStatementExecutionTimeInMilliseconds(final String sqlQuery, final int fetchSize, final boolean fetchAttributesFlag,
			Integer numberOfSelectedFields) throws SQLException {
		Statement stmt = null;
		ResultSet rs = null;
		int numberOfResult = 0;
		if (numberOfSelectedFields == null) {
			numberOfSelectedFields = getNumberOfSelectedFields(sqlQuery);
		}
		long start = 0;
		try {
			stmt = createStatement (fetchSize);
			stmt.executeQuery (sqlQuery);
			start = System.currentTimeMillis ();
			rs = stmt.executeQuery (sqlQuery);
			while (rs.next ()) {
				if (fetchAttributesFlag) {
					for (int i = 1; i <= numberOfSelectedFields; i++) {
						rs.getInt (i);
					}
				}
			}

		}

		finally {
			DatabaseUtils.tryClose(rs);
			DatabaseUtils.tryClose(stmt);
		}
		final long executionTimeInMilliseconds = System.currentTimeMillis() - start;
		System.out.println (executionTimeInMilliseconds);

		return executionTimeInMilliseconds;
	}


	/**
	 * Gets the execution time, in milliseconds, of a given SQL query execution against the RDBMS.
	 * @param sqlQuery SQL query to execute
	 * @param fetchSize
	 * @param fetchAttributesFlag
	 * @return SQL query execution time against the RDBMS in milliseconds
	 * @throws SQLException
	 */
	public long getPrepredStatementExecutionTimeInMilliseconds(final String sqlQuery, final int fetchSize, final boolean fetchAttributesFlag) throws SQLException {
		return getPreparedStatementExecutionTimeInMilliseconds (sqlQuery, fetchSize, fetchAttributesFlag, null);
	}


    /**
     * Gets the execution time, in milliseconds, of a given SQL query execution against the RDBMS.
     * @param fetchSize
     * @param fetchAttributesFlag
     * @param numberOfSelectedFields
     * @return SQL query execution time against the RDBMS in milliseconds
     * @throws SQLException
     */
    public long getPreparedStatementExecutionTimeInMilliseconds(final String sqlQuery, final int fetchSize, final boolean fetchAttributesFlag,
                                                        Integer numberOfSelectedFields) throws SQLException {

        PreparedStatement preparedStatement=null;
		PGConnection pgconn = conn.unwrap(org.postgresql.PGConnection.class);
        ResultSet rs = null;
        int numberOfResult = 0;
        if (numberOfSelectedFields == null) {
            numberOfSelectedFields = getNumberOfSelectedFields(sqlQuery);
        }
        long start = 0;
        try {

            preparedStatement = conn.prepareStatement (sqlQuery);
            start = System.currentTimeMillis();
            rs = preparedStatement.executeQuery ();
            while (rs.next()) {
                numberOfResult++;
                if (fetchAttributesFlag) {
                    for(int i = 1; i <= numberOfSelectedFields; i++) {
                        rs.getInt (i);
                    }
                }
            }
        } finally {
        	DatabaseUtils.tryClose(rs);
            DatabaseUtils.tryClose(preparedStatement);
        }
        final long executionTimeInMilliseconds = System.currentTimeMillis() - start;
        System.out.println (executionTimeInMilliseconds);

        return executionTimeInMilliseconds;
    }

	/**
	 * Gets the execution and resultset dictionary-decode time, in milliseconds, of a given SQL query execution against the RDBMS.
	 * @param fetchSize
	 * @return SQL query execution and resulset dictionary-decode time against the RDBMS in milliseconds
	 * @throws SQLException
	 * @throws InexistentKeyException
	 * @throws DictionaryException
	 */
	public long getStatementExecutionAndResultsDecodeTimeInMilliseconds(final String sqlQuery, final int fetchSize)
			throws SQLException, DictionaryException, InexistentKeyException {
		return  getStatementExecutionAndResultsDecodeTimeInMilliseconds(sqlQuery, fetchSize, getNumberOfSelectedFields(sqlQuery));
	}

	/**
	 * Gets the execution and resultset dictionary-decode time, in milliseconds, of a given SQL query execution against the RDBMS.
	 * @param fetchSize
	 * @param numberOfSelectedFields
	 * @return SQL query execution and resulset dictionary-decode time against the RDBMS in milliseconds
	 * @throws SQLException
	 * @throws InexistentKeyException
	 * @throws DictionaryException
	 */
	public long getStatementExecutionAndResultsDecodeTimeInMilliseconds(final String sqlQuery, final int fetchSize,
			final int numberOfSelectedFields) throws SQLException, DictionaryException, InexistentKeyException {
		if (dictionary == null) {
			throw new DictionaryException("The database handler lacks a dictionary.");
		}

		Statement stmt = null;
		ResultSet rs = null;
		long start = 0;
		try {
			stmt = createStatement(fetchSize);
			start = System.currentTimeMillis();
			rs = stmt.executeQuery(sqlQuery);
			while (rs.next()) {
				for (int i = 1; i <= numberOfSelectedFields; i++) {
					dictionary.getValue(rs.getInt(i));
				}
			}
		} finally {
			DatabaseUtils.tryClose(rs);
			DatabaseUtils.tryClose(stmt);
		}
		final long executionTimeInMilliseconds = System.currentTimeMillis() - start;

		return executionTimeInMilliseconds;
	}



	/**
	 * Gets the execution and resultset dictionary-decode time, in milliseconds, of a given SQL query execution against the RDBMS.
	 * @param fetchSize
	 * @return SQL query execution and resulset dictionary-decode time against the RDBMS in milliseconds
	 * @throws SQLException
	 * @throws InexistentKeyException
	 * @throws DictionaryException
	 */
	public long getStatementExecutionAndResultsDecodeInFileTimeInMilliseconds(final String sqlQuery, final int fetchSize,String rsFile)
			throws SQLException, DictionaryException, InexistentKeyException, IOException {
		return getStatementExecutionAndResultsDecodeInFileTimeInMilliseconds (sqlQuery, fetchSize, null,rsFile);
	}


	/**
	 * Gets the execution and resultset dictionary-decode time, in milliseconds,
	 * of a given SQL query execution against the RDBMS and put the results in a File.
	 * @param fetchSize
	 * @param numberOfSelectedFields
	 * @param rsFile
	 * @return SQL query execution and resulset dictionary-decode time against the RDBMS in milliseconds
	 * @throws SQLException
	 * @throws InexistentKeyException
	 * @throws DictionaryException
	 */
	public long getStatementExecutionAndResultsDecodeInFileTimeInMilliseconds (final String sqlQuery, final int fetchSize,
																			   Integer numberOfSelectedFields,String rsFile) throws SQLException, DictionaryException, InexistentKeyException, IOException {
		if (dictionary == null) {
			throw new DictionaryException("The database handler lacks a dictionary.");
		}

		if (numberOfSelectedFields == null) {
			numberOfSelectedFields = getNumberOfSelectedFields(sqlQuery);
		}

		StringBuilder dataFileCreated = new StringBuilder ();
		File resultDirectory = new File("results/rs_");
		File file;
		if(!resultDirectory.exists ()){
			resultDirectory.mkdirs ();
		}

		if(rsFile ==  null || rsFile.isEmpty ()){
			file = new File (resultDirectory + dataFileCreated.toString () + "" + "qexec");
		}
		else{
			file = new File (resultDirectory + dataFileCreated.toString () + "" + rsFile);
		}

		file.createNewFile ();
		FileWriter fstream = new FileWriter (file);
		BufferedWriter out = new BufferedWriter (fstream);

		Statement stmt = null;
		ResultSet rs = null;
		long start = 0;
		try {
			stmt = createStatement(fetchSize);
			start = System.currentTimeMillis();
			rs = stmt.executeQuery(sqlQuery);
			while (rs.next()) {
				for (int i = 1; i <= numberOfSelectedFields; i++) {
					out.write (dictionary.getValue(rs.getInt(i))+"\n");
				}
			}
		} finally {
			DatabaseUtils.tryClose(rs);
			DatabaseUtils.tryClose(stmt);
		}
		out.close ();

		final long executionTimeInMilliseconds = System.currentTimeMillis() - start;

		return executionTimeInMilliseconds;
	}

	/**
	 * Returns the number of attributes that appear in the SELECT clause of the given query.
	 * @param query
	 * @return the number of attributes in the SELECT clause
	 */
	public int getNumberOfSelectedFields(final String query) {
		return getSqlQueryNumberOfSelectedFields(query);
	}

	/**
	 * Returns the number of attributes that appear in the SELECT clause of the given SQL query.
	 * @param sqlQuery
	 * @return the number of attributes in the SELECT clause
	 */
	public int getSqlQueryNumberOfSelectedFields(final String sqlQuery) {
		final String attributes;
		//final String upperCaseSqlQuery = sqlQuery.toUpperCase();
		String upperCaseSqlQuery;
		if(sqlQuery.startsWith ("(")){
			upperCaseSqlQuery = sqlQuery.substring(sqlQuery.toUpperCase().indexOf ("("),sqlQuery.toUpperCase().indexOf (")"));
		}
		else {
			upperCaseSqlQuery = sqlQuery;
		}
		if(upperCaseSqlQuery.startsWith ("SELECT") || upperCaseSqlQuery.startsWith ("(SELECT")){
			if (upperCaseSqlQuery.contains ("FROM")) {
				attributes = upperCaseSqlQuery.substring (upperCaseSqlQuery.indexOf ("SELECT "), upperCaseSqlQuery.indexOf (" FROM "));
			}
			else {
				attributes = upperCaseSqlQuery.substring (upperCaseSqlQuery.lastIndexOf ("SELECT "), upperCaseSqlQuery.lastIndexOf (" AS "));
			}
			}
		else{
			if (upperCaseSqlQuery.contains ("FROM")){
				System.out.println ("upper "+upperCaseSqlQuery);
				attributes = upperCaseSqlQuery.substring (upperCaseSqlQuery.lastIndexOf ("SELECT "), upperCaseSqlQuery.lastIndexOf (" FROM "));
			}
			else {
				attributes = upperCaseSqlQuery.substring (upperCaseSqlQuery.lastIndexOf ("SELECT "), upperCaseSqlQuery.lastIndexOf (" AS "));
			}
		}


		return CharMatcher.is(',').countIn(attributes) + 1;
	}

	/**
	 * Attempts to execute the given statement.
	 *
	 * @param update
	 * @throws SQLException
	 */
	public void executeUpdate(final String update) throws SQLException {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(update);
			stmt.executeUpdate();
		} finally {
			DatabaseUtils.tryClose(stmt);
		}
	}

	public void setAutoCommit(final boolean value) throws SQLException {
		conn.setAutoCommit(value);
	}

	public void commit() throws SQLException {
		conn.commit();
	}
}
