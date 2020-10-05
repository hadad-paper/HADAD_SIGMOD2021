package hadad.base.compiler;

/**
 * Visitor pattern.
 *
 * Provides a way to navigate (similarly to a functional fold) the elements of a
 * nested block tree.
 */
public interface QueryBlockTreeVisitor {
    void visit(final QueryBlockTree tree);

    void visit(final RootBlock block);

    void visit(final ChildBlock block);
}
