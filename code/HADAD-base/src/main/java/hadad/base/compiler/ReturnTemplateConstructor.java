package hadad.base.compiler;

import hadad.base.compiler.exceptions.ReturnConstructException;

/**
 * Interface for return template construction.
 */
public interface ReturnTemplateConstructor {
    /**
     * Constructs the given return template using the given row data.
     *
     * @param template
     *            the return template.
     * @param row
     *            the retrieved row to be constructed.
     * @return the constructed element with the retrieved row data and this
     *         return term.
     * @throws ReturnConstructException
     */
    String construct(final ReturnTemplate template, final Row row) throws ReturnConstructException;

    /**
     * Constructs the given return template.
     *
     * @param template
     *            the return template.
     * @return the constructed element with the variables in their positions.
     * @throws ReturnConstructException
     */
    default String construct(final ReturnTemplate template) throws ReturnConstructException {
        return construct(template, null);
    }
}
