package hadad.base.compiler;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import hadad.commons.conjunctivequery.Term;
import hadad.commons.conjunctivequery.Variable;

/**
 * Part of nested block tree data structure.
 *
 * Represents (nested block tree) block return template variable (leaf) term.
 */
public final class ReturnVariableTerm extends ReturnTerm implements ReturnLeafTerm {
    /* The variable of this return (leaf) term */
    private final Variable var;
    /* The optionals in this return template. */
    private final ImmutableMap<String, String> optionals;

    /**
     * Constructs a new return template variable (leaf) term with the specified
     * variable and optionals.
     *
     * @param var
     *            the variable for the return (leaf) term.
     * @param optionals
     *            the optionals for the return variable term.
     */
    public ReturnVariableTerm(final Variable var, final Map<String, String> optionals) {
        this(null, var, optionals);
    }

    /**
     * Constructs a new return template variable (leaf) term with the specified
     * parent return template construct term, variable and optionals.
     *
     * @param parent
     *            the parent return template construct term.
     * @param var
     *            the variable for the return (leaf) term.
     * @param optionals
     *            the optionals for the return variable term.
     */
    public ReturnVariableTerm(final ReturnConstructTerm parent, final Variable var,
            final Map<String, String> optionals) {
        super(parent);
        this.var = checkNotNull(var);
        this.optionals = ImmutableMap.copyOf(checkNotNull(optionals));
    }

    /**
     * The variable of this return (leaf) term.
     *
     * @return the variable of this return (leaf) term.
     */
    public Variable getVariable() {
        return var;
    }

    /**
     * The optionals in this return template.
     *
     * @return optionals in this return template.
     */
    public Map<String, String> getOptionals() {
        return optionals;
    }

    @Override
    public Term toTerm() {
        return var;
    }

    @Override
    public void accept(final ReturnTemplateVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Set<Variable> getReferredVariables() {
        final ImmutableSet.Builder<Variable> builder = ImmutableSet.builder();
        builder.add(var);
        return builder.build();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(var.toString());
        if (!optionals.isEmpty()) {
            builder.append("[").append(optionals.toString()).append("]");
        }
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(var, super.hashCode(), optionals);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ReturnVariableTerm)) {
            return false;
        }
        final ReturnVariableTerm p = (ReturnVariableTerm) o;
        return super.equals(p) && var.equals(p.var) && optionals.equals(p.optionals);
    }
}
