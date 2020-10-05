package hadad.base.compiler;

import hadad.commons.conjunctivequery.Term;

/**
 * Part of query block tree data structure.
 */
public interface Element {
    /**
     * The conjunctive query term for this element.
     *
     * @return the conjunctive query term for this element.
     */
    public Term toTerm();

    public boolean isEmpty();
}
