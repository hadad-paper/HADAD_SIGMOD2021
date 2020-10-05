package hadad.base.loader;

import java.io.File;
import java.util.Arrays;
import org.apache.log4j.Logger;

import hadad.base.compiler.model.la.builder.estim.MatrixBlock;
import hadad.base.compiler.model.la.exception.LAException;

/**
 * Data loader with assumption that input matrices fit in memory (no spilling to disk)
 *
 */
public final class DataLoaderCSV {
    /** Logger **/
    private static final Logger LOGGER = Logger.getLogger(DataLoaderCSV.class);
    public static MatrixBlock load(final File file) throws LAException {
        final CSVFileDataReader reader = new CSVFileDataReader(file);
        //First pass for dimension.
        int nRows = 0;
        int nCols = 0;
        try {
            reader.open();
            while (reader.hasNext()) {
                if (nRows == 0) {
                    nCols = reader.next().length;
                }
                reader.next();
                nRows++;
            }
        } catch (LAException e) {
            throw e;
        }
        reader.close();
        //Second pass to load
        double[] data = new double[(++nRows) * nCols];
        try {
            int ix = 0;
            reader.open();
            while (reader.hasNext()) {
                double[] row = Arrays.stream(reader.next()).mapToDouble(Double::parseDouble).toArray();
                System.arraycopy(row, 0, data, ix * (row.length), row.length);
                ix++;
            }

        } catch (LAException e) {
            throw e;
        }
        reader.close();
        return new MatrixBlock(data, nRows, nCols);

    }

}
