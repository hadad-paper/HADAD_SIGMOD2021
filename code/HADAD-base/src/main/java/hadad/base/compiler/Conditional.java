package hadad.base.compiler;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.Variable;

/**
 * Part of query block tree data structure.
 *
 * Represents (nested block tree) block conditional expression.
 * 
 * 
 */
public final class Conditional {
    /* The path expressions introduced in this conditional. */
    private List<PathExpression> pathExpressions;
    /* The conditions composing this conditional. */
    private final List<Condition> conditions;
    /* List of models appear in this pattern */
    private final List<String> models;

    /**
     * Merge the given conditional with the current conditional
     * 
     * @param c
     *            the given conditional
     */
    public void merge(final Conditional c) {
        pathExpressions.addAll(c.pathExpressions);
        conditions.addAll(c.conditions);
        models.addAll(c.models);
    }

    /**
     * Return the current constructed conditional instance
     * 
     * @return Conditional instance
     */
    public Conditional getConditional() {
        return this;
    }

    /**
     * Constructs a new (nested block tree block) conditional expression with
     * the specified conditions and path expressions.
     *
     * @param conditions
     *            the conditions.
     * @param pathExpressions
     *            the path expressions (introduced).
     */
    public Conditional(final List<Condition> conditions, final List<PathExpression> pathExpressions,
            final List<String> models) {
        this.pathExpressions = pathExpressions; // ImmutableList.copyOf(checkNotNull(pathExpressions));
        this.conditions = conditions;
        this.models = models;
    }

    /**
     * The variables referred in this conditional.
     *
     * @return variables referred in this conditional.
     */
    Set<Variable> getReferredVariables() {
        final ImmutableSet.Builder<Variable> builder = ImmutableSet.builder();
        pathExpressions.stream().map(PathExpression::getReferredVariables).forEach(builder::addAll);
        conditions.stream().map(Condition::getReferredVariables).forEach(builder::addAll);
        return builder.build();
    }

    /**
     * The path expressions in this condition.
     *
     * @return path expressions in this condition.
     */
    List<PathExpression> getPathExpressions() {
        final ImmutableList.Builder<PathExpression> builder = ImmutableList.builder();
        builder.addAll(pathExpressions);
        conditions.stream().map(Condition::getPathExpressions).forEach(builder::addAll);
        return builder.build();
    }

    /**
     * The models referred in this conditional.
     *
     * @return models referred in this conditional.
     */
    public List<String> getModels() {
        return this.models;
    }

    /**
     * Returns <code>true</code> if this conditional contains no path
     * expressions not conditions.
     *
     * @return <code>true</code> if this conditional contains no path
     *         expressions not conditions.
     */
    public boolean isEmpty() {
        return pathExpressions.isEmpty() && conditions.isEmpty();
    }

    /**
     * Encodes this conditional into relational CQ model.
     *
     * @param f
     *            the function that accepts one condition as argument and return
     *            its encoding.
     * @return relational CQ encoding for this conditional.
     */
    public List<Atom> encoding(final Function<Condition, List<Atom>> f) {
        final ImmutableList.Builder<Atom> builder = ImmutableList.builder();
        pathExpressions.stream().map(PathExpression::encoding).forEach(builder::addAll);
        conditions.stream().map(f::apply).forEach(builder::addAll);
        return builder.build();
    }

    /**
     * Encodes this conditional into relational CQ model.
     *
     * @param f
     *            the function that accepts one condition as argument and return
     *            its encoding.
     * @return relational CQ encoding for this conditional.
     */
    public List<Atom> encoding() {
        final ImmutableList.Builder<Atom> builder = ImmutableList.builder();
        pathExpressions.stream().map(PathExpression::encoding).forEach(builder::addAll);
        conditions.stream().map(Condition::encoding).forEach(builder::addAll);
        return builder.build();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        if (!pathExpressions.isEmpty()) {
            builder.append("FOR: ").append(pathExpressions.toString()).append(";\n");
        }
        if (!conditions.isEmpty()) {
            builder.append("WHERE: ").append(conditions.toString()).append(";\n");
        }
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(pathExpressions, conditions);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Conditional)) {
            return false;
        }
        final Conditional p = (Conditional) o;
        return pathExpressions.equals(p.pathExpressions) && conditions.equals(p.conditions);
    }
}
