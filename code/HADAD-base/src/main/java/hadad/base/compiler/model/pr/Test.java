package hadad.base.compiler.model.pr;

import static java.sql.Types.VARCHAR;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.google.inject.Guice;
import com.google.inject.Injector;

import hadad.commons.relationalschema.RelationalSchema;
import hadad.base.rewriter.ConjunctiveQueryRewriter;
import hadad.base.rewriter.Context;
import hadad.base.rewriter.PACBConjunctiveQueryRewriter;
import hadad.base.rewriter.TimedReformulations;
import hadad.base.compiler.QueryBlockTree;
import hadad.base.compiler.Utils;

/*PR Temp test */
public class Test {
    private static final int COMPILER = 1;
    private static final Logger log = Logger.getLogger(Test.class);
    private static final int TESTNUMBER = 1;
    private static Injector INJECTOR = null;

    public static void main(String[] args) throws Exception {

        switch (COMPILER) {
            case 1:
                INJECTOR = Guice.createInjector(new PRNaiveModule());
                break;

        }
        switch (TESTNUMBER) {
            case 1:
                test1();
                break;
        }

    }

    static void test1()
            throws IllegalArgumentException, hadad.commons.conjunctivequery.parser.ParseException, Exception {

        final String OUTPUT_FORWARD_CONSTRAINTS_FILE = "src/main/resources/testPR/constraints_chase";
        final String OUTPUT_BACKWARD_CONSTRAINTS_FILE = "src/main/resources/testPR/constraints_bkchase";
        final String OUTPUT_SCHEMA_FILE = "src/main/resources/testPR/schemas";
        final String INPUT_QUERY_FILE = "src/main/resources/testPR/v.view";

        PRQueryBlockTreeBuilderAlternative builder = INJECTOR.getInstance(PRQueryBlockTreeBuilderAlternative.class);

        Map<String, Relation> Relations = new HashMap<String, Relation>();
        Relations.put("r", new Relation("r", Arrays.asList(new String[] { "ID", "name" }),
                Arrays.asList(new Integer[] { VARCHAR, VARCHAR })));

        Relations.put("s", new Relation("s", Arrays.asList(new String[] { "ID", "Z" }),
                Arrays.asList(new Integer[] { VARCHAR, VARCHAR })));
        builder.setRelations(Relations);

        final QueryBlockTree qbt = builder.buildQueryBlockTree(FileUtils.readFileToString(new File(INPUT_QUERY_FILE)));
        System.out.println(qbt.toString());

        PRQueryBlockTreeCompiler compiler0 = INJECTOR.getInstance(PRQueryBlockTreeCompiler.class);
        Context context = compiler0.compileContext(qbt,
                new RelationalSchema(new ArrayList<hadad.commons.relationalschema.Relation>()), true);

        Utils.writeConstraints(OUTPUT_FORWARD_CONSTRAINTS_FILE, context.getForwardConstraints());
        Utils.writeConstraints(OUTPUT_BACKWARD_CONSTRAINTS_FILE, context.getBackwardConstraints());
        Utils.writeSchemas(OUTPUT_SCHEMA_FILE, context.getGlobalSchema(), context.getTargetSchema());

        final Context context01 = hadad.base.rewriter.server.Utils.parseContext(OUTPUT_SCHEMA_FILE,
                OUTPUT_FORWARD_CONSTRAINTS_FILE, OUTPUT_BACKWARD_CONSTRAINTS_FILE);
        final ConjunctiveQueryRewriter rewriter = new PACBConjunctiveQueryRewriter(context01);
        final BufferedReader query = new BufferedReader(new FileReader(new File("src/main/resources/testPR/query")));
        final TimedReformulations timedRewritings = rewriter.getTimedReformulations(
                hadad.base.rewriter.server.Utils.parseQuery(IOUtils.toString(query)));
        System.out.println(timedRewritings.getRewritings());
    }
}
