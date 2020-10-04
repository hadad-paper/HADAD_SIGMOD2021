package hadad.db.chase;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import hadad.db.canonicaldb.Database;
import hadad.db.canonicaldb.Tuple;
import hadad.db.chaseexceptions.InconsistencyException;
import hadad.db.datalogexpr.Predicate;
import hadad.db.datalogexpr.Statement;
import hadad.db.datalogexpr.Value;
import hadad.db.query.QueryEvaluation;
import hadad.db.query.QueryTree;

/**
 * This class represents a constraint in the context of a
 * <code>CanonicalDB<code>, which generates an <code>Equality</code>
 * when used by the <code>Chase</code>. Primary key constraints are
 * of this type. Such constraint have a given premise and a conclusion
 * that equates two <code>Value</code> objects.
 *
 */
public class EqualityGenConstraint extends Constraint {
    /** Logger */
    private final static Logger LOGGER = Logger.getLogger(EqualityGenConstraint.class.getName());

    /** The premise of the constraint */
    private Statement premise;
    /**
     * The equalities that have to be enforced if the premise of
     * the constraint is satisfied
     */
    private List<Equality> equalities;

    /** The position in the query result of the left term for each equality */
    private int[] leftTerms;

    /** The position in the query result of the right term for each equality */
    private int[] rightTerms;

    /** The <code>QueryEvaluation</code> object used to evaluate the query corresponding to the constraint */
    private QueryEvaluation queryEvaluation;

    /**
     * Constructor
     * 
     * @param db
     *            the database
     */
    private EqualityGenConstraint(final Database db) {
        super(db);
    }

    /**
     * Constructor
     * 
     * @param premise
     *            the premise
     * @param equalities
     *            the equalities
     * @param db
     *            the database
     */
    public EqualityGenConstraint(final Statement premise, final List<Equality> equalities, final Database db) {
        super(db);
        this.premise = premise;
        this.equalities = equalities;
        createEqualityArrays();
        createQueryEvaluation();
    }

    /**
     * Create a copy of another constraints
     * 
     * @param otherConstraint
     *            other constraint
     * @param db
     *            the database
     * @return the newly created <code> EqualityGenConstraint </code>
     */
    public static EqualityGenConstraint createCopyOfConstraint(final EqualityGenConstraint otherConstraint,
            final Database db) {
        final EqualityGenConstraint newEgd = new EqualityGenConstraint(db);
        newEgd.premise = otherConstraint.premise;
        newEgd.equalities = otherConstraint.equalities;
        newEgd.leftTerms = otherConstraint.leftTerms;
        newEgd.rightTerms = otherConstraint.rightTerms;
        newEgd.createQueryEvaluation();
        return newEgd;
    }

    /**
     * Get equalities
     * 
     * @return return equalities
     */
    public List<Equality> getEqualities() {
        return equalities;
    }

    /**
     * Get the premise
     * 
     * @return the premise
     */
    public Statement getPremise() {
        return premise;
    }

    /**
     * Create equality array
     */
    private void createEqualityArrays() {
        final Predicate queryHead = premise.head();
        final int numOfEqualities = equalities.size();
        Equality equality;

        leftTerms = new int[numOfEqualities];
        rightTerms = new int[numOfEqualities];

        for (int i = 0; i < numOfEqualities; i++) {
            equality = equalities.get(i);
            leftTerms[i] = queryHead.variableIsAt(equality.getLeft());
            rightTerms[i] = queryHead.variableIsAt(equality.getRight());
        }
    }

    /**
     * Create a constraint query evaluation
     */
    private void createQueryEvaluation() {
        QueryTree queryTree = QueryTree.CreateQueryTree(premise, db);
        queryEvaluation = new QueryEvaluation(queryTree);
    }

    @Override
    public boolean enforce() throws InconsistencyException {
        LinkedList<Tuple> queryAnswer = queryEvaluation.run();
        boolean changedInstance = false;
        int answerSize = queryAnswer.size();
        int numOfEqualities = leftTerms.length;

        for (int i = 0; i < answerSize; i++) {
            final Tuple tuple = queryAnswer.removeFirst();
            for (int j = 0; j < numOfEqualities; j++) {
                Value left = tuple.getValue(leftTerms[j]);
                Value right = tuple.getValue(rightTerms[j]);
                if (!left.equalsByRepresentative(right)) {
                    boolean success = tuple.getValue(leftTerms[j]).equate(tuple.getValue(rightTerms[j]));
                    Value v1 = tuple.getValue(leftTerms[j]);
                    Value v2 = tuple.getValue(rightTerms[j]);
//                    if (success) {
//                        final List<String> relations = new ArrayList<>();
//                        final List<MapPredicates> map = queryEvaluation.getQueryTree().getLeaves();
//                        for (int k = 0; k < map.size(); k++) {
//                           
//                            relations.add(map.get(k).getPred().getRelation());
//                        }
//                        for (String name : relations) {
//                            if(!name.equals("E")){
//                                final List<MapPredicates> regoP = db.getRelationInstance(name).getRegOp();
//                                for (int k = 0; k < regoP.size(); k++) {
//                                    regoP.get(k).getIterator().reset();
//                                    regoP.get(k).pushAll();
//                                } 
//                            }
//                        }
//                    }

                    //                   final List<MapPredicates> map = t.relation().getRegOp();
                    //                  for (int k = 0; k < size; k++) {
                    //                      map.get(k).pushAll();
                    //                  }

                    //                    final List<Tuple> list = db.getTuplesContainingValue(v1);
                    //                    list.addAll(db.getTuplesContainingValue(v2));
                    //                    for (Tuple t : list) {
                    //                       int size = t.relation().getRegOp().size();
                    //                       final List<MapPredicates> map = t.relation().getRegOp();
                    //                       for (int k = 0; k < size; k++) {
                    //                           map.get(k).pushAll();
                    //                       }
                    //                    }
                    if (!success) {
                        throw new InconsistencyException(tuple.getValue(leftTerms[j]), tuple.getValue(rightTerms[j]),
                                db);
                    }
                    changedInstance = true;
                }
            }
        }
        return changedInstance;
    }

    @Override
    public void flush() {
        queryEvaluation.flush();
    }

    @Override
    public String toString() {
        final StringBuffer buf = new StringBuffer();
        buf.append("\t\t");
        buf.append(premise);
        buf.append("\n\t\t           IMPLIES\n\t\t");
        buf.append("(");
        buf.append(equalities.get(0).getLeft().toString());
        buf.append(" = ");
        buf.append(equalities.get(0).getRight().toString());
        buf.append(")");
        for (int i = 1; i < equalities.size(); i++) {
            buf.append(" AND (");
            Equality curEquality = equalities.get(i);
            buf.append(curEquality.getLeft().toString());
            buf.append(" = ");
            buf.append(curEquality.getRight().toString());
            buf.append(")");
        }
        return buf.toString();
    }

}
