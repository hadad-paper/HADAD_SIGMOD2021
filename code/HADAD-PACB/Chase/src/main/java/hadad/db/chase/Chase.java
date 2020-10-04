package hadad.db.chase;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import hadad.db.chaseexceptions.InconsistencyException;
import hadad.db.chaseexceptions.RedundancyException;

/**
 * This interface represents a chase engine which is associated with a
 * <code>CanonicalDB<code>.
 */
public class Chase {
    /** Logger */
    private final static Logger LOGGER = Logger.getLogger(Chase.class.getName());

    /** Assertions */
    private List<Assertion> assertions;
    /** Tuple generating constraints */
    private List<TupleGenConstraint> tgds;
    /** Equality generating constraints */
    private List<EqualityGenConstraint> egds;
    /** Denial constraints */
    private List<DenialConstraint> dgds;
    private boolean appliedDenial;

    /**
     * Constructor
     * 
     * @param tgds
     *            tuple generating constraints
     * @param egds
     *            equality generating constraints
     * @param dgds
     * @param assertions
     */
    public Chase(final List<TupleGenConstraint> tgds, final List<EqualityGenConstraint> egds,
            final List<DenialConstraint> dgds, final List<Assertion> assertions) {

        this.tgds = new ArrayList<TupleGenConstraint>(tgds);
        this.egds = new ArrayList<EqualityGenConstraint>(egds);
        this.dgds = new ArrayList<DenialConstraint>(dgds);
        this.assertions = new ArrayList<Assertion>(assertions);
    }

    /**
     * Sets the set of tuple and equality generating constraints, as well as
     * assertions, registered by the same and other sources. The implementation
     * should create a "base" canonical instance whenever the existing
     * constraints are set. After that, the chase engine will chase on the base
     * canonical instance with ALL constraints.
     *
     * @param constraints
     *            Constraints registered by the same and other sources.
     * @param equalityConstraints
     *            The <code>EqualityGenConstraint</code> objects
     * @param assertions
     *            The <code>Assertion</code> objects
     */
    public void setConstraints(List<TupleGenConstraint> tupleConstraints,
            List<EqualityGenConstraint> equalityConstraints, List<DenialConstraint> denailConstraints,
            List<Assertion> assertionConstraints) {

        tgds = new ArrayList<TupleGenConstraint>(tupleConstraints);
        egds = new ArrayList<EqualityGenConstraint>(equalityConstraints);
        dgds = new ArrayList<DenialConstraint>(denailConstraints);
        assertions = new ArrayList<Assertion>(assertionConstraints);
    }

    /**
     * Creates a <code>CanonicalDB</code> and chases it with the set of given
     * <code>Constraint</code> objects. (original)
     *
     * @return the <code>CanonicalDB</code> created
     * @throws RedundancyException
     *             when the given <code>Constraint</code> objects do not
     *             augment the <code>CanonicalDB</code>.
     * @throws InconsistencyException
     *             when the chase tries to equate two different constants.
     */
    public void run() throws InconsistencyException {
        for (int i = 0; i < assertions.size(); i++) {
            assertions.get(i).enforce();
        }
        boolean changed = true;
        boolean localChange;

        while (changed) {
            for (int i = 0; i < dgds.size(); i++) {
                DenialConstraint curDgd = dgds.get(i);
                localChange = curDgd.enforce();
                if (localChange) {
                    changed = false;
                    appliedDenial = true;
                    break;
                }
            }
            if (changed) {
                changed = false;
            }

        }

        if (!appliedDenial) {
            changed = true;
            while (changed) {
                changed = false;

                for (int i = 0; i < tgds.size(); i++) {
                    TupleGenConstraint curTgd = tgds.get(i);
                    localChange = curTgd.enforce();
                    changed = changed || localChange;
                }
            }
            changed = true;

            while (changed) {
                changed = false;

                for (int i = 0; i < tgds.size(); i++) {
                    TupleGenConstraint curTgd = tgds.get(i);
                    localChange = curTgd.enforce();
                    changed = changed || localChange;
                }
                for (int i = 0; i < dgds.size(); i++) {
                    DenialConstraint curDgd = dgds.get(i);
                    localChange = curDgd.enforce();
                    if (localChange) {
                        changed = false;
                        appliedDenial = true;
                        changed = changed || appliedDenial;
                        break;
                    }
                }
                for (int i = 0; i < egds.size(); i++) {
                    EqualityGenConstraint curEgd = egds.get(i);
                    localChange = curEgd.enforce();
                    if (localChange) {
                        for (int j = 0; j < tgds.size(); j++) {
                            tgds.get(j).flush();
                        }
                        for (int j = 0; j < egds.size(); j++) {

                            egds.get(j).flush();
                        }
                        for (int j = 0; j < dgds.size(); j++) {

                            dgds.get(j).flush();
                        }

                    }
                    changed = changed || localChange;
                }

            }
        }

    }

    /**
     * Creates a <code>CanonicalDB</code> and chases it with the set of given
     * <code>Constraint</code> objects. (alternative)
     *
     * @return the <code>CanonicalDB</code> created
     * @throws RedundancyException
     *             when the given <code>Constraint</code> objects do not
     *             augment the <code>CanonicalDB</code>.
     * @throws InconsistencyException
     *             when the chase tries to equate two different constants.
     */
    public void alternativeRun() throws InconsistencyException {
        for (int i = 0; i < assertions.size(); i++) {
            assertions.get(i).enforce();
        }
        boolean changed = true;
        boolean localChange;
        boolean localChangeEGD;

        while (changed) {
            for (int i = 0; i < dgds.size(); i++) {
                DenialConstraint curDgd = dgds.get(i);
                localChange = curDgd.enforce();
                if (localChange) {
                    changed = false;
                    appliedDenial = true;
                    break;
                }
            }
            if (changed) {
                changed = false;
            }

        }
        if (!appliedDenial) {
            changed = true;
            while (changed) {
                changed = false;

                for (int i = 0; i < tgds.size(); i++) {
                    final TupleGenConstraint curTgd = tgds.get(i);
                    localChange = curTgd.enforce();
                    changed = changed || localChange;

                    for (int j = 0; j < egds.size(); j++) {
                        final EqualityGenConstraint curEgd = egds.get(j);
                        localChangeEGD = curEgd.enforce();
                        if (localChangeEGD) {
                            for (int tgdCount = 0; tgdCount < tgds.size(); tgdCount++) {
                                tgds.get(tgdCount).flush();
                            }
                            for (int egdCount = 0; egdCount < egds.size(); egdCount++) {
                                egds.get(egdCount).flush();
                            }
                            for (int dgdCount = 0; dgdCount < dgds.size(); dgdCount++) {
                                dgds.get(dgdCount).flush();
                            }

                        }
                        changed = changed || localChangeEGD;
                    }

                }
                for (int i = 0; i < dgds.size(); i++) {
                    final DenialConstraint curDgd = dgds.get(i);
                    localChange = curDgd.enforce();
                    if (localChange) {
                        changed = false;
                        appliedDenial = true;
                        changed = changed || appliedDenial;
                        break;
                    }
                }

            }
        }
    }

    /**
     * Checks if denial constraints are applied or not
     * 
     * @return <code> True </code> if at least of one the denial constraints are applied and
     *         <code> False </code> if non of the denial constraints are applied
     */
    public boolean getAppliedDenial() {
        return appliedDenial;
    }

}
