package hadad.base.compiler.model.sppj;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.commons.conjunctivequery.Variable;
import hadad.base.compiler.PathExpression;
import hadad.base.compiler.Pattern;
import hadad.base.compiler.QueryBlockTree;
import hadad.base.compiler.QueryBlockTreeBuilder;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.VariableMapper;
import hadad.base.compiler.exceptions.ParseException;

/**
 * SPPJ QueryBlockTreeBuilder
 * 
 * 
 *
 */
@Singleton
public final class SPPJQueryBlockTreeBuilder implements QueryBlockTreeBuilder {
    private final PathExpressionListener pathExpressionListener;
    private final ReturnTemplateListener returnTemplateListener;
    private final QueryBlockTreeListener queryBlockTreeListener;
    private final PatternListener patternListener;

    @Inject
    public SPPJQueryBlockTreeBuilder(final PathExpressionListener pathExpressionListener,
            final ReturnTemplateListener returnTemplateListener, final QueryBlockTreeListener queryBlockTreeListener,
            final PatternListener patternListener) {
        this.pathExpressionListener = pathExpressionListener;
        this.returnTemplateListener = returnTemplateListener;
        this.queryBlockTreeListener = queryBlockTreeListener;
        this.patternListener = patternListener;
    }

    @Override
    public PathExpression buildPathExpression(final String str) throws ParseException {
        return pathExpressionListener.parse(str);
    }

    /**
     * The definitions are not used.
     */
    @Override
    public ReturnTemplate buildReturnTemplate(ImmutableMap<Variable, PathExpression> definitions, final String str)
            throws ParseException {
        return returnTemplateListener.parse(str);
    }

    @Override
    public QueryBlockTree buildQueryBlockTree(final String str) throws ParseException {
        return queryBlockTreeListener.parse(str);
    }

    @Override
    public Pattern buildPattern(String str) throws ParseException {

        return patternListener.parse(str);
    }

    public VariableMapper getVariableMapper() {

        return patternListener.getVariableMapper();
    }
}
