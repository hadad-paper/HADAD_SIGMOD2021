package hadad.base.compiler.model.sj;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.Term;
import hadad.commons.conjunctivequery.Variable;
import hadad.base.compiler.Element;
import hadad.base.compiler.ReturnConstructTerm;
import hadad.base.compiler.ReturnStringTerm;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.ReturnTemplateVisitor;
import hadad.base.compiler.ReturnVariableTerm;
import hadad.base.compiler.model.aj.Utils;

@Singleton
public class SJExtractVariableToCreatedNodeVisitor implements ReturnTemplateVisitor {
    private ImmutableList.Builder<Atom> builder;
    private Variable viewID;
    private String viewName;

    @Inject
    public SJExtractVariableToCreatedNodeVisitor() {
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
        if (term.getParent() != null) {
            final Element termElement = term.getParent().getElement();
            if (!termElement.isEmpty()) {
                final Term termVar = termElement.toTerm();
                final Term termStr = term.getElement().toTerm();
                final Term termVarRoot = viewID;
                builder.add(new Atom(Predicate.CHILD.toString() + "_" + viewName, termVarRoot, termVar, termStr,
                        Utils.toTerm(DataType.OBJECT.toString())));
            }
        }
    }

    @Override
    public void visit(final ReturnVariableTerm term) {
        builder.add(new Atom(Predicate.CHILD.toString() + "_" + viewName, viewID, term.getVariable(),
                term.getParent().getElement().toTerm(), Utils.getDataType(term)));
    }

    @Override
    public void visit(ReturnStringTerm term) {
        // NOP (no encoding for string terms)
    }
}