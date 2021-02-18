package hadad.backchase.instance;

import hadad.backchase.atoms.ResolvedTerm;
import hadad.backchase.provenanace.flatProvenance.FlatFormula;
import hadad.backchase.provenanace.placeHodlerProvenance.PHFormula;

public class LocalMapping {
    public LocalMapping m_leftMapping;
    public LocalMapping m_rightMapping;

    public ResolvedTerm[] m_termsForEqsInParent;
    public ResolvedTerm[] m_termsForAncestors;

    public int m_hashCodeEq;
    public int m_hashCodeId;

    public FlatFormula m_flatProvenance;
    public PHFormula m_placeHolderProvenance;

    public LocalMapping() {
        m_leftMapping = null;
        m_rightMapping = null;
    }

    public int hashCode() {
        return m_hashCodeId;
    }

    /**
     * Update flat formula
     * 
     * @param formula
     *            the FlatFormula to be added
     */
    public void updateFlatFormula(final FlatFormula formula) {
        m_flatProvenance = new FlatFormula(formula);
    }

    public void fillFrom(LocalMapping leftMapping, LocalMapping rightMapping, PHFormula leftph, PHFormula rightph,
            FlatFormula leftflat, FlatFormula rightflat, boolean[] comesFromLeft, int[] indices) {
        m_leftMapping = leftMapping;
        m_rightMapping = rightMapping;

        for (int i = 0; i < comesFromLeft.length; ++i) {
            if (comesFromLeft[i])
                m_termsForAncestors[i] = leftMapping.m_termsForAncestors[indices[i]];
            else
                m_termsForAncestors[i] = rightMapping.m_termsForAncestors[indices[i]];
        }
        computeHashCodeId();

        if (ChasedInstance.zeInstance.m_usePlaceHolders) {
            m_placeHolderProvenance = new PHFormula(leftph, rightph);
            for (int i = 0; i < leftMapping.m_termsForEqsInParent.length; ++i) {
                if (leftMapping.m_termsForEqsInParent[i] == rightMapping.m_termsForEqsInParent[i])
                    continue;
                m_placeHolderProvenance.addEquality(leftMapping.m_termsForEqsInParent[i],
                        rightMapping.m_termsForEqsInParent[i]);
            }
        }

        m_flatProvenance = new FlatFormula(leftflat);
        m_flatProvenance.addProductCanonical(rightflat);

        for (int i = 0; i < leftMapping.m_termsForEqsInParent.length; ++i) {
            if (leftMapping.m_termsForEqsInParent[i] == rightMapping.m_termsForEqsInParent[i])
                continue;
            m_flatProvenance.addProductCanonical(leftMapping.m_termsForEqsInParent[i].getComponent()
                    .getClosureProvenance(leftMapping.m_termsForEqsInParent[i], rightMapping.m_termsForEqsInParent[i]));
        }
    }

    public boolean isSameAs(LocalMapping mapping) {
        for (int i = 0; i < m_termsForAncestors.length; ++i)
            if (m_termsForAncestors[i] != mapping.m_termsForAncestors[i])
                return false;
        return true;
    }

    public boolean equals(Object object) {
        LocalMapping mapping = (LocalMapping) object;
        return isSameAs(mapping);
    }

    public void computeHashCodeEq() {
        m_hashCodeEq = 0;

        for (int i = 0; i < m_termsForEqsInParent.length; ++i)
            m_hashCodeEq += m_hashCodeEq * 0x9e370001 + m_termsForEqsInParent[i].getComponent().getIndex();
    }

    public void computeHashCodeId() {
        m_hashCodeId = 0;
        for (int i = 0; i < m_termsForAncestors.length; ++i)
            m_hashCodeId += m_hashCodeId * 0x9e370001 + m_termsForAncestors[i].getIndex();
    }

    public void makeResolvedTermsForEqs(int[] equalities) {
        m_termsForEqsInParent = new ResolvedTerm[equalities.length];
        for (int i = 0; i < equalities.length; ++i)
            m_termsForEqsInParent[i] = m_termsForAncestors[equalities[i]];
    }

    public String toString() {
        String str = "terms useful for upper levels\n";
        for (int i = 0; i < m_termsForAncestors.length; ++i)
            str += m_termsForAncestors[i];
        return str;
    }

}
