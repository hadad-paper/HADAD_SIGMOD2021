package hadad.base.compiler.model.aj;

import com.google.inject.Inject;

import hadad.base.compiler.BlockEncoder;
import hadad.base.compiler.Format;
import hadad.base.compiler.Language;
import hadad.base.compiler.Model;
import hadad.base.compiler.QueryBlockTreeBuilder;

/**
 * AJ Model
 *
 */
public class AJModel extends Model {
    public final static String ID = "AJ";

    @Inject
    public AJModel(final QueryBlockTreeBuilder queryBlockTreeBuilder, final BlockEncoder blockEncoder) {
        super(ID, Format.JSON, Language.AQL, queryBlockTreeBuilder, blockEncoder);
    }
}
