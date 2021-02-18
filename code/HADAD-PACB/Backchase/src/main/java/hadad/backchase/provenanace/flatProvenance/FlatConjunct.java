package hadad.backchase.provenanace.flatProvenance;

import java.util.Arrays;
import org.apache.log4j.Logger;

import hadad.backchase.instance.ChasedInstance;
import hadad.backchase.provenanace.ProvenanceSymbol;

/**
 * A conjunct in a provenance formula
 *
 */
public class FlatConjunct {
    private final static Logger LOGGER = Logger.getLogger(FlatConjunct.class);

    private long[] symbolMask;
    private int cost;
    public static int m_countLongsProv = 1;

    /**
     * Constructor
     */
    public FlatConjunct() {
        symbolMask = new long[m_countLongsProv];
        cost = 0;
    }

    /**
     * Constructor
     * Creates a new FlatConjunct from the one passed as a parameter
     * 
     * @param other
     *            the FlatConjuct which is copied
     */
    public FlatConjunct(FlatConjunct other) {
        if (other == null)
            throw new IllegalArgumentException();
        symbolMask = Arrays.copyOf(other.symbolMask, other.symbolMask.length);
        cost = other.cost;
    }

    /**
     * Add provenance symbol
     * 
     * @param provenance
     *            symbol
     */
    public void addSymbol(final ProvenanceSymbol symbol) {
        int longplace = symbol.getProvenanceIndex() / 63;
        int longind = symbol.getProvenanceIndex() % 63;
        symbolMask[longplace] |= ((long) 1) << longind;
        cost++;
    }

    /**
     * Get FlatConjunct product
     * 
     * @param conj1
     *            the flat conjunct
     * @param conj2
     *            the flat conjunct
     * @return the new (product) flat conjunct
     */
    public static FlatConjunct getProduct(FlatConjunct conj1, FlatConjunct conj2) {
        FlatConjunct prod = new FlatConjunct();
        for (int i = 0; i < m_countLongsProv; ++i) {
            prod.symbolMask[i] = conj1.symbolMask[i] | conj2.symbolMask[i];

            for (int j = 0; j < 62; ++j)
                if ((prod.symbolMask[i] & (((long) 1) << j)) != 0)
                    prod.cost++;

        }
        return prod;
    }

    /**
     * Check if this conjunct is subsumed by other conjunct
     * 
     * @param other
     *            conjunct
     * @return <code> True</code> if this conjunct is subsumed by other conjunct, otherwise <code> False </code>
     */
    public boolean isSubsumedBy(final FlatConjunct other) {
        for (int k = 0; k < m_countLongsProv; ++k)
            if ((other.symbolMask[k] & symbolMask[k]) != other.symbolMask[k])
                return false;
        return true;
    }

    /**
     * Get conjunct cost
     * 
     * @return cost
     */
    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int k = 0; k < m_countLongsProv; ++k)
            for (int i = 0; i < 62; ++i)
                if ((symbolMask[k] & (((long) 1) << i)) != 0) {
                    str.append(ChasedInstance.zeInstance.m_provenanceSymbols.get(k * 63 + i).getProvenanceName());
                    str.append(',');
                }
        if (str.length() > 0) {
            str.deleteCharAt(str.length() - 1);
        }
        return str.toString();
    }
}
