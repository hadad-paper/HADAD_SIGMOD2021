package hadad.base.compiler.model.sppj;

public enum Predicate {
    CHILD("child_sppj"),
    ROOT("root_sppj"),
    TAG("tag_sppj"),
    EQUALS("eq_sppj"),
    EXTRACT("extr_sppj"),
    CREATE("create_sppj"),
    COPY("copy_sppj"),
    VAL("val_sppj"),
    SKOLEM("sk_sppj");

    private final String str;

    private Predicate(final String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return str;
    }
}
