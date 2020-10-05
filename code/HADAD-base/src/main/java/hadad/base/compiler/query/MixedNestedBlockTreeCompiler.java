package hadad.base.compiler.query;

import java.util.LinkedHashSet;
import java.util.Set;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.Term;
import hadad.base.compiler.PathExpression;
import hadad.base.compiler.Pattern;
import hadad.base.compiler.QueryBlockTreeQueryCompiler;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.ReturnTerm;
import hadad.base.compiler.exceptions.CompilationException;

/**
 * Mixed nested block query compiler
 * 
 *   
 */
public final class MixedNestedBlockTreeCompiler implements QueryBlockTreeQueryCompiler {
    @Override
    public Set<? extends Atom> compilePattern(Pattern nbtPattern) throws CompilationException {

        final Set<Atom> queryBody = new LinkedHashSet<Atom>();
        for (final PathExpression pathExpression : nbtPattern.getStructural().getPathExpressions()) {
            queryBody.addAll(pathExpression.encoding());
        }
        return queryBody;
    }

    @Override
    public Set<? extends Term> compileReturnTemplate(ReturnTemplate nbtReturnTemplate) throws CompilationException {
        final Set<Term> queryHead = new LinkedHashSet<Term>();
        for (final ReturnTerm returnTerm : nbtReturnTemplate.getTerms()) {
            queryHead.addAll(returnTerm.getReferredVariables());
        }
        return queryHead;
    }
}