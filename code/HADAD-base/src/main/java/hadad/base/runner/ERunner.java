package hadad.base.runner;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;



import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.base.rewriter.ConjunctiveQueryRewriter;
import hadad.base.rewriter.Context;
import hadad.base.rewriter.PACBConjunctiveQueryRewriter;
import hadad.base.rewriter.TimedReformulations;
//import hadad.base.rewriting.logical.RewritingToLogicalPlanGenerator;
//import hadad.base.rewriting.physical.LogicalToNaivePhysicalPlanGenerator;
import hadad.base.utils.Utils;

@Singleton
public class ERunner {
    private static final Logger LOGGER = Logger.getLogger(ERunner.class);
    private final String inputQuerysAndViewsFolder;

    @Inject
    private ERunner(@Named("cases.folder") final String inputQuerysAndViewsFolder) {
        Logger.getRootLogger().setLevel(Level.INFO);

        this.inputQuerysAndViewsFolder = checkNotNull(inputQuerysAndViewsFolder);
//        try {
//            Parameters.init();
//            RegisterMetaData.registerMetaData();
//        } catch (Exception e) {
//            LOGGER.error("Could not instantiates the execution engine (Tatooine): " + e.getMessage());
//        }

    }

//    public void run() throws TatooineExecutionException {
//
//        final File directory = new File(inputQuerysAndViewsFolder);
//        File[] directoryListing = directory.listFiles();
//        if (directoryListing != null) {
//            for (final File folder : directoryListing) {
//                final String folderName = folder.getName();
//
//                long startTime = System.currentTimeMillis();
//
//                final Context context = constructContext(folderName);
//                final List<ConjunctiveQuery> rewritings = findRewriting(folderName, context);
//                LOGGER.info("Query Rewriitng :" + rewritings.get(0).toString());
//                final LogOperator logicalPlanRootOperator =
//                        new RewritingToLogicalPlanGenerator(rewritings.get(0)).generate();
//                LOGGER.info("Logical Plan :" + logicalPlanRootOperator.getName());
//                final NIterator rewritingPhyPlan =
//                        new LogicalToNaivePhysicalPlanGenerator(logicalPlanRootOperator).generate();
//                rewritingPhyPlan.open();
//                int count = 0;
//                while (rewritingPhyPlan.hasNext()) {
//                    final NTuple ntuple = rewritingPhyPlan.next();
//                    count++;
//
//                }
//                long entTime = System.currentTimeMillis();
//
//                System.out.println("ResultCount : " + count + " Time : " + ((entTime - startTime) / 1000.00));
//                rewritingPhyPlan.close();
//            }
//        }
//
//    }

    /**
     * Create a rewriting context.
     * 
     * @param folderName
     *            the folder name where views and queries reside.
     * @return The constructed rewriting context
     * @throws hadad.commons.constraints.parser.ParseException
     */
    private Context constructContext(final String folderName) {

        try {
            final Context context = hadad.base.rewriter.server.Utils.parseContext(
                    inputQuerysAndViewsFolder + folderName + "/schemas",
                    inputQuerysAndViewsFolder + folderName + "/constraints_chase",
                    inputQuerysAndViewsFolder + folderName + "/constraints_bkchase");
            return context;
        } catch (IOException | hadad.commons.relationalschema.parser.ParseException
                | hadad.commons.constraints.parser.ParseException e) {
            LOGGER.error("Constraints parsing exception: " + e.getMessage());
            return null;
        }

    }

    /**
     * Find a query rewriting.
     * 
     * @param context
     *            the rewriting context.
     * @return The list of rewritings.
     */
    private List<ConjunctiveQuery> findRewriting(final String folderName, final Context context) {
        final ConjunctiveQueryRewriter rewriter = new PACBConjunctiveQueryRewriter(context);
        try {
            final BufferedReader query =
                    new BufferedReader(new FileReader(inputQuerysAndViewsFolder + folderName + "/query"));
            final TimedReformulations timedRewritings = rewriter.getTimedReformulations(
                    hadad.base.rewriter.server.Utils.parseQuery(IOUtils.toString(query)));
            final List<TimedReformulations> rewritings = new ArrayList<TimedReformulations>();
            rewritings.add(timedRewritings);
            final ExecutionUtils exe = new ExecutionUtils(rewritings);
            if (!exe.getRewritings().isEmpty()) {
                final List<ConjunctiveQuery> rws = exe.getRewritings();
                Utils.writeRewritings(rws, inputQuerysAndViewsFolder + folderName + "/rewriting");
                return rws;
            } else {
                LOGGER.debug("Query Reformulations not found.");
                return null;
            }
        } catch (Exception e) {
            LOGGER.error("Rewriting Exception: " + e.getMessage());
            return null;
        }

    }

}