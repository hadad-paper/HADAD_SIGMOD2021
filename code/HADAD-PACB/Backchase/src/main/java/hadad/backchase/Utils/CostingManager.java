package hadad.backchase.Utils;

/**
 * Back-chase Costing Manager
 *
 */
public final class CostingManager {

    public static boolean ENABLE_COSTING = false;
    public static CostFunction COST_FUNCTION = CostFunction.MATRIX_INTERMEDIATE_RESULTS;
    public static CostType COSTING_TYPE = CostType.PRUNED_COSTING;

    private CostingManager() {
    };
}
