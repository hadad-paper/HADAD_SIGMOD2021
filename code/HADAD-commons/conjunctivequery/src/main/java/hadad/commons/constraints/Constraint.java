package hadad.commons.constraints;

import java.util.List;

import hadad.commons.conjunctivequery.Atom;

/**
 * Abstract parent class for constraints.
 */
public abstract class Constraint implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** The premise. */
	protected List<Atom> premise;

	/**
	 * Default constructor.
	 *
	 * @param premise
	 *            the premise of the constraint
	 */
	protected Constraint(List<Atom> premise){
		this.premise = premise;
	}

	/**
	 * Gets the premise of the constraint
	 *
	 * @return the premise of the constraint
	 */
	public List<Atom> getPremise(){
		return premise;
	}

	@Override
	public String toString() {
		final StringBuilder result = new StringBuilder();
		if (!premise.isEmpty()) {
			for (final Atom atom : premise) {
				result.append(atom.toString());
				result.append(",");
			}
			result.deleteCharAt(result.length() - 1);
		}
		result.append("->");
		return result.toString();
	}

	/**
	 * The notion of equivalence provided by this method is expressed in terms
	 * of homomorphism and not isomorphism.
	 *
	 * Note that premise and conclusion size check is not enough.
	 *
	 * @return true if this query is equivalent with q and false otherwise.
	 */
	abstract public boolean isEquivalent(final Constraint other);
}
