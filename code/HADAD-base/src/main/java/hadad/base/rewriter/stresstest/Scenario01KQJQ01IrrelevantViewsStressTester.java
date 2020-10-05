package hadad.base.rewriter.stresstest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.constraints.Constraint;
import hadad.commons.relationalschema.Relation;
import hadad.commons.relationalschema.RelationalSchema;
import hadad.commons.relationalschema.parser.ParseException;
import hadad.base.rewriter.ConjunctiveQueryRewriter;
import hadad.base.rewriter.Context;
import hadad.base.rewriter.PACBConjunctiveQueryRewriter;
import hadad.base.rewriter.TimedReformulations;

public class Scenario01KQJQ01IrrelevantViewsStressTester {
	private final static String RELEVANT_VIEWS_DIR_NAME = "relevant_views/";
	private final static String IRRELEVANT_VIEW_DIR_NAME = "irrelevant_view/";
	private final static String QUERY_FILE_NAME = "query";
	private final static String SCHEMA_FILE_NAME = "schemas";
	private final static String FORWARD_CONSTRAINTS_FILE_NAME = "forward_constraints";
	private final static String BACKWARD_CONSTRAINTS_FILE_NAME = "backward_constraints";

	private final ConjunctiveQuery query;
	private final String inputPath;
	private final String outputPath;
	private final String[] numberOfIrrelevantViews;
	private final int numberOfExecutions;
	private final String irrelevantViewName;
	private final String irrelevantViewTag;

	private Context inputRelevantViewsContext;
	private Context inputIrrelevantViewsContext;

	@Inject
	private Scenario01KQJQ01IrrelevantViewsStressTester(@Named("input_path") final String inputPath,
			@Named("output_path") final String outputPath,
			@Named("number_of_irrelevant_views") final String numberOfIrrelevantViews,
			@Named("number_of_executions") int numberOfExecutions,
			@Named("irrelevant_view.name") String irrelevantViewName,
			@Named("irrelevant_view.tag") String irrelevantViewTag)
					throws IOException, ParseException, hadad.commons.constraints.parser.ParseException,
					IllegalArgumentException, hadad.commons.conjunctivequery.parser.ParseException {
		this.inputPath = inputPath;
		this.outputPath = outputPath;
		this.numberOfIrrelevantViews = numberOfIrrelevantViews.split(",");
		this.numberOfExecutions = numberOfExecutions;
		this.irrelevantViewName = irrelevantViewName;
		this.irrelevantViewTag = irrelevantViewTag;
		final String queryFileName = inputPath + QUERY_FILE_NAME;
		query = hadad.base.rewriter.server.Utils.parseQuery(readQuery(queryFileName));
		inputRelevantViewsContext = hadad.base.rewriter.server.Utils.parseContext(
				getInputRelevantSchemasFileName(), getInputRelevantForwardConstraintsFileName(),
				getInputRelevantBackwardConstraintsFileName());
		inputIrrelevantViewsContext = hadad.base.rewriter.server.Utils.parseContext(
				getInputIrrelevantSchemasFileName(), getInputIrrelevantForwardConstraintsFileName(),
				getInputIrrelevantBackwardConstraintsFileName());
	}

	private String getInputRelevantSchemasFileName() {
		return inputPath + RELEVANT_VIEWS_DIR_NAME + SCHEMA_FILE_NAME;
	}

	private String getInputRelevantForwardConstraintsFileName() {
		return inputPath + RELEVANT_VIEWS_DIR_NAME + FORWARD_CONSTRAINTS_FILE_NAME;
	}

	private String getInputRelevantBackwardConstraintsFileName() {
		return inputPath + RELEVANT_VIEWS_DIR_NAME + BACKWARD_CONSTRAINTS_FILE_NAME;
	}

	private String getInputIrrelevantSchemasFileName() {
		return inputPath + IRRELEVANT_VIEW_DIR_NAME + SCHEMA_FILE_NAME;
	}

	private String getInputIrrelevantForwardConstraintsFileName() {
		return inputPath + IRRELEVANT_VIEW_DIR_NAME + FORWARD_CONSTRAINTS_FILE_NAME;
	}

	private String getInputIrrelevantBackwardConstraintsFileName() {
		return inputPath + IRRELEVANT_VIEW_DIR_NAME + BACKWARD_CONSTRAINTS_FILE_NAME;
	}

	private String getOutputSchemasFileName(int numberOfIrrelevantViews) {
		return outputPath + SCHEMA_FILE_NAME + "." + numberOfIrrelevantViews;
	}

	private String getOutputForwardConstraintsFileName(int numberOfIrrelevantViews) {
		System.out.println(outputPath + FORWARD_CONSTRAINTS_FILE_NAME + "." + numberOfIrrelevantViews);
		return outputPath + FORWARD_CONSTRAINTS_FILE_NAME + "." + numberOfIrrelevantViews;
	}

	private String getOutputBackwardConstraintsFileName(int numberOfIrrelevantViews) {
		return outputPath + BACKWARD_CONSTRAINTS_FILE_NAME + "." + numberOfIrrelevantViews;
	}

	private static String readQuery(final String fileName) throws IOException {
		return FileUtils.readFileToString(new File(fileName));
	}

	public Map<Integer, Execution> run() throws Exception {
		System.out.println("=====================================");
		System.out.println("       View navigation disjoint      ");
		System.out.println("=====================================");
		final Map<Integer, Execution> executions = new HashMap<>();
		final Map<Integer, Double> times = new HashMap<>();
		for (final String numberOfIrrelevantViews : this.numberOfIrrelevantViews) {
			final Integer n = Integer.valueOf(numberOfIrrelevantViews);
			final Execution e = run(n);
			executions.put(n, e);
			times.put(n, e.getExecTimesAverage());
			System.out.println("Number of irrelevant views: " + numberOfIrrelevantViews);
			System.out.println(e.toString());
			System.out.println("*************************************");
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++");
		times.entrySet().stream().forEach(v -> System.out.println(v.getKey() + "\t" + v.getValue()));
		System.out.println("+++++++++++++++++++++++++++++++++++++");
		return executions;
	}

	private Execution run(int numberOfIrrelevantViews) throws Exception {
		final Context context = createContext(numberOfIrrelevantViews);
		final ConjunctiveQueryRewriter rewriter = new PACBConjunctiveQueryRewriter(context);
		Utils.writeConstraints(getOutputForwardConstraintsFileName(numberOfIrrelevantViews),
				context.getForwardConstraints());
		Utils.writeConstraints(getOutputBackwardConstraintsFileName(numberOfIrrelevantViews),
				context.getBackwardConstraints());
		Utils.writeSchemas(getOutputSchemasFileName(numberOfIrrelevantViews), context.getGlobalSchema(),
				context.getTargetSchema());

		final List<TimedReformulations> timedReformulations = new ArrayList<TimedReformulations>();
		for (int i = 0; i < numberOfExecutions; i++) {
			timedReformulations.add(rewriter.getTimedReformulations(query));
		}
		return new Execution(timedReformulations);
	}

	private Context createContext(int numberOfIrrelevantViews) {
		final Set<Relation> outputGeneralSchemas = new LinkedHashSet<>(
				inputRelevantViewsContext.getGlobalSchema().getRelations());
		final Set<Relation> outputTargetSchemas = new LinkedHashSet<>(
				inputRelevantViewsContext.getTargetSchema().getRelations());
		final Set<Constraint> outputForwardConstraints = new HashSet<>(
				inputRelevantViewsContext.getForwardConstraints());
		final Set<Constraint> outputBackwardConstraints = new HashSet<>(
				inputRelevantViewsContext.getBackwardConstraints());
		for (int i = 1; i <= numberOfIrrelevantViews; i++) {
			final String newViewName = irrelevantViewName + Integer.toString(i);
			final String newTag = irrelevantViewTag + Integer.toString(i);
			outputGeneralSchemas.addAll(Utils.changeRelationsViewName(
					inputIrrelevantViewsContext.getGlobalSchema().getRelations(), irrelevantViewName, newViewName));
			outputGeneralSchemas.addAll(Utils.changeRelationsViewName(
					inputIrrelevantViewsContext.getGlobalSchema().getRelations(), irrelevantViewTag, newTag));
			outputTargetSchemas.addAll(Utils.changeRelationsViewName(
					inputIrrelevantViewsContext.getTargetSchema().getRelations(), irrelevantViewName, newViewName));
			outputForwardConstraints
					.addAll(Utils.replaceConstraintsRelation(inputIrrelevantViewsContext.getForwardConstraints(),
							irrelevantViewName, irrelevantViewTag, newViewName, newTag));
			outputBackwardConstraints
					.addAll(Utils.replaceConstraintsRelation(inputIrrelevantViewsContext.getBackwardConstraints(),
							irrelevantViewName, irrelevantViewTag, newViewName, newTag));
		}
		return new Context(new RelationalSchema(new ArrayList<>(outputGeneralSchemas)),
				new RelationalSchema(new ArrayList<>(outputTargetSchemas)), new ArrayList<>(outputForwardConstraints),
				new ArrayList<>(outputBackwardConstraints));
	}
}
