package hadad.base.compiler;

import hadad.commons.conjunctivequery.ConjunctiveQuery;

/**
 * Block Encoder
 */
public interface BlockEncoder {
    ConjunctiveQuery encode(final Block block);
}
