package hadad.base.compiler.model.sm;

import static com.google.common.base.Preconditions.checkNotNull;

import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.base.compiler.VariableMapper;

/**
 * SM Return Template Listener
 * 
 *  
 *
 */
@Singleton
final class ReturnTemplateListener extends DMLBaseListener {
    private static final Logger LOGGER = Logger.getLogger(ReturnTemplateListener.class);
    private final VariableMapper variableMapper;

    @Inject
    public ReturnTemplateListener(final VariableMapper variableMapper) {
        this.variableMapper = checkNotNull(variableMapper);
    }
}
