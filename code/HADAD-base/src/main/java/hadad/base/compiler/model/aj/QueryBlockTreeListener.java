package hadad.base.compiler.model.aj;

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
 * AJ QueryBlockTreeListener
 */
@Singleton
final class QueryBlockTreeListener {
    private static final Logger log = Logger.getLogger(QueryBlockTreeListener.class);

    private final BlockListener blockListener;
    private final VariableFactory cqVariableFactory;
    private final VariableFactory aqlVariableFactory;
    private final VariableMapper variableMapper;

    /* Used to keep the root block of the query being parsed */
    private RootBlock root;

    @Inject
    public QueryBlockTreeListener(final BlockListener blockListener,
            @Named("ConjunctiveQueryVariableFactory") final VariableFactory cqVariableFactory,
            @Named("AQLVariableFactory") final VariableFactory aqlVariableFactory,
            final VariableMapper variableMapper) {
        this.blockListener = blockListener;
        this.cqVariableFactory = cqVariableFactory;
        this.aqlVariableFactory = aqlVariableFactory;
        this.variableMapper = variableMapper;
    }

    public QueryBlockTree parse(final String str) throws ParseException {
        final AQLLexer lexer = new AQLLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final AQLParser parser = new AQLParser(tokens);
        final ParserRuleContext tree = parser.aqlquery();
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
            root = new RootBlock(listener.getQueryName(), new ReturnTemplate(AJModel.ID, terms));
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

    private class NestedBlockTreeListenerAux extends AQLBaseListener {
        private BlockAux root;
        private BlockAux currentBlock;
        /* Used to keep the query name of the query being parsed */
        private String queryName;
        /* Used to keep the root element of the query being parsed */
        private StringElement rootElement;
        /* Used to know the tag inside current constructFlwr */
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
        public void enterAqlquery(AQLParser.AqlqueryContext ctx) {
            log.debug("Entering AQLQuery: " + ctx.getText());
            cqVariableFactory.reset();
            aqlVariableFactory.reset();
            variableMapper.reset();
            currentFlwrConstructTag = new Stack<String>();
        }

        @Override
        public void enterViewName(AQLParser.ViewNameContext ctx) {
            log.debug("Entering ViewName: " + ctx.getText());
            queryName = ctx.getText();
        }

        @Override
        public void enterRootFieldName(AQLParser.RootFieldNameContext ctx) {
            log.debug("Entering RootFieldName: " + ctx.getText());
            rootElement = new StringElement(ctx.getText().substring(1, ctx.getText().length() - 1));
        }

        @Override
        public void enterRecordConstructFieldName(AQLParser.RecordConstructFieldNameContext ctx) {
            log.debug("Entering RecordConstructFieldName: " + ctx.getText());
            currentFlwrConstructTag.push(ctx.getText().substring(1, ctx.getText().length() - 1));
        }

        @Override
        public void exitFieldBinding(AQLParser.FieldBindingContext ctx) {
            log.debug("Exiting FieldBinding: " + ctx.getText());
            currentFlwrConstructTag.pop();
        }

        @Override
        public void enterQuery(AQLParser.QueryContext ctx) {
            log.debug("Entering query: " + ctx.getText());
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
        public void exitQuery(AQLParser.QueryContext ctx) {
            log.debug("Exiting query: " + ctx.getText());
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
