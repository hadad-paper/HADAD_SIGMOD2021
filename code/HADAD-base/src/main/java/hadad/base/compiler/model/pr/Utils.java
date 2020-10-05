package hadad.base.compiler.model.pr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import hadad.commons.conjunctivequery.Atom;
import hadad.base.compiler.Condition;

public class Utils {

	public static Function<Condition, List<Atom>> conditionEncoding = c -> new ArrayList<Atom>(
	        Arrays.asList(new Atom(Predicate.EQUALS.toString(), c.getLeftOp().getTerm(), c.getRightOp().getTerm())));

}
