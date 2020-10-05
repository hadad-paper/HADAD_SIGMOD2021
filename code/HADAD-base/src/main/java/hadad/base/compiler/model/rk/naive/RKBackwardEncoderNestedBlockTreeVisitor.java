package hadad.base.compiler.model.rk.naive;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.Variable;
import hadad.commons.constraints.Constraint;
import hadad.commons.constraints.Tgd;
import hadad.base.compiler.ChildBlock;
import hadad.base.compiler.QueryBlockTree;
import hadad.base.compiler.QueryBlockTreeVisitor;
import hadad.base.compiler.ReturnConstructTerm;
import hadad.base.compiler.RootBlock;
import hadad.base.compiler.VariableCopier;
import hadad.base.compiler.model.rk.RKExtractVariableToCreatedNodeVisitor;
import hadad.base.compiler.model.rk.Utils;
import hadad.base.rewriter.Comment;

@Singleton
class RKBackwardEncoderNestedBlockTreeVisitor implements QueryBlockTreeVisitor {
	private final RKExtractVariableToCreatedNodeVisitor	rKExtractVariableToCreatedNodeVisitor;
	private ImmutableList.Builder<Constraint>			builder;
	private Variable									viewSetID;
	private Variable									internalMapID;
	private boolean										includeComments;

	@Inject
	public RKBackwardEncoderNestedBlockTreeVisitor(
	        final RKExtractVariableToCreatedNodeVisitor rKExtractVariableToCreatedNodeVisitor,
	        final VariableCopier variableCopier) {
		this.rKExtractVariableToCreatedNodeVisitor = rKExtractVariableToCreatedNodeVisitor;
	}

	public List<Constraint> compileConstraints(final QueryBlockTree nbt, boolean includeComments,
	        final Variable viewSetID, final Variable internalMapID) {
		this.viewSetID = viewSetID;
		this.internalMapID = internalMapID;
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
				builder.add(new Comment(block.getQueryName() + " constraint for Body Encoding"));
			}
			builder.add(getBackwardConstraintForBodyEncoding(block));
		}
	}

	private Constraint getBackwardConstraintForBodyEncoding(final RootBlock block) {

		final String queryName = block.getQueryName();
		final List<Atom> premise = new ArrayList<Atom>();
		final List<Atom> conclusion = new ArrayList<Atom>();
		premise.addAll(rKExtractVariableToCreatedNodeVisitor.encode(viewSetID, queryName));
		premise.add(Utils.getCollectionAtom(block, viewSetID));
		if (block.getReturnTemplate().getTerms().get(0) instanceof ReturnConstructTerm) {
			premise.add(Utils.getInternalMapAtom(block, internalMapID));
			premise.addAll(Utils.getCollectionAtomMap(block, internalMapID));
		}
		conclusion.addAll(block.getPattern().encoding(Utils.conditionEncoding));
		conclusion.addAll(rKExtractVariableToCreatedNodeVisitor.encode(block.getReturnTemplate(), queryName));
		return new Tgd(premise, conclusion);
	}

	@Override
	public void visit(ChildBlock block) {
		// No ChildBlcok so no implementation

	}

}