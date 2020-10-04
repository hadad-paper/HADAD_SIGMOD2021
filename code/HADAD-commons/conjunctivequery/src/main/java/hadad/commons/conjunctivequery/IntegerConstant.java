package hadad.commons.conjunctivequery;

import static java.util.Objects.requireNonNull;

/**
 * Constants are used to represent constant objects in the CQs.
 */
public class IntegerConstant extends Constant {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Integer value;

	/**
	 * Default constructor.
	 *
	 * @param value
	 *            the value of the constant as a String.
	 */
	public IntegerConstant(final Integer value) {
		this.value = requireNonNull(value);
	}

	/**
	 * Default constructor.
	 *
	 * @param value
	 *            the value of the constant as a String.
	 */
	public IntegerConstant(final String value) {
		this(Integer.valueOf(value));
	}

	@Override
	/*
	 * (non-Javadoc)
	 * 
	 * @see hadad.commons.conjunctivequery.Constant#getValue()
	 */
	public Integer getValue() {
		return value;
	}

	@Override
	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return Integer.toString(value);
	}

	@Override
	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return value.hashCode();
	}

	@Override
	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		return (o != null && o.getClass() == getClass())
				&& value.equals(((IntegerConstant) o).value);
	}
}
