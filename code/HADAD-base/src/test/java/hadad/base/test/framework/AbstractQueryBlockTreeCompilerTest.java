package hadad.base.test.framework;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;

import com.google.common.collect.ImmutableList;

import hadad.commons.relationalschema.Relation;
import hadad.commons.relationalschema.RelationalSchema;
import hadad.base.rewriter.ConjunctiveQueryRewriter;
import hadad.base.rewriter.Context;
import hadad.base.rewriter.PACBConjunctiveQueryRewriter;
import hadad.base.compiler.QueryBlockTree;
import hadad.base.compiler.QueryBlockTreeBuilder;
import hadad.base.compiler.QueryBlockTreeViewCompiler;

/**
 * Abstract class for query block tree compilers unit tests.
 * 
 *   
 *
 */
public abstract class AbstractQueryBlockTreeCompilerTest {
    protected QueryBlockTreeBuilder builder;
    private ImmutableList<QueryBlockTreeViewCompiler> compilers;

    @Before
    public void setUp() {
        builder = createBuilder();
        compilers = ImmutableList.copyOf(createCompilers());
    }

    @After
    public void tearDown() {
        builder = null;
        compilers = null;
    }

    protected abstract QueryBlockTreeBuilder createBuilder();

    protected abstract List<QueryBlockTreeViewCompiler> createCompilers();

    protected List<Context> createContexts(final List<QueryBlockTree> nbts) {
        final List<Context> contexts = new ArrayList<Context>();
        compilers.stream().forEach(
                c -> contexts.add(c.compileContext(nbts, new RelationalSchema(new ArrayList<Relation>()), false)));
        return contexts;
    }

    protected List<ConjunctiveQueryRewriter> createRewriters(final List<QueryBlockTree> nbts) {
        final List<ConjunctiveQueryRewriter> rewriters = new ArrayList<ConjunctiveQueryRewriter>();
        createContexts(nbts).stream().forEach(c -> rewriters.add(new PACBConjunctiveQueryRewriter(c)));
        return rewriters;
    }
}
