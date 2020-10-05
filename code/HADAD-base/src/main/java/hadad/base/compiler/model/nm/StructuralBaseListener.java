package hadad.base.compiler.model.nm;

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
import hadad.base.compiler.exceptions.ParseException;;

/**
 * NM StructuralBaseListener
 * 
 *   
 *
 */
abstract class StructuralBaseListener extends NumPyBaseListener {
    /* Used to create fresh NM variables */
    protected final VariableFactory NMVariableFactory;
    /* Used to map NM variables and the internal fresh variables */
    protected final VariableMapper variableMapper;
    /* Used to keep the introduced variables of the path expression being parsed */
    private List<Tuple<Variable, PathExpression>> definitions;
    /* Used to know the variable being introduced */
    protected Variable currentVar;
    /* Used to know the name of variable being introduced */
    protected String currentVarName;

    private List<String> models;
    /* Used to parse path expressions */
    protected final PathExpressionListener pathExpressionListener;

    public StructuralBaseListener(final PathExpressionListener pathExpressionlistener,
            final VariableFactory nmVariableFactory, final VariableMapper variableMapper) {
        this.pathExpressionListener = checkNotNull(pathExpressionlistener);
        this.NMVariableFactory = checkNotNull(nmVariableFactory);
        this.variableMapper = checkNotNull(variableMapper);
    }

    public Structural parse(final String str) throws ParseException {
        definitions = new ArrayList<Tuple<Variable, PathExpression>>();
        currentVar = null;
        models = new ArrayList<String>();
        models.add(NMModel.ID);

        final NumPyLexer lexer = new NumPyLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final NumPyParser parser = new NumPyParser(tokens);
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
        currentVar = null;
    }

    protected abstract ParserRuleContext createParseTree(final NumPyParser parser);
}
