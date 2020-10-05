package hadad.base.compiler.model.rk;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.google.inject.Guice;
import com.google.inject.Injector;

import hadad.commons.relationalschema.Relation;
import hadad.commons.relationalschema.RelationalSchema;
import hadad.base.compiler.QueryBlockTree;
import hadad.base.compiler.model.rk.naive.RKNaiveModule;
import hadad.base.compiler.model.rk.naive.RKNaiveQueryBlockTreeCompiler;
import hadad.base.rewriter.ConjunctiveQueryRewriter;
import hadad.base.rewriter.Context;
import hadad.base.rewriter.PACBConjunctiveQueryRewriter;
import hadad.base.rewriter.TimedReformulations;

public class Test {
    private static final String OUTPUT_FORWARD_CONSTRAINTS_FILE = "src/main/resources/testRK/constraints_chase";
    private static final String OUTPUT_BACKWARD_CONSTRAINTS_FILE = "src/main/resources/testRK/constraints_bkchase";
    private static final String OUTPUT_SCHEMA_FILE = "src/main/resources/testRK/schemas";
    private static final String INPUT_QUERY_FILE = "src/main/resources/testRK/v.view";
    private static final int COMPILER = 1;
    private static final Logger log = Logger.getLogger(Test.class);

    public static void main(String[] args) throws Exception {
        Injector injector = null;
        switch (COMPILER) {
            case 1:
                injector = Guice.createInjector(new RKNaiveModule());
                break;

        }

        RKQueryBlockTreeBuilder builder = injector.getInstance(RKQueryBlockTreeBuilder.class);
        final QueryBlockTree nbt = builder.buildQueryBlockTree(FileUtils.readFileToString(new File(INPUT_QUERY_FILE)));
        System.out.println(nbt.toString());
        Context context = null;

        switch (COMPILER) {
            case 1:
                RKNaiveQueryBlockTreeCompiler compiler0 = injector.getInstance(RKNaiveQueryBlockTreeCompiler.class);
                context = compiler0.compileContext(nbt, new RelationalSchema(new ArrayList<Relation>()), true);
                break;
        }
        final Context context01 = hadad.base.rewriter.server.Utils.parseContext(OUTPUT_SCHEMA_FILE,
                OUTPUT_FORWARD_CONSTRAINTS_FILE, OUTPUT_BACKWARD_CONSTRAINTS_FILE);
        final ConjunctiveQueryRewriter rewriter = new PACBConjunctiveQueryRewriter(context01);
        final BufferedReader query = new BufferedReader(new FileReader(new File("src/main/resources/testRK/query")));
        final TimedReformulations timedRewritings = rewriter.getTimedReformulations(
                hadad.base.rewriter.server.Utils.parseQuery(IOUtils.toString(query)));
        System.out.println(timedRewritings.getRewritings());
    }
}
