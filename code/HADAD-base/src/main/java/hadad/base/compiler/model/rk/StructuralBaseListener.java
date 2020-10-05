package hadad.base.compiler.model.rk;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import hadad.commons.conjunctivequery.Variable;
import hadad.commons.miscellaneous.Tuple;
import hadad.base.compiler.PathExpression;
import hadad.base.compiler.Structural;
import hadad.base.compiler.VariableFactory;
import hadad.base.compiler.VariableMapper;
import hadad.base.compiler.exceptions.ParseException;

/**
 * RK StructuralBaseListener
 * 
 * 
 */
abstract class StructuralBaseListener extends KQLBaseListener {
    /* Used to parse path expressions */
    protected final LookUpExpressionListener lookUpExpressionListener;
    /* Used to create fresh kql variables */
    protected final VariableFactory kqlVariableFactory;
    /* Used to map kql variables and the internal fresh variables */
    protected final VariableMapper variableMapper;

    /*
     * Used to keep the introduced variables of the path expression being parsed
     */
    private List<Tuple<Variable, PathExpression>> definitions;
    /* Used to know the variable being introduced */
    protected Variable currentVar;
    /* Used to know the set variable being introduced */
    protected String setVarStr;

    /* Used to hold all pattern models */
    private List<String> models;

    public StructuralBaseListener(final LookUpExpressionListener listener, final VariableFactory kqlVariableFactory,
            final VariableMapper variableMapper) {
        lookUpExpressionListener = checkNotNull(listener);
        this.kqlVariableFactory = checkNotNull(kqlVariableFactory);
        this.variableMapper = checkNotNull(variableMapper);
    }

    public Structural parse(final String str) throws ParseException {
        definitions = new ArrayList<Tuple<Variable, PathExpression>>();
        currentVar = null;
        setVarStr = null;
        models = new ArrayList<String>();
        models.add(RKModel.ID);
        final KQLLexer lexer = new KQLLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final KQLParser parser = new KQLParser(tokens);
        final ParserRuleContext tree = createParseTree(parser);
        final ParseTreeWalker walker = new ParseTreeWalker();
        try {
            walker.walk(this, tree);
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
        return new Structural(definitions, models);
    }

    protected void defineVariable(final PathExpression pathExpression) {
        if (currentVar == null) {
            throw new IllegalStateException("Variable expected.");
        }
        definitions.add(new Tuple<Variable, PathExpression>(currentVar, pathExpression));
        if (LookUpExpressionListener.setVar != null)
            definitions.add(new Tuple<Variable, PathExpression>(LookUpExpressionListener.setVar, pathExpression));

        currentVar = null;

    }

    protected abstract ParserRuleContext createParseTree(final KQLParser parser);
}
