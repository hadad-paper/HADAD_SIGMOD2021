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

@Singleton
class PJFullBackwardEncoderQueryBlockTreeVisitor implements QueryBlockTreeVisitor {
    private final PJFullExtractVariableToCreatedNodeVisitor pJExtractVariableToCreatedNodeVisitor;
    private Variable viewID;
    private ImmutableList.Builder<Constraint> builder;
    private boolean includeComments;

    @Inject
    public PJFullBackwardEncoderQueryBlockTreeVisitor(
            final PJFullExtractVariableToCreatedNodeVisitor pJExtractVariableToCreatedNodeVisitor) {
        this.pJExtractVariableToCreatedNodeVisitor = pJExtractVariableToCreatedNodeVisitor;
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
            //builder.add(getBackwardConstraintForBodyEncoding(block));
        }
    }

    @Override
    public void visit(final ChildBlock block) {

    }

    //    private Constraint getBackwardConstraintForBodyEncoding(final RootBlock block) {
    //        final String viewName = block.getQueryName();
    //        final List<Atom> premise = new ArrayList<Atom>();
    //        final List<Atom> conclusion = new ArrayList<Atom>();
    //        conclusion.addAll(block.getPattern().encoding(Utils.conditionEncoding));
    //        pJExtractVariableToCreatedNodeVisitor.encode(viewID, viewName);
    //        premise.addAll(pJExtractVariableToCreatedNodeVisitor.encode(block.getReturnTemplate()));
    //        premise.add(Utils.createRootAtom(viewID, viewName));
    //        return new Tgd(premise, conclusion);
    //    }

}