package hadad.base.compiler;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.Variable;

/**
 * Part of query block tree data structure.
 *
 * Represents one binary condition in a block conditional expression.
 */
public final class Condition {
    /* The left term of the binary condition. */
    private final ConditionTerm left;
    /* The right term of the binary condition. */
    private final ConditionTerm right;
    /* The operator of the binary condition. */
    private final Operator op;

    /**
     * Constructs a new (block conditional) binary condition with the specified
     * terms and operator.
     *
     * @param left
     *            the left term of the binary condition.
     * @param op
     *            the operator of the binary condition.
     * @param right
     *            the right term of the binary condition.
     */
    public Condition(final ConditionTerm left, final Operator op, final ConditionTerm right) {
        this.left = checkNotNull(left);
        this.op = checkNotNull(op);
        this.right = checkNotNull(right);
    }

    /**
     * Gets the left operand of this condition
     *
     * @return the left operand of this condition
     */
    public ConditionTerm getLeftOp() {
        return left;
    }

    /**
     * Gets the right operand of this condition
     *
     * @return the right operand of this condition
     */
    public ConditionTerm getRightOp() {
        return right;
    }

    /**
     * Gets the operator of this condition
     *
     * @return the operator of this condition
     */
    public Operator getOperator() {
        return op;
    }

    /**
     * Encodes this conditions into relational CQ model.
     *
     * @return relational CQ encoding for this structural.
     */
    public List<Atom> encoding() {
        final ImmutableList.Builder<Atom> builder = ImmutableList.builder();
        getPathExpressions().stream().map(PathExpression::encoding).forEach(builder::addAll);
        return builder.build();
    }

    /**
     * The variables referred in this condition.
     *
     * @return variables referred in this condition.
     */
    Set<Variable> getReferredVariables() {
        final ImmutableSet.Builder<Variable> builder = ImmutableSet.builder();
        builder.addAll(left.getReferredVariables());
        builder.addAll(right.getReferredVariables());
        return builder.build();
    }

    /**
     * The path expressions in this condition.
     *
     * @return path expressions in this condition.
     */
    List<PathExpression> getPathExpressions() {
        final ImmutableList.Builder<PathExpression> builder = ImmutableList.builder();
        builder.addAll(left.getPathExpressions());
        builder.addAll(right.getPathExpressions());
        return builder.build();
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder();
        result.append(left);
        result.append(op.toString());
        result.append(right);
        return result.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, op, right);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Condition)) {
            return false;
        }
        final Condition eq = (Condition) o;
        return left.equals(eq.left) && op.equals(eq.op) && right.equals(eq.right);
    }
}
