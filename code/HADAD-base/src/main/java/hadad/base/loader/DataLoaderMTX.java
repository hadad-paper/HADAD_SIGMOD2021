package hadad.base.loader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.apache.log4j.Logger;

import hadad.base.compiler.model.la.builder.estim.MatrixBlock;

/**
 * Data loader with assumption that input matrices fit in memory
 *
 */
public final class DataLoaderMTX {
    /** Logger **/
    private static final Logger LOGGER = Logger.getLogger(DataLoaderMTX.class);

    public static MatrixBlock load(final File file) throws Exception {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            String colRowSize = reader.readLine();
            String[] parameters = colRowSize.split(" ");
            int nRows = Integer.parseInt(parameters[0]);
            int nCols = Integer.parseInt(parameters[1]);
            int size = Integer.parseInt(parameters[2]);
            double[] data = new double[size];
            line = reader.readLine();
            System.out.println(line);
            while (line != null) {
                parameters = line.split(" ");
                int i = Integer.parseInt(parameters[0]);
                int j = Integer.parseInt(parameters[1]);
                int val = Integer.parseInt(parameters[2]);
                data[i * nCols + j] = val;
                line = reader.readLine();
                System.out.println(line);
            }
            reader.close();
            return new MatrixBlock(data, nRows, nCols);

        } catch (IOException e) {
            throw e;
        }
    }
}
