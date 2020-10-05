package hadad.base.utils;
import org.apache.log4j.Logger;

import hadad.base.compiler.model.la.builder.estim.MatrixHistogram;
import hadad.base.compiler.model.la.exception.LAException;
import hadad.base.compiler.model.la.metadata.Metadata;
import hadad.base.loader.Deserializer;
/**
 * Utils for load base histograms
 *
 */
public final class UtilsLoadHistogram {
    /** Logger **/
    private static final Logger LOGGER = Logger.getLogger(UtilsLoadHistogram.class);

    private UtilsLoadHistogram() {
    };
    //TODO: Need to be loaded during start-up
    public static MatrixHistogram get(final String baseName) throws LAException {
        String path = null;
        MatrixHistogram baseHitogram = null;
        try {
            if (Metadata.instance.contains(baseName)) {
                path = Metadata.instance.getHistogramPath(baseName);
                baseHitogram = Deserializer.deserialize(path);
            }
        } catch (LAException e) {
            throw e;
        }
        return baseHitogram;
    }
}
