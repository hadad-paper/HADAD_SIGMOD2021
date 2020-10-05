package hadad.base.compiler;

import static com.google.common.base.Preconditions.checkNotNull;

import hadad.commons.conjunctivequery.StringConstant;

/**
 * Part of query block tree data structure.
 *
 *   
 *   
 */
/* Should we give one id to each created element? */
public final class StringElement implements Element {
    /* The element tag name. */
    private final String tag;

    /**
     * Constructs a new element with the specified tag.
     *
     * @param str
     *            the element tag name.
     */
    public StringElement(final String tag) {
        this.tag = checkNotNull(tag);
    }

    /**
     * The conjunctive query term for this element.
     *
     * @return the conjunctive query term for this element.
     */
    @Override
    public StringConstant toTerm() {
        return new StringConstant(tag);
    }

    @Override
    public boolean isEmpty() {
        return tag.isEmpty();
    }

    @Override
    public String toString() {
        return tag;
    }

    @Override
    public int hashCode() {
        return tag.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof StringElement) && tag.equals(((StringElement) o).tag);
    }
}
