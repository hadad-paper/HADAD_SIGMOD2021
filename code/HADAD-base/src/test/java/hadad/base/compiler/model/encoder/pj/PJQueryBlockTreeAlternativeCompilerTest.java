package hadad.base.compiler.model.encoder.pj;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;

import com.google.inject.Guice;
import com.google.inject.Injector;

import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.base.compiler.model.pj.naive.PJNaiveModule;
import hadad.base.compiler.model.pj.naive.PJNaiveQueryBlockTreeCompiler;
import hadad.base.compiler.QueryBlockTreeBuilder;
import hadad.base.compiler.QueryBlockTreeViewCompiler;
import hadad.base.compiler.model.pj.PJQueryBlockTreeBuilder;
import hadad.base.compiler.model.pj.Utils;

/**
 * PJ QueryBlockTreeAlternativeCompilerTest
 * 
 *  
 *
 */
public final class PJQueryBlockTreeAlternativeCompilerTest extends PJQueryBlockTreeCompilerTest {
    private Injector injector;

    @Override
    @Before
    public void setUp() {
        injector = Guice.createInjector(new PJNaiveModule());;
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
        return injector.getInstance(PJQueryBlockTreeBuilder.class);
    }

    @Override
    protected List<QueryBlockTreeViewCompiler> createCompilers() {
        final List<QueryBlockTreeViewCompiler> compilers = new ArrayList<QueryBlockTreeViewCompiler>();
        compilers.add(injector.getInstance(PJNaiveQueryBlockTreeCompiler.class));

        return compilers;
    }

    @Override
    protected ConjunctiveQuery restrict(final ConjunctiveQuery query) {
        return Utils.restrict(query);
    }
}
