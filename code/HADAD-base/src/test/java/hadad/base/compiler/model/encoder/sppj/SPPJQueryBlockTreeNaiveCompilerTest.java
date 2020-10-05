package hadad.base.compiler.model.encoder.sppj;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;

import com.google.inject.Guice;
import com.google.inject.Injector;

import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.base.compiler.QueryBlockTreeBuilder;
import hadad.base.compiler.QueryBlockTreeViewCompiler;
import hadad.base.compiler.model.sppj.SPPJQueryBlockTreeBuilder;
import hadad.base.compiler.model.sppj.naive.SPPJNaiveModule;
import hadad.base.compiler.model.sppj.naive.SPPJNaiveQueryBlockTreeCompiler;

/**
 * SPPJ QueryBlockTreeNaiveCompilerTest
 * 
 *   
 *
 */
public final class SPPJQueryBlockTreeNaiveCompilerTest extends SPPJQueryBlockTreeCompilerTest {
    private Injector injector;

    @Override
    @Before
    public void setUp() {
        injector = Guice.createInjector(new SPPJNaiveModule());
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
        return injector.getInstance(SPPJQueryBlockTreeBuilder.class);
    }

    @Override
    protected List<QueryBlockTreeViewCompiler> createCompilers() {
        final List<QueryBlockTreeViewCompiler> compilers = new ArrayList<QueryBlockTreeViewCompiler>();
        compilers.add(injector.getInstance(SPPJNaiveQueryBlockTreeCompiler.class));
        return compilers;
    }

    @Override
    protected ConjunctiveQuery restrict(final ConjunctiveQuery query) {
        return query;
    }
}
