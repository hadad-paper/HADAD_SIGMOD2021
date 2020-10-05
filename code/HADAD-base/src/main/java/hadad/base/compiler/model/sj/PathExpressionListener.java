package hadad.base.compiler.model.sj;

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
import hadad.base.compiler.model.sj.SJQLParser.SjFieldNameContext;
import hadad.base.compiler.DocumentsCatalog;
import hadad.base.compiler.PathExpression;
import hadad.base.compiler.VariableFactory;
import hadad.base.compiler.VariableMapper;
import hadad.base.compiler.exceptions.ParseException;

/**
 * SJ PathExpressionListener
 * 
 *  
 *
 */
@Singleton
class PathExpressionListener extends SJQLBaseListener {
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
     * Parse the query body in case of SJ
     * 
     * @param str
     *            The query body
     *
     * @return pathExpression. Parsed PathExpression
     * @throws ParseException
     */
    public PathExpression parse(final String str) throws ParseException {
        referredVariables = new HashSet<Variable>();
        encoding = new ArrayList<Atom>();
        currentVar = null;

        final SJQLLexer lexer = new SJQLLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final SJQLParser parser = new SJQLParser(tokens);
        final ParserRuleContext tree = parser.sjQuery();
        final ParseTreeWalker walker = new ParseTreeWalker();
        try {
            walker.walk(this, tree);
            return new PathExpression(SJModel.ID, referredVariables, encoding, currentVar,
                    new HashMap<String, String>());
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
    }

    @Override
    public void enterSjCollectionName(SJQLParser.SjCollectionNameContext ctx) {
        LOGGER.debug("Entering CollectionName: " + ctx.getText());
        final Variable var = cqVariableFactory.createFreshVar();
        encoding.add(
                new Atom(Predicate.ROOT.toString() + documentNamePrefix + documentsCatalog.getId(ctx.getText()), var));
        currentVar = var;
    }

    @Override
    public void enterSjProjectFields(SJQLParser.SjProjectFieldsContext ctx) {
        LOGGER.debug("Entering ProjectFields: " + ctx.getText());
        for (SjFieldNameContext fnctx : ctx.sjFieldName()) {
            final Variable var = cqVariableFactory.createFreshVar();
            encoding.add(new Atom(Predicate.CHILD.toString(), currentVar, var, Utils.toTerm(fnctx.getText()),
                    Utils.toTerm(DataType.OBJECT.toString())));
            variableMapper.define(fnctx.getText(), var);
        }
    }

    @Override
    public void enterSjTextSearch(SJQLParser.SjTextSearchContext ctx) {
        LOGGER.debug("Entering TextSearch: " + ctx.getText());
        final Variable var = cqVariableFactory.createFreshVar();
        encoding.add(new Atom(Predicate.CHILD.toString(), currentVar, var,
                Utils.toTerm(ctx.sjLeftTerm().sjTerm().sjFieldName().getText()),
                Utils.toTerm(DataType.OBJECT.toString())));
        variableMapper.define(ctx.sjLeftTerm().sjTerm().sjFieldName().getText(), var);

    }

}
