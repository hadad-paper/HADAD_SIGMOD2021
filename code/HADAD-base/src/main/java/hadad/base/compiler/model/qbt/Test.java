package hadad.base.compiler.model.qbt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import com.google.inject.Guice;
import com.google.inject.Injector;

import hadad.commons.constraints.Constraint;
import hadad.commons.relationalschema.Relation;
import hadad.commons.relationalschema.RelationalSchema;
import hadad.base.compiler.model.qbt.naive.QBTNaiveQueryBlockTreeCompiler;
import hadad.base.rewriter.Comment;
import hadad.base.rewriter.ConjunctiveQueryRewriter;
import hadad.base.rewriter.Context;
import hadad.base.rewriter.PACBConjunctiveQueryRewriter;
import hadad.base.rewriter.TimedReformulations;
import hadad.base.compiler.QueryBlockTree;

public class Test {
    private static final String CHARSET = "utf-8";
    private static final String INPUT_FILE = "src/main/resources/testQBT/";
    private static final String OUTPUT_FORWARD_CONSTRAINTS_FILE = "src/main/resources/testQBT/constraints_chase";
    private static final String OUTPUT_BACKWARD_CONSTRAINTS_FILE = "src/main/resources/testQBT/constraints_bkchase";
    private static final String OUTPUT_SCHEMA_FILE = "src/main/resources/testQBT/schemas";
    private static Writer writerFW;
    private static Writer writerBW;
    private static Writer writerSchema;

    private static final int COMPILER = 1;
    private static final Logger log = Logger.getLogger(Test.class);
    private static Injector injector = null;

    public static void main(String[] args) throws Exception {
        writerFW = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(OUTPUT_FORWARD_CONSTRAINTS_FILE), CHARSET));
        writerBW = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(OUTPUT_BACKWARD_CONSTRAINTS_FILE), CHARSET));

        writerSchema = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(OUTPUT_SCHEMA_FILE), CHARSET));
        switch (COMPILER) {
            case 1:
                injector = Guice.createInjector(new QBTNaiveModule());
                test1();
                break;
        }

    }

    static void test1() throws Exception {

        final List<Relation> sRelations = new ArrayList<>();
        final List<Relation> tRelations = new ArrayList<>();

        final File directory = new File(INPUT_FILE + "views");
        File[] directoryListing = directory.listFiles();
        if (directoryListing != null) {
            for (final File file : directoryListing) {
                QBTQueryBlockTreeBuilder.reIntilize();
                final QBTQueryBlockTreeBuilder builder = injector.getInstance(QBTQueryBlockTreeBuilder.class);
                final QueryBlockTree nbt = builder.buildQueryBlockTree(FileUtils.readFileToString(file));
                final QBTNaiveQueryBlockTreeCompiler compiler0 =
                        injector.getInstance(QBTNaiveQueryBlockTreeCompiler.class);
                final Context context = compiler0.compileContext(nbt,
                        new RelationalSchema(new ArrayList<hadad.commons.relationalschema.Relation>()), true);
                System.out.println(nbt.toString());

                writeConstraintsFW(context.getForwardConstraints());
                writeConstraintsBW(context.getBackwardConstraints());

                sRelations.addAll(addToSchema(context.getGlobalSchema().getRelations(), sRelations));
                tRelations.addAll(addToSchema(context.getTargetSchema().getRelations(), tRelations));

            }
        }

        writerFW.close();
        writerBW.close();
        final RelationalSchema sSchema = new RelationalSchema(sRelations);
        final RelationalSchema tSchema = new RelationalSchema(tRelations);
        writeSchemas(sSchema, tSchema);
        writerSchema.close();

        final Context context01 = hadad.base.rewriter.server.Utils.parseContext(OUTPUT_SCHEMA_FILE,
                OUTPUT_FORWARD_CONSTRAINTS_FILE, OUTPUT_BACKWARD_CONSTRAINTS_FILE);
        final ConjunctiveQueryRewriter rewriter = new PACBConjunctiveQueryRewriter(context01);
        final BufferedReader query = new BufferedReader(new FileReader(new File("src/main/resources/testQBT/query")));
        final TimedReformulations timedRewritings = rewriter.getTimedReformulations(
                hadad.base.rewriter.server.Utils.parseQuery(IOUtils.toString(query)));
        //Rewriting
        System.out.println(timedRewritings.getRewritings());

    }

    public static void writeConstraintsFW(final Collection<? extends Constraint> constraints) throws IOException {
        try {
            for (final Constraint constraint : constraints) {
                writerFW.write(constraint.toString() + (constraint instanceof Comment ? "" : ";\n"));
            }
        } catch (IOException e) {
            throw e;
        }
    }

    public static void writeConstraintsBW(final Collection<? extends Constraint> constraints) throws IOException {
        try {
            for (final Constraint constraint : constraints) {
                writerBW.write(constraint.toString() + (constraint instanceof Comment ? "" : ";\n"));
            }
        } catch (IOException e) {
            throw e;
        }
    }

    public static void writeSchemas(final RelationalSchema sourceSchema, final RelationalSchema targetSchema)
            throws IOException {
        try {
            writerSchema.write(sourceSchema.toString() + "\n");
            writerSchema.write(targetSchema.toString());
        } catch (IOException e) {
            throw e;
        }
    }

    private static List<Relation> addToSchema(final List<Relation> toAdd, final List<Relation> old) {
        final List<Relation> newRelations = new ArrayList<>();
        if (old.isEmpty()) {
            return toAdd;
        } else {
            for (Relation relation : toAdd) {
                if (!old.contains(relation)) {
                    newRelations.add(relation);
                }
            }

        }
        return newRelations;
    }

}
