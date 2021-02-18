package hadad.backchase.constraints;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import hadad.backchase.Utils.Parser;
import hadad.backchase.atoms.AtomPositionTerm;
import hadad.backchase.atoms.DefEquality;
import hadad.backchase.atoms.DefRelAtom;
import hadad.backchase.atoms.PremiseDefinition;
import hadad.backchase.atoms.ResolvedEquality;
import hadad.backchase.instance.ChasedInstance;
import hadad.backchase.instance.LocalMapping;
import hadad.backchase.instance.Utilities;
import hadad.backchase.nodes.AdaptiveMappingsIndex;
import hadad.backchase.nodes.Node;
import hadad.backchase.provenanace.flatProvenance.FlatFormula;
import hadad.backchase.provenanace.placeHodlerProvenance.PHFormula;
import hadad.backchase.provenanace.provenanaceEvents.ProvChangedOnEquality;

/**
 * EGD
 *
 */
public class Egd extends Node {
    private final static Logger LOGGER = Logger.getLogger(Egd.class);

    private PremiseDefinition premDef;
    private List<DefEquality> conclusions;
    private Map<LocalMapping, ArrayList<ResolvedEquality>> matchedPremiseMappings;
    private LinkedList<LocalMapping> newPremiseMappings;
    private AdaptiveMappingsIndex joinMappingsId;

    /**
     * Constructor
     */
    public Egd() {
        super();
        premDef = new PremiseDefinition();
        conclusions = new ArrayList<DefEquality>();
        matchedPremiseMappings = new HashMap<LocalMapping, ArrayList<ResolvedEquality>>();
        newPremiseMappings = new LinkedList<LocalMapping>();
        joinMappingsId = new AdaptiveMappingsIndex(10);
    }

    /**
     * Get index from premise
     * 
     * @param term
     *            the term position
     * @param termsNeededUpper
     *            the atom position terms
     * @return the term index
     */
    private int getIndexFromPremise(final AtomPositionTerm term, final List<AtomPositionTerm> termsNeededUpper) {
        int index = 0;
        for (index = 0; index < termsNeededUpper.size(); ++index)
            if (termsNeededUpper.get(index) == term)
                return index;
        termsNeededUpper.add(term);
        return index;
    }

    /**
     * Re-adjust provenance equality
     * 
     * @param eq
     *            the ResolvedEquality
     * @param phprov
     *            the PHFormula
     * @param flatprov
     *            the flatprov
     */
    public void readjustProvenanceOnEquality(final ResolvedEquality eq, final PHFormula phprov,
            final FlatFormula flatprov) {
        eq.registerAsWatcher(phprov);
        eq.getPlaceHolderProvenance().addSum(phprov);
        boolean subsumed = eq.getFlatFormula().addSumCanonical(flatprov, false);
        if (!subsumed)
            ChasedInstance.zeInstance.addEvent(new ProvChangedOnEquality(eq));
    }

    /**
     * Re-adjust provenance equality
     * 
     * @param equalities
     *            the ResolvedEquality(s)
     * @param phprov
     *            the PHFormula
     * @param flatprov
     *            the FlatFormula
     */
    public void readjustProvenanceOnEqualities(final List<ResolvedEquality> equalities, final PHFormula phprov,
            FlatFormula flatprov) {
        for (int i = 0; i < equalities.size(); ++i)
            readjustProvenanceOnEquality(equalities.get(i), phprov, flatprov);
    }

    /**
     * Enforce the constraint
     * 
     * @return <code> True </code> if the constraint is enforced, otherwise <code> False</code>
     */
    public boolean enforce() {
        ChasedInstance.zeInstance.resetNeedsFlush();

        if (!hasNew)
            return false;
        while (hasNew)
            pushNew();

        if (ChasedInstance.zeInstance.m_needsFlush) {
            ChasedInstance.zeInstance.flushConstraints();
            ChasedInstance.zeInstance.rePushAtoms();
        }

        return true;
    }

    /**
     * Get resolved conclusion
     * 
     * @param premiseMapping
     *            the Local Mapping for the premise
     * @param conclusion
     *            the conclusion to be resolved
     * @return the resolved equality
     */
    private ResolvedEquality getResolvedConclusion(final LocalMapping premiseMapping, final DefEquality conclusion) {
        ResolvedEquality tr = new ResolvedEquality();
        tr.setTerm1(Utilities.getResolvedConclusionTerm(conclusion.getAtomPositionTerm1(), premiseMapping));
        tr.setTerm2(Utilities.getResolvedConclusionTerm(conclusion.getAtomPositionTerm2(), premiseMapping));
        return tr;
    }

    /**
     * Set new premise mappings
     * 
     * @param newPremiseMappings
     *            the new premise mappings to be added
     */
    public void setNewPremiseMappings(final LinkedList<LocalMapping> newPremiseMappings) {
        this.newPremiseMappings = newPremiseMappings;

    };

    /**
     * Set new join mappings
     * 
     * @param joinMappingsId
     *            the new join mappings to be added
     */
    public void setjoinMappingsId(final AdaptiveMappingsIndex joinMappingsId) {
        this.joinMappingsId = joinMappingsId;

    };

    /**
     * Get new premise mappings
     * 
     * @return newPremiseMappings
     */
    public LinkedList<LocalMapping> getNewPremiseMappings() {
        return newPremiseMappings;
    }

    /**
     * Get new join mappings id
     * 
     * @return joinMappingsId
     */
    public AdaptiveMappingsIndex getJoinMappingsId() {
        return joinMappingsId;
    }

    @Override
    public void computeNeededTerms(final List<AtomPositionTerm> termsNeededUpper) {
        for (int i = 0; i < conclusions.size(); ++i) {
            if (conclusions.get(i).getAtomPositionTerm1().getDefRelAtom() != null)
                conclusions.get(i).setTerm1(new AtomPositionTerm(null,
                        getIndexFromPremise(conclusions.get(i).getAtomPositionTerm1(), termsNeededUpper)));

            if (conclusions.get(i).getAtomPositionTerm2().getDefRelAtom() != null)
                conclusions.get(i).setTerm2(new AtomPositionTerm(null,
                        getIndexFromPremise(conclusions.get(i).getAtomPositionTerm2(), termsNeededUpper)));
        }

        premDef.getTopJoinNode().computeNeededTerms(termsNeededUpper);
    }

    @Override
    public void pushNew() {
        if (premDef.getTopJoinNode().hasNew) {
            premDef.getTopJoinNode().pushNew();
            hasNew = premDef.getTopJoinNode().hasNew;
        }
    }

    @Override
    public void refreshDummyMapping() {
    }

    @Override
    public void addNewLocalMapping(LocalMapping mapping, Object adder) {
        final List<ResolvedEquality> existingConclusions = matchedPremiseMappings.get(mapping);
        if (null != existingConclusions)
            readjustProvenanceOnEqualities(existingConclusions, mapping.m_placeHolderProvenance,
                    mapping.m_flatProvenance);
        else {
            ArrayList<ResolvedEquality> matchedConclusions = new ArrayList<ResolvedEquality>();
            for (int j = 0; j < conclusions.size(); ++j) {
                final ResolvedEquality resolved = getResolvedConclusion(mapping, conclusions.get(j));
                if (resolved.getTerm1() == resolved.getTerm2())
                    continue;
                resolved.setProvenance(mapping.m_flatProvenance, new PHFormula(mapping.m_placeHolderProvenance));
                final ResolvedEquality realMatch = resolved.getTerm1().getComponent().addPossiblyExisting(resolved);
                matchedConclusions.add(realMatch);
                if (realMatch == resolved)
                    resolved.registerAsWatcher(resolved.getPlaceHolderProvenance());
                else
                    readjustProvenanceOnEquality(realMatch, mapping.m_placeHolderProvenance, mapping.m_flatProvenance);

            }
            matchedPremiseMappings.put(mapping, matchedConclusions);
        }
    }

    @Override
    public void addExistingMappingAdditionalProvenance(final LocalMapping mapping, final PHFormula phform,
            final FlatFormula flatform, Object adder) {
        ArrayList<ResolvedEquality> existingConclusions = matchedPremiseMappings.get(mapping);
        readjustProvenanceOnEqualities(existingConclusions, mapping.m_placeHolderProvenance, mapping.m_flatProvenance);
    }

    @Override
    public boolean hasAtom(final DefRelAtom atom) {
        return false;
    }

    @Override
    public void registerAsWatcherOnRelations() {
        premDef.getTopJoinNode().registerAsWatcherOnRelations();
    }

    @Override
    public void flush() {
        premDef.getTopJoinNode().flush();
    }

    public void readFromFile(final BufferedReader br) throws Exception {
        premDef.readFromFile(br);
        premDef.getTopJoinNode().parent = this;

        Parser parser = new Parser();
        String line = br.readLine();
        parser.parseEqualities(line);

        ArrayList<String[]> equalities = parser.getEqualities();
        for (int i = 0; i < equalities.size(); ++i) {
            String[] crtParsedEquality = parser.getEqualities().get(i);
            DefEquality crtEquality = new DefEquality(premDef.getTermFromString(crtParsedEquality[0]),
                    premDef.getTermFromString(crtParsedEquality[1]));
            conclusions.add(crtEquality);
        }
    }

    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder();
        str.append(premDef);
        str.append("->");
        str.append(conclusions);
        return str.toString();
    }

}
