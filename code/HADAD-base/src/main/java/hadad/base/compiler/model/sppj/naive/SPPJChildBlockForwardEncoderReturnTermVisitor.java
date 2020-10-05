package hadad.base.compiler.model.sppj.naive;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.Variable;
import hadad.base.compiler.Element;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.ReturnTerm;
import hadad.base.compiler.StringElement;
import hadad.base.compiler.model.sppj.ArrayElementFactory;

@Singleton
public class SPPJChildBlockForwardEncoderReturnTermVisitor extends SPPJBaseForwardEncoderReturnTermVisitor {
    private Variable parentBlockCreatedNode;

    @Inject
    public SPPJChildBlockForwardEncoderReturnTermVisitor(final ArrayElementFactory arrayElementFactory) {
        super(arrayElementFactory);
    }

    public List<Atom> encode(final Variable parentBlockCreatedNode, final ReturnTemplate template,
            final String viewName) {
        builder = ImmutableList.builder();
        this.parentBlockCreatedNode = parentBlockCreatedNode;
        this.viewName = viewName;
        template.accept(this);
        return builder.build();
    }

    @Override
    protected Element getParentBlockElement(final ReturnTerm term) {
        if (term.hasParent()) {
            if (!term.getParent().getElement().isEmpty()) {
                return term.getParent().getElement();
            } else {
                if (term.getParent().hasParent() && !term.getParent().getParent().getElement().isEmpty()) {
                    return term.getParent().getParent().getElement();
                }
            }
        }
        return new StringElement("");
    }

    @Override
    protected Variable getParentBlockCreatedNode(final ReturnTerm term) {
        if (term.hasParent()) {
            if (!term.getParent().getElement().isEmpty()) {
                return term.getParent().getCreatedNode();
            } else {
                if (term.getParent().hasParent() && !term.getParent().getParent().getElement().isEmpty()) {
                    return term.getParent().getParent().getCreatedNode();
                }
            }
        }
        return parentBlockCreatedNode;
    }
}