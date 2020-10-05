package hadad.base.compiler.model.pr;

public enum Predicate {
    EQUALS("eq_pr"),
    CONSTANT("constant");

    private final String str;

    private Predicate(final String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return str;
    }
}
