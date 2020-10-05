package hadad.base.compiler.model.la.api;
import hadad.base.compiler.model.la.builder.BinaryOperator;
import hadad.base.compiler.model.la.builder.ScalarOperator;
import hadad.base.compiler.model.la.builder.ScanOperator;
import hadad.base.compiler.model.la.builder.UnaryOperator;
public interface IOperatorVisitor<R, A> {

    R visit(UnaryOperator unaryOperator, A arg);

    R visit(ScanOperator unaryOperator, A arg);

    R visit(BinaryOperator unaryOperator, A arg);

    R visit(ScalarOperator unaryOperator, A arg);

}
