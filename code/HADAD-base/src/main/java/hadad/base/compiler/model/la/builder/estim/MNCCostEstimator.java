package hadad.base.compiler.model.la.builder.estim;

import org.apache.log4j.Logger;

import hadad.base.compiler.model.la.api.IOperatorVisitor;
import hadad.base.compiler.model.la.builder.BinaryOperator;
import hadad.base.compiler.model.la.builder.OpType;
import hadad.base.compiler.model.la.builder.ScalarOperator;
import hadad.base.compiler.model.la.builder.ScanOperator;
import hadad.base.compiler.model.la.builder.UnaryOperator;
import hadad.base.compiler.model.la.exception.LAException;
import hadad.base.utils.UtilsLoadHistogram;
/**
 * MCN-based cost estimator
 */
public class MNCCostEstimator implements IOperatorVisitor<MatrixHistogram, Void> {
    /** Logger **/
    private static final Logger LOGGER = Logger.getLogger(MNCCostEstimator.class);
    /** Plan total cost **/
    private double totalCost;

    /** Constructor **/
    public MNCCostEstimator() {
        totalCost = 0;
    }

    @Override
    public MatrixHistogram visit(final UnaryOperator unaryOperator, Void e) {
        final MatrixHistogram h1 = unaryOperator.getChildOp().accept(this, e);
        if (h1 != null) {
            switch (unaryOperator.getOpType()) {
                case TR:
                    totalCost += SparsityEstimatorMCN.estimIntern(h1, null, OpType.TR);
                    return MatrixHistogramUtils.deriveOutputHistogram(h1, null, 0, OpType.TR);
                case IN:
                    totalCost += SparsityEstimatorMCN.estimIntern(h1, null, OpType.IN);
                    return MatrixHistogramUtils.deriveOutputHistogram(h1, null, 0, OpType.IN);
                case EXP:
                    totalCost += SparsityEstimatorMCN.estimIntern(h1, null, OpType.EXP);
                    return MatrixHistogramUtils.deriveOutputHistogram(h1, null, 0, OpType.EXP);
                case ROWSUMS:
                    totalCost += SparsityEstimatorMCN.estimIntern(h1, null, OpType.ROWSUMS);
                    return MatrixHistogramUtils.deriveOutputHistogram(h1, null, 0, OpType.ROWSUMS);
                case COLSUMS:
                    totalCost += SparsityEstimatorMCN.estimIntern(h1, null, OpType.COLSUMS);
                    return MatrixHistogramUtils.deriveOutputHistogram(h1, null, 0, OpType.COLSUMS);
                case TRACE:
                case DET:
                case INS:
                case SUM:
                    totalCost += 0;
                default:
                    return null;
            }
        }
        return null;
    }

    @Override
    public MatrixHistogram visit(final ScanOperator scanOperator, Void e) {
        MatrixHistogram h1 = null;
        try {
            h1 = UtilsLoadHistogram.get(scanOperator.getBaseMatrixName());
        } catch (LAException e1) {
            LOGGER.error("Error getting the histogram!");
        }
        return h1;
    }

    @Override
    public MatrixHistogram visit(ScalarOperator scalarOperator, Void arg) {
        return null;
    }

    @Override
    public MatrixHistogram visit(final BinaryOperator binaryOperator, Void e) {
        final MatrixHistogram h1 = binaryOperator.getChildOpLeft().accept(this, e);
        final MatrixHistogram h2 = binaryOperator.getChildOpRight().accept(this, e);
        switch (binaryOperator.getOpType()) {
            case MULTI:
                double nnz = SparsityEstimatorMCN.estimIntern(h1, h2, OpType.MULTI);
                totalCost += nnz;
                double spOut = nnz / ((double) h1.getRows() * h2.getCols());
                return MatrixHistogramUtils.deriveOutputHistogram(h1, h2, spOut, OpType.MULTI);
            case ADD:
                totalCost += SparsityEstimatorMCN.estimIntern(h1, h2, OpType.ADD);
                return MatrixHistogramUtils.deriveOutputHistogram(h1, h2, 0, OpType.ADD);
            case MULTI_S:
                totalCost += SparsityEstimatorMCN.estimIntern(h1, h2, OpType.MULTI_S);
                return MatrixHistogramUtils.deriveOutputHistogram(h1, h2, 0, OpType.MULTI_S);
            case MULTI_E:
                totalCost += SparsityEstimatorMCN.estimIntern(h1, h2, OpType.MULTI_E);
                return MatrixHistogramUtils.deriveOutputHistogram(h1, h2, 0, OpType.MULTI_E);
            case MULTI_C:
            case ADD_S:
                totalCost += 0; //NO intermediate results.

            default:
                return null;
        }
    }

    /**
     * Get estimated cost
     * 
     * @return cost
     */
    public double getEstimatedCost() {
        return totalCost;
    }
}
