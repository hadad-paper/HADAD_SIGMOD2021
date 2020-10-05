package hadad.base.compiler.model.tm;

import org.antlr.v4.runtime.ParserRuleContext;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import hadad.commons.conjunctivequery.Variable;
import hadad.base.compiler.AntlrUtils;
import hadad.base.compiler.PathExpression;
import hadad.base.compiler.VariableFactory;
import hadad.base.compiler.VariableMapper;

/**
 * SJ Structural Listener
 * 
 * 
 *
 */
@Singleton
public final class StructuralListener extends StructuralBaseListener {
	private static final Logger LOGGER = Logger.getLogger(StructuralListener.class);

	@Inject
	public StructuralListener(final PathExpressionListener pathExpressionlistener,
			@Named("TFMVariableFactory") VariableFactory dmlVariableFactory, VariableMapper variableMapper) {
		super(pathExpressionlistener, dmlVariableFactory, variableMapper);
	}

	@Override
	public void enterTfmStatemnet(TFMParser.TfmStatemnetContext ctx) {
		LOGGER.debug("Entering TFM Statement Query: " + ctx.getText());
		if (currentVar != null) {
			throw new IllegalStateException("Path expression expected.");
		}

		if (ctx.matrixName() != null) {
			Variable var = dmlVariableFactory.createFreshVar();
			if (ctx.source().tfGraphInit() != null) {
				if (ctx.source().tfGraphInit().getText().contains("placeholder")) {
					variableMapper.define(ctx.matrixName().getText(),
							variableMapper.getVariable(ctx.source().tfGraphInit().val().shape().ID().get(0).getText()));
				}

			} else {
				System.out.println(ctx.matrixName().getText());
				variableMapper.define(ctx.matrixName().getText(), var);
				currentVar = var;
			}

			currentVar = var;
			final PathExpression expr = pathExpressionListener.parse(AntlrUtils.getFullText(ctx)).copy(currentVar);
			defineVariable(expr);
		}

	}

	@Override
	protected ParserRuleContext createParseTree(final TFMParser parser) {
		return parser.tfmScript();
	}
}
