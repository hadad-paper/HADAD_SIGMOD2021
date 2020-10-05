package hadad.base.compiler.model.la.metadata;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.apache.log4j.Logger;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import hadad.base.utils.Tuple;
/**
 * Utils for metadata
 *
 */
public final class Metadata {
    public static Metadata instance;
    private static final Logger LOGGER = Logger.getLogger(Metadata.class);
    private static final Charset CHARSET = Charsets.UTF_8;
    private final Map<String, Tuple<Integer, Integer, Double, String>> metadata;

    private static final String path = "src/main/resources/metadata.json";

    private Metadata() {
        metadata = new HashMap<>();
    }

    public static void getInstance() {
        if (instance == null) {
            final File file = new File(path);
            if (file.exists() && file.length() > 0) {
                try {
                    instance = load();
                } catch (IOException e) {
                    LOGGER.error("Couldn't load from the metadata file!", e);
                }
            } else {
                instance = new Metadata();
                try {
                    write(instance);
                } catch (IOException e) {
                    LOGGER.error("Couldn't write to the metadata file!", e);
                }
            }
        }
    }

    /** Attempts to read, JSON-decode, and return the contents of a metadata */
    public static Metadata load() throws IOException {
        final Gson gson = createGson();
        final String json = Files.toString(new File(path), CHARSET);
        final Type type = new TypeToken<Metadata>() {
        }.getType();
        return gson.fromJson(json, type);
    }

    /**
     * Receives a catalog and attempts to JSON-encode it and write it into a
     * file
     */
    public static void write(final Metadata catalog) throws IOException {
        final Gson gson = createGson();
        final String json = gson.toJson(catalog);
        Files.write(json, new File(path), CHARSET);
    }

    /** Attempts to JSON-encode and write a metadata into a file */
    public void write() throws IOException {
        write(this);
    }

    /** Adds a new item to the catalog */
    public void add(final String matrixname, int nrows, int ncol, double nnz, String histogramPath) {

        metadata.put(matrixname, new Tuple<Integer, Integer, Double, String>(nrows, ncol, nnz, histogramPath));
        try {
            write();
        } catch (IOException e) {
            LOGGER.error("Couldn't write to the catalog file!", e);
        }
    }
    /** Adds a new item to the catalog */
    public void update(final String matrixname, String histogramPath) {
    	Tuple<Integer, Integer, Double, String>  temp= metadata.get(matrixname);
        metadata.put(matrixname, new Tuple<Integer, Integer, Double, String>(temp.first(),temp.second(), temp.third(), histogramPath));
        try {
            write();
        } catch (IOException e) {
            LOGGER.error("Couldn't write to the catalog file!", e);
        }
    }

    /** Deletes the catalog */
    public void delete() {
        final File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
        metadata.clear();
    }

    /** Searches the catalog for a specified string key */
    public boolean contains(String key) {
        return metadata.containsKey(key);
    }

    @Override
    public String toString() {
        return metadata.toString();
    }

    private static Gson createGson() {
        return new GsonBuilder().create();
    }

    public int getNRows(final String key) {
        return metadata.get(key).first();
    }

    public int getNCols(String key) {
        return metadata.get(key).second();
    }

    public double getNNZ(String key) {
        return metadata.get(key).third();
    }

    public String getHistogramPath(String key) {
        return metadata.get(key).fourth();
    }
}
