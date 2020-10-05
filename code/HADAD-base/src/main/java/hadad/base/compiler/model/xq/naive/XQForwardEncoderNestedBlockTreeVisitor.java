package hadad.base.compiler.model.xq.naive;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;

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
class XQForwardEncoderNestedBlockTreeVisitor implements QueryBlockTreeVisitor {
	private final XQExtractVariableToCreatedNodeVisitor xQExtractVariableToCreatedNodeVisitor;
	private final XQRootBlockForwardEncoderReturnTermVisitor xQRootBlockForwardEncoderReturnTermVisitor;
	private final XQChildBlockForwardEncoderReturnTermVisitor xQChildBlockForwardEncoderReturnTermVisitor;

	private ImmutableList.Builder<Constraint> builder;
	private boolean includeComments;

	@Inject
	public XQForwardEncoderNestedBlockTreeVisitor(
			final XQExtractVariableToCreatedNodeVisitor xQExtractVariableToCreatedNodeVisitor,
			final XQRootBlockForwardEncoderReturnTermVisitor xQRootBlockForwardEncoderReturnTermVisitor,
			final XQChildBlockForwardEncoderReturnTermVisitor xQChildBlockForwardEncoderReturnTermVisitor) {
		this.xQExtractVariableToCreatedNodeVisitor = xQExtractVariableToCreatedNodeVisitor;
		this.xQRootBlockForwardEncoderReturnTermVisitor = xQRootBlockForwardEncoderReturnTermVisitor;
		this.xQChildBlockForwardEncoderReturnTermVisitor = xQChildBlockForwardEncoderReturnTermVisitor;
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
			builder.add(new Comment(block.getId()
				+ " constraint relating extract with create"));
		}
		builder.add(getConstraintRelatingExtractWithCreate(block));
		if (includeComments) {
			builder.add(new Comment(block.getId()
				+ " constraint connecting create to XML constructed by view"));
		}
		builder.add(getConstraintConnectingCreateToXMLConstructedByView(block));
		if (!block.getPattern().isEmpty()) {
			final List<Constraint> skolemFunctions = getConstraintForSkolemFunctions(block);
			if (includeComments && !skolemFunctions.isEmpty()) {
				builder.add(new Comment(block.getId()
						+ " constraints for skolem functions"));
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
			builder.add(new Comment(block.getId()
				+ " constraint relating extract with create"));
		}
		builder.add(getConstraintRelatingExtractWithCreate(block));
		if (includeComments) {
			builder.add(new Comment(block.getId()
				+ " constraint connecting create to XML constructed by view"));
		}
		builder.add(getConstraintConnectingCreateToXMLConstructedByView(block));
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
		conclusion.addAll(xQExtractVariableToCreatedNodeVisitor.encode(
				block.getReturnTemplate(), queryName));
		conclusion.add(Utils.getCreateAtom(block));
		if (!block.getPattern().isEmpty()) {
			for (final Atom skolemFunction : Utils.getSkolemFunctions(block)) {
				conclusion.add(skolemFunction);
			}
		}
		return new Tgd(premise, conclusion);
	}

	private Constraint getConstraintConnectingCreateToXMLConstructedByView(
			final RootBlock block) {
		final List<Atom> premise = new ArrayList<Atom>();
		premise.add(Utils.getCreateAtom(block));
		final List<Atom> conclusion = xQRootBlockForwardEncoderReturnTermVisitor
				.encode(block.getReturnTemplate(),
						block.getQueryName());
		return new Tgd(premise, conclusion);
	}

	private Constraint getConstraintConnectingCreateToXMLConstructedByView(
			final ChildBlock block) {
		final List<Atom> premise = new ArrayList<Atom>();
		premise.add(Utils.getCreateAtom(block.getParent()));
		premise.add(Utils.getCreateAtom(block));
		if (!block.getParent().getPattern().isEmpty()) {
			premise.add(Utils.getParentCreateSkolemFunction(block));
		}
		premise.addAll(Utils.getSkolemFunctions(block));
		final List<Atom> conclusion = xQChildBlockForwardEncoderReturnTermVisitor
				.encode(block.getCreatedNode(), block.getReturnTemplate(),
						block.getQueryName());
		return new Tgd(premise, conclusion);
	}

	private List<Constraint> getConstraintForSkolemFunctions(final Block block) {
		final List<Constraint> constraints = new ArrayList<Constraint>();
		return constraints;
	}
}