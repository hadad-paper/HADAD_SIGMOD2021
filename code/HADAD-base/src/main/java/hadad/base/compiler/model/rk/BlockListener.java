package hadad.base.compiler.model.rk;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.base.compiler.AntlrUtils;
import hadad.base.compiler.Pattern;
import hadad.base.compiler.RootBlock;
import hadad.base.compiler.exceptions.ParseException;

/**
 * RK BlockListener
 * 
 * 
 */
@Singleton
final class BlockListener {
    private static final Logger LOG = Logger.getLogger(BlockListener.class);

    private final PatternListener patternListener;
    private final ReturnTemplateListener returnTemplateListener;

    @Inject
    public BlockListener(final PatternListener patternListener, final ReturnTemplateListener returnTemplateListener) {
        this.patternListener = patternListener;
        this.returnTemplateListener = returnTemplateListener;
    }

    public RootBlock parse(final String queryName, final String str) throws ParseException {
        final BlockListenerAux listener = _parse(str);
        final Pattern pattern = patternListener.parse(listener.getPattern());
        return new RootBlock(queryName, pattern, returnTemplateListener.parse(listener.getReturnTemplate()));
    }

    private BlockListenerAux _parse(final String str) throws ParseException {
        final KQLLexer lexer = new KQLLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final KQLParser parser = new KQLParser(tokens);
        final ParserRuleContext tree = parser.redisKQLQuery();
        final ParseTreeWalker walker = new ParseTreeWalker();
        final BlockListenerAux listener = new BlockListenerAux();
        try {
            walker.walk(listener, tree);
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
        if (listener.getPattern() == null) {
            throw new ParseException(new IllegalStateException("Pattern expected."));
        }

        if (listener.getReturnTemplate() == null) {
            throw new ParseException(new IllegalStateException("Return template expected."));
        }

        return listener;
    }

    private class BlockListenerAux extends KQLBaseListener {
        private String pattern;
        private String returnTemplate;

        public String getPattern() {
            return pattern;
        }

        public String getReturnTemplate() {
            return returnTemplate;
        }

        @Override
        public void enterRkFromClasue(KQLParser.RkFromClasueContext ctx) {
            LOG.debug("Entering FromClause: " + ctx.getText());
            if (pattern == null && returnTemplate != null) {
                pattern = AntlrUtils.getFullText(ctx);
            }
        }

        @Override
        public void enterRkSelectClasue(KQLParser.RkSelectClasueContext ctx) {
            LOG.debug("Entering SelectClause: " + ctx.getText());
            if (pattern == null && returnTemplate == null) {
                returnTemplate = AntlrUtils.getFullText(ctx);
                LOG.debug("Return Template: " + returnTemplate);
            }
        }
    }
}
