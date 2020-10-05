package hadad.base.compiler.model.la.builder;

import static com.google.common.base.Preconditions.checkNotNull;

import org.apache.log4j.Logger;

import hadad.base.compiler.model.la.api.IOperatorVisitor;


/**
 * LA Scan operator
 *
 */
public class ScanOperator extends IOperator {
    private static final long serialVersionUID = 1L;
    /** Logger **/
    private static final Logger LOGGER = Logger.getLogger(IOperator.class);
    /** Base matrix name **/
    final String baseMatrixName;

    /**
     * Constructor
     * 
     * @param baseMatrixName
     *            matrix name
     * @param metadata
     *            the metadata
     */
    public ScanOperator(final String baseMatrixName) {
        super();
        this.baseMatrixName = checkNotNull(baseMatrixName);
    }

    /**
     * Get base matrix name
     * 
     * @return base matrix name
     */
    public String getBaseMatrixName() {
        return baseMatrixName;
    }

    @Override
    public String toString() {
        final StringBuffer str = new StringBuffer();
        str.append("Scan:{\n");
        str.append(baseMatrixName);
        str.append("\n");
        str.append("}");
        return str.toString();
    }

    @Override
    public <R, A> R accept(IOperatorVisitor<R, A> visitor, A arg) {
        return visitor.visit(this, arg);
    }
}
