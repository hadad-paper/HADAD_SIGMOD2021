package hadad.base.utils;

import java.util.Objects;

/**
 * Tuple implementations
 *
 * @param <S>
 * @param <T>
 */
public class Tuple<S, T, U, E> {
    private final S s;
    private final T t;
    private final U u;
    private final E e;

    /**
     * @param s
     *            first element of the tuple
     * @param t
     *            second element of the tuple
     * @param u
     *            third element of the tuple
     */
    public Tuple(final S s, final T t, final U u, final E e) {
        this.s = s;
        this.t = t;
        this.u = u;
        this.e = e;
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

    /**
     * Returns the third element of the tuple
     *
     * @return the third element of the tuple
     */
    public U third() {
        return u;
    }

    /**
     * Returns the third element of the tuple
     *
     * @return the third element of the tuple
     */
    public E fourth() {
        return e;
    }

    @Override
    public String toString() {
        return "<" + s.toString() + "," + t.toString() + "," + u.toString() + "," + e.toString() + ">";
    }

    @Override
    public int hashCode() {
        return Objects.hash(s, t, u);
    }

    @Override
    public boolean equals(Object o) {
        return (o instanceof Tuple<?, ?, ?, ?>) && s.equals(((Tuple<?, ?, ?, ?>) o).s)
                && t.equals(((Tuple<?, ?, ?, ?>) o).t);
    }
}
