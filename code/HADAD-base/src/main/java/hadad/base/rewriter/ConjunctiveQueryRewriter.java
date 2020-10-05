package hadad.base.rewriter;

import java.util.List;

import hadad.commons.conjunctivequery.ConjunctiveQuery;

public interface ConjunctiveQueryRewriter {
	/**
	 * Computes the reformulations of the specified conjunctive query.
	 *
	 * @param query
	 *            The query to be reformulated
	 *
	 * @return The chase execution time, query assertion generation, restrict
	 *         execution time, backchase execution time and reformulations.
	 * @throws Exception
	 */
	public TimedReformulations getTimedReformulations(
			final ConjunctiveQuery query) throws Exception;

	/**
	 * Computes the reformulations of the specified conjunctive query.
	 *
	 * @param query
	 *            The query to be reformulated.
	 *
	 * @return The reformulations of the specified conjunctive query with the
	 *         specified chase context target schema and backward constraints.
	 * @throws Exception
	 */
	public List<ConjunctiveQuery> getReformulations(final ConjunctiveQuery query)
			throws Exception;
}
