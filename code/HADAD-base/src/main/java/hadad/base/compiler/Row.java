package hadad.base.compiler;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;

import com.google.common.collect.ImmutableMap;

import hadad.commons.conjunctivequery.Variable;
import hadad.commons.miscellaneous.Tuple;

/**
 * Represents a row in a table (including the data type for each column).
 *
 * Used to construct a return template.
 */
public final class Row {
    /* The columns, their data type and value in this row. */
    private final ImmutableMap<Variable, Tuple<DataType, Object>> columns;

    /**
     * Constructs a row with the specified columns.
     *
     * @param columns
     *            the columns, their data type and value for the row.
     */
    public Row(final Map<Variable, Tuple<DataType, Object>> columns) {
        this.columns = ImmutableMap.copyOf(checkNotNull(columns));
    }

    /**
     * <code>true</code> if the specified variable is defined in this row.
     *
     * @param str
     *            conjunctive query variable whose presence in this row is to be
     *            tested.
     * @return <code>true</code> if the specified variable is defined in this
     *         row.
     */
    public boolean contains(final Variable var) {
        return columns.containsKey(var);
    }

    /**
     * The value (wrt its data type) in this row for the specified variable.
     *
     * Throws an IllegalStateException if the specified variable is not defined
     * in this row.
     *
     * @param var
     *            conjunctive query variable whose value in this row is
     *            required.
     * @return the value (wrt its data type) in this row for the specified
     *         variable.
     */
    public Object getValue(final Variable var) {
        assertDefined(var);
        return getDataType(var).valueOf(columns.get(var).second());
    }

    /**
     * The data type in this row for the specified variable.
     *
     * Throws an IllegalStateException if the specified variable is not defined
     * in this row.
     *
     * @param var
     *            conjunctive query variable whose data type in this row is
     *            required.
     * @return the data type in this row for the specified variable.
     */
    private DataType getDataType(final Variable var) {
        assertDefined(var);
        return columns.get(var).first();
    }

    /**
     * Throws an IllegalStateException if the specified variable is not defined
     * in this row.
     *
     * @param var
     *            conjunctive query variable whose presence in this row is to be
     *            tested
     * @throws IllegalStateException
     */
    private void assertDefined(final Variable var) throws IllegalStateException {
        if (!contains(var)) {
            throw new IllegalStateException("The variable " + var + " is not defined in this row.");
        }
    }

    @Override
    public String toString() {
        final StringBuilder varsBuilder = new StringBuilder();
        final StringBuilder typesBuilder = new StringBuilder();
        final StringBuilder valuesBuilder = new StringBuilder();
        String prefix = "";
        for (final Variable var : columns.keySet()) {
            varsBuilder.append(prefix).append(var.toString());
            typesBuilder.append(prefix).append("(").append(getDataType(var).toString()).append(")");
            valuesBuilder.append(prefix).append(getValue(var).toString());
            prefix = " | ";
        }
        final StringBuilder builder = new StringBuilder();
        builder.append(varsBuilder).append("\n").append(typesBuilder).append("\n").append(valuesBuilder).append("\n");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return columns.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Row) && columns.equals(((Row) o).columns);
    }
}
