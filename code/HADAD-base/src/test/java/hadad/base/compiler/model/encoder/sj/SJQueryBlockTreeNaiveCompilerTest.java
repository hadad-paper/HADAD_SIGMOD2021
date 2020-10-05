package hadad.base.compiler.model.encoder.sj;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;

import com.google.inject.Guice;
import com.google.inject.Injector;

import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.base.compiler.model.sj.SJQueryBlockTreeBuilder;
import hadad.base.compiler.model.sj.naive.SJNaiveModule;
import hadad.base.compiler.model.sj.naive.SJNaiveQueryBlockTreeCompiler;
import hadad.base.compiler.QueryBlockTreeBuilder;
import hadad.base.compiler.QueryBlockTreeViewCompiler;

/**
 * SJ NestedBlockTreeNaiveCompilerTest
 * 
 *   
 *
 */
public final class SJQueryBlockTreeNaiveCompilerTest extends SJQueryBlockTreeCompilerTest {
    private Injector injector;

    @Override
    @Before
    public void setUp() {
        injector = Guice.createInjector(new SJNaiveModule());
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
        return injector.getInstance(SJQueryBlockTreeBuilder.class);
    }

    @Override
    protected List<QueryBlockTreeViewCompiler> createCompilers() {
        final List<QueryBlockTreeViewCompiler> compilers = new ArrayList<QueryBlockTreeViewCompiler>();
        compilers.add(injector.getInstance(SJNaiveQueryBlockTreeCompiler.class));
        return compilers;
    }

    @Override
    protected ConjunctiveQuery restrict(final ConjunctiveQuery query) {
        return query;
    }
}
