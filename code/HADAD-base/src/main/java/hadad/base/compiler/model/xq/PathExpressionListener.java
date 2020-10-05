package hadad.base.compiler.model.xq;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
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
 * 
 */
@Singleton
class PathExpressionListener extends XQueryBaseListener {
    private static final Logger log = Logger.getLogger(PathExpressionListener.class);
    /* Used to create fresh CQ variables */
    private final VariableFactory cqVariableFactory;
    /* Used to map xquery variables and the internal fresh variables */
    private final VariableMapper variableMapper;
    /* Used to keep the document name prefix of this path expression */
    private final String documentNamePrefix;
    /* Used to get the document name of the document sources */
    private final DocumentsCatalog documentsCatalog;
    /* Used to keep the referred variables in the path expression being parsed */
    private Set<Variable> referredVariables;
    /* Used to keep the encoding of the path expression being parsed */
    private List<Atom> encoding;
    /* Used to keep the optionals of the path expression being parsed */
    private Map<String, String> optionals;

    /*
     * The pointer to the current variable for the return element of the path
     * expression
     */
    private Variable currentVar;
    /*
     * The pointer to the previous variable for the return element of the path
     * expression
     *
     * Used to rollback the last child in case of text()
     */
    private Variable previousVar;
    /* Used to know if inside a ApAttr */
    private boolean insideApAttrFlag;

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
        optionals = new HashMap<String, String>();
        optionals.put(PathExpressionOptional.ENDS_WITH_TEXT.toString(), "false");
        currentVar = null;
        previousVar = null;
        insideApAttrFlag = false;

        final XQueryLexer lexer = new XQueryLexer(new ANTLRInputStream(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final XQueryParser parser = new XQueryParser(tokens);
        final ParserRuleContext tree = parser.p();
        final ParseTreeWalker walker = new ParseTreeWalker();
        try {
            walker.walk(this, tree);
            return new PathExpression(XQModel.ID, referredVariables, encoding, currentVar, optionals);
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
    }

    @Override
    public void enterRpText(XQueryParser.RpTextContext ctx) {
        log.debug("Entering RpText: " + ctx.getText());
        encoding.remove(encoding.size() - 1); // Rollback the last child
        final Variable var = cqVariableFactory.createFreshVar();
        encoding.add(new Atom(Predicate.TEXT.toString(), previousVar, var));
        previousVar = null;
        currentVar = var;
        optionals.put(PathExpressionOptional.ENDS_WITH_TEXT.toString(), "true");
    }

    @Override
    public void enterRpDot(XQueryParser.RpDotContext ctx) {
        log.debug("Entering RpDot: " + ctx.getText());
        throw new IllegalStateException("Dot semantic is not defined for path expressions.");
    }

    @Override
    public void enterChild(XQueryParser.ChildContext ctx) {
        log.debug("Entering Child: " + ctx.getText());
        final Variable var = cqVariableFactory.createFreshVar();
        encoding.add(new Atom(Predicate.CHILD.toString(), currentVar, var));
        previousVar = currentVar;
        currentVar = var;
    }

    @Override
    public void enterDesc(XQueryParser.DescContext ctx) {
        log.debug("Entering Descendant: " + ctx.getText());
        final Variable var1 = cqVariableFactory.createFreshVar();
        final Variable var2 = cqVariableFactory.createFreshVar();
        encoding.add(new Atom(Predicate.DESCENDANT.toString(), currentVar, var1));
        encoding.add(new Atom(Predicate.CHILD.toString(), var1, var2));
        currentVar = var2;
    }

    @Override
    public void enterSource(XQueryParser.SourceContext ctx) {
        log.debug("Entering Soruce: " + ctx.getText());
        final Variable var = cqVariableFactory.createFreshVar();
        encoding.add(
                new Atom(Predicate.ROOT.toString() + documentNamePrefix + documentsCatalog.getId(ctx.getText()), var));
        previousVar = currentVar;
        currentVar = var;
    }

    @Override
    public void enterRpTag(XQueryParser.RpTagContext ctx) {
        log.debug("Entering RpTag: " + ctx.getText());
        encoding.add(new Atom(Predicate.TAG.toString(), currentVar, new StringConstant(ctx.getText())));
    }

    @Override
    public void enterRpAttr(XQueryParser.RpAttrContext ctx) {
        log.debug("Entering RpAttr: " + ctx.getText());
        final int arrobaPos = ctx.getText().lastIndexOf('@');
        final StringConstant tag = new StringConstant(ctx.getText().substring(0, arrobaPos));
        final StringConstant attr = new StringConstant(ctx.getText().substring(arrobaPos + 1));
        encoding.add(new Atom(Predicate.TAG.toString(), currentVar, tag));
        encoding.add(new Atom(Predicate.HAS_ATTRIBUTE.toString(), currentVar, attr));
        final Variable var = cqVariableFactory.createFreshVar();
        encoding.add(new Atom(Predicate.HAS_ATTRIBUTE_VALUE.toString(), currentVar, attr, var));
        currentVar = var;
    }

    @Override
    public void enterApAttr(XQueryParser.ApAttrContext ctx) {
        log.debug("Entering ApAttr: " + ctx.getText());
        insideApAttrFlag = true;
        final int arrobaPos = ctx.getText().lastIndexOf('@');
        final Variable var = variableMapper.getVariable(ctx.getText().substring(0, arrobaPos));
        final StringConstant attr = new StringConstant(ctx.getText().substring(arrobaPos + 1));
        referredVariables.add(var);
        encoding.add(new Atom(Predicate.HAS_ATTRIBUTE.toString(), var, attr));
        currentVar = cqVariableFactory.createFreshVar();
        encoding.add(new Atom(Predicate.HAS_ATTRIBUTE_VALUE.toString(), var, attr, currentVar));
    }

    @Override
    public void exitApAttr(XQueryParser.ApAttrContext ctx) {
        log.debug("Exiting ApAttr: " + ctx.getText());
        insideApAttrFlag = false;
    }

    @Override
    public void enterVar(XQueryParser.VarContext ctx) {
        log.debug("Entering Var: " + ctx.getText());
        if (!insideApAttrFlag) {
            final Variable var = variableMapper.getVariable(ctx.getText());
            referredVariables.add(var);
            currentVar = var;
        }
    }
}
