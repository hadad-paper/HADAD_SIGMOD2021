package hadad.base.compiler.model.sppj;

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
 * SPPJ StructuralBaseListener
 * 
 * 
 */
abstract class StructuralBaseListener extends SPPJQLBaseListener {
    private static final Logger LOGGER = Logger.getLogger(StructuralBaseListener.class);
    protected final PathExpressionListener pathExpressionListener;
    protected final VariableFactory sppjqlVariableFactory;
    protected final VariableMapper variableMapper;
    private List<Tuple<Variable, PathExpression>> definitions;
    protected Variable currentVar;
    private List<String> models;

    public StructuralBaseListener(final PathExpressionListener pathExpressionlistener,
            final VariableFactory sppjqlVariableFactory, final VariableMapper variableMapper) {
        this.pathExpressionListener = checkNotNull(pathExpressionlistener);
        this.sppjqlVariableFactory = checkNotNull(sppjqlVariableFactory);
        this.variableMapper = checkNotNull(variableMapper);
    }

    public Structural parse(final String str) throws ParseException {
        definitions = new ArrayList<Tuple<Variable, PathExpression>>();
        currentVar = null;
        models = new ArrayList<String>();
        models.add(SPPJModel.ID);

        final SPPJQLLexer lexer = new SPPJQLLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final SPPJQLParser parser = new SPPJQLParser(tokens);
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

    protected abstract ParserRuleContext createParseTree(final SPPJQLParser parser);
}
