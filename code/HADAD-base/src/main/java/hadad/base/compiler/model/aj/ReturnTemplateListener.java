package hadad.base.compiler.model.aj;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.commons.conjunctivequery.Variable;
import hadad.base.compiler.model.qbt.QBTQueryBlockTreeBuilder;
import hadad.base.compiler.ReturnConstructTerm;
import hadad.base.compiler.ReturnLeafTerm;
import hadad.base.compiler.ReturnStringTerm;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.ReturnTerm;
import hadad.base.compiler.ReturnVariableTerm;
import hadad.base.compiler.StringElement;
import hadad.base.compiler.VariableMapper;
import hadad.base.compiler.exceptions.ParseException;

/**
 * AJ ReturnTemplateListener which extends {@link AQLBaseListener}
 */
@Singleton
final class ReturnTemplateListener extends AQLBaseListener {
    private static final Logger log = Logger.getLogger(ReturnTemplateListener.class);

    /* Used to map aqlquery variables and the internal fresh variables */
    private final VariableMapper variableMapper;

    /* Used to keep the terms of the return template being parsed */
    private List<ReturnTerm> terms;

    /*
     * Used to keep the current construct term of the return template being parsed
     */
    private ReturnConstructTerm currentTerm;

    private AQLParser.QueryContext returnConstructFlwrContext;

    @Inject
    public ReturnTemplateListener(final VariableMapper variableMapper) {
        this.variableMapper = checkNotNull(variableMapper);
    }

    public ReturnTemplate parse(final String str) throws ParseException {
        terms = new ArrayList<ReturnTerm>();
        currentTerm = null;
        returnConstructFlwrContext = null;

        final AQLLexer lexer = new AQLLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final AQLParser parser = new AQLParser(tokens);
        final ParserRuleContext tree = parser.returnClause();
        final ParseTreeWalker walker = new ParseTreeWalker();
        try {
            walker.walk(this, tree);
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
        return new ReturnTemplate(AJModel.ID, terms);
    }

    @Override
    public void enterQuery(AQLParser.QueryContext ctx) {
        log.debug("Entering Query: " + ctx.getText());
        if (returnConstructFlwrContext == null) {
            returnConstructFlwrContext = ctx;
        }
    }

    @Override
    public void exitQuery(AQLParser.QueryContext ctx) {
        log.debug("Exiting Query: " + ctx.getText());
        if (returnConstructFlwrContext != null && returnConstructFlwrContext.equals(ctx)) {
            returnConstructFlwrContext = null;
        }
    }

    @Override
    public void enterRecordConstruct(AQLParser.RecordConstructContext ctx) {
        log.debug("Entering RecordConstruct: " + ctx.getText());
        if (returnConstructFlwrContext == null) {
            if (currentTerm == null) {
                final ReturnConstructTerm term =
                        new ReturnConstructTerm(new StringElement(""), new HashMap<String, ReturnLeafTerm>());
                terms.add(term);
                currentTerm = term;
            } else {
                createConstructTermAndAddAsChild("");
            }
        }
    }

    private void createConstructTermAndAddAsChild(final String str) {
        final ReturnConstructTerm term =
                new ReturnConstructTerm(currentTerm, new StringElement(str), new HashMap<String, ReturnLeafTerm>());
        currentTerm.addChild(term);
        currentTerm = term;
    }

    @Override
    public void exitRecordConstruct(AQLParser.RecordConstructContext ctx) {
        log.debug("Exiting RecordConstruct: " + ctx.getText());
        if (returnConstructFlwrContext == null) {
            currentTerm = currentTerm.getParent();
        }
    }

    @Override
    public void exitFieldBinding(AQLParser.FieldBindingContext ctx) {
        log.debug("Exiting FieldBinding: " + ctx.getText());
        if (returnConstructFlwrContext == null) {
            currentTerm = currentTerm.getParent();
        }
    }

    @Override
    public void enterRecordConstructFieldName(AQLParser.RecordConstructFieldNameContext ctx) {
        log.debug("Entering RecordConstructFieldName: " + ctx.getText());
        if (returnConstructFlwrContext == null) {
            createConstructTermAndAddAsChild(ctx.getText().substring(1, ctx.getText().length() - 1));
        }
    }

    @Override
    public void enterReturnVar(AQLParser.ReturnVarContext ctx) {
        log.debug("Entering ReturnVar: " + ctx.getText());
        System.out.println("*********************" + QBTQueryBlockTreeBuilder.variableMapper);
        final Variable var;
        if (returnConstructFlwrContext == null) {
            if (variableMapper.isNotDefined(ctx.getText()) && QBTQueryBlockTreeBuilder.variableMapper != null
                    && !QBTQueryBlockTreeBuilder.variableMapper.isEmptyVariablesMapping()) {

                var = QBTQueryBlockTreeBuilder.variableMapper.getVariable(ctx.getText());
            } else {
                var = variableMapper.getVariable(ctx.getText());
            }
            final Map<String, String> optionals = new HashMap<String, String>();
            if (currentTerm == null) {
                terms.add(new ReturnVariableTerm(var, optionals));
            } else {
                currentTerm.addChild(new ReturnVariableTerm(currentTerm, var, optionals));
            }
        }
    }

    @Override
    public void enterReturnConstant(AQLParser.ReturnConstantContext ctx) {
        log.debug("Entering ReturnConstant: " + ctx.getText());
        if (returnConstructFlwrContext == null) {
            if (currentTerm == null) {
                terms.add(new ReturnStringTerm(ctx.getText()));
            } else {
                currentTerm.addChild(new ReturnStringTerm(currentTerm, ctx.getText()));
            }
        }
    }
}
