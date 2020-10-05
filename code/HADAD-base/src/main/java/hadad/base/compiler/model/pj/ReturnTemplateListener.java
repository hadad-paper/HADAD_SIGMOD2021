package hadad.base.compiler.model.pj;

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
 * PJ ReturnTemplateListener which extends {@link PJQLBaseListener}
 *
 */
@Singleton
final class ReturnTemplateListener extends PJQLBaseListener {
    private static final Logger LOGGER = Logger.getLogger(ReturnTemplateListener.class);
    private final VariableMapper variableMapper;
    private List<ReturnTerm> terms;
    private ReturnConstructTerm currentTerm;
    private PJQLParser.PjQueryContext returnConstructFlwrContext;

    @Inject
    public ReturnTemplateListener(final VariableMapper variableMapper) {
        this.variableMapper = checkNotNull(variableMapper);
    }

    /**
     * Parse the return template
     * 
     * @param str
     *            the return template part of the query that needs to be parsed
     * @return constructed qbt return template
     * @throws ParseException
     */
    public ReturnTemplate parse(final String str) throws ParseException {
        terms = new ArrayList<ReturnTerm>();
        currentTerm = null;
        returnConstructFlwrContext = null;

        final PJQLLexer lexer = new PJQLLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final PJQLParser parser = new PJQLParser(tokens);
        final ParserRuleContext tree = parser.pjSelectClause();
        final ParseTreeWalker walker = new ParseTreeWalker();
        try {
            walker.walk(this, tree);
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
        return new ReturnTemplate(PJModel.ID, terms);
    }

    @Override
    public void enterPjQuery(PJQLParser.PjQueryContext ctx) {
        LOGGER.debug("Entering Query: " + ctx.getText());
        if (returnConstructFlwrContext == null) {
            returnConstructFlwrContext = ctx;
        }
    }

    @Override
    public void exitPjQuery(PJQLParser.PjQueryContext ctx) {
        LOGGER.debug("Exiting Query: " + ctx.getText());
        if (returnConstructFlwrContext != null && returnConstructFlwrContext.equals(ctx)) {
            returnConstructFlwrContext = null;
        }
    }

    @Override
    public void enterPjRecordConstruct(PJQLParser.PjRecordConstructContext ctx) {
        LOGGER.debug("Entering RecordConstruct: " + ctx.getText());
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
    public void exitPjRecordConstruct(PJQLParser.PjRecordConstructContext ctx) {
        LOGGER.debug("Exiting RecordConstruct: " + ctx.getText());
        if (returnConstructFlwrContext == null) {
            currentTerm = currentTerm.getParent();
        }
    }

    @Override
    public void exitPjFieldBinding(PJQLParser.PjFieldBindingContext ctx) {
        LOGGER.debug("Exiting FieldBinding: " + ctx.getText());
        if (returnConstructFlwrContext == null) {
            currentTerm = currentTerm.getParent();
        }
    }

    @Override
    public void enterPjRecordConstructFieldName(PJQLParser.PjRecordConstructFieldNameContext ctx) {
        LOGGER.debug("Entering RecordConstructFieldName: " + ctx.getText());
        if (returnConstructFlwrContext == null) {
            createConstructTermAndAddAsChild(ctx.getText().substring(1, ctx.getText().length() - 1));
        }
    }

    @Override
    public void enterPjSelectVar(PJQLParser.PjSelectVarContext ctx) {
        LOGGER.debug("Entering ReturnVar: " + ctx.getText());
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
    public void enterPjSelectConstant(PJQLParser.PjSelectConstantContext ctx) {
        LOGGER.debug("Entering ReturnConstant: " + ctx.getText());
        if (returnConstructFlwrContext == null) {
            if (currentTerm == null) {
                terms.add(new ReturnStringTerm(ctx.getText()));
            } else {
                currentTerm.addChild(new ReturnStringTerm(currentTerm, ctx.getText()));
            }
        }
    }
}
