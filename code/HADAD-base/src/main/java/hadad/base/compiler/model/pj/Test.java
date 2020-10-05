package hadad.base.compiler.model.pj;

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
import hadad.base.compiler.model.pj.naive.PJNaiveModule;
import hadad.base.compiler.model.pj.naive.PJNaiveQueryBlockTreeCompiler;
import hadad.base.rewriter.ConjunctiveQueryRewriter;
import hadad.base.rewriter.Context;
import hadad.base.rewriter.PACBConjunctiveQueryRewriter;
import hadad.base.rewriter.TimedReformulations;
import hadad.base.compiler.QueryBlockTree;
import hadad.base.compiler.Utils;

public class Test {
    private static final Logger LOGGER = Logger.getLogger(Test.class);
    private static final String OUTPUT_FORWARD_CONSTRAINTS_FILE = "src/main/resources/testPJ/constraints_chase";
    private static final String OUTPUT_BACKWARD_CONSTRAINTS_FILE = "src/main/resources/testPJ/constraints_bkchase";
    private static final String OUTPUT_SCHEMA_FILE = "src/main/resources/testPJ/schemas";
    private static final String INPUT_QUERY_FILE = "src/main/resources/testPJ/v.view";

    private static final int COMPILER = 0;

    public static void main(String[] args) throws Exception {
        Injector injector = null;
        switch (COMPILER) {
            case 0:
                injector = Guice.createInjector(new PJNaiveModule());
                break;
        }

        PJQueryBlockTreeBuilder builder = injector.getInstance(PJQueryBlockTreeBuilder.class);
        final QueryBlockTree qbt = builder.buildQueryBlockTree(FileUtils.readFileToString(new File(INPUT_QUERY_FILE)));
        LOGGER.debug(qbt.toString());
        Context context = null;
        switch (COMPILER) {
            case 0:
                PJNaiveQueryBlockTreeCompiler compiler0 = injector.getInstance(PJNaiveQueryBlockTreeCompiler.class);
                context = compiler0.compileContext(qbt, new RelationalSchema(new ArrayList<Relation>()), true);
                break;
        }

        LOGGER.debug(context.getForwardConstraints());
        LOGGER.debug(context.getBackwardConstraints());

        Utils.writeConstraints(OUTPUT_FORWARD_CONSTRAINTS_FILE, context.getForwardConstraints());
        Utils.writeConstraints(OUTPUT_BACKWARD_CONSTRAINTS_FILE, context.getBackwardConstraints());
        Utils.writeSchemas(OUTPUT_SCHEMA_FILE, context.getGlobalSchema(), context.getTargetSchema());
        Utils.writeConstraints(OUTPUT_FORWARD_CONSTRAINTS_FILE, context.getForwardConstraints());
        Utils.writeConstraints(OUTPUT_BACKWARD_CONSTRAINTS_FILE, context.getBackwardConstraints());
        Utils.writeSchemas(OUTPUT_SCHEMA_FILE, context.getGlobalSchema(), context.getTargetSchema());

        final Context context01 = hadad.base.rewriter.server.Utils.parseContext(OUTPUT_SCHEMA_FILE,
                OUTPUT_FORWARD_CONSTRAINTS_FILE, OUTPUT_BACKWARD_CONSTRAINTS_FILE);
        final ConjunctiveQueryRewriter rewriter = new PACBConjunctiveQueryRewriter(context01);
        final BufferedReader query = new BufferedReader(new FileReader(new File("src/main/resources/testPJ/query")));
        final TimedReformulations timedRewritings = rewriter.getTimedReformulations(
                hadad.base.rewriter.server.Utils.parseQuery(IOUtils.toString(query)));
        System.out.println(timedRewritings.getRewritings());
    }
}
