package hadad.base.compiler.model.sj;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.base.compiler.AntlrUtils;
import hadad.base.compiler.Block;
import hadad.base.compiler.ChildBlock;
import hadad.base.compiler.Pattern;
import hadad.base.compiler.RootBlock;
import hadad.base.compiler.exceptions.ParseException;

/**
 * SJ BlockListener
 * 
 *   
 */
@Singleton
final class BlockListener {
    private static final Logger LOGGER = Logger.getLogger(BlockListener.class);

    private final PatternListener patternListener;
    private final ReturnTemplateListener returnTemplateListener;

    @Inject
    public BlockListener(final PatternListener patternListener, final ReturnTemplateListener returnTemplateListener) {
        this.patternListener = patternListener;
        this.returnTemplateListener = returnTemplateListener;
    }

    /**
     * Parse SJQL
     * 
     * @param queryName
     * @param str
     * @return rootblock
     * @throws ParseException
     */
    public RootBlock parse(final String queryName, final String str) throws ParseException {
        final BlockListenerAux listener = _parse(str);
        final Pattern pattern = patternListener.parse(listener.getPattern());
        return new RootBlock(queryName, pattern,
                returnTemplateListener.parseProjectFields(listener.getReturnTemplate()));
    }

    /**
     * Parse SJQL
     * 
     * @param parent
     * @param createdNode
     * @param str
     * @return childblook
     * @throws ParseException
     */
    public ChildBlock parse(final Block parent, final String createdNode, final String str) throws ParseException {
        final BlockListenerAux listener = _parse(str);
        final Pattern pattern = patternListener.parse(listener.getPattern());
        return new ChildBlock(parent, createdNode, pattern,
                returnTemplateListener.parseProjectFields(listener.getReturnTemplate()));
    }

    private BlockListenerAux _parse(final String str) throws ParseException {
        final SJQLLexer lexer = new SJQLLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final SJQLParser parser = new SJQLParser(tokens);
        final ParserRuleContext tree = parser.sjQuery();
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

    private class BlockListenerAux extends SJQLBaseListener {
        private String pattern;
        private String returnTemplate;

        /**
         * Get the pattern
         * 
         * @return pattern. The constructed pattern
         */
        public String getPattern() {
            return pattern;
        }

        /**
         * Get return template
         * 
         * @return returnTemplate. The constructed return template
         */
        public String getReturnTemplate() {
            return returnTemplate;
        }

        @Override
        public void enterSjQuery(SJQLParser.SjQueryContext ctx) {
            LOGGER.debug("Entering query: " + ctx.getText());
            if (pattern == null && returnTemplate == null) {
                pattern = AntlrUtils.getFullText(ctx);
            }
        }

        @Override
        public void enterSjProjectFields(SJQLParser.SjProjectFieldsContext ctx) {
            LOGGER.debug("Entering project fields: " + ctx.getText());
            if (pattern != null && returnTemplate == null) {
                returnTemplate = AntlrUtils.getFullText(ctx);
            }
        }
    }
}
