package hadad.commons.constraints;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import hadad.commons.constraints.Egd;
import hadad.commons.constraints.parser.ParseException;

public class EgdTest {
	@Test
	public void testIsEquivalent1() throws UnsupportedEncodingException,
	ParseException {
		final Egd tgd1 = Egd.fromString("V(x) -> x=0;");
		final Egd tgd2 = Egd.fromString("V(x) -> x=1;");
		assertFalse(tgd1.isEquivalent(tgd2));
	}

	@Test
	public void testIsEquivalent2() throws UnsupportedEncodingException,
	ParseException {
		final Egd tgd1 = Egd.fromString("V(x) -> x=0;");
		final Egd tgd2 = Egd.fromString("V(x) -> x=0;");
		assertTrue(tgd1.isEquivalent(tgd2));
	}

	@Test
	public void testIsEquivalent3() throws UnsupportedEncodingException,
	ParseException {
		final Egd tgd1 = Egd.fromString("V(x), B(y) -> x=y;");
		final Egd tgd2 = Egd.fromString("V(x), B(y) -> x=z;");
		assertFalse(tgd1.isEquivalent(tgd2));
	}

	@Test
	public void testIsEquivalent4() throws UnsupportedEncodingException,
	ParseException {
		final Egd tgd1 = Egd.fromString("V(x), B(y) -> x=y;");
		final Egd tgd2 = Egd.fromString("V(y), B(x) -> y=x;");
		assertTrue(tgd1.isEquivalent(tgd2));
	}
}
