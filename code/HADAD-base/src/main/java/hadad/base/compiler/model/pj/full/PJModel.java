package hadad.base.compiler.model.pj.full;

import com.google.inject.Inject;

import hadad.base.compiler.BlockEncoder;
import hadad.base.compiler.Format;
import hadad.base.compiler.Language;
import hadad.base.compiler.Model;
import hadad.base.compiler.QueryBlockTreeBuilder;

public class PJModel extends Model {
    public final static String ID = "PJ";

    @Inject
    public PJModel(final QueryBlockTreeBuilder queryBlockTreeBuilder, final BlockEncoder blockEncoder) {
        super(ID, Format.JSON, Language.PJSQL, queryBlockTreeBuilder, blockEncoder);
    }
}
