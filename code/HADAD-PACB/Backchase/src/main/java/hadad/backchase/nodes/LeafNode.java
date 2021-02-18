package hadad.backchase.nodes;

import java.util.Arrays;
import java.util.List;

import hadad.backchase.atoms.AtomPositionTerm;
import hadad.backchase.atoms.DefRelAtom;
import hadad.backchase.atoms.ResolvedRelAtom;
import hadad.backchase.atoms.ResolvedTerm;
import hadad.backchase.instance.ChasedInstance;
import hadad.backchase.instance.LocalMapping;
import hadad.backchase.provenanace.flatProvenance.FlatFormula;
import hadad.backchase.provenanace.placeHodlerProvenance.PHConjunct;
import hadad.backchase.provenanace.placeHodlerProvenance.PHFormula;

public class LeafNode extends Node {
    public DefRelAtom m_atom;

    public ResolvedTerm[] m_termsForEqsLeft;
    public ResolvedTerm[] m_termsForEqsRight;

    public AdaptiveMappingsIndex m_index;

    public int m_cursorInRelation;

    public LeafNode(DefRelAtom atom) {
        super();
        m_atom = atom;
        m_index = new AdaptiveMappingsIndex(10);
        m_cursorInRelation = 0;

        depth = 1;
    }

    public boolean hasAtom(DefRelAtom atom) {
        return atom == m_atom;
    }

    public void refreshDummyMapping() {
        dummyMapping = new LocalMapping();
        dummyMapping.m_termsForAncestors = new ResolvedTerm[indices.length];
        dummyMapping.m_flatProvenance = new FlatFormula();
    }

    public void computeNeededTerms(List<AtomPositionTerm> termsNeededUpper) {
        comesFromLeft = new boolean[termsNeededUpper.size()];
        indices = new int[termsNeededUpper.size()];

        //projected attributes
        for (int i = 0; i < termsNeededUpper.size(); ++i)
            indices[i] = termsNeededUpper.get(i).getAttributeIndex();

        //join attributes
        //to do: store constants differently!
        eqsLeft = new int[defEqualities.size()];
        eqsRight = new int[defEqualities.size()];

        for (int i = 0; i < defEqualities.size(); ++i) {
            AtomPositionTerm term1 = defEqualities.get(i).getAtomPositionTerm1();
            AtomPositionTerm term2 = defEqualities.get(i).getAtomPositionTerm2();

            eqsLeft[i] = term1.getAttributeIndex();
            eqsRight[i] = term2.getAttributeIndex();
        }

        m_termsForEqsLeft = new ResolvedTerm[defEqualities.size()];
        m_termsForEqsRight = new ResolvedTerm[defEqualities.size()];

        refreshDummyMapping();
    }

    public void flush() {
        m_index.flush();
        m_cursorInRelation = 0;
    }

    private void addNewAtom(ResolvedRelAtom atom) {
        //check if constants are respected
        for (int i = 0; i < m_atom.getAtomPositionTerms().length; ++i)
            if (m_atom.getAtomPositionTerms()[i].getResolvedTerm() != null && m_atom.getAtomPositionTerms()[i]
                    .getResolvedTerm().getComponent() != atom.getResolvedTerms()[i].getComponent())
                return;

        //check if inner atom equalities are respected
        for (int i = 0; i < m_termsForEqsLeft.length; ++i) {
            m_termsForEqsLeft[i] = atom.getResolvedTerms()[eqsLeft[i]];
            m_termsForEqsRight[i] = atom.getResolvedTerms()[eqsRight[i]];
        }
        if (!Node.checkMatchingEqualities(m_termsForEqsLeft, m_termsForEqsRight))
            return;

        //fill dummy mapping
        for (int i = 0; i < indices.length; ++i)
            dummyMapping.m_termsForAncestors[i] = atom.getResolvedTerms()[indices[i]];
        dummyMapping.computeHashCodeId();

        if (ChasedInstance.zeInstance.m_usePlaceHolders) {
            //to do: replace this by "clear"
            PHConjunct dummyConjunct = new PHConjunct();
            dummyConjunct.addAtom(atom);

            dummyMapping.m_placeHolderProvenance = new PHFormula(dummyConjunct);

            for (int i = 0; i < m_termsForEqsLeft.length; ++i)
                dummyMapping.m_placeHolderProvenance.addEquality(m_termsForEqsLeft[i], m_termsForEqsRight[i]);
        }

        dummyMapping.m_flatProvenance = new FlatFormula(atom.getFlatFormula());

        for (int i = 0; i < m_termsForEqsLeft.length; ++i)
            dummyMapping.m_flatProvenance.addProductCanonical(m_termsForEqsLeft[i].getComponent()
                    .getClosureProvenance(m_termsForEqsLeft[i], m_termsForEqsRight[i]));

        addNewLocalMapping(dummyMapping, this);
    }

    public void addNewLocalMapping(LocalMapping mapping, Object adder) {
        //find if an identical-project atom already exists
        LocalMapping exists = m_index.getAndInsert(mapping, mapping.m_hashCodeId);
        if (exists != null) {
            //do this better with subsumption
            boolean subsumed = exists.m_flatProvenance.addSumCanonical(mapping.m_flatProvenance, true);

            if (ChasedInstance.zeInstance.m_usePlaceHolders)
                exists.m_placeHolderProvenance.addSum(mapping.m_placeHolderProvenance);
            else if (subsumed)
                return;

            parent.addExistingMappingAdditionalProvenance(exists, mapping.m_placeHolderProvenance,
                    mapping.m_flatProvenance, this);
        } else {
            parent.addNewLocalMapping(mapping, this);
            refreshDummyMapping();
        }
    }

    public void addExistingMappingAdditionalProvenance(LocalMapping mapping, PHFormula phform, FlatFormula provform,
            Object adder) {
    }

    public void registerAsWatcherOnRelations() {
        m_atom.getRelation().addWatcher(this);
    }

    public void pushNew() {
        ResolvedRelAtom newAtom = m_atom.getRelation().getResolvedAtoms().get(m_cursorInRelation);
        addNewAtom(newAtom);
        m_cursorInRelation++;
        if (m_cursorInRelation == m_atom.getRelation().getResolvedAtoms().size())
            hasNew = false;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(m_atom);
        if (m_termsForEqsLeft != null) {
            sb.append(" ");
            sb.append("L:");
            sb.append(Arrays.toString(m_termsForEqsLeft));
        } else {
            sb.append(" ");
            sb.append("L:");
            sb.append("null");
        }
        if (m_termsForEqsRight != null) {
            sb.append(" ");
            sb.append("R:");
            sb.append(Arrays.toString(m_termsForEqsRight));
        } else {
            sb.append(" ");
            sb.append("R:");
            sb.append("null");
        }
        return sb.toString();

    }

}
