package hadad.base.rewriter;

import java.util.List;

import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.base.compiler.BlockEncoder;
import hadad.base.compiler.ChildBlock;
import hadad.base.compiler.Model;
import hadad.base.compiler.QueryBlockTree;
import hadad.base.compiler.QueryBlockTreeBuilder;
import hadad.base.compiler.RewritingSelector;
import hadad.base.compiler.RootBlock;
import hadad.base.compiler.exceptions.CompilationException;

/**
 * Nested block tree (query) compiler interface.
 *
 *   
 */
public interface NestedBlockTreeRewriter {
    /**
     * Compiles the given (query) nested block tree into a compiled (rewritten
     * query) nested block tree.
     *
     * Throws a compilation error if it cannot be accomplished.
     *
     * @param model
     *            the model of the query to be rewritten.
     * @param nbt
     *            the query (nested block tree) to be rewritten (compiled).
     * @return the compiled (rewritten query) nested block tree for the given
     *         (query) nested block tree with the specified rewriter.
     */
    default QueryBlockTree compileQuery(final Model model, final QueryBlockTree nbt) throws CompilationException {
        return new QueryBlockTree(compileBlock(nbt.getRoot(), rewriters(), selector(), model.getBlockEncoder(),
                model.getNestedBlockTreeBuilder()));
    }

    /**
     * Returns the list of rewriters to be used to rewrite (compile) a
     * conjunctive query.
     *
     * @return the list of rewriters to be used to rewrite (compile) a
     *         conjunctive query (nested block tree). Rewriters are in order of
     *         appliance, with the initial query as input for the first one, its
     *         rewriting as input for the second one and so on. The output of
     *         the last rewriter is the rewriting for the query.
     */
    List<ConjunctiveQueryRewriter> rewriters();

    /**
     * Returns the rewriting selector to be used to select a conjunctive query
     * rewriting among the available ones, if any.
     *
     * @return the selector to be used to select the conjunctive query
     *         rewriting.
     */
    RewritingSelector selector();

    /**
     * Compiles the given root block with the specified rewriter into a compiled
     * root block.
     *
     * Throws a compilation error if it cannot be accomplished.
     *
     * @param block
     *            the root block to be rewritten (compiled).
     * @param rewriters
     *            the rewriters to be used to rewrite (compile) the query
     *            (nested block tree). Rewriters are applied in order, with the
     *            initial query as input for the first one, its rewriting as
     *            input for the second one and so on. The output of the last
     *            rewriter is the rewriting for the query.
     * @param selector
     *            the selector to be used to select the (pattern) rewriting.
     * @param encoder
     *            the block encoder into conjunctive query.
     * @param builder
     *            the nested block tree builder to construct the compiled
     *            pattern from the rewritten one.
     * @return the compiled root block for the given root block with the
     *         specified rewriter.
     */
    default RootBlock compileBlock(final RootBlock block, final List<ConjunctiveQueryRewriter> rewriters,
            final RewritingSelector selector, final BlockEncoder encoder, final QueryBlockTreeBuilder builder)
            throws CompilationException {
        final RootBlock compiledBlock = block.getPattern().isEmpty() ? block
                : new RootBlock(block.getQueryName(),
                        compileBlock(block.encoding(encoder), rewriters, selector, builder), block.getReturnTemplate());
        for (final ChildBlock child : block.getChildren()) {
            compiledBlock.addChild(compileBlock(child, rewriters, selector, encoder, builder));
        }
        return compiledBlock;
    }

    /**
     * Compiles the given child block with the specified rewriter into a
     * compiled child block.
     *
     * Throws a compilation error if it cannot be accomplished.
     *
     * @param block
     *            the child block to be rewritten (compiled).
     * @param rewriters
     *            the rewriters to be used to rewrite (compile) the query
     *            (nested block tree). Rewriters are applied in order, with the
     *            initial query as input for the first one, its rewriting as
     *            input for the second one and so on. The output of the last
     *            rewriter is the rewriting for the query.
     * @param selector
     *            the selector to be used to select the (pattern) rewriting.
     * @param encoder
     *            the block encoder into conjunctive query.
     * @param builder
     *            the nested block tree builder to construct the compiled
     *            pattern from the rewritten one.
     * @return the compiled child block for the given child block with the
     *         specified rewriter.
     */
    default ChildBlock compileBlock(final ChildBlock block, final List<ConjunctiveQueryRewriter> rewriters,
            final RewritingSelector selector, final BlockEncoder encoder, final QueryBlockTreeBuilder builder)
            throws CompilationException {
        final ChildBlock compiledBlock = new ChildBlock(block.getParent(),
                compileBlock(block.encoding(encoder), rewriters, selector, builder), block.getReturnTemplate());
        for (final ChildBlock child : block.getChildren()) {
            compiledBlock.addChild(compileBlock(child, rewriters, selector, encoder, builder));
        }
        return compiledBlock;
    }

    /**
     * Compiles the given pattern with the specified rewriter into a compiled
     * pattern.
     *
     * Throws a compilation error if it cannot be accomplished.
     *
     * @param pattern
     *            the pattern to be rewritten (compiled).
     * @param rewriters
     *            the rewriters to be used to rewrite (compile) the query
     *            (nested block tree). Rewriters are applied in order, with the
     *            initial query as input for the first one, its rewriting as
     *            input for the second one and so on. The output of the last
     *            rewriter is the rewriting for the query.
     * @param selector
     *            the selector to be used to select the (pattern) rewriting.
     * @param builder
     *            the nested block tree builder to construct the compiled
     *            pattern from the rewritten one.
     * @return the compiled pattern for the given pattern with the specified
     *         rewriter.
     */
    default ConjunctiveQuery compileBlock(final ConjunctiveQuery query, final List<ConjunctiveQueryRewriter> rewriters,
            final RewritingSelector selector, final QueryBlockTreeBuilder builder) throws CompilationException {
        if (rewriters.isEmpty()) {
            throw new CompilationException("Rewriter(s) expected.");
        }
        ConjunctiveQuery rewriting = query;
        for (final ConjunctiveQueryRewriter rewriter : rewriters) {
            try {
                rewriting = selector.select(rewriter.getReformulations(query));
            } catch (Exception e) {
                throw new CompilationException(e);
            }
        }
        return rewriting;
    }
}
