package hadad.base.compiler.model.rk;

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
 * RK BlockTreeListener
 * 
 * 
 */
@Singleton
final class BlockTreeListener {
    private static final Logger LOG = Logger.getLogger(BlockTreeListener.class);

    private final BlockListener blockListener;
    private final VariableFactory cqVariableFactory;
    private final VariableFactory kqlVariableFactory;
    private final VariableMapper variableMapper;

    /* Used to keep the root block of the query being parsed */
    private RootBlock root;

    @Inject
    public BlockTreeListener(final BlockListener blockListener,
            @Named("ConjunctiveQueryVariableFactory") final VariableFactory cqVariableFactory,
            @Named("KQLVariableFactory") final VariableFactory kqlVariableFactory,
            final VariableMapper variableMapper) {
        this.blockListener = blockListener;
        this.cqVariableFactory = cqVariableFactory;
        this.kqlVariableFactory = kqlVariableFactory;
        this.variableMapper = variableMapper;
    }

    public QueryBlockTree parse(final String str) throws ParseException {
        final KQLLexer lexer = new KQLLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final KQLParser parser = new KQLParser(tokens);
        final ParserRuleContext tree = parser.kqlquery();
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

    private class BlockTreeListenerAux extends KQLBaseListener {
        private BlockAux root;
        private BlockAux currentBlock;
        /* Used to keep the query name of the query being parsed */
        private String queryName;
        /* Used to keep the root element of the query being parsed */
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
        public void enterKqlquery(KQLParser.KqlqueryContext ctx) {
            LOG.debug("Entering KQLQuery: " + ctx.getText());
            cqVariableFactory.reset();
            kqlVariableFactory.reset();
            variableMapper.reset();
        }

        @Override
        public void enterViewName(KQLParser.ViewNameContext ctx) {
            LOG.debug("Entering ViewName: " + ctx.getText());
            queryName = ctx.getText();
        }

        @Override
        public void enterRedisKQLQuery(KQLParser.RedisKQLQueryContext ctx) {
            LOG.debug("Entering query: " + ctx.getText());
            if (currentBlock == null) {
                root = new BlockAux(AntlrUtils.getFullText(ctx), null);
                currentBlock = root;
            }
        }

        @Override
        public void exitRedisKQLQuery(KQLParser.RedisKQLQueryContext ctx) {
            LOG.debug("Exiting query: " + ctx.getText());
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
