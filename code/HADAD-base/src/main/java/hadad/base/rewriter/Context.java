package hadad.base.rewriter;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;

import hadad.commons.constraints.Constraint;
import hadad.commons.relationalschema.Relation;
import hadad.commons.relationalschema.RelationalSchema;

/**
 * Represents a context for the provenance aware chase and backchase rewriting
 * algorithm (in short, PACB)
 */
public final class Context {
    /* The global relational schema (contains all the relations). */
    private final RelationalSchema globalSchema;
    /*
     * The target relational schema (contains only those relations that are in
     * the target schema).
     */
    private final RelationalSchema targetSchema;
    /* The constraints for the chase. */
    private final ImmutableList<? extends Constraint> forwardConstraints;
    /* The constraints for the backchase. */
    private final ImmutableList<? extends Constraint> backwardConstraints;

    /**
     * Constructs a new PACB context with the specified global and target
     * schemas, forward and backward constraints.
     *
     * @param globalSchema
     *            the global relational schema (contains all the relations).
     * @param targetSchema
     *            the target relational schema (contains only those relations
     *            that are in the target schema).
     * @param forwardConstraints
     *            the constraints for the chase.
     * @param backwardConstraints
     *            the constraints for the backchase.
     */
    public Context(final RelationalSchema globalSchema, final RelationalSchema targetSchema,
            final List<? extends Constraint> forwardConstraints, final List<? extends Constraint> backwardConstraints) {
        this.globalSchema = checkNotNull(globalSchema);
        this.targetSchema = checkNotNull(targetSchema);
        this.forwardConstraints = ImmutableList.copyOf(checkNotNull(forwardConstraints));
        this.backwardConstraints = ImmutableList.copyOf(checkNotNull(backwardConstraints));
    }

    /**
     * The global relational schema (contains all the relations) of this
     * context.
     *
     * @return the global relational schema (contains all the relations) of this
     *         context.
     */
    public final RelationalSchema getGlobalSchema() {
        return globalSchema;
    }

    /**
     * The target relational schema (contains only those relations that are in
     * the target schema) of this context.
     *
     * @return the target relational schema (contains only those relations that
     *         are in the target schema) of this context.
     */
    public final RelationalSchema getTargetSchema() {
        return targetSchema;
    }

    /**
     * The constraints for the chase of this context.
     *
     * @return the constraints for the chase of this context.
     */
    public final List<? extends Constraint> getForwardConstraints() {
        return forwardConstraints;
    }

    /**
     * The constraints for the backchase of this context.
     *
     * @return the constraints for the backchase of this context.
     */
    public final List<? extends Constraint> getBackwardConstraints() {
        return backwardConstraints;
    }

    public static Context union(final Context c1, final Context... C) {
        final List<Relation> globalSchemaRelations = new ArrayList<>(c1.globalSchema.getRelations());
        final List<Relation> targetSchemaRelations = new ArrayList<>(c1.targetSchema.getRelations());
        final List<Constraint> forwardConstraints = new ArrayList<>(c1.forwardConstraints);
        final List<Constraint> backwardConstraints = new ArrayList<>(c1.backwardConstraints);
        for (final Context c2 : C) {
            for (final Relation r : c2.globalSchema.getRelations()) {
                if (!globalSchemaRelations.contains(r)) {
                    globalSchemaRelations.add(r);
                }
            }
            for (final Relation r : c2.targetSchema.getRelations()) {
                if (!targetSchemaRelations.contains(r)) {
                    targetSchemaRelations.add(r);
                }
            }
            forwardConstraints.addAll(c2.forwardConstraints);
            backwardConstraints.addAll(c2.backwardConstraints);
        }
        return new Context(new RelationalSchema(globalSchemaRelations), new RelationalSchema(targetSchemaRelations),
                forwardConstraints, backwardConstraints);
    }
}
