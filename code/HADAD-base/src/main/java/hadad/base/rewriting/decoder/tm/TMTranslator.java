package hadad.base.rewriting.decoder.tm;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.log4j.Logger;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.conjunctivequery.Term;
import hadad.base.compiler.model.tm.Predicate;

/**
 * 
 * This class translates the conjunctive rewriting into DML query syntax
 * 
 *  
 *
 */
public class TMTranslator {

    private static final Logger LOGGER = Logger.getLogger(TMTranslator.class);
    private static final Character LParenthesis = '(';
    private static final Character RParenthesis = ')';
    private final ConjunctiveQuery rewriting;
    private Map<Term, String> varaibleMapping;
    private Map<Term, String> idDecodingMapping;
    private Map<Term, Atom> idAtomMapping;
    private Iterator<Map.Entry<Term, Atom>> iterator;

    /**
     * Constructor
     * 
     * @param query
     *            rewriting conjunctive query
     */
    public TMTranslator(final ConjunctiveQuery rewriting) {
        this.rewriting = rewriting;
        varaibleMapping = new HashMap<>();
        idAtomMapping = new HashMap<>();
        idDecodingMapping = new HashMap<>();
    }

    /**
     * Translate the given rewriting into DML query
     * 
     * @return the translated rewriting
     */
    public String translate() {
        preProcess();
        do {
            for (iterator = idAtomMapping.entrySet().iterator(); iterator.hasNext();) {
                final Map.Entry<Term, Atom> entry = iterator.next();
                switch (entry.getValue().getPredicate()) {
                    case "tr_tm":
                        processTranspose(entry.getValue());
                        break;
                    case "trace_tm":
                        processTrace(entry.getValue());
                        break;
                    case "diag_tm":
                        processDiag(entry.getValue());
                        break;
                    case "add_tm":
                        processAdd(entry.getValue());
                        break;
                    case "multi_tm":
                        processMulti(entry.getValue());
                        break;
                    default:
                        break;
                }
            }

        } while (idAtomMapping.size() != 0);
        final Term head = rewriting.getHead().get(0);
        return rewriting.getName() + "=" + idDecodingMapping.get(head);
    }

    /**
     * Pre-process the rewriting
     */
    private void preProcess() {
        for (final Atom atom : rewriting.getBody()) {
            final String atomPredicte = atom.getPredicate();
            if (atomPredicte.equals(Predicate.NAME.toString())) {
                varaibleMapping.put(atom.getTerm(0), atom.getTerm(1).toString().replace("\"", ""));
            } else {
                if (atom.getTerms().size() == 2) {
                    idAtomMapping.put(atom.getTerm(0), atom);
                }
                if (atom.getTerms().size() == 3) {
                    idAtomMapping.put(atom.getTerm(0), atom);
                    idAtomMapping.put(atom.getTerm(1), atom);
                }
            }
        }
    }

    /**
     * Process transpose operation
     * 
     * @param atom
     *            transpose atom
     */
    private void processTranspose(final Atom atom) {
        final Term term = atom.getTerm(0);
        boolean status = false;
        final StringBuilder decodingTranspsoe = new StringBuilder();
        if (varaibleMapping.containsKey(term)) {
            status = true;
            decodingTranspsoe.append(LParenthesis);
            decodingTranspsoe.append(TMOperation.TRANS);
            decodingTranspsoe.append(LParenthesis);
            decodingTranspsoe.append(varaibleMapping.get(term));
            decodingTranspsoe.append(RParenthesis);
            decodingTranspsoe.append(RParenthesis);
            idDecodingMapping.put(atom.getTerm(1), decodingTranspsoe.toString());
        } else {
            if (idDecodingMapping.containsKey(term)) {
                status = true;

                decodingTranspsoe.append(LParenthesis);
                decodingTranspsoe.append(TMOperation.TRANS);
                decodingTranspsoe.append(LParenthesis);
                decodingTranspsoe.append(idDecodingMapping.get(term));
                decodingTranspsoe.append(RParenthesis);
                decodingTranspsoe.append(RParenthesis);
                idDecodingMapping.put(atom.getTerm(1), decodingTranspsoe.toString());
            }
        }

        if (status) {
            iterator.remove();
        }
    }

    /**
     * Process trace operation
     * 
     * @param atom
     *            trace atom
     */
    private void processTrace(final Atom atom) {
        final Term term = atom.getTerm(0);
        boolean status = false;
        final StringBuilder decodingTranspsoe = new StringBuilder();
        if (varaibleMapping.containsKey(term)) {
            status = true;
            decodingTranspsoe.append(LParenthesis);
            decodingTranspsoe.append(TMOperation.TRACE);
            decodingTranspsoe.append(LParenthesis);
            decodingTranspsoe.append(varaibleMapping.get(term));
            decodingTranspsoe.append(RParenthesis);
            decodingTranspsoe.append(RParenthesis);
            idDecodingMapping.put(atom.getTerm(1), decodingTranspsoe.toString());
        } else {
            if (idDecodingMapping.containsKey(term)) {
                status = true;

                decodingTranspsoe.append(LParenthesis);
                decodingTranspsoe.append(TMOperation.TRACE);
                decodingTranspsoe.append(LParenthesis);
                decodingTranspsoe.append(idDecodingMapping.get(term));
                decodingTranspsoe.append(RParenthesis);
                decodingTranspsoe.append(RParenthesis);
                idDecodingMapping.put(atom.getTerm(1), decodingTranspsoe.toString());
            }
        }

        if (status) {
            iterator.remove();
        }
    }

    /**
     * Process diag operation
     * 
     * @param atom
     *            diag atom
     */
    private void processDiag(final Atom atom) {
        final Term term = atom.getTerm(0);
        boolean status = false;
        final StringBuilder decodingTranspsoe = new StringBuilder();
        if (varaibleMapping.containsKey(term)) {
            status = true;
            decodingTranspsoe.append(LParenthesis);
            decodingTranspsoe.append(TMOperation.DIAG);
            decodingTranspsoe.append(LParenthesis);
            decodingTranspsoe.append(varaibleMapping.get(term));
            decodingTranspsoe.append(RParenthesis);
            decodingTranspsoe.append(RParenthesis);
            idDecodingMapping.put(atom.getTerm(1), decodingTranspsoe.toString());
        } else {
            if (idDecodingMapping.containsKey(term)) {
                status = true;

                decodingTranspsoe.append(LParenthesis);
                decodingTranspsoe.append(TMOperation.DIAG);
                decodingTranspsoe.append(LParenthesis);
                decodingTranspsoe.append(idDecodingMapping.get(term));
                decodingTranspsoe.append(RParenthesis);
                decodingTranspsoe.append(RParenthesis);
                idDecodingMapping.put(atom.getTerm(1), decodingTranspsoe.toString());
            }
        }

        if (status) {
            iterator.remove();
        }
    }

    /**
     * Process add operation
     * 
     * @param atom
     *            add atom
     */
    private void processAdd(final Atom atom) {
        final Term term1 = atom.getTerm(0);
        final Term term2 = atom.getTerm(1);
        boolean status = false;
        final StringBuilder decodingTranspsoe = new StringBuilder();
        if (varaibleMapping.containsKey(term1) && varaibleMapping.containsKey(term2)) {
            status = true;
            decodingTranspsoe.append(LParenthesis);
            decodingTranspsoe.append(TMOperation.ADD);
            decodingTranspsoe.append(LParenthesis);
            decodingTranspsoe.append(varaibleMapping.get(term1));
            decodingTranspsoe.append(",");
            decodingTranspsoe.append(varaibleMapping.get(term2));
            decodingTranspsoe.append(RParenthesis);
            decodingTranspsoe.append(RParenthesis);
            idDecodingMapping.put(atom.getTerm(2), decodingTranspsoe.toString());
        } else {
            if (varaibleMapping.containsKey(term1) && idDecodingMapping.containsKey(term2)) {
                status = true;
                decodingTranspsoe.append(LParenthesis);
                decodingTranspsoe.append(TMOperation.ADD);
                decodingTranspsoe.append(LParenthesis);
                decodingTranspsoe.append(varaibleMapping.get(term1));
                decodingTranspsoe.append(",");
                decodingTranspsoe.append(idDecodingMapping.get(term2));
                decodingTranspsoe.append(RParenthesis);
                decodingTranspsoe.append(RParenthesis);
                idDecodingMapping.put(atom.getTerm(2), decodingTranspsoe.toString());
            } else {
                if (idDecodingMapping.containsKey(term1) && varaibleMapping.containsKey(term2)) {
                    status = true;
                    decodingTranspsoe.append(LParenthesis);
                    decodingTranspsoe.append(TMOperation.ADD);
                    decodingTranspsoe.append(LParenthesis);
                    decodingTranspsoe.append(idDecodingMapping.get(term1));
                    decodingTranspsoe.append(",");
                    decodingTranspsoe.append(varaibleMapping.get(term2));
                    decodingTranspsoe.append(RParenthesis);
                    decodingTranspsoe.append(RParenthesis);
                    idDecodingMapping.put(atom.getTerm(2), decodingTranspsoe.toString());
                } else {
                    if (idDecodingMapping.containsKey(term1) && idDecodingMapping.containsKey(term2)) {
                        status = true;
                        decodingTranspsoe.append(LParenthesis);
                        decodingTranspsoe.append(TMOperation.ADD);
                        decodingTranspsoe.append(LParenthesis);
                        decodingTranspsoe.append(idDecodingMapping.get(term1));
                        decodingTranspsoe.append(",");
                        decodingTranspsoe.append(idDecodingMapping.get(term2));
                        decodingTranspsoe.append(RParenthesis);
                        decodingTranspsoe.append(RParenthesis);
                        idDecodingMapping.put(atom.getTerm(2), decodingTranspsoe.toString());
                    }
                }
            }
        }

        if (status) {
            iterator.remove();
        }
    }

    /**
     * Process add operation
     * 
     * @param atom
     *            add atom
     */
    private void processMulti(final Atom atom) {
        final Term term1 = atom.getTerm(0);
        final Term term2 = atom.getTerm(1);
        boolean status = false;
        final StringBuilder decodingTranspsoe = new StringBuilder();
        if (varaibleMapping.containsKey(term1) && varaibleMapping.containsKey(term2)) {
            status = true;
            decodingTranspsoe.append(LParenthesis);
            decodingTranspsoe.append(TMOperation.ADD);
            decodingTranspsoe.append(LParenthesis);
            decodingTranspsoe.append(varaibleMapping.get(term1));
            decodingTranspsoe.append(",");
            decodingTranspsoe.append(varaibleMapping.get(term2));
            decodingTranspsoe.append(RParenthesis);
            decodingTranspsoe.append(RParenthesis);
            idDecodingMapping.put(atom.getTerm(2), decodingTranspsoe.toString());
        } else {
            if (varaibleMapping.containsKey(term1) && idDecodingMapping.containsKey(term2)) {
                status = true;
                decodingTranspsoe.append(LParenthesis);
                decodingTranspsoe.append(TMOperation.MULTI);
                decodingTranspsoe.append(LParenthesis);
                decodingTranspsoe.append(varaibleMapping.get(term1));
                decodingTranspsoe.append(",");
                decodingTranspsoe.append(idDecodingMapping.get(term2));
                decodingTranspsoe.append(RParenthesis);
                decodingTranspsoe.append(RParenthesis);
                idDecodingMapping.put(atom.getTerm(2), decodingTranspsoe.toString());
            } else {
                if (idDecodingMapping.containsKey(term1) && varaibleMapping.containsKey(term2)) {
                    status = true;
                    decodingTranspsoe.append(LParenthesis);
                    decodingTranspsoe.append(TMOperation.MULTI);
                    decodingTranspsoe.append(LParenthesis);
                    decodingTranspsoe.append(idDecodingMapping.get(term1));
                    decodingTranspsoe.append(",");
                    decodingTranspsoe.append(varaibleMapping.get(term2));
                    decodingTranspsoe.append(RParenthesis);
                    decodingTranspsoe.append(RParenthesis);
                    idDecodingMapping.put(atom.getTerm(2), decodingTranspsoe.toString());
                } else {
                    if (idDecodingMapping.containsKey(term1) && idDecodingMapping.containsKey(term2)) {
                        status = true;
                        decodingTranspsoe.append(LParenthesis);
                        decodingTranspsoe.append(TMOperation.MULTI);
                        decodingTranspsoe.append(LParenthesis);
                        decodingTranspsoe.append(idDecodingMapping.get(term1));
                        decodingTranspsoe.append(",");
                        decodingTranspsoe.append(idDecodingMapping.get(term2));
                        decodingTranspsoe.append(RParenthesis);
                        decodingTranspsoe.append(RParenthesis);
                        idDecodingMapping.put(atom.getTerm(2), decodingTranspsoe.toString());
                    }
                }
            }
        }

        if (status) {
            iterator.remove();
        }
    }

}
