package hadad.base.compiler.model.pj.full;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.Variable;
import hadad.base.compiler.DocumentsCatalog;
import hadad.base.compiler.PathExpression;
import hadad.base.compiler.VariableFactory;
import hadad.base.compiler.VariableMapper;
import hadad.base.compiler.exceptions.ParseException;

/**
 * PJ PathExpressionListener
 *
 */
@Singleton
class PathExpressionListener extends PJQLBaseListener {
    private static final Logger LOGGER = Logger.getLogger(PathExpressionListener.class);
    private final VariableFactory cqVariableFactory;
    private final VariableMapper variableMapper;
    private final String documentNamePrefix;
    private final DocumentsCatalog documentsCatalog;
    private Set<Variable> referredVariables;
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
     * Parse the path expression.
     * 
     * @param str
     *            the path expression that needs to be parsed
     * @return
     * @throws ParseException
     */
    public PathExpression parse(final String str) throws ParseException {
        referredVariables = new HashSet<Variable>();
        encoding = new ArrayList<Atom>();
        currentVar = null;

        final PJQLLexer lexer = new PJQLLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final PJQLParser parser = new PJQLParser(tokens);
        final ParserRuleContext tree = parser.pjSource();
        final ParseTreeWalker walker = new ParseTreeWalker();
        try {
            walker.walk(this, tree);
            return new PathExpression(PJModel.ID, referredVariables, encoding, currentVar,
                    new HashMap<String, String>());
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
    }

    @Override
    public void enterPjRelation(PJQLParser.PjRelationContext ctx) {
        LOGGER.debug("Entering relation: " + ctx.getText());
        final Variable var = cqVariableFactory.createFreshVar();
        encoding.add(
                new Atom(Predicate.ROOT.toString() + documentNamePrefix + documentsCatalog.getId(ctx.getText()), var));
        currentVar = var;
    }

    @Override
    public void enterPjPathVar(PJQLParser.PjPathVarContext ctx) {
        LOGGER.debug("Entering PathVar: " + ctx.getText());
        System.out.println(variableMapper.toString());
        final Variable var = variableMapper.getVariable(ctx.getText());
        referredVariables.add(var);
        currentVar = var;
    }

    @Override
    public void enterPjObjStep(PJQLParser.PjObjStepContext ctx) {
        LOGGER.debug("Entering ObjectStep: " + ctx.getText());
        final Variable var = cqVariableFactory.createFreshVar();
        encoding.add(new Atom(Predicate.CHILD.toString(), currentVar, var,
                Utils.toTerm(ctx.getText().substring(2).replace("\'", "")), Utils.toTerm(DataType.OBJECT.toString())));
        currentVar = var;

    }
}
