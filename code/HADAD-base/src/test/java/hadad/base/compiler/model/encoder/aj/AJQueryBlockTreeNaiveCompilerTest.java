package hadad.base.compiler.model.encoder.aj;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;

import com.google.inject.Guice;
import com.google.inject.Injector;

import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.base.compiler.QueryBlockTreeBuilder;
import hadad.base.compiler.QueryBlockTreeViewCompiler;
import hadad.base.compiler.model.aj.AJQueryBlockTreeBuilder;
import hadad.base.compiler.model.aj.naive.AJNaiveModule;
import hadad.base.compiler.model.aj.naive.AJNaiveQueryBlockTreeCompiler;

/**
 *  AJ NestedBlockTreeNaiveCompilerTest
 *   
 *
 */
public final class AJQueryBlockTreeNaiveCompilerTest extends
		AJQueryBlockTreeCompilerTest {
	private Injector injector;

	@Override
	@Before
	public void setUp() {
		injector = Guice.createInjector(new AJNaiveModule());
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
		return injector.getInstance(AJQueryBlockTreeBuilder.class);
	}

	@Override
	protected List<QueryBlockTreeViewCompiler> createCompilers() {
		final List<QueryBlockTreeViewCompiler> compilers = new ArrayList<QueryBlockTreeViewCompiler>();
		compilers.add(injector
				.getInstance(AJNaiveQueryBlockTreeCompiler.class));
		return compilers;
	}

	@Override
	protected ConjunctiveQuery restrict(final ConjunctiveQuery query) {
		return query;
	}
}
