package hadad.base.compiler.model.la.builder.estim;

import java.util.stream.IntStream;

import org.apache.commons.lang3.NotImplementedException;
import org.apache.log4j.Logger;
import hadad.base.compiler.model.la.builder.OpType;

/**
 * Sparsity estimator MNC.
 * Adopted from SystemML MatirxHistogram 
 * (https://github.com/apache/systemds/blob/master/src/main/java/org/apache/sysds/hops/estim/EstimatorMatrixHistogram.java)
 *
 */
public final class SparsityEstimatorMCN {
    /** Logger **/
    private static final Logger LOGGER = Logger.getLogger(MatrixHistogramUtils.class);
    private static final boolean DEFAULT_USE_EXTENDED = true;

    private SparsityEstimatorMCN() {
    };

    /**
     * Estimate intermediate non-zero size
     * 
     * @param h1
     *            left histogram
     * @param h2
     *            left histogram
     * @param op
     *            operator
     * @return estimated number of non-zeros
     */
    public static double estimIntern(final MatrixHistogram h1, final MatrixHistogram h2, OpType op) {
        switch (op) {
            case MULTI:
                return estimInternMM(h1, h2);
            case MULTI_E: {
                final double scale =
                        IntStream.range(0, h1.getCols()).mapToDouble(j -> (double) h1.cNnz[j] * h2.cNnz[j]).sum()
                                / h1.getNonZeros() / h2.getNonZeros();
                return IntStream.range(0, h1.getRows()).mapToDouble(i -> (double) h1.rNnz[i] * h2.rNnz[i] * scale)
                        .sum();

            }
            case ADD: {
                final double scale =
                        IntStream.range(0, h1.getCols()).mapToDouble(j -> (double) h1.cNnz[j] * h2.cNnz[j]).sum()
                                / h1.getNonZeros() / h2.getNonZeros();
                return IntStream.range(0, h1.getRows())
                        .mapToDouble(i -> (double) h1.rNnz[i] + h2.rNnz[i] - (double) h1.rNnz[i] * h2.rNnz[i] * scale)
                        .sum();
            }
            case MULTI_S:
                return h2 != null ? h2.getNonZeros() : 0;
            case ROWSUMS:
                return IntStream.range(0, h1.getRows()).mapToDouble(i -> (h1.rNnz[i] != 0 ? 1 : 0)).sum();
            case COLSUMS:
                return IntStream.range(0, h1.getCols()).mapToDouble(i -> (h1.cNnz[i] != 0 ? 1 : 0)).sum();
            case IN:
                return h1.getNonZeros();
            case TR:
                return h1.getNonZeros();
            case EXP:
                return h1.getNonZeros();

            default:
                throw new NotImplementedException("Operator is not supported!");
        }
    }

    /**
     * Estimate matrix multiplication non-zeros intermediates
     * 
     * @param h1
     *            left histogram
     * @param h2
     *            right histogram
     * @return estimated non-zero intermediate size
     */
    private static double estimInternMM(MatrixHistogram h1, MatrixHistogram h2) {
        long nnz = 0;

        if (h1.rMaxNnz <= 1 || h2.cMaxNnz <= 1) {
            for (int j = 0; j < h1.getCols(); j++)
                nnz += (long) h1.cNnz[j] * h2.rNnz[j];
        } else if (h1.cNnz1e != null || h2.rNnz1e != null) {

            long mnOut = DEFAULT_USE_EXTENDED ? (long) (h1.rNonEmpty - h1.rN1) * (h2.cNonEmpty - h2.cN1)
                    : (long) (h1.getRows() - h1.rN1) * (h2.getCols() - h2.cN1);
            double spOutRest = 0;
            for (int j = 0; j < h1.getCols(); j++) {
                int h1c1ej = (h1.cNnz1e != null) ? h1.cNnz1e[j] : 0;
                int h2r1ej = (h2.rNnz1e != null) ? h2.rNnz1e[j] : 0;
                nnz += (long) h1c1ej * h2.rNnz[j];
                nnz += (long) (h1.cNnz[j] - h1c1ej) * h2r1ej;
                double lsp = (double) (h1.cNnz[j] - h1c1ej) * (h2.rNnz[j] - h2r1ej) / mnOut;
                spOutRest = spOutRest + lsp - spOutRest * lsp;
            }
            nnz += (long) (spOutRest * mnOut);
        } else {
            long mnOut = DEFAULT_USE_EXTENDED ? (long) h1.rNonEmpty * h2.cNonEmpty : (long) h1.getRows() * h2.getCols();
            double spOut = 0;
            for (int j = 0; j < h1.getCols(); j++) {
                double lsp = (double) h1.cNnz[j] * h2.rNnz[j] / mnOut;
                spOut = spOut + lsp - spOut * lsp;
            }
            nnz = (long) (spOut * mnOut);
        }

        if (DEFAULT_USE_EXTENDED) {

            nnz = (h1.rNdiv2 >= 0 && h2.cNdiv2 >= 0) ? Math.max((long) h1.rNdiv2 * h2.cNdiv2, nnz) : nnz;
        }

        return nnz;
    }
}
