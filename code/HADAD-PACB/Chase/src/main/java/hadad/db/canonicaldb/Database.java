package hadad.db.canonicaldb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import hadad.db.datalogexpr.Value;

/**
 * This class represents a canonical database, which is a collection of
 * <code>Relation</code> instances.
 */
public class Database {
    /** Logger */
    private final static Logger LOGGER = Logger.getLogger(Database.class.getName());

    /** Database version */
    private int version;

    /** The relations in the database indexed by their name */
    private Map<String, Relation> db;

    /** The list of tuples that contain any specific value */
    private Hashtable<String, List<Tuple>> valueMap;

    /**
     * Constructor.
     */
    public Database() {
        version = 0;
        db = new HashMap<>();
        valueMap = new Hashtable<>();
    }

    /**
     * Create a database with the same schema of a given database
     * 
     * @param otherDB
     * @return return the newly created database
     */
    public static Database createDatabaseWithSameSchema(final Database otherDB) {
        final Database newDB = new Database();
        final Collection<Relation> oldRelations = otherDB.db.values();
        final Iterator<Relation> iter = oldRelations.iterator();
        while (iter.hasNext()) {
            Relation oldRel = iter.next();
            Relation newRel = Relation.createRelationWithSameSchema(oldRel);
            newDB.addRelationInstance(newRel);
        }
        return newDB;
    }

    /**
     * Update the database mapping
     * 
     * @param tuple
     */
    protected void updateMap(final Tuple tuple) {
        int arity = tuple.size();
        final Set<Value> duplicateValues = new HashSet<Value>();
        for (int i = 0; i < arity; i++) {
            final Value curValue = tuple.getValue(i);
            if (duplicateValues.add(curValue)) {
                addToMap(curValue.getValueStr(), tuple);
            }
        }
    }

    /**
     * 
     * @param str
     * @param tuple
     */
    private void addToMap(final String str, final Tuple tuple) {
        if (valueMap.containsKey(str)) {
            valueMap.get(str).add(tuple);
        } else {
            List<Tuple> newArray = new ArrayList<Tuple>();
            newArray.add(tuple);
            valueMap.put(str, newArray);
        }
    }

    /**
     * Creates a new <code>Relation</code> instance and adds it to the
     * canonical database.
     *
     * @param name
     *            the name of the <code>Relation</code>
     * @param schema
     *            the schema of the <code>Relation</code>
     * @return the <code>Relation</code> created
     * @throws CanonicalDBException
     *             when there is another <code>Relation</code> with the same
     *             name, or the <code>schema</code> is <code>null</code>.
     */
    public Relation createRelationInstance(final String name, final CanonicalSchema schema)
            throws CanonicalDBException {
        if (db.containsKey(name)) {
            throw new CanonicalDBException("Rleation with the same name already exists.");
        }

        if (schema == null) {
            throw new CanonicalDBException("Schema cann't be null.");
        }
        return new Relation(name, schema.size());
    }

    /**
     * Adds a <code>Relation</code> instance to the canonical database.
     *
     * @param relation
     *            the <code>Relation</code> to add
     * @throws CanonicalDBException
     *             when a <code>Relation</code> with the same name is already
     *             in the <code>CanonicalDB</code>
     */
    public void addRelationInstance(Relation relation) throws CanonicalDBException {
        if (db.containsKey(relation.name)) {
            throw new CanonicalDBException("Adding relation \"" + relation.name + "\" to the database failed: "
                    + "relation with the same name already in the database");
        } else {
            db.put(relation.name, relation);
            relation.db = this;
        }
    }

    /**
     * Gets a <code>Relation</code> instance.
     *
     * @param name
     *            the name of the <code>Relation</code>
     * @return a <code>Relation</code> object
     * @throws CanonicalDBException
     *             when there is no <code>Relation</code> with the given
     *             <code>name</code>.
     */
    public Relation getRelationInstance(final String name) throws CanonicalDBException {
        if (db.containsKey(name)) {
            return db.get(name);
        } else {
            final StringBuilder exceptionMsg = new StringBuilder();
            exceptionMsg.append("Retrieving relation \"");
            exceptionMsg.append(name);
            exceptionMsg.append("\" from the database failed: ");
            exceptionMsg.append("relation not in the database");
            throw new CanonicalDBException(exceptionMsg.toString());
        }
    }

    /**
     * Get relation names in the database
     * 
     * @return the list of relation names in the database
     */
    public List<String> getRelationNames() {
        return new ArrayList<String>(db.keySet());
    }

    /**
     * Get tuples containing specific value from the databases
     * 
     * @param value
     * @return the tuples that contain the given value
     */
    public List<Tuple> getTuplesContainingValue(final Value value) {
        return valueMap.get(value.getValueStr());
    }

    /**
     * Gets the number of the latest version.
     *
     * @return a positive integer denoting the latest version, or
     *         <code>-1</code> if there are no versions.
     */
    public int getLatestVersion() {
        return version;
    }

    /**
     * Flush all database populated relations
     */
    public void flush() {
        for (final Relation relation : db.values()) {
            relation.flush();
        }
    }

    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder();
        for (Map.Entry<String, Relation> ent : db.entrySet()) {
            str.append(ent.getValue().toString());
            str.append("\n");
        }
        return str.toString();
    }
}
