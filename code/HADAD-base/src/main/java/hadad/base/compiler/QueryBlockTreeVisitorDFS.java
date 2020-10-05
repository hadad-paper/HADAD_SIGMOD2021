package hadad.base.compiler;

/**
 * Visitor pattern.
 *
 * Provides a DFS way to navigate the elements of a query block tree.
 */
public interface QueryBlockTreeVisitorDFS {
    void visit(final QueryBlockTree tree);

    void visit(final RootBlock block);

    void visit(final ChildBlock block);

    void visitPre(final QueryBlockTree block);

    void visitPost(final QueryBlockTree block);

    void visitPre(final RootBlock block);

    void visitPre(final ChildBlock block);

    void visitPost(final RootBlock block);

    void visitPost(final ChildBlock block);

}
