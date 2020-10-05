package hadad.base.compiler.model.pr;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.Variable;
import hadad.commons.miscellaneous.Tuple;
import hadad.base.compiler.PathExpression;
import hadad.base.compiler.Structural;
import hadad.base.compiler.VariableFactory;
import hadad.base.compiler.VariableMapper;
import hadad.base.compiler.exceptions.ParseException;

/**
 * PR StructuralBaseListener
 * 
 *   
 */
abstract class StructuralBaseListener extends SQLBaseListener {
    protected final VariableFactory sqlVariableFactory;
    protected final VariableMapper variableMapper;
    protected final ReturnTemplateListener returnListener;
    static List<Tuple<Variable, PathExpression>> definitions;
    protected Variable currentVar;
    protected Variable leftJoinVariable;
    protected String bindingRelation;
    protected String relationName;
    protected Map<String, Object> relationColumnMapper;
    protected Map<String, Object> relationLefttermMapper;
    protected Map<String, Object> relationRighttermMapper;
    protected Map<String, String> relationMapper;
    static List<Atom> encoding;
    private List<String> models;

    public StructuralBaseListener(final VariableFactory aqlVariableFactory, final VariableMapper variableMapper,
            final ReturnTemplateListener returnListener) {
        this.sqlVariableFactory = checkNotNull(aqlVariableFactory);
        this.variableMapper = checkNotNull(variableMapper);
        this.returnListener = returnListener;

    }

    public Structural parse(final String str) throws ParseException {
        definitions = new ArrayList<Tuple<Variable, PathExpression>>();
        currentVar = null;
        encoding = new ArrayList<Atom>();
        models = new ArrayList<String>();
        models.add(PRModel.ID);
        relationColumnMapper = new LinkedHashMap<String, Object>();
        relationLefttermMapper = new LinkedHashMap<String, Object>();
        relationRighttermMapper = new LinkedHashMap<String, Object>();
        relationMapper = new LinkedHashMap<String, String>();
        leftJoinVariable = null;
        returnListener.parse(BlockListener.returnStatement);
        final SQLLexer lexer = new SQLLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final SQLParser parser = new SQLParser(tokens);
        final ParserRuleContext tree = createParseTree(parser);
        final ParseTreeWalker walker = new ParseTreeWalker();
        try {
            walker.walk(this, tree);
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
        for (String variable : returnListener.getReferdVariables()) {
            definitions.add(new Tuple<Variable, PathExpression>(variableMapper.getVariable(variable),
                    new PathExpression(PRModel.ID, new HashSet<Variable>(), encoding, null)));
        }

        return new Structural(definitions, models);
    }

    protected abstract ParserRuleContext createParseTree(final SQLParser parser);
}
