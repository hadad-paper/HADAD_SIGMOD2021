package hadad.base.compiler.model.aj;

import java.util.ArrayList;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.base.compiler.AntlrUtils;
import hadad.base.compiler.Condition;
import hadad.base.compiler.Conditional;
import hadad.base.compiler.PathExpression;
import hadad.base.compiler.Pattern;
import hadad.base.compiler.VariableMapper;
import hadad.base.compiler.exceptions.ParseException;

/**
 * AJ PatternListener
 */
@Singleton
final class PatternListener {
    private final StructuralListener structuralListener;
    private final ConditionalListener conditionalListener;
    private Pattern constructedPattern;

    @Inject
    public PatternListener(final StructuralListener structuralListener, final ConditionalListener conditionalListener) {
        this.structuralListener = structuralListener;
        this.conditionalListener = conditionalListener;
    }

    public Pattern parse(final String str) throws ParseException {
        final AQLLexer lexer = new AQLLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final AQLParser parser = new AQLParser(tokens);
        final ParserRuleContext tree = parser.forWhereClauses();
        final ParseTreeWalker walker = new ParseTreeWalker();
        final PatternListenerAux listener = new PatternListenerAux();
        try {
            walker.walk(listener, tree);
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
        if (listener.getStructural() == null) {
            throw new ParseException(new IllegalStateException("Structural expected."));
        }
        constructedPattern = new Pattern(structuralListener.parse(listener.getStructural()),
                listener.hasConditional() ? conditionalListener.parse(listener.getConditional())
                        : new Conditional(new ArrayList<Condition>(), new ArrayList<PathExpression>(),
                                new ArrayList<String>()));
        return constructedPattern;
    }

    /**
     * @return The VariableMapper for the Pattern listener.
     */
    public VariableMapper getVariableMapper() {
        return structuralListener.variableMapper;

    }

    /**
     * @return The new constructedPattern
     */
    public Pattern getPattern() {
        return constructedPattern;
    }

    /*
     * We allow only strings that have structural followed by conditional.
     */
    private class PatternListenerAux extends AQLBaseListener {
        private String structural;
        private String conditional;

        public String getStructural() {
            return structural;
        }

        public boolean hasConditional() {
            return conditional != null;
        }

        public String getConditional() {
            return conditional;
        }

        @Override
        public void enterForClause(AQLParser.ForClauseContext ctx) {
            if (structural == null && conditional == null) {
                structural = AntlrUtils.getFullText(ctx);
            }
        }

        @Override
        public void enterWhereClause(AQLParser.WhereClauseContext ctx) {
            if (structural != null && conditional == null) {
                conditional = AntlrUtils.getFullText(ctx);
            }
        }
    }
}
