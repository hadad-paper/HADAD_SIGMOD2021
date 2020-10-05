package hadad.base.compiler.model.pj;

import hadad.base.compiler.ReturnConstructTerm;
import hadad.base.compiler.ReturnStringTerm;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.ReturnTemplateConstructor;
import hadad.base.compiler.ReturnTemplateVisitor;
import hadad.base.compiler.ReturnTerm;
import hadad.base.compiler.ReturnVariableTerm;
import hadad.base.compiler.Row;
import hadad.base.compiler.exceptions.ReturnConstructException;

/**
 * PJ ReturnTemplateConstructor which implements {@link ReturnTemplateConstructor}
 *
 */
public class PJReturnTemplateConstructor implements ReturnTemplateConstructor {
    private final PJConstructReturnTermVisitor constructVisitor;

    public PJReturnTemplateConstructor() {
        constructVisitor = new PJConstructReturnTermVisitor();
    }

    @Override
    public final String construct(final ReturnTemplate template, final Row row) throws ReturnConstructException {
        return constructVisitor.construct(template, row);
    }

    private class PJConstructReturnTermVisitor implements ReturnTemplateVisitor {
        private StringBuilder builder;
        private Row row;

        public String construct(final ReturnTemplate template, final Row row) throws ReturnConstructException {
            builder = new StringBuilder();
            this.row = row;
            template.accept(this);
            return builder.toString();
        }

        @Override
        public void visit(final ReturnTemplate template) {
            // NOP (no construction of the optionals)
        }

        @Override
        public void visitPre(final ReturnConstructTerm term) {
            if (!term.getElement().isEmpty()) {
                builder.append("\"").append(term.getElement().toString());
                builder.append("\":");
            }
            if (isObject(term)) {
                builder.append("{");
            } else {
                builder.append("[");
            }
        }

        @Override
        public void visitPost(final ReturnConstructTerm term) {
            if (isObject(term)) {
                builder.append("}");
            } else {
                builder.append("]");
            }
        }

        @Override
        public void visit(final ReturnVariableTerm term) {
            if (row == null) {
                builder.append(term.getVariable().toString());
            } else {
                builder.append("\"").append(row.getValue(term.getVariable()).toString()).append("\"");
            }
        }

        @Override
        public void visit(final ReturnStringTerm term) {
            builder.append(term.toString());
        }

        private boolean isObject(final ReturnConstructTerm term) {
            return !isArray(term);
        }

        private boolean isArray(final ReturnConstructTerm term) {
            if (!term.hasChildren()) {
                return true;
            }
            final ReturnTerm firstChild = term.getChildren().get(0);
            if (firstChild instanceof ReturnVariableTerm || firstChild instanceof ReturnStringTerm) {
                return true;
            }
            if (firstChild instanceof ReturnConstructTerm
                    && ((ReturnConstructTerm) firstChild).getElement().isEmpty()) {
                return true;
            }
            return false;
        }
    }
}
