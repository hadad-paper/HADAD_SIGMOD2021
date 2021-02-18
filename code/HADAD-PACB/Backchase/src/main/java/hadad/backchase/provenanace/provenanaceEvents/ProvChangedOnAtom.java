package hadad.backchase.provenanace.provenanaceEvents;

import org.apache.log4j.Logger;

import hadad.backchase.atoms.ResolvedEquality;
import hadad.backchase.atoms.ResolvedRelAtom;

public class ProvChangedOnAtom extends ProvenanceEvent {
    private final static Logger LOGGER = Logger.getLogger(ProvChangedOnAtom.class);

    private ResolvedRelAtom atom;

    /**
     * Constructor
     * 
     * @param atom
     */
    public ProvChangedOnAtom(ResolvedRelAtom atom) {
        this.atom = atom;
    }
    
    public void propagate() {
        for (ResolvedRelAtom atom : atom.getAtomWatchers())
            atom.provenanceChanged();
        for (ResolvedEquality eq : atom.getEqualityWatchers())
            eq.provenanceChanged();
    }
}
