package hadad.base.compiler.model.aj;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Properties;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import hadad.commons.constraints.Constraint;
import hadad.commons.constraints.parser.ConstraintParser;
import hadad.commons.constraints.parser.ParseException;
import hadad.base.compiler.NaiveRewritingSelector;
import hadad.base.compiler.QueryBlockTreeBuilder;
import hadad.base.compiler.QueryBlockTreeConstraintsTemplate;
import hadad.base.compiler.RewritingSelector;
import hadad.base.compiler.VariableFactory;

/**
 * AJ Module (Google Guice Injector)
 */
public abstract class AJModule extends AbstractModule {
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
                new VariableFactory(properties.getProperty("fresh_conjunctive_query_variable_prefix", "c_")));
        bind(VariableFactory.class).annotatedWith(Names.named("AQLVariableFactory"))
                .toInstance(new VariableFactory(properties.getProperty("fresh_xquery_variable_prefix", "b_")));
        bind(VariableFactory.class).annotatedWith(Names.named("ElementVariableFactory"))
                .toInstance(new VariableFactory(properties.getProperty("fresh_element_variable_prefix", "d_")));
        bind(VariableFactory.class).annotatedWith(Names.named("ReturnTemplateVariableFactory"))
                .toInstance(new VariableFactory(properties.getProperty("fresh_return_variable_prefix", "e_")));
        try {
            bind(QueryBlockTreeConstraintsTemplate.class).annotatedWith(Names.named("ForwardConstraintsTemplate"))
                    .toInstance(new QueryBlockTreeConstraintsTemplate(
                            parseConstraints(
                                    properties.getProperty("forward_constraints.template_grex_schema_file_name")),
                            parseConstraints(properties.getProperty("forward_constraints.template_view_file_name")),
                            properties.getProperty("template_document_name"),
                            properties.getProperty("document_name_prefix"),
                            properties.getProperty("template_view_name"), properties.getProperty("view_name_prefix")));
        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
        try {
            bind(QueryBlockTreeConstraintsTemplate.class).annotatedWith(Names.named("BackwardConstraintsTemplate"))
                    .toInstance(new QueryBlockTreeConstraintsTemplate(
                            parseConstraints(
                                    properties.getProperty("backward_constraints.template_grex_schema_file_name")),
                            parseConstraints(properties.getProperty("backward_constraints.template_view_file_name")),
                            properties.getProperty("template_document_name"),
                            properties.getProperty("document_name_prefix"),
                            properties.getProperty("template_view_name"), properties.getProperty("view_name_prefix")));
        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
        bind(RewritingSelector.class).to(NaiveRewritingSelector.class);
        bind(QueryBlockTreeBuilder.class).to(AJQueryBlockTreeBuilder.class);
    }

    private List<Constraint> parseConstraints(final String fileName) throws ParseException, IOException {
        final Reader reader = new FileReader(fileName);
        final ConstraintParser parser = new ConstraintParser(reader);
        final List<Constraint> constraints = parser.parse();
        reader.close();
        return constraints;
    }

    protected abstract String getPropertiesFileName();
}