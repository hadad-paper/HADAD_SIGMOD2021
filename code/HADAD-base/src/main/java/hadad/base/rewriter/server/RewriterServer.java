package hadad.base.rewriter.server;

import static com.google.common.base.Preconditions.checkNotNull;
import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.conjunctivequery.parser.CQParser;
import hadad.commons.conjunctivequery.parser.ParseException;
import hadad.base.rewriter.PACBConjunctiveQueryRewriter;
import hadad.base.rewriter.ConjunctiveQueryRewriter;
import io.vertx.core.Vertx;
import io.vertx.core.http.HttpHeaders;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.BodyHandler;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

final class RewriterServer {
	private final String schemasFileName;
	private final String forwardConstraintsFileName;
	private final String backwardConstraintsFileName;
	private final String httpHeaderAccessControlAllowOrigin;
	private final String httpHeaderAccessControlAllowMethods;

	private final HttpServer server;
	private final Router router;
	private ConjunctiveQueryRewriter rewriter;

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new RewriterServerModule());
		injector.getInstance(RewriterServer.class);
	}

	/**
	 * Constructs a new rewriter server.
	 *
	 * @param port
	 *            The port on which the server listens.
	 * @param schemasFileName
	 *            The general and target relational schemas file name.
	 * @param forwardConstraintsFileName
	 *            The forward constraints file name.
	 * @param backwardConstraintsFileName
	 *            The backward constraints file name.
	 * @param httpHeaderAccessControlAllowOrigin
	 *            The http header access control allow origin value.
	 * @param httpHeaderAccessControlAllowMethods
	 *            The http header access control allow methods value.
	 * @throws IOException
	 * @throws hadad.commons.constraints.parser.ParseException
	 * @throws hadad.commons.relationalschema.parser.ParseException
	 */
	@Inject
	private RewriterServer(
			@Named("server_port") int port,
			@Named("schemas_file_name") final String schemasFileName,
			@Named("forward_constraints_file_name") final String forwardConstraintsFileName,
			@Named("backward_constraints_file_name") final String backwardConstraintsFileName,
			@Named("http_header.access_control_allow_origin") final String httpHeaderAccessControlAllowOrigin,
			@Named("http_header.access_control_allow_methods") final String httpHeaderAccessControlAllowMethods)
			throws IOException,
	hadad.commons.constraints.parser.ParseException,
	hadad.commons.relationalschema.parser.ParseException {
		this.schemasFileName = checkNotNull(schemasFileName);
		this.forwardConstraintsFileName = checkNotNull(forwardConstraintsFileName);
		this.backwardConstraintsFileName = checkNotNull(backwardConstraintsFileName);
		this.httpHeaderAccessControlAllowOrigin = checkNotNull(httpHeaderAccessControlAllowOrigin);
		this.httpHeaderAccessControlAllowMethods = checkNotNull(httpHeaderAccessControlAllowMethods);

		Vertx vertx = Vertx.vertx();
		server = vertx.createHttpServer();
		router = Router.router(vertx);
		routeRestartService();
		routeComputeRewritingsService();
		routeCompileQueryService();
		server.requestHandler(router::accept).listen(port);

		reloadContext();
	}

	private void reloadContext() throws IOException,
			hadad.commons.constraints.parser.ParseException,
			hadad.commons.relationalschema.parser.ParseException {
		rewriter = new PACBConjunctiveQueryRewriter(Utils.parseContext(schemasFileName,
				forwardConstraintsFileName, backwardConstraintsFileName));
	}

	private void putAccessControlHeaders(final HttpServerResponse response) {
		response.putHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN,
				httpHeaderAccessControlAllowOrigin);
		response.putHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS,
				httpHeaderAccessControlAllowMethods);
	}

	private void routeRestartService() {
		final String url = "/restart/";
		router.route(url).handler(BodyHandler.create());
		Route route = router.route(url);

		route.blockingHandler(routingContext -> {
			try {
				reloadContext();
				HttpServerResponse response = routingContext.response();
				response.putHeader(HttpHeaders.CONTENT_TYPE, "application/json");
				putAccessControlHeaders(response);
				final Map<String, Object> responseBody = new HashMap<String, Object>();
				responseBody.put("message", "OK");
				final Gson gson = new Gson();
				response.end(gson.toJson(responseBody));
			} catch (Exception e) {
				handleException(routingContext, e);
			}
		});
	}

	private void routeComputeRewritingsService() {
		final String url = "/rewritings/";
		router.route(url).handler(BodyHandler.create());
		Route route = router.route(url);

		route.blockingHandler(routingContext -> {
			final int executions = Integer.valueOf(routingContext.request()
					.getParam("executions"));
			final String query = routingContext.request().getParam(
					"query");
			final boolean prettify = Boolean.valueOf(routingContext.request()
					.getParam("prettify"));
			try {

				// This handler will be called for every request
				HttpServerResponse response = routingContext.response();
				response.putHeader(HttpHeaders.CONTENT_TYPE, "application/json");
				putAccessControlHeaders(response);
				final Execution execution = getExecution(executions, query);
				// Write to the response and end it
				final Map<String, Object> responseBody = new HashMap<String, Object>();
				responseBody.put("execution_time_in_ms",
						execution.getQueryExecutionAverageTimeInMilliseconds());
				responseBody.put("rewritings",
						prettify ? prettify(execution.getRewritings())
								: execution.getRewritings());
				final Gson gson = new Gson();
				response.end(gson.toJson(responseBody));
			} catch (Exception e) {
				handleException(routingContext, e);
			}
		});
	}

	private void routeCompileQueryService() {
		final String url = "/compile/query/";
		router.route(url).handler(BodyHandler.create());
		Route route = router.route(url);

		route.blockingHandler(routingContext -> {
			final String query = routingContext.request().getParam("query");
			final boolean prettify = Boolean.valueOf(routingContext.request()
					.getParam("prettify"));
			try {

				// This handler will be called for every request
				HttpServerResponse response = routingContext.response();
				response.putHeader(HttpHeaders.CONTENT_TYPE, "application/json");
				putAccessControlHeaders(response);
				final ConjunctiveQuery compiledQuery = getQueryCompilation(query);
				// Write to the response and end it
				final Map<String, Object> responseBody = new HashMap<String, Object>();
				responseBody.put("query", prettify ? compiledQuery.toString()
						: compiledQuery);
				final Gson gson = new Gson();
				response.end(gson.toJson(responseBody));
			} catch (Exception e) {
				handleException(routingContext, e);
			}
		});
	}

	private ConjunctiveQuery getQueryCompilation(final String queryString)
			throws Exception {
		throw new Exception("Method not implemented.");
	}

	private List<String> prettify(final List<ConjunctiveQuery> rewritings) {
		final List<String> rewritingStrings = new ArrayList<String>();
		for (final ConjunctiveQuery rw : rewritings) {
			rewritingStrings.add(hadad.base.rewriter.legacy.Utils
					.fromQueryToString(rw));
		}
		return rewritingStrings;
	}

	private Execution getExecution(int executions, final String queryString)
			throws Exception {
		final ConjunctiveQuery query = parseQuery(queryString);
		final long[] executionTimesInMilliseconds = new long[executions];
		List<ConjunctiveQuery> rewritings = null;
		for (int executionCounter = 0; executionCounter < executions; executionCounter++) {
			final long start = System.currentTimeMillis();
			rewritings = rewriter.getReformulations(query);
			final long executionTimeInMilliseconds = System.currentTimeMillis()
					- start;
			executionTimesInMilliseconds[executionCounter] = executionTimeInMilliseconds;
		}

		return new Execution(executionTimesInMilliseconds, rewritings);
	}

	/**
	 * @param e
	 */
	protected static final void handleException(
			final RoutingContext routingContext, final Exception e) {
		// This handler will be called for every request
		HttpServerResponse response = routingContext.response();
		response.setStatusCode(500);
		response.putHeader(HttpHeaders.CONTENT_TYPE, "text/plain");

		// Write to the response and end it
		response.end("Server error: " + e.getClass());
		e.printStackTrace();
	}

	private ConjunctiveQuery parseQuery(final String str)
			throws ParseException, IllegalArgumentException {
		final CQParser parser = new CQParser(new StringReader(str));
		final Map<String, ConjunctiveQuery> queries = parser.parse();
		if (queries.size() != 1) {
			throw new IllegalArgumentException(
					"The query string is not a valid RDF CQ.");
		}
		return queries.values().iterator().next();
	}

	/**
	 * Query execution struct.
	 *
	 *   
	 */
	public class Execution {
		private final long[] executionTimesInMilliseconds;
		private final List<ConjunctiveQuery> rewritings;

		public Execution(long[] executionTimesInMilliseconds,
				final List<ConjunctiveQuery> rewritings) {
			this.executionTimesInMilliseconds = executionTimesInMilliseconds;
			this.rewritings = rewritings;
		}

		/**
		 * Returns the average execution time (in milliseconds).
		 *
		 * @return average execution time in milliseconds
		 */
		public final double getQueryExecutionAverageTimeInMilliseconds() {
			long sumOfExecutionTimesInMilliseconds = 0;
			for (long executionTimeInMilliseconds : executionTimesInMilliseconds) {
				sumOfExecutionTimesInMilliseconds += executionTimeInMilliseconds;
			}
			return (double) sumOfExecutionTimesInMilliseconds
					/ executionTimesInMilliseconds.length;
		}

		/**
		 * Returns the rewritings.
		 *
		 * @return rewritings
		 */
		public List<ConjunctiveQuery> getRewritings() {
			return rewritings;
		}
	}

}