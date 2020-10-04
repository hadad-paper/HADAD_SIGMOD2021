package hadad.commons.conjunctivequery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import hadad.commons.conjunctivequery.StringConstant;
import hadad.commons.conjunctivequery.Variable;

public class VariableTest {
	private String name;
	private Variable variable;

	/**
	 * Sets up the test fixture.
	 * (Called before every test case method.)
	 */
	@Before
	public void setUp() {
		name = "name";
		variable = new Variable(name);
	}

	/**
	 * Tears down the test fixture.
	 * (Called after every test case method.)
	 */
	@After
	public void tearDown() {
		variable = null;
	}

	@Test
	public void testToString() {
		assertEquals(name, variable.toString());
	}

	@Test
	public void testHashCode() {
		assertEquals(name.hashCode(), variable.hashCode());
	}

	@Test
	public void testEqualsVariableWithSameName() {
		final Variable variableAux = new Variable(name);
		assertTrue(variable.equals(variableAux));
	}

	@Test
	public void testEqualsVariableWithDiffName() {
		final String nameAux = "foo";
		final Variable variableAux = new Variable(nameAux);
		assertFalse(variable.equals(variableAux));
	}

	@Test
	public void testEqualsString() {
		assertFalse(variable.equals(name));
	}

	@Test
	public void testEqualsConstant() {
		assertFalse(variable.equals(new StringConstant(name)));
	}

	@Test
	public void testIsConstant() {
		assertFalse(variable.isConstant());
	}

	@Test
	public void testIsVariable() {
		assertTrue(variable.isVariable());
	}
}
