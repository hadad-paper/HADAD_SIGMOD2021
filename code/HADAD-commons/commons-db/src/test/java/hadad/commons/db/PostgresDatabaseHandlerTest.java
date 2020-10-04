package hadad.commons.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import hadad.commons.db.DB2DatabaseHandler;
import hadad.commons.db.DatabaseHandler;
import hadad.commons.db.DictionaryException;
import hadad.commons.db.InexistentKeyException;
import hadad.commons.db.InexistentValueException;
import hadad.commons.db.PostgresDatabaseHandler;

public class PostgresDatabaseHandlerTest extends DatabaseHandlerTest {
	
	/**
     * Sets up the test fixture. 
     * (Called before every test case method.)
	 */
    @Before
    public void setUp() throws DictionaryException, InexistentValueException, InexistentKeyException {
    	dbHandler = new DB2DatabaseHandler(Mockito.mock(Connection.class));
    }
    
    /**
     * Tears down the test fixture. 
     * (Called after every test case method.)
     */
    @After
    public void tearDown() {}
    
    @Test
    public void testGetNumberOfSelectedFields() {
    	// GIVEN
    	final DatabaseHandler dbHandler = new PostgresDatabaseHandler(Mockito.mock(Connection.class));
    	final String query = "SELECT DISTINCT t1.s, t2.o FROM encoded_triples t1, encoded_triples t2 WHERE t1.s = t2.s AND t1.p = 1234 AND t1.o = 23 AND t2.p = 7";
        
    	// WHEN
    	final int ret = dbHandler.getNumberOfSelectedFields(query);
    	
    	// THEN
    	assertEquals(ret, 2);
    }
    
    @Test
    public void testCreateStatement() throws SQLException {
    	// GIVEN
    	final MockStatement stmt = new MockStatement(1000);
    	final MockConnection conn = new MockConnection(stmt, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
    	final DatabaseHandler dbHandler = new PostgresDatabaseHandler(conn);
		
		// WHEN 
		final Statement newStmt = dbHandler.createStatement(1000);
    	
		// THEN
		assertSame(stmt, newStmt);
		stmt.verify();
		conn.verify();
    }
}
