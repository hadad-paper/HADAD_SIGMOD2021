/**
  * Copyright 2013, 2014 Ioana Ileana @ Telecom ParisTech 
  * This program is free software: you can redistribute it and/or modify
  * it under the terms of the GNU General Public License as published by
  * the Free Software Foundation, either version 3 of the License, or
  * (at your option) any later version.

  * This program is distributed in the hope that it will be useful,
  * but WITHOUT ANY WARRANTY; without even the implied warranty of
  * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  * GNU General Public License for more details.

  * You should have received a copy of the GNU General Public License
  * along with this program.  If not, see <http://www.gnu.org/licenses/>.
**/

package hadad.backchase.constraints;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hadad.backchase.Utils.Parser;
import hadad.backchase.atoms.AtomPositionTerm;
import hadad.backchase.atoms.DefRelAtom;
import hadad.backchase.atoms.PremiseDefinition;
import hadad.backchase.atoms.ResolvedRelAtom;
import hadad.backchase.atoms.ResolvedTerm;
import hadad.backchase.Utils.CostType;
import hadad.backchase.Utils.CostingManager;
import hadad.backchase.Utils.PrunedCosting;
import hadad.backchase.instance.ChasedInstance;
import hadad.backchase.instance.LocalMapping;
import hadad.backchase.instance.Utilities;
import hadad.backchase.nodes.Node;
import hadad.backchase.provenanace.flatProvenance.FlatConjunct;
import hadad.backchase.provenanace.flatProvenance.FlatFormula;
import hadad.backchase.provenanace.placeHodlerProvenance.PHFormula;
import hadad.backchase.provenanace.provenanaceEvents.ProvChangedOnAtom;

/**
 * TGD
 *
 */
public class Tgd extends Node {

    private PremiseDefinition premDef;
    private ArrayList<DefRelAtom> conclusions;
    public String type = "";
    private Map<LocalMapping, ArrayList<ResolvedRelAtom>> matchedPremiseMappings;
    private HashMap<String, Integer> skolemsByName;
    private int countSkolems;
    private ResolvedTerm[] resolvedSkolems;

    public Tgd() {
        super();
        premDef = new PremiseDefinition();
        conclusions = new ArrayList<DefRelAtom>();
        skolemsByName = new HashMap<String, Integer>();
        countSkolems = 0;
        resolvedSkolems = null;
        matchedPremiseMappings = new HashMap<LocalMapping, ArrayList<ResolvedRelAtom>>();

    }

    public boolean enforce() {
        if (!hasNew)
            return false;
        while (hasNew)
            pushNew();
        return true;

    }
    public PremiseDefinition getPref() {
        return premDef;
    }
    @Override
    public void pushNew() {
        if (premDef.getTopJoinNode().hasNew) {
            premDef.getTopJoinNode().pushNew();
            hasNew = premDef.getTopJoinNode().hasNew;
        }
    }

    public int getSkolemIndex(String strSkolem) {
        Integer skindex = skolemsByName.get(strSkolem);
        if (null == skindex) {
            skindex = countSkolems;
            countSkolems++;
            skolemsByName.put(strSkolem, skindex);
        }
        return skindex;
    }

    private int getIndexFromPremise(AtomPositionTerm term, List<AtomPositionTerm> termsNeededUpper) {
        int index = 0;
        for (index = 0; index < termsNeededUpper.size(); ++index)
            if (termsNeededUpper.get(index) == term)
                return index;
        termsNeededUpper.add(term);
        return index;
    }

    private void makeFreshSkolems() {
        for (int i = 0; i < resolvedSkolems.length; ++i)
            resolvedSkolems[i] = ChasedInstance.zeInstance.createFreshSkolemSpecialTerm();
    }

    public void readjustProvenanceOnAtom(ResolvedRelAtom atom, PHFormula phprov, FlatFormula flatprov) {
        atom.registerAsWatcher(phprov);
        atom.getPlaceHolderProvenance().addSum(phprov);

        boolean subsumed = atom.getFlatFormula().addSumCanonical(flatprov, false);
        if (!subsumed)
            ChasedInstance.zeInstance.addEvent(new ProvChangedOnAtom(atom));
    }

    public void readjustProvenanceOnAtoms(List<ResolvedRelAtom> atoms, PHFormula phprov, FlatFormula flatprov) {
        for (int i = 0; i < atoms.size(); ++i)
            readjustProvenanceOnAtom(atoms.get(i), phprov, flatprov);
    }

    private ResolvedRelAtom getResolvedConclusion(LocalMapping premiseMapping, DefRelAtom conclusion) {
        ResolvedRelAtom tr = new ResolvedRelAtom(conclusion.getRelation(), conclusion.getAtomPositionTerms().length);
        for (int i = 0; i < tr.getResolvedTerms().length; ++i) {
            tr.getResolvedTerms()[i] =
                    Utilities.getResolvedConclusionTerm(conclusion.getAtomPositionTerms()[i], premiseMapping);
            if (null == tr.getResolvedTerms()[i]) //this is a skolem
                tr.getResolvedTerms()[i] = resolvedSkolems[conclusion.getAtomPositionTerms()[i].getSkolemIndex()];
        }
        return tr;
    }

    @Override
    public void computeNeededTerms(List<AtomPositionTerm> termsNeededUpper) {
        for (int i = 0; i < conclusions.size(); ++i)
            for (int k = 0; k < conclusions.get(i).getAtomPositionTerms().length; k++) {
                AtomPositionTerm term = conclusions.get(i).getAtomPositionTerms()[k];
                if (term.getDefRelAtom() == null) //constant or skolem
                    continue;
                conclusions.get(i).getAtomPositionTerms()[k] = new AtomPositionTerm(term.getDefRelAtom(),
                        getIndexFromPremise(conclusions.get(i).getAtomPositionTerms()[k], termsNeededUpper));
            }
        premDef.getTopJoinNode().computeNeededTerms(termsNeededUpper);
    }

    @Override
    public boolean hasAtom(DefRelAtom atom) {
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

    @Override
    public void addNewLocalMapping(LocalMapping mapping, Object adder) {

        if (CostingManager.ENABLE_COSTING) {
            if (!type.equals("query")) {
                final FlatFormula prunedProvnance = new FlatFormula();
                final List<FlatConjunct> provConjust = mapping.m_flatProvenance.getConjuncts();

                if (CostingManager.COSTING_TYPE.equals(CostType.PRUNED_COSTING)) {
                    for (final FlatConjunct flatConjunct : provConjust) {
                        if (PrunedCosting.getSubQueryCost(flatConjunct) <= PrunedCosting.threshHold) {
                            prunedProvnance.addFlatConjunct(flatConjunct);
                        }
                    }
                    if (!prunedProvnance.getConjuncts().isEmpty()) {
                        mapping.updateFlatFormula(prunedProvnance);
                        ArrayList<ResolvedRelAtom> existingConclusions = matchedPremiseMappings.get(mapping);
                        if (existingConclusions != null)
                            readjustProvenanceOnAtoms(existingConclusions, mapping.m_placeHolderProvenance,
                                    mapping.m_flatProvenance);
                        else {
                            makeFreshSkolems();
                            ArrayList<ResolvedRelAtom> matchedConclusions = new ArrayList<ResolvedRelAtom>();
                            for (int j = 0; j < conclusions.size(); ++j) {
                                ResolvedRelAtom resolved = getResolvedConclusion(mapping, conclusions.get(j));
                                resolved.setProvenance(mapping.m_flatProvenance,
                                        new PHFormula(mapping.m_placeHolderProvenance));
                                ResolvedRelAtom realMatch = resolved.getRelation().addPossiblyExisting(resolved);
                                matchedConclusions.add(realMatch);

                                if (realMatch == resolved)
                                    resolved.registerAsWatcher(resolved.getPlaceHolderProvenance());
                                else
                                    readjustProvenanceOnAtom(realMatch, mapping.m_placeHolderProvenance,
                                            mapping.m_flatProvenance);

                            }
                            matchedPremiseMappings.put(mapping, matchedConclusions);
                        }
                        ChasedInstance.zeInstance.m_query.enforce();
                        if (ChasedInstance.zeInstance.m_query.getProvenance() != null) {
                            PrunedCosting
                                    .findMinRewriting(ChasedInstance.zeInstance.m_query.getProvenance().getConjuncts());
                        }
                    }
                } else {
                    List<ResolvedRelAtom> existingConclusions = matchedPremiseMappings.get(mapping);
                    if (null != existingConclusions)
                        readjustProvenanceOnAtoms(existingConclusions, mapping.m_placeHolderProvenance,
                                mapping.m_flatProvenance);
                    else {

                        makeFreshSkolems();

                        ArrayList<ResolvedRelAtom> matchedConclusions = new ArrayList<ResolvedRelAtom>();
                        for (int j = 0; j < conclusions.size(); ++j) {
                            ResolvedRelAtom resolved = getResolvedConclusion(mapping, conclusions.get(j));
                            resolved.setProvenance(mapping.m_flatProvenance,
                                    new PHFormula(mapping.m_placeHolderProvenance));
                            ResolvedRelAtom realMatch = resolved.getRelation().addPossiblyExisting(resolved);
                            matchedConclusions.add(realMatch);

                            if (realMatch == resolved)
                                resolved.registerAsWatcher(resolved.getPlaceHolderProvenance());
                            else
                                readjustProvenanceOnAtom(realMatch, mapping.m_placeHolderProvenance,
                                        mapping.m_flatProvenance);

                        }
                        matchedPremiseMappings.put(mapping, matchedConclusions);
                    }
                }
            } else {

                List<ResolvedRelAtom> existingConclusions = matchedPremiseMappings.get(mapping);
                if (null != existingConclusions)
                    readjustProvenanceOnAtoms(existingConclusions, mapping.m_placeHolderProvenance,
                            mapping.m_flatProvenance);
                else {

                    makeFreshSkolems();

                    ArrayList<ResolvedRelAtom> matchedConclusions = new ArrayList<ResolvedRelAtom>();
                    for (int j = 0; j < conclusions.size(); ++j) {
                        ResolvedRelAtom resolved = getResolvedConclusion(mapping, conclusions.get(j));
                        resolved.setProvenance(mapping.m_flatProvenance,
                                new PHFormula(mapping.m_placeHolderProvenance));
                        ResolvedRelAtom realMatch = resolved.getRelation().addPossiblyExisting(resolved);
                        matchedConclusions.add(realMatch);

                        if (realMatch == resolved)
                            resolved.registerAsWatcher(resolved.getPlaceHolderProvenance());
                        else
                            readjustProvenanceOnAtom(realMatch, mapping.m_placeHolderProvenance,
                                    mapping.m_flatProvenance);

                    }
                    matchedPremiseMappings.put(mapping, matchedConclusions);
                }
            }
        } else {
            ArrayList<ResolvedRelAtom> existingConclusions = matchedPremiseMappings.get(mapping);
            if (null != existingConclusions) //this has already been treated, we need to update provenance
                readjustProvenanceOnAtoms(existingConclusions, mapping.m_placeHolderProvenance,
                        mapping.m_flatProvenance);
            else {

                makeFreshSkolems();

                ArrayList<ResolvedRelAtom> matchedConclusions = new ArrayList<ResolvedRelAtom>();
                for (int j = 0; j < conclusions.size(); ++j) {
                    ResolvedRelAtom resolved = getResolvedConclusion(mapping, conclusions.get(j));
                    resolved.setProvenance(mapping.m_flatProvenance, new PHFormula(mapping.m_placeHolderProvenance));
                    ResolvedRelAtom realMatch = resolved.getRelation().addPossiblyExisting(resolved);
                    matchedConclusions.add(realMatch);

                    if (realMatch == resolved)//we added a new atom 
                        resolved.registerAsWatcher(resolved.getPlaceHolderProvenance());
                    else
                        readjustProvenanceOnAtom(realMatch, mapping.m_placeHolderProvenance, mapping.m_flatProvenance);

                }
                matchedPremiseMappings.put(mapping, matchedConclusions);
            }
        }
    }

    @Override
    public void addExistingMappingAdditionalProvenance(LocalMapping mapping, PHFormula phform, FlatFormula flatform,
            Object adder) {
        ArrayList<ResolvedRelAtom> existingConclusions = matchedPremiseMappings.get(mapping);
        readjustProvenanceOnAtoms(existingConclusions, mapping.m_placeHolderProvenance, mapping.m_flatProvenance);
    }

    @Override
    public void refreshDummyMapping() {
    }

    public void readFromFile(BufferedReader br) throws Exception {
        premDef.readFromFile(br);
        premDef.getTopJoinNode().parent = this;
        Parser parser = new Parser();
        String line = br.readLine();
        parser.parseRelationals(line);
        ArrayList<ArrayList<String>> parsedRelationals = parser.getRelationals();
        for (int i = 0; i < parsedRelationals.size(); ++i) {
            ArrayList<String> crtParsedRelational = parsedRelationals.get(i);
            DefRelAtom conclusion =
                    new DefRelAtom(ChasedInstance.zeInstance.getRelationByName(crtParsedRelational.get(0)),
                            crtParsedRelational.size() - 1);
            for (int j = 0; j < crtParsedRelational.size() - 1; j++) {
                String strTerm = crtParsedRelational.get(j + 1);
                conclusion.getAtomPositionTerms()[j] = premDef.getTermFromString(strTerm);
                if (conclusion.getAtomPositionTerms()[j] == null) {
                    conclusion.getAtomPositionTerms()[j] = new AtomPositionTerm(null, -1);
                    conclusion.getAtomPositionTerms()[j].setSkolemIndex(getSkolemIndex(crtParsedRelational.get(j + 1)));
                }
            }
            conclusions.add(conclusion);
        }
        resolvedSkolems = new ResolvedTerm[countSkolems];
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
