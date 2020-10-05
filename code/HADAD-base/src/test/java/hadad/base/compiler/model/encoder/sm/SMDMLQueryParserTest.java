package hadad.base.compiler.model.encoder.sm;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import hadad.base.compiler.model.sm.DMLBaseListener;
import hadad.base.compiler.model.sm.DMLLexer;
import hadad.base.compiler.model.sm.DMLParser;
import hadad.base.compiler.AntlrUtils;

/**
 * SMDMLQueryParserTest
 * 
 *   
 *
 */
public final class SMDMLQueryParserTest extends DMLBaseListener {
    private static final String TESTS_DIR = "/compiler/sm-encoder";
    private static final Logger LOGGER = Logger.getLogger(SMDMLQueryParserTest.class);

    /**
     * Get test query
     * 
     * @param testDirectory
     * @return file
     * @throws IOException
     */
    private File getTestQuery(final File testDirectory) throws IOException {
        for (final File file : testDirectory.listFiles()) {
            if (file.isFile() && file.getName().equals("query")) {
                return file;
            }
        }
        throw new IOException("Query file not found.");
    }

    /**
     * Get all tests directories
     * 
     * @return List<File>
     */
    private List<File> getTestsDirectories() {
        final File directory = new File(SMDMLQueryParserTest.class.getResource(TESTS_DIR).toString().substring(5));

        LOGGER.debug("Test home path: " + directory.toString());

        final List<File> testsDirectory = new ArrayList<File>();
        for (final File file : directory.listFiles()) {
            if (file.isDirectory()) {
                testsDirectory.add(file);
            }
        }
        return testsDirectory;
    }

    @Test
    public void test() {
        getTestsDirectories().stream().forEach(f -> test(f));
    }

    /**
     * Perform the test
     * 
     * @param testDirectory
     */
    private void test(final File testDirectory) {
        LOGGER.debug("Testing " + testDirectory.toString());
        try {
            final String query = FileUtils.readFileToString(getTestQuery(testDirectory));
            final DMLLexer lexer = new DMLLexer(CharStreams.fromString(query));
            final CommonTokenStream tokens = new CommonTokenStream(lexer);
            final DMLParser parser = new DMLParser(tokens);
            final ParserRuleContext tree = parser.dmlQuery();
            final ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(this, tree);
            LOGGER.debug("\n \n" + AntlrUtils.getFullText(tree));
            assertTrue(query.equals(AntlrUtils.getFullText(tree)));
        } catch (IllegalStateException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}
