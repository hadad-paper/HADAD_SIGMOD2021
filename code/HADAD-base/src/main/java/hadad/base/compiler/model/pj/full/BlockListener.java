package hadad.base.compiler.model.pj.full;

import java.util.ArrayList;

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
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.ReturnTerm;
import hadad.base.compiler.RootBlock;
import hadad.base.compiler.exceptions.ParseException;

/**
 * PJ BlockListener
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
        return new RootBlock("dummy", pattern, new ReturnTemplate(PJModel.ID, new ArrayList<ReturnTerm>()));
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
        return new ChildBlock(parent, createdNode, pattern,
                new ReturnTemplate(PJModel.ID, new ArrayList<ReturnTerm>()));
    }

    private BlockListenerAux _parse(final String str) throws ParseException {
        final PJQLLexer lexer = new PJQLLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final PJQLParser parser = new PJQLParser(tokens);
        final ParserRuleContext tree = parser.pjQuery();
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
        return listener;
    }

    private class BlockListenerAux extends PJQLBaseListener {
        private StringBuffer fromPattern = new StringBuffer();
        private StringBuffer wherePattern = new StringBuffer();
        private StringBuffer selectPattern = new StringBuffer();

        public String getPattern() {
            return fromPattern.toString();
        }

        @Override
        public void enterPjFromClause(final PJQLParser.PjFromClauseContext ctx) {
            LOGGER.debug("Entering fromClause: " + ctx.getText());
            fromPattern.append(AntlrUtils.getFullText(ctx));

        }

        @Override
        public void enterPjWhereClause(PJQLParser.PjWhereClauseContext ctx) {
            LOGGER.debug("Entering whereClause: " + ctx.getText());
            wherePattern.append(AntlrUtils.getFullText(ctx));

        }

        @Override
        public void enterPjPathSelect(final PJQLParser.PjPathSelectContext ctx) {
            LOGGER.debug("Entering pathSelect: " + ctx.getText());
            selectPattern.append(",");
            selectPattern.append(AntlrUtils.getFullText(ctx));

        }

        @Override
        public void exitPjQuery(PJQLParser.PjQueryContext ctx) {
            fromPattern.append(selectPattern);
            fromPattern.append(" ");
            fromPattern.append(wherePattern);
        }
    }

    public PatternListener getPatternListener() {
        return patternListener;
    }

}
