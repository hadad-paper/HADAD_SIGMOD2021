package hadad.backchase.Utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;

import hadad.backchase.provenanace.flatProvenance.FlatConjunct;
import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.conjunctivequery.Term;

/**
 * Naive costing based on
 *
 */
public final class CostingRelationallJoinNumbers {
    private final static Logger LOGGER = Logger.getLogger(NaiveCosting.class);

    private CostingRelationallJoinNumbers() {
    };

    /**
     * Find minimum-cost rewriting
     * 
     * @param provenanaceFormula
     * @param uplanAtoms
     * @return the found minimum-cost rewriting
     */
    public static ConjunctiveQuery findRewriting(final List<FlatConjunct> provenanaceFormula,
            final ConjunctiveQuery uPlan, final ConjunctiveQuery query) {

        double maxJoin = getCost(query.getBody());
        final List<Atom> uPlanAtoms = new ArrayList<>();
        for (Atom tmp : uPlan.getBody())
            uPlanAtoms.add(tmp);
        final List<Term> head = uPlan.getHead();

        final ArrayList<Atom> minRewriting = new ArrayList<Atom>();
        for (int i = 0; i < provenanaceFormula.size(); ++i) {
            ArrayList<Atom> rwAtoms = new ArrayList<Atom>();
            String conjStr = provenanaceFormula.get(i).toString();
            String[] symbols = conjStr.split(",");
            for (int j = 0; j < symbols.length; ++j)
                if (symbols[j].substring(0, 1).equals("p")) {
                    int index = Integer.parseInt(symbols[j].substring(1));
                    rwAtoms.add(uPlanAtoms.get(index));
                }
            if ((rwAtoms.size() - 1) <= maxJoin) {
                minRewriting.clear();
                minRewriting.addAll(rwAtoms);
                maxJoin = (rwAtoms.size() - 1);
            }
        }
        return new ConjunctiveQuery("RW" + String.valueOf(0), head, minRewriting);
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
    public static ConjunctiveQuery findRewriting(final List<FlatConjunct> provenanaceFormula,
            final ConjunctiveQuery uPlan) {

        double maxJoin = PrunedCosting.threshHold;
        final List<Atom> uPlanAtoms = new ArrayList<>();
        for (Atom tmp : uPlan.getBody())
            uPlanAtoms.add(tmp);
        final List<Term> head = uPlan.getHead();

        final ArrayList<Atom> minRewriting = new ArrayList<Atom>();
        for (int i = 0; i < provenanaceFormula.size(); ++i) {
            ArrayList<Atom> rwAtoms = new ArrayList<Atom>();
            String conjStr = provenanaceFormula.get(i).toString();
            String[] symbols = conjStr.split(",");
            for (int j = 0; j < symbols.length; ++j)
                if (symbols[j].substring(0, 1).equals("p")) {
                    int index = Integer.parseInt(symbols[j].substring(1));
                    rwAtoms.add(uPlanAtoms.get(index));
                }
            if ((rwAtoms.size() - 1) <= maxJoin) {
                minRewriting.clear();
                minRewriting.addAll(rwAtoms);
                maxJoin = (rwAtoms.size() - 1);
            }
        }
        return new ConjunctiveQuery("RW" + String.valueOf(0), head, minRewriting);
    }

    /**
     * Find the query cost
     * 
     * @param query
     * @return the query cost
     */

    public static double getCost(final Collection<Atom> query) {
        return query.size() - 1;
    }

}
