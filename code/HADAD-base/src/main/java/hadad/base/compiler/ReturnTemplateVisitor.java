package hadad.base.compiler;

/**
 * Visitor pattern.
 *
 * Provides a way to navigate (similarly to a functional fold) the elements of a
 * query block tree return template.
 */
public interface ReturnTemplateVisitor {
    void visit(final ReturnTemplate template);

    void visitPre(final ReturnConstructTerm term);

    void visitPost(final ReturnConstructTerm term);

    void visit(final ReturnVariableTerm term);

    void visit(final ReturnStringTerm term);
}
