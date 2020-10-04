package hadad.commons.conjunctivequery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.conjunctivequery.Homomorphism;
import hadad.commons.conjunctivequery.Term;
import hadad.commons.conjunctivequery.parser.CQParser;
import hadad.commons.conjunctivequery.parser.ParseException;

public class HomomorphismTest {
	private static List<ConjunctiveQuery> queries;

	@BeforeClass
	public static void setUpClass() throws ParseException {
		String queriesString = "Q1<a,e> :- R(a,b,c),T(c,e);"
				+ "Q2<a,e> :- T(c,e),R(a,b,c);" + "Q3<a,f>:- T(b,f), R(a,d,b);"
				+ "Q4<f,a>:- T(b,f), R(a,d,b);"
				+ "Q5<a,f,d> :- T(b,f), R(a,d,b);"
				+ "Q6<a,f>:- R(a,d,b), T(b,f), T(b,f);"
				+ "Q7<a,e>:- R(a,b,c),T(d,e);"
				+ "Q8<a,e>:- R(a,\"C\",c),T(c,e);"
				+ "Q9<a,j>:- R(a,b,c),R(d,e,f),R(g,h,i),T(c,j);"
				+ "Q10<a,f>:-R(a,d,b),T(b,f),S(f,g,h);"
				+ "Q11<a,i>:-R(a,b,c),T(c,f),T(c,h),T(c,i);";

		InputStream is = new ByteArrayInputStream(queriesString.getBytes());

		final CQParser PARSER = new CQParser(is);
		queries = new ArrayList<ConjunctiveQuery>(PARSER.parse().values());
	}

	@Test
	public void testFindHomomorphisms1() {
		List<Atom> Q1 = queries.get(0).body;
		List<Atom> Q2 = queries.get(1).body;
		List<Homomorphism> homomorphisms = Homomorphism.findHomomorphisms(
				Q1, Q2);
		assertNotNull(homomorphisms);
		assertEquals(1, homomorphisms.size());
		for (Atom q1 : Q1) {
			for (Term q1Term : q1.getTerms()) {
				Term q2 = homomorphisms.get(0).getMapping(q1Term);
				assertTrue(containsTerm(Q2, q2));
			}
		}
	}

	@Test
	public void testFindHomomorphisms2() {
		List<Atom> Q1 = queries.get(0).body;
		List<Atom> Q2 = queries.get(2).body;
		List<Homomorphism> homomorphisms = Homomorphism.findHomomorphisms(
				Q1, Q2);
		assertNotNull(homomorphisms);
		assertEquals(1, homomorphisms.size());
		for (Atom q1 : Q1) {
			for (Term q1Term : q1.getTerms()) {
				Term q2 = homomorphisms.get(0).getMapping(q1Term);
				assertTrue(containsTerm(Q2, q2));
			}
		}
	}

	@Test
	public void testFindHomomorphisms3() {
		List<Atom> Q1 = queries.get(0).body;
		List<Atom> Q2 = queries.get(3).body;
		List<Homomorphism> homomorphisms = Homomorphism.findHomomorphisms(
				Q1, Q2);
		assertNotNull(homomorphisms);
		assertEquals(1, homomorphisms.size());
		for (Atom q1 : Q1) {
			for (Term q1Term : q1.getTerms()) {
				Term q2 = homomorphisms.get(0).getMapping(q1Term);
				assertTrue(containsTerm(Q2, q2));
			}
		}
	}

	@Test
	public void testFindHomomorphisms4() {
		List<Atom> Q1 = queries.get(0).body;
		List<Atom> Q2 = queries.get(5).body;
		List<Homomorphism> homomorphisms = Homomorphism.findHomomorphisms(
				Q1, Q2);
		assertNotNull(homomorphisms);
		assertEquals(2, homomorphisms.size());
		for (Atom q1 : Q1) {
			for (Term q1Term : q1.getTerms()) {
				Term q2 = homomorphisms.get(0).getMapping(q1Term);
				assertTrue(containsTerm(Q2, q2));
			}
		}
	}

	@Test
	public void testFindHomomorphisms5() {
		List<Atom> Q1 = queries.get(5).body;
		List<Atom> Q2 = queries.get(0).body;
		List<Homomorphism> homomorphisms = Homomorphism.findHomomorphisms(
				Q1, Q2);
		assertNotNull(homomorphisms);
		assertEquals(1, homomorphisms.size());
		for (Atom q1 : Q1) {
			for (Term q1Term : q1.getTerms()) {
				Term q2 = homomorphisms.get(0).getMapping(q1Term);
				assertTrue(containsTerm(Q2, q2));
			}
		}
	}

	@Test
	public void testFindHomomorphisms6() {
		List<Atom> Q1 = queries.get(0).body;
		List<Atom> Q2 = queries.get(6).body;
		List<Homomorphism> homomorphisms = Homomorphism.findHomomorphisms(
				Q1, Q2);
		assertNotNull(homomorphisms);
		assertEquals(0, homomorphisms.size());

	}

	@Test
	public void testFindHomomorphisms7() {
		List<Atom> Q1 = queries.get(6).body;
		List<Atom> Q2 = queries.get(0).body;
		List<Homomorphism> homomorphisms = Homomorphism.findHomomorphisms(
				Q1, Q2);
		assertNotNull(homomorphisms);
		assertEquals(1, homomorphisms.size());
		for (Atom q1 : Q1) {
			for (Term q1Term : q1.getTerms()) {
				Term q2 = homomorphisms.get(0).getMapping(q1Term);
				assertTrue(containsTerm(Q2, q2));
			}
		}
	}

	@Test
	public void testFindHomomorphisms8() {
		List<Atom> Q1 = queries.get(0).body;
		List<Atom> Q2 = queries.get(7).body;
		List<Homomorphism> homomorphisms = Homomorphism.findHomomorphisms(
				Q1, Q2);
		assertNotNull(homomorphisms);
		assertEquals(1, homomorphisms.size());
		for (Atom q1 : Q1) {
			for (Term q1Term : q1.getTerms()) {
				Term q2 = homomorphisms.get(0).getMapping(q1Term);
				assertTrue(containsTerm(Q2, q2));
			}
		}
	}

	@Test
	public void testFindHomomorphisms9() {
		List<Atom> Q1 = queries.get(7).body;
		List<Atom> Q2 = queries.get(0).body;
		List<Homomorphism> homomorphisms = Homomorphism.findHomomorphisms(
				Q1, Q2);
		assertNotNull(homomorphisms);
		assertEquals(0, homomorphisms.size());

	}

	@Test
	public void testFindHomomorphisms10() {
		List<Atom> Q1 = queries.get(8).body;
		List<Atom> Q2 = queries.get(0).body;
		List<Homomorphism> homomorphisms = Homomorphism.findHomomorphisms(
				Q1, Q2);
		assertNotNull(homomorphisms);
		assertEquals(1, homomorphisms.size());
		for (Atom q1 : Q1) {
			for (Term q1Term : q1.getTerms()) {
				Term q2 = homomorphisms.get(0).getMapping(q1Term);
				assertTrue(containsTerm(Q2, q2));
			}
		}
	}

	@Test
	public void testFindHomomorphisms11() {
		List<Atom> Q1 = queries.get(0).body;
		List<Atom> Q2 = queries.get(8).body;
		List<Homomorphism> homomorphisms = Homomorphism.findHomomorphisms(
				Q1, Q2);
		assertNotNull(homomorphisms);
		assertEquals(1, homomorphisms.size());
		for (Atom q1 : Q1) {
			for (Term q1Term : q1.getTerms()) {
				Term q2 = homomorphisms.get(0).getMapping(q1Term);
				assertTrue(containsTerm(Q2, q2));
			}
		}
	}

	@Test
	public void testFindHomomorphisms12() {
		List<Atom> Q1 = queries.get(0).body;
		List<Atom> Q2 = queries.get(9).body;
		List<Homomorphism> homomorphisms = Homomorphism.findHomomorphisms(
				Q1, Q2);
		assertNotNull(homomorphisms);
		assertEquals(1, homomorphisms.size());
		for (Atom q1 : Q1) {
			for (Term q1Term : q1.getTerms()) {
				Term q2 = homomorphisms.get(0).getMapping(q1Term);
				assertTrue(containsTerm(Q2, q2));
			}
		}
	}

	@Test
	public void testFindHomomorphisms13() {
		List<Atom> Q1 = queries.get(9).body;
		List<Atom> Q2 = queries.get(0).body;
		List<Homomorphism> homomorphisms = Homomorphism.findHomomorphisms(
				Q1, Q2);
		assertNotNull(homomorphisms);
		assertEquals(0, homomorphisms.size());

	}

	@Test
	public void testFindHomomorphisms14() {
		List<Atom> Q1 = queries.get(0).body;
		List<Atom> Q2 = queries.get(10).body;
		List<Homomorphism> homomorphisms = Homomorphism.findHomomorphisms(
				Q1, Q2);
		assertNotNull(homomorphisms);
		assertEquals(3, homomorphisms.size());
		for (Homomorphism h : homomorphisms) {
			for (Atom q1 : Q1) {
				for (Term q1Term : q1.getTerms()) {
					Term q2 = h.getMapping(q1Term);
					assertTrue(containsTerm(Q2, q2));
				}
			}
		}
	}

	@Test
	public void testFindHomomorphisms15() {
		List<Atom> Q1 = queries.get(10).body;
		List<Atom> Q2 = queries.get(0).body;
		List<Homomorphism> homomorphisms = Homomorphism.findHomomorphisms(
				Q1, Q2);
		assertNotNull(homomorphisms);
		assertEquals(1, homomorphisms.size());
		for (Homomorphism h : homomorphisms) {
			for (Atom q1 : Q1) {
				for (Term q1Term : q1.getTerms()) {
					Term q2 = h.getMapping(q1Term);
					assertTrue(containsTerm(Q2, q2));
				}
			}
		}
	}

	/**
	 *
	 * @param atoms
	 *            - a list of atoms
	 * @param t
	 *            - a term
	 * @return true if the atoms given as a parameter contain the term t
	 */
	private static boolean containsTerm(List<Atom> atoms, Term t) {
		for (Atom a : atoms) {
			for (Term at : a.getTerms()) {
				if (t.equals(at)) {
					return true;
				}
			}
		}
		return false;

	}
}
