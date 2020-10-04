package hadad.db.query;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.logging.Logger;

import hadad.db.canonicaldb.CanonicalSchema;
import hadad.db.canonicaldb.Database;
import hadad.db.canonicaldb.Relation;
import hadad.db.canonicaldb.Tuple;
import hadad.db.datalogexpr.Predicate;
import hadad.db.datalogexpr.Value;

/**
 * This operator takes as input a predicate and a database instance and produces
 * the database tuples matching the predicate. It is a ScanRelation operator
 * that also does Selection and Join inside the relational atom.
 */
public class MapPredicates extends Operator {

    /** Logger */
    private final static Logger LOGGER = Logger.getLogger(MapPredicates.class.getName());

    /** The query <code>Predicate</code>. */
    private final Predicate queryPred;

    /** The <code>Database</code> instance on which the query is run. */
    private final Database db;

    /**
     * An iterator over the set of tuples of the database <code>Relation</code>
     * corresponding to the query predicate.
     */
    private final Relation.TupleIterator dbTupleIter;

    /**
     * Map of a column position to the position of the immediately previous
     * column with the same variable (if it exists). This is used for joins.
     */
    private final Map<Integer, Integer> joins;

    /**
     * The projection component.
     */
    private final UnaryProjectComponent project;

    /**
     * Constructor.
     * 
     * @param queryPred
     *            A <code>Predicate</code> of the query <code>Statement</code>
     * @param db
     *            The contained <code>Database</code> instance
     */
    public MapPredicates(final Predicate queryPred, final Database db, final CanonicalSchema outputSchema,
            final LinkedHashMap<Integer, Value> newVars) {
        super();
        this.queryPred = queryPred;
        this.db = db;
        if (db == null || db.getRelationInstance(queryPred.getFunctionHead()) == null) {
            throw new IllegalArgumentException("No relation exsistis");
        }
        Relation dbRelation = db.getRelationInstance(queryPred.getFunctionHead());
        dbTupleIter = dbRelation.getTupleIterator(this);

        joins = findJoins();
        CanonicalSchema predSchema = queryPred.getCanonicalSchema();
        project = new UnaryProjectComponent(outputSchema, predSchema, newVars);
        outSchema = project.outSchema;
    }

    /**
     * Finds joins within the same predicate.
     */
    private Map<Integer, Integer> findJoins() {
        Map<String, Integer> vars = new LinkedHashMap<String, Integer>();
        Map<Integer, Integer> joins = new LinkedHashMap<Integer, Integer>();
        Value queryVal;
        for (int i = 0; i < queryPred.size(); i++) {
            queryVal = queryPred.variableI(i);
            if (!queryVal.isAnyConstant()) {
                if (vars.containsKey(queryVal.getValueStr()))
                    joins.put(i, vars.get(queryVal.getValueStr()));
                
                vars.put(queryVal.getValueStr(), i);
            }
        }
        return joins;
    }

    @Override
    public void enQueue(LinkedList<Tuple> tuples, Object caller) {
        throw new QueryEvaluationException("Enqueue called for " + this.getClass().getName());
    }

    @Override
    public void enQueue(Tuple tuple, Object caller) {
        throw new QueryEvaluationException("Enqueue called for " + this.getClass().getName());
    }

    @Override
    protected Tuple next() {
        Value queryVal;
        Value dbVal;
        Tuple tupleAfterProjection = null;
        boolean foundTuple;
        int queryPredSize = queryPred.size();
        while (dbTupleIter.hasNext()) {
            Tuple curTuple = dbTupleIter.next();
            foundTuple = true;
            for (int i = 0; i < queryPredSize; i++) {
                queryVal = queryPred.variableI(i);
                dbVal = curTuple.getValue(i);

                if ((queryVal.isAnyConstant() && !queryVal.equals(dbVal)) || (!queryVal.isAnyConstant()
                        && joins.containsKey(i) && !dbVal.equals(curTuple.getValue(joins.get(i))))) {
                    foundTuple = false;
                    break;
                }
            }
            if (foundTuple) {
                tupleAfterProjection = project.projectTuple(curTuple);
                if (tupleAfterProjection != null)
                    break;
            }
        }
        return tupleAfterProjection;
    }

    @Override
    protected boolean hasEmptyInput() {
        return !dbTupleIter.hasNext();
    }

    public Predicate getPred() {
        return queryPred;
    }
    public Relation.TupleIterator getIterator(){
        return dbTupleIter;
    }
    @Override
    protected StringBuffer printString() {
        if (queryPred == null)
            return new StringBuffer("");
        final StringBuffer retVal = new StringBuffer(project.toString());
        retVal.append(" Scan(");
        retVal.append(queryPred.printString().toString());
        retVal.append(")");
        return retVal;
    }

    @Override
    protected boolean isBlockedDefault() {
        return false;
    }

    @Override
    protected void flush() {
        dbTupleIter.reset();
        project.flush();
    }

    @Override
    protected void setOutSchema() {
    }

}
