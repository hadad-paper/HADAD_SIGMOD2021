package hadad.base.compiler;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.Variable;

/**
 * Part of nested block tree data structure.
 */
public final class PathExpression {
	/* The model of this path expression. */
	private final String model;
	/* The variables referred in this path expression. */
	private final ImmutableSet<Variable> referredVariables;
	/* The conjunctive query encoding for this path expression. */
	private final ImmutableList<Atom> encoding;
	/* The optionals for this path expression. */
	private final ImmutableMap<String, String> optionals;
	/* The conjunctive query return variable of this path expression. */
	private final Variable returnVar;

	/**
	 * Constructs a new path expression with the specified model,
	 * referredVariables, encoding and returnVar.
	 *
	 * @param model
	 *            the model for the path expression.
	 * @param referredVariables
	 *            the variables referred for the expression.
	 * @param encoding
	 *            the conjunctive query encoding for the path expression.
	 * @param returnVar
	 *            the optionals for the path expression.
	 */
	public PathExpression(final String model,
			final Set<Variable> referredVariables,
			final List<Atom> encoding, @Nullable final Variable returnVar) {
		this(model, referredVariables, encoding, returnVar,
				new HashMap<String, String>());
	}

	/**
	 * Constructs a new path expression with the specified model,
	 * referredVariables, encoding, returnVar and optionals.
	 *
	 * @param model
	 *            the model for the path expression.
	 * @param referredVariables
	 *            the variables referred for the expression.
	 * @param encoding
	 *            the conjunctive query encoding for the path expression.
	 * @param returnVar
	 *            the optionals for the path expression.
	 * @param optionals
	 *            the conjunctive query return variable for the path expression.
	 */
	public PathExpression(final String model,
			final Set<Variable> referredVariables,
			final List<Atom> encoding, @Nullable final Variable returnVar,
			final Map<String, String> optionals) {
		this.model = checkNotNull(model);
		this.referredVariables = ImmutableSet
				.copyOf(checkNotNull(referredVariables));
		this.encoding = ImmutableList.copyOf(checkNotNull(encoding));
		this.returnVar = returnVar;
		this.optionals = ImmutableMap.copyOf(checkNotNull(optionals));
	}

	/**
	 * Creates a copy of this path expression changing the return variable to
	 * the given one.
	 *
	 * @param returnVar
	 *            the return variable to be used in the copy
	 * @return path expression based on the given one in which the return
	 *         variable is change to the given one.
	 */
	public PathExpression copy(final Variable returnVar) {
		return new PathExpression(model,
				referredVariables,
				encoding.stream()
					.map(a -> replaceReturnVar(a, this.returnVar, returnVar))
					.collect(Collectors.toList()),
				returnVar,
				optionals);
	}

	private Atom replaceReturnVar(final Atom atom,
			final Variable currentVar, final Variable returnVar) {
		return new Atom(atom.getId(),
				atom.getPredicate(),
				atom.getTerms().stream().
					map(t -> t.equals(currentVar) ? returnVar : t)
					.collect(Collectors.toList()));
	}

	/**
	 * The model for this path expression.
	 *
	 * @return model for this path expression.
	 */
	public String getModel() {
		return model;
	}

	/**
	 * Encodes this path expression into relational CQ model.
	 *
	 * @return relational CQ encoding for this path expression.
	 */
	public List<Atom> encoding() {
		return encoding;
	}

	/**
	 * The variables referred in this path expression.
	 *
	 * @return variables referred in this path expression.
	 */
	public Set<Variable> getReferredVariables() {
		return referredVariables;
	}

	/**
	 * The return variable in this path expression.
	 *
	 * @return return variable in this path expression.
	 */
	public Variable getReturnVar() {
		return returnVar;
	}

	/**
	 * The optionals in this path expression.
	 *
	 * @return optionals in this path expression.
	 */
	public Map<String, String> getOptionals() {
		return optionals;
	}

	@Override
	public String toString() {
		return toString(false);
	}

	public String toString(boolean includeReturnVar) {
		final StringBuilder builder = new StringBuilder();
		builder.append(model);
		if (!referredVariables.isEmpty() || includeReturnVar) {
			builder.append("(");
			String prefix = "";
			for (final Variable referredVar : referredVariables) {
				builder.append(prefix).append(referredVar.toString());
				prefix = ", ";
			}
			if (includeReturnVar) {
				builder.append("->").append(returnVar);
			}
			builder.append(")");
		}
		if (!optionals.isEmpty()) {
			builder.append("[").append(optionals.toString()).append("]");
		}
		builder.append("{");
		String prefix = "";
		for (final Atom encodingAtom : encoding) {
			builder.append(prefix).append(encodingAtom.toString());
			prefix = ", ";
		}
		builder.append("}");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(model, referredVariables, encoding, optionals,
				returnVar);
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof PathExpression)) {
			return false;
		}
		final PathExpression p = (PathExpression) o;
		return model.equals(p.model)
				&& referredVariables.equals(p.referredVariables)
				&& encoding.equals(p.encoding) && optionals.equals(p.optionals)
				&& returnVar.equals(p.returnVar);
	}
}
