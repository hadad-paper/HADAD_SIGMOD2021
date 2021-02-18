package hadad.backchase.instance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import hadad.backchase.Utils.Parser;
import hadad.backchase.atoms.AtomPositionTerm;
import hadad.backchase.atoms.Relation;
import hadad.backchase.atoms.ResolvedRelAtom;
import hadad.backchase.atoms.ResolvedTerm;
import hadad.backchase.constraints.Denial;
import hadad.backchase.constraints.Egd;
import hadad.backchase.constraints.Tgd;
import hadad.backchase.Utils.CostingManager;
import hadad.backchase.Utils.NaiveCosting;
import hadad.backchase.Utils.PrunedCosting;
import hadad.backchase.provenanace.ProvenanceSymbol;
import hadad.backchase.provenanace.flatProvenance.FlatConjunct;
import hadad.backchase.provenanace.flatProvenance.FlatFormula;
import hadad.backchase.provenanace.placeHodlerProvenance.PHConjunct;
import hadad.backchase.provenanace.placeHodlerProvenance.PHFormula;
import hadad.backchase.provenanace.provenanaceEvents.ProvenanceEvent;
import hadad.commons.conjunctivequery.Atom;
import hadad.commons.conjunctivequery.ConjunctiveQuery;

public class ChasedInstance {
    private final static Logger LOGGER = Logger.getLogger(ChasedInstance.class);

    public static ChasedInstance zeInstance = new ChasedInstance();
    public int totalCost = 0;
    public int countSpecialTerms = 0;
    public int countProvenanceSymbols = 0;
    public int countConnectedComponents = 0;

    public HashMap<String, Relation> m_relationsByName;

    public HashMap<String, ResolvedTerm> m_specialTermsByName;
    public ArrayList<ResolvedTerm> m_specialTerms;

    public HashMap<String, ProvenanceSymbol> m_provenanceSymbolsByName;
    public ArrayList<ProvenanceSymbol> m_provenanceSymbols;

    public ArrayList<ConnectedComponent> m_connectedComponents;

    public ArrayList<Tgd> m_tgds;
    public ArrayList<Egd> m_egds;
    public ArrayList<Denial> m_denial;

    public Query m_query;

    public LinkedList<ProvenanceEvent> m_events;

    public boolean m_needsFlush;
    public boolean m_usePlaceHolders;

    private boolean denial_applied;

    public static void Restart() {
        zeInstance = new ChasedInstance();
    }

    public ChasedInstance() {
        m_relationsByName = new HashMap<String, Relation>();
        m_specialTermsByName = new HashMap<String, ResolvedTerm>();
        m_specialTerms = new ArrayList<ResolvedTerm>();
        m_provenanceSymbolsByName = new HashMap<String, ProvenanceSymbol>();
        m_provenanceSymbols = new ArrayList<ProvenanceSymbol>();

        m_connectedComponents = new ArrayList<ConnectedComponent>();

        m_tgds = new ArrayList<>();
        m_egds = new ArrayList<>();
        m_denial = new ArrayList<>();

        m_query = new Query();
        m_query.type = "query";

        m_events = new LinkedList<ProvenanceEvent>();

        m_needsFlush = false;
        m_usePlaceHolders = true;

        denial_applied = false;
    }

    public long readFromPABackChaseFile(final String fileName) throws Exception {
        long time = 0;

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line = br.readLine();
        int countSymbols = Integer.valueOf(line).intValue();
        FlatConjunct.m_countLongsProv = countSymbols / 64 + 1;

        //read query
        line = br.readLine();
        long startTime = System.currentTimeMillis();
        m_query.readFromFile(br);
        m_query.computeNeededTerms(new ArrayList<AtomPositionTerm>());
        m_query.registerAsWatcherOnRelations();
        time += System.currentTimeMillis() - startTime;

        line = br.readLine();
        line = br.readLine();
        int countConstraints = Integer.valueOf(line).intValue();

        //read constraints
        for (int i = 0; i < countConstraints; ++i) {
            line = br.readLine();
            if (line.equals("TGD")) //read TGD
            {
                Tgd crtTgd = new Tgd();
                crtTgd.readFromFile(br);
                crtTgd.computeNeededTerms(new ArrayList<AtomPositionTerm>());
                crtTgd.registerAsWatcherOnRelations();
                m_tgds.add(crtTgd);
            } else {
                if (line.equals("EGD")) {
                    Egd crtEgd = new Egd();
                    crtEgd.readFromFile(br);
                    crtEgd.computeNeededTerms(new ArrayList<AtomPositionTerm>());
                    crtEgd.registerAsWatcherOnRelations();
                    m_egds.add(crtEgd);
                } else {
                    Denial crtEgd = new Denial();
                    crtEgd.readFromFile(br);
                    crtEgd.computeNeededTerms(new ArrayList<AtomPositionTerm>());
                    crtEgd.registerAsWatcherOnRelations();
                    m_denial.add(crtEgd);
                }
            }

        }

        //read instance
        Parser parser = new Parser();
        line = br.readLine();
        startTime = System.currentTimeMillis();
        while (true) {
            line = br.readLine();
            if (null == line) {
                break;
            }
            parser.flush();

            ArrayList<String> atom = parser.parseAtom(line);
            if (null == atom) {
                break;
            }
            Relation crtRelation = getRelationByName(atom.get(0));
            ResolvedRelAtom crtAtom = new ResolvedRelAtom(crtRelation, atom.size() - 1);

            for (int j = 0; j < atom.size() - 1; ++j) {
                crtAtom.getResolvedTerms()[j] = getSpecialTermByName(atom.get(j + 1));
            }

            ArrayList<String> provenance = parser.parseProvenance(line);
            PHConjunct bla = new PHConjunct();
            bla.addAtom(crtAtom);

            crtAtom.setProvenance(getFlatFormula(provenance), new PHFormula(bla));

            crtRelation.addFresh(crtAtom);
        }
        br.close();
        time += System.currentTimeMillis() - startTime;
        return time;
    }

    public long PABackChase() {

        long startTime = System.currentTimeMillis();
        boolean changed = false;
        do {
            changed = false;
            for (Tgd tgd : m_tgds) {
                boolean enforced = tgd.enforce();
                changed = changed || enforced;
            }
            for (Denial denial : m_denial) {
                boolean enforced = denial.enforce();
                if (denial.getApplied()) {
                    denial_applied = true;
                    break;
                }
                changed = changed || enforced;
            }
            for (Egd egd : m_egds) {
                boolean enforced = egd.enforce();
                changed = changed || enforced;
            }
        } while (changed && !denial_applied);
        treatEvents();
        return System.currentTimeMillis() - startTime;
    }
    
    public long PABackChaseCost() {

        long startTime = System.currentTimeMillis();
        boolean changed = false;
        do {
            changed = false;
            for (Tgd tgd : m_tgds) {
                boolean enforced = tgd.enforce();
                changed = changed || enforced;
                for (Egd egd : m_egds) {
                    boolean enforcedEDG = egd.enforce();
                    changed = changed || enforcedEDG;
                }
            }
            
        } while (changed && !denial_applied);
        treatEvents();
        return System.currentTimeMillis() - startTime;
    }

    /**
     * Compute rewriting with naive approach costing
     * 
     * @param filename
     * @param uPlan
     *            universal plan
     * @param query
     *            original query
     * @return timed rewritings
     * @throws Exception
     */
    public Map<Long, List<ConjunctiveQuery>> computeRewritingsNaive(final String filename, final ConjunctiveQuery uPlan,
            final ConjunctiveQuery query) throws Exception {
        final Map<Long, List<ConjunctiveQuery>> timedRewritings = new HashMap<>();
        readFromPABackChaseFile(filename);
        long start = System.currentTimeMillis();
        PABackChase();
        if (!denial_applied) {
            removeWatchers();
            flushConstraints();
            m_query.computeNeededTerms(new ArrayList<AtomPositionTerm>());
            m_query.registerAsWatcherOnRelations();
            m_usePlaceHolders = false;
            rePushAtoms();
            m_query.enforce();
            final List<ConjunctiveQuery> rewritings = new ArrayList<>();

            if (m_query.getProvenance() == null) {
                return timedRewritings;
            } else {
                final NaiveCosting naiveCosting = new NaiveCosting(m_query.getProvenance().getConjuncts(), uPlan, query,
                        CostingManager.COST_FUNCTION);
                rewritings.add(naiveCosting.findMinCostRewriting());
            }
            long finish = System.currentTimeMillis();
            long paChaseTime = finish - start;
            //LOGGER.debug("BackChase Time: " + paChaseTime);
            timedRewritings.put(paChaseTime, rewritings);
        }
        return timedRewritings;
    }

    /**
     * Compute rewriting with pruned costing approach
     * 
     * @param filename
     * @param uPlan
     *            universal plan
     * @param query
     *            original query
     * @return timed rewritings
     * @throws Exception
     */
    public Map<Long, List<ConjunctiveQuery>> computeRewritingsPruned(final String filename,
            final ConjunctiveQuery uPlan, final ConjunctiveQuery query) throws Exception {
        final Map<Long, List<ConjunctiveQuery>> timedRewritings = new HashMap<>();

        PrunedCosting.costFunction = CostingManager.COST_FUNCTION;
        PrunedCosting.uPlan = uPlan;
        PrunedCosting.threshHold = PrunedCosting.getQueryCost(query);

        readFromPABackChaseFile(filename);
        long start = System.currentTimeMillis();
        PABackChase();
        if (!denial_applied) {
            final List<ConjunctiveQuery> rewritings = new ArrayList<>();
            if (m_query.getProvenance() == null) {
                return timedRewritings;
            } else {
                rewritings.add(PrunedCosting.minRewriting);
            }
            long finish = System.currentTimeMillis();
            long paChaseTime = finish - start;
            //LOGGER.debug("BackChase Time: " + paChaseTime);
            timedRewritings.put(paChaseTime, rewritings);
        }
        return timedRewritings;
    }

    /**
     * Compute rewriting with no costing
     * 
     * @param filename
     *            pre-processing back-chase
     * @param uPlan
     *            universal plan
     * @return return rewritings if exists
     * @throws Exception
     */
    public Map<Long, List<ConjunctiveQuery>> computeRewritings(final String filename, final ConjunctiveQuery uPlan)
            throws Exception {
        final Map<Long, List<ConjunctiveQuery>> timedRewritings = new HashMap<>();
        readFromPABackChaseFile(filename);
        long start = System.currentTimeMillis();
        //PABackChaseCost();
        PABackChase();
        if (!denial_applied) {
            removeWatchers();
            flushConstraints();
            m_query.computeNeededTerms(new ArrayList<AtomPositionTerm>());
            m_query.registerAsWatcherOnRelations();
            m_usePlaceHolders = false;
            rePushAtoms();
            m_query.enforce();
            final List<ConjunctiveQuery> rewritings = new ArrayList<>();

            if (m_query.getProvenance() == null) {
                return timedRewritings;
            } else {
                final List<FlatConjunct> rewritingConjuncts = m_query.getProvenance().getConjuncts();
                ArrayList<Atom> uplanAtoms = new ArrayList<Atom>();
                for (Atom tmp : uPlan.getBody())
                    uplanAtoms.add(tmp);
                for (int i = 0; i < rewritingConjuncts.size(); ++i) {
                    ArrayList<Atom> rwAtoms = new ArrayList<Atom>();
                    String conjStr = rewritingConjuncts.get(i).toString();
                    String[] symbols = conjStr.split(",");
                    for (int j = 0; j < symbols.length; ++j)
                        if (symbols[j].substring(0, 1).equals("p")) {
                            int index = Integer.parseInt(symbols[j].substring(1));
                            rwAtoms.add(uplanAtoms.get(index));
                        }
                    ConjunctiveQuery rw = new ConjunctiveQuery("RW" + String.valueOf(i), uPlan.getHead(), rwAtoms);
                    rewritings.add(rw);
                }

            }
            long finish = System.currentTimeMillis();
            long paChaseTime = finish - start;
            //LOGGER.debug("PA-Chase Time: " + paChaseTime);
            timedRewritings.put(paChaseTime, rewritings);
        }
        return timedRewritings;
    }

    public void resetNeedsFlush() {
        m_needsFlush = false;
    }

    public void setNeedsFlush() {
        m_needsFlush = true;
    }

    public Relation getRelationByName(String s) {
        Relation r = m_relationsByName.get(s);
        if (null == r) {
            r = new Relation(s);
            m_relationsByName.put(s, r);
        }
        return r;
    }

    public ResolvedTerm getSpecialTermByName(String s) {
        ResolvedTerm t = m_specialTermsByName.get(s);
        if (null == t) {
            t = createFreshSpecialTerm(s);
            m_specialTermsByName.put(s, t);
        }
        return t;
    }

    private ResolvedTerm createFreshSpecialTerm(String s) {
        ResolvedTerm t = new ResolvedTerm(s, countSpecialTerms);
        m_specialTerms.add(t);
        countSpecialTerms++;
        return t;
    }

    public ResolvedTerm createFreshSkolemSpecialTerm() {
        return createFreshSpecialTerm("sk" + countSpecialTerms);
    }

    public ProvenanceSymbol getProvenanceSymbolByName(String name) {
        ProvenanceSymbol symbol = m_provenanceSymbolsByName.get(name);
        if (null == symbol) {
            symbol = new ProvenanceSymbol(name, countProvenanceSymbols);
            m_provenanceSymbols.add(symbol);
            countProvenanceSymbols++;
            m_provenanceSymbolsByName.put(name, symbol);
        }
        return symbol;
    }

    public FlatFormula getFlatFormula(ArrayList<String> symbols) {
        FlatConjunct conjunct = new FlatConjunct();

        for (int i = 0; i < symbols.size(); ++i) {
            if (!symbols.get(i).equals("none")) {
                conjunct.addSymbol(getProvenanceSymbolByName(symbols.get(i)));
            }
        }
        return new FlatFormula(conjunct);
    }

    public void addConnectedComponent(ConnectedComponent comp) {
        m_connectedComponents.add(comp);
    }

    public void addEvent(ProvenanceEvent event) {
        m_events.add(event);
    }

    public void treatEvents() {
        while (m_events.size() != 0) {
            ProvenanceEvent event = m_events.removeFirst();
            event.propagate();
        }
    }

    public void flushConstraints() {
        for (int i = 0; i < m_tgds.size(); ++i) {
            m_tgds.get(i).flush();
        }

        for (int i = 0; i < m_egds.size(); ++i) {
            m_egds.get(i).flush();
        }
        m_query.flush();
    }

    public void removeWatchers() {
        for (String name : m_relationsByName.keySet()) {
            Relation rel = m_relationsByName.get(name);
            rel.flushWatchers();
        }
    }

    public void rePushAtoms() {
        for (String name : m_relationsByName.keySet()) {
            Relation rel = m_relationsByName.get(name);
            if (rel.getResolvedAtoms().size() != 0) {
                rel.rePushAllAtoms();
            }
        }
    }

    public void display() {
        for (String name : m_relationsByName.keySet()) {
            Relation rel = m_relationsByName.get(name);
            rel.displayContents();
        }

        for (int i = 0; i < m_connectedComponents.size(); ++i) {
            m_connectedComponents.get(i).displayContents();
        }
    }

    public int getTotalCost() {
        return totalCost;
    }

}
