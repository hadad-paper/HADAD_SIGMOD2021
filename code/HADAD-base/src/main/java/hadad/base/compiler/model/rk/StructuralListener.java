package hadad.base.compiler.model.rk;

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
 * Damian Bursztyn
 *  (Used Damian's Convention for JQ)
 */
@Singleton
public final class StructuralListener extends StructuralBaseListener {
    private static final Logger log = Logger.getLogger(StructuralListener.class);

    @Inject
    public StructuralListener(final LookUpExpressionListener listener,
            @Named("KQLVariableFactory") VariableFactory kqlVariableFactory, VariableMapper variableMapper) {
        super(listener, kqlVariableFactory, variableMapper);
    }

    @Override
    public void enterFromvariableBinding(KQLParser.FromvariableBindingContext ctx) {
        log.debug("Entering FromClasueVariableBinding: " + ctx.getText());
        if (currentVar != null) {
            throw new IllegalStateException("LookUpExpresstion expected.");
        }
        final Variable var = kqlVariableFactory.createFreshVar();
        setVarStr = ctx.getText();
        LookUpExpressionListener.setVar = null;
        variableMapper.define(ctx.getText(), var);
        log.debug("VariableBinding" + ctx.getText());
        currentVar = var;
    }

    @Override
    public void enterRkSource(KQLParser.RkSourceContext ctx) {
        log.debug("Entering FromClauseBindingSource: " + ctx.getText());
        defineVariable(lookUpExpressionListener.parse(AntlrUtils.getFullText(ctx)).copy(currentVar));
        if (LookUpExpressionListener.setVar != null) {
            variableMapper.updateVariable(setVarStr, LookUpExpressionListener.setVar);
        }
    }

    @Override
    public void exitRkFromClasue(KQLParser.RkFromClasueContext ctx) {
        LookUpExpressionListener.currentRootVar = null;
        LookUpExpressionListener.lookUpVariable = null;
        LookUpExpressionListener.currentInternalMap = null;
        LookUpExpressionListener.currentVarVal = null;
        LookUpExpressionListener.setVar = null;
    }

    @Override
    protected ParserRuleContext createParseTree(final KQLParser parser) {
        return parser.rkFromClasue();
    }
}
