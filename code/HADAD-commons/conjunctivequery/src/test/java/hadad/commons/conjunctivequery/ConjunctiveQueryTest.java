package hadad.commons.conjunctivequery;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.conjunctivequery.Term;
import hadad.commons.conjunctivequery.Variable;
import hadad.commons.conjunctivequery.parser.CQParser;
import hadad.commons.conjunctivequery.parser.ParseException;

public class ConjunctiveQueryTest {

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
	public void testIsContained1(){
		//Only the order of the atoms in the body
		//is different.
		ConjunctiveQuery q1 = queries.get(0);
		ConjunctiveQuery q2 = queries.get(1);

		assertTrue(q1.isContained(q2));
		assertTrue(q2.isContained(q1));
	}

	@Test
	public void testIsContained2(){
		//Different order of the atoms and variable
		//renaming.
		ConjunctiveQuery q1 = queries.get(0);
		ConjunctiveQuery q2 = queries.get(2);

		assertTrue(q1.isContained(q2));
		assertTrue(q2.isContained(q1));
	}

	@Test
	public void testIsContained3(){
		//Different order of variables in the head
		ConjunctiveQuery q1 = queries.get(0);
		ConjunctiveQuery q2 = queries.get(3);

		assertFalse(q1.isContained(q2));
		assertFalse(q2.isContained(q1));
	}

	@Test
	public void testIsContained4(){
		//Different number of variables in the head
		ConjunctiveQuery q1 = queries.get(0);
		ConjunctiveQuery q2 = queries.get(4);

		assertFalse(q1.isContained(q2));
		assertFalse(q2.isContained(q1));
	}

	@Test
	public void testIsContained5(){
		//Queries with different number of atoms
		ConjunctiveQuery q1 = queries.get(0);
		ConjunctiveQuery q2 = queries.get(5);

		assertTrue(q1.isContained(q2));
		assertTrue(q2.isContained(q1));
	}

	@Test
	public void testIsContained6(){
		//Query with join vs query with cartesian product
		ConjunctiveQuery q1 = queries.get(0);
		ConjunctiveQuery q2 = queries.get(6);

		assertTrue(q1.isContained(q2));
		assertFalse(q2.isContained(q1));
	}

	@Test
	public void testIsContained7(){
		//Query with constants
		ConjunctiveQuery q1 = queries.get(0);
		ConjunctiveQuery q2 = queries.get(7);

		assertFalse(q1.isContained(q2));
		assertTrue(q2.isContained(q1));
	}

	@Test
	public void testIsContained8(){
		//Query with different number of atoms;atoms occuring more than once
		ConjunctiveQuery q1 = queries.get(0);
		ConjunctiveQuery q2 = queries.get(8);

		assertTrue(q1.isContained(q2));
		assertTrue(q2.isContained(q1));
	}

	@Test
	public void testIsContained9(){
		//Query with different atoms
		ConjunctiveQuery q1 = queries.get(0);
		ConjunctiveQuery q2 = queries.get(9);

		assertFalse(q1.isContained(q2));
		assertTrue(q2.isContained(q1));
	}

	@Test
	public void testIsContained10(){
		ConjunctiveQuery q1 = generateStarQuery(10, "x", "R", 4, 0);
		ConjunctiveQuery q2 = generateStarQuery(10, "y", "R", 4, 0);

		assertTrue(q1.isContained(q2));
		assertTrue(q2.isContained(q1));
	}

	@Test
	public void testIsContained11(){
		ConjunctiveQuery q1 = generateStarQuery(10, "x", "R", 4, 0);
		ConjunctiveQuery q2 = generateStarQuery(20, "y", "R", 4, 0);

		assertFalse(q1.isContained(q2));
		assertTrue(q2.isContained(q1));
	}

	@Test
	public void testIsContained12(){
		ConjunctiveQuery q1 = generateStarQuery(1000, "x", "R", 4, 0);
		ConjunctiveQuery q2 = generateStarQuery(1000, "y", "R", 4, 0);

		assertTrue(q1.isContained(q2));
		assertTrue(q2.isContained(q1));
	}

	//Removed test-case since it needs a lot of heap-space just for generating the queries
	//	@Test
	//	public void testIsContained13(){
	//		ConjunctiveQuery q1 = generateStarQuery(100000, "x", "R", 4, 0);
	//		ConjunctiveQuery q2 = generateStarQuery(100000, "y", "S", 4, 0);
	//
	//		assertFalse(q1.isContained(q2));
	//		assertFalse(q2.isContained(q1));
	//	}

	@Test
	public void testIsContained13(){
		ConjunctiveQuery q1 = generateStarQuery(1000, "x", "R", 4, 0);
		ConjunctiveQuery q2 = generateStarQuery(1000, "y", "S", 4, 0);

		assertFalse(q1.isContained(q2));
		assertFalse(q2.isContained(q1));
	}

	@Test
	public void testIsContained14(){
		ConjunctiveQuery q1 = generateChainQuery(10, "x", "R", 4);
		ConjunctiveQuery q2 = generateChainQuery(10, "y", "R", 4);

		assertTrue(q1.isContained(q2));
		assertTrue(q2.isContained(q1));
	}

	@Test
	public void testIsContained15(){
		ConjunctiveQuery q1 = generateChainQuery(10, "x", "R", 4);
		ConjunctiveQuery q2 = generateChainQuery(20, "y", "R", 4);

		assertFalse(q1.isContained(q2));
		assertTrue(q2.isContained(q1));
	}

	@Test
	public void testIsContained16(){
		ConjunctiveQuery q1 = generateChainQuery(1000, "x", "R", 4);
		ConjunctiveQuery q2 = generateChainQuery(1000, "y", "R", 4);

		assertTrue(q1.isContained(q2));
		assertTrue(q2.isContained(q1));
	}

	@Test
	public void testIsContained17(){
		ConjunctiveQuery q1 = generateStarQuery(1000, "x", "R", 4, 0);
		ConjunctiveQuery q2 = generateChainQuery(1000, "y", "R", 4);

		assertFalse(q1.isContained(q2));
		assertFalse(q2.isContained(q1));
	}

	//The tests for equivalence between queries which are given below
	//recycle the scenarios which are used in the containment tests
	//above.

	@Test
	public void testIsEquivalent1(){
		//Only the order of the atoms in the body
		//is different.
		ConjunctiveQuery q1 = queries.get(0);
		ConjunctiveQuery q2 = queries.get(1);


		assertTrue(q1.isEquivalent(q2));
		assertTrue(q2.isEquivalent(q1));
	}

	@Test
	public void testIsEquivalent2(){
		//Different order of the atoms and variable
		//renaming.
		ConjunctiveQuery q1 = queries.get(0);
		ConjunctiveQuery q2 = queries.get(2);

		assertTrue(q1.isEquivalent(q2));
		assertTrue(q2.isEquivalent(q1));
	}

	@Test
	public void testIsEquivalent3(){
		//Different order of variables in the head
		ConjunctiveQuery q1 = queries.get(0);
		ConjunctiveQuery q2 = queries.get(3);

		assertFalse(q1.isEquivalent(q2));
		assertFalse(q2.isEquivalent(q1));
	}

	@Test
	public void testIsEquivalent4(){
		//Different number of variables in the head
		ConjunctiveQuery q1 = queries.get(0);
		ConjunctiveQuery q2 = queries.get(4);

		assertFalse(q1.isEquivalent(q2));
		assertFalse(q2.isEquivalent(q1));
	}

	@Test
	public void testIsEquivalent5(){
		//Queries with different number of atoms
		ConjunctiveQuery q1 = queries.get(0);
		ConjunctiveQuery q2 = queries.get(5);

		assertTrue(q1.isEquivalent(q2));
		assertTrue(q2.isEquivalent(q1));
	}


	@Test
	public void testIsEquivalent6(){
		//Query with join vs query with cartesian product
		ConjunctiveQuery q1 = queries.get(0);
		ConjunctiveQuery q2 = queries.get(6);

		assertFalse(q1.isEquivalent(q2));
		assertFalse(q2.isEquivalent(q1));
	}

	@Test
	public void testIsEquivalent7(){
		//Query with constants
		ConjunctiveQuery q1 = queries.get(0);
		ConjunctiveQuery q2 = queries.get(7);

		assertFalse(q1.isEquivalent(q2));
		assertFalse(q2.isEquivalent(q1));
	}

	@Test
	public void testIsEquivalent8(){
		//Query with different number of atoms;atoms occuring more than once
		ConjunctiveQuery q1 = queries.get(0);
		ConjunctiveQuery q2 = queries.get(8);

		assertTrue(q1.isEquivalent(q2));
		assertTrue(q2.isEquivalent(q1));
	}

	@Test
	public void testIsEquivalent9(){
		//Query with different atoms
		ConjunctiveQuery q1 = queries.get(0);
		ConjunctiveQuery q2 = queries.get(9);

		assertFalse(q1.isEquivalent(q2));
		assertFalse(q2.isEquivalent(q1));
	}

	@Test
	public void testIsEquivalent10(){
		ConjunctiveQuery q1 = generateStarQuery(10, "x", "R", 4, 0);
		ConjunctiveQuery q2 = generateStarQuery(10, "y", "R", 4, 0);

		assertTrue(q1.isEquivalent(q2));
		assertTrue(q2.isEquivalent(q1));
	}


	@Test
	public void testIsEquivalent11(){
		ConjunctiveQuery q1 = generateStarQuery(10, "x", "R", 4, 0);
		ConjunctiveQuery q2 = generateStarQuery(20, "y", "R", 4, 0);

		assertFalse(q1.isEquivalent(q2));
		assertFalse(q2.isEquivalent(q1));
	}

	@Test
	public void testIsEquivalent12(){
		ConjunctiveQuery q1 = generateStarQuery(1000, "x", "R", 4, 0);
		ConjunctiveQuery q2 = generateStarQuery(1000, "y", "R", 4, 0);

		assertTrue(q1.isEquivalent(q2));
		assertTrue(q2.isEquivalent(q1));
	}

	//Removed test-case since it needs a lot of heap-space just for generating the queries
	//	@Test
	//	public void testIsEquivalent13(){
	//		ConjunctiveQuery q1 = generateStarQuery(100000, "x", "R", 4, 0);
	//		ConjunctiveQuery q2 = generateStarQuery(100000, "y", "S", 4, 0);
	//
	//		assertFalse(q1.isEquivalent(q2));
	//		assertFalse(q2.isEquivalent(q1));
	//	}

	@Test
	public void testIsEquivalent13(){
		ConjunctiveQuery q1 = generateStarQuery(1000, "x", "R", 4, 0);
		ConjunctiveQuery q2 = generateStarQuery(1000, "y", "S", 4, 0);

		assertFalse(q1.isEquivalent(q2));
		assertFalse(q2.isEquivalent(q1));
	}

	@Test
	public void testIsEquivalent14(){
		ConjunctiveQuery q1 = generateChainQuery(10, "x", "R", 4);
		ConjunctiveQuery q2 = generateChainQuery(10, "y", "R", 4);

		assertTrue(q1.isEquivalent(q2));
		assertTrue(q2.isEquivalent(q1));
	}

	@Test
	public void testIsEquivalent15(){
		ConjunctiveQuery q1 = generateChainQuery(10, "x", "R", 4);
		ConjunctiveQuery q2 = generateChainQuery(20, "y", "R", 4);

		assertFalse(q1.isEquivalent(q2));
		assertFalse(q2.isEquivalent(q1));
	}

	@Test
	public void testIsEquivalent16(){
		ConjunctiveQuery q1 = generateChainQuery(1000, "x", "R", 4);
		ConjunctiveQuery q2 = generateChainQuery(1000, "y", "R", 4);

		assertTrue(q1.isEquivalent(q2));
		assertTrue(q2.isEquivalent(q1));
	}

	@Test
	public void testIsEquivalent17(){
		ConjunctiveQuery q1 = generateStarQuery(1000, "x", "R", 4, 0);
		ConjunctiveQuery q2 = generateChainQuery(1000, "y", "R", 4);

		assertFalse(q1.isEquivalent(q2));
		assertFalse(q2.isEquivalent(q1));
	}


	/**
	 * Generates a star ConjunctiveQuery based on the given parameters.
	 *
	 * @param NUM_ATOMS - the number of atoms from which the query is comprised
	 * @param VAR_PREFIX - the prefix which is used for the variables of the atoms
	 * @param PREDICATE_PREFIX - the prefix which is used for the predicates of the atoms
	 * @param TERMS_PER_ATOM - the number of terms per atom
	 * @param JOIN_ON_TERM - the position on which we introduce the join
	 *
	 * @return a star ConjunctiveQuery which is generated based on the given parameters.
	 */
	private static ConjunctiveQuery generateStarQuery(
			final int NUM_ATOMS,
			final String VAR_PREFIX,
			final String PREDICATE_PREFIX,
			final int TERMS_PER_ATOM,
			final int JOIN_ON_TERM){
		if(NUM_ATOMS<=0 || VAR_PREFIX==null
				|| VAR_PREFIX.equals("")
				|| PREDICATE_PREFIX==null
				|| PREDICATE_PREFIX.equals("")
				|| TERMS_PER_ATOM<=0
				|| JOIN_ON_TERM<0
				|| JOIN_ON_TERM>TERMS_PER_ATOM){
			throw new IllegalArgumentException();
		}
		List<Term> head = new ArrayList<Term>();
		List<Atom> body = new ArrayList<Atom>();
		//Create the body of the query
		int tid = 0;
		for(int i=0;i<NUM_ATOMS;i++){
			List<Term> terms = new ArrayList<Term>(TERMS_PER_ATOM);
			for(int j=0;j<TERMS_PER_ATOM;j++){
				if(JOIN_ON_TERM == j){
					terms.add(new Variable(VAR_PREFIX));
				}else{
					terms.add(new Variable(VAR_PREFIX+tid));
				}
				tid++;
			}
			Atom a = new Atom(PREDICATE_PREFIX+i, terms);
			body.add(a);
		}
		return new ConjunctiveQuery(head, body);
	}

	/**
	 * Generates a chain ConjunctiveQuery based on the given parameters.
	 *
	 * @param NUM_ATOMS - the number of atoms from which the query is comprised
	 * @param VAR_PREFIX - the prefix which is used for the variables of the atoms
	 * @param PREDICATE_PREFIX - the prefix which is used for the predicates of the atoms
	 * @param TERMS_PER_ATOM - the number of terms per atom (since it is a chain query it must be >= 2)
	 *
	 * @return a chain ConjunctiveQuery which is generated based on the given parameters.
	 */
	private static ConjunctiveQuery generateChainQuery(
			final int NUM_ATOMS,
			final String VAR_PREFIX,
			final String PREDICATE_PREFIX,
			final int TERMS_PER_ATOM){
		if(NUM_ATOMS<=0 || VAR_PREFIX==null
				|| VAR_PREFIX.equals("")
				|| PREDICATE_PREFIX==null
				|| PREDICATE_PREFIX.equals("")
				|| TERMS_PER_ATOM<2){
			throw new IllegalArgumentException();
		}
		List<Term> head = new ArrayList<Term>();
		List<Atom> body = new ArrayList<Atom>();
		//Create the body of the query
		int tid = 0;
		Term prevTerm = new Variable(VAR_PREFIX+tid);
		tid++;
		for(int i=0;i<NUM_ATOMS;i++){
			List<Term> terms = new ArrayList<Term>(TERMS_PER_ATOM);
			terms.add(prevTerm);
			for (int j = 1; j < TERMS_PER_ATOM; j++) {
				Term nt = new Variable(VAR_PREFIX + tid);
				terms.add(nt);
				prevTerm = nt;
				tid++;

			}
			Atom a = new Atom(PREDICATE_PREFIX+i, terms);
			body.add(a);
		}
		return new ConjunctiveQuery(head, body);
	}
}
