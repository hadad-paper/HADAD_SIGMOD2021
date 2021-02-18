package hadad.backchase.atoms;

import org.apache.log4j.Logger;

/**
 * An equality on two positions of two atoms
 * part of the definition of the premise
 */

public class DefEquality {
    private final static Logger LOGGER = Logger.getLogger(DefEquality.class);

    private AtomPositionTerm term1;
    private AtomPositionTerm term2;

    /** Constructor **/
    public DefEquality(final AtomPositionTerm term1, final AtomPositionTerm term2) {
        this.term1 = term1;
        this.term2 = term2;
    }

    /**
     * Set Term 1
     * 
     * @param term1
     */
    public void setTerm1(final AtomPositionTerm term1) {
        this.term1 = term1;
    }

    /**
     * Set Term 2
     * 
     * @param term2
     */
    public void setTerm2(final AtomPositionTerm term2) {
        this.term2 = term2;
    }

    /**
     * Get Term 1
     */
    public AtomPositionTerm getAtomPositionTerm1() {
        return term1;
    }

    /**
     * Get Term 2
     */
    public AtomPositionTerm getAtomPositionTerm2() {
        return term2;
    }

    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder();
        str.append(term1);
        str.append("=");
        str.append(term2);

        return str.toString();
    }
}
