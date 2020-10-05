package hadad.base.rewriter.stresstest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.base.rewriter.TimedReformulations;

public final class Execution {
	private final List<TimedReformulations> timedReformulations;

	public Execution(final List<TimedReformulations> timedReformulations) {
		this.timedReformulations = timedReformulations;
	}

	public List<Long> getQueryAssertionTimes() {
		return timedReformulations.stream()
				.map(TimedReformulations::getQueryAssertionTime)
				.collect(Collectors.toList());
	}

	public double getQueryAssertionTimesAverage() {
		return timedReformulations.stream()
				.mapToLong(TimedReformulations::getQueryAssertionTime)
				.average().getAsDouble();
	}

	public List<Long> getChaseExecTimes() {
		return timedReformulations.stream()
				.map(TimedReformulations::getChaseExecTime)
				.collect(Collectors.toList());
	}

	public double getChaseExecTimesAverage() {
		return timedReformulations.stream()
				.mapToLong(TimedReformulations::getChaseExecTime).average()
				.getAsDouble();
	}

	public List<Long> getRestrictExecTimes() {
		return timedReformulations.stream()
				.map(TimedReformulations::getRestrictExecTime)
				.collect(Collectors.toList());
	}

	public double getRestrictExecTimesAverage() {
		return timedReformulations.stream()
				.mapToLong(TimedReformulations::getRestrictExecTime).average()
				.getAsDouble();
	}

	public List<Long> getBackchaseExecTimes() {
		return timedReformulations.stream()
				.map(TimedReformulations::getBackchaseExecTime)
				.collect(Collectors.toList());
	}

	public double getBackchaseExecTimesAverage() {
		return timedReformulations.stream()
				.mapToLong(TimedReformulations::getBackchaseExecTime).average()
				.getAsDouble();
	}

	public double getExecTimesAverage() {
		return nano2ms(getQueryAssertionTimesAverage() + getChaseExecTimesAverage() + getRestrictExecTimesAverage()
				+ getBackchaseExecTimesAverage());
	}

	public List<ConjunctiveQuery> getRewritings() {
		if (timedReformulations.isEmpty()) {
			return new ArrayList<ConjunctiveQuery>();
		} else {
			return timedReformulations.get(0).getRewritings();
		}
	}


	@Override
	public String toString() {
		final StringBuilder builder = new StringBuilder();
		builder.append("Query rewriting average time (ms): ").append(getExecTimesAverage()).append("\n");
		builder.append("Query assertion generation average time (ms): ")
				.append(nano2ms(getQueryAssertionTimesAverage()))
				.append(" (")
				.append(getQueryAssertionTimes().stream()
						.map(Execution::nano2ms)
						.collect(Collectors.toList()).toString())
				.append(")").append("\n");
		builder.append("Query chase execution average time (ms): ")
				.append(nano2ms(getChaseExecTimesAverage()))
				.append(" (")
				.append(getChaseExecTimes().stream()
						.map(Execution::nano2ms)
						.collect(Collectors.toList()).toString())
				.append(")").append("\n");
		builder.append("Query restrict execution average time (ms): ")
				.append(nano2ms(getRestrictExecTimesAverage()))
				.append(" (")
				.append(getRestrictExecTimes().stream()
						.map(Execution::nano2ms)
						.collect(Collectors.toList()).toString())
				.append(")").append("\n");
		builder.append("Query backchase execution average time (ms): ")
				.append(nano2ms(getBackchaseExecTimesAverage()))
				.append(" (")
				.append(getBackchaseExecTimes().stream()
						.map(Execution::nano2ms)
						.collect(Collectors.toList()).toString())
				.append(")").append("\n");
		builder.append("Rewritings: ").append(getRewritings().toString()).append("\n");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return timedReformulations.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		return (o instanceof Execution)
				&& timedReformulations
						.equals(((Execution) o).timedReformulations);
	}

	private static double nano2ms(double nano) {
		return nano / 1000 / 1000;
	}

	private static long nano2ms(long nano) {
		return nano / 1000 / 1000;
	}
}
