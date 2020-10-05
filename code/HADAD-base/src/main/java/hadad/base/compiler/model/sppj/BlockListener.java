package hadad.base.compiler.model.sppj;

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
 * SPPJ BlockListener
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
     * Parse the query/view definition.
     * 
     * @param queryName
     *            the query/view name
     * @param str
     *            the query/view definition that needs to be parsed
     * @return the root block
     * @throws ParseException
     */
    public RootBlock parse(final String queryName, final String str) throws ParseException {
        final BlockListenerAux listener = _parse(str);
        final Pattern pattern = patternListener.parse(listener.getPattern());
        return new RootBlock(queryName, pattern, returnTemplateListener.parse(listener.getReturnTemplate()));
    }

    /**
     * Parse the child query/view definition
     * 
     * @param parent
     *            the parent block
     * @param createdNode
     *            the newly created node
     * @param str
     *            the child query/view definition that needs to be parsed
     * @return
     * @throws ParseException
     */
    public ChildBlock parse(final Block parent, final String createdNode, final String str) throws ParseException {
        final BlockListenerAux listener = _parse(str);
        final Pattern pattern = patternListener.parse(listener.getPattern());
        return new ChildBlock(parent, createdNode, pattern, returnTemplateListener.parse(listener.getReturnTemplate()));
    }

    private BlockListenerAux _parse(final String str) throws ParseException {
        final SPPJQLLexer lexer = new SPPJQLLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final SPPJQLParser parser = new SPPJQLParser(tokens);
        final ParserRuleContext tree = parser.sppjQuery();
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

    private class BlockListenerAux extends SPPJQLBaseListener {
        private String pattern;
        private String returnTemplate;

        public String getPattern() {
            return pattern;
        }

        public String getReturnTemplate() {
            return returnTemplate;
        }

        @Override
        public void enterSppjFromWhereClause(SPPJQLParser.SppjFromWhereClauseContext ctx) {
            LOGGER.debug("Entering fromWhereClause: " + ctx.getText());
            if (pattern == null) {
                pattern = AntlrUtils.getFullText(ctx);
            }
        }

        @Override
        public void enterSppjSelectClause(SPPJQLParser.SppjSelectClauseContext ctx) {
            LOGGER.debug("Entering selectClause: " + ctx.getText());
            if (returnTemplate == null)
                returnTemplate = AntlrUtils.getFullText(ctx);
        }
    }
}
