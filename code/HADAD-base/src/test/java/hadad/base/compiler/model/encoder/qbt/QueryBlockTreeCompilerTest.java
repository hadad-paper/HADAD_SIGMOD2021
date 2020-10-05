package hadad.base.compiler.model.encoder.qbt;

import static java.sql.Types.VARCHAR;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
import hadad.base.compiler.model.pr.Relation;
import hadad.base.compiler.model.qbt.QBTQueryBlockTreeBuilder;
import hadad.base.rewriter.ConjunctiveQueryRewriter;
import hadad.base.test.framework.AbstractQueryBlockTreeCompilerTest;
import hadad.base.compiler.QueryBlockTree;
import hadad.base.compiler.Utils;

public abstract class QueryBlockTreeCompilerTest extends AbstractQueryBlockTreeCompilerTest {
    private final static String TESTS_DIR = "/compiler/qbt-encoder";
    private static final Logger LOGGER = Logger.getLogger(QueryBlockTreeCompilerTest.class);

    protected abstract ConjunctiveQuery restrict(final ConjunctiveQuery query);

    private File getTestQuery(final File testDirectory) throws IOException {
        for (final File file : testDirectory.listFiles()) {
            if (file.isFile() && file.getName().equals("query")) {
                return file;
            }
        }
        throw new IOException("Query file not found.");
    }

    private List<File> getTestReformulations(final File testDirectory) throws IOException {
        final List<File> reformulationsFiles = new ArrayList<>();
        for (final File file : testDirectory.listFiles()) {
            if (file.isFile() && file.getName().startsWith("reformulations")) {
                reformulationsFiles.add(file);
            }
        }
        if (!reformulationsFiles.isEmpty())
            return reformulationsFiles;
        else
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
        final File directory =
                new File(QueryBlockTreeCompilerTest.class.getResource(TESTS_DIR).toString().substring(5));
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

    private void test(final File testDirectory) {
        LOGGER.debug("Testing " + testDirectory.toString());
        ConjunctiveQuery query;
        try {
            query = Utils.parseQuery(getTestQuery(testDirectory));
        } catch (IllegalArgumentException | ParseException | IOException e) {

            throw new RuntimeException(e.getMessage());
        }
        final Collection<ConjunctiveQuery> expectedReformulations = new ArrayList<>();
        try {
            final List<File> expectedReformulationsFiles = getTestReformulations(testDirectory);
            for (File expectedReformulationsFile : expectedReformulationsFiles) {
                expectedReformulations.addAll(Utils.parseQueries(expectedReformulationsFile));;
            }
        } catch (ParseException | IOException e) {
            throw new RuntimeException(e);
        }
        final List<QueryBlockTree> views = new ArrayList<QueryBlockTree>();
        for (final File view : getTestViews(testDirectory)) {
            try {
                QBTQueryBlockTreeBuilder mixedBuilder = (QBTQueryBlockTreeBuilder) builder;
                mixedBuilder
                        .setRealtions(relations(testDirectory.getName().charAt(testDirectory.getName().length() - 1)));
                QueryBlockTree nbt = mixedBuilder.buildQueryBlockTree(FileUtils.readFileToString(view));
                views.add(nbt);
                QBTQueryBlockTreeBuilder.reIntilize();
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
                    throw new RuntimeException("Single reformulation expected rewritings.");
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

    private Map<String, Relation> relations(char realtionNumber) {
        Map<String, Relation> Relations = new HashMap<String, Relation>();
        switch (realtionNumber) {

            case '1':
            case '2':
            case '3':
            case '4':
                Relations.put("artist",
                        new Relation("artist", Arrays.asList(new String[] { "id", "gender", "area", "name" }),
                                Arrays.asList(new Integer[] { VARCHAR, VARCHAR, VARCHAR, VARCHAR })));
                Relations.put("area", new Relation("area", Arrays.asList(new String[] { "type", "id", "name" }),
                        Arrays.asList(new Integer[] { VARCHAR, VARCHAR, VARCHAR })));
                Relations.put("area_type", new Relation("area_type", Arrays.asList(new String[] { "id", "name" }),
                        Arrays.asList(new Integer[] { VARCHAR, VARCHAR })));
                Relations.put("gender", new Relation("gender", Arrays.asList(new String[] { "id", "name" }),
                        Arrays.asList(new Integer[] { VARCHAR, VARCHAR })));
                Relations.put("artist_credit_name",
                        new Relation("artist_credit_name", Arrays.asList(new String[] { "artist", "artist_credit" }),
                                Arrays.asList(new Integer[] { VARCHAR, VARCHAR })));
                Relations.put("artist_credit",
                        new Relation("artist_credit", Arrays.asList(new String[] { "artist_credit_id", "id" }),
                                Arrays.asList(new Integer[] { VARCHAR, VARCHAR })));
                Relations.put("recording",
                        new Relation("recording", Arrays.asList(new String[] { "name", "artist_credit", "id" }),
                                Arrays.asList(new Integer[] { VARCHAR, VARCHAR, VARCHAR })));
                Relations.put("track",
                        new Relation("track", Arrays.asList(new String[] { "recording", "medium", "name" }),
                                Arrays.asList(new Integer[] { VARCHAR, VARCHAR, VARCHAR })));
                Relations.put("medium",
                        new Relation("medium", Arrays.asList(new String[] { "id", "release", "format" }),
                                Arrays.asList(new Integer[] { VARCHAR, VARCHAR, VARCHAR })));
                Relations.put("medium_format",
                        new Relation("medium_format", Arrays.asList(new String[] { "name", "id" }),
                                Arrays.asList(new Integer[] { VARCHAR, VARCHAR })));
                Relations.put("release",
                        new Relation("release",
                                Arrays.asList(new String[] { "id", "name", "artist_credit", "language" }),
                                Arrays.asList(new Integer[] { VARCHAR, VARCHAR, VARCHAR, VARCHAR })));
                Relations.put("language", new Relation("language", Arrays.asList(new String[] { "id", "iso_code" }),
                        Arrays.asList(new Integer[] { VARCHAR, VARCHAR })));
                break;

            default:
                Relations = null;

        }

        return Relations;
    }
}
