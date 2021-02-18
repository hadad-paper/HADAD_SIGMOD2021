package hadad.backchase.instance;

import hadad.backchase.atoms.AtomPositionTerm;
import hadad.backchase.atoms.ResolvedTerm;

public class Utilities {

    public static ResolvedTerm getResolvedConclusionTerm(AtomPositionTerm term, LocalMapping mapping) {
        if (-1 != term.getAttributeIndex())
            return mapping.m_termsForAncestors[term.getAttributeIndex()];
        else
            return term.getResolvedTerm();
    }
}
