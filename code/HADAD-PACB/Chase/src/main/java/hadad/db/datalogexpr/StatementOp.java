package hadad.db.datalogexpr;

import java.util.Iterator;

import hadad.db.canonicaldb.CanonicalSchema;

/**
 * This class represents an operator in a <code>Statement</code>
 */
public abstract class StatementOp {
    protected StatementOp parent;

    CanonicalSchema allAttribsUpToThisLevel;
    CanonicalSchema requiredAttribsByThisLevel;
    CanonicalSchema requiredAttribsDownToThisLevel;

    public CanonicalSchema getAllAttribsUpToThisLevel() {
        if (allAttribsUpToThisLevel == null)
            setAllAttribsUpToThisLevel();

        return allAttribsUpToThisLevel;
    }

    public CanonicalSchema getRequiredAttribsDownToThisLevel() {
        if (requiredAttribsDownToThisLevel == null)
            setRequiredAttribsDownToThisLevel();

        return requiredAttribsDownToThisLevel;
    }

    public CanonicalSchema getRequiredAttribsByThisLevel() {
        if (requiredAttribsByThisLevel == null)
            setRequiredAttribsByThisLevel();

        return requiredAttribsByThisLevel;
    }

    public CanonicalSchema getOutputSchemaAfterProjection() {
        if (parent != null) {
            CanonicalSchema outputSchema = getAllAttribsUpToThisLevel();
            CanonicalSchema ancestorReqs = parent.getRequiredAttribsDownToThisLevel();
            return intersection(outputSchema, ancestorReqs);
        }

        return new CanonicalSchema();
    }

    public CanonicalSchema getAttribsToProjectOut() {
        if (parent != null) {
            CanonicalSchema ancestorReqs = parent.getRequiredAttribsDownToThisLevel();

            if (this instanceof StatementScan) {
                CanonicalSchema outputSchema = getAllAttribsUpToThisLevel();
                return difference(outputSchema, ancestorReqs);
            } else {
                CanonicalSchema thisReqs = getRequiredAttribsByThisLevel();
                return difference(thisReqs, ancestorReqs);
            }
        }

        return new CanonicalSchema();
    }

    public CanonicalSchema getAttribsToProject() {
        if (parent != null)
            return intersection(parent.getRequiredAttribsDownToThisLevel(), getAllAttribsUpToThisLevel());

        return new CanonicalSchema();
    }

    private void setRequiredAttribsDownToThisLevel() {
        CanonicalSchema thisAttribs = this.getRequiredAttribsByThisLevel();
        if (parent != null) {
            CanonicalSchema ancestorAttribs = parent.getRequiredAttribsDownToThisLevel();
            requiredAttribsDownToThisLevel = union(ancestorAttribs, thisAttribs);
        } else {
            requiredAttribsDownToThisLevel = thisAttribs;
        }
    }

    protected abstract void setAllAttribsUpToThisLevel();

    protected abstract void setRequiredAttribsByThisLevel();

    // TODO: In the intersection and difference we may get duplicate columns
    // if for example we have a predicate of the form R(x, x)

    // Returns s1 intersection s2
    public CanonicalSchema intersection(CanonicalSchema s1, CanonicalSchema s2) {
        CanonicalSchema res = new CanonicalSchema();
        String curCol;

        Iterator<String> s1Iter = s1.getColumnNames();

        while (s1Iter.hasNext()) {
            curCol = s1Iter.next();
            if (s2.hasColumnName(curCol))
                res.addColumnName(curCol);
        }

        return res;
    }

    // Returns s1 - s2
    public CanonicalSchema difference(CanonicalSchema s1, CanonicalSchema s2) {
        CanonicalSchema res = new CanonicalSchema();
        String curCol;

        Iterator<String> s1Iter = s1.getColumnNames();

        while (s1Iter.hasNext()) {
            curCol = s1Iter.next();
            if (!s2.hasColumnName(curCol))
                res.addColumnName(curCol);
        }

        return res;
    }

    // TODO: Add copy constructor to copy s1 and add only those columns not in s2
    public CanonicalSchema union(CanonicalSchema s1, CanonicalSchema s2) {
        CanonicalSchema res = new CanonicalSchema();
        String curCol;

        Iterator<String> s1Iter = s1.getColumnNames();

        while (s1Iter.hasNext()) {
            curCol = s1Iter.next();
            res.addColumnName(curCol);
        }

        Iterator<String> s2Iter = s2.getColumnNames();

        while (s2Iter.hasNext()) {
            curCol = s2Iter.next();
            if (!res.hasColumnName(curCol))
                res.addColumnName(curCol);
        }

        return res;

    }

}
