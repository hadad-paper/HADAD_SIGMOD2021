package hadad.base.compiler.model.la.builder.estim;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.log4j.Logger;

import hadad.base.compiler.Utils;
import hadad.base.compiler.model.la.builder.BinaryOperator;
import hadad.base.compiler.model.la.builder.IOperator;
import hadad.base.compiler.model.la.builder.LAPlanBuilder;
import hadad.base.compiler.model.la.builder.UnaryOperator;
import hadad.base.compiler.model.la.metadata.Metadata;
import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.conjunctivequery.parser.ParseException;
public class TestNaive {
    private static final Logger LOGGER = Logger.getLogger(TestNaive.class);
    private static final String TEST_DIR = "src/test/resources/lapipes/";

    public static void main(String args[]) throws Exception {
        Metadata.getInstance();
        Metadata.instance.delete();
        Metadata.instance.add("matrix-50000-100-1.0.csv", 50000, 100, 5000000, "");
        Metadata.instance.add("matrix-100-50000-1.0.csv", 100, 50000, 5000000, "");
        Metadata.instance.add("matrix-1000000-100-1.0.csv", 1000000, 100, 100000000, "");
        Metadata.instance.add("matrix-10000-10000-1.0.csv", 10000, 10000, 100000000, "");
        Metadata.instance.add("matrix-100-1-1.0.csv", 100, 1, 100, "");
        test();
    }

    private static List<File> getTestsDirectories() {
        final File directory = new File(TEST_DIR);
        final List<File> testsDirectory = new ArrayList<File>();
        for (final File file : directory.listFiles()) {
            if (file.isDirectory()) {
                testsDirectory.add(file);

            }
        }
        return testsDirectory;
    }

    public static void test() {
        getTestsDirectories().stream().forEach(f -> test(f));
    }

    private static List<File> getTestQuery(final File testDirectory) throws IOException {
        List<File> files = new ArrayList<>();
        for (final File file : testDirectory.listFiles()) {
            if (file.isFile() && file.getName().contains((".RW"))) {
                files.add(file);

            }
        }
        return files;
    }

	private static void test(final File testDirectory) {

		LOGGER.debug("Testing " + testDirectory.toString());
		try {
			final Collection<ConjunctiveQuery> rewriitngs = new ArrayList<>();
			List<File> rws = getTestQuery(testDirectory);
			for (File file : rws) {
				rewriitngs.add(Utils.parseQuery(file));
			}
			double minCost = Double.MAX_VALUE;
			ConjunctiveQuery minRW = null;
			// warm-up
			for (final ConjunctiveQuery rw : rewriitngs) {
				final IOperator root = LAPlanBuilder.constructPlan(rw);
				NaiveCostEstimator estimator = null;
				estimator = new NaiveCostEstimator();
				if (root instanceof UnaryOperator) {
					estimator.visit((UnaryOperator) root, null);

				}
				if (root instanceof BinaryOperator) {
					estimator.visit((BinaryOperator) root, null);

				}
				double currentCost = estimator.getEstimatedCost();
				if (currentCost <= minCost) {
					minCost = currentCost;
					minRW = rw;
				}
			}

			long startTime = System.nanoTime();
			for (int i = 0; i < 10; i++) {
				minCost = Double.MAX_VALUE;
				minRW = null;
				for (final ConjunctiveQuery rw : rewriitngs) {
					final IOperator root = LAPlanBuilder.constructPlan(rw);
					NaiveCostEstimator estimator = null;
					estimator = new NaiveCostEstimator();
					if (root instanceof UnaryOperator) {
						estimator.visit((UnaryOperator) root, null);

					}
					if (root instanceof BinaryOperator) {
						estimator.visit((BinaryOperator) root, null);

					}
					double currentCost = estimator.getEstimatedCost();
					if (currentCost <= minCost) {
						minCost = currentCost;
						minRW = rw;
					}
				}

			}
			long endTime = System.nanoTime();

			LOGGER.debug("Time:- " + (((endTime - startTime) / 10) * 1e-9));
			LOGGER.debug(minRW);

		} catch (IOException | ParseException e) {
			throw new RuntimeException(e);
		}
	}
}