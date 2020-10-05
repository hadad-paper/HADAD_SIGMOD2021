package hadad.base.compiler;

import java.util.Collection;

import hadad.commons.conjunctivequery.ConjunctiveQuery;

/**
 * Provides a way to select one (conjunctive query) rewriting from a collection
 * of (conjunctive query) rewritings (given by a rewrite algorithm)
 */
public interface RewritingSelector {
	/**
	 * Selects one rewriting from the specified collection.
	 *
	 * Throws an IllegalArgumentException if the given collection of rewritings
	 * is empty.
	 *
	 * @param rewritings
	 *            collection of rewritings to select the rewriting from.
	 * @return the selected rewriting from the collection.
	 */
	ConjunctiveQuery select(final Collection<ConjunctiveQuery> rewritings)
			throws IllegalArgumentException;
}
