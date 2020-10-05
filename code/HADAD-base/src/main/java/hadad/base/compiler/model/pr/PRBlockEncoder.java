package hadad.base.compiler.model.pr;

import java.util.List;
import java.util.function.Function;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.base.compiler.Block;
import hadad.base.compiler.BlockEncoder;
import hadad.base.compiler.Condition;

public class PRBlockEncoder implements BlockEncoder {

	@Override
	public ConjunctiveQuery encode(final Block block) {
		return new ConjunctiveQuery(block.getId(), block.getPattern()
				.getLocalDefinedVariables(), block.getPattern().encoding(conditionEncoder()));
	}
	public Function<Condition, List<Atom>> conditionEncoder() {
		return Utils.conditionEncoding;
	}
}
