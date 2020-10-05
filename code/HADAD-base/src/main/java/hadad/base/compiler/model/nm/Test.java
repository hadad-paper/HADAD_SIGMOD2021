package hadad.base.compiler.model.nm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

import hadad.base.compiler.model.la.builder.estim.MatrixBlock;
import hadad.base.compiler.model.la.builder.estim.MatrixHistogram;
import hadad.base.compiler.model.la.metadata.Metadata;
import hadad.base.loader.DataLoaderCSV;
import hadad.base.loader.DataLoaderMTX;
import hadad.base.loader.Serializer;
import hadad.base.rewriting.decoder.nm.NMGen;
import hadad.base.rewriting.decoder.rm.RMGen;

public class Test {
	private static final Logger LOGGER = Logger.getLogger(Test.class);
	private static final String BASE_DIR = "src/main/resources/testsLA1";
	private static final String TEST_DATA_Syn = "../../data/synthetic/";
	private static final String TEST_DATA_Views = "../../data/views/";
	private static final String TEST_DATA_Real = "../../data/real-data/";
	private static final int ESTIM =1;

	public static void main(String[] args) throws Exception {
		BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/testsLA1/out.out", true));
		switch (ESTIM) {
		case 1:
			naiveInt();
			break;
		default:
			MNCInt();
		}
		for (File file : getTestsDirectories()) {	
			LOGGER.debug("Test file: " + file.getName());				
			if(file.getName().equals("P2.25")||file.getName().equals("P2.27")||file.getName().equals("P2.21")) {
				continue;
			}
			TestWrapper test = new TestWrapper(file.getAbsolutePath(), ESTIM);
			test.runTest();
			System.out.println("RW:- " + test.getRW());
			System.out.println("Time:- " + test.getTime());
			writer.write(file.getName()+" : "+ test.getTime()+"\n");
			writer.write(file.getName()+" : "+ test.getRW()+"\n");
			NMGen.run(file.getName(), test.getRW());
		}
		writer.close();
	}

	private static List<File> getTestsDirectories() {
		final File directory = new File(BASE_DIR);
		LOGGER.debug("Test home path: " + directory.toString());
		final List<File> testsDirectory = new ArrayList<File>();
		for (final File file : directory.listFiles()) {
			if (file.isDirectory()) {
				testsDirectory.add(file);
			}
		}
		return testsDirectory;
	}

	private static void naiveInt() throws IOException {
		initializeMeta();
	}

	private static void MNCInt() throws Exception {
		initializeMeta();
		File[] testFilesSyn = new File(TEST_DATA_Syn).listFiles();
		for (final File file : testFilesSyn) {
			if (file.getName().contains(".csv")) {
				if (file.getName().contains("V4.csv")){
					continue;
				}
				final MatrixBlock data = DataLoaderCSV.load(file);
				final MatrixHistogram histogram = new MatrixHistogram(data, true);
				final String serPath = Files.createTempDirectory("TempFolder").resolve(file.getName()).toString();				
				Metadata.instance.update(file.getName().trim(), serPath);
				Metadata.instance.write();
				Serializer.serialize(serPath, histogram);
				Metadata.load();
			}
		}
		File[] testFilesReal = new File(TEST_DATA_Real).listFiles();
		for (final File file : testFilesReal) {
			if (file.getName().contains("AL3.mtx") || file.getName().contains("AL2.mtx") ||   file.getName().contains("NL2.mtx")){
				continue;
			}
			if (file.getName().contains(".mtx")) {
				LOGGER.debug(file.getName());
				final MatrixBlock data = DataLoaderMTX.load(file);
				final MatrixHistogram histogram = new MatrixHistogram(data, true);
				final String serPath = Files.createTempDirectory("TempFolder").resolve(file.getName()).toString();
				Metadata.instance.update(file.getName(), serPath);
				Metadata.instance.write();
				Serializer.serialize(serPath, histogram);
				Metadata.load();
			}
		}
		
		File[] testFileViews = new File(TEST_DATA_Views).listFiles();
		for (final File file : testFileViews) {
			if (file.getName().contains(".csv")) {
				LOGGER.debug(file.getName());
				final MatrixBlock data = DataLoaderCSV.load(file);
				final MatrixHistogram histogram = new MatrixHistogram(data, true);
				final String serPath = Files.createTempDirectory("TempFolder").resolve(file.getName()).toString();
				Metadata.instance.update(file.getName(), serPath);
				Metadata.instance.write();
				Serializer.serialize(serPath, histogram);
				Metadata.load();
			}
		}
	}
	private static void initializeMeta () throws IOException {
		Metadata.load();
		Metadata.getInstance();
		Metadata.instance.delete();
		Metadata.instance.add("syn1.csv", 50000, 100, 5000000, "");
		Metadata.instance.add("syn2.csv", 100, 50000, 5000000, "");
		Metadata.instance.add("syn3a.csv", 1000000, 100, 100000000, "");
		Metadata.instance.add("syn3b.csv", 1000000, 100, 100000000, "");
		Metadata.instance.add("syn4a.csv", 5000000, 100, 100000000, "");
		Metadata.instance.add("syn4b.csv", 5000000, 100, 100000000, "");
		Metadata.instance.add("syn5c.csv", 10000, 10000, 100000000, "");
		Metadata.instance.add("syn5d.csv", 10000, 10000, 100000000, "");
		Metadata.instance.add("syn5e.csv", 10000, 10000, 100000000, "");
		Metadata.instance.add("syn6c.csv", 20000, 20000, 400000000, "");
		Metadata.instance.add("syn6d.csv", 20000, 20000, 400000000, "");
		Metadata.instance.add("syn6e.csv", 20000, 20000, 400000000, "");
		Metadata.instance.add("syn7.csv", 100, 1, 100, "");
		Metadata.instance.add("syn8.csv", 50000, 1, 50000, "");
		Metadata.instance.add("syn9.csv", 100000, 1, 100000, "");
		Metadata.instance.add("syn10.csv", 100, 100, 10000, "");
		Metadata.instance.add("AS.mtx", 50000, 100, 5000000, "");
		
		Metadata.instance.add("V1.csv", 10000, 10000, 100000000, "");
		Metadata.instance.add("V2.csv", 10000, 10000, 100000000, "");
		Metadata.instance.add("V3.csv", 100, 100, 10000, "");
		Metadata.instance.add("V4.csv", 100000, 50000, 2000000000, "");//5B > INTEGER.max. So far put it as 2000000000.
		Metadata.instance.add("V5A.csv", 10000, 10000, 100000000, "");
		Metadata.instance.add("V5B.csv", 20000, 20000, 400000000, "");
		Metadata.instance.add("V6A.csv", 1000000, 100, 100000000, "");
		Metadata.instance.add("V6B.csv", 5000000, 100, 500000000, "");
		Metadata.instance.add("V7.csv", 10000, 10000, 100000000, "");
		Metadata.instance.add("V8A.csv", 10000, 10000, 100000000, "");
		Metadata.instance.add("V8B.csv", 10000, 10000, 100000000, "");
		Metadata.instance.add("V9.csv", 10000, 10000, 100000000, "");
		Metadata.instance.add("V10.csv", 1, 1, 1, "");
		Metadata.instance.add("V11.csv", 1, 1, 1, "");
		Metadata.instance.add("V12A.csv", 1000000, 100, 100000000, "");
		Metadata.instance.add("V12B.csv", 5000000, 100, 500000000, "");
	}

}
