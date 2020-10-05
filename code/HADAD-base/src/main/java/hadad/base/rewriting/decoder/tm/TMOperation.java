package hadad.base.rewriting.decoder.tm;

/**
 * TensorFlow Operations
 * 
 *  
 *
 */
public enum TMOperation {
    ADD("tf.math.add"),
    MULTI("tf.linalg.matmul"),
    MULTIS("tf.math.scalar_mul"),
    MULTIE("tf.math.matmul"),
    DIV("tf.math.divide"),
    TRANS("tf.linalg.matrix_transpose"),
    INVERSE("tf.linalg.inv"),
    DET("tf.linalg.det"),
    ADJ("tf.linalg.adjoint"),
    TRACE("tf.linalg.trace"),
    DIAG("tf.linalg.diag"),
    MEAN("tf.reduce_mean");

    private final String str;

    private TMOperation(final String str) {
        this.str = str;
    }

    public String OperationValue() {
        return str;
    }

    @Override
    public String toString() {
        return str;
    }
}
