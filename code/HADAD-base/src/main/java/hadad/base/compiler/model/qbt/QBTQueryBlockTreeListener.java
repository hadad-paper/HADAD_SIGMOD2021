package hadad.base.compiler.model.qbt;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.base.compiler.AntlrUtils;
import hadad.base.compiler.ChildBlock;
import hadad.base.compiler.QueryBlockTree;
import hadad.base.compiler.RootBlock;
import hadad.base.compiler.exceptions.ParseException;

/**
 * QBT Query Block Tree
 * 
 *   
 *
 */
@Singleton
final class QBTQueryBlockTreeListener {
    private static final Logger log = Logger.getLogger(QBTQueryBlockTreeListener.class);

    private final BlockListener blockListener;
    private RootBlock root;
    private ChildBlock childBlock;

    @Inject
    public QBTQueryBlockTreeListener(final BlockListener blockListener) {
        this.blockListener = blockListener;
    }

    public QueryBlockTree parse(final String str) throws ParseException {
        final QBTLexer lexer = new QBTLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final QBTParser parser = new QBTParser(tokens);
        final ParserRuleContext tree = parser.mixedqbt();
        final ParseTreeWalker walker = new ParseTreeWalker();
        final BlockTreeListenerAux listener = new BlockTreeListenerAux();
        try {
            walker.walk(listener, tree);
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
        if (listener.getQueryName() == null) {
            throw new ParseException(new IllegalStateException("Block Name Expxcted."));
        }
        if (listener.getRoot() == null) {
            throw new ParseException(new IllegalStateException("Root Block expected."));
        }

        // Obtaining/Parsing childblock based on the model.
        if (listener.getPattenBlocksCounts() == 1 && listener.getChildBlockModel().equals(listener.getPattenModel())
                && listener.isChildBlockNested()) {
            root = blockListener.parse(listener.getQueryName(), listener.getRoot().getFlwr());
        } else {
            root = blockListener.parse(listener.getQueryName(), listener.getRoot().getFlwr());
            if (listener.isChildBlockNested()) {
                switch (listener.getChildBlockModel()) {
                    case "AJ":
                        childBlock = QBTQueryBlockTreeBuilder.ajBlockNestedTreeBuilder
                                .buildQueryBlockTree(listener.getChildBlock()).getRoot().getChildren().get(0);
                        childBlock.setParentBlock(root);
                        childBlock.setCreatedNode(listener.getJQElement());
                        root.addChild(childBlock);
                        break;
                    case "SPPJ":
                        childBlock = QBTQueryBlockTreeBuilder.sppjBlockNestedTreeBuilder
                                .buildQueryBlockTree(listener.getChildBlock()).getRoot().getChildren().get(0);
                        childBlock.setParentBlock(root);
                        childBlock.setCreatedNode(listener.getJQElement());
                        root.addChild(childBlock);
                        break;
                }
            }
        }

        return new QueryBlockTree(root);
    }

    private class BlockTreeListenerAux extends QBTBaseListener {
        private BlockAux root;
        private BlockAux currentBlock;
        private String viewName;
        private String patternModel;
        private String childBlock;
        private String childBlockModel;
        private String jqElement;
        private boolean NestedChildBlock;
        private boolean tagObtained;
        private int blockPatternsCount;

        public BlockTreeListenerAux() {
            this.root = null;
            this.currentBlock = null;
            this.tagObtained = false;
        }

        public BlockAux getRoot() {
            return root;
        }

        public String getQueryName() {
            return viewName;
        }

        public boolean isChildBlockNested() {
            return NestedChildBlock;
        }

        public String getChildBlock() {
            return childBlock;
        }

        public String getChildBlockModel() {
            return childBlockModel;
        }

        public String getPattenModel() {
            return patternModel;
        }

        public String getJQElement() {
            return jqElement;
        }

        public int getPattenBlocksCounts() {
            return blockPatternsCount;
        }

        @Override
        public void enterViewName(QBTParser.ViewNameContext ctx) {
            log.debug("Entering ViewName: " + ctx.getText());
            viewName = ctx.getText();
        }

        @Override
        public void enterQbtQuery(QBTParser.QbtQueryContext ctx) {
            log.debug("Entering mixed QBT query: " + ctx.getText());
            if (currentBlock == null) {
                root = new BlockAux(AntlrUtils.getFullText(ctx), null);
                currentBlock = root;
            }
        }

        @Override
        public void exitQbtQuery(QBTParser.QbtQueryContext ctx) {
            log.debug("Exiting mixedQBT query: " + ctx.getText());
            currentBlock = !currentBlock.hasParent() ? null : currentBlock.getParent();
        }

        @Override
        public void exitQbtReturnPattern(QBTParser.QbtReturnPatternContext ctx) {
            log.debug("Entering ReturnPattern query: " + ctx.getText());
            childBlockModel = ctx.constructor().annotation().getText();
            if (childBlockModel.equals("AJ")) {
                if (NestedChildBlock) {
                    childBlock = "V= " + AntlrUtils.getFullText(ctx.constructor().modelConstructor().ajConstructor());
                }
            }
            if (childBlockModel.equals("XQ")) {
                if (NestedChildBlock) {
                    //childBlock = "V= " + AntlrUtils.getFullText(ctx.constructor().modelConstructor().xqConstructor());
                }
            }
            if (childBlockModel.equals("SPPJ")) {
                if (NestedChildBlock) {
                    childBlock = "V= " + AntlrUtils.getFullText(ctx.constructor().modelConstructor().sppjConstructor());
                }
            }

        }

        @Override
        public void enterQbtForPattern(QBTParser.QbtForPatternContext ctx) {
            blockPatternsCount = ctx.qbtPattern().size();
            if (!(blockPatternsCount > 1)) {
                patternModel = ctx.qbtPattern(0).annotation().getText();
            }
        }

        @Override
        public void enterQuery(QBTParser.QueryContext ctx) {
            NestedChildBlock = true;
        }

        @Override
        public void enterSppjQuery(QBTParser.SppjQueryContext ctx) {
            NestedChildBlock = true;
        }

        @Override
        public void exitRecordConstructFieldName(QBTParser.RecordConstructFieldNameContext ctx) {
            if (!tagObtained) {
                jqElement = ctx.getText().replaceAll("\"", "");
                tagObtained = true;
            }

        }

        @Override
        public void exitSppjRecordConstructFieldName(QBTParser.SppjRecordConstructFieldNameContext ctx) {
            if (!tagObtained) {
                jqElement = ctx.getText().replaceAll("\"", "");
                tagObtained = true;
            }

        }
    }

    private class BlockAux {
        private final String fwr;
        private final BlockAux parent;

        public BlockAux(final String fwr, final BlockAux parent) {
            this.fwr = fwr;
            this.parent = parent;

        }

        public String getFlwr() {
            return fwr;
        }

        public boolean hasParent() {
            return parent != null;
        }

        public BlockAux getParent() {
            return parent;
        }

    }
}
