package hadad.base.compiler.model.aj.alternative.secondstep;

import java.util.ArrayList;
import java.util.List;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.base.compiler.model.aj.Predicate;

public class Utils {
	public static ConjunctiveQuery restrict(final ConjunctiveQuery query) {
		final List<Atom> body = new ArrayList<Atom>();

		for (final Atom atom : query.getBody()) {
			if (!atom.getPredicate().startsWith(Predicate.TAG.toString())) {
				body.add(atom);
			}
		}
		return new ConjunctiveQuery(query.getName(), query.getHead(), body);
	}
}
