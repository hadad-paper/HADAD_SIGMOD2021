package hadad.base.loader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import org.apache.log4j.Logger;
import hadad.base.compiler.model.la.exception.LAException;

/**
 * A class to serialize an object.
 *
 */
public class Serializer {
    private static final Logger LOGGER = Logger.getLogger(Serializer.class);

    /**
     * Serialize an object
     * 
     * @param fileName
     *            a file name to persist the serialized object.
     * @param object
     *            the object to be serialized.
     * @throws LAException
     */
    public static void serialize(final String fileName, final Serializable object) throws LAException {
        FileOutputStream file;
        ObjectOutputStream out;
        try {
            file = new FileOutputStream(fileName);
            out = new ObjectOutputStream(file);
            out.writeObject(object);
            out.close();
            file.close();
        } catch (IOException e) {
            LOGGER.error("Object serialization failed: " + e.getMessage());
            throw new LAException(e);
        }
    }
}
