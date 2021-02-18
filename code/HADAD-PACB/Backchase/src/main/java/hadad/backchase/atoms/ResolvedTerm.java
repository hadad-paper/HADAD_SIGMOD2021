package hadad.backchase.atoms;

import org.apache.log4j.Logger;

import hadad.backchase.instance.ConnectedComponent;

/**
 * A variable of the chased instance or a constant (not an atom position)
 *
 */
public class ResolvedTerm {

    private final static Logger LOGGER = Logger.getLogger(ResolvedTerm.class);

    private String name;
    private ConnectedComponent component;
    private int index;
    private int indexInComponent;

    /**
     * Constructor
     * 
     * @param name
     *            variable/constant name
     * @param index
     *            the variable index
     */
    public ResolvedTerm(final String name, int index) {
        this.name = name;
        this.index = index;
        setComponent(new ConnectedComponent(this));
        indexInComponent = 0;
    }

    /**
     * Set name
     * 
     * @param name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Set index
     * 
     * @param index
     */
    public void setIndex(final int index) {
        this.index = index;
    }

    /**
     * Set component
     * 
     * @param component
     */
    public void setComponent(final ConnectedComponent component) {
        this.component = component;
    }

    /**
     * Set index component
     * 
     * @param indexInComponent
     */
    public void setIndexComponenet(final int indexInComponent) {
        this.indexInComponent = indexInComponent;
    }

    /**
     * Get index
     * 
     * @return index
     */
    public int getIndex() {
        return index;
    }

    /**
     * Get name
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Get component
     * 
     * @return component
     */
    public ConnectedComponent getComponent() {
        return component;
    }

    /**
     * Get index component
     * 
     * @return indexInComponent
     */
    public int getIndexComponenet() {
        return indexInComponent;
    }

    @Override
    public String toString() {
        return name;
    }
}
