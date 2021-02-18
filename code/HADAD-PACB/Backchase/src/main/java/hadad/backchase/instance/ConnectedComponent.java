package hadad.backchase.instance;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import hadad.backchase.atoms.ResolvedEquality;
import hadad.backchase.atoms.ResolvedRelAtom;
import hadad.backchase.atoms.ResolvedTerm;
import hadad.backchase.provenanace.flatProvenance.FlatFormula;
import hadad.backchase.provenanace.provenanaceEvents.ProvChangedInComp;

/**
 * ConnectedComponents
 *
 */
public class ConnectedComponent {
    private final static Logger LOGGER = Logger.getLogger(ConnectedComponent.class);

    private ArrayList<ResolvedTerm> specialTerms;
    private ArrayList<ResolvedEquality> equalities;
    private Set<ResolvedRelAtom> atomWatchers;
    private Set<ResolvedEquality> equalityWatchers;
    private List<ArrayList<FlatFormula>> provenanceInClosure;
    private List<ArrayList<FlatFormula>> copyClosure;
    private int index;

    /**
     * Constructor
     * 
     * @param term
     *            the ResolvedTerm
     */
    public ConnectedComponent(final ResolvedTerm term) {
        index = ChasedInstance.zeInstance.countConnectedComponents;
        ChasedInstance.zeInstance.countConnectedComponents++;
        specialTerms = new ArrayList<ResolvedTerm>();
        specialTerms.add(term);
        equalities = new ArrayList<ResolvedEquality>();
        atomWatchers = new HashSet<ResolvedRelAtom>();
        equalityWatchers = new HashSet<ResolvedEquality>();
        ChasedInstance.zeInstance.addConnectedComponent(this);
        provenanceInClosure = new ArrayList<ArrayList<FlatFormula>>();
        provenanceInClosure.add(new ArrayList<FlatFormula>());
        copyClosure = new ArrayList<ArrayList<FlatFormula>>();
    }

    /**
     * adjust copy closure
     */
    private void adjustCopyClosure() {
        for (int i = 0; i < provenanceInClosure.size(); ++i) {
            if (i == copyClosure.size())
                copyClosure.add(new ArrayList<FlatFormula>());

            int initSize = copyClosure.get(i).size();
            for (int j = initSize; j < provenanceInClosure.get(i).size(); ++j)
                copyClosure.get(i).add(null);
        }
    }

    /**
     * Add special term
     * 
     * @param term
     *            the ResolvedTerm term to be added
     */
    private void addSpecialTerm(ResolvedTerm term) {
        term.setIndexComponenet(specialTerms.size());
        specialTerms.add(term);
    }

    /**
     * Merge other ConnectedComponent
     * 
     * @param other
     *            the other ConnectedComponent.
     * @param link
     *            the resolvedEquality link
     */
    private void mergeComponentIntoThis(final ConnectedComponent other, final ResolvedEquality link) {
        computeMergedClosureProvenance(other, link);
        provenanceInClosure.addAll(other.provenanceInClosure);
        adjustCopyClosure();
        for (int i = 0; i < other.specialTerms.size(); ++i) {
            other.specialTerms.get(i).setComponent(this);
            addSpecialTerm(other.specialTerms.get(i));
        }
        for (int i = 0; i < other.equalities.size(); ++i)
            equalities.add(other.equalities.get(i));
        equalities.add(link);
        atomWatchers.addAll(other.atomWatchers);
        equalityWatchers.addAll(other.equalityWatchers);
        other.equalities = null;
        other.specialTerms = null;
        other.atomWatchers = null;
        other.equalityWatchers = null;
        other.provenanceInClosure = null;
        ChasedInstance.zeInstance.setNeedsFlush();
    }

    /**
     * Compute merged Closure provenance
     * 
     * @param other
     *            the other ConnectedComponent.
     * @param link
     *            the resolvedEquality link
     */
    private void computeMergedClosureProvenance(final ConnectedComponent other, final ResolvedEquality link) {
        for (int i = 0; i < specialTerms.size(); ++i)
            for (int j = 0; j < other.specialTerms.size(); j++) {
                ResolvedTerm term1 = specialTerms.get(i);
                ResolvedTerm term2 = other.specialTerms.get(j);
                FlatFormula prov = new FlatFormula(link.getFlatFormula());
                if (term1 != link.getTerm1())
                    prov.addProductCanonical(getClosureProvenance(term1, link.getTerm1()));
                if (term2 != link.getTerm2())
                    prov.addProductCanonical(other.getClosureProvenance(term2, link.getTerm2()));
                provenanceInClosure.get(term1.getIndexComponenet()).add(prov);
            }
    }

    /**
     * Get closure provenance
     * 
     * @param term1
     *            the first ResolvedTerm term
     * @param term2
     *            the second ResolvedTerm term
     * @return the ClosureProvenance
     */
    public FlatFormula getClosureProvenance(final ResolvedTerm term1, final ResolvedTerm term2) {
        int index1 = term1.getIndexComponenet();
        int index2 = term2.getIndexComponenet();

        if (index1 > index2) {
            int aux = index1;
            index1 = index2;
            index2 = aux;
        }
        return provenanceInClosure.get(index1).get(index2 - index1 - 1);
    }

    /**
     * addPossiblyExisting
     * 
     * @param eq
     *            the ResolvedEquality
     * @return the new ResolvedEquality
     */
    public ResolvedEquality addPossiblyExisting(final ResolvedEquality eq) {
        if (eq.getTerm1().getComponent() != eq.getTerm2().getComponent()) {
            mergeComponentIntoThis(eq.getTerm2().getComponent(), eq);
            return eq;
        } else {
            for (int i = 0; i < equalities.size(); ++i)
                if (equalities.get(i).isSameAs(eq))
                    return equalities.get(i);
            equalities.add(eq);
            boolean provChanged = recomputeClosureEqualities(eq);
            if (provChanged && (atomWatchers.size() != 0 || equalityWatchers.size() != 0))
                ChasedInstance.zeInstance.addEvent(new ProvChangedInComp(specialTerms.get(0)));

            return eq;
        }
    }

    /**
     * Add ResolvedRelAtom watchers
     * 
     * @param atom
     *            the ResolvedRelAtom.
     */
    public void addWatcher(final ResolvedRelAtom atom) {
        atomWatchers.add(atom);
    }

    /**
     * Add ResolvedEquality watchers
     * 
     * @param eq
     *            the ResolvedEquality
     */
    public void addWatcher(final ResolvedEquality eq) {
        equalityWatchers.add(eq);
    }

    /**
     * Recompute closure equalities
     * 
     * @param eq
     *            the ResolvedEquality
     * @return <code> True </code> if closure can be recomputed, otherwise <code> False </code>
     */
    private boolean recomputeClosureEqualities(final ResolvedEquality eq) {
        boolean changed = false;
        for (int i = 0; i < provenanceInClosure.size(); ++i) {
            final ResolvedTerm term1 = specialTerms.get(i);
            final List<FlatFormula> crtProvenanceRow = provenanceInClosure.get(i);

            for (int j = 0; j < crtProvenanceRow.size(); j++) {
                final ResolvedTerm term2 = specialTerms.get(j + i + 1);
                final FlatFormula crtProvenance = crtProvenanceRow.get(j);
                copyClosure.get(i).set(j, new FlatFormula());
                final FlatFormula newProvenance = copyClosure.get(i).get(j);
                FlatFormula m_dummyFlatFormula = null;
                m_dummyFlatFormula = new FlatFormula(eq.getFlatFormula());
                if (term1 != eq.getTerm1())
                    m_dummyFlatFormula.addProductCanonical(getClosureProvenance(term1, eq.getTerm1()));
                if (term2 != eq.getTerm2())
                    m_dummyFlatFormula.addProductCanonical(getClosureProvenance(term2, eq.getTerm2()));
                newProvenance.addSumCanonical(m_dummyFlatFormula, false);

                m_dummyFlatFormula = new FlatFormula(eq.getFlatFormula());
                if (term1 != eq.getTerm2())
                    m_dummyFlatFormula.addProductCanonical(getClosureProvenance(term1, eq.getTerm2()));

                if (term2 != eq.getTerm1())
                    m_dummyFlatFormula.addProductCanonical(getClosureProvenance(term2, eq.getTerm1()));
                newProvenance.addSumCanonical(m_dummyFlatFormula, false);

                if (!newProvenance.isSubsumedBy(crtProvenance)) {
                    changed = true;
                }
            }
        }

        if (changed) {
            for (int i = 0; i < provenanceInClosure.size(); ++i)
                for (int j = 0; j < provenanceInClosure.get(i).size(); j++)
                    provenanceInClosure.get(i).get(j).addSumCanonical(copyClosure.get(i).get(j), false);
        }

        return changed;
    }

    /**
     * Updated provenance
     * 
     * @param eq
     *            the ResolvedEquality
     */
    public void provenanceChanged(ResolvedEquality eq) {
        boolean provChanged = recomputeClosureEqualities(eq);
        if (provChanged)
            ChasedInstance.zeInstance.addEvent(new ProvChangedInComp(specialTerms.get(0)));
    }

    /**
     * Get atom watchers
     * 
     * @return atomWatchers
     */
    public Set<ResolvedRelAtom> getAtomWatchers() {
        return atomWatchers;
    }

    /**
     * Get atom watchers
     * 
     * @return equalityWatchers
     */
    public Set<ResolvedEquality> getEqualityWatchers() {
        return equalityWatchers;
    }

    /**
     * Get index
     * 
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    public void displayContents() {
        if (null == equalities)
            return;
        System.out.println("\n\nconnected component");
        System.out.println("raw equalities");
        for (int i = 0; i < equalities.size(); ++i)
            System.out.println(equalities.get(i));

        System.out.println("closure equalities");
        for (int i = 0; i < provenanceInClosure.size(); ++i) {
            ArrayList<FlatFormula> crtRow = provenanceInClosure.get(i);
            for (int j = 0; j < crtRow.size(); ++j) {
                System.out
                        .print(specialTerms.get(i).getName() + "=" + specialTerms.get(j + i + 1).getName() + " prov:");
                System.out.println(crtRow.get(j));
            }
        }

    }
}
