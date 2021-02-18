package hadad.backchase.provenanace.flatProvenance;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import hadad.backchase.instance.ChasedInstance;
import hadad.backchase.instance.Switches;

/**
 * A provenance formula as a sum of conjuncts
 *
 */
public class FlatFormula {
    private final static Logger LOGGER = Logger.getLogger(FlatFormula.class);
    private static ArrayList<FlatConjunct> prodList = new ArrayList<FlatConjunct>(50);
    private static ArrayList<FlatConjunct> sumList = new ArrayList<FlatConjunct>(50);
    private static ArrayList<FlatConjunct> deltaList = new ArrayList<FlatConjunct>(50);
    private static ArrayList<Boolean> statusList = new ArrayList<Boolean>(50);

    private ArrayList<FlatConjunct> conjuncts;

    /**
     * Constructor
     */
    public FlatFormula() {
        conjuncts = new ArrayList<FlatConjunct>();
    }

    /**
     * Constructor
     * Creates a new FlatFormula which is a copy of the
     * one passed as parameter.
     * 
     * @param other
     *            the FlatFormula which we want to copy
     */
    public FlatFormula(final FlatFormula other) {
        if (other == null)
            throw new IllegalArgumentException("The input formula cannot be null.");

        conjuncts = new ArrayList<FlatConjunct>();
        for (FlatConjunct conjuct : other.conjuncts) {
            FlatConjunct copy = new FlatConjunct(conjuct);
            conjuncts.add(copy);
        }
    }

    /**
     * Constructor
     * Creates a new FlatFormula from the one passed as a parameter
     * 
     * @param conjunct
     *            to be added conjunct
     */
    public FlatFormula(final FlatConjunct conjunct) {
        conjuncts = new ArrayList<FlatConjunct>();
        conjuncts.add(conjunct);
    }

    /**
     * Add new flat conjunct to this formula
     * 
     * @param conjunct
     *            to be added conjunct
     */
    public void addFlatConjunct(final FlatConjunct conjunct) {
        if (conjunct != null)
            conjuncts.add(conjunct);

    }

    /**
     * Add product canonical
     * 
     * @param formula
     *            provenance formula
     */
    public void addProductCanonical(final FlatFormula formula) {
        int othersize = formula.conjuncts.size();
        if (othersize == 0)
            conjuncts.clear();
        int thissize = conjuncts.size();
        if (thissize == 0)
            return;

        prodList.clear();
        statusList.clear();
        for (int i = 0; i < thissize * othersize; ++i)
            statusList.add(true);

        for (int i = 0; i < thissize; ++i) {
            FlatConjunct crtConjunct = conjuncts.get(i);
            for (int j = 0; j < othersize; ++j) {
                FlatConjunct prod = FlatConjunct.getProduct(crtConjunct, formula.conjuncts.get(j));

                boolean isValid = true;
                if (Switches.COST_ON)
                    if (prod.getCost() >= ChasedInstance.zeInstance.m_query.getMinCost())
                        isValid = false;

                if (isValid) {
                    for (int k = 0; k < thissize; k++)
                        if (k != i)
                            if (statusList.get(k * othersize + j)) //the product is not subsumed by some other
                                if (prod.isSubsumedBy(conjuncts.get(k))) {
                                    isValid = false;
                                    break;
                                }
                }
                if (isValid) {
                    for (int k = 0; k < othersize; k++)
                        if (k != j)
                            if (statusList.get(i * othersize + k)) //the product is not subsumed by some other
                                if (prod.isSubsumedBy(formula.conjuncts.get(k))) {
                                    isValid = false;
                                    break;
                                }
                }

                if (!isValid)
                    statusList.set(i * othersize + j, false);
                else
                    prodList.add(prod);
            }
        }

        final ArrayList<FlatConjunct> aux = conjuncts;
        conjuncts = prodList;
        prodList = aux;

    }

    /**
     * Add sum canonical
     * 
     * @param toAdd
     *            canonical to add
     * @param retainOnlyDelta
     * @return <code> True </code> if sum canonical added, otherwise <code> False </code>
     */
    public boolean addSumCanonical(final FlatFormula toAdd, boolean retainOnlyDelta) {
        deltaList.clear();
        statusList.clear();
        int thissize = conjuncts.size();
        for (int j = 0; j < thissize; ++j)
            statusList.add(false);
        boolean origSubsumed = false;
        for (int i = 0; i < toAdd.conjuncts.size(); ++i) {
            final FlatConjunct crtConjunct = toAdd.conjuncts.get(i);
            boolean subsumed = false;
            for (int j = 0; j < thissize; ++j) {
                if (crtConjunct.isSubsumedBy(this.conjuncts.get(j))) {
                    subsumed = true;
                    break;
                }
            }
            if (!subsumed) {
                deltaList.add(crtConjunct);
                for (int j = 0; j < thissize; ++j)
                    if (this.conjuncts.get(j).isSubsumedBy(crtConjunct)) {
                        statusList.set(j, true);
                        origSubsumed = true;
                    }
            }
        }
        if (origSubsumed) {
            sumList.clear();
            for (int j = 0; j < thissize; ++j)
                if (!statusList.get(j))
                    sumList.add(this.conjuncts.get(j));
            ArrayList<FlatConjunct> aux = this.conjuncts;
            this.conjuncts = sumList;
            sumList = aux;
        }
        for (int i = 0; i < deltaList.size(); ++i)
            conjuncts.add(deltaList.get(i));

        boolean result = deltaList.size() == 0;
        if (retainOnlyDelta) {
            ArrayList<FlatConjunct> aux = toAdd.conjuncts;
            toAdd.conjuncts = deltaList;
            deltaList = aux;
        }
        return result;
    }

    /**
     * Check if this formula is subsumed by another formula
     * 
     * @param other
     *            other flat formula
     * @return <code> True </code> if the flat formula is subsumed by other, otherwise <code> False </code>
     */
    public boolean isSubsumedBy(final FlatFormula other) {
        int thissize = conjuncts.size();
        int othersize = other.conjuncts.size();
        for (int i = 0; i < thissize; ++i) {
            boolean subsumed = false;
            FlatConjunct crtConjunct = conjuncts.get(i);
            for (int j = 0; j < othersize; ++j)
                if (crtConjunct.isSubsumedBy(other.conjuncts.get(j))) {
                    subsumed = true;
                    break;
                }
            if (!subsumed)
                return false;
        }
        return true;
    }

    /**
     * Shrink to minimum cost
     * 
     * @return shrinked cost
     */
    public int shrinkToMinCost() {
        FlatConjunct minConj = conjuncts.get(0);
        for (int i = 1; i < conjuncts.size(); ++i)
            if (conjuncts.get(i).getCost() < minConj.getCost())
                minConj = conjuncts.get(i);
        conjuncts.clear();
        conjuncts.add(minConj);
        return minConj.getCost();
    }

    /**
     * Check if formula is canonical
     * 
     * @return <code> True </code> if the flat formula is canonical, otherwise <code> False </code>
     */
    public boolean isCanonical() {
        for (int i = 0; i < conjuncts.size(); i++)
            for (int j = i + 1; j < conjuncts.size(); ++j) {
                if (conjuncts.get(i).isSubsumedBy(conjuncts.get(j)))
                    return false;
                if (conjuncts.get(j).isSubsumedBy(conjuncts.get(i)))
                    return false;
            }
        return true;
    }

    /**
     * Get conjuncts
     * 
     * @return conjuncts
     */
    public List<FlatConjunct> getConjuncts() {
        return conjuncts;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        Iterator<FlatConjunct> it = conjuncts.iterator();
        while (it.hasNext()) {
            FlatConjunct conj = it.next();
            sb.append(conj);
            if (it.hasNext()) {
                sb.append("+");
            }
        }
        return sb.toString();
    }

}
