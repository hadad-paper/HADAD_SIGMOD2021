package hadad.base.compiler.query;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import hadad.base.compiler.Pattern;
import hadad.base.compiler.exceptions.ParseException;

/**
 * Mixed model structural base listener
 * 
 *   
 */
abstract class StructuralBaseListener extends QBTQUERYBaseListener {
    private Pattern patterns;

    public Pattern parse(final String str) throws ParseException {
        patterns = null;
        final QBTQUERYLexer lexer = new QBTQUERYLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final QBTQUERYParser parser = new QBTQUERYParser(tokens);
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

    protected abstract ParserRuleContext createParseTree(final QBTQUERYParser parser);
}
