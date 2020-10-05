package hadad.base.compiler.model.pj;

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
 * PJ StructuralListener which extends {@link StructuralBaseListener}.
 */
@Singleton
public final class StructuralListener extends StructuralBaseListener {
    private static final Logger LOGGER = Logger.getLogger(StructuralListener.class);

    @Inject
    public StructuralListener(final PathExpressionListener listener,
            @Named("PJQLVariableFactory") VariableFactory pjqlVariableFactory, VariableMapper variableMapper) {
        super(listener, pjqlVariableFactory, variableMapper);
    }

    @Override
    public void enterPjBinding(PJQLParser.PjBindingContext ctx) {
        LOGGER.debug("Entering ForClauseBindingVar: " + ctx.getText());
        if (currentVar != null) {
            throw new IllegalStateException("Path expression expected.");
        }
        final Variable var = pjqlVariableFactory.createFreshVar();
        variableMapper.define(ctx.pjFromClauseBindingVar().getText(), var);
        currentVar = var;
        defineVariable(
                pathExpressionListener.parse(AntlrUtils.getFullText(ctx.pjFromClauseBindingSource())).copy(currentVar));

    }

    @Override
    protected ParserRuleContext createParseTree(final PJQLParser parser) {
        return parser.pjFromClause();
    }
}
