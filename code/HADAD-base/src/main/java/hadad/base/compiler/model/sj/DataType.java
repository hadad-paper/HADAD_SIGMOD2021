package hadad.base.compiler.model.sj;

/**
 * PJ Data Type
 * 
 *  
 *
 */
public enum DataType {
    OBJECT("o");

    private final String str;

    private DataType(final String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return str;
    }
}
