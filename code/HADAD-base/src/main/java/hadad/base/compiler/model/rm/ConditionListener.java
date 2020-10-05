package hadad.base.compiler.model.rm;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
final class ConditionListener {
    @SuppressWarnings("unused")
    private final ConditionTermListener conditionTermListener;

    @Inject
    public ConditionListener(final ConditionTermListener conditionTermListener) {
        this.conditionTermListener = conditionTermListener;
    }
}
