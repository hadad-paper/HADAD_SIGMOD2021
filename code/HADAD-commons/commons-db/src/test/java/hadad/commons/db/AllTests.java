package hadad.commons.db;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ DB2DatabaseHandlerTest.class, MySQLDatabaseHandlerTest.class,
		PostgresDatabaseHandlerTest.class, VirtuosoDatabaseHandlerTest.class })
public class AllTests {

}
