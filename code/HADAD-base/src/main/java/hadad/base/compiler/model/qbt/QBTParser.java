// Generated from QBT.g4 by ANTLR 4.7.2

package hadad.base.compiler.model.qbt;

import java.util.List;

import org.antlr.v4.runtime.FailedPredicateException;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Token;
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
public class QBTParser extends Parser {
    static {
        RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
    public static final int T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9,
            T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15, T__15 = 16, T__16 = 17, T__17 = 18,
            T__18 = 19, T__19 = 20, T__20 = 21, T__21 = 22, T__22 = 23, T__23 = 24, T__24 = 25, FOR = 26, WHERE = 27,
            RETURN = 28, AJ = 29, RK = 30, PR = 31, SPPJ = 32, PJ = 33, SJ = 34, XQ = 35, TQ = 36, AND = 37, FROM = 38,
            IN = 39, SELECT = 40, AS = 41, LIKE = 42, QUERY = 43, JSONBUILDOBJECT = 44, JSONARRAYELEMENTS = 45,
            SOLRJSONBUILDOBJECT = 46, NAME = 47, STRING = 48, INTEGER = 49, WHITESPACE = 50, MAP = 51, KEYS = 52,
            LIST = 53, SET = 54, MAIN = 55, BETA = 56, WS = 57;
    public static final int RULE_mixedqbt = 0, RULE_viewName = 1, RULE_qbtQuery = 2, RULE_qbtBlock = 3,
            RULE_qbtForPattern = 4, RULE_qbtWherePattern = 5, RULE_qbtReturnPattern = 6, RULE_qbtPattern = 7,
            RULE_modelPattern = 8, RULE_ajPattern = 9, RULE_rkPattern = 10, RULE_prPattern = 11, RULE_sppjPattern = 12,
            RULE_pjPattern = 13, RULE_sjPattern = 14, RULE_qbtCondition = 15, RULE_qbtAtom = 16, RULE_qbtVariable = 17,
            RULE_modelPathExpr = 18, RULE_constructor = 19, RULE_modelConstructor = 20, RULE_ajConstructor = 21,
            RULE_rkConstructor = 22, RULE_sppjConstructor = 23, RULE_pjConstructor = 24, RULE_sjConstructor = 25,
            RULE_prConstructor = 26, RULE_annotation = 27, RULE_kqlquery = 28, RULE_redisKQLQuery = 29,
            RULE_sfwQuery = 30, RULE_rkSelectClasue = 31, RULE_rkSelectStatement = 32, RULE_rkSelectItem = 33,
            RULE_rkReturnVariable = 34, RULE_mapConstructor = 35, RULE_rkAttribute = 36, RULE_rkAttributeValue = 37,
            RULE_mapKey = 38, RULE_rkFromClasue = 39, RULE_varBinding = 40, RULE_fromvariableBinding = 41,
            RULE_rkSource = 42, RULE_rkLookUpExpression = 43, RULE_mainMap = 44, RULE_mapVariable = 45, RULE_rkKey = 46,
            RULE_rkStringKey = 47, RULE_variableKey = 48, RULE_keyVariable = 49, RULE_mapName = 50,
            RULE_rkVariable = 51, RULE_aqlquery = 52, RULE_query = 53, RULE_rootFieldName = 54, RULE_returnClause = 55,
            RULE_recordConstruct = 56, RULE_fieldBinding = 57, RULE_recordConstructFieldName = 58, RULE_fieldName = 59,
            RULE_fieldValue = 60, RULE_returnVar = 61, RULE_name = 62, RULE_returnConstant = 63, RULE_returnQuery = 64,
            RULE_term = 65, RULE_termVar = 66, RULE_termConstant = 67, RULE_termPath = 68, RULE_constant = 69,
            RULE_number = 70, RULE_path = 71, RULE_pathVar = 72, RULE_var = 73, RULE_step = 74, RULE_objectStep = 75,
            RULE_arrayStep = 76, RULE_key = 77, RULE_index = 78, RULE_forClause = 79, RULE_binding = 80,
            RULE_forClauseBindingVar = 81, RULE_forClauseBindingSource = 82, RULE_source = 83, RULE_dataSetName = 84,
            RULE_whereClause = 85, RULE_condition = 86, RULE_whereCondSome = 87, RULE_whereCondBinding = 88,
            RULE_whereCondBindingVar = 89, RULE_whereCondBindingSource = 90, RULE_whereCondEquality = 91,
            RULE_whereCondEqualityLeftTerm = 92, RULE_whereCondEqualityRightTerm = 93, RULE_cterm = 94,
            RULE_forWhereClauses = 95, RULE_rqQuery = 96, RULE_prSQuery = 97, RULE_prSfwQuery = 98,
            RULE_prFromWhereClauses = 99, RULE_prSelectClause = 100, RULE_prSelectStatement = 101,
            RULE_prSelectItem = 102, RULE_prFromClause = 103, RULE_prRelationBinding = 104, RULE_prSource = 105,
            RULE_prRelationName = 106, RULE_prVariable = 107, RULE_prWhereClause = 108, RULE_prWhereStatement = 109,
            RULE_prCondition = 110, RULE_prTerm = 111, RULE_prEquality = 112, RULE_prLikeExpression = 113,
            RULE_prLeftterm = 114, RULE_prRightterm = 115, RULE_realtion = 116, RULE_sjqlquery = 117,
            RULE_sjQuery = 118, RULE_sjCollectionName = 119, RULE_sjTextSearch = 120, RULE_sjLeftTerm = 121,
            RULE_sjRightTerm = 122, RULE_sjTerm = 123, RULE_sjProjectFields = 124, RULE_sjRecordConstruct = 125,
            RULE_sjFieldBinding = 126, RULE_sjRecordConstructFieldName = 127, RULE_sjKeyName = 128,
            RULE_sjFieldValue = 129, RULE_sjFieldName = 130, RULE_sjVar = 131, RULE_sjConstant = 132,
            RULE_pjqlQuery = 133, RULE_pjQuery = 134, RULE_pjSelectClause = 135, RULE_pjSelectStatement = 136,
            RULE_pjSelectItem = 137, RULE_pjPathSelect = 138, RULE_pjRecordConstruct = 139, RULE_pjFieldBinding = 140,
            RULE_pjRecordConstructFieldName = 141, RULE_pjFieldValue = 142, RULE_pjSelectVar = 143,
            RULE_pjSelectConstant = 144, RULE_pjSelectQuery = 145, RULE_pjFromWhereClause = 146,
            RULE_pjFromClause = 147, RULE_pjBinding = 148, RULE_pjFromClauseBindingSource = 149, RULE_pjSource = 150,
            RULE_pjFromClauseBindingVar = 151, RULE_pjWhereClause = 152, RULE_pjCondition = 153,
            RULE_pjWhereCondEquality = 154, RULE_pjWhereCondEqualityLeftTerm = 155,
            RULE_pjWhereCondEqualityRightTerm = 156, RULE_pjCTerm = 157, RULE_pjTerm = 158, RULE_pjTermVar = 159,
            RULE_pjTermConstant = 160, RULE_pjTermPath = 161, RULE_pjPath = 162, RULE_pjPathVar = 163,
            RULE_pjStep = 164, RULE_pjObjStep = 165, RULE_pjPathAttr = 166, RULE_pjVariable = 167,
            RULE_pjRelation = 168, RULE_pjKey = 169, RULE_pjConstant = 170, RULE_attribute = 171,
            RULE_sppjqlQuery = 172, RULE_sppjQuery = 173, RULE_sppjRootFieldName = 174, RULE_sppjSelectClause = 175,
            RULE_sppjSelectStatement = 176, RULE_sppjSelectItem = 177, RULE_sppjRecordConstruct = 178,
            RULE_sppjFieldBinding = 179, RULE_sppjRecordConstructFieldName = 180, RULE_sppjFieldValue = 181,
            RULE_sppjSelectVar = 182, RULE_sppjSelectConstant = 183, RULE_sppjSelectQuery = 184,
            RULE_sppjFromWhereClause = 185, RULE_sppjFromClause = 186, RULE_sppjBinding = 187,
            RULE_sppjFromClauseBindingSource = 188, RULE_sppjSource = 189, RULE_sppjFromClauseBindingVar = 190,
            RULE_sppjWhereClause = 191, RULE_sppjCondition = 192, RULE_sppjWhereCondEquality = 193,
            RULE_sppjWhereCondEqualityLeftTerm = 194, RULE_sppjWhereCondEqualityRightTerm = 195, RULE_sppjCTerm = 196,
            RULE_sppjTerm = 197, RULE_sppjTermVar = 198, RULE_sppjTermConstant = 199, RULE_sppjTermPath = 200,
            RULE_sppjPath = 201, RULE_sppjPathVar = 202, RULE_sppjStep = 203, RULE_sppjObjStep = 204,
            RULE_sppjVariable = 205, RULE_sppjFieldName = 206, RULE_sppjConstant = 207;

    private static String[] makeRuleNames() {
        return new String[] { "mixedqbt", "viewName", "qbtQuery", "qbtBlock", "qbtForPattern", "qbtWherePattern",
                "qbtReturnPattern", "qbtPattern", "modelPattern", "ajPattern", "rkPattern", "prPattern", "sppjPattern",
                "pjPattern", "sjPattern", "qbtCondition", "qbtAtom", "qbtVariable", "modelPathExpr", "constructor",
                "modelConstructor", "ajConstructor", "rkConstructor", "sppjConstructor", "pjConstructor",
                "sjConstructor", "prConstructor", "annotation", "kqlquery", "redisKQLQuery", "sfwQuery",
                "rkSelectClasue", "rkSelectStatement", "rkSelectItem", "rkReturnVariable", "mapConstructor",
                "rkAttribute", "rkAttributeValue", "mapKey", "rkFromClasue", "varBinding", "fromvariableBinding",
                "rkSource", "rkLookUpExpression", "mainMap", "mapVariable", "rkKey", "rkStringKey", "variableKey",
                "keyVariable", "mapName", "rkVariable", "aqlquery", "query", "rootFieldName", "returnClause",
                "recordConstruct", "fieldBinding", "recordConstructFieldName", "fieldName", "fieldValue", "returnVar",
                "name", "returnConstant", "returnQuery", "term", "termVar", "termConstant", "termPath", "constant",
                "number", "path", "pathVar", "var", "step", "objectStep", "arrayStep", "key", "index", "forClause",
                "binding", "forClauseBindingVar", "forClauseBindingSource", "source", "dataSetName", "whereClause",
                "condition", "whereCondSome", "whereCondBinding", "whereCondBindingVar", "whereCondBindingSource",
                "whereCondEquality", "whereCondEqualityLeftTerm", "whereCondEqualityRightTerm", "cterm",
                "forWhereClauses", "rqQuery", "prSQuery", "prSfwQuery", "prFromWhereClauses", "prSelectClause",
                "prSelectStatement", "prSelectItem", "prFromClause", "prRelationBinding", "prSource", "prRelationName",
                "prVariable", "prWhereClause", "prWhereStatement", "prCondition", "prTerm", "prEquality",
                "prLikeExpression", "prLeftterm", "prRightterm", "realtion", "sjqlquery", "sjQuery", "sjCollectionName",
                "sjTextSearch", "sjLeftTerm", "sjRightTerm", "sjTerm", "sjProjectFields", "sjRecordConstruct",
                "sjFieldBinding", "sjRecordConstructFieldName", "sjKeyName", "sjFieldValue", "sjFieldName", "sjVar",
                "sjConstant", "pjqlQuery", "pjQuery", "pjSelectClause", "pjSelectStatement", "pjSelectItem",
                "pjPathSelect", "pjRecordConstruct", "pjFieldBinding", "pjRecordConstructFieldName", "pjFieldValue",
                "pjSelectVar", "pjSelectConstant", "pjSelectQuery", "pjFromWhereClause", "pjFromClause", "pjBinding",
                "pjFromClauseBindingSource", "pjSource", "pjFromClauseBindingVar", "pjWhereClause", "pjCondition",
                "pjWhereCondEquality", "pjWhereCondEqualityLeftTerm", "pjWhereCondEqualityRightTerm", "pjCTerm",
                "pjTerm", "pjTermVar", "pjTermConstant", "pjTermPath", "pjPath", "pjPathVar", "pjStep", "pjObjStep",
                "pjPathAttr", "pjVariable", "pjRelation", "pjKey", "pjConstant", "attribute", "sppjqlQuery",
                "sppjQuery", "sppjRootFieldName", "sppjSelectClause", "sppjSelectStatement", "sppjSelectItem",
                "sppjRecordConstruct", "sppjFieldBinding", "sppjRecordConstructFieldName", "sppjFieldValue",
                "sppjSelectVar", "sppjSelectConstant", "sppjSelectQuery", "sppjFromWhereClause", "sppjFromClause",
                "sppjBinding", "sppjFromClauseBindingSource", "sppjSource", "sppjFromClauseBindingVar",
                "sppjWhereClause", "sppjCondition", "sppjWhereCondEquality", "sppjWhereCondEqualityLeftTerm",
                "sppjWhereCondEqualityRightTerm", "sppjCTerm", "sppjTerm", "sppjTermVar", "sppjTermConstant",
                "sppjTermPath", "sppjPath", "sppjPathVar", "sppjStep", "sppjObjStep", "sppjVariable", "sppjFieldName",
                "sppjConstant" };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[] { null, "'='", "','", "':'", "'{'", "'}'", "'('", "')'", "'-'", "'>'", "'.'", "'['", "']'",
                "'return'", "'for'", "'in'", "'dataset'", "'where'", "'and'", "'some'", "'satisfies'", "'/'", "'?q='",
                "'&'", "'fl='", "'->'" };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[] { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, "FOR", "WHERE", "RETURN", "AJ", "RK",
                "PR", "SPPJ", "PJ", "SJ", "XQ", "TQ", "AND", "FROM", "IN", "SELECT", "AS", "LIKE", "QUERY",
                "JSONBUILDOBJECT", "JSONARRAYELEMENTS", "SOLRJSONBUILDOBJECT", "NAME", "STRING", "INTEGER",
                "WHITESPACE", "MAP", "KEYS", "LIST", "SET", "MAIN", "BETA", "WS" };
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
        return "QBT.g4";
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

    public QBTParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    public static class MixedqbtContext extends ParserRuleContext {
        public ViewNameContext viewName() {
            return getRuleContext(ViewNameContext.class, 0);
        }

        public QbtQueryContext qbtQuery() {
            return getRuleContext(QbtQueryContext.class, 0);
        }

        public TerminalNode EOF() {
            return getToken(QBTParser.EOF, 0);
        }

        public MixedqbtContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_mixedqbt;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterMixedqbt(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitMixedqbt(this);
        }
    }

    public final MixedqbtContext mixedqbt() throws RecognitionException {
        MixedqbtContext _localctx = new MixedqbtContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_mixedqbt);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(416);
                viewName();
                setState(417);
                match(T__0);
                setState(418);
                qbtQuery();
                setState(419);
                match(EOF);
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
            return getToken(QBTParser.NAME, 0);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterViewName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitViewName(this);
        }
    }

    public final ViewNameContext viewName() throws RecognitionException {
        ViewNameContext _localctx = new ViewNameContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_viewName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(421);
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

    public static class QbtQueryContext extends ParserRuleContext {
        public QbtBlockContext qbtBlock() {
            return getRuleContext(QbtBlockContext.class, 0);
        }

        public QbtQueryContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_qbtQuery;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterQbtQuery(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitQbtQuery(this);
        }
    }

    public final QbtQueryContext qbtQuery() throws RecognitionException {
        QbtQueryContext _localctx = new QbtQueryContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_qbtQuery);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(423);
                qbtBlock();
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

    public static class QbtBlockContext extends ParserRuleContext {
        public QbtForPatternContext qbtForPattern() {
            return getRuleContext(QbtForPatternContext.class, 0);
        }

        public QbtReturnPatternContext qbtReturnPattern() {
            return getRuleContext(QbtReturnPatternContext.class, 0);
        }

        public QbtWherePatternContext qbtWherePattern() {
            return getRuleContext(QbtWherePatternContext.class, 0);
        }

        public QbtBlockContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_qbtBlock;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterQbtBlock(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitQbtBlock(this);
        }
    }

    public final QbtBlockContext qbtBlock() throws RecognitionException {
        QbtBlockContext _localctx = new QbtBlockContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_qbtBlock);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(425);
                qbtForPattern();
                setState(427);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == WHERE) {
                    {
                        setState(426);
                        qbtWherePattern();
                    }
                }

                setState(429);
                qbtReturnPattern();
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

    public static class QbtForPatternContext extends ParserRuleContext {
        public TerminalNode FOR() {
            return getToken(QBTParser.FOR, 0);
        }

        public List<QbtPatternContext> qbtPattern() {
            return getRuleContexts(QbtPatternContext.class);
        }

        public QbtPatternContext qbtPattern(int i) {
            return getRuleContext(QbtPatternContext.class, i);
        }

        public QbtForPatternContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_qbtForPattern;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterQbtForPattern(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitQbtForPattern(this);
        }
    }

    public final QbtForPatternContext qbtForPattern() throws RecognitionException {
        QbtForPatternContext _localctx = new QbtForPatternContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_qbtForPattern);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(431);
                match(FOR);
                setState(432);
                qbtPattern();
                setState(437);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__1) {
                    {
                        {
                            setState(433);
                            match(T__1);
                            setState(434);
                            qbtPattern();
                        }
                    }
                    setState(439);
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

    public static class QbtWherePatternContext extends ParserRuleContext {
        public TerminalNode WHERE() {
            return getToken(QBTParser.WHERE, 0);
        }

        public QbtConditionContext qbtCondition() {
            return getRuleContext(QbtConditionContext.class, 0);
        }

        public QbtWherePatternContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_qbtWherePattern;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterQbtWherePattern(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitQbtWherePattern(this);
        }
    }

    public final QbtWherePatternContext qbtWherePattern() throws RecognitionException {
        QbtWherePatternContext _localctx = new QbtWherePatternContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_qbtWherePattern);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(440);
                match(WHERE);
                setState(441);
                qbtCondition(0);
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

    public static class QbtReturnPatternContext extends ParserRuleContext {
        public TerminalNode RETURN() {
            return getToken(QBTParser.RETURN, 0);
        }

        public ConstructorContext constructor() {
            return getRuleContext(ConstructorContext.class, 0);
        }

        public QbtReturnPatternContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_qbtReturnPattern;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterQbtReturnPattern(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitQbtReturnPattern(this);
        }
    }

    public final QbtReturnPatternContext qbtReturnPattern() throws RecognitionException {
        QbtReturnPatternContext _localctx = new QbtReturnPatternContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_qbtReturnPattern);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(443);
                match(RETURN);
                setState(444);
                constructor();
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

    public static class QbtPatternContext extends ParserRuleContext {
        public AnnotationContext annotation() {
            return getRuleContext(AnnotationContext.class, 0);
        }

        public ModelPatternContext modelPattern() {
            return getRuleContext(ModelPatternContext.class, 0);
        }

        public QbtPatternContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_qbtPattern;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterQbtPattern(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitQbtPattern(this);
        }
    }

    public final QbtPatternContext qbtPattern() throws RecognitionException {
        QbtPatternContext _localctx = new QbtPatternContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_qbtPattern);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(446);
                annotation();
                setState(447);
                match(T__2);
                setState(448);
                match(T__3);
                setState(449);
                modelPattern();
                setState(450);
                match(T__4);
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

    public static class ModelPatternContext extends ParserRuleContext {
        public AjPatternContext ajPattern() {
            return getRuleContext(AjPatternContext.class, 0);
        }

        public RkPatternContext rkPattern() {
            return getRuleContext(RkPatternContext.class, 0);
        }

        public PrPatternContext prPattern() {
            return getRuleContext(PrPatternContext.class, 0);
        }

        public SppjPatternContext sppjPattern() {
            return getRuleContext(SppjPatternContext.class, 0);
        }

        public PjPatternContext pjPattern() {
            return getRuleContext(PjPatternContext.class, 0);
        }

        public SjPatternContext sjPattern() {
            return getRuleContext(SjPatternContext.class, 0);
        }

        public ModelPatternContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_modelPattern;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterModelPattern(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitModelPattern(this);
        }
    }

    public final ModelPatternContext modelPattern() throws RecognitionException {
        ModelPatternContext _localctx = new ModelPatternContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_modelPattern);
        try {
            setState(458);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(452);
                    ajPattern();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(453);
                    rkPattern();
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(454);
                    prPattern();
                }
                    break;
                case 4:
                    enterOuterAlt(_localctx, 4); {
                    setState(455);
                    sppjPattern();
                }
                    break;
                case 5:
                    enterOuterAlt(_localctx, 5); {
                    setState(456);
                    pjPattern();
                }
                    break;
                case 6:
                    enterOuterAlt(_localctx, 6); {
                    setState(457);
                    sjPattern();
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

    public static class AjPatternContext extends ParserRuleContext {
        public ForClauseContext forClause() {
            return getRuleContext(ForClauseContext.class, 0);
        }

        public WhereClauseContext whereClause() {
            return getRuleContext(WhereClauseContext.class, 0);
        }

        public AjPatternContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_ajPattern;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterAjPattern(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitAjPattern(this);
        }
    }

    public final AjPatternContext ajPattern() throws RecognitionException {
        AjPatternContext _localctx = new AjPatternContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_ajPattern);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(460);
                forClause();
                setState(462);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__16) {
                    {
                        setState(461);
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

    public static class RkPatternContext extends ParserRuleContext {
        public RkFromClasueContext rkFromClasue() {
            return getRuleContext(RkFromClasueContext.class, 0);
        }

        public RkPatternContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_rkPattern;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterRkPattern(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitRkPattern(this);
        }
    }

    public final RkPatternContext rkPattern() throws RecognitionException {
        RkPatternContext _localctx = new RkPatternContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_rkPattern);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(464);
                rkFromClasue();
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

    public static class PrPatternContext extends ParserRuleContext {
        public PrSQueryContext prSQuery() {
            return getRuleContext(PrSQueryContext.class, 0);
        }

        public PrPatternContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prPattern;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPrPattern(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPrPattern(this);
        }
    }

    public final PrPatternContext prPattern() throws RecognitionException {
        PrPatternContext _localctx = new PrPatternContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_prPattern);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(466);
                prSQuery();
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

    public static class SppjPatternContext extends ParserRuleContext {
        public SppjFromWhereClauseContext sppjFromWhereClause() {
            return getRuleContext(SppjFromWhereClauseContext.class, 0);
        }

        public SppjPatternContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjPattern;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjPattern(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjPattern(this);
        }
    }

    public final SppjPatternContext sppjPattern() throws RecognitionException {
        SppjPatternContext _localctx = new SppjPatternContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_sppjPattern);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(468);
                sppjFromWhereClause();
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

    public static class PjPatternContext extends ParserRuleContext {
        public PjQueryContext pjQuery() {
            return getRuleContext(PjQueryContext.class, 0);
        }

        public PjPatternContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjPattern;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjPattern(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjPattern(this);
        }
    }

    public final PjPatternContext pjPattern() throws RecognitionException {
        PjPatternContext _localctx = new PjPatternContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_pjPattern);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(470);
                pjQuery();
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

    public static class SjPatternContext extends ParserRuleContext {
        public SjQueryContext sjQuery() {
            return getRuleContext(SjQueryContext.class, 0);
        }

        public SjPatternContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sjPattern;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSjPattern(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSjPattern(this);
        }
    }

    public final SjPatternContext sjPattern() throws RecognitionException {
        SjPatternContext _localctx = new SjPatternContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_sjPattern);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(472);
                sjQuery();
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

    public static class QbtConditionContext extends ParserRuleContext {
        public QbtAtomContext qbtAtom() {
            return getRuleContext(QbtAtomContext.class, 0);
        }

        public List<QbtConditionContext> qbtCondition() {
            return getRuleContexts(QbtConditionContext.class);
        }

        public QbtConditionContext qbtCondition(int i) {
            return getRuleContext(QbtConditionContext.class, i);
        }

        public TerminalNode AND() {
            return getToken(QBTParser.AND, 0);
        }

        public QbtConditionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_qbtCondition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterQbtCondition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitQbtCondition(this);
        }
    }

    public final QbtConditionContext qbtCondition() throws RecognitionException {
        return qbtCondition(0);
    }

    private QbtConditionContext qbtCondition(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        QbtConditionContext _localctx = new QbtConditionContext(_ctx, _parentState);
        QbtConditionContext _prevctx = _localctx;
        int _startState = 30;
        enterRecursionRule(_localctx, 30, RULE_qbtCondition, _p);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(480);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 4, _ctx)) {
                    case 1: {
                        setState(475);
                        qbtAtom();
                    }
                        break;
                    case 2: {
                        setState(476);
                        match(T__5);
                        setState(477);
                        qbtCondition(0);
                        setState(478);
                        match(T__6);
                    }
                        break;
                }
                _ctx.stop = _input.LT(-1);
                setState(487);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 5, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null)
                            triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            {
                                _localctx = new QbtConditionContext(_parentctx, _parentState);
                                pushNewRecursionContext(_localctx, _startState, RULE_qbtCondition);
                                setState(482);
                                if (!(precpred(_ctx, 1)))
                                    throw new FailedPredicateException(this, "precpred(_ctx, 1)");
                                setState(483);
                                match(AND);
                                setState(484);
                                qbtCondition(2);
                            }
                        }
                    }
                    setState(489);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 5, _ctx);
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

    public static class QbtAtomContext extends ParserRuleContext {
        public QbtAtomContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_qbtAtom;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterQbtAtom(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitQbtAtom(this);
        }
    }

    public final QbtAtomContext qbtAtom() throws RecognitionException {
        QbtAtomContext _localctx = new QbtAtomContext(_ctx, getState());
        enterRule(_localctx, 32, RULE_qbtAtom);
        try {
            enterOuterAlt(_localctx, 1);
            {
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

    public static class QbtVariableContext extends ParserRuleContext {
        public TerminalNode NAME() {
            return getToken(QBTParser.NAME, 0);
        }

        public QbtVariableContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_qbtVariable;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterQbtVariable(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitQbtVariable(this);
        }
    }

    public final QbtVariableContext qbtVariable() throws RecognitionException {
        QbtVariableContext _localctx = new QbtVariableContext(_ctx, getState());
        enterRule(_localctx, 34, RULE_qbtVariable);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(492);
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

    public static class ModelPathExprContext extends ParserRuleContext {
        public ModelPathExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_modelPathExpr;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterModelPathExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitModelPathExpr(this);
        }
    }

    public final ModelPathExprContext modelPathExpr() throws RecognitionException {
        ModelPathExprContext _localctx = new ModelPathExprContext(_ctx, getState());
        enterRule(_localctx, 36, RULE_modelPathExpr);
        try {
            enterOuterAlt(_localctx, 1);
            {
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

    public static class ConstructorContext extends ParserRuleContext {
        public AnnotationContext annotation() {
            return getRuleContext(AnnotationContext.class, 0);
        }

        public ModelConstructorContext modelConstructor() {
            return getRuleContext(ModelConstructorContext.class, 0);
        }

        public ConstructorContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_constructor;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterConstructor(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitConstructor(this);
        }
    }

    public final ConstructorContext constructor() throws RecognitionException {
        ConstructorContext _localctx = new ConstructorContext(_ctx, getState());
        enterRule(_localctx, 38, RULE_constructor);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(496);
                annotation();
                setState(497);
                match(T__2);
                setState(498);
                match(T__3);
                setState(499);
                modelConstructor();
                setState(500);
                match(T__4);
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

    public static class ModelConstructorContext extends ParserRuleContext {
        public AjConstructorContext ajConstructor() {
            return getRuleContext(AjConstructorContext.class, 0);
        }

        public RkConstructorContext rkConstructor() {
            return getRuleContext(RkConstructorContext.class, 0);
        }

        public SppjConstructorContext sppjConstructor() {
            return getRuleContext(SppjConstructorContext.class, 0);
        }

        public PjConstructorContext pjConstructor() {
            return getRuleContext(PjConstructorContext.class, 0);
        }

        public SjConstructorContext sjConstructor() {
            return getRuleContext(SjConstructorContext.class, 0);
        }

        public PrConstructorContext prConstructor() {
            return getRuleContext(PrConstructorContext.class, 0);
        }

        public ModelConstructorContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_modelConstructor;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterModelConstructor(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitModelConstructor(this);
        }
    }

    public final ModelConstructorContext modelConstructor() throws RecognitionException {
        ModelConstructorContext _localctx = new ModelConstructorContext(_ctx, getState());
        enterRule(_localctx, 40, RULE_modelConstructor);
        try {
            setState(508);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 6, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(502);
                    ajConstructor();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(503);
                    rkConstructor();
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(504);
                    sppjConstructor();
                }
                    break;
                case 4:
                    enterOuterAlt(_localctx, 4); {
                    setState(505);
                    pjConstructor();
                }
                    break;
                case 5:
                    enterOuterAlt(_localctx, 5); {
                    setState(506);
                    sjConstructor();
                }
                    break;
                case 6:
                    enterOuterAlt(_localctx, 6); {
                    setState(507);
                    prConstructor();
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

    public static class AjConstructorContext extends ParserRuleContext {
        public RecordConstructContext recordConstruct() {
            return getRuleContext(RecordConstructContext.class, 0);
        }

        public AjConstructorContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_ajConstructor;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterAjConstructor(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitAjConstructor(this);
        }
    }

    public final AjConstructorContext ajConstructor() throws RecognitionException {
        AjConstructorContext _localctx = new AjConstructorContext(_ctx, getState());
        enterRule(_localctx, 42, RULE_ajConstructor);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(510);
                recordConstruct();
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

    public static class RkConstructorContext extends ParserRuleContext {
        public MapConstructorContext mapConstructor() {
            return getRuleContext(MapConstructorContext.class, 0);
        }

        public RkConstructorContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_rkConstructor;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterRkConstructor(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitRkConstructor(this);
        }
    }

    public final RkConstructorContext rkConstructor() throws RecognitionException {
        RkConstructorContext _localctx = new RkConstructorContext(_ctx, getState());
        enterRule(_localctx, 44, RULE_rkConstructor);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(512);
                mapConstructor();
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

    public static class SppjConstructorContext extends ParserRuleContext {
        public SppjRecordConstructContext sppjRecordConstruct() {
            return getRuleContext(SppjRecordConstructContext.class, 0);
        }

        public SppjConstructorContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjConstructor;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjConstructor(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjConstructor(this);
        }
    }

    public final SppjConstructorContext sppjConstructor() throws RecognitionException {
        SppjConstructorContext _localctx = new SppjConstructorContext(_ctx, getState());
        enterRule(_localctx, 46, RULE_sppjConstructor);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(514);
                sppjRecordConstruct();
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

    public static class PjConstructorContext extends ParserRuleContext {
        public PjRecordConstructContext pjRecordConstruct() {
            return getRuleContext(PjRecordConstructContext.class, 0);
        }

        public PjConstructorContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjConstructor;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjConstructor(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjConstructor(this);
        }
    }

    public final PjConstructorContext pjConstructor() throws RecognitionException {
        PjConstructorContext _localctx = new PjConstructorContext(_ctx, getState());
        enterRule(_localctx, 48, RULE_pjConstructor);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(516);
                pjRecordConstruct();
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

    public static class SjConstructorContext extends ParserRuleContext {
        public SjRecordConstructContext sjRecordConstruct() {
            return getRuleContext(SjRecordConstructContext.class, 0);
        }

        public SjConstructorContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sjConstructor;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSjConstructor(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSjConstructor(this);
        }
    }

    public final SjConstructorContext sjConstructor() throws RecognitionException {
        SjConstructorContext _localctx = new SjConstructorContext(_ctx, getState());
        enterRule(_localctx, 50, RULE_sjConstructor);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(518);
                sjRecordConstruct();
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

    public static class PrConstructorContext extends ParserRuleContext {
        public PrSelectStatementContext prSelectStatement() {
            return getRuleContext(PrSelectStatementContext.class, 0);
        }

        public PrConstructorContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prConstructor;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPrConstructor(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPrConstructor(this);
        }
    }

    public final PrConstructorContext prConstructor() throws RecognitionException {
        PrConstructorContext _localctx = new PrConstructorContext(_ctx, getState());
        enterRule(_localctx, 52, RULE_prConstructor);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(520);
                prSelectStatement();
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

    public static class AnnotationContext extends ParserRuleContext {
        public TerminalNode AJ() {
            return getToken(QBTParser.AJ, 0);
        }

        public TerminalNode RK() {
            return getToken(QBTParser.RK, 0);
        }

        public TerminalNode PR() {
            return getToken(QBTParser.PR, 0);
        }

        public TerminalNode PJ() {
            return getToken(QBTParser.PJ, 0);
        }

        public TerminalNode SPPJ() {
            return getToken(QBTParser.SPPJ, 0);
        }

        public TerminalNode SJ() {
            return getToken(QBTParser.SJ, 0);
        }

        public TerminalNode TQ() {
            return getToken(QBTParser.TQ, 0);
        }

        public AnnotationContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_annotation;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterAnnotation(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitAnnotation(this);
        }
    }

    public final AnnotationContext annotation() throws RecognitionException {
        AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
        enterRule(_localctx, 54, RULE_annotation);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(522);
                _la = _input.LA(1);
                if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AJ) | (1L << RK) | (1L << PR) | (1L << SPPJ)
                        | (1L << PJ) | (1L << SJ) | (1L << TQ))) != 0))) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF)
                        matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
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

    public static class KqlqueryContext extends ParserRuleContext {
        public ViewNameContext viewName() {
            return getRuleContext(ViewNameContext.class, 0);
        }

        public RedisKQLQueryContext redisKQLQuery() {
            return getRuleContext(RedisKQLQueryContext.class, 0);
        }

        public TerminalNode EOF() {
            return getToken(QBTParser.EOF, 0);
        }

        public KqlqueryContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_kqlquery;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterKqlquery(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitKqlquery(this);
        }
    }

    public final KqlqueryContext kqlquery() throws RecognitionException {
        KqlqueryContext _localctx = new KqlqueryContext(_ctx, getState());
        enterRule(_localctx, 56, RULE_kqlquery);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(524);
                viewName();
                setState(525);
                match(T__0);
                setState(526);
                redisKQLQuery();
                setState(527);
                match(EOF);
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

    public static class RedisKQLQueryContext extends ParserRuleContext {
        public SfwQueryContext sfwQuery() {
            return getRuleContext(SfwQueryContext.class, 0);
        }

        public RedisKQLQueryContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_redisKQLQuery;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterRedisKQLQuery(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitRedisKQLQuery(this);
        }
    }

    public final RedisKQLQueryContext redisKQLQuery() throws RecognitionException {
        RedisKQLQueryContext _localctx = new RedisKQLQueryContext(_ctx, getState());
        enterRule(_localctx, 58, RULE_redisKQLQuery);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(529);
                sfwQuery();
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

    public static class SfwQueryContext extends ParserRuleContext {
        public RkSelectClasueContext rkSelectClasue() {
            return getRuleContext(RkSelectClasueContext.class, 0);
        }

        public RkFromClasueContext rkFromClasue() {
            return getRuleContext(RkFromClasueContext.class, 0);
        }

        public SfwQueryContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sfwQuery;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSfwQuery(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSfwQuery(this);
        }
    }

    public final SfwQueryContext sfwQuery() throws RecognitionException {
        SfwQueryContext _localctx = new SfwQueryContext(_ctx, getState());
        enterRule(_localctx, 60, RULE_sfwQuery);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(531);
                rkSelectClasue();
                setState(532);
                rkFromClasue();
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

    public static class RkSelectClasueContext extends ParserRuleContext {
        public RkSelectStatementContext rkSelectStatement() {
            return getRuleContext(RkSelectStatementContext.class, 0);
        }

        public RkSelectClasueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_rkSelectClasue;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterRkSelectClasue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitRkSelectClasue(this);
        }
    }

    public final RkSelectClasueContext rkSelectClasue() throws RecognitionException {
        RkSelectClasueContext _localctx = new RkSelectClasueContext(_ctx, getState());
        enterRule(_localctx, 62, RULE_rkSelectClasue);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(534);
                rkSelectStatement();
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

    public static class RkSelectStatementContext extends ParserRuleContext {
        public TerminalNode SELECT() {
            return getToken(QBTParser.SELECT, 0);
        }

        public RkSelectItemContext rkSelectItem() {
            return getRuleContext(RkSelectItemContext.class, 0);
        }

        public RkSelectStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_rkSelectStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterRkSelectStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitRkSelectStatement(this);
        }
    }

    public final RkSelectStatementContext rkSelectStatement() throws RecognitionException {
        RkSelectStatementContext _localctx = new RkSelectStatementContext(_ctx, getState());
        enterRule(_localctx, 64, RULE_rkSelectStatement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(536);
                match(SELECT);
                setState(537);
                rkSelectItem();
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

    public static class RkSelectItemContext extends ParserRuleContext {
        public RkReturnVariableContext rkReturnVariable() {
            return getRuleContext(RkReturnVariableContext.class, 0);
        }

        public MapConstructorContext mapConstructor() {
            return getRuleContext(MapConstructorContext.class, 0);
        }

        public RkSelectItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_rkSelectItem;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterRkSelectItem(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitRkSelectItem(this);
        }
    }

    public final RkSelectItemContext rkSelectItem() throws RecognitionException {
        RkSelectItemContext _localctx = new RkSelectItemContext(_ctx, getState());
        enterRule(_localctx, 66, RULE_rkSelectItem);
        try {
            setState(541);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 7, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(539);
                    rkReturnVariable();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(540);
                    mapConstructor();
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

    public static class RkReturnVariableContext extends ParserRuleContext {
        public RkVariableContext rkVariable() {
            return getRuleContext(RkVariableContext.class, 0);
        }

        public RkReturnVariableContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_rkReturnVariable;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterRkReturnVariable(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitRkReturnVariable(this);
        }
    }

    public final RkReturnVariableContext rkReturnVariable() throws RecognitionException {
        RkReturnVariableContext _localctx = new RkReturnVariableContext(_ctx, getState());
        enterRule(_localctx, 68, RULE_rkReturnVariable);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(543);
                rkVariable();
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

    public static class MapConstructorContext extends ParserRuleContext {
        public MapKeyContext mapKey() {
            return getRuleContext(MapKeyContext.class, 0);
        }

        public List<RkAttributeContext> rkAttribute() {
            return getRuleContexts(RkAttributeContext.class);
        }

        public RkAttributeContext rkAttribute(int i) {
            return getRuleContext(RkAttributeContext.class, i);
        }

        public MapConstructorContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_mapConstructor;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterMapConstructor(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitMapConstructor(this);
        }
    }

    public final MapConstructorContext mapConstructor() throws RecognitionException {
        MapConstructorContext _localctx = new MapConstructorContext(_ctx, getState());
        enterRule(_localctx, 70, RULE_mapConstructor);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(545);
                mapKey();
                setState(546);
                match(T__7);
                setState(547);
                match(T__8);
                setState(548);
                match(T__3);
                setState(549);
                rkAttribute();
                setState(554);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__1) {
                    {
                        {
                            setState(550);
                            match(T__1);
                            setState(551);
                            rkAttribute();
                        }
                    }
                    setState(556);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(557);
                match(T__4);
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

    public static class RkAttributeContext extends ParserRuleContext {
        public RkStringKeyContext rkStringKey() {
            return getRuleContext(RkStringKeyContext.class, 0);
        }

        public RkAttributeValueContext rkAttributeValue() {
            return getRuleContext(RkAttributeValueContext.class, 0);
        }

        public RkAttributeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_rkAttribute;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterRkAttribute(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitRkAttribute(this);
        }
    }

    public final RkAttributeContext rkAttribute() throws RecognitionException {
        RkAttributeContext _localctx = new RkAttributeContext(_ctx, getState());
        enterRule(_localctx, 72, RULE_rkAttribute);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(559);
                rkStringKey();
                setState(560);
                match(T__2);
                setState(561);
                rkAttributeValue();
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

    public static class RkAttributeValueContext extends ParserRuleContext {
        public RkReturnVariableContext rkReturnVariable() {
            return getRuleContext(RkReturnVariableContext.class, 0);
        }

        public RkAttributeValueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_rkAttributeValue;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterRkAttributeValue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitRkAttributeValue(this);
        }
    }

    public final RkAttributeValueContext rkAttributeValue() throws RecognitionException {
        RkAttributeValueContext _localctx = new RkAttributeValueContext(_ctx, getState());
        enterRule(_localctx, 74, RULE_rkAttributeValue);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(563);
                rkReturnVariable();
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

    public static class MapKeyContext extends ParserRuleContext {
        public List<TerminalNode> NAME() {
            return getTokens(QBTParser.NAME);
        }

        public TerminalNode NAME(int i) {
            return getToken(QBTParser.NAME, i);
        }

        public TerminalNode STRING() {
            return getToken(QBTParser.STRING, 0);
        }

        public MapKeyContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_mapKey;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterMapKey(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitMapKey(this);
        }
    }

    public final MapKeyContext mapKey() throws RecognitionException {
        MapKeyContext _localctx = new MapKeyContext(_ctx, getState());
        enterRule(_localctx, 76, RULE_mapKey);
        try {
            setState(570);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 9, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(565);
                    match(NAME);
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(566);
                    match(NAME);
                    setState(567);
                    match(T__9);
                    setState(568);
                    match(NAME);
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(569);
                    match(STRING);
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

    public static class RkFromClasueContext extends ParserRuleContext {
        public TerminalNode FROM() {
            return getToken(QBTParser.FROM, 0);
        }

        public List<VarBindingContext> varBinding() {
            return getRuleContexts(VarBindingContext.class);
        }

        public VarBindingContext varBinding(int i) {
            return getRuleContext(VarBindingContext.class, i);
        }

        public RkFromClasueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_rkFromClasue;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterRkFromClasue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitRkFromClasue(this);
        }
    }

    public final RkFromClasueContext rkFromClasue() throws RecognitionException {
        RkFromClasueContext _localctx = new RkFromClasueContext(_ctx, getState());
        enterRule(_localctx, 78, RULE_rkFromClasue);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(572);
                match(FROM);
                setState(573);
                varBinding();
                setState(578);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__1) {
                    {
                        {
                            setState(574);
                            match(T__1);
                            setState(575);
                            varBinding();
                        }
                    }
                    setState(580);
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

    public static class VarBindingContext extends ParserRuleContext {
        public FromvariableBindingContext fromvariableBinding() {
            return getRuleContext(FromvariableBindingContext.class, 0);
        }

        public TerminalNode IN() {
            return getToken(QBTParser.IN, 0);
        }

        public RkSourceContext rkSource() {
            return getRuleContext(RkSourceContext.class, 0);
        }

        public VarBindingContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_varBinding;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterVarBinding(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitVarBinding(this);
        }
    }

    public final VarBindingContext varBinding() throws RecognitionException {
        VarBindingContext _localctx = new VarBindingContext(_ctx, getState());
        enterRule(_localctx, 80, RULE_varBinding);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(581);
                fromvariableBinding();
                setState(582);
                match(IN);
                setState(583);
                rkSource();
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

    public static class FromvariableBindingContext extends ParserRuleContext {
        public RkVariableContext rkVariable() {
            return getRuleContext(RkVariableContext.class, 0);
        }

        public FromvariableBindingContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fromvariableBinding;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterFromvariableBinding(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitFromvariableBinding(this);
        }
    }

    public final FromvariableBindingContext fromvariableBinding() throws RecognitionException {
        FromvariableBindingContext _localctx = new FromvariableBindingContext(_ctx, getState());
        enterRule(_localctx, 82, RULE_fromvariableBinding);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(585);
                rkVariable();
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

    public static class RkSourceContext extends ParserRuleContext {
        public RkLookUpExpressionContext rkLookUpExpression() {
            return getRuleContext(RkLookUpExpressionContext.class, 0);
        }

        public RkSourceContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_rkSource;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterRkSource(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitRkSource(this);
        }
    }

    public final RkSourceContext rkSource() throws RecognitionException {
        RkSourceContext _localctx = new RkSourceContext(_ctx, getState());
        enterRule(_localctx, 84, RULE_rkSource);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(587);
                rkLookUpExpression();
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

    public static class RkLookUpExpressionContext extends ParserRuleContext {
        public RkLookUpExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_rkLookUpExpression;
        }

        public RkLookUpExpressionContext() {
        }

        public void copyFrom(RkLookUpExpressionContext ctx) {
            super.copyFrom(ctx);
        }
    }

    public static class KeysMapLookUpContext extends RkLookUpExpressionContext {
        public TerminalNode KEYS() {
            return getToken(QBTParser.KEYS, 0);
        }

        public KeyVariableContext keyVariable() {
            return getRuleContext(KeyVariableContext.class, 0);
        }

        public KeysMapLookUpContext(RkLookUpExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterKeysMapLookUp(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitKeysMapLookUp(this);
        }
    }

    public static class VariableMapLookUpContext extends RkLookUpExpressionContext {
        public MapVariableContext mapVariable() {
            return getRuleContext(MapVariableContext.class, 0);
        }

        public List<RkKeyContext> rkKey() {
            return getRuleContexts(RkKeyContext.class);
        }

        public RkKeyContext rkKey(int i) {
            return getRuleContext(RkKeyContext.class, i);
        }

        public VariableMapLookUpContext(RkLookUpExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterVariableMapLookUp(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitVariableMapLookUp(this);
        }
    }

    public static class MainMapLookUpContext extends RkLookUpExpressionContext {
        public MainMapContext mainMap() {
            return getRuleContext(MainMapContext.class, 0);
        }

        public List<RkKeyContext> rkKey() {
            return getRuleContexts(RkKeyContext.class);
        }

        public RkKeyContext rkKey(int i) {
            return getRuleContext(RkKeyContext.class, i);
        }

        public MainMapLookUpContext(RkLookUpExpressionContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterMainMapLookUp(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitMainMapLookUp(this);
        }
    }

    public final RkLookUpExpressionContext rkLookUpExpression() throws RecognitionException {
        RkLookUpExpressionContext _localctx = new RkLookUpExpressionContext(_ctx, getState());
        enterRule(_localctx, 86, RULE_rkLookUpExpression);
        int _la;
        try {
            setState(620);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case MAIN:
                    _localctx = new MainMapLookUpContext(_localctx);
                    enterOuterAlt(_localctx, 1); {
                    setState(589);
                    mainMap();
                    setState(590);
                    match(T__10);
                    setState(591);
                    rkKey();
                    setState(592);
                    match(T__11);
                    setState(599);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T__10) {
                        {
                            {
                                setState(593);
                                match(T__10);
                                setState(594);
                                rkKey();
                                setState(595);
                                match(T__11);
                            }
                        }
                        setState(601);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                }
                    break;
                case NAME:
                    _localctx = new VariableMapLookUpContext(_localctx);
                    enterOuterAlt(_localctx, 2); {
                    setState(602);
                    mapVariable();
                    setState(603);
                    match(T__10);
                    setState(604);
                    rkKey();
                    setState(605);
                    match(T__11);
                    setState(612);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T__10) {
                        {
                            {
                                setState(606);
                                match(T__10);
                                setState(607);
                                rkKey();
                                setState(608);
                                match(T__11);
                            }
                        }
                        setState(614);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                }
                    break;
                case KEYS:
                    _localctx = new KeysMapLookUpContext(_localctx);
                    enterOuterAlt(_localctx, 3); {
                    setState(615);
                    match(KEYS);
                    setState(616);
                    match(T__10);
                    setState(617);
                    keyVariable();
                    setState(618);
                    match(T__11);
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

    public static class MainMapContext extends ParserRuleContext {
        public TerminalNode MAIN() {
            return getToken(QBTParser.MAIN, 0);
        }

        public MainMapContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_mainMap;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterMainMap(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitMainMap(this);
        }
    }

    public final MainMapContext mainMap() throws RecognitionException {
        MainMapContext _localctx = new MainMapContext(_ctx, getState());
        enterRule(_localctx, 88, RULE_mainMap);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(622);
                match(MAIN);
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

    public static class MapVariableContext extends ParserRuleContext {
        public TerminalNode NAME() {
            return getToken(QBTParser.NAME, 0);
        }

        public MapVariableContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_mapVariable;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterMapVariable(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitMapVariable(this);
        }
    }

    public final MapVariableContext mapVariable() throws RecognitionException {
        MapVariableContext _localctx = new MapVariableContext(_ctx, getState());
        enterRule(_localctx, 90, RULE_mapVariable);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(624);
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

    public static class RkKeyContext extends ParserRuleContext {
        public RkStringKeyContext rkStringKey() {
            return getRuleContext(RkStringKeyContext.class, 0);
        }

        public VariableKeyContext variableKey() {
            return getRuleContext(VariableKeyContext.class, 0);
        }

        public RkKeyContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_rkKey;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterRkKey(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitRkKey(this);
        }
    }

    public final RkKeyContext rkKey() throws RecognitionException {
        RkKeyContext _localctx = new RkKeyContext(_ctx, getState());
        enterRule(_localctx, 92, RULE_rkKey);
        try {
            setState(628);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case STRING:
                    enterOuterAlt(_localctx, 1); {
                    setState(626);
                    rkStringKey();
                }
                    break;
                case NAME:
                    enterOuterAlt(_localctx, 2); {
                    setState(627);
                    variableKey();
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

    public static class RkStringKeyContext extends ParserRuleContext {
        public TerminalNode STRING() {
            return getToken(QBTParser.STRING, 0);
        }

        public RkStringKeyContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_rkStringKey;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterRkStringKey(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitRkStringKey(this);
        }
    }

    public final RkStringKeyContext rkStringKey() throws RecognitionException {
        RkStringKeyContext _localctx = new RkStringKeyContext(_ctx, getState());
        enterRule(_localctx, 94, RULE_rkStringKey);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(630);
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

    public static class VariableKeyContext extends ParserRuleContext {
        public List<TerminalNode> NAME() {
            return getTokens(QBTParser.NAME);
        }

        public TerminalNode NAME(int i) {
            return getToken(QBTParser.NAME, i);
        }

        public VariableKeyContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_variableKey;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterVariableKey(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitVariableKey(this);
        }
    }

    public final VariableKeyContext variableKey() throws RecognitionException {
        VariableKeyContext _localctx = new VariableKeyContext(_ctx, getState());
        enterRule(_localctx, 96, RULE_variableKey);
        try {
            setState(636);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 15, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(632);
                    match(NAME);
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(633);
                    match(NAME);
                    setState(634);
                    match(T__9);
                    setState(635);
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

    public static class KeyVariableContext extends ParserRuleContext {
        public TerminalNode NAME() {
            return getToken(QBTParser.NAME, 0);
        }

        public KeyVariableContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_keyVariable;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterKeyVariable(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitKeyVariable(this);
        }
    }

    public final KeyVariableContext keyVariable() throws RecognitionException {
        KeyVariableContext _localctx = new KeyVariableContext(_ctx, getState());
        enterRule(_localctx, 98, RULE_keyVariable);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(638);
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

    public static class MapNameContext extends ParserRuleContext {
        public MainMapContext mainMap() {
            return getRuleContext(MainMapContext.class, 0);
        }

        public RkVariableContext rkVariable() {
            return getRuleContext(RkVariableContext.class, 0);
        }

        public MapNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_mapName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterMapName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitMapName(this);
        }
    }

    public final MapNameContext mapName() throws RecognitionException {
        MapNameContext _localctx = new MapNameContext(_ctx, getState());
        enterRule(_localctx, 100, RULE_mapName);
        try {
            setState(642);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case MAIN:
                    enterOuterAlt(_localctx, 1); {
                    setState(640);
                    mainMap();
                }
                    break;
                case NAME:
                    enterOuterAlt(_localctx, 2); {
                    setState(641);
                    rkVariable();
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

    public static class RkVariableContext extends ParserRuleContext {
        public List<TerminalNode> NAME() {
            return getTokens(QBTParser.NAME);
        }

        public TerminalNode NAME(int i) {
            return getToken(QBTParser.NAME, i);
        }

        public RkVariableContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_rkVariable;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterRkVariable(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitRkVariable(this);
        }
    }

    public final RkVariableContext rkVariable() throws RecognitionException {
        RkVariableContext _localctx = new RkVariableContext(_ctx, getState());
        enterRule(_localctx, 102, RULE_rkVariable);
        try {
            setState(648);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 17, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(644);
                    match(NAME);
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(645);
                    match(NAME);
                    setState(646);
                    match(T__9);
                    setState(647);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterAqlquery(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitAqlquery(this);
        }
    }

    public final AqlqueryContext aqlquery() throws RecognitionException {
        AqlqueryContext _localctx = new AqlqueryContext(_ctx, getState());
        enterRule(_localctx, 104, RULE_aqlquery);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(650);
                viewName();
                setState(651);
                match(T__0);
                setState(659);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case T__13: {
                        setState(652);
                        query();
                    }
                        break;
                    case T__3: {
                        setState(653);
                        match(T__3);
                        setState(654);
                        rootFieldName();
                        setState(655);
                        match(T__2);
                        setState(656);
                        query();
                        setState(657);
                        match(T__4);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterQuery(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitQuery(this);
        }
    }

    public final QueryContext query() throws RecognitionException {
        QueryContext _localctx = new QueryContext(_ctx, getState());
        enterRule(_localctx, 106, RULE_query);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(661);
                forWhereClauses();
                setState(662);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterRootFieldName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitRootFieldName(this);
        }
    }

    public final RootFieldNameContext rootFieldName() throws RecognitionException {
        RootFieldNameContext _localctx = new RootFieldNameContext(_ctx, getState());
        enterRule(_localctx, 108, RULE_rootFieldName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(664);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterReturnClause(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitReturnClause(this);
        }
    }

    public final ReturnClauseContext returnClause() throws RecognitionException {
        ReturnClauseContext _localctx = new ReturnClauseContext(_ctx, getState());
        enterRule(_localctx, 110, RULE_returnClause);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(666);
                match(T__12);
                setState(670);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case T__3: {
                        setState(667);
                        recordConstruct();
                    }
                        break;
                    case NAME: {
                        setState(668);
                        returnVar();
                    }
                        break;
                    case STRING:
                    case BETA: {
                        setState(669);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterRecordConstruct(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitRecordConstruct(this);
        }
    }

    public final RecordConstructContext recordConstruct() throws RecognitionException {
        RecordConstructContext _localctx = new RecordConstructContext(_ctx, getState());
        enterRule(_localctx, 112, RULE_recordConstruct);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(672);
                match(T__3);
                setState(673);
                fieldBinding();
                setState(678);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__1) {
                    {
                        {
                            setState(674);
                            match(T__1);
                            setState(675);
                            fieldBinding();
                        }
                    }
                    setState(680);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(681);
                match(T__4);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterFieldBinding(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitFieldBinding(this);
        }
    }

    public final FieldBindingContext fieldBinding() throws RecognitionException {
        FieldBindingContext _localctx = new FieldBindingContext(_ctx, getState());
        enterRule(_localctx, 114, RULE_fieldBinding);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(683);
                recordConstructFieldName();
                setState(684);
                match(T__2);
                setState(685);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterRecordConstructFieldName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitRecordConstructFieldName(this);
        }
    }

    public final RecordConstructFieldNameContext recordConstructFieldName() throws RecognitionException {
        RecordConstructFieldNameContext _localctx = new RecordConstructFieldNameContext(_ctx, getState());
        enterRule(_localctx, 116, RULE_recordConstructFieldName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(687);
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
            return getToken(QBTParser.STRING, 0);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterFieldName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitFieldName(this);
        }
    }

    public final FieldNameContext fieldName() throws RecognitionException {
        FieldNameContext _localctx = new FieldNameContext(_ctx, getState());
        enterRule(_localctx, 118, RULE_fieldName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(689);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterFieldValue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitFieldValue(this);
        }
    }

    public final FieldValueContext fieldValue() throws RecognitionException {
        FieldValueContext _localctx = new FieldValueContext(_ctx, getState());
        enterRule(_localctx, 120, RULE_fieldValue);
        try {
            setState(695);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__3:
                    enterOuterAlt(_localctx, 1); {
                    setState(691);
                    recordConstruct();
                }
                    break;
                case NAME:
                    enterOuterAlt(_localctx, 2); {
                    setState(692);
                    returnVar();
                }
                    break;
                case STRING:
                case BETA:
                    enterOuterAlt(_localctx, 3); {
                    setState(693);
                    returnConstant();
                }
                    break;
                case T__13:
                    enterOuterAlt(_localctx, 4); {
                    setState(694);
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
            return getToken(QBTParser.NAME, 0);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterReturnVar(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitReturnVar(this);
        }
    }

    public final ReturnVarContext returnVar() throws RecognitionException {
        ReturnVarContext _localctx = new ReturnVarContext(_ctx, getState());
        enterRule(_localctx, 122, RULE_returnVar);
        try {
            setState(702);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 22, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(697);
                    var();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(698);
                    name();
                    setState(699);
                    match(T__9);
                    setState(700);
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
            return getToken(QBTParser.NAME, 0);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitName(this);
        }
    }

    public final NameContext name() throws RecognitionException {
        NameContext _localctx = new NameContext(_ctx, getState());
        enterRule(_localctx, 124, RULE_name);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(704);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterReturnConstant(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitReturnConstant(this);
        }
    }

    public final ReturnConstantContext returnConstant() throws RecognitionException {
        ReturnConstantContext _localctx = new ReturnConstantContext(_ctx, getState());
        enterRule(_localctx, 126, RULE_returnConstant);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(706);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterReturnQuery(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitReturnQuery(this);
        }
    }

    public final ReturnQueryContext returnQuery() throws RecognitionException {
        ReturnQueryContext _localctx = new ReturnQueryContext(_ctx, getState());
        enterRule(_localctx, 128, RULE_returnQuery);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(708);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterTerm(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitTerm(this);
        }
    }

    public final TermContext term() throws RecognitionException {
        TermContext _localctx = new TermContext(_ctx, getState());
        enterRule(_localctx, 130, RULE_term);
        try {
            setState(713);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 23, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(710);
                    termConstant();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(711);
                    termVar();
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(712);
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
            return getToken(QBTParser.NAME, 0);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterTermVar(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitTermVar(this);
        }
    }

    public final TermVarContext termVar() throws RecognitionException {
        TermVarContext _localctx = new TermVarContext(_ctx, getState());
        enterRule(_localctx, 132, RULE_termVar);
        try {
            setState(720);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 24, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(715);
                    var();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(716);
                    name();
                    setState(717);
                    match(T__9);
                    setState(718);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterTermConstant(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitTermConstant(this);
        }
    }

    public final TermConstantContext termConstant() throws RecognitionException {
        TermConstantContext _localctx = new TermConstantContext(_ctx, getState());
        enterRule(_localctx, 134, RULE_termConstant);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(722);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterTermPath(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitTermPath(this);
        }
    }

    public final TermPathContext termPath() throws RecognitionException {
        TermPathContext _localctx = new TermPathContext(_ctx, getState());
        enterRule(_localctx, 136, RULE_termPath);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(724);
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
            return getToken(QBTParser.STRING, 0);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterConstant(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitConstant(this);
        }
    }

    public final ConstantContext constant() throws RecognitionException {
        ConstantContext _localctx = new ConstantContext(_ctx, getState());
        enterRule(_localctx, 138, RULE_constant);
        try {
            setState(728);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case BETA:
                    enterOuterAlt(_localctx, 1); {
                    setState(726);
                    number();
                }
                    break;
                case STRING:
                    enterOuterAlt(_localctx, 2); {
                    setState(727);
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
            return getToken(QBTParser.BETA, 0);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterNumber(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitNumber(this);
        }
    }

    public final NumberContext number() throws RecognitionException {
        NumberContext _localctx = new NumberContext(_ctx, getState());
        enterRule(_localctx, 140, RULE_number);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(730);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPath(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPath(this);
        }
    }

    public final PathContext path() throws RecognitionException {
        PathContext _localctx = new PathContext(_ctx, getState());
        enterRule(_localctx, 142, RULE_path);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(732);
                pathVar();
                setState(734);
                _errHandler.sync(this);
                _alt = 1;
                do {
                    switch (_alt) {
                        case 1: {
                            {
                                setState(733);
                                step();
                            }
                        }
                            break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(736);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 26, _ctx);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPathVar(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPathVar(this);
        }
    }

    public final PathVarContext pathVar() throws RecognitionException {
        PathVarContext _localctx = new PathVarContext(_ctx, getState());
        enterRule(_localctx, 144, RULE_pathVar);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(738);
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
            return getToken(QBTParser.NAME, 0);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterVar(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitVar(this);
        }
    }

    public final VarContext var() throws RecognitionException {
        VarContext _localctx = new VarContext(_ctx, getState());
        enterRule(_localctx, 146, RULE_var);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(740);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterStep(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitStep(this);
        }
    }

    public final StepContext step() throws RecognitionException {
        StepContext _localctx = new StepContext(_ctx, getState());
        enterRule(_localctx, 148, RULE_step);
        try {
            setState(744);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__9:
                    enterOuterAlt(_localctx, 1); {
                    setState(742);
                    objectStep();
                }
                    break;
                case T__10:
                    enterOuterAlt(_localctx, 2); {
                    setState(743);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterObjectStep(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitObjectStep(this);
        }
    }

    public final ObjectStepContext objectStep() throws RecognitionException {
        ObjectStepContext _localctx = new ObjectStepContext(_ctx, getState());
        enterRule(_localctx, 150, RULE_objectStep);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(746);
                match(T__9);
                setState(747);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterArrayStep(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitArrayStep(this);
        }
    }

    public final ArrayStepContext arrayStep() throws RecognitionException {
        ArrayStepContext _localctx = new ArrayStepContext(_ctx, getState());
        enterRule(_localctx, 152, RULE_arrayStep);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(749);
                match(T__10);
                setState(750);
                index();
                setState(751);
                match(T__11);
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
            return getToken(QBTParser.NAME, 0);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterKey(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitKey(this);
        }
    }

    public final KeyContext key() throws RecognitionException {
        KeyContext _localctx = new KeyContext(_ctx, getState());
        enterRule(_localctx, 154, RULE_key);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(753);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterIndex(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitIndex(this);
        }
    }

    public final IndexContext index() throws RecognitionException {
        IndexContext _localctx = new IndexContext(_ctx, getState());
        enterRule(_localctx, 156, RULE_index);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(755);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterForClause(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitForClause(this);
        }
    }

    public final ForClauseContext forClause() throws RecognitionException {
        ForClauseContext _localctx = new ForClauseContext(_ctx, getState());
        enterRule(_localctx, 158, RULE_forClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(757);
                match(T__13);
                setState(758);
                binding();
                setState(763);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__1) {
                    {
                        {
                            setState(759);
                            match(T__1);
                            setState(760);
                            binding();
                        }
                    }
                    setState(765);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterBinding(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitBinding(this);
        }
    }

    public final BindingContext binding() throws RecognitionException {
        BindingContext _localctx = new BindingContext(_ctx, getState());
        enterRule(_localctx, 160, RULE_binding);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(766);
                forClauseBindingVar();
                setState(767);
                match(T__14);
                setState(768);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterForClauseBindingVar(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitForClauseBindingVar(this);
        }
    }

    public final ForClauseBindingVarContext forClauseBindingVar() throws RecognitionException {
        ForClauseBindingVarContext _localctx = new ForClauseBindingVarContext(_ctx, getState());
        enterRule(_localctx, 162, RULE_forClauseBindingVar);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(770);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterForClauseBindingSource(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitForClauseBindingSource(this);
        }
    }

    public final ForClauseBindingSourceContext forClauseBindingSource() throws RecognitionException {
        ForClauseBindingSourceContext _localctx = new ForClauseBindingSourceContext(_ctx, getState());
        enterRule(_localctx, 164, RULE_forClauseBindingSource);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(772);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSource(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSource(this);
        }
    }

    public final SourceContext source() throws RecognitionException {
        SourceContext _localctx = new SourceContext(_ctx, getState());
        enterRule(_localctx, 166, RULE_source);
        try {
            setState(777);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__15:
                    enterOuterAlt(_localctx, 1); {
                    setState(774);
                    match(T__15);
                    setState(775);
                    dataSetName();
                }
                    break;
                case NAME:
                    enterOuterAlt(_localctx, 2); {
                    setState(776);
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
            return getToken(QBTParser.NAME, 0);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterDataSetName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitDataSetName(this);
        }
    }

    public final DataSetNameContext dataSetName() throws RecognitionException {
        DataSetNameContext _localctx = new DataSetNameContext(_ctx, getState());
        enterRule(_localctx, 168, RULE_dataSetName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(779);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterWhereClause(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitWhereClause(this);
        }
    }

    public final WhereClauseContext whereClause() throws RecognitionException {
        WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
        enterRule(_localctx, 170, RULE_whereClause);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(781);
                match(T__16);
                setState(782);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterCondition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitCondition(this);
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
        int _startState = 172;
        enterRecursionRule(_localctx, 172, RULE_condition, _p);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(795);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case NAME:
                    case STRING:
                    case BETA: {
                        setState(785);
                        whereCondEquality();
                    }
                        break;
                    case T__18: {
                        setState(786);
                        match(T__18);
                        setState(787);
                        whereCondSome();
                        setState(788);
                        match(T__19);
                        setState(789);
                        condition(2);
                    }
                        break;
                    case T__5: {
                        setState(791);
                        match(T__5);
                        setState(792);
                        condition(0);
                        setState(793);
                        match(T__6);
                    }
                        break;
                    default:
                        throw new NoViableAltException(this);
                }
                _ctx.stop = _input.LT(-1);
                setState(802);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 31, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null)
                            triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            {
                                _localctx = new ConditionContext(_parentctx, _parentState);
                                pushNewRecursionContext(_localctx, _startState, RULE_condition);
                                setState(797);
                                if (!(precpred(_ctx, 3)))
                                    throw new FailedPredicateException(this, "precpred(_ctx, 3)");
                                setState(798);
                                match(T__17);
                                setState(799);
                                condition(4);
                            }
                        }
                    }
                    setState(804);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 31, _ctx);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterWhereCondSome(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitWhereCondSome(this);
        }
    }

    public final WhereCondSomeContext whereCondSome() throws RecognitionException {
        WhereCondSomeContext _localctx = new WhereCondSomeContext(_ctx, getState());
        enterRule(_localctx, 174, RULE_whereCondSome);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(805);
                whereCondBinding();
                setState(810);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__1) {
                    {
                        {
                            setState(806);
                            match(T__1);
                            setState(807);
                            whereCondBinding();
                        }
                    }
                    setState(812);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterWhereCondBinding(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitWhereCondBinding(this);
        }
    }

    public final WhereCondBindingContext whereCondBinding() throws RecognitionException {
        WhereCondBindingContext _localctx = new WhereCondBindingContext(_ctx, getState());
        enterRule(_localctx, 176, RULE_whereCondBinding);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(813);
                whereCondBindingVar();
                setState(814);
                match(T__14);
                setState(815);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterWhereCondBindingVar(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitWhereCondBindingVar(this);
        }
    }

    public final WhereCondBindingVarContext whereCondBindingVar() throws RecognitionException {
        WhereCondBindingVarContext _localctx = new WhereCondBindingVarContext(_ctx, getState());
        enterRule(_localctx, 178, RULE_whereCondBindingVar);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(817);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterWhereCondBindingSource(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitWhereCondBindingSource(this);
        }
    }

    public final WhereCondBindingSourceContext whereCondBindingSource() throws RecognitionException {
        WhereCondBindingSourceContext _localctx = new WhereCondBindingSourceContext(_ctx, getState());
        enterRule(_localctx, 180, RULE_whereCondBindingSource);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(819);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterWhereCondEquality(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitWhereCondEquality(this);
        }
    }

    public final WhereCondEqualityContext whereCondEquality() throws RecognitionException {
        WhereCondEqualityContext _localctx = new WhereCondEqualityContext(_ctx, getState());
        enterRule(_localctx, 182, RULE_whereCondEquality);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(821);
                whereCondEqualityLeftTerm();
                setState(822);
                match(T__0);
                setState(823);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterWhereCondEqualityLeftTerm(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitWhereCondEqualityLeftTerm(this);
        }
    }

    public final WhereCondEqualityLeftTermContext whereCondEqualityLeftTerm() throws RecognitionException {
        WhereCondEqualityLeftTermContext _localctx = new WhereCondEqualityLeftTermContext(_ctx, getState());
        enterRule(_localctx, 184, RULE_whereCondEqualityLeftTerm);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(825);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterWhereCondEqualityRightTerm(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitWhereCondEqualityRightTerm(this);
        }
    }

    public final WhereCondEqualityRightTermContext whereCondEqualityRightTerm() throws RecognitionException {
        WhereCondEqualityRightTermContext _localctx = new WhereCondEqualityRightTermContext(_ctx, getState());
        enterRule(_localctx, 186, RULE_whereCondEqualityRightTerm);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(827);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterCterm(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitCterm(this);
        }
    }

    public final CtermContext cterm() throws RecognitionException {
        CtermContext _localctx = new CtermContext(_ctx, getState());
        enterRule(_localctx, 188, RULE_cterm);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(829);
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
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterForWhereClauses(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitForWhereClauses(this);
        }
    }

    public final ForWhereClausesContext forWhereClauses() throws RecognitionException {
        ForWhereClausesContext _localctx = new ForWhereClausesContext(_ctx, getState());
        enterRule(_localctx, 190, RULE_forWhereClauses);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(831);
                forClause();
                setState(833);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == T__16) {
                    {
                        setState(832);
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

    public static class RqQueryContext extends ParserRuleContext {
        public ViewNameContext viewName() {
            return getRuleContext(ViewNameContext.class, 0);
        }

        public PrSQueryContext prSQuery() {
            return getRuleContext(PrSQueryContext.class, 0);
        }

        public TerminalNode EOF() {
            return getToken(QBTParser.EOF, 0);
        }

        public RqQueryContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_rqQuery;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterRqQuery(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitRqQuery(this);
        }
    }

    public final RqQueryContext rqQuery() throws RecognitionException {
        RqQueryContext _localctx = new RqQueryContext(_ctx, getState());
        enterRule(_localctx, 192, RULE_rqQuery);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(835);
                viewName();
                setState(836);
                match(T__0);
                setState(837);
                prSQuery();
                setState(838);
                match(EOF);
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

    public static class PrSQueryContext extends ParserRuleContext {
        public PrSfwQueryContext prSfwQuery() {
            return getRuleContext(PrSfwQueryContext.class, 0);
        }

        public PrSQueryContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prSQuery;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPrSQuery(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPrSQuery(this);
        }
    }

    public final PrSQueryContext prSQuery() throws RecognitionException {
        PrSQueryContext _localctx = new PrSQueryContext(_ctx, getState());
        enterRule(_localctx, 194, RULE_prSQuery);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(840);
                prSfwQuery();
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

    public static class PrSfwQueryContext extends ParserRuleContext {
        public PrSelectClauseContext prSelectClause() {
            return getRuleContext(PrSelectClauseContext.class, 0);
        }

        public PrFromWhereClausesContext prFromWhereClauses() {
            return getRuleContext(PrFromWhereClausesContext.class, 0);
        }

        public PrSfwQueryContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prSfwQuery;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPrSfwQuery(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPrSfwQuery(this);
        }
    }

    public final PrSfwQueryContext prSfwQuery() throws RecognitionException {
        PrSfwQueryContext _localctx = new PrSfwQueryContext(_ctx, getState());
        enterRule(_localctx, 196, RULE_prSfwQuery);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(842);
                prSelectClause();
                setState(843);
                prFromWhereClauses();
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

    public static class PrFromWhereClausesContext extends ParserRuleContext {
        public PrFromClauseContext prFromClause() {
            return getRuleContext(PrFromClauseContext.class, 0);
        }

        public PrWhereClauseContext prWhereClause() {
            return getRuleContext(PrWhereClauseContext.class, 0);
        }

        public PrFromWhereClausesContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prFromWhereClauses;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPrFromWhereClauses(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPrFromWhereClauses(this);
        }
    }

    public final PrFromWhereClausesContext prFromWhereClauses() throws RecognitionException {
        PrFromWhereClausesContext _localctx = new PrFromWhereClausesContext(_ctx, getState());
        enterRule(_localctx, 198, RULE_prFromWhereClauses);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(845);
                prFromClause();
                setState(847);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == WHERE) {
                    {
                        setState(846);
                        prWhereClause();
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

    public static class PrSelectClauseContext extends ParserRuleContext {
        public TerminalNode SELECT() {
            return getToken(QBTParser.SELECT, 0);
        }

        public PrSelectStatementContext prSelectStatement() {
            return getRuleContext(PrSelectStatementContext.class, 0);
        }

        public PrSelectClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prSelectClause;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPrSelectClause(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPrSelectClause(this);
        }
    }

    public final PrSelectClauseContext prSelectClause() throws RecognitionException {
        PrSelectClauseContext _localctx = new PrSelectClauseContext(_ctx, getState());
        enterRule(_localctx, 200, RULE_prSelectClause);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(849);
                match(SELECT);
                setState(850);
                prSelectStatement();
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

    public static class PrSelectStatementContext extends ParserRuleContext {
        public List<PrSelectItemContext> prSelectItem() {
            return getRuleContexts(PrSelectItemContext.class);
        }

        public PrSelectItemContext prSelectItem(int i) {
            return getRuleContext(PrSelectItemContext.class, i);
        }

        public PrSelectStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prSelectStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPrSelectStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPrSelectStatement(this);
        }
    }

    public final PrSelectStatementContext prSelectStatement() throws RecognitionException {
        PrSelectStatementContext _localctx = new PrSelectStatementContext(_ctx, getState());
        enterRule(_localctx, 202, RULE_prSelectStatement);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(852);
                prSelectItem();
                setState(857);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__1) {
                    {
                        {
                            setState(853);
                            match(T__1);
                            setState(854);
                            prSelectItem();
                        }
                    }
                    setState(859);
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

    public static class PrSelectItemContext extends ParserRuleContext {
        public PrTermContext prTerm() {
            return getRuleContext(PrTermContext.class, 0);
        }

        public TerminalNode NAME() {
            return getToken(QBTParser.NAME, 0);
        }

        public PrSelectItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prSelectItem;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPrSelectItem(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPrSelectItem(this);
        }
    }

    public final PrSelectItemContext prSelectItem() throws RecognitionException {
        PrSelectItemContext _localctx = new PrSelectItemContext(_ctx, getState());
        enterRule(_localctx, 204, RULE_prSelectItem);
        try {
            setState(862);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 36, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(860);
                    prTerm();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(861);
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

    public static class PrFromClauseContext extends ParserRuleContext {
        public TerminalNode FROM() {
            return getToken(QBTParser.FROM, 0);
        }

        public List<PrRelationBindingContext> prRelationBinding() {
            return getRuleContexts(PrRelationBindingContext.class);
        }

        public PrRelationBindingContext prRelationBinding(int i) {
            return getRuleContext(PrRelationBindingContext.class, i);
        }

        public PrFromClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prFromClause;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPrFromClause(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPrFromClause(this);
        }
    }

    public final PrFromClauseContext prFromClause() throws RecognitionException {
        PrFromClauseContext _localctx = new PrFromClauseContext(_ctx, getState());
        enterRule(_localctx, 206, RULE_prFromClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(864);
                match(FROM);
                setState(865);
                prRelationBinding();
                setState(870);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__1) {
                    {
                        {
                            setState(866);
                            match(T__1);
                            setState(867);
                            prRelationBinding();
                        }
                    }
                    setState(872);
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

    public static class PrRelationBindingContext extends ParserRuleContext {
        public PrSourceContext prSource() {
            return getRuleContext(PrSourceContext.class, 0);
        }

        public TerminalNode AS() {
            return getToken(QBTParser.AS, 0);
        }

        public PrVariableContext prVariable() {
            return getRuleContext(PrVariableContext.class, 0);
        }

        public PrRelationBindingContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prRelationBinding;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPrRelationBinding(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPrRelationBinding(this);
        }
    }

    public final PrRelationBindingContext prRelationBinding() throws RecognitionException {
        PrRelationBindingContext _localctx = new PrRelationBindingContext(_ctx, getState());
        enterRule(_localctx, 208, RULE_prRelationBinding);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(873);
                prSource();
                setState(874);
                match(AS);
                setState(875);
                prVariable();
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

    public static class PrSourceContext extends ParserRuleContext {
        public PrRelationNameContext prRelationName() {
            return getRuleContext(PrRelationNameContext.class, 0);
        }

        public PrSourceContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prSource;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPrSource(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPrSource(this);
        }
    }

    public final PrSourceContext prSource() throws RecognitionException {
        PrSourceContext _localctx = new PrSourceContext(_ctx, getState());
        enterRule(_localctx, 210, RULE_prSource);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(877);
                prRelationName();
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

    public static class PrRelationNameContext extends ParserRuleContext {
        public TerminalNode NAME() {
            return getToken(QBTParser.NAME, 0);
        }

        public PrRelationNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prRelationName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPrRelationName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPrRelationName(this);
        }
    }

    public final PrRelationNameContext prRelationName() throws RecognitionException {
        PrRelationNameContext _localctx = new PrRelationNameContext(_ctx, getState());
        enterRule(_localctx, 212, RULE_prRelationName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(879);
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

    public static class PrVariableContext extends ParserRuleContext {
        public TerminalNode NAME() {
            return getToken(QBTParser.NAME, 0);
        }

        public PrVariableContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prVariable;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPrVariable(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPrVariable(this);
        }
    }

    public final PrVariableContext prVariable() throws RecognitionException {
        PrVariableContext _localctx = new PrVariableContext(_ctx, getState());
        enterRule(_localctx, 214, RULE_prVariable);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(881);
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

    public static class PrWhereClauseContext extends ParserRuleContext {
        public PrWhereStatementContext prWhereStatement() {
            return getRuleContext(PrWhereStatementContext.class, 0);
        }

        public PrWhereClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prWhereClause;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPrWhereClause(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPrWhereClause(this);
        }
    }

    public final PrWhereClauseContext prWhereClause() throws RecognitionException {
        PrWhereClauseContext _localctx = new PrWhereClauseContext(_ctx, getState());
        enterRule(_localctx, 216, RULE_prWhereClause);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(883);
                prWhereStatement();
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

    public static class PrWhereStatementContext extends ParserRuleContext {
        public TerminalNode WHERE() {
            return getToken(QBTParser.WHERE, 0);
        }

        public PrConditionContext prCondition() {
            return getRuleContext(PrConditionContext.class, 0);
        }

        public PrWhereStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prWhereStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPrWhereStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPrWhereStatement(this);
        }
    }

    public final PrWhereStatementContext prWhereStatement() throws RecognitionException {
        PrWhereStatementContext _localctx = new PrWhereStatementContext(_ctx, getState());
        enterRule(_localctx, 218, RULE_prWhereStatement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(885);
                match(WHERE);
                setState(886);
                prCondition(0);
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

    public static class PrConditionContext extends ParserRuleContext {
        public PrEqualityContext prEquality() {
            return getRuleContext(PrEqualityContext.class, 0);
        }

        public PrLikeExpressionContext prLikeExpression() {
            return getRuleContext(PrLikeExpressionContext.class, 0);
        }

        public List<PrConditionContext> prCondition() {
            return getRuleContexts(PrConditionContext.class);
        }

        public PrConditionContext prCondition(int i) {
            return getRuleContext(PrConditionContext.class, i);
        }

        public TerminalNode AND() {
            return getToken(QBTParser.AND, 0);
        }

        public PrConditionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prCondition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPrCondition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPrCondition(this);
        }
    }

    public final PrConditionContext prCondition() throws RecognitionException {
        return prCondition(0);
    }

    private PrConditionContext prCondition(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        PrConditionContext _localctx = new PrConditionContext(_ctx, _parentState);
        PrConditionContext _prevctx = _localctx;
        int _startState = 220;
        enterRecursionRule(_localctx, 220, RULE_prCondition, _p);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(895);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 38, _ctx)) {
                    case 1: {
                        setState(889);
                        prEquality();
                    }
                        break;
                    case 2: {
                        setState(890);
                        prLikeExpression();
                    }
                        break;
                    case 3: {
                        setState(891);
                        match(T__5);
                        setState(892);
                        prCondition(0);
                        setState(893);
                        match(T__6);
                    }
                        break;
                }
                _ctx.stop = _input.LT(-1);
                setState(902);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 39, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null)
                            triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            {
                                _localctx = new PrConditionContext(_parentctx, _parentState);
                                pushNewRecursionContext(_localctx, _startState, RULE_prCondition);
                                setState(897);
                                if (!(precpred(_ctx, 2)))
                                    throw new FailedPredicateException(this, "precpred(_ctx, 2)");
                                setState(898);
                                match(AND);
                                setState(899);
                                prCondition(3);
                            }
                        }
                    }
                    setState(904);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 39, _ctx);
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

    public static class PrTermContext extends ParserRuleContext {
        public RealtionContext realtion() {
            return getRuleContext(RealtionContext.class, 0);
        }

        public TerminalNode NAME() {
            return getToken(QBTParser.NAME, 0);
        }

        public TerminalNode STRING() {
            return getToken(QBTParser.STRING, 0);
        }

        public PrTermContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prTerm;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPrTerm(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPrTerm(this);
        }
    }

    public final PrTermContext prTerm() throws RecognitionException {
        PrTermContext _localctx = new PrTermContext(_ctx, getState());
        enterRule(_localctx, 222, RULE_prTerm);
        try {
            setState(911);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 40, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(905);
                    realtion();
                    setState(906);
                    match(T__9);
                    setState(907);
                    match(NAME);
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(909);
                    match(NAME);
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(910);
                    match(STRING);
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

    public static class PrEqualityContext extends ParserRuleContext {
        public PrLefttermContext prLeftterm() {
            return getRuleContext(PrLefttermContext.class, 0);
        }

        public PrRighttermContext prRightterm() {
            return getRuleContext(PrRighttermContext.class, 0);
        }

        public PrEqualityContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prEquality;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPrEquality(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPrEquality(this);
        }
    }

    public final PrEqualityContext prEquality() throws RecognitionException {
        PrEqualityContext _localctx = new PrEqualityContext(_ctx, getState());
        enterRule(_localctx, 224, RULE_prEquality);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(913);
                prLeftterm();
                setState(914);
                match(T__0);
                setState(915);
                prRightterm();
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

    public static class PrLikeExpressionContext extends ParserRuleContext {
        public PrTermContext prTerm() {
            return getRuleContext(PrTermContext.class, 0);
        }

        public TerminalNode LIKE() {
            return getToken(QBTParser.LIKE, 0);
        }

        public TerminalNode STRING() {
            return getToken(QBTParser.STRING, 0);
        }

        public PrLikeExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prLikeExpression;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPrLikeExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPrLikeExpression(this);
        }
    }

    public final PrLikeExpressionContext prLikeExpression() throws RecognitionException {
        PrLikeExpressionContext _localctx = new PrLikeExpressionContext(_ctx, getState());
        enterRule(_localctx, 226, RULE_prLikeExpression);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(917);
                prTerm();
                setState(918);
                match(LIKE);
                setState(919);
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

    public static class PrLefttermContext extends ParserRuleContext {
        public PrTermContext prTerm() {
            return getRuleContext(PrTermContext.class, 0);
        }

        public PrLefttermContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prLeftterm;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPrLeftterm(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPrLeftterm(this);
        }
    }

    public final PrLefttermContext prLeftterm() throws RecognitionException {
        PrLefttermContext _localctx = new PrLefttermContext(_ctx, getState());
        enterRule(_localctx, 228, RULE_prLeftterm);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(921);
                prTerm();
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

    public static class PrRighttermContext extends ParserRuleContext {
        public PrTermContext prTerm() {
            return getRuleContext(PrTermContext.class, 0);
        }

        public PrRighttermContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prRightterm;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPrRightterm(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPrRightterm(this);
        }
    }

    public final PrRighttermContext prRightterm() throws RecognitionException {
        PrRighttermContext _localctx = new PrRighttermContext(_ctx, getState());
        enterRule(_localctx, 230, RULE_prRightterm);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(923);
                prTerm();
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

    public static class RealtionContext extends ParserRuleContext {
        public TerminalNode NAME() {
            return getToken(QBTParser.NAME, 0);
        }

        public RealtionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_realtion;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterRealtion(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitRealtion(this);
        }
    }

    public final RealtionContext realtion() throws RecognitionException {
        RealtionContext _localctx = new RealtionContext(_ctx, getState());
        enterRule(_localctx, 232, RULE_realtion);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(925);
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

    public static class SjqlqueryContext extends ParserRuleContext {
        public ViewNameContext viewName() {
            return getRuleContext(ViewNameContext.class, 0);
        }

        public SjQueryContext sjQuery() {
            return getRuleContext(SjQueryContext.class, 0);
        }

        public TerminalNode EOF() {
            return getToken(QBTParser.EOF, 0);
        }

        public SjqlqueryContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sjqlquery;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSjqlquery(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSjqlquery(this);
        }
    }

    public final SjqlqueryContext sjqlquery() throws RecognitionException {
        SjqlqueryContext _localctx = new SjqlqueryContext(_ctx, getState());
        enterRule(_localctx, 234, RULE_sjqlquery);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(927);
                viewName();
                setState(928);
                match(T__0);
                setState(929);
                sjQuery();
                setState(930);
                match(EOF);
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

    public static class SjQueryContext extends ParserRuleContext {
        public SjCollectionNameContext sjCollectionName() {
            return getRuleContext(SjCollectionNameContext.class, 0);
        }

        public TerminalNode QUERY() {
            return getToken(QBTParser.QUERY, 0);
        }

        public SjProjectFieldsContext sjProjectFields() {
            return getRuleContext(SjProjectFieldsContext.class, 0);
        }

        public SjTextSearchContext sjTextSearch() {
            return getRuleContext(SjTextSearchContext.class, 0);
        }

        public SjQueryContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sjQuery;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSjQuery(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSjQuery(this);
        }
    }

    public final SjQueryContext sjQuery() throws RecognitionException {
        SjQueryContext _localctx = new SjQueryContext(_ctx, getState());
        enterRule(_localctx, 236, RULE_sjQuery);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(932);
                sjCollectionName();
                setState(933);
                match(T__20);
                setState(934);
                match(QUERY);
                setState(935);
                match(T__21);
                setState(937);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAME) | (1L << STRING) | (1L << INTEGER))) != 0)) {
                    {
                        setState(936);
                        sjTextSearch();
                    }
                }

                setState(939);
                match(T__22);
                setState(940);
                sjProjectFields();
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

    public static class SjCollectionNameContext extends ParserRuleContext {
        public TerminalNode NAME() {
            return getToken(QBTParser.NAME, 0);
        }

        public SjCollectionNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sjCollectionName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSjCollectionName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSjCollectionName(this);
        }
    }

    public final SjCollectionNameContext sjCollectionName() throws RecognitionException {
        SjCollectionNameContext _localctx = new SjCollectionNameContext(_ctx, getState());
        enterRule(_localctx, 238, RULE_sjCollectionName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(942);
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

    public static class SjTextSearchContext extends ParserRuleContext {
        public SjLeftTermContext sjLeftTerm() {
            return getRuleContext(SjLeftTermContext.class, 0);
        }

        public SjRightTermContext sjRightTerm() {
            return getRuleContext(SjRightTermContext.class, 0);
        }

        public SjTextSearchContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sjTextSearch;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSjTextSearch(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSjTextSearch(this);
        }
    }

    public final SjTextSearchContext sjTextSearch() throws RecognitionException {
        SjTextSearchContext _localctx = new SjTextSearchContext(_ctx, getState());
        enterRule(_localctx, 240, RULE_sjTextSearch);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(944);
                sjLeftTerm();
                setState(945);
                match(T__2);
                setState(946);
                sjRightTerm();
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

    public static class SjLeftTermContext extends ParserRuleContext {
        public SjTermContext sjTerm() {
            return getRuleContext(SjTermContext.class, 0);
        }

        public SjLeftTermContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sjLeftTerm;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSjLeftTerm(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSjLeftTerm(this);
        }
    }

    public final SjLeftTermContext sjLeftTerm() throws RecognitionException {
        SjLeftTermContext _localctx = new SjLeftTermContext(_ctx, getState());
        enterRule(_localctx, 242, RULE_sjLeftTerm);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(948);
                sjTerm();
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

    public static class SjRightTermContext extends ParserRuleContext {
        public SjTermContext sjTerm() {
            return getRuleContext(SjTermContext.class, 0);
        }

        public SjRightTermContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sjRightTerm;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSjRightTerm(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSjRightTerm(this);
        }
    }

    public final SjRightTermContext sjRightTerm() throws RecognitionException {
        SjRightTermContext _localctx = new SjRightTermContext(_ctx, getState());
        enterRule(_localctx, 244, RULE_sjRightTerm);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(950);
                sjTerm();
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

    public static class SjTermContext extends ParserRuleContext {
        public SjFieldNameContext sjFieldName() {
            return getRuleContext(SjFieldNameContext.class, 0);
        }

        public SjConstantContext sjConstant() {
            return getRuleContext(SjConstantContext.class, 0);
        }

        public SjTermContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sjTerm;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSjTerm(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSjTerm(this);
        }
    }

    public final SjTermContext sjTerm() throws RecognitionException {
        SjTermContext _localctx = new SjTermContext(_ctx, getState());
        enterRule(_localctx, 246, RULE_sjTerm);
        try {
            setState(954);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case NAME:
                    enterOuterAlt(_localctx, 1); {
                    setState(952);
                    sjFieldName();
                }
                    break;
                case STRING:
                case INTEGER:
                    enterOuterAlt(_localctx, 2); {
                    setState(953);
                    sjConstant();
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

    public static class SjProjectFieldsContext extends ParserRuleContext {
        public List<SjFieldNameContext> sjFieldName() {
            return getRuleContexts(SjFieldNameContext.class);
        }

        public SjFieldNameContext sjFieldName(int i) {
            return getRuleContext(SjFieldNameContext.class, i);
        }

        public SjProjectFieldsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sjProjectFields;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSjProjectFields(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSjProjectFields(this);
        }
    }

    public final SjProjectFieldsContext sjProjectFields() throws RecognitionException {
        SjProjectFieldsContext _localctx = new SjProjectFieldsContext(_ctx, getState());
        enterRule(_localctx, 248, RULE_sjProjectFields);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(956);
                match(T__23);
                setState(957);
                sjFieldName();
                setState(962);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__1) {
                    {
                        {
                            setState(958);
                            match(T__1);
                            setState(959);
                            sjFieldName();
                        }
                    }
                    setState(964);
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

    public static class SjRecordConstructContext extends ParserRuleContext {
        public TerminalNode SOLRJSONBUILDOBJECT() {
            return getToken(QBTParser.SOLRJSONBUILDOBJECT, 0);
        }

        public List<SjFieldBindingContext> sjFieldBinding() {
            return getRuleContexts(SjFieldBindingContext.class);
        }

        public SjFieldBindingContext sjFieldBinding(int i) {
            return getRuleContext(SjFieldBindingContext.class, i);
        }

        public SjRecordConstructContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sjRecordConstruct;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSjRecordConstruct(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSjRecordConstruct(this);
        }
    }

    public final SjRecordConstructContext sjRecordConstruct() throws RecognitionException {
        SjRecordConstructContext _localctx = new SjRecordConstructContext(_ctx, getState());
        enterRule(_localctx, 250, RULE_sjRecordConstruct);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(965);
                match(SOLRJSONBUILDOBJECT);
                setState(966);
                match(T__5);
                setState(967);
                sjFieldBinding();
                setState(972);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__1) {
                    {
                        {
                            setState(968);
                            match(T__1);
                            setState(969);
                            sjFieldBinding();
                        }
                    }
                    setState(974);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(975);
                match(T__6);
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

    public static class SjFieldBindingContext extends ParserRuleContext {
        public SjRecordConstructFieldNameContext sjRecordConstructFieldName() {
            return getRuleContext(SjRecordConstructFieldNameContext.class, 0);
        }

        public SjFieldValueContext sjFieldValue() {
            return getRuleContext(SjFieldValueContext.class, 0);
        }

        public SjFieldBindingContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sjFieldBinding;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSjFieldBinding(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSjFieldBinding(this);
        }
    }

    public final SjFieldBindingContext sjFieldBinding() throws RecognitionException {
        SjFieldBindingContext _localctx = new SjFieldBindingContext(_ctx, getState());
        enterRule(_localctx, 252, RULE_sjFieldBinding);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(977);
                sjRecordConstructFieldName();
                setState(978);
                match(T__2);
                setState(979);
                sjFieldValue();
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

    public static class SjRecordConstructFieldNameContext extends ParserRuleContext {
        public SjKeyNameContext sjKeyName() {
            return getRuleContext(SjKeyNameContext.class, 0);
        }

        public SjRecordConstructFieldNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sjRecordConstructFieldName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSjRecordConstructFieldName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSjRecordConstructFieldName(this);
        }
    }

    public final SjRecordConstructFieldNameContext sjRecordConstructFieldName() throws RecognitionException {
        SjRecordConstructFieldNameContext _localctx = new SjRecordConstructFieldNameContext(_ctx, getState());
        enterRule(_localctx, 254, RULE_sjRecordConstructFieldName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(981);
                sjKeyName();
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

    public static class SjKeyNameContext extends ParserRuleContext {
        public TerminalNode STRING() {
            return getToken(QBTParser.STRING, 0);
        }

        public SjKeyNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sjKeyName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSjKeyName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSjKeyName(this);
        }
    }

    public final SjKeyNameContext sjKeyName() throws RecognitionException {
        SjKeyNameContext _localctx = new SjKeyNameContext(_ctx, getState());
        enterRule(_localctx, 256, RULE_sjKeyName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(983);
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

    public static class SjFieldValueContext extends ParserRuleContext {
        public SjVarContext sjVar() {
            return getRuleContext(SjVarContext.class, 0);
        }

        public SjFieldValueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sjFieldValue;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSjFieldValue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSjFieldValue(this);
        }
    }

    public final SjFieldValueContext sjFieldValue() throws RecognitionException {
        SjFieldValueContext _localctx = new SjFieldValueContext(_ctx, getState());
        enterRule(_localctx, 258, RULE_sjFieldValue);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(985);
                sjVar();
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

    public static class SjFieldNameContext extends ParserRuleContext {
        public TerminalNode NAME() {
            return getToken(QBTParser.NAME, 0);
        }

        public SjFieldNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sjFieldName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSjFieldName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSjFieldName(this);
        }
    }

    public final SjFieldNameContext sjFieldName() throws RecognitionException {
        SjFieldNameContext _localctx = new SjFieldNameContext(_ctx, getState());
        enterRule(_localctx, 260, RULE_sjFieldName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(987);
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

    public static class SjVarContext extends ParserRuleContext {
        public TerminalNode NAME() {
            return getToken(QBTParser.NAME, 0);
        }

        public SjVarContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sjVar;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSjVar(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSjVar(this);
        }
    }

    public final SjVarContext sjVar() throws RecognitionException {
        SjVarContext _localctx = new SjVarContext(_ctx, getState());
        enterRule(_localctx, 262, RULE_sjVar);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(989);
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

    public static class SjConstantContext extends ParserRuleContext {
        public TerminalNode STRING() {
            return getToken(QBTParser.STRING, 0);
        }

        public TerminalNode INTEGER() {
            return getToken(QBTParser.INTEGER, 0);
        }

        public SjConstantContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sjConstant;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSjConstant(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSjConstant(this);
        }
    }

    public final SjConstantContext sjConstant() throws RecognitionException {
        SjConstantContext _localctx = new SjConstantContext(_ctx, getState());
        enterRule(_localctx, 264, RULE_sjConstant);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(991);
                _la = _input.LA(1);
                if (!(_la == STRING || _la == INTEGER)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF)
                        matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
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

    public static class PjqlQueryContext extends ParserRuleContext {
        public ViewNameContext viewName() {
            return getRuleContext(ViewNameContext.class, 0);
        }

        public PjQueryContext pjQuery() {
            return getRuleContext(PjQueryContext.class, 0);
        }

        public TerminalNode EOF() {
            return getToken(QBTParser.EOF, 0);
        }

        public PjqlQueryContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjqlQuery;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjqlQuery(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjqlQuery(this);
        }
    }

    public final PjqlQueryContext pjqlQuery() throws RecognitionException {
        PjqlQueryContext _localctx = new PjqlQueryContext(_ctx, getState());
        enterRule(_localctx, 266, RULE_pjqlQuery);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(993);
                viewName();
                setState(994);
                match(T__0);
                setState(995);
                pjQuery();
                setState(996);
                match(EOF);
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

    public static class PjQueryContext extends ParserRuleContext {
        public PjFromWhereClauseContext pjFromWhereClause() {
            return getRuleContext(PjFromWhereClauseContext.class, 0);
        }

        public PjSelectClauseContext pjSelectClause() {
            return getRuleContext(PjSelectClauseContext.class, 0);
        }

        public PjQueryContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjQuery;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjQuery(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjQuery(this);
        }
    }

    public final PjQueryContext pjQuery() throws RecognitionException {
        PjQueryContext _localctx = new PjQueryContext(_ctx, getState());
        enterRule(_localctx, 268, RULE_pjQuery);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(998);
                pjFromWhereClause();
                setState(999);
                pjSelectClause();
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

    public static class PjSelectClauseContext extends ParserRuleContext {
        public PjSelectStatementContext pjSelectStatement() {
            return getRuleContext(PjSelectStatementContext.class, 0);
        }

        public PjSelectClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjSelectClause;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjSelectClause(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjSelectClause(this);
        }
    }

    public final PjSelectClauseContext pjSelectClause() throws RecognitionException {
        PjSelectClauseContext _localctx = new PjSelectClauseContext(_ctx, getState());
        enterRule(_localctx, 270, RULE_pjSelectClause);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1001);
                pjSelectStatement();
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

    public static class PjSelectStatementContext extends ParserRuleContext {
        public TerminalNode SELECT() {
            return getToken(QBTParser.SELECT, 0);
        }

        public List<PjSelectItemContext> pjSelectItem() {
            return getRuleContexts(PjSelectItemContext.class);
        }

        public PjSelectItemContext pjSelectItem(int i) {
            return getRuleContext(PjSelectItemContext.class, i);
        }

        public PjSelectStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjSelectStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjSelectStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjSelectStatement(this);
        }
    }

    public final PjSelectStatementContext pjSelectStatement() throws RecognitionException {
        PjSelectStatementContext _localctx = new PjSelectStatementContext(_ctx, getState());
        enterRule(_localctx, 272, RULE_pjSelectStatement);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1003);
                match(SELECT);
                setState(1004);
                pjSelectItem();
                setState(1009);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 45, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1005);
                                match(T__1);
                                setState(1006);
                                pjSelectItem();
                            }
                        }
                    }
                    setState(1011);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 45, _ctx);
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

    public static class PjSelectItemContext extends ParserRuleContext {
        public PjRecordConstructContext pjRecordConstruct() {
            return getRuleContext(PjRecordConstructContext.class, 0);
        }

        public PjSelectVarContext pjSelectVar() {
            return getRuleContext(PjSelectVarContext.class, 0);
        }

        public PjSelectConstantContext pjSelectConstant() {
            return getRuleContext(PjSelectConstantContext.class, 0);
        }

        public PjPathSelectContext pjPathSelect() {
            return getRuleContext(PjPathSelectContext.class, 0);
        }

        public PjSelectItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjSelectItem;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjSelectItem(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjSelectItem(this);
        }
    }

    public final PjSelectItemContext pjSelectItem() throws RecognitionException {
        PjSelectItemContext _localctx = new PjSelectItemContext(_ctx, getState());
        enterRule(_localctx, 274, RULE_pjSelectItem);
        try {
            setState(1016);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 46, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(1012);
                    pjRecordConstruct();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1013);
                    pjSelectVar();
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(1014);
                    pjSelectConstant();
                }
                    break;
                case 4:
                    enterOuterAlt(_localctx, 4); {
                    setState(1015);
                    pjPathSelect();
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

    public static class PjPathSelectContext extends ParserRuleContext {
        public PjPathContext pjPath() {
            return getRuleContext(PjPathContext.class, 0);
        }

        public TerminalNode AS() {
            return getToken(QBTParser.AS, 0);
        }

        public PjVariableContext pjVariable() {
            return getRuleContext(PjVariableContext.class, 0);
        }

        public PjPathSelectContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjPathSelect;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjPathSelect(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjPathSelect(this);
        }
    }

    public final PjPathSelectContext pjPathSelect() throws RecognitionException {
        PjPathSelectContext _localctx = new PjPathSelectContext(_ctx, getState());
        enterRule(_localctx, 276, RULE_pjPathSelect);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1018);
                pjPath();
                setState(1019);
                match(AS);
                setState(1020);
                pjVariable();
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

    public static class PjRecordConstructContext extends ParserRuleContext {
        public TerminalNode JSONBUILDOBJECT() {
            return getToken(QBTParser.JSONBUILDOBJECT, 0);
        }

        public List<PjFieldBindingContext> pjFieldBinding() {
            return getRuleContexts(PjFieldBindingContext.class);
        }

        public PjFieldBindingContext pjFieldBinding(int i) {
            return getRuleContext(PjFieldBindingContext.class, i);
        }

        public PjRecordConstructContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjRecordConstruct;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjRecordConstruct(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjRecordConstruct(this);
        }
    }

    public final PjRecordConstructContext pjRecordConstruct() throws RecognitionException {
        PjRecordConstructContext _localctx = new PjRecordConstructContext(_ctx, getState());
        enterRule(_localctx, 278, RULE_pjRecordConstruct);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1022);
                match(JSONBUILDOBJECT);
                setState(1023);
                match(T__5);
                setState(1024);
                pjFieldBinding();
                setState(1029);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__1) {
                    {
                        {
                            setState(1025);
                            match(T__1);
                            setState(1026);
                            pjFieldBinding();
                        }
                    }
                    setState(1031);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(1032);
                match(T__6);
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

    public static class PjFieldBindingContext extends ParserRuleContext {
        public PjRecordConstructFieldNameContext pjRecordConstructFieldName() {
            return getRuleContext(PjRecordConstructFieldNameContext.class, 0);
        }

        public PjFieldValueContext pjFieldValue() {
            return getRuleContext(PjFieldValueContext.class, 0);
        }

        public PjFieldBindingContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjFieldBinding;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjFieldBinding(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjFieldBinding(this);
        }
    }

    public final PjFieldBindingContext pjFieldBinding() throws RecognitionException {
        PjFieldBindingContext _localctx = new PjFieldBindingContext(_ctx, getState());
        enterRule(_localctx, 280, RULE_pjFieldBinding);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1034);
                pjRecordConstructFieldName();
                setState(1035);
                match(T__1);
                setState(1036);
                pjFieldValue();
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

    public static class PjRecordConstructFieldNameContext extends ParserRuleContext {
        public PjKeyContext pjKey() {
            return getRuleContext(PjKeyContext.class, 0);
        }

        public PjRecordConstructFieldNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjRecordConstructFieldName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjRecordConstructFieldName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjRecordConstructFieldName(this);
        }
    }

    public final PjRecordConstructFieldNameContext pjRecordConstructFieldName() throws RecognitionException {
        PjRecordConstructFieldNameContext _localctx = new PjRecordConstructFieldNameContext(_ctx, getState());
        enterRule(_localctx, 282, RULE_pjRecordConstructFieldName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1038);
                pjKey();
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

    public static class PjFieldValueContext extends ParserRuleContext {
        public PjRecordConstructContext pjRecordConstruct() {
            return getRuleContext(PjRecordConstructContext.class, 0);
        }

        public PjSelectVarContext pjSelectVar() {
            return getRuleContext(PjSelectVarContext.class, 0);
        }

        public PjSelectConstantContext pjSelectConstant() {
            return getRuleContext(PjSelectConstantContext.class, 0);
        }

        public PjSelectQueryContext pjSelectQuery() {
            return getRuleContext(PjSelectQueryContext.class, 0);
        }

        public PjFieldValueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjFieldValue;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjFieldValue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjFieldValue(this);
        }
    }

    public final PjFieldValueContext pjFieldValue() throws RecognitionException {
        PjFieldValueContext _localctx = new PjFieldValueContext(_ctx, getState());
        enterRule(_localctx, 284, RULE_pjFieldValue);
        try {
            setState(1044);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case JSONBUILDOBJECT:
                    enterOuterAlt(_localctx, 1); {
                    setState(1040);
                    pjRecordConstruct();
                }
                    break;
                case NAME:
                    enterOuterAlt(_localctx, 2); {
                    setState(1041);
                    pjSelectVar();
                }
                    break;
                case STRING:
                case INTEGER:
                    enterOuterAlt(_localctx, 3); {
                    setState(1042);
                    pjSelectConstant();
                }
                    break;
                case FROM:
                    enterOuterAlt(_localctx, 4); {
                    setState(1043);
                    pjSelectQuery();
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

    public static class PjSelectVarContext extends ParserRuleContext {
        public PjVariableContext pjVariable() {
            return getRuleContext(PjVariableContext.class, 0);
        }

        public PjSelectVarContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjSelectVar;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjSelectVar(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjSelectVar(this);
        }
    }

    public final PjSelectVarContext pjSelectVar() throws RecognitionException {
        PjSelectVarContext _localctx = new PjSelectVarContext(_ctx, getState());
        enterRule(_localctx, 286, RULE_pjSelectVar);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1046);
                pjVariable();
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

    public static class PjSelectConstantContext extends ParserRuleContext {
        public PjConstantContext pjConstant() {
            return getRuleContext(PjConstantContext.class, 0);
        }

        public PjSelectConstantContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjSelectConstant;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjSelectConstant(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjSelectConstant(this);
        }
    }

    public final PjSelectConstantContext pjSelectConstant() throws RecognitionException {
        PjSelectConstantContext _localctx = new PjSelectConstantContext(_ctx, getState());
        enterRule(_localctx, 288, RULE_pjSelectConstant);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1048);
                pjConstant();
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

    public static class PjSelectQueryContext extends ParserRuleContext {
        public PjQueryContext pjQuery() {
            return getRuleContext(PjQueryContext.class, 0);
        }

        public PjSelectQueryContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjSelectQuery;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjSelectQuery(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjSelectQuery(this);
        }
    }

    public final PjSelectQueryContext pjSelectQuery() throws RecognitionException {
        PjSelectQueryContext _localctx = new PjSelectQueryContext(_ctx, getState());
        enterRule(_localctx, 290, RULE_pjSelectQuery);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1050);
                pjQuery();
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

    public static class PjFromWhereClauseContext extends ParserRuleContext {
        public PjFromClauseContext pjFromClause() {
            return getRuleContext(PjFromClauseContext.class, 0);
        }

        public PjWhereClauseContext pjWhereClause() {
            return getRuleContext(PjWhereClauseContext.class, 0);
        }

        public PjFromWhereClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjFromWhereClause;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjFromWhereClause(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjFromWhereClause(this);
        }
    }

    public final PjFromWhereClauseContext pjFromWhereClause() throws RecognitionException {
        PjFromWhereClauseContext _localctx = new PjFromWhereClauseContext(_ctx, getState());
        enterRule(_localctx, 292, RULE_pjFromWhereClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1052);
                pjFromClause();
                setState(1054);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == WHERE) {
                    {
                        setState(1053);
                        pjWhereClause();
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

    public static class PjFromClauseContext extends ParserRuleContext {
        public TerminalNode FROM() {
            return getToken(QBTParser.FROM, 0);
        }

        public List<PjBindingContext> pjBinding() {
            return getRuleContexts(PjBindingContext.class);
        }

        public PjBindingContext pjBinding(int i) {
            return getRuleContext(PjBindingContext.class, i);
        }

        public PjFromClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjFromClause;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjFromClause(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjFromClause(this);
        }
    }

    public final PjFromClauseContext pjFromClause() throws RecognitionException {
        PjFromClauseContext _localctx = new PjFromClauseContext(_ctx, getState());
        enterRule(_localctx, 294, RULE_pjFromClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1056);
                match(FROM);
                setState(1057);
                pjBinding();
                setState(1062);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__1) {
                    {
                        {
                            setState(1058);
                            match(T__1);
                            setState(1059);
                            pjBinding();
                        }
                    }
                    setState(1064);
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

    public static class PjBindingContext extends ParserRuleContext {
        public PjFromClauseBindingSourceContext pjFromClauseBindingSource() {
            return getRuleContext(PjFromClauseBindingSourceContext.class, 0);
        }

        public TerminalNode AS() {
            return getToken(QBTParser.AS, 0);
        }

        public PjFromClauseBindingVarContext pjFromClauseBindingVar() {
            return getRuleContext(PjFromClauseBindingVarContext.class, 0);
        }

        public PjBindingContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjBinding;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjBinding(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjBinding(this);
        }
    }

    public final PjBindingContext pjBinding() throws RecognitionException {
        PjBindingContext _localctx = new PjBindingContext(_ctx, getState());
        enterRule(_localctx, 296, RULE_pjBinding);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1065);
                pjFromClauseBindingSource();
                setState(1066);
                match(AS);
                setState(1067);
                pjFromClauseBindingVar();
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

    public static class PjFromClauseBindingSourceContext extends ParserRuleContext {
        public PjSourceContext pjSource() {
            return getRuleContext(PjSourceContext.class, 0);
        }

        public PjFromClauseBindingSourceContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjFromClauseBindingSource;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjFromClauseBindingSource(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjFromClauseBindingSource(this);
        }
    }

    public final PjFromClauseBindingSourceContext pjFromClauseBindingSource() throws RecognitionException {
        PjFromClauseBindingSourceContext _localctx = new PjFromClauseBindingSourceContext(_ctx, getState());
        enterRule(_localctx, 298, RULE_pjFromClauseBindingSource);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1069);
                pjSource();
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

    public static class PjSourceContext extends ParserRuleContext {
        public PjRelationContext pjRelation() {
            return getRuleContext(PjRelationContext.class, 0);
        }

        public TerminalNode JSONARRAYELEMENTS() {
            return getToken(QBTParser.JSONARRAYELEMENTS, 0);
        }

        public PjPathContext pjPath() {
            return getRuleContext(PjPathContext.class, 0);
        }

        public PjSourceContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjSource;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjSource(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjSource(this);
        }
    }

    public final PjSourceContext pjSource() throws RecognitionException {
        PjSourceContext _localctx = new PjSourceContext(_ctx, getState());
        enterRule(_localctx, 300, RULE_pjSource);
        try {
            setState(1078);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 51, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(1071);
                    pjRelation();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1072);
                    match(JSONARRAYELEMENTS);
                    setState(1073);
                    match(T__5);
                    setState(1074);
                    pjPath();
                    setState(1075);
                    match(T__6);
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(1077);
                    pjPath();
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

    public static class PjFromClauseBindingVarContext extends ParserRuleContext {
        public PjVariableContext pjVariable() {
            return getRuleContext(PjVariableContext.class, 0);
        }

        public PjFromClauseBindingVarContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjFromClauseBindingVar;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjFromClauseBindingVar(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjFromClauseBindingVar(this);
        }
    }

    public final PjFromClauseBindingVarContext pjFromClauseBindingVar() throws RecognitionException {
        PjFromClauseBindingVarContext _localctx = new PjFromClauseBindingVarContext(_ctx, getState());
        enterRule(_localctx, 302, RULE_pjFromClauseBindingVar);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1080);
                pjVariable();
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

    public static class PjWhereClauseContext extends ParserRuleContext {
        public TerminalNode WHERE() {
            return getToken(QBTParser.WHERE, 0);
        }

        public PjConditionContext pjCondition() {
            return getRuleContext(PjConditionContext.class, 0);
        }

        public PjWhereClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjWhereClause;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjWhereClause(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjWhereClause(this);
        }
    }

    public final PjWhereClauseContext pjWhereClause() throws RecognitionException {
        PjWhereClauseContext _localctx = new PjWhereClauseContext(_ctx, getState());
        enterRule(_localctx, 304, RULE_pjWhereClause);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1082);
                match(WHERE);
                setState(1083);
                pjCondition(0);
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

    public static class PjConditionContext extends ParserRuleContext {
        public PjWhereCondEqualityContext pjWhereCondEquality() {
            return getRuleContext(PjWhereCondEqualityContext.class, 0);
        }

        public List<PjConditionContext> pjCondition() {
            return getRuleContexts(PjConditionContext.class);
        }

        public PjConditionContext pjCondition(int i) {
            return getRuleContext(PjConditionContext.class, i);
        }

        public TerminalNode AND() {
            return getToken(QBTParser.AND, 0);
        }

        public PjConditionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjCondition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjCondition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjCondition(this);
        }
    }

    public final PjConditionContext pjCondition() throws RecognitionException {
        return pjCondition(0);
    }

    private PjConditionContext pjCondition(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        PjConditionContext _localctx = new PjConditionContext(_ctx, _parentState);
        PjConditionContext _prevctx = _localctx;
        int _startState = 306;
        enterRecursionRule(_localctx, 306, RULE_pjCondition, _p);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1091);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case NAME:
                    case STRING:
                    case INTEGER: {
                        setState(1086);
                        pjWhereCondEquality();
                    }
                        break;
                    case T__5: {
                        setState(1087);
                        match(T__5);
                        setState(1088);
                        pjCondition(0);
                        setState(1089);
                        match(T__6);
                    }
                        break;
                    default:
                        throw new NoViableAltException(this);
                }
                _ctx.stop = _input.LT(-1);
                setState(1098);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 53, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null)
                            triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            {
                                _localctx = new PjConditionContext(_parentctx, _parentState);
                                pushNewRecursionContext(_localctx, _startState, RULE_pjCondition);
                                setState(1093);
                                if (!(precpred(_ctx, 2)))
                                    throw new FailedPredicateException(this, "precpred(_ctx, 2)");
                                setState(1094);
                                match(AND);
                                setState(1095);
                                pjCondition(3);
                            }
                        }
                    }
                    setState(1100);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 53, _ctx);
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

    public static class PjWhereCondEqualityContext extends ParserRuleContext {
        public PjWhereCondEqualityLeftTermContext pjWhereCondEqualityLeftTerm() {
            return getRuleContext(PjWhereCondEqualityLeftTermContext.class, 0);
        }

        public PjWhereCondEqualityRightTermContext pjWhereCondEqualityRightTerm() {
            return getRuleContext(PjWhereCondEqualityRightTermContext.class, 0);
        }

        public PjWhereCondEqualityContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjWhereCondEquality;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjWhereCondEquality(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjWhereCondEquality(this);
        }
    }

    public final PjWhereCondEqualityContext pjWhereCondEquality() throws RecognitionException {
        PjWhereCondEqualityContext _localctx = new PjWhereCondEqualityContext(_ctx, getState());
        enterRule(_localctx, 308, RULE_pjWhereCondEquality);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1101);
                pjWhereCondEqualityLeftTerm();
                setState(1102);
                match(T__0);
                setState(1103);
                pjWhereCondEqualityRightTerm();
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

    public static class PjWhereCondEqualityLeftTermContext extends ParserRuleContext {
        public PjCTermContext pjCTerm() {
            return getRuleContext(PjCTermContext.class, 0);
        }

        public PjWhereCondEqualityLeftTermContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjWhereCondEqualityLeftTerm;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjWhereCondEqualityLeftTerm(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjWhereCondEqualityLeftTerm(this);
        }
    }

    public final PjWhereCondEqualityLeftTermContext pjWhereCondEqualityLeftTerm() throws RecognitionException {
        PjWhereCondEqualityLeftTermContext _localctx = new PjWhereCondEqualityLeftTermContext(_ctx, getState());
        enterRule(_localctx, 310, RULE_pjWhereCondEqualityLeftTerm);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1105);
                pjCTerm();
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

    public static class PjWhereCondEqualityRightTermContext extends ParserRuleContext {
        public PjCTermContext pjCTerm() {
            return getRuleContext(PjCTermContext.class, 0);
        }

        public PjWhereCondEqualityRightTermContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjWhereCondEqualityRightTerm;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjWhereCondEqualityRightTerm(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjWhereCondEqualityRightTerm(this);
        }
    }

    public final PjWhereCondEqualityRightTermContext pjWhereCondEqualityRightTerm() throws RecognitionException {
        PjWhereCondEqualityRightTermContext _localctx = new PjWhereCondEqualityRightTermContext(_ctx, getState());
        enterRule(_localctx, 312, RULE_pjWhereCondEqualityRightTerm);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1107);
                pjCTerm();
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

    public static class PjCTermContext extends ParserRuleContext {
        public PjTermContext pjTerm() {
            return getRuleContext(PjTermContext.class, 0);
        }

        public PjCTermContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjCTerm;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjCTerm(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjCTerm(this);
        }
    }

    public final PjCTermContext pjCTerm() throws RecognitionException {
        PjCTermContext _localctx = new PjCTermContext(_ctx, getState());
        enterRule(_localctx, 314, RULE_pjCTerm);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1109);
                pjTerm();
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

    public static class PjTermContext extends ParserRuleContext {
        public PjTermConstantContext pjTermConstant() {
            return getRuleContext(PjTermConstantContext.class, 0);
        }

        public PjTermVarContext pjTermVar() {
            return getRuleContext(PjTermVarContext.class, 0);
        }

        public PjTermPathContext pjTermPath() {
            return getRuleContext(PjTermPathContext.class, 0);
        }

        public PjTermContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjTerm;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjTerm(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjTerm(this);
        }
    }

    public final PjTermContext pjTerm() throws RecognitionException {
        PjTermContext _localctx = new PjTermContext(_ctx, getState());
        enterRule(_localctx, 316, RULE_pjTerm);
        try {
            setState(1114);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 54, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(1111);
                    pjTermConstant();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1112);
                    pjTermVar();
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(1113);
                    pjTermPath();
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

    public static class PjTermVarContext extends ParserRuleContext {
        public PjVariableContext pjVariable() {
            return getRuleContext(PjVariableContext.class, 0);
        }

        public PjTermVarContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjTermVar;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjTermVar(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjTermVar(this);
        }
    }

    public final PjTermVarContext pjTermVar() throws RecognitionException {
        PjTermVarContext _localctx = new PjTermVarContext(_ctx, getState());
        enterRule(_localctx, 318, RULE_pjTermVar);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1116);
                pjVariable();
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

    public static class PjTermConstantContext extends ParserRuleContext {
        public PjConstantContext pjConstant() {
            return getRuleContext(PjConstantContext.class, 0);
        }

        public PjTermConstantContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjTermConstant;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjTermConstant(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjTermConstant(this);
        }
    }

    public final PjTermConstantContext pjTermConstant() throws RecognitionException {
        PjTermConstantContext _localctx = new PjTermConstantContext(_ctx, getState());
        enterRule(_localctx, 320, RULE_pjTermConstant);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1118);
                pjConstant();
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

    public static class PjTermPathContext extends ParserRuleContext {
        public PjPathContext pjPath() {
            return getRuleContext(PjPathContext.class, 0);
        }

        public PjTermPathContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjTermPath;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjTermPath(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjTermPath(this);
        }
    }

    public final PjTermPathContext pjTermPath() throws RecognitionException {
        PjTermPathContext _localctx = new PjTermPathContext(_ctx, getState());
        enterRule(_localctx, 322, RULE_pjTermPath);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1120);
                pjPath();
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

    public static class PjPathContext extends ParserRuleContext {
        public PjPathVarContext pjPathVar() {
            return getRuleContext(PjPathVarContext.class, 0);
        }

        public List<PjStepContext> pjStep() {
            return getRuleContexts(PjStepContext.class);
        }

        public PjStepContext pjStep(int i) {
            return getRuleContext(PjStepContext.class, i);
        }

        public PjPathContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjPath;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjPath(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjPath(this);
        }
    }

    public final PjPathContext pjPath() throws RecognitionException {
        PjPathContext _localctx = new PjPathContext(_ctx, getState());
        enterRule(_localctx, 324, RULE_pjPath);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1122);
                pjPathVar();
                setState(1124);
                _errHandler.sync(this);
                _alt = 1 + 1;
                do {
                    switch (_alt) {
                        case 1 + 1: {
                            {
                                setState(1123);
                                pjStep();
                            }
                        }
                            break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(1126);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 55, _ctx);
                } while (_alt != 1 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
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

    public static class PjPathVarContext extends ParserRuleContext {
        public PjVariableContext pjVariable() {
            return getRuleContext(PjVariableContext.class, 0);
        }

        public PjPathAttrContext pjPathAttr() {
            return getRuleContext(PjPathAttrContext.class, 0);
        }

        public PjPathVarContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjPathVar;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjPathVar(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjPathVar(this);
        }
    }

    public final PjPathVarContext pjPathVar() throws RecognitionException {
        PjPathVarContext _localctx = new PjPathVarContext(_ctx, getState());
        enterRule(_localctx, 326, RULE_pjPathVar);
        try {
            setState(1130);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 56, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(1128);
                    pjVariable();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1129);
                    pjPathAttr();
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

    public static class PjStepContext extends ParserRuleContext {
        public PjObjStepContext pjObjStep() {
            return getRuleContext(PjObjStepContext.class, 0);
        }

        public PjStepContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjStep;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjStep(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjStep(this);
        }
    }

    public final PjStepContext pjStep() throws RecognitionException {
        PjStepContext _localctx = new PjStepContext(_ctx, getState());
        enterRule(_localctx, 328, RULE_pjStep);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1132);
                pjObjStep();
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

    public static class PjObjStepContext extends ParserRuleContext {
        public PjKeyContext pjKey() {
            return getRuleContext(PjKeyContext.class, 0);
        }

        public PjObjStepContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjObjStep;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjObjStep(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjObjStep(this);
        }
    }

    public final PjObjStepContext pjObjStep() throws RecognitionException {
        PjObjStepContext _localctx = new PjObjStepContext(_ctx, getState());
        enterRule(_localctx, 330, RULE_pjObjStep);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1134);
                match(T__24);
                setState(1135);
                pjKey();
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

    public static class PjPathAttrContext extends ParserRuleContext {
        public PjVariableContext pjVariable() {
            return getRuleContext(PjVariableContext.class, 0);
        }

        public AttributeContext attribute() {
            return getRuleContext(AttributeContext.class, 0);
        }

        public PjPathAttrContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjPathAttr;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjPathAttr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjPathAttr(this);
        }
    }

    public final PjPathAttrContext pjPathAttr() throws RecognitionException {
        PjPathAttrContext _localctx = new PjPathAttrContext(_ctx, getState());
        enterRule(_localctx, 332, RULE_pjPathAttr);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1137);
                pjVariable();
                setState(1138);
                match(T__9);
                setState(1139);
                attribute();
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

    public static class PjVariableContext extends ParserRuleContext {
        public TerminalNode NAME() {
            return getToken(QBTParser.NAME, 0);
        }

        public PjVariableContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjVariable;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjVariable(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjVariable(this);
        }
    }

    public final PjVariableContext pjVariable() throws RecognitionException {
        PjVariableContext _localctx = new PjVariableContext(_ctx, getState());
        enterRule(_localctx, 334, RULE_pjVariable);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1141);
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

    public static class PjRelationContext extends ParserRuleContext {
        public TerminalNode NAME() {
            return getToken(QBTParser.NAME, 0);
        }

        public PjRelationContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjRelation;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjRelation(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjRelation(this);
        }
    }

    public final PjRelationContext pjRelation() throws RecognitionException {
        PjRelationContext _localctx = new PjRelationContext(_ctx, getState());
        enterRule(_localctx, 336, RULE_pjRelation);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1143);
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

    public static class PjKeyContext extends ParserRuleContext {
        public TerminalNode STRING() {
            return getToken(QBTParser.STRING, 0);
        }

        public TerminalNode NAME() {
            return getToken(QBTParser.NAME, 0);
        }

        public PjKeyContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjKey;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjKey(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjKey(this);
        }
    }

    public final PjKeyContext pjKey() throws RecognitionException {
        PjKeyContext _localctx = new PjKeyContext(_ctx, getState());
        enterRule(_localctx, 338, RULE_pjKey);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1145);
                _la = _input.LA(1);
                if (!(_la == NAME || _la == STRING)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF)
                        matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
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

    public static class PjConstantContext extends ParserRuleContext {
        public TerminalNode INTEGER() {
            return getToken(QBTParser.INTEGER, 0);
        }

        public TerminalNode STRING() {
            return getToken(QBTParser.STRING, 0);
        }

        public PjConstantContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_pjConstant;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterPjConstant(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitPjConstant(this);
        }
    }

    public final PjConstantContext pjConstant() throws RecognitionException {
        PjConstantContext _localctx = new PjConstantContext(_ctx, getState());
        enterRule(_localctx, 340, RULE_pjConstant);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1147);
                _la = _input.LA(1);
                if (!(_la == STRING || _la == INTEGER)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF)
                        matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
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

    public static class AttributeContext extends ParserRuleContext {
        public TerminalNode NAME() {
            return getToken(QBTParser.NAME, 0);
        }

        public AttributeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_attribute;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterAttribute(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitAttribute(this);
        }
    }

    public final AttributeContext attribute() throws RecognitionException {
        AttributeContext _localctx = new AttributeContext(_ctx, getState());
        enterRule(_localctx, 342, RULE_attribute);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1149);
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

    public static class SppjqlQueryContext extends ParserRuleContext {
        public ViewNameContext viewName() {
            return getRuleContext(ViewNameContext.class, 0);
        }

        public SppjQueryContext sppjQuery() {
            return getRuleContext(SppjQueryContext.class, 0);
        }

        public TerminalNode EOF() {
            return getToken(QBTParser.EOF, 0);
        }

        public SppjRootFieldNameContext sppjRootFieldName() {
            return getRuleContext(SppjRootFieldNameContext.class, 0);
        }

        public SppjqlQueryContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjqlQuery;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjqlQuery(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjqlQuery(this);
        }
    }

    public final SppjqlQueryContext sppjqlQuery() throws RecognitionException {
        SppjqlQueryContext _localctx = new SppjqlQueryContext(_ctx, getState());
        enterRule(_localctx, 344, RULE_sppjqlQuery);
        try {
            setState(1162);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case NAME:
                    enterOuterAlt(_localctx, 1); {
                    setState(1151);
                    viewName();
                    setState(1152);
                    match(T__0);
                    setState(1153);
                    sppjQuery();
                    setState(1154);
                    match(EOF);
                }
                    break;
                case T__3:
                    enterOuterAlt(_localctx, 2); {
                    setState(1156);
                    match(T__3);
                    setState(1157);
                    sppjRootFieldName();
                    setState(1158);
                    match(T__2);
                    setState(1159);
                    sppjQuery();
                    setState(1160);
                    match(T__4);
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

    public static class SppjQueryContext extends ParserRuleContext {
        public SppjFromWhereClauseContext sppjFromWhereClause() {
            return getRuleContext(SppjFromWhereClauseContext.class, 0);
        }

        public SppjSelectClauseContext sppjSelectClause() {
            return getRuleContext(SppjSelectClauseContext.class, 0);
        }

        public SppjQueryContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjQuery;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjQuery(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjQuery(this);
        }
    }

    public final SppjQueryContext sppjQuery() throws RecognitionException {
        SppjQueryContext _localctx = new SppjQueryContext(_ctx, getState());
        enterRule(_localctx, 346, RULE_sppjQuery);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1164);
                sppjFromWhereClause();
                setState(1165);
                sppjSelectClause();
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

    public static class SppjRootFieldNameContext extends ParserRuleContext {
        public SppjFieldNameContext sppjFieldName() {
            return getRuleContext(SppjFieldNameContext.class, 0);
        }

        public SppjRootFieldNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjRootFieldName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjRootFieldName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjRootFieldName(this);
        }
    }

    public final SppjRootFieldNameContext sppjRootFieldName() throws RecognitionException {
        SppjRootFieldNameContext _localctx = new SppjRootFieldNameContext(_ctx, getState());
        enterRule(_localctx, 348, RULE_sppjRootFieldName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1167);
                sppjFieldName();
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

    public static class SppjSelectClauseContext extends ParserRuleContext {
        public SppjSelectStatementContext sppjSelectStatement() {
            return getRuleContext(SppjSelectStatementContext.class, 0);
        }

        public SppjSelectClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjSelectClause;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjSelectClause(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjSelectClause(this);
        }
    }

    public final SppjSelectClauseContext sppjSelectClause() throws RecognitionException {
        SppjSelectClauseContext _localctx = new SppjSelectClauseContext(_ctx, getState());
        enterRule(_localctx, 350, RULE_sppjSelectClause);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1169);
                sppjSelectStatement();
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

    public static class SppjSelectStatementContext extends ParserRuleContext {
        public TerminalNode SELECT() {
            return getToken(QBTParser.SELECT, 0);
        }

        public SppjSelectItemContext sppjSelectItem() {
            return getRuleContext(SppjSelectItemContext.class, 0);
        }

        public SppjSelectStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjSelectStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjSelectStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjSelectStatement(this);
        }
    }

    public final SppjSelectStatementContext sppjSelectStatement() throws RecognitionException {
        SppjSelectStatementContext _localctx = new SppjSelectStatementContext(_ctx, getState());
        enterRule(_localctx, 352, RULE_sppjSelectStatement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1171);
                match(SELECT);
                setState(1172);
                sppjSelectItem();
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

    public static class SppjSelectItemContext extends ParserRuleContext {
        public SppjRecordConstructContext sppjRecordConstruct() {
            return getRuleContext(SppjRecordConstructContext.class, 0);
        }

        public SppjSelectVarContext sppjSelectVar() {
            return getRuleContext(SppjSelectVarContext.class, 0);
        }

        public SppjSelectConstantContext sppjSelectConstant() {
            return getRuleContext(SppjSelectConstantContext.class, 0);
        }

        public SppjSelectItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjSelectItem;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjSelectItem(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjSelectItem(this);
        }
    }

    public final SppjSelectItemContext sppjSelectItem() throws RecognitionException {
        SppjSelectItemContext _localctx = new SppjSelectItemContext(_ctx, getState());
        enterRule(_localctx, 354, RULE_sppjSelectItem);
        try {
            setState(1177);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__3:
                    enterOuterAlt(_localctx, 1); {
                    setState(1174);
                    sppjRecordConstruct();
                }
                    break;
                case NAME:
                    enterOuterAlt(_localctx, 2); {
                    setState(1175);
                    sppjSelectVar();
                }
                    break;
                case STRING:
                case INTEGER:
                    enterOuterAlt(_localctx, 3); {
                    setState(1176);
                    sppjSelectConstant();
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

    public static class SppjRecordConstructContext extends ParserRuleContext {
        public List<SppjFieldBindingContext> sppjFieldBinding() {
            return getRuleContexts(SppjFieldBindingContext.class);
        }

        public SppjFieldBindingContext sppjFieldBinding(int i) {
            return getRuleContext(SppjFieldBindingContext.class, i);
        }

        public SppjRecordConstructContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjRecordConstruct;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjRecordConstruct(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjRecordConstruct(this);
        }
    }

    public final SppjRecordConstructContext sppjRecordConstruct() throws RecognitionException {
        SppjRecordConstructContext _localctx = new SppjRecordConstructContext(_ctx, getState());
        enterRule(_localctx, 356, RULE_sppjRecordConstruct);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1179);
                match(T__3);
                setState(1180);
                sppjFieldBinding();
                setState(1185);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__1) {
                    {
                        {
                            setState(1181);
                            match(T__1);
                            setState(1182);
                            sppjFieldBinding();
                        }
                    }
                    setState(1187);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(1188);
                match(T__4);
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

    public static class SppjFieldBindingContext extends ParserRuleContext {
        public SppjRecordConstructFieldNameContext sppjRecordConstructFieldName() {
            return getRuleContext(SppjRecordConstructFieldNameContext.class, 0);
        }

        public SppjFieldValueContext sppjFieldValue() {
            return getRuleContext(SppjFieldValueContext.class, 0);
        }

        public SppjFieldBindingContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjFieldBinding;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjFieldBinding(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjFieldBinding(this);
        }
    }

    public final SppjFieldBindingContext sppjFieldBinding() throws RecognitionException {
        SppjFieldBindingContext _localctx = new SppjFieldBindingContext(_ctx, getState());
        enterRule(_localctx, 358, RULE_sppjFieldBinding);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1190);
                sppjRecordConstructFieldName();
                setState(1191);
                match(T__2);
                setState(1192);
                sppjFieldValue();
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

    public static class SppjRecordConstructFieldNameContext extends ParserRuleContext {
        public KeyContext key() {
            return getRuleContext(KeyContext.class, 0);
        }

        public SppjRecordConstructFieldNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjRecordConstructFieldName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjRecordConstructFieldName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjRecordConstructFieldName(this);
        }
    }

    public final SppjRecordConstructFieldNameContext sppjRecordConstructFieldName() throws RecognitionException {
        SppjRecordConstructFieldNameContext _localctx = new SppjRecordConstructFieldNameContext(_ctx, getState());
        enterRule(_localctx, 360, RULE_sppjRecordConstructFieldName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1194);
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

    public static class SppjFieldValueContext extends ParserRuleContext {
        public SppjRecordConstructContext sppjRecordConstruct() {
            return getRuleContext(SppjRecordConstructContext.class, 0);
        }

        public SppjSelectVarContext sppjSelectVar() {
            return getRuleContext(SppjSelectVarContext.class, 0);
        }

        public SppjSelectConstantContext sppjSelectConstant() {
            return getRuleContext(SppjSelectConstantContext.class, 0);
        }

        public SppjSelectQueryContext sppjSelectQuery() {
            return getRuleContext(SppjSelectQueryContext.class, 0);
        }

        public SppjFieldValueContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjFieldValue;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjFieldValue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjFieldValue(this);
        }
    }

    public final SppjFieldValueContext sppjFieldValue() throws RecognitionException {
        SppjFieldValueContext _localctx = new SppjFieldValueContext(_ctx, getState());
        enterRule(_localctx, 362, RULE_sppjFieldValue);
        try {
            setState(1200);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__3:
                    enterOuterAlt(_localctx, 1); {
                    setState(1196);
                    sppjRecordConstruct();
                }
                    break;
                case NAME:
                    enterOuterAlt(_localctx, 2); {
                    setState(1197);
                    sppjSelectVar();
                }
                    break;
                case STRING:
                case INTEGER:
                    enterOuterAlt(_localctx, 3); {
                    setState(1198);
                    sppjSelectConstant();
                }
                    break;
                case FROM:
                    enterOuterAlt(_localctx, 4); {
                    setState(1199);
                    sppjSelectQuery();
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

    public static class SppjSelectVarContext extends ParserRuleContext {
        public SppjVariableContext sppjVariable() {
            return getRuleContext(SppjVariableContext.class, 0);
        }

        public SppjSelectVarContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjSelectVar;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjSelectVar(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjSelectVar(this);
        }
    }

    public final SppjSelectVarContext sppjSelectVar() throws RecognitionException {
        SppjSelectVarContext _localctx = new SppjSelectVarContext(_ctx, getState());
        enterRule(_localctx, 364, RULE_sppjSelectVar);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1202);
                sppjVariable();
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

    public static class SppjSelectConstantContext extends ParserRuleContext {
        public SppjConstantContext sppjConstant() {
            return getRuleContext(SppjConstantContext.class, 0);
        }

        public SppjSelectConstantContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjSelectConstant;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjSelectConstant(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjSelectConstant(this);
        }
    }

    public final SppjSelectConstantContext sppjSelectConstant() throws RecognitionException {
        SppjSelectConstantContext _localctx = new SppjSelectConstantContext(_ctx, getState());
        enterRule(_localctx, 366, RULE_sppjSelectConstant);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1204);
                sppjConstant();
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

    public static class SppjSelectQueryContext extends ParserRuleContext {
        public SppjQueryContext sppjQuery() {
            return getRuleContext(SppjQueryContext.class, 0);
        }

        public SppjSelectQueryContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjSelectQuery;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjSelectQuery(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjSelectQuery(this);
        }
    }

    public final SppjSelectQueryContext sppjSelectQuery() throws RecognitionException {
        SppjSelectQueryContext _localctx = new SppjSelectQueryContext(_ctx, getState());
        enterRule(_localctx, 368, RULE_sppjSelectQuery);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1206);
                sppjQuery();
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

    public static class SppjFromWhereClauseContext extends ParserRuleContext {
        public SppjFromClauseContext sppjFromClause() {
            return getRuleContext(SppjFromClauseContext.class, 0);
        }

        public SppjWhereClauseContext sppjWhereClause() {
            return getRuleContext(SppjWhereClauseContext.class, 0);
        }

        public SppjFromWhereClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjFromWhereClause;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjFromWhereClause(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjFromWhereClause(this);
        }
    }

    public final SppjFromWhereClauseContext sppjFromWhereClause() throws RecognitionException {
        SppjFromWhereClauseContext _localctx = new SppjFromWhereClauseContext(_ctx, getState());
        enterRule(_localctx, 370, RULE_sppjFromWhereClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1208);
                sppjFromClause();
                setState(1210);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == WHERE) {
                    {
                        setState(1209);
                        sppjWhereClause();
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

    public static class SppjFromClauseContext extends ParserRuleContext {
        public TerminalNode FROM() {
            return getToken(QBTParser.FROM, 0);
        }

        public List<SppjBindingContext> sppjBinding() {
            return getRuleContexts(SppjBindingContext.class);
        }

        public SppjBindingContext sppjBinding(int i) {
            return getRuleContext(SppjBindingContext.class, i);
        }

        public SppjFromClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjFromClause;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjFromClause(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjFromClause(this);
        }
    }

    public final SppjFromClauseContext sppjFromClause() throws RecognitionException {
        SppjFromClauseContext _localctx = new SppjFromClauseContext(_ctx, getState());
        enterRule(_localctx, 372, RULE_sppjFromClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1212);
                match(FROM);
                setState(1213);
                sppjBinding();
                setState(1218);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == T__1) {
                    {
                        {
                            setState(1214);
                            match(T__1);
                            setState(1215);
                            sppjBinding();
                        }
                    }
                    setState(1220);
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

    public static class SppjBindingContext extends ParserRuleContext {
        public SppjFromClauseBindingSourceContext sppjFromClauseBindingSource() {
            return getRuleContext(SppjFromClauseBindingSourceContext.class, 0);
        }

        public TerminalNode AS() {
            return getToken(QBTParser.AS, 0);
        }

        public SppjFromClauseBindingVarContext sppjFromClauseBindingVar() {
            return getRuleContext(SppjFromClauseBindingVarContext.class, 0);
        }

        public SppjBindingContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjBinding;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjBinding(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjBinding(this);
        }
    }

    public final SppjBindingContext sppjBinding() throws RecognitionException {
        SppjBindingContext _localctx = new SppjBindingContext(_ctx, getState());
        enterRule(_localctx, 374, RULE_sppjBinding);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1221);
                sppjFromClauseBindingSource();
                setState(1222);
                match(AS);
                setState(1223);
                sppjFromClauseBindingVar();
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

    public static class SppjFromClauseBindingSourceContext extends ParserRuleContext {
        public SppjSourceContext sppjSource() {
            return getRuleContext(SppjSourceContext.class, 0);
        }

        public SppjFromClauseBindingSourceContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjFromClauseBindingSource;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjFromClauseBindingSource(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjFromClauseBindingSource(this);
        }
    }

    public final SppjFromClauseBindingSourceContext sppjFromClauseBindingSource() throws RecognitionException {
        SppjFromClauseBindingSourceContext _localctx = new SppjFromClauseBindingSourceContext(_ctx, getState());
        enterRule(_localctx, 376, RULE_sppjFromClauseBindingSource);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1225);
                sppjSource();
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

    public static class SppjSourceContext extends ParserRuleContext {
        public DataSetNameContext dataSetName() {
            return getRuleContext(DataSetNameContext.class, 0);
        }

        public SppjPathContext sppjPath() {
            return getRuleContext(SppjPathContext.class, 0);
        }

        public SppjSourceContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjSource;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjSource(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjSource(this);
        }
    }

    public final SppjSourceContext sppjSource() throws RecognitionException {
        SppjSourceContext _localctx = new SppjSourceContext(_ctx, getState());
        enterRule(_localctx, 378, RULE_sppjSource);
        try {
            setState(1229);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 63, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(1227);
                    dataSetName();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1228);
                    sppjPath();
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

    public static class SppjFromClauseBindingVarContext extends ParserRuleContext {
        public SppjVariableContext sppjVariable() {
            return getRuleContext(SppjVariableContext.class, 0);
        }

        public SppjFromClauseBindingVarContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjFromClauseBindingVar;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjFromClauseBindingVar(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjFromClauseBindingVar(this);
        }
    }

    public final SppjFromClauseBindingVarContext sppjFromClauseBindingVar() throws RecognitionException {
        SppjFromClauseBindingVarContext _localctx = new SppjFromClauseBindingVarContext(_ctx, getState());
        enterRule(_localctx, 380, RULE_sppjFromClauseBindingVar);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1231);
                sppjVariable();
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

    public static class SppjWhereClauseContext extends ParserRuleContext {
        public TerminalNode WHERE() {
            return getToken(QBTParser.WHERE, 0);
        }

        public SppjConditionContext sppjCondition() {
            return getRuleContext(SppjConditionContext.class, 0);
        }

        public SppjWhereClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjWhereClause;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjWhereClause(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjWhereClause(this);
        }
    }

    public final SppjWhereClauseContext sppjWhereClause() throws RecognitionException {
        SppjWhereClauseContext _localctx = new SppjWhereClauseContext(_ctx, getState());
        enterRule(_localctx, 382, RULE_sppjWhereClause);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1233);
                match(WHERE);
                setState(1234);
                sppjCondition(0);
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

    public static class SppjConditionContext extends ParserRuleContext {
        public SppjWhereCondEqualityContext sppjWhereCondEquality() {
            return getRuleContext(SppjWhereCondEqualityContext.class, 0);
        }

        public List<SppjConditionContext> sppjCondition() {
            return getRuleContexts(SppjConditionContext.class);
        }

        public SppjConditionContext sppjCondition(int i) {
            return getRuleContext(SppjConditionContext.class, i);
        }

        public TerminalNode AND() {
            return getToken(QBTParser.AND, 0);
        }

        public SppjConditionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjCondition;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjCondition(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjCondition(this);
        }
    }

    public final SppjConditionContext sppjCondition() throws RecognitionException {
        return sppjCondition(0);
    }

    private SppjConditionContext sppjCondition(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        SppjConditionContext _localctx = new SppjConditionContext(_ctx, _parentState);
        SppjConditionContext _prevctx = _localctx;
        int _startState = 384;
        enterRecursionRule(_localctx, 384, RULE_sppjCondition, _p);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1242);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case NAME:
                    case STRING:
                    case INTEGER: {
                        setState(1237);
                        sppjWhereCondEquality();
                    }
                        break;
                    case T__5: {
                        setState(1238);
                        match(T__5);
                        setState(1239);
                        sppjCondition(0);
                        setState(1240);
                        match(T__6);
                    }
                        break;
                    default:
                        throw new NoViableAltException(this);
                }
                _ctx.stop = _input.LT(-1);
                setState(1249);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 65, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null)
                            triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            {
                                _localctx = new SppjConditionContext(_parentctx, _parentState);
                                pushNewRecursionContext(_localctx, _startState, RULE_sppjCondition);
                                setState(1244);
                                if (!(precpred(_ctx, 2)))
                                    throw new FailedPredicateException(this, "precpred(_ctx, 2)");
                                setState(1245);
                                match(AND);
                                setState(1246);
                                sppjCondition(3);
                            }
                        }
                    }
                    setState(1251);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 65, _ctx);
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

    public static class SppjWhereCondEqualityContext extends ParserRuleContext {
        public SppjWhereCondEqualityLeftTermContext sppjWhereCondEqualityLeftTerm() {
            return getRuleContext(SppjWhereCondEqualityLeftTermContext.class, 0);
        }

        public SppjWhereCondEqualityRightTermContext sppjWhereCondEqualityRightTerm() {
            return getRuleContext(SppjWhereCondEqualityRightTermContext.class, 0);
        }

        public SppjWhereCondEqualityContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjWhereCondEquality;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjWhereCondEquality(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjWhereCondEquality(this);
        }
    }

    public final SppjWhereCondEqualityContext sppjWhereCondEquality() throws RecognitionException {
        SppjWhereCondEqualityContext _localctx = new SppjWhereCondEqualityContext(_ctx, getState());
        enterRule(_localctx, 386, RULE_sppjWhereCondEquality);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1252);
                sppjWhereCondEqualityLeftTerm();
                setState(1253);
                match(T__0);
                setState(1254);
                sppjWhereCondEqualityRightTerm();
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

    public static class SppjWhereCondEqualityLeftTermContext extends ParserRuleContext {
        public SppjCTermContext sppjCTerm() {
            return getRuleContext(SppjCTermContext.class, 0);
        }

        public SppjWhereCondEqualityLeftTermContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjWhereCondEqualityLeftTerm;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjWhereCondEqualityLeftTerm(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjWhereCondEqualityLeftTerm(this);
        }
    }

    public final SppjWhereCondEqualityLeftTermContext sppjWhereCondEqualityLeftTerm() throws RecognitionException {
        SppjWhereCondEqualityLeftTermContext _localctx = new SppjWhereCondEqualityLeftTermContext(_ctx, getState());
        enterRule(_localctx, 388, RULE_sppjWhereCondEqualityLeftTerm);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1256);
                sppjCTerm();
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

    public static class SppjWhereCondEqualityRightTermContext extends ParserRuleContext {
        public SppjCTermContext sppjCTerm() {
            return getRuleContext(SppjCTermContext.class, 0);
        }

        public SppjWhereCondEqualityRightTermContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjWhereCondEqualityRightTerm;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjWhereCondEqualityRightTerm(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjWhereCondEqualityRightTerm(this);
        }
    }

    public final SppjWhereCondEqualityRightTermContext sppjWhereCondEqualityRightTerm() throws RecognitionException {
        SppjWhereCondEqualityRightTermContext _localctx = new SppjWhereCondEqualityRightTermContext(_ctx, getState());
        enterRule(_localctx, 390, RULE_sppjWhereCondEqualityRightTerm);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1258);
                sppjCTerm();
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

    public static class SppjCTermContext extends ParserRuleContext {
        public SppjTermContext sppjTerm() {
            return getRuleContext(SppjTermContext.class, 0);
        }

        public SppjCTermContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjCTerm;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjCTerm(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjCTerm(this);
        }
    }

    public final SppjCTermContext sppjCTerm() throws RecognitionException {
        SppjCTermContext _localctx = new SppjCTermContext(_ctx, getState());
        enterRule(_localctx, 392, RULE_sppjCTerm);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1260);
                sppjTerm();
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

    public static class SppjTermContext extends ParserRuleContext {
        public SppjTermConstantContext sppjTermConstant() {
            return getRuleContext(SppjTermConstantContext.class, 0);
        }

        public SppjTermVarContext sppjTermVar() {
            return getRuleContext(SppjTermVarContext.class, 0);
        }

        public SppjTermPathContext sppjTermPath() {
            return getRuleContext(SppjTermPathContext.class, 0);
        }

        public SppjTermContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjTerm;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjTerm(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjTerm(this);
        }
    }

    public final SppjTermContext sppjTerm() throws RecognitionException {
        SppjTermContext _localctx = new SppjTermContext(_ctx, getState());
        enterRule(_localctx, 394, RULE_sppjTerm);
        try {
            setState(1265);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 66, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1); {
                    setState(1262);
                    sppjTermConstant();
                }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2); {
                    setState(1263);
                    sppjTermVar();
                }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3); {
                    setState(1264);
                    sppjTermPath();
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

    public static class SppjTermVarContext extends ParserRuleContext {
        public SppjVariableContext sppjVariable() {
            return getRuleContext(SppjVariableContext.class, 0);
        }

        public SppjTermVarContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjTermVar;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjTermVar(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjTermVar(this);
        }
    }

    public final SppjTermVarContext sppjTermVar() throws RecognitionException {
        SppjTermVarContext _localctx = new SppjTermVarContext(_ctx, getState());
        enterRule(_localctx, 396, RULE_sppjTermVar);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1267);
                sppjVariable();
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

    public static class SppjTermConstantContext extends ParserRuleContext {
        public SppjConstantContext sppjConstant() {
            return getRuleContext(SppjConstantContext.class, 0);
        }

        public SppjTermConstantContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjTermConstant;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjTermConstant(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjTermConstant(this);
        }
    }

    public final SppjTermConstantContext sppjTermConstant() throws RecognitionException {
        SppjTermConstantContext _localctx = new SppjTermConstantContext(_ctx, getState());
        enterRule(_localctx, 398, RULE_sppjTermConstant);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1269);
                sppjConstant();
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

    public static class SppjTermPathContext extends ParserRuleContext {
        public SppjPathContext sppjPath() {
            return getRuleContext(SppjPathContext.class, 0);
        }

        public SppjTermPathContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjTermPath;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjTermPath(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjTermPath(this);
        }
    }

    public final SppjTermPathContext sppjTermPath() throws RecognitionException {
        SppjTermPathContext _localctx = new SppjTermPathContext(_ctx, getState());
        enterRule(_localctx, 400, RULE_sppjTermPath);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1271);
                sppjPath();
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

    public static class SppjPathContext extends ParserRuleContext {
        public SppjPathVarContext sppjPathVar() {
            return getRuleContext(SppjPathVarContext.class, 0);
        }

        public List<SppjStepContext> sppjStep() {
            return getRuleContexts(SppjStepContext.class);
        }

        public SppjStepContext sppjStep(int i) {
            return getRuleContext(SppjStepContext.class, i);
        }

        public SppjPathContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjPath;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjPath(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjPath(this);
        }
    }

    public final SppjPathContext sppjPath() throws RecognitionException {
        SppjPathContext _localctx = new SppjPathContext(_ctx, getState());
        enterRule(_localctx, 402, RULE_sppjPath);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1273);
                sppjPathVar();
                setState(1275);
                _errHandler.sync(this);
                _alt = 1 + 1;
                do {
                    switch (_alt) {
                        case 1 + 1: {
                            {
                                setState(1274);
                                sppjStep();
                            }
                        }
                            break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(1277);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 67, _ctx);
                } while (_alt != 1 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
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

    public static class SppjPathVarContext extends ParserRuleContext {
        public SppjVariableContext sppjVariable() {
            return getRuleContext(SppjVariableContext.class, 0);
        }

        public SppjPathVarContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjPathVar;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjPathVar(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjPathVar(this);
        }
    }

    public final SppjPathVarContext sppjPathVar() throws RecognitionException {
        SppjPathVarContext _localctx = new SppjPathVarContext(_ctx, getState());
        enterRule(_localctx, 404, RULE_sppjPathVar);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1279);
                sppjVariable();
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

    public static class SppjStepContext extends ParserRuleContext {
        public SppjObjStepContext sppjObjStep() {
            return getRuleContext(SppjObjStepContext.class, 0);
        }

        public SppjStepContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjStep;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjStep(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjStep(this);
        }
    }

    public final SppjStepContext sppjStep() throws RecognitionException {
        SppjStepContext _localctx = new SppjStepContext(_ctx, getState());
        enterRule(_localctx, 406, RULE_sppjStep);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1281);
                sppjObjStep();
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

    public static class SppjObjStepContext extends ParserRuleContext {
        public KeyContext key() {
            return getRuleContext(KeyContext.class, 0);
        }

        public SppjObjStepContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjObjStep;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjObjStep(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjObjStep(this);
        }
    }

    public final SppjObjStepContext sppjObjStep() throws RecognitionException {
        SppjObjStepContext _localctx = new SppjObjStepContext(_ctx, getState());
        enterRule(_localctx, 408, RULE_sppjObjStep);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1283);
                match(T__9);
                setState(1284);
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

    public static class SppjVariableContext extends ParserRuleContext {
        public TerminalNode NAME() {
            return getToken(QBTParser.NAME, 0);
        }

        public SppjVariableContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjVariable;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjVariable(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjVariable(this);
        }
    }

    public final SppjVariableContext sppjVariable() throws RecognitionException {
        SppjVariableContext _localctx = new SppjVariableContext(_ctx, getState());
        enterRule(_localctx, 410, RULE_sppjVariable);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1286);
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

    public static class SppjFieldNameContext extends ParserRuleContext {
        public TerminalNode STRING() {
            return getToken(QBTParser.STRING, 0);
        }

        public SppjFieldNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjFieldName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjFieldName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjFieldName(this);
        }
    }

    public final SppjFieldNameContext sppjFieldName() throws RecognitionException {
        SppjFieldNameContext _localctx = new SppjFieldNameContext(_ctx, getState());
        enterRule(_localctx, 412, RULE_sppjFieldName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1288);
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

    public static class SppjConstantContext extends ParserRuleContext {
        public TerminalNode INTEGER() {
            return getToken(QBTParser.INTEGER, 0);
        }

        public TerminalNode STRING() {
            return getToken(QBTParser.STRING, 0);
        }

        public SppjConstantContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_sppjConstant;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).enterSppjConstant(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof QBTListener)
                ((QBTListener) listener).exitSppjConstant(this);
        }
    }

    public final SppjConstantContext sppjConstant() throws RecognitionException {
        SppjConstantContext _localctx = new SppjConstantContext(_ctx, getState());
        enterRule(_localctx, 414, RULE_sppjConstant);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1290);
                _la = _input.LA(1);
                if (!(_la == STRING || _la == INTEGER)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF)
                        matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
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
            case 15:
                return qbtCondition_sempred((QbtConditionContext) _localctx, predIndex);
            case 86:
                return condition_sempred((ConditionContext) _localctx, predIndex);
            case 110:
                return prCondition_sempred((PrConditionContext) _localctx, predIndex);
            case 153:
                return pjCondition_sempred((PjConditionContext) _localctx, predIndex);
            case 192:
                return sppjCondition_sempred((SppjConditionContext) _localctx, predIndex);
        }
        return true;
    }

    private boolean qbtCondition_sempred(QbtConditionContext _localctx, int predIndex) {
        switch (predIndex) {
            case 0:
                return precpred(_ctx, 1);
        }
        return true;
    }

    private boolean condition_sempred(ConditionContext _localctx, int predIndex) {
        switch (predIndex) {
            case 1:
                return precpred(_ctx, 3);
        }
        return true;
    }

    private boolean prCondition_sempred(PrConditionContext _localctx, int predIndex) {
        switch (predIndex) {
            case 2:
                return precpred(_ctx, 2);
        }
        return true;
    }

    private boolean pjCondition_sempred(PjConditionContext _localctx, int predIndex) {
        switch (predIndex) {
            case 3:
                return precpred(_ctx, 2);
        }
        return true;
    }

    private boolean sppjCondition_sempred(SppjConditionContext _localctx, int predIndex) {
        switch (predIndex) {
            case 4:
                return precpred(_ctx, 2);
        }
        return true;
    }

    public static final String _serializedATN = "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3;\u050f\4\2\t\2\4"
            + "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"
            + "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"
            + "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"
            + "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"
            + "\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"
            + ",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"
            + "\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="
            + "\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"
            + "\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"
            + "\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"
            + "`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"
            + "k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv\4"
            + "w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\4\177\t\177\4\u0080\t\u0080"
            + "\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083\t\u0083\4\u0084\t\u0084\4\u0085"
            + "\t\u0085\4\u0086\t\u0086\4\u0087\t\u0087\4\u0088\t\u0088\4\u0089\t\u0089"
            + "\4\u008a\t\u008a\4\u008b\t\u008b\4\u008c\t\u008c\4\u008d\t\u008d\4\u008e"
            + "\t\u008e\4\u008f\t\u008f\4\u0090\t\u0090\4\u0091\t\u0091\4\u0092\t\u0092"
            + "\4\u0093\t\u0093\4\u0094\t\u0094\4\u0095\t\u0095\4\u0096\t\u0096\4\u0097"
            + "\t\u0097\4\u0098\t\u0098\4\u0099\t\u0099\4\u009a\t\u009a\4\u009b\t\u009b"
            + "\4\u009c\t\u009c\4\u009d\t\u009d\4\u009e\t\u009e\4\u009f\t\u009f\4\u00a0"
            + "\t\u00a0\4\u00a1\t\u00a1\4\u00a2\t\u00a2\4\u00a3\t\u00a3\4\u00a4\t\u00a4"
            + "\4\u00a5\t\u00a5\4\u00a6\t\u00a6\4\u00a7\t\u00a7\4\u00a8\t\u00a8\4\u00a9"
            + "\t\u00a9\4\u00aa\t\u00aa\4\u00ab\t\u00ab\4\u00ac\t\u00ac\4\u00ad\t\u00ad"
            + "\4\u00ae\t\u00ae\4\u00af\t\u00af\4\u00b0\t\u00b0\4\u00b1\t\u00b1\4\u00b2"
            + "\t\u00b2\4\u00b3\t\u00b3\4\u00b4\t\u00b4\4\u00b5\t\u00b5\4\u00b6\t\u00b6"
            + "\4\u00b7\t\u00b7\4\u00b8\t\u00b8\4\u00b9\t\u00b9\4\u00ba\t\u00ba\4\u00bb"
            + "\t\u00bb\4\u00bc\t\u00bc\4\u00bd\t\u00bd\4\u00be\t\u00be\4\u00bf\t\u00bf"
            + "\4\u00c0\t\u00c0\4\u00c1\t\u00c1\4\u00c2\t\u00c2\4\u00c3\t\u00c3\4\u00c4"
            + "\t\u00c4\4\u00c5\t\u00c5\4\u00c6\t\u00c6\4\u00c7\t\u00c7\4\u00c8\t\u00c8"
            + "\4\u00c9\t\u00c9\4\u00ca\t\u00ca\4\u00cb\t\u00cb\4\u00cc\t\u00cc\4\u00cd"
            + "\t\u00cd\4\u00ce\t\u00ce\4\u00cf\t\u00cf\4\u00d0\t\u00d0\4\u00d1\t\u00d1"
            + "\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\5\5\u01ae\n\5\3\5\3\5\3\6"
            + "\3\6\3\6\3\6\7\6\u01b6\n\6\f\6\16\6\u01b9\13\6\3\7\3\7\3\7\3\b\3\b\3\b"
            + "\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u01cd\n\n\3\13\3"
            + "\13\5\13\u01d1\n\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21"
            + "\3\21\3\21\3\21\3\21\3\21\5\21\u01e3\n\21\3\21\3\21\3\21\7\21\u01e8\n"
            + "\21\f\21\16\21\u01eb\13\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25"
            + "\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u01ff\n\26\3\27\3\27"
            + "\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36"
            + "\3\36\3\36\3\36\3\37\3\37\3 \3 \3 \3!\3!\3\"\3\"\3\"\3#\3#\5#\u0220\n"
            + "#\3$\3$\3%\3%\3%\3%\3%\3%\3%\7%\u022b\n%\f%\16%\u022e\13%\3%\3%\3&\3&"
            + "\3&\3&\3\'\3\'\3(\3(\3(\3(\3(\5(\u023d\n(\3)\3)\3)\3)\7)\u0243\n)\f)\16"
            + ")\u0246\13)\3*\3*\3*\3*\3+\3+\3,\3,\3-\3-\3-\3-\3-\3-\3-\3-\7-\u0258\n"
            + "-\f-\16-\u025b\13-\3-\3-\3-\3-\3-\3-\3-\3-\7-\u0265\n-\f-\16-\u0268\13"
            + "-\3-\3-\3-\3-\3-\5-\u026f\n-\3.\3.\3/\3/\3\60\3\60\5\60\u0277\n\60\3\61"
            + "\3\61\3\62\3\62\3\62\3\62\5\62\u027f\n\62\3\63\3\63\3\64\3\64\5\64\u0285"
            + "\n\64\3\65\3\65\3\65\3\65\5\65\u028b\n\65\3\66\3\66\3\66\3\66\3\66\3\66"
            + "\3\66\3\66\3\66\5\66\u0296\n\66\3\67\3\67\3\67\38\38\39\39\39\39\59\u02a1"
            + "\n9\3:\3:\3:\3:\7:\u02a7\n:\f:\16:\u02aa\13:\3:\3:\3;\3;\3;\3;\3<\3<\3"
            + "=\3=\3>\3>\3>\3>\5>\u02ba\n>\3?\3?\3?\3?\3?\5?\u02c1\n?\3@\3@\3A\3A\3"
            + "B\3B\3C\3C\3C\5C\u02cc\nC\3D\3D\3D\3D\3D\5D\u02d3\nD\3E\3E\3F\3F\3G\3"
            + "G\5G\u02db\nG\3H\3H\3I\3I\6I\u02e1\nI\rI\16I\u02e2\3J\3J\3K\3K\3L\3L\5"
            + "L\u02eb\nL\3M\3M\3M\3N\3N\3N\3N\3O\3O\3P\3P\3Q\3Q\3Q\3Q\7Q\u02fc\nQ\f"
            + "Q\16Q\u02ff\13Q\3R\3R\3R\3R\3S\3S\3T\3T\3U\3U\3U\5U\u030c\nU\3V\3V\3W"
            + "\3W\3W\3X\3X\3X\3X\3X\3X\3X\3X\3X\3X\3X\5X\u031e\nX\3X\3X\3X\7X\u0323"
            + "\nX\fX\16X\u0326\13X\3Y\3Y\3Y\7Y\u032b\nY\fY\16Y\u032e\13Y\3Z\3Z\3Z\3"
            + "Z\3[\3[\3\\\3\\\3]\3]\3]\3]\3^\3^\3_\3_\3`\3`\3a\3a\5a\u0344\na\3b\3b"
            + "\3b\3b\3b\3c\3c\3d\3d\3d\3e\3e\5e\u0352\ne\3f\3f\3f\3g\3g\3g\7g\u035a"
            + "\ng\fg\16g\u035d\13g\3h\3h\5h\u0361\nh\3i\3i\3i\3i\7i\u0367\ni\fi\16i"
            + "\u036a\13i\3j\3j\3j\3j\3k\3k\3l\3l\3m\3m\3n\3n\3o\3o\3o\3p\3p\3p\3p\3"
            + "p\3p\3p\5p\u0382\np\3p\3p\3p\7p\u0387\np\fp\16p\u038a\13p\3q\3q\3q\3q"
            + "\3q\3q\5q\u0392\nq\3r\3r\3r\3r\3s\3s\3s\3s\3t\3t\3u\3u\3v\3v\3w\3w\3w"
            + "\3w\3w\3x\3x\3x\3x\3x\5x\u03ac\nx\3x\3x\3x\3y\3y\3z\3z\3z\3z\3{\3{\3|"
            + "\3|\3}\3}\5}\u03bd\n}\3~\3~\3~\3~\7~\u03c3\n~\f~\16~\u03c6\13~\3\177\3"
            + "\177\3\177\3\177\3\177\7\177\u03cd\n\177\f\177\16\177\u03d0\13\177\3\177"
            + "\3\177\3\u0080\3\u0080\3\u0080\3\u0080\3\u0081\3\u0081\3\u0082\3\u0082"
            + "\3\u0083\3\u0083\3\u0084\3\u0084\3\u0085\3\u0085\3\u0086\3\u0086\3\u0087"
            + "\3\u0087\3\u0087\3\u0087\3\u0087\3\u0088\3\u0088\3\u0088\3\u0089\3\u0089"
            + "\3\u008a\3\u008a\3\u008a\3\u008a\7\u008a\u03f2\n\u008a\f\u008a\16\u008a"
            + "\u03f5\13\u008a\3\u008b\3\u008b\3\u008b\3\u008b\5\u008b\u03fb\n\u008b"
            + "\3\u008c\3\u008c\3\u008c\3\u008c\3\u008d\3\u008d\3\u008d\3\u008d\3\u008d"
            + "\7\u008d\u0406\n\u008d\f\u008d\16\u008d\u0409\13\u008d\3\u008d\3\u008d"
            + "\3\u008e\3\u008e\3\u008e\3\u008e\3\u008f\3\u008f\3\u0090\3\u0090\3\u0090"
            + "\3\u0090\5\u0090\u0417\n\u0090\3\u0091\3\u0091\3\u0092\3\u0092\3\u0093"
            + "\3\u0093\3\u0094\3\u0094\5\u0094\u0421\n\u0094\3\u0095\3\u0095\3\u0095"
            + "\3\u0095\7\u0095\u0427\n\u0095\f\u0095\16\u0095\u042a\13\u0095\3\u0096"
            + "\3\u0096\3\u0096\3\u0096\3\u0097\3\u0097\3\u0098\3\u0098\3\u0098\3\u0098"
            + "\3\u0098\3\u0098\3\u0098\5\u0098\u0439\n\u0098\3\u0099\3\u0099\3\u009a"
            + "\3\u009a\3\u009a\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\3\u009b\5\u009b"
            + "\u0446\n\u009b\3\u009b\3\u009b\3\u009b\7\u009b\u044b\n\u009b\f\u009b\16"
            + "\u009b\u044e\13\u009b\3\u009c\3\u009c\3\u009c\3\u009c\3\u009d\3\u009d"
            + "\3\u009e\3\u009e\3\u009f\3\u009f\3\u00a0\3\u00a0\3\u00a0\5\u00a0\u045d"
            + "\n\u00a0\3\u00a1\3\u00a1\3\u00a2\3\u00a2\3\u00a3\3\u00a3\3\u00a4\3\u00a4"
            + "\6\u00a4\u0467\n\u00a4\r\u00a4\16\u00a4\u0468\3\u00a5\3\u00a5\5\u00a5"
            + "\u046d\n\u00a5\3\u00a6\3\u00a6\3\u00a7\3\u00a7\3\u00a7\3\u00a8\3\u00a8"
            + "\3\u00a8\3\u00a8\3\u00a9\3\u00a9\3\u00aa\3\u00aa\3\u00ab\3\u00ab\3\u00ac"
            + "\3\u00ac\3\u00ad\3\u00ad\3\u00ae\3\u00ae\3\u00ae\3\u00ae\3\u00ae\3\u00ae"
            + "\3\u00ae\3\u00ae\3\u00ae\3\u00ae\3\u00ae\5\u00ae\u048d\n\u00ae\3\u00af"
            + "\3\u00af\3\u00af\3\u00b0\3\u00b0\3\u00b1\3\u00b1\3\u00b2\3\u00b2\3\u00b2"
            + "\3\u00b3\3\u00b3\3\u00b3\5\u00b3\u049c\n\u00b3\3\u00b4\3\u00b4\3\u00b4"
            + "\3\u00b4\7\u00b4\u04a2\n\u00b4\f\u00b4\16\u00b4\u04a5\13\u00b4\3\u00b4"
            + "\3\u00b4\3\u00b5\3\u00b5\3\u00b5\3\u00b5\3\u00b6\3\u00b6\3\u00b7\3\u00b7"
            + "\3\u00b7\3\u00b7\5\u00b7\u04b3\n\u00b7\3\u00b8\3\u00b8\3\u00b9\3\u00b9"
            + "\3\u00ba\3\u00ba\3\u00bb\3\u00bb\5\u00bb\u04bd\n\u00bb\3\u00bc\3\u00bc"
            + "\3\u00bc\3\u00bc\7\u00bc\u04c3\n\u00bc\f\u00bc\16\u00bc\u04c6\13\u00bc"
            + "\3\u00bd\3\u00bd\3\u00bd\3\u00bd\3\u00be\3\u00be\3\u00bf\3\u00bf\5\u00bf"
            + "\u04d0\n\u00bf\3\u00c0\3\u00c0\3\u00c1\3\u00c1\3\u00c1\3\u00c2\3\u00c2"
            + "\3\u00c2\3\u00c2\3\u00c2\3\u00c2\5\u00c2\u04dd\n\u00c2\3\u00c2\3\u00c2"
            + "\3\u00c2\7\u00c2\u04e2\n\u00c2\f\u00c2\16\u00c2\u04e5\13\u00c2\3\u00c3"
            + "\3\u00c3\3\u00c3\3\u00c3\3\u00c4\3\u00c4\3\u00c5\3\u00c5\3\u00c6\3\u00c6"
            + "\3\u00c7\3\u00c7\3\u00c7\5\u00c7\u04f4\n\u00c7\3\u00c8\3\u00c8\3\u00c9"
            + "\3\u00c9\3\u00ca\3\u00ca\3\u00cb\3\u00cb\6\u00cb\u04fe\n\u00cb\r\u00cb"
            + "\16\u00cb\u04ff\3\u00cc\3\u00cc\3\u00cd\3\u00cd\3\u00ce\3\u00ce\3\u00ce"
            + "\3\u00cf\3\u00cf\3\u00d0\3\u00d0\3\u00d1\3\u00d1\3\u00d1\4\u0468\u04ff"
            + "\7 \u00ae\u00de\u0134\u0182\u00d2\2\4\6\b\n\f\16\20\22\24\26\30\32\34"
            + "\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082"
            + "\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a"
            + "\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2"
            + "\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca"
            + "\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc\u00de\u00e0\u00e2"
            + "\u00e4\u00e6\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2\u00f4\u00f6\u00f8\u00fa"
            + "\u00fc\u00fe\u0100\u0102\u0104\u0106\u0108\u010a\u010c\u010e\u0110\u0112"
            + "\u0114\u0116\u0118\u011a\u011c\u011e\u0120\u0122\u0124\u0126\u0128\u012a"
            + "\u012c\u012e\u0130\u0132\u0134\u0136\u0138\u013a\u013c\u013e\u0140\u0142"
            + "\u0144\u0146\u0148\u014a\u014c\u014e\u0150\u0152\u0154\u0156\u0158\u015a"
            + "\u015c\u015e\u0160\u0162\u0164\u0166\u0168\u016a\u016c\u016e\u0170\u0172"
            + "\u0174\u0176\u0178\u017a\u017c\u017e\u0180\u0182\u0184\u0186\u0188\u018a"
            + "\u018c\u018e\u0190\u0192\u0194\u0196\u0198\u019a\u019c\u019e\u01a0\2\5"
            + "\4\2\37$&&\3\2\62\63\3\2\61\62\2\u049d\2\u01a2\3\2\2\2\4\u01a7\3\2\2\2"
            + "\6\u01a9\3\2\2\2\b\u01ab\3\2\2\2\n\u01b1\3\2\2\2\f\u01ba\3\2\2\2\16\u01bd"
            + "\3\2\2\2\20\u01c0\3\2\2\2\22\u01cc\3\2\2\2\24\u01ce\3\2\2\2\26\u01d2\3"
            + "\2\2\2\30\u01d4\3\2\2\2\32\u01d6\3\2\2\2\34\u01d8\3\2\2\2\36\u01da\3\2"
            + "\2\2 \u01e2\3\2\2\2\"\u01ec\3\2\2\2$\u01ee\3\2\2\2&\u01f0\3\2\2\2(\u01f2"
            + "\3\2\2\2*\u01fe\3\2\2\2,\u0200\3\2\2\2.\u0202\3\2\2\2\60\u0204\3\2\2\2"
            + "\62\u0206\3\2\2\2\64\u0208\3\2\2\2\66\u020a\3\2\2\28\u020c\3\2\2\2:\u020e"
            + "\3\2\2\2<\u0213\3\2\2\2>\u0215\3\2\2\2@\u0218\3\2\2\2B\u021a\3\2\2\2D"
            + "\u021f\3\2\2\2F\u0221\3\2\2\2H\u0223\3\2\2\2J\u0231\3\2\2\2L\u0235\3\2"
            + "\2\2N\u023c\3\2\2\2P\u023e\3\2\2\2R\u0247\3\2\2\2T\u024b\3\2\2\2V\u024d"
            + "\3\2\2\2X\u026e\3\2\2\2Z\u0270\3\2\2\2\\\u0272\3\2\2\2^\u0276\3\2\2\2"
            + "`\u0278\3\2\2\2b\u027e\3\2\2\2d\u0280\3\2\2\2f\u0284\3\2\2\2h\u028a\3"
            + "\2\2\2j\u028c\3\2\2\2l\u0297\3\2\2\2n\u029a\3\2\2\2p\u029c\3\2\2\2r\u02a2"
            + "\3\2\2\2t\u02ad\3\2\2\2v\u02b1\3\2\2\2x\u02b3\3\2\2\2z\u02b9\3\2\2\2|"
            + "\u02c0\3\2\2\2~\u02c2\3\2\2\2\u0080\u02c4\3\2\2\2\u0082\u02c6\3\2\2\2"
            + "\u0084\u02cb\3\2\2\2\u0086\u02d2\3\2\2\2\u0088\u02d4\3\2\2\2\u008a\u02d6"
            + "\3\2\2\2\u008c\u02da\3\2\2\2\u008e\u02dc\3\2\2\2\u0090\u02de\3\2\2\2\u0092"
            + "\u02e4\3\2\2\2\u0094\u02e6\3\2\2\2\u0096\u02ea\3\2\2\2\u0098\u02ec\3\2"
            + "\2\2\u009a\u02ef\3\2\2\2\u009c\u02f3\3\2\2\2\u009e\u02f5\3\2\2\2\u00a0"
            + "\u02f7\3\2\2\2\u00a2\u0300\3\2\2\2\u00a4\u0304\3\2\2\2\u00a6\u0306\3\2"
            + "\2\2\u00a8\u030b\3\2\2\2\u00aa\u030d\3\2\2\2\u00ac\u030f\3\2\2\2\u00ae"
            + "\u031d\3\2\2\2\u00b0\u0327\3\2\2\2\u00b2\u032f\3\2\2\2\u00b4\u0333\3\2"
            + "\2\2\u00b6\u0335\3\2\2\2\u00b8\u0337\3\2\2\2\u00ba\u033b\3\2\2\2\u00bc"
            + "\u033d\3\2\2\2\u00be\u033f\3\2\2\2\u00c0\u0341\3\2\2\2\u00c2\u0345\3\2"
            + "\2\2\u00c4\u034a\3\2\2\2\u00c6\u034c\3\2\2\2\u00c8\u034f\3\2\2\2\u00ca"
            + "\u0353\3\2\2\2\u00cc\u0356\3\2\2\2\u00ce\u0360\3\2\2\2\u00d0\u0362\3\2"
            + "\2\2\u00d2\u036b\3\2\2\2\u00d4\u036f\3\2\2\2\u00d6\u0371\3\2\2\2\u00d8"
            + "\u0373\3\2\2\2\u00da\u0375\3\2\2\2\u00dc\u0377\3\2\2\2\u00de\u0381\3\2"
            + "\2\2\u00e0\u0391\3\2\2\2\u00e2\u0393\3\2\2\2\u00e4\u0397\3\2\2\2\u00e6"
            + "\u039b\3\2\2\2\u00e8\u039d\3\2\2\2\u00ea\u039f\3\2\2\2\u00ec\u03a1\3\2"
            + "\2\2\u00ee\u03a6\3\2\2\2\u00f0\u03b0\3\2\2\2\u00f2\u03b2\3\2\2\2\u00f4"
            + "\u03b6\3\2\2\2\u00f6\u03b8\3\2\2\2\u00f8\u03bc\3\2\2\2\u00fa\u03be\3\2"
            + "\2\2\u00fc\u03c7\3\2\2\2\u00fe\u03d3\3\2\2\2\u0100\u03d7\3\2\2\2\u0102"
            + "\u03d9\3\2\2\2\u0104\u03db\3\2\2\2\u0106\u03dd\3\2\2\2\u0108\u03df\3\2"
            + "\2\2\u010a\u03e1\3\2\2\2\u010c\u03e3\3\2\2\2\u010e\u03e8\3\2\2\2\u0110"
            + "\u03eb\3\2\2\2\u0112\u03ed\3\2\2\2\u0114\u03fa\3\2\2\2\u0116\u03fc\3\2"
            + "\2\2\u0118\u0400\3\2\2\2\u011a\u040c\3\2\2\2\u011c\u0410\3\2\2\2\u011e"
            + "\u0416\3\2\2\2\u0120\u0418\3\2\2\2\u0122\u041a\3\2\2\2\u0124\u041c\3\2"
            + "\2\2\u0126\u041e\3\2\2\2\u0128\u0422\3\2\2\2\u012a\u042b\3\2\2\2\u012c"
            + "\u042f\3\2\2\2\u012e\u0438\3\2\2\2\u0130\u043a\3\2\2\2\u0132\u043c\3\2"
            + "\2\2\u0134\u0445\3\2\2\2\u0136\u044f\3\2\2\2\u0138\u0453\3\2\2\2\u013a"
            + "\u0455\3\2\2\2\u013c\u0457\3\2\2\2\u013e\u045c\3\2\2\2\u0140\u045e\3\2"
            + "\2\2\u0142\u0460\3\2\2\2\u0144\u0462\3\2\2\2\u0146\u0464\3\2\2\2\u0148"
            + "\u046c\3\2\2\2\u014a\u046e\3\2\2\2\u014c\u0470\3\2\2\2\u014e\u0473\3\2"
            + "\2\2\u0150\u0477\3\2\2\2\u0152\u0479\3\2\2\2\u0154\u047b\3\2\2\2\u0156"
            + "\u047d\3\2\2\2\u0158\u047f\3\2\2\2\u015a\u048c\3\2\2\2\u015c\u048e\3\2"
            + "\2\2\u015e\u0491\3\2\2\2\u0160\u0493\3\2\2\2\u0162\u0495\3\2\2\2\u0164"
            + "\u049b\3\2\2\2\u0166\u049d\3\2\2\2\u0168\u04a8\3\2\2\2\u016a\u04ac\3\2"
            + "\2\2\u016c\u04b2\3\2\2\2\u016e\u04b4\3\2\2\2\u0170\u04b6\3\2\2\2\u0172"
            + "\u04b8\3\2\2\2\u0174\u04ba\3\2\2\2\u0176\u04be\3\2\2\2\u0178\u04c7\3\2"
            + "\2\2\u017a\u04cb\3\2\2\2\u017c\u04cf\3\2\2\2\u017e\u04d1\3\2\2\2\u0180"
            + "\u04d3\3\2\2\2\u0182\u04dc\3\2\2\2\u0184\u04e6\3\2\2\2\u0186\u04ea\3\2"
            + "\2\2\u0188\u04ec\3\2\2\2\u018a\u04ee\3\2\2\2\u018c\u04f3\3\2\2\2\u018e"
            + "\u04f5\3\2\2\2\u0190\u04f7\3\2\2\2\u0192\u04f9\3\2\2\2\u0194\u04fb\3\2"
            + "\2\2\u0196\u0501\3\2\2\2\u0198\u0503\3\2\2\2\u019a\u0505\3\2\2\2\u019c"
            + "\u0508\3\2\2\2\u019e\u050a\3\2\2\2\u01a0\u050c\3\2\2\2\u01a2\u01a3\5\4"
            + "\3\2\u01a3\u01a4\7\3\2\2\u01a4\u01a5\5\6\4\2\u01a5\u01a6\7\2\2\3\u01a6"
            + "\3\3\2\2\2\u01a7\u01a8\7\61\2\2\u01a8\5\3\2\2\2\u01a9\u01aa\5\b\5\2\u01aa"
            + "\7\3\2\2\2\u01ab\u01ad\5\n\6\2\u01ac\u01ae\5\f\7\2\u01ad\u01ac\3\2\2\2"
            + "\u01ad\u01ae\3\2\2\2\u01ae\u01af\3\2\2\2\u01af\u01b0\5\16\b\2\u01b0\t"
            + "\3\2\2\2\u01b1\u01b2\7\34\2\2\u01b2\u01b7\5\20\t\2\u01b3\u01b4\7\4\2\2"
            + "\u01b4\u01b6\5\20\t\2\u01b5\u01b3\3\2\2\2\u01b6\u01b9\3\2\2\2\u01b7\u01b5"
            + "\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8\13\3\2\2\2\u01b9\u01b7\3\2\2\2\u01ba"
            + "\u01bb\7\35\2\2\u01bb\u01bc\5 \21\2\u01bc\r\3\2\2\2\u01bd\u01be\7\36\2"
            + "\2\u01be\u01bf\5(\25\2\u01bf\17\3\2\2\2\u01c0\u01c1\58\35\2\u01c1\u01c2"
            + "\7\5\2\2\u01c2\u01c3\7\6\2\2\u01c3\u01c4\5\22\n\2\u01c4\u01c5\7\7\2\2"
            + "\u01c5\21\3\2\2\2\u01c6\u01cd\5\24\13\2\u01c7\u01cd\5\26\f\2\u01c8\u01cd"
            + "\5\30\r\2\u01c9\u01cd\5\32\16\2\u01ca\u01cd\5\34\17\2\u01cb\u01cd\5\36"
            + "\20\2\u01cc\u01c6\3\2\2\2\u01cc\u01c7\3\2\2\2\u01cc\u01c8\3\2\2\2\u01cc"
            + "\u01c9\3\2\2\2\u01cc\u01ca\3\2\2\2\u01cc\u01cb\3\2\2\2\u01cd\23\3\2\2"
            + "\2\u01ce\u01d0\5\u00a0Q\2\u01cf\u01d1\5\u00acW\2\u01d0\u01cf\3\2\2\2\u01d0"
            + "\u01d1\3\2\2\2\u01d1\25\3\2\2\2\u01d2\u01d3\5P)\2\u01d3\27\3\2\2\2\u01d4"
            + "\u01d5\5\u00c4c\2\u01d5\31\3\2\2\2\u01d6\u01d7\5\u0174\u00bb\2\u01d7\33"
            + "\3\2\2\2\u01d8\u01d9\5\u010e\u0088\2\u01d9\35\3\2\2\2\u01da\u01db\5\u00ee"
            + "x\2\u01db\37\3\2\2\2\u01dc\u01dd\b\21\1\2\u01dd\u01e3\5\"\22\2\u01de\u01df"
            + "\7\b\2\2\u01df\u01e0\5 \21\2\u01e0\u01e1\7\t\2\2\u01e1\u01e3\3\2\2\2\u01e2"
            + "\u01dc\3\2\2\2\u01e2\u01de\3\2\2\2\u01e3\u01e9\3\2\2\2\u01e4\u01e5\f\3"
            + "\2\2\u01e5\u01e6\7\'\2\2\u01e6\u01e8\5 \21\4\u01e7\u01e4\3\2\2\2\u01e8"
            + "\u01eb\3\2\2\2\u01e9\u01e7\3\2\2\2\u01e9\u01ea\3\2\2\2\u01ea!\3\2\2\2"
            + "\u01eb\u01e9\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed#\3\2\2\2\u01ee\u01ef\7"
            + "\61\2\2\u01ef%\3\2\2\2\u01f0\u01f1\3\2\2\2\u01f1\'\3\2\2\2\u01f2\u01f3"
            + "\58\35\2\u01f3\u01f4\7\5\2\2\u01f4\u01f5\7\6\2\2\u01f5\u01f6\5*\26\2\u01f6"
            + "\u01f7\7\7\2\2\u01f7)\3\2\2\2\u01f8\u01ff\5,\27\2\u01f9\u01ff\5.\30\2"
            + "\u01fa\u01ff\5\60\31\2\u01fb\u01ff\5\62\32\2\u01fc\u01ff\5\64\33\2\u01fd"
            + "\u01ff\5\66\34\2\u01fe\u01f8\3\2\2\2\u01fe\u01f9\3\2\2\2\u01fe\u01fa\3"
            + "\2\2\2\u01fe\u01fb\3\2\2\2\u01fe\u01fc\3\2\2\2\u01fe\u01fd\3\2\2\2\u01ff"
            + "+\3\2\2\2\u0200\u0201\5r:\2\u0201-\3\2\2\2\u0202\u0203\5H%\2\u0203/\3"
            + "\2\2\2\u0204\u0205\5\u0166\u00b4\2\u0205\61\3\2\2\2\u0206\u0207\5\u0118"
            + "\u008d\2\u0207\63\3\2\2\2\u0208\u0209\5\u00fc\177\2\u0209\65\3\2\2\2\u020a"
            + "\u020b\5\u00ccg\2\u020b\67\3\2\2\2\u020c\u020d\t\2\2\2\u020d9\3\2\2\2"
            + "\u020e\u020f\5\4\3\2\u020f\u0210\7\3\2\2\u0210\u0211\5<\37\2\u0211\u0212"
            + "\7\2\2\3\u0212;\3\2\2\2\u0213\u0214\5> \2\u0214=\3\2\2\2\u0215\u0216\5"
            + "@!\2\u0216\u0217\5P)\2\u0217?\3\2\2\2\u0218\u0219\5B\"\2\u0219A\3\2\2"
            + "\2\u021a\u021b\7*\2\2\u021b\u021c\5D#\2\u021cC\3\2\2\2\u021d\u0220\5F"
            + "$\2\u021e\u0220\5H%\2\u021f\u021d\3\2\2\2\u021f\u021e\3\2\2\2\u0220E\3"
            + "\2\2\2\u0221\u0222\5h\65\2\u0222G\3\2\2\2\u0223\u0224\5N(\2\u0224\u0225"
            + "\7\n\2\2\u0225\u0226\7\13\2\2\u0226\u0227\7\6\2\2\u0227\u022c\5J&\2\u0228"
            + "\u0229\7\4\2\2\u0229\u022b\5J&\2\u022a\u0228\3\2\2\2\u022b\u022e\3\2\2"
            + "\2\u022c\u022a\3\2\2\2\u022c\u022d\3\2\2\2\u022d\u022f\3\2\2\2\u022e\u022c"
            + "\3\2\2\2\u022f\u0230\7\7\2\2\u0230I\3\2\2\2\u0231\u0232\5`\61\2\u0232"
            + "\u0233\7\5\2\2\u0233\u0234\5L\'\2\u0234K\3\2\2\2\u0235\u0236\5F$\2\u0236"
            + "M\3\2\2\2\u0237\u023d\7\61\2\2\u0238\u0239\7\61\2\2\u0239\u023a\7\f\2"
            + "\2\u023a\u023d\7\61\2\2\u023b\u023d\7\62\2\2\u023c\u0237\3\2\2\2\u023c"
            + "\u0238\3\2\2\2\u023c\u023b\3\2\2\2\u023dO\3\2\2\2\u023e\u023f\7(\2\2\u023f"
            + "\u0244\5R*\2\u0240\u0241\7\4\2\2\u0241\u0243\5R*\2\u0242\u0240\3\2\2\2"
            + "\u0243\u0246\3\2\2\2\u0244\u0242\3\2\2\2\u0244\u0245\3\2\2\2\u0245Q\3"
            + "\2\2\2\u0246\u0244\3\2\2\2\u0247\u0248\5T+\2\u0248\u0249\7)\2\2\u0249"
            + "\u024a\5V,\2\u024aS\3\2\2\2\u024b\u024c\5h\65\2\u024cU\3\2\2\2\u024d\u024e"
            + "\5X-\2\u024eW\3\2\2\2\u024f\u0250\5Z.\2\u0250\u0251\7\r\2\2\u0251\u0252"
            + "\5^\60\2\u0252\u0259\7\16\2\2\u0253\u0254\7\r\2\2\u0254\u0255\5^\60\2"
            + "\u0255\u0256\7\16\2\2\u0256\u0258\3\2\2\2\u0257\u0253\3\2\2\2\u0258\u025b"
            + "\3\2\2\2\u0259\u0257\3\2\2\2\u0259\u025a\3\2\2\2\u025a\u026f\3\2\2\2\u025b"
            + "\u0259\3\2\2\2\u025c\u025d\5\\/\2\u025d\u025e\7\r\2\2\u025e\u025f\5^\60"
            + "\2\u025f\u0266\7\16\2\2\u0260\u0261\7\r\2\2\u0261\u0262\5^\60\2\u0262"
            + "\u0263\7\16\2\2\u0263\u0265\3\2\2\2\u0264\u0260\3\2\2\2\u0265\u0268\3"
            + "\2\2\2\u0266\u0264\3\2\2\2\u0266\u0267\3\2\2\2\u0267\u026f\3\2\2\2\u0268"
            + "\u0266\3\2\2\2\u0269\u026a\7\66\2\2\u026a\u026b\7\r\2\2\u026b\u026c\5"
            + "d\63\2\u026c\u026d\7\16\2\2\u026d\u026f\3\2\2\2\u026e\u024f\3\2\2\2\u026e"
            + "\u025c\3\2\2\2\u026e\u0269\3\2\2\2\u026fY\3\2\2\2\u0270\u0271\79\2\2\u0271"
            + "[\3\2\2\2\u0272\u0273\7\61\2\2\u0273]\3\2\2\2\u0274\u0277\5`\61\2\u0275"
            + "\u0277\5b\62\2\u0276\u0274\3\2\2\2\u0276\u0275\3\2\2\2\u0277_\3\2\2\2"
            + "\u0278\u0279\7\62\2\2\u0279a\3\2\2\2\u027a\u027f\7\61\2\2\u027b\u027c"
            + "\7\61\2\2\u027c\u027d\7\f\2\2\u027d\u027f\7\61\2\2\u027e\u027a\3\2\2\2"
            + "\u027e\u027b\3\2\2\2\u027fc\3\2\2\2\u0280\u0281\7\61\2\2\u0281e\3\2\2"
            + "\2\u0282\u0285\5Z.\2\u0283\u0285\5h\65\2\u0284\u0282\3\2\2\2\u0284\u0283"
            + "\3\2\2\2\u0285g\3\2\2\2\u0286\u028b\7\61\2\2\u0287\u0288\7\61\2\2\u0288"
            + "\u0289\7\f\2\2\u0289\u028b\7\61\2\2\u028a\u0286\3\2\2\2\u028a\u0287\3"
            + "\2\2\2\u028bi\3\2\2\2\u028c\u028d\5\4\3\2\u028d\u0295\7\3\2\2\u028e\u0296"
            + "\5l\67\2\u028f\u0290\7\6\2\2\u0290\u0291\5n8\2\u0291\u0292\7\5\2\2\u0292"
            + "\u0293\5l\67\2\u0293\u0294\7\7\2\2\u0294\u0296\3\2\2\2\u0295\u028e\3\2"
            + "\2\2\u0295\u028f\3\2\2\2\u0296k\3\2\2\2\u0297\u0298\5\u00c0a\2\u0298\u0299"
            + "\5p9\2\u0299m\3\2\2\2\u029a\u029b\5x=\2\u029bo\3\2\2\2\u029c\u02a0\7\17"
            + "\2\2\u029d\u02a1\5r:\2\u029e\u02a1\5|?\2\u029f\u02a1\5\u0080A\2\u02a0"
            + "\u029d\3\2\2\2\u02a0\u029e\3\2\2\2\u02a0\u029f\3\2\2\2\u02a1q\3\2\2\2"
            + "\u02a2\u02a3\7\6\2\2\u02a3\u02a8\5t;\2\u02a4\u02a5\7\4\2\2\u02a5\u02a7"
            + "\5t;\2\u02a6\u02a4\3\2\2\2\u02a7\u02aa\3\2\2\2\u02a8\u02a6\3\2\2\2\u02a8"
            + "\u02a9\3\2\2\2\u02a9\u02ab\3\2\2\2\u02aa\u02a8\3\2\2\2\u02ab\u02ac\7\7"
            + "\2\2\u02acs\3\2\2\2\u02ad\u02ae\5v<\2\u02ae\u02af\7\5\2\2\u02af\u02b0"
            + "\5z>\2\u02b0u\3\2\2\2\u02b1\u02b2\5x=\2\u02b2w\3\2\2\2\u02b3\u02b4\7\62"
            + "\2\2\u02b4y\3\2\2\2\u02b5\u02ba\5r:\2\u02b6\u02ba\5|?\2\u02b7\u02ba\5"
            + "\u0080A\2\u02b8\u02ba\5\u0082B\2\u02b9\u02b5\3\2\2\2\u02b9\u02b6\3\2\2"
            + "\2\u02b9\u02b7\3\2\2\2\u02b9\u02b8\3\2\2\2\u02ba{\3\2\2\2\u02bb\u02c1"
            + "\5\u0094K\2\u02bc\u02bd\5~@\2\u02bd\u02be\7\f\2\2\u02be\u02bf\7\61\2\2"
            + "\u02bf\u02c1\3\2\2\2\u02c0\u02bb\3\2\2\2\u02c0\u02bc\3\2\2\2\u02c1}\3"
            + "\2\2\2\u02c2\u02c3\7\61\2\2\u02c3\177\3\2\2\2\u02c4\u02c5\5\u008cG\2\u02c5"
            + "\u0081\3\2\2\2\u02c6\u02c7\5l\67\2\u02c7\u0083\3\2\2\2\u02c8\u02cc\5\u0088"
            + "E\2\u02c9\u02cc\5\u0086D\2\u02ca\u02cc\5\u008aF\2\u02cb\u02c8\3\2\2\2"
            + "\u02cb\u02c9\3\2\2\2\u02cb\u02ca\3\2\2\2\u02cc\u0085\3\2\2\2\u02cd\u02d3"
            + "\5\u0094K\2\u02ce\u02cf\5~@\2\u02cf\u02d0\7\f\2\2\u02d0\u02d1\7\61\2\2"
            + "\u02d1\u02d3\3\2\2\2\u02d2\u02cd\3\2\2\2\u02d2\u02ce\3\2\2\2\u02d3\u0087"
            + "\3\2\2\2\u02d4\u02d5\5\u008cG\2\u02d5\u0089\3\2\2\2\u02d6\u02d7\5\u0090"
            + "I\2\u02d7\u008b\3\2\2\2\u02d8\u02db\5\u008eH\2\u02d9\u02db\7\62\2\2\u02da"
            + "\u02d8\3\2\2\2\u02da\u02d9\3\2\2\2\u02db\u008d\3\2\2\2\u02dc\u02dd\7:"
            + "\2\2\u02dd\u008f\3\2\2\2\u02de\u02e0\5\u0092J\2\u02df\u02e1\5\u0096L\2"
            + "\u02e0\u02df\3\2\2\2\u02e1\u02e2\3\2\2\2\u02e2\u02e0\3\2\2\2\u02e2\u02e3"
            + "\3\2\2\2\u02e3\u0091\3\2\2\2\u02e4\u02e5\5\u0094K\2\u02e5\u0093\3\2\2"
            + "\2\u02e6\u02e7\7\61\2\2\u02e7\u0095\3\2\2\2\u02e8\u02eb\5\u0098M\2\u02e9"
            + "\u02eb\5\u009aN\2\u02ea\u02e8\3\2\2\2\u02ea\u02e9\3\2\2\2\u02eb\u0097"
            + "\3\2\2\2\u02ec\u02ed\7\f\2\2\u02ed\u02ee\5\u009cO\2\u02ee\u0099\3\2\2"
            + "\2\u02ef\u02f0\7\r\2\2\u02f0\u02f1\5\u009eP\2\u02f1\u02f2\7\16\2\2\u02f2"
            + "\u009b\3\2\2\2\u02f3\u02f4\7\61\2\2\u02f4\u009d\3\2\2\2\u02f5\u02f6\5"
            + "\u008eH\2\u02f6\u009f\3\2\2\2\u02f7\u02f8\7\20\2\2\u02f8\u02fd\5\u00a2"
            + "R\2\u02f9\u02fa\7\4\2\2\u02fa\u02fc\5\u00a2R\2\u02fb\u02f9\3\2\2\2\u02fc"
            + "\u02ff\3\2\2\2\u02fd\u02fb\3\2\2\2\u02fd\u02fe\3\2\2\2\u02fe\u00a1\3\2"
            + "\2\2\u02ff\u02fd\3\2\2\2\u0300\u0301\5\u00a4S\2\u0301\u0302\7\21\2\2\u0302"
            + "\u0303\5\u00a6T\2\u0303\u00a3\3\2\2\2\u0304\u0305\5\u0094K\2\u0305\u00a5"
            + "\3\2\2\2\u0306\u0307\5\u00a8U\2\u0307\u00a7\3\2\2\2\u0308\u0309\7\22\2"
            + "\2\u0309\u030c\5\u00aaV\2\u030a\u030c\5\u0090I\2\u030b\u0308\3\2\2\2\u030b"
            + "\u030a\3\2\2\2\u030c\u00a9\3\2\2\2\u030d\u030e\7\61\2\2\u030e\u00ab\3"
            + "\2\2\2\u030f\u0310\7\23\2\2\u0310\u0311\5\u00aeX\2\u0311\u00ad\3\2\2\2"
            + "\u0312\u0313\bX\1\2\u0313\u031e\5\u00b8]\2\u0314\u0315\7\25\2\2\u0315"
            + "\u0316\5\u00b0Y\2\u0316\u0317\7\26\2\2\u0317\u0318\5\u00aeX\4\u0318\u031e"
            + "\3\2\2\2\u0319\u031a\7\b\2\2\u031a\u031b\5\u00aeX\2\u031b\u031c\7\t\2"
            + "\2\u031c\u031e\3\2\2\2\u031d\u0312\3\2\2\2\u031d\u0314\3\2\2\2\u031d\u0319"
            + "\3\2\2\2\u031e\u0324\3\2\2\2\u031f\u0320\f\5\2\2\u0320\u0321\7\24\2\2"
            + "\u0321\u0323\5\u00aeX\6\u0322\u031f\3\2\2\2\u0323\u0326\3\2\2\2\u0324"
            + "\u0322\3\2\2\2\u0324\u0325\3\2\2\2\u0325\u00af\3\2\2\2\u0326\u0324\3\2"
            + "\2\2\u0327\u032c\5\u00b2Z\2\u0328\u0329\7\4\2\2\u0329\u032b\5\u00b2Z\2"
            + "\u032a\u0328\3\2\2\2\u032b\u032e\3\2\2\2\u032c\u032a\3\2\2\2\u032c\u032d"
            + "\3\2\2\2\u032d\u00b1\3\2\2\2\u032e\u032c\3\2\2\2\u032f\u0330\5\u00b4["
            + "\2\u0330\u0331\7\21\2\2\u0331\u0332\5\u00b6\\\2\u0332\u00b3\3\2\2\2\u0333"
            + "\u0334\5\u0094K\2\u0334\u00b5\3\2\2\2\u0335\u0336\5\u00a8U\2\u0336\u00b7"
            + "\3\2\2\2\u0337\u0338\5\u00ba^\2\u0338\u0339\7\3\2\2\u0339\u033a\5\u00bc"
            + "_\2\u033a\u00b9\3\2\2\2\u033b\u033c\5\u00be`\2\u033c\u00bb\3\2\2\2\u033d"
            + "\u033e\5\u00be`\2\u033e\u00bd\3\2\2\2\u033f\u0340\5\u0084C\2\u0340\u00bf"
            + "\3\2\2\2\u0341\u0343\5\u00a0Q\2\u0342\u0344\5\u00acW\2\u0343\u0342\3\2"
            + "\2\2\u0343\u0344\3\2\2\2\u0344\u00c1\3\2\2\2\u0345\u0346\5\4\3\2\u0346"
            + "\u0347\7\3\2\2\u0347\u0348\5\u00c4c\2\u0348\u0349\7\2\2\3\u0349\u00c3"
            + "\3\2\2\2\u034a\u034b\5\u00c6d\2\u034b\u00c5\3\2\2\2\u034c\u034d\5\u00ca"
            + "f\2\u034d\u034e\5\u00c8e\2\u034e\u00c7\3\2\2\2\u034f\u0351\5\u00d0i\2"
            + "\u0350\u0352\5\u00dan\2\u0351\u0350\3\2\2\2\u0351\u0352\3\2\2\2\u0352"
            + "\u00c9\3\2\2\2\u0353\u0354\7*\2\2\u0354\u0355\5\u00ccg\2\u0355\u00cb\3"
            + "\2\2\2\u0356\u035b\5\u00ceh\2\u0357\u0358\7\4\2\2\u0358\u035a\5\u00ce"
            + "h\2\u0359\u0357\3\2\2\2\u035a\u035d\3\2\2\2\u035b\u0359\3\2\2\2\u035b"
            + "\u035c\3\2\2\2\u035c\u00cd\3\2\2\2\u035d\u035b\3\2\2\2\u035e\u0361\5\u00e0"
            + "q\2\u035f\u0361\7\61\2\2\u0360\u035e\3\2\2\2\u0360\u035f\3\2\2\2\u0361"
            + "\u00cf\3\2\2\2\u0362\u0363\7(\2\2\u0363\u0368\5\u00d2j\2\u0364\u0365\7"
            + "\4\2\2\u0365\u0367\5\u00d2j\2\u0366\u0364\3\2\2\2\u0367\u036a\3\2\2\2"
            + "\u0368\u0366\3\2\2\2\u0368\u0369\3\2\2\2\u0369\u00d1\3\2\2\2\u036a\u0368"
            + "\3\2\2\2\u036b\u036c\5\u00d4k\2\u036c\u036d\7+\2\2\u036d\u036e\5\u00d8"
            + "m\2\u036e\u00d3\3\2\2\2\u036f\u0370\5\u00d6l\2\u0370\u00d5\3\2\2\2\u0371"
            + "\u0372\7\61\2\2\u0372\u00d7\3\2\2\2\u0373\u0374\7\61\2\2\u0374\u00d9\3"
            + "\2\2\2\u0375\u0376\5\u00dco\2\u0376\u00db\3\2\2\2\u0377\u0378\7\35\2\2"
            + "\u0378\u0379\5\u00dep\2\u0379\u00dd\3\2\2\2\u037a\u037b\bp\1\2\u037b\u0382"
            + "\5\u00e2r\2\u037c\u0382\5\u00e4s\2\u037d\u037e\7\b\2\2\u037e\u037f\5\u00de"
            + "p\2\u037f\u0380\7\t\2\2\u0380\u0382\3\2\2\2\u0381\u037a\3\2\2\2\u0381"
            + "\u037c\3\2\2\2\u0381\u037d\3\2\2\2\u0382\u0388\3\2\2\2\u0383\u0384\f\4"
            + "\2\2\u0384\u0385\7\'\2\2\u0385\u0387\5\u00dep\5\u0386\u0383\3\2\2\2\u0387"
            + "\u038a\3\2\2\2\u0388\u0386\3\2\2\2\u0388\u0389\3\2\2\2\u0389\u00df\3\2"
            + "\2\2\u038a\u0388\3\2\2\2\u038b\u038c\5\u00eav\2\u038c\u038d\7\f\2\2\u038d"
            + "\u038e\7\61\2\2\u038e\u0392\3\2\2\2\u038f\u0392\7\61\2\2\u0390\u0392\7"
            + "\62\2\2\u0391\u038b\3\2\2\2\u0391\u038f\3\2\2\2\u0391\u0390\3\2\2\2\u0392"
            + "\u00e1\3\2\2\2\u0393\u0394\5\u00e6t\2\u0394\u0395\7\3\2\2\u0395\u0396"
            + "\5\u00e8u\2\u0396\u00e3\3\2\2\2\u0397\u0398\5\u00e0q\2\u0398\u0399\7,"
            + "\2\2\u0399\u039a\7\62\2\2\u039a\u00e5\3\2\2\2\u039b\u039c\5\u00e0q\2\u039c"
            + "\u00e7\3\2\2\2\u039d\u039e\5\u00e0q\2\u039e\u00e9\3\2\2\2\u039f\u03a0"
            + "\7\61\2\2\u03a0\u00eb\3\2\2\2\u03a1\u03a2\5\4\3\2\u03a2\u03a3\7\3\2\2"
            + "\u03a3\u03a4\5\u00eex\2\u03a4\u03a5\7\2\2\3\u03a5\u00ed\3\2\2\2\u03a6"
            + "\u03a7\5\u00f0y\2\u03a7\u03a8\7\27\2\2\u03a8\u03a9\7-\2\2\u03a9\u03ab"
            + "\7\30\2\2\u03aa\u03ac\5\u00f2z\2\u03ab\u03aa\3\2\2\2\u03ab\u03ac\3\2\2"
            + "\2\u03ac\u03ad\3\2\2\2\u03ad\u03ae\7\31\2\2\u03ae\u03af\5\u00fa~\2\u03af"
            + "\u00ef\3\2\2\2\u03b0\u03b1\7\61\2\2\u03b1\u00f1\3\2\2\2\u03b2\u03b3\5"
            + "\u00f4{\2\u03b3\u03b4\7\5\2\2\u03b4\u03b5\5\u00f6|\2\u03b5\u00f3\3\2\2"
            + "\2\u03b6\u03b7\5\u00f8}\2\u03b7\u00f5\3\2\2\2\u03b8\u03b9\5\u00f8}\2\u03b9"
            + "\u00f7\3\2\2\2\u03ba\u03bd\5\u0106\u0084\2\u03bb\u03bd\5\u010a\u0086\2"
            + "\u03bc\u03ba\3\2\2\2\u03bc\u03bb\3\2\2\2\u03bd\u00f9\3\2\2\2\u03be\u03bf"
            + "\7\32\2\2\u03bf\u03c4\5\u0106\u0084\2\u03c0\u03c1\7\4\2\2\u03c1\u03c3"
            + "\5\u0106\u0084\2\u03c2\u03c0\3\2\2\2\u03c3\u03c6\3\2\2\2\u03c4\u03c2\3"
            + "\2\2\2\u03c4\u03c5\3\2\2\2\u03c5\u00fb\3\2\2\2\u03c6\u03c4\3\2\2\2\u03c7"
            + "\u03c8\7\60\2\2\u03c8\u03c9\7\b\2\2\u03c9\u03ce\5\u00fe\u0080\2\u03ca"
            + "\u03cb\7\4\2\2\u03cb\u03cd\5\u00fe\u0080\2\u03cc\u03ca\3\2\2\2\u03cd\u03d0"
            + "\3\2\2\2\u03ce\u03cc\3\2\2\2\u03ce\u03cf\3\2\2\2\u03cf\u03d1\3\2\2\2\u03d0"
            + "\u03ce\3\2\2\2\u03d1\u03d2\7\t\2\2\u03d2\u00fd\3\2\2\2\u03d3\u03d4\5\u0100"
            + "\u0081\2\u03d4\u03d5\7\5\2\2\u03d5\u03d6\5\u0104\u0083\2\u03d6\u00ff\3"
            + "\2\2\2\u03d7\u03d8\5\u0102\u0082\2\u03d8\u0101\3\2\2\2\u03d9\u03da\7\62"
            + "\2\2\u03da\u0103\3\2\2\2\u03db\u03dc\5\u0108\u0085\2\u03dc\u0105\3\2\2"
            + "\2\u03dd\u03de\7\61\2\2\u03de\u0107\3\2\2\2\u03df\u03e0\7\61\2\2\u03e0"
            + "\u0109\3\2\2\2\u03e1\u03e2\t\3\2\2\u03e2\u010b\3\2\2\2\u03e3\u03e4\5\4"
            + "\3\2\u03e4\u03e5\7\3\2\2\u03e5\u03e6\5\u010e\u0088\2\u03e6\u03e7\7\2\2"
            + "\3\u03e7\u010d\3\2\2\2\u03e8\u03e9\5\u0126\u0094\2\u03e9\u03ea\5\u0110"
            + "\u0089\2\u03ea\u010f\3\2\2\2\u03eb\u03ec\5\u0112\u008a\2\u03ec\u0111\3"
            + "\2\2\2\u03ed\u03ee\7*\2\2\u03ee\u03f3\5\u0114\u008b\2\u03ef\u03f0\7\4"
            + "\2\2\u03f0\u03f2\5\u0114\u008b\2\u03f1\u03ef\3\2\2\2\u03f2\u03f5\3\2\2"
            + "\2\u03f3\u03f1\3\2\2\2\u03f3\u03f4\3\2\2\2\u03f4\u0113\3\2\2\2\u03f5\u03f3"
            + "\3\2\2\2\u03f6\u03fb\5\u0118\u008d\2\u03f7\u03fb\5\u0120\u0091\2\u03f8"
            + "\u03fb\5\u0122\u0092\2\u03f9\u03fb\5\u0116\u008c\2\u03fa\u03f6\3\2\2\2"
            + "\u03fa\u03f7\3\2\2\2\u03fa\u03f8\3\2\2\2\u03fa\u03f9\3\2\2\2\u03fb\u0115"
            + "\3\2\2\2\u03fc\u03fd\5\u0146\u00a4\2\u03fd\u03fe\7+\2\2\u03fe\u03ff\5"
            + "\u0150\u00a9\2\u03ff\u0117\3\2\2\2\u0400\u0401\7.\2\2\u0401\u0402\7\b"
            + "\2\2\u0402\u0407\5\u011a\u008e\2\u0403\u0404\7\4\2\2\u0404\u0406\5\u011a"
            + "\u008e\2\u0405\u0403\3\2\2\2\u0406\u0409\3\2\2\2\u0407\u0405\3\2\2\2\u0407"
            + "\u0408\3\2\2\2\u0408\u040a\3\2\2\2\u0409\u0407\3\2\2\2\u040a\u040b\7\t"
            + "\2\2\u040b\u0119\3\2\2\2\u040c\u040d\5\u011c\u008f\2\u040d\u040e\7\4\2"
            + "\2\u040e\u040f\5\u011e\u0090\2\u040f\u011b\3\2\2\2\u0410\u0411\5\u0154"
            + "\u00ab\2\u0411\u011d\3\2\2\2\u0412\u0417\5\u0118\u008d\2\u0413\u0417\5"
            + "\u0120\u0091\2\u0414\u0417\5\u0122\u0092\2\u0415\u0417\5\u0124\u0093\2"
            + "\u0416\u0412\3\2\2\2\u0416\u0413\3\2\2\2\u0416\u0414\3\2\2\2\u0416\u0415"
            + "\3\2\2\2\u0417\u011f\3\2\2\2\u0418\u0419\5\u0150\u00a9\2\u0419\u0121\3"
            + "\2\2\2\u041a\u041b\5\u0156\u00ac\2\u041b\u0123\3\2\2\2\u041c\u041d\5\u010e"
            + "\u0088\2\u041d\u0125\3\2\2\2\u041e\u0420\5\u0128\u0095\2\u041f\u0421\5"
            + "\u0132\u009a\2\u0420\u041f\3\2\2\2\u0420\u0421\3\2\2\2\u0421\u0127\3\2"
            + "\2\2\u0422\u0423\7(\2\2\u0423\u0428\5\u012a\u0096\2\u0424\u0425\7\4\2"
            + "\2\u0425\u0427\5\u012a\u0096\2\u0426\u0424\3\2\2\2\u0427\u042a\3\2\2\2"
            + "\u0428\u0426\3\2\2\2\u0428\u0429\3\2\2\2\u0429\u0129\3\2\2\2\u042a\u0428"
            + "\3\2\2\2\u042b\u042c\5\u012c\u0097\2\u042c\u042d\7+\2\2\u042d\u042e\5"
            + "\u0130\u0099\2\u042e\u012b\3\2\2\2\u042f\u0430\5\u012e\u0098\2\u0430\u012d"
            + "\3\2\2\2\u0431\u0439\5\u0152\u00aa\2\u0432\u0433\7/\2\2\u0433\u0434\7"
            + "\b\2\2\u0434\u0435\5\u0146\u00a4\2\u0435\u0436\7\t\2\2\u0436\u0439\3\2"
            + "\2\2\u0437\u0439\5\u0146\u00a4\2\u0438\u0431\3\2\2\2\u0438\u0432\3\2\2"
            + "\2\u0438\u0437\3\2\2\2\u0439\u012f\3\2\2\2\u043a\u043b\5\u0150\u00a9\2"
            + "\u043b\u0131\3\2\2\2\u043c\u043d\7\35\2\2\u043d\u043e\5\u0134\u009b\2"
            + "\u043e\u0133\3\2\2\2\u043f\u0440\b\u009b\1\2\u0440\u0446\5\u0136\u009c"
            + "\2\u0441\u0442\7\b\2\2\u0442\u0443\5\u0134\u009b\2\u0443\u0444\7\t\2\2"
            + "\u0444\u0446\3\2\2\2\u0445\u043f\3\2\2\2\u0445\u0441\3\2\2\2\u0446\u044c"
            + "\3\2\2\2\u0447\u0448\f\4\2\2\u0448\u0449\7\'\2\2\u0449\u044b\5\u0134\u009b"
            + "\5\u044a\u0447\3\2\2\2\u044b\u044e\3\2\2\2\u044c\u044a\3\2\2\2\u044c\u044d"
            + "\3\2\2\2\u044d\u0135\3\2\2\2\u044e\u044c\3\2\2\2\u044f\u0450\5\u0138\u009d"
            + "\2\u0450\u0451\7\3\2\2\u0451\u0452\5\u013a\u009e\2\u0452\u0137\3\2\2\2"
            + "\u0453\u0454\5\u013c\u009f\2\u0454\u0139\3\2\2\2\u0455\u0456\5\u013c\u009f"
            + "\2\u0456\u013b\3\2\2\2\u0457\u0458\5\u013e\u00a0\2\u0458\u013d\3\2\2\2"
            + "\u0459\u045d\5\u0142\u00a2\2\u045a\u045d\5\u0140\u00a1\2\u045b\u045d\5"
            + "\u0144\u00a3\2\u045c\u0459\3\2\2\2\u045c\u045a\3\2\2\2\u045c\u045b\3\2"
            + "\2\2\u045d\u013f\3\2\2\2\u045e\u045f\5\u0150\u00a9\2\u045f\u0141\3\2\2"
            + "\2\u0460\u0461\5\u0156\u00ac\2\u0461\u0143\3\2\2\2\u0462\u0463\5\u0146"
            + "\u00a4\2\u0463\u0145\3\2\2\2\u0464\u0466\5\u0148\u00a5\2\u0465\u0467\5"
            + "\u014a\u00a6\2\u0466\u0465\3\2\2\2\u0467\u0468\3\2\2\2\u0468\u0469\3\2"
            + "\2\2\u0468\u0466\3\2\2\2\u0469\u0147\3\2\2\2\u046a\u046d\5\u0150\u00a9"
            + "\2\u046b\u046d\5\u014e\u00a8\2\u046c\u046a\3\2\2\2\u046c\u046b\3\2\2\2"
            + "\u046d\u0149\3\2\2\2\u046e\u046f\5\u014c\u00a7\2\u046f\u014b\3\2\2\2\u0470"
            + "\u0471\7\33\2\2\u0471\u0472\5\u0154\u00ab\2\u0472\u014d\3\2\2\2\u0473"
            + "\u0474\5\u0150\u00a9\2\u0474\u0475\7\f\2\2\u0475\u0476\5\u0158\u00ad\2"
            + "\u0476\u014f\3\2\2\2\u0477\u0478\7\61\2\2\u0478\u0151\3\2\2\2\u0479\u047a"
            + "\7\61\2\2\u047a\u0153\3\2\2\2\u047b\u047c\t\4\2\2\u047c\u0155\3\2\2\2"
            + "\u047d\u047e\t\3\2\2\u047e\u0157\3\2\2\2\u047f\u0480\7\61\2\2\u0480\u0159"
            + "\3\2\2\2\u0481\u0482\5\4\3\2\u0482\u0483\7\3\2\2\u0483\u0484\5\u015c\u00af"
            + "\2\u0484\u0485\7\2\2\3\u0485\u048d\3\2\2\2\u0486\u0487\7\6\2\2\u0487\u0488"
            + "\5\u015e\u00b0\2\u0488\u0489\7\5\2\2\u0489\u048a\5\u015c\u00af\2\u048a"
            + "\u048b\7\7\2\2\u048b\u048d\3\2\2\2\u048c\u0481\3\2\2\2\u048c\u0486\3\2"
            + "\2\2\u048d\u015b\3\2\2\2\u048e\u048f\5\u0174\u00bb\2\u048f\u0490\5\u0160"
            + "\u00b1\2\u0490\u015d\3\2\2\2\u0491\u0492\5\u019e\u00d0\2\u0492\u015f\3"
            + "\2\2\2\u0493\u0494\5\u0162\u00b2\2\u0494\u0161\3\2\2\2\u0495\u0496\7*"
            + "\2\2\u0496\u0497\5\u0164\u00b3\2\u0497\u0163\3\2\2\2\u0498\u049c\5\u0166"
            + "\u00b4\2\u0499\u049c\5\u016e\u00b8\2\u049a\u049c\5\u0170\u00b9\2\u049b"
            + "\u0498\3\2\2\2\u049b\u0499\3\2\2\2\u049b\u049a\3\2\2\2\u049c\u0165\3\2"
            + "\2\2\u049d\u049e\7\6\2\2\u049e\u04a3\5\u0168\u00b5\2\u049f\u04a0\7\4\2"
            + "\2\u04a0\u04a2\5\u0168\u00b5\2\u04a1\u049f\3\2\2\2\u04a2\u04a5\3\2\2\2"
            + "\u04a3\u04a1\3\2\2\2\u04a3\u04a4\3\2\2\2\u04a4\u04a6\3\2\2\2\u04a5\u04a3"
            + "\3\2\2\2\u04a6\u04a7\7\7\2\2\u04a7\u0167\3\2\2\2\u04a8\u04a9\5\u016a\u00b6"
            + "\2\u04a9\u04aa\7\5\2\2\u04aa\u04ab\5\u016c\u00b7\2\u04ab\u0169\3\2\2\2"
            + "\u04ac\u04ad\5\u009cO\2\u04ad\u016b\3\2\2\2\u04ae\u04b3\5\u0166\u00b4"
            + "\2\u04af\u04b3\5\u016e\u00b8\2\u04b0\u04b3\5\u0170\u00b9\2\u04b1\u04b3"
            + "\5\u0172\u00ba\2\u04b2\u04ae\3\2\2\2\u04b2\u04af\3\2\2\2\u04b2\u04b0\3"
            + "\2\2\2\u04b2\u04b1\3\2\2\2\u04b3\u016d\3\2\2\2\u04b4\u04b5\5\u019c\u00cf"
            + "\2\u04b5\u016f\3\2\2\2\u04b6\u04b7\5\u01a0\u00d1\2\u04b7\u0171\3\2\2\2"
            + "\u04b8\u04b9\5\u015c\u00af\2\u04b9\u0173\3\2\2\2\u04ba\u04bc\5\u0176\u00bc"
            + "\2\u04bb\u04bd\5\u0180\u00c1\2\u04bc\u04bb\3\2\2\2\u04bc\u04bd\3\2\2\2"
            + "\u04bd\u0175\3\2\2\2\u04be\u04bf\7(\2\2\u04bf\u04c4\5\u0178\u00bd\2\u04c0"
            + "\u04c1\7\4\2\2\u04c1\u04c3\5\u0178\u00bd\2\u04c2\u04c0\3\2\2\2\u04c3\u04c6"
            + "\3\2\2\2\u04c4\u04c2\3\2\2\2\u04c4\u04c5\3\2\2\2\u04c5\u0177\3\2\2\2\u04c6"
            + "\u04c4\3\2\2\2\u04c7\u04c8\5\u017a\u00be\2\u04c8\u04c9\7+\2\2\u04c9\u04ca"
            + "\5\u017e\u00c0\2\u04ca\u0179\3\2\2\2\u04cb\u04cc\5\u017c\u00bf\2\u04cc"
            + "\u017b\3\2\2\2\u04cd\u04d0\5\u00aaV\2\u04ce\u04d0\5\u0194\u00cb\2\u04cf"
            + "\u04cd\3\2\2\2\u04cf\u04ce\3\2\2\2\u04d0\u017d\3\2\2\2\u04d1\u04d2\5\u019c"
            + "\u00cf\2\u04d2\u017f\3\2\2\2\u04d3\u04d4\7\35\2\2\u04d4\u04d5\5\u0182"
            + "\u00c2\2\u04d5\u0181\3\2\2\2\u04d6\u04d7\b\u00c2\1\2\u04d7\u04dd\5\u0184"
            + "\u00c3\2\u04d8\u04d9\7\b\2\2\u04d9\u04da\5\u0182\u00c2\2\u04da\u04db\7"
            + "\t\2\2\u04db\u04dd\3\2\2\2\u04dc\u04d6\3\2\2\2\u04dc\u04d8\3\2\2\2\u04dd"
            + "\u04e3\3\2\2\2\u04de\u04df\f\4\2\2\u04df\u04e0\7\'\2\2\u04e0\u04e2\5\u0182"
            + "\u00c2\5\u04e1\u04de\3\2\2\2\u04e2\u04e5\3\2\2\2\u04e3\u04e1\3\2\2\2\u04e3"
            + "\u04e4\3\2\2\2\u04e4\u0183\3\2\2\2\u04e5\u04e3\3\2\2\2\u04e6\u04e7\5\u0186"
            + "\u00c4\2\u04e7\u04e8\7\3\2\2\u04e8\u04e9\5\u0188\u00c5\2\u04e9\u0185\3"
            + "\2\2\2\u04ea\u04eb\5\u018a\u00c6\2\u04eb\u0187\3\2\2\2\u04ec\u04ed\5\u018a"
            + "\u00c6\2\u04ed\u0189\3\2\2\2\u04ee\u04ef\5\u018c\u00c7\2\u04ef\u018b\3"
            + "\2\2\2\u04f0\u04f4\5\u0190\u00c9\2\u04f1\u04f4\5\u018e\u00c8\2\u04f2\u04f4"
            + "\5\u0192\u00ca\2\u04f3\u04f0\3\2\2\2\u04f3\u04f1\3\2\2\2\u04f3\u04f2\3"
            + "\2\2\2\u04f4\u018d\3\2\2\2\u04f5\u04f6\5\u019c\u00cf\2\u04f6\u018f\3\2"
            + "\2\2\u04f7\u04f8\5\u01a0\u00d1\2\u04f8\u0191\3\2\2\2\u04f9\u04fa\5\u0194"
            + "\u00cb\2\u04fa\u0193\3\2\2\2\u04fb\u04fd\5\u0196\u00cc\2\u04fc\u04fe\5"
            + "\u0198\u00cd\2\u04fd\u04fc\3\2\2\2\u04fe\u04ff\3\2\2\2\u04ff\u0500\3\2"
            + "\2\2\u04ff\u04fd\3\2\2\2\u0500\u0195\3\2\2\2\u0501\u0502\5\u019c\u00cf"
            + "\2\u0502\u0197\3\2\2\2\u0503\u0504\5\u019a\u00ce\2\u0504\u0199\3\2\2\2"
            + "\u0505\u0506\7\f\2\2\u0506\u0507\5\u009cO\2\u0507\u019b\3\2\2\2\u0508"
            + "\u0509\7\61\2\2\u0509\u019d\3\2\2\2\u050a\u050b\7\62\2\2\u050b\u019f\3"
            + "\2\2\2\u050c\u050d\t\3\2\2\u050d\u01a1\3\2\2\2F\u01ad\u01b7\u01cc\u01d0"
            + "\u01e2\u01e9\u01fe\u021f\u022c\u023c\u0244\u0259\u0266\u026e\u0276\u027e"
            + "\u0284\u028a\u0295\u02a0\u02a8\u02b9\u02c0\u02cb\u02d2\u02da\u02e2\u02ea"
            + "\u02fd\u030b\u031d\u0324\u032c\u0343\u0351\u035b\u0360\u0368\u0381\u0388"
            + "\u0391\u03ab\u03bc\u03c4\u03ce\u03f3\u03fa\u0407\u0416\u0420\u0428\u0438"
            + "\u0445\u044c\u045c\u0468\u046c\u048c\u049b\u04a3\u04b2\u04bc\u04c4\u04cf" + "\u04dc\u04e3\u04f3\u04ff";
    public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}