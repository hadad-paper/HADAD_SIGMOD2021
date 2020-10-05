package hadad.base.compiler.model.encoder.qbt;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;

import com.google.inject.Guice;
import com.google.inject.Injector;

import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.base.compiler.model.qbt.QBTNaiveModule;
import hadad.base.compiler.model.qbt.QBTQueryBlockTreeBuilder;
import hadad.base.compiler.model.qbt.naive.QBTNaiveQueryBlockTreeCompiler;
import hadad.base.compiler.QueryBlockTreeBuilder;
import hadad.base.compiler.QueryBlockTreeViewCompiler;

/**
 * QBT Unit Tests
 * 
 *   
 *
 */
public final class QueryBlockTreeNaiveCompilerTest extends QueryBlockTreeCompilerTest {
    private Injector injector;

    @Override
    @Before
    public void setUp() {
        injector = Guice.createInjector(new QBTNaiveModule());
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
        return injector.getInstance(QBTQueryBlockTreeBuilder.class);
    }

    @Override
    protected List<QueryBlockTreeViewCompiler> createCompilers() {
        final List<QueryBlockTreeViewCompiler> compilers = new ArrayList<QueryBlockTreeViewCompiler>();
        compilers.add(injector.getInstance(QBTNaiveQueryBlockTreeCompiler.class));
        return compilers;
    }

    @Override
    protected ConjunctiveQuery restrict(final ConjunctiveQuery query) {
        return query;
    }
}
