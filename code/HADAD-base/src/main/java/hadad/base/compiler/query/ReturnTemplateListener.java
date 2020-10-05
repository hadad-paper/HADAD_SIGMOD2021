package hadad.base.compiler.query;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.base.compiler.AntlrUtils;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.exceptions.ParseException;;

/**
 * Mixed model return template listener
 * 
 *   
 */
@Singleton
final class ReturnTemplateListener {
    private static final Logger log = Logger.getLogger(ReturnTemplateListener.class);

    @Inject
    public ReturnTemplateListener() {
    }

    public ReturnTemplate parse(final String str) throws ParseException {

        final QBTQUERYLexer lexer = new QBTQUERYLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final QBTQUERYParser parser = new QBTQUERYParser(tokens);
        final ParserRuleContext tree = parser.returnPattern();
        final ParseTreeWalker walker = new ParseTreeWalker();
        final ReturnListenerAux listener = new ReturnListenerAux();

        try {
            walker.walk(listener, tree);
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
        if (listener.getReturnTemplate() == null) {
            throw new ParseException(new IllegalStateException("Return Pattern expected."));
        }
        return listener.getReturnTemplate();
    }

    private class ReturnListenerAux extends QBTQUERYBaseListener {
        private ReturnTemplate returnTemplate;

        public ReturnTemplate getReturnTemplate() {
            return returnTemplate;
        }

        @Override
        public void enterConstructor(QBTQUERYParser.ConstructorContext ctx) {
            log.debug("Entering ReturnPattern: " + ctx.getText());
            switch (ctx.annotation().getText()) {
                case "JQ":
                    returnTemplate = MixedNestedBlockTreeBuilder.jqBlockNestedTreeBuilder.buildReturnTemplate(null,
                            "return " + AntlrUtils.getFullText(ctx.modelConstructor().jqConstructor()));
                    break;
                case "KQ":
                    returnTemplate = MixedNestedBlockTreeBuilder.kqBlockNestedTreeBuilder.buildReturnTemplate(null,
                            "SELECT " + AntlrUtils.getFullText(ctx.modelConstructor().kqConstructor()));
                    break;
                case "RQ":
                    // TODO
                    break;
                case "XQ":
                    returnTemplate = MixedNestedBlockTreeBuilder.xqBlockNestedTreeBuilder.buildReturnTemplate(null,
                            "return " + AntlrUtils.getFullText(ctx.modelConstructor().xqConstructor()));
                    break;

            }

        }

    }
}
