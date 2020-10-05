package hadad.base.compiler.model.rm;

import com.google.inject.Inject;

import hadad.base.compiler.BlockEncoder;
import hadad.base.compiler.Format;
import hadad.base.compiler.Language;
import hadad.base.compiler.Model;
import hadad.base.compiler.QueryBlockTreeBuilder;

public class RMModel extends Model {
    public final static String ID = "RM";

    @Inject
    public RMModel(final QueryBlockTreeBuilder queryBlockTreeBuilder, final BlockEncoder blockEncoder) {
        super(ID, Format.MATRIX, Language.R, queryBlockTreeBuilder, blockEncoder);
    }
}
