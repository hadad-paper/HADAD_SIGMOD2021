package hadad.base.compiler.model.sppj;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.conjunctivequery.Term;

/**
 * Translate the rewriting to SPPJQL query
 * 
 * 
 *
 */
public class SPPJTranslator {

    /**
     * Some characters and keywords that are used in AQL Surface syntax
     */
    private static final Character DOT = '.';
    private static final String SELECT = " SELECT ";
    private static final String FROM = " FROM ";
    private static final String AS = " AS ";
    private static final String WHERE = " WHERE ";
    private static final String COMMA = ",";
    private ConjunctiveQuery query;

    public SPPJTranslator(final ConjunctiveQuery query) {
        this.query = query;
    }

    /**
     * Translate the given rewriting into PJQL query
     * 
     * @return
     */
    public String translate() {
        final StringBuilder pjqlQuery = new StringBuilder();
        final StringBuilder fromClause = new StringBuilder(trasnlateFromClause());
        final StringBuilder whereClause = new StringBuilder(trasnlateWhereClause());
        final StringBuilder selectClause = new StringBuilder(translateSelectClause());
        pjqlQuery.append(selectClause);
        pjqlQuery.append(fromClause);
        pjqlQuery.append(whereClause);
        return pjqlQuery.toString();
    }

    /**
     * Translate the from clause
     * 
     * @return
     */
    private String trasnlateFromClause() {
        final StringBuilder fromClause = new StringBuilder();
        final Collection<Atom> queryBody = new ArrayList<>(query.getBody());
        for (final Atom atom : queryBody) {
            if (atom.getTerms().size() == 1) {
                fromClause.append(FROM);
                fromClause.append(atom.getPredicate());
                fromClause.append(AS);
                fromClause.append(atom.getTerm(0));
                if (queryBody.size() != 2) {
                    fromClause.append(COMMA);
                }
            }
            if (atom.getTerms().size() > 2 && !(atom.getTerm(3).toString().replace("\"", "").equals("a"))) {
                fromClause.append(atom.getTerm(0).toString() + DOT + atom.getTerm(2).toString().replace("\"", "") + AS
                        + atom.getTerm(1).toString());
                fromClause.append(COMMA);
            }
        }
        if (!fromClause.substring(fromClause.toString().length() - 1).equals(COMMA))
            return fromClause.toString();
        else
            return fromClause.substring(0, fromClause.toString().length() - 1);
    }

    private String trasnlateWhereClause() {
        return "";
    }

    private String translateSelectClause() {
        final StringBuilder selectClause = new StringBuilder();
        final Collection<Atom> queryBody = new ArrayList<>(query.getBody());
        final List<Term> head = new ArrayList<>(query.getHead());
        selectClause.append(SELECT);
        boolean flagNested = false;
        for (final Term term : head) {
            Term temp = null;
            for (final Atom atom : queryBody) {
                if (atom.getPredicate().startsWith("eq")) {
                    if (atom.getTerm(1).toString().equals(term.toString())) {
                        temp = atom.getTerm(0);
                    }
                }
                if (atom.getTerms().size() > 2 && atom.getTerm(3).toString().replace("\"", "").equals("a")) {
                    if (atom.getTerm(1).equals(temp)) {
                        flagNested = true;
                        selectClause.append(atom.getTerm(0));
                        selectClause.append(COMMA);
                    }
                }

            }
            if (!flagNested) {
                selectClause.append(temp);
                flagNested = false;
            }
        }
        if (!selectClause.substring(selectClause.toString().length() - 1).equals(COMMA))
            return selectClause.toString();
        else
            return selectClause.substring(0, selectClause.toString().length() - 1);
    }
}
