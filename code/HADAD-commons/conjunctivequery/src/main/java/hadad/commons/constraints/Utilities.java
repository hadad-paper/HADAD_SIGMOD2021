package hadad.commons.constraints;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.ConjunctiveQuery;


/**
 * Static methods for constraints-related operationss
 */
public class Utilities {

	/**
	 * Provides the forward and backward constraints for a list of queries
	 *
	 * @param queries
	 * 			the list of queries
	 *
	 * @return a pair of lista, one for the forward constraints, one for the backward constraints
	 */
	public static Pair<List<Constraint>, List<Constraint>> getFWandBWConstraints(List<ConjunctiveQuery> queries) {
		final List<Constraint> fwlist = new ArrayList<Constraint>();
		final List<Constraint> bwlist = new ArrayList<Constraint>();

		for (final ConjunctiveQuery query:queries) {
			final List<Atom> fwprem = new ArrayList<Atom>();
			for (final Atom atom : query.getBody()) {
				fwprem.add(atom);
			}
			final List<Atom> fwconc = new ArrayList<Atom>();
			fwconc.add(new Atom(query.getName(), query.getHead()));
			fwlist.add(new Tgd(fwprem, fwconc));
			bwlist.add(new Tgd(fwconc, fwprem));
		}

		return new ImmutablePair<List<Constraint>, List<Constraint>>(fwlist, bwlist);
	}
}
