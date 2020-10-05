package hadad.base.compiler.model.pj;

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
import hadad.base.compiler.model.qbt.QBTQueryBlockTreeBuilder;
import hadad.base.compiler.AntlrUtils;
import hadad.base.compiler.ConditionTerm;
import hadad.base.compiler.PathExpression;
import hadad.base.compiler.VariableMapper;
import hadad.base.compiler.exceptions.ParseException;

/**
 * PJ ConditionTermListener which extends {@link PJQLBaseListener}
 *
 */
@Singleton
final class ConditionTermListener extends PJQLBaseListener {
    private static final Logger log = Logger.getLogger(ConditionTermListener.class);
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
     * Parse the condition term.
     * 
     * @param str
     *            the condition term that needs to be parsed
     * @return the parsed condition term
     */
    public ConditionTerm parse(final String str) {
        referredVariables = new HashSet<Variable>();
        term = null;
        pathExpressions = new ArrayList<PathExpression>();

        final PJQLLexer lexer = new PJQLLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final PJQLParser parser = new PJQLParser(tokens);
        final ParserRuleContext tree = parser.pjCTerm();
        final ParseTreeWalker walker = new ParseTreeWalker();
        try {
            walker.walk(this, tree);
            return new ConditionTerm(term, referredVariables, pathExpressions);
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
    }

    @Override
    public void enterPjTermVar(PJQLParser.PjTermVarContext ctx) {
        log.debug("Entering TermVar: " + ctx.getText());
        final Variable var;
        if (variableMapper.isNotDefined(ctx.getText()) && QBTQueryBlockTreeBuilder.variableMapper != null) {
            var = QBTQueryBlockTreeBuilder.variableMapper.getVariable(ctx.getText());
        } else {
            var = variableMapper.getVariable(ctx.getText());
        }
        referredVariables.add(var);
        term = var;
    }

    @Override
    public void enterPjTermConstant(PJQLParser.PjTermConstantContext ctx) {
        log.debug("Entering TermConstant: " + ctx.getText());
        term = new StringConstant(ctx.getText().substring(1, ctx.getText().length() - 1));
    }

    @Override
    public void enterPjTermPath(PJQLParser.PjTermPathContext ctx) {
        log.debug("Entering TermPath: " + ctx.getText());
        final PathExpression pathExpression = pathExpressionListener.parse(AntlrUtils.getFullText(ctx));
        term = pathExpression.getReturnVar();
        pathExpressions.add(pathExpression);
    }
}