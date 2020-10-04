package fr.inria.cedar.ontosql.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;

/**
 *
 */
final class MockStatement implements Statement {

	private final int expected;
	private boolean wasCalled;

	MockStatement(final int expected) {
		this.expected = expected;
	}

	/**
	 * @see java.sql.Statement#setFetchSize(int)
	 */
	@Override
	public void setFetchSize(final int rows) {
		assertEquals("Unexpectd fetch size", this.expected, rows);
		this.wasCalled = true;
	}

	void verify() {
		assertTrue("Statement setFetchSize wasn't called", this.wasCalled);
	}

	/**
	 * @see java.sql.Wrapper#unwrap(java.lang.Class)
	 */
	@Override
	public <T> T unwrap(final Class<T> iface) {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockStatement.unwrap");
	}

	/**
	 * @see java.sql.Wrapper#isWrapperFor(java.lang.Class)
	 */
	@Override
	public boolean isWrapperFor(final Class<?> iface) {
		// TODO Auto-generated method stub
		// return false;
		throw new UnsupportedOperationException("MockStatement.isWrapperFor");
	}

	/**
	 * @see java.sql.Statement#executeQuery(java.lang.String)
	 */
	@Override
	public ResultSet executeQuery(final String sql) {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockStatement.executeQuery");
	}

	/**
	 * @see java.sql.Statement#executeUpdate(java.lang.String)
	 */
	@Override
	public int executeUpdate(final String sql) {
		// TODO Auto-generated method stub
		// return 0;
		throw new UnsupportedOperationException("MockStatement.executeUpdate");
	}

	/**
	 * @see java.sql.Statement#close()
	 */
	@Override
	public void close() {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockStatement.close");
	}

	/**
	 * @see java.sql.Statement#getMaxFieldSize()
	 */
	@Override
	public int getMaxFieldSize() {
		// TODO Auto-generated method stub
		// return 0;
		throw new UnsupportedOperationException("MockStatement.getMaxFieldSize");
	}

	/**
	 * @see java.sql.Statement#setMaxFieldSize(int)
	 */
	@Override
	public void setMaxFieldSize(final int max) {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockStatement.setMaxFieldSize");
	}

	/**
	 * @see java.sql.Statement#getMaxRows()
	 */
	@Override
	public int getMaxRows() {
		// TODO Auto-generated method stub
		// return 0;
		throw new UnsupportedOperationException("MockStatement.getMaxRows");
	}

	/**
	 * @see java.sql.Statement#setMaxRows(int)
	 */
	@Override
	public void setMaxRows(final int max) {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockStatement.setMaxRows");
	}

	/**
	 * @see java.sql.Statement#setEscapeProcessing(boolean)
	 */
	@Override
	public void setEscapeProcessing(final boolean enable) {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockStatement.setEscapeProcessing");
	}

	/**
	 * @see java.sql.Statement#getQueryTimeout()
	 */
	@Override
	public int getQueryTimeout() {
		// TODO Auto-generated method stub
		// return 0;
		throw new UnsupportedOperationException("MockStatement.getQueryTimeout");
	}

	/**
	 * @see java.sql.Statement#setQueryTimeout(int)
	 */
	@Override
	public void setQueryTimeout(final int seconds) {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockStatement.setQueryTimeout");
	}

	/**
	 * @see java.sql.Statement#cancel()
	 */
	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockStatement.cancel");
	}

	/**
	 * @see java.sql.Statement#getWarnings()
	 */
	@Override
	public SQLWarning getWarnings() {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockStatement.getWarnings");
	}

	/**
	 * @see java.sql.Statement#clearWarnings()
	 */
	@Override
	public void clearWarnings() {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockStatement.clearWarnings");
	}

	/**
	 * @see java.sql.Statement#setCursorName(java.lang.String)
	 */
	@Override
	public void setCursorName(final String name) {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockStatement.setCursorName");
	}

	/**
	 * @see java.sql.Statement#execute(java.lang.String)
	 */
	@Override
	public boolean execute(final String sql) {
		// TODO Auto-generated method stub
		// return false;
		throw new UnsupportedOperationException("MockStatement.execute");
	}

	/**
	 * @see java.sql.Statement#getResultSet()
	 */
	@Override
	public ResultSet getResultSet() {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockStatement.getResultSet");
	}

	/**
	 * @see java.sql.Statement#getUpdateCount()
	 */
	@Override
	public int getUpdateCount() {
		// TODO Auto-generated method stub
		// return 0;
		throw new UnsupportedOperationException("MockStatement.getUpdateCount");
	}

	/**
	 * @see java.sql.Statement#getMoreResults()
	 */
	@Override
	public boolean getMoreResults() {
		// TODO Auto-generated method stub
		// return false;
		throw new UnsupportedOperationException("MockStatement.getMoreResults");
	}

	/**
	 * @see java.sql.Statement#setFetchDirection(int)
	 */
	@Override
	public void setFetchDirection(final int direction) {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockStatement.setFetchDirection");
	}

	/**
	 * @see java.sql.Statement#getFetchDirection()
	 */
	@Override
	public int getFetchDirection() {
		// TODO Auto-generated method stub
		// return 0;
		throw new UnsupportedOperationException("MockStatement.getFetchDirection");
	}

	/**
	 * @see java.sql.Statement#getFetchSize()
	 */
	@Override
	public int getFetchSize() {
		// TODO Auto-generated method stub
		// return 0;
		throw new UnsupportedOperationException("MockStatement.getFetchSize");
	}

	/**
	 * @see java.sql.Statement#getResultSetConcurrency()
	 */
	@Override
	public int getResultSetConcurrency() {
		// TODO Auto-generated method stub
		// return 0;
		throw new UnsupportedOperationException("MockStatement.getResultSetConcurrency");
	}

	/**
	 * @see java.sql.Statement#getResultSetType()
	 */
	@Override
	public int getResultSetType() {
		// TODO Auto-generated method stub
		// return 0;
		throw new UnsupportedOperationException("MockStatement.getResultSetType");
	}

	/**
	 * @see java.sql.Statement#addBatch(java.lang.String)
	 */
	@Override
	public void addBatch(final String sql) {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockStatement.addBatch");
	}

	/**
	 * @see java.sql.Statement#clearBatch()
	 */
	@Override
	public void clearBatch() {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockStatement.clearBatch");
	}

	/**
	 * @see java.sql.Statement#executeBatch()
	 */
	@Override
	public int[] executeBatch() {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockStatement.executeBatch");
	}

	/**
	 * @see java.sql.Statement#getConnection()
	 */
	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockStatement.getConnection");
	}

	/**
	 * @see java.sql.Statement#getMoreResults(int)
	 */
	@Override
	public boolean getMoreResults(final int current) {
		// TODO Auto-generated method stub
		// return false;
		throw new UnsupportedOperationException("MockStatement.getMoreResults");
	}

	/**
	 * @see java.sql.Statement#getGeneratedKeys()
	 */
	@Override
	public ResultSet getGeneratedKeys() {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockStatement.getGeneratedKeys");
	}

	/**
	 * @see java.sql.Statement#executeUpdate(java.lang.String, int)
	 */
	@Override
	public int executeUpdate(final String sql, final int autoGeneratedKeys) {
		// TODO Auto-generated method stub
		// return 0;
		throw new UnsupportedOperationException("MockStatement.executeUpdate");
	}

	/**
	 * @see java.sql.Statement#executeUpdate(java.lang.String, int[])
	 */
	@Override
	public int executeUpdate(final String sql, final int[] columnIndexes) {
		// TODO Auto-generated method stub
		// return 0;
		throw new UnsupportedOperationException("MockStatement.executeUpdate");
	}

	/**
	 * @see java.sql.Statement#executeUpdate(java.lang.String, java.lang.String[])
	 */
	@Override
	public int executeUpdate(final String sql, final String[] columnNames) {
		// TODO Auto-generated method stub
		// return 0;
		throw new UnsupportedOperationException("MockStatement.executeUpdate");
	}

	/**
	 * @see java.sql.Statement#execute(java.lang.String, int)
	 */
	@Override
	public boolean execute(final String sql, final int autoGeneratedKeys) {
		// TODO Auto-generated method stub
		// return false;
		throw new UnsupportedOperationException("MockStatement.execute");
	}

	/**
	 * @see java.sql.Statement#execute(java.lang.String, int[])
	 */
	@Override
	public boolean execute(final String sql, final int[] columnIndexes) {
		// TODO Auto-generated method stub
		// return false;
		throw new UnsupportedOperationException("MockStatement.execute");
	}

	/**
	 * @see java.sql.Statement#execute(java.lang.String, java.lang.String[])
	 */
	@Override
	public boolean execute(final String sql, final String[] columnNames) {
		// TODO Auto-generated method stub
		// return false;
		throw new UnsupportedOperationException("MockStatement.execute");
	}

	/**
	 * @see java.sql.Statement#getResultSetHoldability()
	 */
	@Override
	public int getResultSetHoldability() {
		// TODO Auto-generated method stub
		// return 0;
		throw new UnsupportedOperationException("MockStatement.getResultSetHoldability");
	}

	/**
	 * @see java.sql.Statement#isClosed()
	 */
	@Override
	public boolean isClosed() {
		// TODO Auto-generated method stub
		// return false;
		throw new UnsupportedOperationException("MockStatement.isClosed");
	}

	/**
	 * @see java.sql.Statement#setPoolable(boolean)
	 */
	@Override
	public void setPoolable(final boolean poolable) {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockStatement.setPoolable");
	}

	/**
	 * @see java.sql.Statement#isPoolable()
	 */
	@Override
	public boolean isPoolable() {
		// TODO Auto-generated method stub
		// return false;
		throw new UnsupportedOperationException("MockStatement.isPoolable");
	}

	/**
	 * @see java.sql.Statement#closeOnCompletion()
	 */
	@Override
	public void closeOnCompletion() {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException(
				"MockStatement.closeOnCompletion");
	}

	/**
	 * @see java.sql.Statement#isCloseOnCompletion()
	 */
	@Override
	public boolean isCloseOnCompletion() {
		// TODO Auto-generated method stub
		// return false;
		throw new UnsupportedOperationException(
				"MockStatement.isCloseOnCompletion");
	}

}
