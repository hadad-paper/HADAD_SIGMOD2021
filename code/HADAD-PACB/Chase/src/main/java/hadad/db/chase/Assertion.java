package hadad.db.chase;

import hadad.db.canonicaldb.Database;
import hadad.db.datalogexpr.Statement;

/**
 * This class represents an assertion in the context of a
 * <code>CanonicalDB<code>, which is a constraint with a
 * given conclusion and a premise that always holds.
 */
public class Assertion extends Constraint {
    /** Assertion conclusion */
    private final Statement conclusion;

    /**
     * Constructor
     * 
     * @param conclusion
     *            assertion's conclusion
     * @param db
     *            the database
     */
    public Assertion(final Statement conclusion, final Database db) {
        super(db);
        this.conclusion = conclusion;
    }

    /**
     * Copy of the assertion
     * 
     * @param oldAssertion
     * @param db
     * @return the newly created assertion
     */
    public static Assertion createCopyOfConstraint(final Assertion otherAssertion, final Database db) {
        Assertion newAssertion = new Assertion(otherAssertion.conclusion, db);
        return newAssertion;
    }

    /**
     * Get assertion conclusion
     * 
     * @return the conclusion
     */
    public Statement getConclusion() {
        return conclusion;
    }

    @Override
    public boolean enforce() {
        createFreshInstanceOfQueryBody(conclusion, null, false);
        return true;
    }

    @Override
    public void flush() {
    }

    @Override
    public String toString() {
        final StringBuffer str = new StringBuffer();
        str.append("\t\t");
        str.append(conclusion.toString());
        return str.toString();
    }

}
