package hadad.base.compiler.model.rk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.StringConstant;
import hadad.commons.conjunctivequery.Variable;
import hadad.commons.relationalschema.Relation;
import hadad.base.compiler.Block;
import hadad.base.compiler.Condition;
import hadad.base.compiler.ReturnConstructTerm;
import hadad.base.compiler.ReturnTerm;
import hadad.base.compiler.ReturnVariableTerm;
import hadad.base.compiler.RootBlock;

public class Utils {
	public final static String NOLOOKUP = "0";

	public static StringConstant toTerm(final String str) {
		return new StringConstant(str);
	}

	public static Variable toTermVar(final String str) {
		return new Variable(str);
	}

	private static String getCollectionPredicate(final Block block) {
		return Predicate.COLLECTION + "_" + block.getQueryName();
	}

	public static Atom getCollectionAtom(final Block block, final Variable viewiD) {
		final List<Variable> var;
		if (block.getReturnTemplate().getTerms().get(0) instanceof ReturnVariableTerm) {
			ReturnVariableTerm term = (ReturnVariableTerm) block.getReturnTemplate().getTerms().get(0);
			if (!term.getOptionals().containsKey(term.getVariable().toString())) {
				var = block.getReturnTemplate().getCreatedNodes((block instanceof RootBlock), false);
			} else {

				var = block.getReturnTemplate().getReferredVariables().stream().collect(Collectors.toList());
			}
		} else {
			var = block.getReturnTemplate().getCreatedNodes((block instanceof RootBlock), false);
		}
		return new Atom(getCollectionPredicate(block), viewiD, var.get(0), Utils.toTerm(NOLOOKUP),
		        Utils.toTerm(DataType.SET.toString()));
	}

	public static Atom getCollectionAtomSet(final Block block, final Variable rootVar, final Variable freshVar) {
		return new Atom(getCollectionPredicate(block), rootVar, freshVar, Utils.toTerm(NOLOOKUP),
		        Utils.toTerm(DataType.SET.toString()));
	}

	public static Atom getInternalMapAtom(final Block block, final Variable internalMapID) {
		List<Variable> var = block.getReturnTemplate().getCreatedNodes((block instanceof RootBlock), false);
		return new Atom(getCollectionPredicate(block), var.get(0), internalMapID,
		        Utils.toTermVar(((ReturnConstructTerm) block.getReturnTemplate().getTerms().get(0)).getElement()
		                .toString().replaceAll("\"", "")),
		        Utils.toTerm(DataType.MAP.toString()));

	}

	public static List<Atom> getCollectionAtomMap(final Block block, final Variable InternalMapID) {
		ReturnConstructTerm term = (ReturnConstructTerm) block.getReturnTemplate().getTerms().get(0);
		return term.getChildren().stream().map(c -> (ReturnConstructTerm) c)
		        .map(c -> new Atom(getCollectionPredicate(block), InternalMapID,
		                ((ReturnVariableTerm) c.getChildren().get(0)).getVariable(),
		                Utils.toTerm(c.getElement().toString()), Utils.toTerm(DataType.INTERNALMAP.toString())))
		        .collect(Collectors.toList());
	}

	public static Function<Condition, List<Atom>> conditionEncoding = c -> new ArrayList<Atom>(
	        Arrays.asList(new Atom(Predicate.EQUALS.toString(), c.getLeftOp().getTerm(), c.getRightOp().getTerm())));

	public static List<Relation> getGlobalRelationsToEnsure(final String documentNamePrefix,
	        final Set<String> documentNames, final String viewNamePrefix, final String viewName) {
		final List<Relation> relations = new ArrayList<Relation>();
		relations.add(new Relation(Predicate.COLLECTION.toString(), 4));
		relations.add(new Relation(Predicate.COPY.toString(), 2));
		relations.add(new Relation(Predicate.EQUALS.toString(), 2));
		for (final String documentName : documentNames) {
			relations.add(new Relation(Predicate.MAINMAP.toString() + documentNamePrefix + documentName, 1));
		}

		relations.addAll(getTargetRelationsToEnsure(viewNamePrefix, viewName));

		return relations;
	}

	public static List<Relation> getTargetRelationsToEnsure(final String viewNamePrefix, final String viewName) {
		final List<Relation> relations = new ArrayList<Relation>();
		relations.add(new Relation(Predicate.COLLECTION.toString() + viewNamePrefix + viewName, 4));
		relations.add(new Relation(Predicate.COPY.toString() + viewNamePrefix + viewName, 2));
		relations.add(new Relation(Predicate.EQUALS.toString() + viewNamePrefix + viewName, 2));
		relations.add(new Relation(Predicate.EQUALS.toString(), 2));

		relations.add(new Relation(hadad.base.compiler.Predicate.EQUALS.toString(), 2));
		return relations;
	}

	public static boolean isObject(final ReturnTerm term) {
		return term.hasParent() && !term.getParent().getElement().isEmpty();
	}
}
