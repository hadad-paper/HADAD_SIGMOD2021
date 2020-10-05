package hadad.base.compiler.model.nm;

/**
 * NM predicates
 * 
 *  
 *
 */
public enum Predicate {
    NAME("name"),
    SIZE("size"),
    ZERO("zero"),
    IDENTITY("identity"),
    ADD("add"),
    MULTI("multi"),
    MULTIS("multi_s"),
    MULTIE("multi_e"),
    DIV("div"),
    DIVS("div_s"),
    TRANS("tr"),
    INVERSE("in"),
    SUM("sum"),
    DET("det"),
    RANK("rank"),
    ADJ("adj"),
    COFA("cof"),
    TRACE("trace"),
    DIAG("diag"),
    POW("pow"),
    AVG("avg"),
    MEAN("mean"),
    VAR("var"),
    SD("sd"),
    COLSUM("colSums"),
    COLMEAN("colMeans"),
    COLVARS("colVars"),
    COLSDS("colSds"),
    COLMAX("colMaxs"),
    COLMINS("colMins"),
    ROWSUM("rowSums"),
    ROWMEAN("rowMeans"),
    ROWVARS("rowVars"),
    ROWSDS("rowSds"),
    ROWMAX("rowMaxs"),
    ROWMIN("rowMins"),
    CUMSUM("cumsum"),
    CUMPROD("cumprod"),
    CUMMIN("cummin"),
    CUMMAX("cummax"),
    EQUALS("eq");

    private final String str;

    private Predicate(final String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return str;
    }
}
