package hadad.base.compiler;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Part of query block tree data structure.
 *
 * Represents the operator in a query block tree block conditional binary
 * condition.
 */
public enum Operator {
    EQUALS("=");

    /* The string representation of the operator. */
    private final String str;

    /**
     * Constructs a new operator with the specified string representation.
     *
     * @param str
     *            the string representation of the operator.
     */
    private Operator(final String str) {
        this.str = checkNotNull(str);
    }

    @Override
    public String toString() {
        return str;
    }
}
