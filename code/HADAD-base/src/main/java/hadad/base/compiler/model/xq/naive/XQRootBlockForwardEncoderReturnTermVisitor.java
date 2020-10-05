package hadad.base.compiler.model.xq.naive;

import java.util.List;
import java.util.Map.Entry;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.Term;
import hadad.commons.conjunctivequery.Variable;
import hadad.base.compiler.ReturnConstructTerm;
import hadad.base.compiler.ReturnLeafTerm;
import hadad.base.compiler.ReturnStringTerm;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.ReturnTerm;
import hadad.base.compiler.ReturnVariableTerm;
import hadad.base.compiler.VariableFactory;
import hadad.base.compiler.model.xq.Predicate;
import hadad.base.compiler.model.xq.Utils;

@Singleton
public class XQRootBlockForwardEncoderReturnTermVisitor extends XQBaseForwardEncoderReturnTermVisitor {
	private final VariableFactory	elementVariableFactory;
	private Term					rootElementCreatedNode;

	@Inject
	public XQRootBlockForwardEncoderReturnTermVisitor(
	        @Named("ElementVariableFactory") final VariableFactory elementVariableFactory) {
		super();
		this.elementVariableFactory = elementVariableFactory;
	}

	public List<Atom> encode(final ReturnTemplate template, final String viewName) {
		builder = ImmutableList.builder();
		this.viewName = viewName;
		template.accept(this);
		return builder.build();
	}

	@Override
	public void visitPre(final ReturnConstructTerm term) {
		if (builder.build().isEmpty()) {
			buildRootElement(term.getCreatedNode());
			builder.add(new Atom(Predicate.TAG.toString() + "_" + viewName, term.getCreatedNode(),
			        term.getElement().toTerm()));
			for (final Entry<String, ReturnLeafTerm> attr : term.getAttributes().entrySet()) {
				builder.add(new Atom(Predicate.HAS_ATTRIBUTE.toString() + "_" + viewName, term.getCreatedNode(),
				        Utils.toTerm(attr.getKey())));
			}
		} else {
			super.visitPre(term);
		}
	}

	@Override
	public void visit(final ReturnVariableTerm term) {
		if (builder.build().isEmpty()) {
			if (Utils.isText(term)) {
				final Variable var = elementVariableFactory.createFreshVar();
				buildRootElement(var);
				builder.add(new Atom(Predicate.TEXT.toString() + "_" + viewName, var, term.getCreatedNode()));
			} else {
				buildRootElement(term.getCreatedNode());
			}
		} else {
			super.visit(term);
		}
	}

	@Override
	public void visit(final ReturnStringTerm term) {
		if (builder.build().isEmpty()) {
			final Variable var = elementVariableFactory.createFreshVar();
			buildRootElement(var);
			builder.add(new Atom(Predicate.TEXT.toString() + "_" + viewName, var, term.toTerm()));
		} else {
			super.visit(term);
		}
	}

	@Override
	protected Term getParentBlockCreatedNode(final ReturnTerm term) {
		return term.hasParent() ? term.getParent().getCreatedNode() : rootElementCreatedNode;
	}

	private void buildRootElement(final Term var) {
		rootElementCreatedNode = var;
		builder.add(new Atom(viewName, rootElementCreatedNode));
	}
}