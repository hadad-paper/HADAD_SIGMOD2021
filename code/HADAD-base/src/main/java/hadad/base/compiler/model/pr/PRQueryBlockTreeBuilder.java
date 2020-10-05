package hadad.base.compiler.model.pr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableMap;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.conjunctivequery.Constant;
import hadad.commons.conjunctivequery.Term;
import hadad.commons.conjunctivequery.Variable;
import hadad.commons.miscellaneous.Tuple;
import hadad.base.compiler.Condition;
import hadad.base.compiler.Conditional;
import hadad.base.compiler.PathExpression;
import hadad.base.compiler.Pattern;
import hadad.base.compiler.QueryBlockTree;
import hadad.base.compiler.QueryBlockTreeBuilder;
import hadad.base.compiler.ReturnStringTerm;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.ReturnTerm;
import hadad.base.compiler.ReturnVariableTerm;
import hadad.base.compiler.RootBlock;
import hadad.base.compiler.Structural;
import hadad.base.compiler.Utils;
import hadad.base.compiler.exceptions.ParseException;

/**
 * PR QueryBlockTreeBuilder which implements {@link QueryBlockTreeBuilder}.
 * 
 *   
 */
public final class PRQueryBlockTreeBuilder implements QueryBlockTreeBuilder {
    @Override
    public PathExpression buildPathExpression(final String str) throws ParseException {
        return buildPathExpression(parseQuery(str));
    }

    private PathExpression buildPathExpression(final ConjunctiveQuery query) throws IllegalArgumentException {
        if (query.getHead().size() != 1 || !(query.getHead().get(0) instanceof Variable)) {
            throw new IllegalArgumentException("Single variable head CQ expected.");
        }
        return new PathExpression(PRModel.ID, new HashSet<Variable>(), new ArrayList<Atom>(query.getBody()),
                (Variable) query.getHead().get(0));
    }

    private Pattern buildPattern(final ConjunctiveQuery query) throws IllegalArgumentException {
        final Map<Variable, Tuple<List<Atom>, Set<Variable>>> auxiliar =
                new LinkedHashMap<Variable, Tuple<List<Atom>, Set<Variable>>>();
        for (final Term term : query.getHead()) {
            if (term instanceof Variable) {
                final Set<Variable> variables = new HashSet<Variable>();
                variables.add((Variable) term);
                auxiliar.put((Variable) term, new Tuple<List<Atom>, Set<Variable>>(new ArrayList<Atom>(), variables));
            }
        }
        final List<Atom> check = new ArrayList<Atom>(query.getBody());
        boolean changed = true;
        while (changed) {
            changed = false;
            for (final Variable var : auxiliar.keySet()) {
                for (final Atom atom : query.getBody()) {
                    if (!auxiliar.get(var).first().contains(atom)
                            && (containsAny(atom.getVariables(), auxiliar.get(var).second()))) {
                        auxiliar.get(var).first().add(atom);
                        auxiliar.get(var).second().addAll(atom.getVariables());
                        changed = true;
                        check.remove(atom);
                    }
                }
            }
        }
        if (!check.isEmpty()) {
            throw new IllegalArgumentException("All atoms are expected to be connected to the head variables.");
        }

        final List<Tuple<Variable, PathExpression>> definitions = new ArrayList<Tuple<Variable, PathExpression>>();
        for (final Entry<Variable, Tuple<List<Atom>, Set<Variable>>> entry : auxiliar.entrySet()) {
            definitions.add(new Tuple<Variable, PathExpression>(entry.getKey(),
                    new PathExpression(PRModel.ID, new HashSet<Variable>(), entry.getValue().first(), entry.getKey())));
        }
        return new Pattern(new Structural(definitions, null),
                new Conditional(new ArrayList<Condition>(), new ArrayList<PathExpression>(), new ArrayList<String>()));
    }

    private static boolean containsAny(final Collection<Variable> c1, final Collection<Variable> c2) {
        for (final Variable e : c2) {
            if (c1.contains(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ReturnTemplate buildReturnTemplate(ImmutableMap<Variable, PathExpression> definitions, final String str)
            throws ParseException {
        final ConjunctiveQuery query = parseQuery(str);
        final List<ReturnTerm> terms = query.getHead().stream().map(t -> toTerm(t)).collect(Collectors.toList());
        return new ReturnTemplate(PRModel.ID, terms);
    }

    @Override
    public QueryBlockTree buildQueryBlockTree(final String str) throws ParseException {
        final ConjunctiveQuery query = parseQuery(str);
        return new QueryBlockTree(new RootBlock(query.getName(), buildPattern(query), buildReturnTemplate(null, str)));
    }

    private ConjunctiveQuery parseQuery(final String str) throws ParseException {
        try {
            return Utils.parseQuery(str);
        } catch (IllegalArgumentException | hadad.commons.conjunctivequery.parser.ParseException e) {
            throw new ParseException(e);
        }
    }

    private ReturnTerm toTerm(final Term term) throws ParseException {
        if (term instanceof Constant) {
            return new ReturnStringTerm(((Constant) term).getValue().toString());
        } else if (term instanceof Variable) {
            return new ReturnVariableTerm((Variable) term, new HashMap<String, String>());
        } else {
            throw new ParseException(new IllegalArgumentException("Unsupported term type."));
        }
    }

    @Override
    public Pattern buildPattern(String str) throws ParseException {
        // TODO Auto-generated method stub
        return null;
    }
}
