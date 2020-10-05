package hadad.base.compiler.model.sj;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.conjunctivequery.Term;

/**
 * Translate CQ query into Solr query
 * 
 *  
 *
 */
public class SolrTranslator {

    private static final Character COLON = ':';
    private static final String QUERY = "QUERY";
    private static final String TOKEN = "?q=";
    private static final String FL = "&fl=";
    private static final String COMMA = ",";
    private ConjunctiveQuery query;
    private StringBuilder collectionName = new StringBuilder();
    private StringBuilder textSearchPredicate = new StringBuilder();
    private StringBuilder projectFields = new StringBuilder();

    public SolrTranslator(final ConjunctiveQuery query) {
        this.query = query;
    }

    /**
     * Translate CQ rewriting into Solr query.
     * 
     * @return the translated rewriting
     */
    public String translate() {
        final StringBuilder solrQuery = new StringBuilder();
        trasnlateCollectionName();
        trasnlateTextSearchPredicate();
        trasnlateProjectFields();
        solrQuery.append(collectionName);
        solrQuery.append(textSearchPredicate);
        solrQuery.append(projectFields);
        return solrQuery.toString();
    }

    /**
     * Translate the collection path
     */
    private void trasnlateCollectionName() {
        final Collection<Atom> body = new ArrayList<Atom>(query.getBody());
        for (final Atom atom : body) {
            if (atom.getTerms().size() == 1) {
                collectionName.append(atom.getPredicate() + "/" + QUERY + TOKEN);
                break;
            }
        }

    }

    /**
     * Translate the text search predicate
     */
    private void trasnlateTextSearchPredicate() {
        final Collection<Atom> body = new ArrayList<Atom>(query.getBody());
        final StringBuilder predicate = new StringBuilder();
        final StringBuilder fieldName = new StringBuilder();
        Term term = null;
        boolean valPredicate = false;
        for (final Atom atom : body) {
            if (atom.getPredicate().equals(Predicate.VAL.toString())) {
                term = atom.getTerm(0);
                predicate.append(atom.getTerm(1).toString());
                valPredicate = true;
                continue;
            }
            if (atom.getTerms().contains(term)) {
                fieldName.append(atom.getTerm(2).toString().replace("\"", ""));
                break;
            }
        }
        textSearchPredicate.append(fieldName.toString());
        if (valPredicate)
            textSearchPredicate.append(COLON);
        textSearchPredicate.append(predicate.toString());

    }

    /**
     * Translate the projected fields
     */
    private void trasnlateProjectFields() {
        final Collection<Atom> body = new ArrayList<Atom>(query.getBody());
        final List<Term> head = new ArrayList<Term>(query.getHead());
        final List<String> projectedFields = new ArrayList<String>();
        for (Atom atom : body) {
            if (!(atom.getTerms().size() == 1) && !(atom.getPredicate().equals(Predicate.VAL.toString()))) {
                final Term term = atom.getTerm(1);
                if (head.contains(term)) {
                    projectedFields.add(atom.getTerm(2).toString().replace("\"", ""));
                }
            }
        }
        projectFields.append(FL);
        for (int i = 0; i < projectedFields.size(); i++) {
            if (i == (projectedFields.size() - 1)) {
                projectFields.append(projectedFields.get(i));
            } else {
                projectFields.append(projectedFields.get(i));
                projectFields.append(COMMA);
            }
        }

    }

}
