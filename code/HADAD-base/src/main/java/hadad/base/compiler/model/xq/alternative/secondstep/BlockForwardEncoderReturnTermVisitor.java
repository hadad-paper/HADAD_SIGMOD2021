package hadad.base.compiler.model.xq.alternative.secondstep;

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
import hadad.base.compiler.ReturnTemplateVisitor;
import hadad.base.compiler.ReturnTerm;
import hadad.base.compiler.ReturnVariableTerm;
import hadad.base.compiler.VariableFactory;
import hadad.base.compiler.model.xq.Predicate;
import hadad.base.compiler.model.xq.Utils;

@Singleton
final class BlockForwardEncoderReturnTermVisitor implements
		ReturnTemplateVisitor {
	private final VariableFactory elementVariableFactory;
	private ImmutableList.Builder<Atom> builder;
	private String viewName;
	private Variable parentBlockCreatedNode;
	private Term rootElementCreatedNode;

	@Inject
	public BlockForwardEncoderReturnTermVisitor(
			@Named("ElementVariableFactory") final VariableFactory elementVariableFactory) {
		this.elementVariableFactory = elementVariableFactory;
	}

	public List<Atom> encode(final Variable parentBlockCreatedNode,
			final ReturnTemplate template, final String viewName) {
		return _encode(parentBlockCreatedNode, template,
				viewName);
	}

	public List<Atom> encode(final ReturnTemplate template,
			final String viewName) {
		return _encode(null, template, viewName);
	}

	private List<Atom> _encode(final Variable parentBlockCreatedNode,
			final ReturnTemplate template, final String viewName) {
		builder = ImmutableList.builder();
		this.parentBlockCreatedNode = parentBlockCreatedNode;
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
		if (isRootBlock() && builder.build().isEmpty()) {
			buildRootElement(term.getCreatedNode());
		}
		if (isRootBlock() || (isChildBlock() && term.hasParent())) {
			builder.add(new Atom(Predicate.CHILD.toString() + "_" + viewName,
					getParentBlockCreatedNode(term), term.getCreatedNode()));
		}
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
		if (builder.build().isEmpty()) {
			if (Utils.isText(term)) {
				final Variable var = elementVariableFactory.createFreshVar();
				if (isRootBlock()) {
					buildRootElement(var);
				} else {
					builder.add(new Atom(Predicate.CHILD.toString() + "_"
							+ viewName, getParentBlockCreatedNode(term), var));
				}
				builder.add(new Atom(
						Predicate.TEXT.toString() + "_" + viewName, var, term
								.getCreatedNode()));
			} else {
				if (isRootBlock()) {
					buildRootElement(term.getCreatedNode());
				} else {
					builder.add(new Atom(Predicate.CHILD.toString() + "_"
							+ viewName, getParentBlockCreatedNode(term), term
							.getCreatedNode()));
				}
			}
		}
	}

	@Override
	public void visit(final ReturnStringTerm term) {
		if (builder.build().isEmpty()) {
			final Variable var = elementVariableFactory.createFreshVar();
			if (isRootBlock()) {
				buildRootElement(var);
			} else {
				builder.add(new Atom(Predicate.CHILD.toString() + "_"
						+ viewName, getParentBlockCreatedNode(term), var));
			}
			builder.add(new Atom(Predicate.TEXT.toString() + "_" + viewName,
					var, term.toTerm()));
		}
	}

	private Term getParentBlockCreatedNode(final ReturnTerm term) {
		return term.hasParent() ? term.getParent().getCreatedNode()
				: (isChildBlock() ? parentBlockCreatedNode
						: rootElementCreatedNode);
	}

	private void buildRootElement(final Term var) {
		rootElementCreatedNode = var;
		builder.add(new Atom(viewName, rootElementCreatedNode));
	}
}