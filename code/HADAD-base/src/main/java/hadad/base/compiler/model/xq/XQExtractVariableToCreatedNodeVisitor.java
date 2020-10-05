package hadad.base.compiler.model.xq;

import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.Variable;
import hadad.base.compiler.ReturnConstructTerm;
import hadad.base.compiler.ReturnLeafTerm;
import hadad.base.compiler.ReturnStringTerm;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.ReturnTemplateVisitor;
import hadad.base.compiler.ReturnVariableTerm;
import hadad.base.compiler.VariableCopier;

@Singleton
public class XQExtractVariableToCreatedNodeVisitor implements
		ReturnTemplateVisitor {
	private final VariableCopier variableCopier;
	private ImmutableList.Builder<Atom> builder;
	private String queryName;
	private Set<Variable> copiedVariables;

	@Inject
	public XQExtractVariableToCreatedNodeVisitor(
			final VariableCopier variableCopier) {
		this.variableCopier = variableCopier;
	}

	public List<Atom> encode(final ReturnTemplate template,
			final String queryName) {
		builder = ImmutableList.builder();
		this.queryName = queryName;
		copiedVariables = new HashSet<Variable>();
		template.accept(this);
		return builder.build();
	}

	@Override
	public void visit(final ReturnTemplate template) {
		// NOP (no encoding for the template optionals)
	}

	@Override
	public void visitPre(final ReturnConstructTerm term) {
		for (final Entry<String, ReturnLeafTerm> attr : term.getAttributes()
				.entrySet()) {
			if (attr.getValue() instanceof ReturnVariableTerm) {
				((ReturnVariableTerm) attr.getValue()).accept(this);
				builder.add(new Atom(Predicate.HAS_ATTRIBUTE_VALUE.toString()
						+ "_" + queryName,
						term.getCreatedNode(), Utils.toTerm(attr.getKey()),
						variableCopier.getCopy(((ReturnVariableTerm) attr
								.getValue()).getVariable())));
			} else if (attr.getValue() instanceof ReturnStringTerm) {
				builder.add(new Atom(Predicate.HAS_ATTRIBUTE_VALUE.toString()
						+ "_" + queryName,
						term.getCreatedNode(), Utils.toTerm(attr.getKey()),
						attr.getValue().toTerm()));
			} else {
				throw new IllegalStateException(
						"The return leaf term is not supported.");
			}
		}
	}

	@Override
	public void visitPost(final ReturnConstructTerm term) {
		// NOP (no encoding after the children are processed)
	}

	@Override
	public void visit(final ReturnVariableTerm term) {
		if (!copiedVariables.contains(term.getVariable())) {
			copiedVariables.add(term.getVariable());
			builder.add(new Atom(Predicate.COPY.toString() + "_" + queryName,
					term.toTerm(), variableCopier.getCopy(term.getVariable())));
		}
	}

	@Override
	public void visit(ReturnStringTerm term) {
		// NOP (no encoding for string terms)
	}
}