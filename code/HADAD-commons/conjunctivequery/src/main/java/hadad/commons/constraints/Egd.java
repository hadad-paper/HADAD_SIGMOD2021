package hadad.commons.constraints;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.Homomorphism;
import hadad.commons.constraints.parser.ConstraintParser;
import hadad.commons.constraints.parser.ParseException;

/**
 * An Equality Generating Dependency
 */
public class Egd extends Constraint implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** The conclusion. */
	private List<Equality> conclusion;

	public static Egd fromString(final String str)
			throws UnsupportedEncodingException, ParseException {
		InputStream is = new ByteArrayInputStream(str.getBytes("UTF-8"));
		ConstraintParser parser = new ConstraintParser(is);
		return ((Egd) parser.parse().get(0));
	}

	/**
	 * Default constructor.
	 *
	 * @param premise
	 *            the premise of the EGD
	 * @param conclusion
	 * 			  the conclusion of the EGD
	 */
	public Egd(List<Atom> premise, List<Equality> conclusion){
		super(premise);
		this.conclusion = conclusion;
	}

	/**
	 * Gets the conclusion of the EGD
	 *
	 * @return the conclusion of the EGD
	 */
	public List<Equality> getConclusion(){
		return conclusion;
	}

	@Override
	public String toString(){
		final StringBuilder result = new StringBuilder();
		result.append(super.toString());

		for (final Equality eq : conclusion) {
			result.append(eq.toString());
			result.append(",");
		}
		result.deleteCharAt(result.length() - 1);

		return result.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(premise, conclusion);
	}

	@Override
	public boolean equals(Object o) {
		return (o instanceof Egd) && premise.equals(((Egd) o).premise)
				&& conclusion.equals(((Egd) o).conclusion);
	}

	@Override
	public boolean isEquivalent(final Constraint other) {
		if (!(other instanceof Egd)) {
			return false;
		}
		final Egd egd = (Egd) other;
		return this.isContained(egd) && egd.isContained(this);
	}

	/**
	 * Returns true if this query is contained in the query 'other' given as
	 * parameter and false otherwise. Essentially it searches for homomorphisms
	 * from the query 'other' to the current one.
	 *
	 * @param other
	 *            - the ConjunctiveQuery under which we are checking containment
	 * @return true if this query is contained in 'other' and false otherwise.
	 */
	private boolean isContained(final Egd other) {
		// Find all homomorphisms
		final List<Atom> atomsPremise1 = new ArrayList<Atom>(premise);
		final List<Atom> atomsPremise2 = new ArrayList<Atom>(other.premise);
		final List<Homomorphism> premiseHomomorphisms = Homomorphism
				.findHomomorphisms(atomsPremise1, atomsPremise2);
		if (premiseHomomorphisms.isEmpty()) {
			return false;
		}

		final List<Atom> atomsConclusion1 = new ArrayList<Atom>();
		for (final Equality equality : conclusion) {
			atomsConclusion1.add(new Atom("Equality", equality.getTerm1(),
					equality.getTerm2()));
		}
		final List<Atom> atomsConclusion2 = new ArrayList<Atom>();
		for (final Equality equality : other.conclusion) {
			atomsConclusion2.add(new Atom("Equality", equality.getTerm1(),
					equality.getTerm2()));
		}
		final List<Homomorphism> conclusionHomomorphisms = Homomorphism
				.findHomomorphisms(
						atomsConclusion1, atomsConclusion2);
		if (conclusionHomomorphisms.isEmpty()) {
			return false;
		}

		for (final Homomorphism premiseHomomorphism : premiseHomomorphisms) {
			for (final Homomorphism conclusionHomomorphism : conclusionHomomorphisms) {
				if (premiseHomomorphism.isCompatible(conclusionHomomorphism)) {
					return true;
				}
			}
		}
		return false;
	}
}
