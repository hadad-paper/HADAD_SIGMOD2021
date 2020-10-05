package hadad.base.loader;

import hadad.base.compiler.model.la.exception.LAException;

/**
 * IMatrixReader
 */
public interface IMatrixReader<T> {

    /**
     * Open source reader.
     * 
     * @throws LAException
     */
    public void open() throws LAException;

    /**
     * Check for next record.
     * 
     * @return if there is a new record, returns <Code>True</Code>,
     *         else returns <Code>False</Code>
     */
    public boolean hasNext();

    /**
     * Get the current record.
     * 
     * @return the current record.
     * @throws LAException
     */
    public T next() throws LAException;

    /**
     * Close resources.
     * 
     * @throws LAException
     */
    void close() throws LAException;
}
