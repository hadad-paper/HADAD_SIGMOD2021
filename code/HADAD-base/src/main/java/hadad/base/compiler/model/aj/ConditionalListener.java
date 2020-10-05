package hadad.base.compiler.model.aj;

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
 * AJ Conditional Listener
 */
@Singleton
final class ConditionalListener extends AQLBaseListener {
    private static final Logger log = Logger.getLogger(ConditionalListener.class);

    private final ConditionListener conditionListener;
    private final ConditionalStructuralListener conditionalStructuralListener;

    /* Used to keep the path expression in the conditional being parsed */
    private List<PathExpression> pathExpressions;
    /* Used to keep the equalities in the conditional being parsed */
    private List<Condition> conditions;

    /* Used to define models in the conditional */
    private List<String> models;

    @Inject
    public ConditionalListener(final ConditionListener conditionListener,
            final ConditionalStructuralListener conditionalStructuralListener) {
        this.conditionListener = conditionListener;
        this.conditionalStructuralListener = conditionalStructuralListener;
    }

    public Conditional parse(final String str) throws ParseException {
        pathExpressions = new ArrayList<PathExpression>();
        conditions = new ArrayList<Condition>();
        models = new ArrayList<String>();
        models.add(AJModel.ID);
        final AQLLexer lexer = new AQLLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final AQLParser parser = new AQLParser(tokens);
        final ParserRuleContext tree = parser.whereClause();
        final ParseTreeWalker walker = new ParseTreeWalker();
        try {
            walker.walk(this, tree);
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
        return new Conditional(conditions, pathExpressions, models);
    }

    @Override
    public void enterWhereCondEquality(AQLParser.WhereCondEqualityContext ctx) {
        log.debug("Entering WhereCondEquality: " + ctx.getText());
        try {
            conditions.add(conditionListener.parse(AntlrUtils.getFullText(ctx)));
        } catch (ParseException e) {

        }
    }

    @Override
    public void enterWhereCondSome(AQLParser.WhereCondSomeContext ctx) {
        log.debug("Entering WhereCondSome: " + ctx.getText());
        pathExpressions.addAll(conditionalStructuralListener.parse(AntlrUtils.getFullText(ctx)).getPathExpressions());
    }
}
