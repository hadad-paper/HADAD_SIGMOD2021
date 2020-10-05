package hadad.base.compiler.model.pj.full.naive;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.Term;
import hadad.commons.conjunctivequery.Variable;
import hadad.base.compiler.ReturnConstructTerm;
import hadad.base.compiler.ReturnStringTerm;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.ReturnTemplateVisitor;
import hadad.base.compiler.ReturnVariableTerm;
import hadad.base.compiler.VariableFactory;
import hadad.base.compiler.model.pj.ArrayElementFactory;
import hadad.base.compiler.model.pj.Predicate;
import hadad.base.compiler.model.pj.Utils;

@Singleton
public final class PJFullBackwardEncoderReturnTermVisitor implements ReturnTemplateVisitor {
    private final ArrayElementFactory arrayElementFactory;
    private final VariableFactory elementVariableFactory;

    private ImmutableList.Builder<Atom> builder;
    private Map<Variable, ImmutableList.Builder<Atom>> auxiliarBuilders;
    private String viewName;
    private Variable viewSetID;
    private Variable parentBlockCreatedNode;
    private Term rootElementCreatedNode;

    @Inject
    public PJFullBackwardEncoderReturnTermVisitor(final ArrayElementFactory arrayElementFactory,
            @Named("ElementVariableFactory") final VariableFactory elementVariableFactory) {
        this.elementVariableFactory = elementVariableFactory;
        this.arrayElementFactory = arrayElementFactory;
    }

    public List<Atom> encode(final Variable parentBlockCreatedNode, final ReturnTemplate template,
            final String viewName) {
        return _encode(parentBlockCreatedNode, template, viewName, null);
    }

    public List<Atom> encode(final ReturnTemplate template, final String viewName, final Variable viewSetID) {
        return _encode(null, template, viewName, viewSetID);
    }

    private List<Atom> _encode(final Variable parentBlockCreatedNode, final ReturnTemplate template,
            final String viewName, final Variable viewSetID) {
        builder = ImmutableList.builder();
        this.auxiliarBuilders = new HashMap<Variable, ImmutableList.Builder<Atom>>();
        this.parentBlockCreatedNode = parentBlockCreatedNode;
        this.viewName = viewName;
        this.viewSetID = viewSetID;
        template.accept(this);
        return builder.build();
    }

    private boolean isRootBlock() {
        return parentBlockCreatedNode == null;
    }

    private boolean isChildBlock() {
        return !isRootBlock();
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
        builder.add(new Atom(Predicate.CHILD.toString() + "_" + viewName, viewSetID, term.getVariable(),
                term.getParent().getElement().toTerm(), Utils.getDataType(term)));
    }

    @Override
    public void visit(final ReturnStringTerm term) {

    }
}