package hadad.base.compiler;

import hadad.commons.conjunctivequery.Variable;

/**
 * Element factory.
 *
 * Creates the corresponding element.
 */
public class ElementFactory {
    /**
     * Attempts to creates an element.
     *
     * @throws RuntimeException
     */
    public static Element createElement(final Object o) throws RuntimeException {
        if (o instanceof String) {
            return new StringElement((String) o);
        }
        if (o instanceof Variable) {
            return new VariableElement((Variable) o);
        }
        throw new RuntimeException();
    }
}
