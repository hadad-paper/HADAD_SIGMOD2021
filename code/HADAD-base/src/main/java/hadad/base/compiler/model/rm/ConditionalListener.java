package hadad.base.compiler.model.rm;

import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
final class ConditionalListener extends RBaseListener {
    @SuppressWarnings("unused")
    private static final Logger LOGGER = Logger.getLogger(ConditionalListener.class);
    @SuppressWarnings("unused")
    private final ConditionListener conditionListener;

    @Inject
    public ConditionalListener(final ConditionListener conditionListener) {
        this.conditionListener = conditionListener;
    }
}
