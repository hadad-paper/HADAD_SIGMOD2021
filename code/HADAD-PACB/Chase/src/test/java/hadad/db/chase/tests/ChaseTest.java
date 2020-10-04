package hadad.db.chase.tests;

import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.junit.Test;

import hadad.db.canonicaldb.Database;
import hadad.db.canonicaldb.Relation;
import hadad.db.canonicaldb.Tuple;
import hadad.db.canonicaldb.Relation.TupleIterator;
import hadad.db.chase.Assertion;
import hadad.db.chase.Chase;
import hadad.db.chase.DenialConstraint;
import hadad.db.chase.Equality;
import hadad.db.chase.EqualityGenConstraint;
import hadad.db.chase.TupleGenConstraint;
import hadad.db.chaseexceptions.InconsistencyException;
import hadad.db.datalogexpr.Predicate;
import hadad.db.datalogexpr.Statement;
import hadad.db.datalogexpr.StatementJoin;
import hadad.db.datalogexpr.StatementScan;
import hadad.db.datalogexpr.Value;

public class ChaseTest {

	/**
	 * Initial Input >	Instance:		empty
	 * 					Constraints:	true \subseteq R(x, y)
	 * 
	 * Expected Instance > R(z1, z2)
	 */
	@Test public void SimpleAssertion() {
		
		// Populate instance
		Database db = new Database();
		
		Relation rel1 = new Relation("R", 2);
		db.addRelationInstance(rel1);
		
		// Create assertion
		Predicate pred1 = new Predicate(2);
		pred1.setFunctionHead("R");
		pred1.addVariable(Value.createVariable("x", false));
		pred1.addVariable(Value.createVariable("y", false));
		
		Predicate head = new Predicate(0);
		
		Statement assertionConclusion = new Statement(head, new StatementScan(pred1));
		
		Assertion assertion1 = new Assertion(assertionConclusion, db);
		
		// Populate list of constraints
		ArrayList<Assertion> assertions = new ArrayList<Assertion>();
		assertions.add(assertion1);
		
		ArrayList<TupleGenConstraint> tgds = new ArrayList<TupleGenConstraint>();
		ArrayList<EqualityGenConstraint> egds = new ArrayList<EqualityGenConstraint>();
		
		// Chase
		Chase chase = new Chase(tgds, egds, new ArrayList<DenialConstraint>() , assertions);
		
		try {
			chase.run();
		} catch (InconsistencyException e) {
			e.printStackTrace();
		}
		
		// Create expected canonical database
		Database expectedDb = new Database();
		
		Relation expectedRel1 = new Relation("R", 2);
		expectedDb.addRelationInstance(expectedRel1);
		
		Tuple tuple = new Tuple(2);
		tuple.addValue(Value.createVariable("z1", false));
		tuple.addValue(Value.createVariable("z2", false));
		
		expectedRel1.addTuple(tuple);
		
		assertTrue("The canonical database does not have the expected schema", haveSameSchema(db, expectedDb));
		assertTrue("The canonical database is not the expected one", areHomomorphic(db, expectedDb));
	}
	
	/**
	 * Initial Input >	Instance:		empty
	 * 					Constraints:	true \subseteq R(x, 1, "a")
	 * 
	 * Expected Instance > R(z1, 1, "a")
	 */
	@Test public void SimpleAssertionWithConstants() {
		
		// Populate instance
		Database db = new Database();
		
		Relation rel1 = new Relation("R", 3);
		db.addRelationInstance(rel1);
		
		// Create assertion
		Predicate pred1 = new Predicate(3);
		pred1.setFunctionHead("R");
		pred1.addVariable(Value.createVariable("x", false));
		pred1.addVariable(Value.createNumericConstant(1.0));
		pred1.addVariable(Value.createStringConstant("a"));
		
		Predicate head = new Predicate(0);
		
		Statement assertionConclusion = new Statement(head, new StatementScan(pred1));
		
		Assertion assertion1 = new Assertion(assertionConclusion, db);
		
		// Populate list of constraints
		ArrayList<Assertion> assertions = new ArrayList<Assertion>();
		assertions.add(assertion1);
		
		ArrayList<TupleGenConstraint> tgds = new ArrayList<TupleGenConstraint>();
		ArrayList<EqualityGenConstraint> egds = new ArrayList<EqualityGenConstraint>();
		
		// Chase
		Chase chase = new Chase(tgds, egds, new ArrayList<DenialConstraint>() , assertions);
		
		try {
			chase.run();
		} catch (InconsistencyException e) {
			e.printStackTrace();
		}
		
		// Create expected canonical database
		Database expectedDb = new Database();
		
		Relation expectedRel1 = new Relation("R", 3);
		expectedDb.addRelationInstance(expectedRel1);
		
		Tuple tuple = new Tuple(3);
		tuple.addValue(Value.createVariable("z1", false));
		tuple.addValue(Value.createNumericConstant(1.0));
		tuple.addValue(Value.createStringConstant("a"));
		
		expectedRel1.addTuple(tuple);
		
		assertTrue("The canonical database does not have the expected schema", haveSameSchema(db, expectedDb));
		assertTrue("The canonical database is not the expected one", areHomomorphic(db, expectedDb));
	}

	/**
	 * Initial Input >	Instance:		empty
	 * 					Constraints:	true \subseteq R(x, y), S(y, w)
	 * 
	 * Expected Instance > R(z1, z2), S(z2, z3)
	 */
	@Test public void AssertionWithMultipleTuples() {
		
		// Populate instance
		Database db = new Database();
		
		Relation rel1 = new Relation("R", 2);
		db.addRelationInstance(rel1);

		Relation rel2 = new Relation("S", 2);
		db.addRelationInstance(rel2);
		
		// Create assertion
		Predicate pred1 = new Predicate(2);
		pred1.setFunctionHead("R");
		pred1.addVariable(Value.createVariable("x", false));
		pred1.addVariable(Value.createVariable("y", false));

		Predicate pred2 = new Predicate(2);
		pred2.setFunctionHead("S");
		pred2.addVariable(Value.createVariable("y", false));
		pred2.addVariable(Value.createVariable("w", false));
		
		Predicate head = new Predicate(0);
		
		Statement assertionConclusion = new Statement(head, new StatementJoin(new StatementScan(pred1), new StatementScan(pred2)));
		
		Assertion assertion1 = new Assertion(assertionConclusion, db);
		
		// Populate list of constraints
		ArrayList<Assertion> assertions = new ArrayList<Assertion>();
		assertions.add(assertion1);
		
		ArrayList<TupleGenConstraint> tgds = new ArrayList<TupleGenConstraint>();
		ArrayList<EqualityGenConstraint> egds = new ArrayList<EqualityGenConstraint>();
		
		// Chase
		Chase chase = new Chase(tgds, egds, new ArrayList<DenialConstraint>() , assertions);
		
		try {
			chase.run();
		} catch (InconsistencyException e) {
			e.printStackTrace();
		}
		
		// Create expected canonical database
		Database expectedDb = new Database();
		
		Relation expectedRel1 = new Relation("R", 2);
		expectedDb.addRelationInstance(expectedRel1);
		
		Relation expectedRel2 = new Relation("S", 2);
		expectedDb.addRelationInstance(expectedRel2);
		
		Tuple tuple = new Tuple(2);
		tuple.addValue(Value.createVariable("z1", false));
		tuple.addValue(Value.createVariable("z2", false));
		
		expectedRel1.addTuple(tuple);
		
		tuple = new Tuple(2);
		tuple.addValue(Value.createVariable("z2", false));
		tuple.addValue(Value.createVariable("z3", false));
		
		expectedRel2.addTuple(tuple);
		
		assertTrue("The canonical database does not have the expected schema", haveSameSchema(db, expectedDb));
		assertTrue("The canonical database is not the expected one", areHomomorphic(db, expectedDb));
	}

	/**
	 * Initial Input >	Instance:		empty
	 * 					Constraints:	true \subseteq R(x, y)
	 * 
	 * Expected Instance > R(z1, z2)
	 */
	@Test public void AssertionWithNonEmptyHead() {
		
		// Populate instance
		Database db = new Database();
		
		Relation rel1 = new Relation("R", 2);
		db.addRelationInstance(rel1);
		
		// Create assertion
		Predicate pred1 = new Predicate(2);
		pred1.setFunctionHead("R");
		pred1.addVariable(Value.createVariable("x", false));
		pred1.addVariable(Value.createVariable("y", false));
		
		Predicate head = new Predicate(2);
		head.addVariable(Value.createVariable("x", false));
		
		Statement assertionConclusion = new Statement(head, new StatementScan(pred1));
		
		Assertion assertion1 = new Assertion(assertionConclusion, db);
		
		// Populate list of constraints
		ArrayList<Assertion> assertions = new ArrayList<Assertion>();
		assertions.add(assertion1);
		
		ArrayList<TupleGenConstraint> tgds = new ArrayList<TupleGenConstraint>();
		ArrayList<EqualityGenConstraint> egds = new ArrayList<EqualityGenConstraint>();
		
		// Chase
		Chase chase = new Chase(tgds, egds, new ArrayList<DenialConstraint>() , assertions);
		
		try {
			chase.run();
		} catch (InconsistencyException e) {
			e.printStackTrace();
		}
		
		// Create expected canonical database
		Database expectedDb = new Database();
		
		Relation expectedRel1 = new Relation("R", 2);
		expectedDb.addRelationInstance(expectedRel1);
		
		Tuple tuple = new Tuple(2);
		tuple.addValue(Value.createVariable("z1", false));
		tuple.addValue(Value.createVariable("z2", false));
		
		expectedRel1.addTuple(tuple);
		
		assertTrue("The canonical database does not have the expected schema", haveSameSchema(db, expectedDb));
		assertTrue("The canonical database is not the expected one", areHomomorphic(db, expectedDb));
	}
	
	/**
	 * Initial Input >	Instance:		empty
	 * 					Constraints:	true \subseteq R(x, y)
	 * 									Q(x) :- R(x, y) \subseteq Q(x) :- S(x, y)
	 * 
	 * Expected Instance > R(z1, z2), S(z1, SK1)
	 */
	@Test public void SimpleTgd() {
		
		// Populate instance
		Database db = new Database();
		
		Relation rel1 = new Relation("R", 2);
		db.addRelationInstance(rel1);

		Relation rel2 = new Relation("S", 2);
		db.addRelationInstance(rel2);
		
		// Create assertion
		Predicate pred1 = new Predicate(2);
		pred1.setFunctionHead("R");
		pred1.addVariable(Value.createVariable("x", false));
		pred1.addVariable(Value.createVariable("y", false));
		
		Predicate head = new Predicate(0);
		
		Statement assertionConclusion = new Statement(head, new StatementScan(pred1));
		
		Assertion assertion1 = new Assertion(assertionConclusion, db);
		
		// Create tgd
		Predicate predTgd1 = new Predicate(2);
		predTgd1.setFunctionHead("R");
		predTgd1.addVariable(Value.createVariable("x", false));
		predTgd1.addVariable(Value.createVariable("y", false));
		
		Predicate predHead1 = new Predicate(1);
		predHead1.addVariable(Value.createVariable("x", false));
		
		Statement statTgd1 = new Statement(predHead1, new StatementScan(predTgd1));
		
		Predicate predTgd2 = new Predicate(2);
		predTgd2.setFunctionHead("S");
		predTgd2.addVariable(Value.createVariable("x", false));
		predTgd2.addVariable(Value.createVariable("y", false));
		
		Predicate predHead2 = new Predicate(1);
		predHead2.addVariable(Value.createVariable("x", false));

		Statement statTgd2 = new Statement(predHead2, new StatementScan(predTgd2));
		
		TupleGenConstraint tgd = new TupleGenConstraint(statTgd1, statTgd2, db);
		
		// Populate list of constraints
		ArrayList<Assertion> assertions = new ArrayList<Assertion>();
		assertions.add(assertion1);
		
		ArrayList<TupleGenConstraint> tgds = new ArrayList<TupleGenConstraint>();
		tgds.add(tgd);
		
		ArrayList<EqualityGenConstraint> egds = new ArrayList<EqualityGenConstraint>();
		
		// Chase
		Chase chase = new Chase(tgds, egds, new ArrayList<DenialConstraint>() , assertions);
		
		try {
			chase.run();
		} catch (InconsistencyException e) {
			e.printStackTrace();
		}
		
		// Create expected canonical database
		Database expectedDb = new Database();
		
		Relation expectedRel1 = new Relation("R", 2);
		expectedDb.addRelationInstance(expectedRel1);
		
		Relation expectedRel2 = new Relation("S", 2);
		expectedDb.addRelationInstance(expectedRel2);
		
		Tuple tuple = new Tuple(2);
		tuple.addValue(Value.createVariable("z1", false));
		tuple.addValue(Value.createVariable("z2", false));
		
		expectedRel1.addTuple(tuple);
		
		tuple = new Tuple(2);
		tuple.addValue(Value.createVariable("z1", false));
		tuple.addValue(Value.createVariable("newSK1", true));
		
		expectedRel2.addTuple(tuple);
		
		assertTrue("The canonical database does not have the expected schema", haveSameSchema(db, expectedDb));
		assertTrue("The canonical database is not the expected one", areHomomorphic(db, expectedDb));
	}
	
	/**
	 * Initial Input >	Instance:		empty
	 * 					Constraints:	true \subseteq R(x, y)
	 * 									Q() :- R(x, y) \subseteq Q() :- S(x, y)
	 * 
	 * Expected Instance > R(z1, z2), S(SK1, SK2)
	 */
	@Test public void TgdWithEmptyHeads() {
		
		// Populate instance
		Database db = new Database();
		
		Relation rel1 = new Relation("R", 2);
		db.addRelationInstance(rel1);

		Relation rel2 = new Relation("S", 2);
		db.addRelationInstance(rel2);
		
		// Create assertion
		Predicate pred1 = new Predicate(2);
		pred1.setFunctionHead("R");
		pred1.addVariable(Value.createVariable("x", false));
		pred1.addVariable(Value.createVariable("y", false));
		
		Predicate head = new Predicate(0);
		
		Statement assertionConclusion = new Statement(head, new StatementScan(pred1));
		
		Assertion assertion1 = new Assertion(assertionConclusion, db);
		
		// Create tgd
		Predicate predTgd1 = new Predicate(2);
		predTgd1.setFunctionHead("R");
		predTgd1.addVariable(Value.createVariable("x", false));
		predTgd1.addVariable(Value.createVariable("y", false));
		
		Predicate predHead1 = new Predicate(0);
		
		Statement statTgd1 = new Statement(predHead1, new StatementScan(predTgd1));
		
		Predicate predTgd2 = new Predicate(2);
		predTgd2.setFunctionHead("S");
		predTgd2.addVariable(Value.createVariable("x", false));
		predTgd2.addVariable(Value.createVariable("y", false));
		
		Predicate predHead2 = new Predicate(0);

		Statement statTgd2 = new Statement(predHead2, new StatementScan(predTgd2));
		
		TupleGenConstraint tgd = new TupleGenConstraint(statTgd1, statTgd2, db);
		
		// Populate list of constraints
		ArrayList<Assertion> assertions = new ArrayList<Assertion>();
		assertions.add(assertion1);
		
		ArrayList<TupleGenConstraint> tgds = new ArrayList<TupleGenConstraint>();
		tgds.add(tgd);
		
		
		ArrayList<EqualityGenConstraint> egds = new ArrayList<EqualityGenConstraint>();
		
		// Chase
		Chase chase = new Chase(tgds, egds, new ArrayList<DenialConstraint>() , assertions);
		
		try {
			chase.run();
		} catch (InconsistencyException e) {
			e.printStackTrace();
		}
		
		// Create expected canonical database
		Database expectedDb = new Database();
		
		Relation expectedRel1 = new Relation("R", 2);
		expectedDb.addRelationInstance(expectedRel1);
		
		Relation expectedRel2 = new Relation("S", 2);
		expectedDb.addRelationInstance(expectedRel2);
		
		Tuple tuple = new Tuple(2);
		tuple.addValue(Value.createVariable("z1", false));
		tuple.addValue(Value.createVariable("z2", false));
		
		expectedRel1.addTuple(tuple);
		
		tuple = new Tuple(2);
		tuple.addValue(Value.createVariable("newSK1", true));
		tuple.addValue(Value.createVariable("newSK2", true));
		
		expectedRel2.addTuple(tuple);
		
		assertTrue("The canonical database does not have the expected schema", haveSameSchema(db, expectedDb));
		assertTrue("The canonical database is not the expected one", areHomomorphic(db, expectedDb));
	}

	/**
	 * Initial Input >	Instance:		empty
	 * 					Constraints:	true \subseteq R(x, y)
	 * 									Q(3, x) :- R(x, y) \subseteq Q(x, y) :- S(x, y, z)
	 * 
	 * Expected Instance > R(z1, z2), S(3, z1, SK1)
	 */	
	@Test public void TgdWithConstantInSourceHead() {
		
		// Populate instance
		Database db = new Database();
		
		Relation rel1 = new Relation("R", 2);
		db.addRelationInstance(rel1);

		Relation rel2 = new Relation("S", 3);
		db.addRelationInstance(rel2);
		
		// Create assertion
		Predicate pred1 = new Predicate(2);
		pred1.setFunctionHead("R");
		pred1.addVariable(Value.createVariable("x", false));
		pred1.addVariable(Value.createVariable("y", false));
		
		Predicate head = new Predicate(0);
		
		Statement assertionConclusion = new Statement(head, new StatementScan(pred1));
		
		Assertion assertion1 = new Assertion(assertionConclusion, db);
		
		// Create tgd
		Predicate predTgd1 = new Predicate(2);
		predTgd1.setFunctionHead("R");
		predTgd1.addVariable(Value.createVariable("x", false));
		predTgd1.addVariable(Value.createVariable("y", false));
		
		Predicate predHead1 = new Predicate(2);
		predHead1.addVariable(Value.createNumericConstant(3.0));
		predHead1.addVariable(Value.createVariable("x", false));
		
		Statement statTgd1 = new Statement(predHead1, new StatementScan(predTgd1));
		
		Predicate predTgd2 = new Predicate(3);
		predTgd2.setFunctionHead("S");
		predTgd2.addVariable(Value.createVariable("x", false));
		predTgd2.addVariable(Value.createVariable("y", false));
		predTgd2.addVariable(Value.createVariable("z", false));
		
		Predicate predHead2 = new Predicate(2);
		predHead2.addVariable(Value.createVariable("x", false));
		predHead2.addVariable(Value.createVariable("y", false));
		
		Statement statTgd2 = new Statement(predHead2, new StatementScan(predTgd2));
		
		TupleGenConstraint tgd = new TupleGenConstraint(statTgd1, statTgd2, db);
		
		// Populate list of constraints
		ArrayList<Assertion> assertions = new ArrayList<Assertion>();
		assertions.add(assertion1);
		
		ArrayList<TupleGenConstraint> tgds = new ArrayList<TupleGenConstraint>();
		tgds.add(tgd);
		
		
		ArrayList<EqualityGenConstraint> egds = new ArrayList<EqualityGenConstraint>();
		
		// Chase
		Chase chase = new Chase(tgds, egds, new ArrayList<DenialConstraint>() , assertions);
		
		try {
			chase.run();
		} catch (InconsistencyException e) {
			e.printStackTrace();
		}
		
		// Create expected canonical database
		Database expectedDb = new Database();
		
		Relation expectedRel1 = new Relation("R", 2);
		expectedDb.addRelationInstance(expectedRel1);
		
		Relation expectedRel2 = new Relation("S", 3);
		expectedDb.addRelationInstance(expectedRel2);
		
		Tuple tuple = new Tuple(2);
		tuple.addValue(Value.createVariable("z1", false));
		tuple.addValue(Value.createVariable("z2", false));
		
		expectedRel1.addTuple(tuple);
		
		tuple = new Tuple(3);
		tuple.addValue(Value.createNumericConstant(3.0));
		tuple.addValue(Value.createVariable("z1", false));
		tuple.addValue(Value.createVariable("newSK1", true));
		
		expectedRel2.addTuple(tuple);
		
		assertTrue("The canonical database does not have the expected schema", haveSameSchema(db, expectedDb));
		assertTrue("The canonical database is not the expected one", areHomomorphic(db, expectedDb));		
	}

	/**
	 * Initial Input >	Instance:		empty
	 * 					Constraints:	true \subseteq R(x, y)
	 * 									Q(3, 4) :- R(x, y) \subseteq Q(x, x) :- S(x, y)
	 * 
	 * Expected Instance > Inconsistency
	 */		
	@Test public void TgdWithInconsistency1() {
		 
	}

	/**
	 * Initial Input >	Instance:		empty
	 * 					Constraints:	true \subseteq R(x, y)
	 * 									Q(3) :- R(x, y) \subseteq Q(3) :- S(x, y)
	 * 
	 * Expected Instance > R(z1, z2), S(SK1, SK2)
	 */		
	@Test public void TgdWithConstantsInBothHeads1() {
		
		// Populate instance
		Database db = new Database();
		
		Relation rel1 = new Relation("R", 2);
		db.addRelationInstance(rel1);

		Relation rel2 = new Relation("S", 2);
		db.addRelationInstance(rel2);
		
		// Create assertion
		Predicate pred1 = new Predicate(2);
		pred1.setFunctionHead("R");
		pred1.addVariable(Value.createVariable("x", false));
		pred1.addVariable(Value.createVariable("y", false));
		
		Predicate head = new Predicate(0);
		
		Statement assertionConclusion = new Statement(head, new StatementScan(pred1));
		
		Assertion assertion1 = new Assertion(assertionConclusion, db);
		
		// Create tgd
		Predicate predTgd1 = new Predicate(2);
		predTgd1.setFunctionHead("R");
		predTgd1.addVariable(Value.createVariable("x", false));
		predTgd1.addVariable(Value.createVariable("y", false));
		
		Predicate predHead1 = new Predicate(1);
		predHead1.addVariable(Value.createNumericConstant(3.0));
		
		Statement statTgd1 = new Statement(predHead1, new StatementScan(predTgd1));
		
		Predicate predTgd2 = new Predicate(2);
		predTgd2.setFunctionHead("S");
		predTgd2.addVariable(Value.createVariable("x", false));
		predTgd2.addVariable(Value.createVariable("y", false));
		
		Predicate predHead2 = new Predicate(1);
		predHead2.addVariable(Value.createNumericConstant(3.0));
		
		Statement statTgd2 = new Statement(predHead2, new StatementScan(predTgd2));
		
		TupleGenConstraint tgd = new TupleGenConstraint(statTgd1, statTgd2, db);
		
		// Populate list of constraints
		ArrayList<Assertion> assertions = new ArrayList<Assertion>();
		assertions.add(assertion1);
		
		ArrayList<TupleGenConstraint> tgds = new ArrayList<TupleGenConstraint>();
		tgds.add(tgd);
		
		
		ArrayList<EqualityGenConstraint> egds = new ArrayList<EqualityGenConstraint>();
		
		// Chase
		Chase chase = new Chase(tgds, egds, new ArrayList<DenialConstraint>() , assertions);
		
		try {
			chase.run();
		} catch (InconsistencyException e) {
			e.printStackTrace();
		}
		
		// Create expected canonical database
		Database expectedDb = new Database();
		
		Relation expectedRel1 = new Relation("R", 2);
		expectedDb.addRelationInstance(expectedRel1);
		
		Relation expectedRel2 = new Relation("S", 2);
		expectedDb.addRelationInstance(expectedRel2);
		
		Tuple tuple = new Tuple(2);
		tuple.addValue(Value.createVariable("z1", false));
		tuple.addValue(Value.createVariable("z2", false));
		
		expectedRel1.addTuple(tuple);
		
		tuple = new Tuple(2);
		tuple.addValue(Value.createVariable("newSK1", true));
		tuple.addValue(Value.createVariable("newSK2", true));
		
		expectedRel2.addTuple(tuple);
		
		assertTrue("The canonical database does not have the expected schema", haveSameSchema(db, expectedDb));
		assertTrue("The canonical database is not the expected one", areHomomorphic(db, expectedDb));			 
	}

	/**
	 * Initial Input >	Instance:		empty
	 * 					Constraints:	true \subseteq R(x, y)
	 * 									Q(3) :- R(x, y) \subseteq Q(4) :- S(x, y)
	 * 
	 * Expected Instance > Inconsistency
	 */		
	@Test public void TgdWithConstantsInBothHeads2() {
			 
	}
	
	/**
	 * Initial Input >	Instance:		empty
	 * 					Constraints:	true \subseteq R(x, y)
	 * 									Q(x) :- R(x, y) \subseteq Q(4) :- S(x, y)
	 * 
	 * Expected Instance > R(z1, z2), S(SK1, SK2)?
	 */		
	@Test public void TgdWithConstantsInTargetHead() {
		
	}

	/**
	 * Initial Input >	Instance:		empty
	 * 					Constraints:	true \subseteq R(x, y)
	 * 									Q(x, x) :- R(x, y) \subseteq Q(x, y) :- S(x, y)
	 * 
	 * Expected Instance > R(z1, z2), S(z1, z1)
	 */
	@Test public void TgdWithMultipleOccursOfVarInSourceHead() {
		
		// Populate instance
		Database db = new Database();
		
		Relation rel1 = new Relation("R", 2);
		db.addRelationInstance(rel1);

		Relation rel2 = new Relation("S", 2);
		db.addRelationInstance(rel2);
		
		// Create assertion
		Predicate pred1 = new Predicate(2);
		pred1.setFunctionHead("R");
		pred1.addVariable(Value.createVariable("x", false));
		pred1.addVariable(Value.createVariable("y", false));
		
		Predicate head = new Predicate(0);
		
		Statement assertionConclusion = new Statement(head, new StatementScan(pred1));
		
		Assertion assertion1 = new Assertion(assertionConclusion, db);
		
		// Create tgd
		Predicate predTgd1 = new Predicate(2);
		predTgd1.setFunctionHead("R");
		predTgd1.addVariable(Value.createVariable("x", false));
		predTgd1.addVariable(Value.createVariable("y", false));
		
		Predicate predHead1 = new Predicate(2);
		predHead1.addVariable(Value.createVariable("x", false));
		predHead1.addVariable(Value.createVariable("x", false));
		
		Statement statTgd1 = new Statement(predHead1, new StatementScan(predTgd1));
		
		Predicate predTgd2 = new Predicate(2);
		predTgd2.setFunctionHead("S");
		predTgd2.addVariable(Value.createVariable("x", false));
		predTgd2.addVariable(Value.createVariable("y", false));
		
		Predicate predHead2 = new Predicate(2);
		predHead2.addVariable(Value.createVariable("x", false));
		predHead2.addVariable(Value.createVariable("y", false));
		
		Statement statTgd2 = new Statement(predHead2, new StatementScan(predTgd2));
		
		TupleGenConstraint tgd = new TupleGenConstraint(statTgd1, statTgd2, db);
		
		// Populate list of constraints
		ArrayList<Assertion> assertions = new ArrayList<Assertion>();
		assertions.add(assertion1);
		
		ArrayList<TupleGenConstraint> tgds = new ArrayList<TupleGenConstraint>();
		tgds.add(tgd);
		
		
		ArrayList<EqualityGenConstraint> egds = new ArrayList<EqualityGenConstraint>();
		
		// Chase
		Chase chase = new Chase(tgds, egds, new ArrayList<DenialConstraint>() , assertions);
		
		try {
			chase.run();
		} catch (InconsistencyException e) {
			e.printStackTrace();
		}
		
		// Create expected canonical database
		Database expectedDb = new Database();
		
		Relation expectedRel1 = new Relation("R", 2);
		expectedDb.addRelationInstance(expectedRel1);
		
		Relation expectedRel2 = new Relation("S", 2);
		expectedDb.addRelationInstance(expectedRel2);
		
		Tuple tuple = new Tuple(2);
		tuple.addValue(Value.createVariable("z1", false));
		tuple.addValue(Value.createVariable("z2", false));
		
		expectedRel1.addTuple(tuple);
		
		tuple = new Tuple(2);
		tuple.addValue(Value.createVariable("z1", false));
		tuple.addValue(Value.createVariable("z1", false));
		
		expectedRel2.addTuple(tuple);
		
		assertTrue("The canonical database does not have the expected schema", haveSameSchema(db, expectedDb));
		assertTrue("The canonical database is not the expected one", areHomomorphic(db, expectedDb));		
	}

	/**
	 * Initial Input >	Instance:		empty
	 * 					Constraints:	true \subseteq R(x, y)
	 * 									Q(x, x) :- R(x, y) \subseteq Q(x, x) :- S(x, y)
	 * 
	 * Expected Instance > R(z1, z2), S(z1, SK1)
	 */
	@Test public void TgdWithMultipleOccursOfVarInBothHeads() {
		
		// Populate instance
		Database db = new Database();
		
		Relation rel1 = new Relation("R", 2);
		db.addRelationInstance(rel1);

		Relation rel2 = new Relation("S", 2);
		db.addRelationInstance(rel2);
		
		// Create assertion
		Predicate pred1 = new Predicate(2);
		pred1.setFunctionHead("R");
		pred1.addVariable(Value.createVariable("x", false));
		pred1.addVariable(Value.createVariable("y", false));
		
		Predicate head = new Predicate(0);
		
		Statement assertionConclusion = new Statement(head, new StatementScan(pred1));
		
		Assertion assertion1 = new Assertion(assertionConclusion, db);
		
		// Create tgd
		Predicate predTgd1 = new Predicate(2);
		predTgd1.setFunctionHead("R");
		predTgd1.addVariable(Value.createVariable("x", false));
		predTgd1.addVariable(Value.createVariable("y", false));
		
		Predicate predHead1 = new Predicate(2);
		predHead1.addVariable(Value.createVariable("x", false));
		predHead1.addVariable(Value.createVariable("x", false));
		
		Statement statTgd1 = new Statement(predHead1, new StatementScan(predTgd1));
		
		Predicate predTgd2 = new Predicate(2);
		predTgd2.setFunctionHead("S");
		predTgd2.addVariable(Value.createVariable("x", false));
		predTgd2.addVariable(Value.createVariable("y", false));
		
		Predicate predHead2 = new Predicate(2);
		predHead2.addVariable(Value.createVariable("x", false));
		predHead2.addVariable(Value.createVariable("x", false));
		
		Statement statTgd2 = new Statement(predHead2, new StatementScan(predTgd2));
		
		TupleGenConstraint tgd = new TupleGenConstraint(statTgd1, statTgd2, db);
		
		// Populate list of constraints
		ArrayList<Assertion> assertions = new ArrayList<Assertion>();
		assertions.add(assertion1);
		
		ArrayList<TupleGenConstraint> tgds = new ArrayList<TupleGenConstraint>();
		tgds.add(tgd);
		
		
		ArrayList<EqualityGenConstraint> egds = new ArrayList<EqualityGenConstraint>();
		
		// Chase
		Chase chase = new Chase(tgds, egds, new ArrayList<DenialConstraint>() , assertions);
		
		try {
			chase.run();
		} catch (InconsistencyException e) {
			e.printStackTrace();
		}
		
		// Create expected canonical database
		Database expectedDb = new Database();
		
		Relation expectedRel1 = new Relation("R", 2);
		expectedDb.addRelationInstance(expectedRel1);
		
		Relation expectedRel2 = new Relation("S", 2);
		expectedDb.addRelationInstance(expectedRel2);
		
		Tuple tuple = new Tuple(2);
		tuple.addValue(Value.createVariable("z1", false));
		tuple.addValue(Value.createVariable("z2", false));
		
		expectedRel1.addTuple(tuple);
		
		tuple = new Tuple(2);
		tuple.addValue(Value.createVariable("z1", false));
		tuple.addValue(Value.createVariable("newSK1", true));
		
		expectedRel2.addTuple(tuple);
		
		assertTrue("The canonical database does not have the expected schema", haveSameSchema(db, expectedDb));
		assertTrue("The canonical database is not the expected one", areHomomorphic(db, expectedDb));		
	}	
	
	/**
	 * Initial Input >	Instance:		empty
	 * 					Constraints:	true \subseteq R(x, y)
	 * 									Q(x, y) :- R(x, y) \subseteq Q(x, y) :- S(x, y), R(y, x)
	 * 
	 * Expected Instance > R(z1, z2), S(z1, z2), R(z2, z1), S(z2, z1)
	 */
	@Test public void TgdWithTargetJoin() {
		
		// Populate instance
		Database db = new Database();
		
		Relation rel1 = new Relation("R", 2);
		db.addRelationInstance(rel1);

		Relation rel2 = new Relation("S", 2);
		db.addRelationInstance(rel2);
		
		// Create assertion
		Predicate pred1 = new Predicate(2);
		pred1.setFunctionHead("R");
		pred1.addVariable(Value.createVariable("x", false));
		pred1.addVariable(Value.createVariable("y", false));
		
		Predicate head = new Predicate(0);
		
		Statement assertionConclusion = new Statement(head, new StatementScan(pred1));
		
		Assertion assertion1 = new Assertion(assertionConclusion, db);
		
		// Create tgd
		Predicate predTgd1 = new Predicate(2);
		predTgd1.setFunctionHead("R");
		predTgd1.addVariable(Value.createVariable("x", false));
		predTgd1.addVariable(Value.createVariable("y", false));
		
		Predicate predHead1 = new Predicate(2);
		predHead1.addVariable(Value.createVariable("x", false));
		predHead1.addVariable(Value.createVariable("y", false));
		
		Statement statTgd1 = new Statement(predHead1, new StatementScan(predTgd1));
		
		Predicate predTgd2a = new Predicate(2);
		predTgd2a.setFunctionHead("S");
		predTgd2a.addVariable(Value.createVariable("x", false));
		predTgd2a.addVariable(Value.createVariable("y", false));
		
		Predicate predTgd2b = new Predicate(2);
		predTgd2b.setFunctionHead("R");
		predTgd2b.addVariable(Value.createVariable("y", false));
		predTgd2b.addVariable(Value.createVariable("x", false));
		
		Predicate predHead2 = new Predicate(2);
		predHead2.addVariable(Value.createVariable("x", false));
		predHead2.addVariable(Value.createVariable("y", false));
		
		Statement statTgd2 = new Statement(predHead2, new StatementJoin(new StatementScan(predTgd2a), new StatementScan(predTgd2b)));
		
		TupleGenConstraint tgd = new TupleGenConstraint(statTgd1, statTgd2, db);
		
		// Populate list of constraints
		ArrayList<Assertion> assertions = new ArrayList<Assertion>();
		assertions.add(assertion1);
		
		ArrayList<TupleGenConstraint> tgds = new ArrayList<TupleGenConstraint>();
		tgds.add(tgd);
		
		
		ArrayList<EqualityGenConstraint> egds = new ArrayList<EqualityGenConstraint>();
		
		// Chase
		Chase chase = new Chase(tgds, egds, new ArrayList<DenialConstraint>() , assertions);
		
		try {
			chase.run();
		} catch (InconsistencyException e) {
			e.printStackTrace();
		}
		
		// Create expected canonical database
		Database expectedDb = new Database();
		
		Relation expectedRel1 = new Relation("R", 2);
		expectedDb.addRelationInstance(expectedRel1);
		
		Relation expectedRel2 = new Relation("S", 2);
		expectedDb.addRelationInstance(expectedRel2);
		
		Tuple tuple = new Tuple(2);
		tuple.addValue(Value.createVariable("z1", false));
		tuple.addValue(Value.createVariable("z2", false));
		
		expectedRel1.addTuple(tuple);
		
		tuple = new Tuple(2);
		tuple.addValue(Value.createVariable("z2", false));
		tuple.addValue(Value.createVariable("z1", false));
		
		expectedRel1.addTuple(tuple);
		
		tuple = new Tuple(2);
		tuple.addValue(Value.createVariable("z1", false));
		tuple.addValue(Value.createVariable("z2", false));
		
		expectedRel2.addTuple(tuple);

		tuple = new Tuple(2);
		tuple.addValue(Value.createVariable("z2", false));
		tuple.addValue(Value.createVariable("z1", false));
		
		expectedRel2.addTuple(tuple);
		
		assertTrue("The canonical database does not have the expected schema", haveSameSchema(db, expectedDb));
		assertTrue("The canonical database is not the expected one", areHomomorphic(db, expectedDb));		
	}
	
	/**
	 * Initial Input >	Instance:		empty
	 * 					Constraints:	true \subseteq R(4, y)
	 * 									Q(x, 3) :- R(x, y) \subseteq Q(x, y) :- S(x, y), R(y, x)
	 * 
	 * Expected Instance > R(4, z2), S(4, 3), R(3, 4), S(3, 3), R(3, 3)
	 */
	@Test public void TgdWithTargetJoinAndConstantInTheSourceHead() {
		
		// Populate instance
		Database db = new Database();
		
		Relation rel1 = new Relation("R", 2);
		db.addRelationInstance(rel1);

		Relation rel2 = new Relation("S", 2);
		db.addRelationInstance(rel2);
		
		// Create assertion
		Predicate pred1 = new Predicate(2);
		pred1.setFunctionHead("R");
		pred1.addVariable(Value.createNumericConstant(4.0));
		pred1.addVariable(Value.createVariable("y", false));
		
		Predicate head = new Predicate(0);
		
		Statement assertionConclusion = new Statement(head, new StatementScan(pred1));
		
		Assertion assertion1 = new Assertion(assertionConclusion, db);
		
		// Create tgd
		Predicate predTgd1 = new Predicate(2);
		predTgd1.setFunctionHead("R");
		predTgd1.addVariable(Value.createVariable("x", false));
		predTgd1.addVariable(Value.createVariable("y", false));
		
		Predicate predHead1 = new Predicate(2);
		predHead1.addVariable(Value.createVariable("x", false));
		predHead1.addVariable(Value.createNumericConstant(3.0));
		
		Statement statTgd1 = new Statement(predHead1, new StatementScan(predTgd1));
		
		Predicate predTgd2a = new Predicate(2);
		predTgd2a.setFunctionHead("S");
		predTgd2a.addVariable(Value.createVariable("x", false));
		predTgd2a.addVariable(Value.createVariable("y", false));
		
		Predicate predTgd2b = new Predicate(2);
		predTgd2b.setFunctionHead("R");
		predTgd2b.addVariable(Value.createVariable("y", false));
		predTgd2b.addVariable(Value.createVariable("x", false));
		
		Predicate predHead2 = new Predicate(2);
		predHead2.addVariable(Value.createVariable("x", false));
		predHead2.addVariable(Value.createVariable("y", false));
		
		Statement statTgd2 = new Statement(predHead2, new StatementJoin(new StatementScan(predTgd2a), new StatementScan(predTgd2b)));
		
		TupleGenConstraint tgd = new TupleGenConstraint(statTgd1, statTgd2, db);
		
		// Populate list of constraints
		ArrayList<Assertion> assertions = new ArrayList<Assertion>();
		assertions.add(assertion1);
		
		ArrayList<TupleGenConstraint> tgds = new ArrayList<TupleGenConstraint>();
		tgds.add(tgd);
		
		
		ArrayList<EqualityGenConstraint> egds = new ArrayList<EqualityGenConstraint>();
		
		// Chase
		Chase chase = new Chase(tgds, egds, new ArrayList<DenialConstraint>() , assertions);
		
		try {
			chase.run();
		} catch (InconsistencyException e) {
			e.printStackTrace();
		}
		
		// Create expected canonical database
		Database expectedDb = new Database();
		
		Relation expectedRel1 = new Relation("R", 2);
		expectedDb.addRelationInstance(expectedRel1);
		
		Relation expectedRel2 = new Relation("S", 2);
		expectedDb.addRelationInstance(expectedRel2);
		
		Tuple tuple = new Tuple(2);
		tuple.addValue(Value.createNumericConstant(4.0));
		tuple.addValue(Value.createVariable("z2", false));
		
		expectedRel1.addTuple(tuple);
		
		tuple = new Tuple(2);
		tuple.addValue(Value.createNumericConstant(3.0));
		tuple.addValue(Value.createNumericConstant(4.0));
		
		expectedRel1.addTuple(tuple);

		tuple = new Tuple(2);
		tuple.addValue(Value.createNumericConstant(3.0));
		tuple.addValue(Value.createNumericConstant(3.0));
		
		expectedRel1.addTuple(tuple);
		
		tuple = new Tuple(2);
		tuple.addValue(Value.createNumericConstant(4.0));
		tuple.addValue(Value.createNumericConstant(3.0));
		
		expectedRel2.addTuple(tuple);

		tuple = new Tuple(2);
		tuple.addValue(Value.createNumericConstant(3.0));
		tuple.addValue(Value.createNumericConstant(3.0));
		
		expectedRel2.addTuple(tuple);
		
		assertTrue("The canonical database does not have the expected schema", haveSameSchema(db, expectedDb));
		assertTrue("The canonical database is not the expected one", areHomomorphic(db, expectedDb));		
	}

	/**
	 * Initial Input >	Instance:		empty
	 * 					Constraints:	true \subseteq R(x, y)
	 * 									Q(x, y) :- R(x, y) \subseteq Q(x, y) :- S(x, z), R(z, y)
	 * 
	 * Expected Instance > R(z1, z2), S(z1, SK1), R(SK1, z2)
	 */
	@Test public void TgdWithLoop() {
		
	}
	
	/**
	 * Initial Input >	Instance:		empty
	 * 					Constraints:	true \subseteq R(x, y)
	 * 									Q(x, y) :- R(x, y) \subseteq Q(x, y) :- S(x, z), S(z, y)
	 * 
	 * Expected Instance > R(z1, z2), S(z1, SK1), S(SK1, z2)
	 */
	@Test public void TgdWithExistentialTargetJoin() {
		
		// Populate instance
		Database db = new Database();
		
		Relation rel1 = new Relation("R", 2);
		db.addRelationInstance(rel1);

		Relation rel2 = new Relation("S", 2);
		db.addRelationInstance(rel2);
		
		// Create assertion
		Predicate pred1 = new Predicate(2);
		pred1.setFunctionHead("R");
		pred1.addVariable(Value.createVariable("x", false));
		pred1.addVariable(Value.createVariable("y", false));
		
		Predicate head = new Predicate(0);
		
		Statement assertionConclusion = new Statement(head, new StatementScan(pred1));
		
		Assertion assertion1 = new Assertion(assertionConclusion, db);
		
		// Create tgd
		Predicate predTgd1 = new Predicate(2);
		predTgd1.setFunctionHead("R");
		predTgd1.addVariable(Value.createVariable("x", false));
		predTgd1.addVariable(Value.createVariable("y", false));
		
		Predicate predHead1 = new Predicate(2);
		predHead1.addVariable(Value.createVariable("x", false));
		predHead1.addVariable(Value.createVariable("y", false));
		
		Statement statTgd1 = new Statement(predHead1, new StatementScan(predTgd1));
		
		Predicate predTgd2a = new Predicate(2);
		predTgd2a.setFunctionHead("S");
		predTgd2a.addVariable(Value.createVariable("x", false));
		predTgd2a.addVariable(Value.createVariable("z", false));
		
		Predicate predTgd2b = new Predicate(2);
		predTgd2b.setFunctionHead("S");
		predTgd2b.addVariable(Value.createVariable("z", false));
		predTgd2b.addVariable(Value.createVariable("y", false));
		
		Predicate predHead2 = new Predicate(2);
		predHead2.addVariable(Value.createVariable("x", false));
		predHead2.addVariable(Value.createVariable("y", false));
		
		Statement statTgd2 = new Statement(predHead2, new StatementJoin(new StatementScan(predTgd2a), new StatementScan(predTgd2b)));
		
		TupleGenConstraint tgd = new TupleGenConstraint(statTgd1, statTgd2, db);
		
		// Populate list of constraints
		ArrayList<Assertion> assertions = new ArrayList<Assertion>();
		assertions.add(assertion1);
		
		ArrayList<TupleGenConstraint> tgds = new ArrayList<TupleGenConstraint>();
		tgds.add(tgd);
		
		
		ArrayList<EqualityGenConstraint> egds = new ArrayList<EqualityGenConstraint>();
		
		// Chase
		Chase chase = new Chase(tgds, egds, new ArrayList<DenialConstraint>() , assertions);
		
		try {
			chase.run();
		} catch (InconsistencyException e) {
			e.printStackTrace();
		}
		
		// Create expected canonical database
		Database expectedDb = new Database();
		
		Relation expectedRel1 = new Relation("R", 2);
		expectedDb.addRelationInstance(expectedRel1);
		
		Relation expectedRel2 = new Relation("S", 2);
		expectedDb.addRelationInstance(expectedRel2);
		
		Tuple tuple = new Tuple(2);
		tuple.addValue(Value.createVariable("z1", false));
		tuple.addValue(Value.createVariable("z2", false));
		
		expectedRel1.addTuple(tuple);
		
		tuple = new Tuple(2);
		tuple.addValue(Value.createVariable("z1", false));
		tuple.addValue(Value.createVariable("newSK1", true));
		
		expectedRel2.addTuple(tuple);

		tuple = new Tuple(2);
		tuple.addValue(Value.createVariable("newSK1", true));
		tuple.addValue(Value.createVariable("z2", false));
		
		expectedRel2.addTuple(tuple);
		
		assertTrue("The canonical database does not have the expected schema", haveSameSchema(db, expectedDb));
		assertTrue("The canonical database is not the expected one", areHomomorphic(db, expectedDb));		
	}
	
	/**
	 * Initial Input >	Instance:		empty
	 * 					Constraints:	true \subseteq R(x, y)
	 * 									Q(x) :- R(x, y) \subseteq Q(x) :- R(x, y)
	 * 
	 * Expected Instance > R(z1, z2)
	 */	
	@Test public void TgdWithNoEffect() {
		
		// Populate instance
		Database db = new Database();
		
		Relation rel1 = new Relation("R", 2);
		db.addRelationInstance(rel1);
		
		// Create assertion
		Predicate pred1 = new Predicate(2);
		pred1.setFunctionHead("R");
		pred1.addVariable(Value.createVariable("x", false));
		pred1.addVariable(Value.createVariable("y", false));
		
		Predicate head = new Predicate(0);
		
		Statement assertionConclusion = new Statement(head, new StatementScan(pred1));
		
		Assertion assertion1 = new Assertion(assertionConclusion, db);
		
		// Create tgd
		Predicate predTgd1 = new Predicate(2);
		predTgd1.setFunctionHead("R");
		predTgd1.addVariable(Value.createVariable("x", false));
		predTgd1.addVariable(Value.createVariable("y", false));
		
		Predicate predHead1 = new Predicate(1);
		predHead1.addVariable(Value.createVariable("x", false));
		
		Statement statTgd1 = new Statement(predHead1, new StatementScan(predTgd1));
		
		Predicate predTgd2 = new Predicate(2);
		predTgd2.setFunctionHead("R");
		predTgd2.addVariable(Value.createVariable("x", false));
		predTgd2.addVariable(Value.createVariable("y", false));
		
		Predicate predHead2 = new Predicate(1);
		predHead2.addVariable(Value.createVariable("x", false));
		
		Statement statTgd2 = new Statement(predHead2, new StatementScan(predTgd2));
		
		TupleGenConstraint tgd = new TupleGenConstraint(statTgd1, statTgd2, db);
		
		// Populate list of constraints
		ArrayList<Assertion> assertions = new ArrayList<Assertion>();
		assertions.add(assertion1);
		
		ArrayList<TupleGenConstraint> tgds = new ArrayList<TupleGenConstraint>();
		tgds.add(tgd);
		
		
		ArrayList<EqualityGenConstraint> egds = new ArrayList<EqualityGenConstraint>();
		
		// Chase
		Chase chase = new Chase(tgds, egds, new ArrayList<DenialConstraint>() , assertions);
		
		try {
			chase.run();
		} catch (InconsistencyException e) {
			e.printStackTrace();
		}
		
		// Create expected canonical database
		Database expectedDb = new Database();
		
		Relation expectedRel1 = new Relation("R", 2);
		expectedDb.addRelationInstance(expectedRel1);
		
		Tuple tuple = new Tuple(2);
		tuple.addValue(Value.createVariable("z1", false));
		tuple.addValue(Value.createVariable("z2", false));
		
		expectedRel1.addTuple(tuple);
		
		assertTrue("The canonical database does not have the expected schema", haveSameSchema(db, expectedDb));
		assertTrue("The canonical database is not the expected one", areHomomorphic(db, expectedDb));			
	}

	/**
	 * Initial Input >	Instance:		empty
	 * 					Constraints:	true \subseteq R(x, y)
	 * 									Q(x) :- R(x, 3) \subseteq Q(x) :- S(x, y)
	 * 
	 * Expected Instance > R(z1, z2)
	 */	
	/*
	@Test public void TgdWithConstantsInTheSource1() {
		
		// Populate instance
		Database db = new Database();
		
		Relation rel1 = new Relation("R", 2);
		db.addRelationInstance(rel1);

		Relation rel2 = new Relation("S", 2);
		db.addRelationInstance(rel2);
		
		// Create assertion
		Predicate pred1 = new Predicate(2);
		pred1.setFunctionHead("R");
		pred1.addVariable(Value.createVariable("x", false));
		pred1.addVariable(Value.createVariable("y", false));
		
		Predicate head = new Predicate(0);
		
		Statement assertionConclusion = new Statement(head, new StatementScan(pred1));
		
		Assertion assertion1 = new Assertion(assertionConclusion, db);
		
		// Create tgd
		Predicate predTgd1 = new Predicate(2);
		predTgd1.setFunctionHead("R");
		predTgd1.addVariable(Value.createVariable("x", false));
		predTgd1.addVariable(Value.createNumericConstant(3.0));
		
		Predicate predHead1 = new Predicate(1);
		predHead1.addVariable(Value.createVariable("x", false));
		
		Statement statTgd1 = new Statement(predHead1, new StatementScan(predTgd1));
		
		Predicate predTgd2 = new Predicate(3);
		predTgd2.setFunctionHead("S");
		predTgd2.addVariable(Value.createVariable("x", false));
		predTgd2.addVariable(Value.createVariable("y", false));
		
		Predicate predHead2 = new Predicate(1);
		predHead2.addVariable(Value.createVariable("x", false));
		
		Statement statTgd2 = new Statement(predHead2, new StatementScan(predTgd2));
		
		TupleGenConstraint tgd = new TupleGenConstraint(statTgd1, statTgd2, db);
		
		// Populate list of constraints
		ArrayList<Assertion> assertions = new ArrayList<Assertion>();
		assertions.add(assertion1);
		
		ArrayList<TupleGenConstraint> tgds = new ArrayList<TupleGenConstraint>();
		tgds.add(tgd);
		
		
		ArrayList<EqualityGenConstraint> egds = new ArrayList<EqualityGenConstraint>();
		
		// Chase
		Chase chase = new Chase(tgds, egds, assertions);
		
		try {
			chase.run();
		} catch (InconsistencyException e) {
			e.printStackTrace();
		}
		
		// Create expected canonical database
		Database expectedDb = new Database();
		
		Relation expectedRel1 = new Relation("R", 2);
		expectedDb.addRelationInstance(expectedRel1);
		
		Relation expectedRel2 = new Relation("S", 2);
		expectedDb.addRelationInstance(expectedRel2);
		
		Tuple tuple = new Tuple(2);
		tuple.addValue(Value.createVariable("z1", false));
		tuple.addValue(Value.createVariable("z2", false));
		
		expectedRel1.addTuple(tuple);
		
		assertTrue("The canonical database does not have the expected schema", haveSameSchema(db, expectedDb));
		assertTrue("The canonical database is not the expected one", areHomomorphic(db, expectedDb));		
	}
	*/

	/**
	 * Initial Input >	Instance:		empty
	 * 					Constraints:	true \subseteq R(x, 3)
	 * 									Q(x) :- R(x, 3) \subseteq Q(x) :- S(x, y)
	 * 
	 * Expected Instance > R(z1, 3), S(z1, SK1)
	 */	
	@Test public void TgdWithConstantsInTheSource2() {
		
		// Populate instance
		Database db = new Database();
		
		Relation rel1 = new Relation("R", 2);
		db.addRelationInstance(rel1);

		Relation rel2 = new Relation("S", 2);
		db.addRelationInstance(rel2);
		
		// Create assertion
		Predicate pred1 = new Predicate(2);
		pred1.setFunctionHead("R");
		pred1.addVariable(Value.createVariable("x", false));
		pred1.addVariable(Value.createNumericConstant(3.0));
		
		Predicate head = new Predicate(0);
		
		Statement assertionConclusion = new Statement(head, new StatementScan(pred1));
		
		Assertion assertion1 = new Assertion(assertionConclusion, db);
		
		// Create tgd
		Predicate predTgd1 = new Predicate(2);
		predTgd1.setFunctionHead("R");
		predTgd1.addVariable(Value.createVariable("x", false));
		predTgd1.addVariable(Value.createNumericConstant(3.0));
		
		Predicate predHead1 = new Predicate(1);
		predHead1.addVariable(Value.createVariable("x", false));
		
		Statement statTgd1 = new Statement(predHead1, new StatementScan(predTgd1));
		
		Predicate predTgd2 = new Predicate(2);
		predTgd2.setFunctionHead("S");
		predTgd2.addVariable(Value.createVariable("x", false));
		predTgd2.addVariable(Value.createVariable("y", false));
		
		Predicate predHead2 = new Predicate(1);
		predHead2.addVariable(Value.createVariable("x", false));
		
		Statement statTgd2 = new Statement(predHead2, new StatementScan(predTgd2));
		
		TupleGenConstraint tgd = new TupleGenConstraint(statTgd1, statTgd2, db);
		
		// Populate list of constraints
		ArrayList<Assertion> assertions = new ArrayList<Assertion>();
		assertions.add(assertion1);
		
		ArrayList<TupleGenConstraint> tgds = new ArrayList<TupleGenConstraint>();
		tgds.add(tgd);
		
		
		ArrayList<EqualityGenConstraint> egds = new ArrayList<EqualityGenConstraint>();
		
		// Chase
		Chase chase = new Chase(tgds, egds, new ArrayList<DenialConstraint>() , assertions);
		
		try {
			chase.run();
		} catch (InconsistencyException e) {
			e.printStackTrace();
		}
		
		// Create expected canonical database
		Database expectedDb = new Database();
		
		Relation expectedRel1 = new Relation("R", 2);
		expectedDb.addRelationInstance(expectedRel1);
		
		Relation expectedRel2 = new Relation("S", 2);
		expectedDb.addRelationInstance(expectedRel2);
		
		Tuple tuple = new Tuple(2);
		tuple.addValue(Value.createVariable("z1", false));
		tuple.addValue(Value.createNumericConstant(3.0));
		
		expectedRel1.addTuple(tuple);
		
		tuple = new Tuple(2);
		tuple.addValue(Value.createVariable("z1", false));
		tuple.addValue(Value.createVariable("newSK1", true));
		
		expectedRel2.addTuple(tuple);
		
		assertTrue("The canonical database does not have the expected schema", haveSameSchema(db, expectedDb));
		assertTrue("The canonical database is not the expected one", areHomomorphic(db, expectedDb));		
	}

	/**
	 * Initial Input >	Instance:		empty
	 * 					Constraints:	true \subseteq R(x, 3)
	 * 									Q(x) :- R(x, y) \subseteq Q(x) :- S(x, 3)
	 * 
	 * Expected Instance > R(z1, z2), S(z1, 3)
	 */	
	@Test public void TgdWithConstantsInTheTarget() {
		
		// Populate instance
		Database db = new Database();
		
		Relation rel1 = new Relation("R", 2);
		db.addRelationInstance(rel1);

		Relation rel2 = new Relation("S", 2);
		db.addRelationInstance(rel2);
		
		// Create assertion
		Predicate pred1 = new Predicate(2);
		pred1.setFunctionHead("R");
		pred1.addVariable(Value.createVariable("x", false));
		pred1.addVariable(Value.createVariable("y", false));
		
		Predicate head = new Predicate(0);
		
		Statement assertionConclusion = new Statement(head, new StatementScan(pred1));
		
		Assertion assertion1 = new Assertion(assertionConclusion, db);
		
		// Create tgd
		Predicate predTgd1 = new Predicate(2);
		predTgd1.setFunctionHead("R");
		predTgd1.addVariable(Value.createVariable("x", false));
		predTgd1.addVariable(Value.createVariable("y", false));
		
		Predicate predHead1 = new Predicate(1);
		predHead1.addVariable(Value.createVariable("x", false));
		
		Statement statTgd1 = new Statement(predHead1, new StatementScan(predTgd1));
		
		Predicate predTgd2 = new Predicate(2);
		predTgd2.setFunctionHead("S");
		predTgd2.addVariable(Value.createVariable("x", false));
		predTgd2.addVariable(Value.createNumericConstant(3.0));
		
		Predicate predHead2 = new Predicate(1);
		predHead2.addVariable(Value.createVariable("x", false));
		
		Statement statTgd2 = new Statement(predHead2, new StatementScan(predTgd2));
		
		TupleGenConstraint tgd = new TupleGenConstraint(statTgd1, statTgd2, db);
		
		// Populate list of constraints
		ArrayList<Assertion> assertions = new ArrayList<Assertion>();
		assertions.add(assertion1);
		
		ArrayList<TupleGenConstraint> tgds = new ArrayList<TupleGenConstraint>();
		tgds.add(tgd);
		
		
		ArrayList<EqualityGenConstraint> egds = new ArrayList<EqualityGenConstraint>();
		
		// Chase
		Chase chase = new Chase(tgds, egds, new ArrayList<DenialConstraint>() , assertions);
		
		try {
			chase.run();
		} catch (InconsistencyException e) {
			e.printStackTrace();
		}
		
		// Create expected canonical database
		Database expectedDb = new Database();
		
		Relation expectedRel1 = new Relation("R", 2);
		expectedDb.addRelationInstance(expectedRel1);
		
		Relation expectedRel2 = new Relation("S", 2);
		expectedDb.addRelationInstance(expectedRel2);
		
		Tuple tuple = new Tuple(2);
		tuple.addValue(Value.createVariable("z1", false));
		tuple.addValue(Value.createVariable("z2", false));
		
		expectedRel1.addTuple(tuple);
		
		tuple = new Tuple(2);
		tuple.addValue(Value.createVariable("z1", false));
		tuple.addValue(Value.createNumericConstant(3.0));
		
		expectedRel2.addTuple(tuple);
		
		assertTrue("The canonical database does not have the expected schema", haveSameSchema(db, expectedDb));
		assertTrue("The canonical database is not the expected one", areHomomorphic(db, expectedDb));
		
	}

	/**
	 * Initial Input >	Instance:		empty
	 * 					Constraints:	true \subseteq R(2), T(2)
	 * 									Q(x) :- R(x) \subseteq Q(x) :- S(x, y)
	 * 									Q(x) :- T(x) \subseteq Q(x) :- S(x, y)
	 * 									S(x, y1), S(x, y2) \implies y1 = y2
	 * 
	 * Expected Instance > R(2), T(2), S(2, SK1)
	 */	
	@Test public void SimpleEgd() {
		
		// Populate instance
		Database db = new Database();
		
		Relation rel1 = new Relation("R", 1);
		db.addRelationInstance(rel1);

		Relation rel2 = new Relation("T", 1);
		db.addRelationInstance(rel2);
		
		Relation rel3 = new Relation("S", 2);
		db.addRelationInstance(rel3);
		
		// Create assertion
		Predicate pred1 = new Predicate(1);
		pred1.setFunctionHead("R");
		pred1.addVariable(Value.createNumericConstant(2.0));

		Predicate pred2 = new Predicate(1);
		pred2.setFunctionHead("T");
		pred2.addVariable(Value.createNumericConstant(2.0));
		
		Predicate head = new Predicate(0);
		
		Statement assertionConclusion = new Statement(head, new StatementJoin(new StatementScan(pred1), new StatementScan(pred2)));
		
		Assertion assertion1 = new Assertion(assertionConclusion, db);
		
		// Create tgd1
		Predicate predTgd1 = new Predicate(1);
		predTgd1.setFunctionHead("R");
		predTgd1.addVariable(Value.createVariable("x", false));
		
		Predicate predHead1 = new Predicate(1);
		predHead1.addVariable(Value.createVariable("x", false));
		
		Statement statTgd1 = new Statement(predHead1, new StatementScan(predTgd1));
		
		Predicate predTgd2 = new Predicate(2);
		predTgd2.setFunctionHead("S");
		predTgd2.addVariable(Value.createVariable("x", false));
		predTgd2.addVariable(Value.createVariable("y", false));
		
		Predicate predHead2 = new Predicate(1);
		predHead2.addVariable(Value.createVariable("x", false));
		
		Statement statTgd2 = new Statement(predHead2, new StatementScan(predTgd2));
		
		TupleGenConstraint tgd1 = new TupleGenConstraint(statTgd1, statTgd2, db);
		
		// Create tgd2
		predTgd1 = new Predicate(1);
		predTgd1.setFunctionHead("T");
		predTgd1.addVariable(Value.createVariable("x", false));
		
		predHead1 = new Predicate(1);
		predHead1.addVariable(Value.createVariable("x", false));
		
		statTgd1 = new Statement(predHead1, new StatementScan(predTgd1));
		
		predTgd2 = new Predicate(2);
		predTgd2.setFunctionHead("S");
		predTgd2.addVariable(Value.createVariable("x", false));
		predTgd2.addVariable(Value.createVariable("y", false));
		
		predHead2 = new Predicate(1);
		predHead2.addVariable(Value.createVariable("x", false));
		
		statTgd2 = new Statement(predHead2, new StatementScan(predTgd2));
		
		TupleGenConstraint tgd2 = new TupleGenConstraint(statTgd1, statTgd2, db);
		
		// Create egd
		Predicate predEgd1 = new Predicate(2);
		predEgd1.setFunctionHead("S");
		predEgd1.addVariable(Value.createVariable("x", false));
		predEgd1.addVariable(Value.createVariable("y1", false));
		
		Predicate predEgd2 = new Predicate(2);
		predEgd2.setFunctionHead("S");
		predEgd2.addVariable(Value.createVariable("x", false));
		predEgd2.addVariable(Value.createVariable("y2", false));
		
		Predicate egdHead = new Predicate(2);
		egdHead.addVariable(Value.createVariable("y1", false));
		egdHead.addVariable(Value.createVariable("y2", false));
		
		Statement statEgd = new Statement(egdHead, new StatementJoin(new StatementScan(predEgd1), new StatementScan(predEgd2)));
		Equality eq = new Equality(Value.createVariable("y1", false), Value.createVariable("y2", false));
		ArrayList<Equality> eqs = new ArrayList<Equality>();
		eqs.add(eq);
		
		EqualityGenConstraint egd = new EqualityGenConstraint(statEgd, eqs, db);
		
		// Populate list of constraints
		ArrayList<Assertion> assertions = new ArrayList<Assertion>();
		assertions.add(assertion1);
		
		ArrayList<TupleGenConstraint> tgds = new ArrayList<TupleGenConstraint>();
		tgds.add(tgd1);
		tgds.add(tgd2);
		
		ArrayList<EqualityGenConstraint> egds = new ArrayList<EqualityGenConstraint>();
		egds.add(egd);
		
		// Chase
		Chase chase = new Chase(tgds, egds, new ArrayList<DenialConstraint>() , assertions);
		
		try {
			chase.run();
		} catch (InconsistencyException e) {
			e.printStackTrace();
		}
		
		// Create expected canonical database
		Database expectedDb = new Database();
		
		Relation expectedRel1 = new Relation("R", 1);
		expectedDb.addRelationInstance(expectedRel1);

		Relation expectedRel2 = new Relation("T", 1);
		expectedDb.addRelationInstance(expectedRel2);
		
		Relation expectedRel3 = new Relation("S", 2);
		expectedDb.addRelationInstance(expectedRel3);
		
		Tuple tuple = new Tuple(1);
		tuple.addValue(Value.createNumericConstant(2.0));
		
		expectedRel1.addTuple(tuple);
		
		tuple = new Tuple(1);
		tuple.addValue(Value.createNumericConstant(2.0));
		
		expectedRel2.addTuple(tuple);
		
		tuple = new Tuple(2);
		tuple.addValue(Value.createNumericConstant(2.0));
		tuple.addValue(Value.createVariable("newSK1", true));
		
		expectedRel3.addTuple(tuple);
		
		assertTrue("The canonical database does not have the expected schema", haveSameSchema(db, expectedDb));
		assertTrue("The canonical database is not the expected one", areHomomorphic(db, expectedDb));		
	}
	 
	// TODO: Add check for cycles
	// TODO: They do not have to be equal. They have to have a mapping!
	private boolean areHomomorphic(Database db1, Database db2) {
		if (!haveSameSchema(db1, db2) || !haveSameNumberOfTuples(db1, db2))
			return false;
		
		List<String> relationNames1 = db1.getRelationNames();
		
		// Number of relations
		int numOfRels = relationNames1.size();
		
		// Size of each relation
		int numOfTuples[] = new int[numOfRels];
		
		// Number of permutations of its tuples per relation
		PermutationGenerator relPerms[] = new PermutationGenerator[numOfRels];
		
		for (int i = 0; i < numOfRels; i++) {
			String relName = relationNames1.get(i);
			int relSize = db1.getRelationInstance(relName).size();
			
			numOfTuples[i] = relSize;
			relPerms[i] = new PermutationGenerator(relSize);
		}
		
		boolean done = false;
		
		while (!done) {
			ArrayList<int[]> perms = new ArrayList<int[]>();
			
			
			
			for (int i = 0; i < numOfRels; i++) {
				perms.add(relPerms[i].getNext());
			}
			
			if (tryMatchAll(db1, db2, perms))
				return true;
			
			// Increment counters on permutations	
			for (int i = numOfRels - 1; i >=0; i--) {
				if (!relPerms[i].hasMore() && i != 0)
					relPerms[i] = new PermutationGenerator(numOfTuples[i]);
				else if (!relPerms[i].hasMore()) {
					done = true;
					break;
				}
				else
					break;
			}
		}
		
		return false;
	}
	
	private boolean tryMatchAll(Database db1, Database db2, ArrayList<int[]> permutations) {
		List<String> relationNames1 = db1.getRelationNames();
		
		Hashtable<Value, Value> stMappings = new Hashtable<Value, Value>();
		Hashtable<Value, Value> tsMappings = new Hashtable<Value, Value>();
		
		for (int i = 0; i < relationNames1.size(); i++) {
			String relName = relationNames1.get(i);
			Relation rel1 = db1.getRelationInstance(relName);
			Relation rel2 = db2.getRelationInstance(relName);
			
			TupleIterator tuples1 = rel1.getNonSyncTupleIterator();
			int[] curPermutation = permutations.get(i);
			
			for (int j = 0; j < rel1.size(); j++) {
				Tuple tuple1 = tuples1.next();
				Tuple tuple2 = null;
				
				TupleIterator tuples2 = rel2.getNonSyncTupleIterator();
				for (int k = 0; k <= curPermutation[j]; k++)
					tuple2 = tuples2.next();
				
				if (!tryMatchTuple(tuple1, tuple2, stMappings, tsMappings))
					return false;
			}
		}
		
		return true;
	}
	
	private boolean haveSameSchema(Database db1, Database db2) {
		List<String> relationNames1 = db1.getRelationNames();
		List<String> relationNames2 = db2.getRelationNames();
		
		// Check whether the databases contain relations with the
		// same names
		if (relationNames1.size() != relationNames2.size())
			return false;
		
		for (String relName1 : relationNames1)
			if (!relationNames2.contains(relName1))
				return false;
		
		// Check whether relations with the same name share the
		// same schema
		for (String relName: relationNames1) {
			Relation rel1 = db1.getRelationInstance(relName);
			Relation rel2 = db2.getRelationInstance(relName);
			
			if (rel1.arity() != rel2.arity())
				return false;
		}
		
		return true;
	}
	
	private boolean haveSameNumberOfTuples(Database db1, Database db2) {
		List<String> relationNames1 = db1.getRelationNames();
		List<String> relationNames2 = db2.getRelationNames();

		// Check whether relations with the same name have
		// the same number of tuples
		for (String relName: relationNames1) {
			if (!relationNames2.contains(relName))
				return false;
			
			Relation rel1 = db1.getRelationInstance(relName);
			Relation rel2 = db2.getRelationInstance(relName);
			
			if (rel1.size() != rel2.size())
				return false;
		}
		
		return true;
	}
	
	// Matches the <code>source</code> tuple to the <code>target</code> tuple and
	// updates the value mappings (which have to be 1-1). It returns <code>true</code> if the mapping
	// succeeds and <code>false</code> otherwise.
	private boolean tryMatchTuple(Tuple source, Tuple target, Hashtable<Value, Value> stMappings, Hashtable<Value, Value> tsMappings) {
		// Tuples should have the same arity
		if (source.size() != target.size())
			return false;
		
		for (int i = 0; i < source.size(); i++) {
			Value sourceValue = source.getValue(i);
			Value targetValue = target.getValue(i);
			
			// If a value is a constant, the other should be also the same constant
			if ((sourceValue.isAnyConstant() || targetValue.isAnyConstant()) && !sourceValue.equals(targetValue))
				return false;
			
			// A value should be a skolem if and only if the other is also a skolem
			if ((sourceValue.isSkolem() && !targetValue.isSkolem()) ||
				(targetValue.isSkolem() && !sourceValue.isSkolem()))
				return false;
			
			if ((stMappings.containsKey(sourceValue) && !tsMappings.containsKey(targetValue)) ||
				(tsMappings.containsKey(targetValue) && !stMappings.containsKey(sourceValue)))
				return false;
			
			if (stMappings.containsKey(sourceValue))
			{
				Value sMappedValue = stMappings.get(sourceValue);
				Value tMappedValue = tsMappings.get(targetValue);
				if (!sMappedValue.equals(targetValue) || !tMappedValue.equals(sourceValue))
					return false;
			}
			else {
				stMappings.put(sourceValue, targetValue);
				tsMappings.put(targetValue, sourceValue);
			}
		}
		
		return true;
	}
	
	// From http://www.merriampark.com/perm.htm
	public class PermutationGenerator {

		  private int[] a;
		  private BigInteger numLeft;
		  private BigInteger total;

		  //-----------------------------------------------------------
		  // Constructor. WARNING: Don't make n too large.
		  // Recall that the number of permutations is n!
		  // which can be very large, even when n is as small as 20 --
		  // 20! = 2,432,902,008,176,640,000 and
		  // 21! is too big to fit into a Java long, which is
		  // why we use BigInteger instead.
		  //----------------------------------------------------------

		  public PermutationGenerator (int n) {
		    if (n < 1) {
		      throw new IllegalArgumentException ("Min 1");
		    }
		    a = new int[n];
		    total = getFactorial (n);
		    reset ();
		  }

		  //------
		  // Reset
		  //------

		  public void reset () {
		    for (int i = 0; i < a.length; i++) {
		      a[i] = i;
		    }
		    numLeft = new BigInteger (total.toString ());
		  }

		  //------------------------------------------------
		  // Return number of permutations not yet generated
		  //------------------------------------------------

		  public BigInteger getNumLeft () {
		    return numLeft;
		  }

		  //------------------------------------
		  // Return total number of permutations
		  //------------------------------------

		  public BigInteger getTotal () {
		    return total;
		  }

		  //-----------------------------
		  // Are there more permutations?
		  //-----------------------------

		  public boolean hasMore () {
		    return numLeft.compareTo (BigInteger.ZERO) == 1;
		  }

		  //------------------
		  // Compute factorial
		  //------------------

		  private BigInteger getFactorial (int n) {
		    BigInteger fact = BigInteger.ONE;
		    for (int i = n; i > 1; i--) {
		      fact = fact.multiply (new BigInteger (Integer.toString (i)));
		    }
		    return fact;
		  }

		  //--------------------------------------------------------
		  // Generate next permutation (algorithm from Rosen p. 284)
		  //--------------------------------------------------------

		  public int[] getNext () {

		    if (numLeft.equals (total)) {
		      numLeft = numLeft.subtract (BigInteger.ONE);
		      return a;
		    }

		    int temp;

		    // Find largest index j with a[j] < a[j+1]

		    int j = a.length - 2;
		    while (a[j] > a[j+1]) {
		      j--;
		    }

		    // Find index k such that a[k] is smallest integer
		    // greater than a[j] to the right of a[j]

		    int k = a.length - 1;
		    while (a[j] > a[k]) {
		      k--;
		    }

		    // Interchange a[j] and a[k]

		    temp = a[k];
		    a[k] = a[j];
		    a[j] = temp;

		    // Put tail end of permutation after jth position in increasing order

		    int r = a.length - 1;
		    int s = j + 1;

		    while (r > s) {
		      temp = a[s];
		      a[s] = a[r];
		      a[r] = temp;
		      r--;
		      s++;
		    }

		    numLeft = numLeft.subtract (BigInteger.ONE);
		    
		    return a;

		  }

		}

}
