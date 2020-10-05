package hadad.base.compiler.model.pj.full;

import org.antlr.v4.runtime.ParserRuleContext;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import hadad.base.compiler.VariableFactory;
import hadad.base.compiler.VariableMapper;

/**
 * PJ Full ConditionalStructuralListener which extends {@link StructuralBaseListener}.
 */
@Singleton
final class ConditionalStructuralListener extends StructuralBaseListener {
    private static final Logger log = Logger.getLogger(ConditionalStructuralListener.class);

    @Inject
    public ConditionalStructuralListener(final PathExpressionListener listener,
            @Named("PJQLVariableFactory") VariableFactory aqlVariableFactory, VariableMapper variableMapper) {
        super(listener, aqlVariableFactory, variableMapper);
    }

    @Override
    protected ParserRuleContext createParseTree(final PJQLParser parser) {
        // TODO Auto-generated method stub
        return null;
    }
}
