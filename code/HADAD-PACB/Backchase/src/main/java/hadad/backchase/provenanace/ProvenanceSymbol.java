package hadad.backchase.provenanace;

/**
 * Provenance Symbol
 * 
 *  
 *  Ioana Ileana
 */
public class ProvenanceSymbol {
    private String name;
    private int index;

    /**
     * Constructor
     * 
     * @param provenance
     *            name
     * @param provenance
     *            index
     */
    public ProvenanceSymbol(final String name, final int index) {
        this.name = name;
        this.index = index;
    }

    /**
     * Set provenance name
     * 
     * @param name
     */
    public void setProvenanceName(final String name) {
        this.name = name;
    }

    /**
     * Set provenance index
     * 
     * @param index
     */
    public void setProvenanceIndex(final int index) {
        this.index = index;
    }

    /**
     * Get provenance name
     * 
     * @return provenance name
     */
    public String getProvenanceName() {
        return name;
    }

    /**
     * Get provenance index
     * 
     * @return provenance index
     */
    public int getProvenanceIndex() {
        return index;
    }
}
