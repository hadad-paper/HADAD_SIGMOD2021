package hadad.base.compiler.query;

import org.antlr.v4.runtime.ParserRuleContext;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.base.compiler.AntlrUtils;

/**
 * Mixed model structural listener
 * 
 *   
 */
@Singleton
public final class StructuralListener extends StructuralBaseListener {
    private static final Logger log = Logger.getLogger(StructuralListener.class);

    @Inject
    public StructuralListener() {
    }

    @Override
    public void enterPattern(final QBTQUERYParser.PatternContext ctx) {
        log.debug("Pattern: " + ctx.getText());
        switch (ctx.annotation().getText()) {
            case "JQ":
                addPattern(MixedNestedBlockTreeBuilder.jqBlockNestedTreeBuilder
                        .buildPattern("for " + AntlrUtils.getFullText(ctx.modelPattern().jqPattern())));
                MixedNestedBlockTreeBuilder.variableMapper
                        .addAll((MixedNestedBlockTreeBuilder.jqBlockNestedTreeBuilder.getVariableMapper()));
                break;
            case "KQ":
                addPattern(MixedNestedBlockTreeBuilder.kqBlockNestedTreeBuilder
                        .buildPattern(AntlrUtils.getFullText(ctx.modelPattern().kqPattern())));
                MixedNestedBlockTreeBuilder.variableMapper
                        .addAll((MixedNestedBlockTreeBuilder.kqBlockNestedTreeBuilder.getVariableMapper()));
                break;
            case "RQ":
                System.out.println(AntlrUtils.getFullText(ctx.modelPattern().rqPattern()));

                addPattern(MixedNestedBlockTreeBuilder.rqBlockNestedTreeBuilder
                        .buildQueryBlockTree("V =" + AntlrUtils.getFullText(ctx.modelPattern().rqPattern())).getRoot()
                        .getPattern());
                MixedNestedBlockTreeBuilder.variableMapper
                        .addAll((MixedNestedBlockTreeBuilder.rqBlockNestedTreeBuilder.getVariableMapper()));
        }
    }

    @Override
    protected ParserRuleContext createParseTree(final QBTQUERYParser parser) {
        return parser.forPattern();
    }
}
