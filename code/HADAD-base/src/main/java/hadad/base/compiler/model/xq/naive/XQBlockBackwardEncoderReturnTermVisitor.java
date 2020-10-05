package hadad.base.compiler.model.xq.naive;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.Term;
import hadad.commons.conjunctivequery.Variable;
import hadad.base.compiler.PathExpression;
import hadad.base.compiler.ReturnConstructTerm;
import hadad.base.compiler.ReturnLeafTerm;
import hadad.base.compiler.ReturnStringTerm;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.ReturnTemplateVisitor;
import hadad.base.compiler.ReturnTerm;
import hadad.base.compiler.ReturnVariableTerm;
import hadad.base.compiler.VariableFactory;
import hadad.base.compiler.model.xq.Predicate;
import hadad.base.compiler.model.xq.Utils;

@Singleton
public final class XQBlockBackwardEncoderReturnTermVisitor implements ReturnTemplateVisitor {
	private final VariableFactory						elementVariableFactory;

	private Map<Variable, PathExpression>				definitions;
	private ImmutableList.Builder<List<Atom>>			builder;
	private Map<Variable, ImmutableList.Builder<Atom>>	auxiliarBuilders;
	private String										viewName;
	private Variable									parentBlockCreatedNode;
	private Term										rootElementCreatedNode;

	@Inject
	public XQBlockBackwardEncoderReturnTermVisitor(
	        @Named("ElementVariableFactory") final VariableFactory elementVariableFactory) {
		this.elementVariableFactory = elementVariableFactory;
	}

	public List<List<Atom>> encode(final Map<Variable, PathExpression> definitions,
	        final Variable parentBlockCreatedNode, final ReturnTemplate template, final String viewName) {
		return _encode(definitions, parentBlockCreatedNode, template, viewName);
	}

	public List<List<Atom>> encode(final Map<Variable, PathExpression> definitions, final ReturnTemplate template,
	        final String viewName) {
		return _encode(definitions, null, template, viewName);
	}

	private List<List<Atom>> _encode(final Map<Variable, PathExpression> definitions,
	        final Variable parentBlockCreatedNode, final ReturnTemplate template, final String viewName) {
		builder = ImmutableList.builder();
		this.auxiliarBuilders = new HashMap<Variable, ImmutableList.Builder<Atom>>();
		this.definitions = definitions;
		this.parentBlockCreatedNode = parentBlockCreatedNode;
		this.viewName = viewName;
		template.accept(this);
		return builder.build();
	}

	private boolean isRootBlock() {
		return parentBlockCreatedNode == null;
	}

	private boolean isChildBlock() {
		return !isRootBlock();
	}

	@Override
	public void visit(final ReturnTemplate template) {
		// NOP (no encoding for the template optionals)
	}

	@Override
	public void visitPost(final ReturnConstructTerm term) {
		// NOP (no encoding after the children are processed)
	}

	@Override
	public void visitPre(final ReturnConstructTerm term) {
		final ImmutableList.Builder<Atom> builderAux = ImmutableList.builder();
		addParentBlockCreatedNode(builderAux, term);
		if (isRootBlock() && auxiliarBuilders.isEmpty()) {
			buildRootElement(builderAux, term.getCreatedNode());
		}
		if (isChildBlock() || term.hasParent()) {
			builderAux.add(new Atom(Predicate.CHILD.toString() + "_" + viewName, getParentBlockCreatedNode(term),
			        term.getCreatedNode()));
		}
		builderAux.add(
		        new Atom(Predicate.TAG.toString() + "_" + viewName, term.getCreatedNode(), term.getElement().toTerm()));
		auxiliarBuilders.put(term.getCreatedNode(), builderAux);
		builder.add(builderAux.build());
		for (final Entry<String, ReturnLeafTerm> attr : term.getAttributes().entrySet()) {
			final ImmutableList.Builder<Atom> builderAuxAttr = ImmutableList.builder();
			builderAuxAttr.addAll(builderAux.build());
			builderAuxAttr.add(new Atom(Predicate.HAS_ATTRIBUTE.toString() + "_" + viewName, term.getCreatedNode(),
			        Utils.toTerm(attr.getKey())));
			builder.add(builderAuxAttr.build());
		}
	}

	@Override
	public void visit(final ReturnVariableTerm term) {
		final ImmutableList.Builder<Atom> builderAux = ImmutableList.builder();
		if (isRootBlock()) {
			buildRootElement(builderAux, term.getCreatedNode());
		} else {
			addParentBlockCreatedNode(builderAux, term);
			visitAux(term, builderAux);
		}
		builder.add(builderAux.build());
	}

	private void visitAux(final ReturnVariableTerm term, final ImmutableList.Builder<Atom> builderAux) {
		if (Utils.isText(term)) {
			builderAux.add(new Atom(Predicate.TEXT.toString() + "_" + viewName, getParentBlockCreatedNode(term),
			        term.getCreatedNode()));
		} else {
			final List<Atom> tags = definitions.get(term.getVariable()).encoding().stream().filter(
			        c -> c.getPredicate().equals(Predicate.TAG.toString()) && c.getTerm(0).equals(term.getVariable()))
			        .collect(Collectors.toList());

			if (tags.size() != 1) {
				throw new IllegalStateException("Tag atom not found for the variable.");
			}

			builderAux.add(new Atom(Predicate.CHILD.toString() + "_" + viewName, getParentBlockCreatedNode(term),
			        term.getCreatedNode()));
			builderAux.add(
			        new Atom(Predicate.TAG.toString() + "_" + viewName, term.getCreatedNode(), tags.get(0).getTerm(1)));
		}
	}

	@Override
	public void visit(final ReturnStringTerm term) {
		final ImmutableList.Builder<Atom> builderAux = ImmutableList.builder();

		if (isRootBlock()) {
			buildRootElement(builderAux, elementVariableFactory.createFreshVar());
			builderAux.add(new Atom(Predicate.TEXT.toString() + "_" + viewName, rootElementCreatedNode, term.toTerm()));
		} else {
			addParentBlockCreatedNode(builderAux, term);
			builderAux.add(new Atom(Predicate.TEXT.toString() + "_" + viewName, getParentBlockCreatedNode(term),
			        term.toTerm()));
		}
		builder.add(builderAux.build());
	}

	private void addParentBlockCreatedNode(final ImmutableList.Builder<Atom> builderAux, final ReturnTerm term) {
		if (auxiliarBuilders.containsKey(getParentBlockCreatedNode(term))) {
			builderAux.addAll(auxiliarBuilders.get(getParentBlockCreatedNode(term)).build());
		} else if (term.hasParent()) {
			throw new IllegalStateException("Parent block created node builder expected on child term.");
		}
	}

	private Term getParentBlockCreatedNode(final ReturnTerm term) {
		return term.hasParent() ? term.getParent().getCreatedNode()
		        : (isChildBlock() ? parentBlockCreatedNode : rootElementCreatedNode);
	}

	private void buildRootElement(final ImmutableList.Builder<Atom> builderAux, final Term var) {
		rootElementCreatedNode = var;
		builderAux.add(new Atom(viewName, rootElementCreatedNode));
	}
}