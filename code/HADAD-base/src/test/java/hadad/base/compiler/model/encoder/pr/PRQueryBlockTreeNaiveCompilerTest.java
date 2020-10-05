package hadad.base.compiler.model.encoder.pr;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;

import com.google.inject.Guice;
import com.google.inject.Injector;

import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.base.compiler.model.pr.PRNaiveModule;
import hadad.base.compiler.model.pr.PRQueryBlockTreeBuilderAlternative;
import hadad.base.compiler.model.pr.PRQueryBlockTreeCompiler;
import hadad.base.compiler.QueryBlockTreeBuilder;
import hadad.base.compiler.QueryBlockTreeViewCompiler;

/**
 * PJ QueryBlockTreeNaiveCompilerTest
 * 
 *   
 *
 */
public final class PRQueryBlockTreeNaiveCompilerTest extends PRQueryBlockTreeCompilerTest {
    private Injector injector;

    @Override
    @Before
    public void setUp() {
        injector = Guice.createInjector(new PRNaiveModule());
        super.setUp();
    }

    @Override
    @After
    public void tearDown() {
        injector = null;
        super.tearDown();
    }

    @Override
    protected QueryBlockTreeBuilder createBuilder() {
        return injector.getInstance(PRQueryBlockTreeBuilderAlternative.class);
    }

    @Override
    protected List<QueryBlockTreeViewCompiler> createCompilers() {
        final List<QueryBlockTreeViewCompiler> compilers = new ArrayList<QueryBlockTreeViewCompiler>();
        compilers.add(injector.getInstance(PRQueryBlockTreeCompiler.class));
        return compilers;
    }

    @Override
    protected ConjunctiveQuery restrict(final ConjunctiveQuery query) {
        return query;
    }
}
