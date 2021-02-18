package hadad.backchase.nodes;

import hadad.backchase.atoms.AtomPositionTerm;
import hadad.backchase.atoms.DefRelAtom;
import hadad.backchase.atoms.ResolvedTerm;
import hadad.backchase.instance.ChasedInstance;
import hadad.backchase.instance.LocalMapping;
import hadad.backchase.provenanace.flatProvenance.FlatFormula;
import hadad.backchase.provenanace.placeHodlerProvenance.PHFormula;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InnerNode extends Node {
    private Node leftChild;
    private Node rightChild;
    private Set<DefRelAtom> atoms;
    private AdaptiveMappingsIndex localMappingsLeft;
    private AdaptiveMappingsIndex localMappingsRight;
    private AdaptiveMappingsIndex joinMappingsId;

    public InnerNode(final Node left, final Node right) {
        super();

        leftChild = left;
        left.parent = this;
        rightChild = right;
        right.parent = this;
        localMappingsLeft = new AdaptiveMappingsIndex(4);
        localMappingsRight = new AdaptiveMappingsIndex(4);
        atoms = new HashSet<DefRelAtom>();
        leftChild.addAtomsToParent(atoms);
        rightChild.addAtomsToParent(atoms);
        depth = leftChild.depth;
        if (rightChild.depth > depth)
            depth = rightChild.depth;
        depth++;
    }

    public boolean hasAtom(DefRelAtom atom) {
        return atoms.contains(atom);
    }

    public void refreshDummyMapping() {
        dummyMapping = new LocalMapping();
        dummyMapping.m_termsForAncestors = new ResolvedTerm[comesFromLeft.length];
        dummyMapping.m_flatProvenance = new FlatFormula();
    }

    public void computeNeededTerms(List<AtomPositionTerm> termsNeededUpper) {
        comesFromLeft = new boolean[termsNeededUpper.size()];
        indices = new int[termsNeededUpper.size()];
        eqsLeft = new int[defEqualities.size()];
        eqsRight = new int[defEqualities.size()];

        List<AtomPositionTerm> termsneededLeft = new ArrayList<AtomPositionTerm>();
        List<AtomPositionTerm> termsneededRight = new ArrayList<AtomPositionTerm>();

        for (int i = 0; i < termsNeededUpper.size(); ++i) {
            AtomPositionTerm term = termsNeededUpper.get(i);

            if (leftChild.hasAtom(term.getDefRelAtom())) {
                comesFromLeft[i] = true;
                indices[i] = termsneededLeft.size();
                termsneededLeft.add(term);
            } else {
                comesFromLeft[i] = false;
                indices[i] = termsneededRight.size();
                termsneededRight.add(term);
            }
        }

        for (int i = 0; i < defEqualities.size(); ++i) {
            AtomPositionTerm termLeft = defEqualities.get(i).getAtomPositionTerm1();
            AtomPositionTerm termRight = defEqualities.get(i).getAtomPositionTerm2();

            if (!leftChild.hasAtom(termLeft.getDefRelAtom())) {
                AtomPositionTerm aux = termLeft;
                termLeft = termRight;
                termRight = aux;
            }

            int j = 0;
            for (j = 0; j < termsneededLeft.size(); ++j)
                if (termsneededLeft.get(j).isSameAs(termLeft))
                    break;
            eqsLeft[i] = j;
            if (j == termsneededLeft.size())
                termsneededLeft.add(termLeft);

            for (j = 0; j < termsneededRight.size(); ++j)
                if (termsneededRight.get(j).isSameAs(termRight))
                    break;
            eqsRight[i] = j;
            if (j == termsneededRight.size())
                termsneededRight.add(termRight);
        }

        leftChild.computeNeededTerms(termsneededLeft);
        rightChild.computeNeededTerms(termsneededRight);

        refreshDummyMapping();
        joinMappingsId = new AdaptiveMappingsIndex(10);
    }

    public void flush() {
        leftChild.flush();
        rightChild.flush();

        localMappingsLeft.flush();
        localMappingsRight.flush();

        joinMappingsId.flush();
    }

    private void makeJoinMapping(LocalMapping leftMapping, LocalMapping rightMapping, PHFormula phLeft,
            PHFormula phRight, FlatFormula flatLeft, FlatFormula flatRight) {
        if (!Node.checkMatchingEqualities(leftMapping.m_termsForEqsInParent, rightMapping.m_termsForEqsInParent))
            return;
        dummyMapping.fillFrom(leftMapping, rightMapping, phLeft, phRight, flatLeft, flatRight, comesFromLeft, indices);

        LocalMapping exists = joinMappingsId.getAndInsert(dummyMapping, dummyMapping.m_hashCodeId);
        if (null != exists) {
            boolean subsumed = exists.m_flatProvenance.addSumCanonical(dummyMapping.m_flatProvenance, true);
            if (ChasedInstance.zeInstance.m_usePlaceHolders)
                exists.m_placeHolderProvenance.addSum(dummyMapping.m_placeHolderProvenance);
            else if (subsumed)
                return;

            parent.addExistingMappingAdditionalProvenance(exists, dummyMapping.m_placeHolderProvenance,
                    dummyMapping.m_flatProvenance, this);
        } else {
            parent.addNewLocalMapping(dummyMapping, this);
            refreshDummyMapping();
        }
    }

    public void addNewMappingLeft(LocalMapping mapping) {
        mapping.makeResolvedTermsForEqs(eqsLeft);
        mapping.computeHashCodeEq();
        localMappingsLeft.insert(mapping, mapping.m_hashCodeEq);

        List<LocalMapping> matching = localMappingsRight.getMatching(mapping.m_hashCodeEq);
        if (null == matching)
            return;

        for (LocalMapping right : matching)
            makeJoinMapping(mapping, right, mapping.m_placeHolderProvenance, right.m_placeHolderProvenance,
                    mapping.m_flatProvenance, right.m_flatProvenance);
    }

    public void addNewMappingRight(LocalMapping mapping) {
        mapping.makeResolvedTermsForEqs(eqsRight);
        mapping.computeHashCodeEq();
        localMappingsRight.insert(mapping, mapping.m_hashCodeEq);

        List<LocalMapping> matching = localMappingsLeft.getMatching(mapping.m_hashCodeEq);
        if (null == matching)
            return;

        for (LocalMapping left : matching)
            makeJoinMapping(left, mapping, left.m_placeHolderProvenance, mapping.m_placeHolderProvenance,
                    left.m_flatProvenance, mapping.m_flatProvenance);
    }

    public void addNewLocalMapping(LocalMapping mapping, Object adder) {
        if (adder == leftChild)
            addNewMappingLeft(mapping);
        else
            addNewMappingRight(mapping);
    }

    public void addExistingMappingLeft(LocalMapping mapping, PHFormula phform, FlatFormula provform) {
        List<LocalMapping> matching = localMappingsRight.getMatching(mapping.m_hashCodeEq);
        if (null == matching)
            return;

        for (LocalMapping right : matching)
            makeJoinMapping(mapping, right, phform, right.m_placeHolderProvenance, provform, right.m_flatProvenance);
    }

    public void addExistingMappingRight(LocalMapping mapping, PHFormula phform, FlatFormula provform) {
        List<LocalMapping> matching = localMappingsLeft.getMatching(mapping.m_hashCodeEq);
        if (null == matching)
            return;

        for (LocalMapping left : matching)
            makeJoinMapping(left, mapping, left.m_placeHolderProvenance, phform, left.m_flatProvenance, provform);
    }

    public void addExistingMappingAdditionalProvenance(LocalMapping mapping, PHFormula phform, FlatFormula provform,
            Object adder) {
        if (adder == leftChild)
            addExistingMappingLeft(mapping, phform, provform);
        else
            addExistingMappingRight(mapping, phform, provform);
    }

    public void registerAsWatcherOnRelations() {
        leftChild.registerAsWatcherOnRelations();
        rightChild.registerAsWatcherOnRelations();
    }

    public Set<DefRelAtom> getAtoms() {
        return atoms;
    }
    public void pushNew() {

        if (leftChild.hasNew)
            leftChild.pushNew();
        else if (rightChild.hasNew)
            rightChild.pushNew();
        else
            hasNew = false;

    }

}
