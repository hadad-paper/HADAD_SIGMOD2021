package hadad.commons.conjunctivequery;

import static java.util.Objects.requireNonNull;

/**
 * Constants are used to represent constant objects in the CQs.
 */
public class StringConstant extends Constant {
	private final String value;

	/**
	 * Default constructor.
	 *
	 * @param value
	 *            the value of the constant as a String.
	 */
	public StringConstant(final String value) {
		this.value = requireNonNull(value);
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "\"" + value + "\"";
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
				&& value.equals(((StringConstant) o).value);
	}
}
