package hadad.base.compiler.model.rm;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.base.compiler.VariableMapper;

/**
 * RM Return Template Listener
 * 
 *  
 *
 */
@Singleton
final class ReturnTemplateListener extends RBaseListener {
    @SuppressWarnings("unused")
    private final VariableMapper variableMapper;

    @Inject
    public ReturnTemplateListener(final VariableMapper variableMapper) {
        this.variableMapper = checkNotNull(variableMapper);
    }
}
