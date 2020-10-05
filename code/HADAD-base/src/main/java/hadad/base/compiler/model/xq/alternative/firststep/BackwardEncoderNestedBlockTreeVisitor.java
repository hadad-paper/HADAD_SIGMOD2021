package hadad.base.compiler.model.xq.alternative.firststep;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.constraints.Constraint;
import hadad.commons.constraints.Tgd;
import hadad.base.compiler.Block;
import hadad.base.compiler.ChildBlock;
import hadad.base.compiler.QueryBlockTree;
import hadad.base.compiler.QueryBlockTreeVisitor;
import hadad.base.compiler.RootBlock;
import hadad.base.compiler.model.xq.XQExtractVariableToCreatedNodeVisitor;
import hadad.base.compiler.model.xq.Utils;
import hadad.base.rewriter.Comment;

@Singleton
class BackwardEncoderNestedBlockTreeVisitor implements QueryBlockTreeVisitor {
	private final XQExtractVariableToCreatedNodeVisitor xQExtractVariableToCreatedNodeVisitor;
	private final BlockBackwardEncoderReturnTermVisitor blockBackwardEncoderReturnTermVisitor;
	private final String skolemFunctionVariableCopySuffix;

	private ImmutableList.Builder<Constraint> builder;
	private boolean includeComments;

	@Inject
	public BackwardEncoderNestedBlockTreeVisitor(
			final XQExtractVariableToCreatedNodeVisitor xQExtractVariableToCreatedNodeVisitor,
			@Named("skolem_function_variable_copy_suffix") final String skolemFunctionVariableCopySuffix,
			final BlockBackwardEncoderReturnTermVisitor blockBackwardEncoderReturnTermVisitor) {
		this.xQExtractVariableToCreatedNodeVisitor = xQExtractVariableToCreatedNodeVisitor;
		this.blockBackwardEncoderReturnTermVisitor = blockBackwardEncoderReturnTermVisitor;
		this.skolemFunctionVariableCopySuffix = skolemFunctionVariableCopySuffix;
	}

	public List<Constraint> compileConstraints(final QueryBlockTree nbt,
			boolean includeComments) {
		builder = ImmutableList.builder();
		this.includeComments = includeComments;
		nbt.accept(this);
		return builder.build();
	}

	@Override
	public void visit(final QueryBlockTree tree) {
		// TODO Auto-generated method stub
	}

	@Override
	public void visit(final RootBlock block) {
		if (!block.getPattern().isEmpty()) {
			final List<Constraint> skolemFunctions = Utils
					.getConstraintForSkolemFunctions(block,
							skolemFunctionVariableCopySuffix);
			if (includeComments && !skolemFunctions.isEmpty()) {
				builder.add(new Comment(block.getId()
						+ " constraints for skolem functions"));
			}
			builder.addAll(skolemFunctions);
		}
		if (includeComments) {
			builder.add(new Comment(block.getId()
					+ " constraint connecting create to XML constructed by view"));
		}
		builder.add(getConstraintConnectingCreateToXMLConstructedByView(block));
		if (!block.getPattern().isEmpty()) {
			if (includeComments) {
				builder.add(new Comment(block.getId()
						+ " constraint relating extract with create"));
			}
			builder.add(getConstraintRelatingExtractWithCreate(block));
			if (includeComments) {
				builder.add(new Comment(block.getId() + " constraint for extract"));
			}
			builder.add(getConstraintForExtract(block));
		}
	}

	@Override
	public void visit(final ChildBlock block) {
		final List<Constraint> skolemFunctions = Utils
				.getConstraintForSkolemFunctions(block,
						skolemFunctionVariableCopySuffix);
		if (includeComments && !skolemFunctions.isEmpty()) {
			builder.add(new Comment(block.getId() + " constraints for skolem functions"));
		}
		builder.addAll(skolemFunctions);
		if (includeComments) {
			builder.add(new Comment(block.getId()
				+ " constraint connecting create to XML constructed by view"));
		}
		builder.add(getConstraintConnectingCreateToXMLConstructedByView(block));
		if (includeComments) {
			builder.add(new Comment(block.getId()
				+ " constraint relating extract with create"));
		}
		builder.add(getConstraintRelatingExtractWithCreate(block));
		if (includeComments) {
			builder.add(new Comment(block.getId() + " constraint for extract"));
		}
		builder.add(getConstraintForExtract(block));
	}

	private Constraint getConstraintForExtract(final RootBlock block) {
		final List<Atom> premise = new ArrayList<Atom>();
		premise.add(Utils.getExtractAtom(block));
		final List<Atom> conclusion = new ArrayList<Atom>();
		conclusion.addAll(block.getPattern().encoding(Utils.conditionEncoding));
		return new Tgd(premise, conclusion);
	}

	private Constraint getConstraintForExtract(final ChildBlock block) {
		final List<Atom> premise = new ArrayList<Atom>();
		premise.add(Utils.getExtractAtom(block));
		final List<Atom> conclusion = new ArrayList<Atom>();
		if (!block.getParent().getPattern().isEmpty()) {
			conclusion.add(Utils.getExtractAtom(block.getParent()));
		}
		conclusion.addAll(block.getPattern().encoding(Utils.conditionEncoding));
		return new Tgd(premise, conclusion);
	}

	private Constraint getConstraintRelatingExtractWithCreate(final Block block) {
		final String queryName = block.getQueryName();
		final List<Atom> premise = new ArrayList<Atom>();
		premise.add(Utils.getCreateAtom(block));
		for (final Atom skolemFunction : Utils.getSkolemFunctions(block)) {
			premise.add(skolemFunction);
		}
		final List<Atom> conclusion = new ArrayList<Atom>();
		conclusion.addAll(xQExtractVariableToCreatedNodeVisitor.encode(
				block.getReturnTemplate(), queryName));
		conclusion.add(Utils.getExtractAtom(block));
		return new Tgd(premise, conclusion);
	}

	private Constraint getConstraintConnectingCreateToXMLConstructedByView(
			final RootBlock block) {
		final List<Atom> premise = new ArrayList<Atom>();
		premise.add(Utils.getCreateAtom(block));

		final List<Atom> conclusion = new ArrayList<Atom>();
		conclusion.addAll(Utils.getSkolemFunctions(block));
		return new Tgd(premise, conclusion);
	}

	private Constraint getConstraintConnectingCreateToXMLConstructedByView(
			final ChildBlock block) {
		final List<Atom> premise = new ArrayList<Atom>();
		premise.add(Utils.getCreateAtom(block.getParent()));
		if (!block.getParent().getPattern().isEmpty()) {
			premise.add(Utils.getParentCreateSkolemFunction(block));
		}
		premise.addAll(blockBackwardEncoderReturnTermVisitor.encode(block
				.getPattern().getDefinitions(), block.getCreatedNode(), block
				.getReturnTemplate(), block.getQueryName()));

		final List<Atom> conclusion = new ArrayList<Atom>();
		conclusion.add(Utils.getCreateAtom(block));
		conclusion.addAll(Utils.getSkolemFunctions(block));

		return new Tgd(premise, conclusion);
	}
}