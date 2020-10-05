package hadad.base.runner;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 * Rewriter module
 * 
 *   
 */
class EModule extends AbstractModule {
    @Override
    protected void configure() {
        final Properties properties = new Properties();
        try {
            properties.load(new FileReader("HADAD.properties"));
            Names.bindProperties(binder(), properties);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}