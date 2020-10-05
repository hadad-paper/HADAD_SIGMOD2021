package hadad.base.compiler;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.conjunctivequery.Variable;

/**
 * Part of query block tree data structure.
 *
 * We call block of a query V the structure that reflects a flwr expression,
 * composed by a pattern (structural + optionally conditions) and a return
 * template.
 *
 * Blocks are named (identified) using Dewey notation, based on the position of
 * each block within the list of its siblings.
 */
public abstract class Block {
    /* The pattern (structural + optionally conditions) of this block */
    private final Pattern pattern;
    /* The return template of this block */
    private final ReturnTemplate template;
    /*
     * The children of the block reflects (in the parent-child relationship) the
     * immediate nesting relationship of the syntaxes
     */
    private final List<ChildBlock> children;
    /*
     * Tradeoff architecture for decoders (lack of time).
     *
     * TODO: implement the decoders per format and remove the constructor and
     * the class property encoding.
     */
    @Deprecated
    private final ConjunctiveQuery encoding;

    /*
     * Tradeoff architecture for decoders (lack of time).
     *
     * TODO: implement the decoders per format and remove the constructor and
     * the class property encoding.
     */
    @Deprecated
    public Block(final ConjunctiveQuery encoding, final ReturnTemplate template) {
        children = new ArrayList<ChildBlock>();
        this.encoding = encoding;
        this.template = template;
        pattern = null;
    }

    /**
     * Constructs a new (nested block tree) block with the specified pattern and
     * return template.
     *
     * @param pattern
     *            the pattern (structural + optionally conditions).
     * @param template
     *            the return template.
     */
    public Block(final Pattern pattern, final ReturnTemplate template) {
        children = new ArrayList<ChildBlock>();
        this.pattern = checkNotNull(pattern);
        this.template = checkNotNull(template);
        encoding = null;
    }

    /**
     * The pattern (structural + optionally conditions) of this block.
     *
     * @return the pattern (structural + optionally conditions) of this block.
     */
    public Pattern getPattern() {
        return pattern;
    }

    /**
     * The return template of this block.
     *
     * @return the return template of this block.
     */
    public ReturnTemplate getReturnTemplate() {
        return template;
    }

    /**
     * Returns <code>true</code> if this block have no children.
     *
     * @return <code>true</code> if this block have no children.
     */
    public boolean isLeaf() {
        return children.isEmpty();
    }

    /**
     * Adds a child (in order) to this block.
     *
     * Lateral effect: sets the child index.
     *
     * @param child
     *            the child to be added.
     */
    public void addChild(final ChildBlock child) {
        checkNotNull(child);
        child.setIndexOf(children.size());
        children.add(child);
    }

    /**
     * Immutable copy of this block children.
     *
     * @return copy of this block children
     */
    public List<ChildBlock> getChildren() {
        return ImmutableList.copyOf(children);
    }

    /**
     * The variables introduced in this block.
     *
     * @return variables introduced in this block.
     */
    public List<Variable> getLocalDefinedVariables() {
        return pattern.getLocalDefinedVariables();
    }

    /**
     * The variables referred in this block.
     *
     * @return variables referred in this block.
     */
    public Set<Variable> getReferredVariables() {
        final ImmutableSet.Builder<Variable> builder = ImmutableSet.builder();
        builder.addAll(pattern.getReferredVariables());
        builder.addAll(template.getReferredVariables());
        return builder.build();
    }

    /**
     * The variables referred in this block but introduced by ancestors of this
     * block.
     *
     * @return variables referred in this block but introduced by ancestors of
     *         this block.
     */
    public Set<Variable> getFreeVariables() {
        final Set<Variable> referredVariables = getReferredVariables();
        final ImmutableSet.Builder<Variable> builder = ImmutableSet.builder();
        getContextVariables().stream().filter(referredVariables::contains).forEach(builder::add);
        return builder.build();
    }

    /**
     * The variables available in this block.
     *
     * @return variables available in this block.
     */
    public Set<Variable> getVisibleVariables() {
        final ImmutableSet.Builder<Variable> builder = ImmutableSet.builder();
        builder.addAll(getContextVariables());
        builder.addAll(getLocalDefinedVariables());
        return builder.build();
    }

    /**
     * The (variable) definitions introduced in this block.
     *
     * @return (variable) definitions introduced in this block.
     */
    public Map<Variable, PathExpression> getLocalDefinitions() {
        return pattern.getDefinitions();
    }

    /**
     * Encodes this block into relational CQ model.
     *
     * @param encoder
     *            the block encoder to be use.
     * @return relational CQ encoding for this pattern.
     */
    /*
     * Tradeoff architecture for decoders (lack of time).
     *
     * TODO: implement the decoders per format and remove the constructor and
     * the class property encoding.
     */
    public ConjunctiveQuery encoding(final BlockEncoder encoder) {
        if (encoding != null) {
            return encoding;
        } else {
            return encoder.encode(this);
        }
    }

    /**
     * Decodes this block into relational CQ model.
     *
     * @param decoder
     *            the block encoder to be use.
     * @return relational CQ encoding for this pattern.
     */
    /*
     * public String decoding(final BlockDecoder decoder) { return
     * decoder.decode(this.encoding);
     * 
     * }
     */

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(pattern.toString()).append("\n").append("RETURN TEMPLATE: ").append(template.toString())
                .append("\n");
        if (!children.isEmpty()) {
            builder.append("CHILDREN: ").append("[").append(children.toString()).append("]\n");
        }
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(children, pattern, template);
    }

    @Override
    public boolean equals(Object o) {
        final Block p = (Block) o;
        return children.equals(p.children) && pattern.equals(p.pattern) && template.equals(p.template);
    }

    /**
     * The height of this nested block tree.
     *
     * @return the height of this nested block tree.
     */
    int height() {
        int height = 1;
        if (!children.isEmpty()) {
            height += children.stream().map(Block::height).max(Integer::compare).get();
        }
        return height;
    }

    /**
     * The definitions available in this block.
     *
     * @return definitions available in this block.
     */
    public abstract Map<Variable, PathExpression> getVisibleDefinitions();

    /**
     * Visitor pattern.
     *
     * Provides a way to navigate the elements of a nested block tree.
     *
     * @param visitor
     *            the nested block tree visitor implementation.
     */
    protected abstract void accept(final QueryBlockTreeVisitor visitor);

    /**
     * Visitor pattern.
     *
     * Provides depth-first traversal way to navigate the elements of a nested
     * block tree.
     *
     * @param visitor
     *            the nested block tree visitor implementation.
     */
    protected abstract void acceptDFS(final QueryBlockTreeVisitorDFS visitor);

    /**
     * The unique identifier of this block in the tree.
     *
     * @return unique identifier of this block in the tree
     */
    public abstract String getId();

    /**
     * The query name of this block.
     *
     * @return query name of this block
     */
    public abstract String getQueryName();

    /**
     * The variables introduced by ancestors of this block.
     *
     * @return variables introduced by ancestors of this block.
     */
    public abstract Set<Variable> getContextVariables();
}
