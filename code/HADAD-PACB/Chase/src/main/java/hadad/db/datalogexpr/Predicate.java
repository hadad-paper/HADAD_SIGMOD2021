package hadad.db.datalogexpr;

import java.util.LinkedHashMap;
import java.util.logging.Logger;

import hadad.db.canonicaldb.CanonicalSchema;

/**
 * This class implements a predicate of a Datalog query. A predicate consists of
 * a function name (or relation name), and a listing of variables. The variables
 * and function name are all strings.
 */
public class Predicate implements Cloneable {

    /** Logger */
    private final static Logger LOGGER = Logger.getLogger(Predicate.class.getName());

    /** The relation name. */
    protected String relation;

    /** The variables. */
    protected Value[] variables;

    /** The number of variables in the predicate. */
    protected int numvariables;

    /**
     * Constructor
     * 
     * @param size
     *            the number of variables, <code>Value</code> objects, in the
     *            predicate.
     */
    public Predicate(int size) {
        variables = new Value[size];
        numvariables = 0;
    }

    /**
     * Predicate size
     * 
     * @return predicate size
     */
    public int size() {
        return numvariables;
    }

    /**
     * Get value at index index
     * 
     * @param value
     *            index
     * @return index
     */
    public Value variableI(int index) {
        return variables[index];
    }

    /**
     * Get predicate head
     * 
     * @return predicate head
     */
    public String getFunctionHead() {
        return relation;
    }

    /**
     * Set predicate head
     * 
     * @param relation
     *            the predicate head
     */
    public void setFunctionHead(final String relation) {
        this.relation = relation;
    }

    /**
     * Check if this predicate is equal to another one
     * 
     * @param predciate
     *            the predicate to be compared with
     * @return <code> True </code> if there are equal, otherwise <code> False </code>
     */
    public boolean equals(final Predicate predciate) {
        int counter;
        if (numvariables == predciate.numvariables && relation.equals(predciate.relation)) {
            for (counter = 0; counter < numvariables; counter++) {
                if (!variableI(counter).equals(predciate.variableI(counter))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Add variable
     * 
     * @param value
     *            the variable to be added
     * @return <code> True </code> indicating that the variable is added
     */
    public boolean addVariable(final Value value) {
        variables[numvariables] = value;
        numvariables++;
        return true;
    }

    /**
     * This function returns the location the given variable is at.
     * 
     * @param var
     *            the variable to look for
     * @return the location of the given variable; -1 if the variable was not
     *         found
     */
    public int variableIsAt(Value var) {
        for (int i = 0; i < numvariables; i++)
            if (var.equals(variableI(i)))
                return i;

        return -1;
    }

    public boolean containsVariable(Value avar) {
        for (int i = 0; i < numvariables; i++) {
            if (avar.equals(variableI(i))) {
                return true;
            }
        }

        return false;
    }

    public StringBuffer printString() {
        int counter;
        if (relation == null) {
            return new StringBuffer("");
        }

        StringBuffer retval = new StringBuffer(relation);
        retval.append("(");
        if (numvariables > 0) {
            for (counter = 0; counter < numvariables - 1; counter++) {
                retval.append(variableI(counter).getValueStr());
                retval.append(",");
            }
            retval.append(variableI(numvariables - 1).getValueStr());
        }
        retval.append(")");

        return retval;
    }

    // Should we buffer that?
    public CanonicalSchema getCanonicalSchema() {
        Value cur;

        CanonicalSchema schema = new CanonicalSchema();

        // The schema may contain the same variable multiple
        // times as well as constants
        for (int i = 0; i < numvariables; i++) {
            cur = variables[i];
            if (cur.isAnyConstant())
                schema.addColumnName(CanonicalSchema.freshColName());
            else
                schema.addColumnName(variables[i].getValueStr());
        }

        return schema;
    }

    public LinkedHashMap<Integer, Value> getPosToValueCorrespondence() {
        LinkedHashMap<Integer, Value> map = new LinkedHashMap<Integer, Value>();
        Value cur;

        for (int i = 0; i < numvariables; i++) {
            cur = variables[i];
            if (cur.isAnyConstant())
                map.put(i, cur);
        }

        return map;
    }
    
    
    public String getRelation() {
       return  relation;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();

        if (relation != null)
            buffer.append(relation);

        buffer.append("(");

        for (int i = 0; i < numvariables - 1; i++) {
            buffer.append(variables[i].getValueStr());
            buffer.append(",");
        }

        if (numvariables > 0)
            buffer.append(variables[numvariables - 1].getValueStr());

        buffer.append(")");

        return buffer.toString();
    }

}
