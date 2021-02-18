package hadad.backchase.instance;

import org.apache.log4j.Logger;

import hadad.backchase.constraints.Tgd;
import hadad.backchase.provenanace.flatProvenance.FlatFormula;
import hadad.backchase.provenanace.placeHodlerProvenance.PHFormula;

public class Query extends Tgd {
    private final static Logger LOGGER = Logger.getLogger(Query.class);

    private FlatFormula provenance;
    private int minCost;

    /**
     * Constructor
     */
    public Query() {
        super();
        provenance = null;
        minCost = 100000;

    }

    /**
     * Set provenance
     * 
     * @param provenance
     */
    public void setProvenance(final FlatFormula provenance) {
        this.provenance = provenance;
    }

    /**
     * Get provenance
     * 
     * @return provenance
     */
    public FlatFormula getProvenance() {
        return provenance;
    }

    /**
     * Get minimum cost
     * 
     * @return minCost
     */
    public int getMinCost() {
        return minCost;
    }

    @Override
    public void addNewLocalMapping(final LocalMapping mapping, final Object adder) {
        provenance = mapping.m_flatProvenance;
        if (Switches.COST_ON)
            minCost = provenance.shrinkToMinCost();
    }

    @Override
    public void addExistingMappingAdditionalProvenance(LocalMapping mapping, PHFormula phform, FlatFormula flatform,
            Object adder) {
        if (Switches.COST_ON)
            minCost = provenance.shrinkToMinCost();
    }
}
