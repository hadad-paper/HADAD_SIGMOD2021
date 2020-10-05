package hadad.base.compiler;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Interval;

/**
 * Provides some common methods for Antlr,
 */
public final class AntlrUtils {
    /**
     * Returns the original text (preserving white spaces) of the given context.
     *
     * @param context
     *            the parse rule context whose original text (preserving white
     *            spaces) is wanted.
     * @return original text (preserving white spaces) of the given context.
     */
    public static String getFullText(final ParserRuleContext context) {
        if (context.start == null || context.stop == null || context.start.getStartIndex() < 0
                || context.stop.getStopIndex() < 0) {
            return context.getText();
        }

        return context.start.getInputStream()
                .getText(Interval.of(context.start.getStartIndex(), context.stop.getStopIndex()));
    }
}
