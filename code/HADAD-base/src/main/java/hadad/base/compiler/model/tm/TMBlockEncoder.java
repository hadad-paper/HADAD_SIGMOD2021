package hadad.base.compiler.model.tm;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.conjunctivequery.Variable;
import hadad.base.compiler.Block;
import hadad.base.compiler.BlockEncoder;
import hadad.base.compiler.Condition;

public class TMBlockEncoder implements BlockEncoder {
	private final String encodingHeadVariablePosfix;

	@Inject
	public TMBlockEncoder(
			@Named("fresh_conjunctive_query_head_variable_posfix") final String encodingHeadVariablePosfix) {
		this.encodingHeadVariablePosfix = encodingHeadVariablePosfix;
	}

	@Override
	public ConjunctiveQuery encode(final Block block) {
		final List<Atom> body = new ArrayList<>();
		final List<Variable> head = new ArrayList<Variable>();
		for (final Variable var : block.getPattern().getLocalDefinedVariables()) {
			final Variable newVar = new Variable(var.getName() + encodingHeadVariablePosfix);
			head.add(newVar);
			body.add(new Atom(Predicate.EQUALS.toString(), var, newVar));
		}
		body.addAll(block.getPattern().encoding(conditionEncoder()));
		return new ConjunctiveQuery(block.getId(), head, body);
	}

	public Function<Condition, List<Atom>> conditionEncoder() {
		return Utils.conditionEncoding;
	}
}
