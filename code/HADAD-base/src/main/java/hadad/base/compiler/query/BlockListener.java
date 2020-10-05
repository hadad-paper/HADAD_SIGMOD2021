package hadad.base.compiler.query;

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
import hadad.base.compiler.QueryBlockTree;
import hadad.base.compiler.RootBlock;
import hadad.base.compiler.exceptions.ParseException;

/**
 * Block listener
 * 
 *   
 */
@Singleton
final class BlockListener {
    private static final Logger log = Logger.getLogger(BlockListener.class);
    private final PatternListener patternListener;
    private final ReturnTemplateListener returnTemplateListener;

    @Inject
    public BlockListener(final PatternListener patternListener, final ReturnTemplateListener returnTemplateListener) {
        this.patternListener = patternListener;
        this.returnTemplateListener = returnTemplateListener;

    }

    public RootBlock parse(final String queryName, final String str) throws ParseException {
        final BlockListenerAux listener = _parse(str);

        if (listener.getBlockPatternsCount() == 1
                && listener.getPatternModel().equals(listener.getReturnTemplateModel())) {
            switch (listener.getPatternModel()) {
                case "JQ":
                    QueryBlockTree nbtJQ = MixedNestedBlockTreeBuilder.jqBlockNestedTreeBuilder
                            .buildQueryBlockTree("Q=" + "for " + listener.getSpecifiedPattern()
                                    .concat(" return " + listener.getSpecifiedReturnTemplate()));
                    return nbtJQ.getRoot();
                case "KQ":
                    QueryBlockTree nbtKQ = MixedNestedBlockTreeBuilder.kqBlockNestedTreeBuilder.buildQueryBlockTree(
                            "Q=" + listener.getSpecifiedReturnTemplate().concat(" " + listener.getSpecifiedPattern()));
                    return nbtKQ.getRoot();
                case "RQ": //TODO: Fix RQ return constructor
                    QueryBlockTree nbtXQ =
                            MixedNestedBlockTreeBuilder.rqBlockNestedTreeBuilder.buildQueryBlockTree("Q=" + listener
                                    .getSpecifiedPattern().concat(" return " + listener.getSpecifiedReturnTemplate()));
                    return nbtXQ.getRoot();
                default:
                    return null;
            }
        } else {
            final Pattern pattern = patternListener.parse(listener.getPattern());
            return new RootBlock(queryName, pattern, returnTemplateListener.parse(listener.getReturnTemplate()));
        }

    }

    public ChildBlock parse(final Block parent, final String createdNode, final String str) throws ParseException {
        final BlockListenerAux listener = _parse(str);
        final Pattern pattern = patternListener.parse(listener.getPattern());
        return new ChildBlock(parent, createdNode, pattern, returnTemplateListener.parse(listener.getReturnTemplate()));
    }

    private BlockListenerAux _parse(final String str) throws ParseException {
        final QBTQUERYLexer lexer = new QBTQUERYLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final QBTQUERYParser parser = new QBTQUERYParser(tokens);
        final ParserRuleContext tree = parser.block();
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

    private class BlockListenerAux extends QBTQUERYBaseListener {
        private String pattern;
        private String specifiedPattern;
        private String returnTemplate;
        private String specifiedreturnTemplate;
        private String patternModel;
        private String returnModel;
        private int blockPatternsCount;

        public String getPattern() {
            return pattern;
        }

        public String getSpecifiedPattern() {
            return specifiedPattern;
        }

        public String getPatternModel() {
            return patternModel;
        }

        public String getReturnTemplateModel() {
            return returnModel;
        }

        public String getReturnTemplate() {
            return returnTemplate;
        }

        public String getSpecifiedReturnTemplate() {
            return specifiedreturnTemplate;
        }

        public int getBlockPatternsCount() {
            return blockPatternsCount;
        }

        @Override
        public void enterForPattern(QBTQUERYParser.ForPatternContext ctx) {
            log.debug("Entering ForPattern: " + ctx.getText());

            if (pattern == null && returnTemplate == null) {
                blockPatternsCount = ctx.pattern().size();
                pattern = AntlrUtils.getFullText(ctx);
                if (!(blockPatternsCount > 1)) {
                    patternModel = ctx.pattern().get(0).annotation().getText();
                    switch (patternModel) {
                        case "JQ":
                            specifiedPattern = AntlrUtils.getFullText(ctx.pattern(0).modelPattern().jqPattern());
                            break;
                        case "KQ":
                            specifiedPattern = AntlrUtils.getFullText(ctx.pattern(0).modelPattern().kqPattern());
                            break;
                        case "RQ":
                            specifiedPattern = AntlrUtils.getFullText(ctx.pattern(0).modelPattern().rqPattern());
                            break;
                    }
                }
            }
        }

        @Override
        public void enterReturnPattern(QBTQUERYParser.ReturnPatternContext ctx) {
            log.debug("Entering ReturnPattern: " + ctx.getText());
            if (pattern != null && returnTemplate == null) {
                returnTemplate = AntlrUtils.getFullText(ctx);
                log.debug("Return Template: " + returnTemplate);
                if (!(blockPatternsCount > 1)) {
                    returnModel = ctx.constructor().annotation().getText();
                    switch (returnModel) {
                        case "JQ":
                            specifiedreturnTemplate =
                                    AntlrUtils.getFullText(ctx.constructor().modelConstructor().jqConstructor());
                            break;
                        case "KQ":
                            specifiedreturnTemplate =
                                    AntlrUtils.getFullText(ctx.constructor().modelConstructor().kqConstructor());
                            break;
                    }
                }
            }
        }
    }
}
