package hadad.base.compiler.model.la.builder.estim;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.log4j.Logger;
import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.conjunctivequery.parser.ParseException;
import hadad.base.compiler.Utils;
import hadad.base.compiler.model.la.builder.BinaryOperator;
import hadad.base.compiler.model.la.builder.IOperator;
import hadad.base.compiler.model.la.builder.LAPlanBuilder;
import hadad.base.compiler.model.la.builder.UnaryOperator;
import hadad.base.compiler.model.la.metadata.Metadata;
import hadad.base.loader.DataLoaderCSV;
import hadad.base.loader.DataLoaderMTX;
import hadad.base.loader.Serializer;

public class TestMNC {

	private static final Logger LOGGER = Logger.getLogger(TestMNC.class);
	private static final String TEST_DIR = "src/test/resources/lapipes/";
	private static final String TEST_DATA_Syn = "../../data/test/synthetic/";
	private static final String TEST_DATA_Real = "../../data/test/real-data/";


	public static void main(String args[]) throws Exception {
		Metadata.getInstance();
		Metadata.instance.delete();
		File[] testFilesSyn = new File(TEST_DATA_Syn).listFiles();
		for (final File file : testFilesSyn) {
				final MatrixBlock data = DataLoaderCSV.load(file);
				final MatrixHistogram histogram = new MatrixHistogram(data, true);
				final String serPath = Files.createTempDirectory("TempFolder").resolve(file.getName()).toString();
				Metadata.instance.add(file.getName(), 0, 0, 0, serPath);
				Metadata.instance.write();
				Serializer.serialize(serPath, histogram);
				Metadata.load();		
		}
		File[] testFilesReal = new File(TEST_DATA_Real).listFiles();
		for (final File file : testFilesReal) {
				final MatrixBlock data = DataLoaderMTX.load(file);
				final MatrixHistogram histogram = new MatrixHistogram(data, true);
				final String serPath = Files.createTempDirectory("TempFolder").resolve(file.getName()).toString();
				Metadata.instance.add(file.getName(), 0, 0, 0, serPath);
				Metadata.instance.write();
				Serializer.serialize(serPath, histogram);
				Metadata.load();
		}
			
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
				MNCCostEstimator estimator = null;
				estimator = new MNCCostEstimator();
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
					MNCCostEstimator estimator = null;
					estimator = new MNCCostEstimator();
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
