package hadad.backchase.atoms;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;

import hadad.backchase.instance.ChasedInstance;
import hadad.backchase.provenanace.flatProvenance.FlatFormula;
import hadad.backchase.provenanace.placeHodlerProvenance.PHFormula;
import hadad.backchase.provenanace.provenanaceEvents.ProvChangedOnAtom;

/**
 * A relational atom in the instance
 *
 */
public class ResolvedRelAtom {
    private final static Logger LOGGER = Logger.getLogger(ResolvedRelAtom.class);

    private Relation relation;
    private ResolvedTerm[] terms;
    private Set<ResolvedRelAtom> atomWatchers;
    private Set<ResolvedEquality> equalityWatchers;
    private FlatFormula flatProvenance;
    private PHFormula placeHolderProvenance;
    private StringBuffer key;

    /**
     * Constructor
     * 
     * @param relation
     *            relation
     * @param size
     *            terms size
     */
    public ResolvedRelAtom(final Relation relation, int size) {
        this.relation = relation;
        terms = new ResolvedTerm[size];
        atomWatchers = new HashSet<ResolvedRelAtom>();
        equalityWatchers = new HashSet<ResolvedEquality>();
        flatProvenance = null;
        placeHolderProvenance = new PHFormula();
        key = new StringBuffer();

    }

    /**
     * Set Provenance
     * 
     * @param flatProvenance
     *            the flat provenance.
     * @param phProvenance
     *            the ph provenance
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
     * Compute relation key
     */
    public void computeKey() {
        key.setLength(0);
        for (int i = 0; i < terms.length; ++i) {
            key.append(terms[i].getName());
            key.append(" ");
        }
    }

    /**
     * Relation watcher
     * 
     * @param atom
     *            new relation atom added
     */
    public void addWatcher(final ResolvedRelAtom atom) {
        atomWatchers.add(atom);
    }

    /**
     * Equality watcher
     * 
     * @param eq
     *            new equality added
     */
    public void addWatcher(final ResolvedEquality eq) {
        equalityWatchers.add(eq);
    }

    /**
     * Check if two relation atoms are the same
     * 
     * @param other
     *            relation atom
     * @return <code> True </code> if the are the same, otherwise, <code> False </code>
     */
    public boolean isSameAs(final ResolvedRelAtom other) {
        for (int i = 0; i < terms.length; ++i)
            if (terms[i] != other.terms[i])
                return false;
        return true;
    }

    /**
     * Register watcher
     * 
     * @param formula
     */
    public void registerAsWatcher(final PHFormula formula) {
        formula.addAtomWatcher(this);
    }

    /**
     * Updated relation atom provenance
     */
    public void provenanceChanged() {
        final FlatFormula newFormula = placeHolderProvenance.getFlattened();
        if (!newFormula.isSubsumedBy(flatProvenance)) {
            flatProvenance = newFormula;
            ChasedInstance.zeInstance.addEvent(new ProvChangedOnAtom(this));
        }
    }

    /**
     * Set relation
     * 
     * @param relation
     *            new relation
     */
    public void setRelation(final Relation relation) {
        this.relation = relation;
    }

    /**
     * Set relation atom terms
     * 
     * @param terms
     *            relation terms
     */
    public void setTerms(final ResolvedTerm[] terms) {
        this.terms = terms;
    }

    /**
     * Set flat provenance
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
     * Get relation
     * 
     * @return relation
     */
    public Relation getRelation() {
        return relation;
    }

    /**
     * Get relation resolved terms
     * 
     * @return relation terms
     */
    public ResolvedTerm[] getResolvedTerms() {
        return terms;
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
     * Get the relation key
     * 
     * @return
     */
    public String getKey() {
        return key.toString();
    }

    /**
     * Get AtomWatchers
     * 
     * @return atom watchers
     */
    public Set<ResolvedRelAtom> getAtomWatchers() {
        return atomWatchers;
    }

    /**
     * Get EqualityWatchers
     * 
     * @return equality watchers
     */
    public Set<ResolvedEquality> getEqualityWatchers() {
        return equalityWatchers;
    }

    @Override
    public String toString() {

        final StringBuilder str = new StringBuilder();
        str.append(relation.getName());
        str.append("(");
        for (int i = 0; i < terms.length; ++i) {
            str.append(terms[i]);
            if (i < terms.length - 1)
                str.append(",");
            else
                str.append(")");
        }
        str.append(" prov: ");
        str.append(flatProvenance);
        return str.toString();
    }
}
