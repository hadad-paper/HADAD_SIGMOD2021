package hadad.base.compiler.model.pr;

import hadad.base.compiler.Format;
import hadad.base.compiler.Language;
import hadad.base.compiler.Model;

public class PRModel extends Model {
    public final static String ID = "PR";

    public PRModel() {
        super(ID, Format.RELATIONAL, Language.CONJUNCTIVE_QUERY, new PRQueryBlockTreeBuilder(), new PRBlockEncoder());
    }
}
