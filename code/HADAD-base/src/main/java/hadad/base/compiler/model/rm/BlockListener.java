package hadad.base.compiler.model.rm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.apache.log4j.Logger;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import hadad.commons.conjunctivequery.Variable;
import hadad.base.compiler.AntlrUtils;
import hadad.base.compiler.Block;
import hadad.base.compiler.ChildBlock;
import hadad.base.compiler.Pattern;
import hadad.base.compiler.ReturnConstructTerm;
import hadad.base.compiler.ReturnLeafTerm;
import hadad.base.compiler.ReturnTemplate;
import hadad.base.compiler.ReturnTerm;
import hadad.base.compiler.RootBlock;
import hadad.base.compiler.StringElement;
import hadad.base.compiler.VariableElement;
import hadad.base.compiler.exceptions.ParseException;

/**
 * RM BlockListener
 * 
 *  
 */
@Singleton
final class BlockListener {
    private static final Logger LOGGER = Logger.getLogger(BlockListener.class);

    private final PatternListener patternListener;
    @SuppressWarnings("unused")
    private final ReturnTemplateListener returnTemplateListener;

    @Inject
    public BlockListener(final PatternListener patternListener, final ReturnTemplateListener returnTemplateListener) {
        this.patternListener = patternListener;
        this.returnTemplateListener = returnTemplateListener;
    }

    /**
     * Parse DML script
     * 
     * @param queryName
     *            a query name
     * @param strQuery
     *            dml script
     * @return rootblock constructed root block
     * @throws ParseException
     */
    public RootBlock parse(final String queryName, final String strQuery) throws ParseException {
        final BlockListenerAux listener = _parse(strQuery);
        final Pattern pattern = patternListener.parse(listener.getPattern());

        return new RootBlock(queryName, pattern,
                constructReturnTemplate(pattern.getStructural().getDefinedVariables()));
    }

    /**
     * Parse DML
     * 
     * @param parent
     * @param createdNode
     * @param str
     * @return childblook
     * @throws ParseException
     */
    public ChildBlock parse(final Block parent, final String createdNode, final String str) throws ParseException {
        final BlockListenerAux listener = _parse(str);
        final Pattern pattern = patternListener.parse(listener.getPattern());
        return new ChildBlock(parent, createdNode, pattern,
                constructReturnTemplate(pattern.getStructural().getDefinedVariables()));
    }

    /**
     * Construct return template for DML script
     * 
     * @param patternVars
     *            the variables introduced in the pattern structural (ordered)
     * @return return template
     */
    private ReturnTemplate constructReturnTemplate(final List<Variable> patternVars) {
        final List<ReturnTerm> terms = new ArrayList<ReturnTerm>();
        final Variable var = patternVars.get(patternVars.size() - 1);
        final ReturnConstructTerm term = new ReturnConstructTerm(
                new ReturnConstructTerm(new VariableElement(var), new HashMap<String, ReturnLeafTerm>()),
                new StringElement(var.getName()), new HashMap<String, ReturnLeafTerm>());
        terms.add(term);
        return new ReturnTemplate(RMModel.ID, terms);
    }

    private BlockListenerAux _parse(final String str) throws ParseException {
        final RLexer lexer = new RLexer(CharStreams.fromString(str));
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final RParser parser = new RParser(tokens);
        final ParserRuleContext tree = parser.rScript();
        final ParseTreeWalker walker = new ParseTreeWalker();
        final BlockListenerAux listener = new BlockListenerAux();
        try {
            walker.walk(listener, tree);
        } catch (IllegalStateException e) {
            throw new ParseException(e);
        }
        if (listener.getPattern() == null) {
            throw new ParseException(new IllegalStateException("Pattern expected."));
        }
        return listener;
    }

    private class BlockListenerAux extends RBaseListener {
        private String pattern;

        /**
         * Get the pattern
         * 
         * @return pattern. The constructed pattern
         */
        public String getPattern() {
            return pattern;
        }

        @Override
        public void enterRScript(RParser.RScriptContext ctx) {
            if (pattern == null) {
                pattern = AntlrUtils.getFullText(ctx);
            }
        }
    }
}
