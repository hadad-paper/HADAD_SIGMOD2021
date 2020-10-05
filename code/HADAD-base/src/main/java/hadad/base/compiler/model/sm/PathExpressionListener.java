package hadad.base.compiler.model.sm;

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
import hadad.base.compiler.model.rm.Predicate;

/**
 * SM PathExpressionListener
 * 
 *  
 *
 */
@Singleton
class PathExpressionListener extends DMLBaseListener {
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
     * @param str
     *            DML expression
     *
     * @return parsed expression
     * @throws ParseException
     */
    public PathExpression parse(final String str) throws ParseException {
        referredVariables = new HashSet<Variable>();
        encoding = new ArrayList<Atom>();
        currentVar = null;
        dmlStatementTreeProperty = new ParseTreeProperty<Variable>();
        final DMLLexer lexer = new DMLLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final DMLParser parser = new DMLParser(tokens);
        final ParserRuleContext tree = parser.dmlStatemnet();
        final ParseTreeWalker walker = new ParseTreeWalker();
        try {
            walker.walk(this, tree);
            return new PathExpression(SMModel.ID, referredVariables, encoding, currentVar,
                    new HashMap<String, String>());
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
    }

    @Override
    public void enterDmlStatemnet(DMLParser.DmlStatemnetContext ctx) {
        if (ctx.source().dmlMatrixConstruction() != null) {
            LOGGER.debug("Entering matrix dml statemnet: " + ctx.getText());
            final Variable var = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.NAME.toString(), var, new StringConstant(ctx.source().dmlMatrixConstruction().dmlMatrixConstructionMatrixSource().mName().getText().replace("\"", ""))));
            currentVar = var;
        }
    }

    @Override
    public void exitMatrixIdentifier(DMLParser.MatrixIdentifierContext ctx) {
        LOGGER.debug("Entering matrix identifier: " + ctx.getText());
        if (ctx != null) {
            final Variable var = variableMapper.getVariable(ctx.getText());
            referredVariables.add(var);
            setObject(ctx, var);
            currentVar = var;
        }
    }

    @Override
    public void exitMatrixMulExpression(DMLParser.MatrixMulExpressionContext ctx) {
        LOGGER.debug("Entering MatrixMulExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable varLeft = retrieveVariable(ctx.dmlExpression().get(0));
            final Variable varRight = retrieveVariable(ctx.dmlExpression().get(1));
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.MULTI.toString(), varLeft, varRight, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }

    @Override
    public void exitMatrixAddExpression(DMLParser.MatrixAddExpressionContext ctx) {
        LOGGER.debug("Entering MatrixAddExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable varLeft = retrieveVariable(ctx.dmlExpression().get(0));
            final Variable varRight = retrieveVariable(ctx.dmlExpression().get(1));
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.ADD.toString(), varLeft, varRight, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }

    @Override
    public void exitMatrixDivision(DMLParser.MatrixDivisionContext ctx) {
        LOGGER.debug("Entering MatrixDivExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable varLeft = retrieveVariable(ctx.dmlExpression().get(0));
            final Variable varRight = retrieveVariable(ctx.dmlExpression().get(1));
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.DIV.toString(), varLeft, varRight, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }

    @Override
    public void exitRowsSumExperssion(DMLParser.RowsSumExperssionContext ctx) {
       // LOGGER.debug("Entering MatrixTransposeExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable var = retrieveVariable(ctx.dmlExpression());
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.ROWSUM.toString(), var, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }
    @Override
    public void exitColumnsSumExperssion(DMLParser.ColumnsSumExperssionContext ctx) {
        //LOGGER.debug("Entering MatrixTransposeExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable var = retrieveVariable(ctx.dmlExpression());
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.COLSUM.toString(), var, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }
    
    @Override
    public void exitMatrixTransposeExpression(DMLParser.MatrixTransposeExpressionContext ctx) {
       // LOGGER.debug("Entering MatrixTransposeExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable var = retrieveVariable(ctx.dmlExpression());
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.TRANS.toString(), var, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }
    @Override
    public void exitMatrixInverseExpression(DMLParser.MatrixInverseExpressionContext ctx) {
        //LOGGER.debug("Entering MatrixTransposeExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable var = retrieveVariable(ctx.dmlExpression());
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.INVERSE.toString(), var, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }


    @Override
    public void exitMatrixDetExpression(DMLParser.MatrixDetExpressionContext ctx) {
       // LOGGER.debug("Entering MatrixTransposeExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable var = retrieveVariable(ctx.dmlExpression());
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.DET.toString(), var, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }
    @Override
    public void exitMatrixTraceExpression(DMLParser.MatrixTraceExpressionContext ctx) {
       // LOGGER.debug("Entering MatrixTransposeExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable var = retrieveVariable(ctx.dmlExpression());
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.DET.toString(), var, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }

    @Override
    public void exitSumExperssion(DMLParser.SumExperssionContext ctx) {
        //LOGGER.debug("Entering MatrixTransposeExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable var = retrieveVariable(ctx.dmlExpression());
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.SUM.toString(), var, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }


    @Override
    public void exitMatrixDiagonalExpression(DMLParser.MatrixDiagonalExpressionContext ctx) {
        //LOGGER.debug("Entering MatrixDiagonalExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable var = retrieveVariable(ctx.dmlExpression());
            final Variable result = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.DIAG.toString(), var, result));
            currentVar = result;
            setObject(ctx, result);
        }
    }

    @Override
    public void exitAtomicExpression(DMLParser.AtomicExpressionContext ctx) {
        //LOGGER.debug("Entering AtomicExpression: " + ctx.getText());
        if (ctx != null) {
            final Variable var = retrieveVariable(ctx.dmlExpression());
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

        return dmlStatementTreeProperty.get(subtree);
    }

    /**
     * @param subtree
     *            the sub-parse tree node
     * @param var
     *            The variable that corresponds subtree
     */
    private void setObject(ParseTree subtree, Variable var) {
        dmlStatementTreeProperty.put(subtree, var);
    }

}
