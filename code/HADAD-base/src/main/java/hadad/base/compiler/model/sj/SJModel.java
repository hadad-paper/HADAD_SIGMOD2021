package hadad.base.compiler.model.sj;

import com.google.inject.Inject;

import hadad.base.compiler.BlockEncoder;
import hadad.base.compiler.Format;
import hadad.base.compiler.Language;
import hadad.base.compiler.Model;
import hadad.base.compiler.QueryBlockTreeBuilder;

public class SJModel extends Model {
	public final static String ID = "SJ";

	@Inject
	public SJModel(final QueryBlockTreeBuilder queryBlockTreeBuilder, final BlockEncoder blockEncoder) {
		super(ID, Format.JSON, Language.SJQL, queryBlockTreeBuilder, blockEncoder);
	}
}
