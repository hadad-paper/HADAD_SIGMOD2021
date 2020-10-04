package hadad.db.query;

import hadad.db.canonicaldb.Tuple;

public class SelfJoin extends UnaryOperator {

    UnaryProjectComponent project;

    public SelfJoin(Operator childOp) {
        super(childOp);
    }

    @Override
    protected void flush() {

    }

    @Override
    protected boolean hasEmptyInput() {
        return false;
    }

    @Override
    protected boolean isBlockedDefault() {
        return false;
    }

    @Override
    protected Tuple next() {
        return null;
    }
    @Override
    protected StringBuffer printString() {
        return null;
    }

    @Override
    protected void setOutSchema() {
    }

}
