package hadad.backchase.atoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import hadad.backchase.atoms.ResolvedRelAtom;
import hadad.backchase.nodes.LeafNode;

/**
 * Relation (instance)
 *
 */
public class Relation {
    private final static Logger LOGGER = Logger.getLogger(PremiseDefinition.class);

    private String name;
    private List<LeafNode> watchers;
    private Map<String, ResolvedRelAtom> atomsByKey;
    private List<ResolvedRelAtom> atoms;

    /**
     * Constructor
     * 
     * @param name
     *            relation name
     */
    public Relation(final String name) {
        this.name = name;
        atomsByKey = new HashMap<String, ResolvedRelAtom>();
        watchers = new ArrayList<LeafNode>();
        atoms = new ArrayList<ResolvedRelAtom>();
    }

    /**
     * Set watchers
     * 
     * @param watchers
     */
    public void setWatchers(final List<LeafNode> watchers) {
        this.watchers = watchers;
    }

    /**
     * Set atomsByKey
     * 
     * @param atomsByKey
     */
    public void setAtomsByKey(final Map<String, ResolvedRelAtom> atomsByKey) {
        this.atomsByKey = atomsByKey;
    }

    /**
     * Set resolved atoms
     * 
     * @param atoms
     */
    public void setResolvedAtoms(final List<ResolvedRelAtom> atoms) {
        this.atoms = atoms;
    }

    /**
     * Add watcher
     * 
     * @param watcher
     */
    public void addWatcher(LeafNode watcher) {
        watchers.add(watcher);
    }

    /**
     * Flush relation watchers
     */
    public void flushWatchers() {
        watchers.clear();
    }

    /**
     * Add fresh new atom
     * 
     * @param atom
     *            the ResolvedRelAtom
     */
    public void addFresh(final ResolvedRelAtom atom) {
        atom.computeKey();
        atomsByKey.put(atom.getKey(), atom);
        atoms.add(atom);

        for (int i = 0; i < watchers.size(); ++i)
            watchers.get(i).notifyHasNew();
    }

    /**
     * Add possibly existing resolvedRelAtom
     * 
     * @param atom
     *            the resolved atom
     * @return the resolved atom
     */
    public ResolvedRelAtom addPossiblyExisting(final ResolvedRelAtom atom) {
        atom.computeKey();
        final ResolvedRelAtom existing = atomsByKey.get(atom.getKey());
        if (null != existing)
            return existing;
        else {
            atoms.add(atom);
            atomsByKey.put(atom.getKey().toString(), atom);
            for (int i = 0; i < watchers.size(); ++i)
                watchers.get(i).notifyHasNew();
            return atom;
        }
    }

    /**
     * Get watchers
     * 
     * @return watchers
     */
    public List<LeafNode> getWatchers() {
        return watchers;
    }

    /**
     * Get atomsByKey
     * 
     * @return atomsByKey
     */
    public Map<String, ResolvedRelAtom> getAtomsByKey() {
        return atomsByKey;
    }

    /**
     * Get resolved atoms
     * 
     * @param atoms
     */
    public List<ResolvedRelAtom> getResolvedAtoms() {
        return atoms;
    }

    /**
     * Get name
     * 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Re-push All atoms
     */
    public void rePushAllAtoms() {
        for (int j = 0; j < watchers.size(); ++j)
            watchers.get(j).notifyHasNew();
    }

    public void displayContents() {
        for (int i = 0; i < atoms.size(); ++i)
            System.out.println(atoms.get(i));
    }

    @Override
    public String toString() {
        return name;
    }
}
