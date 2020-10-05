package hadad.base.compiler.model.sppj;

import com.google.inject.Inject;

import hadad.base.compiler.BlockEncoder;
import hadad.base.compiler.Format;
import hadad.base.compiler.Language;
import hadad.base.compiler.Model;
import hadad.base.compiler.QueryBlockTreeBuilder;

public class SPPJModel extends Model {
    public final static String ID = "SPPJ";

    @Inject
    public SPPJModel(final QueryBlockTreeBuilder queryBlockTreeBuilder, final BlockEncoder blockEncoder) {
        super(ID, Format.JSON, Language.SQLPlusPlus, queryBlockTreeBuilder, blockEncoder);
    }
}
