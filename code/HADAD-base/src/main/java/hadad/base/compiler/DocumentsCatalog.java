package hadad.base.compiler;

import com.google.inject.Singleton;

/**
 * Documents Catalog
 *
 */
@Singleton
public class DocumentsCatalog {
    public String getId(final String documentName) {
        return String.valueOf(documentName.hashCode());
    }
}
