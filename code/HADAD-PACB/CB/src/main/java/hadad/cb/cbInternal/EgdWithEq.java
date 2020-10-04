package hadad.cb.cbInternal;

import java.util.ArrayList;

import hadad.commons.constraints.Egd;
import hadad.commons.constraints.Equality;

/**
 *  An EGD with explicit equalities
 */
public class EgdWithEq extends ConstraintWithEq {

	private ArrayList<Equality> conclusion;
	
	/**
	 *  Constructor
	 *  
	 *  @param egd
	 *  		The EGD without equalities
	 */
	public EgdWithEq(final Egd egd)
	{	
		super();
		Utils.FromBodyToBodyWithEq(egd.getPremise(), premiseRel, premiseEq);
		conclusion = new ArrayList<Equality>();
		for (Equality oldEq:egd.getConclusion()) {
			Equality newEq = Utils.GetTransformedEquality(oldEq, egd.getPremise(), premiseRel);
			conclusion.add(newEq);
		}
	}
	
	/**
	 *  Gets the conclusion of the EGD
	 *  
	 *  @return the conclusion of the EGD
	 */
	public ArrayList<Equality> getConclusion() {
		return conclusion;
	}
	
	@Override
	public String toString() {
		return Utils.fromAtomsToString(premiseRel)+","+Utils.fromEqsToString(premiseEq)+"->"+Utils.fromEqsToString(conclusion);
	}
	
}