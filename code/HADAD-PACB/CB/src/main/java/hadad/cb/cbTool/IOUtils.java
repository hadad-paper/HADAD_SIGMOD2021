package hadad.cb.cbTool;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import hadad.cb.cbInternal.CQWithEq;
import hadad.cb.cbInternal.ConstraintWithEq;
import hadad.cb.cbInternal.DenialWithEq;
import hadad.cb.cbInternal.EgdWithEq;
import hadad.cb.cbInternal.TgdWithEq;
import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.conjunctivequery.IntegerConstant;
import hadad.commons.conjunctivequery.StringConstant;
import hadad.commons.conjunctivequery.Term;
import hadad.commons.conjunctivequery.Variable;
import hadad.commons.constraints.Constraint;
import hadad.commons.constraints.Egd;
import hadad.commons.constraints.Equality;
import hadad.commons.constraints.False;
import hadad.commons.constraints.Tgd;

public class IOUtils {

    /**
     * Back-chase pre-processing
     * 
     * @param initquery
     *            original query
     * @param universalPlan
     *            universal plan
     * @param bwconstraints
     *            backward constraints
     * @throws IOException
     */
    public static void BackChasePreProcessing(final ConjunctiveQuery originalQuery,
            final ConjunctiveQuery universalPlan, final ArrayList<Constraint> bwconstraints) throws IOException {
        final ConjunctiveQuery queryAsInstance = addSpecialVars(originalQuery);
        final CQWithEq query = new CQWithEq(queryAsInstance);
        final ConjunctiveQuery uPlanAsInstance = addSpecialVars(universalPlan);
        final ArrayList<ConstraintWithEq> constraints = getConstraintsWithEq(bwconstraints);

        final BufferedWriter writer = new BufferedWriter(new FileWriter("bkchasetmp.in"));
        writer.write(universalPlan.getBody().size() + 1 + "\n");

        writer.write("query\n");
        final ArrayList<Atom> relquery = query.getBodyRel();
        for (int i = 0; i < relquery.size(); ++i) {
            Atom crtAtom = relquery.get(i);
            writer.write(toBackchaseInput(crtAtom));
            if (i < relquery.size() - 1)
                writer.write(",");
            else
                writer.write("\n");
        }

        final ArrayList<Equality> eqquery = query.getBodyEq();
        for (int i = 0; i < eqquery.size(); ++i) {
            Equality crtEq = eqquery.get(i);
            writer.write(toBackchaseInput(crtEq));
            if (i < eqquery.size() - 1)
                writer.write(",");
        }
        writer.write("\n");
        writer.write("\n");
        writer.write("constraints\n");
        writer.write(constraints.size() + "\n");

        for (int i = 0; i < constraints.size(); ++i) {
            ConstraintWithEq crtConstraint = constraints.get(i);

            if (crtConstraint instanceof TgdWithEq)
                writer.write("TGD\n");
            else if (crtConstraint instanceof EgdWithEq) {
                writer.write("EGD\n");
            } else {
                writer.write("Denail\n");
            }

            ArrayList<Atom> premRel = crtConstraint.getPremiseRel();
            for (int j = 0; j < premRel.size(); ++j) {
                Atom crtAtom = premRel.get(j);
                writer.write(toBackchaseInput(crtAtom));
                if (j < premRel.size() - 1)
                    writer.write(",");
            }
            if (premRel.size() == 0)
                writer.write("TRUE()");
            writer.write("\n");

            ArrayList<Equality> premEq = crtConstraint.getPremiseEq();
            for (int j = 0; j < premEq.size(); ++j) {
                Equality crtEq = premEq.get(j);
                writer.write(toBackchaseInput(crtEq));
                if (j < premEq.size() - 1)
                    writer.write(",");
            }
            writer.write("\n");

            if (crtConstraint instanceof TgdWithEq) {
                ArrayList<Atom> concRel = ((TgdWithEq) crtConstraint).getConclusion();
                for (int j = 0; j < concRel.size(); ++j) {
                    Atom crtAtom = concRel.get(j);
                    writer.write(toBackchaseInput(crtAtom));
                    if (j < concRel.size() - 1)
                        writer.write(",");
                }
                writer.write("\n");
            } else {
                if (crtConstraint instanceof EgdWithEq) {
                    ArrayList<Equality> concEq = ((EgdWithEq) crtConstraint).getConclusion();
                    for (int j = 0; j < concEq.size(); ++j) {
                        Equality crtEq = concEq.get(j);
                        writer.write(toBackchaseInput(crtEq));
                        if (j < concEq.size() - 1)
                            writer.write(",");
                    }
                    writer.write("\n");
                } 
                else {
                    writer.write("\n");
                }

            }
        }
        writer.write("instance\n");
        Collection<Atom> uPlanAtoms = uPlanAsInstance.getBody();

        int i = 0;
        for (Atom crtAtom : uPlanAtoms) {
            writer.write(toBackchaseInput(crtAtom) + " p" + (i++) + "\n");
        }
        writer.write("TRUE() true");

        writer.close();
    }

    private static ConjunctiveQuery addSpecialVars(ConjunctiveQuery query) {
        HashSet<String> specialVars = new HashSet<String>();
        for (Term term : query.getHead())
            if (term.isVariable())
                specialVars.add(((Variable) term).getName());
        ArrayList<Atom> newAtoms = new ArrayList<Atom>();
        for (Atom atom : query.getBody()) {
            ArrayList<Term> newTerms = new ArrayList<Term>();
            for (Term term : atom.getTerms())
                if (term.isVariable() && specialVars.contains(((Variable) term).getName()))
                    newTerms.add(new StringConstant("$" + ((Variable) term).getName()));
                else
                    newTerms.add(term);
            newAtoms.add(new Atom(atom.getPredicate(), newTerms));
        }
        return new ConjunctiveQuery(query.getName(), query.getHead(), newAtoms);
    }

    private static String toBackchaseInput(Atom atom) {
        String stringRep = atom.getPredicate() + "(";
        for (int i = 0; i < atom.getTerms().size(); ++i) {
            Term crtTerm = atom.getTerm(i);
            if (crtTerm.isVariable())
                stringRep += crtTerm;
            else {
                if (crtTerm instanceof StringConstant)
                    stringRep += "co." + ((StringConstant) crtTerm).getValue();
                else
                    stringRep += "co." + ((IntegerConstant) crtTerm).getValue();
            }
            if (i < atom.getTerms().size() - 1)
                stringRep += ",";
            else
                stringRep += ")";
        }
        return stringRep;
    }

    private static String toBackchaseInput(Equality eq) {
        String stringRep = "";
        Term crtTerm = eq.getTerm1();
        if (crtTerm instanceof Variable)
            stringRep += eq.getTerm1();
        else {
            if (crtTerm instanceof StringConstant)
                stringRep += "co." + ((StringConstant) crtTerm).getValue();
            else
                stringRep += "co." + ((IntegerConstant) crtTerm).getValue();
        }
        stringRep += "=";

        crtTerm = eq.getTerm2();
        if (crtTerm instanceof Variable)
            stringRep += eq.getTerm2();
        else {
            if (crtTerm instanceof StringConstant)
                stringRep += "co." + ((StringConstant) crtTerm).getValue();
            else
                stringRep += "co." + ((IntegerConstant) crtTerm).getValue();
        }
        return stringRep;
    }

    private static ArrayList<ConstraintWithEq> getConstraintsWithEq(ArrayList<Constraint> constraints) {
        ArrayList<ConstraintWithEq> result = new ArrayList<ConstraintWithEq>();
        for (Constraint constraint : constraints) {
            if (constraint instanceof Egd)
                result.add(new EgdWithEq((Egd) constraint));
            else if (constraint instanceof Tgd) {
                result.add(new TgdWithEq((Tgd) constraint));
            } else {

                result.add(new DenialWithEq((False) constraint));
            }
        }
        return result;
    }

}
