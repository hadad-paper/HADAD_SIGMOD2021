package fr.inria.cedar.ontosql.db;

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

/**
 *
 */
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
	public Statement createStatement(final int resultSetType, final int resultSetConcurrency) {
		assertEquals("Unexpected resultset type", this.resultsetType, resultSetType);
		assertEquals("Unexpected resultset concurrency", this.resultsetConcurrency, resultSetConcurrency);
		this.wasCalled = true;
		return this.stmt;
	}

	/**
	 * @see java.sql.Wrapper#unwrap(java.lang.Class)
	 */
	@Override
	public <T> T unwrap(final Class<T> iface) {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.unwrap");
	}

	/**
	 * @see java.sql.Wrapper#isWrapperFor(java.lang.Class)
	 */
	@Override
	public boolean isWrapperFor(final Class<?> iface) {
		// TODO Auto-generated method stub
		// return false;
		throw new UnsupportedOperationException("MockConnection.isWrapperFor");
	}

	/**
	 * @see java.sql.Connection#createStatement()
	 */
	@Override
	public Statement createStatement() {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.createStatement");
	}

	/**
	 * @see java.sql.Connection#prepareStatement(java.lang.String)
	 */
	@Override
	public PreparedStatement prepareStatement(final String sql) {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.prepareStatement");
	}

	/**
	 * @see java.sql.Connection#prepareCall(java.lang.String)
	 */
	@Override
	public CallableStatement prepareCall(final String sql) {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.prepareCall");
	}

	/**
	 * @see java.sql.Connection#nativeSQL(java.lang.String)
	 */
	@Override
	public String nativeSQL(final String sql) {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.nativeSQL");
	}

	/**
	 * @see java.sql.Connection#setAutoCommit(boolean)
	 */
	@Override
	public void setAutoCommit(final boolean autoCommit) {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockConnection.setAutoCommit");
	}

	/**
	 * @see java.sql.Connection#getAutoCommit()
	 */
	@Override
	public boolean getAutoCommit() {
		// TODO Auto-generated method stub
		// return false;
		throw new UnsupportedOperationException("MockConnection.getAutoCommit");
	}

	/**
	 * @see java.sql.Connection#commit()
	 */
	@Override
	public void commit() {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockConnection.commit");
	}

	/**
	 * @see java.sql.Connection#rollback()
	 */
	@Override
	public void rollback() {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockConnection.rollback");
	}

	/**
	 * @see java.sql.Connection#close()
	 */
	@Override
	public void close() {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockConnection.close");
	}

	/**
	 * @see java.sql.Connection#isClosed()
	 */
	@Override
	public boolean isClosed() {
		// TODO Auto-generated method stub
		// return false;
		throw new UnsupportedOperationException("MockConnection.isClosed");
	}

	/**
	 * @see java.sql.Connection#getMetaData()
	 */
	@Override
	public DatabaseMetaData getMetaData() {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.getMetaData");
	}

	/**
	 * @see java.sql.Connection#setReadOnly(boolean)
	 */
	@Override
	public void setReadOnly(final boolean readOnly) {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockConnection.setReadOnly");
	}

	/**
	 * @see java.sql.Connection#isReadOnly()
	 */
	@Override
	public boolean isReadOnly() {
		// TODO Auto-generated method stub
		// return false;
		throw new UnsupportedOperationException("MockConnection.isReadOnly");
	}

	/**
	 * @see java.sql.Connection#setCatalog(java.lang.String)
	 */
	@Override
	public void setCatalog(final String catalog) {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockConnection.setCatalog");
	}

	/**
	 * @see java.sql.Connection#getCatalog()
	 */
	@Override
	public String getCatalog() {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.getCatalog");
	}

	/**
	 * @see java.sql.Connection#setTransactionIsolation(int)
	 */
	@Override
	public void setTransactionIsolation(final int level) {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockConnection.setTransactionIsolation");
	}

	/**
	 * @see java.sql.Connection#getTransactionIsolation()
	 */
	@Override
	public int getTransactionIsolation() {
		// TODO Auto-generated method stub
		// return 0;
		throw new UnsupportedOperationException("MockConnection.getTransactionIsolation");
	}

	/**
	 * @see java.sql.Connection#getWarnings()
	 */
	@Override
	public SQLWarning getWarnings() {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.getWarnings");
	}

	/**
	 * @see java.sql.Connection#clearWarnings()
	 */
	@Override
	public void clearWarnings() {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockConnection.clearWarnings");
	}

	/**
	 * @see java.sql.Connection#prepareStatement(java.lang.String, int, int)
	 */
	@Override
	public PreparedStatement prepareStatement(final String sql, final int resultSetType, final int resultSetConcurrency) {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.prepareStatement");
	}

	/**
	 * @see java.sql.Connection#prepareCall(java.lang.String, int, int)
	 */
	@Override
	public CallableStatement prepareCall(final String sql, final int resultSetType, final int resultSetConcurrency) {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.prepareCall");
	}

	/**
	 * @see java.sql.Connection#getTypeMap()
	 */
	@Override
	public Map<String, Class<?>> getTypeMap() {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.getTypeMap");
	}

	/**
	 * @see java.sql.Connection#setTypeMap(java.util.Map)
	 */
	@Override
	public void setTypeMap(final Map<String, Class<?>> map) {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockConnection.setTypeMap");
	}

	/**
	 * @see java.sql.Connection#setHoldability(int)
	 */
	@Override
	public void setHoldability(final int holdability) {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockConnection.setHoldability");
	}

	/**
	 * @see java.sql.Connection#getHoldability()
	 */
	@Override
	public int getHoldability() {
		// TODO Auto-generated method stub
		// return 0;
		throw new UnsupportedOperationException("MockConnection.getHoldability");
	}

	/**
	 * @see java.sql.Connection#setSavepoint()
	 */
	@Override
	public Savepoint setSavepoint() {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.setSavepoint");
	}

	/**
	 * @see java.sql.Connection#setSavepoint(java.lang.String)
	 */
	@Override
	public Savepoint setSavepoint(final String name) {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.setSavepoint");
	}

	/**
	 * @see java.sql.Connection#rollback(java.sql.Savepoint)
	 */
	@Override
	public void rollback(final Savepoint savepoint) {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockConnection.rollback");
	}

	/**
	 * @see java.sql.Connection#releaseSavepoint(java.sql.Savepoint)
	 */
	@Override
	public void releaseSavepoint(final Savepoint savepoint) {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockConnection.releaseSavepoint");
	}

	/**
	 * @see java.sql.Connection#createStatement(int, int, int)
	 */
	@Override
	public Statement createStatement(final int resultSetType, final int resultSetConcurrency, final int resultSetHoldability) {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.createStatement");
	}

	/**
	 * @see java.sql.Connection#prepareStatement(java.lang.String, int, int, int)
	 */
	@Override
	public PreparedStatement prepareStatement(final String sql, final int resultSetType, final int resultSetConcurrency,
			final int resultSetHoldability) {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.prepareStatement");
	}

	/**
	 * @see java.sql.Connection#prepareCall(java.lang.String, int, int, int)
	 */
	@Override
	public CallableStatement prepareCall(final String sql, final int resultSetType, final int resultSetConcurrency,
			final int resultSetHoldability) {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.prepareCall");
	}

	/**
	 * @see java.sql.Connection#prepareStatement(java.lang.String, int)
	 */
	@Override
	public PreparedStatement prepareStatement(final String sql, final int autoGeneratedKeys) {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.prepareStatement");
	}

	/**
	 * @see java.sql.Connection#prepareStatement(java.lang.String, int[])
	 */
	@Override
	public PreparedStatement prepareStatement(final String sql, final int[] columnIndexes) {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.prepareStatement");
	}

	/**
	 * @see java.sql.Connection#prepareStatement(java.lang.String, java.lang.String[])
	 */
	@Override
	public PreparedStatement prepareStatement(final String sql, final String[] columnNames) {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.prepareStatement");
	}

	/**
	 * @see java.sql.Connection#createClob()
	 */
	@Override
	public Clob createClob() {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.createClob");
	}

	/**
	 * @see java.sql.Connection#createBlob()
	 */
	@Override
	public Blob createBlob() {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.createBlob");
	}

	/**
	 * @see java.sql.Connection#createNClob()
	 */
	@Override
	public NClob createNClob() {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.createNClob");
	}

	/**
	 * @see java.sql.Connection#createSQLXML()
	 */
	@Override
	public SQLXML createSQLXML() {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.createSQLXML");
	}

	/**
	 * @see java.sql.Connection#isValid(int)
	 */
	@Override
	public boolean isValid(final int timeout) {
		// TODO Auto-generated method stub
		// return false;
		throw new UnsupportedOperationException("MockConnection.isValid");
	}

	/**
	 * @see java.sql.Connection#setClientInfo(java.lang.String, java.lang.String)
	 */
	@Override
	public void setClientInfo(final String name, final String value) {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockConnection.setClientInfo");
	}

	/**
	 * @see java.sql.Connection#setClientInfo(java.util.Properties)
	 */
	@Override
	public void setClientInfo(final Properties properties) {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockConnection.setClientInfo");
	}

	/**
	 * @see java.sql.Connection#getClientInfo(java.lang.String)
	 */
	@Override
	public String getClientInfo(final String name) {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.getClientInfo");
	}

	/**
	 * @see java.sql.Connection#getClientInfo()
	 */
	@Override
	public Properties getClientInfo() {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.getClientInfo");
	}

	/**
	 * @see java.sql.Connection#createArrayOf(java.lang.String, java.lang.Object[])
	 */
	@Override
	public Array createArrayOf(final String typeName, final Object[] elements) {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.createArrayOf");
	}

	/**
	 * @see java.sql.Connection#createStruct(java.lang.String, java.lang.Object[])
	 */
	@Override
	public Struct createStruct(final String typeName, final Object[] attributes) {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.createStruct");
	}

	/**
	 * @see java.sql.Connection#setSchema(java.lang.String)
	 */
	@Override
	public void setSchema(String schema) {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockConnection.setSchema");
	}

	/**
	 * @see java.sql.Connection#getSchema()
	 */
	@Override
	public String getSchema() {
		// TODO Auto-generated method stub
		// return null;
		throw new UnsupportedOperationException("MockConnection.getSchema");
	}

	/**
	 * @see java.sql.Connection#abort(java.util.concurrent.Executor)
	 */
	@Override
	public void abort(Executor executor) {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException("MockConnection.abort");
	}

	/**
	 * @see java.sql.Connection#setNetworkTimeout(java.util.concurrent.Executor,
	 *      int)
	 */
	@Override
	public void setNetworkTimeout(Executor executor, int milliseconds) {
		// TODO Auto-generated method stub
		//
		throw new UnsupportedOperationException(
				"MockConnection.setNetworkTimeout");
	}

	/**
	 * @see java.sql.Connection#getNetworkTimeout()
	 */
	@Override
	public int getNetworkTimeout() {
		// TODO Auto-generated method stub
		// return 0;
		throw new UnsupportedOperationException(
				"MockConnection.getNetworkTimeout");
	}
}
