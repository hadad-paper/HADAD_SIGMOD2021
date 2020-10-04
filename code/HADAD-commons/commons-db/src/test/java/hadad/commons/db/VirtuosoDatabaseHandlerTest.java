package hadad.commons.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.sql.Connection;
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
import hadad.commons.db.VirtuosoDatabaseHandler;
import virtuoso.jdbc4.VirtuosoResultSet;

public class VirtuosoDatabaseHandlerTest extends DatabaseHandlerTest {
	
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
    	final DatabaseHandler dbHandler = new VirtuosoDatabaseHandler(Mockito.mock(Connection.class));
    	final String query = "SPARQL SELECT DISTINCT ?X ?Y FROM <my_current_graph> WHERE { ?X <http://www.w3.org/1999/02/22-rdf-syntax-ns#type> <http://www.lehigh.edu/~zhp2/2004/0401/univ-bench.owl#Employee> . ?X <http://www.lehigh.edu/~zhp2/2004/0401/univ-bench.owl#worksFor> <http://www.Department0.University0.edu> . ?X <http://www.lehigh.edu/~zhp2/2004/0401/univ-bench.owl#degreeFrom> ?Y . }";
        
    	// WHEN
    	final int ret = dbHandler.getNumberOfSelectedFields(query);
    	
    	// THEN
    	assertEquals(ret, 2);
    }
    
    @Test
    public void testCreateStatement() throws SQLException {
    	// GIVEN
    	final MockStatement stmt = new MockStatement(1000);
    	final MockConnection conn = new MockConnection(stmt, VirtuosoResultSet.TYPE_FORWARD_ONLY, VirtuosoResultSet.CONCUR_READ_ONLY);
    	final DatabaseHandler dbHandler = new VirtuosoDatabaseHandler(conn);
		
		// WHEN 
		final Statement newStmt = dbHandler.createStatement(1000);
    	
		// THEN
		assertSame(stmt, newStmt);
		stmt.verify();
		conn.verify();
    }
}
