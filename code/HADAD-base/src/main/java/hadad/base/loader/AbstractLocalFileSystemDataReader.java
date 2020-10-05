package hadad.base.loader;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import hadad.base.compiler.model.la.exception.LAException;

/**
 * Abstract local file system data reader which implements {@link IDataReader} interface.
 * 
 * 
 */
public abstract class AbstractLocalFileSystemDataReader<T> implements IMatrixReader<T> {
    /** Logger **/
    protected static final Logger LOGGER = Logger.getLogger(AbstractLocalFileSystemDataReader.class);
    /** File **/
    protected final File file;
    /** Line iterator file **/
    protected LineIterator iterator;

    /**
     * Constructor.
     * 
     * @param absolutePath
     *            file absolute path.
     */
    public AbstractLocalFileSystemDataReader(final String absolutePath) {
        this(new File(absolutePath));
        LOGGER.setLevel(Level.OFF);
    }

    /**
     * Constructor.
     * 
     * @param file
     *            file.
     */
    public AbstractLocalFileSystemDataReader(final File file) {

        this.file = file;
    }

    @Override
    public void open() throws LAException {

        try {
            iterator = FileUtils.lineIterator(file, "UTF-8");
        } catch (IOException e) {
            LOGGER.error("Reading LFS File Faild:" + e.getMessage());
            throw new LAException(e);
        }
    }

    @Override
    public void close() {

        iterator.close();

    }

    @Override
    public boolean hasNext() {

        return iterator.hasNext();
    }

}
