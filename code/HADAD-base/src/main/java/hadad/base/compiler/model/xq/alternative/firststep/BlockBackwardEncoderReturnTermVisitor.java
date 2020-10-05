package hadad.base.compiler.model.xq.alternative.firststep;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableList;
import com.google.inject.Singleton;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.Term;
import hadad.commons.conjunctivequery.Variable;
import hadad.base.compiler.PathExpression;
import hadad.base.compiler.ReturnConstructTerm;
import hadad.base.compiler.ReturnStringTerm;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.ReturnTemplateVisitor;
import hadad.base.compiler.ReturnTerm;
import hadad.base.compiler.ReturnVariableTerm;
import hadad.base.compiler.model.xq.Predicate;
import hadad.base.compiler.model.xq.Utils;

@Singleton
final class BlockBackwardEncoderReturnTermVisitor implements
		ReturnTemplateVisitor {
	private Map<Variable, PathExpression> definitions;
	private ImmutableList.Builder<Atom> builder;
	private String viewName;
	private Variable parentBlockCreatedNode;

	public List<Atom> encode(final Map<Variable, PathExpression> definitions,
			final Variable parentBlockCreatedNode,
			final ReturnTemplate template, final String viewName) {
		builder = ImmutableList.builder();
		this.definitions = definitions;
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
		if (builder.build().isEmpty()) {
			if (isChildBlock()) {
				builder.add(new Atom(Predicate.CHILD.toString() + "_"
						+ viewName, getParentBlockCreatedNode(term), term
						.getCreatedNode()));
			}
			builder.add(new Atom(Predicate.TAG.toString() + "_" + viewName,
					term
				.getCreatedNode(), term.getElement().toTerm()));
		}
	}

	@Override
	public void visit(final ReturnVariableTerm term) {
		if (builder.build().isEmpty()) {
			if (Utils.isText(term)) {
				builder.add(new Atom(
						Predicate.TEXT.toString() + "_" + viewName,
					getParentBlockCreatedNode(term), term.getCreatedNode()));
			} else {
				final List<Atom> tags = definitions
						.get(term.getVariable())
						.encoding()
						.stream()
						.filter(c -> c.getPredicate().equals(
								Predicate.TAG.toString())
								&& c.getTerm(0).equals(term.getVariable()))
						.collect(Collectors.toList());

				if (tags.size() != 1) {
					throw new IllegalStateException(
							"Tag atom not found for the variable.");
				}
				if (isChildBlock()) {
					builder.add(new Atom(Predicate.CHILD.toString() + "_"
							+ viewName, getParentBlockCreatedNode(term), term
							.getCreatedNode()));
				}
				builder.add(new Atom(Predicate.TAG.toString() + "_" + viewName,
					term.getCreatedNode(), tags.get(0).getTerm(1)));
			}
		}
	}

	@Override
	public void visit(final ReturnStringTerm term) {
		if (builder.build().isEmpty()) {
			builder.add(new Atom(Predicate.TEXT.toString() + "_" + viewName,
					getParentBlockCreatedNode(term), term.toTerm()));
		}
	}

	private Term getParentBlockCreatedNode(final ReturnTerm term) {
		return term.hasParent() ? term.getParent().getCreatedNode()
				: parentBlockCreatedNode;
	}
}