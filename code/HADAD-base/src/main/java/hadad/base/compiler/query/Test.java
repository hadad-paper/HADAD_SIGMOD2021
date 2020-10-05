package hadad.base.compiler.query;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.google.inject.Guice;
import com.google.inject.Injector;

import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.base.compiler.QueryBlockTree;
import hadad.base.compiler.exceptions.ParseException;

public class Test {
    private static final String INPUT_QUERY_FILE =
            "src/test/resources/compiler/queries/v.view";

    private static final int COMPILER = 1;
    private static final Logger log = Logger.getLogger(Test.class);
    private static Injector injector = null;

    public static void main(String[] args) throws Exception {
        switch (COMPILER) {
            case 1:
                injector = Guice.createInjector(new QBTQueryNaiveModule());
                test1();
                break;
        }

    }

    static void test1() throws ParseException, IOException {
        MixedNestedBlockTreeBuilder builder = injector.getInstance(MixedNestedBlockTreeBuilder.class);
        final QueryBlockTree nbt = builder.buildQueryBlockTree(FileUtils.readFileToString(new File(INPUT_QUERY_FILE)));
        final MixedNestedBlockTreeCompiler compiler0 = injector.getInstance(MixedNestedBlockTreeCompiler.class);
        final ConjunctiveQuery conjunctiveQuery = compiler0.compileQuery(nbt);
        log.debug("CQ Query: " + conjunctiveQuery.toString());
    }
}
