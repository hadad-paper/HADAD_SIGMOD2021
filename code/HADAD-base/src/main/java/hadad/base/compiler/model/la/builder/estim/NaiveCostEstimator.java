package hadad.base.compiler.model.la.builder.estim;
import org.apache.log4j.Logger;

import hadad.base.compiler.model.la.api.IOperatorVisitor;
import hadad.base.compiler.model.la.builder.BinaryOperator;
import hadad.base.compiler.model.la.builder.IOperator;
import hadad.base.compiler.model.la.builder.OpType;
import hadad.base.compiler.model.la.builder.ScalarOperator;
import hadad.base.compiler.model.la.builder.ScanOperator;
import hadad.base.compiler.model.la.builder.UnaryOperator;
import hadad.base.compiler.model.la.metadata.Metadata;
/**
 * Naive LA plan cost-estimator based using naive worse case sparsity estimator.
 * Adopted from SystemML.
 *
 */
public class NaiveCostEstimator implements IOperatorVisitor<Void, Void> {
    /** Logger **/
    private static final Logger LOGGER = Logger.getLogger(NaiveCostEstimator.class);
    private double cost;

    /** Constructor **/
    public NaiveCostEstimator() {
        cost = 0;
    }

    @Override
    public Void visit(final UnaryOperator unaryOperator, Void e) {
        IOperator childOp = unaryOperator.getChildOp();
        childOp.accept(this, e);
        double nnz;
        if (unaryOperator.getOpType().equals(OpType.ROWSUMS)) {
            nnz = SparsityEstimatorWorse.estimateUnary(unaryOperator.getOpType(), childOp.getNnz(),
                    childOp.getNumberOfRows());
        } else {
            if (unaryOperator.getOpType().equals(OpType.COLSUMS)) {
                nnz = SparsityEstimatorWorse.estimateUnary(unaryOperator.getOpType(), childOp.getNnz(),
                        childOp.getNumberOfColumns());
            } else {
                nnz = SparsityEstimatorWorse.estimateUnary(unaryOperator.getOpType(), childOp.getNnz(), 0);
            }
        }
        unaryOperator.setNnz(nnz);
        cost += nnz;
        return e;

    }

    @Override
    public Void visit(final ScanOperator scanOperator, Void e) {
        double nnz = SparsityEstimatorWorse.estimateBase(scanOperator.getNumberOfRows(),
                scanOperator.getNumberOfColumns(), Metadata.instance.getNNZ(scanOperator.getBaseMatrixName()));
        scanOperator.setNnz(nnz);
        return e;

    }

    @Override
    public Void visit(ScalarOperator scalarOperator, Void arg) {
        return null;
    }

    @Override
    public Void visit(final BinaryOperator binaryOperator, Void e) {
        binaryOperator.getChildOpLeft().accept(this, e);
        binaryOperator.getChildOpRight().accept(this, e);
        double nnz =
                SparsityEstimatorWorse.estimateBinary(binaryOperator.getOpType(), binaryOperator.getNumberOfColumns(),
                        binaryOperator.getChildOpLeft().getNnz(), binaryOperator.getChildOpRight().getNnz());
        binaryOperator.setNnz(nnz);
        cost += nnz;
        return e;
    }

    /**
     * Get estimated cost
     * 
     * @return cost
     */
    public double getEstimatedCost() {
        return cost;
    }

}
