package hadad.base.compiler.model.pr;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import hadad.base.compiler.AntlrUtils;
import hadad.base.compiler.QueryBlockTree;
import hadad.base.compiler.RootBlock;
import hadad.base.compiler.StringElement;
import hadad.base.compiler.VariableFactory;
import hadad.base.compiler.VariableMapper;
import hadad.base.compiler.exceptions.ParseException;

/**
 * PR Query Block Tree Listener
 * 
 *   
 *
 */
@Singleton
final class QueryBlockTreeListener {
    private static final Logger log = Logger.getLogger(QueryBlockTreeListener.class);

    private final BlockListener blockListener;
    private final VariableFactory cqVariableFactory;
    private final VariableFactory sqlVariableFactory;
    private final VariableMapper variableMapper;

    private RootBlock root;

    @Inject
    public QueryBlockTreeListener(final BlockListener blockListener,
            @Named("ConjunctiveQueryVariableFactory") final VariableFactory cqVariableFactory,
            @Named("SQLVariableFactory") final VariableFactory sqlVariableFactory,
            final VariableMapper variableMapper) {
        this.blockListener = blockListener;
        this.cqVariableFactory = cqVariableFactory;
        this.sqlVariableFactory = sqlVariableFactory;
        this.variableMapper = variableMapper;
    }

    public QueryBlockTree parse(final String str) throws ParseException {
        final SQLLexer lexer = new SQLLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final SQLParser parser = new SQLParser(tokens);
        final ParserRuleContext tree = parser.rqQuery();
        final ParseTreeWalker walker = new ParseTreeWalker();
        final BlockTreeListenerAux listener = new BlockTreeListenerAux();
        try {
            walker.walk(listener, tree);
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
        if (listener.getQueryName() == null) {
            throw new ParseException(new IllegalStateException("Query name expected."));
        }
        if (listener.getRoot() == null) {
            throw new ParseException(new IllegalStateException("Root expected."));
        }
        if (!(listener.hasRootElement())) {
            root = blockListener.parse(listener.getQueryName(), listener.getRoot().getFlwr());
        }

        return new QueryBlockTree(root);
    }

    private class BlockTreeListenerAux extends SQLBaseListener {
        private BlockAux root;
        private BlockAux currentBlock;
        private String queryName;
        private StringElement rootElement;

        public BlockAux getRoot() {
            return root;
        }

        public String getQueryName() {
            return queryName;
        }

        public boolean hasRootElement() {
            return rootElement != null;
        }

        @Override
        public void enterRqQuery(SQLParser.RqQueryContext ctx) {
            log.debug("Entering Rq Query: " + ctx.getText());
            cqVariableFactory.reset();
            sqlVariableFactory.reset();
            variableMapper.reset();
        }

        @Override
        public void enterViewName(SQLParser.ViewNameContext ctx) {
            log.debug("Entering ViewName: " + ctx.getText());
            queryName = ctx.getText();
        }

        @Override
        public void enterPrQuery(SQLParser.PrQueryContext ctx) {
            log.debug("Entering SQL query: " + ctx.getText());
            if (currentBlock == null) {
                root = new BlockAux(AntlrUtils.getFullText(ctx), null);
                currentBlock = root;
            }
        }

        @Override
        public void exitPrQuery(SQLParser.PrQueryContext ctx) {
            log.debug("Exiting SQL query: " + ctx.getText());
            currentBlock = !currentBlock.hasParent() ? null : currentBlock.getParent();
        }
    }

    private class BlockAux {
        private final String sfw;
        private final BlockAux parent;

        public BlockAux(final String sfw, final BlockAux parent) {
            this.sfw = sfw;
            this.parent = parent;
        }

        public String getFlwr() {
            return sfw;
        }

        public boolean hasParent() {
            return parent != null;
        }

        public BlockAux getParent() {
            return parent;
        }

    }
}
