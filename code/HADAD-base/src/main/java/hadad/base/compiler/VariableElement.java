package hadad.base.compiler;

import static com.google.common.base.Preconditions.checkNotNull;

import hadad.commons.conjunctivequery.Variable;

/**
 * Part of query block tree data structure.
 * 
 */
public final class VariableElement implements Element {
    /* The element tag name. */
    private final Variable tag;

    /**
     * Constructs a new element with the specified tag.
     *
     * @param str
     *            the element tag name.
     */
    public VariableElement(final Variable tag) {
        this.tag = checkNotNull(tag);
    }

    /**
     * The conjunctive query term for this element.
     *
     * @return the conjunctive query term for this element.
     */
    @Override
    public Variable toTerm() {
        return tag;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public String toString() {
        return tag.toString();
    }

    @Override
    public int hashCode() {
        return tag.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof VariableElement) && tag.equals(((VariableElement) o).tag);
    }
}
