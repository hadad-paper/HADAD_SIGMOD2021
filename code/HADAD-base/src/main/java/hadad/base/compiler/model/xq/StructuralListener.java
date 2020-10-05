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
public final class StructuralListener extends StructuralBaseListener {
	private static final Logger log = Logger
			.getLogger(StructuralListener.class);

	@Inject
	public StructuralListener(
			final PathExpressionListener listener,
			@Named("XQueryVariableFactory") VariableFactory xqueryVariableFactory,
			VariableMapper variableMapper) {
		super(listener, xqueryVariableFactory, variableMapper);
	}

	@Override
	public void enterFlwrForVar(XQueryParser.FlwrForVarContext ctx) {
		log.debug("Entering FlwrForVar: " + ctx.getText());
		if (currentVar != null) {
			throw new IllegalStateException("Path expression expected.");
		}
		final Variable var = xqueryVariableFactory.createFreshVar();
		variableMapper.define(ctx.getText(), var);
		currentVar = var;
	}

	@Override
	public void enterFlwrForP(XQueryParser.FlwrForPContext ctx) {
		log.debug("Entering FlwrForP: " + ctx.getText());
		defineVariable(pathExpressionListener.parse(
				AntlrUtils.getFullText(ctx)).copy(currentVar));
	}

	@Override
	protected ParserRuleContext createParseTree(final XQueryParser parser) {
		return parser.flwrFor();
	}
}
