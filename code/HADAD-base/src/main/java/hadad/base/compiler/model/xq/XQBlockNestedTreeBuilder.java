package hadad.base.compiler.model.xq;

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
 * 
 */
@Singleton
public final class XQBlockNestedTreeBuilder implements QueryBlockTreeBuilder {
    private final PathExpressionListener pathExpressionListener;
    private final ReturnTemplateListener returnTemplateListener;
    private final NestedBlockTreeListener nestedBlockTreeListener;
    private final PatternListener patternListener;

    @Inject
    public XQBlockNestedTreeBuilder(final PathExpressionListener pathExpressionListener,
            final ReturnTemplateListener returnTemplateListener, final NestedBlockTreeListener nestedBlockTreeListener,
            final PatternListener patternListener) {
        this.pathExpressionListener = pathExpressionListener;
        this.returnTemplateListener = returnTemplateListener;
        this.nestedBlockTreeListener = nestedBlockTreeListener;
        this.patternListener = patternListener;
    }

    @Override
    public PathExpression buildPathExpression(final String str) throws ParseException {
        return pathExpressionListener.parse(str);
    }

    @Override
    public ReturnTemplate buildReturnTemplate(ImmutableMap<Variable, PathExpression> definitions, final String str)
            throws ParseException {
        return returnTemplateListener.parse(definitions, str);
    }

    @Override
    public QueryBlockTree buildQueryBlockTree(final String str) throws ParseException {
        return nestedBlockTreeListener.parse(str);
    }

    @Override
    public Pattern buildPattern(String str) throws ParseException {
        return patternListener.parse(str);
    }

    public VariableMapper getVariableMapper() {
        return patternListener.getVariableMapper();
    }
}
