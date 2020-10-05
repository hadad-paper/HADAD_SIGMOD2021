package hadad.base.compiler.model.xq;

import com.google.inject.Inject;

import hadad.base.compiler.BlockEncoder;
import hadad.base.compiler.Format;
import hadad.base.compiler.Language;
import hadad.base.compiler.Model;
import hadad.base.compiler.QueryBlockTreeBuilder;

public class XQModel extends Model {
	public final static String ID = "XQ";

	@Inject
	public XQModel(final QueryBlockTreeBuilder queryBlockTreeBuilder,
			final BlockEncoder blockEncoder) {
		super(ID, Format.XML, Language.XQUERY, queryBlockTreeBuilder,
				blockEncoder);
	}
}
