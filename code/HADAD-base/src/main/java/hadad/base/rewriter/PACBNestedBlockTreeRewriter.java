package hadad.base.rewriter;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.IOException;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import hadad.commons.relationalschema.RelationalSchema;
import hadad.commons.relationalschema.parser.ParseException;
import hadad.base.compiler.RewritingSelector;

/**
 * Nested block tree PACB rewriter implementation.
 *
 *   
 */
@Singleton
public class PACBNestedBlockTreeRewriter implements NestedBlockTreeRewriter {
	/*
	 * The list of rewriters to be used to rewrite (compile) a conjunctive query
	 * (nested block tree) with this compiler. Rewriters are in order of
	 * appliance, with the initial query as input for the first one, its
	 * rewriting as input for the second one and so on. The output of the last
	 * rewriter is the rewriting for the query.
	 */
	private final ImmutableList<ConjunctiveQueryRewriter> rewriters;
	/*
	 * The selector to be used to select the conjunctive query rewriting.
	 */
	private final RewritingSelector selector;

	@Inject
	public PACBNestedBlockTreeRewriter(
			@Named("rewriters.forward_constraints_file_name_prefix") final String rewritersForwardConstraintsFileNamePrefix,
			@Named("rewriters.backward_constraints_file_name_prefix") final String rewritersBackwardConstraintsFileNamePrefix,
			@Named("rewriters.schemas_file_name_prefix") final String rewritersSchemasFileNamePrefix,
			@Named("rewriters.context_suffixes") final String rewritersContextSuffixes,
			final RewritingSelector selector) throws IOException,
			ParseException, hadad.commons.constraints.parser.ParseException {
		this.rewriters = rewriters(rewritersForwardConstraintsFileNamePrefix,
				rewritersBackwardConstraintsFileNamePrefix,
				rewritersSchemasFileNamePrefix,
				rewritersContextSuffixes.split(","));
		this.selector = checkNotNull(selector);
	}

	private static ImmutableList<ConjunctiveQueryRewriter> rewriters(
			final String forwardConstraintsFileNamePrefix,
			final String backwardConstraintsFileNamePrefix,
			final String schemasFileNamePrefix, final String[] contextSuffixes)
			throws IOException, ParseException,
			hadad.commons.constraints.parser.ParseException {
		final ImmutableList.Builder<ConjunctiveQueryRewriter> builder = ImmutableList.builder();
		for (final String contextSuffix : contextSuffixes) {
			final List<RelationalSchema> schemas = hadad.base.rewriter.server.Utils
					.parseSchemas(schemasFileNamePrefix + contextSuffix);
			builder.add(new PACBConjunctiveQueryRewriter(
					new Context(
							schemas.get(0),
							schemas.get(1),
							hadad.base.rewriter.server.Utils
								.parseConstraints(forwardConstraintsFileNamePrefix
									+ contextSuffix),
							hadad.base.rewriter.server.Utils
								.parseConstraints(backwardConstraintsFileNamePrefix
									+ contextSuffix))
					));
		}
		return builder.build();
	}

	@Override
	public List<ConjunctiveQueryRewriter> rewriters() {
		return rewriters;
	}

	@Override
	public RewritingSelector selector() {
		return selector;
	}
}
