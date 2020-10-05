package hadad.base.compiler.model.qbt.naive;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.Term;
import hadad.commons.conjunctivequery.Variable;
import hadad.commons.constraints.Constraint;
import hadad.commons.constraints.Tgd;
import hadad.base.compiler.model.pr.naive.PRRootBlockForwardEncoderReturnTermVisitor;
import hadad.base.compiler.model.sj.SJExtractVariableToCreatedNodeVisitor;
import hadad.base.rewriter.Comment;
import hadad.base.compiler.Block;
import hadad.base.compiler.ChildBlock;
import hadad.base.compiler.QueryBlockTree;
import hadad.base.compiler.QueryBlockTreeVisitor;
import hadad.base.compiler.RootBlock;
import hadad.base.compiler.model.aj.AJExtractVariableToCreatedNodeVisitor;
import hadad.base.compiler.model.aj.Utils;
import hadad.base.compiler.model.aj.naive.AJChildBlockForwardEncoderReturnTermVisitor;
import hadad.base.compiler.model.aj.naive.AJRootBlockForwardEncoderReturnTermVisitor;
import hadad.base.compiler.model.pj.full.Predicate;
import hadad.base.compiler.model.pj.full.naive.PJFullRootBlockForwardEncoderReturnTermVisitor;
import hadad.base.compiler.model.rk.RKExtractVariableToCreatedNodeVisitor;
import hadad.base.compiler.model.sppj.SPPJExtractVariableToCreatedNodeVisitor;
import hadad.base.compiler.model.sppj.naive.SPPJChildBlockForwardEncoderReturnTermVisitor;
import hadad.base.compiler.model.sppj.naive.SPPJRootBlockForwardEncoderReturnTermVisitor;
import hadad.base.compiler.model.xq.XQExtractVariableToCreatedNodeVisitor;
import hadad.base.compiler.model.xq.naive.XQChildBlockForwardEncoderReturnTermVisitor;
import hadad.base.compiler.model.xq.naive.XQRootBlockForwardEncoderReturnTermVisitor;

@Singleton
class QBTForwardEncoderNestedBlockTreeVisitor implements QueryBlockTreeVisitor {
    private final AJExtractVariableToCreatedNodeVisitor extractVariableToCreatedNodeVisitorAJ;
    private final SPPJExtractVariableToCreatedNodeVisitor extractVariableToCreatedNodeVisitorSPPJ;
    private final SJExtractVariableToCreatedNodeVisitor extractVariableToCreatedNodeVisitorSJ;
    private final XQExtractVariableToCreatedNodeVisitor extractVariableToCreatedNodeVisitorXQ;
    private final RKExtractVariableToCreatedNodeVisitor extractVariableToCreatedNodeVisitorRK;

    private final AJRootBlockForwardEncoderReturnTermVisitor rootBlockForwardEncoderReturnTermVisitorAJ;
    private final AJChildBlockForwardEncoderReturnTermVisitor childBlockForwardEncoderReturnTermVisitorAJ;
    private final SPPJRootBlockForwardEncoderReturnTermVisitor rootBlockForwardEncoderReturnTermVisitorSPPJ;
    private final SPPJChildBlockForwardEncoderReturnTermVisitor childBlockForwardEncoderReturnTermVisitorSPPJ;
    private final XQRootBlockForwardEncoderReturnTermVisitor rootBlockForwardEncoderReturnTermVisitorXQ;
    private final XQChildBlockForwardEncoderReturnTermVisitor childBlockForwardEncoderReturnTermVisitorXQ;
    private final PJFullRootBlockForwardEncoderReturnTermVisitor pJForwardEncoderReturnTermVisitor;
    private final PRRootBlockForwardEncoderReturnTermVisitor pRForwardEncoderReturnTermVisitor;

    private Variable viewSetID;
    private ImmutableList.Builder<Constraint> builder;
    private boolean includeComments;

    @Inject
    public QBTForwardEncoderNestedBlockTreeVisitor(
            final AJRootBlockForwardEncoderReturnTermVisitor rootBlockForwardEncoderReturnTermVisitorAJ,
            final AJChildBlockForwardEncoderReturnTermVisitor childBlockForwardEncoderReturnTermVisitorAJ,
            final SPPJRootBlockForwardEncoderReturnTermVisitor rootBlockForwardEncoderReturnTermVisitorSPPJ,
            final SPPJChildBlockForwardEncoderReturnTermVisitor childBlockForwardEncoderReturnTermVisitorSPPJ,
            final XQRootBlockForwardEncoderReturnTermVisitor rootBlockForwardEncoderReturnTermVisitorXQ,
            final XQChildBlockForwardEncoderReturnTermVisitor childBlockForwardEncoderReturnTermVisitorXQ,
            final AJExtractVariableToCreatedNodeVisitor extractVariableToCreatedNodeVisitorAJ,
            final SPPJExtractVariableToCreatedNodeVisitor extractVariableToCreatedNodeVisitorSPPJ,
            final SJExtractVariableToCreatedNodeVisitor extractVariableToCreatedNodeVisitorSJ,
            final RKExtractVariableToCreatedNodeVisitor extractVariableToCreatedNodeVisitorRK,
            final XQExtractVariableToCreatedNodeVisitor extractVariableToCreatedNodeVisitorXQ,
            final PJFullRootBlockForwardEncoderReturnTermVisitor pJForwardEncoderReturnTermVisitor,
            final PRRootBlockForwardEncoderReturnTermVisitor pRForwardEncoderReturnTermVisitor) {

        this.extractVariableToCreatedNodeVisitorAJ = extractVariableToCreatedNodeVisitorAJ;
        this.extractVariableToCreatedNodeVisitorSPPJ = extractVariableToCreatedNodeVisitorSPPJ;
        this.extractVariableToCreatedNodeVisitorXQ = extractVariableToCreatedNodeVisitorXQ;
        this.extractVariableToCreatedNodeVisitorRK = extractVariableToCreatedNodeVisitorRK;
        this.extractVariableToCreatedNodeVisitorSJ = extractVariableToCreatedNodeVisitorSJ;
        this.rootBlockForwardEncoderReturnTermVisitorAJ = rootBlockForwardEncoderReturnTermVisitorAJ;
        this.rootBlockForwardEncoderReturnTermVisitorSPPJ = rootBlockForwardEncoderReturnTermVisitorSPPJ;
        this.rootBlockForwardEncoderReturnTermVisitorXQ = rootBlockForwardEncoderReturnTermVisitorXQ;
        this.childBlockForwardEncoderReturnTermVisitorAJ = childBlockForwardEncoderReturnTermVisitorAJ;
        this.childBlockForwardEncoderReturnTermVisitorSPPJ = childBlockForwardEncoderReturnTermVisitorSPPJ;
        this.childBlockForwardEncoderReturnTermVisitorXQ = childBlockForwardEncoderReturnTermVisitorXQ;
        this.pJForwardEncoderReturnTermVisitor = pJForwardEncoderReturnTermVisitor;
        this.pRForwardEncoderReturnTermVisitor = pRForwardEncoderReturnTermVisitor;
        this.viewSetID = null;
    }

    public List<Constraint> compileConstraints(final QueryBlockTree nbt, boolean includeComments,
            final Variable viewSetID) {
        this.viewSetID = viewSetID;
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
                builder.add(new Comment(block.getQueryName() + " constraint for extract"));
            }
            switch (block.getReturnTemplate().getModel()) {
                case "RK":
                    builder.add(getForwardConstraintForBodyEncodingRK(block));
                    break;
                case "PJ":
                    builder.add(getForwardConstraintForBodyEncodingPJ(block));
                    break;
                case "PR":
                    builder.add(getForwardConstraintForBodyEncodingPR(block));
                    break;
                case "AJ":
                    buildBForwardRootBlockJQ(block);
                    break;
                case "SJ":
                    builder.add(getForwardConstraintForBodyEncodingSJ(block));
                    break;
                case "SPPJ":
                    buildBForwardRootBlockSPPJ(block);
                    break;
                case "XQ":
                    buildForwardRootBlockXQ(block);
                    break;
            }

        }
    }

    @Override
    public void visit(final ChildBlock block) {
        if (!block.getPattern().isEmpty()) {
            if (includeComments) {
                builder.add(new Comment(block.getQueryName() + " constraint for extract"));
            }
            switch (block.getReturnTemplate().getModel()) {
                case "AJ":
                    buildForwardChildBlockJQ(block);
                    break;
                case "SPPJ":
                    buildForwardChildBlockSPPJ(block);
                    break;
                case "XQ":
                    buildForwardChildBlockXQ(block);
                    break;
            }

        }

    }

    /**
     * Building forward constraints JQ ChildBlock
     * 
     * @param block
     *            JQ Child block
     */
    private void buildForwardChildBlockJQ(final ChildBlock block) {
        builder.add(getConstraintForExtractJQ(block));
        if (includeComments) {
            builder.add(new Comment(block.getId() + " constraint relating extract with create"));
        }
        builder.add(getConstraintRelatingExtractWithCreateJQ(block));
        if (includeComments) {
            builder.add(new Comment(block.getId() + " constraint connecting create to JSON constructed by view"));
        }
        builder.add(getConstraintConnectingCreateToJSONConstructedByViewJQ(block));
        if (!block.getPattern().isEmpty()) {
            final List<Constraint> skolemFunctions = getConstraintForSkolemFunctions(block);
            if (includeComments && !skolemFunctions.isEmpty()) {
                builder.add(new Comment(block.getId() + " constraints for skolem functions"));
            }
            builder.addAll(skolemFunctions);
        }
    }

    /**
     * Building forward constraints SPPJ ChildBlock
     * 
     * @param block
     *            SPPJ Child block
     */
    private void buildForwardChildBlockSPPJ(final ChildBlock block) {
        builder.add(getConstraintForExtractSPPJ(block));
        if (includeComments) {
            builder.add(new Comment(block.getId() + " constraint relating extract with create"));
        }
        builder.add(getConstraintRelatingExtractWithCreateSPPJ(block));
        if (includeComments) {
            builder.add(new Comment(block.getId() + " constraint connecting create to JSON constructed by view"));
        }
        builder.add(getConstraintConnectingCreateToJSONConstructedByViewSPPJ(block));
        if (!block.getPattern().isEmpty()) {
            final List<Constraint> skolemFunctions = getConstraintForSkolemFunctions(block);
            if (includeComments && !skolemFunctions.isEmpty()) {
                builder.add(new Comment(block.getId() + " constraints for skolem functions"));
            }
            builder.addAll(skolemFunctions);
        }
    }

    /**
     * Building forward constraints JQ RootBlock
     * 
     * @param block
     *            JQ Root block
     */
    private void buildBForwardRootBlockJQ(final RootBlock block) {
        builder.add(getConstraintForExtractJQ(block));
        if (includeComments) {
            builder.add(new Comment(block.getId() + " constraint relating extract with create"));
        }
        builder.add(getConstraintRelatingExtractWithCreateJQ(block));
        if (includeComments) {
            builder.add(new Comment(block.getId() + " constraint connecting create to JSON constructed by view"));
        }
        builder.add(getConstraintConnectingCreateToJSONConstructedByViewJQ(block));
        if (!block.getPattern().isEmpty()) {
            final List<Constraint> skolemFunctions = getConstraintForSkolemFunctions(block);
            if (includeComments && !skolemFunctions.isEmpty()) {
                builder.add(new Comment(block.getId() + " constraints for skolem functions"));
            }
            builder.addAll(skolemFunctions);
            if (includeComments) {
                builder.add(new Comment(block.getId() + " constraints for type inference"));
            }
            builder.addAll(getConstraintForTypeInfernece(block));
        }
    }

    /**
     * Building forward constraints SPPJ RootBlock
     * 
     * @param block
     *            SPPJ Root block
     */
    private void buildBForwardRootBlockSPPJ(final RootBlock block) {
        builder.add(getConstraintForExtractSPPJ(block));
        if (includeComments) {
            builder.add(new Comment(block.getId() + " constraint relating extract with create"));
        }
        builder.add(getConstraintRelatingExtractWithCreateSPPJ(block));
        if (includeComments) {
            builder.add(new Comment(block.getId() + " constraint connecting create to JSON constructed by view"));
        }
        builder.add(getConstraintConnectingCreateToJSONConstructedByViewSPPJ(block));
        if (!block.getPattern().isEmpty()) {
            final List<Constraint> skolemFunctions = getConstraintForSkolemFunctions(block);
            if (includeComments && !skolemFunctions.isEmpty()) {
                builder.add(new Comment(block.getId() + " constraints for skolem functions"));
            }
            builder.addAll(skolemFunctions);
            if (includeComments) {
                builder.add(new Comment(block.getId() + " constraints for type inference"));
            }
            builder.addAll(getConstraintForTypeInferneceSPPJ(block));
        }
    }

    /**
     * Building forward constraints XQ RootBlock
     * 
     * @param block
     *            XQ Root block
     */
    private void buildForwardRootBlockXQ(final RootBlock block) {
        builder.add(getConstraintForExtractXQ(block));

        if (includeComments) {
            builder.add(new Comment(block.getId() + " constraint relating extract with create"));
        }
        builder.add(getConstraintRelatingExtractWithCreateXQ(block));
        if (includeComments) {
            builder.add(new Comment(block.getId() + " constraint connecting create to XML constructed by view"));
        }
        builder.add(getConstraintConnectingCreateToXMLConstructedByView(block));
        if (!block.getPattern().isEmpty()) {
            final List<Constraint> skolemFunctions = getConstraintForSkolemFunctions(block);
            if (includeComments && !skolemFunctions.isEmpty()) {
                builder.add(new Comment(block.getId() + " constraints for skolem functions"));
            }
            builder.addAll(skolemFunctions);

        }
    }

    /**
     * Building forward constraints XQ ChildBlock
     * 
     * @param block
     *            XQ Child block
     */
    private void buildForwardChildBlockXQ(final ChildBlock block) {
        builder.add(getConstraintForExtractXQ(block));

        if (includeComments) {
            builder.add(new Comment(block.getId() + " constraint relating extract with create"));
        }
        builder.add(getConstraintRelatingExtractWithCreateXQ(block));
        if (includeComments) {
            builder.add(new Comment(block.getId() + " constraint connecting create to XML constructed by view"));
        }
        builder.add(getConstraintConnectingCreateToXMLConstructedByView(block));
        if (!block.getPattern().isEmpty()) {
            final List<Constraint> skolemFunctions = getConstraintForSkolemFunctions(block);
            if (includeComments && !skolemFunctions.isEmpty()) {
                builder.add(new Comment(block.getId() + " constraints for skolem functions"));
            }
            builder.addAll(skolemFunctions);
        }
    }

    /**
     * Get forward constraints RK body
     * 
     * @param block
     *            RK RootBlock
     * @return the encoded constraints
     */
    private Constraint getForwardConstraintForBodyEncodingRK(final RootBlock block) {
        final String queryName = block.getQueryName();
        final List<Atom> premise = new ArrayList<Atom>();
        final List<String> models = block.getPattern().getConditional().getModels();
        if (!models.isEmpty()) {
            for (String model : models) {
                switch (model) {
                    case "AJ":
                        premise.addAll(block.getPattern()
                                .encoding(hadad.base.compiler.model.aj.Utils.conditionEncoding));
                        break;
                    case "XQ":
                        premise.addAll(block.getPattern()
                                .encoding(hadad.base.compiler.model.xq.Utils.conditionEncoding));

                }
            }
        } else {
            premise.addAll(
                    block.getPattern().encoding(hadad.base.compiler.model.rk.Utils.conditionEncoding));
        }
        final List<Atom> conclusion = new ArrayList<Atom>();
        conclusion.addAll(extractVariableToCreatedNodeVisitorRK.encode(block.getReturnTemplate(), queryName));
        conclusion.addAll(extractVariableToCreatedNodeVisitorRK.encode(viewSetID, queryName));
        conclusion.add(hadad.base.compiler.model.rk.Utils.getCollectionAtom(block, viewSetID));
        return new Tgd(premise, conclusion);
    }

    /**
     * Get forward constraints PJ body
     * 
     * @param block
     *            PJ RootBlock
     * @return the encoded constraints
     */
    private Constraint getForwardConstraintForBodyEncodingPJ(final RootBlock block) {
        final String queryName = block.getQueryName();
        final List<Atom> premise = new ArrayList<Atom>();
        final List<String> models = block.getPattern().getConditional().getModels();
        if (!models.isEmpty()) {
            for (String model : models) {
                switch (model) {
                    case "PJ":
                        premise.addAll(modifiedPremise(block.getPattern()
                                .encoding(hadad.base.compiler.model.pj.full.Utils.conditionEncoding)));
                        break;
                    case "AJ":
                        premise.addAll(block.getPattern()
                                .encoding(hadad.base.compiler.model.aj.Utils.conditionEncoding));
                        break;
                    case "XQ":
                        premise.addAll(block.getPattern()
                                .encoding(hadad.base.compiler.model.xq.Utils.conditionEncoding));

                }
            }
        } else {
            premise.addAll(modifiedPremise(
                    block.getPattern().encoding(hadad.base.compiler.model.pj.full.Utils.conditionEncoding)));
        }
        final List<Atom> conclusion = new ArrayList<Atom>();
        conclusion.addAll(pJForwardEncoderReturnTermVisitor.encode(block.getReturnTemplate(), queryName, viewSetID));
        conclusion.add(hadad.base.compiler.model.pj.full.Utils.createRootAtom(viewSetID, queryName));
        return new Tgd(premise, conclusion);
    }

    /**
     * Get forward constraints PR body
     * 
     * @param block
     *            PR RootBlock
     * @return the encoded constraints
     */
    private Constraint getForwardConstraintForBodyEncodingPR(final RootBlock block) {
        final String queryName = block.getQueryName();
        final List<Atom> premise = new ArrayList<Atom>();
        final List<String> models = block.getPattern().getConditional().getModels();
        if (!models.isEmpty()) {
            for (String model : models) {
                switch (model) {
                    case "PJ":
                        premise.addAll(block.getPattern()
                                .encoding(hadad.base.compiler.model.pj.full.Utils.conditionEncoding));
                        break;
                    case "AJ":
                        premise.addAll(block.getPattern()
                                .encoding(hadad.base.compiler.model.aj.Utils.conditionEncoding));
                        break;
                    case "XQ":
                        premise.addAll(block.getPattern()
                                .encoding(hadad.base.compiler.model.xq.Utils.conditionEncoding));

                }
            }
        } else {
            premise.addAll(
                    block.getPattern().encoding(hadad.base.compiler.model.pr.Utils.conditionEncoding));
        }
        final List<Atom> conclusion = new ArrayList<Atom>();
        conclusion.addAll(pRForwardEncoderReturnTermVisitor.encode(block.getReturnTemplate(), queryName));
        return new Tgd(premise, conclusion);
    }

    /**
     * Get forward constraints SJ body
     * 
     * @param block
     *            SJ RootBlock
     * @return the encoded constraints
     */
    private Constraint getForwardConstraintForBodyEncodingSJ(final RootBlock block) {
        final String queryName = block.getQueryName();
        final List<Atom> premise = new ArrayList<Atom>();
        premise.addAll(block.getPattern().encoding(hadad.base.compiler.model.sj.Utils.conditionEncoding));
        final List<Atom> conclusion = new ArrayList<Atom>();
        extractVariableToCreatedNodeVisitorSJ.encode(viewSetID, queryName);
        conclusion.addAll(extractVariableToCreatedNodeVisitorSJ.encode(block.getReturnTemplate()));
        conclusion.add(hadad.base.compiler.model.sj.Utils.createRootAtom(viewSetID, queryName));
        return new Tgd(premise, conclusion);
    }

    /**
     * Get constraints for extract AJ
     * 
     * @param block
     *            AJ RootBlock
     * @return the encoded constraints
     */
    private Constraint getConstraintForExtractJQ(final RootBlock block) {
        final List<Atom> premise = new ArrayList<Atom>();
        final List<String> models = block.getPattern().getConditional().getModels();
        if (!models.isEmpty()) {
            for (String model : models) {
                switch (model) {
                    case "AJ":
                        premise.addAll(block.getPattern()
                                .encoding(hadad.base.compiler.model.aj.Utils.conditionEncoding));
                        break;
                    case "SJ":
                        premise.addAll(block.getPattern()
                                .encoding(hadad.base.compiler.model.sj.Utils.conditionEncoding));
                        break;
                    case "XQ":
                        premise.addAll(block.getPattern()
                                .encoding(hadad.base.compiler.model.xq.Utils.conditionEncoding));
                }
            }
        } else {
            premise.addAll(
                    block.getPattern().encoding(hadad.base.compiler.model.aj.Utils.conditionEncoding));
        }
        final List<Atom> conclusion = new ArrayList<Atom>();
        conclusion.add(hadad.base.compiler.model.aj.Utils.getExtractAtom(block));
        return new Tgd(premise, conclusion);
    }

    /**
     * Get constraints for extract SPPJ RootBlock
     * 
     * @param block
     *            SPPJ RootBlock
     * @return the encoded constraints
     */
    private Constraint getConstraintForExtractSPPJ(final RootBlock block) {
        final List<Atom> premise = new ArrayList<Atom>();
        final List<String> models = block.getPattern().getConditional().getModels();
        if (!models.isEmpty()) {
            for (String model : models) {
                switch (model) {
                    case "AJ":
                        premise.addAll(block.getPattern()
                                .encoding(hadad.base.compiler.model.aj.Utils.conditionEncoding));
                        break;
                    case "SPPJ":
                        premise.addAll(block.getPattern()
                                .encoding(hadad.base.compiler.model.sppj.Utils.conditionEncoding));
                        break;
                    case "XQ":
                        premise.addAll(block.getPattern()
                                .encoding(hadad.base.compiler.model.xq.Utils.conditionEncoding));
                }
            }
        } else {
            premise.addAll(
                    block.getPattern().encoding(hadad.base.compiler.model.sppj.Utils.conditionEncoding));
        }
        final List<Atom> conclusion = new ArrayList<Atom>();
        conclusion.add(hadad.base.compiler.model.sppj.Utils.getExtractAtom(block));
        return new Tgd(premise, conclusion);
    }

    /**
     * Get constraints for extract AJ ChildBlock
     * 
     * @param block
     *            AJ ChildBlock
     * @return the encoded constraints
     */
    private Constraint getConstraintForExtractJQ(final ChildBlock block) {
        final List<Atom> premise = new ArrayList<Atom>();
        if (!block.getParent().getPattern().isEmpty()) {
            premise.add(Utils.getExtractAtom(block.getParent()));
        }
        premise.addAll(block.getPattern().encoding(hadad.base.compiler.model.aj.Utils.conditionEncoding));
        final List<Atom> conclusion = new ArrayList<Atom>();
        conclusion.add(hadad.base.compiler.model.aj.Utils.getExtractAtom(block));
        return new Tgd(premise, conclusion);
    }

    private Constraint getConstraintForExtractSPPJ(final ChildBlock block) {
        final List<Atom> premise = new ArrayList<Atom>();
        if (!block.getParent().getPattern().isEmpty()) {
            premise.add(Utils.getExtractAtom(block.getParent()));
        }
        premise.addAll(block.getPattern().encoding(hadad.base.compiler.model.sppj.Utils.conditionEncoding));
        final List<Atom> conclusion = new ArrayList<Atom>();
        conclusion.add(hadad.base.compiler.model.sppj.Utils.getExtractAtom(block));
        return new Tgd(premise, conclusion);
    }

    private Constraint getConstraintRelatingExtractWithCreateJQ(final Block block) {

        final String queryName = block.getQueryName();
        final List<Atom> premise = new ArrayList<Atom>();
        if (!block.getPattern().isEmpty()) {
            premise.add(hadad.base.compiler.model.aj.Utils.getExtractAtom(block));
        }
        final List<Atom> conclusion = new ArrayList<Atom>();
        conclusion.addAll(extractVariableToCreatedNodeVisitorAJ.encode(block.getReturnTemplate(), queryName));
        conclusion.add(hadad.base.compiler.model.aj.Utils.getCreateAtom(block));
        if (!block.getPattern().isEmpty()) {
            for (final Atom skolemFunction : hadad.base.compiler.model.aj.Utils.getSkolemFunctions(block)) {
                conclusion.add(skolemFunction);
            }
        }
        return new Tgd(premise, conclusion);
    }

    private Constraint getConstraintRelatingExtractWithCreateSPPJ(final Block block) {

        final String queryName = block.getQueryName();
        final List<Atom> premise = new ArrayList<Atom>();
        if (!block.getPattern().isEmpty()) {
            premise.add(hadad.base.compiler.model.sppj.Utils.getExtractAtom(block));
        }
        final List<Atom> conclusion = new ArrayList<Atom>();
        conclusion.addAll(extractVariableToCreatedNodeVisitorSPPJ.encode(block.getReturnTemplate(), queryName));
        conclusion.add(hadad.base.compiler.model.sppj.Utils.getCreateAtom(block));
        if (!block.getPattern().isEmpty()) {
            for (final Atom skolemFunction : hadad.base.compiler.model.sppj.Utils
                    .getSkolemFunctions(block)) {
                conclusion.add(skolemFunction);
            }
        }
        return new Tgd(premise, conclusion);
    }

    private List<Constraint> getConstraintForTypeInfernece(final RootBlock block) {
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

    private Constraint getConstraintConnectingCreateToJSONConstructedByViewJQ(final RootBlock block) {
        final List<Atom> premise = new ArrayList<Atom>();
        premise.add(hadad.base.compiler.model.aj.Utils.getCreateAtom(block));
        final List<Atom> conclusion =
                rootBlockForwardEncoderReturnTermVisitorAJ.encode(block.getReturnTemplate(), block.getQueryName());
        return new Tgd(premise, conclusion);
    }

    private Constraint getConstraintConnectingCreateToJSONConstructedByViewSPPJ(final RootBlock block) {
        final List<Atom> premise = new ArrayList<Atom>();
        premise.add(hadad.base.compiler.model.sppj.Utils.getCreateAtom(block));
        final List<Atom> conclusion =
                rootBlockForwardEncoderReturnTermVisitorSPPJ.encode(block.getReturnTemplate(), block.getQueryName());
        return new Tgd(premise, conclusion);
    }

    private Constraint getConstraintConnectingCreateToJSONConstructedByViewJQ(final ChildBlock block) {
        final List<Atom> premise = new ArrayList<Atom>();
        premise.add(hadad.base.compiler.model.aj.Utils.getCreateAtom(block.getParent()));
        premise.add(hadad.base.compiler.model.aj.Utils.getCreateAtom(block));
        if (!block.getParent().getPattern().isEmpty()) {
            premise.add(hadad.base.compiler.model.aj.Utils.getParentCreateSkolemFunction(block));
        }
        premise.addAll(hadad.base.compiler.model.aj.Utils.getSkolemFunctions(block));
        final List<Atom> conclusion = childBlockForwardEncoderReturnTermVisitorAJ.encode(block.getCreatedNode(),
                block.getReturnTemplate(), block.getQueryName());
        return new Tgd(premise, conclusion);
    }

    private Constraint getConstraintConnectingCreateToJSONConstructedByViewSPPJ(final ChildBlock block) {
        final List<Atom> premise = new ArrayList<Atom>();
        premise.add(hadad.base.compiler.model.sppj.Utils.getCreateAtom(block.getParent()));
        premise.add(hadad.base.compiler.model.sppj.Utils.getCreateAtom(block));
        if (!block.getParent().getPattern().isEmpty()) {
            premise.add(hadad.base.compiler.model.sppj.Utils.getParentCreateSkolemFunction(block));
        }
        premise.addAll(hadad.base.compiler.model.sppj.Utils.getSkolemFunctions(block));
        final List<Atom> conclusion = childBlockForwardEncoderReturnTermVisitorSPPJ.encode(block.getCreatedNode(),
                block.getReturnTemplate(), block.getQueryName());
        return new Tgd(premise, conclusion);
    }

    private Constraint getConstraintForExtractXQ(final RootBlock block) {
        final List<Atom> premise = new ArrayList<Atom>();
        final List<String> models = block.getPattern().getConditional().getModels();
        for (String model : models) {
            switch (model) {
                case "AJ":
                    premise.addAll(block.getPattern()
                            .encoding(hadad.base.compiler.model.aj.Utils.conditionEncoding));
                    break;
                case "XQ":
                    premise.addAll(block.getPattern()
                            .encoding(hadad.base.compiler.model.xq.Utils.conditionEncoding));
            }
        }
        final List<Atom> conclusion = new ArrayList<Atom>();
        conclusion.add(hadad.base.compiler.model.xq.Utils.getExtractAtom(block));
        return new Tgd(premise, conclusion);
    }

    private Constraint getConstraintForExtractXQ(final ChildBlock block) {
        final List<Atom> premise = new ArrayList<Atom>();
        if (!block.getParent().getPattern().isEmpty()) {
            premise.add(hadad.base.compiler.model.xq.Utils.getExtractAtom(block.getParent()));
        }
        premise.addAll(block.getPattern().encoding(hadad.base.compiler.model.xq.Utils.conditionEncoding));
        final List<Atom> conclusion = new ArrayList<Atom>();
        conclusion.add(hadad.base.compiler.model.xq.Utils.getExtractAtom(block));
        return new Tgd(premise, conclusion);
    }

    private Constraint getConstraintRelatingExtractWithCreateXQ(final Block block) {
        final String queryName = block.getQueryName();
        final List<Atom> premise = new ArrayList<Atom>();
        if (!block.getPattern().isEmpty()) {
            premise.add(hadad.base.compiler.model.xq.Utils.getExtractAtom(block));
        }
        final List<Atom> conclusion = new ArrayList<Atom>();
        conclusion.addAll(extractVariableToCreatedNodeVisitorXQ.encode(block.getReturnTemplate(), queryName));
        conclusion.add(hadad.base.compiler.model.xq.Utils.getCreateAtom(block));
        if (!block.getPattern().isEmpty()) {
            for (final Atom skolemFunction : hadad.base.compiler.model.xq.Utils.getSkolemFunctions(block)) {
                conclusion.add(skolemFunction);
            }
        }
        return new Tgd(premise, conclusion);
    }

    private Constraint getConstraintConnectingCreateToXMLConstructedByView(final RootBlock block) {
        final List<Atom> premise = new ArrayList<Atom>();
        premise.add(hadad.base.compiler.model.xq.Utils.getCreateAtom(block));
        final List<Atom> conclusion =
                rootBlockForwardEncoderReturnTermVisitorXQ.encode(block.getReturnTemplate(), block.getQueryName());
        return new Tgd(premise, conclusion);
    }

    private Constraint getConstraintConnectingCreateToXMLConstructedByView(final ChildBlock block) {
        final List<Atom> premise = new ArrayList<Atom>();
        premise.add(Utils.getCreateAtom(block.getParent()));
        premise.add(Utils.getCreateAtom(block));
        if (!block.getParent().getPattern().isEmpty()) {
            premise.add(Utils.getParentCreateSkolemFunction(block));
        }
        premise.addAll(Utils.getSkolemFunctions(block));
        final List<Atom> conclusion = childBlockForwardEncoderReturnTermVisitorXQ.encode(block.getCreatedNode(),
                block.getReturnTemplate(), block.getQueryName());
        return new Tgd(premise, conclusion);
    }

    private List<Constraint> getConstraintForSkolemFunctions(final Block block) {
        final List<Constraint> constraints = new ArrayList<Constraint>();
        return constraints;
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