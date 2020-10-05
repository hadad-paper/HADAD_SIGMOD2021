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
class BackwardEncoderNestedBlockTreeVisitor implements QueryBlockTreeVisitor {
	private final BlockBackwardEncoderReturnTermVisitor blockBackwardEncoderReturnTermVisitor;

	private ImmutableList.Builder<Constraint> builder;
	private boolean includeComments;

	@Inject
	public BackwardEncoderNestedBlockTreeVisitor(
			final BlockBackwardEncoderReturnTermVisitor blockBackwardEncoderReturnTermVisitor) {
		this.blockBackwardEncoderReturnTermVisitor = blockBackwardEncoderReturnTermVisitor;
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
		final List<Constraint> constraintConnectingCreateToJSONConstructedByView = getConstraintConnectingCreateToJSONConstructedByView(block);
		if (includeComments
				&& !constraintConnectingCreateToJSONConstructedByView.isEmpty()) {
			builder.add(new Comment(
					block.getId()
							+ " constraint connecting create to JSON constructed by view"));
		}
		builder.addAll(constraintConnectingCreateToJSONConstructedByView);
	}

	@Override
	public void visit(final ChildBlock block) {
		final List<Constraint> constraintConnectingCreateToJSONConstructedByView = getConstraintConnectingCreateToJSONConstructedByView(block);
		if (includeComments && !constraintConnectingCreateToJSONConstructedByView.isEmpty()) {
			builder.add(new Comment(block.getId() + " constraint connecting create to JSON constructed by view"));
		}
		builder.addAll(constraintConnectingCreateToJSONConstructedByView);
	}

	private List<Constraint> getConstraintConnectingCreateToJSONConstructedByView(
			final RootBlock block) {
		final List<List<Atom>> premises = blockBackwardEncoderReturnTermVisitor
				.encode(block.getReturnTemplate(), block.getQueryName());

		final List<Atom> conclusion = new ArrayList<Atom>();
		conclusion.add(Utils.getCreateAtom(block));

		final List<Constraint> constraints = new ArrayList<Constraint>();
		for (final List<Atom> premise : premises) {
			constraints.add(new Tgd(premise, conclusion));
		}
		return constraints;
	}

	private List<Constraint> getConstraintConnectingCreateToJSONConstructedByView(
			final ChildBlock block) {
		final List<List<Atom>> premises = blockBackwardEncoderReturnTermVisitor
				.encode(block.getCreatedNode(),
						block.getReturnTemplate(),
						block.getQueryName());

		final List<Atom> conclusion = new ArrayList<Atom>();
		conclusion.add(Utils.getCreateAtom(block));

		final List<Constraint> constraints = new ArrayList<Constraint>();
		for (final List<Atom> premise : premises) {
			final List<Atom> premiseAux = new ArrayList<Atom>();
			premiseAux.add(Utils.getCreateAtom(block.getParent()));
			premiseAux.addAll(premise);
			constraints.add(new Tgd(premiseAux, conclusion));
		}

		return constraints;
	}
}