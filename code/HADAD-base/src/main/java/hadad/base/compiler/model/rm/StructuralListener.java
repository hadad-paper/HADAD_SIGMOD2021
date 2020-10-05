package hadad.base.compiler.model.rm;

import org.antlr.v4.runtime.ParserRuleContext;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import hadad.commons.conjunctivequery.Variable;
import hadad.base.compiler.AntlrUtils;
import hadad.base.compiler.PathExpression;
import hadad.base.compiler.VariableFactory;
import hadad.base.compiler.VariableMapper;

/**
 * SJ Structural Listener
 * 
 *  
 *
 */
@Singleton
public final class StructuralListener extends StructuralBaseListener {
    private static final Logger LOGGER = Logger.getLogger(StructuralListener.class);

    @Inject
    public StructuralListener(final PathExpressionListener pathExpressionlistener,
            @Named("RVariableFactory") VariableFactory dmlVariableFactory, VariableMapper variableMapper) {
        super(pathExpressionlistener, dmlVariableFactory, variableMapper);
    }

    @Override
    public void enterRStatemnet(RParser.RStatemnetContext ctx) {
        //LOGGER.debug("Entering DML Statement Query: " + ctx.getText());
        if (currentVar != null) {
            throw new IllegalStateException("Path expression expected.");
        }

        final Variable var = dmlVariableFactory.createFreshVar();
        variableMapper.define(ctx.matrixName().getText(), var);
        currentVar = var;
        final PathExpression expr = pathExpressionListener.parse(AntlrUtils.getFullText(ctx)).copy(currentVar);
        defineVariable(expr);
    }

    @Override
    protected ParserRuleContext createParseTree(final RParser parser) {
        return parser.rScript();
    }
}
