package hadad.commons.conjunctivequery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * A Conjunctive Query, ie. a set of Terms (the head), and a set atoms (the
 * body).
 */
public class ConjunctiveQuery implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String DEFAULT_NAME_PREFIX = "q";
	private static int counter = 0;

	/** The query name */
	protected String name;

	/** The head, a tuple of variable constants. */
	protected List<Term> head;

	/** The set of patterns. */
	protected List<Atom> body;

	/** The set of variables */
	private Map<String, Variable> variables;

	/** The clusters, the set of patterns associated with each variable. */
	protected Map<Variable, Set<Atom>> clusters;

	public ConjunctiveQuery(Collection<? extends Term> head,
			Collection<Atom> body) {
		this(DEFAULT_NAME_PREFIX + counter, head, body);
	}

	public ConjunctiveQuery(final String name, Collection<? extends Term> head,
			Collection<Atom> body) {
		this.name = name;
		this.body = body != null ? new ArrayList<Atom>(body) : null;
		consolidateVariables();
		updateClusters();
		if (head == null) {
			this.head = new ArrayList<Term>(variables.values());
		} else {
			updateHead(head);
		}
		counter++;
	}

	/**
	 * Gets the name
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the head.
	 *
	 * @return the head, as a collection of terms.
	 */
	public List<Term> getHead() {
		return head;
	}

	/**
	 * Gets the body patterns.
	 *
	 * @return the body patterns
	 */
	public Collection<Atom> getBody() {
		return body;
	}

	/**
	 * Gets the variables appearing in the patterns of the query.
	 *
	 * @return the body variables
	 */
	public Set<Variable> getVariables() {
		return new HashSet<Variable>(variables.values());
	}

	/**
	 * Gets the clusters, a map associating to each variable, the set of
	 * patterns it appears in.
	 *
	 * @return the clusters, a map associating to each variable, the set of
	 *         patterns it appears in.
	 */
	public Map<Variable, Set<Atom>> getClusters() {
		return clusters;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder result = new StringBuilder();
		result.append(getName());
		// Head
		result.append('<');
		if (!getHead().isEmpty()) {
			for (final Term t : getHead()) {
				result.append(t).append(',');
			}
			result.deleteCharAt(result.length() - 1);
		}
		result.append("> :- ");
		// Body
		if (getBody() != null) {
			for (final Atom atom : getBody()) {
				result.append(atom.toString()).append(',');
			}
			result.deleteCharAt(result.length() - 1);
		}
		// Add the ending semicolon
		result.append(";");
		return result.toString();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return Objects.hash(head, body);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#equals(java.lang.Object)
	 */

	@Override
	public boolean equals(Object o) {
		return (o != null && o.getClass() == getClass())
				&& head.equals(((ConjunctiveQuery) o).head)
				&& body.equals(((ConjunctiveQuery) o).body);
	}

	/**
	 * Returns true if this query is equivalent with the query 'other' given as parameter and false otherwise.
	 * Equivalence is checked through both ways containment of the queries.
	 *
	 * @param other - the ConjunctiveQuery under which we are checking for equivalence.
	 * @return true if this query is equivalent with q and false otherwise.
	 */
	public boolean isEquivalent(ConjunctiveQuery other){
		return this.isContained(other) && other.isContained(this);
	}

	/**
	 * Returns true if this query is contained in the query 'other' given as parameter and false otherwise.
	 * Essentially it searches for homomorphisms from the query 'other' to the current one.
	 *
	 * @param other - the ConjunctiveQuery under which we are checking containment
	 * @return true if this query is contained in 'other' and false otherwise.
	 */
	public boolean isContained(ConjunctiveQuery other){
		List<Atom> atomsQ1 = new ArrayList<Atom>(body);
		List<Atom> atomsQ2 = new ArrayList<Atom>(other.body);


		//If the heads project out different number of variables
		//then the queries cannot be contained
		if(head.size()!=other.head.size()){
			return false;
		}

		//Model the head of the queries as an atom and push it inside the body
		//to check for global homomorphism
		Atom hQ1 = new Atom("Q", head);
		Atom hQ2 = new Atom("Q", other.head);
		atomsQ1.add(hQ1);
		atomsQ2.add(hQ2);

		//TODO zabetak: Instead of finding all homomorphisms (wasting performance) one could be sufficient for the containment check.
		//Find all homomorphisms
		List<Homomorphism> homomorphisms = Homomorphism.findHomomorphisms(
				atomsQ2, atomsQ1);
		return !homomorphisms.isEmpty();
	}



	/**
	 * Consolidate variables. Identifies variable with identical name, and
	 * resolves conflicts (e.g. variables with identical names and different
	 * types).
	 */
	private void consolidateVariables() {
		final List<Atom> consolidated = new ArrayList<Atom>();
		variables = new HashMap<String, Variable>();

		if (body != null) {
			for (final Atom pattern : body) {
				final Atom consolidatedPattern = consolidatePatternIfNeeded(pattern);
				consolidated.add(consolidatedPattern);
			}
			body = consolidated;
		}
	}

	/**
	 * Consolidate variables. Identifies variable with identical name, and
	 * resolves conflicts (e.g. variables with identical names and different
	 * types). Fresh/unknown variables, that appear in the pattern, are added
	 *
	 * @param pattern
	 *            which variables will be consolidated against the known
	 *            variables, if needed
	 * @return pattern if it doesn't need to be consolidated a new triple
	 *         pattern with the variables consolidated, otherwise
	 */
	private Atom consolidatePatternIfNeeded(final Atom atom) {
		final List<Term> consolidatedTerms = new ArrayList<Term>();
		Boolean needsConsolidation = false;
		for (final Term term : atom.getTerms()) {
			final Term consolidatedTerm = consolidateTermIfNeeded(term);
			consolidatedTerms.add(consolidatedTerm);
			if (consolidatedTerm != term) {
				needsConsolidation = true;
			}
		}
		return (needsConsolidation ? new Atom(atom.getId(),
				atom.getPredicate(), consolidatedTerms) : atom);
	}

	/**
	 * Consolidate variables. Identifies variable with identical name, and
	 * resolves conflicts (e.g. variables with identical names and different
	 * types). Fresh/unknown variables will be added.
	 *
	 * @param term
	 *            to be consolidated against the known variables, if needed
	 * @return term if it doesn't need to be consolidated the known variable, to
	 *         which term had been consolidated, otherwise
	 */
	private Term consolidateTermIfNeeded(Term term) {
		Term consolidated = term;

		if (term.isVariable()) {
			final Variable variable = (Variable) term;
			final Variable knownVariable = variables.get(variable.getName());
			if (knownVariable == null) {
				variables.put(variable.getName(), variable);
			} else {
				consolidated = knownVariable;
			}
		}

		return consolidated;
	}

	/**
	 * Updates the clusters. In practice, the clusters are completely rebuilt in
	 * the process.
	 */
	private void updateClusters() {
		clusters = new HashMap<Variable, Set<Atom>>();
		if (body != null) {
			for (final Atom p : body) {
				for (final Variable v : p.getVariables()) {
					Set<Atom> patterns = clusters.get(v);
					if (patterns == null) {
						patterns = new HashSet<Atom>();
					}
					patterns.add(p);
					clusters.put(v, patterns);
				}
			}
		}
	}

	/**
	 * Rebuilds the head as a list of terms pointing to the variables appearing
	 * in the body.
	 *
	 * @param head
	 *            the head
	 * @return the list
	 */
	private void updateHead(Collection<? extends Term> head) {
		final List<Term> newHead = new ArrayList<Term>();
		for (final Term t : head) {
			if (t.isVariable()) {
				final Variable v = variables.get(((Variable) t).getName());
				if (v != null) {
					newHead.add(variables.get(((Variable) t).getName()));
				} else {
					newHead.add(t);
				}
			} else {
				newHead.add(t);
			}
		}
		this.head = newHead;
	}
}
