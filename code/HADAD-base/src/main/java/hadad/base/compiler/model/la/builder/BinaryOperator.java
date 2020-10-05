package hadad.base.compiler.model.la.builder;

import static com.google.common.base.Preconditions.checkNotNull;

import org.apache.log4j.Logger;

import hadad.base.compiler.model.la.api.IOperatorVisitor;

/**
 * Represents an LA Unary operator
 */
public class BinaryOperator extends IOperator {
    private static final long serialVersionUID = 1L;
    /** Logger **/
    private static final Logger LOGGER = Logger.getLogger(BinaryOperator.class);
    /** Left child **/
    private final IOperator childOpLeft;
    /** Right child **/
    private final IOperator childOpRight;

    /** Constructor **/
    public BinaryOperator(final IOperator childOpLeft, final IOperator childOpRight, final OpType opType) {
        super();
        this.childOpLeft = checkNotNull(childOpLeft);
        this.childOpRight = checkNotNull(childOpRight);
        this.opType = checkNotNull(opType);
        childOpLeft.setParentOperator(this);
        childOpRight.setParentOperator(this);
        deriveOutputDimension();
    }

    /**
     * Get the child left operator
     * 
     * @return the child operator
     */
    public IOperator getChildOpLeft() {
        return childOpLeft;
    }

    /**
     * Get the child right operator
     * 
     * @return the child operator
     */
    public IOperator getChildOpRight() {
        return childOpRight;
    }

    private void deriveOutputDimension() {
        switch (opType) {
            case MULTI:
                this.nRows = childOpLeft.nRows;
                this.nCols = childOpRight.nCols;
            case ADD:
                this.nRows = childOpLeft.nRows;
                this.nCols = childOpLeft.nCols;
            case MULTI_S:
                this.nRows = childOpLeft.nRows;
                this.nCols = childOpLeft.nCols;
            case MULTI_E:
                this.nRows = childOpLeft.nRows;
                this.nCols = childOpLeft.nCols;
            case DIV:
                this.nRows = childOpLeft.nRows;
                this.nCols = childOpLeft.nCols;
            case DIVS:
                this.nRows = childOpLeft.nRows;
                this.nCols = childOpLeft.nCols;
            case ADD_S: //TODO: Should be different than add scalar 
                this.nRows = 0;
                this.nCols = 0;
            case MULTI_C: //TODO: Should be different than add scalar 
                this.nRows = 0;
                this.nCols = 0;
            default:
                break;
        }
    }

    @Override
    public String toString() {
        final StringBuffer str = new StringBuffer();
        str.append(opType);
        str.append(":\n");
        str.append("childOpLeft:{\n");
        str.append(childOpLeft.toString());
        str.append("\n");
        str.append("}\n");
        str.append("childOpRight:{\n");
        str.append(childOpRight.toString());
        str.append("\n");
        str.append("}");
        return str.toString();
    }

    @Override
    public <R, A> R accept(IOperatorVisitor<R, A> visitor, A arg) {
        return visitor.visit(this, arg);
    }

}