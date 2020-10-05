package hadad.base.compiler.model.pj.naive;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.Term;
import hadad.base.compiler.Element;
import hadad.base.compiler.ReturnConstructTerm;
import hadad.base.compiler.ReturnStringTerm;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.ReturnTemplateVisitor;
import hadad.base.compiler.ReturnTerm;
import hadad.base.compiler.ReturnVariableTerm;
import hadad.base.compiler.model.pj.ArrayElementFactory;
import hadad.base.compiler.model.pj.DataType;
import hadad.base.compiler.model.pj.Predicate;
import hadad.base.compiler.model.pj.Utils;

abstract class PJBaseForwardEncoderReturnTermVisitor implements
		ReturnTemplateVisitor {
	protected final ArrayElementFactory arrayElementFactory;
	protected ImmutableList.Builder<Atom> builder;
	protected String viewName;

	@Inject
	public PJBaseForwardEncoderReturnTermVisitor(final ArrayElementFactory arrayElementFactory) {
		this.arrayElementFactory = arrayElementFactory;
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
		
	}

	@Override
	public void visit(final ReturnVariableTerm term) {
		builder.add(new Atom(Predicate.CHILD.toString() + "_" + viewName,
				getParentBlockCreatedNode(term), term.getCreatedNode(),
				Utils.isObject(term) ? getParentBlockElement(term).toTerm()
						: arrayElementFactory.getElement(term),
				Utils.getDataType(term)));
	}

	@Override
	public void visit(final ReturnStringTerm term) {
		builder.add(new Atom(Predicate.CHILD.toString() + "_" + viewName,
				getParentBlockCreatedNode(term), term.toTerm(),
				Utils.isObject(term) ? getParentBlockElement(term).toTerm()
						: arrayElementFactory.getElement(term),
				Utils.getDataType(term)));
	}

	protected abstract Element getParentBlockElement(final ReturnTerm term);

	protected abstract Term getParentBlockCreatedNode(final ReturnTerm term);
}