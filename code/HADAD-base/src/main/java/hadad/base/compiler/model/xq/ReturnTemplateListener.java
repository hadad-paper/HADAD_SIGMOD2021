package hadad.base.compiler.model.xq;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.commons.conjunctivequery.Variable;
import hadad.base.compiler.PathExpression;
import hadad.base.compiler.ReturnConstructTerm;
import hadad.base.compiler.ReturnLeafTerm;
import hadad.base.compiler.ReturnStringTerm;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.ReturnTerm;
import hadad.base.compiler.ReturnVariableTerm;
import hadad.base.compiler.StringElement;
import hadad.base.compiler.VariableMapper;
import hadad.base.compiler.exceptions.ParseException;
import hadad.base.compiler.model.qbt.QBTQueryBlockTreeBuilder;

/**
 * 
 */
@Singleton
final class ReturnTemplateListener extends XQueryBaseListener {
    private static final Logger log = Logger.getLogger(ReturnTemplateListener.class);

    /* Used to map xquery variables and the internal fresh variables */
    private final VariableMapper variableMapper;

    /* Used to keep the terms of the return template being parsed */
    private List<ReturnTerm> terms;

    /* The definitions available in this return template */
    private Map<Variable, PathExpression> definitions;
    /*
     * Used to keep the current construct term of the return template being
     * parsed
     */
    private ReturnConstructTerm currentTerm;

    private StringElement currentElement;
    private String currentAttributeName;
    private Map<String, ReturnLeafTerm> currentAttributes;
    private XQueryParser.FlwrContext returnConstructFlwrContext;

    @Inject
    public ReturnTemplateListener(final VariableMapper variableMapper) {
        this.variableMapper = checkNotNull(variableMapper);
    }

    public ReturnTemplate parse(Map<Variable, PathExpression> definitions, final String str) throws ParseException {
        terms = new ArrayList<ReturnTerm>();
        currentTerm = null;
        resetReturnConstructTermVariables();
        returnConstructFlwrContext = null;
        this.definitions = definitions;

        final XQueryLexer lexer = new XQueryLexer(new ANTLRInputStream(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final XQueryParser parser = new XQueryParser(tokens);
        final ParserRuleContext tree = parser.flwrReturn();
        final ParseTreeWalker walker = new ParseTreeWalker();
        try {
            walker.walk(this, tree);
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
        return new ReturnTemplate(XQModel.ID, terms);
    }

    private void resetReturnConstructTermVariables() {
        currentElement = null;
        currentAttributeName = null;
        currentAttributes = new HashMap<String, ReturnLeafTerm>();
    }

    @Override
    public void enterFlwr(XQueryParser.FlwrContext ctx) {
        log.debug("Entering Flwr: " + ctx.getText());
        if (returnConstructFlwrContext == null) {
            returnConstructFlwrContext = ctx;
        }
    }

    @Override
    public void exitFlwr(XQueryParser.FlwrContext ctx) {
        log.debug("Exiting Flwr: " + ctx.getText());
        if (returnConstructFlwrContext != null && returnConstructFlwrContext.equals(ctx)) {
            returnConstructFlwrContext = null;
        }
    }

    @Override
    public void enterConstruct(XQueryParser.ConstructContext ctx) {
        log.debug("Entering Construct: " + ctx.getText());
        if (returnConstructFlwrContext == null) {
            resetReturnConstructTermVariables();
        }
    }

    @Override
    public void enterTag(XQueryParser.TagContext ctx) {
        log.debug("Entering Tag: " + ctx.getText());
        if (returnConstructFlwrContext == null) {
            currentElement = new StringElement(ctx.getText());
        }
    }

    @Override
    public void enterMkattrName(XQueryParser.MkattrNameContext ctx) {
        log.debug("Entering MkattrName: " + ctx.getText());
        if (returnConstructFlwrContext == null) {
            currentAttributeName = ctx.getText();
        }
    }

    @Override
    public void enterAtermVar(XQueryParser.AtermVarContext ctx) {
        log.debug("Entering AtermVar: " + ctx.getText());
        if (returnConstructFlwrContext == null) {
            currentAttributes.put(currentAttributeName, new ReturnVariableTerm(currentTerm,
                    variableMapper.getVariable(ctx.getText()), new HashMap<String, String>()));
            currentAttributeName = null;
        }
    }

    @Override
    public void enterAtermString(XQueryParser.AtermStringContext ctx) {
        log.debug("Entering AtermString: " + ctx.getText());
        if (returnConstructFlwrContext == null) {
            currentAttributes.put(currentAttributeName, new ReturnStringTerm(currentTerm, ctx.getText()));
            currentAttributeName = null;
        }
    }

    @Override
    public void enterConstructDelimeter(XQueryParser.ConstructDelimeterContext ctx) {
        log.debug("Entering ConstructDelimeter: " + ctx.getText());
        if (returnConstructFlwrContext == null) {
            if (currentTerm == null) {
                final ReturnConstructTerm term = new ReturnConstructTerm(currentElement, currentAttributes);
                terms.add(term);
                currentTerm = term;
            } else {
                final ReturnConstructTerm term =
                        new ReturnConstructTerm(currentTerm, currentElement, currentAttributes);
                currentTerm.addChild(term);
                currentTerm = term;
            }
            resetReturnConstructTermVariables();
        }
    }

    @Override
    public void enterConstructFlwrCloseTag(XQueryParser.ConstructFlwrCloseTagContext ctx) {
        log.debug("Entering ConstructFlwrCloseTag: " + ctx.getText());
        if (returnConstructFlwrContext == null) {
            currentTerm = currentTerm.getParent();
        }
    }

    @Override
    public void enterFlwrReturnVar(XQueryParser.FlwrReturnVarContext ctx) {
        log.debug("Entering FlwrReturnVar: " + ctx.getText());
        final Variable var;
        if (returnConstructFlwrContext == null) {
            if (variableMapper.isNotDefined(ctx.getText())
                    && !QBTQueryBlockTreeBuilder.variableMapper.isEmptyVariablesMapping()
                    && (QBTQueryBlockTreeBuilder.variableMapper.getVariable((ctx.getText())) != null)) {
                var = QBTQueryBlockTreeBuilder.variableMapper.getVariable(ctx.getText());
            } else {
                var = variableMapper.getVariable(ctx.getText());
            }
            final Map<String, String> optionals = new HashMap<String, String>();
            if (definitions.get(var).getOptionals().containsKey(PathExpressionOptional.ENDS_WITH_TEXT.toString())
                    && definitions.get(var).getOptionals().get(PathExpressionOptional.ENDS_WITH_TEXT.toString())
                            .equals("true")) {
                optionals.put(ReturnVariableTermOptional.IS_TEXT.toString(), "true");
            }
            if (currentTerm == null) {
                terms.add(new ReturnVariableTerm(var, optionals));
            } else {
                currentTerm.addChild(new ReturnVariableTerm(currentTerm, var, optionals));
            }

        }
    }

    @Override
    public void enterFlwrReturnString(XQueryParser.FlwrReturnStringContext ctx) {
        log.debug("Entering FlwrReturnString: " + ctx.getText());
        if (returnConstructFlwrContext == null) {
            if (currentTerm == null) {
                terms.add(new ReturnStringTerm(ctx.getText()));
            } else {
                currentTerm.addChild(new ReturnStringTerm(currentTerm, ctx.getText()));
            }
        }
    }
}
