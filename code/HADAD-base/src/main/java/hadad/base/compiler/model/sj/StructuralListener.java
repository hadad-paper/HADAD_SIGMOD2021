package hadad.base.compiler.model.sj;

import java.util.Map;

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
            @Named("SJQLVariableFactory") VariableFactory sjqlVariableFactory, VariableMapper variableMapper) {
        super(pathExpressionlistener, sjqlVariableFactory, variableMapper);
    }

    @Override
    public void enterSjQuery(SJQLParser.SjQueryContext ctx) {
        LOGGER.debug("Entering Query: " + ctx.getText());
        if (currentVar != null) {
            throw new IllegalStateException("Path expression expected.");
        }
        final Variable var = sjqlVariableFactory.createFreshVar();
        variableMapper.define(ctx.sjCollectionName().getText(), var);
        currentVar = var;
        final PathExpression expr = pathExpressionListener.parse(AntlrUtils.getFullText(ctx)).copy(currentVar);
        defineVariable(expr);
        for (Map.Entry<String, Variable> entry : variableMapper.getVariableMapping().entrySet()) {
            if (!entry.getKey().equals(ctx.sjCollectionName().getText())) {
                currentVar = entry.getValue();
                defineVariable(expr);
            }
        }
    }

    @Override
    protected ParserRuleContext createParseTree(final SJQLParser parser) {
        return parser.sjQuery();
    }
}
