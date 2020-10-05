package hadad.base.compiler;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.Singleton;

import hadad.commons.conjunctivequery.Variable;

/**
 * Maps variable names in the input query (syntax) to conjunctive query
 * variables in the nested block tree.
 */
@Singleton
public final class VariableMapper {
    /*
     * Mapping between variable names in the input query (syntax) to conjunctive
     * query variables in the nested block tree.
     */
    private Map<String, Variable> variablesMapping;

    /**
     * Constructs a new variable mapper.
     */
    public VariableMapper() {
        variablesMapping = new HashMap<String, Variable>();
    }

    /**
     * Defines a mapping within the specified variable defined in the input
     * query (syntax) and conjunctive query variable in the nested block tree.
     *
     * Throws an IllegalStateException if the specified variable defined in the
     * input query (syntax) is already defined in this variable mapping.
     *
     * @param str
     *            the variable defined in the input query (syntax)
     * @param var
     *            the conjunctive query variable defined in the nested block
     *            tree
     * @throws IllegalStateException
     */
    public void define(final String str, final Variable var) throws IllegalStateException {
        assertUndefined(str);
        variablesMapping.put(str, var);
    }

    /**
     * The conjunctive query variable in the nested block tree for the specified
     * variable defined in the input query (syntax).
     *
     * Throws an IllegalStateException if the specified variable defined in the
     * input query (syntax) is not defined in this variable mapping.
     *
     * @param str
     *            the conjunctive query variable in the nested block tree for
     *            the specified variable defined in the input query (syntax)
     * @throws IllegalStateException
     */
    public Variable getVariable(final String str) throws IllegalStateException {
        assertDefined(str);
        return variablesMapping.get(str);
    }

    /**
     * Removes all of the mappings from this variable mapping.
     *
     * The variable mapping will be empty after this call returns.
     */
    public void reset() {
        variablesMapping.clear();
    }

    /**
     * <code>true</code> if the specified variable is defined in the input query
     * (syntax) is defined.
     *
     * @param str
     *            the conjunctive query variable in the nested block tree for
     *            the specified variable defined in the input query (syntax)
     * @return <code>true</code> if the specified variable is defined in the
     *         input query (syntax) is defined.
     */
    private boolean isDefined(final String str) {
        return variablesMapping.containsKey(str);
    }

    /**
     * <code>true</code> if the specified variable is not defined in the input
     * query (syntax) is defined.
     *
     * @param str
     *            the conjunctive query variable in the nested block tree for
     *            the specified variable defined in the input query (syntax)
     * @return <code>true</code> if the specified variable is defined in the
     *         input query (syntax) is defined.
     */
    public boolean isNotDefined(final String str) {
        return !variablesMapping.containsKey(str);
    }

    /**
     * Throws an IllegalStateException if the specified variable defined in the
     * input query (syntax) is not defined in this variable mapping.
     *
     * @param str
     *            the conjunctive query variable in the nested block tree for
     *            the specified variable defined in the input query (syntax)
     * @throws IllegalStateException
     */
    private void assertDefined(final String str) throws IllegalStateException {
        if (!isDefined(str)) {
            throw new IllegalStateException("The variable " + str + " is not defined.");
        }
    }

    /**
     * Checks if variablesMapping is empty or not
     * 
     * @return <code>true</code> if the variablesMapping is empty; otherwise
     *         false.
     */
    public boolean isEmptyVariablesMapping() {
        return variablesMapping.isEmpty();
    }

    /**
     * Returns VariableMapping
     * 
     * @return variablesMapping
     */
    public Map<String, Variable> getVariableMapping() {
        return variablesMapping;
    }

    /**
     * Adds a given VariableMapping
     */
    public void setVariableMapping(Map<String, Variable> variablesMapping) {
        this.variablesMapping = variablesMapping;
    }

    /**
     * Sets/Updates a Variable mapping
     */
    public void updateVariable(final String str, final Variable var) {
        this.variablesMapping.put(str, var);
    }

    /**
     * Throws an IllegalStateException if the specified variable defined in the
     * input query (syntax) is already defined in this variable mapping.
     *
     * @param str
     *            the conjunctive query variable in the nested block tree for
     *            the specified variable defined in the input query (syntax)
     * @throws IllegalStateException
     */
    private void assertUndefined(final String str) throws IllegalStateException {
        if (isDefined(str)) {
            throw new IllegalStateException("The variable " + str + " is already defined.");
        }
    }

    /**
     * Concatenates a given VariableMapper variable mappings with a current one
     * 
     * @param variableMapper
     *            a VariableMapper
     * @throws IllegalStateException
     */
    public void addAll(VariableMapper variableMapper) throws IllegalStateException {
        assert (variableMapper != null);
        for (Map.Entry<String, Variable> varDefinition : variableMapper.variablesMapping.entrySet()) {
            assertUndefined(varDefinition.getKey());
            variablesMapping.put(varDefinition.getKey(), varDefinition.getValue());
        }
    }

    @Override
    public String toString() {
        return variablesMapping.toString();
    }

    @Override
    public int hashCode() {
        return variablesMapping.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof VariableMapper) && variablesMapping.equals(((VariableMapper) o).variablesMapping);
    }
}
