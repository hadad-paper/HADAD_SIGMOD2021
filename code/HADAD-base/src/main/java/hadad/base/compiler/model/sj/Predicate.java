package hadad.base.compiler.model.sj;

/**
 * SJ Atom Preicate
 * 
 *  
 *
 */
public enum Predicate {
    CHILD("child_sj"),
    ROOT("root_sj"),
    TAG("tag_sj"),
    EQUALS("eq_sj"),
    VAL("val_sj");

    private final String str;

    private Predicate(final String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return str;
    }
}
