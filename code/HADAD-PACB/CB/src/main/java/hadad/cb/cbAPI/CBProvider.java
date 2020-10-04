package hadad.cb.cbAPI;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import hadad.cb.cbInternal.BackchaseWrapper;
import hadad.cb.cbTool.ToolUtils;
import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.conjunctivequery.IntegerConstant;
import hadad.commons.conjunctivequery.StringConstant;
import hadad.commons.conjunctivequery.Term;
import hadad.commons.conjunctivequery.Variable;
import hadad.commons.constraints.Constraint;
import hadad.commons.constraints.Egd;
import hadad.commons.constraints.False;
import hadad.commons.constraints.Tgd;
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
import hadad.db.datalogexpr.StatementOp;
import hadad.db.datalogexpr.StatementScan;
import hadad.db.datalogexpr.Value;

/**
 * Main API class for interacting with the Reformulation (CB) engine
 */
public class CBProvider {

    /** Logger **/
    private final static Logger LOGGER = Logger.getLogger(ToolUtils.class.getName());

    /**
     * Computes the reformulation of a conjunctive query, given a set of
     * constraints
     *
     * @param query
     *            The query to be reformulated
     * @param global
     *            The global schema (including source, target and constraints)
     * @param target
     *            The target schema
     * @param fwconstraints
     *            The set of constraints to apply during the Chase phase
     * @param bwconstraints
     *            The set of constraints to apply during the Backchase phase
     *
     * @return The reformulations
     */
    public static Map<Long, List<ConjunctiveQuery>> getReformulations(final ConjunctiveQuery query,
            final hadad.commons.relationalschema.RelationalSchema global,
            final hadad.commons.relationalschema.RelationalSchema target,
            final ArrayList<Constraint> fwconstraints, final ArrayList<Constraint> bwconstraints,
            final Properties properties) throws Exception {
        long start = System.currentTimeMillis();
        ConjunctiveQuery chaseRes = Chase(query, global, fwconstraints);
        System.out.println("\nCHASED QUERY\n===========================\n");
        System.out.println(chaseRes);
        System.out.println("\n===========================\n");
        ConjunctiveQuery uPlan = Restrict(chaseRes, target);
        System.out.println("\nUNIVERSAL PLAN\n===========================\n");
        System.out.println(uPlan);
        System.out.println("\n===========================\n");
        long end = System.currentTimeMillis();
        LOGGER.debug("Chase and Restriction Time: " + (end - start));
        final Map<Long, List<ConjunctiveQuery>> rewrtings =
                BackchaseWrapper.Backchase(query, uPlan, bwconstraints, properties);
        final Map<Long, List<ConjunctiveQuery>> timedRewritngs = new HashMap<>();
        if (!rewrtings.isEmpty())
            timedRewritngs.put(rewrtings.keySet().iterator().next() + (end - start),
                    rewrtings.values().iterator().next());
        return timedRewritngs;
    }

    /**
     * Chases a conjunctive query with a set of constraints
     *
     * @param query
     *            The query to be chased
     * @param schema
     *            The global schema (query and constraints)
     * @param constraints
     *            The set of constraints
     *
     * @return The result of the chase
     */
    //TODO: This needs to be refactored
    public static ConjunctiveQuery Chase(ConjunctiveQuery query,
            hadad.commons.relationalschema.RelationalSchema schema, ArrayList<Constraint> constraints) {

        hadad.db.canonicaldb.Database db = new hadad.db.canonicaldb.Database();
        List<hadad.commons.relationalschema.Relation> relations = schema.getRelations();

        for (int i = 0; i < relations.size(); ++i) {
            db.addRelationInstance(
                    new hadad.db.canonicaldb.Relation(relations.get(i).getName(), relations.get(i).getArity()));
        }

        List<Assertion> assertions = new ArrayList<Assertion>();
        List<TupleGenConstraint> tgds = new ArrayList<TupleGenConstraint>();
        List<EqualityGenConstraint> egds = new ArrayList<EqualityGenConstraint>();
        List<DenialConstraint> dgds = new ArrayList<DenialConstraint>();

        Value.restartVarIndex();
        HashMap<String, Term> varChange = new HashMap<String, Term>();
        HashSet<String> seenTerms = new HashSet<String>();

        int globalIndex = 0;

        Predicate head = new Predicate(0);
        StatementOp laststatement = null;
        for (Atom crtAtom : query.getBody()) {
            Predicate pred = new Predicate(crtAtom.getTerms().size());
            pred.setFunctionHead(crtAtom.getPredicate());
            for (Term crtTerm : crtAtom.getTerms()) {
                Value created = null;
                if (crtTerm.isConstant()) {
                    String constValue = crtTerm.toString();
                    created = Value.createConstant(constValue);
                } else {
                    String varName = ((Variable) crtTerm).getName();
                    created = Value.createVariable(varName, false);
                    if (!seenTerms.contains(varName)) {
                        seenTerms.add(varName);
                        varChange.put("VAR_" + (globalIndex++), crtTerm);
                    }
                }
                pred.addVariable(created);
            }

            if (laststatement == null) {
                laststatement = new StatementScan(pred);
            } else {
                laststatement = new StatementJoin(laststatement, new StatementScan(pred));
            }
        }
        Statement assertionConclusion = new Statement(head, laststatement);
        Assertion assertion = new Assertion(assertionConclusion, db);
        assertions.add(assertion);

        //other assertions
        for (Constraint crtConstraint : constraints) {
            if (crtConstraint instanceof Tgd) {
                Tgd crtTgd = (Tgd) crtConstraint;
                if (crtTgd.getPremise().size() != 0) {
                    continue;
                }

                head = new Predicate(0);
                laststatement = null;
                for (Atom crtAtom : crtTgd.getConclusion()) {
                    Predicate pred = new Predicate(crtAtom.getTerms().size());
                    pred.setFunctionHead(crtAtom.getPredicate());
                    for (Term crtTerm : crtAtom.getTerms()) {
                        Value created = null;
                        if (crtTerm.isConstant()) {
                            String constValue = crtTerm.toString();
                            created = Value.createConstant(constValue);
                        } else {
                            String varName = ((Variable) crtTerm).getName();
                            created = Value.createVariable(varName, false);
                        }
                        pred.addVariable(created);
                    }

                    if (laststatement == null) {
                        laststatement = new StatementScan(pred);
                    } else {
                        laststatement = new StatementJoin(laststatement, new StatementScan(pred));
                    }
                }
                assertionConclusion = new Statement(head, laststatement);
                assertion = new Assertion(assertionConclusion, db);
                assertions.add(assertion);
            }
        }

        //constraints
        for (Constraint crtConstraint : constraints) {
            HashSet<String> seenVars = new HashSet<String>();

            List<Atom> premise = crtConstraint.getPremise();

            if (premise.size() == 0) {
                continue; //assertion, ignore
            }

            ArrayList<String> headVarNames = new ArrayList<String>();

            if (crtConstraint instanceof Egd) {
                Egd crtEgd = (Egd) crtConstraint;
                for (hadad.commons.constraints.Equality crtEq : crtEgd.getConclusion()) {
                    Term term1 = crtEq.getTerm1();
                    if (term1.isVariable() && !(seenVars.contains(term1.toString()))) {
                        seenVars.add(term1.toString());
                        boolean found = false;
                        for (Atom crtAtom : premise) {
                            Collection<? extends Term> atomTerms = crtAtom.getTerms();
                            for (Term term : atomTerms) {
                                if (term.isVariable()) {
                                    if (((Variable) term).getName().equals(((Variable) term1).getName())) {
                                        found = true;
                                        break;
                                    }
                                }
                            }
                            if (found) {
                                headVarNames.add(((Variable) term1).getName());
                                break;
                            }
                        }
                    }

                    Term term2 = crtEq.getTerm2();
                    if (term2.isVariable() && !(seenVars.contains(term2.toString()))) {
                        seenVars.add(term2.toString());
                        boolean found = false;
                        for (Atom crtAtom : premise) {
                            Collection<? extends Term> atomTerms = crtAtom.getTerms();
                            for (Term term : atomTerms) {
                                if (term.isVariable()) {
                                    if (((Variable) term).getName().equals(((Variable) term2).getName())) {
                                        found = true;
                                        break;
                                    }
                                }
                            }
                            if (found) {
                                headVarNames.add(((Variable) term2).getName());
                                break;
                            }
                        }
                    }
                }
            } else if (crtConstraint instanceof Tgd) {
                Tgd crtTgd = (Tgd) crtConstraint;
                List<Atom> atoms = crtTgd.getConclusion();

                for (Atom crtAtom : atoms) {
                    for (Term crtTerm : crtAtom.getTerms()) {
                        if (crtTerm.isVariable() && !(seenVars.contains(crtTerm.toString()))) {
                            seenVars.add(crtTerm.toString());
                            boolean found = false;
                            for (Atom atom2 : premise) {
                                for (Term term2 : atom2.getTerms()) {
                                    if (term2.isVariable()) {
                                        if (((Variable) term2).getName().equals(((Variable) crtTerm).getName())) {
                                            found = true;
                                            break;
                                        }
                                    }
                                }
                                if (found) {
                                    headVarNames.add(((Variable) crtTerm).getName());
                                    break;
                                }
                            }
                        }
                    }
                }
            }

            head = new Predicate(headVarNames.size());
            for (int j = 0; j < headVarNames.size(); ++j) {
                head.addVariable(Value.createVariable(headVarNames.get(j), false));
            }

            laststatement = null;
            for (Atom crtAtom : premise) {
                Collection<? extends Term> terms = crtAtom.getTerms();
                Predicate pred = new Predicate(terms.size());
                pred.setFunctionHead(crtAtom.getPredicate());
                for (Term crtTerm : terms) {
                    if (crtTerm.isVariable()) {
                        pred.addVariable(Value.createVariable(((Variable) crtTerm).getName(), false));
                    } else {
                        pred.addVariable(Value.createConstant(crtTerm.toString()));
                    }
                }
                if (laststatement == null) {
                    laststatement = new StatementScan(pred);
                } else {
                    laststatement = new StatementJoin(laststatement, new StatementScan(pred));
                }
            }

            Statement newPremise = new Statement(head, laststatement);

            if (crtConstraint instanceof False) {

                DenialConstraint dgd = new DenialConstraint(newPremise, db);
                dgds.add(dgd);

            } else if (crtConstraint instanceof Egd) {
                ArrayList<Equality> newConclusion = new ArrayList<Equality>();
                Egd crtEgd = (Egd) crtConstraint;

                for (hadad.commons.constraints.Equality crtEq : crtEgd.getConclusion()) {
                    Value value1 = null;
                    Term term1 = crtEq.getTerm1();
                    if (term1.isVariable()) {
                        value1 = Value.createVariable(((Variable) term1).getName(), false);
                    } else {
                        value1 = Value.createConstant(term1.toString());
                    }

                    Value value2 = null;
                    Term term2 = crtEq.getTerm2();
                    if (term2.isVariable()) {
                        value2 = Value.createVariable(((Variable) term2).getName(), false);
                    } else {
                        value2 = Value.createConstant(term2.toString());
                    }

                    Equality eq = new Equality(value1, value2);
                    newConclusion.add(eq);
                }

                EqualityGenConstraint egd = new EqualityGenConstraint(newPremise, newConclusion, db);
                egds.add(egd);
            } else {
                laststatement = null;
                Tgd crtTgd = (Tgd) crtConstraint;

                for (Atom crtAtom : crtTgd.getConclusion()) {
                    Predicate pred = new Predicate(crtAtom.getTerms().size());
                    pred.setFunctionHead(crtAtom.getPredicate());
                    for (Term crtTerm : crtAtom.getTerms()) {
                        if (crtTerm.isVariable()) {
                            pred.addVariable(Value.createVariable(((Variable) crtTerm).getName(), false));
                        } else {
                            pred.addVariable(Value.createConstant(crtTerm.toString()));
                        }
                    }

                    if (laststatement == null) {
                        laststatement = new StatementScan(pred);
                    } else {
                        laststatement = new StatementJoin(laststatement, new StatementScan(pred));
                    }
                }

                Statement newConclusion = new Statement(head, laststatement);
                TupleGenConstraint tgd = new TupleGenConstraint(newPremise, newConclusion, db);
                tgds.add(tgd);
            }
        }
        //long finish = System.nanoTime();
        System.out.println("============================");
        //System.out.println((finish - start) / 1000 / 1000);
        System.out.println("============================");
        // Chase
        long start = System.nanoTime();

        Chase chase = new Chase(tgds, egds, dgds, assertions);
        try {
            //chase.alternativeRun();
            chase.run();
        } catch (InconsistencyException e) {
            e.printStackTrace();
        }

        //Collect result from database
        //Workaround: the chase code will produce a lot of duplicates!

        ArrayList<Atom> allatoms = new ArrayList<Atom>();
        ArrayList<Atom> selected = new ArrayList<Atom>();
        if (!chase.getAppliedDenial()) {
            for (String crtRelationName : db.getRelationNames()) {
                Relation dbrel = db.getRelationInstance(crtRelationName);

                TupleIterator tupleit = dbrel.getNonSyncTupleIterator();
                while (tupleit.hasNext()) {
                    Tuple crttuple = tupleit.next();
                    ArrayList<Term> crtatomterms = new ArrayList<Term>();

                    for (int j = 0; j < dbrel.arity(); ++j) {
                        Value crtVal = crttuple.getValue(j).getRepresentative();
                        Term newterm = varChange.get(crtVal.toString());
                        if (newterm == null) {
                            if (crtVal.isAnyConstant()) {
                                newterm = new StringConstant(
                                        crtVal.getValueStr().substring(1, crtVal.getValueStr().length() - 1));
                            } else {
                                newterm = new Variable(crtVal.getValueStr());
                            }
                        }
                        crtatomterms.add(newterm);
                    }
                    Atom crtAtom = new Atom(crtRelationName, crtatomterms);
                    boolean found = false;
                    for (int i = 0; i < allatoms.size() && !found; ++i) {
                        if (areEqual(allatoms.get(i), crtAtom)) {
                            found = true;
                        }
                    }
                    if (!found) {
                        selected.add(crtAtom);
                    }
                    allatoms.add(crtAtom);
                }

            }
        }
        long finish = System.nanoTime();
        System.out.println("-----" + (finish - start) / 1000.00 / 1000.00 / 1000.00);
        return new ConjunctiveQuery(query.getName() + "_C", query.getHead(), selected);
    }

    /**
     * Restricts a query to a target schema
     *
     * @param query
     *            The query to be restricted
     * @param schema
     *            The target schema
     * @return The restricted query, with head "U"
     */
    public static ConjunctiveQuery Restrict(ConjunctiveQuery query,
            hadad.commons.relationalschema.RelationalSchema schema) {
        ArrayList<Atom> rbody = new ArrayList<Atom>();

        for (Atom crtAtom : query.getBody()) {
            for (hadad.commons.relationalschema.Relation rel : schema.getRelations()) {
                if (rel.getName().equals(crtAtom.getPredicate())) {
                    rbody.add(crtAtom);
                    break;
                }
            }
        }
        return new ConjunctiveQuery("U", query.getHead(), rbody);
    }

    private static boolean areEqual(Atom atom1, Atom atom2) {
        if (!(atom1.getPredicate().equals(atom2.getPredicate()))
                || !(atom1.getTerms().size() == atom2.getTerms().size())) {
            return false;
        }
        for (int i = 0; i < atom1.getTerms().size(); ++i) {
            Term term1 = atom1.getTerm(i);
            Term term2 = atom2.getTerm(i);
            if (term1.isVariable() && term2.isVariable()
                    && ((Variable) term1).getName().equals(((Variable) term2).getName())) {
                continue;
            }
            if (term1 instanceof StringConstant && term2 instanceof StringConstant
                    && ((StringConstant) term1).getValue().equals(((StringConstant) term2).getValue())) {
                continue;
            }
            if (term1 instanceof IntegerConstant && term2 instanceof IntegerConstant
                    && ((IntegerConstant) term1).getValue().equals(((IntegerConstant) term2).getValue())) {
                continue;
            }
            return false;
        }
        return true;
    }
}
