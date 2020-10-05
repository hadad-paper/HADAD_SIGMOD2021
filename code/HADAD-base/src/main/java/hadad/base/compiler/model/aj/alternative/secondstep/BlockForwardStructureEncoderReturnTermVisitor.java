package hadad.base.compiler.model.aj.alternative.secondstep;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.inject.Singleton;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.Variable;
import hadad.base.compiler.ReturnConstructTerm;
import hadad.base.compiler.ReturnStringTerm;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.ReturnTemplateVisitor;
import hadad.base.compiler.ReturnTerm;
import hadad.base.compiler.ReturnVariableTerm;
import hadad.base.compiler.model.aj.DataType;
import hadad.base.compiler.model.aj.Predicate;
import hadad.base.compiler.model.aj.Utils;

@Singleton
class BlockForwardStructureEncoderReturnTermVisitor implements
		ReturnTemplateVisitor {
	private ImmutableList.Builder<Atom> builder;
	private String viewName;

	private Variable parentBlockCreatedNode;

	public List<Atom> encode(final Variable parentBlockCreatedNode,
			final ReturnTemplate template, final String viewName) {
		builder = ImmutableList.builder();
		this.parentBlockCreatedNode = parentBlockCreatedNode;
		this.viewName = viewName;
		template.accept(this);
		return builder.build();
	}

	public List<Atom> encode(final ReturnTemplate template,
			final String viewName) {
		builder = ImmutableList.builder();
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
		if (isChildBlock() && term.hasParent() && !term.getParent().hasParent()
					&& term.getParent().getElement().isEmpty()) {
			builder.add(new Atom(Predicate.CHILD.toString() + "_" + viewName,
					getParentBlockCreatedNode(term), term.getCreatedNode(),
					term.getElement().toTerm(), Utils.toTerm(DataType.OBJECT
							.toString())));
		}
	}

	@Override
	public void visit(final ReturnVariableTerm term) {
		// NOP
	}

	@Override
	public void visit(final ReturnStringTerm term) {
		// NOP
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