package hadad.base.compiler.model.nm;

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
 * NM PathExpressionListener
 * 
 *  
 *
 */
@Singleton
class PathExpressionListener extends NumPyBaseListener {
    private static final Logger LOGGER = Logger.getLogger(PathExpressionListener.class);
    private final VariableFactory cqVariableFactory;
    private final VariableMapper variableMapper;
    private final String documentNamePrefix;
    private final DocumentsCatalog documentsCatalog;
    private Set<Variable> referredVariables;
    private ParseTreeProperty<Variable> numPyStatementTreeProperty;
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
     * Parse NumPy expression
     * 
     * @param str
     *            NumPy expression
     *
     * @return parsed expression
     * @throws ParseException
     */
    public PathExpression parse(final String str) throws ParseException {
        referredVariables = new HashSet<Variable>();
        encoding = new ArrayList<Atom>();
        currentVar = null;
        numPyStatementTreeProperty = new ParseTreeProperty<Variable>();
        final NumPyLexer lexer = new NumPyLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final NumPyParser parser = new NumPyParser(tokens);
        final ParserRuleContext tree = parser.numPyStatemnet();
        final ParseTreeWalker walker = new ParseTreeWalker();
        try {
            walker.walk(this, tree);
            return new PathExpression(NMModel.ID, referredVariables, encoding, currentVar,
                    new HashMap<String, String>());
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
    }

    @Override
    public void enterNumPyStatemnet(NumPyParser.NumPyStatemnetContext ctx) {
        if (ctx.source().numPyMatrixConstruction() != null) {
            //LOGGER.debug("Entering matrix numpy statemnet: " + ctx.getText());
            final Variable var = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.NAME.toString(), var, new StringConstant(ctx.source().numPyMatrixConstruction().numPyMatrixConstructionMatrixSource().load().mName().getText().replace("\"", ""))));
            currentVar = var;
        }
    }

    @Override
    public void exitMatrixIdentifier(NumPyParser.MatrixIdentifierContext ctx) {
        //LOGGER.debug("Entering matrix identifier: " + ctx.getText());
        if (ctx != null) {
            final Variable var = variableMapper.getVariable(ctx.getText());
            referredVariables.add(var);
            setObject(ctx, var);
            currentVar = var;
        }
    }

    @Override
    public void exitMatrixMulExpression(NumPyParser.MatrixMulExpressionContext ctx) {
        //LOGGER.debug("Entering MatrixMulExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable varLeft = retrieveVariable(ctx.numPyExpression().get(0));
            final Variable varRight = retrieveVariable(ctx.numPyExpression().get(1));
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.MULTI.toString(), varLeft, varRight, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }

    @Override
    public void exitMatrixMulElementwiseExpression(NumPyParser.MatrixMulElementwiseExpressionContext ctx) {
        //LOGGER.debug("Entering MatrixMulExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable varLeft = retrieveVariable(ctx.numPyExpression().get(0));
            final Variable varRight = retrieveVariable(ctx.numPyExpression().get(1));
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.MULTIE.toString(), varLeft, varRight, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }
    
    @Override
    public void exitMatrixMulScalarExpression(NumPyParser.MatrixMulScalarExpressionContext ctx) {
       // LOGGER.debug("Entering MatrixMulExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable varLeft = retrieveVariable(ctx.numericScalar());
            final Variable varRight = retrieveVariable(ctx.numPyExpression());
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.MULTIS.toString(), varLeft, varRight, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }

    @Override
    public void exitMatrixAddExpression(NumPyParser.MatrixAddExpressionContext ctx) {
        //LOGGER.debug("Entering MatrixAddExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable varLeft = retrieveVariable(ctx.numPyExpression().get(0));
            final Variable varRight = retrieveVariable(ctx.numPyExpression().get(1));
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.ADD.toString(), varLeft, varRight, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }

    @Override
    public void exitMatrixDivision(NumPyParser.MatrixDivisionContext ctx) {
        //LOGGER.debug("Entering MatrixDivExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable varLeft = retrieveVariable(ctx.numPyExpression().get(0));
            final Variable varRight = retrieveVariable(ctx.numPyExpression().get(1));
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.DIV.toString(), varLeft, varRight, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }

    @Override
    public void exitMatrixScalarDivision(NumPyParser.MatrixScalarDivisionContext ctx) {
        //LOGGER.debug("Entering MatrixDivExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable varLeft = retrieveVariable(ctx.numPyExpression());
            final Variable varRight = retrieveVariable(ctx.numericScalar());
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.DIVS.toString(), varLeft, varRight, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }

    @Override
    public void exitMatrixTransposeExpression(NumPyParser.MatrixTransposeExpressionContext ctx) {
        //LOGGER.debug("Entering MatrixTransposeExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable var = retrieveVariable(ctx.numPyExpression());
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.TRANS.toString(), var, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }

    @Override
    public void exitColumnsSumExperssion(NumPyParser.ColumnsSumExperssionContext ctx) {
        //LOGGER.debug("Entering MatrixTransposeExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable var = retrieveVariable(ctx.numPyExpression());
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.COLSUM.toString(), var, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }
    @Override
    public void exitSumExperssion(NumPyParser.SumExperssionContext ctx) {
        //LOGGER.debug("Entering MatrixTransposeExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable var = retrieveVariable(ctx.numPyExpression());
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.SUM.toString(), var, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }
    @Override
    public void exitRowsSumExperssion(NumPyParser.RowsSumExperssionContext ctx) {
        //LOGGER.debug("Entering MatrixTransposeExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable var = retrieveVariable(ctx.numPyExpression());
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.ROWSUM.toString(), var, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }
    @Override
    public void exitMatrixTraceExpression(NumPyParser.MatrixTraceExpressionContext ctx) {
        //LOGGER.debug("Entering MatrixTransposeExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable var = retrieveVariable(ctx.numPyExpression());
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.TRACE.toString(), var, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }

    @Override
    public void exitMatrixDiagonalExpression(NumPyParser.MatrixDiagonalExpressionContext ctx) {
        //LOGGER.debug("Entering MatrixDiagonalExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable var = retrieveVariable(ctx.numPyExpression());
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.DIAG.toString(), var, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }

    @Override
    public void exitMatrixDetExpression(NumPyParser.MatrixDetExpressionContext ctx) {
        //LOGGER.debug("Entering MatrixDeterminantExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable var = retrieveVariable(ctx.numPyExpression());
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.DET.toString(), var, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }

    @Override
    public void exitMatrixInvExpression(NumPyParser.MatrixInvExpressionContext ctx) {
        //LOGGER.debug("Entering Matrix Inverse Expression: " + ctx.getText());
        if (ctx != null) {
            final Variable var = retrieveVariable(ctx.numPyExpression());
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.INVERSE.toString(), var, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }

    @Override
    public void exitMatrixRankExpression(NumPyParser.MatrixRankExpressionContext ctx) {
        //LOGGER.debug("Entering Matrix Inverse Expression: " + ctx.getText());
        if (ctx != null) {
            final Variable var = retrieveVariable(ctx.numPyExpression());
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.RANK.toString(), var, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }

    @Override
    public void exitNumericScalar(NumPyParser.NumericScalarContext ctx) {
        //LOGGER.debug("Entering numeric scalar: " + ctx.getText());
        if (ctx != null) {
            final Variable varConstant = new Variable(ctx.INT().getText());
            setObject(ctx, varConstant);
        }
    }

    /**
     * Retrieve variable associated with each sub-parse tree node.
     * 
     * @param subtree
     *            the sub-parse tree node
     * @return The corresponding sub-parse tree node variable
     */
    private Variable retrieveVariable(ParseTree subtree) {

        return numPyStatementTreeProperty.get(subtree);
    }

    /**
     * @param subtree
     *            the sub-parse tree node
     * @param var
     *            The variable that corresponds subtree
     */
    private void setObject(ParseTree subtree, Variable var) {
        numPyStatementTreeProperty.put(subtree, var);
    }

}
