package hadad.commons.constraints.parser;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.IntegerConstant;
import hadad.commons.conjunctivequery.StringConstant;
import hadad.commons.conjunctivequery.Term;
import hadad.commons.constraints.Constraint;
import hadad.commons.constraints.Egd;
import hadad.commons.constraints.Equality;
import hadad.commons.constraints.Tgd;
import hadad.commons.constraints.parser.ConstraintParser;


public class ParserTest {

	@Test
	public void BasicTgdTest() {
		try
		{
			InputStream is = getClass().getResourceAsStream("/BasicTgdTest");
			ConstraintParser parser = new ConstraintParser(is);
			ArrayList<Constraint> parsed = parser.parse();
			assertTrue(parsed.size() == 1);
			Constraint constraint = parsed.get(0);
			assertTrue(constraint instanceof Tgd);
			Tgd tgd = (Tgd)constraint;
			List<Atom> premise = tgd.getPremise();
			assertTrue(premise.size() ==3);
			List<Atom> conclusion = tgd.getConclusion();
			assertTrue(conclusion.size() ==4);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void BasicEgdTest() {
		try
		{
			InputStream is = getClass().getResourceAsStream("/BasicEgdTest");
			ConstraintParser parser = new ConstraintParser(is);
			ArrayList<Constraint> parsed = parser.parse();
			assertTrue(parsed.size() == 1);
			Constraint constraint = parsed.get(0);
			assertTrue(constraint instanceof Egd);
			Egd egd = (Egd)constraint;
			List<Atom> premise = egd.getPremise();
			assertTrue(premise.size() ==2);
			List<Equality> conclusion = egd.getConclusion();
			assertTrue(conclusion.size() ==2);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void TgdWithConstantsTest() {
		try
		{
			InputStream is = getClass().getResourceAsStream("/TgdWithConstantsTest");
			ConstraintParser parser = new ConstraintParser(is);
			ArrayList<Constraint> parsed = parser.parse();
			assertTrue(parsed.size() == 1);
			Constraint constraint = parsed.get(0);
			assertTrue(constraint instanceof Tgd);
			Tgd tgd = (Tgd)constraint;
			List<Atom> premise = tgd.getPremise();
			assertTrue(premise.size() ==1);
			Atom atom = premise.get(0);
			List<? extends Term> terms = atom.getTerms();
			assertTrue(terms.size()==3);
			assertTrue(terms.get(0).isVariable());
			assertTrue(terms.get(1) instanceof IntegerConstant);
			assertTrue(((IntegerConstant)terms.get(1)).getValue() == 1);
			assertTrue(terms.get(2) instanceof StringConstant);
			assertTrue(((StringConstant)terms.get(2)).getValue().equals("ll"));

		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void AssertionTest() {
		try
		{
			InputStream is = getClass().getResourceAsStream("/AssertionTest");
			ConstraintParser parser = new ConstraintParser(is);
			ArrayList<Constraint> parsed = parser.parse();
			assertTrue(parsed.size() == 1);
			Constraint constraint = parsed.get(0);
			assertTrue(constraint instanceof Tgd);
			Tgd tgd = (Tgd)constraint;
			assertTrue(tgd.getPremise().size()==0);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}


}
