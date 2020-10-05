package hadad.base.rewriting.decoder.sm;

/**
 * DML Operations
 * 
 *  
 *
 */
public enum SMOperation {
    ADD("+"),
    MULTI("%*%"),
    MULTIS("*"),
    MULTIE("*"),
    DIV("%/%"),
    DIVS("/"),
    TRANS("t"),
    INVERSE("inv"),
    DET("det"),
    ADJ("adj"),
    COFA("cof"),
    TRACE("trace"),
    DIAG("diag"),
    POW("^"),
    AVG("avg"),
    MEAN("mean"),
    VAR("var"),
    SD("sd"),
    SUM("sum"),
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
    EQUALS("eq"),
	ADDS("+");

    private final String str;

    private SMOperation(final String str) {
        this.str = str;
    }

    public String OperationValue() {
        return str;
    }

    @Override
    public String toString() {
        return str;
    }
}
