package hadad.commons.conjunctivequery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import hadad.commons.conjunctivequery.Constant;
import hadad.commons.conjunctivequery.StringConstant;
import hadad.commons.conjunctivequery.Variable;

public class StringConstantTest extends ConstantTest {
	protected String value;

	/**
	 * Sets up the test fixture.
	 * (Called before every test case method.)
	 */
	@Before
	public void setUp()  {
		value = "someLiteral";
		constant = new StringConstant(value);
	}

	@Test
	public void testHashCode() {
		assertEquals(value.hashCode(), constant.hashCode());
	}

	@Test
	public void testEqualsWithLiteralSameValue() {
		final Constant constantAux = new StringConstant("someLiteral");
		assertTrue(constant.equals(constantAux));
	}

	@Test
	public void testEqualsWithLiteralDiffValue() {
		final Constant constantAux = new StringConstant("anotherLiteral");
		assertFalse(constant.equals(constantAux));
	}

	@Test
	public void testGetValue() {
		assertEquals("someLiteral", constant.getValue());
	}

	@Test
	public void testToString() {
		assertEquals("\"someLiteral\"", constant.toString());
	}

	@Test
	public void testEqualsVariable() {
		assertFalse(constant.equals(new Variable(value)));
	}
}
