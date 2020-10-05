package hadad.base.compiler.model.rk;

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
 * RK QueryBlockTreeBuilder
 * 
 * 
 */
@Singleton
public final class RKQueryBlockTreeBuilder implements QueryBlockTreeBuilder {
    private final LookUpExpressionListener lookUpExpressionListener;
    private final ReturnTemplateListener returnTemplateListener;
    private final BlockTreeListener rootBlock;
    private final PatternListener patetrnListener;

    @Inject
    public RKQueryBlockTreeBuilder(final LookUpExpressionListener pathExpressionListener,
            final ReturnTemplateListener returnTemplateListener, final BlockTreeListener rootBlock,
            final PatternListener patternListener) {
        this.lookUpExpressionListener = pathExpressionListener;
        this.returnTemplateListener = returnTemplateListener;
        this.rootBlock = rootBlock;
        this.patetrnListener = patternListener;
    }

    @Override
    public PathExpression buildPathExpression(final String str) throws ParseException {
        return lookUpExpressionListener.parse(str);
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

        return rootBlock.parse(str);
    }

    @Override
    public Pattern buildPattern(String str) throws ParseException {

        return patetrnListener.parse(str);
    }

    public VariableMapper getVariableMapper() {
        return patetrnListener.getVariableMapper();
    }
}
