package hadad.base.compiler.model.aj;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.log4j.Logger;

import hadad.commons.conjunctivequery.Variable;
import hadad.commons.miscellaneous.Tuple;
import hadad.base.compiler.PathExpression;
import hadad.base.compiler.Structural;
import hadad.base.compiler.VariableFactory;
import hadad.base.compiler.VariableMapper;
import hadad.base.compiler.exceptions.ParseException;

/**
 * AJ StructuralBaseListener which extends {@link AQLBaseListener}
 */
abstract class StructuralBaseListener extends AQLBaseListener {
    private static final Logger LOGGER = Logger.getLogger(StructuralBaseListener.class);
    /* Used to parse path expressions */
    protected final PathExpressionListener pathExpressionListener;
    /* Used to create fresh aql variables */
    protected final VariableFactory aqlVariableFactory;
    /* Used to map aql variables and the internal fresh variables */
    protected final VariableMapper variableMapper;

    /*
     * Used to keep the introduced variables of the path expression being parsed
     */
    private List<Tuple<Variable, PathExpression>> definitions;
    /* Used to know the variable being introduced */
    protected Variable currentVar;

    private List<String> models;

    public StructuralBaseListener(final PathExpressionListener listener, final VariableFactory aqlVariableFactory,
            final VariableMapper variableMapper) {
        pathExpressionListener = checkNotNull(listener);
        this.aqlVariableFactory = checkNotNull(aqlVariableFactory);
        this.variableMapper = checkNotNull(variableMapper);
    }

    public Structural parse(final String str) throws ParseException {
        definitions = new ArrayList<Tuple<Variable, PathExpression>>();
        currentVar = null;
        models = new ArrayList<String>();
        models.add(AJModel.ID);

        final AQLLexer lexer = new AQLLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final AQLParser parser = new AQLParser(tokens);
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
        LOGGER.debug("entering defineVariable");
        if (currentVar == null) {
            throw new IllegalStateException("Variable expected.");
        }
        definitions.add(new Tuple<Variable, PathExpression>(currentVar, pathExpression));
        currentVar = null;

    }

    protected abstract ParserRuleContext createParseTree(final AQLParser parser);
}