package hadad.base.compiler.model.tm;

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
 * SM StructuralBaseListener
 * 
 *   
 *
 */
abstract class StructuralBaseListener extends TFMBaseListener {
    /* Used to create fresh aql variables */
    protected final VariableFactory dmlVariableFactory;
    /* Used to map sjql variables and the internal fresh variables */
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
            final VariableFactory sjqlVariableFactory, final VariableMapper variableMapper) {
        this.pathExpressionListener = checkNotNull(pathExpressionlistener);
        this.dmlVariableFactory = checkNotNull(sjqlVariableFactory);
        this.variableMapper = checkNotNull(variableMapper);
    }

    public Structural parse(final String str) throws ParseException {
        definitions = new ArrayList<Tuple<Variable, PathExpression>>();
		currentVar = null;
        models = new ArrayList<String>();
        models.add(TMModel.ID);

        final TFMLexer lexer = new TFMLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final TFMParser parser = new TFMParser(tokens);
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
        currentVar=null;
    }

    protected abstract ParserRuleContext createParseTree(final TFMParser parser);
}
