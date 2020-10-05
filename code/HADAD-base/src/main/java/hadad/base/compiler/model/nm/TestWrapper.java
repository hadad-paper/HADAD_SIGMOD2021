package hadad.base.compiler.model.nm;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.google.inject.Guice;
import com.google.inject.Injector;

import hadad.base.compiler.PathExpression;
import hadad.base.compiler.QueryBlockTree;
import hadad.base.compiler.Utils;
import hadad.base.compiler.exceptions.ParseException;
import hadad.base.compiler.model.la.builder.BinaryOperator;
import hadad.base.compiler.model.la.builder.IOperator;
import hadad.base.compiler.model.la.builder.LAPlanBuilder;
import hadad.base.compiler.model.la.builder.UnaryOperator;
import hadad.base.compiler.model.la.builder.estim.MNCCostEstimator;
import hadad.base.compiler.model.la.builder.estim.NaiveCostEstimator;
import hadad.base.rewriter.Context;
import hadad.base.rewriter.PACBConjunctiveQueryRewriter;
import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.constraints.Constraint;
import hadad.commons.constraints.parser.ConstraintParser;
import hadad.commons.relationalschema.RelationalSchema;
import hadad.commons.relationalschema.parser.RelSchemaParser;

public class TestWrapper {
	private static final Logger LOGGER = Logger.getLogger(TestWrapper.class);
	private double time = 0.00;
	private int flag =0;
	private ConjunctiveQuery rw = null;
	private final String BASE_DIR;

	public TestWrapper(final String BASE_DIR, final int falg) {
		this.BASE_DIR = BASE_DIR;
		this.flag=falg;
	}

	public void runTest() throws Exception {
		computeRewritings();
	}

	public void computeRewritings() throws Exception {
		computeRewritings(Utils.parseQuery(getQuery().toString()));
	}

	private StringBuilder getQuery() throws ParseException, IOException {
		Injector injector = null;
		injector = Guice.createInjector(new NMNaiveModule());
		NMQueryBlockTreeBuilder builder = injector.getInstance(NMQueryBlockTreeBuilder.class);
		final QueryBlockTree nbt = builder.buildQueryBlockTree(FileUtils.readFileToString(new File(BASE_DIR + "/NQ")));
		LOGGER.debug(nbt.toString());
		final StringBuilder querystrBuilder = new StringBuilder();
		final Collection<PathExpression> paths = nbt.getRoot().getPattern().getStructural().getPathExpressions();
		final List<Atom> atoms = new ArrayList<>();
		final String queryName = nbt.getRoot().getQueryName();
		final String returnVar = nbt.getRoot().getReturnTemplate().getTerms().get(0).getParent().getElement()
				.toString();
		querystrBuilder.append(queryName);
		querystrBuilder.append("<");
		querystrBuilder.append(returnVar);
		querystrBuilder.append(">:-");

		for (final PathExpression path : paths) {
			atoms.addAll(path.encoding());
		}
		int i = 0;
		for (final Atom atom : atoms) {
			querystrBuilder.append(atom);
			if (i != atoms.size() - 1)
				querystrBuilder.append(",");
			i++;
		}

		querystrBuilder.append(";");
		return querystrBuilder;
	}

	private Context getContext() throws Exception {
		final List<Constraint> fw = parseConstraints(BASE_DIR + "/constraints_chase");
		final List<Constraint> bw = parseConstraints(BASE_DIR + "/constraints_bkchase");
		final List<RelationalSchema> schemas = parseSchemas(BASE_DIR + "/schemas");
		return new Context(schemas.get(0), schemas.get(1), fw, bw);
	}

	private List<Constraint> parseConstraints(final String fileName)
			throws IOException, hadad.commons.constraints.parser.ParseException {
		final FileReader fr = new FileReader(fileName);
		final ConstraintParser parser = new ConstraintParser(fr);
		final List<Constraint> constraints = parser.parse();
		fr.close();
		return constraints;
	}

	private static List<RelationalSchema> parseSchemas(final String fileName)
			throws IOException, hadad.commons.relationalschema.parser.ParseException {
		final FileReader fr = new FileReader(fileName);
		final RelSchemaParser parser = new RelSchemaParser(fr);
		final List<RelationalSchema> constraints = parser.parse();
		fr.close();
		return constraints;
	}

	private PACBConjunctiveQueryRewriter getRewriter() throws Exception {
		return new PACBConjunctiveQueryRewriter(getContext());
	}

	private void computeRewritings(final ConjunctiveQuery query) throws Exception {
		List<ConjunctiveQuery> rws = getRewriter().getReformulations(query);
		System.out.println(rws);
		long rwTime = 0;
		for (int i = 0; i < 100; i++) {
			if (i == 0) {
				rws = getRewriter().getReformulations(query);
			} else {
				long start = System.nanoTime();
				rws = getRewriter().getReformulations(query);
				long end = System.nanoTime();
				rwTime += (end - start);
			}
		}
		time += ((rwTime / 99) * 1e-9);
		if (flag == 1) {
			naive(rws);
		} else {
			mnc(rws);
		}
	}

	private void naive(List<ConjunctiveQuery> rws) {
		double minCost = Double.MAX_VALUE;
		ConjunctiveQuery minRW = null;
		// warm-up
		for (final ConjunctiveQuery rw : rws) {
			final IOperator root = LAPlanBuilder.constructPlan(rw);
			NaiveCostEstimator estimator = null;
			if (root != null) {
				estimator = new NaiveCostEstimator();
				if (root instanceof UnaryOperator) {
					estimator.visit((UnaryOperator) root, null);

				}
				if (root instanceof BinaryOperator) {
					estimator.visit((BinaryOperator) root, null);

				}
				double currentCost = estimator.getEstimatedCost();
				if (currentCost <= minCost) {
					minCost = currentCost;
					minRW = rw;
				}
			}
		}

		long startTime = System.nanoTime();
		for (int i = 0; i < 10; i++) {
			minCost = Double.MAX_VALUE;
			minRW = null;
			for (final ConjunctiveQuery rw : rws) {
				final IOperator root = LAPlanBuilder.constructPlan(rw);
				NaiveCostEstimator estimator = null;
				if (root != null) {
					estimator = new NaiveCostEstimator();
					if (root instanceof UnaryOperator) {
						estimator.visit((UnaryOperator) root, null);

					}
					if (root instanceof BinaryOperator) {
						estimator.visit((BinaryOperator) root, null);

					}
					double currentCost = estimator.getEstimatedCost();
					if (currentCost <= minCost) {
						minCost = currentCost;
						minRW = rw;
					}
				}
			}

		}
		long endTime = System.nanoTime();
		time += (((endTime - startTime) / 10) * 1e-9);
		rw = minRW;
	}

	private void mnc(List<ConjunctiveQuery> rws) {
		double minCost = Double.MAX_VALUE;
		ConjunctiveQuery minRW = null;
		// warm-up
		for (final ConjunctiveQuery rw : rws) {
			final IOperator root = LAPlanBuilder.constructPlan(rw);
			if (root != null) {
				MNCCostEstimator estimator = null;
				estimator = new MNCCostEstimator();
				if (root instanceof UnaryOperator) {
					estimator.visit((UnaryOperator) root, null);

				}
				if (root instanceof BinaryOperator) {
					estimator.visit((BinaryOperator) root, null);

				}
				double currentCost = estimator.getEstimatedCost();
				if (currentCost <= minCost) {
					minCost = currentCost;
					minRW = rw;
				}
			}
		}

		long startTime = System.nanoTime();
		for (int i = 0; i < 10; i++) {
			minCost = Double.MAX_VALUE;
			minRW = null;
			for (final ConjunctiveQuery rw : rws) {
				final IOperator root = LAPlanBuilder.constructPlan(rw);
				MNCCostEstimator estimator = null;
				if (root != null) {
					estimator = new MNCCostEstimator();
					if (root instanceof UnaryOperator) {
						estimator.visit((UnaryOperator) root, null);

					}
					if (root instanceof BinaryOperator) {
						estimator.visit((BinaryOperator) root, null);

					}
					double currentCost = estimator.getEstimatedCost();
					if (currentCost <= minCost) {
						minCost = currentCost;
						minRW = rw;
					}
				}
			}

		}
		long endTime = System.nanoTime();
		time += (((endTime - startTime) / 10) * 1e-9);
		rw = minRW;
	}

	public double getTime() {
		return time;
	}

	public ConjunctiveQuery getRW() {
		return rw;
	}
}
