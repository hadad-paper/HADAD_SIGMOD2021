package hadad.commons.conjunctivequery;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ AtomTest.class, ConjunctiveQueryTest.class,
		HomomorphismTest.class, IntegerConstantTest.class,
		StringConstantTest.class, VariableTest.class })
public class AllTests {

}
