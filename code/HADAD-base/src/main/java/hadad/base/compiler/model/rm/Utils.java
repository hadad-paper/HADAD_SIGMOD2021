package hadad.base.compiler.model.rm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.conjunctivequery.StringConstant;
import hadad.commons.conjunctivequery.Variable;
import hadad.commons.relationalschema.Relation;
import hadad.base.compiler.model.sj.Predicate;
import hadad.base.compiler.Condition;
import hadad.base.compiler.ReturnTerm;

public class Utils {
    public static StringConstant toTerm(final String str) {
        return new StringConstant(str);
    }

    public static Atom createRootAtom(final Variable viewID, final String queryName) {
        return new Atom(queryName, viewID);
    }

    public static Function<Condition, List<Atom>> conditionEncoding = c -> new ArrayList<Atom>(

            Arrays.asList(new Atom(Predicate.VAL.toString(), c.getLeftOp().getTerm(), c.getRightOp().getTerm())));

    public static List<Relation> getGlobalRelationsToEnsure(final String documentNamePrefix,
            final Set<String> documentNames, final String viewNamePrefix, final String viewName) {
        final List<Relation> relations = new ArrayList<Relation>();
        relations.add(new Relation(Predicate.CHILD.toString(), 4));
        relations.add(new Relation(Predicate.EQUALS.toString(), 2));
        for (final String documentName : documentNames) {
            relations.add(new Relation(Predicate.ROOT.toString() + documentNamePrefix + documentName, 1));
        }

        relations.addAll(getTargetRelationsToEnsure(viewNamePrefix, viewName));

        return relations;
    }

    public static List<Relation> getTargetRelationsToEnsure(final String viewNamePrefix, final String viewName) {
        final List<Relation> relations = new ArrayList<Relation>();
        relations.add(new Relation(Predicate.CHILD.toString() + viewNamePrefix + viewName, 4));
        relations.add(new Relation(Predicate.EQUALS.toString() + viewNamePrefix + viewName, 2));
        relations.add(new Relation(
                hadad.base.compiler.Predicate.EQUALS.toString() + viewNamePrefix + viewName, 2));
        relations.add(new Relation(Predicate.VAL.toString(), 2));
        relations.add(new Relation(hadad.base.compiler.model.pr.Predicate.EQUALS.toString(), 2));
        relations.add(new Relation(hadad.base.compiler.Predicate.EQUALS.toString(), 2));
        return relations;
    }

    public static boolean isObject(final ReturnTerm term) {
        return term.hasParent() && !term.getParent().getElement().isEmpty();
    }

    public static ConjunctiveQuery restrict(final ConjunctiveQuery query) {
        final List<Atom> body = new ArrayList<Atom>();

        for (final Atom atom : query.getBody()) {
            if (!atom.getPredicate().startsWith(Predicate.TAG.toString())) {
                body.add(atom);
            }
        }
        return new ConjunctiveQuery(query.getName(), query.getHead(), body);
    }
}
