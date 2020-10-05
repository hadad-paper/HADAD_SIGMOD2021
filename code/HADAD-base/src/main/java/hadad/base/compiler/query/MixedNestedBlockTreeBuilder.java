package hadad.base.compiler.query;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

import hadad.commons.conjunctivequery.Variable;
import hadad.base.compiler.model.pr.PRNaiveModule;
import hadad.base.compiler.model.pr.PRQueryBlockTreeBuilderAlternative;
import hadad.base.compiler.model.pr.Relation;
import hadad.base.compiler.PathExpression;
import hadad.base.compiler.Pattern;
import hadad.base.compiler.QueryBlockTree;
import hadad.base.compiler.QueryBlockTreeBuilder;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.VariableMapper;
import hadad.base.compiler.exceptions.ParseException;
import hadad.base.compiler.model.aj.AJQueryBlockTreeBuilder;
import hadad.base.compiler.model.aj.naive.AJNaiveModule;
import hadad.base.compiler.model.rk.RKQueryBlockTreeBuilder;
import hadad.base.compiler.model.rk.naive.RKNaiveModule;
import hadad.base.compiler.model.xq.XQBlockNestedTreeBuilder;
import hadad.base.compiler.model.xq.naive.XQNaiveModule;

/**
 * Mixed nested block tree (query) builder
 * 
 *   
 */
@Singleton
public final class MixedNestedBlockTreeBuilder implements QueryBlockTreeBuilder {
    private final PatternListener patternListener;
    private final ReturnTemplateListener returnTemplateListener;
    private final MixedBlockTreeListener nestedBlockTreeListener;

    /*
     * Provide a static way to access the same NBTbuilder for a specified model
     * among different instances
     */
    static RKQueryBlockTreeBuilder kqBlockNestedTreeBuilder;
    static AJQueryBlockTreeBuilder jqBlockNestedTreeBuilder;
    static XQBlockNestedTreeBuilder xqBlockNestedTreeBuilder;
    static PRQueryBlockTreeBuilderAlternative rqBlockNestedTreeBuilder;
    /**
     * Provide a generic and a static way to keep track of mapped variables
     * among different NBT blocks
     */
    public static VariableMapper variableMapper;

    /**
     * In case of having RQ in the pattern since relations schemas are needed
     * during NBTEncdoing
     */
    public static Map<String, Relation> relations;

    @Inject
    public MixedNestedBlockTreeBuilder(final MixedBlockTreeListener nestedBlockTreeListener,
            final PatternListener patternListener, final ReturnTemplateListener returnTemplateListener,
            final VariableMapper variableMapper) {
        Injector injectorKQ = Guice.createInjector(new RKNaiveModule());
        Injector injectorJQ = Guice.createInjector(new AJNaiveModule());
        Injector injectorXQ = Guice.createInjector(new XQNaiveModule());
        Injector injectorRQ = Guice.createInjector(new PRNaiveModule());

        this.nestedBlockTreeListener = nestedBlockTreeListener;
        this.patternListener = patternListener;
        this.returnTemplateListener = returnTemplateListener;
        MixedNestedBlockTreeBuilder.variableMapper = variableMapper;
        MixedNestedBlockTreeBuilder.kqBlockNestedTreeBuilder = injectorKQ.getInstance(RKQueryBlockTreeBuilder.class);
        MixedNestedBlockTreeBuilder.jqBlockNestedTreeBuilder = injectorJQ.getInstance(AJQueryBlockTreeBuilder.class);
        MixedNestedBlockTreeBuilder.xqBlockNestedTreeBuilder = injectorXQ.getInstance(XQBlockNestedTreeBuilder.class);
        MixedNestedBlockTreeBuilder.rqBlockNestedTreeBuilder =
                injectorRQ.getInstance(PRQueryBlockTreeBuilderAlternative.class);

    }

    @Override
    public QueryBlockTree buildQueryBlockTree(final String str) throws ParseException {
        QueryBlockTree mixedModelNestedBlockTree = nestedBlockTreeListener.parse(str);
        return mixedModelNestedBlockTree;
    }

    @Override
    public Pattern buildPattern(String str) throws ParseException {

        return patternListener.parse(str);
    }

    @Override
    public PathExpression buildPathExpression(String str) throws ParseException {
        // NO PathExpression Required
        return null;
    }

    @Override
    public ReturnTemplate buildReturnTemplate(ImmutableMap<Variable, PathExpression> definitions, String str)
            throws ParseException {
        return returnTemplateListener.parse(str);
    }

}
