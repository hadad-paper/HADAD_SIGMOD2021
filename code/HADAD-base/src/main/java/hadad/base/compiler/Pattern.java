package hadad.base.compiler;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.rits.cloning.Cloner;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.Variable;

/**
 * Part of query block tree data structure.
 *
 * Represents (nested block tree) block pattern expression, composed of the
 * structural and the conditional.
 */
public final class Pattern {
    /* The structural of this pattern. */
    private final Structural structural;
    /* The conditional of this pattern. */
    private final Conditional conditional;

    /**
     * Constructs a new pattern with the specified structural and conditional.
     *
     * @param structural
     *            the structural for the pattern.
     * @param conditional
     *            the conditional for the pattern.
     * @param models
     *            Models appear in this pattern
     */
    public Pattern(final Structural structural, final Conditional conditional) {
        this.structural = checkNotNull(structural);
        this.conditional = checkNotNull(conditional);

    }

    /**
     * Returns <code>true</code> if this pattern contains no structural and no
     * conditionals.
     *
     * @return <code>true</code> if this structural contains no structural and
     *         no conditionals.
     */
    public boolean isEmpty() {
        return structural.isEmpty() && conditional.isEmpty();
    }

    /**
     * The variables introduced in this block.
     *
     * @return variables introduced in this block.
     */
    public List<Variable> getLocalDefinedVariables() {
        return structural.getDefinedVariables();
    }

    /**
     * The variables referred in this block.
     *
     * @return variables referred in this block.
     */
    public Set<Variable> getReferredVariables() {
        final ImmutableSet.Builder<Variable> builder = ImmutableSet.builder();
        builder.addAll(structural.getReferredVariables());
        builder.addAll(conditional.getReferredVariables());
        return builder.build();
    }

    /**
     * The definitions introduced in this structural.
     *
     * @return definitions introduced in this structural.
     */
    public Map<Variable, PathExpression> getDefinitions() {
        return structural.getDefinitions();
    }

    /**
     * Encodes this pattern into relational CQ model.
     *
     * @param f
     *            the function that accepts one condition as argument and return
     *            its encoding.
     * @return relational CQ encoding for this pattern.
     */
    public List<Atom> encoding(final Function<Condition, List<Atom>> f) {
        final ImmutableList.Builder<Atom> builder = ImmutableList.builder();
        builder.addAll(structural.encoding());
        builder.addAll(conditional.encoding());
        builder.addAll(conditional.encoding(f));
        return builder.build();
    }

    /**
     * @param p
     *            the pattern that will be merged with current pattern
     * @return the new merged pattern
     */
    public Pattern mergePattern(final Pattern p) {
        this.structural.merge(p.structural);
        this.conditional.merge(p.conditional);
        return this;
    }

    /**
     * Returns the structural instance of the current pattern
     * 
     * @return
     */
    public Structural getStructural() {
        return this.structural;
    }

    /**
     * Returns the conditional instance of the current pattern
     * 
     * @return
     */
    public Conditional getConditional() {
        return this.conditional;
    }

    public Pattern deepClone() {
        final Cloner cloner = new Cloner();
        return cloner.deepClone(this);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        if (!structural.isEmpty()) {
            builder.append("FOR: ").append(structural.toString()).append(";\n");
        }
        if (!conditional.isEmpty()) {
            builder.append("WHERE: ").append(conditional.toString()).append(";\n");
        }
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(structural, conditional);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pattern)) {
            return false;
        }
        final Pattern p = (Pattern) o;
        return structural.equals(p.structural) && conditional.equals(p.conditional);
    }
}
