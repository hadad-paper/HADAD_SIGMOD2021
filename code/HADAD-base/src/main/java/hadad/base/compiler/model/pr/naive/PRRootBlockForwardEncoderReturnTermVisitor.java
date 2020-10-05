package hadad.base.compiler.model.pr.naive;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import hadad.commons.conjunctivequery.Atom;
import hadad.base.compiler.ReturnConstructTerm;
import hadad.base.compiler.ReturnStringTerm;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.ReturnVariableTerm;
import hadad.base.compiler.VariableFactory;
import hadad.base.compiler.model.pj.ArrayElementFactory;

@Singleton
public class PRRootBlockForwardEncoderReturnTermVisitor extends PRForwardEncoderReturnTermVisitor {
    private final VariableFactory elementVariableFactory;

    @Inject
    public PRRootBlockForwardEncoderReturnTermVisitor(final ArrayElementFactory arrayElementFactory,
            @Named("ElementVariableFactory") final VariableFactory elementVariableFactory) {
        super(arrayElementFactory);
        this.elementVariableFactory = elementVariableFactory;
    }

    public List<Atom> encode(final ReturnTemplate template, final String viewName) {
        builder = ImmutableList.builder();
        this.viewName = viewName;
        template.accept(this);
        builder.add(new Atom(viewName, terms));
        return builder.build();
    }

    @Override
    public void visitPre(final ReturnConstructTerm term) {

    }

    @Override
    public void visit(final ReturnVariableTerm term) {
        super.visit(term);
    }

    @Override
    public void visit(final ReturnStringTerm term) {

    }
}