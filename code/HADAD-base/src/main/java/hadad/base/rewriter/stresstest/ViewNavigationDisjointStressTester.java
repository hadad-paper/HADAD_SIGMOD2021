package hadad.base.rewriter.stresstest;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.conjunctivequery.parser.ParseException;
import hadad.commons.constraints.Constraint;
import hadad.commons.relationalschema.Relation;
import hadad.commons.relationalschema.RelationalSchema;
import hadad.base.rewriter.Context;
import hadad.base.rewriter.PACBConjunctiveQueryRewriter;
import hadad.base.rewriter.ConjunctiveQueryRewriter;
import hadad.base.rewriter.TimedReformulations;

@Singleton
public class ViewNavigationDisjointStressTester {
	private final ConjunctiveQuery query;
	private final String outputSchemasFileName;
	private final String outputForwardConstraintsFileName;
	private final String outputBackwardConstraintsFileName;
	private final String[] numberOfDisjointViews;
	private final int numberOfExecutions;
	private final String viewName;
	private final String tag;

	private Context inputContext;

	/**
	 * Constructs a new view navigation disjoint stress tester.
	 *
	 * @param inputSchemasFileName
	 *            The general and target relational schemas input file name.
	 * @param inputForwardConstraintsFileName
	 *            The forward constraints input file name.
	 * @param inputBackwardConstraintsFileName
	 *            The backward constraints input file name.
	 * @param outputSchemasFileName
	 *            The general and target relational schemas output file name.
	 * @param outputForwardConstraintsFileName
	 *            The forward constraints output file name.
	 * @param outputBackwardConstraintsFileName
	 *            The backward constraints output file name.
	 * @param numberOfDisjointViews
	 *            The number of disjoint views separated by commas.
	 * @param numberOfExecutions
	 *            The number of executions to average the results.
	 * @throws ParseException
	 * @throws IllegalArgumentException
	 */
	@Inject
	private ViewNavigationDisjointStressTester(
			@Named("navigation_disjoint.input.query_file_name") final String queryFileName,
			@Named("navigation_disjoint.input.schemas_file_name") final String inputSchemasFileName,
			@Named("navigation_disjoint.input.forward_constraints_file_name") final String inputForwardConstraintsFileName,
			@Named("navigation_disjoint.input.backward_constraints_file_name") final String inputBackwardConstraintsFileName,
			@Named("navigation_disjoint.output.schemas_file_name") final String outputSchemasFileName,
			@Named("navigation_disjoint.output.forward_constraints_file_name") final String outputForwardConstraintsFileName,
			@Named("navigation_disjoint.output.backward_constraints_file_name") final String outputBackwardConstraintsFileName,
			@Named("navigation_disjoint.number_of_disjoint_views") final String numberOfDisjointViews,
			@Named("navigation_disjoint.number_of_executions") int numberOfExecutions,
			@Named("navigation_disjoint.view_name") String viewName,
			@Named("navigation_disjoint.tag") String tag)
			throws IOException,
			hadad.commons.relationalschema.parser.ParseException,
			hadad.commons.constraints.parser.ParseException,
			IllegalArgumentException, ParseException {
		query = hadad.base.rewriter.server.Utils
				.parseQuery(readQuery(queryFileName));
		this.outputSchemasFileName = checkNotNull(outputSchemasFileName);
		this.outputForwardConstraintsFileName = checkNotNull(outputForwardConstraintsFileName);
		this.outputBackwardConstraintsFileName = checkNotNull(outputBackwardConstraintsFileName);
		this.numberOfDisjointViews = numberOfDisjointViews.split(",");
		this.numberOfExecutions = numberOfExecutions;
		this.viewName = viewName;
		this.tag = tag;

		inputContext = hadad.base.rewriter.server.Utils
				.parseContext(inputSchemasFileName,
				inputForwardConstraintsFileName,
				inputBackwardConstraintsFileName);
	}

	private static String readQuery(final String fileName) throws IOException {
		return FileUtils.readFileToString(new File(fileName));
	}

	public Map<Integer, Execution> run() throws Exception {
		System.out.println("=====================================");
		System.out.println("       View navigation disjoint      ");
		System.out.println("=====================================");
		final Map<Integer, Execution> executions = new HashMap<Integer, Execution>();
		for (final String numberOfDisjointViews : this.numberOfDisjointViews) {
			final Integer n = Integer.valueOf(numberOfDisjointViews);
			final Execution e = run(n);
			executions.put(n, e);
			System.out.println("Disjoints views: " + numberOfDisjointViews);
			System.out.println(e.toString());
			System.out.println("*************************************");
		}
		return executions;
	}

	private Execution run(int numberOfDisjointViews) throws Exception {
		final Context context = createContext(numberOfDisjointViews);
		final ConjunctiveQueryRewriter rewriter = new PACBConjunctiveQueryRewriter(context);

		Utils.writeConstraints(outputForwardConstraintsFileName + "."
				+ numberOfDisjointViews, context.getForwardConstraints());
		Utils.writeConstraints(outputBackwardConstraintsFileName + "."
				+ numberOfDisjointViews, context.getBackwardConstraints());
		Utils.writeSchemas(outputSchemasFileName + "." + numberOfDisjointViews,
				context.getGlobalSchema(), context.getTargetSchema());

		final List<TimedReformulations> timedReformulations = new ArrayList<TimedReformulations>();
		for (int i = 0; i < numberOfExecutions; i++) {
			timedReformulations.add(rewriter.getTimedReformulations(query));
		}
		return new Execution(timedReformulations);
	}

	private Context createContext(int numberOfDisjointViews) {
		final Set<Relation> outputGeneralSchemas = new LinkedHashSet<Relation>(
				inputContext.getGlobalSchema().getRelations());
		final Set<Relation> outputTargetSchemas = new LinkedHashSet<Relation>(
				inputContext.getTargetSchema().getRelations());
		final List<Constraint> outputForwardConstraints = new ArrayList<Constraint>(
				inputContext.getForwardConstraints());
		final List<Constraint> outputBackwardConstraints = new ArrayList<Constraint>(
				inputContext.getBackwardConstraints());
		for (int i = 1; i <= numberOfDisjointViews; i++) {
			final String newViewName = viewName + Integer.toString(i);
			final String newTag = tag + Integer.toString(i);
			outputGeneralSchemas.addAll(Utils.changeRelationsViewName(
					inputContext.getGlobalSchema().getRelations(), viewName,
					newViewName));
			outputTargetSchemas.addAll(Utils.changeRelationsViewName(
					inputContext.getTargetSchema().getRelations(), viewName,
					newViewName));
			outputForwardConstraints.addAll(Utils.replaceConstraintsTag(
					inputContext.getForwardConstraints(), viewName, tag,
					newViewName,
					newTag));
			outputBackwardConstraints.addAll(Utils.replaceConstraintsTag(
					inputContext.getBackwardConstraints(), viewName, tag,
					newViewName,
					newTag));
		}
		return new Context(new RelationalSchema(new ArrayList<Relation>(
				outputGeneralSchemas)), new RelationalSchema(
				new ArrayList<Relation>(outputTargetSchemas)),
				outputForwardConstraints, outputBackwardConstraints);
	}
}
