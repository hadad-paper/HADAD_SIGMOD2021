package hadad.base.compiler.model.la.builder.estim;
import java.util.Random;
import java.util.stream.IntStream;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.log4j.Logger;

import hadad.base.compiler.model.la.builder.OpType;

/**
 * Matrix histogram Utils.
 *
 */
public final class MatrixHistogramUtils {
    /** Logger **/
    private static final Logger LOGGER = Logger.getLogger(MatrixHistogramUtils.class);

    private MatrixHistogramUtils() {
    };

    /**
     * Derive output histogram
     * 
     * @param h1
     *            left histogram
     * @param h2
     *            right histogram
     * @param spOut
     *            sparsity output
     * @param op
     *            operator
     * @return derived histogram
     */
    public static MatrixHistogram deriveOutputHistogram(final MatrixHistogram h1, final MatrixHistogram h2,
            final double spOut, final OpType op) {
        switch (op) {
            case MULTI:
                return deriveMMHistogram(h1, h2, spOut);
            case MULTI_E:
                return deriveMultHistogram(h1, h2);
            case MULTI_S:
                return h2;
            case ADD:
                return derivePlusHistogram(h1, h2);
            case TR:
                return deriveTransHistogram(h1);
            case ROWSUMS:
                return deriveRowsHistogram(h1);
            case COLSUMS:
                return derivColsHistogram(h1);
            case EXP:
            case IN: //MNC doesn't provide an way to derive histogram of the output of inverse
                return h1;

            default:
                throw new NotImplementedException("Operator is not supported!");
        }
    }

    public static MatrixHistogram deriveMMHistogram(final MatrixHistogram h1, MatrixHistogram h2, double spOut) {

        if (h1.fullDiag)
            return h2;
        if (h2.fullDiag)
            return h1;

        long nnz1 = h1.getNonZeros();
        long nnz2 = h2.getNonZeros();
        double nnzOut = spOut * h1.getRows() * h2.getCols();

        int rMaxNnz = 0, cMaxNnz = 0;
        int[] rNnz = new int[h1.getRows()];
        Random rn = new Random();
        for (int i = 0; i < h1.getRows(); i++) {
            rNnz[i] = probRound(nnzOut / nnz1 * h1.rNnz[i], rn);
            rMaxNnz = Math.max(rMaxNnz, rNnz[i]);
        }
        int[] cNnz = new int[h2.getCols()];

        for (int i = 0; i < h2.getCols(); i++) {
            cNnz[i] = probRound(nnzOut / nnz2 * h2.cNnz[i], rn);
            cMaxNnz = Math.max(cMaxNnz, cNnz[i]);
        }

        //construct new histogram object
        return new MatrixHistogram(rNnz, null, cNnz, null, rMaxNnz, cMaxNnz);
    }

    public static MatrixHistogram deriveMultHistogram(final MatrixHistogram h1, final MatrixHistogram h2) {

        final double scaler = IntStream.range(0, h1.getCols()).mapToDouble(j -> (double) h1.cNnz[j] * h2.cNnz[j]).sum()
                / h1.getNonZeros() / h2.getNonZeros();
        final double scalec = IntStream.range(0, h1.getRows()).mapToDouble(j -> (double) h1.rNnz[j] * h2.rNnz[j]).sum()
                / h1.getNonZeros() / h2.getNonZeros();
        int rMaxNnz = 0, cMaxNnz = 0;
        Random rn = new Random();
        int[] rNnz = new int[h1.getRows()];
        for (int i = 0; i < h1.getRows(); i++) {
            rNnz[i] = probRound((double) h1.rNnz[i] * h2.rNnz[i] * scaler, rn);
            rMaxNnz = Math.max(rMaxNnz, rNnz[i]);
        }
        int[] cNnz = new int[h1.getCols()];
        for (int i = 0; i < h1.getCols(); i++) {
            cNnz[i] = probRound((double) h1.cNnz[i] * h2.cNnz[i] * scalec, rn);
            cMaxNnz = Math.max(cMaxNnz, cNnz[i]);
        }
        return new MatrixHistogram(rNnz, null, cNnz, null, rMaxNnz, cMaxNnz);
    }

    public static MatrixHistogram derivePlusHistogram(final MatrixHistogram h1, MatrixHistogram h2) {
        final double scaler = IntStream.range(0, h1.getCols()).mapToDouble(j -> (double) h1.cNnz[j] * h2.cNnz[j]).sum()
                / h1.getNonZeros() / h2.getNonZeros();
        final double scalec = IntStream.range(0, h1.getRows()).mapToDouble(j -> (double) h1.rNnz[j] * h2.rNnz[j]).sum()
                / h1.getNonZeros() / h2.getNonZeros();
        int rMaxNnz = 0, cMaxNnz = 0;
        Random rn = new Random();
        int[] rNnz = new int[h1.getRows()];
        for (int i = 0; i < h1.getRows(); i++) {
            rNnz[i] = probRound(h1.rNnz[i] + h2.rNnz[i] - (double) h1.rNnz[i] * h2.rNnz[i] * scaler, rn);
            rMaxNnz = Math.max(rMaxNnz, rNnz[i]);
        }
        int[] cNnz = new int[h1.getCols()];
        for (int i = 0; i < h1.getCols(); i++) {
            cNnz[i] = probRound(h1.cNnz[i] + h2.cNnz[i] - (double) h1.cNnz[i] * h2.cNnz[i] * scalec, rn);
            cMaxNnz = Math.max(cMaxNnz, cNnz[i]);
        }
        return new MatrixHistogram(rNnz, null, cNnz, null, rMaxNnz, cMaxNnz);
    }

    private static MatrixHistogram deriveTransHistogram(MatrixHistogram h1) {
        return new MatrixHistogram(h1.cNnz, h1.cNnz1e, h1.rNnz, h1.rNnz1e, h1.cMaxNnz, h1.rMaxNnz);
    }

    private static MatrixHistogram deriveRowsHistogram(MatrixHistogram h1) {
        int[] rNnz = new int[h1.getRows()];
        for (int i = 0; i < h1.getRows(); i++) {
            rNnz[i] = (h1.rNnz[i] != 0) ? 1 : 0;
        }

        int[] cNnz = new int[1];
        cNnz[0] = (int) IntStream.range(0, h1.getRows()).mapToDouble(i -> (rNnz[i] != 0 ? 1 : 0)).sum();
        int rMaxNnz = 0;
        rMaxNnz = cNnz[0] >= 1 ? 1 : 0;
        //return new MatrixHistogram(cNnz, null, rNnz, null, cNnz[0], rMaxNnz);
        return new MatrixHistogram(rNnz, null, cNnz, null, cNnz[0], rMaxNnz);
        
    }

    private static MatrixHistogram derivColsHistogram(MatrixHistogram h1) {
        int[] cNnz = new int[h1.getCols()];
        for (int i = 0; i < h1.getCols(); i++) {
            cNnz[i] = (h1.cNnz[i] != 0) ? 1 : 0;
        }

        int[] rNnz = new int[1];
        rNnz[0] = (int) IntStream.range(0, h1.getCols()).mapToDouble(i -> (cNnz[i] != 0 ? 1 : 0)).sum();
        int cMaxNnz = 0;
        cMaxNnz = rNnz[0] >= 1 ? 1 : 0;
        //return new MatrixHistogram(cNnz, null, rNnz, null, rNnz[0], cMaxNnz);
        return new MatrixHistogram(rNnz, null, cNnz, null, rNnz[0], cMaxNnz);
    }

    private static int probRound(double inNnz, Random rand) {
        double temp = Math.floor(inNnz);
        double f = inNnz - temp;
        double randf = rand.nextDouble();
        return (int) ((f > randf) ? temp + 1 : temp);
    }

}
