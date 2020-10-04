package hadad.commons.db;

import java.sql.SQLException;

import org.junit.Test;

import hadad.commons.db.DatabaseHandler;
import hadad.commons.db.DictionaryException;
import hadad.commons.db.InexistentKeyException;

public abstract class DatabaseHandlerTest  {
	protected DatabaseHandler dbHandler;
	
	public abstract void testGetNumberOfSelectedFields();
	public abstract void testCreateStatement() throws SQLException;
	
    @Test(expected = DictionaryException.class)
    public void testGetStatementExecutionAndResultsDecodeTimeInMilliseconds() throws SQLException, DictionaryException, InexistentKeyException {
    	// GIVEN
    	final String query = "SELECT DISTINCT t1.s, t2.o FROM encoded_triples t1, encoded_triples t2 WHERE t1.s = t2.s AND t1.p = 1234 AND t1.o = 23 AND t2.p = 7";
    	final int ignored = 0;
    	
    	// WHEN
    	dbHandler.getStatementExecutionAndResultsDecodeTimeInMilliseconds(query, ignored);
	}
}
