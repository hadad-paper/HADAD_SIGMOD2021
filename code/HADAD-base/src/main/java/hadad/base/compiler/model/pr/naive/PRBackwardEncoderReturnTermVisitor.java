package hadad.base.compiler.model.pr.naive;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.Term;
import hadad.base.compiler.ReturnConstructTerm;
import hadad.base.compiler.ReturnStringTerm;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.ReturnTemplateVisitor;
import hadad.base.compiler.ReturnVariableTerm;
import hadad.base.compiler.VariableFactory;
import hadad.base.compiler.model.pj.ArrayElementFactory;

@Singleton
public final class PRBackwardEncoderReturnTermVisitor implements ReturnTemplateVisitor {
    private final ArrayElementFactory arrayElementFactory;
    private final VariableFactory elementVariableFactory;
    private List<Term> terms;
    private ImmutableList.Builder<Atom> builder;
    private String viewName;

    @Inject
    public PRBackwardEncoderReturnTermVisitor(final ArrayElementFactory arrayElementFactory,
            @Named("ElementVariableFactory") final VariableFactory elementVariableFactory) {
        this.elementVariableFactory = elementVariableFactory;
        this.arrayElementFactory = arrayElementFactory;

    }

    public List<Atom> encode(final ReturnTemplate template, final String viewName) {
        builder = ImmutableList.builder();
        terms = new ArrayList<Term>();
        this.viewName = viewName;
        template.accept(this);
        builder.add(new Atom(viewName, terms));
        return builder.build();
    }

    @Override
    public void visit(final ReturnTemplate template) {
        // NOP (no encoding for the template optionals)
    }

    @Override
    public void visitPost(final ReturnConstructTerm term) {
        // NOP (no encoding after the children are processed)
    }

    @Override
    public void visitPre(final ReturnConstructTerm term) {

    }

    @Override
    public void visit(final ReturnVariableTerm term) {
        if (!terms.contains(term.getVariable()))
            terms.add(term.getVariable());
    }

    @Override
    public void visit(final ReturnStringTerm term) {

    }
}