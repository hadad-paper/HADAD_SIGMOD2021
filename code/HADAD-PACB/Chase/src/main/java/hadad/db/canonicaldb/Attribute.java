package hadad.db.canonicaldb;

import java.util.logging.Logger;

/**
 * It represents an attribute (column) in a relational table.
 */
public class Attribute {

    private final static Logger LOGGER = Logger.getLogger(Attribute.class.getName());

    /** Relation in which the attribute belongs */
    private final Relation relation;

    /** The index of the attribute in the relation */
    private final int position;

    /** The attribute's name */
    private final String name;

    /**
     * Constructor
     * 
     * @param relation
     *            relation that the attribute belongs to
     * @param postion
     *            the attribute's position
     * @param name
     *            the attribute's name
     */
    public Attribute(final Relation relation, int postion, final String name) {
        this.relation = relation;
        this.position = postion;
        this.name = new String(name);
    }

    /**
     * Get attribute's relation
     * 
     * @return relation
     */
    public Relation getRelation() {
        return relation;
    }

    /**
     * Get attribute's position
     * 
     * @return attribute's position
     */
    public int getPosition() {
        return position;
    }

    /**
     * Get attribute's name
     * 
     * @return attribute's name
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder();
        str.append(relation.name);
        str.append(".");
        str.append(name);
        return str.toString();
    }
}
