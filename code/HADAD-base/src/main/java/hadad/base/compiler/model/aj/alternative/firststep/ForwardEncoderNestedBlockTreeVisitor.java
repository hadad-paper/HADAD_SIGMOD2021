package hadad.base.compiler.model.aj.alternative.firststep;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.constraints.Constraint;
import hadad.commons.constraints.Tgd;
import hadad.base.rewriter.Comment;
import hadad.base.compiler.Block;
import hadad.base.compiler.ChildBlock;
import hadad.base.compiler.QueryBlockTree;
import hadad.base.compiler.QueryBlockTreeVisitor;
import hadad.base.compiler.RootBlock;
import hadad.base.compiler.model.aj.AJExtractVariableToCreatedNodeVisitor;
import hadad.base.compiler.model.aj.Utils;

@Singleton
class ForwardEncoderNestedBlockTreeVisitor implements QueryBlockTreeVisitor {
	private final AJExtractVariableToCreatedNodeVisitor aJExtractVariableToCreatedNodeVisitor;
	private final BlockForwardStructureEncoderReturnTermVisitor blockForwardStructureEncoderReturnTermVisitor;
	private final BlockForwardTagsEncoderReturnTermVisitor blockForwardTagsEncoderReturnTermVisitor;

	private ImmutableList.Builder<Constraint> builder;
	private boolean includeComments;

	@Inject
	public ForwardEncoderNestedBlockTreeVisitor(
			final AJExtractVariableToCreatedNodeVisitor aJExtractVariableToCreatedNodeVisitor,
			final BlockForwardStructureEncoderReturnTermVisitor blockForwardStructureEncoderReturnTermVisitor,
			final BlockForwardTagsEncoderReturnTermVisitor blockForwardTagsEncoderReturnTermVisitor) {
		this.aJExtractVariableToCreatedNodeVisitor = aJExtractVariableToCreatedNodeVisitor;
		this.blockForwardStructureEncoderReturnTermVisitor = blockForwardStructureEncoderReturnTermVisitor;
		this.blockForwardTagsEncoderReturnTermVisitor = blockForwardTagsEncoderReturnTermVisitor;
	}

	public List<Constraint> compileConstraints(final QueryBlockTree nbt, boolean includeComments) {
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
			if (includeComments) {
				builder.add(new Comment(block.getId() + " constraint for extract"));
			}
			builder.add(getConstraintForExtract(block));
		}
		if (includeComments) {
			builder.add(new Comment(block.getId() + " constraint relating extract with create"));
		}
		builder.add(getConstraintRelatingExtractWithCreate(block));
		if (!block.getPattern().isEmpty()) {
			final Constraint constraintConnectingCreateToJSONConstructedByView = getConstraintConnectingCreateToJSONConstructedByView(block);
			if (constraintConnectingCreateToJSONConstructedByView != null) {
				if (includeComments) {
					builder.add(new Comment(block.getId() + " constraint connecting create to JSON constructed by view"));
				}
				builder.add(constraintConnectingCreateToJSONConstructedByView);
			}
			final List<Constraint> skolemFunctions = getConstraintForSkolemFunctions(block);
			if (includeComments && !skolemFunctions.isEmpty()) {
				builder.add(new Comment(block.getId() + " constraints for skolem functions"));
			}
			builder.addAll(skolemFunctions);
		}
	}

	@Override
	public void visit(final ChildBlock block) {
		if (includeComments) {
			builder.add(new Comment(block.getId() + " constraint for extract"));
		}
		builder.add(getConstraintForExtract(block));
		if (includeComments) {
			builder.add(new Comment(block.getId() + " constraint relating extract with create"));
		}
		builder.add(getConstraintRelatingExtractWithCreate(block));
		if (includeComments) {
			builder.add(new Comment(block.getId() + " constraint connecting create to JSON constructed by view"));
		}
		builder.addAll(getConstraintConnectingCreateToJSONConstructedByView(block));
		final List<Constraint> skolemFunctions = getConstraintForSkolemFunctions(block);
		if (includeComments && !skolemFunctions.isEmpty()) {
			builder.add(new Comment(block.getId() + " constraints for skolem functions"));
		}
		builder.addAll(skolemFunctions);
	}

	private Constraint getConstraintForExtract(final RootBlock block) {
		final List<Atom> premise = new ArrayList<Atom>();
		premise.addAll(block.getPattern().encoding(Utils.conditionEncoding));
		final List<Atom> conclusion = new ArrayList<Atom>();
		conclusion.add(Utils.getExtractAtom(block));
		return new Tgd(premise, conclusion);
	}

	private Constraint getConstraintForExtract(final ChildBlock block) {
		final List<Atom> premise = new ArrayList<Atom>();
		if (!block.getParent().getPattern().isEmpty()) {
			premise.add(Utils.getExtractAtom(block.getParent()));
		}
		premise.addAll(block.getPattern().encoding(Utils.conditionEncoding));
		final List<Atom> conclusion = new ArrayList<Atom>();
		conclusion.add(Utils.getExtractAtom(block));
		return new Tgd(premise, conclusion);
	}

	private Constraint getConstraintRelatingExtractWithCreate(final Block block) {
		final String queryName = block.getQueryName();
		final List<Atom> premise = new ArrayList<Atom>();
		if (!block.getPattern().isEmpty()) {
			premise.add(Utils.getExtractAtom(block));
		}
		final List<Atom> conclusion = new ArrayList<Atom>();
		conclusion.addAll(aJExtractVariableToCreatedNodeVisitor.encode(
				block.getReturnTemplate(), queryName));
		conclusion.add(Utils.getCreateAtom(block));
		if (!block.getPattern().isEmpty()) {
			for (final Atom skolemFunction : Utils.getSkolemFunctions(block)) {
				conclusion.add(skolemFunction);
			}
		}
		return new Tgd(premise, conclusion);
	}

	private Constraint getConstraintConnectingCreateToJSONConstructedByView(
			final RootBlock block) {
		final List<Atom> premise = new ArrayList<Atom>();
		premise.add(Utils.getCreateAtom(block));
		final List<Atom> conclusion = blockForwardTagsEncoderReturnTermVisitor
				.encode(block.getReturnTemplate(), block.getQueryName());
		if (conclusion.isEmpty()) {
			return null;
		} else {
			return new Tgd(premise, conclusion);
		}
	}

	private List<Constraint> getConstraintConnectingCreateToJSONConstructedByView(
			final ChildBlock block) {
		final List<Atom> premise1 = new ArrayList<Atom>();
		premise1.add(Utils.getCreateAtom(block.getParent()));
		premise1.add(Utils.getCreateAtom(block));
		if (!block.getParent().getPattern().isEmpty()) {
			premise1.add(Utils.getParentCreateSkolemFunction(block));
		}
		premise1.addAll(Utils.getSkolemFunctions(block));
		final List<Atom> conclusion1 = blockForwardStructureEncoderReturnTermVisitor
				.encode(block.getCreatedNode(), block.getReturnTemplate(),
						block.getQueryName());

		final List<Atom> premise2 = new ArrayList<Atom>();
		premise2.add(Utils.getCreateAtom(block));
		final List<Atom> conclusion2 = blockForwardTagsEncoderReturnTermVisitor
				.encode(block.getReturnTemplate(), block.getQueryName());

		final List<Constraint> constraints = new ArrayList<Constraint>();
		if (!conclusion1.isEmpty()) {
			constraints.add(new Tgd(premise1, conclusion1));
		}
		if (!conclusion2.isEmpty()) {
			constraints.add(new Tgd(premise2, conclusion2));
		}
		return constraints;
	}

	private List<Constraint> getConstraintForSkolemFunctions(final Block block) {
		final List<Constraint> constraints = new ArrayList<Constraint>();
		return constraints;
	}
}