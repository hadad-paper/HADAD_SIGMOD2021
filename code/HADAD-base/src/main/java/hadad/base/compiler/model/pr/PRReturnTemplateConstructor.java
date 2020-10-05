package hadad.base.compiler.model.pr;

import hadad.base.compiler.ReturnConstructTerm;
import hadad.base.compiler.ReturnStringTerm;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.ReturnTemplateConstructor;
import hadad.base.compiler.ReturnTemplateVisitor;
import hadad.base.compiler.ReturnVariableTerm;
import hadad.base.compiler.Row;
import hadad.base.compiler.exceptions.ReturnConstructException;

/**
 * PR ReturnTemplateConstructor which implements {@link ReturnTemplateConstructor}.
 * 
 *   
 */
public class PRReturnTemplateConstructor implements ReturnTemplateConstructor {
    private final PRConstructReturnTermVisitor constructVisitor;

    public PRReturnTemplateConstructor() {
        constructVisitor = new PRConstructReturnTermVisitor();
    }

    @Override
    public final String construct(final ReturnTemplate template, final Row row) throws ReturnConstructException {
        return constructVisitor.construct(template, row);
    }

    private class PRConstructReturnTermVisitor implements ReturnTemplateVisitor {
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
            // NOP (no construction)
        }

        @Override
        public void visitPost(final ReturnConstructTerm term) {
            // NOP (no construction)
        }

        @Override
        public void visit(final ReturnVariableTerm term) {
            if (builder.length() > 0) {
                builder.append(",");
            }
            if (row == null) {
                builder.append(term.getVariable().toString());
            } else {
                builder.append(row.getValue(term.getVariable()).toString());
            }
        }

        @Override
        public void visit(final ReturnStringTerm term) {
            if (builder.length() > 0) {
                builder.append(",");
            }
            builder.append(term.toString());
        }
    }
}
