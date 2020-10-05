// Generated from AQL.g4 by ANTLR 4.7.2

package hadad.base.compiler.model.aj;

import java.util.List;

import org.antlr.v4.runtime.FailedPredicateException;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

@SuppressWarnings({ "all", "warnings", "unchecked", "unused", "cast" })
public class AQLParser extends Parser {
    static {
        RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
    public static final int T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9,
            T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15, T__15 = 16, T__16 = 17, T__17 = 18,
            NAME = 19, BETA = 20, WS = 21, STRING = 22;
    public static final int RULE_aqlquery = 0, RULE_viewName = 1, RULE_query = 2, RULE_rootFieldName = 3,
            RULE_returnClause = 4, RULE_recordConstruct = 5, RULE_fieldBinding = 6, RULE_recordConstructFieldName = 7,
            RULE_fieldName = 8, RULE_fieldValue = 9, RULE_returnVar = 10, RULE_name = 11, RULE_returnConstant = 12,
            RULE_returnQuery = 13, RULE_term = 14, RULE_termVar = 15, RULE_termConstant = 16, RULE_termPath = 17,
            RULE_constant = 18, RULE_number = 19, RULE_path = 20, RULE_pathVar = 21, RULE_var = 22, RULE_step = 23,
            RULE_objectStep = 24, RULE_arrayStep = 25, RULE_key = 26, RULE_index = 27, RULE_forClause = 28,
            RULE_binding = 29, RULE_forClauseBindingVar = 30, RULE_forClauseBindingSource = 31, RULE_source = 32,
            RULE_dataSetName = 33, RULE_whereClause = 34, RULE_condition = 35, RULE_whereCondSome = 36,
            RULE_whereCondBinding = 37, RULE_whereCondBindingVar = 38, RULE_whereCondBindingSource = 39,
            RULE_whereCondEquality = 40, RULE_whereCondEqualityLeftTerm = 41, RULE_whereCondEqualityRightTerm = 42,
            RULE_cterm = 43, RULE_forWhereClauses = 44;

    private static String[] makeRuleNames() {
        return new String[] { "aqlquery", "viewName", "query", "rootFieldName", "returnClause", "recordConstruct",
                "fieldBinding", "recordConstructFieldName", "fieldName", "fieldValue", "returnVar", "name",
                "returnConstant", "returnQuery", "term", "termVar", "termConstant", "termPath", "constant", "number",
                "path", "pathVar", "var", "step", "objectStep", "arrayStep", "key", "index", "forClause", "binding",
                "forClauseBindingVar", "forClauseBindingSource", "source", "dataSetName", "whereClause", "condition",
                "whereCondSome", "whereCondBinding", "whereCondBindingVar", "whereCondBindingSource",
                "whereCondEquality", "whereCondEqualityLeftTerm", "whereCondEqualityRightTerm", "cterm",
                "forWhereClauses" };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[] { null, "'='", "'{'", "':'", "'}'", "'return'", "','", "'.'", "'['", "']'", "'for'", "'in'",
                "'dataset'", "'where'", "'and'", "'some'", "'satisfies'", "'('", "')'" };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[] { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, "NAME", "BETA", "WS", "STRING" };
    }

    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getGrammarFileName() {
        return "AQL.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public AQLParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    public static class AqlqueryContext extends ParserRuleContext {
        public ViewNameContext viewName() {
            return getRuleContext(ViewNameContext.class, 0);
        }

        public QueryContext query() {
            return getRuleContext(QueryContext.class, 0);
        }

        public RootFieldNameContext rootFieldName() {
            return getRuleContext(RootFieldNameContext.class, 0);
        }

        public AqlqueryContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_aqlquery;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterAqlquery(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitAqlquery(this);
        }
    }

    public final AqlqueryContext aqlquery() throws RecognitionException {
        AqlqueryContext _localctx = new AqlqueryContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_aqlquery);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(90);
                viewName();
                setState(91);
                match(T__0);
                setState(99);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case T__9: {
                        setState(92);
                        query();
                    }
                        break;
                    case T__1: {
                        setState(93);
                        match(T__1);
                        setState(94);
                        rootFieldName();
                        setState(95);
                        match(T__2);
                        setState(96);
                        query();
                        setState(97);
                        match(T__3);
                    }
                        break;
                    default:
                        throw new NoViableAltException(this);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ViewNameContext extends ParserRuleContext {
        public TerminalNode NAME() {
            return getToken(AQLParser.NAME, 0);
        }

        public ViewNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_viewName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterViewName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitViewName(this);
        }
    }

    public final ViewNameContext viewName() throws RecognitionException {
        ViewNameContext _localctx = new ViewNameContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_viewName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(101);
                match(NAME);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class QueryContext extends ParserRuleContext {
        public ForWhereClausesContext forWhereClauses() {
            return getRuleContext(ForWhereClausesContext.class, 0);
        }

        public ReturnClauseContext returnClause() {
            return getRuleContext(ReturnClauseContext.class, 0);
        }

        public QueryContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_query;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterQuery(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitQuery(this);
        }
    }

    public final QueryContext query() throws RecognitionException {
        QueryContext _localctx = new QueryContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_query);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(103);
                forWhereClauses();
                setState(104);
                returnClause();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class RootFieldNameContext extends ParserRuleContext {
        public FieldNameContext fieldName() {
            return getRuleContext(FieldNameContext.class, 0);
        }

        public RootFieldNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_rootFieldName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterRootFieldName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitRootFieldName(this);
        }
    }

    public final RootFieldNameContext rootFieldName() throws RecognitionException {
        RootFieldNameContext _localctx = new RootFieldNameContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_rootFieldName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(106);
                fieldName();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ReturnClauseContext extends ParserRuleContext {
        public RecordConstructContext recordConstruct() {
            return getRuleContext(RecordConstructContext.class, 0);
        }

        public ReturnVarContext returnVar() {
            return getRuleContext(ReturnVarContext.class, 0);
        }

        public ReturnConstantContext returnConstant() {
            return getRuleContext(ReturnConstantContext.class, 0);
        }

        public ReturnClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_returnClause;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterReturnClause(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitReturnClause(this);
        }
    }

    public final ReturnClauseContext returnClause() throws RecognitionException {
        ReturnClauseContext _localctx = new ReturnClauseContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_returnClause);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(108);
                match(T__4);
                setState(112);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case T__1: {
                        setState(109);
                        recordConstruct();
                    }
                        break;
                    case NAME: {
                        setState(110);
                        returnVar();
                    }
                        break;
                    case BETA:
                    case STRING: {
                        setState(111);
                        returnConstant();
                    }
                        break;
                    default:
                        throw new NoViableAltException(this);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class RecordConstructContext extends ParserRuleContext {
        public List<FieldBindingContext> fieldBinding() {
            return getRuleContexts(FieldBindingContext.class);
        }

        public FieldBindingContext fieldBinding(int i) {
            return getRuleContext(FieldBindingContext.class, i);
        }

        public RecordConstructContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_recordConstruct;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterRecordConstruct(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitRecordConstruct(this);
        }
    }

    public final RecordConstructContext recordConstruct() throws RecognitionException {
        RecordConstructContext _localctx = new RecordConstructContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_recordConstruct);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(114);
                match(T__1);
                setState(115);
                fieldBinding();
                setState(120);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__5) {
                    {
                        {
                            setState(116);
                            match(T__5);
                            setState(117);
                            fieldBinding();
                        }
                    }
                    setState(122);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(123);
                match(T__3);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FieldBindingContext extends ParserRuleContext {
        public RecordConstructFieldNameContext recordConstructFieldName() {
            return getRuleContext(RecordConstructFieldNameContext.class, 0);
        }

        public FieldValueContext fieldValue() {
            return getRuleContext(FieldValueContext.class, 0);
        }

        public FieldBindingContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fieldBinding;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterFieldBinding(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitFieldBinding(this);
        }
    }

    public final FieldBindingContext fieldBinding() throws RecognitionException {
        FieldBindingContext _localctx = new FieldBindingContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_fieldBinding);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(125);
                recordConstructFieldName();
                setState(126);
                match(T__2);
                setState(127);
                fieldValue();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class RecordConstructFieldNameContext extends ParserRuleContext {
        public FieldNameContext fieldName() {
            return getRuleContext(FieldNameContext.class, 0);
        }

        public RecordConstructFieldNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_recordConstructFieldName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterRecordConstructFieldName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitRecordConstructFieldName(this);
        }
    }

    public final RecordConstructFieldNameContext recordConstructFieldName() throws RecognitionException {
        RecordConstructFieldNameContext _localctx = new RecordConstructFieldNameContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_recordConstructFieldName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(129);
                fieldName();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FieldNameContext extends ParserRuleContext {
        public TerminalNode STRING() {
            return getToken(AQLParser.STRING, 0);
        }

        public FieldNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fieldName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterFieldName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitFieldName(this);
        }
    }

    public final FieldNameContext fieldName() throws RecognitionException {
        FieldNameContext _localctx = new FieldNameContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_fieldName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(131);
                match(STRING);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class FieldValueContext extends ParserRuleContext {
        public RecordConstructContext recordConstruct() {
            return getRuleContext(RecordConstructContext.class, 0);
        }

        public ReturnVarContext returnVar() {
            return getRuleContext(ReturnVarContext.class, 0);
        }

        public ReturnConstantContext returnConstant() {
            return getRuleContext(ReturnConstantContext.class, 0);
        }

        public ReturnQueryContext returnQuery() {
            return getRuleContext(ReturnQueryContext.class, 0);
        }

        public FieldValueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fieldValue;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterFieldValue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitFieldValue(this);
        }
    }

    public final FieldValueContext fieldValue() throws RecognitionException {
        FieldValueContext _localctx = new FieldValueContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_fieldValue);
        try {
            setState(137);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__1:
                    enterOuterAlt(_localctx, 1); {
                    setState(133);
                    recordConstruct();
                }
                    break;
                case NAME:
                    enterOuterAlt(_localctx, 2); {
                    setState(134);
                    returnVar();
                }
                    break;
                case BETA:
                case STRING:
                    enterOuterAlt(_localctx, 3); {
                    setState(135);
                    returnConstant();
                }
                    break;
                case T__9:
                    enterOuterAlt(_localctx, 4); {
                    setState(136);
                    returnQuery();
                }
                    break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ReturnVarContext extends ParserRuleContext {
        public VarContext var() {
            return getRuleContext(VarContext.class, 0);
        }

        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }

        public TerminalNode NAME() {
            return getToken(AQLParser.NAME, 0);
        }

        public ReturnVarContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_returnVar;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterReturnVar(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitReturnVar(this);
        }
    }

    public final ReturnVarContext returnVar() throws RecognitionException {
        ReturnVarContext _localctx = new ReturnVarContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_returnVar);
        try {
            setState(144);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 4, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(139);
                    var();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(140);
                    name();
                    setState(141);
                    match(T__6);
                    setState(142);
                    match(NAME);
                }
                    break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class NameContext extends ParserRuleContext {
        public TerminalNode NAME() {
            return getToken(AQLParser.NAME, 0);
        }

        public NameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_name;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitName(this);
        }
    }

    public final NameContext name() throws RecognitionException {
        NameContext _localctx = new NameContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_name);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(146);
                match(NAME);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ReturnConstantContext extends ParserRuleContext {
        public ConstantContext constant() {
            return getRuleContext(ConstantContext.class, 0);
        }

        public ReturnConstantContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_returnConstant;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterReturnConstant(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitReturnConstant(this);
        }
    }

    public final ReturnConstantContext returnConstant() throws RecognitionException {
        ReturnConstantContext _localctx = new ReturnConstantContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_returnConstant);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(148);
                constant();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ReturnQueryContext extends ParserRuleContext {
        public QueryContext query() {
            return getRuleContext(QueryContext.class, 0);
        }

        public ReturnQueryContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_returnQuery;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterReturnQuery(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitReturnQuery(this);
        }
    }

    public final ReturnQueryContext returnQuery() throws RecognitionException {
        ReturnQueryContext _localctx = new ReturnQueryContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_returnQuery);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(150);
                query();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class TermContext extends ParserRuleContext {
        public TermConstantContext termConstant() {
            return getRuleContext(TermConstantContext.class, 0);
        }

        public TermVarContext termVar() {
            return getRuleContext(TermVarContext.class, 0);
        }

        public TermPathContext termPath() {
            return getRuleContext(TermPathContext.class, 0);
        }

        public TermContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_term;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterTerm(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitTerm(this);
        }
    }

    public final TermContext term() throws RecognitionException {
        TermContext _localctx = new TermContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_term);
        try {
            setState(155);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 5, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(152);
                    termConstant();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(153);
                    termVar();
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(154);
                    termPath();
                }
                    break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class TermVarContext extends ParserRuleContext {
        public VarContext var() {
            return getRuleContext(VarContext.class, 0);
        }

        public NameContext name() {
            return getRuleContext(NameContext.class, 0);
        }

        public TerminalNode NAME() {
            return getToken(AQLParser.NAME, 0);
        }

        public TermVarContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_termVar;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterTermVar(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitTermVar(this);
        }
    }

    public final TermVarContext termVar() throws RecognitionException {
        TermVarContext _localctx = new TermVarContext(_ctx, getState());
        enterRule(_localctx, 30, RULE_termVar);
        try {
            setState(162);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 6, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(157);
                    var();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(158);
                    name();
                    setState(159);
                    match(T__6);
                    setState(160);
                    match(NAME);
                }
                    break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class TermConstantContext extends ParserRuleContext {
        public ConstantContext constant() {
            return getRuleContext(ConstantContext.class, 0);
        }

        public TermConstantContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_termConstant;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterTermConstant(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitTermConstant(this);
        }
    }

    public final TermConstantContext termConstant() throws RecognitionException {
        TermConstantContext _localctx = new TermConstantContext(_ctx, getState());
        enterRule(_localctx, 32, RULE_termConstant);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(164);
                constant();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class TermPathContext extends ParserRuleContext {
        public PathContext path() {
            return getRuleContext(PathContext.class, 0);
        }

        public TermPathContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_termPath;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterTermPath(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitTermPath(this);
        }
    }

    public final TermPathContext termPath() throws RecognitionException {
        TermPathContext _localctx = new TermPathContext(_ctx, getState());
        enterRule(_localctx, 34, RULE_termPath);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(166);
                path();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ConstantContext extends ParserRuleContext {
        public NumberContext number() {
            return getRuleContext(NumberContext.class, 0);
        }

        public TerminalNode STRING() {
            return getToken(AQLParser.STRING, 0);
        }

        public ConstantContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_constant;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterConstant(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitConstant(this);
        }
    }

    public final ConstantContext constant() throws RecognitionException {
        ConstantContext _localctx = new ConstantContext(_ctx, getState());
        enterRule(_localctx, 36, RULE_constant);
        try {
            setState(170);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case BETA:
                    enterOuterAlt(_localctx, 1); {
                    setState(168);
                    number();
                }
                    break;
                case STRING:
                    enterOuterAlt(_localctx, 2); {
                    setState(169);
                    match(STRING);
                }
                    break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class NumberContext extends ParserRuleContext {
        public TerminalNode BETA() {
            return getToken(AQLParser.BETA, 0);
        }

        public NumberContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_number;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterNumber(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitNumber(this);
        }
    }

    public final NumberContext number() throws RecognitionException {
        NumberContext _localctx = new NumberContext(_ctx, getState());
        enterRule(_localctx, 38, RULE_number);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(172);
                match(BETA);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class PathContext extends ParserRuleContext {
        public PathVarContext pathVar() {
            return getRuleContext(PathVarContext.class, 0);
        }

        public List<StepContext> step() {
            return getRuleContexts(StepContext.class);
        }

        public StepContext step(int i) {
            return getRuleContext(StepContext.class, i);
        }

        public PathContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_path;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterPath(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitPath(this);
        }
    }

    public final PathContext path() throws RecognitionException {
        PathContext _localctx = new PathContext(_ctx, getState());
        enterRule(_localctx, 40, RULE_path);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(174);
                pathVar();
                setState(176);
                _errHandler.sync(this);
                _alt = 1;
                do {
                    switch (_alt) {
                        case 1: {
                            {
                                setState(175);
                                step();
                            }
                        }
                            break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(178);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 8, _ctx);
                } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class PathVarContext extends ParserRuleContext {
        public VarContext var() {
            return getRuleContext(VarContext.class, 0);
        }

        public PathVarContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pathVar;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterPathVar(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitPathVar(this);
        }
    }

    public final PathVarContext pathVar() throws RecognitionException {
        PathVarContext _localctx = new PathVarContext(_ctx, getState());
        enterRule(_localctx, 42, RULE_pathVar);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(180);
                var();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class VarContext extends ParserRuleContext {
        public TerminalNode NAME() {
            return getToken(AQLParser.NAME, 0);
        }

        public VarContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_var;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterVar(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitVar(this);
        }
    }

    public final VarContext var() throws RecognitionException {
        VarContext _localctx = new VarContext(_ctx, getState());
        enterRule(_localctx, 44, RULE_var);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(182);
                match(NAME);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class StepContext extends ParserRuleContext {
        public ObjectStepContext objectStep() {
            return getRuleContext(ObjectStepContext.class, 0);
        }

        public ArrayStepContext arrayStep() {
            return getRuleContext(ArrayStepContext.class, 0);
        }

        public StepContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_step;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterStep(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitStep(this);
        }
    }

    public final StepContext step() throws RecognitionException {
        StepContext _localctx = new StepContext(_ctx, getState());
        enterRule(_localctx, 46, RULE_step);
        try {
            setState(186);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__6:
                    enterOuterAlt(_localctx, 1); {
                    setState(184);
                    objectStep();
                }
                    break;
                case T__7:
                    enterOuterAlt(_localctx, 2); {
                    setState(185);
                    arrayStep();
                }
                    break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ObjectStepContext extends ParserRuleContext {
        public KeyContext key() {
            return getRuleContext(KeyContext.class, 0);
        }

        public ObjectStepContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_objectStep;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterObjectStep(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitObjectStep(this);
        }
    }

    public final ObjectStepContext objectStep() throws RecognitionException {
        ObjectStepContext _localctx = new ObjectStepContext(_ctx, getState());
        enterRule(_localctx, 48, RULE_objectStep);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(188);
                match(T__6);
                setState(189);
                key();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ArrayStepContext extends ParserRuleContext {
        public IndexContext index() {
            return getRuleContext(IndexContext.class, 0);
        }

        public ArrayStepContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_arrayStep;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterArrayStep(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitArrayStep(this);
        }
    }

    public final ArrayStepContext arrayStep() throws RecognitionException {
        ArrayStepContext _localctx = new ArrayStepContext(_ctx, getState());
        enterRule(_localctx, 50, RULE_arrayStep);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(191);
                match(T__7);
                setState(192);
                index();
                setState(193);
                match(T__8);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class KeyContext extends ParserRuleContext {
        public TerminalNode NAME() {
            return getToken(AQLParser.NAME, 0);
        }

        public KeyContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_key;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterKey(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitKey(this);
        }
    }

    public final KeyContext key() throws RecognitionException {
        KeyContext _localctx = new KeyContext(_ctx, getState());
        enterRule(_localctx, 52, RULE_key);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(195);
                match(NAME);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class IndexContext extends ParserRuleContext {
        public NumberContext number() {
            return getRuleContext(NumberContext.class, 0);
        }

        public IndexContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_index;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterIndex(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitIndex(this);
        }
    }

    public final IndexContext index() throws RecognitionException {
        IndexContext _localctx = new IndexContext(_ctx, getState());
        enterRule(_localctx, 54, RULE_index);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(197);
                number();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ForClauseContext extends ParserRuleContext {
        public List<BindingContext> binding() {
            return getRuleContexts(BindingContext.class);
        }

        public BindingContext binding(int i) {
            return getRuleContext(BindingContext.class, i);
        }

        public ForClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_forClause;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterForClause(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitForClause(this);
        }
    }

    public final ForClauseContext forClause() throws RecognitionException {
        ForClauseContext _localctx = new ForClauseContext(_ctx, getState());
        enterRule(_localctx, 56, RULE_forClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(199);
                match(T__9);
                setState(200);
                binding();
                setState(205);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__5) {
                    {
                        {
                            setState(201);
                            match(T__5);
                            setState(202);
                            binding();
                        }
                    }
                    setState(207);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class BindingContext extends ParserRuleContext {
        public ForClauseBindingVarContext forClauseBindingVar() {
            return getRuleContext(ForClauseBindingVarContext.class, 0);
        }

        public ForClauseBindingSourceContext forClauseBindingSource() {
            return getRuleContext(ForClauseBindingSourceContext.class, 0);
        }

        public BindingContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_binding;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterBinding(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitBinding(this);
        }
    }

    public final BindingContext binding() throws RecognitionException {
        BindingContext _localctx = new BindingContext(_ctx, getState());
        enterRule(_localctx, 58, RULE_binding);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(208);
                forClauseBindingVar();
                setState(209);
                match(T__10);
                setState(210);
                forClauseBindingSource();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ForClauseBindingVarContext extends ParserRuleContext {
        public VarContext var() {
            return getRuleContext(VarContext.class, 0);
        }

        public ForClauseBindingVarContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_forClauseBindingVar;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterForClauseBindingVar(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitForClauseBindingVar(this);
        }
    }

    public final ForClauseBindingVarContext forClauseBindingVar() throws RecognitionException {
        ForClauseBindingVarContext _localctx = new ForClauseBindingVarContext(_ctx, getState());
        enterRule(_localctx, 60, RULE_forClauseBindingVar);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(212);
                var();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ForClauseBindingSourceContext extends ParserRuleContext {
        public SourceContext source() {
            return getRuleContext(SourceContext.class, 0);
        }

        public ForClauseBindingSourceContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_forClauseBindingSource;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterForClauseBindingSource(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitForClauseBindingSource(this);
        }
    }

    public final ForClauseBindingSourceContext forClauseBindingSource() throws RecognitionException {
        ForClauseBindingSourceContext _localctx = new ForClauseBindingSourceContext(_ctx, getState());
        enterRule(_localctx, 62, RULE_forClauseBindingSource);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(214);
                source();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class SourceContext extends ParserRuleContext {
        public DataSetNameContext dataSetName() {
            return getRuleContext(DataSetNameContext.class, 0);
        }

        public PathContext path() {
            return getRuleContext(PathContext.class, 0);
        }

        public SourceContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_source;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterSource(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitSource(this);
        }
    }

    public final SourceContext source() throws RecognitionException {
        SourceContext _localctx = new SourceContext(_ctx, getState());
        enterRule(_localctx, 64, RULE_source);
        try {
            setState(219);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__11:
                    enterOuterAlt(_localctx, 1); {
                    setState(216);
                    match(T__11);
                    setState(217);
                    dataSetName();
                }
                    break;
                case NAME:
                    enterOuterAlt(_localctx, 2); {
                    setState(218);
                    path();
                }
                    break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class DataSetNameContext extends ParserRuleContext {
        public TerminalNode NAME() {
            return getToken(AQLParser.NAME, 0);
        }

        public DataSetNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_dataSetName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterDataSetName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitDataSetName(this);
        }
    }

    public final DataSetNameContext dataSetName() throws RecognitionException {
        DataSetNameContext _localctx = new DataSetNameContext(_ctx, getState());
        enterRule(_localctx, 66, RULE_dataSetName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(221);
                match(NAME);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class WhereClauseContext extends ParserRuleContext {
        public ConditionContext condition() {
            return getRuleContext(ConditionContext.class, 0);
        }

        public WhereClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_whereClause;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterWhereClause(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitWhereClause(this);
        }
    }

    public final WhereClauseContext whereClause() throws RecognitionException {
        WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
        enterRule(_localctx, 68, RULE_whereClause);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(223);
                match(T__12);
                setState(224);
                condition(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ConditionContext extends ParserRuleContext {
        public WhereCondEqualityContext whereCondEquality() {
            return getRuleContext(WhereCondEqualityContext.class, 0);
        }

        public WhereCondSomeContext whereCondSome() {
            return getRuleContext(WhereCondSomeContext.class, 0);
        }

        public List<ConditionContext> condition() {
            return getRuleContexts(ConditionContext.class);
        }

        public ConditionContext condition(int i) {
            return getRuleContext(ConditionContext.class, i);
        }

        public ConditionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_condition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterCondition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitCondition(this);
        }
    }

    public final ConditionContext condition() throws RecognitionException {
        return condition(0);
    }

    private ConditionContext condition(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        ConditionContext _localctx = new ConditionContext(_ctx, _parentState);
        ConditionContext _prevctx = _localctx;
        int _startState = 70;
        enterRecursionRule(_localctx, 70, RULE_condition, _p);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(237);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case NAME:
                    case BETA:
                    case STRING: {
                        setState(227);
                        whereCondEquality();
                    }
                        break;
                    case T__14: {
                        setState(228);
                        match(T__14);
                        setState(229);
                        whereCondSome();
                        setState(230);
                        match(T__15);
                        setState(231);
                        condition(2);
                    }
                        break;
                    case T__16: {
                        setState(233);
                        match(T__16);
                        setState(234);
                        condition(0);
                        setState(235);
                        match(T__17);
                    }
                        break;
                    default:
                        throw new NoViableAltException(this);
                }
                _ctx.stop = _input.LT(-1);
                setState(244);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 13, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null)
                            triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            {
                                _localctx = new ConditionContext(_parentctx, _parentState);
                                pushNewRecursionContext(_localctx, _startState, RULE_condition);
                                setState(239);
                                if (!(precpred(_ctx, 3)))
                                    throw new FailedPredicateException(this, "precpred(_ctx, 3)");
                                setState(240);
                                match(T__13);
                                setState(241);
                                condition(4);
                            }
                        }
                    }
                    setState(246);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 13, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public static class WhereCondSomeContext extends ParserRuleContext {
        public List<WhereCondBindingContext> whereCondBinding() {
            return getRuleContexts(WhereCondBindingContext.class);
        }

        public WhereCondBindingContext whereCondBinding(int i) {
            return getRuleContext(WhereCondBindingContext.class, i);
        }

        public WhereCondSomeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_whereCondSome;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterWhereCondSome(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitWhereCondSome(this);
        }
    }

    public final WhereCondSomeContext whereCondSome() throws RecognitionException {
        WhereCondSomeContext _localctx = new WhereCondSomeContext(_ctx, getState());
        enterRule(_localctx, 72, RULE_whereCondSome);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(247);
                whereCondBinding();
                setState(252);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__5) {
                    {
                        {
                            setState(248);
                            match(T__5);
                            setState(249);
                            whereCondBinding();
                        }
                    }
                    setState(254);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class WhereCondBindingContext extends ParserRuleContext {
        public WhereCondBindingVarContext whereCondBindingVar() {
            return getRuleContext(WhereCondBindingVarContext.class, 0);
        }

        public WhereCondBindingSourceContext whereCondBindingSource() {
            return getRuleContext(WhereCondBindingSourceContext.class, 0);
        }

        public WhereCondBindingContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_whereCondBinding;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterWhereCondBinding(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitWhereCondBinding(this);
        }
    }

    public final WhereCondBindingContext whereCondBinding() throws RecognitionException {
        WhereCondBindingContext _localctx = new WhereCondBindingContext(_ctx, getState());
        enterRule(_localctx, 74, RULE_whereCondBinding);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(255);
                whereCondBindingVar();
                setState(256);
                match(T__10);
                setState(257);
                whereCondBindingSource();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class WhereCondBindingVarContext extends ParserRuleContext {
        public VarContext var() {
            return getRuleContext(VarContext.class, 0);
        }

        public WhereCondBindingVarContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_whereCondBindingVar;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterWhereCondBindingVar(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitWhereCondBindingVar(this);
        }
    }

    public final WhereCondBindingVarContext whereCondBindingVar() throws RecognitionException {
        WhereCondBindingVarContext _localctx = new WhereCondBindingVarContext(_ctx, getState());
        enterRule(_localctx, 76, RULE_whereCondBindingVar);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(259);
                var();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class WhereCondBindingSourceContext extends ParserRuleContext {
        public SourceContext source() {
            return getRuleContext(SourceContext.class, 0);
        }

        public WhereCondBindingSourceContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_whereCondBindingSource;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterWhereCondBindingSource(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitWhereCondBindingSource(this);
        }
    }

    public final WhereCondBindingSourceContext whereCondBindingSource() throws RecognitionException {
        WhereCondBindingSourceContext _localctx = new WhereCondBindingSourceContext(_ctx, getState());
        enterRule(_localctx, 78, RULE_whereCondBindingSource);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(261);
                source();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class WhereCondEqualityContext extends ParserRuleContext {
        public WhereCondEqualityLeftTermContext whereCondEqualityLeftTerm() {
            return getRuleContext(WhereCondEqualityLeftTermContext.class, 0);
        }

        public WhereCondEqualityRightTermContext whereCondEqualityRightTerm() {
            return getRuleContext(WhereCondEqualityRightTermContext.class, 0);
        }

        public WhereCondEqualityContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_whereCondEquality;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterWhereCondEquality(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitWhereCondEquality(this);
        }
    }

    public final WhereCondEqualityContext whereCondEquality() throws RecognitionException {
        WhereCondEqualityContext _localctx = new WhereCondEqualityContext(_ctx, getState());
        enterRule(_localctx, 80, RULE_whereCondEquality);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(263);
                whereCondEqualityLeftTerm();
                setState(264);
                match(T__0);
                setState(265);
                whereCondEqualityRightTerm();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class WhereCondEqualityLeftTermContext extends ParserRuleContext {
        public CtermContext cterm() {
            return getRuleContext(CtermContext.class, 0);
        }

        public WhereCondEqualityLeftTermContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_whereCondEqualityLeftTerm;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterWhereCondEqualityLeftTerm(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitWhereCondEqualityLeftTerm(this);
        }
    }

    public final WhereCondEqualityLeftTermContext whereCondEqualityLeftTerm() throws RecognitionException {
        WhereCondEqualityLeftTermContext _localctx = new WhereCondEqualityLeftTermContext(_ctx, getState());
        enterRule(_localctx, 82, RULE_whereCondEqualityLeftTerm);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(267);
                cterm();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class WhereCondEqualityRightTermContext extends ParserRuleContext {
        public CtermContext cterm() {
            return getRuleContext(CtermContext.class, 0);
        }

        public WhereCondEqualityRightTermContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_whereCondEqualityRightTerm;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterWhereCondEqualityRightTerm(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitWhereCondEqualityRightTerm(this);
        }
    }

    public final WhereCondEqualityRightTermContext whereCondEqualityRightTerm() throws RecognitionException {
        WhereCondEqualityRightTermContext _localctx = new WhereCondEqualityRightTermContext(_ctx, getState());
        enterRule(_localctx, 84, RULE_whereCondEqualityRightTerm);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(269);
                cterm();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class CtermContext extends ParserRuleContext {
        public TermContext term() {
            return getRuleContext(TermContext.class, 0);
        }

        public CtermContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_cterm;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterCterm(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitCterm(this);
        }
    }

    public final CtermContext cterm() throws RecognitionException {
        CtermContext _localctx = new CtermContext(_ctx, getState());
        enterRule(_localctx, 86, RULE_cterm);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(271);
                term();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public static class ForWhereClausesContext extends ParserRuleContext {
        public ForClauseContext forClause() {
            return getRuleContext(ForClauseContext.class, 0);
        }

        public WhereClauseContext whereClause() {
            return getRuleContext(WhereClauseContext.class, 0);
        }

        public ForWhereClausesContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_forWhereClauses;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).enterForWhereClauses(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof AQLListener)
                ((AQLListener) listener).exitForWhereClauses(this);
        }
    }

    public final ForWhereClausesContext forWhereClauses() throws RecognitionException {
        ForWhereClausesContext _localctx = new ForWhereClausesContext(_ctx, getState());
        enterRule(_localctx, 88, RULE_forWhereClauses);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(273);
                forClause();
                setState(275);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__12) {
                    {
                        setState(274);
                        whereClause();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
        switch (ruleIndex) {
            case 35:
                return condition_sempred((ConditionContext) _localctx, predIndex);
        }
        return true;
    }

    private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
        switch (predIndex) {
            case 0:
                return precpred(_ctx, 3);
        }
        return true;
    }

    public static final String _serializedATN = "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\30\u0118\4\2\t\2"
            + "\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"
            + "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"
            + "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"
            + "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"
            + "\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"
            + ",\t,\4-\t-\4.\t.\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\5\2f\n\2\3\3\3\3"
            + "\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\5\6s\n\6\3\7\3\7\3\7\3\7\7\7y\n\7"
            + "\f\7\16\7|\13\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13"
            + "\3\13\5\13\u008c\n\13\3\f\3\f\3\f\3\f\3\f\5\f\u0093\n\f\3\r\3\r\3\16\3"
            + "\16\3\17\3\17\3\20\3\20\3\20\5\20\u009e\n\20\3\21\3\21\3\21\3\21\3\21"
            + "\5\21\u00a5\n\21\3\22\3\22\3\23\3\23\3\24\3\24\5\24\u00ad\n\24\3\25\3"
            + "\25\3\26\3\26\6\26\u00b3\n\26\r\26\16\26\u00b4\3\27\3\27\3\30\3\30\3\31"
            + "\3\31\5\31\u00bd\n\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\35"
            + "\3\35\3\36\3\36\3\36\3\36\7\36\u00ce\n\36\f\36\16\36\u00d1\13\36\3\37"
            + "\3\37\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3\"\5\"\u00de\n\"\3#\3#\3$\3$\3$\3"
            + "%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u00f0\n%\3%\3%\3%\7%\u00f5\n%\f%\16"
            + "%\u00f8\13%\3&\3&\3&\7&\u00fd\n&\f&\16&\u0100\13&\3\'\3\'\3\'\3\'\3(\3"
            + "(\3)\3)\3*\3*\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\5.\u0116\n.\3.\2\3H/\2\4\6"
            + "\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRT"
            + "VXZ\2\2\2\u00ff\2\\\3\2\2\2\4g\3\2\2\2\6i\3\2\2\2\bl\3\2\2\2\nn\3\2\2"
            + "\2\ft\3\2\2\2\16\177\3\2\2\2\20\u0083\3\2\2\2\22\u0085\3\2\2\2\24\u008b"
            + "\3\2\2\2\26\u0092\3\2\2\2\30\u0094\3\2\2\2\32\u0096\3\2\2\2\34\u0098\3"
            + "\2\2\2\36\u009d\3\2\2\2 \u00a4\3\2\2\2\"\u00a6\3\2\2\2$\u00a8\3\2\2\2"
            + "&\u00ac\3\2\2\2(\u00ae\3\2\2\2*\u00b0\3\2\2\2,\u00b6\3\2\2\2.\u00b8\3"
            + "\2\2\2\60\u00bc\3\2\2\2\62\u00be\3\2\2\2\64\u00c1\3\2\2\2\66\u00c5\3\2"
            + "\2\28\u00c7\3\2\2\2:\u00c9\3\2\2\2<\u00d2\3\2\2\2>\u00d6\3\2\2\2@\u00d8"
            + "\3\2\2\2B\u00dd\3\2\2\2D\u00df\3\2\2\2F\u00e1\3\2\2\2H\u00ef\3\2\2\2J"
            + "\u00f9\3\2\2\2L\u0101\3\2\2\2N\u0105\3\2\2\2P\u0107\3\2\2\2R\u0109\3\2"
            + "\2\2T\u010d\3\2\2\2V\u010f\3\2\2\2X\u0111\3\2\2\2Z\u0113\3\2\2\2\\]\5"
            + "\4\3\2]e\7\3\2\2^f\5\6\4\2_`\7\4\2\2`a\5\b\5\2ab\7\5\2\2bc\5\6\4\2cd\7"
            + "\6\2\2df\3\2\2\2e^\3\2\2\2e_\3\2\2\2f\3\3\2\2\2gh\7\25\2\2h\5\3\2\2\2"
            + "ij\5Z.\2jk\5\n\6\2k\7\3\2\2\2lm\5\22\n\2m\t\3\2\2\2nr\7\7\2\2os\5\f\7"
            + "\2ps\5\26\f\2qs\5\32\16\2ro\3\2\2\2rp\3\2\2\2rq\3\2\2\2s\13\3\2\2\2tu"
            + "\7\4\2\2uz\5\16\b\2vw\7\b\2\2wy\5\16\b\2xv\3\2\2\2y|\3\2\2\2zx\3\2\2\2"
            + "z{\3\2\2\2{}\3\2\2\2|z\3\2\2\2}~\7\6\2\2~\r\3\2\2\2\177\u0080\5\20\t\2"
            + "\u0080\u0081\7\5\2\2\u0081\u0082\5\24\13\2\u0082\17\3\2\2\2\u0083\u0084"
            + "\5\22\n\2\u0084\21\3\2\2\2\u0085\u0086\7\30\2\2\u0086\23\3\2\2\2\u0087"
            + "\u008c\5\f\7\2\u0088\u008c\5\26\f\2\u0089\u008c\5\32\16\2\u008a\u008c"
            + "\5\34\17\2\u008b\u0087\3\2\2\2\u008b\u0088\3\2\2\2\u008b\u0089\3\2\2\2"
            + "\u008b\u008a\3\2\2\2\u008c\25\3\2\2\2\u008d\u0093\5.\30\2\u008e\u008f"
            + "\5\30\r\2\u008f\u0090\7\t\2\2\u0090\u0091\7\25\2\2\u0091\u0093\3\2\2\2"
            + "\u0092\u008d\3\2\2\2\u0092\u008e\3\2\2\2\u0093\27\3\2\2\2\u0094\u0095"
            + "\7\25\2\2\u0095\31\3\2\2\2\u0096\u0097\5&\24\2\u0097\33\3\2\2\2\u0098"
            + "\u0099\5\6\4\2\u0099\35\3\2\2\2\u009a\u009e\5\"\22\2\u009b\u009e\5 \21"
            + "\2\u009c\u009e\5$\23\2\u009d\u009a\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009c"
            + "\3\2\2\2\u009e\37\3\2\2\2\u009f\u00a5\5.\30\2\u00a0\u00a1\5\30\r\2\u00a1"
            + "\u00a2\7\t\2\2\u00a2\u00a3\7\25\2\2\u00a3\u00a5\3\2\2\2\u00a4\u009f\3"
            + "\2\2\2\u00a4\u00a0\3\2\2\2\u00a5!\3\2\2\2\u00a6\u00a7\5&\24\2\u00a7#\3"
            + "\2\2\2\u00a8\u00a9\5*\26\2\u00a9%\3\2\2\2\u00aa\u00ad\5(\25\2\u00ab\u00ad"
            + "\7\30\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\'\3\2\2\2\u00ae"
            + "\u00af\7\26\2\2\u00af)\3\2\2\2\u00b0\u00b2\5,\27\2\u00b1\u00b3\5\60\31"
            + "\2\u00b2\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4\u00b5"
            + "\3\2\2\2\u00b5+\3\2\2\2\u00b6\u00b7\5.\30\2\u00b7-\3\2\2\2\u00b8\u00b9"
            + "\7\25\2\2\u00b9/\3\2\2\2\u00ba\u00bd\5\62\32\2\u00bb\u00bd\5\64\33\2\u00bc"
            + "\u00ba\3\2\2\2\u00bc\u00bb\3\2\2\2\u00bd\61\3\2\2\2\u00be\u00bf\7\t\2"
            + "\2\u00bf\u00c0\5\66\34\2\u00c0\63\3\2\2\2\u00c1\u00c2\7\n\2\2\u00c2\u00c3"
            + "\58\35\2\u00c3\u00c4\7\13\2\2\u00c4\65\3\2\2\2\u00c5\u00c6\7\25\2\2\u00c6"
            + "\67\3\2\2\2\u00c7\u00c8\5(\25\2\u00c89\3\2\2\2\u00c9\u00ca\7\f\2\2\u00ca"
            + "\u00cf\5<\37\2\u00cb\u00cc\7\b\2\2\u00cc\u00ce\5<\37\2\u00cd\u00cb\3\2"
            + "\2\2\u00ce\u00d1\3\2\2\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d0"
            + ";\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d3\5> \2\u00d3\u00d4\7\r\2\2\u00d4"
            + "\u00d5\5@!\2\u00d5=\3\2\2\2\u00d6\u00d7\5.\30\2\u00d7?\3\2\2\2\u00d8\u00d9"
            + "\5B\"\2\u00d9A\3\2\2\2\u00da\u00db\7\16\2\2\u00db\u00de\5D#\2\u00dc\u00de"
            + "\5*\26\2\u00dd\u00da\3\2\2\2\u00dd\u00dc\3\2\2\2\u00deC\3\2\2\2\u00df"
            + "\u00e0\7\25\2\2\u00e0E\3\2\2\2\u00e1\u00e2\7\17\2\2\u00e2\u00e3\5H%\2"
            + "\u00e3G\3\2\2\2\u00e4\u00e5\b%\1\2\u00e5\u00f0\5R*\2\u00e6\u00e7\7\21"
            + "\2\2\u00e7\u00e8\5J&\2\u00e8\u00e9\7\22\2\2\u00e9\u00ea\5H%\4\u00ea\u00f0"
            + "\3\2\2\2\u00eb\u00ec\7\23\2\2\u00ec\u00ed\5H%\2\u00ed\u00ee\7\24\2\2\u00ee"
            + "\u00f0\3\2\2\2\u00ef\u00e4\3\2\2\2\u00ef\u00e6\3\2\2\2\u00ef\u00eb\3\2"
            + "\2\2\u00f0\u00f6\3\2\2\2\u00f1\u00f2\f\5\2\2\u00f2\u00f3\7\20\2\2\u00f3"
            + "\u00f5\5H%\6\u00f4\u00f1\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4\3\2\2"
            + "\2\u00f6\u00f7\3\2\2\2\u00f7I\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9\u00fe"
            + "\5L\'\2\u00fa\u00fb\7\b\2\2\u00fb\u00fd\5L\'\2\u00fc\u00fa\3\2\2\2\u00fd"
            + "\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ffK\3\2\2\2"
            + "\u0100\u00fe\3\2\2\2\u0101\u0102\5N(\2\u0102\u0103\7\r\2\2\u0103\u0104"
            + "\5P)\2\u0104M\3\2\2\2\u0105\u0106\5.\30\2\u0106O\3\2\2\2\u0107\u0108\5"
            + "B\"\2\u0108Q\3\2\2\2\u0109\u010a\5T+\2\u010a\u010b\7\3\2\2\u010b\u010c"
            + "\5V,\2\u010cS\3\2\2\2\u010d\u010e\5X-\2\u010eU\3\2\2\2\u010f\u0110\5X"
            + "-\2\u0110W\3\2\2\2\u0111\u0112\5\36\20\2\u0112Y\3\2\2\2\u0113\u0115\5"
            + ":\36\2\u0114\u0116\5F$\2\u0115\u0114\3\2\2\2\u0115\u0116\3\2\2\2\u0116"
            + "[\3\2\2\2\22erz\u008b\u0092\u009d\u00a4\u00ac\u00b4\u00bc\u00cf\u00dd" + "\u00ef\u00f6\u00fe\u0115";
    public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}