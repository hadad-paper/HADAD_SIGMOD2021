package hadad.base.compiler.model.sppj;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.base.compiler.AntlrUtils;
import hadad.base.compiler.Condition;
import hadad.base.compiler.Conditional;
import hadad.base.compiler.PathExpression;
import hadad.base.compiler.exceptions.ParseException;

/**
 * SPPJ ConditionalListener
 * 
 * 
 *
 */
@Singleton
final class ConditionalListener extends SPPJQLBaseListener {
    private static final Logger log = Logger.getLogger(ConditionalListener.class);
    private final ConditionListener conditionListener;
    private List<PathExpression> pathExpressions;
    private List<Condition> conditions;
    private List<String> models;

    @Inject
    public ConditionalListener(final ConditionListener conditionListener) {
        this.conditionListener = conditionListener;
    }

    /**
     * Parse the condition
     * 
     * @param str
     *            the condition that need to be parsed
     * @return the conditional
     * @throws ParseException
     */
    public Conditional parse(final String str) throws ParseException {
        pathExpressions = new ArrayList<PathExpression>();
        conditions = new ArrayList<Condition>();
        models = new ArrayList<String>();
        models.add(SPPJModel.ID);
        final SPPJQLLexer lexer = new SPPJQLLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final SPPJQLParser parser = new SPPJQLParser(tokens);
        final ParserRuleContext tree = parser.sppjWhereClause();
        final ParseTreeWalker walker = new ParseTreeWalker();
        try {
            walker.walk(this, tree);
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
        return new Conditional(conditions, pathExpressions, models);
    }

    @Override
    public void enterSppjWhereCondEquality(SPPJQLParser.SppjWhereCondEqualityContext ctx) {
        log.debug("Entering WhereCondEquality: " + ctx.getText());
        conditions.add(conditionListener.parse(AntlrUtils.getFullText(ctx)));
    }

}
