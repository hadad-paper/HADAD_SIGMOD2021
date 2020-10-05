package hadad.base.compiler.model.qbt;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import hadad.base.compiler.Pattern;
import hadad.base.compiler.exceptions.ParseException;

/**
 * QBT StructuralBaseListener which extends {@link QBTBaseListener}.
 * 
 *   
 */
abstract class StructuralBaseListener extends QBTBaseListener {
    /*
     * Used to keep the introduced Patterns of each pattern being parsed
     */
    private Pattern patterns;

    public Pattern parse(final String str) throws ParseException {
        patterns = null;
        final QBTLexer lexer = new QBTLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final QBTParser parser = new QBTParser(tokens);
        final ParserRuleContext tree = createParseTree(parser);
        final ParseTreeWalker walker = new ParseTreeWalker();
        try {
            walker.walk(this, tree);
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
        return patterns;
    }

    protected void addPattern(final Pattern pattern) {
        if (pattern == null) {
            throw new IllegalStateException("Pattern expected.");
        }
        if (patterns == null)
            patterns = pattern;
        else
            patterns = patterns.mergePattern(pattern);

    }

    protected abstract ParserRuleContext createParseTree(final QBTParser parser);
}
