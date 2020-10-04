package hadad.commons.conjunctivequery;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Atom implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_NAME_PREFIX = "a";
	private static int counter = 0;

	private final String id;
	private final String predicate;
	private final List<? extends Term> terms;

	public Atom(final String predicate) {
		this(predicate, new ArrayList<>());
		
	}

	
	public Atom(final String predicate, final Term... terms) {
		this(predicate, Arrays.asList(terms));
	}

	public Atom(final String predicate, final List<? extends Term> terms) {
		this(DEFAULT_NAME_PREFIX + Integer.toString(counter), predicate, terms);
	}

	public Atom(final String id, final String predicate, final Term... terms) {
		this(id, predicate, Arrays.asList(terms));
	}

	public Atom(final String id, final String predicate,
			final List<? extends Term> terms) {
		this.id = id;
		this.predicate = predicate;
		this.terms = terms;
		counter++;
		

	}

	public final String getId() {
		return id;
	}

	public final String getPredicate() {
		return predicate;
	}

	/**
	 * Returns true if this and the given predicate have common variables (a
	 * variable with the same name appears in both), false otherwise.
	 *
	 * @param p
	 * @return true if the given triple patterns have common variables
	 */
	public boolean haveSharedVariables(final Atom p) {
		return haveSharedVariables(this, p);
	}

	/**
	 * Returns true if the given predicates have common variables (a variable
	 * with the same name appears in both), false otherwise.
	 *
	 * @param p1
	 * @param p2
	 * @return true if the given predicates have common variables
	 */
	private static boolean haveSharedVariables(final Atom p1,
			final Atom p2) {
		final List<Variable> variables = p1.getVariables();
		final List<Variable> variables2 = p2.getVariables();
		for (final Variable variable : variables) {
			if (variables2.contains(variable)) {
				return true;
			}
		}
		return false;
	}

	public List<Variable> getVariables() {
		final List<Variable> result = new ArrayList<Variable>();
		for (final Term term : terms) {
			if (term instanceof Variable) {
				result.add((Variable) term);
			}
		}
		return result;
	}

	public List<? extends Term> getTerms() {
		return terms;
	}

	public Term getTerm(final int index) {
		return terms.get(index);
	}

	public int indexOf(final Term term) {
		for (int i = 0; i < terms.size(); i++) {
			if (terms.get(i).equals(term)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return Objects.hash(getPredicate(), terms);
	}

	@Override
	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object o) {
		return o != null && (o instanceof Atom)
				&& getPredicate().equals(((Atom) o).getPredicate())
				&& terms.equals(((Atom) o).terms);
	}

	@Override
	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		final StringBuilder result = new StringBuilder();
		result.append(getPredicate());
		result.append("(");
		final Iterator<? extends Term> it = getTerms().iterator();
		while (it.hasNext()) {
			result.append(it.next().toString());
			if (it.hasNext()) {
				result.append(",");
			}
		}
		result.append(')');
		return result.toString();
	}
}
