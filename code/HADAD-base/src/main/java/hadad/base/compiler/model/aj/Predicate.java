package hadad.base.compiler.model.aj;

public enum Predicate {
    CHILD("child_aj"),
    ROOT("root_aj"),
    TAG("tag_aj"),
    EQUALS("eq_aj"),
    EXTRACT("extr_aj"),
    CREATE("create_aj"),
    COPY("copy_aj"),
    VAL("val_aj"),
    SKOLEM("sk_aj");

    private final String str;

    private Predicate(final String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return str;
    }
}
