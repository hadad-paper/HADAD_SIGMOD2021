package hadad.commons.miscellaneous;

import java.util.Objects;

/**
 * Simple tuple implementation.
 *
 * @param <S>
 * @param <T>
 */
public class Tuple<S, T> {
	private final S s;
	private final T t;

	/**
	 * @param s
	 *            first element of the tuple
	 * @param t
	 *            second element of the tuple
	 */
	public Tuple(final S s, final T t) {
		this.s = s;
		this.t = t;
	}

	/**
	 * Returns the first element of the tuple.
	 *
	 * @return the first element of the tuple
	 */
	public S first() {
		return s;
	}

	/**
	 * Returns the second element of the tuple
	 *
	 * @return the second element of the tuple
	 */
	public T second() {
		return t;
	}

	@Override
	public String toString() {
		return "<" + s.toString() + "," + t.toString() + ">";
	}

	@Override
	public int hashCode() {
		return Objects.hash(s, t);
	}

	@Override
	public boolean equals(Object o) {
		return (o instanceof Tuple<?, ?>) && s.equals(((Tuple<?, ?>) o).s)
				&& t.equals(((Tuple<?, ?>) o).t);
	}
}
