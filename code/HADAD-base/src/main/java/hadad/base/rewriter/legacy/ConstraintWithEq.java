package hadad.base.rewriter.legacy;

import java.util.ArrayList;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.constraints.Equality;

/**
 *  A constraint with explicit equalities
 */
public abstract class ConstraintWithEq {
	
	/** The relational atoms in the premise of the constraint*/
	protected ArrayList<Atom> premiseRel;

	/** The equalities in the premise of the constraint*/
	protected ArrayList<Equality> premiseEq;

	/**
	 *  Constructor (to be used by subclasses)
	 */
	public ConstraintWithEq() {
		this.premiseRel = new ArrayList<Atom>();
		this.premiseEq = new ArrayList<Equality>();
	}

	/**
	 *  Gets the relational atoms in the premise of the constraint
	 *  
	 *  @return the relational atoms in the premise of the constraint
	 */
	public ArrayList<Atom> getPremiseRel() {
		return premiseRel;
	} 

	/**
	 *  Gets the equalities in the premise of the constraint
	 *  
	 *  @return the equalities in the premise of the constraint
	 */
	public ArrayList<Equality> getPremiseEq() {
		return premiseEq;
	} 

}
