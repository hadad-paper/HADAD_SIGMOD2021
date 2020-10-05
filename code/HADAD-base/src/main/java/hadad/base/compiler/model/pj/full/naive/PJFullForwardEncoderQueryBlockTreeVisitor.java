package hadad.base.compiler.model.pj.full.naive;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.commons.conjunctivequery.Variable;
import hadad.commons.constraints.Constraint;
import hadad.base.rewriter.Comment;
import hadad.base.compiler.ChildBlock;
import hadad.base.compiler.QueryBlockTree;
import hadad.base.compiler.QueryBlockTreeVisitor;
import hadad.base.compiler.RootBlock;
import hadad.base.compiler.model.pj.full.PJFullExtractVariableToCreatedNodeVisitor;

/**
 * SJ Forward Encoder Nested Block Tree Visitor
 * 
 *  
 *
 */
@Singleton
class PJFullForwardEncoderQueryBlockTreeVisitor implements QueryBlockTreeVisitor {
    private final PJFullExtractVariableToCreatedNodeVisitor sJExtractVariableToCreatedNodeVisitor;
    private Variable viewID;
    private ImmutableList.Builder<Constraint> builder;
    private boolean includeComments;

    @Inject
    public PJFullForwardEncoderQueryBlockTreeVisitor(
            final PJFullExtractVariableToCreatedNodeVisitor extractVariableToCreatedNodeVisit) {
        this.sJExtractVariableToCreatedNodeVisitor = extractVariableToCreatedNodeVisit;
        this.viewID = null;

    }

    public List<Constraint> compileConstraints(final QueryBlockTree nbt, final Variable viewID,
            boolean includeComments) {
        this.viewID = viewID;
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
            //builder.add(getForwardConstraintForBodyEncoding(block));
        }
    }

    @Override
    public void visit(final ChildBlock block) {
        // TODO Auto-generated method stub
    }

    //    /**
    //     * Get forward constraints
    //     * 
    //     * @param qbtBlock
    //     *            the qbt block
    //     * @return the constraints
    //     */
    //    private Constraint getForwardConstraintForBodyEncoding(final RootBlock qbtBlock) {
    //        final String viewName = qbtBlock.getQueryName();
    //        final List<Atom> premise = new ArrayList<Atom>();
    //        premise.addAll(qbtBlock.getPattern().encoding(Utils.conditionEncoding));
    //        final List<Atom> conclusion = new ArrayList<Atom>();
    //        sJExtractVariableToCreatedNodeVisitor.encode(viewID, viewName);
    //        conclusion.addAll(sJExtractVariableToCreatedNodeVisitor.encode(qbtBlock.getReturnTemplate()));
    //        conclusion.add(Utils.createRootAtom(viewID, viewName));
    //        return new Tgd(premise, conclusion);
    //    }

}