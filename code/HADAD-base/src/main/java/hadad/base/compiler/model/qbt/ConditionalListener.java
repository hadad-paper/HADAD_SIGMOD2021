package hadad.base.compiler.model.qbt;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.base.compiler.Conditional;
import hadad.base.compiler.exceptions.ParseException;

/**
 * AJ ConditionalListener which extends {@link QBTBaseListener}.
 * 
 *   
 *
 */
@Singleton
final class ConditionalListener extends QBTBaseListener {
    private static final Logger log = Logger.getLogger(ConditionalListener.class);

    @Inject
    public ConditionalListener() {

    }

    public Conditional parse(final String str) throws ParseException {

        final QBTLexer lexer = new QBTLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final QBTParser parser = new QBTParser(tokens);
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
