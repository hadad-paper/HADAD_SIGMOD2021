package hadad.base.compiler.model.rk;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.conjunctivequery.Term;
import hadad.base.compiler.exceptions.QueryTranslationException;

/**
 * For a given KQL conjunctive query, this class is responsible
 * for generating an equivalent KQL Surface syntax
 * 
 * 
 *
 */
public class KQLTranslator {

    /**
     * Some characters and keywords that are used KQL Surface syntax
     */
    public static final Character SPACE = ' ';
    public static final Character RBRACKET = '[';
    public static final Character LBRACKET = ']';
    public static final Character COMMA = ',';
    public static final String SELECT = "SELECT ";
    public static final String FROM = "FROM ";
    public static final String IN = "IN ";
    public static final String MAIN = "MAP";
    public static final String KEYS = "KEYS";
    private final Map<Term, Term> headVariables = new HashMap<Term, Term>();
    private final Deque<Atom> atomsRerodered = new ArrayDeque<Atom>();
    private final Set<Term> bindingVar = new HashSet<Term>();

    /**
     * @param query
     *            given KQL conjunctive query representation
     * @return Corresponding KQL Surface syntax
     * @throws QueryTranslationException
     */
    public String translate(ConjunctiveQuery query) throws QueryTranslationException {
        List<Term> head = query.getHead();
        StringBuilder kqlquery = new StringBuilder();
        String fromClause = generateFromClause(query);
        kqlquery.append(generateSelectClause(head));
        kqlquery.append(fromClause);
        return kqlquery.toString();
    }

    /**
     * @param head
     *            the head of the KQL conjunctive query representation
     * @return selectCaluse the corresponding Select Clause for a given head in
     *         CQ
     * 
     * @throws QueryTranslationException
     */
    protected String generateSelectClause(List<Term> head) throws QueryTranslationException {
        StringBuilder selectCaluse = new StringBuilder(SELECT);
        boolean first = true;
        if (head.isEmpty()) {
            throw new QueryTranslationException("KQL CQ muust have a head variable");
        }
        for (int i = head.size() - 1; i >= 0; i--) {
            Term variableHead = head.get(i);
            if (headVariables.containsKey(variableHead) || bindingVar.contains(variableHead)) {
                if (!first)
                    selectCaluse.append(",");
                first = false;
                selectCaluse.append(headVariables.get(variableHead));

            }

        }
        selectCaluse.append(SPACE);
        return selectCaluse.toString();
    }

    /**
     * @param body
     *            the body of the KQL conjunctive query representation
     * @return fromCaluse the corresponding from Clause for a given body in CQ
     * 
     * @throws QueryTranslationException
     */
    protected String generateFromClause(ConjunctiveQuery cq) throws QueryTranslationException {
        StringBuilder fromClause = new StringBuilder();
        fromClause.append(FROM);
        reOrderingAtoms(cq);

        for (Iterator<Atom> stackIterator = atomsRerodered.iterator(); stackIterator.hasNext();) {
            Atom peak = stackIterator.next();
            Term type = peak.getTerm(3);
            switch (type.toString().replaceAll("\"", "")) {
                case "m":
                    if (bindingVar.contains(peak.getTerm(2))) {
                        fromClause.append(peak.getTerm(0));
                        fromClause.append(SPACE);
                        fromClause.append(IN);
                        fromClause.append(KEYS);
                        fromClause.append(RBRACKET);
                        fromClause.append(MAIN);
                        fromClause.append(LBRACKET);
                        fromClause.append(COMMA);
                        fromClause.append(SPACE);
                        fromClause.append(peak.getTerm(1));
                        fromClause.append(SPACE);
                        fromClause.append(IN);
                        fromClause.append(SPACE);
                        fromClause.append(MAIN);
                        fromClause.append(RBRACKET);
                        fromClause.append(peak.getTerm(0));
                        fromClause.append(LBRACKET);
                        fromClause.append(COMMA);
                    } else {
                        Term mainMapVar = peak.getTerm(1);
                        Term mainMapKey = peak.getTerm(2);
                        fromClause.append(SPACE);
                        fromClause.append(mainMapVar.toString());
                        fromClause.append(SPACE);
                        fromClause.append(IN);
                        fromClause.append(MAIN);
                        fromClause.append(RBRACKET);
                        fromClause.append(mainMapKey.toString());
                        fromClause.append(LBRACKET);
                        fromClause.append(stackIterator.hasNext() ? COMMA : SPACE);
                    }
                    break;
                case "im":
                    Term internalMapVar = peak.getTerm(0);
                    Term internalMapBindVar = peak.getTerm(1);
                    Term internalMapKey = peak.getTerm(2);
                    fromClause.append(internalMapBindVar.toString());
                    fromClause.append(SPACE);
                    fromClause.append(IN);
                    fromClause.append(internalMapVar.toString());
                    fromClause.append(RBRACKET);
                    fromClause.append(internalMapKey.toString().replaceAll("\"", "'"));
                    fromClause.append(LBRACKET);
                    fromClause.append(stackIterator.hasNext() ? COMMA : SPACE);
                    break;
            }
        }
        return fromClause.toString();
    }

    /**
     * 
     * Re-order the atoms
     * 
     * @param body
     *            the body of the KQL conjunctive query representation
     */
    private void reOrderingAtoms(ConjunctiveQuery cq) {
        Atom mainMap = null;
        for (Iterator<Atom> i = cq.getBody().iterator(); i.hasNext();) {
            Atom currentAtom = i.next();
            if (currentAtom.getPredicate().startsWith("eq"))
                headVariables.put(currentAtom.getTerm(1), currentAtom.getTerm(0));
            if (currentAtom.getTerms().size() > 2 && cq.getHead().contains(currentAtom.getTerm(1))) {
                headVariables.put(currentAtom.getTerm(1), currentAtom.getTerm(1));
            }
            if (currentAtom.getPredicate().startsWith("eq") || currentAtom.getTerms().size() == 1
                    || currentAtom.getTerm(2).toString().startsWith("\"s\"")) {
                continue;
            } else {
                Term type = currentAtom.getTerm(3);

                switch (type.toString().replaceAll("\"", "")) {
                    case "m":
                        mainMap = currentAtom;
                        break;
                    case "im":
                        bindingVar.add(currentAtom.getTerm(1));
                        atomsRerodered.push(currentAtom);
                        break;
                }
            }
        }
        atomsRerodered.push(mainMap);
    }
}
