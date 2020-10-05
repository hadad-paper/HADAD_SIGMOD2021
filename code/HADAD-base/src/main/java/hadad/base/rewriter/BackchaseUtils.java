package hadad.base.rewriter;

public final class BackchaseUtils {
	/**
	 * Returns the backchase context for the specified context.
	 *
	 * @param context
	 *            The provenance aware chase & backchase algorithm context.
	 * @return The chase context for the specified context.
	 */
	public static BackchaseContext createBackchaseContext(final Context context) {
		return new BackchaseContext(context.getTargetSchema(),
				context.getBackwardConstraints());
	}
}
