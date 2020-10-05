package hadad.base.compiler.model.nm;

import com.google.inject.Inject;

import hadad.base.compiler.BlockEncoder;
import hadad.base.compiler.Format;
import hadad.base.compiler.Language;
import hadad.base.compiler.Model;
import hadad.base.compiler.QueryBlockTreeBuilder;

public class NMModel extends Model {
    public final static String ID = "NM";

    @Inject
    public NMModel(final QueryBlockTreeBuilder queryBlockTreeBuilder, final BlockEncoder blockEncoder) {
        super(ID, Format.MATRIX, Language.NUMPY, queryBlockTreeBuilder, blockEncoder);
    }
}
