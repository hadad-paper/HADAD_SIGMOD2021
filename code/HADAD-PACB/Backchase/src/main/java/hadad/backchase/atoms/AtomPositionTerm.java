package hadad.backchase.atoms;

import org.apache.log4j.Logger;

/**
 * A position in an atom (non-resolved atom attribute), these are used for the initial definitions of the constraints
 * for equalities in the premise, and for conclusion definitions
 * the class is also used to represent constants and Skolems
 *
 */
public class AtomPositionTerm {
    private final static Logger LOGGER = Logger.getLogger(AtomPositionTerm.class);

    /** The atom in the premise, null if this is a Skolem or constant */
    private DefRelAtom defRelAtom;
    /** The position in the atom, -1 if this is a Skolem of constant */
    private int attributeIndex;
    /** The constant, null if this is not a constant */
    private ResolvedTerm constant;
    /** The Skolem index at the constraint level, -1 if this is not a Skolem */
    private int skolemIndex;

    /** Constructor **/
    public AtomPositionTerm(DefRelAtom atom, int position) {
        defRelAtom = atom;
        attributeIndex = position;
        skolemIndex = -1;
        constant = null;
    }

    /**
     * Set definition relation atom
     * 
     * @param defRelAtom
     */
    public void setDefRelAtom(final DefRelAtom defRelAtom) {
        this.defRelAtom = defRelAtom;
    }

    /**
     * Set attribute index
     * 
     * @param attributeIndex
     */
    public void setAttributeIndex(final int attributeIndex) {
        this.attributeIndex = attributeIndex;
    }

    /**
     * Set resolved term (constant)
     * 
     * @param constant
     */
    public void setResolvedTerm(final ResolvedTerm constant) {
        this.constant = constant;
    }

    /**
     * Set Skolem Index
     * 
     * @param skolemIndex
     */
    public void setSkolemIndex(final int skolemIndex) {
        this.skolemIndex = skolemIndex;
    }

    /**
     * Get definition relation atom
     * 
     * @param defRelAtom
     */
    public DefRelAtom getDefRelAtom() {
        return defRelAtom;
    }

    /**
     * Get attribute index
     * 
     * @param attributeIndex
     */
    public int getAttributeIndex() {
        return attributeIndex;
    }

    /**
     * Get resolved term (constant)
     * 
     * @param constant
     */
    public ResolvedTerm getResolvedTerm() {
        return constant;
    }

    /**
     * Set Skolem Index
     * 
     * @param skolemIndex
     */
    public int getSkolemIndex() {
        return skolemIndex;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if (defRelAtom == null) {
            if (skolemIndex != -1) {
                str.append("SK_");
                str.append(skolemIndex);
            } else {
                str.append(constant);
            }
        } else {
            str.append(defRelAtom.getRelation().getName());
            str.append('.');
            str.append(attributeIndex);
        }
        return str.toString();
    }

    /**
     * Check if AtomPositionTerms are the same
     * 
     * @param other
     * @return <code> True </code> if there are the same, otherwise <code> False </code>
     */
    public boolean isSameAs(final AtomPositionTerm other) {
        return (defRelAtom == other.defRelAtom && attributeIndex == other.attributeIndex);
    }
}
