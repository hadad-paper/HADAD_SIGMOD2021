package hadad.base.compiler.model.qbt;

import java.util.Map;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

import hadad.commons.conjunctivequery.Variable;
import hadad.base.compiler.model.pj.naive.PJNaiveModule;
import hadad.base.compiler.model.pr.PRNaiveModule;
import hadad.base.compiler.model.pr.PRQueryBlockTreeBuilderAlternative;
import hadad.base.compiler.model.pr.Relation;
import hadad.base.compiler.model.sj.SJQueryBlockTreeBuilder;
import hadad.base.compiler.model.sj.naive.SJNaiveModule;
import hadad.base.compiler.PathExpression;
import hadad.base.compiler.Pattern;
import hadad.base.compiler.QueryBlockTree;
import hadad.base.compiler.QueryBlockTreeBuilder;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.VariableMapper;
import hadad.base.compiler.exceptions.ParseException;
import hadad.base.compiler.model.aj.AJQueryBlockTreeBuilder;
import hadad.base.compiler.model.aj.naive.AJNaiveModule;
import hadad.base.compiler.model.pj.full.PJFULLQueryBlockTreeBuilder;
import hadad.base.compiler.model.rk.RKQueryBlockTreeBuilder;
import hadad.base.compiler.model.rk.naive.RKNaiveModule;
import hadad.base.compiler.model.sppj.SPPJQueryBlockTreeBuilder;
import hadad.base.compiler.model.sppj.naive.SPPJNaiveModule;

/**
 * QBT QueryBlockTreeBuilder
 * 
 *   
 *
 */
@Singleton
public final class QBTQueryBlockTreeBuilder implements QueryBlockTreeBuilder {
    static RKQueryBlockTreeBuilder rkBlockNestedTreeBuilder;
    static AJQueryBlockTreeBuilder ajBlockNestedTreeBuilder;
    static PRQueryBlockTreeBuilderAlternative prBlockNestedTreeBuilder;
    static PJFULLQueryBlockTreeBuilder pjBlockNestedTreeBuilder;
    static SPPJQueryBlockTreeBuilder sppjBlockNestedTreeBuilder;
    static SJQueryBlockTreeBuilder sjBlockNestedTreeBuilder;
    public static VariableMapper variableMapper;
    public static Map<String, Relation> relations;
    private final PatternListener patternListener;
    private final ReturnTemplateListener returnTemplateListener;
    private final QBTQueryBlockTreeListener queryBlockTreeListener;

    @Inject
    public QBTQueryBlockTreeBuilder(final QBTQueryBlockTreeListener queryBlockTreeListener,
            final PatternListener patternListener, final ReturnTemplateListener returnTemplateListener,
            final VariableMapper variableMapper) {
        Injector injectorRK = Guice.createInjector(new RKNaiveModule());
        Injector injectorAJ = Guice.createInjector(new AJNaiveModule());
        Injector injectorRQ = Guice.createInjector(new PRNaiveModule());
        Injector injectorPJ = Guice.createInjector(new PJNaiveModule());
        Injector injectorSPPJ = Guice.createInjector(new SPPJNaiveModule());
        Injector injectorSJ = Guice.createInjector(new SJNaiveModule());

        this.queryBlockTreeListener = queryBlockTreeListener;
        this.patternListener = patternListener;
        this.returnTemplateListener = returnTemplateListener;
        QBTQueryBlockTreeBuilder.variableMapper = variableMapper;
        QBTQueryBlockTreeBuilder.rkBlockNestedTreeBuilder = injectorRK.getInstance(RKQueryBlockTreeBuilder.class);
        QBTQueryBlockTreeBuilder.ajBlockNestedTreeBuilder = injectorAJ.getInstance(AJQueryBlockTreeBuilder.class);
        QBTQueryBlockTreeBuilder.prBlockNestedTreeBuilder =
                injectorRQ.getInstance(PRQueryBlockTreeBuilderAlternative.class);
        QBTQueryBlockTreeBuilder.pjBlockNestedTreeBuilder = injectorPJ.getInstance(PJFULLQueryBlockTreeBuilder.class);
        QBTQueryBlockTreeBuilder.sppjBlockNestedTreeBuilder = injectorSPPJ.getInstance(SPPJQueryBlockTreeBuilder.class);
        QBTQueryBlockTreeBuilder.sjBlockNestedTreeBuilder = injectorSJ.getInstance(SJQueryBlockTreeBuilder.class);

    }

    @Override
    public QueryBlockTree buildQueryBlockTree(final String str) throws ParseException {
        QueryBlockTree mixedModelNestedBlockTree = queryBlockTreeListener.parse(str);
        return mixedModelNestedBlockTree;
    }

    @Override
    public Pattern buildPattern(String str) throws ParseException {

        return patternListener.parse(str);
    }

    @Override
    public PathExpression buildPathExpression(String str) throws ParseException {
        return null;
    }

    @Override
    public ReturnTemplate buildReturnTemplate(ImmutableMap<Variable, PathExpression> definitions, String str)
            throws ParseException {
        return returnTemplateListener.parse(str);
    }

    public void setRealtions(Map<String, Relation> relations) {
        PRQueryBlockTreeBuilderAlternative.relations = relations;
    }

    public static void reIntilize() {
        Injector injectorRK = Guice.createInjector(new RKNaiveModule());
        Injector injectorAJ = Guice.createInjector(new AJNaiveModule());
        Injector injectorRQ = Guice.createInjector(new PRNaiveModule());
        Injector injectorPJ = Guice.createInjector(new PJNaiveModule());
        Injector injectorSPPJ = Guice.createInjector(new SPPJNaiveModule());
        Injector injectorSJ = Guice.createInjector(new SJNaiveModule());
        QBTQueryBlockTreeBuilder.rkBlockNestedTreeBuilder = injectorRK.getInstance(RKQueryBlockTreeBuilder.class);
        QBTQueryBlockTreeBuilder.ajBlockNestedTreeBuilder = injectorAJ.getInstance(AJQueryBlockTreeBuilder.class);
        QBTQueryBlockTreeBuilder.prBlockNestedTreeBuilder =
                injectorRQ.getInstance(PRQueryBlockTreeBuilderAlternative.class);
        QBTQueryBlockTreeBuilder.pjBlockNestedTreeBuilder = injectorPJ.getInstance(PJFULLQueryBlockTreeBuilder.class);
        QBTQueryBlockTreeBuilder.sppjBlockNestedTreeBuilder = injectorSPPJ.getInstance(SPPJQueryBlockTreeBuilder.class);
        QBTQueryBlockTreeBuilder.sjBlockNestedTreeBuilder = injectorSJ.getInstance(SJQueryBlockTreeBuilder.class);
        QBTQueryBlockTreeBuilder.variableMapper = new VariableMapper();
        PRQueryBlockTreeBuilderAlternative.relations = null;
    }

}
