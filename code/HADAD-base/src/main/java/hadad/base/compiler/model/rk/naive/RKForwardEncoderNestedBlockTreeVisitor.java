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
class RKForwardEncoderNestedBlockTreeVisitor implements QueryBlockTreeVisitor {
	private final RKExtractVariableToCreatedNodeVisitor	rKExtractVariableToCreatedNodeVisitor;
	private Variable									viewSetID;
	private Variable									internalMapID;
	private ImmutableList.Builder<Constraint>			builder;
	private boolean										includeComments;

	@Inject
	public RKForwardEncoderNestedBlockTreeVisitor(final VariableCopier variableCopier,
	        final RKExtractVariableToCreatedNodeVisitor rKExtractVariableToCreatedNodeVisitor) {
		this.rKExtractVariableToCreatedNodeVisitor = rKExtractVariableToCreatedNodeVisitor;
		this.viewSetID = null;
		this.internalMapID = null;
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
	public void visit(ChildBlock block) {
		// No Implementation Since There is no Child Block

	}

	@Override
	public void visit(final RootBlock block) {

		if (!block.getPattern().isEmpty()) {
			if (includeComments) {
				builder.add(new Comment(block.getQueryName() + " constraint for Body Encoding"));
			}
			builder.add(getForwardConstraintForBodyEncoding(block, internalMapID));
		}
	}

	private Constraint getForwardConstraintForBodyEncoding(final RootBlock block, final Variable InternalMapID) {
		final String queryName = block.getQueryName();
		final List<Atom> premise = new ArrayList<Atom>();
		premise.addAll(block.getPattern().encoding(Utils.conditionEncoding));
		final List<Atom> conclusion = new ArrayList<Atom>();
		conclusion.addAll(rKExtractVariableToCreatedNodeVisitor.encode(block.getReturnTemplate(), queryName));
		conclusion.addAll(rKExtractVariableToCreatedNodeVisitor.encode(viewSetID, queryName));
		conclusion.add(Utils.getCollectionAtom(block, viewSetID));
		if (block.getReturnTemplate().getTerms().get(0) instanceof ReturnConstructTerm) {
			conclusion.add(Utils.getInternalMapAtom(block, internalMapID));
			conclusion.addAll(Utils.getCollectionAtomMap(block, InternalMapID));
		}
		return new Tgd(premise, conclusion);
	}

}