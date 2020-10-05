package hadad.base.compiler.query;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import hadad.base.compiler.NaiveRewritingSelector;
import hadad.base.compiler.QueryBlockTreeBuilder;
import hadad.base.compiler.RewritingSelector;
import hadad.base.compiler.VariableFactory;

public abstract class QBTQueryModule extends AbstractModule {
	@Override
	protected void configure() {
		final Properties properties = new Properties();
		try {
			properties.load(new FileReader(getPropertiesFileName()));
			Names.bindProperties(binder(), properties);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		bind(VariableFactory.class).annotatedWith(Names.named("ArrayElementVariableFactory"))
				.toInstance(new VariableFactory(properties.getProperty("fresh_array_element_variable_prefix", "a_")));
		bind(VariableFactory.class).annotatedWith(Names.named("ConjunctiveQueryVariableFactory")).toInstance(
				new VariableFactory(properties.getProperty("fresh_conjunctive_query_variable_prefix", "e_")));
		bind(VariableFactory.class).annotatedWith(Names.named("KQLVariableFactory"))
				.toInstance(new VariableFactory(properties.getProperty("fresh_map_variable_prefix", "w_")));
		bind(VariableFactory.class).annotatedWith(Names.named("ElementVariableFactory"))
				.toInstance(new VariableFactory(properties.getProperty("fresh_element_variable_prefix", "z_")));
		bind(VariableFactory.class).annotatedWith(Names.named("ReturnTemplateVariableFactory"))
				.toInstance(new VariableFactory(properties.getProperty("fresh_return_variable_prefix", "r_")));
		bind(RewritingSelector.class).to(NaiveRewritingSelector.class);
		bind(QueryBlockTreeBuilder.class).to(MixedNestedBlockTreeBuilder.class);
	}

	protected abstract String getPropertiesFileName();
}