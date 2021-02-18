package hadad.backchase.nodes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import hadad.backchase.atoms.PremiseDefinition;
import hadad.backchase.instance.LocalMapping;

public class AdaptiveMappingsIndex {

    private final static Logger LOGGER = Logger.getLogger(AdaptiveMappingsIndex.class);

    private int countBuckets;
    private int complementCountBits;
    private int moduloBitMask;
    private List<LinkedList<LocalMapping>> storage;

    /**
     * Constructor
     * 
     * @param countBits
     *            count bits
     */
    public AdaptiveMappingsIndex(int countBits) {
        complementCountBits = 32 - countBits;
        moduloBitMask = 0;
        for (int i = 0; i < countBits; ++i)
            moduloBitMask += 1 << i;
        countBuckets = 1 << countBits;
        storage = new ArrayList<LinkedList<LocalMapping>>(countBuckets);
        for (int i = 0; i < countBuckets; ++i)
            storage.add(null);
    }

    /**
     * Insert local mapping
     * 
     * @param mapping
     *            the mapping
     * @param key
     *            the key
     */
    private void insertLocal(LocalMapping mapping, int key) {
        int index = (key >> complementCountBits) & moduloBitMask;
        LinkedList<LocalMapping> crt = storage.get(index);
        if (null == crt) {
            crt = new LinkedList<LocalMapping>();
            storage.set(index, crt);
        }
        crt.add(mapping);
    }

    public void insert(LocalMapping mapping, int key) {
        insertLocal(mapping, key);
    }

    /**
     * Get matching
     * 
     * @param key
     *            the key of the mapping
     * @return the list of mapping
     */
    public List<LocalMapping> getMatching(int key) {
        return storage.get((key >> complementCountBits) & moduloBitMask);
    }

    /**
     * Flush storage
     */
    public void flush() {
        for (int i = 0; i < countBuckets; ++i)
            if (null != storage.get(i))
                storage.get(i).clear();
    }

    /**
     * Get and insert new mapping
     * 
     * @param mapping
     *            the mapping
     * @param key
     *            the key
     * @return the new local mapping
     */
    private LocalMapping getAndInsertLocal(LocalMapping mapping, int key) {
        int index = (key >> complementCountBits) & moduloBitMask;
        LinkedList<LocalMapping> crt = storage.get(index);
        if (null == crt) {
            crt = new LinkedList<LocalMapping>();
            storage.set(index, crt);
            crt.add(mapping);
            return null;
        }
        for (LocalMapping ex : crt)
            if (ex.isSameAs(mapping))
                return ex;
        crt.add(mapping);
        return null;
    }

    /**
     * Get and insert local mapping
     * 
     * @param mapping
     *            the mapping
     * @param key
     *            the key
     * @return new mapping
     */
    public LocalMapping getAndInsert(final LocalMapping mapping, int key) {
        return getAndInsertLocal(mapping, key);
    }
}
