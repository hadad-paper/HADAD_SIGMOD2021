package hadad.db.canonicaldb;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Logger;

import hadad.db.query.QueryEvaluationException;

/**
 * Represents the schema of a <code>Tuple</code>.
 * 
 */
public class CanonicalSchema {

    private final static Logger LOGGER = Logger.getLogger(Attribute.class.getName());

    private static int newColNameCounter;

    /**
     * The <code>LinkedHashMap</code> holding the schema of a tuple. The key
     * is a position and the value is the name of the column in the tuple.
     */
    private final LinkedHashMap<Integer, String> schema;

    /**
     * The <code>Hashtable</code> holding the inverted schema of a tuple. The
     * key is a column name and the value is one of the possible many positions
     * of the column in the tuple.
     */
    private final Hashtable<String, Integer> invertedSchema;

    /**
     * Constructors
     */
    public CanonicalSchema() {
        schema = new LinkedHashMap<Integer, String>();
        invertedSchema = new Hashtable<String, Integer>();
    }

    /**
     * Adds a new column to the end of the schema.
     * 
     * @param column
     *            the name of the column to add
     * @return the position of the added column
     * @throws QueryEvaluationException
     *             if the column is already in the schema
     */
    public int addColumnName(final String column) {
        int position = schema.size();
        schema.put(position, column);
        invertedSchema.put(column, position);

        return position;
    }

    /**
     * Adds a new column and position to the schema.
     * 
     * @param column
     *            the name of the column to add
     * @param position
     *            the position of the column to add
     * @throws QueryEvaluationException
     *             if the column is already in the schema, or if there is a
     *             position collision.
     */
    public void addColumnName(final String column, int position) {
        if (schema.containsKey(position))
            throw new QueryEvaluationException(
                    "Adding column to schema failed: " + "position already taken in the schema.");

        schema.put(position, column);
        invertedSchema.put(column, position);
    }

    /**
     * Gets the position of a column in the schema.
     * 
     * @param column
     *            the name of the column
     * @return the position of the specified column
     * @throws QueryEvaluationException
     *             if the column is not in the schema
     */
    public int getPosition(final String column) {
        if (!invertedSchema.containsKey(column))
            throw new QueryEvaluationException("Getting column position failed: " + "column not in the schema.");

        return invertedSchema.get(column);
    }

    /**
     * Gets an iterator over the positions in the schema. Positions are
     * <code>Integer</code> objects.
     * 
     * @return an iterator over the positions in the schema
     */
    public Iterator<Integer> getPositions() {
        return schema.keySet().iterator();
    }

    /**
     * Gets an iterator over the column names in the schema. Column names are
     * <code>String</code> objects.
     * 
     * @return an iterator over the column names in the schema
     */
    public Iterator<String> getColumnNames() {
        return schema.values().iterator();
    }

    /**
     * Gets an iterator over the (position, column name) pairs in the schema.
     * Pairs are <code>Map.Entry</code> objects, where the position (key) is
     * an <code>Integer</code> object, and the column name (value) is a
     * <code>String</code> object.
     * 
     * @return an iterator over the (column name, position) pairs in the schema.
     */
    public Iterator<Map.Entry<Integer, String>> getEntries() {
        return schema.entrySet().iterator();
    }

    /**
     * Determines if the specified position is part of the schema.
     * 
     * @param position
     *            a position to lookup
     * @return <code>true</code>, if the specified position is part of the
     *         schema; <code>false</code>, otherwise.
     */
    public boolean hasPosition(int position) {
        return schema.containsKey(position);
    }

    /**
     * Determines if the specified column name is part of the schema.
     * 
     * @param column
     *            a column name to lookup
     * @return <code>true</code>, if the specified column name is part of the
     *         schema; <code>false</code>, otherwise.
     */
    public boolean hasColumnName(final String column) {
        return invertedSchema.containsKey(column);
    }

    /**
     * Determines is the schema is empty.
     * 
     * @return <code>True</code>, if the schema contains no columns;
     *         <code>False</code>, otherwise.
     */
    public boolean isEmpty() {
        return schema.isEmpty();
    }

    /**
     * Gets the size of the schema.
     * 
     * @return the size of the schema as an integer.
     */
    public int size() {
        return schema.size();
    }

    /**
     * Get fresh column name
     * 
     * @return fresh column name
     */
    public static String freshColName() {
        final StringBuilder str = new StringBuilder();
        str.append("_x");
        str.append(newColNameCounter);
        newColNameCounter++;
        return str.toString();
    }

    public void display() {
        for (String column : schema.values())
            System.out.print(column + " ");
        System.out.println();
    }
}
