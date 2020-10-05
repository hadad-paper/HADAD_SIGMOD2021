package hadad.base.compiler;

import java.util.LinkedHashSet;
import java.util.Set;

import hadad.base.compiler.exceptions.CompilationException;
import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.conjunctivequery.Term;

/**
 * Query block tree (query) compiler
 */
public interface QueryBlockTreeQueryCompiler {
    /**
     * Compiles the nested block tree
     *
     * @param nbts
     *            the nested block trees.
     * @param includeComments
     *            if <code>true</code> comments will be included.
     * @return the encoded conjunctive query for the specified nested block trees.
     * @throws CompilationException
     */
    default ConjunctiveQuery compileQuery(final QueryBlockTree nbt) throws CompilationException {
        final Set<Atom> queryBody = new LinkedHashSet<>();
        final Set<Term> queryHead = new LinkedHashSet<>();
        queryBody.addAll(compilePattern(nbt.getRoot().getPattern()));
        queryHead.addAll(compileReturnTemplate(nbt.getRoot().getReturnTemplate()));

        return new ConjunctiveQuery(queryHead, queryBody);
    }

    /**
     * Compiles the pattern for the specified query block tree.
     *
     * @param nbt
     *            the nested block tree.
     * @param includeComments
     *            if <code>true</code> comments will be
     *            included.
     * @return the encoded query body for the specified nested block tree.
     * @throws CompilationException
     */
    Set<? extends Atom> compilePattern(final Pattern nbtPattern) throws CompilationException;

    /**
     * Compiles the return template for the specified query block tree.
     *
     * @param nbt
     *            the nested block tree.
     * @param includeComments
     *            if <code>true</code> comments will be included.
     * @return the encoded query head for the specified nested block tree.
     * @throws CompilationException
     */
    Set<? extends Term> compileReturnTemplate(final ReturnTemplate nbtReturnTemplate) throws CompilationException;
}
