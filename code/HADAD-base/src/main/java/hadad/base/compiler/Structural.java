package hadad.base.compiler;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.Variable;
import hadad.commons.miscellaneous.Tuple;

/**
 * Represents (query block tree) block pattern expression structural, composed
 * of the variables introduced in the block and their correspondent path
 * expressions.s
 */
public final class Structural {
    /*
     * The introduced variables and their correspondent path expression
     * definition in this structural.
     */
    private Map<Variable, PathExpression> definitions;
    /*
     * Order in which the variables where introduced in this structural.
     */
    private List<Variable> order;

    /* List of models appear in this pattern */
    private List<String> models;

    /**
     * Constructs a new structural with the specified definitions.
     *
     * @param definitions
     *            the introduced variables and their correspondent path
     *            expression definition for the structural.
     */
    public Structural(final List<Tuple<Variable, PathExpression>> definitions, final List<String> models) {
        this.definitions = new HashMap<Variable, PathExpression>();
        this.order = new ArrayList<Variable>();
        for (final Tuple<Variable, PathExpression> definition : checkNotNull(definitions)) {
            this.definitions.put(definition.first(), definition.second());
            this.order.add(definition.first());
        }
        this.models = models;
    }

    /**
     * Merged the given Structural with the current structural
     * 
     * @param s
     *            the given structural
     */
    public void merge(final Structural s) {
        for (final Variable b : s.definitions.keySet()) {
            if (definitions.containsKey(b)) {
                System.out.println(b.toString());
            } else
                definitions.put(b, s.definitions.get(b));
        }
        order.addAll(s.order);
        models.addAll(s.models);
    }

    /**
     * Return the current constructed structural instance
     * 
     * @return Structural instance
     */
    public Structural getStructural() {
        return this;
    }

    /**
     * The variables introduced in this structural.
     *
     * @return variables introduced in this structural.
     */
    public List<Variable> getDefinedVariables() {
        return order;
    }

    /**
     * The path expressions introduced in this structural.
     *
     * @return path expressions introduced in this structural.
     */
    public Collection<PathExpression> getPathExpressions() {
        return definitions.values();
    }

    /**
     * The definitions introduced in this structural.
     *
     * @return definitions introduced in this structural.
     */
    public Map<Variable, PathExpression> getDefinitions() {
        return definitions;
    }

    /**
     * The models introduced in this structural.
     * 
     * @return models
     */
    public List<String> getModels() {
        return this.models;
    }

    /**
     * The variables referred in this structural.
     *
     * @return variables referred in this structural.
     */
    public Set<Variable> getReferredVariables() {
        final ImmutableSet.Builder<Variable> builder = ImmutableSet.builder();
        definitions.values().stream().map(PathExpression::getReferredVariables).forEach(builder::addAll);
        return builder.build();
    }

    /**
     * Encodes this structural into relational CQ model.
     *
     * @return relational CQ encoding for this structural.
     */
    public List<Atom> encoding() {
        final Set<Atom> encoding = new LinkedHashSet<Atom>();
        order.stream().map(v -> definitions.get(v).encoding()).forEach(encoding::addAll);
        return ImmutableList.copyOf(encoding);
    }

    /**
     * Returns <code>true</code> if this structural contains no definitions.
     *
     * @return <code>true</code> if this structural contains no definitions.
     */
    public boolean isEmpty() {
        return definitions.isEmpty();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("[");
        String prefix = "";
        for (final Variable var : order) {
            builder.append(prefix).append(definitions.get(var).toString());
            prefix = ",";
        }
        builder.append("]");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(definitions, order);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Structural)) {
            return false;
        }
        final Structural p = (Structural) o;
        return definitions.equals(p.definitions) && order.equals(p.order);
    }
}
