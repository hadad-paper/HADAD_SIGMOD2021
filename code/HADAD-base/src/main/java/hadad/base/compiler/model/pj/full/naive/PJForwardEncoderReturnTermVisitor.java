package hadad.base.compiler.model.pj.full.naive;

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
import hadad.base.compiler.model.pj.ArrayElementFactory;
import hadad.base.compiler.model.pj.Predicate;
import hadad.base.compiler.model.pj.Utils;

@Singleton
public abstract class PJForwardEncoderReturnTermVisitor implements ReturnTemplateVisitor {
    protected final ArrayElementFactory arrayElementFactory;
    protected ImmutableList.Builder<Atom> builder;
    protected String viewName;
    protected Variable viewID;

    @Inject
    public PJForwardEncoderReturnTermVisitor(final ArrayElementFactory arrayElementFactory) {
        this.arrayElementFactory = arrayElementFactory;

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
        builder.add(new Atom(Predicate.CHILD.toString() + "_" + viewName, viewID, term.getVariable(),
                term.getParent().getElement().toTerm(), Utils.getDataType(term)));
    }

    @Override
    public void visit(final ReturnStringTerm term) {

    }
}