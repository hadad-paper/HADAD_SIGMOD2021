package hadad.base.compiler.model.la.builder;

import java.io.Serializable;

import org.apache.log4j.Logger;

import hadad.base.compiler.model.la.api.IVisitable;


/**
 * Represents LA operator as a Unary or Binary operator
 *
 */
public abstract class IOperator implements Serializable, IVisitable {

    private static final long serialVersionUID = 1L;
    /** Logger **/
    private static final Logger LOGGER = Logger.getLogger(IOperator.class);
    /** The parent of the current operator **/
    protected IOperator parentOp;
    /** Operator type **/
    protected OpType opType;
    /** Non-zero estimate for the result of each operator **/
    protected double nNZ;
    /** Row size **/
    protected int nRows;
    /** Column size **/
    protected int nCols;

    /** Constructor **/
    public IOperator() {
        nNZ = 0;
    }

    /**
     * Set parent operator
     * 
     * @param parentOp
     *            the parent operator
     */
    protected void setParentOperator(final IOperator parentOp) {
        this.parentOp = parentOp;
    }

    /**
     * Set the non-zero estimate
     * 
     * @param nNZ
     *            the non-zero estimate
     */
    public void setNnz(final double nNZ) {
        this.nNZ = nNZ;
    }

    /**
     * Set the number of rows
     * 
     * @param nRows
     *            the number of rows
     */
    public void setNumberOfRows(final int nRows) {
        this.nRows = nRows;
    }

    /**
     * Set the number of columns
     * 
     * @param nCols
     *            the number of columns
     */
    public void setNumberOfCols(final int nCols) {
        this.nCols = nCols;
    }

    /**
     * Get non-zero count
     * 
     * @return non-zero count
     */
    public double getNnz() {
        return nNZ;
    }

    /**
     * Get number of rows
     * 
     * @return number of rows
     */
    public int getNumberOfRows() {
        return nRows;
    }

    /**
     * Get number of columns
     * 
     * @return number of columns
     */
    public int getNumberOfColumns() {
        return nCols;
    }

    /**
     * Get operator type
     * 
     * @return operator type
     */
    public OpType getOpType() {
        return opType;
    }

    @Override
    public String toString() {
        final StringBuffer str = new StringBuffer();
        str.append(parentOp.toString());
        return str.toString();
    }

}