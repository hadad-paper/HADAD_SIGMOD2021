package hadad.backchase.Utils;

/**
 * Cost Type
 *
 */
public enum CostType {
    
    NAIVE_COSTING ("naive_costing"),
    PRUNED_COSTING ("pruned_costing");
    
    private final String costType;

    private CostType(final String costType) {
        this.costType=costType;
    }
    
    public String getCostType() {
        return costType;
    } 
}
