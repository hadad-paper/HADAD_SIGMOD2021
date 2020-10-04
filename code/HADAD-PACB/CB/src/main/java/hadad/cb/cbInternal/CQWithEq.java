package hadad.cb.cbInternal;

import java.util.ArrayList;
import java.util.Collection;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.constraints.Equality;

/**
 * A conjunctive query with explicit equalities
 */
public class CQWithEq {

	private Atom head;
	
	private ArrayList<Atom> bodyRel;
	
	private ArrayList<Equality> bodyEq;
	
	/**
	* Constructor
	* 
	* @param query 
	* 				The conjunctive query without equalities
	*/
	public CQWithEq(ConjunctiveQuery query) {
		bodyRel = new ArrayList<Atom>();
		bodyEq = new ArrayList<Equality>();
		
		Collection<Atom> origBodyRel = query.getBody();
		Utils.FromBodyToBodyWithEq(origBodyRel, bodyRel, bodyEq);
		head = Utils.GetTransformedRelational(new Atom(query.getName(), query.getHead()), origBodyRel, bodyRel);
	}

	
	/**
	 * Gets the query's head
	 * 
	 * @return the relational head of the query
	 */
	public Atom getHead() {
		return head;
	}
	
	/**
	 * Gets the relational atoms in the query's body
	 * 
	 * @return the list of relational atoms in the query's body
	 */
	public ArrayList<Atom> getBodyRel() {
		return bodyRel;
	}
	
	/**
	 * Gets the equalities in the query's body
	 * 
	 * @return the list of equalities in the query's body
	 */
	public ArrayList<Equality> getBodyEq() {
		return bodyEq;
	}
	
	@Override
	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		final StringBuilder result = new StringBuilder();
		result.append(head);
		result.append(" :- ");
		for (final Atom atom : bodyRel) {
				result.append(atom);
				result.append(",");
		}
		
		if (bodyEq.isEmpty()) {
			if (!bodyRel.isEmpty())
				result.deleteCharAt(result.length() - 1);
			return result.toString();
		}
		
		for (final Equality eq : bodyEq) {
			result.append(eq);
			result.append(",");
		}
		result.deleteCharAt(result.length() - 1);
		
		return result.toString();
	}
}
