package hadad.base.compiler.model.pj;

import java.util.HashSet;
import java.util.Set;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import hadad.base.compiler.Block;
import hadad.base.compiler.ChildBlock;
import hadad.base.compiler.QueryBlockTree;
import hadad.base.compiler.QueryBlockTreeVisitor;
import hadad.base.compiler.RootBlock;

/**
 * PJ DocumentNamesExtractor which extends {@link QueryBlockTreeVisitor}
 *
 */
@Singleton
public class PJDocumentNamesExtractor implements QueryBlockTreeVisitor {
    private final String documentNamePrefix;
    private Set<String> documentNames;

    @Inject
    public PJDocumentNamesExtractor(@Named("document_name_prefix") final String documentNamePrefix) {
        this.documentNamePrefix = documentNamePrefix;
    }

    public Set<String> getDocumentNames(final QueryBlockTree nbt) {
        documentNames = new HashSet<String>();
        nbt.accept(this);
        return documentNames;
    }

    @Override
    public void visit(final QueryBlockTree tree) {
        // NOP
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
        block.getPattern().encoding(Utils.conditionEncoding).stream()
                .filter(a -> a.getPredicate().startsWith(Predicate.ROOT.toString()))
                .map(a -> a.getPredicate().substring(a.getPredicate().indexOf(documentNamePrefix) + 1))
                .forEach(documentNames::add);
    }
}
