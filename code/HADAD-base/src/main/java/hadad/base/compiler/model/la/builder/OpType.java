package hadad.base.compiler.model.la.builder;

/**
 * operators
 *
 */
public enum OpType {

    ADD("add"),
    ADD_S("add_s"),
    MULTI("multi"),
    MULTI_S("multi_s"),
    MULTI_E("multi_e"),
    MULTI_C("multi_c"),
    DIV("div"),
    DIVS("div_s"),
    TR("tr"),
    IN("in"),
    INS("in_s"),
    EXP("exp"),
    DET("det"),
    TRACE("trace"),
    SUM("sum"),
    COLSUMS("colsums"),
    ROWSUMS("rowsums");

    private String opType;

    OpType(final String opType) {
        this.opType = opType;
    }

    public String getOpType() {
        return opType;
    }
}
