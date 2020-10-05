package hadad.base.compiler;

import java.util.stream.Collectors;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

/**
 * Node setter query block tree
 *
 */
@Singleton
public class CreatedNodesSetteQueryBlockTree implements QueryBlockTreeVisitor {
    private final CreatedNodesSetterReturnTerm createdNodesSetterVisitor;
    private final VariableFactory elementVariableFactory;

    @Inject
    public CreatedNodesSetteQueryBlockTree(final VariableCopier variableCopier,
            @Named("ElementVariableFactory") final VariableFactory elementVariableFactory) {
        this.elementVariableFactory = elementVariableFactory;
        createdNodesSetterVisitor = new CreatedNodesSetterReturnTerm(variableCopier, elementVariableFactory);
    }

    public void setCreatedNodes(final QueryBlockTree nbt) {
        elementVariableFactory.reset();
        nbt.accept(this);
    }

    @Override
    public void visit(final QueryBlockTree tree) {
        // NOP (no created nodes on the tree)
    }

    @Override
    public void visit(final RootBlock block) {
        _visit(block);
    }

    @Override
    public void visit(final ChildBlock block) {
        _visit(block);
    }

    private void _visit(final Block block) {
        createdNodesSetterVisitor.setCreatedNodes(block.getReturnTemplate(),
                block.getReturnTemplate().getTerms().stream().filter(t -> t instanceof ReturnConstructTerm)
                        .map(t -> elementVariableFactory.createFreshVar()).collect(Collectors.toList()));
    }
}