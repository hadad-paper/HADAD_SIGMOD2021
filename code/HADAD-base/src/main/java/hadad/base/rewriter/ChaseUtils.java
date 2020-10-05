package hadad.base.rewriter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import hadad.db.canonicaldb.Database;
import hadad.db.canonicaldb.Relation;
import hadad.db.canonicaldb.Relation.TupleIterator;
import hadad.db.canonicaldb.Tuple;
import hadad.db.chase.Assertion;
import hadad.db.chase.EqualityGenConstraint;
import hadad.db.chase.TupleGenConstraint;
import hadad.db.datalogexpr.Predicate;
import hadad.db.datalogexpr.Statement;
import hadad.db.datalogexpr.StatementJoin;
import hadad.db.datalogexpr.StatementOp;
import hadad.db.datalogexpr.StatementScan;
import hadad.db.datalogexpr.Value;
import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.conjunctivequery.StringConstant;
import hadad.commons.conjunctivequery.Term;
import hadad.commons.conjunctivequery.Variable;
import hadad.commons.constraints.Constraint;
import hadad.commons.constraints.Egd;
import hadad.commons.constraints.Equality;
import hadad.commons.constraints.Tgd;
import hadad.commons.relationalschema.RelationalSchema;

public final class ChaseUtils {
	/**
	 * Returns the chase context for the specified context.
	 *
	 * @param context
	 *            The provenance aware chase & backchase algorithm context.
	 * @return The chase context for the specified context.
	 */
	public static ChaseContext createChaseContext(final Context context) {
		final Database db = relationalSchema2database(context.getGlobalSchema());

		final List<Assertion> assertions = forwardConstraints2assertions(db,
				context.getForwardConstraints());
		final List<TupleGenConstraint> tgds = forwardConstraints2tgds(db,
				context.getForwardConstraints());
		final List<EqualityGenConstraint> egds = forwardConstraints2egds(db,
				context.getForwardConstraints());

		return new ChaseContext(db, assertions, tgds, egds);
	}

	/**
	 * Returns the chase assertion for the specified query and canonical
	 * database.
	 *
	 * @param db
	 *            the canonical database to be used for the chase.
	 * @param query
	 *            the query to be chased.
	 * @return The chase assertion for the specified query and canonical
	 *         database.
	 */
	public static Assertion createQueryAssertion(final Database db,
			final ConjunctiveQuery query) {
		return new Assertion(new Statement(new Predicate(0),
				atoms2statementOp(new ArrayList<Atom>(query.getBody()))), db);
	}

	/**
	 * Collects the (chased) universal plan (conjunctive query) for the
	 * specified query and canonical database.
	 *
	 * @param query
	 *            the query whose universal plan is to be collected.
	 * @param db
	 *            the canonical database (used for the chase) from which the
	 *            universal plan will is to be collected.
	 * @return The (chased) universal plan (conjunctive query) for the specified
	 *         query and canonical database.
	 */
	public static ConjunctiveQuery collectResult(final ConjunctiveQuery query, final Database db) {
		final Map<String, Variable> queryVariablesMapping = createQueryVariablesMapping(query);
		final Set<Atom> atoms = new HashSet<Atom>();

		for (final String name:  db.getRelationNames()) {
			final Relation relation = db.getRelationInstance(name);
			final TupleIterator it = relation.getNonSyncTupleIterator();
			while (it.hasNext()) {
				final Tuple tuple = it.next();
				final List<Term> terms = new ArrayList<Term>();

				for (int j = 0; j< relation.arity(); ++j) {
					final Value val = tuple.getValue(j).getRepresentative();
					if (queryVariablesMapping.containsKey(val.toString())) {
						terms.add(queryVariablesMapping.get(val.toString()));
					} else {
						Term term;
						if (val.isAnyConstant()) {
							term = new StringConstant(val.getValueStr().substring(1,val.getValueStr().length()-1));
						} else {
							term = new Variable(val.getValueStr());
						}
						terms.add(term);
					}
				}
				atoms.add(new Atom(name, terms));
			}
		}

		return new ConjunctiveQuery(query.getName() + "_C", query.getHead(),
				atoms);
	}

	/*
	 * Used to collect the result from database.
	 *
	 * Workaround as the chase code will produce a lot of duplicates (according
	 * to Ioana's comment).
	 */
	private static Map<String, Variable> createQueryVariablesMapping(
			final ConjunctiveQuery query) {
		final Map<String, Variable> mapping = new HashMap<String, Variable>();
		final Set<Variable> seenVars = new HashSet<Variable>();
		int counter = 0;
		for (final Atom atom : query.getBody()) {
			for (final Term term : atom.getTerms()) {
				if (term instanceof Variable) {
					final Variable var = (Variable) term;
					if (!seenVars.contains(var)) {
						seenVars.add(var);
						mapping.put("VAR_" + (counter++), var);
					}
				}
			}
		}
		return mapping;
	}

	private static Database relationalSchema2database(
			final RelationalSchema schema) {
		final Database db = new Database();
		for (final hadad.commons.relationalschema.Relation relation : schema
				.getRelations()) {
			db.addRelationInstance(relationalRelation2relation(relation));
		}
		return db;
	}

	private static Relation relationalRelation2relation(
			final hadad.commons.relationalschema.Relation relation) {
		return new Relation(relation.getName(), relation.getArity());
	}

	private static List<Assertion> forwardConstraints2assertions(
			final Database db, final List<? extends Constraint> forwardConstraints) {
		final List<Assertion> assertions = new ArrayList<Assertion>();
		for (Constraint constraint : forwardConstraints) {
			if (constraint instanceof Tgd && constraint.getPremise().isEmpty()) {
				assertions.add(constraint2assertion(db, (Tgd) constraint));
			}
		}
		return assertions;
	}

	private static List<TupleGenConstraint> forwardConstraints2tgds(
			final Database db, final List<? extends Constraint> forwardConstraints) {
		final List<TupleGenConstraint> tgds = new ArrayList<TupleGenConstraint>();
		for (Constraint constraint : forwardConstraints) {
			if (constraint instanceof Tgd && !constraint.getPremise().isEmpty()) {
				tgds.add(constraint2chaseConstraint(db, (Tgd) constraint));
			}
		}
		return tgds;
	}

	private static List<EqualityGenConstraint> forwardConstraints2egds(
			final Database db, final List<? extends Constraint> forwardConstraints) {
		final List<EqualityGenConstraint> egds = new ArrayList<EqualityGenConstraint>();
		for (Constraint constraint : forwardConstraints) {
			if (constraint instanceof Egd && !constraint.getPremise().isEmpty()) {
				egds.add(constraint2chaseConstraint(db, (Egd) constraint));
			}
		}
		return egds;
	}

	private static Assertion constraint2assertion(final Database db,
			final Tgd constraint) {
		if (!constraint.getPremise().isEmpty()) {
			throw new IllegalStateException("Empty TGD premise expected.");
		}
		return new Assertion(new Statement(new Predicate(0),
				atoms2statementOp(constraint.getConclusion())), db);
	}

	private static StatementOp atoms2statementOp(final List<Atom> atoms) {
		StatementOp lastStatement = null;
		for (final Atom atom : atoms) {
			final Predicate predicate = atom2predicate(atom);
			if (lastStatement == null) {
				lastStatement = new StatementScan(predicate);
			} else {
				lastStatement = new StatementJoin(lastStatement,
						new StatementScan(predicate));
			}
		}
		return lastStatement;
	}

	private static Predicate atom2predicate(final Atom atom) {
		final Predicate predicate = new Predicate(atom.getTerms().size());
		predicate.setFunctionHead(atom.getPredicate());
		for (final Term term : atom.getTerms()) {
			predicate.addVariable(term2value(term));
		}

		return predicate;
	}

	private static Value term2value(final Term term) {
		return term.isConstant() ? Value.createConstant(term.toString())
				: Value.createVariable(((Variable) term).getName(), false);
	}

	private static EqualityGenConstraint constraint2chaseConstraint(
			final Database db, final Egd constraint) {
		if (constraint.getPremise().isEmpty()) {
			throw new IllegalStateException("Non-empty EGD premise expected.");
		}
		return new EqualityGenConstraint(constraint2premise(constraint),
				(ArrayList<hadad.db.chase.Equality>) constraint2conclusion(constraint),
				db);
	}

	private static TupleGenConstraint constraint2chaseConstraint(
			final Database db, final Tgd constraint) {
		if (constraint.getPremise().isEmpty()) {
			throw new IllegalStateException("Non-empty TGD premise expected.");
		}
		return new TupleGenConstraint(constraint2premise(constraint),
				constraint2conclusion(constraint), db);
	}

	private static Statement constraint2premise(final Egd constraint) {
		return new Statement(
				headVariableNames2predicate(constraint2headVariableNames(constraint)),
				atoms2statementOp(constraint.getPremise()));
	}

	private static Statement constraint2premise(final Tgd constraint) {
		return new Statement(
				headVariableNames2predicate(constraint2headVariableNames(constraint)),
				atoms2statementOp(constraint.getPremise()));
	}

	private static List<hadad.db.chase.Equality> constraint2conclusion(
			final Egd constraint) {
		final List<hadad.db.chase.Equality> conclusion = new ArrayList<hadad.db.chase.Equality>();
		for (final Equality equality : constraint.getConclusion()) {
			conclusion.add(new hadad.db.chase.Equality(term2value(equality
					.getTerm1()), term2value(equality.getTerm2())));
		}
		return conclusion;
	}

	private static Statement constraint2conclusion(final Tgd constraint) {
		return new Statement(
				headVariableNames2predicate(constraint2headVariableNames(constraint)),
				atoms2statementOp(constraint.getConclusion()));
	}

	private static Predicate headVariableNames2predicate(
			final List<String> headVarNames) {
		final Predicate head = new Predicate(headVarNames.size());
		for (int j = 0; j < headVarNames.size(); ++j) {
			head.addVariable(Value.createVariable(headVarNames.get(j), false));
		}
		return head;
	}

	private static List<String> constraint2headVariableNames(
			final Egd constraint) {
		final Set<Variable> seenVars = new HashSet<Variable>();
		final List<String> headVarNames = new ArrayList<String>();

		for (final Equality equality: constraint.getConclusion()) {
			for (final Term term : new ArrayList<Term>(
					Arrays.asList(new Term[] { equality.getTerm1(),
							equality.getTerm2() }))) {
				if (term instanceof Variable) {
					final Variable var = (Variable) term;
					if (!seenVars.contains(var)) {
						seenVars.add(var);
						for (final Atom atom: constraint.getPremise()) {
							if (atom.getTerms().contains(var)) {
								headVarNames.add(var.getName());
								break;
							}
						}
					}
				}
			}
		}
		return headVarNames;
	}

	private static List<String> constraint2headVariableNames(
			final Tgd constraint) {
		final Set<Variable> seenVars = new HashSet<Variable>();
		final List<String> headVarNames = new ArrayList<String>();

		for (final Atom atom : constraint.getConclusion()) {
			for (final Term term : atom.getTerms()) {
				if (term instanceof Variable) {
					final Variable var = (Variable) term;
					if (!seenVars.contains(var)) {
						seenVars.add(var);
						for (final Atom atomAux : constraint.getPremise()) {
							if (atomAux.getTerms().contains(var)) {
								headVarNames.add(var.getName());
								break;
							}
						}
					}
				}
			}
		}
		return headVarNames;
	}
}
