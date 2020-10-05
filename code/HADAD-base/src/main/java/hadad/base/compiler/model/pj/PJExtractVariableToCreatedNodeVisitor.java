package hadad.base.compiler.model.pj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.Variable;
import hadad.base.compiler.ReturnConstructTerm;
import hadad.base.compiler.ReturnStringTerm;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.ReturnTemplateVisitor;
import hadad.base.compiler.ReturnVariableTerm;
import hadad.base.compiler.VariableCopier;

/**
 * PJ ExtractVariableToCreatedNodeVisitor which implements {@link ReturnTemplateVisitor}
 *
 */
@Singleton
public class PJExtractVariableToCreatedNodeVisitor implements ReturnTemplateVisitor {
    private final VariableCopier variableCopier;
    private ImmutableList.Builder<Atom> builder;
    private String queryName;
    private Set<Variable> copiedVariables;

    @Inject
    public PJExtractVariableToCreatedNodeVisitor(final VariableCopier variableCopier) {
        this.variableCopier = variableCopier;
    }

    public List<Atom> encode(final ReturnTemplate template, final String queryName) {
        builder = ImmutableList.builder();
        this.queryName = queryName;
        copiedVariables = new HashSet<Variable>();
        template.accept(this);
        return builder.build();
    }

    public List<Atom> encode(Variable viewID) {
        final List<Atom> viewConclusion = new ArrayList<Atom>();
        viewConclusion.add(new Atom(queryName, viewID));
        return viewConclusion;
    }

    @Override
    public void visit(final ReturnTemplate template) {
        // NOP (no encoding for the template optionals)
    }

    @Override
    public void visitPre(final ReturnConstructTerm term) {
        // NOP (no encoding before the children are processed)
    }

    @Override
    public void visitPost(final ReturnConstructTerm term) {
        // NOP (no encoding after the children are processed)
    }

    @Override
    public void visit(final ReturnVariableTerm term) {
        if (!copiedVariables.contains(term.getVariable())) {
            copiedVariables.add(term.getVariable());
            builder.add(new Atom(Predicate.COPY.toString() + "_" + queryName, term.toTerm(),
                    variableCopier.getCopy(term.getVariable())));
        }
    }

    @Override
    public void visit(ReturnStringTerm term) {
        // NOP (no encoding for string terms)
    }
}