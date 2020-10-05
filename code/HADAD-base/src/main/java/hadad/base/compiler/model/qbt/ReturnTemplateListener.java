package hadad.base.compiler.model.qbt;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.base.compiler.AntlrUtils;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.exceptions.ParseException;

/**
 * QBT ReturnTemplateListener
 * 
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

        final QBTLexer lexer = new QBTLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final QBTParser parser = new QBTParser(tokens);
        final ParserRuleContext tree = parser.qbtReturnPattern();
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

    private class ReturnListenerAux extends QBTBaseListener {
        private ReturnTemplate returnTemplate;

        public ReturnTemplate getReturnTemplate() {
            return returnTemplate;
        }

        @Override
        public void enterConstructor(QBTParser.ConstructorContext ctx) {
            log.debug("Entering ReturnPattern: " + ctx.getText());
            switch (ctx.annotation().getText()) {
                case "AJ":
                    returnTemplate = QBTQueryBlockTreeBuilder.ajBlockNestedTreeBuilder.buildReturnTemplate(null,
                            "return " + AntlrUtils.getFullText(ctx.modelConstructor().ajConstructor()));
                    break;
                case "PJ":
                    returnTemplate = QBTQueryBlockTreeBuilder.pjBlockNestedTreeBuilder.buildReturnTemplate(null,
                            "SELECT " + AntlrUtils.getFullText(ctx.modelConstructor().pjConstructor()));
                    break;

                case "PR":
                    returnTemplate = QBTQueryBlockTreeBuilder.prBlockNestedTreeBuilder.buildReturnTemplate(null,
                            "SELECT " + AntlrUtils.getFullText(ctx.modelConstructor().prConstructor()));
                    break;
                case "SJ":
                    returnTemplate = QBTQueryBlockTreeBuilder.sjBlockNestedTreeBuilder.buildReturnTemplate(null,
                            AntlrUtils.getFullText(ctx.modelConstructor().sjConstructor()));
                    break;
                case "SPPJ":
                    returnTemplate = QBTQueryBlockTreeBuilder.sppjBlockNestedTreeBuilder.buildReturnTemplate(null,
                            "SELECT " + AntlrUtils.getFullText(ctx.modelConstructor().ajConstructor()));
                    break;
                case "RK":
                    returnTemplate = QBTQueryBlockTreeBuilder.rkBlockNestedTreeBuilder.buildReturnTemplate(null,
                            "SELECT " + AntlrUtils.getFullText(ctx.modelConstructor().rkConstructor()));
                    break;

            }

        }

    }
}
