package hadad.backchase.provenanace.placeHodlerProvenance;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import hadad.backchase.atoms.ResolvedEquality;
import hadad.backchase.atoms.ResolvedRelAtom;
import hadad.backchase.atoms.ResolvedTerm;
import hadad.backchase.provenanace.flatProvenance.FlatFormula;

/**
 * PH Formula
 *
 */
public class PHFormula {

    private final static Logger LOGGER = Logger.getLogger(FlatFormula.class);
    /**
     * Conjuncts
     */
    private ArrayList<PHConjunct> conjuncts;

    /**
     * Constructor
     */
    public PHFormula() {
        conjuncts = new ArrayList<PHConjunct>();
    }

    /**
     * Constructor
     * 
     * @param conjunct
     *            provernance holder conjunct
     */
    public PHFormula(final PHConjunct conjunct) {
        conjuncts = new ArrayList<PHConjunct>();
        conjuncts.add(conjunct);
    }

    /**
     * Constructor (union formula)
     * 
     * @param form1
     *            the first provernance holder formula
     * @param form2
     *            the second provernance holder formula
     */
    public PHFormula(final PHFormula form1, final PHFormula form2) {
        conjuncts = new ArrayList<PHConjunct>();
        if (form1.conjuncts.size() == 0) {
            for (int i = 0; i < form2.conjuncts.size(); ++i)
                conjuncts.add(form2.conjuncts.get(i));
            return;
        }
        if (form2.conjuncts.size() == 0) {
            for (int i = 0; i < form1.conjuncts.size(); ++i)
                conjuncts.add(form1.conjuncts.get(i));
            return;
        }

        for (int i = 0; i < form1.conjuncts.size(); ++i)
            for (int j = 0; j < form2.conjuncts.size(); ++j)
                conjuncts.add(PHConjunct.getProduct(form1.conjuncts.get(i), form2.conjuncts.get(j)));
    }

    /**
     * Constructor
     * 
     * @param other
     *            provernance holder
     */
    public PHFormula(final PHFormula other) {
        conjuncts = new ArrayList<PHConjunct>();
        for (int i = 0; i < other.conjuncts.size(); ++i)
            conjuncts.add(other.conjuncts.get(i));
    }

    /**
     * Add equality
     * 
     * @param term1
     *            first term
     * @param term2
     *            second term
     */
    public void addEquality(final ResolvedTerm term1, final ResolvedTerm term2) {
        if (conjuncts.size() == 0)
            conjuncts.add(new PHConjunct());
        for (int i = 0; i < conjuncts.size(); ++i)
            conjuncts.get(i).addEquality(term1, term2);
    }

    /**
     * Add formula
     * 
     * @param formula
     *            the PHFormula formula
     */
    public void addSum(final PHFormula formula) {
        for (int i = 0; i < formula.conjuncts.size(); ++i)
            conjuncts.add(formula.conjuncts.get(i));
    }

    /**
     * Flatten formula
     * 
     * @return the flattened formula
     */
    public FlatFormula getFlattened() {
        FlatFormula formula = new FlatFormula();
        for (int i = 0; i < conjuncts.size(); ++i)
            formula.addSumCanonical(conjuncts.get(i).getFlattened(), false);
        return formula;
    }

    /**
     * Add atom watcher
     * 
     * @param atom
     *            the ResolvedRelAtom
     */
    public void addAtomWatcher(final ResolvedRelAtom atom) {
        for (int i = 0; i < conjuncts.size(); ++i)
            conjuncts.get(i).addAtomWatcher(atom);
    }

    /**
     * Add equality atom
     * 
     * @param eq
     *            the ResolvedEquality
     */
    public void addEqualityWatcher(final ResolvedEquality eq) {
        for (int i = 0; i < conjuncts.size(); ++i)
            conjuncts.get(i).addEqualityWatcher(eq);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(conjuncts);
        return str.toString();
    }

}
