package hadad.base.compiler.model.pr.naive;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.Term;
import hadad.base.compiler.ReturnConstructTerm;
import hadad.base.compiler.ReturnStringTerm;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.ReturnTemplateVisitor;
import hadad.base.compiler.ReturnVariableTerm;
import hadad.base.compiler.model.pj.ArrayElementFactory;

@Singleton
public abstract class PRForwardEncoderReturnTermVisitor implements ReturnTemplateVisitor {
    protected final ArrayElementFactory arrayElementFactory;
    protected ImmutableList.Builder<Atom> builder;
    protected String viewName;
    protected List<Term> terms;

    @Inject
    public PRForwardEncoderReturnTermVisitor(final ArrayElementFactory arrayElementFactory) {
        this.arrayElementFactory = arrayElementFactory;
        terms = new ArrayList<Term>();

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