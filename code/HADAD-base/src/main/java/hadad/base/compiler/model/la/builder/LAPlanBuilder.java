package hadad.base.compiler.model.la.builder;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import org.apache.log4j.Logger;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;

import hadad.base.compiler.model.la.metadata.Metadata;
import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.conjunctivequery.StringConstant;
import hadad.commons.conjunctivequery.Term;

/**
 * Simple LA plan builder. The order of the operator in the constructed plan is
 * based on the order of operators in the rewriting.
 *
 */
public final class LAPlanBuilder {

    /** Logger **/
    private static final Logger LOGGER = Logger.getLogger(LAPlanBuilder.class);

    /** Constructor 
     * @throws IOException **/
    private LAPlanBuilder() throws IOException {
     Metadata.load();
    };

    /**
     * Construct a simple LA plan (for cost-estimation) from a given rewriting
     * 
     * @param rewriting
     *            the conjunctive rewriting
     */
    public static IOperator constructPlan(final ConjunctiveQuery rewriting) {
        final Map<Term, IOperator> operatorMapping = baseTermsToScanOperatorMapping(rewriting);
        final ListMultimap<Term, Atom> termsAtomsMapping = termsToAtomsMapping(rewriting);
        if (termsAtomsMapping != null) {
            final Queue<Term> ids = new LinkedList<Term>(termsAtomsMapping.keySet());
            while (!ids.isEmpty()) {
                final Term term = ids.poll();
                final Atom currentAtom = termsAtomsMapping.get(term).get(0);

                //Process Unary
                if (currentAtom.getTerms().size() == 2) {
                    final Term term1 = currentAtom.getTerm(0);
                    if (operatorMapping.containsKey(term1)) {
                        final IOperator chidOp = operatorMapping.get(term1);
                        final UnaryOperator unaryOp =
                                new UnaryOperator(chidOp, OpType.valueOf(currentAtom.getPredicate().toUpperCase()));
                        operatorMapping.put(currentAtom.getTerm(1), unaryOp);
                    } else {
                        ids.add(term1);
                    }
                }
                //Process Binary
                if (currentAtom.getTerms().size() == 3) {
                    final Term term1 = currentAtom.getTerm(0);
                    final Term term2 = currentAtom.getTerm(1);
                    if (term1.isConstant() && term2.isConstant()) {
                        final StringConstant str1 = (StringConstant) term1;
                        final StringConstant str2 = (StringConstant) term1;

                        final IOperator chidOpLeft = new ScalarOperator(Double.valueOf(str1.getValue()));
                        final IOperator chidOpRight = new ScalarOperator(Double.valueOf(str2.getValue()));
                        final BinaryOperator binaryOp = new BinaryOperator(chidOpLeft, chidOpRight,
                                OpType.valueOf(currentAtom.getPredicate().toUpperCase()));
                        operatorMapping.put(currentAtom.getTerm(2), binaryOp);
                    } else {
                        if (!term1.isConstant()) {
                            if (operatorMapping.containsKey(term1) && operatorMapping.containsKey(term2)) {
                                final IOperator chidOpLeft = operatorMapping.get(term1);
                                final IOperator chidOpRight = operatorMapping.get(term2);
                                final BinaryOperator binaryOp = new BinaryOperator(chidOpLeft, chidOpRight,
                                        OpType.valueOf(currentAtom.getPredicate().toUpperCase()));
                                operatorMapping.put(currentAtom.getTerm(2), binaryOp);
                            } else {
                                if (!operatorMapping.containsKey(term1)) {
                                    ids.add(term1);
                                }
                                if (!operatorMapping.containsKey(term2)) {
                                    ids.add(term2);
                                }
                            }
                        } else {
                            if (!operatorMapping.containsKey(term2)) {
                                ids.add(term2);
                            } else {
                                final StringConstant str = (StringConstant) term1;
                                final IOperator chidOpLeft = new ScalarOperator(Double.valueOf(str.getValue()));
                                final IOperator chidOpRight = operatorMapping.get(term2);
                                final BinaryOperator binaryOp = new BinaryOperator(chidOpLeft, chidOpRight,
                                        OpType.valueOf(currentAtom.getPredicate().toUpperCase()));
                                operatorMapping.put(currentAtom.getTerm(2), binaryOp);
                            }
                        }
                    }
                }
            }
        }else {
        	return null;
        }
        return operatorMapping.get(rewriting.getHead().get(0));

    }

    /**
     * Provide terms to atoms mapping
     * 
     * @param rewriting
     *            the conjunctive rewriting
     * @return the terms-atoms mapping
     */
    private static ListMultimap<Term, Atom> termsToAtomsMapping(final ConjunctiveQuery rewriting) {
        final ListMultimap<Term, Atom> termsAtomsMapping = ArrayListMultimap.create();
        final Set<Term> outIDs = new HashSet<>();
        final Set<Term> specIDs =  new HashSet<>();
        for (Atom atom : rewriting.getBody()) {
            if (atom.getPredicate().equals("name")) {
            	specIDs.add(atom.getTerm(0));
            	if(outIDs.contains(atom.getTerm(0))){
            		return null;
            	}
            } else {
                if (atom.getTerms().size() == 3) {
                    final Term out = atom.getTerm(2);
                    if (!outIDs.contains(out) && !specIDs.contains(out) ) {
                        termsAtomsMapping.put(atom.getTerm(0), atom);
                        termsAtomsMapping.put(atom.getTerm(1), atom);
                        outIDs.add(out);
                    } else
                        return null;
                } else {
                    final Term out = atom.getTerm(1);
                    if (!outIDs.contains(out)&& !specIDs.contains(out)) {
                        termsAtomsMapping.put(atom.getTerm(0), atom);
                        outIDs.add(out);
                    } else
                        return null;
                }
            }
        }
        return termsAtomsMapping;
    }

    /**
     * Provides base terms to scan operators mapping
     * 
     * @param rewriting
     *            the conjunctive rewriting
     * @return matrix id and scan operator mappings
     */
    private static Map<Term, IOperator> baseTermsToScanOperatorMapping(final ConjunctiveQuery rewriting) {
        final Map<Term, IOperator> operatorMapping = new HashMap<>();
        final Set<Atom> baseAtoms = new HashSet<>();
        final Set<Atom> sizeAtoms = new HashSet<>();
        for (Atom atom : rewriting.getBody()) {
            if (atom.getPredicate().equals("name")) {
                baseAtoms.add(atom);
            }
            if (atom.getPredicate().equals("size")) {
                sizeAtoms.add(atom);
            }
        }
//        for (Atom atomSize : sizeAtoms) {
//            final Term term = atomSize.getTerm(0);
//            for (Atom atomBase : baseAtoms) {
//                if (atomBase.getTerm(0).equals(term)) {
//                    final StringConstant str = (StringConstant) atomBase.getTerm(1);
//                    final ScanOperator scan = new ScanOperator(str.getValue());
//                    StringConstant rows = (StringConstant) atomSize.getTerm(1);
//                    StringConstant cols = (StringConstant) atomSize.getTerm(2);
//                    scan.setNumberOfRows(Integer.valueOf(rows.getValue()));
//                    scan.setNumberOfCols(Integer.valueOf(cols.getValue()));
//                    operatorMapping.put(term, scan);
//                }
//            }
//        }
       ;
            for (Atom atomBase : baseAtoms) {
                    final StringConstant str = (StringConstant) atomBase.getTerm(1);
                    final ScanOperator scan = new ScanOperator(str.getValue());
                    int cols = Metadata.instance.getNCols(str.getValue());
                    int rows = Metadata.instance.getNRows(str.getValue());
                    scan.setNumberOfRows(rows);
                    scan.setNumberOfCols(cols);
                    operatorMapping.put(atomBase.getTerm(0), scan);
                }
            
        
        return operatorMapping;
    }

}
