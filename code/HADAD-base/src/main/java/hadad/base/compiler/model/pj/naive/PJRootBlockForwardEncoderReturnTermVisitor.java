package hadad.base.compiler.model.pj.naive;

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
import hadad.base.compiler.ReturnTerm;
import hadad.base.compiler.ReturnVariableTerm;
import hadad.base.compiler.StringElement;
import hadad.base.compiler.VariableFactory;
import hadad.base.compiler.model.pj.ArrayElementFactory;

@Singleton
public class PJRootBlockForwardEncoderReturnTermVisitor extends PJBaseForwardEncoderReturnTermVisitor {
	private final VariableFactory elementVariableFactory;
	private Term rootElementCreatedNode;

	@Inject
	public PJRootBlockForwardEncoderReturnTermVisitor(final ArrayElementFactory arrayElementFactory,
			@Named("ElementVariableFactory") final VariableFactory elementVariableFactory) {
		super(arrayElementFactory);
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
		if (!term.getElement().isEmpty()) {
			if (builder.build().isEmpty()) {
				if (term.hasChildren()) {
					buildRootElement(term.getCreatedNode());
				} else {
					final Variable var = elementVariableFactory.createFreshVar();
					buildRootElement(var);
				}
			}
			super.visitPre(term);
		} else {
			if (builder.build().isEmpty()) {
				if (term.hasChildren()) {
					buildRootElement(term.getCreatedNode());
				}
			}
		}
	}

	@Override
	public void visit(final ReturnVariableTerm term) {
		if (builder.build().isEmpty()) {
			buildRootElement(term.getCreatedNode());
		} else {
			super.visit(term);
		}
	}

	@Override
	public void visit(final ReturnStringTerm term) {
		if (builder.build().isEmpty()) {
			buildRootElement(term.toTerm());
		} else {
			super.visit(term);
		}
	}

	@Override
	protected Element getParentBlockElement(final ReturnTerm term) {
		if (term.hasParent()) {
			if (!term.getParent().getElement().isEmpty()) {
				return term.getParent().getElement();
			} else {
				if (term.getParent().hasParent() && !term.getParent().getParent().getElement().isEmpty()) {
					return term.getParent().getParent().getElement();
				}
			}
		}
		return new StringElement("");
	}

	@Override
	protected Term getParentBlockCreatedNode(final ReturnTerm term) {
		if (term.hasParent()) {
			// TODO: test that we are not introducing a bug when the parent's
			// parent is not the root.
			if ((term instanceof ReturnVariableTerm || term instanceof ReturnStringTerm) && term.getParent().hasParent()
					&& term.getParent().getParent().getElement().isEmpty()) {
				return rootElementCreatedNode;
			}
			if (!term.getParent().getElement().isEmpty()) {
				return term.getParent().getCreatedNode();
			} else {
				if (term.getParent().hasParent() && !term.getParent().getParent().getElement().isEmpty()) {
					return term.getParent().getParent().getCreatedNode();
				}
			}
		}
		return rootElementCreatedNode;
	}

	private void buildRootElement(final Term var) {
		rootElementCreatedNode = var;
		builder.add(new Atom(viewName, rootElementCreatedNode));
	}
}