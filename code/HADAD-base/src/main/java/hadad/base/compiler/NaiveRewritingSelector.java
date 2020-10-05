package hadad.base.compiler;

import java.util.Collection;

import com.google.inject.Singleton;

import hadad.commons.conjunctivequery.ConjunctiveQuery;

/**
 * Naive implementation that returns the (first) rewriting with the smaller
 * number of atoms in the collection.
 */
@Singleton
public class NaiveRewritingSelector implements RewritingSelector {

    @Override
    public ConjunctiveQuery select(final Collection<ConjunctiveQuery> rewritings) throws IllegalArgumentException {
        if (rewritings.isEmpty()) {
            throw new IllegalArgumentException("The rewritings collection is empty.");
        }
        int minSize = 0;
        ConjunctiveQuery minRewriting = null;
        for (final ConjunctiveQuery rewriting : rewritings) {
            final int size = rewriting.getBody().size();
            if (minRewriting == null || size < minSize) {
                minSize = size;
                minRewriting = rewriting;
            }
        }
        return minRewriting;
    }

}
