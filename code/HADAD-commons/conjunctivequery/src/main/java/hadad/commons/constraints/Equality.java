package hadad.commons.constraints;

import java.util.Objects;

import hadad.commons.conjunctivequery.Term;

/**
 * An equality atom.
 */
public class Equality implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** The terms */
	private Term term1, term2;

	/**
	 * Default constructor.
	 *
	 * @param term1
	 *            the first term of the equality
	 * @param term2
	 * 			  the second term of the equality
	 */
	public Equality(Term term1, Term term2) {
		this.term1 = term1;
		this.term2 = term2;
	}

	/**
	 * Gets the first term of the equality
	 *
	 * @return the first term of the equality
	 */
	public Term getTerm1() {
		return term1;
	}

	/**
	 * Gets the second term of the equality
	 *
	 * @return the second term of the equality
	 */
	public Term getTerm2() {
		return term2;
	}

	@Override
	public String toString() {
		final StringBuilder result = new StringBuilder();
		result.append(term1);
		result.append("=");
		result.append(term2);
		return result.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(term1, term2);
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Equality)) {
			return false;
		}
		final Equality eq = (Equality) o;
		return term1.equals(eq.term1) && term2.equals(eq.term2);
	}
}
