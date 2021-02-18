package hadad.backchase.provenanace.provenanaceEvents;
import hadad.backchase.atoms.ResolvedEquality;
import hadad.backchase.atoms.ResolvedRelAtom;
import hadad.backchase.atoms.ResolvedTerm;


public class ProvChangedInComp extends ProvenanceEvent {
    
    private ResolvedTerm m_term;

    public ProvChangedInComp(ResolvedTerm term) {
        m_term = term;
    }

    public void propagate() {
        for (ResolvedRelAtom atom : m_term.getComponent().getAtomWatchers())
            atom.provenanceChanged();
        for (ResolvedEquality eq : m_term.getComponent().getEqualityWatchers())
            eq.provenanceChanged();
    }
}
