package hadad.base.rewriter;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.List;

import hadad.db.chase.Assertion;
import hadad.db.chase.Chase;
import hadad.db.chase.DenialConstraint;
import hadad.db.datalogexpr.Value;
import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.constraints.Constraint;
import hadad.commons.miscellaneous.Tuple;
import hadad.commons.relationalschema.Relation;
import hadad.commons.relationalschema.RelationalSchema;
import hadad.base.rewriter.legacy.BackchaseWrapper;

public final class PACBConjunctiveQueryRewriter implements ConjunctiveQueryRewriter {
    /* The chase context */
    private final ChaseContext chaseContext;
    /* The backchase context */
    private final BackchaseContext backchaseContext;

    /**
     * Constructs a rewriter with the specified context.
     *
     * @param context
     *            The provenance aware chase & backchase algorithm context.
     */
    public PACBConjunctiveQueryRewriter(final Context context) {
        chaseContext = ChaseUtils.createChaseContext(checkNotNull(context));
        backchaseContext = BackchaseUtils.createBackchaseContext(checkNotNull(context));
    }

    @Override
    public TimedReformulations getTimedReformulations(final ConjunctiveQuery query) throws Exception {
        flush();

        long start = System.nanoTime();
        final Assertion queryAssertion = ChaseUtils.createQueryAssertion(chaseContext.getDb(), query);
        long finish = System.nanoTime();
        final long queryAssertionTimeInNano = finish - start;

        final List<Assertion> assertions = new ArrayList<Assertion>();
        assertions.add(queryAssertion);
        assertions.addAll(chaseContext.getAssertions());

        final Chase chase = new Chase(chaseContext.getTgds(), chaseContext.getEgds(),new ArrayList<DenialConstraint>(), assertions);

        start = System.nanoTime();
        try {
            chase.run();
        } catch (RuntimeException e) {
            finish = System.nanoTime();
            if (isDocumentNameRelationRelatedException(e)) {
                return new TimedReformulations(queryAssertionTimeInNano, finish - start, -1, -1,
                        new ArrayList<ConjunctiveQuery>());
            } else {
                throw e;
            }
        }
        final ConjunctiveQuery chasedQuery = ChaseUtils.collectResult(query, chaseContext.getDb());
        finish = System.nanoTime();
        final long chaseExecTimeInNano = finish - start;

        start = System.nanoTime();
        final ConjunctiveQuery universalPlan = restrict(chasedQuery, backchaseContext.getTargetSchema());
        finish = System.nanoTime();
        final long restrictExecTimeInNano = finish - start;
        @SuppressWarnings("unchecked")
        final Tuple<Long, List<ConjunctiveQuery>> backchase = BackchaseWrapper.Backchase(query, universalPlan,
                (ArrayList<Constraint>) backchaseContext.getBackwardConstraints(),CBConfig.getProperties());

        final long backchaseExecTimeInNano = backchase.first();
        final List<ConjunctiveQuery> rewritings = backchase.second();

        return new TimedReformulations(queryAssertionTimeInNano, chaseExecTimeInNano, restrictExecTimeInNano,
                backchaseExecTimeInNano, rewritings);
    }

    @Override
    public List<ConjunctiveQuery> getReformulations(final ConjunctiveQuery query) throws Exception {
        flush();

        final Assertion queryAssertion = ChaseUtils.createQueryAssertion(chaseContext.getDb(), query);

        final List<Assertion> assertions = new ArrayList<Assertion>();
        assertions.add(queryAssertion);
        assertions.addAll(chaseContext.getAssertions());

        final Chase chase = new Chase(chaseContext.getTgds(), chaseContext.getEgds(),new ArrayList<DenialConstraint>() ,assertions);

        try {
            chase.run();
        } catch (RuntimeException e) {
            if (isDocumentNameRelationRelatedException(e)) {
                return new ArrayList<ConjunctiveQuery>();
            } else {
                throw e;
            }
        }
        final ConjunctiveQuery chasedQuery = ChaseUtils.collectResult(query, chaseContext.getDb());

        final ConjunctiveQuery universalPlan = restrict(chasedQuery, backchaseContext.getTargetSchema());
        @SuppressWarnings("unchecked")
        final List<ConjunctiveQuery> rewritings = BackchaseWrapper
                .Backchase(query, universalPlan, (ArrayList<Constraint>) backchaseContext.getBackwardConstraints(),CBConfig.getProperties())
                .second();

        return rewritings;
    }

    private boolean isDocumentNameRelationRelatedException(RuntimeException e) {
        return e.getMessage().startsWith("Retrieving relation \"root_");
    }

    private void flush() {
        Value.restartVarIndex();
        chaseContext.flush();
    }

    /**
     * Returns the restricted query wrt a target schema for the specified query
     * and schema.
     *
     * @param query
     *            The query to be restricted.
     * @param schema
     *            The target schema.
     * @return The restricted query with name "U".
     */
    /*
     * TODO: should we restrict also with the relation arity and access patterns
     * (ie. Relation::equals)?
     *
     * Currently the arity check is handled by the PACB and the access patterns
     * are handled in the encoding.
     */
    private static ConjunctiveQuery restrict(final ConjunctiveQuery query, final RelationalSchema targetSchema) {
        final List<Atom> body = new ArrayList<Atom>();

        for (final Atom atom : query.getBody()) {
            for (final Relation relation : targetSchema.getRelations()) {
                if (relation.getName().equals(atom.getPredicate())) {
                    body.add(atom);
                    break;
                }
            }
        }
        return new ConjunctiveQuery("U", query.getHead(), body);
    }
}
