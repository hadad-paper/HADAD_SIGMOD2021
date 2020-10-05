package hadad.base.compiler.model.qbt;

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
 * QBT Block Listener
 * 
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
        /*
         * Cases where we have a single pattern and single return template and
         * they belong to the same model. No need to use mixed model
         * compiler.So, we need to pass them to the corresponding NBTCompiler
         */
        if (listener.getBlockPatternsCount() == 1
                && listener.getPatternModel().equals(listener.getReturnTemplateModel())
                && !listener.getPatternModel().equals("PJ")) {
            switch (listener.getPatternModel()) {
                case "AJ":
                    QueryBlockTree nbtJQ =
                            QBTQueryBlockTreeBuilder.ajBlockNestedTreeBuilder.buildQueryBlockTree("V= " + listener
                                    .getSpecifiedPattern().concat(" return " + listener.getSpecifiedReturnTemplate()));
                    return nbtJQ.getRoot();
                case "RK":
                    QueryBlockTree nbtKQ = QBTQueryBlockTreeBuilder.rkBlockNestedTreeBuilder.buildQueryBlockTree(
                            "V=" + listener.getSpecifiedReturnTemplate().concat(" " + listener.getSpecifiedPattern()));
                    return nbtKQ.getRoot();
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
        final QBTLexer lexer = new QBTLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final QBTParser parser = new QBTParser(tokens);
        final ParserRuleContext tree = parser.qbtBlock();
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

    private class BlockListenerAux extends QBTBaseListener {
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
        public void enterQbtForPattern(QBTParser.QbtForPatternContext ctx) {
            log.debug("Entering ForPattern: " + ctx.getText());

            if (pattern == null && returnTemplate == null) {
                blockPatternsCount = ctx.qbtPattern().size();
                pattern = AntlrUtils.getFullText(ctx);
                if (!(blockPatternsCount > 1)) {
                    patternModel = ctx.qbtPattern().get(0).annotation().getText();
                    switch (patternModel) {
                        case "AJ":
                            specifiedPattern = AntlrUtils.getFullText(ctx.qbtPattern(0).modelPattern().ajPattern());
                            break;
                        case "RK":
                            specifiedPattern = AntlrUtils.getFullText(ctx.qbtPattern(0).modelPattern().rkPattern());
                            break;
                        case "SJ":
                            specifiedPattern = AntlrUtils.getFullText(ctx.qbtPattern(0).modelPattern().sjPattern());
                            break;
                        case "PR":
                            specifiedPattern = AntlrUtils.getFullText(ctx.qbtPattern(0).modelPattern().prPattern());
                            break;
                        case "SPPJ":
                            specifiedPattern = AntlrUtils.getFullText(ctx.qbtPattern(0).modelPattern().sppjPattern());
                            break;

                    }
                }
            }
        }

        @Override
        public void enterQbtReturnPattern(QBTParser.QbtReturnPatternContext ctx) {
            log.debug("Entering ReturnPattern: " + ctx.getText());
            if (pattern != null && returnTemplate == null) {
                returnTemplate = AntlrUtils.getFullText(ctx);
                log.debug("Return Template: " + returnTemplate);
                if (!(blockPatternsCount > 1)) {
                    returnModel = ctx.constructor().annotation().getText();
                    switch (returnModel) {
                        case "AJ":
                            specifiedreturnTemplate =
                                    AntlrUtils.getFullText(ctx.constructor().modelConstructor().ajConstructor());
                            break;
                        case "PJ":
                            specifiedreturnTemplate =
                                    AntlrUtils.getFullText(ctx.constructor().modelConstructor().pjConstructor());
                            break;
                        case "SJ":
                            specifiedreturnTemplate =
                                    AntlrUtils.getFullText(ctx.constructor().modelConstructor().sjConstructor());
                            break;
                        case "RK":
                            specifiedreturnTemplate =
                                    AntlrUtils.getFullText(ctx.constructor().modelConstructor().rkConstructor());
                            break;
                        case "PR":
                            System.out.println("kkkkkkk" + ctx.constructor().modelConstructor().prConstructor());
                            specifiedreturnTemplate =
                                    AntlrUtils.getFullText(ctx.constructor().modelConstructor().prConstructor());
                            break;
                        case "SPPJ": //TOFIX
                            specifiedPattern =
                                    AntlrUtils.getFullText(ctx.constructor().modelConstructor().ajConstructor());
                            break;

                    }
                }
            }
        }
    }
}
