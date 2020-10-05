package hadad.base.compiler.model.xq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.StringConstant;
import hadad.commons.conjunctivequery.Variable;
import hadad.commons.constraints.Constraint;
import hadad.commons.constraints.Egd;
import hadad.commons.constraints.Equality;
import hadad.commons.relationalschema.Relation;
import hadad.base.compiler.Block;
import hadad.base.compiler.ChildBlock;
import hadad.base.compiler.Condition;
import hadad.base.compiler.ReturnVariableTerm;
import hadad.base.compiler.RootBlock;
import hadad.base.compiler.exceptions.CompilationException;

public class Utils {
    public static StringConstant toTerm(final String str) {
        return new StringConstant(str);
    }

    public static boolean isText(final ReturnVariableTerm term) {
        return term.getOptionals().containsKey(ReturnVariableTermOptional.IS_TEXT.toString())
                && term.getOptionals().get(ReturnVariableTermOptional.IS_TEXT.toString()).equals("true");
    }

    private static String getExtractPredicate(final Block block) {
        return block.getId() + "_" + Predicate.EXTRACT;
    }

    private static String getCreatePredicate(final Block block) {
        return block.getId() + "_" + Predicate.CREATE;
    }

    private static String getSkolemFunctionPredicate(final Block block) {
        return block.getId() + "_" + Predicate.SKOLEM;
    }

    public static Atom getExtractAtom(final Block block) {
        return new Atom(getExtractPredicate(block), new ArrayList<Variable>(block.getVisibleVariables()));
    }

    public static Atom getCreateAtom(final Block block) {
        return new Atom(getCreatePredicate(block),
                block.getReturnTemplate().getCreatedNodes((block instanceof RootBlock), true));
    }

    public static List<Atom> getSkolemFunctions(final Block block) {
        final List<Atom> skolemFunctions = new ArrayList<Atom>();
        for (final Variable result : block.getReturnTemplate().getCreatedNodes((block instanceof RootBlock), true)) {
            skolemFunctions.add(new Atom(getSkolemFunctionPredicate(block) + skolemFunctions.size(),
                    getSkolemFunctionTerms(block, result)));
        }
        return skolemFunctions;
    }

    private static List<Variable> getSkolemFunctionTerms(final Block block, final Variable result) {
        final List<Variable> terms = new ArrayList<Variable>();
        terms.add(result);
        terms.addAll(block.getVisibleVariables());
        return terms;
    }

    public static Atom getSkolemFunctionCopyResult(final Atom skolemFunction,
            final String skolemFunctionVariableCopySuffix) {
        final List<Variable> terms = new ArrayList<Variable>();
        terms.add(
                getSkolemFunctionVariableCopy((Variable) skolemFunction.getTerm(0), skolemFunctionVariableCopySuffix));
        for (int i = 1; i < skolemFunction.getTerms().size(); i++) {
            terms.add((Variable) skolemFunction.getTerm(i));
        }
        return new Atom(skolemFunction.getPredicate(), terms);
    }

    public static Atom getSkolemFunctionCopyInputParameters(final Atom skolemFunction,
            final String skolemFunctionVariableCopySuffix) {
        final List<Variable> terms = new ArrayList<Variable>();
        terms.add((Variable) skolemFunction.getTerm(0));
        for (int i = 1; i < skolemFunction.getTerms().size(); i++) {
            terms.add(getSkolemFunctionVariableCopy((Variable) skolemFunction.getTerm(i),
                    skolemFunctionVariableCopySuffix));
        }
        return new Atom(skolemFunction.getPredicate(), terms);
    }

    private static Variable getSkolemFunctionVariableCopy(final Variable var,
            final String skolemFunctionVariableCopySuffix) {
        return new Variable(var.getName() + skolemFunctionVariableCopySuffix);
    }

    public static Function<Condition, List<Atom>> conditionEncoding = c -> new ArrayList<Atom>(
            Arrays.asList(new Atom(Predicate.EQUALS.toString(), c.getLeftOp().getTerm(), c.getRightOp().getTerm())));

    public static Atom getParentCreateSkolemFunction(final ChildBlock block) throws CompilationException {
        final Variable parentCreateAtomVariable = block.getCreatedNode();
        for (final Atom skolemFunction : Utils.getSkolemFunctions(block.getParent())) {
            if (parentCreateAtomVariable.equals(skolemFunction.getTerm(0))) {
                return skolemFunction;
            }
        }
        throw new CompilationException("Parent skolem function not found.");
    }

    public static List<Constraint> getConstraintForSkolemFunctions(final Block block,
            final String skolemFunctionVariableCopySuffix) {
        final List<Constraint> constraints = new ArrayList<Constraint>();
        List<Atom> premise;
        List<Equality> conclusion;
        Atom skolemFunctionCopy;
        for (final Atom skolemFunction : Utils.getSkolemFunctions(block)) {
            premise = new ArrayList<Atom>();
            premise.add(skolemFunction);
            skolemFunctionCopy = Utils.getSkolemFunctionCopyResult(skolemFunction, skolemFunctionVariableCopySuffix);
            premise.add(skolemFunctionCopy);
            conclusion = new ArrayList<Equality>();
            conclusion.add(new Equality(skolemFunction.getTerm(0), skolemFunctionCopy.getTerm(0)));
            constraints.add(new Egd(premise, conclusion));

            premise = new ArrayList<Atom>();
            premise.add(skolemFunction);
            skolemFunctionCopy =
                    Utils.getSkolemFunctionCopyInputParameters(skolemFunction, skolemFunctionVariableCopySuffix);
            premise.add(skolemFunctionCopy);
            conclusion = new ArrayList<Equality>();
            for (int i = 1; i < skolemFunction.getTerms().size(); i++) {
                conclusion.add(new Equality(skolemFunction.getTerm(i), skolemFunctionCopy.getTerm(i)));
            }
            constraints.add(new Egd(premise, conclusion));
        }
        return constraints;
    }

    public static List<Relation> getGlobalRelationsToEnsure(final String documentNamePrefix,
            final Set<String> documentNames, final String viewNamePrefix, final String viewName) {
        final List<Relation> relations = new ArrayList<Relation>();
        relations.add(new Relation(Predicate.CHILD.toString(), 2));
        relations.add(new Relation(Predicate.COPY.toString(), 2));
        relations.add(new Relation(Predicate.DESCENDANT.toString(), 2));
        relations.add(new Relation(Predicate.EQUALS.toString(), 2));
        relations.add(new Relation(Predicate.HAS_ATTRIBUTE.toString(), 2));
        relations.add(new Relation(Predicate.HAS_ATTRIBUTE_VALUE.toString(), 3));
        for (final String documentName : documentNames) {
            relations.add(new Relation(Predicate.ROOT.toString() + documentNamePrefix + documentName, 1));
        }
        relations.add(new Relation(Predicate.TAG.toString(), 2));
        relations.add(new Relation(Predicate.TEXT.toString(), 2));

        relations.addAll(getTargetRelationsToEnsure(viewNamePrefix, viewName));

        return relations;
    }

    public static List<Relation> getTargetRelationsToEnsure(final String viewNamePrefix, final String viewName) {
        final List<Relation> relations = new ArrayList<Relation>();
        relations.add(new Relation(Predicate.CHILD.toString() + viewNamePrefix + viewName, 2));
        relations.add(new Relation(Predicate.COPY.toString() + viewNamePrefix + viewName, 2));
        relations.add(new Relation(Predicate.DESCENDANT.toString() + viewNamePrefix + viewName, 2));
        relations.add(new Relation(hadad.base.compiler.Predicate.EQUALS.toString(), 2));
        relations.add(new Relation(Predicate.EQUALS.toString() + viewNamePrefix + viewName, 2));
        relations.add(new Relation(Predicate.HAS_ATTRIBUTE.toString() + viewNamePrefix + viewName, 2));
        relations.add(new Relation(Predicate.HAS_ATTRIBUTE_VALUE.toString() + viewNamePrefix + viewName, 3));
        relations.add(new Relation(Predicate.TAG.toString() + viewNamePrefix + viewName, 2));
        relations.add(new Relation(Predicate.TEXT.toString() + viewNamePrefix + viewName, 2));
        return relations;
    }
}
