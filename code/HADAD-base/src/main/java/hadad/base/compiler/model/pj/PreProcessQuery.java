package hadad.base.compiler.model.pj;

import java.util.Stack;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import hadad.base.compiler.exceptions.ParseException;

public class PreProcessQuery {

    static String process(final String query) {
        final PJQLLexer lexer = new PJQLLexer(CharStreams.fromString(query));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final PJQLParser parser = new PJQLParser(tokens);
        final ParserRuleContext tree = parser.pjqlQuery();
        final ParseTreeWalker walker = new ParseTreeWalker();
        final PreProcessQueryAux listener = new PreProcessQueryAux();
        try {
            walker.walk(listener, tree);
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }

        return null;
    }

    private static class PreProcessQueryAux extends PJQLBaseListener {
        private Stack<String> currentSelectElement = new Stack<String>();
        private StringBuilder query = new StringBuilder();
        private StringBuilder fromWhereClause = new StringBuilder();
    }

}
