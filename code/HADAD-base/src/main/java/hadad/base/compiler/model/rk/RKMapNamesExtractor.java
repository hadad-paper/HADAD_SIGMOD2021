package hadad.base.compiler.model.rk;

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

@Singleton
public class RKMapNamesExtractor implements QueryBlockTreeVisitor {
	private final String mapNamePrefix;
	private Set<String> mapNames;

	@Inject
	public RKMapNamesExtractor(@Named("document_name_prefix") final String documentNamePrefix) {
		this.mapNamePrefix = documentNamePrefix;
	}

	public Set<String> getDocumentNames(final QueryBlockTree nbt) {
		mapNames = new HashSet<String>();
		nbt.accept(this);
		return mapNames;
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
				.filter(a -> a.getPredicate().startsWith(Predicate.MAINMAP.toString()))
				.map(a -> a.getPredicate().substring(a.getPredicate().lastIndexOf(mapNamePrefix) + 1))
				.forEach(mapNames::add);
	}
}
