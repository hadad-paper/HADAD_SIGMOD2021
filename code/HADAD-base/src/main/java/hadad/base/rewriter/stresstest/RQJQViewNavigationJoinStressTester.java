package hadad.base.rewriter.stresstest;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.conjunctivequery.Term;
import hadad.commons.conjunctivequery.Variable;
import hadad.commons.conjunctivequery.parser.ParseException;
import hadad.commons.constraints.Constraint;
import hadad.commons.relationalschema.Relation;
import hadad.commons.relationalschema.RelationalSchema;
import hadad.base.rewriter.ConjunctiveQueryRewriter;
import hadad.base.rewriter.Context;
import hadad.base.rewriter.PACBConjunctiveQueryRewriter;
import hadad.base.rewriter.TimedReformulations;

@Singleton
public class RQJQViewNavigationJoinStressTester {
	private final ConjunctiveQuery query;
	private final String outputSchemasFileName;
	private final String outputForwardConstraintsFileName;
	private final String outputBackwardConstraintsFileName;
	private final String[] numberOfjoinViews;
	private final int numberOfExecutions;
	private final String viewName;
	private final String tag;

	private Context inputContext;

	/**
	 * Constructs a new view navigation disjoint stress tester.
	 *
	 * @throws ParseException
	 * @throws IllegalArgumentException
	 */
	@Inject
	private RQJQViewNavigationJoinStressTester(
			@Named("navigation_join.input.query_file_name") final String queryFileName,
			@Named("navigation_join.input.schemas_file_name") final String inputSchemasFileName,
			@Named("navigation_join.input.forward_constraints_file_name") final String inputForwardConstraintsFileName,
			@Named("navigation_join.input.backward_constraints_file_name") final String inputBackwardConstraintsFileName,
			@Named("navigation_join.output.schemas_file_name") final String outputSchemasFileName,
			@Named("navigation_join.output.forward_constraints_file_name") final String outputForwardConstraintsFileName,
			@Named("navigation_join.output.backward_constraints_file_name") final String outputBackwardConstraintsFileName,
			@Named("navigation_join.number_of_join_views") final String numberOfjoinViews,
			@Named("navigation_join.number_of_executions") int numberOfExecutions,
			@Named("navigation_join.view_name") String viewName, @Named("navigation_join.tag") String tag)
			throws IOException,
			hadad.commons.relationalschema.parser.ParseException,
			hadad.commons.constraints.parser.ParseException,
			IllegalArgumentException, ParseException {
		query = hadad.base.rewriter.server.Utils
				.parseQuery(readQuery(queryFileName));
		this.outputSchemasFileName = checkNotNull(outputSchemasFileName);
		this.outputForwardConstraintsFileName = checkNotNull(outputForwardConstraintsFileName);
		this.outputBackwardConstraintsFileName = checkNotNull(outputBackwardConstraintsFileName);
		this.numberOfjoinViews = numberOfjoinViews.split(",");
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
		System.out.println("         View navigation join        ");
		System.out.println("=====================================");
		final Map<Integer, Execution> executions = new HashMap<Integer, Execution>();
		for (final String numberOfjoinViews : this.numberOfjoinViews) {
			final Integer n = Integer.valueOf(numberOfjoinViews);
			final Execution e = run(n);
			executions.put(n, e);
			System.out.println("Join views: " + numberOfjoinViews);
			System.out.println(e.toString());
			System.out.println("*************************************");
		}
		return executions;
	}

	private Execution run(int numberOfjoinViews) throws Exception {
		final Context context = createContext(numberOfjoinViews);
		final ConjunctiveQueryRewriter rewriter = new PACBConjunctiveQueryRewriter(context);

		Utils.writeConstraints(outputForwardConstraintsFileName + "." + numberOfjoinViews,
				context.getForwardConstraints());
		Utils.writeConstraints(outputBackwardConstraintsFileName + "." + numberOfjoinViews,
				context.getBackwardConstraints());
		Utils.writeSchemas(outputSchemasFileName + "." + numberOfjoinViews,
				context.getGlobalSchema(), context.getTargetSchema());

		final List<TimedReformulations> timedReformulations = new ArrayList<TimedReformulations>();
		final ConjunctiveQuery query = createQuery(numberOfjoinViews);
		System.out.println(query.toString());
		for (int i = 0; i < numberOfExecutions; i++) {
			timedReformulations.add(rewriter.getTimedReformulations(query));
		}
		return new Execution(timedReformulations);
	}

	private ConjunctiveQuery createQuery(int numberOfjoinViews) {
		final List<Term> head = new ArrayList<>(query.getHead());
		final Collection<Atom> body = new ArrayList<>(query.getBody());
		final List<Term> newTerms = new ArrayList<Term>();
		final List<Atom> newAtoms = new ArrayList<Atom>();
		for (int i = 1; i <= numberOfjoinViews; i++) {
			for (Term t : head) {
				newTerms.add(new Variable(((Variable) t).getName() + Integer.toString(i)));
			}
			for (Atom a : body) {
				final List<Term> newAtomsTerms = new ArrayList<Term>();
				for (Term t : a.getTerms()) {
					if (t instanceof Variable) {
						if (((Variable) t).getName().equals("id")) {
							newAtomsTerms.add(t);
						} else {
							newAtomsTerms.add(new Variable(((Variable) t).getName() + Integer.toString(i)));
						}
					} else {
						newAtomsTerms.add(t);
					}
				}
				newAtoms.add(new Atom(
						(a.getPredicate().equals("artist") ? a.getPredicate() + Integer.toString(i) : a.getPredicate()),
						newAtomsTerms));
			}
		}
		head.addAll(newTerms);
		body.addAll(newAtoms);
		return new ConjunctiveQuery(head, body);
	}

	private Context createContext(int numberOfjoinViews) {
		final Set<Relation> outputGeneralSchemas = new LinkedHashSet<>(
				inputContext.getGlobalSchema().getRelations());
		final Set<Relation> outputTargetSchemas = new LinkedHashSet<>(
				inputContext.getTargetSchema().getRelations());
		final Set<Constraint> outputForwardConstraints = new HashSet<>(
				inputContext.getForwardConstraints());
		final Set<Constraint> outputBackwardConstraints = new HashSet<>(
				inputContext.getBackwardConstraints());
		for (int i = 1; i <= numberOfjoinViews; i++) {
			final String newViewName = viewName + Integer.toString(i);
			final String newTag = tag + Integer.toString(i);
			outputGeneralSchemas.addAll(Utils.changeRelationsViewName(inputContext.getGlobalSchema().getRelations(),
					viewName, newViewName));
			outputGeneralSchemas
					.addAll(Utils.changeRelationsViewName(inputContext.getGlobalSchema().getRelations(), tag, newTag));
			outputTargetSchemas.addAll(Utils.changeRelationsViewName(inputContext.getTargetSchema().getRelations(),
					viewName, newViewName));
			outputForwardConstraints.addAll(Utils.replaceConstraintsRelation(inputContext.getForwardConstraints(),
					viewName, tag, newViewName, newTag));
			outputBackwardConstraints.addAll(Utils.replaceConstraintsRelation(inputContext.getBackwardConstraints(),
					viewName, tag, newViewName, newTag));
		}
		return new Context(new RelationalSchema(new ArrayList<>(outputGeneralSchemas)),
				new RelationalSchema(new ArrayList<>(outputTargetSchemas)), new ArrayList<>(outputForwardConstraints),
				new ArrayList<>(outputBackwardConstraints));
	}
}
