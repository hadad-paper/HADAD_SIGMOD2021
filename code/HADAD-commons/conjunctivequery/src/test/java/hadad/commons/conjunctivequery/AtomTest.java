package hadad.commons.conjunctivequery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.IntegerConstant;
import hadad.commons.conjunctivequery.StringConstant;
import hadad.commons.conjunctivequery.Term;
import hadad.commons.conjunctivequery.Variable;

public class AtomTest {
	@Test
	public void testHaveSharedVariablesTrue() {
		final List<Term> t1 = new ArrayList<Term>();
		t1.add(new StringConstant("cte1"));
		t1.add(new Variable("x"));
		final Atom a1 = new Atom("p1", t1);
		final List<Term> t2 = new ArrayList<Term>();
		t2.add(new Variable("x"));
		final Atom a2 = new Atom("p2", t2);

		assertTrue(a1.haveSharedVariables(a2));
	}

	@Test
	public void testHaveSharedVariablesFalse() {
		final List<Term> t1 = new ArrayList<Term>();
		t1.add(new StringConstant("cte1"));
		t1.add(new Variable("x"));
		final Atom a1 = new Atom("p1", t1);
		final List<Term> t2 = new ArrayList<Term>();
		t2.add(new StringConstant("cte1"));
		t2.add(new Variable("y"));
		final Atom a2 = new Atom("p2", t2);

		assertFalse(a1.haveSharedVariables(a2));
	}

	@Test
	public void testGetVariables() {
		final List<Term> t1 = new ArrayList<Term>();
		t1.add(new StringConstant("cte1"));
		t1.add(new Variable("x"));
		t1.add(new StringConstant("cte2"));
		t1.add(new Variable("y"));
		final Atom a1 = new Atom("p1", t1);

		final List<Term> variables = new ArrayList<Term>();
		variables.add(new Variable("x"));
		variables.add(new Variable("y"));

		assertEquals(a1.getVariables(), variables);
	}

	@Test
	public void testGetTerms() {
		final List<Term> t1 = new ArrayList<Term>();
		t1.add(new StringConstant("cte1"));
		t1.add(new Variable("x"));
		t1.add(new StringConstant("cte2"));
		t1.add(new Variable("y"));
		final Atom a1 = new Atom("p1", t1);

		assertEquals(a1.getTerms(), t1);
	}

	@Test
	public void testGetTerm() {
		final List<Term> t1 = new ArrayList<Term>();
		t1.add(new StringConstant("cte1"));
		t1.add(new Variable("x"));
		t1.add(new StringConstant("cte2"));
		t1.add(new Variable("y"));
		final Atom a1 = new Atom("p1", t1);

		assertEquals(a1.getTerm(2), new StringConstant("cte2"));
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetTermOutOfBounds() {
		final List<Term> t1 = new ArrayList<Term>();
		t1.add(new StringConstant("cte1"));
		final Atom a1 = new Atom("p1", t1);
		a1.getTerm(1);
	}

	@Test
	public void testIndexOfTerm() {
		final List<Term> t1 = new ArrayList<Term>();
		t1.add(new StringConstant("cte1"));
		t1.add(new Variable("x"));
		t1.add(new StringConstant("cte2"));
		t1.add(new Variable("y"));
		final Atom a1 = new Atom("p1", t1);

		assertEquals(a1.indexOf(new StringConstant("cte2")), 2);
	}

	@Test
	public void testIndexOfNonOccur() {
		final List<Term> t1 = new ArrayList<Term>();
		t1.add(new StringConstant("cte1"));
		final Atom a1 = new Atom("p1", t1);

		assertEquals(a1.indexOf(new StringConstant("cte2")), -1);
	}

	@Test
	public void testEqualsTrue() {
		final String predicate = "p1";
		final List<Term> terms = new ArrayList<Term>();
		terms.add(new StringConstant("cte1"));
		terms.add(new Variable("x"));
		final Atom a1 = new Atom("id1", predicate, terms);
		final Atom a2 = new Atom("id2", predicate, terms);

		assertTrue(a1.equals(a2));
	}

	@Test
	public void testEqualsDiffPredicate() {
		final List<Term> terms = new ArrayList<Term>();
		terms.add(new StringConstant("cte1"));
		terms.add(new Variable("x"));
		final Atom a1 = new Atom("id", "p1", terms);
		final Atom a2 = new Atom("id", "p2", terms);

		assertFalse(a1.equals(a2));
	}

	@Test
	public void testEqualsDiffTerms() {
		final String predicate = "p1";
		final List<Term> t1 = new ArrayList<Term>();
		t1.add(new StringConstant("cte1"));
		t1.add(new Variable("x"));
		final Atom a1 = new Atom("id", predicate, t1);
		final List<Term> t2 = new ArrayList<Term>();
		t2.add(new StringConstant("cte2"));
		t2.add(new Variable("x"));
		final Atom a2 = new Atom("id", predicate, t2);

		assertFalse(a1.equals(a2));
	}

	@Test
	public void testEqualsDiffTermsType() {
		final String predicate = "p1";
		final List<Term> t1 = new ArrayList<Term>();
		t1.add(new StringConstant("1"));
		t1.add(new Variable("x"));
		final Atom a1 = new Atom("id", predicate, t1);
		final List<Term> t2 = new ArrayList<Term>();
		t2.add(new IntegerConstant("1"));
		t2.add(new Variable("x"));
		final Atom a2 = new Atom("id", predicate, t2);

		assertFalse(a1.equals(a2));
	}
}
