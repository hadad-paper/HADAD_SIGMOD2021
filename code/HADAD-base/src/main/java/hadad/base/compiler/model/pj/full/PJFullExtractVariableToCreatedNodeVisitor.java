package hadad.base.compiler.model.pj.full;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.Term;
import hadad.commons.conjunctivequery.Variable;
import hadad.base.compiler.model.sj.DataType;
import hadad.base.compiler.model.sj.Predicate;
import hadad.base.compiler.ReturnConstructTerm;
import hadad.base.compiler.ReturnStringTerm;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.ReturnTemplateVisitor;
import hadad.base.compiler.ReturnVariableTerm;
import hadad.base.compiler.VariableCopier;
import hadad.base.compiler.model.aj.Utils;

/**
 * PJ ExtractVariableToCreatedNodeVisitor
 */
@Singleton
public class PJFullExtractVariableToCreatedNodeVisitor implements ReturnTemplateVisitor {
    private final VariableCopier variableCopier;
    private ImmutableList.Builder<Atom> builder;
    private String queryName;
    private Variable viewID;
    private Set<Variable> copiedVariables;

    @Inject
    public PJFullExtractVariableToCreatedNodeVisitor(final VariableCopier variableCopier) {
        this.variableCopier = variableCopier;
    }

    public List<Atom> encode(final ReturnTemplate template) {
        builder = ImmutableList.builder();
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
    }

    @Override
    public void visitPost(final ReturnConstructTerm term) {
        final Term termVar = (Term) term.getCreatedNode();
        final Term termStr = term.getElement().toTerm();
        final Term termVarRoot = viewID;
        builder.add(new Atom(Predicate.CHILD.toString() + "_" + queryName, termVarRoot, termVar, termStr,
                Utils.toTerm(DataType.OBJECT.toString())));
    }

    @Override
    public void visit(final ReturnVariableTerm term) {

    }

    @Override
    public void visit(ReturnStringTerm term) {
        // NOP (no encoding for string terms)
    }
}