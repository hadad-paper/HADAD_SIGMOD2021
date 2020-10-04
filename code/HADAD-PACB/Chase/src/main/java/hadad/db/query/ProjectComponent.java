package hadad.db.query;

import java.util.HashSet;
import java.util.LinkedHashMap;

import hadad.db.datalogexpr.Value;

public abstract class ProjectComponent {

    LinkedHashMap<Integer, Value> newPosToValue;

    /**
     * The actual set of tuples. Each tuple is represented by the concatenation of its
     * column values. This is used for duplicate elimination.
     */
    HashSet<String> keySet;

    protected abstract boolean needsDuplicateElimination();

    protected void flush() {
        if (keySet != null)
            keySet.clear();
    }

}
