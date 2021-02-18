package hadad.backchase.provenanace.provenanaceEvents;

import hadad.backchase.atoms.ResolvedEquality;

public class ProvChangedOnEquality extends ProvenanceEvent {
    private ResolvedEquality equality;

    public ProvChangedOnEquality(ResolvedEquality eq) {
        equality = eq;
    }

    public void propagate() {
        equality.getTerm1().getComponent().provenanceChanged(equality);
    }
}
