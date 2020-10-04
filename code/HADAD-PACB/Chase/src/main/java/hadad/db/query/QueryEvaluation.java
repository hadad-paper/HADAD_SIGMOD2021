package hadad.db.query;

import java.util.LinkedList;
import java.util.logging.Logger;

import hadad.db.canonicaldb.Tuple;

/**
 * Takes as input a query tree and evaluates the corresponding query.
 */
public class QueryEvaluation {

    /** Logger */
    private final static Logger LOGGER = Logger.getLogger(QueryEvaluation.class.getName());
    /** The query tree */
    private final QueryTree queryTree;
    /** Flush flag */
    boolean flushed = false;

    /**
     * Constructor.
     * 
     * @param tree
     *            the query tree
     */
    public QueryEvaluation(final QueryTree queryTree) {
        this.queryTree = queryTree;
    }

    /**
     * Run the query evaluation
     * 
     * @return the result list of tuples
     */
    public LinkedList<Tuple> run() {
        if (flushed) {
            queryTree.initialize();
            flushed = false;
        }
        final Operator root = queryTree.getRoot();
        boolean rootBlocked = root.blocked;
        root.unblock();

        final LinkedList<Tuple> result = root.all();

        if (rootBlocked)
            root.block();

        return result;
    }

    public void flush() {
        queryTree.flush();
        flushed = true;
    }
    public QueryTree getQueryTree() {
        return queryTree;
    }
    // TODO: Does it work on boolean queries (i.e. with empty head) and
    // what does it return?
    // TODO: If the query has constants in the head, at the last step the
    // produced tuples have to be extended by the constant at the right position
    // The same holds if the query has in the head the same variable
    // multiple times
    // TODO: The static analysis has to change if we are not evaluating the
    // query through a left deep join tree
}