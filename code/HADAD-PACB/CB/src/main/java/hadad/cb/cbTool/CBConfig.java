package hadad.cb.cbTool;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * CB Engine Config
 *
 */
public class CBConfig {

    static Properties properties = new Properties();
    final static String CONFIG_PATH = "src/main/resources/CBConfig.properties";

    /**
     * Load configurations
     * 
     * @throws IOException
     */
    public static void loadConfig() throws IOException {
        try (InputStream input = new FileInputStream(CONFIG_PATH)) {
            properties = new Properties();
            properties.load(input);
        } catch (IOException exception) {
            throw exception;
        }
    }

    /**
     * Get property
     * 
     * @param property
     * @return the property value
     */
    public static String getProperty(final String property) {
        return (String) properties.get(property);
    }
    /**
     * Get properties
     * @return properties
     */
    public static Properties getProperties() {
        return properties;
    }
}
