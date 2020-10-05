package hadad.base.compiler.model.la.builder.estim;
import java.util.Arrays;
import java.util.stream.IntStream;
/**
 * Matrix Histogram. Adopted from SystemML MatirxHistogram 
 * (https://github.com/apache/systemds/blob/master/src/main/java/org/apache/sysds/hops/estim/EstimatorMatrixHistogram.java)
 *
 */
public class MatrixHistogram implements java.io.Serializable {
    private static final long serialVersionUID = 1L;

    public final int[] rNnz;
    public int[] rNnz1e = null;
    public final int[] cNnz;
    public int[] cNnz1e = null;

    public final int rMaxNnz, cMaxNnz;
    public final int rN1, cN1;
    public final int rNonEmpty, cNonEmpty;
    public final int rNdiv2, cNdiv2;
    public boolean fullDiag;

    public MatrixHistogram(final MatrixBlock in, boolean useExcepts) {
        // 1) allocate basic synopsis
        final int m = in.getNumRows();
        final int n = in.getNumColumns();
        rNnz = new int[in.getNumRows()];
        cNnz = new int[in.getNumColumns()];
        fullDiag = in.getNumRows() == in.getNonZeros() && in.getNumRows() == in.getNumColumns();

        // 2) compute basic synopsis details
        if (in.getLength() == in.getNonZeros()) {
            Arrays.fill(rNnz, n);
            Arrays.fill(cNnz, m);
        } else if (!in.isEmpty()) {
            for (int j = 0; j < m; j++) {
                rNnz[j] = in.computeNonZero(j);
                fullDiag &= (rNnz[j] == 1 && n > j && in.get(j, j) != 0);
            }
            for (int i = 0; i < n; i++) {
                cNnz[i] = in.computeNonZeroColumn(i);
            }

        }
        // 3) compute meta data synopsis
        int[] rSummary = deriveSummaryStatistics(rNnz, getCols());
        int[] cSummary = deriveSummaryStatistics(cNnz, getRows());
        rMaxNnz = rSummary[0];
        cMaxNnz = cSummary[0];
        rN1 = rSummary[1];
        cN1 = cSummary[1];
        rNonEmpty = rSummary[2];
        cNonEmpty = cSummary[2];
        rNdiv2 = rSummary[3];
        cNdiv2 = cSummary[3];

        // 4) compute exception details if necessary (optional)
        if (useExcepts && !in.isEmpty() && (rMaxNnz > 1 || cMaxNnz > 1) && in.getLength() != in.getNonZeros()) { //not fully dense
            rNnz1e = new int[in.getNumRows()];
            cNnz1e = new int[in.getNumColumns()];

            for (int i = 0; i < m; i++) {
                double[] avals = in.values(i);
                boolean rNnzlte1 = rNnz[i] <= 1;
                for (int j = 0; j < n; j++) {
                    if (avals[j] != 0) {
                        if (cNnz[j] <= 1)
                            rNnz1e[i]++;
                        if (rNnzlte1)
                            cNnz1e[j]++;
                    }
                }
            }
        }
    }

    public MatrixHistogram(int[] r, int[] r1e, int[] c, int[] c1e, int rmax, int cmax) {
        rNnz = r;
        rNnz1e = r1e;
        cNnz = c;
        cNnz1e = c1e;
        rMaxNnz = rmax;
        cMaxNnz = cmax;
        rN1 = cN1 = -1;
        rNdiv2 = cNdiv2 = -1;

        //update non-zero rows/cols
        rNonEmpty = (int) Arrays.stream(rNnz).filter(i -> i != 0).count();
        cNonEmpty = (int) Arrays.stream(cNnz).filter(i -> i != 0).count();
    }

    public int getRows() {
        return rNnz.length;
    }

    public int getCols() {
        return cNnz.length;
    }

    public int[] getRowCounts() {
        return rNnz;
    }

    public int[] getRowCountsE() {
        return rNnz1e;
    }

    public int[] getColCounts() {
        return cNnz;
    }

    public int[] getColCountsE() {
        return cNnz1e;
    }

    public long getNonZeros() {
        return getRows() < getCols() ? IntStream.range(0, getRows()).mapToLong(i -> rNnz[i]).sum()
                : IntStream.range(0, getCols()).mapToLong(i -> cNnz[i]).sum();
    }

    private static int[] deriveSummaryStatistics(int[] counts, int N) {
        int max = Integer.MIN_VALUE, N2 = N / 2;
        int cntN1 = 0, cntNeq0 = 0, cntNdiv2 = 0;
        for (int i = 0; i < counts.length; i++) {
            final int cnti = counts[i];
            max = Math.max(max, cnti);
            cntN1 += (cnti == 1) ? 1 : 0;
            cntNeq0 += (cnti != 0) ? 1 : 0;
            cntNdiv2 += (cnti > N2) ? 1 : 0;
        }
        return new int[] { max, cntN1, cntNeq0, cntNdiv2 };
    }

}
