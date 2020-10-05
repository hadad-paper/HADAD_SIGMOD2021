package hadad.base.compiler.model.rm;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.base.compiler.VariableMapper;

@Singleton
final class ConditionTermListener extends RBaseListener {
    protected final PathExpressionListener pathExpressionListener;
    protected final VariableMapper variableMapper;

    @Inject
    public ConditionTermListener(final PathExpressionListener listener, final VariableMapper variableMapper) {
        this.pathExpressionListener = listener;
        this.variableMapper = variableMapper;
    }
}
