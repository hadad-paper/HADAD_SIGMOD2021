package hadad.base.rewriting.decoder.nm;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import hadad.commons.conjunctivequery.parser.ParseException;
import hadad.base.compiler.Utils;
import hadad.base.rewriting.decoder.nm.NMTranslator;

/**
 * NM Translator Test
 * 
 *  
 *
 */
public class NMDecoderTest {
    final static Logger LOGGER = Logger.getLogger(NMDecoderTest.class);
    final static String TEST_DIR = "/compiler/nm-decoder";

    /**
     * Get all tests directories
     * 
     * @return List<File>
     */
    private List<File> getTestsDirectories() {
        final File directory = new File(NMDecoderTest.class.getResource(TEST_DIR).toString().substring(5));

        LOGGER.debug("Test home path: " + directory.toString());

        final List<File> testsDirectory = new ArrayList<File>();
        for (final File file : directory.listFiles()) {
            if (file.isDirectory()) {
                testsDirectory.add(file);
            }
        }
        return testsDirectory;
    }

    /**
     * Get test rewriting
     * 
     * @param testDirectory
     * @return file
     * @throws IOException
     */
    private File getTestRewriting(final File testDirectory) throws IOException {
        for (final File file : testDirectory.listFiles()) {
            if (file.isFile() && file.getName().equals("rewriting")) {
                return file;
            }
        }
        throw new IOException("Rewriting file not found.");
    }

    /**
     * Get test translated rewriting
     * 
     * @param testDirectory
     * @return file
     * @throws IOException
     */
    private File getTestTranslatedRewriitng(final File testDirectory) throws IOException {
        for (final File file : testDirectory.listFiles()) {
            if (file.isFile() && file.getName().equals("translatedrewriting")) {
                return file;
            }
        }
        throw new IOException("Translated Rewriting file not found.");
    }

    @Test
    public void test() {
        getTestsDirectories().stream().forEach(f -> test(f));
    }

    public void test(final File testDirectory) {
        LOGGER.debug("Testing " + testDirectory.toString());
        File inputRewritingFile;
        File translatedRewritingFile;
        try {
            inputRewritingFile = getTestRewriting(testDirectory);
            translatedRewritingFile = getTestTranslatedRewriitng(testDirectory);
            final NMTranslator rTranslator = new NMTranslator(Utils.parseQuery(inputRewritingFile));
            final String translatedRewriting1 = rTranslator.translate();
            final BufferedReader translatedRewriitng = new BufferedReader(new FileReader(translatedRewritingFile));
            final String translatedRewriting2 = IOUtils.toString(translatedRewriitng);
            assertEquals(translatedRewriting1, translatedRewriting2);
        } catch (IllegalArgumentException | ParseException | IOException e) {
            LOGGER.error(e.getMessage());
        }
    }
}
