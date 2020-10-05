package hadad.base.compiler.model.xq.naive;

import java.util.Map.Entry;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.Term;
import hadad.base.compiler.ReturnConstructTerm;
import hadad.base.compiler.ReturnLeafTerm;
import hadad.base.compiler.ReturnStringTerm;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.ReturnTemplateVisitor;
import hadad.base.compiler.ReturnTerm;
import hadad.base.compiler.ReturnVariableTerm;
import hadad.base.compiler.model.xq.Predicate;
import hadad.base.compiler.model.xq.Utils;

abstract class XQBaseForwardEncoderReturnTermVisitor implements
		ReturnTemplateVisitor {
	protected ImmutableList.Builder<Atom> builder;
	protected String viewName;

	@Inject
	public XQBaseForwardEncoderReturnTermVisitor() {
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
		builder.add(new Atom(Predicate.CHILD.toString() + "_" + viewName,
				getParentBlockCreatedNode(term), term.getCreatedNode()));
		builder.add(new Atom(Predicate.TAG.toString() + "_" + viewName, term
				.getCreatedNode(), term.getElement().toTerm()));
		for (final Entry<String, ReturnLeafTerm> attr : term.getAttributes()
				.entrySet()) {
			builder.add(new Atom(Predicate.HAS_ATTRIBUTE.toString() + "_"
					+ viewName, term.getCreatedNode(), Utils.toTerm(attr
					.getKey())));
		}
	}

	@Override
	public void visit(final ReturnVariableTerm term) {
		final Predicate predicate = Utils.isText(term) ? Predicate.TEXT
				: Predicate.CHILD;
		builder.add(new Atom(predicate.toString() + "_" + viewName,
				getParentBlockCreatedNode(term), term.getCreatedNode()));
	}

	@Override
	public void visit(final ReturnStringTerm term) {
		builder.add(new Atom(Predicate.TEXT.toString() + "_" + viewName,
				getParentBlockCreatedNode(term), term.toTerm()));
	}

	protected abstract Term getParentBlockCreatedNode(final ReturnTerm term);
}