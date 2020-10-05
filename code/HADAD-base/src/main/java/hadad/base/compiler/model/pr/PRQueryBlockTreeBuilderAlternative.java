package hadad.base.compiler.model.pr;

import java.util.LinkedHashMap;
import java.util.Map;

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
 * PRQueryBlockTreeBuilderAlternative which implements {@link QueryBlockTreeBuilder}.
 * 
 *   
 *
 */
@Singleton
public final class PRQueryBlockTreeBuilderAlternative implements QueryBlockTreeBuilder {
    private final ReturnTemplateListener returnTemplateListener;
    private final QueryBlockTreeListener rootBlock;
    private final PatternListener patetrnListener;

    public static Map<String, Relation> relations;
    public static Map<String, Map<String, Object>> realtionsFreshVaribales;

    @Inject
    public PRQueryBlockTreeBuilderAlternative(final ReturnTemplateListener returnTemplateListener,
            final QueryBlockTreeListener rootBlock, final PatternListener patternListener) {

        this.returnTemplateListener = returnTemplateListener;
        this.rootBlock = rootBlock;
        this.patetrnListener = patternListener;
        PRQueryBlockTreeBuilderAlternative.realtionsFreshVaribales = new LinkedHashMap<String, Map<String, Object>>();
    }

    @Override
    public PathExpression buildPathExpression(final String str) throws ParseException {
        return null;
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

    /**
     * Gets Variable Mapping in a pattern
     * 
     * @return variableMapping in this pattern
     */
    public VariableMapper getVariableMapper() {
        return patetrnListener.getVariableMapper();
    }

    /**
     * Sets the relations that are used in a current NBTbuilder
     * 
     * @param relations
     */
    public void setRelations(Map<String, Relation> relations) {
        PRQueryBlockTreeBuilderAlternative.relations = relations;

    }

    /**
     * Reset variables
     */
    public void resetVariables() {
        realtionsFreshVaribales.clear();
    }
}
