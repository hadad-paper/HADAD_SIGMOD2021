package hadad.db.chase;

import java.util.LinkedList;

import hadad.db.canonicaldb.Database;
import hadad.db.canonicaldb.Tuple;
import hadad.db.chaseexceptions.InconsistencyException;
import hadad.db.datalogexpr.Statement;
import hadad.db.query.QueryEvaluation;
import hadad.db.query.QueryTree;

/**
 * This class represents a constraint in the context of a
 * <code>CanonicalDB<code>, which generates an <code>Denial</code>
 * when used by the <code>Chase</code>.
 */
public class DenialConstraint extends Constraint {

    /** The premise of the constraint */
    private Statement premise;

    /** The boolean conclusion, which is always <code> False </code> */
    private boolean conclusion;

    /**
     * The <code>QueryEvaluation</code> object used to evaluate the query
     * corresponding to the constraint
     */
    private QueryEvaluation queryEvaluation;

    /**
     * Constructor
     * 
     * @param db
     *            the database
     */
    private DenialConstraint(final Database db) {
        super(db);
    }

    /**
     * Constructor
     * 
     * @param premise
     *            the premise
     * @param db
     *            the database
     */
    public DenialConstraint(final Statement premise, final Database db) {
        super(db);
        this.premise = premise;
        this.conclusion = false;
        createQueryEvaluation();
    }

    /**
     * Create a copy of a constraint
     * 
     * @param otherDenial
     *            the other constraint
     * @param db
     *            the database
     * @return the newly created constraint
     */
    public static DenialConstraint createCopyOfConstraint(final DenialConstraint otherDenial, final Database db) {
        DenialConstraint newDenial = new DenialConstraint(db);
        newDenial.premise = otherDenial.premise;
        newDenial.createQueryEvaluation();
        return newDenial;
    }

    /**
     * Get the conclusion
     * 
     * @return the conclusion
     */
    public boolean getConclusion() {
        return conclusion;
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
     * Create the constraint query evaluation
     */
    private void createQueryEvaluation() {
        final QueryTree queryTree = QueryTree.CreateQueryTree(premise, db);
        queryEvaluation = new QueryEvaluation(queryTree);
    }

    @Override
    public boolean enforce() throws InconsistencyException {
        LinkedList<Tuple> queryAnswer = queryEvaluation.run();
        boolean changedInstance = false;
        int answerSize = queryAnswer.size();
        if (answerSize > 0) {
            changedInstance = true;
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
        buf.append(conclusion);
        buf.append(")");
        return buf.toString();
    }

}
