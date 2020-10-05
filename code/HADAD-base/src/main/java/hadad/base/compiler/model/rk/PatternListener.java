package hadad.base.compiler.model.rk;

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
 * RK Pattern Listener
 * 
 * @uathor 
 */
@Singleton
final class PatternListener {
    private final StructuralListener structuralListener;
    private Pattern constructedPattern;

    @Inject
    public PatternListener(final StructuralListener structuralListener) {
        this.structuralListener = structuralListener;
    }

    public Pattern parse(final String str) throws ParseException {
        final KQLLexer lexer = new KQLLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final KQLParser parser = new KQLParser(tokens);
        final ParserRuleContext tree = parser.rkFromClasue();
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
                new Conditional(new ArrayList<Condition>(), new ArrayList<PathExpression>(), new ArrayList<String>()));
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
    private class PatternListenerAux extends KQLBaseListener {
        private String structural;

        public String getStructural() {
            return structural;
        }

        @Override
        public void enterRkFromClasue(KQLParser.RkFromClasueContext ctx) {
            if (structural == null) {
                structural = AntlrUtils.getFullText(ctx);
            }
        }
    }
}
