package hadad.base.compiler.model.rk;

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
import hadad.base.compiler.MapsCatalog;
import hadad.base.compiler.PathExpression;
import hadad.base.compiler.VariableFactory;
import hadad.base.compiler.VariableMapper;
import hadad.base.compiler.exceptions.ParseException;
import hadad.base.compiler.model.qbt.QBTQueryBlockTreeBuilder;

/**
 * RK LookUpExpressionListener
 * 
 * 
 */
@Singleton
class LookUpExpressionListener extends KQLBaseListener {
    private static final Logger LOG = Logger.getLogger(LookUpExpressionListener.class);
    /* Used to create fresh CQ variables */
    private final VariableFactory cqVariableFactory;
    /* Used to map kqlquery variables and the internal fresh variables */
    private final VariableMapper variableMapper;
    /* Used to keep the document name prefix of this path expression */
    private final String mapNamePrefix;
    /* Used to get the document name of the document sources */
    private final MapsCatalog mapsCatalog;
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
    /*
     * The pointer to the current variable for the points to the main Map
     */
    // private Variable currentRootVar;
    /*
     * The pointer to the variable that is used for the map look up
     */
    public static Variable lookUpVariable;
    /*
     * The pointer to the variable that is current main map
     */

    public static Variable currentRootVar;
    /*
     * The pointer to the variable that is used for the current internal map lookup
     */
    public static Variable currentInternalMap;
    /*
     * The pointer variable that distinguishes between a single variable uses for
     * lookup and another variable that used in return template to the variable that
     * is used for the current internal map lookup
     */
    public static Variable currentVarVal;
    /* Used to know the set variable being introduced */
    public static Variable setVar;
    /* Used to retain the set variables that are leaf variables */
    public Set<Variable> setListVars;

    @Inject
    public LookUpExpressionListener(@Named("document_name_prefix") final String mapNamePrefix,
            @Named("ConjunctiveQueryVariableFactory") final VariableFactory cqVariableFactory,
            final VariableMapper variableMapper, final MapsCatalog mapsCatalog,
            @Named("BaseTypeVariable") final Set<Variable> setListVars) {
        this.mapNamePrefix = checkNotNull(mapNamePrefix);
        this.cqVariableFactory = checkNotNull(cqVariableFactory);
        this.variableMapper = checkNotNull(variableMapper);
        this.mapsCatalog = checkNotNull(mapsCatalog);
        this.setListVars = setListVars;
    }

    public PathExpression parse(final String str) throws ParseException {
        referredVariables = new HashSet<Variable>();
        encoding = new ArrayList<Atom>();
        currentVar = null;
        final KQLLexer lexer = new KQLLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final KQLParser parser = new KQLParser(tokens);
        final ParserRuleContext tree = parser.rkSource();
        final ParseTreeWalker walker = new ParseTreeWalker();
        try {
            walker.walk(this, tree);
            return new PathExpression(RKModel.ID, referredVariables, encoding, currentVar,
                    new HashMap<String, String>());
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
    }

    @Override
    public void enterMainMapLookUp(KQLParser.MainMapLookUpContext ctx) {
        LOG.debug("Entering MainMap: " + ctx.getText());
        if (currentRootVar == null) {
            final Variable var = cqVariableFactory.createFreshVar();
            currentRootVar = var;
            encoding.add(new Atom(
                    Predicate.MAINMAP.toString() + mapNamePrefix + mapsCatalog.getId(ctx.getText()).replace("-", ""),
                    var));
            currentVar = var;
        }
    }

    @Override
    public void exitMainMapLookUp(KQLParser.MainMapLookUpContext ctx) {
        LOG.debug("Exiting Main Map Look Up " + ctx.getText());
        final Variable var = cqVariableFactory.createFreshVar();
        if (lookUpVariable != null) {
            encoding.add(new Atom(Predicate.COLLECTION.toString(), currentRootVar, var, lookUpVariable,
                    Utils.toTerm(DataType.MAP.toString())));
        } else {
            encoding.add(new Atom(Predicate.COLLECTION.toString(), currentRootVar, var,
                    Utils.toTerm(ctx.rkKey(0).rkStringKey().getText().replaceAll("'", "")),
                    Utils.toTerm(DataType.MAP.toString())));
        }
        currentVar = var;
    }

    @Override
    public void exitVariableKey(KQLParser.VariableKeyContext ctx) {
        LOG.debug("Exiting VariableKey: " + ctx.getText());
        if (variableMapper.isNotDefined(ctx.getText())
                && !QBTQueryBlockTreeBuilder.variableMapper.isEmptyVariablesMapping()
                && (QBTQueryBlockTreeBuilder.variableMapper.getVariable((ctx.getText())) != null)) {
            final Variable varVal = QBTQueryBlockTreeBuilder.variableMapper.getVariable(ctx.getText());
            lookUpVariable = varVal;
        } else {
            final Variable var = variableMapper.getVariable(ctx.getText());
            referredVariables.add(var);
            if (!(currentVarVal != null && !var.toString().equals(currentVarVal.toString()))) {
                currentVar = var;
                final Variable varVal = cqVariableFactory.createFreshVar();
                encoding.add(new Atom(Predicate.COLLECTION.toString(), currentVar, varVal, Utils.toTerm(Utils.NOLOOKUP),
                        Utils.toTerm(DataType.SET.toString())));
                lookUpVariable = varVal;
            }
        }
    }

    @Override
    public void enterMapVariable(KQLParser.MapVariableContext ctx) {
        LOG.debug("Entering MapVariable Name: " + ctx.getText());
        final Variable var = variableMapper.getVariable(ctx.getText());
        LOG.debug("Entering MapVariable: " + var);
        referredVariables.add(var);
        currentVar = var;
    }

    @Override
    public void exitVariableMapLookUp(KQLParser.VariableMapLookUpContext ctx) {
        LOG.debug("Entering Variable Map LookUp: " + ctx.getText());
        final Variable var = cqVariableFactory.createFreshVar();
        if (ctx.rkKey(0).variableKey() != null) {
            if (currentInternalMap != null) {
                encoding.add(new Atom(Predicate.COLLECTION.toString(), currentInternalMap, var, lookUpVariable,
                        Utils.toTerm(DataType.INTERNALMAP.toString())));
            } else {
                encoding.add(new Atom(Predicate.COLLECTION.toString(), currentVar, var, lookUpVariable,
                        Utils.toTerm(DataType.INTERNALMAP.toString())));
            }
            currentVar = var;
        } else {
            final Variable varVal = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.COLLECTION.toString(), currentVar, var,
                    Utils.toTerm(ctx.rkKey(0).rkStringKey().getText().replaceAll("'", "")),
                    Utils.toTerm(DataType.INTERNALMAP.toString())));
            encoding.add(new Atom(Predicate.COLLECTION.toString(), var, varVal, Utils.toTerm(Utils.NOLOOKUP),
                    Utils.toTerm(DataType.SET.toString())));
            currentVarVal = var;
            currentVar = var;
            lookUpVariable = varVal;
            setVar = varVal;
            setListVars.add(varVal);
        }
    }

    @Override
    public void exitKeyVariable(KQLParser.KeyVariableContext ctx) {
        LOG.debug("Entering KeyVariable Name: " + ctx.getText());
        final Variable var = variableMapper.getVariable(ctx.getText());
        LOG.debug("Entering MapVariable: " + var);
        referredVariables.add(var);
        currentVar = var;
        final Variable varVal = cqVariableFactory.createFreshVar();
        encoding.add(new Atom(Predicate.COLLECTION.toString(), currentVar, varVal, Utils.toTerm(Utils.NOLOOKUP),
                Utils.toTerm(DataType.KEYSLOOKUP.toString())));
        currentInternalMap = var;
        currentVar = varVal;
    }

}
