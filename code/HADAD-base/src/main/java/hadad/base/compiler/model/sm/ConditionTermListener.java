package hadad.base.compiler.model.sm;

import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.base.compiler.VariableMapper;

@Singleton
final class ConditionTermListener extends DMLBaseListener {
    private static final Logger LOGGER = Logger.getLogger(ConditionTermListener.class);
    protected final PathExpressionListener pathExpressionListener;
    protected final VariableMapper variableMapper;

    @Inject
    public ConditionTermListener(final PathExpressionListener listener, final VariableMapper variableMapper) {
        this.pathExpressionListener = listener;
        this.variableMapper = variableMapper;
    }
}
