package hadad.base.compiler.query;

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
 * Mixed model block tree listener
 * 
 *   
 */
@Singleton
final class MixedBlockTreeListener {
    private static final Logger log = Logger.getLogger(MixedBlockTreeListener.class);

    private final BlockListener blockListener;
    private RootBlock root;
    private ChildBlock childBlock;

    @Inject
    public MixedBlockTreeListener(final BlockListener blockListener) {
        this.blockListener = blockListener;
    }

    public QueryBlockTree parse(final String str) throws ParseException {
        final QBTQUERYLexer lexer = new QBTQUERYLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final QBTQUERYParser parser = new QBTQUERYParser(tokens);
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

        if (listener.getPattenBlocksCounts() == 1 && listener.getChildBlockModel().equals(listener.getPattenModel())
                && listener.isChildBlockNested()) {
            root = blockListener.parse(listener.getQueryName(), listener.getRoot().getFlwr());
        } else {
            root = blockListener.parse(listener.getQueryName(), listener.getRoot().getFlwr());
            if (listener.isChildBlockNested()) {
                switch (listener.getChildBlockModel()) {
                    case "JQ":
                        childBlock = MixedNestedBlockTreeBuilder.jqBlockNestedTreeBuilder
                                .buildQueryBlockTree(listener.getChildBlock()).getRoot().getChildren().get(0);
                        childBlock.setParentBlock(root);
                        childBlock.setCreatedNode(listener.getJQElement());
                        root.addChild(childBlock);
                        break;

                    case "KQ":
                        childBlock = MixedNestedBlockTreeBuilder.kqBlockNestedTreeBuilder
                                .buildQueryBlockTree(listener.getChildBlock()).getRoot().getChildren().get(0);
                        childBlock.setParentBlock(root);
                        childBlock.setCreatedNode(listener.getXQElement());
                        root.addChild(childBlock);
                        break;

                    case "RQ":
                        childBlock = MixedNestedBlockTreeBuilder.rqBlockNestedTreeBuilder
                                .buildQueryBlockTree(listener.getChildBlock()).getRoot().getChildren().get(0);
                        childBlock.setParentBlock(root);
                        childBlock.setCreatedNode(listener.getXQElement());
                        root.addChild(childBlock);
                        break;
                }
            }
        }

        return new QueryBlockTree(root);
    }

    private class BlockTreeListenerAux extends QBTQUERYBaseListener {
        private BlockAux root;
        private BlockAux currentBlock;
        private String queryName;
        private String patternModel;
        private String childBlock;
        private String childBlockModel;
        private String jqElement;
        private String xqElement;
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
            return queryName;
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

        public String getXQElement() {
            return xqElement;
        }

        public int getPattenBlocksCounts() {
            return blockPatternsCount;
        }

        @Override
        public void enterQueryName(QBTQUERYParser.QueryNameContext ctx) {
            log.debug("Entering queryName: " + ctx.getText());
            queryName = ctx.getText();
        }

        @Override
        public void enterMixedQBTQuery(QBTQUERYParser.MixedQBTQueryContext ctx) {
            log.debug("Entering mixed QBT query: " + ctx.getText());
            if (currentBlock == null) {
                root = new BlockAux(AntlrUtils.getFullText(ctx), null);
                currentBlock = root;
            }
        }

        @Override
        public void exitMixedQBTQuery(QBTQUERYParser.MixedQBTQueryContext ctx) {
            log.debug("Exiting mixedQBT query: " + ctx.getText());
            currentBlock = !currentBlock.hasParent() ? null : currentBlock.getParent();
        }

        @Override
        public void exitReturnPattern(QBTQUERYParser.ReturnPatternContext ctx) {
            log.debug("Entering ReturnPattern query: " + ctx.getText());
            childBlockModel = ctx.constructor().annotation().getText();
            if (childBlockModel.equals("JQ")) {
                if (NestedChildBlock) {
                    childBlock = "Q= " + AntlrUtils.getFullText(ctx.constructor().modelConstructor().jqConstructor());
                }
            }
            //TODO: Fix KQ constructor
            if (childBlockModel.equals("KQ")) {
                if (NestedChildBlock) {
                    childBlock = "Q= " + AntlrUtils.getFullText(ctx.constructor().modelConstructor().kqConstructor());
                }
            }
            //TODO: Fix RQ constructor
            if (childBlockModel.equals("RQ")) {
                if (NestedChildBlock) {
                    childBlock = "Q= " + AntlrUtils.getFullText(ctx.constructor().modelConstructor());
                }
            }

        }

        @Override
        public void enterForPattern(QBTQUERYParser.ForPatternContext ctx) {
            blockPatternsCount = ctx.pattern().size();
            if (!(blockPatternsCount > 1)) {
                patternModel = ctx.pattern(0).annotation().getText();
            }
        }

        @Override
        public void enterQueryAQL(QBTQUERYParser.QueryAQLContext ctx) {
            NestedChildBlock = true;
        }

        @Override
        public void enterFlwr(QBTQUERYParser.FlwrContext ctx) {
            NestedChildBlock = true;
        }

        @Override
        public void exitRecordConstructFieldName(QBTQUERYParser.RecordConstructFieldNameContext ctx) {
            if (!tagObtained) {
                jqElement = ctx.getText().replaceAll("\"", "");
                tagObtained = true;
            }

        }
        //TODO: Add KQ and RQ constructors
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
