package hadad.commons.conjunctivequery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A class representing a homomorphism among terms.
 *
 */
public class Homomorphism implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<Term,Term> mapping;
	Homomorphism(){
		mapping = new HashMap<Term,Term>();
	}

	Homomorphism(Homomorphism h){
		mapping = new HashMap<Term,Term>(h.mapping);

	}

	void add(Term from, Term to){
		mapping.put(from, to);
	}

	void remove(Term t){
		mapping.remove(t);
	}

	Term getMapping(Term from){
		return mapping.get(from);
	}

	Collection<Term> getKeyMappings(){
		return mapping.keySet();
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(mapping);
		return sb.toString();
	}

	/**
	 * Check if the current homomorphism is compatible with the one given as a parameter.
	 *
	 * If the two homomorphisms do not contain the same mapping to different terms then
	 * they are compatible.
	 *
	 * @param other - the other Homomorphism
	 * @return true if the homomorphism is compatible with other and false otherwise.
	 */
	public boolean isCompatible(Homomorphism other){
		if(other == null) {
			throw new IllegalArgumentException("Cannot check compatibility with null");
		}
		for(Term key: other.mapping.keySet()){
			if(this.mapping.containsKey(key)
					&& !this.mapping.get(key).equals(other.mapping.get(key))){
				return false;
			}
		}
		return true;
	}

	/**
	 * Merges two compatible homomorphisms into a single one.
	 *
	 * The result is undefined if the user passes non-compatible homomorphisms.
	 *
	 * @param h1 - the first Homomorphism
	 * @param h2 - the second Homomorphism
	 * @return the homomorphism which results from the merge of h1 and h2
	 */
	public static Homomorphism merge(Homomorphism h1, Homomorphism h2){
		if(h1 == null || h2 == null) {
			throw new IllegalArgumentException("Input Homomorphisms cannot be null.");
		}

		Homomorphism ret = new Homomorphism();
		ret.mapping.putAll(h1.mapping);
		ret.mapping.putAll(h2.mapping);
		return ret;

	}

	/**
	 * Find all possible homomorphisms from the list of atoms q1 to the list of
	 * atoms q2.
	 *
	 * The list may contain duplicates. If no possible homomorphism is found an
	 * empty list is returned.
	 *
	 * @param q1
	 *            - a list of atoms
	 * @param q2
	 *            - a list of atoms
	 *
	 * @return a list containing all the possible homomorphisms from the atoms
	 *         q1 to the atoms q2, or an empty list if such an homomorphism does
	 *         not exist.
	 */
	public static List<Homomorphism> findHomomorphisms(final List<Atom> q1,
			final List<Atom> q2) {
		return findHomomorphisms(q1, q2, false);
	}	
	
	/**
	 * Tests if at least one homomorphism exists from the list of atoms q1 to the list of
	 * atoms q2.
	 *
	 * @param q1
	 *            - a list of atoms
	 * @param q2
	 *            - a list of atoms
	 *
	 * @return true if at least one homomorphism from the atoms
	 *         q1 to the atoms q2 exists, false otherwise.
	 */
	public static boolean homomorphismExists(final List<Atom> q1,
			final List<Atom> q2) {
		return !findHomomorphisms(q1, q2, true).isEmpty();
	}	

	
	/**
	 * Find all possible homomorphisms from the list of atoms q1 to the list of
	 * atoms q2.
	 *
	 * The list may contain duplicates. If no possible homomorphism is found an
	 * empty list is returned.
	 *
	 * @param q1
	 *            - a list of atoms
	 * @param q2
	 *            - a list of atoms
	 * @param stopEarly if true, it stops after the first homomorphism found
	 *
	 * @return a list containing all the possible homomorphisms from the atoms
	 *         q1 to the atoms q2, or an empty list if such an homomorphism does
	 *         not exist.
	 */
	public static List<Homomorphism> findHomomorphisms(final List<Atom> q1,
			final List<Atom> q2, final boolean stopEarly) {
		List<List<Homomorphism>> candidateHomomorphisms = new ArrayList<List<Homomorphism>>(
				q1.size());
		// Initialize the list
		for (int i = 0; i < q1.size(); i++) {
			candidateHomomorphisms.add(new ArrayList<Homomorphism>());
		}

		int index = 0;
		for (Atom q1Atom : q1) {
			for (Atom q2Atom : q2) {
				if (q1Atom.getPredicate().equals(q2Atom.getPredicate())
						&& q1Atom.getTerms().size() == q2Atom.getTerms().size()) {
					Homomorphism h = createHomomorphism(q1Atom, q2Atom);
					if (h != null) {
						List<Homomorphism> currentHomomorphisms = candidateHomomorphisms
								.get(index);
						if (currentHomomorphisms == null) {
							currentHomomorphisms = new ArrayList<Homomorphism>();
							candidateHomomorphisms.add(index,
									currentHomomorphisms);
						}
						currentHomomorphisms.add(h);
					}
				}
			}
			// Early termination condition. If there is no possible
			// homomorphism from one atom then for sure the whole list
			// cannot have a homomorphism
			if (candidateHomomorphisms.get(index).isEmpty()) {
				return new ArrayList<Homomorphism>();
			}
			index++;
		}

		List<Homomorphism> result = candidateHomomorphisms.get(0);
		for (int i = 1; i < candidateHomomorphisms.size(); i++) {
			List<Homomorphism> copy = new ArrayList<Homomorphism>(result);
			List<Homomorphism> tmp = new ArrayList<Homomorphism>();
			for (Homomorphism h1 : copy) {
				for (Homomorphism h2 : candidateHomomorphisms.get(i)) {
					if (h1.isCompatible(h2)) {
						tmp.add(Homomorphism.merge(h1, h2));
						// found one, if we want we can stop early
						if(stopEarly)
							return tmp;
					}
				}
			}
			// Early termination condition. If there is no compatible
			// homomorphisms till now they are not going to be found later.
			if (tmp.isEmpty()) {
				return new ArrayList<Homomorphism>();
			}
			result = tmp;
		}
		return result;
	}

	/**
	 * Creates a homomorphism from atom a to atom b assuming that both a & b
	 * refer to the same relation.
	 *
	 * @param a
	 *            - a relational atom
	 * @param b
	 *            - a relational atom
	 *
	 * @return a homomorphism from atom a to atom b if there is a valid one
	 *         otherwise it returns null.
	 */
	private static Homomorphism createHomomorphism(Atom a, Atom b) {
		if (a == null || b == null) {
			throw new IllegalArgumentException("Input atoms cannot be null.");
		}
		if (!a.getPredicate().equals(b.getPredicate())) {
			throw new IllegalArgumentException(
					"The input atoms must refer to the same relation.");
		}
		if (a.getTerms().size() != b.getTerms().size()) {
			throw new IllegalArgumentException(
					"The input atoms must have the same number of terms.");
		}
		Homomorphism ret = new Homomorphism();
		for (int i = 0; i < a.getTerms().size(); i++) {
			Term ta = a.getTerm(i);
			Term tb = b.getTerm(i);
			if (ta.isConstant() && tb.isVariable()) {
				// We cannot map a constant to a variable
				return null;
			} else if (ta.isConstant() && tb.isConstant() && !ta.equals(tb)) {
				// We cannot map a constant to a different constant
				return null;
			} else {
				ret.add(ta, tb);
			}

		}
		return ret;
	}

}
