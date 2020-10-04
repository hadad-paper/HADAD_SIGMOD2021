package hadad.cb.cbInternal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.conjunctivequery.Term;
import hadad.commons.conjunctivequery.Variable;
import hadad.commons.constraints.Equality;

/**
 *  A collection of utility methods, mainly for translation between tight and with-equality representations
 */
public class Utils {

	public static void FromBodyToBodyWithEq(Collection<Atom> oldBody,
			ArrayList<Atom> newBodyRel,
			ArrayList<Equality> newBodyEq)
	{
		int varindex = 0;
		for (Atom crtAtom:oldBody) {
			ArrayList<Term> resultTerms = new ArrayList<Term>();
			for (int i = 0; i < crtAtom.getTerms().size(); i++) {
				if (crtAtom.getTerms().get(i).isVariable()) {
					Variable resultVar = new Variable("t"+varindex);
					varindex++;
					resultTerms.add(resultVar);
				} else {
					resultTerms.add(crtAtom.getTerms().get(i));
				}
			}
			Atom newAtom = new Atom(crtAtom.getPredicate(), resultTerms);
			newBodyRel.add(newAtom);
		}

		int i = 0;
		for (Atom oldAtom:oldBody) {
			Atom newAtom = newBodyRel.get(i++);
			List<? extends Term> newTerms = newAtom.getTerms();

			for (int j = 0; j < newTerms.size(); ++j) {
				Term crtTerm = newTerms.get(j);
				if (crtTerm.isConstant()) {
					continue;
				}

				Term corresp = oldAtom.getTerms().get(j);
				int k = 0;
				for (Atom tmp:oldBody) {
					for (int h = 0; h < tmp.getTerms().size(); ++h) {
						if (tmp!=oldAtom || h!=j) {
							Term oldOther = tmp.getTerms().get(h);
							if ( (oldOther.isVariable()) && ( ((Variable)oldOther).getName().equals(((Variable)corresp).getName()) ) ) {
								Equality eq = new Equality(crtTerm, newBodyRel.get(k).getTerms().get(h));
								//System.out.println(eq);
								newBodyEq.add(eq);
							}
						}
					}
					k++;
				}
			}
		}
	}

	public static Atom GetTransformedRelational(Atom oldAtom, Collection<Atom> oldBody, ArrayList<Atom> newBodyRel)
	{
		ArrayList<Term> resultTerms = new ArrayList<Term>();
		for (Term term:oldAtom.getTerms()) {
			Term newTerm = getTransformedTerm(term, oldBody, newBodyRel);
			resultTerms.add(newTerm);
		}

		return new Atom(oldAtom.getPredicate(), resultTerms);
	}

	public static Equality GetTransformedEquality(Equality oldEq, Collection<Atom> oldBody, ArrayList<Atom> newBodyRel)
	{
		Term newTerm1 = getTransformedTerm(oldEq.getTerm1(), oldBody, newBodyRel);
		Term newTerm2 = getTransformedTerm(oldEq.getTerm2(), oldBody, newBodyRel);

		return new Equality(newTerm1, newTerm2);
	}

	private static Term getTransformedTerm(Term term, Collection<Atom> oldBody, ArrayList<Atom> newBodyRel)
	{
		if (term.isConstant()) {
			return term;
		}
		Variable crtOldTerm = (Variable)(term);
		int j = 0;
		for (Atom tmp:oldBody) {
			for (int k = 0; k < tmp.getTerms().size(); ++k) {
				Term oldTerm = tmp.getTerms().get(k);
				if (oldTerm instanceof Variable && ((Variable)oldTerm).getName().equals(crtOldTerm.getName()) ) {
					return newBodyRel.get(j).getTerms().get(k);
				}
			}
			j++;
		}
		return crtOldTerm;
	}

	public static String fromEqsToString(ArrayList<Equality> eqs){
		final StringBuilder result = new StringBuilder();
		for (final Equality eq : eqs) {
			result.append(eq);
			result.append(",");
		}
		if (!eqs.isEmpty()) {
			result.deleteCharAt(result.length() - 1);
		}
		return result.toString();
	}

	public static String fromAtomsToString(ArrayList<Atom> atoms){
		final StringBuilder result = new StringBuilder();
		for (final Atom atom : atoms) {
			result.append(atom);
			result.append(",");
		}
		if (!atoms.isEmpty()) {
			result.deleteCharAt(result.length() - 1);
		}
		return result.toString();
	}

	public static String fromQueryToString(ConjunctiveQuery query)
	{
		final StringBuilder result = new StringBuilder();
		result.append(query.getName() + "<");
		for (Term t: query.getHead()) {
			result.append(t); result.append(",");
		}
		if(!query.getHead().isEmpty()){
			result.deleteCharAt(result.length() - 1);
		}

		result.append("> :- ");
		if (query.getBody() != null && !query.getBody().isEmpty()) {
			for (final Atom atom : query.getBody()) {
				result.append(atom);
				result.append(",");
			}
			result.deleteCharAt(result.length() - 1);
		}
		result.append(";");
		return result.toString();
	}

}
