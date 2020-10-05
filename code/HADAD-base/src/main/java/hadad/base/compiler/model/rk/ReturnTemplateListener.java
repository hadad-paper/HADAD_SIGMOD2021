package hadad.base.compiler.model.rk;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import hadad.commons.conjunctivequery.Variable;
import hadad.base.compiler.ReturnConstructTerm;
import hadad.base.compiler.ReturnLeafTerm;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.ReturnTerm;
import hadad.base.compiler.ReturnVariableTerm;
import hadad.base.compiler.StringElement;
import hadad.base.compiler.VariableElement;
import hadad.base.compiler.VariableMapper;
import hadad.base.compiler.exceptions.ParseException;
import hadad.base.compiler.model.qbt.QBTQueryBlockTreeBuilder;

/**
 * RK ReturnTemplateListener
 */
@Singleton
final class ReturnTemplateListener extends KQLBaseListener {
    private static final Logger LOG = Logger.getLogger(ReturnTemplateListener.class);

    /* Used to map aqlquery variables and the internal fresh variables */
    private final VariableMapper variableMapper;
    private final Set<Variable> setListVars;

    /* Used to keep the terms of the return template being parsed */
    private List<ReturnTerm> terms;

    private ReturnTemplate constructedReturnTemplate;

    /*
     * Used to keep the current construct term of the return template being parsed
     */
    private ReturnConstructTerm currentTerm;

    @Inject
    public ReturnTemplateListener(final VariableMapper variableMapper,
            @Named("BaseTypeVariable") final Set<Variable> setListVars) {
        this.variableMapper = checkNotNull(variableMapper);
        this.setListVars = setListVars;
    }

    public ReturnTemplate parse(final String str) throws ParseException {
        terms = new ArrayList<ReturnTerm>();

        final KQLLexer lexer = new KQLLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final KQLParser parser = new KQLParser(tokens);
        final ParserRuleContext tree = parser.rkSelectClasue();
        final ParseTreeWalker walker = new ParseTreeWalker();
        try {
            walker.walk(this, tree);
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
        constructedReturnTemplate = new ReturnTemplate(RKModel.ID, terms);
        return constructedReturnTemplate;
    }

    @Override
    public void enterRkReturnVariable(KQLParser.RkReturnVariableContext ctx) {
        LOG.debug("Entering ReturnVar: " + ctx.getText());
        final Variable var;
        final Map<String, String> optionals = new HashMap<String, String>();

        if (variableMapper.isNotDefined(ctx.getText())
                && !QBTQueryBlockTreeBuilder.variableMapper.isEmptyVariablesMapping()
                && (QBTQueryBlockTreeBuilder.variableMapper.getVariable((ctx.getText())) != null)) {
            var = QBTQueryBlockTreeBuilder.variableMapper.getVariable((ctx.getText()));
        } else {
            var = variableMapper.getVariable(ctx.getText());
        }
        if (setListVars.contains(var)) {
            optionals.put(var.toString(), new String());
        }
        if (currentTerm != null) {
            currentTerm.addChild((new ReturnVariableTerm(var, optionals)));
        } else {
            terms.add((new ReturnVariableTerm(var, optionals)));
        }

    }

    @Override
    public void enterMapConstructor(KQLParser.MapConstructorContext ctx) {
        final ReturnConstructTerm term;
        final Variable var;
        if (ctx.mapKey().STRING() != null) {
            term = new ReturnConstructTerm(new StringElement(ctx.mapKey().getText().replaceAll("\"", "")),
                    new HashMap<String, ReturnLeafTerm>());
            terms.add(term);
            currentTerm = term;
        } else {
            if (variableMapper.isNotDefined(ctx.mapKey().getText())
                    && !QBTQueryBlockTreeBuilder.variableMapper.isEmptyVariablesMapping()
                    && (QBTQueryBlockTreeBuilder.variableMapper.getVariable((ctx.mapKey().getText())) != null)) {
                var = QBTQueryBlockTreeBuilder.variableMapper.getVariable((ctx.mapKey().getText()));
            } else {
                var = variableMapper.getVariable(ctx.mapKey().getText());
            }
            term = new ReturnConstructTerm(new VariableElement(var), new HashMap<String, ReturnLeafTerm>());
            terms.add(term);
            currentTerm = term;
        }
    }

    @Override
    public void exitMapConstructor(KQLParser.MapConstructorContext ctx) {
        currentTerm = null;
    }

    @Override
    public void enterRkStringKey(KQLParser.RkStringKeyContext ctx) {
        LOG.debug("Entering StringKey: " + ctx.getText());
        createConstructTermAndAddAsChild(ctx.getText().substring(1, ctx.getText().length() - 1));
    }

    @Override
    public void exitRkAttribute(KQLParser.RkAttributeContext ctx) {
        LOG.debug("Exiting Attribute: " + ctx.getText());
        currentTerm = currentTerm.getParent();
    }

    private void createConstructTermAndAddAsChild(final String str) {
        final ReturnConstructTerm term =
                new ReturnConstructTerm(currentTerm, new StringElement(str), new HashMap<String, ReturnLeafTerm>());
        currentTerm.addChild(term);
        currentTerm = term;
    }

    public ReturnTemplate getConstructedReturnTemplate() {
        return constructedReturnTemplate;
    }
}
