package hadad.base.loader;

import java.io.File;
import hadad.base.compiler.model.la.exception.LAException;
/**
 * CSV file data reader which extends {@link AbstractLocalFileSystemDataReader<T>} abstract class.
 *
 */
public class CSVFileDataReader extends AbstractLocalFileSystemDataReader<String[]> {
    private final static String COMMA_DELIMITER = ",";

    /**
     * Constructor.
     * 
     * @param absolutePath
     *            absoulte path.
     */
    public CSVFileDataReader(final String absolutePath) {
        super(absolutePath);
    }

    /**
     * Constructor.
     * 
     * @param file
     * 
     */
    public CSVFileDataReader(final File file) {
        super(file);
    }

    @Override
    public String[] next() throws LAException {

        return iterator.nextLine().split(COMMA_DELIMITER);
    }

}
