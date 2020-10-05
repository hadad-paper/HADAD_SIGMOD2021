package hadad.base.compiler;

import java.util.Objects;
import java.util.Set;

import hadad.commons.conjunctivequery.Variable;

/**
 * Part of nested block tree data structure.
 *
 * Represents (nested block tree) block return template (base) term.
 */
public abstract class ReturnTerm {
    /* The parent return template (construct) term. */
    private final ReturnConstructTerm parent;
    /*
     * The created node tag (in this block parent return template) containing
     * this block.
     *
     * Used during the compilation.
     */
    private Variable createdNode;

    /**
     * Constructs a new return template term with the specified parent return
     * template (construct) term.
     *
     * @param parent
     *            the parent return template (construct) term.
     */
    public ReturnTerm(final ReturnConstructTerm parent) {
        this.parent = parent;
    }

    /**
     * Returns true when this return term has a parent, false otherwise.
     *
     * @return true when this return term has a parent, false otherwise.
     */
    public boolean hasParent() {
        return parent != null;
    }

    /**
     * This return term parent.
     *
     * @return this return term parent.
     */
    public ReturnConstructTerm getParent() {
        return parent;
    }

    /**
     * Sets the created node variable (in this block parent return template)
     * containing this block if not already set.
     *
     * Used during the compilation.
     *
     * Throws a illegal state exception if the created node variable is already
     * set.
     *
     * @param createdNode
     *            the created node variable (in this block parent return
     *            template) containing this block.
     * @throws IllegalStateException
     */
    public void setCreatedNode(final Variable createdNode) throws IllegalStateException {
        if (this.createdNode != null) {
            throw new IllegalStateException("The return term created node variable is already set.");
        }
        this.createdNode = createdNode;
    }

    /**
     * <code>true</code> true if the created node variable (in this block parent
     * return template) containing this block is setted.
     *
     * @return <code>true</code> true if the created node variable (in this
     *         block parent return template) containing this block is setted.
     */
    boolean hasCreatedNode() {
        return createdNode != null;
    }

    /**
     * The created node variable (in this block parent return template)
     * containing this block.
     *
     * @return the created node variable (in this block parent return template)
     *         containing this block.
     */
    public Variable getCreatedNode() {
        return createdNode;
    }

    /* Parent element will be constructed by the parent. */
    @Override
    public String toString() {
        return "";
    }

    /* Parent element up to id equality to avoid infinite loop. */
    @Override
    public int hashCode() {
        if (parent == null) {
            return Objects.hash(super.hashCode());
        } else {
            return Objects.hash(parent.getElement(), super.hashCode());
        }
    }

    /* Parent element up to id equality to avoid infinite loop. */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ReturnTerm)) {
            return false;
        }
        final ReturnTerm p = (ReturnTerm) o;
        return super.equals(p) && parent.getElement().equals(p.parent.getElement());
    }

    /**
     * Visitor pattern.
     *
     * Provides a way to navigate the return template and its elements.
     *
     * @param visitor
     *            the return template visitor implementation.
     */
    public abstract void accept(final ReturnTemplateVisitor visitor);

    /**
     * The variables referred in this return expression.
     *
     * @return variables referred in this return expression.
     */
    public abstract Set<Variable> getReferredVariables();
}
