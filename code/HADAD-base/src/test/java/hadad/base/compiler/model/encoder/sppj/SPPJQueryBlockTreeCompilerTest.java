package hadad.base.compiler.model.encoder.sppj;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.junit.Test;

import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.conjunctivequery.parser.ParseException;
import hadad.base.rewriter.ConjunctiveQueryRewriter;
import hadad.base.test.framework.AbstractQueryBlockTreeCompilerTest;
import hadad.base.compiler.QueryBlockTree;
import hadad.base.compiler.Utils;

/**
 * SPPJ NestedBlockTreeCompilerTest
 * 
 *   
 *
 */
public abstract class SPPJQueryBlockTreeCompilerTest extends AbstractQueryBlockTreeCompilerTest {
    private static final String TESTS_DIR = "/compiler/sppj-encoder";
    private static final Logger LOGGER = Logger.getLogger(SPPJQueryBlockTreeCompilerTest.class);

    protected abstract ConjunctiveQuery restrict(final ConjunctiveQuery query);

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
     * Get test reformulation
     * 
     * @param testDirectory
     * @return file
     * @throws IOException
     */
    private File getTestReformulations(final File testDirectory) throws IOException {
        for (final File file : testDirectory.listFiles()) {
            if (file.isFile() && file.getName().equals("reformulations")) {
                return file;
            }
        }
        throw new IOException("Reformulations file not found.");
    }

    /**
     * Get test views to be encoded
     * 
     * @param testDirectory
     * @return viewFiles
     */
    private List<File> getTestViews(final File testDirectory) {
        final List<File> viewFiles = new ArrayList<File>();
        for (final File file : testDirectory.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".view")) {
                viewFiles.add(file);
            }
        }
        return viewFiles;
    }

    /**
     * Get all tests directories
     * 
     * @return List<File>
     */
    private List<File> getTestsDirectories() {
        final File directory =
                new File(SPPJQueryBlockTreeCompilerTest.class.getResource(TESTS_DIR).toString().substring(5));

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
        ConjunctiveQuery query;
        try {
            query = Utils.parseQuery(getTestQuery(testDirectory));
            LOGGER.debug("Query :" + query.toString());
        } catch (IllegalArgumentException | ParseException | IOException e) {
            throw new RuntimeException(e);
        }
        Collection<ConjunctiveQuery> expectedReformulations;
        try {
            expectedReformulations = Utils.parseQueries(getTestReformulations(testDirectory));
        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
        final List<QueryBlockTree> views = new ArrayList<QueryBlockTree>();
        for (final File view : getTestViews(testDirectory)) {
            try {
                views.add(builder.buildQueryBlockTree(FileUtils.readFileToString(view)));
            } catch (hadad.base.compiler.exceptions.ParseException | IOException e) {
                throw new RuntimeException(e);
            }
        }

        final List<ConjunctiveQueryRewriter> rewriters = createRewriters(views);
        final Iterator<ConjunctiveQueryRewriter> it = rewriters.iterator();
        List<ConjunctiveQuery> reformulations = new ArrayList<ConjunctiveQuery>();
        while (it.hasNext()) {
            final ConjunctiveQueryRewriter rewriter = it.next();
            try {
                reformulations = rewriter.getReformulations(query);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            LOGGER.debug("Reformulation: " + reformulations.toString());
            if (it.hasNext()) {
                if (reformulations.isEmpty()) {
                    LOGGER.debug("The expected and current reformulations mismatch.");
                    LOGGER.debug("Expected: " + expectedReformulations.toString());
                    LOGGER.debug("Current: " + reformulations.toString());
                    assertTrue(expectedReformulations.isEmpty());
                } else if (reformulations.size() == 1) {
                    query = reformulations.get(0);
                } else {
                    throw new RuntimeException("Single reformulation expected on intermediate rewritings.");
                }
            }
        }
        final boolean areEquivalent =
                areEquivalent(reformulations, new ArrayList<ConjunctiveQuery>(expectedReformulations));
        if (!areEquivalent) {
            LOGGER.debug("The expected and current reformulations mismatch.");
            LOGGER.debug("Expected: " + expectedReformulations.toString());
            LOGGER.debug("Current: " + reformulations.toString());
        }
        assertTrue(areEquivalent);
    }

    /**
     * Check whether two rewritings are equivalent
     * 
     * @param reformulations
     * @param expectedReformulations
     * @return boolean
     */
    private boolean areEquivalent(final List<ConjunctiveQuery> reformulations,
            final List<ConjunctiveQuery> expectedReformulations) {
        if (reformulations.size() != expectedReformulations.size()) {
            return false;
        }
        final Map<Integer, Integer> mapping = new HashMap<Integer, Integer>();
        int i = 0;
        for (final ConjunctiveQuery reformulation : reformulations) {
            final Integer pos = mapping(restrict(reformulation), expectedReformulations, mapping);
            if (pos == null) {
                return false;
            } else {
                mapping.put(i, pos);
            }
            i++;
        }
        return true;
    }

    private Integer mapping(final ConjunctiveQuery reformulation, final List<ConjunctiveQuery> expectedReformulations,
            final Map<Integer, Integer> mapping) {
        for (Integer i = 0; i < expectedReformulations.size(); i++) {
            if (!mapping.values().contains(i) && reformulation.isEquivalent(expectedReformulations.get(i))) {
                return i;
            }
        }
        return null;
    }
}
