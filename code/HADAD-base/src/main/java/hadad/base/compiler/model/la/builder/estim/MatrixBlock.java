package hadad.base.compiler.model.la.builder.estim;
import static com.google.common.base.Preconditions.checkNotNull;
import org.apache.log4j.Logger;

/**
 * Matrix block to be used by {@link MatrixHistogram} for histogram computation.
 * Simplified version of SystemML Matrix Block implementation.
 *
 */
public class MatrixBlock {
    private static final Logger LOGGER = Logger.getLogger(MatrixBlock.class);

    /** data **/
    private double[] data;
    private int nRows;
    private int nCols;
    private int nnz;

    /**
     * Constructor
     * 
     * @param data
     *            the data
     */
    public MatrixBlock(final double[] data, final int nRows, final int nCols) {
        this.data = checkNotNull(data);
        this.nRows = nRows;
        this.nCols = nCols;
        this.nnz = 0;
        computeNonZero();
    }

    /**
     * Compute non-zero
     */
    private void computeNonZero() {
        for (int i = 0; i < nRows * nCols; i++) {
            nnz += (data[i] != 0) ? 1 : 0;
        }
    }

    /**
     * Compute non-zero per row
     * 
     * @param row
     *            the row number
     * @return the number of non-zero per row.
     */
    public int computeNonZero(int r) {
        int lnnz = 0;
        int start = r * nCols;
        for (int i = start; i < start + nCols; i++)
            lnnz += (data[i] != 0) ? 1 : 0;
        return lnnz;
    }

    /**
     * Compute non-zero per row
     * 
     * @param row
     *            the row number
     * @return the number of non-zero per row.
     */
    public int computeNonZeroColumn(int c) {
        int lnnz = 0;
        for (int i = c; i < nRows * nCols; i += nCols) {
            lnnz += (data[i] != 0) ? 1 : 0;
        }
        return lnnz;
    }

    /**
     * Get number of rows
     * 
     * @return number of rows
     */
    public int getNumRows() {
        return nRows;
    }

    /**
     * Get number of columns
     * 
     * @return number of columns
     */
    public int getNumColumns() {
        return nCols;
    }

    /**
     * Get non-zeros
     * 
     * @return non-number of zeros
     */
    public int getNonZeros() {
        return nnz;
    }

    /**
     * Get data size
     * 
     * @return data size
     */
    public long getLength() {
        return data.length;
    }

    /**
     * Check if data is empty
     * 
     * @return <code>True </code> if data is not empty. Otherwise returns <code> False </code>
     */
    public boolean isEmpty() {
        return nnz == 0;
    }

    /**
     * Starting position
     * 
     * @param row
     *            the row number
     * @return
     */
    public int pos(int row) {
        return row * nCols;
    }

    /**
     * Return row values
     * 
     * @param the
     *            row numbers
     * @return the row values
     */
    public double[] values(int row) {
        double[] rowValues = new double[nCols];
        int ix = pos(row);
        for (int j = 0; j < nCols; j++)
            rowValues[j] = data[ix + j];
        return rowValues;
    }

    public double get(int r, int c) {
        return data[r * nCols + c];
    }

}
