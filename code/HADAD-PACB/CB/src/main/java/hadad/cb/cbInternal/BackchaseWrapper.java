package hadad.cb.cbInternal;

import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

import hadad.backchase.Utils.CostFunction;
import hadad.backchase.Utils.CostType;
import hadad.backchase.Utils.CostingManager;
import hadad.backchase.instance.ChasedInstance;
import hadad.cb.cbTool.IOUtils;
import hadad.cb.cbTool.ToolUtils;
import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.constraints.Constraint;

/**
 * Wrapper class for the Backchase/reformulation engine
 * 
 */
public class BackchaseWrapper {

    private final static Logger LOGGER = Logger.getLogger(ToolUtils.class.getName());

    /**
     * Runs the Backchase phase of Prov C&B
     * 
     * @param initquery
     *            The query to be rewritten
     * @param uPlan
     *            The universal plan
     * @param constraints
     *            The set of constraints for the Backchase
     * 
     * @return The reformulations
     */
    public static Map<Long, List<ConjunctiveQuery>> Backchase(final ConjunctiveQuery initquery,
            final ConjunctiveQuery uPlan, final ArrayList<Constraint> bwconstraints, final Properties properties)
            throws Exception {

        IOUtils.BackChasePreProcessing(initquery, uPlan, bwconstraints);
        ChasedInstance.Restart();
        costingConfig(properties);

        Map<Long, List<ConjunctiveQuery>> timedRewritings = new HashMap<>();

        if (CostingManager.ENABLE_COSTING)
            switch (CostingManager.COSTING_TYPE) {
                case NAIVE_COSTING:
                    timedRewritings =
                            ChasedInstance.zeInstance.computeRewritingsNaive("bkchasetmp.in", uPlan, initquery);
                    break;
                case PRUNED_COSTING:
                    timedRewritings = ChasedInstance.zeInstance.computeRewritingsPruned("bkchasetmp.in", uPlan, initquery);
                    
                    break;
            }
        else {
            timedRewritings = ChasedInstance.zeInstance.computeRewritings("bkchasetmp.in", uPlan);
        }

        return timedRewritings;
    }

    /**
     * Read PACB cost configurations.
     * 
     * @param properties
     */
    private static void costingConfig(final Properties properties) {

        if (properties.get("enable_costing") != null && properties.get("enable_costing").equals("true")) {
            CostingManager.ENABLE_COSTING = true;
            final String costType = ((String) properties.get("cost_type")).toUpperCase();
            final String costFunction = ((String) properties.get("cost_function")).toUpperCase();
            if (costType != null && costFunction != null) {
                if (!costType.isEmpty() && !costFunction.isEmpty()) {
                    CostingManager.COSTING_TYPE = CostType.valueOf(costType);
                    CostingManager.COST_FUNCTION = CostFunction.valueOf(costFunction);
                } else {
                    throw new IllegalArgumentException("COSTING_TYPE is not specified");
                }
            }
        }
    }
}
