package hadad.base.compiler.model.tm;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.StringConstant;
import hadad.commons.conjunctivequery.Variable;
import hadad.base.compiler.DocumentsCatalog;
import hadad.base.compiler.PathExpression;
import hadad.base.compiler.VariableFactory;
import hadad.base.compiler.VariableMapper;
import hadad.base.compiler.exceptions.ParseException;

/**
 * TM PathExpressionListener
 * 
 * 
 *
 */
@Singleton
class PathExpressionListener extends TFMBaseListener {
	private static final Logger LOGGER = Logger.getLogger(PathExpressionListener.class);
	private final VariableFactory cqVariableFactory;
	private final VariableMapper variableMapper;
	private final String documentNamePrefix;
	private final DocumentsCatalog documentsCatalog;
	private Set<Variable> referredVariables;
	private ParseTreeProperty<Variable> dmlStatementTreeProperty;
	private List<Atom> encoding;
	private Variable currentVar;

	@Inject
	public PathExpressionListener(@Named("document_name_prefix") final String documentNamePrefix,
			@Named("ConjunctiveQueryVariableFactory") final VariableFactory cqVariableFactory,
			final VariableMapper variableMapper, final DocumentsCatalog documentsCatalog) {
		this.documentNamePrefix = checkNotNull(documentNamePrefix);
		this.cqVariableFactory = checkNotNull(cqVariableFactory);
		this.variableMapper = checkNotNull(variableMapper);
		this.documentsCatalog = checkNotNull(documentsCatalog);
	}

	/**
	 * Parse DML expression
	 * 
	 * @param str DML expression
	 *
	 * @return parsed expression
	 * @throws ParseException
	 */
	public PathExpression parse(final String str) throws ParseException {
		referredVariables = new HashSet<Variable>();
		encoding = new ArrayList<Atom>();
		currentVar = null;
		dmlStatementTreeProperty = new ParseTreeProperty<Variable>();
		final TFMLexer lexer = new TFMLexer(CharStreams.fromString(str));
		final CommonTokenStream tokens = new CommonTokenStream(lexer);
		final TFMParser parser = new TFMParser(tokens);
		final ParserRuleContext tree = parser.tfmStatemnet();
		final ParseTreeWalker walker = new ParseTreeWalker();
		try {
			walker.walk(this, tree);
			return new PathExpression(TMModel.ID, referredVariables, encoding, currentVar,
					new HashMap<String, String>());
		} catch (IllegalStateException e) {
			throw new ParseException(e);
		}
	}

	@Override
	public void enterTfmStatemnet(TFMParser.TfmStatemnetContext ctx) {
		if (ctx.source() != null) {
			if (ctx.source().tfmMatrixConstruction() != null) {
				LOGGER.debug("Entering matrix TF statemnet: " + ctx.getText());
				final Variable var = cqVariableFactory.createFreshVar();
				encoding.add(
						new Atom(Predicate.NAME.toString(), var, new StringConstant(ctx.source().tfmMatrixConstruction()
								.tfmMatrixConstructionMatrixSource().load().mName().getText().replace("\"", ""))));
				currentVar = var;
			}
		}
	}

	@Override
	public void exitMatrixIdentifier(TFMParser.MatrixIdentifierContext ctx) {
		LOGGER.debug("Entering matrix identifier: " + ctx.getText());
		if (ctx != null) {
			final Variable var = variableMapper.getVariable(ctx.getText());
			referredVariables.add(var);
			setObject(ctx, var);
			currentVar = var;
		}
	}

	@Override
	public void exitMatrixMulExpression(TFMParser.MatrixMulExpressionContext ctx) {
		LOGGER.debug("Entering MatrixMulExpression: " + ctx.getText());
		if (ctx != null) {
			final Variable varLeft = retrieveVariable(ctx.tfmExpression().get(0));
			final Variable varRight = retrieveVariable(ctx.tfmExpression().get(1));
			final Variable result = cqVariableFactory.createFreshVar();
			encoding.add(new Atom(Predicate.MULTI.toString(), varLeft, varRight, result));
			currentVar = result;
			setObject(ctx, result);
		}
	}

	@Override
	public void exitMatrixAddExpression(TFMParser.MatrixAddExpressionContext ctx) {
		LOGGER.debug("Entering MatrixAddExpression: " + ctx.getText());
		if (ctx != null) {
			final Variable varLeft = retrieveVariable(ctx.tfmExpression().get(0));
			final Variable varRight = retrieveVariable(ctx.tfmExpression().get(1));
			final Variable result = cqVariableFactory.createFreshVar();
			encoding.add(new Atom(Predicate.ADD.toString(), varLeft, varRight, result));
			currentVar = result;
			setObject(ctx, result);
		}
	}

	@Override
	public void exitMatrixDivision(TFMParser.MatrixDivisionContext ctx) {
		LOGGER.debug("Entering MatrixDivExpression: " + ctx.getText());
		if (ctx != null) {
			final Variable varLeft = retrieveVariable(ctx.tfmExpression().get(0));
			final Variable varRight = retrieveVariable(ctx.tfmExpression().get(1));
			final Variable result = cqVariableFactory.createFreshVar();
			encoding.add(new Atom(Predicate.DIV.toString(), varLeft, varRight, result));
			currentVar = result;
			setObject(ctx, result);
		}
	}

	@Override
	public void exitMatrixTransposeExpression(TFMParser.MatrixTransposeExpressionContext ctx) {
		LOGGER.debug("Entering MatrixTransposeExpression: " + ctx.getText());
		if (ctx != null) {
			final Variable var = retrieveVariable(ctx.tfmExpression());
			final Variable result = cqVariableFactory.createFreshVar();
			encoding.add(new Atom(Predicate.TRANS.toString(), var, result));
			currentVar = result;
			setObject(ctx, result);
		}
	}
	@Override
	public void exitMatrixDetExpression(TFMParser.MatrixDetExpressionContext ctx) {
		if (ctx != null) {
			final Variable var = retrieveVariable(ctx.tfmExpression());
			final Variable result = cqVariableFactory.createFreshVar();
			encoding.add(new Atom(Predicate.DET.toString(), var, result));
			currentVar = result;
			setObject(ctx, result);
		}
	}

	@Override
	public void exitMatrixInvExpression(TFMParser.MatrixInvExpressionContext ctx) {
		if (ctx != null) {
			final Variable var = retrieveVariable(ctx.tfmExpression());
			final Variable result = cqVariableFactory.createFreshVar();
			encoding.add(new Atom(Predicate.INVERSE.toString(), var, result));
			currentVar = result;
			setObject(ctx, result);
		}
	}

	@Override
	public void exitRowsSumExperssion(TFMParser.RowsSumExperssionContext ctx) {
		if (ctx != null) {
			final Variable var = retrieveVariable(ctx.tfmExpression());
			final Variable result = cqVariableFactory.createFreshVar();
			encoding.add(new Atom(Predicate.ROWSUM.toString(), var, result));
			currentVar = result;
			setObject(ctx, result);
		}
	}

	@Override
	public void exitColumnsSumExperssion(TFMParser.ColumnsSumExperssionContext ctx) {
		if (ctx != null) {
			final Variable var = retrieveVariable(ctx.tfmExpression());
			final Variable result = cqVariableFactory.createFreshVar();
			encoding.add(new Atom(Predicate.COLSUM.toString(), var, result));
			currentVar = result;
			setObject(ctx, result);
		}
	}

	@Override
	public void exitSumExperssion(TFMParser.SumExperssionContext ctx) {
		if (ctx != null) {
			final Variable var = retrieveVariable(ctx.tfmExpression());
			final Variable result = cqVariableFactory.createFreshVar();
			encoding.add(new Atom(Predicate.SUM.toString(), var, result));
			currentVar = result;
			setObject(ctx, result);
		}
	}


	@Override
	public void exitMatrixTraceExpression(TFMParser.MatrixTraceExpressionContext ctx) {
		LOGGER.debug("Entering MatrixTransposeExpression: " + ctx.getText());
		if (ctx != null) {
			final Variable var = retrieveVariable(ctx.tfmExpression());
			final Variable result = cqVariableFactory.createFreshVar();
			encoding.add(new Atom(Predicate.TRACE.toString(), var, result));
			currentVar = result;
			setObject(ctx, result);
		}
	}

	@Override
	public void exitMatrixDiagonalExpression(TFMParser.MatrixDiagonalExpressionContext ctx) {
		LOGGER.debug("Entering MatrixDiagonalExpression: " + ctx.getText());
		if (ctx != null) {
			final Variable var = retrieveVariable(ctx.tfmExpression());
			final Variable result = cqVariableFactory.createFreshVar();
			encoding.add(new Atom(Predicate.DIAG.toString(), var, result));
			currentVar = result;
			setObject(ctx, result);
		}
	}

	/**
	 * Retrieve variable associated with each sub-parse tree node.
	 * 
	 * @param subtree the sub-parse tree node
	 * @return The corresponding sub-parse tree node variable
	 */
	private Variable retrieveVariable(ParseTree subtree) {

		return dmlStatementTreeProperty.get(subtree);
	}

	/**
	 * @param subtree the sub-parse tree node
	 * @param var     The variable that corresponds subtree
	 */
	private void setObject(ParseTree subtree, Variable var) {
		dmlStatementTreeProperty.put(subtree, var);
	}

}
