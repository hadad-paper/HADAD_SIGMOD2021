package hadad.base.rewriter.stresstest;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class Scenario01KQJQ01IrrelavantViewsRewriterStressTesterModule extends AbstractModule {
	@Override
	protected void configure() {
		final Properties properties = new Properties();
		try {
			properties.load(new FileReader("scenario01_kq_jq_01_irrelevant_views_stress_tester.properties"));
			Names.bindProperties(binder(), properties);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}