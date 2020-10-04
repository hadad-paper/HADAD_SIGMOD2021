package hadad.commons.conjunctivequery;

import static java.util.Objects.requireNonNull;

/**
 * Variables are used to represent variable objects in the CQs
 */
public final class Variable implements Term, java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String name;

	/**
	 * Default constructor.
	 *
	 * @param name
	 *            the name of the variable.
	 */
	public Variable(final String name) {
		this.name = requireNonNull(name);
	}

	@Override
	/*
	 * (non-Javadoc)
	 *
	 * @see hadad.commons.conjunctivequery.Term#isConstant()
	 */
	public boolean isConstant() {
		return false;
	}

	@Override
	/*
	 * (non-Javadoc)
	 *
	 * @see hadad.commons.conjunctivequery.Term#isVariable()
	 */
	public boolean isVariable() {
		return true;
	}

	public String getName() {
		return name;
	}

	@Override
	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return name;
	}

	@Override
	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		return (o != null && o instanceof Variable)
				&& name.equals(((Variable) o).name);
	}
}
