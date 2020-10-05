package hadad.base.compiler.model.la.builder;

import static com.google.common.base.Preconditions.checkNotNull;
import org.apache.log4j.Logger;
import hadad.base.compiler.model.la.api.IOperatorVisitor;

/**
 * Temp implementation (this should be value)
 *
 */
public class ScalarOperator extends IOperator {
    private static final long serialVersionUID = 1L;
    /** Logger **/
    private static final Logger LOGGER = Logger.getLogger(IOperator.class);
    final double scalarValue;

    public ScalarOperator(final double scalarValue) {
        super();
        this.scalarValue = checkNotNull(scalarValue);
        this.nCols = 0;
        this.nNZ = 0;
        this.nRows = 0;

    }

    public double getScalarValue() {
        return scalarValue;
    }

    @Override
    public <R, A> R accept(IOperatorVisitor<R, A> visitor, A arg) {
        return visitor.visit(this, arg);
    }

}
