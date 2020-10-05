package hadad.base.compiler.model.aj.naive;

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
public final class AJBlockBackwardEncoderReturnTermVisitor implements ReturnTemplateVisitor {
	private final ArrayElementFactory					arrayElementFactory;
	private final VariableFactory						elementVariableFactory;

	private ImmutableList.Builder<List<Atom>>			builder;
	private Map<Variable, ImmutableList.Builder<Atom>>	auxiliarBuilders;
	private String										viewName;
	private Variable									parentBlockCreatedNode;
	private Term										rootElementCreatedNode;

	@Inject
	public AJBlockBackwardEncoderReturnTermVisitor(final ArrayElementFactory arrayElementFactory,
	        @Named("ElementVariableFactory") final VariableFactory elementVariableFactory) {
		this.elementVariableFactory = elementVariableFactory;
		this.arrayElementFactory = arrayElementFactory;
	}

	public List<List<Atom>> encode(final Variable parentBlockCreatedNode, final ReturnTemplate template,
	        final String viewName) {
		return _encode(parentBlockCreatedNode, template, viewName);
	}

	public List<List<Atom>> encode(final ReturnTemplate template, final String viewName) {
		return _encode(null, template, viewName);
	}

	private List<List<Atom>> _encode(final Variable parentBlockCreatedNode, final ReturnTemplate template,
	        final String viewName) {
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
		final ImmutableList.Builder<Atom> builderAux = ImmutableList.builder();
		if (term.getElement().isEmpty()) {
			if (isRootBlock()) {
				if (builder.build().isEmpty()) {
					if (term.hasChildren()) {
						buildRootElement(builderAux, term.getCreatedNode());
						auxiliarBuilders.put(term.getCreatedNode(), builderAux);
					}
				}
			}
		} else {
			addParentBlockCreatedNode(builderAux, term);
			if (isRootBlock()) {
				if (auxiliarBuilders.isEmpty()) {
					if (term.hasChildren()) {
						buildRootElement(builderAux, term.getCreatedNode());
						auxiliarBuilders.put(term.getCreatedNode(), builderAux);
					} else {
						final Variable var = elementVariableFactory.createFreshVar();
						buildRootElement(builderAux, var);
						auxiliarBuilders.put(var, builderAux);
					}

				}
			}
			builderAux.add(new Atom(Predicate.CHILD.toString() + "_" + viewName, getParentBlockCreatedNode(term),
			        term.getCreatedNode(), term.getElement().toTerm(), Utils.toTerm(DataType.OBJECT.toString())));
			auxiliarBuilders.put(term.getCreatedNode(), builderAux);
			if (!term.hasChildren() || !term.hasNonConstructChild()) {
				builder.add(builderAux.build());
			}
		}
	}

	@Override
	public void visit(final ReturnVariableTerm term) {
		final ImmutableList.Builder<Atom> builderAux = ImmutableList.builder();
		if (isRootBlock() && auxiliarBuilders.isEmpty()) {
			buildRootElement(builderAux, term.getCreatedNode());
		} else {
			if (term.hasParent() && term.getParent().hasParent()
					&& term.getParent().getParent().getElement().isEmpty()) {
				addParentBlockCreatedNode(builderAux, term.getParent());
			} else {
				addParentBlockCreatedNode(builderAux, term);
			}
			builderAux
			        .add(new Atom(Predicate.CHILD.toString() + "_" + viewName,
			                getParentBlockCreatedNode(term), term.getCreatedNode(), Utils.isObject(term)
			                        ? getParentBlockElement(term).toTerm() : arrayElementFactory.getElement(term),
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
			if (term.getParent().hasParent() && term.getParent().getParent().getElement().isEmpty()) {
				addParentBlockCreatedNode(builderAux, term.getParent());
			} else {
				addParentBlockCreatedNode(builderAux, term);
			}
			builderAux
			        .add(new Atom(Predicate.CHILD.toString() + "_" + viewName,
			                getParentBlockCreatedNode(term), term.toTerm(), Utils.isObject(term)
			                        ? getParentBlockElement(term).toTerm() : arrayElementFactory.getElement(term),
			                Utils.getDataType(term)));
		}
		builder.add(builderAux.build());
	}

	private void addParentBlockCreatedNode(final ImmutableList.Builder<Atom> builderAux, final ReturnTerm term) {
		if (auxiliarBuilders.containsKey(getParentBlockCreatedNode(term))) {
			builderAux.addAll(auxiliarBuilders.get(getParentBlockCreatedNode(term)).build());
		} else if (term.hasParent() && !term.getParent().getElement().isEmpty()) {
			throw new IllegalStateException("Parent block created node builder expected on child term.");
		}
	}

	private Term getParentBlockCreatedNode(final ReturnTerm term) {
		if (term.hasParent()) {
			// TODO: test that we are not introducing a bug when the parent's
			// parent is not the root.
			if ((term instanceof ReturnVariableTerm || term instanceof ReturnStringTerm) && term.getParent().hasParent()
					&& term.getParent().getParent().getElement().isEmpty()) {
				return (isChildBlock() ? parentBlockCreatedNode : rootElementCreatedNode);
			}
			if (!term.getParent().getElement().isEmpty()) {
				return term.getParent().getCreatedNode();
			} else {
				if (term.getParent().hasParent() && !term.getParent().getParent().getElement().isEmpty()) {
					return term.getParent().getParent().getCreatedNode();
				}
			}
		}
		return (isChildBlock() ? parentBlockCreatedNode : rootElementCreatedNode);
	}

	private Element getParentBlockElement(final ReturnTerm term) {
		if (term.hasParent()) {
			if (!term.getParent().getElement().isEmpty()) {
				return term.getParent().getElement();
			} else {
				if (term.getParent().hasParent() && !term.getParent().getParent().getElement().isEmpty()) {
					return term.getParent().getParent().getElement();
				}
			}
		}
		return new StringElement("");
	}

	private void buildRootElement(final ImmutableList.Builder<Atom> builderAux, final Term var) {
		rootElementCreatedNode = var;
		builderAux.add(new Atom(viewName, rootElementCreatedNode));
	}
}