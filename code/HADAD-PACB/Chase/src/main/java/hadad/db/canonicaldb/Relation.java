package hadad.db.canonicaldb;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

import hadad.db.query.MapPredicates;

/**
 * This class represents a relation instance which holds a set of tuples. The
 * relation has set semantics, i.e., no duplicates. Duplicates are eliminated
 * when a tuple is added to the relation. A relation can have a list of
 * registered <code>MapPredicates</code> (scan) operators, that are called
 * when a new tuple is added to the relation.
 */
public class Relation {

    private final static Logger LOGGER = Logger.getLogger(Relation.class.getName());

    /** The name of the relation. */
    protected String name;

    /** The arity of the tuples this relation holds. */
    protected int arity = -1;

    /**
     * A set with the string representation of all tuples in the relation.
     * The string corresponding to a tuple is the concatenation of all its
     * column values. This is used for duplicate elimination when adding a tuple.
     */
    protected HashSet<String> tupleSet;

    /** The list of tuples in the relation */
    protected List<Tuple> tupleList;

    /**
     * The list of scan operators that have to be triggered when a tuple is
     * added to the relation.
     */
    protected List<MapPredicates> registeredOps;

    /** The list of attributes of the relation */
    protected Attribute[] attribs;

    /**
     * The database to which the relation belongs
     */
    protected Database db = null;

    /** The list of attributes that constitute the primary key of the relation */
    protected ArrayList<Attribute> pk = null;

    /**
     * Constructor.
     *
     * @param name
     *            the name of the <code>Relation</code>.
     * @param aritty
     *            the arity of the <code> Relation </code>
     */
    public Relation(final String name, int arity) {
        this.name = name;
        this.arity = arity;
        tupleSet = new HashSet<String>();
        tupleList = new ArrayList<Tuple>();
        registeredOps = new ArrayList<MapPredicates>();
        createAttribs();
    }

    public static Relation createRelationWithSameSchema(Relation oldRel) {
        Relation newRel = new Relation(oldRel.name, oldRel.arity);
        return newRel;
    }

    // TODO: Allow users to change the default attribute names

    private void createAttribs() {
        attribs = new Attribute[arity];

        for (int i = 0; i < arity; i++) {
            attribs[i] = new Attribute(this, i, "attr" + i);
        }
    }

    // TODO: Finalize support for primary key constraints

    public void setPK(ArrayList<Attribute> pk) {
        this.pk = new ArrayList<Attribute>(pk);
    }

    public ArrayList<Attribute> getPK() {
        return this.pk;
    }

    public Attribute getAttribute(int pos) {
        if (pos < 0 || pos >= arity) {
            throw new CanonicalDBException("Getting the attribute at position " + pos + " from relation " + name
                    + " failed: The position exceeds the relation's arity of " + arity + ".");
        }

        return attribs[pos];
    }

    /**
     * Flush all relation's tuples
     */
    public void flush() {
        tupleSet = new HashSet<String>();
        tupleList = new ArrayList<Tuple>();
    }

    /**
     * Adds a <code>Tuple</code> to the <code>Relation</code>.
     * After a tuple is added, the registered <code>MapPredicates</code>
     * operators are called.
     *
     * @param tuple
     *            The <code>Tuple</code> to add
     * @return <code>true</code>, if the tuple was not already in the
     *         relation; <code>false</code>, otherwise
     * @throws CanonicalDBException
     *             if the arity of the <code>Relation</code> and the size of
     *             the <code>Tuple</code> do not match
     */
    public boolean addTuple(final Tuple tuple) {
        final StringBuffer keyBuf = new StringBuffer();
        if (arity == -1) {
            arity = tuple.size();
        }
        if (arity != tuple.size()) {
            final StringBuilder str = new StringBuilder();
            str.append("Adding tuple to relation failed: \"");
            str.append(name);
            str.append("\" relation arity and tuple size do not match.");
            throw new CanonicalDBException(str.toString());
        }
        for (int i = 0; i < tuple.size(); i++) {
            keyBuf.append(tuple.getValue(i).getValueStr());
        }

        final String key = keyBuf.toString();
        if (tupleSet.contains(key)) {
            return false;
        }
        tupleSet.add(key);
        tupleList.add(tuple);
        db.updateMap(tuple);
        tuple.relation = this;
        pushTupleToQueryTrees();
        return true;
    }

    /**
     * Push tuples to query tree when added after applicable chase step
     */
    private void pushTupleToQueryTrees() {
        int numOfOps = registeredOps.size();

        for (int i = 0; i < numOfOps; i++) {
            registeredOps.get(i).pushAll();
        }
    }

    public List<MapPredicates>  getRegOp() {
        return registeredOps;
    }
    /**
     * Gets a <code>TupleIterator</code> that iterates over the tuples of the
     * <code>Relation</code>.
     *
     * @return a <code>TupleIterator</code> object
     */
    public TupleIterator getTupleIterator(MapPredicates op) {
        registeredOps.add(op);

        return new TupleIterator();
    }

    /**
     * Gets a <code>TupleIterator</code> that iterates over the tuples of the
     * <code>Relation</code>. To be used only by classes that need to iterate
     * through the relation't tuple without requiring to be notified when a
     * change occurs in the relation.
     *
     * @return a <code>TupleIterator</code> object
     */
    public TupleIterator getNonSyncTupleIterator() {
        return new TupleIterator();
    }

    /**
     * Get relation name
     * 
     * @return relation's name
     */
    public String name() {
        return this.name;
    }

    /**
     * Get relation's arity
     * 
     * @return relation's arity
     */
    public int arity() {
        return this.arity;
    }

    /**
     * Relation's tuples sizes
     * 
     * @return relation's tuples sizes
     */
    public int size() {
        return tupleList.size();
    }

    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder();
        str.append("Relation: ");
        str.append(name);
        str.append("\n");
        for (int i = 0; i < tupleList.size(); i++) {
            str.append(tupleList.get(i).toString());
            str.append("\n");
        }
        return str.toString();
    }

    /**
     * An iterator over the tuples of a <code>Relation</code>.
     */
    public class TupleIterator {

        /**
         * The index of the next tuple to be returned when
         * the <code>next<code> function is invoked.
         */
        int tupleIndex;

        private TupleIterator() {
            tupleIndex = 0;
        }

        /**
         * Returns <code>True</code> if the tuple iteration has more elements.
         * (In other words, returns true if next would return a
         * <code>Tuple</code> rather than throwing an exception.)
         *
         * @return <code>True</code> if the iterator has more tuples
         */
        public boolean hasNext() {
            return tupleIndex < tupleList.size();
        }

        /**
         * Reset tuple iterator index
         */
        public void reset() {
            tupleIndex = 0;
        }

        /**
         * Returns the next <code>Tuple</code> in the iteration.
         *
         * @return the next <code>Tuple</code> in the iteration
         * @throws CanonicalDBException
         *             if there is no next <code>Tuple</code>, or if the
         *             <code>Relation</code> has been modified since the
         *             iteration started
         */
        public Tuple next() throws CanonicalDBException {
            try {
                return tupleList.get(tupleIndex++);
            } catch (NoSuchElementException exception) {
                throw new CanonicalDBException(
                        "Getting next tuple in the relation iteration failed: no such tuple found.");
            } catch (ConcurrentModificationException exception) {
                throw new CanonicalDBException(
                        "Getting next tuple in the relation iteration failed: relation modified since iteration strated.");
            }
        }

    }

}
