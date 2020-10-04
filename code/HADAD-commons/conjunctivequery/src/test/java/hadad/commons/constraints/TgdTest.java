package hadad.commons.constraints;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

import hadad.commons.constraints.Tgd;
import hadad.commons.constraints.parser.ParseException;

public class TgdTest {
	@Test
	public void testIsEquivalent1() throws UnsupportedEncodingException,
	ParseException {
		final Tgd tgd1 = Tgd.fromString("V(x) -> R(x);");
		final Tgd tgd2 = Tgd.fromString("V(x) -> R(y);");
		assertFalse(tgd1.isEquivalent(tgd2));
	}

	@Test
	public void testIsEquivalent2() throws UnsupportedEncodingException,
	ParseException {
		final Tgd tgd1 = Tgd.fromString("V(x) -> R(x);");
		final Tgd tgd2 = Tgd.fromString("V(y) -> R(y);");
		assertTrue(tgd1.isEquivalent(tgd2));
	}

	@Test
	public void testIsEquivalent3() throws UnsupportedEncodingException,
	ParseException {
		final Tgd tgd1 = Tgd
				.fromString("root(x_0),desc(x_0,y_0),tag(y_0,\"person\")->v_0_extr(y_0),child(y_0,z_1);");
		final Tgd tgd2 = Tgd
				.fromString("desc(y_0,w_0),tag(w_0,\"person\"),root(y_0)->child(w_0,v_1),v_0_extr(w_0);");
		assertTrue(tgd1.isEquivalent(tgd2));
	}

}
