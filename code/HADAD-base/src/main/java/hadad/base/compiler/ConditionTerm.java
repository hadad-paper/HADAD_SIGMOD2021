package hadad.base.compiler;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import hadad.commons.conjunctivequery.Term;
import hadad.commons.conjunctivequery.Variable;

/**
 * Part of query block tree data structure.
 *
 * Represents a term in a nested block tree block conditional expression
 * condition.
 */
public final class ConditionTerm {
    /* The conjunctive query term for this condition term. */
    private final Term term;
    /* The variables referred in this condition term. */
    private final ImmutableSet<Variable> referredVariables;
    /* The path expressions introduced this condition term. */
    private final ImmutableList<PathExpression> pathExpressions;

    /**
     * Constructs a new (nested block tree block conditional expression)
     * condition term with the specified conjunctive query term, referred
     * variables and path expressions.
     *
     * @param term
     *            the conjunctive query term for this condition term.
     * @param referredVariables
     *            the variables referred in this condition term.
     * @param pathExpressions
     *            the path expressions introduced this condition term.
     */
    public ConditionTerm(final Term term, final Set<Variable> referredVariables,
            final List<PathExpression> pathExpressions) {
        this.term = checkNotNull(term);
        this.referredVariables = ImmutableSet.copyOf(referredVariables);
        this.pathExpressions = ImmutableList.copyOf(pathExpressions);
    }

    /**
     * Gets the term of this condition term
     *
     * @return the term of this condition term
     */
    public Term getTerm() {
        return term;
    }

    /**
     * The variables referred in this condition.
     *
     * @return variables referred in this condition.
     */
    Set<Variable> getReferredVariables() {
        final ImmutableSet.Builder<Variable> builder = ImmutableSet.builder();
        builder.addAll(referredVariables);
        pathExpressions.stream().map(PathExpression::getReferredVariables).forEach(builder::addAll);
        return builder.build();
    }

    /**
     * The path expressions in this condition.
     *
     * @return path expressions in this condition.
     */
    List<PathExpression> getPathExpressions() {
        return pathExpressions;
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();
        result.append(term).append("(").append(referredVariables.toString()).append(")").append("[")
                .append(pathExpressions.toString()).append("]");
        return result.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(term, referredVariables, pathExpressions);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ConditionTerm)) {
            return false;
        }
        final ConditionTerm eq = (ConditionTerm) o;
        return term.equals(eq.term) && referredVariables.equals(eq.referredVariables)
                && pathExpressions.equals(eq.pathExpressions);
    }
}
