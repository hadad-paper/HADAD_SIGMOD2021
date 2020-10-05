package hadad.base.compiler;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.conjunctivequery.Variable;

/**
 * Part of query block tree data structure.
 *
 * Specialization of a block composed also by link to its parent.
 *
 * Used when the block is a child block.
 */
public final class ChildBlock extends Block {
    /* This block parent block. */
    private Block parent;
    /*
     * The created node tag (in this block parent return template) containing
     * this block.
     */
    private String createdNode;
    /*
     * Index of this block in its parent children list (ie. among it siblings).
     */
    private int indexOf;

    /*
     * Tradeoff architecture for decoders (lack of time).
     *
     * TODO: implement the decoders per format and remove the constructor and
     * the class property encoding.
     */
    @Deprecated
    public ChildBlock(final Block parent, final ConjunctiveQuery encoding, final ReturnTemplate template) {
        super(encoding, template);
        this.parent = checkNotNull(parent);
        createdNode = null;
    }

    /**
     * Constructs a new (nested block tree) child block with the specified
     * parent, parent created node containing this child block, pattern and
     * return template.
     *
     * @param parent
     *            the parent block.
     * @param createdNode
     *            the created node tag in the parent block.
     * @param pattern
     *            the pattern (structural + optionally conditions).
     * @param template
     *            the return template.
     */
    public ChildBlock(final Block parent, final String createdNode, final Pattern pattern,
            final ReturnTemplate template) {
        super(pattern, template);
        this.parent = checkNotNull(parent);
        this.createdNode = checkNotNull(createdNode);
    }

    /**
     * This block parent.
     *
     * @return this block parent.
     */
    public Block getParent() {
        return parent;
    }

    /**
     * The created node tag (in this block parent return template) containing
     * this block.
     *
     * @return the created node tag (in this block parent return template)
     *         containing this block.
     */
    public String getParentCreatedNodeTag() {
        return createdNode;
    }

    /**
     * The created node variable in the parent for this block.
     *
     * @return the created node variable in the parent for this block.
     */
    public Variable getCreatedNode() {
        return getParent().getReturnTemplate().getCreatedNode(ElementFactory.createElement(createdNode));
    }

    /**
     * Sets the index of this block in its parent.
     *
     * To be called by the parent on the addChild.
     *
     * @param indexOf
     *            the index of this block in its parent.
     */
    public void setIndexOf(int indexOf) {
        this.indexOf = indexOf;
    }

    /**
     * Sets the created node tag in the parent block.(Used in the Mixed Model
     * Compiler)
     *
     * @param createdNode
     */
    public void setCreatedNode(String createdNode) {
        this.createdNode = createdNode;
    }

    /**
     * Sets the parent block for this child block (Used in the Mixed Model
     * Compiler)
     *
     * @param parent
     */
    public void setParentBlock(Block parent) {
        this.parent = parent;
    }

    @Override
    public Map<Variable, PathExpression> getVisibleDefinitions() {
        final ImmutableMap.Builder<Variable, PathExpression> builder = ImmutableMap.builder();
        builder.putAll(getParent().getVisibleDefinitions());
        builder.putAll(getLocalDefinitions());
        return builder.build();
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
        return getParent().getId() + "_" + Integer.toString(indexOf);

    }

    @Override
    public String getQueryName() {
        return getParent().getQueryName();
    }

    @Override
    public Set<Variable> getContextVariables() {
        final ImmutableSet.Builder<Variable> builder = ImmutableSet.builder();
        if (!(getParent() instanceof RootBlock)) {
            builder.addAll(getParent().getContextVariables());
        }
        builder.addAll(getParent().getLocalDefinedVariables());
        return builder.build();
    }

    /* Parent string up to id to avoid infinite loop. */
    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("PARENT: ").append(parent.getId()).append("\n").append(super.toString());
        return builder.toString();
    }

    /* Parent equality up to id equality to avoid infinite loop. */
    @Override
    public int hashCode() {
        return Objects.hash(parent.getId(), super.hashCode());
    }

    /* Parent equality up to id equality to avoid infinite loop. */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ChildBlock)) {
            return false;
        }
        final ChildBlock p = (ChildBlock) o;
        return super.equals(p) && parent.getId().equals(p.parent.getId());
    }
}
