package hadad.base.compiler;

import com.google.inject.Singleton;

@Singleton
public class MapsCatalog {
    public String getId(final String documentName) {
        return String.valueOf(documentName.hashCode());
    }
}
