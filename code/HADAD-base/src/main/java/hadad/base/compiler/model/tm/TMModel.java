package hadad.base.compiler.model.tm;

import com.google.inject.Inject;

import hadad.base.compiler.BlockEncoder;
import hadad.base.compiler.Format;
import hadad.base.compiler.Language;
import hadad.base.compiler.Model;
import hadad.base.compiler.QueryBlockTreeBuilder;

public class TMModel extends Model {
    public final static String ID = "TM";

    @Inject
    public TMModel(final QueryBlockTreeBuilder queryBlockTreeBuilder, final BlockEncoder blockEncoder) {
        super(ID, Format.MATRIX, Language.TFM, queryBlockTreeBuilder, blockEncoder);
    }
}
