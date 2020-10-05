package hadad.base.compiler.model.sj;

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
import hadad.base.compiler.model.sj.SJQLParser.SjFieldNameContext;
import hadad.base.compiler.model.sppj.SPPJQLParser;
import hadad.base.compiler.ReturnConstructTerm;
import hadad.base.compiler.ReturnLeafTerm;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.ReturnTerm;
import hadad.base.compiler.ReturnVariableTerm;
import hadad.base.compiler.StringElement;
import hadad.base.compiler.VariableElement;
import hadad.base.compiler.VariableMapper;
import hadad.base.compiler.exceptions.ParseException;

/**
 * SJ Return Template Listener
 * 
 * 
 *
 */
@Singleton
final class ReturnTemplateListener extends SJQLBaseListener {
    private static final Logger LOGGER = Logger.getLogger(ReturnTemplateListener.class);
    private final VariableMapper variableMapper;
    private List<ReturnTerm> terms;
    private ReturnConstructTerm currentTerm;
    private SPPJQLParser.SppjQueryContext returnConstructFlwrContext;

    @Inject
    public ReturnTemplateListener(final VariableMapper variableMapper) {
        this.variableMapper = checkNotNull(variableMapper);
    }

    public ReturnTemplate parseProjectFields(final String str) throws ParseException {
        terms = new ArrayList<ReturnTerm>();
        currentTerm = null;
        returnConstructFlwrContext = null;
        final SJQLLexer lexer = new SJQLLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final SJQLParser parser = new SJQLParser(tokens);
        final ParserRuleContext tree = parser.sjProjectFields();
        final ParseTreeWalker walker = new ParseTreeWalker();
        try {
            walker.walk(this, tree);
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
        return new ReturnTemplate(SJModel.ID, terms);
    }

    public ReturnTemplate parseRecordConstruct(final String str) throws ParseException {
        terms = new ArrayList<ReturnTerm>();
        currentTerm = null;
        returnConstructFlwrContext = null;
        final SJQLLexer lexer = new SJQLLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final SJQLParser parser = new SJQLParser(tokens);
        final ParserRuleContext tree = parser.sjRecordConstruct();
        final ParseTreeWalker walker = new ParseTreeWalker();
        try {
            walker.walk(this, tree);
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
        return new ReturnTemplate(SJModel.ID, terms);
    }

    @Override
    public void enterSjProjectFields(SJQLParser.SjProjectFieldsContext ctx) {
        LOGGER.debug("Entering ProjectFields: " + ctx.getText());
        final Map<String, String> optionals = new HashMap<String, String>();
        for (SjFieldNameContext fnctx : ctx.sjFieldName()) {
            final Variable var;
            var = variableMapper.getVariable(fnctx.getText());
            final ReturnConstructTerm term = new ReturnConstructTerm(
                    new ReturnConstructTerm(new VariableElement(var), new HashMap<String, ReturnLeafTerm>()),
                    new StringElement(fnctx.getText()), new HashMap<String, ReturnLeafTerm>());
            terms.add(term);
        }

    }

    @Override
    public void enterSjRecordConstruct(SJQLParser.SjRecordConstructContext ctx) {
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
    public void exitSjRecordConstruct(SJQLParser.SjRecordConstructContext ctx) {
        LOGGER.debug("Exiting RecordConstruct: " + ctx.getText());
        if (returnConstructFlwrContext == null) {
            currentTerm = currentTerm.getParent();
        }
    }

    @Override
    public void exitSjFieldBinding(SJQLParser.SjFieldBindingContext ctx) {
        LOGGER.debug("Exiting FieldBinding: " + ctx.getText());
        if (returnConstructFlwrContext == null) {
            currentTerm = currentTerm.getParent();
        }
    }

    @Override
    public void enterSjRecordConstructFieldName(SJQLParser.SjRecordConstructFieldNameContext ctx) {
        LOGGER.debug("Entering RecordConstructFieldName: " + ctx.getText());
        if (returnConstructFlwrContext == null) {
            createConstructTermAndAddAsChild(ctx.getText().substring(1, ctx.getText().length() - 1));
        }
    }

    @Override
    public void enterSjVar(SJQLParser.SjVarContext ctx) {
        LOGGER.debug("Entering ReturnVar: " + ctx.getText());
        final Variable var;

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
