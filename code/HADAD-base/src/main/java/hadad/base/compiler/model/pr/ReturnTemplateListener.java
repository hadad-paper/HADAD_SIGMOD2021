package hadad.base.compiler.model.pr;

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
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.ReturnTerm;
import hadad.base.compiler.ReturnVariableTerm;
import hadad.base.compiler.VariableMapper;
import hadad.base.compiler.exceptions.ParseException;

/**
 * PR Return Template Listener
 * 
 *  
 *
 */
@Singleton
final class ReturnTemplateListener extends SQLBaseListener {
    private static final Logger log = Logger.getLogger(ReturnTemplateListener.class);

    private final VariableMapper variableMapper;

    private List<ReturnTerm> terms;

    private ReturnTemplate constructedReturnTemplate;
    private List<String> returnVariables;

    @Inject
    public ReturnTemplateListener(final VariableMapper variableMapper) {
        this.variableMapper = checkNotNull(variableMapper);
    }

    public ReturnTemplate parse(final String str) throws ParseException {
        terms = new ArrayList<ReturnTerm>();
        returnVariables = new ArrayList<String>();
        final SQLLexer lexer = new SQLLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final SQLParser parser = new SQLParser(tokens);
        final ParserRuleContext tree = parser.prSelectClause();
        final ParseTreeWalker walker = new ParseTreeWalker();
        try {
            walker.walk(this, tree);
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
        constructedReturnTemplate = new ReturnTemplate(PRModel.ID, terms);
        return constructedReturnTemplate;
    }

    @Override
    public void enterPrTerm(SQLParser.PrTermContext ctx) {
        log.debug("Entering Term: " + ctx.getText());
        final Map<String, String> optionals = new HashMap<String, String>();
        if (!PRQueryBlockTreeBuilderAlternative.realtionsFreshVaribales.isEmpty()) {
            if (PRQueryBlockTreeBuilderAlternative.realtionsFreshVaribales.get(ctx.realtion().getText())
                    .get(ctx.NAME().getText()) instanceof String) {
                terms.add(new ReturnVariableTerm((Variable) variableMapper.getVariable(ctx.getText()), optionals));
            } else {
                terms.add(new ReturnVariableTerm((Variable) PRQueryBlockTreeBuilderAlternative.realtionsFreshVaribales
                        .get(ctx.realtion().getText()).get(ctx.NAME().getText()), optionals));
            }
        } else {
            final Variable var = getVariableFromQBTBuilder(ctx);
            if (var != null) {
                terms.add(new ReturnVariableTerm(var, optionals));
            }
            returnVariables.add(ctx.getText());
        }

    }

    /**
     * Get variable from QBT builder variable mapper.
     * 
     * @param ctx
     *            term context
     * @return var found variable
     */
    private Variable getVariableFromQBTBuilder(final SQLParser.PrTermContext ctx) {
        if (variableMapper.isNotDefined(ctx.getText()) && QBTQueryBlockTreeBuilder.variableMapper != null
                && !QBTQueryBlockTreeBuilder.variableMapper.isEmptyVariablesMapping()) {

            return QBTQueryBlockTreeBuilder.variableMapper.getVariable(ctx.getText());
        }
        return null;
    }

    public List<String> getReferdVariables() {
        return this.returnVariables;
    }

    public ReturnTemplate getConstructedReturnTemplate() {
        return constructedReturnTemplate;
    }
}
