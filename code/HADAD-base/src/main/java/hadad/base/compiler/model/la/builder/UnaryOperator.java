package hadad.base.compiler.model.la.builder;

import static com.google.common.base.Preconditions.checkNotNull;
import org.apache.log4j.Logger;
import hadad.base.compiler.model.la.api.IOperatorVisitor;

/**
 * Represents a LA Unary operator
 *
 */
public class UnaryOperator extends IOperator {
    private static final long serialVersionUID = 1L;
    /** Logger **/
    private static final Logger LOGGER = Logger.getLogger(BinaryOperator.class);
    /** Child operator **/
    private final IOperator childOp;

    public UnaryOperator(final IOperator childOp, final OpType opType) {
        super();
        this.childOp = checkNotNull(childOp);
        this.opType = checkNotNull(opType);
        childOp.setParentOperator(this);
        deriveOutputDimension();
    }

    /**
     * Get the child operator
     * 
     * @return the child operator
     */
    public IOperator getChildOp() {
        return childOp;
    }

    /**
     * Derive output size
     */
    private void deriveOutputDimension() {
        switch (opType) {
            case TR:
                this.nRows = childOp.nCols;
                this.nCols = childOp.nRows;
            case IN:
                this.nRows = childOp.nRows;
                this.nCols = childOp.nCols;
            case INS:
                this.nRows = childOp.nRows;
                this.nCols = childOp.nCols;
            case EXP:
                this.nRows = childOp.nRows;
                this.nCols = childOp.nCols;
            default:
                break;
        }
    }

    @Override
    public String toString() {
        final StringBuffer str = new StringBuffer();
        str.append(opType);
        str.append(":\n");
        str.append("childOp:{\n");
        str.append(childOp.toString());
        str.append("\n");
        str.append("}");
        return str.toString();
    }

    @Override
    public <R, A> R accept(IOperatorVisitor<R, A> visitor, A arg) {
        return visitor.visit(this, arg);
    }

}