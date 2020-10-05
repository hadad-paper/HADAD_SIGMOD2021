package hadad.base.compiler.model.la.api;

/**
 * IVisitable interface.
**/
public interface IVisitable {
    <R, A> R accept(IOperatorVisitor<R, A> visitor, A arg);
}
