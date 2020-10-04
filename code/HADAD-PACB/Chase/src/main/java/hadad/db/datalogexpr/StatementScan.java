package hadad.db.datalogexpr;

import hadad.db.canonicaldb.CanonicalSchema;

/**
 * The scan operator
 */
public class StatementScan extends StatementOp {

    /**
     * The <code>Predicate</code> in the query body that
     * corresponds to this Scan operator
     */
    private Predicate pred;

    public StatementScan(Predicate _pred) {
        pred = _pred;
    }

    protected void setAllAttribsUpToThisLevel() {
        Value val;

        allAttribsUpToThisLevel = new CanonicalSchema();

        for (int k = 0; k < pred.size(); k++) {
            val = pred.variableI(k);
            if (!val.isAnyConstant()) {
                allAttribsUpToThisLevel.addColumnName(val.getValueStr());
            }
        }
    }

    protected void setRequiredAttribsByThisLevel() {
        requiredAttribsByThisLevel = new CanonicalSchema();
    }

    public Predicate getPredicate() {
        return pred;
    }

    public String toString() {
        return pred.toString();
    }
}
