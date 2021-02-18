package hadad.backchase.Utils;

/**
 * Cost Function
 *
 */
public enum CostFunction {
    
    RELATIONAL_JOIN_NUMBERS ("relational_join_numbers"),
    MATRIX_INTERMEDIATE_RESULTS ("matrix_intermediate_results"),
    SYSTEM_API("system_api");
    
    private final String costFunction;

    private CostFunction(final String costFunction) {
        this.costFunction=costFunction;
    }
    
    public String getCostFunction() {
        return costFunction;
    } 
}
