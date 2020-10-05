package hadad.base.compiler.model.aj.alternative.secondstep;

import java.util.List;

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
final class BlockForwardEncoderReturnTermVisitor implements ReturnTemplateVisitor {
	private final ArrayElementFactory arrayElementFactory;
	private final VariableFactory elementVariableFactory;
	private ImmutableList.Builder<Atom> builder;
	private String viewName;
	private Variable parentBlockCreatedNode;
	private Term rootElementCreatedNode;

	@Inject
	public BlockForwardEncoderReturnTermVisitor(
			final ArrayElementFactory arrayElementFactory,
			@Named("ElementVariableFactory") final VariableFactory elementVariableFactory) {
		this.arrayElementFactory = arrayElementFactory;
		this.elementVariableFactory = elementVariableFactory;
	}

	public List<Atom> encode(final Variable parentBlockCreatedNode,
			final ReturnTemplate template, final String viewName) {
		return _encode(parentBlockCreatedNode, template, viewName);
	}

	public List<Atom> encode(final ReturnTemplate template,
			final String viewName) {
		return _encode(null, template, viewName);
	}

	private List<Atom> _encode(final Variable parentBlockCreatedNode,
			final ReturnTemplate template, final String viewName) {
		builder = ImmutableList.builder();
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
		if (isRootBlock()) {
			if (builder.build().isEmpty()) {
				if (term.hasChildren()) {
					buildRootElement(term.getCreatedNode());
				} else {
					final Variable var = elementVariableFactory.createFreshVar();
					buildRootElement(var);
				}
			}
			if ((!term.hasChildren() || !term.hasNonConstructChild()) && !term.getElement().isEmpty()) {
				builder.add(new Atom(Predicate.CHILD.toString() + "_" + viewName, getParentBlockCreatedNode(term),
						term.getCreatedNode(), term.getElement().toTerm(), Utils.toTerm(DataType.OBJECT.toString())));
			}
		} else {
			if (term.hasParent() && term.getParent().hasParent()) {
				builder.add(new Atom(Predicate.CHILD.toString() + "_" + viewName, getParentBlockCreatedNode(term),
						term.getCreatedNode(), term.getElement().toTerm(), Utils.toTerm(DataType.OBJECT.toString())));
			}
		}
		if (!term.getElement().isEmpty()) {
			builder.add(new Atom(Predicate.TAG.toString() + "_" + viewName, term.getCreatedNode(),
					term.getElement().toTerm()));
		}
	}

	@Override
	public void visit(final ReturnVariableTerm term) {
		if (isRootBlock() && builder.build().isEmpty()) {
			buildRootElement(term.getCreatedNode());
		} else {
			final Term parentCreatedNode = term.hasParent() ? getParentBlockCreatedNode(term.getParent())
					: getParentBlockCreatedNode(term);
			builder.add(new Atom(Predicate.CHILD.toString() + "_" + viewName, parentCreatedNode, term.getCreatedNode(),
					Utils.isObject(term) ? getParentBlockElement(term).toTerm()
							: arrayElementFactory.getElement(term),
					Utils.getDataType(term)));
		}
	}

	@Override
	public void visit(final ReturnStringTerm term) {
		if (isRootBlock() && builder.build().isEmpty()) {
			buildRootElement(term.toTerm());
		} else {
			final Term parentCreatedNode = term.hasParent() ? getParentBlockCreatedNode(term.getParent())
					: getParentBlockCreatedNode(term);
			builder.add(new Atom(Predicate.CHILD.toString() + "_" + viewName, parentCreatedNode, term.toTerm(),
					Utils.isObject(term) ? getParentBlockElement(term).toTerm()
							: arrayElementFactory.getElement(term),
					Utils.getDataType(term)));
		}
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
		return (isChildBlock() ? parentBlockCreatedNode : rootElementCreatedNode);
	}

	private void buildRootElement(final Term var) {
		rootElementCreatedNode = var;
		builder.add(new Atom(viewName, rootElementCreatedNode));
	}
}