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
 * AJ Conditional Structural Listener which extends {@link StructuralBaseListener}
 */
@Singleton
final class ConditionalStructuralListener extends StructuralBaseListener {
    private static final Logger log = Logger.getLogger(ConditionalStructuralListener.class);

    @Inject
    public ConditionalStructuralListener(final PathExpressionListener listener,
            @Named("AQLVariableFactory") VariableFactory aqlVariableFactory, VariableMapper variableMapper) {
        super(listener, aqlVariableFactory, variableMapper);
    }

    @Override
    public void enterWhereCondBindingVar(AQLParser.WhereCondBindingVarContext ctx) {
        log.debug("Entering WhereCondBindingVar: " + ctx.getText());
        if (currentVar != null) {
            throw new IllegalStateException("Path expression expected.");
        }
        final Variable var = aqlVariableFactory.createFreshVar();
        variableMapper.define(ctx.getText(), var);
        currentVar = var;
    }

    @Override
    public void enterWhereCondBindingSource(AQLParser.WhereCondBindingSourceContext ctx) {
        log.debug("Entering WhereCondBindingSource: " + ctx.getText());
        defineVariable(pathExpressionListener.parse(AntlrUtils.getFullText(ctx)).copy(currentVar));
    }

    @Override
    protected ParserRuleContext createParseTree(final AQLParser parser) {
        return parser.whereCondSome();
    }
}
