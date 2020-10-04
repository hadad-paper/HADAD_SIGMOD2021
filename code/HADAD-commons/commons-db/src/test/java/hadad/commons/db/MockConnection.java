package hadad.commons.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;


final class MockConnection implements Connection {

	private final Statement stmt;
	private final int resultsetType;
	private final int resultsetConcurrency;
	private boolean wasCalled;

	MockConnection(final Statement stmt, final int resultsetType, final int resultsetConcurrency) {
		this.stmt = stmt;
		this.resultsetType = resultsetType;
		this.resultsetConcurrency = resultsetConcurrency;
	}

	void verify() {
		assertTrue("Connection createStatement wasn't called", this.wasCalled);
	}

	/**
	 * @see java.sql.Connection#createStatement(int, int)
	 */
	@Override
	public Statement createStatement(final int resultSetType, final int resultSetConcurrency) throws SQLException {
		assertEquals("Unexpected resultset type", this.resultsetType, resultSetType);
		assertEquals("Unexpected resultset concurrency", this.resultsetConcurrency, resultSetConcurrency);
		this.wasCalled = true;
		return this.stmt;
	}

	/**
	 * @see java.sql.Wrapper#unwrap(java.lang.Class)
	 */
	@Override
	public <T> T unwrap(final Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.unwrap");
	}

	/**
	 * @see java.sql.Wrapper#isWrapperFor(java.lang.Class)
	 */
	@Override
	public boolean isWrapperFor(final Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		// return false;
		throw new UnsupportedOperationException("MockConnection.isWrapperFor");
	}

	/**
	 * @see java.sql.Connection#createStatement()
	 */
	@Override
	public Statement createStatement() throws SQLException {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.createStatement");
	}

	/**
	 * @see java.sql.Connection#prepareStatement(java.lang.String)
	 */
	@Override
	public PreparedStatement prepareStatement(final String sql) throws SQLException {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.prepareStatement");
	}

	/**
	 * @see java.sql.Connection#prepareCall(java.lang.String)
	 */
	@Override
	public CallableStatement prepareCall(final String sql) throws SQLException {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.prepareCall");
	}

	/**
	 * @see java.sql.Connection#nativeSQL(java.lang.String)
	 */
	@Override
	public String nativeSQL(final String sql) throws SQLException {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.nativeSQL");
	}

	/**
	 * @see java.sql.Connection#setAutoCommit(boolean)
	 */
	@Override
	public void setAutoCommit(final boolean autoCommit) throws SQLException {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockConnection.setAutoCommit");
	}

	/**
	 * @see java.sql.Connection#getAutoCommit()
	 */
	@Override
	public boolean getAutoCommit() throws SQLException {
		// TODO Auto-generated method stub
		// return false;
		throw new UnsupportedOperationException("MockConnection.getAutoCommit");
	}

	/**
	 * @see java.sql.Connection#commit()
	 */
	@Override
	public void commit() throws SQLException {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockConnection.commit");
	}

	/**
	 * @see java.sql.Connection#rollback()
	 */
	@Override
	public void rollback() throws SQLException {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockConnection.rollback");
	}

	/**
	 * @see java.sql.Connection#close()
	 */
	@Override
	public void close() throws SQLException {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockConnection.close");
	}

	/**
	 * @see java.sql.Connection#isClosed()
	 */
	@Override
	public boolean isClosed() throws SQLException {
		// TODO Auto-generated method stub
		// return false;
		throw new UnsupportedOperationException("MockConnection.isClosed");
	}

	/**
	 * @see java.sql.Connection#getMetaData()
	 */
	@Override
	public DatabaseMetaData getMetaData() throws SQLException {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.getMetaData");
	}

	/**
	 * @see java.sql.Connection#setReadOnly(boolean)
	 */
	@Override
	public void setReadOnly(final boolean readOnly) throws SQLException {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockConnection.setReadOnly");
	}

	/**
	 * @see java.sql.Connection#isReadOnly()
	 */
	@Override
	public boolean isReadOnly() throws SQLException {
		// TODO Auto-generated method stub
		// return false;
		throw new UnsupportedOperationException("MockConnection.isReadOnly");
	}

	/**
	 * @see java.sql.Connection#setCatalog(java.lang.String)
	 */
	@Override
	public void setCatalog(final String catalog) throws SQLException {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockConnection.setCatalog");
	}

	/**
	 * @see java.sql.Connection#getCatalog()
	 */
	@Override
	public String getCatalog() throws SQLException {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.getCatalog");
	}

	/**
	 * @see java.sql.Connection#setTransactionIsolation(int)
	 */
	@Override
	public void setTransactionIsolation(final int level) throws SQLException {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockConnection.setTransactionIsolation");
	}

	/**
	 * @see java.sql.Connection#getTransactionIsolation()
	 */
	@Override
	public int getTransactionIsolation() throws SQLException {
		// TODO Auto-generated method stub
		// return 0;
		throw new UnsupportedOperationException("MockConnection.getTransactionIsolation");
	}

	/**
	 * @see java.sql.Connection#getWarnings()
	 */
	@Override
	public SQLWarning getWarnings() throws SQLException {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.getWarnings");
	}

	/**
	 * @see java.sql.Connection#clearWarnings()
	 */
	@Override
	public void clearWarnings() throws SQLException {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockConnection.clearWarnings");
	}

	/**
	 * @see java.sql.Connection#prepareStatement(java.lang.String, int, int)
	 */
	@Override
	public PreparedStatement prepareStatement(final String sql, final int resultSetType, final int resultSetConcurrency)
			throws SQLException {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.prepareStatement");
	}

	/**
	 * @see java.sql.Connection#prepareCall(java.lang.String, int, int)
	 */
	@Override
	public CallableStatement prepareCall(final String sql, final int resultSetType, final int resultSetConcurrency) throws SQLException {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.prepareCall");
	}

	/**
	 * @see java.sql.Connection#getTypeMap()
	 */
	@Override
	public Map<String, Class<?>> getTypeMap() throws SQLException {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.getTypeMap");
	}

	/**
	 * @see java.sql.Connection#setTypeMap(java.util.Map)
	 */
	@Override
	public void setTypeMap(final Map<String, Class<?>> map) throws SQLException {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockConnection.setTypeMap");
	}

	/**
	 * @see java.sql.Connection#setHoldability(int)
	 */
	@Override
	public void setHoldability(final int holdability) throws SQLException {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockConnection.setHoldability");
	}

	/**
	 * @see java.sql.Connection#getHoldability()
	 */
	@Override
	public int getHoldability() throws SQLException {
		// TODO Auto-generated method stub
		// return 0;
		throw new UnsupportedOperationException("MockConnection.getHoldability");
	}

	/**
	 * @see java.sql.Connection#setSavepoint()
	 */
	@Override
	public Savepoint setSavepoint() throws SQLException {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.setSavepoint");
	}

	/**
	 * @see java.sql.Connection#setSavepoint(java.lang.String)
	 */
	@Override
	public Savepoint setSavepoint(final String name) throws SQLException {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.setSavepoint");
	}

	/**
	 * @see java.sql.Connection#rollback(java.sql.Savepoint)
	 */
	@Override
	public void rollback(final Savepoint savepoint) throws SQLException {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockConnection.rollback");
	}

	/**
	 * @see java.sql.Connection#releaseSavepoint(java.sql.Savepoint)
	 */
	@Override
	public void releaseSavepoint(final Savepoint savepoint) throws SQLException {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockConnection.releaseSavepoint");
	}

	/**
	 * @see java.sql.Connection#createStatement(int, int, int)
	 */
	@Override
	public Statement createStatement(final int resultSetType, final int resultSetConcurrency, final int resultSetHoldability)
			throws SQLException {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.createStatement");
	}

	/**
	 * @see java.sql.Connection#prepareStatement(java.lang.String, int, int, int)
	 */
	@Override
	public PreparedStatement prepareStatement(final String sql, final int resultSetType, final int resultSetConcurrency,
			final int resultSetHoldability) throws SQLException {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.prepareStatement");
	}

	/**
	 * @see java.sql.Connection#prepareCall(java.lang.String, int, int, int)
	 */
	@Override
	public CallableStatement prepareCall(final String sql, final int resultSetType, final int resultSetConcurrency,
			final int resultSetHoldability) throws SQLException {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.prepareCall");
	}

	/**
	 * @see java.sql.Connection#prepareStatement(java.lang.String, int)
	 */
	@Override
	public PreparedStatement prepareStatement(final String sql, final int autoGeneratedKeys) throws SQLException {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.prepareStatement");
	}

	/**
	 * @see java.sql.Connection#prepareStatement(java.lang.String, int[])
	 */
	@Override
	public PreparedStatement prepareStatement(final String sql, final int[] columnIndexes) throws SQLException {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.prepareStatement");
	}

	/**
	 * @see java.sql.Connection#prepareStatement(java.lang.String, java.lang.String[])
	 */
	@Override
	public PreparedStatement prepareStatement(final String sql, final String[] columnNames) throws SQLException {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.prepareStatement");
	}

	/**
	 * @see java.sql.Connection#createClob()
	 */
	@Override
	public Clob createClob() throws SQLException {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.createClob");
	}

	/**
	 * @see java.sql.Connection#createBlob()
	 */
	@Override
	public Blob createBlob() throws SQLException {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.createBlob");
	}

	/**
	 * @see java.sql.Connection#createNClob()
	 */
	@Override
	public NClob createNClob() throws SQLException {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.createNClob");
	}

	/**
	 * @see java.sql.Connection#createSQLXML()
	 */
	@Override
	public SQLXML createSQLXML() throws SQLException {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.createSQLXML");
	}

	/**
	 * @see java.sql.Connection#isValid(int)
	 */
	@Override
	public boolean isValid(final int timeout) throws SQLException {
		// TODO Auto-generated method stub
		// return false;
		throw new UnsupportedOperationException("MockConnection.isValid");
	}

	/**
	 * @see java.sql.Connection#setClientInfo(java.lang.String, java.lang.String)
	 */
	@Override
	public void setClientInfo(final String name, final String value) throws SQLClientInfoException {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockConnection.setClientInfo");
	}

	/**
	 * @see java.sql.Connection#setClientInfo(java.util.Properties)
	 */
	@Override
	public void setClientInfo(final Properties properties) throws SQLClientInfoException {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockConnection.setClientInfo");
	}

	/**
	 * @see java.sql.Connection#getClientInfo(java.lang.String)
	 */
	@Override
	public String getClientInfo(final String name) throws SQLException {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.getClientInfo");
	}

	/**
	 * @see java.sql.Connection#getClientInfo()
	 */
	@Override
	public Properties getClientInfo() throws SQLException {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.getClientInfo");
	}

	/**
	 * @see java.sql.Connection#createArrayOf(java.lang.String, java.lang.Object[])
	 */
	@Override
	public Array createArrayOf(final String typeName, final Object[] elements) throws SQLException {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.createArrayOf");
	}

	/**
	 * @see java.sql.Connection#createStruct(java.lang.String, java.lang.Object[])
	 */
	@Override
	public Struct createStruct(final String typeName, final Object[] attributes) throws SQLException {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.createStruct");
	}

	/**
	 * @see java.sql.Connection#setSchema(java.lang.String)
	 */
	@Override
	public void setSchema(String schema) throws SQLException {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockConnection.setSchema");
	}

	/**
	 * @see java.sql.Connection#getSchema()
	 */
	@Override
	public String getSchema() throws SQLException {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.getSchema");
	}

	/**
	 * @see java.sql.Connection#abort(java.util.concurrent.Executor)
	 */
	@Override
	public void abort(Executor executor) throws SQLException {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockConnection.abort");
	}

	/**
	 * @see java.sql.Connection#setNetworkTimeout(java.util.concurrent.Executor,
	 *      int)
	 */
	@Override
	public void setNetworkTimeout(Executor executor, int milliseconds)
			throws SQLException {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException(
				"MockConnection.setNetworkTimeout");
	}

	/**
	 * @see java.sql.Connection#getNetworkTimeout()
	 */
	@Override
	public int getNetworkTimeout() throws SQLException {
		// TODO Auto-generated method stub
		// return 0;
		throw new UnsupportedOperationException(
				"MockConnection.getNetworkTimeout");
	}
}
