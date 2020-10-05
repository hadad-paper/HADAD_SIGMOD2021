package hadad.base.compiler.model.encoder.xq;

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
import org.junit.Test;

import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.conjunctivequery.parser.ParseException;
import hadad.base.rewriter.ConjunctiveQueryRewriter;
import hadad.base.test.framework.AbstractQueryBlockTreeCompilerTest;
import hadad.base.compiler.QueryBlockTree;
import hadad.base.compiler.Utils;

public abstract class XQQueryBlockTreeCompilerTest extends AbstractQueryBlockTreeCompilerTest {

    private File getTestQuery(final File testDirectory) throws IOException {
        for (final File file : testDirectory.listFiles()) {
            if (file.isFile() && file.getName().equals("query")) {
                return file;
            }
        }
        throw new IOException("Query file not found.");
    }

    private File getTestReformulations(final File testDirectory) throws IOException {
        for (final File file : testDirectory.listFiles()) {
            if (file.isFile() && file.getName().equals("reformulations")) {
                return file;
            }
        }
        throw new IOException("Reformulations file not found.");
    }

    private List<File> getTestViews(final File testDirectory) {
        final List<File> viewFiles = new ArrayList<File>();
        for (final File file : testDirectory.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".view")) {
                viewFiles.add(file);
            }
        }
        return viewFiles;
    }

    private List<File> getTestsDirectories() {
        final String TESTS_DIR = "/compiler/xq-encoder";
        final File directory =
                new File(XQQueryBlockTreeCompilerTest.class.getResource(TESTS_DIR).toString().substring(5));

        System.out.println("Test home path: " + directory.toString());

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

    private void test(final File testDirectory) {
        System.out.println("Testing " + testDirectory.toString());
        ConjunctiveQuery query;
        try {
            query = Utils.parseQuery(getTestQuery(testDirectory));
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
            if (it.hasNext()) {
                if (reformulations.isEmpty()) {
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
            System.out.println("The expected and current reformulations mismatch.");
            System.out.println("Expected: " + expectedReformulations.toString());
            System.out.println("Current: " + reformulations.toString());
        }
        assertTrue(areEquivalent);
    }

    private boolean areEquivalent(final List<ConjunctiveQuery> reformulations,
            final List<ConjunctiveQuery> expectedReformulations) {
        if (reformulations.size() != expectedReformulations.size()) {
            return false;
        }
        final Map<Integer, Integer> mapping = new HashMap<Integer, Integer>();
        int i = 0;
        for (final ConjunctiveQuery reformulation : reformulations) {
            final Integer pos = mapping(reformulation, expectedReformulations, mapping);
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
