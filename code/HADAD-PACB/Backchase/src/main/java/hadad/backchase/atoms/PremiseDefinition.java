package hadad.backchase.atoms;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import hadad.backchase.Utils.Parser;
import hadad.backchase.atoms.AtomPositionTerm;
import hadad.backchase.atoms.DefEquality;
import hadad.backchase.atoms.DefRelAtom;
import hadad.backchase.instance.ChasedInstance;
import hadad.backchase.nodes.InnerNode;
import hadad.backchase.nodes.LeafNode;
import hadad.backchase.nodes.Node;

/**
 * PremiseDefinition
 *
 */
public class PremiseDefinition {

    private final static Logger LOGGER = Logger.getLogger(PremiseDefinition.class);

    private List<DefRelAtom> premiseAtoms;
    private List<DefEquality> premiseEqualities;
    private Node topJoinNode;
    private Map<String, AtomPositionTerm> varsToAtomPositions;

    /**
     * Constructor
     */
    public PremiseDefinition() {
        varsToAtomPositions = new HashMap<String, AtomPositionTerm>();
        premiseAtoms = new ArrayList<DefRelAtom>();
        premiseEqualities = new ArrayList<DefEquality>();
        topJoinNode = null;
    }

    /**
     * Update individual count
     * 
     * @param node
     *            the node
     * @param eqmap
     *            the equality map
     * @param value
     *            the value
     */
    public void updateIndividualCount(final Node node, final Map<Node, Integer> eqMap, final int value) {
        Integer crtval = eqMap.get(node);
        if (null == crtval)
            eqMap.put(node, value);
        else
            eqMap.put(node, crtval + value);
    }

    /**
     * Add equalities
     * 
     * @param couple
     *            the NodeCouple
     * @param eqmap
     *            the equality map
     * @param list
     *            the equality list
     */
    public void addEqualities(final NodeCouple couple, final Map<NodeCouple, List<DefEquality>> eqMap,
            final List<DefEquality> list) {
        final List<DefEquality> crtList = eqMap.get(couple);
        if (null == crtList)
            eqMap.put(couple, list);
        else
            crtList.addAll(list);
    }

    /**
     * Set premise atoms
     * 
     * @param premiseAtoms
     */
    public void setPremiseAtoms(final List<DefRelAtom> premiseAtoms) {
        this.premiseAtoms = premiseAtoms;
    }

    /**
     * Set premise equalities
     * 
     * @param premiseEqualities
     */
    public void setPremiseEqualities(final List<DefEquality> premiseEqualities) {
        this.premiseEqualities = premiseEqualities;
    }

    /**
     * Set top joinNode
     * 
     * @param topJoinNode
     */
    public void setTopJoinNode(final Node topJoinNode) {
        this.topJoinNode = topJoinNode;
    }

    /**
     * Set variables to atom positions
     * 
     * @param varsToAtomPositions
     */
    public void setVarsToAtomPositions(final Map<String, AtomPositionTerm> varsToAtomPositions) {
        this.varsToAtomPositions = varsToAtomPositions;
    }

    /**
     * Get premise atoms
     * 
     * @return premiseAtoms
     */
    public List<DefRelAtom> getPremiseAtoms() {
        return premiseAtoms;
    }

    /**
     * Get premise equalities
     * 
     * @return premiseEqualities
     */
    public List<DefEquality> getPremiseEqualities() {
        return premiseEqualities;
    }

    /**
     * Get top joinNode
     * 
     * @return topJoinNode
     */
    public Node getTopJoinNode() {
        return topJoinNode;
    }

    /**
     * Get variables to atom positions
     * 
     * @param varsToAtomPositions
     */
    public Map<String, AtomPositionTerm> setVarsToAtomPositions() {
        return varsToAtomPositions;
    }

    /**
     * Build the query tree for the premise
     */
    public void buildTree() {
        Map<DefRelAtom, Node> nodesForAtoms = new HashMap<DefRelAtom, Node>();
        for (int i = 0; i < premiseAtoms.size(); ++i)
            nodesForAtoms.put(premiseAtoms.get(i), new LeafNode(premiseAtoms.get(i)));

        Map<NodeCouple, List<DefEquality>> countEqualitiesForCouples = new HashMap<NodeCouple, List<DefEquality>>();
        for (DefRelAtom atom1 : nodesForAtoms.keySet())
            for (DefRelAtom atom2 : nodesForAtoms.keySet())
                if (atom1 != atom2) {
                    NodeCouple couple = new NodeCouple(nodesForAtoms.get(atom1), nodesForAtoms.get(atom2));
                    countEqualitiesForCouples.put(couple, new ArrayList<DefEquality>());
                }
        for (int i = 0; i < premiseEqualities.size(); ++i) {
            DefEquality crtEq = premiseEqualities.get(i);
            NodeCouple couple = new NodeCouple(nodesForAtoms.get(crtEq.getAtomPositionTerm1().getDefRelAtom()),
                    nodesForAtoms.get(crtEq.getAtomPositionTerm2().getDefRelAtom()));
            List<DefEquality> val = countEqualitiesForCouples.get(couple);
            val.add(crtEq);
        }

        HashMap<Node, Integer> countEqualitiesPerNode = new HashMap<Node, Integer>();
        for (NodeCouple couple : countEqualitiesForCouples.keySet()) {
            int val = countEqualitiesForCouples.get(couple).size();
            updateIndividualCount(couple.node1, countEqualitiesPerNode, val);
            updateIndividualCount(couple.node2, countEqualitiesPerNode, val);
        }

        if (countEqualitiesForCouples.size() == 0) {
            topJoinNode = nodesForAtoms.get(premiseAtoms.get(0));
            return;
        }

        while (true) {
            int minValue = 0;
            NodeCouple bestCouple = null;
            for (NodeCouple couple : countEqualitiesForCouples.keySet()) {
                int eqsnode1 = countEqualitiesPerNode.get(couple.node1);
                int eqsnode2 = countEqualitiesPerNode.get(couple.node2);
                int eqscouple = countEqualitiesForCouples.get(couple).size();
                int min = eqsnode1;
                if (eqsnode2 < min)
                    min = eqsnode2;
                int crtValue = min - eqscouple;
                if ((bestCouple == null) || (crtValue < minValue)
                        || (crtValue == minValue && couple.depth < bestCouple.depth)) {
                    minValue = crtValue;
                    bestCouple = couple;
                }
            }

            InnerNode mergedNode = new InnerNode(bestCouple.node1, bestCouple.node2);
            for (DefEquality eq : countEqualitiesForCouples.get(bestCouple))
                mergedNode.addDefEquality(eq);
            HashMap<NodeCouple, List<DefEquality>> auxCountEqualitiesForCouples =
                    new HashMap<NodeCouple, List<DefEquality>>();
            for (NodeCouple couple : countEqualitiesForCouples.keySet()) {
                if (couple.equals(bestCouple))
                    continue;
                else if (couple.node1 == bestCouple.node1 || couple.node1 == bestCouple.node2) {
                    NodeCouple newCouple = new NodeCouple(mergedNode, couple.node2);
                    addEqualities(newCouple, auxCountEqualitiesForCouples, countEqualitiesForCouples.get(couple));
                } else if (couple.node2 == bestCouple.node1 || couple.node2 == bestCouple.node2) {
                    NodeCouple newCouple = new NodeCouple(couple.node1, mergedNode);
                    addEqualities(newCouple, auxCountEqualitiesForCouples, countEqualitiesForCouples.get(couple));
                } else
                    addEqualities(couple, auxCountEqualitiesForCouples, countEqualitiesForCouples.get(couple));
            }

            if (auxCountEqualitiesForCouples.size() == 0) {
                topJoinNode = mergedNode;
                break;
            }
            countEqualitiesForCouples = auxCountEqualitiesForCouples;
            countEqualitiesPerNode.clear();
            for (NodeCouple couple : countEqualitiesForCouples.keySet()) {
                int val = countEqualitiesForCouples.get(couple).size();
                updateIndividualCount(couple.node1, countEqualitiesPerNode, val);
                updateIndividualCount(couple.node2, countEqualitiesPerNode, val);
            }
        }
    }

    /**
     * Get term from String
     * 
     * @param strTerm
     *            the string term
     * @return the term variable (AtomPositionTerm)
     */
    public AtomPositionTerm getTermFromString(final String strTerm) {
        if (strTerm.length() > 3 && strTerm.substring(0, 2).equals("co")) {
            AtomPositionTerm constantTerm = new AtomPositionTerm(null, -1);
            constantTerm.setResolvedTerm(ChasedInstance.zeInstance.getSpecialTermByName(strTerm));
            return constantTerm;
        }
        return varsToAtomPositions.get(strTerm);
    }

    /**
     * Node Couple class
     *
     */
    public class NodeCouple {
        Node node1;
        Node node2;

        int depth;

        public int hashCode() {
            return node1.hashCode() + node2.hashCode();
        }

        public NodeCouple(final Node node1, final Node node2) {
            this.node1 = node1;
            this.node2 = node2;
            depth = node1.depth + node2.depth;
        }

        public boolean equals(final Object otherobj) {
            NodeCouple other = (NodeCouple) otherobj;
            if ((this.node1 == other.node1 && this.node2 == other.node2)
                    || (this.node2 == other.node1 && this.node1 == other.node2))
                return true;
            return false;
        }

    }

    public void readFromFile(final BufferedReader br) throws Exception {
        Parser parser = new Parser();
        String line = br.readLine();
        parser.parseRelationals(line);
        ArrayList<ArrayList<String>> parsedRelationals = parser.getRelationals();
        for (int i = 0; i < parsedRelationals.size(); ++i) {
            ArrayList<String> crtParsedRelational = parsedRelationals.get(i);
            Relation crtRelation = ChasedInstance.zeInstance.getRelationByName(crtParsedRelational.get(0));
            DefRelAtom crtAtom = new DefRelAtom(crtRelation, crtParsedRelational.size() - 1);
            premiseAtoms.add(crtAtom);
            for (int j = 1; j < crtParsedRelational.size(); ++j) {
                String value = crtParsedRelational.get(j);
                if (value.length() > 3 && value.substring(0, 2).equals("co")) {
                    crtAtom.getAtomPositionTerms()[j - 1] = new AtomPositionTerm(null, j - 1);
                    crtAtom.getAtomPositionTerms()[j - 1]
                            .setResolvedTerm(ChasedInstance.zeInstance.getSpecialTermByName(value));
                } else {
                    crtAtom.getAtomPositionTerms()[j - 1] = new AtomPositionTerm(crtAtom, j - 1);
                    varsToAtomPositions.put(value, crtAtom.getAtomPositionTerms()[j - 1]);
                }
            }
        }
        line = br.readLine();
        parser.parseEqualities(line);
        ArrayList<String[]> parsedEqualities = parser.getEqualities();
        for (int i = 0; i < parsedEqualities.size(); ++i) {
            String[] crtParsedEquality = parsedEqualities.get(i);
            final DefEquality crtEq =
                    new DefEquality(getTermFromString(crtParsedEquality[0]), getTermFromString(crtParsedEquality[1]));
            premiseEqualities.add(crtEq);

        }
        buildTree();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(premiseAtoms);
        if (!premiseEqualities.isEmpty()) {
            str.append(',');
            str.append(premiseEqualities);
        }
        return str.toString();
    }

}
