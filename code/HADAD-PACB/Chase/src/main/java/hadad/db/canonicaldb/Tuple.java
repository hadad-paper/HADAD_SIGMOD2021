package hadad.db.canonicaldb;

import java.util.logging.Logger;

import hadad.db.datalogexpr.Value;
import hadad.db.query.QueryEvaluationException;

/**
 * This class represents a relational tuple in a <code> Relation </code>
 */
public class Tuple {
    /** Logger */
    private final static Logger LOGGER = Logger.getLogger(Tuple.class.getName());
    /**
     * The actual tuple represented by an array of <code> Value</code>
     */
    protected Value[] tuple;

    /**
     * The last position inside the tuple to which a value has been assigned
     */
    protected int lastPos = 0;

    /**
     * If it is a fresh tuple, we have not yet put it in the canonical instance
     * (i.e. it has been created by the suggestions generating algorithm)
     */
    private boolean isFresh = false;

    /**
     * The relational instance to which this tuple belongs
     */
    protected Relation relation;

    /**
     * Constructor
     * 
     * @param size
     *            the tuple size
     */
    public Tuple(int size) {
        tuple = new Value[size];
    }

    /**
     * Add a <code> Value </code> to the end of the tuple.
     * 
     * @param value
     *            The value to add
     * @return <code> True <code>, if successful; <code> False </code>, otherwise
     */
    public boolean addValue(final Value value) {
        if (lastPos != tuple.length) {
            tuple[lastPos] = value;
            lastPos++;
            return true;
        } else {
            throw new IllegalArgumentException("Cann't add value to the tuple, size exceeded");
        }
    }

    /**
     * Gets the <code>String</code> value at the given position.
     * 
     * @param pos
     *            the position of the value to get
     * @return a <code>Value</code> object
     * @throws QueryEvaluationException
     *             if the given position is out of range
     */
    public Value getValue(int position) throws CanonicalDBException {
        if (position < 0 || position >= lastPos) {
            final StringBuilder str = new StringBuilder();
            str.append("Tuple value not found specified position \"");
            str.append(position);
            str.append("\" is out of range.");

            throw new QueryEvaluationException(str.toString());
        }
        return tuple[position];

    }

    /**
     * Gets the arity of the tuple.
     * 
     * @return the arity of the tuple as an integer
     */
    public int size() {
        return tuple.length;
    }

    public boolean isEmpty() {
        return lastPos == 0;
    }

    /**
     * Clears all values in the tuple.
     */
    public void clear() {
        lastPos = 0;
    }

    /**
     * Prints the tuple for debugging purposes.
     */
    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder();
        str.append("Tuple: ");

        for (int i = 0; i < tuple.length; i++) {
            str.append("\t");
            str.append(tuple[i].getValueStr());
        }

        return str.toString();
    }

    /**
     * Make the tuple fresh
     */
    public void makeFresh() {
        isFresh = true;
    }

    /**
     * Make tuple not fresh
     */
    public void makeNonFresh() {
        isFresh = false;
    }

    /**
     * Check if tuple if fresh or no
     * 
     * @return <code> True </code> if it i fresh, otherwise <code> False </code>
     */
    public boolean isFresh() {
        return isFresh;
    }

    /**
     * Get tuple's relation
     * 
     * @return tuple's relation
     */
    public Relation relation() {
        return relation;
    }
}
