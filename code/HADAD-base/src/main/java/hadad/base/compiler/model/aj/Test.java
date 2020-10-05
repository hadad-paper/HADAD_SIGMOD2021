package hadad.base.compiler.model.aj;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.google.inject.Guice;
import com.google.inject.Injector;

import hadad.commons.relationalschema.Relation;
import hadad.commons.relationalschema.RelationalSchema;
import hadad.base.rewriter.ConjunctiveQueryRewriter;
import hadad.base.rewriter.Context;
import hadad.base.rewriter.PACBConjunctiveQueryRewriter;
import hadad.base.rewriter.TimedReformulations;
import hadad.base.compiler.QueryBlockTree;
import hadad.base.compiler.Utils;
import hadad.base.compiler.model.aj.naive.AJNaiveModule;
import hadad.base.compiler.model.aj.naive.AJNaiveQueryBlockTreeCompiler;

/* AJ Simple Test */
public class Test {
    private static final String OUTPUT_FORWARD_CONSTRAINTS_FILE = "src/main/resources/testAJ/constraints_chase";
    private static final String OUTPUT_BACKWARD_CONSTRAINTS_FILE = "src/main/resources/testAJ/constraints_bkchase";
    private static final String OUTPUT_SCHEMA_FILE = "src/main/resources/testAJ/schemas";
    private static final String INPUT_QUERY_FILE = "src/main/resources/testAJ/v.view";
    private static final int COMPILER = 0;

    public static void main(String[] args) throws Exception {
        Injector injector = null;
        switch (COMPILER) {
            case 0:
                injector = Guice.createInjector(new AJNaiveModule());
                break;
            case 1:
                injector = Guice.createInjector(
                        new hadad.base.compiler.model.aj.alternative.firststep.AJAlternativeModule());
                break;
            case 2:
                injector = Guice.createInjector(
                        new hadad.base.compiler.model.aj.alternative.secondstep.AJAlternativeModule());
                break;
        }

        AJQueryBlockTreeBuilder builder = injector.getInstance(AJQueryBlockTreeBuilder.class);
        final QueryBlockTree nbt = builder.buildQueryBlockTree(FileUtils.readFileToString(new File(INPUT_QUERY_FILE)));
        System.out.println(nbt.toString());
        Context context = null;
        switch (COMPILER) {
            case 0:
                AJNaiveQueryBlockTreeCompiler compiler0 = injector.getInstance(AJNaiveQueryBlockTreeCompiler.class);
                context = compiler0.compileContext(nbt, new RelationalSchema(new ArrayList<Relation>()), true);
                break;
            case 1:
                hadad.base.compiler.model.aj.alternative.firststep.AJAlternativeNestedBlockTreeCompiler compiler1 =
                        injector.getInstance(
                                hadad.base.compiler.model.aj.alternative.firststep.AJAlternativeNestedBlockTreeCompiler.class);
                context = compiler1.compileContext(nbt, new RelationalSchema(new ArrayList<Relation>()), true);
                break;
            case 2:
                hadad.base.compiler.model.aj.alternative.secondstep.AJAlternativeNestedBlockTreeCompiler compiler2 =
                        injector.getInstance(
                                hadad.base.compiler.model.aj.alternative.secondstep.AJAlternativeNestedBlockTreeCompiler.class);
                context = compiler2.compileContext(nbt, new RelationalSchema(new ArrayList<Relation>()), true);
                break;
        }
        //Encoding
        System.out.println(context.getForwardConstraints());
        Utils.writeConstraints(OUTPUT_FORWARD_CONSTRAINTS_FILE, context.getForwardConstraints());
        Utils.writeConstraints(OUTPUT_BACKWARD_CONSTRAINTS_FILE, context.getBackwardConstraints());
        Utils.writeSchemas(OUTPUT_SCHEMA_FILE, context.getGlobalSchema(), context.getTargetSchema());
        final Context context01 = hadad.base.rewriter.server.Utils.parseContext(OUTPUT_SCHEMA_FILE,
                OUTPUT_FORWARD_CONSTRAINTS_FILE, OUTPUT_BACKWARD_CONSTRAINTS_FILE);
        final ConjunctiveQueryRewriter rewriter = new PACBConjunctiveQueryRewriter(context01);
        final BufferedReader query = new BufferedReader(new FileReader(new File("src/main/resources/testAJ/query")));
        final TimedReformulations timedRewritings = rewriter.getTimedReformulations(
                hadad.base.rewriter.server.Utils.parseQuery(IOUtils.toString(query)));
        //Rewriting
        System.out.println(timedRewritings.getRewritings());
    }
}
