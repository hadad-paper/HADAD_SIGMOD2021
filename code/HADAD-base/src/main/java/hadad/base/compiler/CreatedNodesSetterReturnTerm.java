package hadad.base.compiler;

import java.util.List;

import com.google.inject.Singleton;

import hadad.commons.conjunctivequery.Variable;

/**
 * Nodes setter for return term
 *
 */
@Singleton
class CreatedNodesSetterReturnTerm implements ReturnTemplateVisitor {
    private final VariableCopier variableCopier;
    private final VariableFactory elementVariableFactory;

    private List<Variable> createdNodes;

    public CreatedNodesSetterReturnTerm(final VariableCopier variableCopier,
            final VariableFactory elementVariableFactory) {
        this.variableCopier = variableCopier;
        this.elementVariableFactory = elementVariableFactory;
    }

    public void setCreatedNodes(final ReturnTemplate template, final List<Variable> createdNodes) {
        this.createdNodes = createdNodes;
        template.accept(this);
    }

    @Override
    public void visit(ReturnTemplate template) {
        int i = 0;
        for (final ReturnTerm term : template.getTerms()) {
            if (term instanceof ReturnConstructTerm) {
                term.setCreatedNode(createdNodes.get(i++));
            }
        }
    }

    @Override
    public void visitPre(ReturnConstructTerm term) {
        for (final ReturnTerm child : term.getChildren()) {
            if (child instanceof ReturnConstructTerm) {
                child.setCreatedNode(elementVariableFactory.createFreshVar());
            }
        }
    }

    @Override
    public void visitPost(ReturnConstructTerm term) {
        // NOP (no created node to set after the children are processed)
    }

    @Override
    public void visit(ReturnVariableTerm term) {
        term.setCreatedNode(variableCopier.getCopy(term.getVariable()));
    }

    @Override
    public void visit(ReturnStringTerm term) {
        // NOP (leaf term created node is set on the parent or in the
        // return
        // template itself)
    }
}