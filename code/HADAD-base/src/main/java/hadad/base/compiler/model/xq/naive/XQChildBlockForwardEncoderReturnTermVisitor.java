package hadad.base.compiler.model.xq.naive;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.Variable;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.ReturnTerm;

@Singleton
public class XQChildBlockForwardEncoderReturnTermVisitor extends XQBaseForwardEncoderReturnTermVisitor {
	private Variable parentBlockCreatedNode;

	@Inject
	public XQChildBlockForwardEncoderReturnTermVisitor() {
		super();
	}

	public List<Atom> encode(final Variable parentBlockCreatedNode, final ReturnTemplate template,
	        final String viewName) {
		builder = ImmutableList.builder();
		this.parentBlockCreatedNode = parentBlockCreatedNode;
		this.viewName = viewName;
		template.accept(this);
		return builder.build();
	}

	@Override
	protected Variable getParentBlockCreatedNode(final ReturnTerm term) {
		return term.hasParent() ? term.getParent().getCreatedNode() : parentBlockCreatedNode;
	}
}