package hadad.base.compiler.model.xq;

import org.antlr.v4.runtime.ParserRuleContext;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import hadad.commons.conjunctivequery.Variable;
import hadad.base.compiler.AntlrUtils;
import hadad.base.compiler.VariableFactory;
import hadad.base.compiler.VariableMapper;

/**
 * 
 */
@Singleton
final class ConditionalStructuralListener extends StructuralBaseListener {
	private static final Logger log = Logger
			.getLogger(ConditionalStructuralListener.class);

	@Inject
	public ConditionalStructuralListener(
			final PathExpressionListener listener,
			@Named("XQueryVariableFactory") VariableFactory xqueryVariableFactory,
			VariableMapper variableMapper) {
		super(listener, xqueryVariableFactory,
				variableMapper);
	}

	@Override
	public void enterFlwrWhereCondVar(XQueryParser.FlwrWhereCondVarContext ctx) {
		log.debug("Entering FlwrWhereCondVar: " + ctx.getText());
		if (currentVar != null) {
			throw new IllegalStateException("Path expression expected.");
		}
		final Variable var = xqueryVariableFactory.createFreshVar();
		variableMapper.define(ctx.getText(), var);
		currentVar = var;
	}

	@Override
	public void enterFlwrWhereCondAp(XQueryParser.FlwrWhereCondApContext ctx) {
		log.debug("Entering FlwrWhereCondAp: " + ctx.getText());
		defineVariable(pathExpressionListener.parse(
				AntlrUtils.getFullText(ctx)).copy(currentVar));
	}

	@Override
	protected ParserRuleContext createParseTree(final XQueryParser parser) {
		return parser.flwrWhereCondSome();
	}
}
