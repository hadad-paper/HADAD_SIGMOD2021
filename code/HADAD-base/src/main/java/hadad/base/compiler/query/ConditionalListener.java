package hadad.base.compiler.query;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.base.compiler.Conditional;
import hadad.base.compiler.exceptions.ParseException;

@Singleton
final class ConditionalListener extends QBTQUERYBaseListener {
    @Inject
    public ConditionalListener() {

    }

    public Conditional parse(final String str) throws ParseException {

        final QBTQUERYLexer lexer = new QBTQUERYLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final QBTQUERYParser parser = new QBTQUERYParser(tokens);
        final ParserRuleContext tree = parser.whereClause();
        final ParseTreeWalker walker = new ParseTreeWalker();
        try {
            walker.walk(this, tree);
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
        return new Conditional(null, null, null);
    }

}
