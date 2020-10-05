package hadad.base.compiler.model.xq.alternative.secondstep;

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
import hadad.base.compiler.model.xq.Predicate;

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
		if (isChildBlock() && !term.hasParent()) {
			builder.add(new Atom(Predicate.CHILD.toString() + "_" + viewName,
					getParentBlockCreatedNode(term), term.getCreatedNode()));
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
		return term.hasParent() ? term.getParent().getCreatedNode()
				: parentBlockCreatedNode;
	}
}