package hadad.base.rewriter;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;

import hadad.commons.constraints.Constraint;
import hadad.commons.relationalschema.RelationalSchema;

public final class BackchaseContext {
	/*
	 * The target relational schema (contains only those relations that are in
	 * the target schema) for this backchase context.
	 */
	private final RelationalSchema targetSchema;
	/* The constraints for this backchase context. */
	private final ImmutableList<? extends Constraint> backwardConstraints;

	/**
	 * Constructs a new backchase context with the specified target schema and
	 * backward constraints.
	 *
	 * @param targetSchema
	 *            the target relational schema (contains only those relations
	 *            that are in the target schema) for the backchase context.
	 * @param backwardConstraints
	 *            the constraints for the backchase context.
	 */
	public BackchaseContext(final RelationalSchema targetSchema,
			final List<? extends Constraint> backwardConstraints) {
		this.targetSchema = checkNotNull(targetSchema);
		this.backwardConstraints = ImmutableList
				.copyOf(checkNotNull(backwardConstraints));
	}

	/**
	 * The target relational schema (contains only those relations that are in
	 * the target schema) of this backchase context.
	 *
	 * @return the target relational schema (contains only those relations that
	 *         are in the target schema) of this backchase context.
	 */
	public final RelationalSchema getTargetSchema() {
		return targetSchema;
	}

	/**
	 * The constraints for the backchase of this backchase context.
	 *
	 * @return the constraints for the backchase of this backchase context.
	 */
	// TODO return the backwardConstraints as soon as the
	// BackchaseWrapper::Backchase accepts List<Constraint> instead of
	// ArrayList<Constraint> (ie. once the legay code is gone).
	public final List<? extends Constraint> getBackwardConstraints() {
		return new ArrayList<Constraint>(backwardConstraints);
	}
}
