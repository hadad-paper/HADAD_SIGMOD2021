package hadad.base.rewriter;

import java.util.List;
import java.util.Objects;

import hadad.commons.conjunctivequery.ConjunctiveQuery;

public class TimedReformulations {
	private final long queryAssertionTimeInNano;
	private final long chaseExecTimeInNano;
	private final long restrictExecTimeInNano;
	private final long backchaseExecTimeInNano;
	private final List<ConjunctiveQuery> rewritings;

	public TimedReformulations(long queryAssertionTimeInNano,
			long chaseExecTimeInNano, long restrictExecTimeInNano,
			long backchaseExecTimeInNano,
			final List<ConjunctiveQuery> rewritings) {
		this.queryAssertionTimeInNano = queryAssertionTimeInNano;
		this.chaseExecTimeInNano = chaseExecTimeInNano;
		this.restrictExecTimeInNano = restrictExecTimeInNano;
		this.backchaseExecTimeInNano = backchaseExecTimeInNano;
		this.rewritings = rewritings;
	}

	public long getQueryAssertionTime() {
		return queryAssertionTimeInNano;
	}

	public long getChaseExecTime() {
		return chaseExecTimeInNano;
	}

	/**
	 * Returns -1 when the restrict was not executed (the chase determined there
	 * was no possible rewriting).
	 */
	public long getRestrictExecTime() {
		return restrictExecTimeInNano;
	}

	/**
	 * Returns -1 when the restrict was not executed (the chase determined there
	 * was no possible rewriting).
	 */
	public long getBackchaseExecTime() {
		return backchaseExecTimeInNano;
	}

	public List<ConjunctiveQuery> getRewritings() {
		return rewritings;
	}

	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Query assertion generation time (ms): ").append(
				nano2ms(queryAssertionTimeInNano)).append("\n");
		builder.append("Query chase execution time (ms): ").append(
				nano2ms(chaseExecTimeInNano)).append("\n");
		builder.append("Query restrict execution time (ms): ").append(
				nano2ms(restrictExecTimeInNano)).append("\n");
		builder.append("Query backchase execution time (ms): ").append(
				nano2ms(backchaseExecTimeInNano)).append("\n");
		builder.append("Rewritings: ").append(rewritings.toString())
				.append("\n");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(queryAssertionTimeInNano, chaseExecTimeInNano,
				restrictExecTimeInNano, backchaseExecTimeInNano, rewritings);
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof TimedReformulations)) {
			return false;
		}
		final TimedReformulations p = (TimedReformulations) o;
		return queryAssertionTimeInNano == p.queryAssertionTimeInNano
				&& chaseExecTimeInNano == p.chaseExecTimeInNano
				&& restrictExecTimeInNano == p.restrictExecTimeInNano
				&& backchaseExecTimeInNano == p.backchaseExecTimeInNano
				&& rewritings.equals(p.rewritings);
	}

	private static long nano2ms(long nano) {
		return nano / 1000 / 1000;
	}
}
