package hadad.base.compiler;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import hadad.commons.conjunctivequery.Variable;

/**
 * Part of query block tree data structure.
 *
 * Represents (nested block tree) block return template construct term.
 */
public final class ReturnConstructTerm extends ReturnTerm {
    /* The element of this return template construct term. */
    private final Element element;
    /* The children of this return template construct term. */
    private final List<ReturnTerm> children;
    /* The attributes of this return template construct term. */
    private final ImmutableMap<String, ReturnLeafTerm> attributes;

    /**
     * Creates a new return template construct term with the specified element
     * and attributes.
     *
     * @param element
     *            the element for the return template construct term.
     * @param attributes
     *            the attributes for the return template construct term.
     */
    public ReturnConstructTerm(final Element element, Map<String, ReturnLeafTerm> attributes) {
        this(null, element, attributes);
    }

    /**
     * Creates a new return template construct term with the specified parent
     * return template construct term, element and attributes.
     *
     * @param parent
     *            the parent return template construct term.
     * @param element
     *            the element for the return template construct term.
     * @param attributes
     *            the attributes for the return template construct term.
     */
    public ReturnConstructTerm(final ReturnConstructTerm parent, final Element element,
            Map<String, ReturnLeafTerm> attributes) {
        super(parent);
        this.element = checkNotNull(element);
        this.children = new ArrayList<ReturnTerm>();
        this.attributes = ImmutableMap.copyOf(checkNotNull(attributes));
    }

    /**
     * <code>true</code> if the created node of the return terms in this return
     * construct term are set.
     *
     * Throws an illegal state exception if the created node or some of the
     * return terms in this return construct term are set and some others are
     * not.
     *
     * @return <code>true</code> if the created node of the return terms in this
     *         return construct term are set.
     * @throws IllegalStateException
     */
    boolean hasCreatedNodesSetted() throws IllegalStateException {
        boolean setted = hasCreatedNode();
        for (final ReturnTerm term : children) {
            if (setted != term.hasCreatedNode()) {
                throw new IllegalStateException(
                        "Some return construct term children created node are set and some others are not.");
            }
        }
        return setted;
    }

    /**
     * The created node for the specified element.
     *
     * @param element
     *            the element of this return template whose created node is to
     *            be returned
     * @return the created node for the specified element.
     */
    Variable getCreatedNode(final Element element) {
        if (this.element.equals(element)) {
            return getCreatedNode();
        }
        for (final ReturnTerm child : children) {
            if (child instanceof ReturnConstructTerm) {
                final Variable createdNode = ((ReturnConstructTerm) child).getCreatedNode(element);
                if (createdNode != null) {
                    return createdNode;
                }
            }
        }
        return null;
    }

    /**
     * The created nodes variable in this return construct term.
     *
     * @param addCreatedNodeFlagForNonConstructChild
     * @return the created nodes variable in this return construct term.
     */
    List<Variable> getCreatedNodes(boolean isRootBlock, boolean addCreatedNodeFlagForNonConstructChild) {
        final ImmutableList.Builder<Variable> builder = ImmutableList.builder();
        if ((isRootBlock || !element.isEmpty())
                && (addCreatedNodeFlagForNonConstructChild || !hasNonConstructChild())) {
            builder.add(getCreatedNode());
        }
        for (final ReturnTerm child : children) {
            if (child instanceof ReturnConstructTerm) {
                builder.addAll(((ReturnConstructTerm) child).getCreatedNodes(isRootBlock,
                        addCreatedNodeFlagForNonConstructChild));
            } else {
                builder.add(child.getCreatedNode());
            }
        }
        return builder.build();
    }

    public boolean hasNonConstructChild() {
        for (final ReturnTerm child : children) {
            if (!(child instanceof ReturnConstructTerm)) {
                return true;
            }
        }
        return false;
    }

    /**
     * The element of this return template construct term.
     *
     * @return The element of this return template construct term.
     */
    public Element getElement() {
        return element;
    }

    /**
     * The attributes of this return template construct term.
     *
     * @return The attributes of this return template construct term.
     */
    public Map<String, ReturnLeafTerm> getAttributes() {
        return attributes;
    }

    /**
     * <code>true</code> if this return template construct term has one or more
     * children.
     *
     * @return <code>true</code> if this return template construct term has one
     *         or more children.
     */
    public boolean hasChildren() {
        return !children.isEmpty();
    }

    /**
     * The children of this return template construct term.
     *
     * @return The children of this return template construct term.
     */
    public List<ReturnTerm> getChildren() {
        return ImmutableList.copyOf(children);
    }

    /**
     * Adds the specified return template term to this return template construct
     * term children.
     *
     * @param node
     *            the return template term to be appended to this return
     *            template construct term children.
     */
    public void addChild(final ReturnTerm node) {
        children.add(node);
    }

    @Override
    public void accept(final ReturnTemplateVisitor visitor) {
        visitor.visitPre(this);
        getChildren().stream().forEach(c -> c.accept(visitor));
        visitor.visitPost(this);
    }

    @Override
    public Set<Variable> getReferredVariables() {
        final ImmutableSet.Builder<Variable> builder = ImmutableSet.builder();
        children.stream().map(ReturnTerm::getReferredVariables).forEach(builder::addAll);
        return builder.build();
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("<").append(element.toString()).append(" ");
        for (final Entry<String, ReturnLeafTerm> attr : attributes.entrySet()) {
            builder.append(attr.getKey()).append("=").append(attr.getValue().toString()).append(" ");
        }
        builder.append(">");
        String prefix = "";
        for (final ReturnTerm child : children) {
            builder.append(prefix).append(child.toString());
            prefix = ", ";
        }
        builder.append("</").append(element.toString()).append(">");
        return builder.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(element, children, attributes, super.hashCode());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ReturnConstructTerm)) {
            return false;
        }
        final ReturnConstructTerm p = (ReturnConstructTerm) o;
        return super.equals(p) && element.equals(p.element) && children.equals(p.children)
                && attributes.equals(p.attributes);
    }
}