package hadad.db.chase;

import java.util.logging.Logger;

import hadad.db.datalogexpr.Value;

/**
 * This class represents an equality between a variable and a constant, a
 * variable and a variable, or a constant and a variable. A variable can be
 * either distinguished or existential.
 */
public class Equality {

    /** Logger */
    private final static Logger LOGGER = Logger.getLogger(Equality.class.getName());
    /** Left value */
    private final Value left;
    /** Right value */
    private final Value right;

    /**
     * Constructor
     * 
     * @param left
     *            the left value
     * @param right
     *            the right value
     */
    public Equality(final Value left, final Value right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Get the left value
     * 
     * @return the left value
     */
    public Value getLeft() {
        return left;
    }

    /**
     * Get the right value
     * 
     * @return the right value
     */
    public Value getRight() {
        return right;
    }

}
