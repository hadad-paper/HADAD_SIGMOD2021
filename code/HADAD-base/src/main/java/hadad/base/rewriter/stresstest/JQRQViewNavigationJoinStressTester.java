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
public class JQRQViewNavigationJoinStressTester {
	private final ConjunctiveQuery query;
	private final String outputSchemasFileName;
	private final String outputForwardConstraintsFileName;
	private final String outputBackwardConstraintsFileName;
	private final String[] numberOfjoinViews;
	private final int numberOfExecutions;
	private final String viewName1;
	private final String viewName2;
	private final String viewName3;

	private final String tag1;
	private final String tag2;
	private final String tag3;


	private Context inputContext1;
	private Context inputContext2;
	private Context inputContext3;


	/**
	 * Constructs a new view navigation disjoint stress tester.
	 *
	 * @throws ParseException
	 * @throws IllegalArgumentException
	 */
	@Inject
	private JQRQViewNavigationJoinStressTester(
			@Named("navigation_join.input.query_file_name") final String queryFileName,
			@Named("navigation_join.input.schemas_file_name") final String inputSchemasFileName,
			@Named("navigation_join.input.forward_constraints_file_name1") final String inputForwardConstraintsFileName1,
			@Named("navigation_join.input.backward_constraints_file_name1") final String inputBackwardConstraintsFileName1,
			@Named("navigation_join.input.forward_constraints_file_name2") final String inputForwardConstraintsFileName2,
			@Named("navigation_join.input.backward_constraints_file_name2") final String inputBackwardConstraintsFileName2,
			@Named("navigation_join.input.forward_constraints_file_name3") final String inputForwardConstraintsFileName3,
			@Named("navigation_join.input.backward_constraints_file_name3") final String inputBackwardConstraintsFileName3,
			@Named("navigation_join.output.schemas_file_name") final String outputSchemasFileName,
			@Named("navigation_join.output.forward_constraints_file_name") final String outputForwardConstraintsFileName,
			@Named("navigation_join.output.backward_constraints_file_name") final String outputBackwardConstraintsFileName,
			@Named("navigation_join.number_of_join_views") final String numberOfjoinViews,
			@Named("navigation_join.number_of_executions") int numberOfExecutions,
			@Named("navigation_join.view_name1") String viewName1,
			@Named("navigation_join.view_name2") String viewName2,
			@Named("navigation_join.view_name3") String viewName3,
			@Named("navigation_join.tag1") String tag1,@Named("navigation_join.tag2") String tag2, @Named("navigation_join.tag3") String tag3)
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
		this.viewName1 = viewName1;
		this.viewName2 = viewName2;
		this.viewName3 = viewName3;
		this.tag1 = tag1;
		this.tag2 = tag2;
		this.tag3 = tag3;


		inputContext1 = hadad.base.rewriter.server.Utils
				.parseContext(inputSchemasFileName,
				inputForwardConstraintsFileName1,
				inputBackwardConstraintsFileName1);
		inputContext2 = hadad.base.rewriter.server.Utils
				.parseContext(inputSchemasFileName,
				inputForwardConstraintsFileName2,
				inputBackwardConstraintsFileName2);
		inputContext3 = hadad.base.rewriter.server.Utils
				.parseContext(inputSchemasFileName,
				inputForwardConstraintsFileName3,
				inputBackwardConstraintsFileName3);
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

		System.out.println(outputForwardConstraintsFileName);
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
		final int numViews= numberOfjoinViews/3;

		for (int i = 1; i <= numViews; i++) {
			for (Term t : head) {
				newTerms.add(new Variable(((Variable) t).getName() + Integer.toString(i)));
			}
			for (Atom a : body) {
				final List<Term> newAtomsTerms = new ArrayList<Term>();
				for (Term t : a.getTerms()) {
					if (t instanceof Variable) {
						if (((Variable) t).getName().equals("SUBJECT_ID") ||  ((Variable) t).getName().equals("ITEMID") ) {
							newAtomsTerms.add(t);
						} else {
							newAtomsTerms.add(new Variable(((Variable) t).getName() + Integer.toString(i)));
						}
					} else {
						newAtomsTerms.add(t);
					}
				}
				newAtoms.add(new Atom((a.getPredicate().equals("root_jq_88") || a.getPredicate().equals("root_jq_89") || a.getPredicate().equals("root_jq_90")
						? a.getPredicate() + Integer.toString(i) : a.getPredicate()),
						newAtomsTerms));
			}
		}
		head.addAll(newTerms);
		body.addAll(newAtoms);
		return new ConjunctiveQuery(head, body);
	}

	private Context createContext(int numberOfjoinViews) {
		final Set<Relation> outputGeneralSchemas = new LinkedHashSet<>(
				inputContext1.getGlobalSchema().getRelations());
		outputGeneralSchemas.addAll(inputContext2.getGlobalSchema().getRelations());
		outputGeneralSchemas.addAll(inputContext3.getGlobalSchema().getRelations());

		final Set<Relation> outputTargetSchemas = new LinkedHashSet<>(
				inputContext1.getTargetSchema().getRelations());
		outputTargetSchemas.addAll(inputContext2.getTargetSchema().getRelations());
		outputTargetSchemas.addAll(inputContext3.getTargetSchema().getRelations());

		final Set<Constraint> outputForwardConstraints = new HashSet<>(
				inputContext1.getForwardConstraints());
		outputForwardConstraints.addAll(inputContext2.getForwardConstraints());
		outputForwardConstraints.addAll(inputContext3.getForwardConstraints());

		final Set<Constraint> outputBackwardConstraints = new HashSet<>(
				inputContext1.getBackwardConstraints());
		outputBackwardConstraints.addAll(inputContext2.getBackwardConstraints());
		outputBackwardConstraints.addAll(inputContext3.getBackwardConstraints());

	
		//final String tag2 = "root_jq_89";
		final int numViews= numberOfjoinViews/3;
		//Relational View
		for (int i = 1; i <=numViews; i++) {
			System.out.println(viewName1);
			final String newViewName1 = viewName1 + Integer.toString(i);
			final String newTag1 = tag1 + Integer.toString(i);
			//final String newTag21 = tag2 + Integer.toString(i);
			outputGeneralSchemas.addAll(Utils.changeRelationsViewName(inputContext1.getGlobalSchema().getRelations(),
					viewName1, newViewName1));
			/*outputGeneralSchemas.addAll(Utils.changeRelationsViewName(
					Utils.changeRelationsViewName(inputContext1.getGlobalSchema().getRelations(), tag1, newTag1), tag2,
					newTag21));*/
			outputGeneralSchemas.addAll(
					Utils.changeRelationsViewName(inputContext1.getGlobalSchema().getRelations(), tag1, newTag1));
			
			/*outputTargetSchemas.addAll(Utils.changeRelationsViewName(inputContext1.getTargetSchema().getRelations(),
					viewName1, newViewName1));*/
			outputTargetSchemas.addAll(Utils.changeRelationsViewName(inputContext1.getTargetSchema().getRelations(),
					viewName1, newViewName1));
			
			/*outputForwardConstraints.addAll(Utils
					.replaceConstraintsRelation(Utils.replaceConstraintsRelation(inputContext1.getForwardConstraints(),
							viewName1, tag1, newViewName1, newTag1), newViewName1, tag2, newViewName1, newTag21));*/
			
			outputForwardConstraints.addAll(Utils.replaceConstraintsRelation(inputContext1.getForwardConstraints(),
							viewName1, tag1, newViewName1, newTag1));
			
			
			outputBackwardConstraints.addAll(Utils.replaceConstraintsRelation(inputContext1.getBackwardConstraints(),
					viewName1, tag1, newViewName1, newTag1));
			
			
			
			/*outputBackwardConstraints.addAll(Utils
					.replaceConstraintsRelation(Utils.replaceConstraintsRelation(inputContext1.getBackwardConstraints(),
							viewName1, tag1, newViewName1, newTag1), newViewName1, tag2, newViewName1, newTag21));*/
			//Solr
			/*final String newViewName3 = viewName3 + Integer.toString(i);
			final String newTag3 = tag + Integer.toString(i);
			final String newTag23 = tag2 + Integer.toString(i);
			outputGeneralSchemas.addAll(Utils.changeRelationsViewName(inputContext3.getGlobalSchema().getRelations(),
					viewName3, newViewName3));
			outputGeneralSchemas.addAll(Utils.changeRelationsViewName(
					Utils.changeRelationsViewName(inputContext3.getGlobalSchema().getRelations(), tag, newTag3), tag2,
					newTag23));
			outputTargetSchemas.addAll(Utils.changeRelationsViewName(inputContext3.getTargetSchema().getRelations(),
					viewName3, newViewName3));
			outputForwardConstraints.addAll(Utils
					.replaceConstraintsRelation(Utils.replaceConstraintsRelation(inputContext3.getForwardConstraints(),
							viewName3, tag, newViewName3, newTag3), newViewName3, tag2, newViewName3, newTag23));
			outputBackwardConstraints.addAll(Utils
					.replaceConstraintsRelation(Utils.replaceConstraintsRelation(inputContext3.getBackwardConstraints(),
							viewName3, tag, newViewName3, newTag3), newViewName3, tag2, newViewName3, newTag23));*/
			
		}
		//Redis View
		for (int i = 1; i <=numViews; i++) {
			System.out.println(viewName2);
			final String newViewName = viewName2 + Integer.toString(i);
			final String newTag2 = tag2 + Integer.toString(i);
			//final String newTag2 = tag2 + Integer.toString(i);
			outputGeneralSchemas.addAll(Utils.changeRelationsViewName(inputContext2.getGlobalSchema().getRelations(),
					viewName2, newViewName));
			
			/*outputGeneralSchemas.addAll(Utils.changeRelationsViewName(
					Utils.changeRelationsViewName(inputContext2.getGlobalSchema().getRelations(), tag2, newTag), tag2,
					newTag2));*/
			
			
			outputGeneralSchemas.addAll(
			Utils.changeRelationsViewName(inputContext2.getGlobalSchema().getRelations(), tag2, newTag2));
	
			
			/*outputTargetSchemas.addAll(Utils.changeRelationsViewName(inputContext2.getTargetSchema().getRelations(),
					viewName2, newViewName));*/
			
			
			outputTargetSchemas.addAll(Utils.changeRelationsViewName(inputContext2.getTargetSchema().getRelations(),
			viewName2, newViewName));
			
			/*outputForwardConstraints.addAll(Utils.replaceConstraintsRelation(inputContext2.getForwardConstraints(),
							viewName2, tag2, newViewName, newTag));*/
			
			outputForwardConstraints.addAll(Utils.replaceConstraintsRelation(inputContext2.getForwardConstraints(),
					viewName2, tag2, newViewName, newTag2));
			
			outputBackwardConstraints.addAll(Utils.replaceConstraintsRelation(inputContext2.getBackwardConstraints(),
							viewName2, tag2, newViewName, newTag2));
		}
		//Redis View
		for (int i = 1; i <=numViews; i++) {
			System.out.println(viewName3);

		final String newViewName = viewName3 + Integer.toString(i);
		final String newTag3 = tag3 + Integer.toString(i);
		//final String newTag2 = tag3 + Integer.toString(i);
		
		outputGeneralSchemas.addAll(Utils.changeRelationsViewName(inputContext3.getGlobalSchema().getRelations(),
				viewName3, newViewName));
		
		/*outputGeneralSchemas.addAll(Utils.changeRelationsViewName(
				Utils.changeRelationsViewName(inputContext3.getGlobalSchema().getRelations(), tag, newTag), tag2,
				newTag2));*/
		outputGeneralSchemas.addAll(
				Utils.changeRelationsViewName(inputContext3.getGlobalSchema().getRelations(), tag3, newTag3));
		
		outputTargetSchemas.addAll(Utils.changeRelationsViewName(inputContext3.getTargetSchema().getRelations(),
				viewName3, newViewName));
		
		/*outputForwardConstraints.addAll(Utils
				.replaceConstraintsRelation(Utils.replaceConstraintsRelation(inputContext3.getForwardConstraints(),
						viewName3, tag, newViewName, newTag), newViewName, tag2, newViewName, newTag2));*/
		outputForwardConstraints.addAll(Utils.replaceConstraintsRelation(inputContext3.getForwardConstraints(),
						viewName3, tag3, newViewName, newTag3));
		
		/*outputBackwardConstraints.addAll(Utils
				.replaceConstraintsRelation(Utils.replaceConstraintsRelation(inputContext3.getBackwardConstraints(),
						viewName3, tag, newViewName, newTag), newViewName, tag2, newViewName, newTag2));*/
		outputBackwardConstraints.addAll(Utils.replaceConstraintsRelation(inputContext3.getBackwardConstraints(),
						viewName3, tag3, newViewName, newTag3));
						
	}
		return new Context(new RelationalSchema(new ArrayList<>(outputGeneralSchemas)),
				new RelationalSchema(new ArrayList<>(outputTargetSchemas)), new ArrayList<>(outputForwardConstraints),
				new ArrayList<>(outputBackwardConstraints));
	}
}
