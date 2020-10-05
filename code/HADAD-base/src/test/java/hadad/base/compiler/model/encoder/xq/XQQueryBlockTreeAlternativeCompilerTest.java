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

public final class XQQueryBlockTreeAlternativeCompilerTest extends
		XQQueryBlockTreeCompilerTest {
	private Injector firstStepInjector;
	private Injector secondStepInjector;

	@Override
	@Before
	public void setUp() {
		firstStepInjector = Guice
				.createInjector(new hadad.base.compiler.model.xq.alternative.firststep.XQAlternativeModule());
		secondStepInjector = Guice
				.createInjector(new hadad.base.compiler.model.xq.alternative.secondstep.XQAlternativeModule());
		super.setUp();
	}

	@Override
	@After
	public void tearDown() {
		firstStepInjector = null;
		secondStepInjector = null;
		super.tearDown();
	}

	@Override
	protected QueryBlockTreeBuilder createBuilder() {
		return firstStepInjector.getInstance(XQBlockNestedTreeBuilder.class);
	}

	@Override
	protected List<QueryBlockTreeViewCompiler> createCompilers() {
		final List<QueryBlockTreeViewCompiler> compilers = new ArrayList<QueryBlockTreeViewCompiler>();
		compilers.add(firstStepInjector
						.getInstance(hadad.base.compiler.model.xq.alternative.firststep.XQAlternativeNestedBlockTreeCompiler.class));
		compilers.add(secondStepInjector
						.getInstance(hadad.base.compiler.model.xq.alternative.secondstep.XQAlternativeNestedBlockTreeCompiler.class));
		return compilers;
	}
}
