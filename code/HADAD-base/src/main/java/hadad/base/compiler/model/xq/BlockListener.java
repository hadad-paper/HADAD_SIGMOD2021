package hadad.base.compiler.model.xq;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.log4j.Logger;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.commons.conjunctivequery.Variable;
import hadad.base.compiler.AntlrUtils;
import hadad.base.compiler.Block;
import hadad.base.compiler.ChildBlock;
import hadad.base.compiler.PathExpression;
import hadad.base.compiler.Pattern;
import hadad.base.compiler.RootBlock;
import hadad.base.compiler.exceptions.ParseException;

/**
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
        final Pattern pattern = patternListener.parse(listener.getPattern());
        return new RootBlock(queryName, pattern,
                returnTemplateListener.parse(pattern.getDefinitions(), listener.getReturnTemplate()));
    }

    public ChildBlock parse(final Block parent, final String createdNode, final String str) throws ParseException {
        final BlockListenerAux listener = _parse(str);
        final Pattern pattern = patternListener.parse(listener.getPattern());
        final ImmutableMap.Builder<Variable, PathExpression> builder = ImmutableMap.builder();
        builder.putAll(parent.getVisibleDefinitions());
        builder.putAll(pattern.getDefinitions());
        return new ChildBlock(parent, createdNode, pattern,
                returnTemplateListener.parse(builder.build(), listener.getReturnTemplate()));
    }

    private BlockListenerAux _parse(final String str) throws ParseException {
        final XQueryLexer lexer = new XQueryLexer(new ANTLRInputStream(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final XQueryParser parser = new XQueryParser(tokens);
        final ParserRuleContext tree = parser.flwr();
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

    /*
     * We allow only strings that have pattern followed by return template.
     */
    private class BlockListenerAux extends XQueryBaseListener {
        private String pattern;
        private String returnTemplate;

        public String getPattern() {
            return pattern;
        }

        public String getReturnTemplate() {
            return returnTemplate;
        }

        @Override
        public void enterFlwrForWhere(XQueryParser.FlwrForWhereContext ctx) {
            log.debug("Entering FlwrFor: " + ctx.getText());
            if (pattern == null && returnTemplate == null) {
                pattern = AntlrUtils.getFullText(ctx);
            }
        }

        @Override
        public void enterFlwrReturn(XQueryParser.FlwrReturnContext ctx) {
            log.debug("Entering FlwrReturn: " + ctx.getText());
            if (pattern != null && returnTemplate == null) {
                returnTemplate = AntlrUtils.getFullText(ctx);
            }
        }
    }
}
