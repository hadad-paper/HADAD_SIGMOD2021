package hadad.base.compiler.model.sm;

import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
final class ConditionalListener extends DMLBaseListener {
    private static final Logger LOGGER = Logger.getLogger(ConditionalListener.class);
    private final ConditionListener conditionListener;

    @Inject
    public ConditionalListener(final ConditionListener conditionListener) {
        this.conditionListener = conditionListener;
    }
}
