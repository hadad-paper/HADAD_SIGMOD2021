package hadad.base.compiler;

import com.google.common.collect.ImmutableMap;

import hadad.base.compiler.exceptions.ParseException;
import hadad.commons.conjunctivequery.Variable;

/**
 * Builder pattern.
 *
 * Provides a way to build path expressions, return templates and nested block
 * trees from the syntax (encode), and build path expressions and patterns from
 * conjunctive queries (decode).
 *
 * Path expression and return template encoding is used to create multi-model
 * nested block trees.
 *
 * Path expression and pattern decoding is used to create (PACB) rewritten
 * nested block trees
 */
public interface QueryBlockTreeBuilder {
    /**
     * Parse the given path expression and return a path expression instance.
     *
     * @param str
     *            path expression string
     *
     * @return the path expression
     * @throws ParseException
     */
    PathExpression buildPathExpression(final String str) throws ParseException;

    /**
     * Parse the given return template and return a return template instance.
     *
     * @param definitions
     *            the definitions available in this return template (used for
     *            the path expression optionals).
     * @param str
     *            return template string
     *
     * @return the return template
     * @throws ParseException
     */
    ReturnTemplate buildReturnTemplate(ImmutableMap<Variable, PathExpression> definitions, final String str)
            throws ParseException;

    /**
     * Parse the given query expression string and return a child instance.
     *
     * @param str
     *            query expression string
     * @return the query block tree instance
     * @throws ParseException
     */
    QueryBlockTree buildQueryBlockTree(final String str) throws ParseException;

    /**
     * Parse the given pattern expression string and a pattern instance
     * 
     * @param str
     *            pattern expression string
     * @return the pattern instance
     * @throws ParseException
     */
    Pattern buildPattern(final String str) throws ParseException;
}
