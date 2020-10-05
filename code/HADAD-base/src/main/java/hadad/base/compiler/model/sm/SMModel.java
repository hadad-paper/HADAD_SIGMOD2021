package hadad.base.compiler.model.sm;

import com.google.inject.Inject;

import hadad.base.compiler.BlockEncoder;
import hadad.base.compiler.Format;
import hadad.base.compiler.Language;
import hadad.base.compiler.Model;
import hadad.base.compiler.QueryBlockTreeBuilder;

public class SMModel extends Model {
	public final static String ID = "SM";

	@Inject
	public SMModel(final QueryBlockTreeBuilder queryBlockTreeBuilder, final BlockEncoder blockEncoder) {
		super(ID, Format.MATRIX, Language.DML, queryBlockTreeBuilder, blockEncoder);
	}
}
