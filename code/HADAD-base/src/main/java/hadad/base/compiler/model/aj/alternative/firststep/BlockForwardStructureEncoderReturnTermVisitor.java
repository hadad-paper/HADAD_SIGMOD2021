package hadad.base.compiler.model.aj.alternative.firststep;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.Variable;
import hadad.base.compiler.Element;
import hadad.base.compiler.ReturnConstructTerm;
import hadad.base.compiler.ReturnStringTerm;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.ReturnTemplateVisitor;
import hadad.base.compiler.ReturnTerm;
import hadad.base.compiler.ReturnVariableTerm;
import hadad.base.compiler.StringElement;
import hadad.base.compiler.model.aj.ArrayElementFactory;
import hadad.base.compiler.model.aj.DataType;
import hadad.base.compiler.model.aj.Predicate;
import hadad.base.compiler.model.aj.Utils;

@Singleton
class BlockForwardStructureEncoderReturnTermVisitor implements
		ReturnTemplateVisitor {
	private final ArrayElementFactory arrayElementFactory;
	private ImmutableList.Builder<Atom> builder;
	private String viewName;

	private Variable parentBlockCreatedNode;

	@Inject
	public BlockForwardStructureEncoderReturnTermVisitor(
			final ArrayElementFactory arrayElementFactory) {
		this.arrayElementFactory = arrayElementFactory;
	}

	public List<Atom> encode(final Variable parentBlockCreatedNode,
			final ReturnTemplate template, final String viewName) {
		builder = ImmutableList.builder();
		this.parentBlockCreatedNode = parentBlockCreatedNode;
		this.viewName = viewName;
		template.accept(this);
		return builder.build();
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
		if (term.hasParent() && !term.getParent().hasParent()
				&& term.getParent().getElement().isEmpty()) {
			if (!term.getElement().isEmpty()
					&& (!term.hasChildren() || !term.hasNonConstructChild())) {
				builder.add(new Atom(Predicate.CHILD.toString() + "_"
						+ viewName, getParentBlockCreatedNode(term), term
						.getCreatedNode(), term.getElement().toTerm(), Utils
						.toTerm(DataType.OBJECT.toString())));
			}
		}
	}

	@Override
	public void visit(final ReturnVariableTerm term) {
		if (!term.hasParent()) {
			builder.add(new Atom(Predicate.CHILD.toString() + "_" + viewName,
					getParentBlockCreatedNode(term), term.getCreatedNode(),
					Utils.isObject(term) ? getParentBlockElement(term).toTerm()
							: arrayElementFactory.getElement(term),
					Utils.getDataType(term)));
		}
	}

	@Override
	public void visit(final ReturnStringTerm term) {
		if (!term.hasParent()) {
			builder.add(new Atom(Predicate.CHILD.toString() + "_" + viewName,
					getParentBlockCreatedNode(term), term.toTerm(),
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

	private Variable getParentBlockCreatedNode(final ReturnTerm term) {
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
		return parentBlockCreatedNode;
	}
}