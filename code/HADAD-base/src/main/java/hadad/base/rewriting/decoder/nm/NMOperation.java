package hadad.base.rewriting.decoder.nm;

/**
 * NumPy Operations
 * 
 *  
 *
 */
public enum NMOperation {
    ADD("np.add"),
    ADDS("+"),
    SUM("sum"),
    ROWSUM("sum"),
    COLSUM("sum"),
    MULTI("np.matmul"),
    MULTIS("np.multiply"),
    MULTIE("np.multiply"),
    DIV("np.divide"),
    TRANS("np.transpose"),
    INVERSE("np.linalg.inv"),
    DET("np.linalg.det"),
    TRACE("np.trace"),
    DIAG("np.diag"),
    MEAN("np.mean");

    private final String str;

    private NMOperation(final String str) {
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
