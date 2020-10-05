package hadad.base.compiler.model.encoder.rk;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;

import com.google.inject.Guice;
import com.google.inject.Injector;

import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.base.compiler.QueryBlockTreeBuilder;
import hadad.base.compiler.QueryBlockTreeViewCompiler;
import hadad.base.compiler.model.rk.RKQueryBlockTreeBuilder;
import hadad.base.compiler.model.rk.naive.RKNaiveModule;
import hadad.base.compiler.model.rk.naive.RKNaiveQueryBlockTreeCompiler;

public final class RKNestedBlockTreeNaiveCompilerTest extends RKNestedBlockTreeCompilerTest {
	private Injector injector;

	@Override
	@Before
	public void setUp() {
		injector = Guice.createInjector(new RKNaiveModule());
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
		return injector.getInstance(RKQueryBlockTreeBuilder.class);
	}

	@Override
	protected List<QueryBlockTreeViewCompiler> createCompilers() {
		final List<QueryBlockTreeViewCompiler> compilers = new ArrayList<QueryBlockTreeViewCompiler>();
		compilers.add(injector.getInstance(RKNaiveQueryBlockTreeCompiler.class));
		return compilers;
	}

	@Override
	protected ConjunctiveQuery restrict(final ConjunctiveQuery query) {
		return query;
	}
}
