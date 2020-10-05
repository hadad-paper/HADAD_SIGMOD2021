package hadad.base.compiler.model.encoder.xq;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;

import com.google.inject.Guice;
import com.google.inject.Injector;

import hadad.base.compiler.QueryBlockTreeBuilder;
import hadad.base.compiler.QueryBlockTreeViewCompiler;
import hadad.base.compiler.model.xq.XQBlockNestedTreeBuilder;
import hadad.base.compiler.model.xq.naive.XQNaiveModule;
import hadad.base.compiler.model.xq.naive.XQNaiveNestedBlockTreeCompiler;

/**
 * XQ QueryBlockTreeNaiveCompilerTest
 * 
 *   
 *
 */
public final class XQQueryBlockTreeNaiveCompilerTest extends XQQueryBlockTreeCompilerTest {
    private Injector injector;

    @Override
    @Before
    public void setUp() {
        injector = Guice.createInjector(new XQNaiveModule());
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
        return injector.getInstance(XQBlockNestedTreeBuilder.class);
    }

    @Override
    protected List<QueryBlockTreeViewCompiler> createCompilers() {
        final List<QueryBlockTreeViewCompiler> compilers = new ArrayList<QueryBlockTreeViewCompiler>();
        compilers.add(injector.getInstance(XQNaiveNestedBlockTreeCompiler.class));
        return compilers;
    }
}
