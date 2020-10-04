package hadad.db.chase;

import java.util.LinkedList;
import java.util.logging.Logger;

import hadad.db.canonicaldb.Database;
import hadad.db.canonicaldb.Tuple;
import hadad.db.datalogexpr.Statement;
import hadad.db.query.QueryEvaluation;
import hadad.db.query.QueryTree;

/**
 * This class represents a constraint in the context of a
 * <code>CanonicalDB<code>, which generates a <code>ConstraintTuple</code>
 * when used by the <code>Chase</code>. Foreign key and mapping
 * constraints are of this type. Such constraints have a given
 * premise and a conclusion, both being <code>Statement</code> objects.
 */
public class TupleGenConstraint extends Constraint {
    /** Logger */
    private final static Logger LOGGER = Logger.getLogger(TupleGenConstraint.class.getName());

    /** The premise of the constraint */
    private Statement premise;
    /** The conclusion of the constraint */
    private Statement conclusion;
    /** The <code>QueryEvaluation</code> object used to evaluate the query corresponding to the constraint */
    private QueryEvaluation queryEvaluation;

    /**
     * Constructor
     * 
     * @param db
     *            the database
     */
    private TupleGenConstraint(final Database db) {
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
    public TupleGenConstraint(final Statement premise, final Statement conclusion, final Database db) {
        super(db);
        this.premise = premise;
        this.conclusion = conclusion;
        createQueryEvaluation();
    }

    /**
     * Create a copy of another constraints
     * 
     * @param otherConstraint
     *            other constraint
     * @param db
     *            the database
     * @return the newly created <code> TupleGenConstraint </code>
     */
    public static TupleGenConstraint createCopyOfConstraint(final TupleGenConstraint otherConstraint,
            final Database db) {
        final TupleGenConstraint newTgd =
                new TupleGenConstraint(otherConstraint.premise, otherConstraint.conclusion, db);
        return newTgd;
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
     * Get the conclusion
     * 
     * @return the conclusion
     */
    public Statement getConclusion() {
        return conclusion;
    }

    /**
     * Create a query evaluation
     */
    private void createQueryEvaluation() {
        QueryTree queryTree = QueryTree.CreateQueryTreeForDifference(premise, conclusion, db);
        queryEvaluation = new QueryEvaluation(queryTree);
    }

    @Override
    public boolean enforce() {
        LinkedList<Tuple> queryAnswer = queryEvaluation.run();
        int size = queryAnswer.size();
        for (int i = 0; i < size; i++) {
            createFreshInstanceOfQueryBody(conclusion, queryAnswer.removeFirst(), true);
        }
        return (size > 0);
    }

    @Override
    public void flush() {
        queryEvaluation.flush();
    }
}
