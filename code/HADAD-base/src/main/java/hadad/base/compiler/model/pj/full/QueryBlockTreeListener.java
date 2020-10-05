package hadad.base.compiler.model.pj.full;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import hadad.commons.miscellaneous.Tuple;
import hadad.base.compiler.AntlrUtils;
import hadad.base.compiler.Block;
import hadad.base.compiler.ChildBlock;
import hadad.base.compiler.QueryBlockTree;
import hadad.base.compiler.ReturnConstructTerm;
import hadad.base.compiler.ReturnLeafTerm;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.ReturnTerm;
import hadad.base.compiler.RootBlock;
import hadad.base.compiler.StringElement;
import hadad.base.compiler.VariableFactory;
import hadad.base.compiler.VariableMapper;
import hadad.base.compiler.exceptions.ParseException;

/**
 * PJ QueryBlockTreeListener
 * 
 *   
 */
@Singleton
final class QueryBlockTreeListener {
    private static final Logger LOGGER = Logger.getLogger(QueryBlockTreeListener.class);
    private final BlockListener blockListener;
    private final VariableFactory cqVariableFactory;
    private final VariableFactory aqlVariableFactory;
    private final VariableMapper variableMapper;
    private RootBlock root;

    @Inject
    public QueryBlockTreeListener(final BlockListener blockListener,
            @Named("ConjunctiveQueryVariableFactory") final VariableFactory cqVariableFactory,
            @Named("PJQLVariableFactory") final VariableFactory pjqlVariableFactory,
            final VariableMapper variableMapper) {
        this.blockListener = blockListener;
        this.cqVariableFactory = cqVariableFactory;
        this.aqlVariableFactory = pjqlVariableFactory;
        this.variableMapper = variableMapper;
    }

    /**
     * Parse PJQL query
     * 
     * @param str
     *            the PJQL query that needs to be parsed
     * @return
     * @throws ParseException
     */
    public QueryBlockTree parse(final String str) throws ParseException {
        final PJQLLexer lexer = new PJQLLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final PJQLParser parser = new PJQLParser(tokens);
        final ParserRuleContext tree = parser.pjQuery();
        final ParseTreeWalker walker = new ParseTreeWalker();
        final NestedBlockTreeListenerAux listener = new NestedBlockTreeListenerAux();
        try {
            walker.walk(listener, tree);
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
        if (listener.getRoot() == null) {
            throw new ParseException(new IllegalStateException("Root expected."));
        }
        if (listener.hasRootElement()) {
            final List<ReturnTerm> terms = new ArrayList<ReturnTerm>();
            final ReturnConstructTerm parent =
                    new ReturnConstructTerm(new StringElement(""), new HashMap<String, ReturnLeafTerm>());
            parent.addChild(
                    new ReturnConstructTerm(parent, listener.getRootElement(), new HashMap<String, ReturnLeafTerm>()));
            terms.add(parent);
            root = new RootBlock(listener.getQueryName(), new ReturnTemplate(PJModel.ID, terms));
            final ChildBlock rootChild =
                    blockListener.parse(root, listener.getRootElement().toString(), listener.getRoot().getFlwr());
            parseChildren(rootChild, listener.getRoot().getChildren());
            root.addChild(rootChild);
        } else {
            root = blockListener.parse(listener.getQueryName(), listener.getRoot().getFlwr());
            parseChildren(root, listener.getRoot().getChildren());
        }

        return new QueryBlockTree(root);
    }

    private void parseChildren(final Block parent, final List<Tuple<String, BlockAux>> children) {
        for (final Tuple<String, BlockAux> child : children) {
            final ChildBlock childBlock = blockListener.parse(parent, child.first(), child.second().getFlwr());
            parent.addChild(childBlock);
            parseChildren(childBlock, child.second().getChildren());
        }
    }

    private class NestedBlockTreeListenerAux extends PJQLBaseListener {
        private BlockAux root;
        private BlockAux currentBlock;
        private String queryName;
        private StringElement rootElement;
        private Stack<String> currentFlwrConstructTag;

        public BlockAux getRoot() {
            return root;
        }

        public String getQueryName() {
            return queryName;
        }

        public boolean hasRootElement() {
            return rootElement != null;
        }

        public StringElement getRootElement() {
            return rootElement;
        }

        @Override
        public void enterPjQuery(PJQLParser.PjQueryContext ctx) {
            LOGGER.debug("Entering pjquery: " + ctx.getText());
            cqVariableFactory.reset();
            aqlVariableFactory.reset();
            variableMapper.reset();
            currentFlwrConstructTag = new Stack<String>();
            if (currentBlock == null) {
                root = new BlockAux(AntlrUtils.getFullText(ctx), null);
                currentBlock = root;
            } else {
                final BlockAux block = new BlockAux(AntlrUtils.getFullText(ctx), currentBlock);
                currentBlock.addChild(currentFlwrConstructTag.peek(), block);
                currentBlock = block;
            }
        }

        @Override
        public void exitPjQuery(PJQLParser.PjQueryContext ctx) {
            LOGGER.debug("Exiting query: " + ctx.getText());
            currentBlock = !currentBlock.hasParent() ? null : currentBlock.getParent();
        }
    }

    private class BlockAux {
        private final String flwr;
        private final List<Tuple<String, BlockAux>> children;
        private final BlockAux parent;

        public BlockAux(final String flwr, final BlockAux parent) {
            this.flwr = flwr;
            this.parent = parent;
            children = new ArrayList<Tuple<String, BlockAux>>();
        }

        public void addChild(final String tag, final BlockAux child) {
            children.add(new Tuple<String, BlockAux>(tag, child));
        }

        public String getFlwr() {
            return flwr;
        }

        public boolean hasParent() {
            return parent != null;
        }

        public BlockAux getParent() {
            return parent;
        }

        public List<Tuple<String, BlockAux>> getChildren() {
            return children;
        }
    }
}
