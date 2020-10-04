package hadad.db.chase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import hadad.db.canonicaldb.Database;
import hadad.db.canonicaldb.Tuple;
import hadad.db.chaseexceptions.InconsistencyException;
import hadad.db.datalogexpr.Predicate;
import hadad.db.datalogexpr.Statement;
import hadad.db.datalogexpr.Value;

/**
 * This class represents a database constraint in the context of a
 * <code>CanonicalDB<code>.
 */
public abstract class Constraint {

    /** Logger */
    private final static Logger LOGGER = Logger.getLogger(Constraint.class.getName());

    /** Static counter used to generate IDs for the constraints */
    private static int generateID = 1;
    /** The canonical database to which this constraint is to be applied */
    protected Database db;
    /** The id of the constraint. */
    protected int id = -1;

    /**
     * Constructor
     * 
     * @param db
     *            the database
     */
    protected Constraint(final Database db) {
        this.db = db;
    }

    /**
     * Constraint id
     * 
     * @return constraint's id
     */
    public final int getID() {
        if (id == -1) {
            id = generateID++;
        }
        return id;
    }

    /**
     * Abstract function called to enforce the constraint.
     * 
     * @return <code> True </code> if constraint had effect on the canonical database,
     *         <code> False </code> otherwise
     */
    public abstract boolean enforce() throws InconsistencyException;

    /**
     * Abstract function that flushes the query tree corresponding to the
     * constraint.
     */
    public abstract void flush();

    /**
     * Create a fresh instance of the query body to evaluate the constraints tree
     * 
     * @param query
     *            the query
     * @param producedTuple
     *            the tuple produced after applying a constraint. It is <code> Null </code> during query initialization.
     * @param makeFreshValuesSkolems
     *            <code> True </code> if Skolem values are needed to be constructed, otherwise <code> False </code>
     */
    public void createFreshInstanceOfQueryBody(final Statement query, final Tuple producedTuple,
            final boolean makeFreshValuesSkolems) {
        final Map<String, Value> varsToValues = new HashMap<String, Value>();

        Value value;
        Value variable;
        String varName;
        if (producedTuple != null) {
            int headSize = producedTuple.size();
            for (int i = 0; i < headSize; i++) {
                variable = query.head().variableI(i);
                if (!variable.isAnyConstant()) {
                    varName = variable.getValueStr();
                    value = producedTuple.getValue(i);
                    varsToValues.put(varName, value);
                }
            }
        }
        // Look at the body and create new tuples
        final List<Predicate> preds = query.getPredicates();
        int listSize = preds.size();
        int predSize;
        Predicate curPred;
        // Loop over all predicates
        Tuple tuple;
        for (int i = 0; i < listSize; i++) {
            curPred = preds.get(i);
            predSize = curPred.size();
            // Create new tuple
            tuple = new Tuple(predSize);
            // For each variable in the predicate, add values
            for (int j = 0; j < predSize; j++) {
                value = curPred.variableI(j);
                if (!value.isAnyConstant()) {
                    varName = value.getValueStr();
                    if (varsToValues.containsKey(varName)) {
                        value = varsToValues.get(varName);
                    } else {
                        if (makeFreshValuesSkolems) {
                            value = Value.createFreshSkolem();
                        } else {
                            value = Value.createFreshVariable();
                        }
                        varsToValues.put(varName, value);
                    }
                }
                tuple.addValue(value);
            }
            // Add tuple to the relation
            db.getRelationInstance(curPred.getFunctionHead()).addTuple(tuple);
        }
    }

}
