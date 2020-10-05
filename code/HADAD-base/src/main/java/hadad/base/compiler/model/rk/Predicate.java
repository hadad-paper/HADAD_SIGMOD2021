package hadad.base.compiler.model.rk;

public enum Predicate {
    COLLECTION("collection_rk"),
    MAINMAP("mainmap_rk"),
    EQUALS("eq_rk"),
    VAL("val_rk"),
    COPY("copy_rk");

    private final String str;

    private Predicate(final String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return str;
    }
}
