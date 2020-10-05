package hadad.base.compiler.model.nm;

import static com.google.common.base.Preconditions.checkNotNull;

import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.base.compiler.VariableMapper;

/**
 * NM Return Template Listener
 * 
 *  
 *
 */
@Singleton
final class ReturnTemplateListener extends NumPyBaseListener {
    private static final Logger LOGGER = Logger.getLogger(ReturnTemplateListener.class);
    private final VariableMapper variableMapper;

    @Inject
    public ReturnTemplateListener(final VariableMapper variableMapper) {
        this.variableMapper = checkNotNull(variableMapper);
    }
}
