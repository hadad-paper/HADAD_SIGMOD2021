package hadad.backchase.Utils;

import java.util.List;

import org.apache.log4j.Logger;

import hadad.backchase.provenanace.flatProvenance.FlatConjunct;
import hadad.commons.conjunctivequery.ConjunctiveQuery;

/**
 * Naive Costing
 *
 */
public final class NaiveCosting {

    private final static Logger LOGGER = Logger.getLogger(NaiveCosting.class);

    private final CostFunction costFunction;
    private final List<FlatConjunct> provenanaceFormula;
    private final ConjunctiveQuery uPlan;
    private final ConjunctiveQuery query;

    public NaiveCosting(final List<FlatConjunct> provenanaceFormula, final ConjunctiveQuery uPlan,
            final ConjunctiveQuery query, final CostFunction costFunction) {
        this.costFunction = costFunction;
        this.provenanaceFormula = provenanaceFormula;
        this.uPlan = uPlan;
        this.query = query;
    }

    /**
     * Find minimum-cost Rewriting
     * 
     * @return rewriting
     */
    public ConjunctiveQuery findMinCostRewriting() {
        switch (costFunction) {
            case RELATIONAL_JOIN_NUMBERS:
                return CostingRelationallJoinNumbers.findRewriting(provenanaceFormula, uPlan, query);
            case MATRIX_INTERMEDIATE_RESULTS:
                return CostingMatrixModel.findRewriting(provenanaceFormula, uPlan, query);
            default:
                return null;
        }
    }
}
