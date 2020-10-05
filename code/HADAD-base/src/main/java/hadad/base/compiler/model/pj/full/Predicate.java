package hadad.base.compiler.model.pj.full;

public enum Predicate {
    CHILD("child_pj"),
    ROOT("root_pj"),
    TAG("tag_pj"),
    EQUALS("eq_pj"),
    EXTRACT("extr_pj"),
    CREATE("create_pj"),
    COPY("copy_pj"),
    VAL("val_pj"),
    SKOLEM("sk_pj");

    private final String str;

    private Predicate(final String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return str;
    }
}
