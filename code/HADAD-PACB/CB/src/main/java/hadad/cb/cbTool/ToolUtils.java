package hadad.cb.cbTool;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.log4j.Logger;

import hadad.cb.cbAPI.CBProvider;
import hadad.cb.cbInternal.Utils;
import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.conjunctivequery.parser.CQParser;
import hadad.commons.constraints.Constraint;
import hadad.commons.constraints.Utilities;
import hadad.commons.constraints.parser.ConstraintParser;
import hadad.commons.relationalschema.RelationalSchema;
import hadad.commons.relationalschema.parser.RelSchemaParser;

/**
 * CB ToolUtils
 */
public class ToolUtils {

    /** Logger **/
    private final static Logger LOGGER = Logger.getLogger(ToolUtils.class);

    /**
     * Computes the rewritings for an input configuration, outputs results in
     * inputDir/results
     *
     * @param inputDir
     *            The directory holding the input configuration
     */
    public static void ComputeRewritings(final String inputDir, final Properties properties) throws Exception {
        // parse query
        FileReader fr = new FileReader(inputDir + "/" + "query");
        CQParser cqparser = new CQParser(fr);
        ConjunctiveQuery query = null;
        Map<String, ConjunctiveQuery> parsedCQs = cqparser.parse();
        for (String s : parsedCQs.keySet()) {
            query = parsedCQs.get(s);
        }
        fr.close();

        // parse views
        fr = new FileReader(inputDir + "/" + "views");
        cqparser = new CQParser(fr);
        ArrayList<ConjunctiveQuery> views = new ArrayList<ConjunctiveQuery>();
        parsedCQs = cqparser.parse();
        for (String s : parsedCQs.keySet()) {
            views.add(parsedCQs.get(s));
        }
        fr.close();

        // parse constraints applicable for chase
        fr = new FileReader(inputDir + "/" + "constraints_chase");
        ConstraintParser consparser = new ConstraintParser(fr);
        ArrayList<Constraint> constraints_chase = consparser.parse();
        fr.close();

        // parse constraints applicable for back-chase
        fr = new FileReader(inputDir + "/" + "constraints_bkchase");
        consparser = new ConstraintParser(fr);
        ArrayList<Constraint> constraints_bkchase = consparser.parse();
        fr.close();

        // parse schemas
        fr = new FileReader(inputDir + "/" + "schemas");
        RelSchemaParser schparser = new RelSchemaParser(fr);
        ArrayList<RelationalSchema> schemas = schparser.parse();
        fr.close();

        ArrayList<Constraint> fwconstraints = new ArrayList<Constraint>();
        ArrayList<Constraint> bwconstraints = new ArrayList<Constraint>();
        fwconstraints.addAll(constraints_chase);
        bwconstraints.addAll(constraints_bkchase);

        Pair<List<Constraint>, List<Constraint>> constrFromViews = Utilities.getFWandBWConstraints(views);
        fwconstraints.addAll(constrFromViews.getLeft());
        bwconstraints.addAll(constrFromViews.getRight());
        
//        int i=1;
//        
//        long time=0;
//        while (i<=10) {
//            Map<Long, List<ConjunctiveQuery>> timedRewritings = CBProvider.getReformulations(query, schemas.get(0),
//                    schemas.get(1), fwconstraints, bwconstraints, properties); 
//            Map.Entry<Long, List<ConjunctiveQuery>> entry = timedRewritings.entrySet().iterator().next();
//            time+=entry.getKey();
//            i++;
//        }
//        System.out.println(time/10.00);
        Map<Long, List<ConjunctiveQuery>> timedRewritings = CBProvider.getReformulations(query, schemas.get(0),
              schemas.get(1), fwconstraints, bwconstraints, properties); 
       
        PrintWriter out = new PrintWriter(new FileWriter(inputDir + "/" + "results"));
       // fr = new FileReader(inputDir + "/" + "results");
        BufferedReader br=new BufferedReader(fr); 
        for (Map.Entry<Long, List<ConjunctiveQuery>> entry : timedRewritings.entrySet()) {
            final Long time = entry.getKey();
            LOGGER.debug("Rewriitngs Time (ms):-" + time);
            for (ConjunctiveQuery rw : entry.getValue()) {
                System.out.println(Utils.fromQueryToString(rw));
                out.println(Utils.fromQueryToString(rw));
                
            }
        }
//        String line;  
//        while((line=br.readLine())!=null)  
//        { 
//            LOGGER.debug(line);
//        }
//        //fr.close();
        out.close();
    }
}
