package hadad.base.compiler.model.sm;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
final class ConditionListener {
    private final ConditionTermListener conditionTermListener;

    @Inject
    public ConditionListener(final ConditionTermListener conditionTermListener) {
        this.conditionTermListener = conditionTermListener;
    }
}
