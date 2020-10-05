package hadad.base.compiler.model.sj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.commons.conjunctivequery.StringConstant;
import hadad.commons.conjunctivequery.Term;
import hadad.commons.conjunctivequery.Variable;
import hadad.base.compiler.ConditionTerm;
import hadad.base.compiler.PathExpression;
import hadad.base.compiler.VariableMapper;
import hadad.base.compiler.exceptions.ParseException;

/**
 * SJ Condition Term Listener
 * 
 *   
 *
 */
@Singleton
final class ConditionTermListener extends SJQLBaseListener {
    private static final Logger LOGGER = Logger.getLogger(ConditionTermListener.class);
    protected final PathExpressionListener pathExpressionListener;
    protected final VariableMapper variableMapper;
    private Set<Variable> referredVariables;
    private Term term;
    private List<PathExpression> pathExpressions;

    @Inject
    public ConditionTermListener(final PathExpressionListener listener, final VariableMapper variableMapper) {
        this.pathExpressionListener = listener;
        this.variableMapper = variableMapper;
    }

    /**
     * Parse the term
     * 
     * @param str
     *            the term that needs to be parsed
     * @return constructed condition term
     */
    public ConditionTerm parse(final String str) {
        referredVariables = new HashSet<Variable>();
        term = null;
        pathExpressions = new ArrayList<PathExpression>();

        final SJQLLexer lexer = new SJQLLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final SJQLParser parser = new SJQLParser(tokens);
        final ParserRuleContext tree = parser.sjTerm();
        final ParseTreeWalker walker = new ParseTreeWalker();
        try {
            walker.walk(this, tree);
            return new ConditionTerm(term, referredVariables, pathExpressions);
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
    }

    @Override
    public void enterSjFieldName(SJQLParser.SjFieldNameContext ctx) {
        LOGGER.debug("Entering FieldName: " + ctx.getText());
        final Variable var = variableMapper.getVariable(ctx.getText());
        referredVariables.add(var);
        term = var;
    }

    @Override
    public void enterSjConstant(SJQLParser.SjConstantContext ctx) {
        LOGGER.debug("Entering Constant: " + ctx.getText());
        term = new StringConstant(ctx.getText().substring(1, ctx.getText().length() - 1));

    }
}
