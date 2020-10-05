package hadad.base.rewriter.legacy;

import java.util.ArrayList;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.constraints.False;

/**
 * A Denial constraint with explicit equalities
 */
public class DenialWithEq extends ConstraintWithEq {
    /**
     * Constructor
     * 
     * @param denial
     *            The denial without equalities
     */
    public DenialWithEq(final False denial) {
        super();
        Utils.FromBodyToBodyWithEq(denial.getPremise(), premiseRel, premiseEq);
    }

    /**
     * Gets the Deianl's conclusion
     * 
     * @return the TGD's conclusion
     */
    public ArrayList<Atom> getConclusion() {
        return new ArrayList<>();
    }

    @Override
    public String toString() {

        final StringBuilder str = new StringBuilder();
        str.append(Utils.fromAtomsToString(premiseRel));
        str.append(",");
        str.append(Utils.fromEqsToString(premiseEq));
        str.append("->");
        str.append("false");
        return str.toString();
    }
}
