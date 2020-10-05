package hadad.base.compiler;

import hadad.commons.conjunctivequery.ConjunctiveQuery;

/**
 * Block Decoder
 *
 */
@Deprecated
public interface BlockDecoder {
    String decode(final ConjunctiveQuery query, final ReturnTemplate template);
}
