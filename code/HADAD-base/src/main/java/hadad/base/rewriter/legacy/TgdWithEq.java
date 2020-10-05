package hadad.base.rewriter.legacy;

import java.util.ArrayList;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.constraints.Tgd;

/**
 * A TGD with explicit equalities
 */
public class TgdWithEq extends ConstraintWithEq
{
	private ArrayList<Atom> conclusion;

	/**
	 *  Constructor
	 *  
	 *  @param tgd
	 *  		The TGD without equalities
	 */
	public TgdWithEq(Tgd tgd)
	{	
		super();
		Utils.FromBodyToBodyWithEq(tgd.getPremise(), premiseRel, premiseEq);
		conclusion = new ArrayList<Atom>();
		for (Atom oldAtom:tgd.getConclusion())
		{
			Atom newAtom = Utils.GetTransformedRelational(oldAtom, tgd.getPremise(), premiseRel);
			conclusion.add(newAtom);
		}
	}

	/**
	 *  Gets the TGD's conclusion
	 *  
	 *  @return the TGD's conclusion
	 */
	public ArrayList<Atom> getConclusion() {
		return conclusion;
	}
	public String toString() {
		return Utils.fromAtomsToString(premiseRel)+","+Utils.fromEqsToString(premiseEq)+"->"+Utils.fromAtomsToString(conclusion);
	}
}


