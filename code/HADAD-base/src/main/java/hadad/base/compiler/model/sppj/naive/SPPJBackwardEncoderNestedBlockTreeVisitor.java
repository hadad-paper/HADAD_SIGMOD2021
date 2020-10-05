package hadad.base.compiler.model.sppj.naive;

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
import hadad.base.compiler.model.sppj.SPPJExtractVariableToCreatedNodeVisitor;
import hadad.base.compiler.model.sppj.Utils;
import hadad.base.rewriter.Comment;

@Singleton
class SPPJBackwardEncoderNestedBlockTreeVisitor implements QueryBlockTreeVisitor {
    private final SPPJExtractVariableToCreatedNodeVisitor sPPJExtractVariableToCreatedNodeVisitor;
    private final SPPJBlockBackwardEncoderReturnTermVisitor sPPJBlockBackwardEncoderReturnTermVisitor;
    private final String skolemFunctionVariableCopySuffix;

    private ImmutableList.Builder<Constraint> builder;
    private boolean includeComments;

    @Inject
    public SPPJBackwardEncoderNestedBlockTreeVisitor(
            final SPPJExtractVariableToCreatedNodeVisitor sPPJExtractVariableToCreatedNodeVisitor,
            @Named("skolem_function_variable_copy_suffix") final String skolemFunctionVariableCopySuffix,
            final SPPJBlockBackwardEncoderReturnTermVisitor sPPJBlockBackwardEncoderReturnTermVisitor) {
        this.sPPJExtractVariableToCreatedNodeVisitor = sPPJExtractVariableToCreatedNodeVisitor;
        this.sPPJBlockBackwardEncoderReturnTermVisitor = sPPJBlockBackwardEncoderReturnTermVisitor;
        this.skolemFunctionVariableCopySuffix = skolemFunctionVariableCopySuffix;
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
            final List<Constraint> skolemFunctions =
                    Utils.getConstraintForSkolemFunctions(block, skolemFunctionVariableCopySuffix);
            if (includeComments && !skolemFunctions.isEmpty()) {
                builder.add(new Comment(block.getId() + " constraints for skolem functions"));
            }
            builder.addAll(skolemFunctions);
        }
        if (includeComments) {
            builder.add(new Comment(block.getId() + " constraint connecting create to JSON constructed by view"));
        }
        builder.addAll(getConstraintConnectingCreateToJSONConstructedByView(block));
        if (!block.getPattern().isEmpty()) {
            if (includeComments) {
                builder.add(new Comment(block.getId() + " constraint relating extract with create"));
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
        final List<Constraint> skolemFunctions =
                Utils.getConstraintForSkolemFunctions(block, skolemFunctionVariableCopySuffix);
        if (includeComments && !skolemFunctions.isEmpty()) {
            builder.add(new Comment(block.getId() + " constraints for skolem functions"));
        }
        builder.addAll(skolemFunctions);
        if (includeComments) {
            builder.add(new Comment(block.getId() + " constraint connecting create to JSON constructed by view"));
        }
        builder.addAll(getConstraintConnectingCreateToJSONConstructedByView(block));
        if (includeComments) {
            builder.add(new Comment(block.getId() + " constraint relating extract with create"));
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
        final List<Atom> conclusion = new ArrayList<Atom>();
        conclusion.addAll(sPPJExtractVariableToCreatedNodeVisitor.encode(block.getReturnTemplate(), queryName));
        conclusion.add(Utils.getExtractAtom(block));
        for (final Atom skolemFunction : Utils.getSkolemFunctions(block)) {
            conclusion.add(skolemFunction);
        }
        return new Tgd(premise, conclusion);
    }

    private List<Constraint> getConstraintConnectingCreateToJSONConstructedByView(final RootBlock block) {
        final List<List<Atom>> premises =
                sPPJBlockBackwardEncoderReturnTermVisitor.encode(block.getReturnTemplate(), block.getQueryName());

        final List<Atom> conclusion = new ArrayList<Atom>();
        conclusion.add(Utils.getCreateAtom(block));

        final List<Constraint> constraints = new ArrayList<Constraint>();
        for (final List<Atom> premise : premises) {
            constraints.add(new Tgd(premise, conclusion));
        }
        return constraints;
    }

    private List<Constraint> getConstraintConnectingCreateToJSONConstructedByView(final ChildBlock block) {
        final List<List<Atom>> premises = sPPJBlockBackwardEncoderReturnTermVisitor.encode(block.getCreatedNode(),
                block.getReturnTemplate(), block.getQueryName());

        final List<Atom> conclusion = new ArrayList<Atom>();
        conclusion.add(Utils.getCreateAtom(block));
        conclusion.addAll(Utils.getSkolemFunctions(block));

        final List<Constraint> constraints = new ArrayList<Constraint>();
        for (final List<Atom> premise : premises) {
            final List<Atom> premiseAux = new ArrayList<Atom>();
            if (!block.getParent().getPattern().isEmpty()) {
                premiseAux.add(Utils.getParentCreateSkolemFunction(block));
            }
            premiseAux.add(Utils.getCreateAtom(block.getParent()));
            premiseAux.addAll(premise);
            constraints.add(new Tgd(premiseAux, conclusion));
        }
        return constraints;
    }
}