package hadad.base.compiler.model.rm;

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
 * R PathExpressionListener
 * 
 *  
 *
 */
@Singleton
class PathExpressionListener extends RBaseListener {
    private static final Logger LOGGER = Logger.getLogger(PathExpressionListener.class);
    private final VariableFactory cqVariableFactory;
    private final VariableMapper variableMapper;
    @SuppressWarnings("unused")
    private final String documentNamePrefix;
    @SuppressWarnings("unused")
    private final DocumentsCatalog documentsCatalog;
    private Set<Variable> referredVariables;
    private ParseTreeProperty<Variable> rStatementTreeProperty;
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
     * Parse R expression
     * 
     * @param str
     *            R expression
     *
     * @return parsed expression
     * @throws ParseException
     */
    public PathExpression parse(final String str) throws ParseException {
        referredVariables = new HashSet<Variable>();
        encoding = new ArrayList<Atom>();
        currentVar = null;
        rStatementTreeProperty = new ParseTreeProperty<Variable>();
        final RLexer lexer = new RLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final RParser parser = new RParser(tokens);
        final ParserRuleContext tree = parser.rStatemnet();
        final ParseTreeWalker walker = new ParseTreeWalker();
        try {
            walker.walk(this, tree);
            return new PathExpression(RMModel.ID, referredVariables, encoding, currentVar,
                    new HashMap<String, String>());
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
    }

    @Override
    public void enterRStatemnet(RParser.RStatemnetContext ctx) {
        if (ctx.source().rMatrixConstruction() != null) {
            //LOGGER.debug("Entering matrix R statemnet: " + ctx.getText());
            final Variable var = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.NAME.toString(), var, new StringConstant(ctx.source().rMatrixConstruction().rMatrixConstructionMatrixSource().mName().getText().replace("\"", ""))));
            currentVar = var;
        }
    }

    @Override
    public void exitMatrixIdentifier(RParser.MatrixIdentifierContext ctx) {
       // LOGGER.debug("Entering matrix identifier: " + ctx.getText());
        if (ctx != null) {
        	try {
                int d = Integer.parseInt((ctx.getText()));
            } catch (NumberFormatException nfe) {
            	final Variable var = variableMapper.getVariable(ctx.getText());
                referredVariables.add(var);
                setObject(ctx, var);
                currentVar = var;
            }
            
        }
    }

    @Override
    public void exitMatrixMulExpression(RParser.MatrixMulExpressionContext ctx) {
        //LOGGER.debug("Entering MatrixMulExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable varLeft = retrieveVariable(ctx.rExpression().get(0));
            final Variable varRight = retrieveVariable(ctx.rExpression().get(1));
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.MULTI.toString(), varLeft, varRight, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }

    @Override
    public void exitMatrixAddExpression(RParser.MatrixAddExpressionContext ctx) {
        //LOGGER.debug("Entering MatrixAddExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable varLeft = retrieveVariable(ctx.rExpression().get(0));
            final Variable varRight = retrieveVariable(ctx.rExpression().get(1));
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.ADD.toString(), varLeft, varRight, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }

    @Override
    public void exitMatrixDivision(RParser.MatrixDivisionContext ctx) {
        //LOGGER.debug("Entering MatrixDivExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable varLeft = retrieveVariable(ctx.rExpression().get(0));
            final Variable varRight = retrieveVariable(ctx.rExpression().get(1));
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.DIV.toString(), varLeft, varRight, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }

    @Override
    public void exitRowsSumExperssion(RParser.RowsSumExperssionContext ctx) {
        //LOGGER.debug("Entering MatrixTransposeExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable var = retrieveVariable(ctx.rExpression());
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.ROWSUM.toString(), var, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }
    @Override
    public void exitColumnsSumExperssion(RParser.ColumnsSumExperssionContext ctx) {
        //LOGGER.debug("Entering MatrixTransposeExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable var = retrieveVariable(ctx.rExpression());
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.COLSUM.toString(), var, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }
    @Override
    public void exitSumExperssion(RParser.SumExperssionContext ctx) {
        if (ctx != null) {
            final Variable var = retrieveVariable(ctx.rExpression());
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.SUM.toString(), var, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }
    
    
    @Override
    public void exitMatrixTransposeExpression(RParser.MatrixTransposeExpressionContext ctx) {
        //LOGGER.debug("Entering MatrixTransposeExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable var = retrieveVariable(ctx.rExpression());
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.TRANS.toString(), var, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }

    public void exitMatrixInverseExpression(RParser.MatrixInverseExpressionContext ctx) {
       // LOGGER.debug("Entering MatrixTransposeExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable var = retrieveVariable(ctx.rExpression());
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.INVERSE.toString(), var, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }

    @Override
    public void exitMatrixTraceExpression(RParser.MatrixTraceExpressionContext ctx) {
       // LOGGER.debug("Entering MatrixTransposeExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable var = retrieveVariable(ctx.rExpression());
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.TRACE.toString(), var, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }
    @Override
    public void exitMatrixDetExpression(RParser.MatrixDetExpressionContext ctx) {
       // LOGGER.debug("Entering MatrixTransposeExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable var = retrieveVariable(ctx.rExpression());
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.DET.toString(), var, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }

    @Override
    public void exitMatrixDiagonalExpression(RParser.MatrixDiagonalExpressionContext ctx) {
       //s LOGGER.debug("Entering MatrixDiagonalExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable var = retrieveVariable(ctx.rExpression());
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.DIAG.toString(), var, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }

    @Override
    public void exitAtomicExpression(RParser.AtomicExpressionContext ctx) {
        //LOGGER.debug("Entering AtomicExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable var = retrieveVariable(ctx.rExpression());
            currentVar = var;
            setObject(ctx, var);
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

        return rStatementTreeProperty.get(subtree);
    }

    /**
     * @param subtree
     *            the sub-parse tree node
     * @param var
     *            The variable that corresponds subtree
     */
    private void setObject(ParseTree subtree, Variable var) {
        rStatementTreeProperty.put(subtree, var);
    }

}
