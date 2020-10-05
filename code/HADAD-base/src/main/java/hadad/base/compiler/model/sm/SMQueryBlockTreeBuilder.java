package hadad.base.compiler.model.sm;

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
 * SJ QueryBlockTreeBuilder which implements {@link QueryBlockTreeBuilder}.
 * 
 *   
 */
@Singleton
public final class SMQueryBlockTreeBuilder implements QueryBlockTreeBuilder {
    private final PathExpressionListener pathExpressionListener;
    private final ReturnTemplateListener returnTemplateListener;
    private final PatternListener patternListener;
    private final QueryBlockTreeListener queryBlockTreeListener;

    @Inject
    public SMQueryBlockTreeBuilder(final PathExpressionListener pathExpressionListener,
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

    @Override
    public ReturnTemplate buildReturnTemplate(ImmutableMap<Variable, PathExpression> definitions, final String str)
            throws ParseException {
        return null;
    }

    @Override
    public QueryBlockTree buildQueryBlockTree(final String str) throws ParseException {
        return queryBlockTreeListener.parse(str);
    }

    @Override
    public Pattern buildPattern(final String str) throws ParseException {

        return patternListener.parse(str);
    }

    public VariableMapper getVariableMapper() {

        return patternListener.getVariableMapper();
    }
}
