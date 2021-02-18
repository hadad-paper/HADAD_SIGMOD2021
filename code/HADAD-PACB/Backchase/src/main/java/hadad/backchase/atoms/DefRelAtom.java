
package hadad.backchase.atoms;

import java.util.Arrays;

import org.apache.log4j.Logger;


/**
 * A relational atom in the definition of a constraint
 *
 */
public class DefRelAtom {
    private final static Logger LOGGER = Logger.getLogger(DefRelAtom.class);
    public static int countDefRelAtoms = 0;

    private Relation relation;
    private AtomPositionTerm[] terms;
    private int id;

    /** Constructor **/
    public DefRelAtom(Relation relation, int size) {
        this.relation = relation;
        this.terms = new AtomPositionTerm[size];
        this.id = countDefRelAtoms;
        countDefRelAtoms++;
    }

    /**
     * Set relation
     * 
     * @param relation
     */
    public void setRelation(final Relation relation) {
        this.relation = relation;
    }

    /**
     * Set AtomPositionTerms
     * 
     * @param terms
     */
    public void setAtomPositionTerms(final AtomPositionTerm[] terms) {
        this.terms = terms;
    }

    /**
     * Set an AtomPositionTerm
     * 
     * @param term
     *            the term
     * @param i
     *            the index
     */
    public void setAtomPositionTerm(final AtomPositionTerm term, int i) {
        this.terms[i] = term;
    }

    /**
     * Get relation
     * 
     * @return relation
     */
    public Relation getRelation() {
        return relation;
    }

    /**
     * Get AtomPositionTerms
     * 
     * @return terms
     */
    public AtomPositionTerm[] getAtomPositionTerms() {
        return terms;
    }

    /**
     * Get AtomPositionTerm
     * 
     * @param i
     *            the index
     * @return the term
     */
    public AtomPositionTerm getAtomPositionTerm(int i) {
        return terms[i];
    }

    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder();
        str.append(relation.getName());
        str.append(Arrays.toString(terms));
        return str.toString();
    }

}
