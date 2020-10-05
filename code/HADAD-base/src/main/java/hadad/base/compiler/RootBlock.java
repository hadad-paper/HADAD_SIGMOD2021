package hadad.base.compiler;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.conjunctivequery.Variable;
import hadad.commons.miscellaneous.Tuple;

/**
 * Part of query block tree data structure.
 *
 * Specialization of a block composed also by query name.
 *
 * Used when the block is the root block.
 */
public final class RootBlock extends Block {
    /*
     * The query name represented by the nested block tree whose root is this
     * root block.
     */
    private final String queryName;

    /**
     * Constructs a new (nested block tree) root block with the specified query
     * name, return template.
     *
     * The constructed block will have empty pattern.
     *
     * @param queryName
     *            the query name.
     * @param template
     *            the return template.
     */
    public RootBlock(final String queryName, final ReturnTemplate template) {
        this(queryName, createEmptyPattern(), template);
    }

    private static Pattern createEmptyPattern() {
        return new Pattern(new Structural(new ArrayList<Tuple<Variable, PathExpression>>(), new ArrayList<String>()),
                new Conditional(new ArrayList<Condition>(), new ArrayList<PathExpression>(), new ArrayList<String>()));
    }

    /*
     * Tradeoff architecture for decoders (lack of time).
     * 
     * TODO: implement the decoders per format and remove the constructor and
     * the class property encoding.
     */
    @Deprecated
    public RootBlock(final String queryName, final ConjunctiveQuery encoding, final ReturnTemplate template) {
        super(encoding, template);
        this.queryName = checkNotNull(queryName);
    }

    /**
     * Constructs a new (nested block tree) root block with the specified query
     * name, pattern and return template.
     *
     * @param queryName
     *            the query name.
     * @param pattern
     *            the pattern (structural + optionally conditions).
     * @param template
     *            the return template.
     */
    public RootBlock(final String queryName, final Pattern pattern, final ReturnTemplate template) {
        super(pattern, template);
        this.queryName = checkNotNull(queryName);
    }

    @Override
    public Map<Variable, PathExpression> getVisibleDefinitions() {
        return getLocalDefinitions();
    }

    @Override
    protected void accept(final QueryBlockTreeVisitor visitor) {
        visitor.visit(this);
        getChildren().stream().forEach(c -> c.accept(visitor));
    }

    @Override
    protected void acceptDFS(final QueryBlockTreeVisitorDFS visitor) {
        visitor.visitPre(this);
        getChildren().stream().forEach(c -> c.acceptDFS(visitor));
        visitor.visitPost(this);
    }

    @Override
    public String getId() {
        return getQueryName() + "_0";
    }

    @Override
    public String getQueryName() {
        return queryName;
    }

    @Override
    public Set<Variable> getContextVariables() {
        return new ImmutableSet.Builder<Variable>().build();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(queryName).append(" := ").append("\n").append(super.toString());
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(queryName, super.hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof RootBlock)) {
            return false;
        }
        final RootBlock p = (RootBlock) o;
        return super.equals(p) && queryName.equals(p.queryName);
    }
}
