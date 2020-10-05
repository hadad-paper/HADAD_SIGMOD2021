package hadad.base.compiler.model.sj;

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
 * SJ Conditional Listener which extends {@link SJQLBaseListener}
 * 
 *   
 *
 */
@Singleton
final class ConditionalListener extends SJQLBaseListener {
    private static final Logger LOGGER = Logger.getLogger(ConditionalListener.class);

    private final ConditionListener conditionListener;
    private List<Condition> conditions;
    private List<PathExpression> pathExpressions;
    private List<String> models;

    @Inject
    public ConditionalListener(final ConditionListener conditionListener) {
        this.conditionListener = conditionListener;
    }

    /**
     * Parse the condition
     * 
     * @param str
     *            the condition that needs to be parsed
     * @return the conditional
     * @throws ParseException
     */
    public Conditional parse(final String str) throws ParseException {
        pathExpressions = new ArrayList<PathExpression>();
        conditions = new ArrayList<Condition>();
        models = new ArrayList<String>();
        models.add(SJModel.ID);
        final SJQLLexer lexer = new SJQLLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final SJQLParser parser = new SJQLParser(tokens);
        final ParserRuleContext tree = parser.sjTextSearch();
        final ParseTreeWalker walker = new ParseTreeWalker();
        try {
            walker.walk(this, tree);
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
        return new Conditional(conditions, pathExpressions, models);
    }

    @Override
    public void enterSjTextSearch(SJQLParser.SjTextSearchContext ctx) {
        LOGGER.debug("Entering WhereCondEquality: " + ctx.getText());
        conditions.add(conditionListener.parse(AntlrUtils.getFullText(ctx)));
    }
}
