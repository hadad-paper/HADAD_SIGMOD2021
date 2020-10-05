package hadad.base.rewriting.decoder.aj;

import java.util.Collection;
import java.util.Iterator;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.conjunctivequery.Term;
import hadad.base.compiler.exceptions.QueryTranslationException;

/**
 * AQL Translator. It translates a given AJ model conjunctive query into AQL syntax
 * 
 *  
 *
 */
public class AJTranslator {

    /**
     * Some characters and keywords that are used in AQL Surface syntax
     */
    private static final Character COLON = ':';
    private static final Character SPACE = ' ';
    private static final Character DOT = '.';
    private static final Character EQUAL = '=';
    private static final Character LParenthesis = '(';
    private static final Character RParenthesis = ')';
    private static final String RETURN = " RETURN ";
    private static final String FOR = " FOR ";
    private static final String IN = " IN ";
    private static final String DATASET = " DATASET ";
    private static final String WHERE = " WHERE ";
    private static final String COMMA = " , ";

    private StringBuilder constructedRecord = new StringBuilder();
    private BiMap<String, String> headVariables = HashBiMap.create();
    private BiMap<String, String> conditionVariables = HashBiMap.create();

    /**
     * Returns AQL surface syntax query
     * 
     * @param query
     *            given AQL conjunctive query representation
     * @return Corresponding AQL Surface syntax
     * @throws QueryTranslationException
     */
    public String translate(ConjunctiveQuery cq) throws QueryTranslationException {
        Collection<Atom> body = cq.getBody();
        StringBuilder aqlquery = new StringBuilder();
        constructedFields(cq);
        aqlquery.append(generateForClause(body));
        aqlquery.append(generateReturnClause(body));

        return aqlquery.toString();
    }

    /**
     * Returns the corresponding ReturnClause for a given CQ
     * 
     * @param head
     *            the head of the AQL conjunctive query representation
     * @return returnClause the corresponding Return Clause for a given CQ
     * 
     * @throws QueryTranslationException
     */
    protected String generateReturnClause(Collection<Atom> body) throws QueryTranslationException {
        StringBuilder returnCaluse = new StringBuilder();
        boolean first = true;
        for (Iterator<Atom> i = body.iterator(); i.hasNext();) {
            Atom atom = i.next();
            if (atom.toString().startsWith("val") || atom.toString().startsWith("eq") || atom.getTerms().size() == 1) {
                continue;
            } else {
                if (headVariables.containsValue(atom.getTerm(1).toString())) {
                    if (!first)
                        constructedRecord.append(COMMA);
                    first = false;
                    constructedRecord.append(atom.getTerm(2));
                    constructedRecord.append(COLON);
                    constructedRecord.append(LParenthesis);
                    constructedRecord.append(FOR);
                    constructedRecord.append(SPACE);
                    constructedRecord.append(atom.getTerm(1));
                    constructedRecord.append(IN);
                    constructedRecord.append(atom.getTerm(0));
                    constructedRecord.append(DOT);
                    constructedRecord.append(atom.getTerm(2).toString().replaceAll("\"", ""));
                    constructedRecord.append(SPACE);
                    constructedRecord.append(RETURN);
                    constructedRecord.append(atom.getTerm(1));
                    constructedRecord.append(RParenthesis);
                }
            }
        }
        return returnCaluse.append(RETURN + "{" + constructedRecord + "}").toString();
    }

    /**
     * Tags the fields that need to be constructed
     * 
     * @param body
     *            CQ body
     * @throws QueryTranslationException
     */
    protected void constructedFields(ConjunctiveQuery cq) throws QueryTranslationException {
        boolean valAtom = false;
        final Collection<Atom> body = cq.getBody();
        final Collection<Term> head = cq.getHead();
        for (Iterator<Atom> i = body.iterator(); i.hasNext();) {
            Atom currentAtom = i.next();
            if (currentAtom.getPredicate().startsWith("eq") && !(currentAtom.getTerm(1).isConstant())) {
                if (!valAtom)
                    headVariables.put(currentAtom.getTerm(1).toString(), currentAtom.getTerm(0).toString());
                else
                    headVariables.put(headVariables.inverse().get(currentAtom.getTerm(0).toString()),
                            currentAtom.getTerm(1).toString());
            }
            if (currentAtom.getPredicate().startsWith("val")) {
                valAtom = true;
                headVariables.put(currentAtom.getTerm(1).toString(), currentAtom.getTerm(0).toString());
            }
            if (currentAtom.getTerms().size() > 2 && head.contains(currentAtom.getTerm(1))) {
                headVariables.put(currentAtom.getTerm(1).toString(), currentAtom.getTerm(1).toString());
            }
            if (currentAtom.getPredicate().startsWith("eq") && currentAtom.getTerm(1).isConstant()) {
                conditionVariables.put(currentAtom.getTerm(0).toString(), currentAtom.getTerm(1).toString());
            }
        }
    }

    /**
     * Returns the corresponding forClause for a given CQ
     * 
     * @param body
     *            CQ body
     * @return forCaluse the corresponding for Clause for a given CQ
     * 
     * @throws QueryTranslationException
     */
    protected String generateForClause(Collection<Atom> body) throws QueryTranslationException {
        StringBuilder forClause = new StringBuilder();
        StringBuilder forVariableBinding = new StringBuilder();
        boolean first = true;
        for (Iterator<Atom> i = body.iterator(); i.hasNext();) {
            Atom atom = i.next();
            if (atom.toString().startsWith("eq") || atom.toString().startsWith("val")) {
                continue;
            } else {
                if ((atom.getTerms().size() == 1)) {
                    forVariableBinding.append(atom.getTerm(0));
                    forVariableBinding.append(IN);
                    forVariableBinding.append(DATASET);
                    forVariableBinding.append(atom.getPredicate());
                } else {
                    if (!headVariables.containsValue(atom.getTerm(1).toString())
                            && !conditionVariables.containsKey(atom.getTerm(1).toString())) {
                        if (!first)
                            forVariableBinding.append(COMMA);
                        first = false;
                        forVariableBinding.append(atom.getTerm(1));
                        forVariableBinding.append(IN);
                        forVariableBinding.append(atom.getTerm(0));
                        forVariableBinding.append(DOT);
                        forVariableBinding.append(atom.getTerm(2));
                        forVariableBinding.append(SPACE);

                    } else {
                        if (conditionVariables.containsKey(atom.getTerm(1).toString())) {
                            forVariableBinding.append(WHERE);
                            forVariableBinding.append(atom.getTerm(0));
                            forVariableBinding.append(DOT);
                            forVariableBinding.append(atom.getTerm(2));
                            forVariableBinding.append(EQUAL);
                            forVariableBinding.append(conditionVariables.get(atom.getTerm(1).toString()));
                        }
                    }
                }
            }
        }
        return forClause.append(FOR + forVariableBinding).toString();
    }
}
