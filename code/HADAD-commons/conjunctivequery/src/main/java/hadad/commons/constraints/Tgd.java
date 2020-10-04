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
 * A Tuple Generating Dependency
 */
public class Tgd extends Constraint implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** The conclusion. */
	private List<Atom> conclusion;

	public static Tgd fromString(final String str)
			throws UnsupportedEncodingException, ParseException {
		InputStream is = new ByteArrayInputStream(str.getBytes("UTF-8"));
		ConstraintParser parser = new ConstraintParser(is);
		return ((Tgd) parser.parse().get(0));
	}

	/**
	 * Default constructor.
	 *
	 * @param premise
	 *            the premise of the TGD
	 * @param conclusion
	 * 			  the conclusion of the TGD
	 */
	public Tgd(List<Atom> premise, List<Atom> conclusion){
		super(premise);
		this.conclusion = conclusion;
	}

	/**
	 * Gets the conclusion of the TGD
	 *
	 * @return the conclusion of the TGD
	 */
	public List<Atom> getConclusion(){
		return conclusion;
	}
	
	public boolean isFalse() {
		return conclusion == null;
	}

	@Override
	public String toString(){
		final StringBuilder result = new StringBuilder();
		result.append(super.toString());

		for (final Atom atom : conclusion) {
			result.append(atom.toString());
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
		return (o instanceof Tgd) && premise.equals(((Tgd) o).premise)
				&& conclusion.equals(((Tgd) o).conclusion);
	}

	/**
	 * Returns true if this query is equivalent with the query 'other' given as
	 * parameter and false otherwise. Equivalence is checked through both ways
	 * containment of the queries.
	 *
	 * The notion of equivalence provided by this method is expressed in terms
	 * of homomorphism and not isomorphism.
	 *
	 * Note that premise and conclusion size check is not enough.
	 *
	 * @param other
	 *            - the ConjunctiveQuery under which we are checking for
	 *            equivalence.
	 * @return true if this query is equivalent with q and false otherwise.
	 */
	@Override
	public boolean isEquivalent(final Constraint other) {
		if (!(other instanceof Tgd)) {
			return false;
		}
		final Tgd tgd = (Tgd) other;
		return this.isContained(tgd) && tgd.isContained(this);
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
	private boolean isContained(final Tgd other) {
		final List<Atom> atomsPremise1 = new ArrayList<Atom>(premise);
		final List<Atom> atomsPremise2 = new ArrayList<Atom>(other.premise);
		final List<Homomorphism> premiseHomomorphisms = Homomorphism.findHomomorphisms(
				atomsPremise1, atomsPremise2);
		if (premiseHomomorphisms.isEmpty()) {
			return false;
		}

		final List<Atom> atomsConclusion1 = new ArrayList<Atom>(conclusion);
		final List<Atom> atomsConclusion2 = new ArrayList<Atom>(other.conclusion);
		final List<Homomorphism> conclusionHomomorphisms = Homomorphism.findHomomorphisms(
				atomsConclusion1, atomsConclusion2);
		if (conclusionHomomorphisms.isEmpty()) {
			return false;
		}

		for (final Homomorphism premiseHomomorphism: premiseHomomorphisms) {
			for (final Homomorphism conclusionHomomorphism: conclusionHomomorphisms) {
				if (premiseHomomorphism.isCompatible(conclusionHomomorphism)) {
					return true;
				}
			}
		}
		return false;
	}
}
