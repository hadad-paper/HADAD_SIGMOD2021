package hadad.backchase.Utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.log4j.Logger;

import hadad.backchase.provenanace.flatProvenance.FlatConjunct;
import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.conjunctivequery.Term;

/**
 * Naive costing based on matrix-multiplication intermediate results.
 *
 */
public final class CostingMatrixModel {
    private final static Logger LOGGER = Logger.getLogger(NaiveCosting.class);
    private final static Map<Term, ImmutablePair<Integer, Integer>> UPLAN_SIZE_MAPPING = new HashMap<>();

    private CostingMatrixModel() {
    };

    /**
     * Find minimum-cost rewriting
     * 
     * @param provenanaceFormula
     * @param uplanAtoms
     * @return
     */
    public static ConjunctiveQuery findRewriting(final List<FlatConjunct> provenanaceFormula,
            final ConjunctiveQuery uPlan, final ConjunctiveQuery query) {

        double costsoFar = getCost(query);
        final List<Atom> uPlanAtoms = new ArrayList<>();
        for (Atom tmp : uPlan.getBody())
            uPlanAtoms.add(tmp);
        final List<Term> head = uPlan.getHead();

        ConjunctiveQuery minRewriting = null;
        for (int i = 0; i < provenanaceFormula.size(); ++i) {
            ArrayList<Atom> rwAtoms = new ArrayList<Atom>();
            String conjStr = provenanaceFormula.get(i).toString();
            String[] symbols = conjStr.split(",");
            for (int j = 0; j < symbols.length; ++j)
                if (symbols[j].substring(0, 1).equals("p")) {
                    int index = Integer.parseInt(symbols[j].substring(1));
                    rwAtoms.add(uPlanAtoms.get(index));
                }

            final ConjunctiveQuery rewriting = new ConjunctiveQuery("RW" + String.valueOf(0), head, rwAtoms);
            final double rwCost = getCost(rewriting);
            if (rwCost <= costsoFar) {
                minRewriting = rewriting;
                costsoFar = rwCost;
            }
        }
        return minRewriting;
    }

    /**
     * Special implementation for pruned costing
     * 
     * @param provenanaceFormula
     *            the provenanace formula
     * @param uPlan
     *            the universal plan
     * @return minimum-cost-rewriting so far
     */
    public static void findRewriting(final List<FlatConjunct> provenanaceFormula, final ConjunctiveQuery uPlan) {

        final List<Atom> uPlanAtoms = new ArrayList<>();
        for (Atom tmp : uPlan.getBody())
            uPlanAtoms.add(tmp);
        final List<Term> head = uPlan.getHead();

        for (int i = 0; i < provenanaceFormula.size(); ++i) {
            ArrayList<Atom> rwAtoms = new ArrayList<Atom>();
            String conjStr = provenanaceFormula.get(i).toString();
            String[] symbols = conjStr.split(",");
            for (int j = 0; j < symbols.length; ++j)
                if (symbols[j].substring(0, 1).equals("p")) {
                    int index = Integer.parseInt(symbols[j].substring(1));
                    rwAtoms.add(uPlanAtoms.get(index));
                }

            final ConjunctiveQuery rewriting = new ConjunctiveQuery("RW" + String.valueOf(0), head, rwAtoms);
            final double rwCost = getCost(rewriting);
            if (rwCost <= PrunedCosting.threshHold) {
                PrunedCosting.minRewriting = rewriting;
                PrunedCosting.threshHold = rwCost;
            }
        }

    }

    /**
     * Find the cost of the query
     * 
     * @param query
     * @return the query cost
     */
    public static double getCost(final ConjunctiveQuery query) {
        final Map<Term, ImmutablePair<Integer, Integer>> sizeMapping = new HashMap<>();
        final List<Atom> nonSizeAtoms = new ArrayList<>();
        final Set<Term> inputMatrices = new HashSet<>();
        final Set<Term> inputMatricesMulti = new HashSet<>();

        for (final Atom atom : query.getBody()) {
            if (atom.getPredicate().equals("size")) {
                final Term term1 = atom.getTerm(1);
                final Term term2 = atom.getTerm(2);
                if (term1.isConstant() && term2.isConstant()) {
                    final ImmutablePair<Integer, Integer> size =
                            ImmutablePair.of(Integer.parseInt(term1.toString().replace("\"", "")),
                                    Integer.parseInt(term2.toString().replace("\"", "")));
                    sizeMapping.put(atom.getTerm(0), size);
                }
            } else {
                if (atom.getPredicate().toLowerCase().equals("multi")) {
                    inputMatricesMulti.add(atom.getTerm(0));
                    inputMatricesMulti.add(atom.getTerm(1));
                    nonSizeAtoms.add(atom);
                }

                if (atom.getPredicate().toLowerCase().equals("tr")) {
                    nonSizeAtoms.add(atom);
                }
                if (atom.getPredicate().toLowerCase().equals("in")) {
                    nonSizeAtoms.add(atom);
                }

            }
        }
        final Queue<Atom> atomsToBeProcessed = new LinkedList<>(nonSizeAtoms);
        int totalCost = 0;
        while (atomsToBeProcessed.size() > 1) {
            final Atom atom = atomsToBeProcessed.poll();

            if (atom.getPredicate().toLowerCase().equals("multi")) {

                final Term term1 = atom.getTerm(0);
                final Term term2 = atom.getTerm(1);
                if (sizeMapping.containsKey(term1) && sizeMapping.containsKey(term2)
                        && inputMatricesMulti.contains(atom.getTerm(2))) {
                    final int newRow = sizeMapping.get(term1).getKey();
                    final int newCol = sizeMapping.get(term2).getValue();
                    final double innerCost = newRow * newCol;
                    sizeMapping.put(atom.getTerm(2), ImmutablePair.of(newRow, newCol));
                    totalCost += innerCost;
                } else {
                    if (inputMatricesMulti.contains(atom.getTerm(2))
                            || (inputMatrices.contains(term1))
                            || (inputMatrices.contains(term2)))
                        atomsToBeProcessed.add(atom);
                }
            }

            if (atom.getPredicate().toLowerCase().equals("tr")) {
                final Term term1 = atom.getTerm(0);

                if (sizeMapping.containsKey(term1)) {
                    final int newRow = sizeMapping.get(term1).getKey();
                    final int newCol = sizeMapping.get(term1).getValue();
                    sizeMapping.put(atom.getTerm(1), ImmutablePair.of(newCol, newRow));
                } else {
                    if (inputMatrices.contains(atom.getTerm(1)))
                        atomsToBeProcessed.add(atom);
                }
            }

            if (atom.getPredicate().toLowerCase().equals("in")) {
                final Term term1 = atom.getTerm(0);
                if (sizeMapping.containsKey(term1)) {
                    final int newRow = sizeMapping.get(term1).getKey();
                    final int newCol = sizeMapping.get(term1).getValue();
                    sizeMapping.put(atom.getTerm(1), ImmutablePair.of(newRow, newCol));
                } else {
                    if (inputMatrices.contains(atom.getTerm(1)))
                        atomsToBeProcessed.add(atom);
                }
            }

        }
        return totalCost;
    }

    /**
     * Populate Uplan intermediate result size
     * 
     * @param uPlan
     *            the universal plan
     */
    public static void populateUplanSizeMapping(final Collection<Atom> uPlan) {
        final List<Atom> nonSizeAtoms = new ArrayList<>();
        final Set<Term> inputMatrices = new HashSet<>();
        for (final Atom atom : uPlan) {
            if (atom.getPredicate().equals("size")) {
                final Term term1 = atom.getTerm(1);
                final Term term2 = atom.getTerm(2);
                if (term1.isConstant() && term2.isConstant()) {
                    final ImmutablePair<Integer, Integer> size =
                            ImmutablePair.of(Integer.parseInt(term1.toString().replace("\"", "")),
                                    Integer.parseInt(term2.toString().replace("\"", "")));
                    UPLAN_SIZE_MAPPING.put(atom.getTerm(0), size);
                }
            } else {
                if (atom.getPredicate().toLowerCase().equals("multi")) {
                    inputMatrices.add(atom.getTerm(0));
                    inputMatrices.add(atom.getTerm(1));
                    nonSizeAtoms.add(atom);
                }
                if (atom.getPredicate().toLowerCase().equals("tr")) {
                    nonSizeAtoms.add(atom);
                }
                if (atom.getPredicate().toLowerCase().equals("in")) {
                    nonSizeAtoms.add(atom);
                }

            }
        }

        final Queue<Atom> atomsToBeProcessed = new LinkedList<>(nonSizeAtoms);
        while (atomsToBeProcessed.size() > 1) {
            final Atom atom = atomsToBeProcessed.poll();

            if (atom.getPredicate().toLowerCase().equals("multi")) {
                final Term term1 = atom.getTerm(0);
                final Term term2 = atom.getTerm(1);
                if (UPLAN_SIZE_MAPPING.containsKey(term1) && UPLAN_SIZE_MAPPING.containsKey(term2)
                        && inputMatrices.contains(atom.getTerm(2))) {
                    final int newRow = UPLAN_SIZE_MAPPING.get(term1).getKey();
                    final int newCol = UPLAN_SIZE_MAPPING.get(term2).getValue();
                    UPLAN_SIZE_MAPPING.put(atom.getTerm(2), ImmutablePair.of(newRow, newCol));
                } else {
                    if (inputMatrices.contains(atom.getTerm(2)))
                        atomsToBeProcessed.add(atom);
                }
            }

            if (atom.getPredicate().toLowerCase().equals("tr")) {
                final Term term1 = atom.getTerm(0);

                if (UPLAN_SIZE_MAPPING.containsKey(term1)) {
                    final int newRow = UPLAN_SIZE_MAPPING.get(term1).getKey();
                    final int newCol = UPLAN_SIZE_MAPPING.get(term1).getValue();
                    UPLAN_SIZE_MAPPING.put(atom.getTerm(1), ImmutablePair.of(newCol, newRow));
                } else {
                    if (inputMatrices.contains(atom.getTerm(1)))
                        atomsToBeProcessed.add(atom);
                }
            }

            if (atom.getPredicate().toLowerCase().equals("in")) {
                final Term term1 = atom.getTerm(0);
                if (UPLAN_SIZE_MAPPING.containsKey(term1)) {
                    final int newRow = UPLAN_SIZE_MAPPING.get(term1).getKey();
                    final int newCol = UPLAN_SIZE_MAPPING.get(term1).getValue();
                    UPLAN_SIZE_MAPPING.put(atom.getTerm(1), ImmutablePair.of(newRow, newCol));
                } else {
                    if (inputMatrices.contains(atom.getTerm(1)))
                        atomsToBeProcessed.add(atom);
                }
            }
        }
    }

    /**
     * Find the sub-query cost
     * 
     * @param subQuery
     *            the sub-query conjunct
     * @return the cost
     */
    public static double getSubQueryCost(final Collection<Atom> subQuery) {
        final List<Atom> atoms = new ArrayList<>(subQuery);
        if (atoms.get(0).getPredicate().toLowerCase().equals("multi")
                && atoms.get(1).getPredicate().toLowerCase().equals("multi")) {
            final Set<Term> terms1 = new HashSet<>(atoms.get(0).getTerms());
            final Set<Term> terms2 = new HashSet<>(atoms.get(1).getTerms());
            terms1.retainAll(terms2);
            if (!terms1.isEmpty() && terms1.size() == 1) {
                final Term term = terms1.iterator().next();
                final ImmutablePair<Integer, Integer> size = UPLAN_SIZE_MAPPING.get(term);
                return size.getKey() * size.getValue();
            }
        }

        return -1;
    }

}
