package hadad.base.compiler.model.la.builder.estim;

import hadad.base.compiler.model.la.builder.OpType;

/**
 * Worse case sparsity estimator for basic LA operations.
 */
public final class SparsityEstimatorWorse {

    private SparsityEstimatorWorse() {
    };

    public static double estimateBinary(final OpType opType, int nCols, double nnzLeft, double nnzRight) {
        switch (opType) {
            case ADD:
                return Math.min(1, (nnzLeft + nnzRight));
            case ADD_S:
                return 0;
            case MULTI:
                return (Math.min(1, nnzLeft * nCols) * Math.min(1, nnzRight * nCols));
            case MULTI_E:
                return Math.min(nnzLeft, nnzRight);
            case MULTI_S:
                return nnzRight;
            case DIV:
                return Math.min(nnzLeft, nnzRight);
            case DIVS:
                return nnzRight;
            default:
                return 0;
        }
    }

    /**
     * Undary operator estimate
     * 
     * @param opType
     *            operator type
     * @param nnz
     *            number of non-zero
     * @param aggDim
     *            aggregate dim if any
     * @return the estimated sparsity
     */
    public static double estimateUnary(final OpType opType, double nnz, double aggDim) {
        switch (opType) {
            case TR:
                return nnz;
            case EXP: //TODO: Check exponential 
                return nnz;
            case INS:
            case SUM:
            case TRACE:
            case DET:
                return 0;
            case ROWSUMS:
            case COLSUMS:
                return Math.min(1, aggDim * nnz);
            case IN:
                return nnz;
            default:
                return 0;
        }
    }

    /**
     * Base matrix sparsity estimate
     * 
     * @param nRows
     *            number of rows
     * @param nCols
     *            number of cols
     * @param nnz
     *            number of nnz
     * @return the matrix sparsity
     */
    public static double estimateBase(int nRows, int nCols, double nnz) {
        return nnz / (nCols * nRows);
    }
}
