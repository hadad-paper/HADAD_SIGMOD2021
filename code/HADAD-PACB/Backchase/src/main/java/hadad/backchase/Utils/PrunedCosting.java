package hadad.backchase.Utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import hadad.backchase.provenanace.flatProvenance.FlatConjunct;
import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.ConjunctiveQuery;

/**
 * Pruned Costing
 *
 */
public final class PrunedCosting {

    private final static Logger LOGGER = Logger.getLogger(PrunedCosting.class);

    public static CostFunction costFunction = null;
    public static ConjunctiveQuery uPlan = null;
    public static ConjunctiveQuery minRewriting = null;
    private static boolean flag = false;
    public static double threshHold = 0;

    /**
     * Get the sub-query cost
     * 
     * @return the cost of sub-query
     */
    public static double getSubQueryCost(final FlatConjunct subQuery) {
        final List<Atom> subQueryCQ = getConjunctiveQueryRepresentation(subQuery);
        switch (costFunction) {
            case RELATIONAL_JOIN_NUMBERS:
                return CostingRelationallJoinNumbers.getCost(subQueryCQ);
            case MATRIX_INTERMEDIATE_RESULTS:
                if (!flag) {
                    CostingMatrixModel.populateUplanSizeMapping(uPlan.getBody());
                    flag = true;
                }
                return CostingMatrixModel.getSubQueryCost(subQueryCQ);
            default:
                return 0;
        }
    }

    public static void findMinRewriting(final List<FlatConjunct> provenanaceFormula) {
        switch (costFunction) {
            case RELATIONAL_JOIN_NUMBERS:
                CostingRelationallJoinNumbers.findRewriting(provenanaceFormula, uPlan);
                break;
            case MATRIX_INTERMEDIATE_RESULTS:
                CostingMatrixModel.findRewriting(provenanaceFormula, uPlan);
                break;
            default:

        }
    }

    /**
     * Get the query cost
     * 
     * @return the cost of sub-query
     */
    public static double getQueryCost(final ConjunctiveQuery query) {
        switch (costFunction) {
            case RELATIONAL_JOIN_NUMBERS:
                return CostingRelationallJoinNumbers.getCost(query.getBody());
            case MATRIX_INTERMEDIATE_RESULTS:
                return CostingMatrixModel.getCost(query);
            default:
                return 0;
        }
    }

    /**
     * Get conjunctive query representation
     * 
     * @param subQuery
     *            sub-query as flat conjunct
     * @return the sub-query in conjunctive query form
     */
    private static List<Atom> getConjunctiveQueryRepresentation(final FlatConjunct subQuery) {
        final List<Atom> subQueryCQ = new ArrayList<>();
        final List<Atom> uPlanProcessed = new ArrayList<>(uPlan.getBody());
        final String conjStr = subQuery.toString();
        String[] symbols = conjStr.split(",");
        for (int j = 0; j < symbols.length; ++j)
            if (symbols[j].substring(0, 1).equals("p")) {
                int index = Integer.parseInt(symbols[j].substring(1));
                subQueryCQ.add(uPlanProcessed.get(index));
            }
        return subQueryCQ;
    }
}
