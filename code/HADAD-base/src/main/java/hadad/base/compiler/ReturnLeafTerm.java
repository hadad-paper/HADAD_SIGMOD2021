package hadad.base.compiler;

import hadad.commons.conjunctivequery.Term;

/**
 * Part of nested block tree data structure.
 *
 * Interface for return template leaf terms.
 * 
 */
public interface ReturnLeafTerm {
    /**
     * The conjunctive query term encoding for the return template leaf term.
     * 
     * @return the conjunctive query term encoding for the return template leaf
     *         term.
     */
    Term toTerm();
}