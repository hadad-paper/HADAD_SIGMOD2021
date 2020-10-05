package hadad.base.compiler.model.aj.alternative.firststep;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.inject.Singleton;

import hadad.commons.conjunctivequery.Atom;
import hadad.base.compiler.ReturnConstructTerm;
import hadad.base.compiler.ReturnStringTerm;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.ReturnTemplateVisitor;
import hadad.base.compiler.ReturnVariableTerm;
import hadad.base.compiler.model.aj.Predicate;
@Singleton
class BlockForwardTagsEncoderReturnTermVisitor implements
		ReturnTemplateVisitor {
	private ImmutableList.Builder<Atom> builder;
	private String viewName;

	public List<Atom> encode(final ReturnTemplate template,
			final String viewName) {
		builder = ImmutableList.builder();
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
		if (!term.getElement().isEmpty()) {
			builder.add(new Atom(Predicate.TAG.toString() + "_" + viewName,
					term.getCreatedNode(), term.getElement().toTerm()));
		}
	}

	@Override
	public void visit(final ReturnVariableTerm term) {

	}

	@Override
	public void visit(final ReturnStringTerm term) {

	}
}