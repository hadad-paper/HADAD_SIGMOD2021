package hadad.base.compiler.model.aj;

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
 * AJ StructuralListener which extends {@link StructuralBaseListener}.
 */
@Singleton
public final class StructuralListener extends StructuralBaseListener {
    private static final Logger log = Logger.getLogger(StructuralListener.class);

    @Inject
    public StructuralListener(final PathExpressionListener listener,
            @Named("AQLVariableFactory") VariableFactory aqlVariableFactory, VariableMapper variableMapper) {
        super(listener, aqlVariableFactory, variableMapper);
    }

    @Override
    public void enterForClauseBindingVar(AQLParser.ForClauseBindingVarContext ctx) {
        log.debug("Entering ForClauseBindingVar: " + ctx.getText());
        if (currentVar != null) {
            throw new IllegalStateException("Path expression expected.");
        }
        final Variable var = aqlVariableFactory.createFreshVar();
        variableMapper.define(ctx.getText(), var);
        currentVar = var;
    }

    @Override
    public void enterForClauseBindingSource(AQLParser.ForClauseBindingSourceContext ctx) {
        log.debug("Entering ForClauseBindingSource: " + ctx.getText());
        defineVariable(pathExpressionListener.parse(AntlrUtils.getFullText(ctx)).copy(currentVar));
    }

    @Override
    protected ParserRuleContext createParseTree(final AQLParser parser) {
        return parser.forClause();
    }
}
