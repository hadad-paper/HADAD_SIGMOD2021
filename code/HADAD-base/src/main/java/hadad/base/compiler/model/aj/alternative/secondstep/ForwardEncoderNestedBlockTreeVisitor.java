package hadad.base.compiler.model.aj.alternative.secondstep;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.constraints.Constraint;
import hadad.commons.constraints.Tgd;
import hadad.base.rewriter.Comment;
import hadad.base.compiler.ChildBlock;
import hadad.base.compiler.QueryBlockTree;
import hadad.base.compiler.QueryBlockTreeVisitor;
import hadad.base.compiler.RootBlock;
import hadad.base.compiler.model.aj.Utils;

@Singleton
class ForwardEncoderNestedBlockTreeVisitor implements QueryBlockTreeVisitor {
	private final BlockForwardStructureEncoderReturnTermVisitor blockForwardStructureEncoderReturnTermVisitor;
	private final BlockForwardEncoderReturnTermVisitor blockForwardEncoderReturnTermVisitor;

	private ImmutableList.Builder<Constraint> builder;
	private boolean includeComments;

	@Inject
	public ForwardEncoderNestedBlockTreeVisitor(
			final BlockForwardStructureEncoderReturnTermVisitor blockForwardStructureEncoderReturnTermVisitor,
			final BlockForwardEncoderReturnTermVisitor blockForwardEncoderReturnTermVisitor) {
		this.blockForwardStructureEncoderReturnTermVisitor = blockForwardStructureEncoderReturnTermVisitor;
		this.blockForwardEncoderReturnTermVisitor = blockForwardEncoderReturnTermVisitor;
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
		final Constraint constraintConnectingCreateToJSONConstructedByView = getConstraintConnectingCreateToJSONConstructedByView(block);
		if (constraintConnectingCreateToJSONConstructedByView != null) {
			if (includeComments) {
				builder.add(new Comment(block.getId()
								+ " constraint connecting create to JSON constructed by view"));
			}
			builder.add(constraintConnectingCreateToJSONConstructedByView);
		}
	}

	@Override
	public void visit(final ChildBlock block) {
		final Constraint constraintConnectingCreateToJSONConstructedByView = getConstraintConnectingCreateToJSONConstructedByView(block);
		if (constraintConnectingCreateToJSONConstructedByView != null) {
			if (includeComments) {
				builder.add(new Comment(block.getId() + " constraint connecting create to JSON constructed by view"));
			}
			builder.add(constraintConnectingCreateToJSONConstructedByView);
		}
	}

	private Constraint getConstraintConnectingCreateToJSONConstructedByView(
			final RootBlock block) {
		final List<Atom> premise = new ArrayList<Atom>();
		premise.add(Utils.getCreateAtom(block));

		final List<Atom> conclusion = blockForwardEncoderReturnTermVisitor
				.encode(block.getReturnTemplate(), block.getQueryName());

		if (conclusion.isEmpty()) {
			return null;
		}

		return new Tgd(premise, conclusion);
	}

	private Constraint getConstraintConnectingCreateToJSONConstructedByView(
			final ChildBlock block) {
		final List<Atom> premise = new ArrayList<Atom>();
		premise.add(Utils.getCreateAtom(block.getParent()));
		premise.add(Utils.getCreateAtom(block));
		premise.addAll(blockForwardStructureEncoderReturnTermVisitor.encode(
				block.getCreatedNode(), block.getReturnTemplate(),
				block.getQueryName()));

		final List<Atom> conclusion = blockForwardEncoderReturnTermVisitor
				.encode(block.getCreatedNode(), block.getReturnTemplate(),
						block.getQueryName());

		if (conclusion.isEmpty()) {
			return null;
		}

		return new Tgd(premise, conclusion);
	}
}