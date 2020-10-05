package hadad.base.rewriter.stresstest;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Scenario01KQJQ01RewriterStressTester {
	public static void main(String[] args) throws NumberFormatException,
	Exception {
		final boolean irrelevantViews = false;
		if (irrelevantViews) {
			Injector injector = Guice.createInjector(new Scenario01KQJQ01IrrelavantViewsRewriterStressTesterModule());
			final Scenario01KQJQ01IrrelevantViewsStressTester tester = injector
					.getInstance(Scenario01KQJQ01IrrelevantViewsStressTester.class);
			tester.run();
		} else {
			Injector injector = Guice.createInjector(new Scenario01KQJQ01RelavantViewsRewriterStressTesterModule());
			final Scenario01KQJQ01RelevantViewsStressTester tester = injector
					.getInstance(Scenario01KQJQ01RelevantViewsStressTester.class);
			tester.run();
		}
	}
}
