package hadad.base.compiler.model.nm;

import java.util.List;

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

@Singleton
public class NMExtractVariableToCreatedNodeVisitor implements ReturnTemplateVisitor {
    private ImmutableList.Builder<Atom> builder;
    private Variable viewID;
    private String viewName;

    @Inject
    public NMExtractVariableToCreatedNodeVisitor() {
    }

    public List<Atom> encode(final ReturnTemplate template) {
        builder = ImmutableList.builder();
        template.accept(this);
        return builder.build();
    }

    public void encode(final Variable viewID, final String viewName) {
        this.viewID = viewID;
        this.viewName = viewName;

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

    }

    @Override
    public void visit(final ReturnVariableTerm term) {

    }

    @Override
    public void visit(ReturnStringTerm term) {
        // NOP (no encoding for string terms)
    }
}