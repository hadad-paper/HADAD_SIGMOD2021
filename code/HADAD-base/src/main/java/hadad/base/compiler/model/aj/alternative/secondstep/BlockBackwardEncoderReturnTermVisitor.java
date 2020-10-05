package hadad.base.compiler.model.aj.alternative.secondstep;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.Term;
import hadad.commons.conjunctivequery.Variable;
import hadad.base.compiler.Element;
import hadad.base.compiler.ReturnConstructTerm;
import hadad.base.compiler.ReturnStringTerm;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.ReturnTemplateVisitor;
import hadad.base.compiler.ReturnTerm;
import hadad.base.compiler.ReturnVariableTerm;
import hadad.base.compiler.StringElement;
import hadad.base.compiler.VariableFactory;
import hadad.base.compiler.model.aj.ArrayElementFactory;
import hadad.base.compiler.model.aj.DataType;
import hadad.base.compiler.model.aj.Predicate;
import hadad.base.compiler.model.aj.Utils;

@Singleton
final class BlockBackwardEncoderReturnTermVisitor implements
		ReturnTemplateVisitor {
	private final ArrayElementFactory arrayElementFactory;
	private final VariableFactory elementVariableFactory;

	private ImmutableList.Builder<List<Atom>> builder;
	private Map<Variable, ImmutableList.Builder<Atom>> auxiliarBuilders;
	private String viewName;
	private Variable parentBlockCreatedNode;
	private Term rootElementCreatedNode;

	@Inject
	public BlockBackwardEncoderReturnTermVisitor(
			final ArrayElementFactory arrayElementFactory,
			@Named("ElementVariableFactory") final VariableFactory elementVariableFactory) {
		this.arrayElementFactory = arrayElementFactory;
		this.elementVariableFactory = elementVariableFactory;
	}

	public List<List<Atom>> encode(final Variable parentBlockCreatedNode,
			final ReturnTemplate template, final String viewName) {
		return _encode(parentBlockCreatedNode, template, viewName);
	}

	public List<List<Atom>> encode(final ReturnTemplate template, final String viewName) {
		return _encode(null, template, viewName);
	}

	private List<List<Atom>> _encode(final Variable parentBlockCreatedNode,
			final ReturnTemplate template, final String viewName) {
		builder = ImmutableList.builder();
		this.auxiliarBuilders = new HashMap<Variable, ImmutableList.Builder<Atom>>();
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
		final ImmutableList.Builder<Atom> builderAux = ImmutableList
				.builder();
		if (isRootBlock() && auxiliarBuilders.isEmpty()) {
			buildRootElement(builderAux, term.getCreatedNode());
			auxiliarBuilders.put(term.getCreatedNode(), builderAux);
		}
		final ImmutableList.Builder<Atom> builderAux2 = ImmutableList.builder();
		addParentBlockCreatedNode(builderAux2, term);
		// builderAux2.addAll(builderAux.build());
		if (isChildBlock() && term.hasParent() && !term.getParent().hasParent()
				&& term.getParent().getElement().isEmpty()) {
			// builderAux2.add(new Atom(Predicate.TAG.toString() + "_"
			// + viewName, term.getCreatedNode(), term.getElement()
			// .toTerm()));
			builderAux2.add(new Atom(Predicate.CHILD.toString() + "_" + viewName, getParentBlockCreatedNode(term),
					term.getCreatedNode(), term.getElement().toTerm(), Utils.toTerm(DataType.OBJECT.toString())));
			auxiliarBuilders.put(term.getCreatedNode(), builderAux2);
			// if (!term.hasChildren()) {
			builder.add(builderAux2.build());
			// }
		} else if ((!term.hasChildren() || !term.hasNonConstructChild()) && !term.getElement().isEmpty()) {
			// builderAux2.add(new Atom(Predicate.TAG.toString() + "_"
			// + viewName, term.getCreatedNode(), term.getElement()
			// .toTerm()));
			// if (isRootBlock()) {
			builderAux2.add(new Atom(Predicate.CHILD.toString() + "_" + viewName, getParentBlockCreatedNode(term),
					term.getCreatedNode(), term.getElement().toTerm(), Utils.toTerm(DataType.OBJECT.toString())));
			// }
			auxiliarBuilders.put(term.getCreatedNode(), builderAux2);
			if (!term.hasChildren()) {
				builder.add(builderAux2.build());
			}
		} else {
			auxiliarBuilders.put(term.getCreatedNode(), builderAux2);
		}
	}

	@Override
	public void visit(final ReturnVariableTerm term) {
		final ImmutableList.Builder<Atom> builderAux = ImmutableList.builder();
		if (isRootBlock() && auxiliarBuilders.isEmpty()) {
			buildRootElement(builderAux, term.getCreatedNode());
		} else {
			addParentBlockCreatedNode(builderAux, term);
			// if (!getParentBlockElement(term).isEmpty()) {
			// builderAux.add(new Atom(Predicate.TAG.toString() + "_"
			// + viewName, term.getCreatedNode(),
			// getParentBlockElement(term)
			// .toTerm()));
			// }
			final Term parentCreatedNode = term.hasParent() ? getParentBlockCreatedNode(term
					.getParent()) : getParentBlockCreatedNode(term);
			builderAux.add(new Atom(
					Predicate.CHILD.toString() + "_" + viewName,
					parentCreatedNode, term.getCreatedNode(),
					Utils.isObject(term) ? getParentBlockElement(term).toTerm()
							: arrayElementFactory.getElement(term),
					Utils.getDataType(term)));
		}
		builder.add(builderAux.build());
	}

	@Override
	public void visit(final ReturnStringTerm term) {
		final ImmutableList.Builder<Atom> builderAux = ImmutableList.builder();
		if (isRootBlock() && auxiliarBuilders.isEmpty()) {
			buildRootElement(builderAux, term.toTerm());
		} else {
			addParentBlockCreatedNode(builderAux, term);
			// if (!getParentBlockElement(term).isEmpty()) {
			// builderAux.add(new Atom(Predicate.TAG.toString() + "_"
			// + viewName, term.getCreatedNode(),
			// getParentBlockElement(term).toTerm()));
			// }
			final Term parentCreatedNode = term.hasParent() ? getParentBlockCreatedNode(term
					.getParent()) : getParentBlockCreatedNode(term);
			builderAux.add(new Atom(
					Predicate.CHILD.toString() + "_" + viewName,
					parentCreatedNode, term.toTerm(),
					Utils.isObject(term) ? getParentBlockElement(term).toTerm()
							: arrayElementFactory.getElement(term),
					Utils.getDataType(term)));
		}
		builder.add(builderAux.build());
	}

	private void addParentBlockCreatedNode(
			final ImmutableList.Builder<Atom> builderAux, final ReturnTerm term) {
		if (auxiliarBuilders.containsKey(getParentBlockCreatedNode(term))) {
			builderAux.addAll(auxiliarBuilders.get(
					getParentBlockCreatedNode(term)).build());
		}
	}

	private Term getParentBlockCreatedNode(final ReturnTerm term) {
		if (term.hasParent()) {
			if (!term.getParent().getElement().isEmpty()) {
				return term.getParent().getCreatedNode();
			} else {
				if (term.getParent().hasParent()
						&& !term.getParent().getParent().getElement().isEmpty()) {
					return term.getParent().getParent().getCreatedNode();
				}
			}
		}
		return (isChildBlock() ? parentBlockCreatedNode
				: rootElementCreatedNode);
	}

	private Element getParentBlockElement(final ReturnTerm term) {
		if (term.hasParent()) {
			if (!term.getParent().getElement().isEmpty()) {
				return term.getParent().getElement();
			} else {
				if (term.getParent().hasParent()
						&& !term.getParent().getParent().getElement().isEmpty()) {
					return term.getParent().getParent().getElement();
				}
			}
		}
		return new StringElement("");
	}

	private void buildRootElement(final ImmutableList.Builder<Atom> builderAux,
			final Term var) {
		rootElementCreatedNode = var;
		builderAux.add(new Atom(viewName, rootElementCreatedNode));
	}
}