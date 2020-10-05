package hadad.base.compiler.model.rk;

import com.google.inject.Inject;

import hadad.base.compiler.BlockEncoder;
import hadad.base.compiler.Format;
import hadad.base.compiler.Language;
import hadad.base.compiler.Model;
import hadad.base.compiler.QueryBlockTreeBuilder;

public class RKModel extends Model {
	public final static String ID = "RK";

	@Inject
	public RKModel(final QueryBlockTreeBuilder queryBlockTreeBuilder, final BlockEncoder blockEncoder) {
		super(ID, Format.KEYVALUE, Language.KQL, queryBlockTreeBuilder, blockEncoder);
	}
}
