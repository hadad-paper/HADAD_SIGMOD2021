package hadad.backchase.atoms;

import org.apache.log4j.Logger;

import hadad.backchase.instance.ChasedInstance;
import hadad.backchase.provenanace.flatProvenance.FlatFormula;
import hadad.backchase.provenanace.placeHodlerProvenance.PHFormula;
import hadad.backchase.provenanace.provenanaceEvents.ProvChangedOnEquality;

/**
 * An equality in the instance
 *
 */
public class ResolvedEquality {
    private final static Logger LOGGER = Logger.getLogger(ResolvedEquality.class);

    private ResolvedTerm term1;
    private ResolvedTerm term2;

    private FlatFormula flatProvenance;
    private PHFormula placeHolderProvenance;

    /** Constructor **/
    public ResolvedEquality() {
        flatProvenance = null;
        placeHolderProvenance = null;
    }

    /**
     * Set provenance
     * 
     * @param flatProvenance
     *            flat provenance (conjunct)
     * @param phProvenance
     *            ph provenance
     */
    public void setProvenance(final FlatFormula flatProvenance, final PHFormula phProvenance) {
        if (flatProvenance == null)
            throw new IllegalArgumentException("The parameter 'flatProvenance' cannot be null.");
        if (phProvenance == null)
            throw new IllegalArgumentException("The parameter 'phProvenance' cannot be null.");
        this.flatProvenance = new FlatFormula(flatProvenance);
        this.placeHolderProvenance = phProvenance;
    }

    /**
     * Check if ResolvedEqualities are the same
     * 
     * @param resolvedEquality
     *            the resolved equality
     * @return <code> True </code> if there are the same, otherwise <code> False </code>
     */
    public boolean isSameAs(final ResolvedEquality resolvedEquality) {
        if (term1 == resolvedEquality.term1 && term2 == resolvedEquality.term2)
            return true;
        else if (term1 == resolvedEquality.term2 && term2 == resolvedEquality.term1)
            return true;
        else
            return false;
    }

    /**
     * Equality Watcher
     * 
     * @param PHFormula
     */
    public void registerAsWatcher(final PHFormula formula) {
        formula.addEqualityWatcher(this);
    }

    /**
     * Updated provenance when changed
     */
    public void provenanceChanged() {
        FlatFormula newFormula = placeHolderProvenance.getFlattened();
        if (!newFormula.isSubsumedBy(flatProvenance)) {
            flatProvenance = newFormula;
            ChasedInstance.zeInstance.addEvent(new ProvChangedOnEquality(this));
        }
    }

    /**
     * Set term1
     * 
     * @param term1
     */
    public void setTerm1(final ResolvedTerm term1) {
        this.term1 = term1;
    }

    /**
     * Set term2
     * 
     * @param term2
     */
    public void setTerm2(final ResolvedTerm term2) {
        this.term2 = term2;
    }

    /**
     * Set flat provenanace
     * 
     * @param flatProvenance
     */
    public void setFlatFormula(final FlatFormula flatProvenance) {
        this.flatProvenance = flatProvenance;
    }

    /**
     * Set flat placeHolderProvenance
     * 
     * @param flatProvenance
     */
    public void setplaceHolderProvenance(final PHFormula placeHolderProvenance) {
        this.placeHolderProvenance = placeHolderProvenance;
    }

    /**
     * Get term1
     * 
     * @return term1
     */
    public ResolvedTerm getTerm1() {
        return term1;
    }

    /**
     * Get term2
     * 
     * @return term2
     */
    public ResolvedTerm getTerm2() {
        return term2;
    }

    /**
     * Get flat provenanace
     * 
     * @return flatProvenance
     */
    public FlatFormula getFlatFormula() {
        return flatProvenance;
    }

    /**
     * Set placeHolderProvenance
     * 
     * @return placeHolderProvenance
     */
    public PHFormula getPlaceHolderProvenance() {
        return placeHolderProvenance;
    }

    /**
     * Set term2
     * 
     * @param term2
     */
    public ResolvedTerm settTerm2() {
        return term2;
    }

    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder();
        str.append(term1);
        str.append("=");
        str.append(term2);
        str.append("prov:");
        str.append(flatProvenance);
        return str.toString();
    }

}
