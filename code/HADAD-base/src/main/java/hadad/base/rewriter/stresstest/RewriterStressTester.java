package hadad.base.rewriter.stresstest;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class RewriterStressTester {
	public static void main(String[] args) throws NumberFormatException,

	Exception {
		Injector injector = Guice
				.createInjector(new RewriterStressTesterModule());

		final JQRQViewNavigationDisjointStressTester disjointTester = injector
				.getInstance(JQRQViewNavigationDisjointStressTester.class);
		/*final JQRQViewNavigationJoinStressTester joinTester = injector
				.getInstance(JQRQViewNavigationJoinStressTester.class);*/
		final boolean disjoint = true;
		if (disjoint) {
			disjointTester.run();
		} else {
			//joinTester.run();
		}
	}
}
