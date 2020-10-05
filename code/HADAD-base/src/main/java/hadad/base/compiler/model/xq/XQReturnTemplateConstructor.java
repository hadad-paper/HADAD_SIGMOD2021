package hadad.base.compiler.model.xq;

import java.util.Map;
import java.util.Map.Entry;

import hadad.base.compiler.ReturnConstructTerm;
import hadad.base.compiler.ReturnLeafTerm;
import hadad.base.compiler.ReturnStringTerm;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.ReturnTemplateConstructor;
import hadad.base.compiler.ReturnTemplateVisitor;
import hadad.base.compiler.ReturnVariableTerm;
import hadad.base.compiler.Row;
import hadad.base.compiler.exceptions.ReturnConstructException;

/**
 * 
 */
public class XQReturnTemplateConstructor implements ReturnTemplateConstructor {
    private final XQConstructReturnTermVisitor constructVisitor;

    public XQReturnTemplateConstructor() {
        constructVisitor = new XQConstructReturnTermVisitor();
    }

    @Override
    public final String construct(final ReturnTemplate template, final Row row) throws ReturnConstructException {
        return constructVisitor.construct(template, row);
    }

    private class XQConstructReturnTermVisitor implements ReturnTemplateVisitor {
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
            if (term.hasChildren()) {
                builder.append("<").append(term.getElement().toString());
                visitAttributes(term.getAttributes());
                builder.append(">");
            } else {
                builder.append("<").append(term.getElement().toString());
                visitAttributes(term.getAttributes());
                builder.append("/>");
            }
        }

        private void visitAttributes(final Map<String, ReturnLeafTerm> attributes) {
            for (final Entry<String, ReturnLeafTerm> entry : attributes.entrySet()) {
                builder.append(" ").append(entry.getKey()).append("=");
                if (entry.getValue() instanceof ReturnVariableTerm) {
                    visit((ReturnVariableTerm) entry.getValue());
                } else if (entry.getValue() instanceof ReturnStringTerm) {
                    visit((ReturnStringTerm) entry.getValue());
                } else {
                    throw new IllegalStateException("Unknown return leaf term.");
                }
                builder.append(" ");
            }
        }

        @Override
        public void visitPost(final ReturnConstructTerm term) {
            if (term.hasChildren()) {
                builder.append("</").append(term.getElement().toString()).append(">");
            }
        }

        @Override
        public void visit(final ReturnVariableTerm term) {
            if (row == null) {
                builder.append(term.getVariable().toString());
            } else {
                builder.append(row.getValue(term.getVariable()).toString());
            }
        }

        @Override
        public void visit(final ReturnStringTerm term) {
            builder.append(term.toString());
        }
    }
}
