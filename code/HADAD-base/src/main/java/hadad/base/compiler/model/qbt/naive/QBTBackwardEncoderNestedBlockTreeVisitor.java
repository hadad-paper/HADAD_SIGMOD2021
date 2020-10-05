package hadad.base.compiler.model.qbt.naive;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.Term;
import hadad.commons.conjunctivequery.Variable;
import hadad.commons.constraints.Constraint;
import hadad.commons.constraints.Tgd;
import hadad.base.compiler.model.pr.naive.PRBackwardEncoderReturnTermVisitor;
import hadad.base.compiler.model.sj.SJExtractVariableToCreatedNodeVisitor;
import hadad.base.rewriter.Comment;
import hadad.base.compiler.Block;
import hadad.base.compiler.ChildBlock;
import hadad.base.compiler.QueryBlockTree;
import hadad.base.compiler.QueryBlockTreeVisitor;
import hadad.base.compiler.RootBlock;
import hadad.base.compiler.model.aj.AJExtractVariableToCreatedNodeVisitor;
import hadad.base.compiler.model.aj.naive.AJBlockBackwardEncoderReturnTermVisitor;
import hadad.base.compiler.model.pj.full.Predicate;
import hadad.base.compiler.model.pj.full.naive.PJFullBackwardEncoderReturnTermVisitor;
import hadad.base.compiler.model.rk.RKExtractVariableToCreatedNodeVisitor;
import hadad.base.compiler.model.rk.Utils;
import hadad.base.compiler.model.sppj.SPPJExtractVariableToCreatedNodeVisitor;
import hadad.base.compiler.model.sppj.naive.SPPJBlockBackwardEncoderReturnTermVisitor;
import hadad.base.compiler.model.xq.XQExtractVariableToCreatedNodeVisitor;
import hadad.base.compiler.model.xq.naive.XQBlockBackwardEncoderReturnTermVisitor;

@Singleton
class QBTBackwardEncoderNestedBlockTreeVisitor implements QueryBlockTreeVisitor {
    private final AJExtractVariableToCreatedNodeVisitor extractVariableToCreatedNodeVisitorAJ;
    private final SPPJExtractVariableToCreatedNodeVisitor extractVariableToCreatedNodeVisitorSPPJ;
    private final SJExtractVariableToCreatedNodeVisitor extractVariableToCreatedNodeVisitorSJ;
    private final XQExtractVariableToCreatedNodeVisitor extractVariableToCreatedNodeVisitorXQ;
    private final RKExtractVariableToCreatedNodeVisitor extractVariableToCreatedNodeVisitorRK;

    private final AJBlockBackwardEncoderReturnTermVisitor blockBackwardEncoderReturnTermVisitorAJ;
    private final SPPJBlockBackwardEncoderReturnTermVisitor blockBackwardEncoderReturnTermVisitorSPPJ;
    private final XQBlockBackwardEncoderReturnTermVisitor blockBackwardEncoderReturnTermVisitorXQ;
    private final PJFullBackwardEncoderReturnTermVisitor blockBackwardEncoderReturnTermVisitorPJ;
    private final PRBackwardEncoderReturnTermVisitor blockBackwardEncoderReturnTermVisitorPR;

    private final String skolemFunctionVariableCopySuffix;

    private ImmutableList.Builder<Constraint> builder;
    private boolean includeComments;
    private Variable viewSetID;

    @Inject
    public QBTBackwardEncoderNestedBlockTreeVisitor(
            final RKExtractVariableToCreatedNodeVisitor rKExtractVariableToCreatedNodeVisitor,
            @Named("skolem_function_variable_copy_suffix") final String skolemFunctionVariableCopySuffix,
            final AJExtractVariableToCreatedNodeVisitor extractVariableToCreatedNodeVisitorAJ,
            final RKExtractVariableToCreatedNodeVisitor extractVariableToCreatedNodeVisitorRK,
            final SJExtractVariableToCreatedNodeVisitor extractVariableToCreatedNodeVisitorSJ,
            final XQExtractVariableToCreatedNodeVisitor extractVariableToCreatedNodeVisitorXQ,
            final SPPJExtractVariableToCreatedNodeVisitor extractVariableToCreatedNodeVisitorSPPJ,
            final AJBlockBackwardEncoderReturnTermVisitor blockBackwardEncoderReturnTermVisitorAJ,
            final XQBlockBackwardEncoderReturnTermVisitor blockBackwardEncoderReturnTermVisitorXQ,
            final SPPJBlockBackwardEncoderReturnTermVisitor blockBackwardEncoderReturnTermVisitorSPPJ,
            final PJFullBackwardEncoderReturnTermVisitor blockBackwardEncoderReturnTermVisitorPJ,
            final PRBackwardEncoderReturnTermVisitor blockBackwardEncoderReturnTermVisitorPR) {

        this.extractVariableToCreatedNodeVisitorAJ = extractVariableToCreatedNodeVisitorAJ;
        this.extractVariableToCreatedNodeVisitorSPPJ = extractVariableToCreatedNodeVisitorSPPJ;
        this.extractVariableToCreatedNodeVisitorXQ = extractVariableToCreatedNodeVisitorXQ;
        this.extractVariableToCreatedNodeVisitorRK = extractVariableToCreatedNodeVisitorRK;
        this.extractVariableToCreatedNodeVisitorSJ = extractVariableToCreatedNodeVisitorSJ;
        this.blockBackwardEncoderReturnTermVisitorAJ = blockBackwardEncoderReturnTermVisitorAJ;
        this.blockBackwardEncoderReturnTermVisitorSPPJ = blockBackwardEncoderReturnTermVisitorSPPJ;
        this.blockBackwardEncoderReturnTermVisitorXQ = blockBackwardEncoderReturnTermVisitorXQ;
        this.blockBackwardEncoderReturnTermVisitorPJ = blockBackwardEncoderReturnTermVisitorPJ;
        this.blockBackwardEncoderReturnTermVisitorPR = blockBackwardEncoderReturnTermVisitorPR;
        this.skolemFunctionVariableCopySuffix = skolemFunctionVariableCopySuffix;

    }

    public List<Constraint> compileConstraints(final QueryBlockTree nbt, boolean includeComments,
            final Variable viewSetID) {
        builder = ImmutableList.builder();
        this.includeComments = includeComments;
        this.viewSetID = viewSetID;
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
            switch (block.getReturnTemplate().getModel()) {
                case "AJ":
                    buildBackwardRootBlockJQ(block);
                    break;
                case "PJ":
                    buildBackwardRootBlockPJ(block);
                    break;
                case "PR":
                    buildBackwardRootBlockPR(block);
                    break;
                case "SPPJ":
                    buildBackwardRootBlockSPPJ(block);
                    break;
                case "RK":
                    buildBackwardRootBlockKQ(block);
                    break;
                case "XQ":
                    buildBackwardRootBlockXQ(block);
                    break;
                case "SJ":
                    buildBackwardRootBlockSJ(block);

            }
        }
    }

    @Override
    public void visit(final ChildBlock block) {
        if (!block.getPattern().isEmpty()) {
            switch (block.getReturnTemplate().getModel()) {
                case "AJ":
                    buildBackwardChildBlockJQ(block);
                    break;
                case "SPP":
                    buildBackwardChildBlockSPPJ(block);
                    break;
                case "XQ":
                    buildBackwardChildBlockXQ(block);
                    break;

            }
        }

    }

    // Build   backward encoding
    private void buildBackwardRootBlockKQ(final RootBlock block) {
        if (includeComments) {
            builder.add(new Comment(block.getQueryName() + " constraint for Body Encoding"));
        }
        builder.add(getBackwardConstraintForBodyEncodingRK(block));
    }

    // Build   backward encoding
    private void buildBackwardRootBlockSJ(final RootBlock block) {
        if (includeComments) {
            builder.add(new Comment(block.getQueryName() + " constraint for Body Encoding"));
        }
        builder.add(getBackwardConstraintForBodyEncodingSJ(block));
    }

    // Build   backward encoding
    private void buildBackwardRootBlockPJ(final RootBlock block) {
        if (includeComments) {
            builder.add(new Comment(block.getQueryName() + " constraint for Body Encoding"));
        }
        builder.add(getBackwardConstraintForBodyEncodinPJ(block));
    }

    // Build   backward encoding
    private void buildBackwardRootBlockPR(final RootBlock block) {
        if (includeComments) {
            builder.add(new Comment(block.getQueryName() + " constraint for Body Encoding"));
        }
        builder.add(getBackwardConstraintForBodyEncodinPR(block));
    }

    // Build JQ Root backward encoding
    private void buildBackwardRootBlockJQ(final RootBlock block) {
        final List<Constraint> skolemFunctionsJQ = hadad.base.compiler.model.aj.Utils
                .getConstraintForSkolemFunctions(block, skolemFunctionVariableCopySuffix);
        if (includeComments && !skolemFunctionsJQ.isEmpty()) {
            builder.add(new Comment(block.getId() + " constraints for skolem functions"));
        }
        builder.addAll(skolemFunctionsJQ);
        if (includeComments) {
            builder.add(new Comment(block.getId() + " constraint connecting create to JSON constructed by view"));
        }
        builder.addAll(getConstraintConnectingCreateToJSONConstructedByView(block));
        if (!block.getPattern().isEmpty()) {
            if (includeComments) {
                builder.add(new Comment(block.getId() + " constraint relating extract with create"));
            }
            builder.add(getConstraintRelatingExtractWithCreateJQ(block));
            if (includeComments) {
                builder.add(new Comment(block.getId() + " constraint for extract"));
            }
            builder.add(getConstraintForExtractJQ(block));
            if (includeComments) {
                builder.add(new Comment(block.getId() + " constraints for type inference"));
            }
            builder.addAll(getConstraintForTypeInferneceJQ(block));
        }
    }

    // Build SPPJ Root backward encoding
    private void buildBackwardRootBlockSPPJ(final RootBlock block) {
        final List<Constraint> skolemFunctionsSPPJQ = hadad.base.compiler.model.sppj.Utils
                .getConstraintForSkolemFunctions(block, skolemFunctionVariableCopySuffix);
        if (includeComments && !skolemFunctionsSPPJQ.isEmpty()) {
            builder.add(new Comment(block.getId() + " constraints for skolem functions"));
        }
        builder.addAll(skolemFunctionsSPPJQ);
        if (includeComments) {
            builder.add(new Comment(block.getId() + " constraint connecting create to JSON constructed by view"));
        }
        builder.addAll(getConstraintConnectingCreateToJSONConstructedByViewSPPJ(block));
        if (!block.getPattern().isEmpty()) {
            if (includeComments) {
                builder.add(new Comment(block.getId() + " constraint relating extract with create"));
            }
            builder.add(getConstraintRelatingExtractWithCreateSPPJ(block));
            if (includeComments) {
                builder.add(new Comment(block.getId() + " constraint for extract"));
            }
            builder.add(getConstraintForExtractSPPJ(block));
            if (includeComments) {
                builder.add(new Comment(block.getId() + " constraints for type inference"));
            }
            builder.addAll(getConstraintForTypeInferneceSPPJ(block));
        }
    }

    // Build JQ Child backward encoding
    private void buildBackwardChildBlockJQ(final ChildBlock block) {
        final List<Constraint> skolemFunctionsJQ = hadad.base.compiler.model.aj.Utils
                .getConstraintForSkolemFunctions(block, skolemFunctionVariableCopySuffix);
        if (includeComments && !skolemFunctionsJQ.isEmpty()) {
            builder.add(new Comment(block.getId() + " constraints for skolem functions"));
        }
        builder.addAll(skolemFunctionsJQ);
        if (includeComments) {
            builder.add(new Comment(block.getId() + " constraint connecting create to JSON constructed by view"));
        }
        builder.addAll(getConstraintConnectingCreateToJSONConstructedByView(block));
        if (!block.getPattern().isEmpty()) {
            if (includeComments) {
                builder.add(new Comment(block.getId() + " constraint relating extract with create"));
            }
            builder.add(getConstraintRelatingExtractWithCreateJQ(block));
            if (includeComments) {
                builder.add(new Comment(block.getId() + " constraint for extract"));
            }
            builder.add(getConstraintForExtractJQ(block));
            if (includeComments) {
                builder.add(new Comment(block.getId() + " constraints for type infernece"));
            }
            builder.add(getConstraintForTypeInferneceJQ(block));
        }
    }

    // Build SPPJ Child backward encoding
    private void buildBackwardChildBlockSPPJ(final ChildBlock block) {
        final List<Constraint> skolemFunctionsJQ = hadad.base.compiler.model.sppj.Utils
                .getConstraintForSkolemFunctions(block, skolemFunctionVariableCopySuffix);
        if (includeComments && !skolemFunctionsJQ.isEmpty()) {
            builder.add(new Comment(block.getId() + " constraints for skolem functions"));
        }
        builder.addAll(skolemFunctionsJQ);
        if (includeComments) {
            builder.add(new Comment(block.getId() + " constraint connecting create to JSON constructed by view"));
        }
        builder.addAll(getConstraintConnectingCreateToJSONConstructedByViewSPPJ(block));
        if (!block.getPattern().isEmpty()) {
            if (includeComments) {
                builder.add(new Comment(block.getId() + " constraint relating extract with create"));
            }
            builder.add(getConstraintRelatingExtractWithCreateSPPJ(block));
            if (includeComments) {
                builder.add(new Comment(block.getId() + " constraint for extract"));
            }
            builder.add(getConstraintForExtractSPPJ(block));
            if (includeComments) {
                builder.add(new Comment(block.getId() + " constraints for type infernece"));
            }
            builder.add(getConstraintForTypeInferneceSPPJ(block));
        }
    }

    // Build XQ Root backward encoding
    private void buildBackwardRootBlockXQ(final RootBlock block) {
        final List<Constraint> skolemFunctions = hadad.base.compiler.model.xq.Utils
                .getConstraintForSkolemFunctions(block, skolemFunctionVariableCopySuffix);
        if (includeComments && !skolemFunctions.isEmpty()) {
            builder.add(new Comment(block.getId() + " constraints for skolem functions"));
        }
        builder.addAll(skolemFunctions);
        if (includeComments) {
            builder.add(new Comment(block.getId() + " constraint connecting create to XML constructed by view"));
        }
        builder.addAll(getConstraintConnectingCreateToXMLConstructedByView(block));
        if (!block.getPattern().isEmpty()) {
            if (includeComments) {
                builder.add(new Comment(block.getId() + " constraint relating extract with create"));
            }
            builder.add(getConstraintRelatingExtractWithCreateXQ(block));
            if (includeComments) {
                builder.add(new Comment(block.getId() + " constraint for extract"));
            }
            builder.add(getConstraintForExtractXQ(block));
        }
    }

    // Build XQ Child backward encoding
    private void buildBackwardChildBlockXQ(final ChildBlock block) {
        final List<Constraint> skolemFunctions = hadad.base.compiler.model.xq.Utils
                .getConstraintForSkolemFunctions(block, skolemFunctionVariableCopySuffix);
        if (includeComments && !skolemFunctions.isEmpty()) {
            builder.add(new Comment(block.getId() + " constraints for skolem functions"));
        }
        builder.addAll(skolemFunctions);
        if (includeComments) {
            builder.add(new Comment(block.getId() + " constraint connecting create to XML constructed by view"));
        }
        builder.addAll(getConstraintConnectingCreateToXMLConstructedByView(block));
        if (!block.getPattern().isEmpty()) {
            if (includeComments) {
                builder.add(new Comment(block.getId() + " constraint relating extract with create"));
            }
            builder.add(getConstraintRelatingExtractWithCreateXQ(block));
            if (includeComments) {
                builder.add(new Comment(block.getId() + " constraint for extract"));
            }
            builder.add(getConstraintForExtractXQ(block));

        }
    }

    // JQ Rootblock Extract Constraint
    private Constraint getConstraintForExtractJQ(final RootBlock block) {
        final List<Atom> premise = new ArrayList<Atom>();
        final List<String> models = block.getPattern().getConditional().getModels();
        premise.add(hadad.base.compiler.model.aj.Utils.getExtractAtom(block));
        final List<Atom> conclusion = new ArrayList<Atom>();
        if (!models.isEmpty()) {
            for (String model : models) {
                switch (model) {
                    case "AJ":
                        conclusion.addAll(block.getPattern()
                                .encoding(hadad.base.compiler.model.aj.Utils.conditionEncoding));
                        break;
                    case "SJ":
                        conclusion.addAll(block.getPattern()
                                .encoding(hadad.base.compiler.model.sj.Utils.conditionEncoding));
                        break;
                    case "SPPJ":
                        conclusion.addAll(block.getPattern()
                                .encoding(hadad.base.compiler.model.sppj.Utils.conditionEncoding));
                        break;
                    case "XQ":
                        conclusion.addAll(block.getPattern()
                                .encoding(hadad.base.compiler.model.xq.Utils.conditionEncoding));
                }
            }
        } else {
            conclusion.addAll(
                    block.getPattern().encoding(hadad.base.compiler.model.aj.Utils.conditionEncoding));
        }
        return new Tgd(premise, conclusion);
    }

    // SPPJ Rootblock Extract Constraint
    private Constraint getConstraintForExtractSPPJ(final RootBlock block) {
        final List<Atom> premise = new ArrayList<Atom>();
        final List<String> models = block.getPattern().getConditional().getModels();
        premise.add(hadad.base.compiler.model.sppj.Utils.getExtractAtom(block));
        final List<Atom> conclusion = new ArrayList<Atom>();
        if (!models.isEmpty()) {
            for (String model : models) {
                switch (model) {
                    case "AJ":
                        conclusion.addAll(block.getPattern()
                                .encoding(hadad.base.compiler.model.aj.Utils.conditionEncoding));
                        break;
                    case "SPPJ":
                        conclusion.addAll(block.getPattern()
                                .encoding(hadad.base.compiler.model.sppj.Utils.conditionEncoding));
                        break;
                    case "XQ":
                        conclusion.addAll(block.getPattern()
                                .encoding(hadad.base.compiler.model.xq.Utils.conditionEncoding));
                }
            }
        } else {
            conclusion.addAll(
                    block.getPattern().encoding(hadad.base.compiler.model.aj.Utils.conditionEncoding));
        }
        return new Tgd(premise, conclusion);
    }

    // JQ ChildBlock Extract Constraint
    private Constraint getConstraintForExtractJQ(final ChildBlock block) {
        final List<Atom> premise = new ArrayList<Atom>();
        premise.add(hadad.base.compiler.model.aj.Utils.getExtractAtom(block));
        final List<Atom> conclusion = new ArrayList<Atom>();
        if (!block.getParent().getPattern().isEmpty()) {
            conclusion.add(hadad.base.compiler.model.aj.Utils.getExtractAtom(block.getParent()));
        }
        conclusion.addAll(block.getPattern().encoding(Utils.conditionEncoding));
        return new Tgd(premise, conclusion);
    }

    // JQ ChildBlock Extract Constraint
    private Constraint getConstraintForExtractSPPJ(final ChildBlock block) {
        final List<Atom> premise = new ArrayList<Atom>();
        premise.add(hadad.base.compiler.model.sppj.Utils.getExtractAtom(block));
        final List<Atom> conclusion = new ArrayList<Atom>();
        if (!block.getParent().getPattern().isEmpty()) {
            conclusion.add(hadad.base.compiler.model.sppj.Utils.getExtractAtom(block.getParent()));
        }
        conclusion.addAll(block.getPattern().encoding(Utils.conditionEncoding));
        return new Tgd(premise, conclusion);
    }

    // JQ Block getConstraintRelatingExtractWithCreateJQ
    private Constraint getConstraintRelatingExtractWithCreateJQ(final Block block) {
        final List<Atom> premise = new ArrayList<Atom>();
        premise.add(hadad.base.compiler.model.aj.Utils.getCreateAtom(block));
        final List<Atom> conclusion = new ArrayList<Atom>();
        conclusion.add(hadad.base.compiler.model.aj.Utils.getExtractAtom(block));
        for (final Atom skolemFunction : hadad.base.compiler.model.aj.Utils.getSkolemFunctions(block)) {
            conclusion.add(skolemFunction);

        }
        return new Tgd(premise, conclusion);
    }

    // SPPJ Block getConstraintRelatingExtractWithCreateJQ
    private Constraint getConstraintRelatingExtractWithCreateSPPJ(final Block block) {
        final List<Atom> premise = new ArrayList<Atom>();
        premise.add(hadad.base.compiler.model.sppj.Utils.getCreateAtom(block));
        final List<Atom> conclusion = new ArrayList<Atom>();
        conclusion.add(hadad.base.compiler.model.sppj.Utils.getExtractAtom(block));
        for (final Atom skolemFunction : hadad.base.compiler.model.sppj.Utils.getSkolemFunctions(block)) {
            conclusion.add(skolemFunction);
        }
        return new Tgd(premise, conclusion);
    }

    // JQ RootBlock getConstraintForTypeInferneceJQ
    private List<Constraint> getConstraintForTypeInferneceJQ(final RootBlock block) {
        final List<Constraint> constraints = new ArrayList<Constraint>();
        final List<Atom> skolemFunctions = hadad.base.compiler.model.aj.Utils.getSkolemFunctions(block);
        for (int i = 1; i < skolemFunctions.size(); i++) {
            final List<Atom> premise = new ArrayList<Atom>();
            final List<Atom> conclusion = new ArrayList<Atom>();
            final Variable varVal = new Variable(skolemFunctions.get(i).getTerm(0).toString().substring(0,
                    skolemFunctions.get(i).getTerm(0).toString().lastIndexOf("_")));
            premise.add(skolemFunctions.get(i));
            conclusion.add(new Atom(hadad.base.compiler.model.aj.Predicate.VAL.toString(),
                    (Variable) skolemFunctions.get(i).getTerm(0), varVal));
            constraints.add(new Tgd(premise, conclusion));

        }
        return constraints;
    }

    // JQ ChildBlock getConstraintForTypeInferneceJQ
    private Constraint getConstraintForTypeInferneceJQ(final ChildBlock block) {
        final List<Atom> premise = new ArrayList<Atom>();
        final List<Atom> skolemFunctions = hadad.base.compiler.model.aj.Utils.getSkolemFunctions(block);
        premise.add(skolemFunctions.get(skolemFunctions.size() - 1));
        final List<Atom> conclusion = new ArrayList<Atom>();
        conclusion.add(new Atom(hadad.base.compiler.model.aj.Predicate.VAL.toString(),
                (Variable) skolemFunctions.get(skolemFunctions.size() - 1).getTerm(0),
                (Variable) skolemFunctions.get(skolemFunctions.size() - 1).getTerm(1)));
        return new Tgd(premise, conclusion);
    }

    // SPPJ RootBlock getConstraintForTypeInferneceJQ
    private List<Constraint> getConstraintForTypeInferneceSPPJ(final RootBlock block) {
        final List<Constraint> constraints = new ArrayList<Constraint>();
        final List<Atom> skolemFunctions = hadad.base.compiler.model.sppj.Utils.getSkolemFunctions(block);
        for (int i = 1; i < skolemFunctions.size(); i++) {
            final List<Atom> premise = new ArrayList<Atom>();
            final List<Atom> conclusion = new ArrayList<Atom>();
            final Variable varVal = new Variable(skolemFunctions.get(i).getTerm(0).toString().substring(0,
                    skolemFunctions.get(i).getTerm(0).toString().lastIndexOf("_")));
            premise.add(skolemFunctions.get(i));
            conclusion.add(new Atom(hadad.base.compiler.model.sppj.Predicate.VAL.toString(),
                    (Variable) skolemFunctions.get(i).getTerm(0), varVal));
            constraints.add(new Tgd(premise, conclusion));

        }
        return constraints;
    }

    // SPPJ RootBlock getConstraintForTypeInferneceJQ
    private Constraint getConstraintForTypeInferneceSPPJ(final ChildBlock block) {
        final List<Atom> premise = new ArrayList<Atom>();
        final List<Atom> skolemFunctions = hadad.base.compiler.model.sppj.Utils.getSkolemFunctions(block);
        premise.add(skolemFunctions.get(skolemFunctions.size() - 1));
        final List<Atom> conclusion = new ArrayList<Atom>();
        conclusion.add(new Atom(hadad.base.compiler.model.sppj.Predicate.VAL.toString(),
                (Variable) skolemFunctions.get(skolemFunctions.size() - 1).getTerm(0),
                (Variable) skolemFunctions.get(skolemFunctions.size() - 1).getTerm(1)));
        return new Tgd(premise, conclusion);

    }

    // JQ Rootblock getConstraintConnectingCreateToJSONConstructedByView
    private List<Constraint> getConstraintConnectingCreateToJSONConstructedByView(final RootBlock block) {
        final List<List<Atom>> premises =
                blockBackwardEncoderReturnTermVisitorAJ.encode(block.getReturnTemplate(), block.getQueryName());
        final List<Atom> conclusion = new ArrayList<Atom>();
        conclusion.add(hadad.base.compiler.model.aj.Utils.getCreateAtom(block));

        final List<Constraint> constraints = new ArrayList<Constraint>();
        for (final List<Atom> premise : premises) {
            constraints.add(new Tgd(premise, conclusion));
        }
        return constraints;
    }

    // SPPQ Rootblock getConstraintConnectingCreateToJSONConstructedByView
    private List<Constraint> getConstraintConnectingCreateToJSONConstructedByViewSPPJ(final RootBlock block) {
        final List<List<Atom>> premises =
                blockBackwardEncoderReturnTermVisitorSPPJ.encode(block.getReturnTemplate(), block.getQueryName());
        final List<Atom> conclusion = new ArrayList<Atom>();
        conclusion.add(hadad.base.compiler.model.sppj.Utils.getCreateAtom(block));

        final List<Constraint> constraints = new ArrayList<Constraint>();
        for (final List<Atom> premise : premises) {
            constraints.add(new Tgd(premise, conclusion));
        }
        return constraints;
    }

    // JQ ChildBlock getConstraintConnectingCreateToJSONConstructedByView
    private List<Constraint> getConstraintConnectingCreateToJSONConstructedByView(final ChildBlock block) {
        final List<List<Atom>> premises = blockBackwardEncoderReturnTermVisitorAJ.encode(block.getCreatedNode(),
                block.getReturnTemplate(), block.getQueryName());

        final List<Atom> conclusion = new ArrayList<Atom>();
        conclusion.add(hadad.base.compiler.model.aj.Utils.getCreateAtom(block));
        conclusion.addAll(hadad.base.compiler.model.aj.Utils.getSkolemFunctions(block));

        final List<Constraint> constraints = new ArrayList<Constraint>();
        for (final List<Atom> premise : premises) {
            final List<Atom> premiseAux = new ArrayList<Atom>();
            if (!block.getParent().getPattern().isEmpty()) {
                premiseAux.add(hadad.base.compiler.model.aj.Utils.getParentCreateSkolemFunction(block));
            }
            premiseAux.add(hadad.base.compiler.model.aj.Utils.getCreateAtom(block.getParent()));
            premiseAux.addAll(premise);
            constraints.add(new Tgd(premiseAux, conclusion));
        }
        return constraints;
    }

    // SPPJ ChildBlock getConstraintConnectingCreateToJSONConstructedByView
    private List<Constraint> getConstraintConnectingCreateToJSONConstructedByViewSPPJ(final ChildBlock block) {
        final List<List<Atom>> premises = blockBackwardEncoderReturnTermVisitorSPPJ.encode(block.getCreatedNode(),
                block.getReturnTemplate(), block.getQueryName());

        final List<Atom> conclusion = new ArrayList<Atom>();
        conclusion.add(hadad.base.compiler.model.sppj.Utils.getCreateAtom(block));
        conclusion.addAll(hadad.base.compiler.model.sppj.Utils.getSkolemFunctions(block));

        final List<Constraint> constraints = new ArrayList<Constraint>();
        for (final List<Atom> premise : premises) {
            final List<Atom> premiseAux = new ArrayList<Atom>();
            if (!block.getParent().getPattern().isEmpty()) {
                premiseAux.add(hadad.base.compiler.model.sppj.Utils.getParentCreateSkolemFunction(block));
            }
            premiseAux.add(hadad.base.compiler.model.sppj.Utils.getCreateAtom(block.getParent()));
            premiseAux.addAll(premise);
            constraints.add(new Tgd(premiseAux, conclusion));
        }
        return constraints;
    }

    // KQ getBackwardConstraintForBodyEncoding
    private Constraint getBackwardConstraintForBodyEncodingRK(final RootBlock block) {
        final String queryName = block.getQueryName();
        final List<Atom> premise = new ArrayList<Atom>();
        final List<Atom> conclusion = new ArrayList<Atom>();
        premise.addAll(extractVariableToCreatedNodeVisitorRK.encode(viewSetID, queryName));
        premise.add(hadad.base.compiler.model.rk.Utils.getCollectionAtom(block, viewSetID));
        final List<String> models = block.getPattern().getConditional().getModels();
        if (!models.isEmpty()) {
            for (String model : models) {
                switch (model) {
                    case "AJ":
                        conclusion.addAll(block.getPattern()
                                .encoding(hadad.base.compiler.model.aj.Utils.conditionEncoding));
                        break;
                    case "SPPJ":
                        conclusion.addAll(block.getPattern()
                                .encoding(hadad.base.compiler.model.sppj.Utils.conditionEncoding));
                        break;
                    case "XQ":
                        conclusion.addAll(block.getPattern()
                                .encoding(hadad.base.compiler.model.xq.Utils.conditionEncoding));
                }
            }
        } else {
            conclusion.addAll(
                    block.getPattern().encoding(hadad.base.compiler.model.rk.Utils.conditionEncoding));
        }
        conclusion.addAll(extractVariableToCreatedNodeVisitorRK.encode(block.getReturnTemplate(), queryName));

        return new Tgd(premise, conclusion);
    }

    private Constraint getBackwardConstraintForBodyEncodingSJ(final RootBlock block) {
        final String queryName = block.getQueryName();
        final List<Atom> premise = new ArrayList<Atom>();
        final List<Atom> conclusion = new ArrayList<Atom>();
        extractVariableToCreatedNodeVisitorSJ.encode(viewSetID, queryName);
        premise.addAll(extractVariableToCreatedNodeVisitorSJ.encode(block.getReturnTemplate()));
        premise.add(hadad.base.compiler.model.sj.Utils.createRootAtom(viewSetID, queryName));
        conclusion.addAll(block.getPattern().encoding(hadad.base.compiler.model.sj.Utils.conditionEncoding));
        return new Tgd(premise, conclusion);
    }

    private Constraint getBackwardConstraintForBodyEncodinPJ(final RootBlock block) {
        final String queryName = block.getQueryName();
        final List<Atom> conclusion = new ArrayList<Atom>();
        final List<String> models = block.getPattern().getConditional().getModels();
        if (!models.isEmpty()) {
            for (String model : models) {
                switch (model) {
                    case "PJ":
                        conclusion.addAll(modifiedPremise(block.getPattern()
                                .encoding(hadad.base.compiler.model.pj.full.Utils.conditionEncoding)));
                        break;
                    case "AJ":
                        conclusion.addAll(block.getPattern()
                                .encoding(hadad.base.compiler.model.aj.Utils.conditionEncoding));
                        break;
                    case "XQ":
                        conclusion.addAll(block.getPattern()
                                .encoding(hadad.base.compiler.model.xq.Utils.conditionEncoding));

                }
            }
        } else {
            conclusion.addAll(modifiedPremise(
                    block.getPattern().encoding(hadad.base.compiler.model.pj.full.Utils.conditionEncoding)));
        }
        final List<Atom> premise = new ArrayList<Atom>();
        premise.addAll(blockBackwardEncoderReturnTermVisitorPJ.encode(block.getReturnTemplate(), queryName, viewSetID));
        premise.add(hadad.base.compiler.model.pj.full.Utils.createRootAtom(viewSetID, queryName));
        return new Tgd(premise, conclusion);
    }

    private Constraint getBackwardConstraintForBodyEncodinPR(final RootBlock block) {
        final String queryName = block.getQueryName();
        final List<Atom> conclusion = new ArrayList<Atom>();
        final List<String> models = block.getPattern().getConditional().getModels();
        if (!models.isEmpty()) {
            for (String model : models) {
                switch (model) {
                    case "PJ":
                        conclusion.addAll(block.getPattern()
                                .encoding(hadad.base.compiler.model.pj.full.Utils.conditionEncoding));
                        break;
                    case "AJ":
                        conclusion.addAll(block.getPattern()
                                .encoding(hadad.base.compiler.model.aj.Utils.conditionEncoding));
                        break;
                    case "XQ":
                        conclusion.addAll(block.getPattern()
                                .encoding(hadad.base.compiler.model.xq.Utils.conditionEncoding));

                }
            }
        } else {
            conclusion.addAll(
                    block.getPattern().encoding(hadad.base.compiler.model.pr.Utils.conditionEncoding));
        }
        final List<Atom> premise = new ArrayList<Atom>();
        premise.addAll(blockBackwardEncoderReturnTermVisitorPR.encode(block.getReturnTemplate(), queryName));
        return new Tgd(premise, conclusion);
    }

    // XQ
    private List<Constraint> getConstraintConnectingCreateToXMLConstructedByView(final RootBlock block) {
        final List<List<Atom>> premises = blockBackwardEncoderReturnTermVisitorXQ
                .encode(block.getPattern().getDefinitions(), block.getReturnTemplate(), block.getQueryName());

        final List<Atom> conclusion = new ArrayList<Atom>();
        conclusion.add(hadad.base.compiler.model.xq.Utils.getCreateAtom(block));

        final List<Constraint> constraints = new ArrayList<Constraint>();
        for (final List<Atom> premise : premises) {
            constraints.add(new Tgd(premise, conclusion));
        }
        return constraints;
    }

    private List<Constraint> getConstraintConnectingCreateToXMLConstructedByView(final ChildBlock block) {
        final List<List<Atom>> premises =
                blockBackwardEncoderReturnTermVisitorXQ.encode(block.getPattern().getDefinitions(),
                        block.getCreatedNode(), block.getReturnTemplate(), block.getQueryName());

        final List<Atom> conclusion = new ArrayList<Atom>();
        conclusion.add(hadad.base.compiler.model.xq.Utils.getCreateAtom(block));
        conclusion.addAll(hadad.base.compiler.model.xq.Utils.getSkolemFunctions(block));

        final List<Constraint> constraints = new ArrayList<Constraint>();
        for (final List<Atom> premise : premises) {
            final List<Atom> premiseAux = new ArrayList<Atom>();
            if (!block.getParent().getPattern().isEmpty()) {
                premiseAux.add(hadad.base.compiler.model.xq.Utils.getParentCreateSkolemFunction(block));
            }
            premiseAux.add(hadad.base.compiler.model.xq.Utils.getCreateAtom(block.getParent()));
            premiseAux.addAll(premise);
            constraints.add(new Tgd(premiseAux, conclusion));
        }
        return constraints;
    }

    private Constraint getConstraintRelatingExtractWithCreateXQ(final Block block) {
        final String queryName = block.getQueryName();
        final List<Atom> premise = new ArrayList<Atom>();
        premise.add(hadad.base.compiler.model.xq.Utils.getCreateAtom(block));
        final List<Atom> conclusion = new ArrayList<Atom>();
        conclusion.addAll(extractVariableToCreatedNodeVisitorXQ.encode(block.getReturnTemplate(), queryName));
        conclusion.add(hadad.base.compiler.model.xq.Utils.getExtractAtom(block));
        for (final Atom skolemFunction : hadad.base.compiler.model.xq.Utils.getSkolemFunctions(block)) {
            conclusion.add(skolemFunction);
        }
        return new Tgd(premise, conclusion);
    }

    private Constraint getConstraintForExtractXQ(final RootBlock block) {
        final List<Atom> premise = new ArrayList<Atom>();
        premise.add(hadad.base.compiler.model.xq.Utils.getExtractAtom(block));
        final List<Atom> conclusion = new ArrayList<Atom>();
        final List<String> models = block.getPattern().getConditional().getModels();
        for (String model : models) {
            switch (model) {
                case "AJ":
                    conclusion.addAll(block.getPattern()
                            .encoding(hadad.base.compiler.model.aj.Utils.conditionEncoding));
                    break;
                case "SPPJ":
                    conclusion.addAll(block.getPattern()
                            .encoding(hadad.base.compiler.model.sppj.Utils.conditionEncoding));
                    break;
                case "XQ":
                    conclusion.addAll(block.getPattern()
                            .encoding(hadad.base.compiler.model.xq.Utils.conditionEncoding));
            }
        }
        return new Tgd(premise, conclusion);
    }

    private Constraint getConstraintForExtractXQ(final ChildBlock block) {
        final List<Atom> premise = new ArrayList<Atom>();
        premise.add(hadad.base.compiler.model.xq.Utils.getExtractAtom(block));
        final List<Atom> conclusion = new ArrayList<Atom>();
        if (!block.getParent().getPattern().isEmpty()) {
            conclusion.add(hadad.base.compiler.model.xq.Utils.getExtractAtom(block.getParent()));
        }
        conclusion.addAll(block.getPattern().encoding(hadad.base.compiler.model.xq.Utils.conditionEncoding));
        return new Tgd(premise, conclusion);
    }

    /**
     * Temporary implementation to resolve join condition
     * 
     * @param premise
     *            PJ premise.
     * @return updated PJ premise.
     */
    private List<Atom> modifiedPremise(final List<Atom> premise) {
        final List<Atom> copyList = new ArrayList<>(premise);
        final List<Atom> updatedAtoms = new ArrayList<>();
        final List<Term> joinTerms = new ArrayList<Term>();
        final Iterator<Atom> itertaor = copyList.listIterator();
        while (itertaor.hasNext()) {
            final Atom atom = itertaor.next();
            if (atom.getTerms().size() == 2 && atom.getPredicate().equals(Predicate.VAL.toString())) {
                if (atom.getTerms().get(0) instanceof Variable && atom.getTerms().get(1) instanceof Variable) {
                    joinTerms.add(atom.getTerms().get(0));
                    joinTerms.add(atom.getTerms().get(1));
                    itertaor.remove();
                }
            }
        }
        for (final Atom atom : copyList) {
            int index = -1;
            if (atom.getTerms().contains(joinTerms.get(0))) {
                index = atom.getTerms().indexOf(joinTerms.get(0));

            } else {
                if (atom.getTerms().contains(joinTerms.get(1))) {
                    index = atom.getTerms().indexOf(joinTerms.get(1));
                } else {
                    updatedAtoms.add(atom);
                }
            }
            if (index != -1) {
                final List<Term> terms = new ArrayList<Term>();
                terms.addAll(atom.getTerms());
                terms.set(index, joinTerms.get(0));
                final Atom atomNew = new Atom(atom.getPredicate(), terms);
                updatedAtoms.add(atomNew);
            }
        }
        return updatedAtoms;
    }

}