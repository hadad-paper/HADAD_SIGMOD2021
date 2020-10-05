package hadad.base.compiler;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.Objects;

import com.rits.cloning.Cloner;

/**
 * Part of query block tree data structure.
 *
 * We call s block tree of a query V the tree structure arranging the
 * blocks that reflects (in the parent-child relationship) the immediate nesting
 * relationship of the syntax.
 * 
 */
public final class QueryBlockTree {
    /* The nested block tree root. */
    private final RootBlock root;

    /**
     * Constructs a new nested block tree with the specified root.
     *
     * @param root
     *            the nested block tree root.
     */
    public QueryBlockTree(final RootBlock root) {
        this.root = checkNotNull(root);
    }

    /**
     * Returns the root block of this nested block tree.
     *
     * @return the root block of this nested block tree.
     */
    public RootBlock getRoot() {
        return root;
    }

    /**
     * The query name of the query represented by this nested block tree.
     *
     * @return the query name of the query represented by nested block tree.
     */
    public String getQueryName() {
        return root.getQueryName();
    }

    /**
     * Visitor pattern.
     *
     * Provides a way to navigate the elements of a nested block tree.
     *
     * @param visitor
     *            the nested block tree visitor implementation.
     */
    public void accept(final QueryBlockTreeVisitor visitor) {
        visitor.visit(this);
        root.accept(visitor);
    }

    /**
     * Visitor pattern in DFS.
     *
     * Provides a DFS way to navigate the elements of a nested block tree .
     *
     * @param visitor
     *            the nested block tree visitor implementation.
     */
    public void acceptDFS(final QueryBlockTreeVisitorDFS visitor) {
        visitor.visit(this);
        root.acceptDFS(visitor);
    }

    /**
     * The height of this nested block tree.
     *
     * @return the height of this nested block tree.
     */
    public int height() {
        return root.height();
    }

    public QueryBlockTree deepClone() {
        final Cloner cloner = new Cloner();
        return cloner.deepClone(this);
    }

    @Override
    public String toString() {
        return root.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(root);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof QueryBlockTree)) {
            return false;
        }
        return root.equals(((QueryBlockTree) o).root);
    }
}
