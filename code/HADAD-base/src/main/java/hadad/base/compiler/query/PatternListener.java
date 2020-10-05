package hadad.base.compiler.query;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.base.compiler.AntlrUtils;
import hadad.base.compiler.Conditional;
import hadad.base.compiler.Pattern;
import hadad.base.compiler.exceptions.ParseException;

/**
 * Mixed model pattern listener
 * 
 *   
 *
 */
@Singleton
final class PatternListener {
    private final StructuralListener mixedStructuralListener;
    private final ConditionalListener mixedConditionalListener;

    @Inject
    public PatternListener(final StructuralListener mixedStructuralListener,
            final ConditionalListener mixedConditionalListener) {
        this.mixedConditionalListener = mixedConditionalListener;
        this.mixedStructuralListener = mixedStructuralListener;
    }

    public Pattern parse(final String str) throws ParseException {
        final QBTQUERYLexer lexer = new QBTQUERYLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final QBTQUERYParser parser = new QBTQUERYParser(tokens);
        final ParserRuleContext tree = parser.forPattern();
        final ParseTreeWalker walker = new ParseTreeWalker();
        final PatternListenerAux listener = new PatternListenerAux();
        try {
            walker.walk(listener, tree);
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
        if (listener.getStructural() == null) {
            throw new ParseException(new IllegalStateException("Pattern expected."));
        }
        // Obtain a Merged Patterns
        final Pattern mergedPattern = mixedStructuralListener.parse(listener.getStructural());
        if (listener.hasConditional()) {
            // Obtain a MixedQBTConditional
            final Conditional newConditional = mixedConditionalListener.parse(listener.getConditional());
            // Merge mixedQBTConditional with all conditionals in mergedPattern
            newConditional.merge(mergedPattern.getConditional());
            return new Pattern(mergedPattern.getStructural(), newConditional.getConditional());
        } else
            System.out.println(mergedPattern.getStructural().getDefinitions().toString());
        return new Pattern(mergedPattern.getStructural(), mergedPattern.getConditional());

    }

    private class PatternListenerAux extends QBTQUERYBaseListener {
        private String structural;
        private String conditional;

        public String getStructural() {
            return structural;
        }

        public String getConditional() {
            return conditional;
        }

        public boolean hasConditional() {
            return conditional != null;
        }

        @Override
        public void enterForPattern(final QBTQUERYParser.ForPatternContext ctx) {
            if (structural == null && conditional == null) {
                structural = AntlrUtils.getFullText(ctx);
            }
        }

        @Override
        public void enterWherePattern(final QBTQUERYParser.WherePatternContext ctx) {
            if (structural != null && conditional == null) {
                conditional = AntlrUtils.getFullText(ctx);
            }
        }
    }
}
