package hadad.base.compiler.model.xq;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.commons.conjunctivequery.StringConstant;
import hadad.commons.conjunctivequery.Term;
import hadad.commons.conjunctivequery.Variable;
import hadad.base.compiler.AntlrUtils;
import hadad.base.compiler.ConditionTerm;
import hadad.base.compiler.PathExpression;
import hadad.base.compiler.VariableMapper;
import hadad.base.compiler.exceptions.ParseException;
import hadad.base.compiler.model.qbt.QBTQueryBlockTreeBuilder;

/**
 * 
 */
@Singleton
final class ConditionTermListener extends XQueryBaseListener {
    private static final Logger log = Logger.getLogger(ConditionTermListener.class);

    /* Used to parse path expressions */
    protected final PathExpressionListener pathExpressionListener;
    /* Used to map xquery variables and the internal fresh variables */
    protected final VariableMapper variableMapper;

    /* Used to keep the referred variables in the condition being parsed */
    private Set<Variable> referredVariables;
    /* Used to keep the term of this condition being parsed */
    private Term term;
    /* Used to keep the path expressions of this condition being parsed */
    private List<PathExpression> pathExpressions;

    @Inject
    public ConditionTermListener(final PathExpressionListener listener, final VariableMapper variableMapper) {
        pathExpressionListener = listener;
        this.variableMapper = variableMapper;
    }

    public ConditionTerm parse(final String str) {
        referredVariables = new HashSet<Variable>();
        term = null;
        pathExpressions = new ArrayList<PathExpression>();

        final XQueryLexer lexer = new XQueryLexer(new ANTLRInputStream(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final XQueryParser parser = new XQueryParser(tokens);
        final ParserRuleContext tree = parser.cterm();
        final ParseTreeWalker walker = new ParseTreeWalker();
        try {
            walker.walk(this, tree);
            return new ConditionTerm(term, referredVariables, pathExpressions);
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
    }

    @Override
    public void enterCtermVar(XQueryParser.CtermVarContext ctx) {
        log.debug("Entering CtermVar: " + ctx.getText());
        final Variable var;
        if (variableMapper.isNotDefined(ctx.getText()) && QBTQueryBlockTreeBuilder.variableMapper != null) {
            var = QBTQueryBlockTreeBuilder.variableMapper.getVariable(ctx.getText().replaceAll("\\$", ""));
        } else {
            var = variableMapper.getVariable(ctx.getText());
        }

        referredVariables.add(var);
        term = var;
    }

    @Override
    public void enterCtermString(XQueryParser.CtermStringContext ctx) {
        log.debug("Entering CtermString: " + ctx.getText());
        term = new StringConstant(ctx.getText().substring(1, ctx.getText().length() - 1));
    }

    @Override
    public void enterCtermAp(XQueryParser.CtermApContext ctx) {
        log.debug("Entering CtermAp: " + ctx.getText());
        final PathExpression pathExpression = pathExpressionListener.parse(AntlrUtils.getFullText(ctx));
        term = pathExpression.getReturnVar();
        pathExpressions.add(pathExpression);
    }
}
