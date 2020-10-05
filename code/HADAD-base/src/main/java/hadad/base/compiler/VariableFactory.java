package hadad.base.compiler;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import hadad.commons.conjunctivequery.Variable;

/**
 * Provides fresh conjunctive query variables.
 */
public final class VariableFactory {
    /* The fresh variables name prefix. */
    private final String freshVarPrefix;
    /* The fresh variables counter. */
    private int freshVarCounter;

    /**
     * Constructs a new variable factory with the specified fresh variable name
     * prefix.
     *
     * @param freshVarPrefix
     *            the fresh variables name prefix
     */
    public VariableFactory(final String freshVarPrefix) {
        this.freshVarPrefix = checkNotNull(freshVarPrefix);
        reset();
    }

    /**
     * Creates a fresh variable.
     *
     * @return a fresh variable.
     */
    public Variable createFreshVar() {
        return new Variable(freshVarPrefix + Integer.toString(freshVarCounter++));
    }

    /**
     * Restarts the fresh variables counter to its initial seed.
     */
    public void reset() {
        freshVarCounter = 0;
    }

    @Override
    public String toString() {
        return freshVarPrefix + ": " + freshVarCounter;
    }

    @Override
    public int hashCode() {
        return Objects.hash(freshVarPrefix, freshVarCounter);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof VariableFactory)) {
            return false;
        }
        final VariableFactory p = (VariableFactory) o;
        return freshVarPrefix.equals(p.freshVarPrefix) && freshVarCounter == p.freshVarCounter;
    }
}
