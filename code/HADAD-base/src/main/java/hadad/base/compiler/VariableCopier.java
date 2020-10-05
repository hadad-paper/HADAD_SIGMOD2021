package hadad.base.compiler;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import hadad.commons.conjunctivequery.Variable;

/**
 * Maps variables to a copy of it.
 *
 * Use to store the variable copy made with the COPY predicate (to avoid copying
 * the same variable more than once)
 */
@Singleton
public final class VariableCopier {
    private final String createdNodeVariableCopySuffix;
    /*
     * Mapping between variables and their created copies.
     */
    private final Map<Variable, Variable> variablesCopy;

    /**
     * Constructs a new variable copier.
     */
    @Inject
    public VariableCopier(@Named("created_node_variable_copy_suffix") String createdNodeVariableCopySuffix) {
        this.createdNodeVariableCopySuffix = createdNodeVariableCopySuffix;
        variablesCopy = new HashMap<Variable, Variable>();
    }

    /**
     * The existent copy of the specified variable if already exists; it creates
     * a new copy and return it otherwise.
     *
     * @param var
     *            the variable to copy.
     * @return the existent copy of the specified variable if already exists; it
     *         creates a new copy and return it otherwise.
     */
    public Variable getCopy(final Variable var) {
        if (!variablesCopy.containsKey(var)) {
            variablesCopy.put(var, new Variable(var.getName() + createdNodeVariableCopySuffix));
        }
        return variablesCopy.get(var);
    }

    /**
     * The original of the specified variable copy.
     *
     * Throws an illegal state exception if the specified variable copy is not
     * registered.
     *
     * @param var
     *            the variable copy whose original is required.
     * @return the original of the specified variable copy.
     */
    public Variable getOriginal(final Variable var) throws IllegalStateException {
        for (final Entry<Variable, Variable> entry : variablesCopy.entrySet()) {
            if (entry.getValue().equals(var)) {
                return entry.getKey();
            }
        }
        throw new IllegalStateException("There is no register of the variable copy " + var.toString());
    }

    /**
     * Returns the variables copy map.
     * 
     * @return the variables copy map.
     */
    public Map<Variable, Variable> getVariablesCopy() {
        return variablesCopy;

    }

    /**
     * Removes all of the copies from this variable copies.
     *
     * The variable copies will be empty after this call returns.
     */
    public void reset() {
        variablesCopy.clear();
    }

    @Override
    public String toString() {
        return variablesCopy.toString();
    }

    @Override
    public int hashCode() {
        return variablesCopy.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof VariableCopier) && variablesCopy.equals(((VariableCopier) o).variablesCopy);
    }
}
