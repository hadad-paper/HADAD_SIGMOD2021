package hadad.base.compiler.model.xq;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.base.compiler.AntlrUtils;
import hadad.base.compiler.Condition;
import hadad.base.compiler.Operator;
import hadad.base.compiler.exceptions.ParseException;

/*
 * Currently the operator is hardcoded to = as it is hardcoded in the grammar.
 */
/**
 * 
 */
@Singleton
final class ConditionListener {
    private final ConditionTermListener conditionTermListener;

    @Inject
    public ConditionListener(final ConditionTermListener conditionTermListener) {
        this.conditionTermListener = conditionTermListener;
    }

    public Condition parse(final String str) throws ParseException {
        final XQueryLexer lexer = new XQueryLexer(new ANTLRInputStream(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final XQueryParser parser = new XQueryParser(tokens);
        final ParserRuleContext tree = parser.flwrWhereCondEquality();
        final ParseTreeWalker walker = new ParseTreeWalker();
        final EqualityListenerAux listener = new EqualityListenerAux();
        try {
            walker.walk(listener, tree);
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }

        if (listener.getLeftTerm() == null) {
            throw new ParseException(new IllegalStateException("Left condition term expected."));
        }
        if (listener.getRightTerm() == null) {
            throw new ParseException(new IllegalStateException("Right condition term expected."));
        }
        return new Condition(conditionTermListener.parse(listener.getLeftTerm()), Operator.EQUALS,
                conditionTermListener.parse(listener.getRightTerm()));
    }

    /*
     * We allow only strings that have left term followed by right term.
     */
    private class EqualityListenerAux extends XQueryBaseListener {
        private String left;
        private String right;

        public String getLeftTerm() {
            return left;
        }

        public String getRightTerm() {
            return right;
        }

        @Override
        public void enterFlwrWhereCondEqualityLeftTerm(XQueryParser.FlwrWhereCondEqualityLeftTermContext ctx) {
            if (left == null && right == null) {
                left = AntlrUtils.getFullText(ctx);
            }
        }

        @Override
        public void enterFlwrWhereCondEqualityRightTerm(XQueryParser.FlwrWhereCondEqualityRightTermContext ctx) {
            if (left != null && right == null) {
                right = AntlrUtils.getFullText(ctx);
            }
        }
    }
}
