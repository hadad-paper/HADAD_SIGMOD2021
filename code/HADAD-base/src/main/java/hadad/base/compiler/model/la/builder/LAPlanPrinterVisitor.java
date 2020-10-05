package hadad.base.compiler.model.la.builder;

import hadad.base.compiler.model.la.api.IOperatorVisitor;

public class LAPlanPrinterVisitor implements IOperatorVisitor<Void, Integer> {

    /** String builder **/
    private final StringBuilder builder;

    /** Constructor **/
    public LAPlanPrinterVisitor() {
        builder = new StringBuilder();

    }

    @Override
    public Void visit(UnaryOperator unaryOperator, Integer arg) {
        append(unaryOperator.getOpType(), null, arg);
        unaryOperator.getChildOp().accept(this, arg + 1);
        return null;
    }

    @Override
    public Void visit(ScanOperator scanOperator, Integer arg) {
        append(null, scanOperator.getBaseMatrixName(), arg);
        return null;
    }

    @Override
    public Void visit(ScalarOperator scalarOperator, Integer arg) {
        append(null, scalarOperator.getScalarValue(), arg);
        return null;
    }

    @Override
    public Void visit(BinaryOperator binaryOperator, Integer arg) {
        append(binaryOperator.getOpType(), null, arg);
        binaryOperator.getChildOpLeft().accept(this, arg + 1);
        binaryOperator.getChildOpRight().accept(this, arg + 1);

        return null;
    }

    /**
     * String builder append.
     * 
     * @param key
     *            the key name.
     * @param opType
     *            operator type.
     * @param indentLevel
     *            Indentation level.
     * @param counter
     *            number of nodes. (per node).
     */
    private void append(OpType opType, Object value, int indentLevel) {
        for (int i = 0; i < indentLevel - 1; i++) {
            builder.append("|    ");
        }
        builder.append("|-- ");
        builder.append((opType == null) ? "" : opType);
        builder.append(": ");
        builder.append((value == null) ? "" : value);
        builder.append('\n');
    }

    /**
     * Get string builder.
     * 
     * @return string builder.
     */
    public StringBuilder getStringBuilder() {
        return builder;
    }

}
