package hadad.base.rewriter;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import hadad.commons.constraints.Constraint;
/**
 * Quick hack in order to add comments to the generated constraints files easily
 * and quickly.
 *
 */
public final class Comment extends Constraint {
	/* The comment. */
	private final String comment;

	/**
	 * Constructs a new comment constraint with the specified comment message.
	 *
	 * @param comment
	 *            the comment
	 */
	public Comment(final String comment) {
		super(null);
		this.comment = checkNotNull(comment);
	}

	@Override
	public String toString(){
		return "\n# " + comment + "\n";
	}

	@Override
	public int hashCode() {
		return Objects.hash(comment);
	}

	@Override
	public boolean equals(Object o) {
		return (o instanceof Comment) && comment.equals(((Comment) o).comment);
	}

	@Override
	public boolean isEquivalent(Constraint o) {
		return this.equals(o);
	}
}
