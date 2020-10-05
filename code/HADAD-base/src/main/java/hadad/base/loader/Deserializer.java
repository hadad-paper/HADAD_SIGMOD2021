package hadad.base.loader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import org.apache.log4j.Logger;

import hadad.base.compiler.model.la.exception.LAException;

/**
 * A class to deserialize an object.
 *
 */
public class Deserializer {
    private static final Logger LOGGER = Logger.getLogger(Deserializer.class);

    /**
     * Deserialize an object of type <T>.
     * 
     * @param fileName
     *            a file name that stored the serialized object.
     * @return the deserialized object.
     * @throws LAException
     */
    @SuppressWarnings("unchecked")
    public static <T> T deserialize(final String fileName) throws LAException {
        FileInputStream file;
        ObjectInputStream in;
        T object;
        try {
            file = new FileInputStream(fileName);
            in = new ObjectInputStream(file);
            object = (T) in.readObject();
            in.close();
            file.close();
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.error("Object derialization failed: " + e.getMessage());
            throw new LAException(e);
        }
        return object;
    }
}
