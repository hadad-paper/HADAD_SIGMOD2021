package hadad.base.compiler.model.xq.alternative.firststep;

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
import hadad.base.compiler.model.xq.Utils;

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
		if (!term.hasParent()) {
			builder.add(new Atom(Predicate.CHILD.toString() + "_" + viewName,
					getParentBlockCreatedNode(term), term.getCreatedNode()));
		}
	}

	@Override
	public void visit(final ReturnVariableTerm term) {
		if (!term.hasParent()) {
			final Predicate predicate = Utils.isText(term) ? Predicate.TEXT
					: Predicate.CHILD;
			builder.add(new Atom(predicate.toString() + "_" + viewName,
					getParentBlockCreatedNode(term), term.getCreatedNode()));
		}
	}

	@Override
	public void visit(final ReturnStringTerm term) {
		if (!term.hasParent()) {
			builder.add(new Atom(Predicate.TEXT.toString() + "_" + viewName,
					getParentBlockCreatedNode(term), term.toTerm()));
		}
	}

	private Variable getParentBlockCreatedNode(final ReturnTerm term) {
		return term.hasParent() ? term.getParent().getCreatedNode()
				: parentBlockCreatedNode;
	}
}