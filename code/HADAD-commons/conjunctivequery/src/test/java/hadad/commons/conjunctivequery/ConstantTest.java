package hadad.commons.conjunctivequery;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;

import hadad.commons.conjunctivequery.Constant;

public abstract class ConstantTest {
	protected Constant constant;

	/**
	 * Tears down the test fixture.
	 * (Called after every test case method.)
	 */
	@After
	public void tearDown() {
		constant = null;
	}

	@Test
	public void testEqualsFalseWhenNull() {
		assertFalse(constant.equals(null));
	}

	@Test
	public void testIsConstant() {
		assertTrue(constant.isConstant());
	}

	@Test
	public void testIsVariable() {
		assertFalse(constant.isVariable());
	}
}
