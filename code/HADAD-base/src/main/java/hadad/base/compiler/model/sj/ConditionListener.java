package hadad.base.compiler.model.sj;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.base.compiler.AntlrUtils;
import hadad.base.compiler.Condition;
import hadad.base.compiler.Operator;
import hadad.base.compiler.exceptions.ParseException;

/**
 * SJ Conditional Listener
 * 
 *   
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
        final SJQLLexer lexer = new SJQLLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final SJQLParser parser = new SJQLParser(tokens);
        final ParserRuleContext tree = parser.sjTextSearch();
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

    private class EqualityListenerAux extends SJQLBaseListener {
        private String left;
        private String right;

        public String getLeftTerm() {
            return left;
        }

        public String getRightTerm() {
            return right;
        }

        @Override
        public void enterSjLeftTerm(SJQLParser.SjLeftTermContext ctx) {
            if (left == null && right == null) {
                left = AntlrUtils.getFullText(ctx);
            }
        }

        @Override
        public void enterSjRightTerm(SJQLParser.SjRightTermContext ctx) {
            if (left != null && right == null) {
                right = AntlrUtils.getFullText(ctx);
            }
        }
    }
}
