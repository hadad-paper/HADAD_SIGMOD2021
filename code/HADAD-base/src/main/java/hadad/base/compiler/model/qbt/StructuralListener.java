package hadad.base.compiler.model.qbt;

import org.antlr.v4.runtime.ParserRuleContext;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.base.compiler.AntlrUtils;
import hadad.base.compiler.Pattern;

/**
 * QBT StructuralListener
 * 
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
    public void enterQbtPattern(QBTParser.QbtPatternContext ctx) {
        log.debug("Pattern: " + ctx.getText());
        switch (ctx.annotation().getText()) {
            case "AJ":
                addPattern(QBTQueryBlockTreeBuilder.ajBlockNestedTreeBuilder
                        .buildPattern("for " + AntlrUtils.getFullText(ctx.modelPattern().ajPattern())));
                QBTQueryBlockTreeBuilder.variableMapper
                        .addAll((QBTQueryBlockTreeBuilder.ajBlockNestedTreeBuilder.getVariableMapper()));
                break;
            case "PJ":
                final Pattern pattern = QBTQueryBlockTreeBuilder.pjBlockNestedTreeBuilder
                        .buildQueryBlockTree(AntlrUtils.getFullText(ctx.modelPattern().pjPattern())).getRoot()
                        .getPattern();
                addPattern(pattern);
                QBTQueryBlockTreeBuilder.variableMapper
                        .addAll((QBTQueryBlockTreeBuilder.pjBlockNestedTreeBuilder.getVariableMapper()));
                break;
            case "SPPJ":
                addPattern(QBTQueryBlockTreeBuilder.sppjBlockNestedTreeBuilder
                        .buildPattern("FROM " + AntlrUtils.getFullText(ctx.modelPattern().sppjPattern())));
                QBTQueryBlockTreeBuilder.variableMapper
                        .addAll((QBTQueryBlockTreeBuilder.sppjBlockNestedTreeBuilder.getVariableMapper()));
                break;
            case "SJ":
                addPattern(QBTQueryBlockTreeBuilder.sjBlockNestedTreeBuilder
                        .buildPattern(AntlrUtils.getFullText(ctx.modelPattern().sjPattern())));
                QBTQueryBlockTreeBuilder.variableMapper
                        .addAll((QBTQueryBlockTreeBuilder.sjBlockNestedTreeBuilder.getVariableMapper()));
                break;
            case "RK":
                addPattern(QBTQueryBlockTreeBuilder.rkBlockNestedTreeBuilder
                        .buildPattern(AntlrUtils.getFullText(ctx.modelPattern().rkPattern())));
                QBTQueryBlockTreeBuilder.variableMapper
                        .addAll((QBTQueryBlockTreeBuilder.rkBlockNestedTreeBuilder.getVariableMapper()));
                break;
        }
    }

    @Override
    protected ParserRuleContext createParseTree(QBTParser parser) {
        return parser.qbtForPattern();
    }
}
