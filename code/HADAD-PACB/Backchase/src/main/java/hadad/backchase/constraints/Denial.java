package hadad.backchase.constraints;

import java.io.BufferedReader;
import java.util.List;

import hadad.backchase.Utils.Parser;
import hadad.backchase.atoms.AtomPositionTerm;
import hadad.backchase.atoms.DefRelAtom;
import hadad.backchase.atoms.PremiseDefinition;
import hadad.backchase.instance.LocalMapping;
import hadad.backchase.nodes.Node;
import hadad.backchase.provenanace.flatProvenance.FlatFormula;
import hadad.backchase.provenanace.placeHodlerProvenance.PHFormula;

/**
 * Denial constraint
 * 
 */
public class Denial extends Node {
    
    
    private PremiseDefinition premDef;
    private boolean applied;

    public Denial() {
        super();
        premDef = new PremiseDefinition();
        applied = false;

    }

    public boolean enforce() {
        if (!hasNew)
            return false;
        while (hasNew)
            pushNew();
        return true;

    }

    @Override
    public void computeNeededTerms(List<AtomPositionTerm> termsNeededUpper) {

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
        applied = true;
    }

    @Override
    public void addExistingMappingAdditionalProvenance(LocalMapping mapping, PHFormula phform, FlatFormula flatform,
            Object adder) {
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

    public void readFromFile(BufferedReader br) throws Exception {
        premDef.readFromFile(br);
        premDef.getTopJoinNode().parent = this;
        Parser parser = new Parser();
        String line = br.readLine();
        parser.parseRelationals(line);
    }

    public boolean getApplied() {
        return applied;
    }

    @Override
    public String toString() {
        final StringBuilder str = new StringBuilder();
        str.append(premDef);
        str.append("->");
        str.append("false");
        return str.toString();
    }

}
