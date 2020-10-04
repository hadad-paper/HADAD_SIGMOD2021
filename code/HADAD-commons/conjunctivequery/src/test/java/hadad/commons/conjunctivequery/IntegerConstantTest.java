package hadad.commons.conjunctivequery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import hadad.commons.conjunctivequery.Constant;
import hadad.commons.conjunctivequery.IntegerConstant;
import hadad.commons.conjunctivequery.Variable;

public class IntegerConstantTest extends ConstantTest {
	protected String value;

	/**
	 * Sets up the test fixture.
	 * (Called before every test case method.)
	 */
	@Before
	public void setUp()  {
		value = "123";
		constant = new IntegerConstant(value);
	}


	@Test
	public void testHashCode() {
		assertEquals(Integer.valueOf(value).hashCode(), constant.hashCode());
	}

	@Test
	public void testEqualsWithLiteralSameValue() {
		final Constant constantAux = new IntegerConstant(123);
		assertTrue(constant.equals(constantAux));
	}

	@Test
	public void testEqualsWithLiteralDiffValue() {
		final Constant constantAux = new IntegerConstant("213");
		assertFalse(constant.equals(constantAux));
	}

	@Test
	public void testGetValue() {
		assertEquals(123, constant.getValue());
	}

	@Test
	public void testToString() {
		assertEquals("123", constant.toString());
	}

	@Test
	public void testEqualsVariable() {
		assertFalse(constant.equals(new Variable(value)));
	}
}
