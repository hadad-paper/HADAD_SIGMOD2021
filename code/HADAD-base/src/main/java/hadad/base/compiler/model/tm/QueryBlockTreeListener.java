package hadad.base.compiler.model.tm;

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
 * TM Query Block Tree Listener
 * 
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
            @Named("TFMVariableFactory") final VariableFactory aqlVariableFactory,
            final VariableMapper variableMapper) {
        this.blockListener = blockListener;
        this.cqVariableFactory = cqVariableFactory;
        this.aqlVariableFactory = aqlVariableFactory;
        this.variableMapper = variableMapper;
    }

    /**
     * Parse the query block tree
     * 
     * @param str
     *            The query to be parsed.
     * @return The query block tree representation.
     * @throws ParseException
     */
    public QueryBlockTree parse(final String str) throws ParseException {
        final TFMLexer lexer = new TFMLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final TFMParser parser = new TFMParser(tokens);
        final ParserRuleContext tree = parser.tfmQuery();
        final ParseTreeWalker walker = new ParseTreeWalker();
        final NestedBlockTreeListenerAux listener = new NestedBlockTreeListenerAux();
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
        if (listener.hasRootElement()) {
            final List<ReturnTerm> terms = new ArrayList<ReturnTerm>();
            final ReturnConstructTerm parent =
                    new ReturnConstructTerm(new StringElement(""), new HashMap<String, ReturnLeafTerm>());
            parent.addChild(
                    new ReturnConstructTerm(parent, listener.getRootElement(), new HashMap<String, ReturnLeafTerm>()));
            terms.add(parent);
            root = new RootBlock(listener.getQueryName(), new ReturnTemplate(TMModel.ID, terms));
            final ChildBlock rootChild =
                    blockListener.parse(root, listener.getRootElement().toString(), listener.getRoot().getScript());
            parseChildren(rootChild, listener.getRoot().getChildren());
            root.addChild(rootChild);
        } else {
            root = blockListener.parse(listener.getQueryName(), listener.getRoot().getScript());
            parseChildren(root, listener.getRoot().getChildren());
        }

        return new QueryBlockTree(root);
    }

    private void parseChildren(final Block parent, final List<Tuple<String, BlockAux>> children) {
        for (final Tuple<String, BlockAux> child : children) {
            final ChildBlock childBlock = blockListener.parse(parent, child.first(), child.second().getScript());
            parent.addChild(childBlock);
            parseChildren(childBlock, child.second().getChildren());
        }
    }

    private class NestedBlockTreeListenerAux extends TFMBaseListener {
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
        public void enterTfmQuery(TFMParser.TfmQueryContext ctx) {
            LOGGER.debug("Entering DMLQuery: " + ctx.getText());
            cqVariableFactory.reset();
            aqlVariableFactory.reset();
            variableMapper.reset();
            currentFlwrConstructTag = new Stack<String>();
        }

        @Override
        public void enterViewName(TFMParser.ViewNameContext ctx) {
            LOGGER.debug("Entering ViewName: " + ctx.getText());
            queryName = ctx.getText();
        }

        @Override
        public void enterTfmScript(TFMParser.TfmScriptContext ctx) {
            LOGGER.debug("Entering DMLScript: " + ctx.getText());
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
        public void exitTfmScript(TFMParser.TfmScriptContext ctx) {
            LOGGER.debug("Exiting query: " + ctx.getText());
            currentBlock = !currentBlock.hasParent() ? null : currentBlock.getParent();
        }
    }

    private class BlockAux {
        private final String script;
        private final List<Tuple<String, BlockAux>> children;
        private final BlockAux parent;

        public BlockAux(final String script, final BlockAux parent) {
            this.script = script;
            this.parent = parent;
            children = new ArrayList<Tuple<String, BlockAux>>();
        }

        public void addChild(final String tag, final BlockAux child) {
            children.add(new Tuple<String, BlockAux>(tag, child));
        }

        public String getScript() {
            return script;
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
