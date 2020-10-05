package hadad.base.compiler.model.sppj;

import org.antlr.v4.runtime.ParserRuleContext;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import hadad.commons.conjunctivequery.Variable;
import hadad.base.compiler.AntlrUtils;
import hadad.base.compiler.VariableFactory;
import hadad.base.compiler.VariableMapper;

/**
 * SPPJ StructuralListener
 */
@Singleton
public final class StructuralListener extends StructuralBaseListener {
    private static final Logger LOGGER = Logger.getLogger(StructuralListener.class);

    @Inject
    public StructuralListener(final PathExpressionListener listener,
            @Named("SPPJQLVariableFactory") VariableFactory sppjqlVariableFactory, VariableMapper variableMapper) {
        super(listener, sppjqlVariableFactory, variableMapper);
    }

    @Override
    public void enterSppjBinding(SPPJQLParser.SppjBindingContext ctx) {
        LOGGER.debug("Entering ForClauseBindingVar: " + ctx.getText());
        if (currentVar != null) {
            throw new IllegalStateException("Path expression expected.");
        }
        final Variable var = sppjqlVariableFactory.createFreshVar();
        variableMapper.define(ctx.sppjFromClauseBindingVar().getText(), var);
        currentVar = var;
        defineVariable(pathExpressionListener.parse(AntlrUtils.getFullText(ctx.sppjFromClauseBindingSource()))
                .copy(currentVar));

    }

    @Override
    protected ParserRuleContext createParseTree(final SPPJQLParser parser) {
        return parser.sppjFromClause();
    }
}
