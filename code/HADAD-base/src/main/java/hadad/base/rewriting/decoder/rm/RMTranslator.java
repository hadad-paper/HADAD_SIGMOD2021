package hadad.base.rewriting.decoder.rm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.conjunctivequery.Term;
import hadad.base.compiler.model.la.metadata.Metadata;
import hadad.base.compiler.model.sm.Predicate;

/**
 * 
 * This class translates the conjunctive rewriting into DML query syntax
 * 
 *
 */
public class RMTranslator {

	private static final Logger LOGGER = Logger.getLogger(RMTranslator.class);
	private static final Character LParenthesis = '(';
	private static final Character RParenthesis = ')';
	private ConjunctiveQuery rewriting;
	private Map<Term, String> varaibleMapping;
	private Map<Term, String> baseMaticesMapping;
	private Map<Term, String> idDecodingMapping;
	private StringBuilder laodMatrices;
	private List<Atom> sizeMatrices;
	private Map<Term, Atom> idAtomMapping;
	private String headAfter;
	private Iterator<Map.Entry<Term, Atom>> iterator;

	/**
	 * Constructor
	 * 
	 * @param query rewriting conjunctive query
	 * @throws IOException
	 */
	public RMTranslator(final ConjunctiveQuery rewriting) throws IOException {
		this();
		this.rewriting = rewriting;
		Metadata.load();
		Metadata.getInstance();
	}

	/**
	 * Default Constructor
	 * 
	 * @param query rewriting conjunctive query
	 */
	public RMTranslator() {
		varaibleMapping = new HashMap<>();
		idAtomMapping = new HashMap<>();
		idDecodingMapping = new HashMap<>();
		laodMatrices = new StringBuilder();
		baseMaticesMapping = new HashMap<>();
		sizeMatrices = new ArrayList<>();
		headAfter = null;
	}

	public void setRewriting(final ConjunctiveQuery rewriting) {
		this.rewriting = rewriting;
	}

	public void setRewriting(final ConjunctiveQuery rewriting, final String headAfter) {
		this.rewriting = rewriting;
		this.headAfter = headAfter;
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
				case "tr":
					processTranspose(entry.getValue());
					break;
				case "in":
					processInverse(entry.getValue());
					break;
				case "ins":
					processInverseScalar(entry.getValue());
					break;
				case "trace":
					processTrace(entry.getValue());
					break;
				case "sum":
					processSum(entry.getValue());
					break;
				case "diag":
					processDiag(entry.getValue());
					break;
				case "add":
					processAdd(entry.getValue());
					break;
				case "multi":
					processMulti(entry.getValue());
					break;
				case "det":
					processDet(entry.getValue());
					break;
				case "add_s":
					processAdds(entry.getValue());
					break;
				case "multi_s":
					processMultis(entry.getValue());
					break;
				case "identityPrune":
					procesPruneOut(entry.getValue());
					break;
				case "rowSums":
					processRowSums(entry.getValue());
					break;
				case "colSums":
					processColSums(entry.getValue());
					break;
				default:
					break;
				}
			}

		} while (idAtomMapping.size() != 0);
		final Term head = rewriting.getHead().get(0);
		final StringBuilder str = new StringBuilder();
		processNameRelation();
		if (laodMatrices.length() != 0) {
			str.append(laodMatrices);
		}
		if (headAfter == null)
			str.append(rewriting.getName());
		else {
			str.append(headAfter);
		}

		str.append("<-");
		if (idDecodingMapping.isEmpty()) {
			str.append(head);
		} else {
			str.append(idDecodingMapping.get(head));
		}
		varaibleMapping.clear();
		idAtomMapping.clear();
		idDecodingMapping.clear();
		laodMatrices.setLength(0);
		baseMaticesMapping.clear();
		sizeMatrices.clear();
		headAfter = null;
		return str.toString();
	}

	/**
	 * Pre-process the rewriting
	 */
	private void preProcess() {
		for (final Atom atom : rewriting.getBody()) {
			final String atomPredicte = atom.getPredicate();
			if (atomPredicte.equals(Predicate.SIZE.toString())) {
				sizeMatrices.add(atom);
			} else {
				if (atomPredicte.equals(Predicate.NAME.toString())) {
					varaibleMapping.put(atom.getTerm(0), atom.getTerm(0).toString());
					baseMaticesMapping.put(atom.getTerm(0), atom.getTerm(1).toString());
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
	}

	/**
	 * Process transpose operation
	 * 
	 * @param atom transpose atom
	 */
	private void processTranspose(final Atom atom) {
		final Term term = atom.getTerm(0);
		boolean status = false;
		final StringBuilder decodingTranspsoe = new StringBuilder();
		if (varaibleMapping.containsKey(term)) {
			status = true;
			decodingTranspsoe.append(LParenthesis);
			decodingTranspsoe.append(RMOperation.TRANS);
			decodingTranspsoe.append(LParenthesis);
			decodingTranspsoe.append(varaibleMapping.get(term));
			decodingTranspsoe.append(RParenthesis);
			decodingTranspsoe.append(RParenthesis);
			idDecodingMapping.put(atom.getTerm(1), decodingTranspsoe.toString());
		} else {
			if (idDecodingMapping.containsKey(term)) {
				status = true;

				decodingTranspsoe.append(LParenthesis);
				decodingTranspsoe.append(RMOperation.TRANS);
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
	 * Process determinaint operation
	 * 
	 * @param atom determinaint atom
	 */
	private void processDet(final Atom atom) {
		final Term term = atom.getTerm(0);
		boolean status = false;
		final StringBuilder decodingDet = new StringBuilder();
		if (varaibleMapping.containsKey(term)) {
			status = true;
			decodingDet.append(LParenthesis);
			decodingDet.append(RMOperation.DET);
			decodingDet.append(LParenthesis);
			decodingDet.append(varaibleMapping.get(term));
			decodingDet.append(RParenthesis);
			decodingDet.append(RParenthesis);
			idDecodingMapping.put(atom.getTerm(1), decodingDet.toString());
		} else {
			if (idDecodingMapping.containsKey(term)) {
				status = true;

				decodingDet.append(LParenthesis);
				decodingDet.append(RMOperation.DET);
				decodingDet.append(LParenthesis);
				decodingDet.append(idDecodingMapping.get(term));
				decodingDet.append(RParenthesis);
				decodingDet.append(RParenthesis);
				idDecodingMapping.put(atom.getTerm(1), decodingDet.toString());
			}
		}

		if (status) {
			iterator.remove();
		}
	}

	/**
	 * Process inverse operation
	 * 
	 * @param atom inverse atom
	 */
	private void processInverse(final Atom atom) {
		if (atom.toString().equals("in(c_7,b_3)") || atom.toString().equals("in(b_3,c_7)")) { // TODO:to be fixed
			idDecodingMapping.put(atom.getTerm(1), "");
			iterator.remove();
		} else {
			final Term term = atom.getTerm(0);
			boolean status = false;
			final StringBuilder decodingInverse = new StringBuilder();
			if (varaibleMapping.containsKey(term)) {
				status = true;
				decodingInverse.append(LParenthesis);
				decodingInverse.append(RMOperation.INVERSE);
				decodingInverse.append(LParenthesis);
				decodingInverse.append(varaibleMapping.get(term));
				decodingInverse.append(RParenthesis);
				decodingInverse.append(RParenthesis);
				idDecodingMapping.put(atom.getTerm(1), decodingInverse.toString());
			} else {
				if (idDecodingMapping.containsKey(term)) {
					status = true;
					decodingInverse.append(LParenthesis);
					decodingInverse.append(RMOperation.INVERSE);
					decodingInverse.append(LParenthesis);
					decodingInverse.append(idDecodingMapping.get(term));
					decodingInverse.append(RParenthesis);
					decodingInverse.append(RParenthesis);
					idDecodingMapping.put(atom.getTerm(1), decodingInverse.toString());
				}
			}
			if (status) {
				iterator.remove();
			}
		}
	}

	/**
	 * Process inverse scalar
	 * 
	 * @param atom inverse scalar atom
	 */
	private void processInverseScalar(final Atom atom) {
		final Term term = atom.getTerm(0);
		boolean status = false;
		final StringBuilder decodingInverse = new StringBuilder();
		if (varaibleMapping.containsKey(term)) {
			status = true;
			decodingInverse.append(LParenthesis);
			decodingInverse.append("1/");
			decodingInverse.append(LParenthesis);
			decodingInverse.append(varaibleMapping.get(term));
			decodingInverse.append(RParenthesis);
			decodingInverse.append(RParenthesis);
			idDecodingMapping.put(atom.getTerm(1), decodingInverse.toString());
		} else {
			if (idDecodingMapping.containsKey(term)) {
				status = true;
				decodingInverse.append(LParenthesis);
				decodingInverse.append("1/");
				decodingInverse.append(LParenthesis);
				decodingInverse.append(idDecodingMapping.get(term));
				decodingInverse.append(RParenthesis);
				decodingInverse.append(RParenthesis);
				idDecodingMapping.put(atom.getTerm(1), decodingInverse.toString());
			}
		}
		if (status) {
			iterator.remove();
		}
	}

	/**
	 * Process name relation
	 * 
	 * @param atom size atom
	 */
	private void processNameRelation() {

		for (Map.Entry<Term, String> entry : baseMaticesMapping.entrySet()) {
			final StringBuilder decodingSize = new StringBuilder();
			final String key = entry.getValue().replace("\"", "");
			double nnz = Metadata.instance.getNNZ(key);
			int rows = Metadata.instance.getNRows(key);
			int cols = Metadata.instance.getNCols(key);
			double sparisty = nnz / (rows * cols);
			if (sparisty < 1) {
				decodingSize.append("as.matrix");
				decodingSize.append(LParenthesis);
				decodingSize.append("readMM");
				decodingSize.append(LParenthesis);
				decodingSize.append(baseMaticesMapping.get(entry.getKey()));
				decodingSize.append(RParenthesis);
				decodingSize.append(RParenthesis);

			} else {
				decodingSize.append("as.matrix");
				decodingSize.append(LParenthesis);
				decodingSize.append("read.table");
				decodingSize.append(LParenthesis);
				decodingSize.append(baseMaticesMapping.get(entry.getKey()));
				decodingSize.append(", format=\"csv\",");
				decodingSize.append(" header=FALSE, sep=\",\"");
				decodingSize.append(RParenthesis);
				decodingSize.append(RParenthesis);
			}
			laodMatrices.append(entry.getKey());
			laodMatrices.append("<-");
			laodMatrices.append(decodingSize);
			laodMatrices.append("\n");
		}
	}

	/**
	 * Process trace operation
	 * 
	 * @param atom trace atom
	 */
	private void processTrace(final Atom atom) {
		final Term term = atom.getTerm(0);
		boolean status = false;
		final StringBuilder decodingTranspsoe = new StringBuilder();
		if (varaibleMapping.containsKey(term)) {
			status = true;
			decodingTranspsoe.append(LParenthesis);
			decodingTranspsoe.append(RMOperation.TRACE);
			decodingTranspsoe.append(LParenthesis);
			decodingTranspsoe.append(varaibleMapping.get(term));
			decodingTranspsoe.append(RParenthesis);
			decodingTranspsoe.append(RParenthesis);
			idDecodingMapping.put(atom.getTerm(1), decodingTranspsoe.toString());
		} else {
			if (idDecodingMapping.containsKey(term)) {
				status = true;

				decodingTranspsoe.append(LParenthesis);
				decodingTranspsoe.append(RMOperation.TRACE);
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
	 * Process sum operation
	 * 
	 * @param atom sum atom
	 */
	private void processSum(final Atom atom) {
		final Term term = atom.getTerm(0);
		boolean status = false;
		final StringBuilder decodingTranspsoe = new StringBuilder();
		if (varaibleMapping.containsKey(term)) {
			status = true;
			decodingTranspsoe.append(LParenthesis);
			decodingTranspsoe.append(RMOperation.SUM);
			decodingTranspsoe.append(LParenthesis);
			decodingTranspsoe.append(varaibleMapping.get(term));
			decodingTranspsoe.append(RParenthesis);
			decodingTranspsoe.append(RParenthesis);
			idDecodingMapping.put(atom.getTerm(1), decodingTranspsoe.toString());
		} else {
			if (idDecodingMapping.containsKey(term)) {
				status = true;

				decodingTranspsoe.append(LParenthesis);
				decodingTranspsoe.append(RMOperation.SUM);
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
	 * Process procesPruneOut
	 * 
	 * @param atom tprocesPruneOut
	 */
	private void procesPruneOut(final Atom atom) {
		final Term term = atom.getTerm(0);
		boolean status = false;
		if (varaibleMapping.containsKey(term)) {

			idDecodingMapping.put(atom.getTerm(1), atom.getTerm(0).toString());
		} else {
			if (idDecodingMapping.containsKey(term)) {
				status = true;
				idDecodingMapping.put(atom.getTerm(1), atom.getTerm(0).toString());
			}
		}

		if (status) {
			iterator.remove();

		}
	}

	/**
	 * Process diag operation
	 * 
	 * @param atom diag atom
	 */
	private void processDiag(final Atom atom) {
		final Term term = atom.getTerm(0);
		boolean status = false;
		final StringBuilder decodingTranspsoe = new StringBuilder();
		if (varaibleMapping.containsKey(term)) {
			status = true;
			decodingTranspsoe.append(LParenthesis);
			decodingTranspsoe.append(RMOperation.DIAG);
			decodingTranspsoe.append(LParenthesis);
			decodingTranspsoe.append(varaibleMapping.get(term));
			decodingTranspsoe.append(RParenthesis);
			decodingTranspsoe.append(RParenthesis);
			idDecodingMapping.put(atom.getTerm(1), decodingTranspsoe.toString());
		} else {
			if (idDecodingMapping.containsKey(term)) {
				status = true;

				decodingTranspsoe.append(LParenthesis);
				decodingTranspsoe.append(RMOperation.DIAG);
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
	 * @param atom add atom
	 */
	private void processAdd(final Atom atom) {
		final Term term1 = atom.getTerm(0);
		final Term term2 = atom.getTerm(1);
		boolean status = false;
		final StringBuilder decodingTranspsoe = new StringBuilder();
		if (varaibleMapping.containsKey(term1) && varaibleMapping.containsKey(term2)) {
			status = true;
			decodingTranspsoe.append(LParenthesis);
			decodingTranspsoe.append(varaibleMapping.get(term1));
			decodingTranspsoe.append(RMOperation.ADD);
			decodingTranspsoe.append(varaibleMapping.get(term2));
			decodingTranspsoe.append(RParenthesis);
			idDecodingMapping.put(atom.getTerm(2), decodingTranspsoe.toString());
		} else {
			if (varaibleMapping.containsKey(term1) && idDecodingMapping.containsKey(term2)) {
				status = true;
				decodingTranspsoe.append(LParenthesis);
				decodingTranspsoe.append(varaibleMapping.get(term1));
				decodingTranspsoe.append(RMOperation.ADD);
				decodingTranspsoe.append(idDecodingMapping.get(term2));
				decodingTranspsoe.append(RParenthesis);
				idDecodingMapping.put(atom.getTerm(2), decodingTranspsoe.toString());
			} else {
				if (idDecodingMapping.containsKey(term1) && varaibleMapping.containsKey(term2)) {
					status = true;
					decodingTranspsoe.append(LParenthesis);
					decodingTranspsoe.append(idDecodingMapping.get(term1));
					decodingTranspsoe.append(RMOperation.ADD);
					decodingTranspsoe.append(varaibleMapping.get(term2));
					decodingTranspsoe.append(RParenthesis);
					idDecodingMapping.put(atom.getTerm(2), decodingTranspsoe.toString());
				} else {
					if (idDecodingMapping.containsKey(term1) && idDecodingMapping.containsKey(term2)) {
						status = true;
						decodingTranspsoe.append(LParenthesis);
						decodingTranspsoe.append(idDecodingMapping.get(term1));
						decodingTranspsoe.append(RMOperation.ADD);
						decodingTranspsoe.append(idDecodingMapping.get(term2));
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
	 * Process add_s operation
	 * 
	 * @param atom add atom
	 */
	private void processAdds(final Atom atom) {
		final Term term1 = atom.getTerm(0);
		final Term term2 = atom.getTerm(1);
		boolean status = false;
		final StringBuilder decodingTranspsoe = new StringBuilder();
		if (varaibleMapping.containsKey(term1) && varaibleMapping.containsKey(term2)) {
			status = true;
			decodingTranspsoe.append(LParenthesis);
			decodingTranspsoe.append(varaibleMapping.get(term1));
			decodingTranspsoe.append(RMOperation.ADDS);
			decodingTranspsoe.append(varaibleMapping.get(term2));
			decodingTranspsoe.append(RParenthesis);
			idDecodingMapping.put(atom.getTerm(2), decodingTranspsoe.toString());
		} else {
			if (varaibleMapping.containsKey(term1) && idDecodingMapping.containsKey(term2)) {
				status = true;
				decodingTranspsoe.append(LParenthesis);
				decodingTranspsoe.append(varaibleMapping.get(term1));
				decodingTranspsoe.append(RMOperation.ADDS);
				decodingTranspsoe.append(idDecodingMapping.get(term2));
				decodingTranspsoe.append(RParenthesis);
				idDecodingMapping.put(atom.getTerm(2), decodingTranspsoe.toString());
			} else {
				if (idDecodingMapping.containsKey(term1) && varaibleMapping.containsKey(term2)) {
					status = true;
					decodingTranspsoe.append(LParenthesis);
					decodingTranspsoe.append(idDecodingMapping.get(term1));
					decodingTranspsoe.append(RMOperation.ADDS);
					decodingTranspsoe.append(varaibleMapping.get(term2));
					decodingTranspsoe.append(RParenthesis);
					idDecodingMapping.put(atom.getTerm(2), decodingTranspsoe.toString());
				} else {
					if (idDecodingMapping.containsKey(term1) && idDecodingMapping.containsKey(term2)) {
						status = true;
						decodingTranspsoe.append(LParenthesis);
						decodingTranspsoe.append(idDecodingMapping.get(term1));
						decodingTranspsoe.append(RMOperation.ADDS);
						decodingTranspsoe.append(idDecodingMapping.get(term2));
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
	 * Process multi_s operation
	 * 
	 * @param atom add atom
	 */
	private void processMultis(final Atom atom) {
		final Term term1 = atom.getTerm(0);
		final Term term2 = atom.getTerm(1);
		boolean status = false;
		final StringBuilder decodingTranspsoe = new StringBuilder();
		if (varaibleMapping.containsKey(term1) && varaibleMapping.containsKey(term2)) {
			status = true;
			decodingTranspsoe.append(LParenthesis);
			decodingTranspsoe.append(varaibleMapping.get(term1));
			decodingTranspsoe.append(RMOperation.MULTIS);
			decodingTranspsoe.append(varaibleMapping.get(term2));
			decodingTranspsoe.append(RParenthesis);
			idDecodingMapping.put(atom.getTerm(2), decodingTranspsoe.toString());
		} else {
			if (varaibleMapping.containsKey(term1) && idDecodingMapping.containsKey(term2)) {
				status = true;
				decodingTranspsoe.append(LParenthesis);
				decodingTranspsoe.append(varaibleMapping.get(term1));
				decodingTranspsoe.append(RMOperation.MULTIS);
				decodingTranspsoe.append(idDecodingMapping.get(term2));
				decodingTranspsoe.append(RParenthesis);
				idDecodingMapping.put(atom.getTerm(2), decodingTranspsoe.toString());
			} else {
				if (idDecodingMapping.containsKey(term1) && varaibleMapping.containsKey(term2)) {
					status = true;
					decodingTranspsoe.append(LParenthesis);
					decodingTranspsoe.append(idDecodingMapping.get(term1));
					decodingTranspsoe.append(RMOperation.MULTIS);
					decodingTranspsoe.append(varaibleMapping.get(term2));
					decodingTranspsoe.append(RParenthesis);
					idDecodingMapping.put(atom.getTerm(2), decodingTranspsoe.toString());
				} else {
					if (idDecodingMapping.containsKey(term1) && idDecodingMapping.containsKey(term2)) {
						status = true;
						decodingTranspsoe.append(LParenthesis);
						decodingTranspsoe.append(idDecodingMapping.get(term1));
						decodingTranspsoe.append(RMOperation.MULTIS);
						decodingTranspsoe.append(idDecodingMapping.get(term2));
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
	 * @param atom add atom
	 */
	private void processMulti(final Atom atom) {
		final Term term1 = atom.getTerm(0);
		final Term term2 = atom.getTerm(1);
		boolean status = false;
		final StringBuilder decodingTranspsoe = new StringBuilder();
		if (varaibleMapping.containsKey(term1) && varaibleMapping.containsKey(term2)) {
			status = true;
			decodingTranspsoe.append(LParenthesis);
			decodingTranspsoe.append(varaibleMapping.get(term1));
			decodingTranspsoe.append(RMOperation.MULTI);
			decodingTranspsoe.append(varaibleMapping.get(term2));
			decodingTranspsoe.append(RParenthesis);
			idDecodingMapping.put(atom.getTerm(2), decodingTranspsoe.toString());
		} else {
			if (varaibleMapping.containsKey(term1) && idDecodingMapping.containsKey(term2)) {
				status = true;
				decodingTranspsoe.append(LParenthesis);
				decodingTranspsoe.append(varaibleMapping.get(term1));
				decodingTranspsoe.append(RMOperation.MULTI);
				decodingTranspsoe.append(idDecodingMapping.get(term2));
				decodingTranspsoe.append(RParenthesis);
				idDecodingMapping.put(atom.getTerm(2), decodingTranspsoe.toString());
			} else {
				if (idDecodingMapping.containsKey(term1) && varaibleMapping.containsKey(term2)) {
					status = true;
					decodingTranspsoe.append(LParenthesis);
					decodingTranspsoe.append(idDecodingMapping.get(term1));
					decodingTranspsoe.append(RMOperation.MULTI);
					decodingTranspsoe.append(varaibleMapping.get(term2));
					decodingTranspsoe.append(RParenthesis);
					idDecodingMapping.put(atom.getTerm(2), decodingTranspsoe.toString());
				} else {
					if (idDecodingMapping.containsKey(term1) && idDecodingMapping.containsKey(term2)) {
						status = true;
						decodingTranspsoe.append(LParenthesis);
						decodingTranspsoe.append(idDecodingMapping.get(term1));
						decodingTranspsoe.append(RMOperation.MULTI);
						decodingTranspsoe.append(idDecodingMapping.get(term2));
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
	 * Process rowsums operation
	 * 
	 * @param atom rowSumss atom
	 */
	private void processRowSums(final Atom atom) {
		final Term term = atom.getTerm(0);
		boolean status = false;
		final StringBuilder decodingTranspsoe = new StringBuilder();
		if (varaibleMapping.containsKey(term)) {
			status = true;
			decodingTranspsoe.append(LParenthesis);
			decodingTranspsoe.append(RMOperation.ROWSUM);
			decodingTranspsoe.append(LParenthesis);
			decodingTranspsoe.append(varaibleMapping.get(term));
			decodingTranspsoe.append(RParenthesis);
			decodingTranspsoe.append(RParenthesis);
			idDecodingMapping.put(atom.getTerm(1), decodingTranspsoe.toString());
		} else {
			if (idDecodingMapping.containsKey(term)) {
				status = true;

				decodingTranspsoe.append(LParenthesis);
				decodingTranspsoe.append(RMOperation.ROWSUM);
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
	 * Process rowsums operation
	 * 
	 * @param atom rowSumss atom
	 */
	private void processColSums(final Atom atom) {
		final Term term = atom.getTerm(0);
		boolean status = false;
		final StringBuilder decodingTranspsoe = new StringBuilder();
		if (varaibleMapping.containsKey(term)) {
			status = true;
			decodingTranspsoe.append(LParenthesis);
			decodingTranspsoe.append(RMOperation.COLSUM);
			decodingTranspsoe.append(LParenthesis);
			decodingTranspsoe.append(varaibleMapping.get(term));
			decodingTranspsoe.append(RParenthesis);
			decodingTranspsoe.append(RParenthesis);
			idDecodingMapping.put(atom.getTerm(1), decodingTranspsoe.toString());
		} else {
			if (idDecodingMapping.containsKey(term)) {
				status = true;

				decodingTranspsoe.append(LParenthesis);
				decodingTranspsoe.append(RMOperation.COLSUM);
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
}