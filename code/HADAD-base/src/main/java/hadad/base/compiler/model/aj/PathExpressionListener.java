package hadad.base.compiler.model.aj;

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
 * AJ PathExpressionListener which extends {@link AQLBaseListener}
 */
@Singleton
class PathExpressionListener extends AQLBaseListener {
    private static final Logger log = Logger.getLogger(PathExpressionListener.class);
    /* Used to create fresh CQ variables */
    private final VariableFactory cqVariableFactory;
    /* Used to map aqlquery variables and the internal fresh variables */
    private final VariableMapper variableMapper;
    /* Used to keep the document name prefix of this path expression */
    private final String documentNamePrefix;
    /* Used to get the document name of the document sources */
    private final DocumentsCatalog documentsCatalog;
    /*
     * Used to keep the referred variables in the path expression being parsed
     */
    private Set<Variable> referredVariables;
    /* Used to keep the encoding of the path expression being parsed */
    private List<Atom> encoding;

    /*
     * The pointer to the current variable for the return element of the path
     * expression
     */
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

    public PathExpression parse(final String str) throws ParseException {
        referredVariables = new HashSet<Variable>();
        encoding = new ArrayList<Atom>();
        currentVar = null;

        final AQLLexer lexer = new AQLLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final AQLParser parser = new AQLParser(tokens);
        final ParserRuleContext tree = parser.source();
        final ParseTreeWalker walker = new ParseTreeWalker();
        try {
            walker.walk(this, tree);
            return new PathExpression(AJModel.ID, referredVariables, encoding, currentVar,
                    new HashMap<String, String>());
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
    }

    @Override
    public void enterDataSetName(AQLParser.DataSetNameContext ctx) {
        log.debug("Entering Document: " + ctx.getText());
        final Variable var = cqVariableFactory.createFreshVar();
        encoding.add(
                new Atom(Predicate.ROOT.toString() + documentNamePrefix + documentsCatalog.getId(ctx.getText()), var));
        currentVar = var;
    }

    @Override
    public void enterPathVar(AQLParser.PathVarContext ctx) {
        log.debug("Entering PathVar: " + ctx.getText());
        System.out.println(variableMapper.toString());
        final Variable var = variableMapper.getVariable(ctx.getText());
        referredVariables.add(var);
        currentVar = var;
    }

    @Override
    public void enterObjectStep(AQLParser.ObjectStepContext ctx) {
        log.debug("Entering ObjectStep: " + ctx.getText());
        final Variable var = cqVariableFactory.createFreshVar();
        encoding.add(new Atom(Predicate.CHILD.toString(), currentVar, var, Utils.toTerm(ctx.getText().substring(1)),
                Utils.toTerm(DataType.OBJECT.toString())));
        currentVar = var;

    }

    @Override
    public void enterArrayStep(AQLParser.ArrayStepContext ctx) {
        log.debug("Entering ObjectStep: " + ctx.getText());
        final Variable var = cqVariableFactory.createFreshVar();
        encoding.add(new Atom(Predicate.CHILD.toString(), currentVar, var,
                Utils.toTerm(ctx.getText().substring(1, ctx.getText().length() - 1)),
                Utils.toTerm(DataType.ARRAY.toString())));
        currentVar = var;
    }
}
