package hadad.backchase.nodes;

import hadad.backchase.atoms.AtomPositionTerm;
import hadad.backchase.atoms.DefEquality;
import hadad.backchase.atoms.DefRelAtom;
import hadad.backchase.atoms.ResolvedTerm;
import hadad.backchase.instance.LocalMapping;
import hadad.backchase.provenanace.flatProvenance.FlatFormula;
import hadad.backchase.provenanace.placeHodlerProvenance.PHFormula;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

public abstract class Node {
    private final static Logger LOGGER = Logger.getLogger(Node.class);

    public Node parent;
    public List<DefEquality> defEqualities;

    public boolean hasNew;
    public boolean[] comesFromLeft;
    public int[] indices;

    public int[] eqsLeft;
    public int[] eqsRight;

    public LocalMapping dummyMapping;

    public int id;
    public static int countNodes = 0;

    public int depth;

    public Node() {
        parent = null;
        defEqualities = new ArrayList<DefEquality>();
        hasNew = false;
        id = countNodes;
        countNodes++;
    }

    public abstract boolean hasAtom(final DefRelAtom atom);

    public abstract void computeNeededTerms(final List<AtomPositionTerm> termsNeededUpper);

    public abstract void addNewLocalMapping(final LocalMapping mapping, final Object adder);

    public abstract void addExistingMappingAdditionalProvenance(final LocalMapping mapping, final PHFormula phform,
            final FlatFormula provform, final Object adder);

    public abstract void registerAsWatcherOnRelations();

    public abstract void flush();

    public abstract void refreshDummyMapping();

    public abstract void pushNew();

    protected static boolean checkMatchingEqualities(final ResolvedTerm[] resTermsLeft,
            final ResolvedTerm[] resTermsRight) {
        for (int j = 0; j < resTermsLeft.length; ++j)
            if (resTermsLeft[j].getComponent() != resTermsRight[j].getComponent())
                return false;
        return true;
    }

    public void addDefEquality(final DefEquality atom) {
        defEqualities.add(atom);
    }

    public void notifyHasNew() {
        hasNew = true;
        if (null != parent)
            parent.notifyHasNew();
    }

    public void addAtomsToParent(final Set<DefRelAtom> atoms) {
        if (this instanceof LeafNode)
            atoms.add(((LeafNode) this).m_atom);
        else
            atoms.addAll(((InnerNode) this).getAtoms());
    }

    public String nodeAtoms() {
        if (this instanceof LeafNode)
            return ((LeafNode) this).m_atom.getRelation().getName();
        else {
            final StringBuilder str = new StringBuilder();
            for (DefRelAtom atom : ((InnerNode) this).getAtoms()) {
                str.append(atom.getRelation().getName());
                str.append(" ");
            }
            return str.toString();
        }
    }
}
