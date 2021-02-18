package hadad.backchase.provenanace.placeHodlerProvenance;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;

import hadad.backchase.atoms.ResolvedEquality;
import hadad.backchase.atoms.ResolvedRelAtom;
import hadad.backchase.atoms.ResolvedTerm;
import hadad.backchase.provenanace.flatProvenance.FlatFormula;

/**
 * PHConjunct
 */
public class PHConjunct {
    private final static Logger LOGGER = Logger.getLogger(PHConjunct.class);
   
    private Set<ResolvedRelAtom> atoms;
    private Map<ResolvedTerm, Set<ResolvedTerm>> equalities;

    public PHConjunct() {
        atoms = new HashSet<>();
        equalities = new HashMap<>();
    }

    /**
     * Add atom
     * 
     * @param atom
     *            atom to be added
     */
    public void addAtom(final ResolvedRelAtom atom) {
        atoms.add(atom);
    }

    /**
     * Add equality
     * 
     * @param term1
     *            equality term 1
     * @param term2
     *            equality term 2
     */
    public void addEquality(final ResolvedTerm term1, final ResolvedTerm term2) {
        if (term1 == term2)
            return;
        if (term1.getIndex() > term2.getIndex())
            addEquality(term2, term1);
        else {
            Set<ResolvedTerm> crt = equalities.get(term1);
            if (crt == null) {
                crt = new HashSet<ResolvedTerm>();
                equalities.put(term1, crt);
            }
            crt.add(term2);
        }
    }

    /**
     * Get provenanace holders product
     * 
     * @param conj1
     *            the first conjunct
     * @param conj2
     *            the first conjunct
     * @return the product conjunct
     */
    public static PHConjunct getProduct(final PHConjunct conj1, final PHConjunct conj2) {
        PHConjunct prod = new PHConjunct();
        for (ResolvedRelAtom atom : conj1.atoms)
            prod.atoms.add(atom);
        for (ResolvedRelAtom atom : conj2.atoms)
            prod.atoms.add(atom);

        for (ResolvedTerm t1 : conj1.equalities.keySet())
            for (ResolvedTerm t2 : conj1.equalities.get(t1))
                prod.addEquality(t1, t2);

        for (ResolvedTerm t1 : conj2.equalities.keySet())
            for (ResolvedTerm t2 : conj2.equalities.get(t1))
                prod.addEquality(t1, t2);

        return prod;

    }
    /**
     * Get flattened formula
     * @return the flattened formula
     */
    public FlatFormula getFlattened() {
        FlatFormula formula = null;
        Iterator<ResolvedRelAtom> atomsIt = atoms.iterator();
        if (atomsIt.hasNext()) {
            formula = new FlatFormula(atomsIt.next().getFlatFormula());
        }
        while (atomsIt.hasNext()) {
            formula.addProductCanonical(atomsIt.next().getFlatFormula());
        }
        for (ResolvedTerm t1 : equalities.keySet()) {
            for (ResolvedTerm t2 : equalities.get(t1)) {
                if (formula == null) {
                    formula = new FlatFormula(t1.getComponent().getClosureProvenance(t1, t2));
                } else {
                    formula.addProductCanonical(t1.getComponent().getClosureProvenance(t1, t2));
                }
            }
        }
        return formula;
    }

    /**
     * Add atom watcher
     * 
     * @param atom
     *            an atom
     */
    public void addAtomWatcher(final ResolvedRelAtom atom) {
        for (ResolvedRelAtom exists : atoms)
            exists.addWatcher(atom);
        for (ResolvedTerm t1 : equalities.keySet())
            t1.getComponent().addWatcher(atom);
    }

    /**
     * Add equality watcher
     * 
     * @param eq
     *            an equality
     */
    public void addEqualityWatcher(final ResolvedEquality eq) {
        for (ResolvedRelAtom exists : atoms)
            exists.addWatcher(eq);
        for (ResolvedTerm t1 : equalities.keySet())
            t1.getComponent().addWatcher(eq);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Atoms:");
        sb.append(atoms);
        sb.append(" Equalities:");
        sb.append(equalities);
        return sb.toString();
    }

}
