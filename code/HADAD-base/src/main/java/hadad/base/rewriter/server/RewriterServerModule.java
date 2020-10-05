package hadad.base.rewriter.server;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

/**
 *   
 */
class RewriterServerModule extends AbstractModule {
	@Override
	protected void configure() {
		final Properties properties = new Properties();
		try {
			properties.load(new FileReader("rewriter_server.properties"));
			Names.bindProperties(binder(), properties);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}