package hadad.base.compiler.model.pr;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ParserRuleContext;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.Constant;
import hadad.commons.conjunctivequery.Term;
import hadad.commons.conjunctivequery.Variable;
import hadad.base.compiler.VariableFactory;
import hadad.base.compiler.VariableMapper;
import hadad.base.compiler.model.rk.Utils;

/**
 * PR StructuralListener
 * 
 *  
 *
 */
@Singleton
public final class StructuralListener extends StructuralBaseListener {
    private static final Logger log = Logger.getLogger(StructuralListener.class);

    @Inject
    public StructuralListener(@Named("SQLVariableFactory") VariableFactory sqlVariableFactory,
            VariableMapper variableMapper, final ReturnTemplateListener returnListener) {
        super(sqlVariableFactory, variableMapper, returnListener);
    }

    @Override
    public void enterPrRelationBinding(SQLParser.PrRelationBindingContext ctx) {
        log.debug("Entering Relation Source: " + ctx.getText());
        bindingRelation = ctx.prVariable().getText();
        relationColumnMapper = new LinkedHashMap<String, Object>();
        relationName = ctx.prSource().getText();
        final Relation realtion = PRQueryBlockTreeBuilderAlternative.relations.get(ctx.prSource().getText());
        for (String attributeName : realtion.getAttributes()) {
            final Variable var = sqlVariableFactory.createFreshVar();
            variableMapper.define(bindingRelation + "." + attributeName, var);
            relationColumnMapper.put(attributeName, var);
        }
        relationMapper.put(bindingRelation, relationName);
        PRQueryBlockTreeBuilderAlternative.realtionsFreshVaribales.put(bindingRelation, relationColumnMapper);
    }

    @Override
    public void enterPrLeftterm(SQLParser.PrLefttermContext ctx) {
        log.debug("Entering Left Term: " + ctx.getText());
        relationLefttermMapper =
                PRQueryBlockTreeBuilderAlternative.realtionsFreshVaribales.get(ctx.prTerm().realtion().getText());
        leftJoinVariable = (Variable) relationLefttermMapper.get(ctx.prTerm().NAME().getText());
    }

    @Override
    public void enterPrRightterm(SQLParser.PrRighttermContext ctx) {
        log.debug("Entering Right Term: " + ctx.getText());
        if (ctx.prTerm().STRING() == null) {
            relationRighttermMapper =
                    PRQueryBlockTreeBuilderAlternative.realtionsFreshVaribales.get(ctx.prTerm().realtion().getText());
            relationRighttermMapper.put(ctx.prTerm().NAME().getText(), leftJoinVariable);
            variableMapper.updateVariable(ctx.prTerm().getText(), leftJoinVariable);
            PRQueryBlockTreeBuilderAlternative.realtionsFreshVaribales.put(ctx.prTerm().realtion().getText(),
                    relationRighttermMapper);
        }
    }

    @Override
    public void exitPrEquality(SQLParser.PrEqualityContext ctx) {
        log.debug("Entering Right Term: " + ctx.getText());
        if (ctx.prRightterm().prTerm().STRING() != null) {
            relationLefttermMapper = PRQueryBlockTreeBuilderAlternative.realtionsFreshVaribales
                    .get(ctx.prLeftterm().prTerm().realtion().getText());
            relationLefttermMapper.put(ctx.prLeftterm().prTerm().NAME().getText(),
                    ctx.prRightterm().prTerm().STRING().getText().replaceAll("\"", ""));
            PRQueryBlockTreeBuilderAlternative.realtionsFreshVaribales
                    .put(ctx.prLeftterm().prTerm().realtion().getText(), relationLefttermMapper);
        }
    }

    @Override
    public void exitPrLikeExpression(SQLParser.PrLikeExpressionContext ctx) {
        log.debug("Entering Like Expression: " + ctx.getText());
        if (ctx.STRING() != null) {
            relationLefttermMapper =
                    PRQueryBlockTreeBuilderAlternative.realtionsFreshVaribales.get(ctx.prTerm().realtion().getText());
            relationLefttermMapper.put(ctx.prTerm().NAME().getText(),
                    "@LIKE@" + ctx.STRING().getText().replaceAll("\"", ""));
            PRQueryBlockTreeBuilderAlternative.realtionsFreshVaribales.put(ctx.prTerm().realtion().getText(),
                    relationLefttermMapper);

        }
    }

    @Override
    public void exitPrFromWhereClauses(SQLParser.PrFromWhereClausesContext ctx) {
        for (Map.Entry<String, Map<String, Object>> entryOutter : PRQueryBlockTreeBuilderAlternative.realtionsFreshVaribales
                .entrySet()) {
            List<Term> terms = new ArrayList<Term>();
            List<Atom> Atoms = new ArrayList<Atom>();
            for (Map.Entry<String, Object> enteryInner : entryOutter.getValue().entrySet()) {
                // Note: This piece of code for handling equality in the head of
                // cq
                if (enteryInner.getValue() instanceof Variable) {
                    terms.add((Variable) enteryInner.getValue());
                } else {
                    if (returnListener.getReferdVariables()
                            .contains(entryOutter.getKey() + "." + enteryInner.getKey())) {
                        final Variable var =
                                variableMapper.getVariable(entryOutter.getKey() + "." + enteryInner.getKey());
                        terms.add(var);
                        Atoms.add(new Atom(Predicate.CONSTANT.toString(), var,
                                Utils.toTerm((String) enteryInner.getValue())));
                    } else {
                        terms.add((Constant) Utils.toTerm((String) enteryInner.getValue()));
                    }
                }
            }
            if (relationMapper.get(entryOutter.getKey()) != null) {
                encoding.add(new Atom(relationMapper.get(entryOutter.getKey()), terms));
            }
            if (!Atoms.isEmpty()) {
                encoding.addAll(Atoms);
            }

        }
    }

    @Override
    protected ParserRuleContext createParseTree(final SQLParser parser) {
        return parser.prFromWhereClauses();
    }
}
