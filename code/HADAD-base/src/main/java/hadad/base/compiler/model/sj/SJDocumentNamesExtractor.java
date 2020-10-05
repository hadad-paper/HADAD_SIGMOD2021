package hadad.base.compiler.model.sj;

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
 * Document Names Extractor
 * 
 *  
 *
 */
@Singleton
public class SJDocumentNamesExtractor implements QueryBlockTreeVisitor {
    private final String documentNamePrefix;
    private Set<String> documentNames;

    @Inject
    public SJDocumentNamesExtractor(@Named("document_name_prefix") final String documentNamePrefix) {
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
