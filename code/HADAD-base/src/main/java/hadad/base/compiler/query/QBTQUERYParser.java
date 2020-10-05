// Generated from QBTQUERY.g4 by ANTLR 4.5

package hadad.base.compiler.query;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QBTQUERYParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, FOR=30, WHERE=31, RETURN=32, 
		JQ=33, KQ=34, RQ=35, XQ=36, TQ=37, AND=38, MAIN=39, IN=40, FROM=41, SELECT=42, 
		AS=43, LIKE=44, NAME=45, STRINGRULE=46, INTEGER=47, WHITESPACE=48, MAP=49, 
		KEYS=50, LIST=51, SET=52, BETA=53, WS=54, ALPHA=55, STRING=56;
	public static final int
		RULE_mixedqbt = 0, RULE_queryName = 1, RULE_mixedQBTQuery = 2, RULE_block = 3, 
		RULE_forPattern = 4, RULE_wherePattern = 5, RULE_returnPattern = 6, RULE_pattern = 7, 
		RULE_modelPattern = 8, RULE_jqPattern = 9, RULE_kqPattern = 10, RULE_xqPattern = 11, 
		RULE_rqPattern = 12, RULE_mixedcondition = 13, RULE_atom = 14, RULE_termmixed = 15, 
		RULE_constant = 16, RULE_pathExpr = 17, RULE_constructor = 18, RULE_modelConstructor = 19, 
		RULE_jqConstructor = 20, RULE_kqConstructor = 21, RULE_xqConstructor = 22, 
		RULE_annotation = 23, RULE_stringConstant = 24, RULE_numericConstant = 25, 
		RULE_mainMap = 26, RULE_kqlquery = 27, RULE_redisKQLQuery = 28, RULE_sfwQuery = 29, 
		RULE_selectClasue = 30, RULE_selectStatement = 31, RULE_selectItemKQL = 32, 
		RULE_returnVariableKQL = 33, RULE_fromClasue = 34, RULE_varBinding = 35, 
		RULE_fromvariableBinding = 36, RULE_sourceKQL = 37, RULE_lookUpExpression = 38, 
		RULE_mapVariable = 39, RULE_keyKQL = 40, RULE_stringKey = 41, RULE_variableKey = 42, 
		RULE_keyVariable = 43, RULE_mapName = 44, RULE_variableKQL = 45, RULE_aqlquery = 46, 
		RULE_queryAQL = 47, RULE_rootFieldName = 48, RULE_returnClause = 49, RULE_recordConstruct = 50, 
		RULE_fieldBinding = 51, RULE_recordConstructFieldName = 52, RULE_fieldName = 53, 
		RULE_fieldValue = 54, RULE_returnVar = 55, RULE_varRQ = 56, RULE_name = 57, 
		RULE_returnConstant = 58, RULE_returnQuery = 59, RULE_term = 60, RULE_termVar = 61, 
		RULE_termConstant = 62, RULE_termPath = 63, RULE_number = 64, RULE_string = 65, 
		RULE_path = 66, RULE_pathVar = 67, RULE_varAQL = 68, RULE_step = 69, RULE_objectStep = 70, 
		RULE_arrayStep = 71, RULE_keyAQL = 72, RULE_index = 73, RULE_forClause = 74, 
		RULE_formixed = 75, RULE_binding = 76, RULE_forClauseBindingVar = 77, 
		RULE_forClauseBindingSource = 78, RULE_sourceAQL = 79, RULE_dataSetName = 80, 
		RULE_whereClause = 81, RULE_condition = 82, RULE_whereCondSome = 83, RULE_whereCondBinding = 84, 
		RULE_whereCondBindingVar = 85, RULE_whereCondBindingSource = 86, RULE_whereCondEquality = 87, 
		RULE_whereCondEqualityLeftTerm = 88, RULE_whereCondEqualityRightTerm = 89, 
		RULE_cterm = 90, RULE_xquery = 91, RULE_openRootTag = 92, RULE_closeRootTag = 93, 
		RULE_construct = 94, RULE_constructEmptyTag = 95, RULE_constructString = 96, 
		RULE_constructVar = 97, RULE_constructFlwr = 98, RULE_constructFlwrTerm = 99, 
		RULE_constructDelimeter = 100, RULE_constructFlwrOpenTag = 101, RULE_constructFlwrCloseTag = 102, 
		RULE_tag = 103, RULE_mkattr = 104, RULE_mkattrName = 105, RULE_aterm = 106, 
		RULE_atermVar = 107, RULE_atermString = 108, RULE_varXQ = 109, RULE_flwr = 110, 
		RULE_flwrFor = 111, RULE_flwrWhere = 112, RULE_flwrForWhere = 113, RULE_flwrReturn = 114, 
		RULE_flwrForVar = 115, RULE_flwrForP = 116, RULE_flwrWhereCond = 117, 
		RULE_flwrWhereCondSome = 118, RULE_flwrWhereCondVar = 119, RULE_flwrWhereCondAp = 120, 
		RULE_flwrWhereCondEquality = 121, RULE_flwrWhereCondEqualityLeftTerm = 122, 
		RULE_flwrWhereCondEqualityRightTerm = 123, RULE_ctermAp = 124, RULE_ctermVar = 125, 
		RULE_ctermString = 126, RULE_flwrReturnVar = 127, RULE_flwrReturnString = 128, 
		RULE_flwrReturnConstruct = 129, RULE_rp = 130, RULE_child = 131, RULE_desc = 132, 
		RULE_rpTag = 133, RULE_rpAttr = 134, RULE_rpText = 135, RULE_ap = 136, 
		RULE_document = 137, RULE_sourceXQ = 138, RULE_apAttr = 139, RULE_p = 140, 
		RULE_rqQuery = 141, RULE_sqlQuery = 142, RULE_sfwQueryRQ = 143, RULE_fromWhereClausesRQ = 144, 
		RULE_selectClauseRQ = 145, RULE_selectStatementRQ = 146, RULE_selectItemRQ = 147, 
		RULE_fromClauseRQ = 148, RULE_relationBinding = 149, RULE_source = 150, 
		RULE_relationName = 151, RULE_variableKQ = 152, RULE_whereClauseRQ = 153, 
		RULE_whereStatementRQ = 154, RULE_conditionRQ = 155, RULE_termRQ = 156, 
		RULE_equality = 157, RULE_likeExpression = 158, RULE_lefttermRQ = 159, 
		RULE_righttermRQ = 160, RULE_realtion = 161;
	public static final String[] ruleNames = {
		"mixedqbt", "queryName", "mixedQBTQuery", "block", "forPattern", "wherePattern", 
		"returnPattern", "pattern", "modelPattern", "jqPattern", "kqPattern", 
		"xqPattern", "rqPattern", "mixedcondition", "atom", "termmixed", "constant", 
		"pathExpr", "constructor", "modelConstructor", "jqConstructor", "kqConstructor", 
		"xqConstructor", "annotation", "stringConstant", "numericConstant", "mainMap", 
		"kqlquery", "redisKQLQuery", "sfwQuery", "selectClasue", "selectStatement", 
		"selectItemKQL", "returnVariableKQL", "fromClasue", "varBinding", "fromvariableBinding", 
		"sourceKQL", "lookUpExpression", "mapVariable", "keyKQL", "stringKey", 
		"variableKey", "keyVariable", "mapName", "variableKQL", "aqlquery", "queryAQL", 
		"rootFieldName", "returnClause", "recordConstruct", "fieldBinding", "recordConstructFieldName", 
		"fieldName", "fieldValue", "returnVar", "varRQ", "name", "returnConstant", 
		"returnQuery", "term", "termVar", "termConstant", "termPath", "number", 
		"string", "path", "pathVar", "varAQL", "step", "objectStep", "arrayStep", 
		"keyAQL", "index", "forClause", "formixed", "binding", "forClauseBindingVar", 
		"forClauseBindingSource", "sourceAQL", "dataSetName", "whereClause", "condition", 
		"whereCondSome", "whereCondBinding", "whereCondBindingVar", "whereCondBindingSource", 
		"whereCondEquality", "whereCondEqualityLeftTerm", "whereCondEqualityRightTerm", 
		"cterm", "xquery", "openRootTag", "closeRootTag", "construct", "constructEmptyTag", 
		"constructString", "constructVar", "constructFlwr", "constructFlwrTerm", 
		"constructDelimeter", "constructFlwrOpenTag", "constructFlwrCloseTag", 
		"tag", "mkattr", "mkattrName", "aterm", "atermVar", "atermString", "varXQ", 
		"flwr", "flwrFor", "flwrWhere", "flwrForWhere", "flwrReturn", "flwrForVar", 
		"flwrForP", "flwrWhereCond", "flwrWhereCondSome", "flwrWhereCondVar", 
		"flwrWhereCondAp", "flwrWhereCondEquality", "flwrWhereCondEqualityLeftTerm", 
		"flwrWhereCondEqualityRightTerm", "ctermAp", "ctermVar", "ctermString", 
		"flwrReturnVar", "flwrReturnString", "flwrReturnConstruct", "rp", "child", 
		"desc", "rpTag", "rpAttr", "rpText", "ap", "document", "sourceXQ", "apAttr", 
		"p", "rqQuery", "sqlQuery", "sfwQueryRQ", "fromWhereClausesRQ", "selectClauseRQ", 
		"selectStatementRQ", "selectItemRQ", "fromClauseRQ", "relationBinding", 
		"source", "relationName", "variableKQ", "whereClauseRQ", "whereStatementRQ", 
		"conditionRQ", "termRQ", "equality", "likeExpression", "lefttermRQ", "righttermRQ", 
		"realtion"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "','", "'WHERE'", "':'", "'{'", "'}'", "'('", "')'", "'MAIN1'", 
		"'['", "']'", "'.'", "'return'", "'for '", "'in'", "'dataset'", "'where'", 
		"'and'", "'some'", "'satisfies'", "'<'", "'>'", "'</'", "'/>'", "'/'", 
		"'//'", "'@'", "'text()'", "'document('"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "FOR", "WHERE", "RETURN", "JQ", "KQ", 
		"RQ", "XQ", "TQ", "AND", "MAIN", "IN", "FROM", "SELECT", "AS", "LIKE", 
		"NAME", "STRINGRULE", "INTEGER", "WHITESPACE", "MAP", "KEYS", "LIST", 
		"SET", "BETA", "WS", "ALPHA", "STRING"
	};
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
	public String getGrammarFileName() { return "QBTQUERY.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QBTQUERYParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class MixedqbtContext extends ParserRuleContext {
		public QueryNameContext queryName() {
			return getRuleContext(QueryNameContext.class,0);
		}
		public MixedQBTQueryContext mixedQBTQuery() {
			return getRuleContext(MixedQBTQueryContext.class,0);
		}
		public TerminalNode EOF() { return getToken(QBTQUERYParser.EOF, 0); }
		public MixedqbtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mixedqbt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterMixedqbt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitMixedqbt(this);
		}
	}

	public final MixedqbtContext mixedqbt() throws RecognitionException {
		MixedqbtContext _localctx = new MixedqbtContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_mixedqbt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324);
			queryName();
			setState(325);
			match(T__0);
			setState(326);
			mixedQBTQuery();
			setState(327);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryNameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(QBTQUERYParser.NAME, 0); }
		public QueryNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterQueryName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitQueryName(this);
		}
	}

	public final QueryNameContext queryName() throws RecognitionException {
		QueryNameContext _localctx = new QueryNameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_queryName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(329);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MixedQBTQueryContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public MixedQBTQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mixedQBTQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterMixedQBTQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitMixedQBTQuery(this);
		}
	}

	public final MixedQBTQueryContext mixedQBTQuery() throws RecognitionException {
		MixedQBTQueryContext _localctx = new MixedQBTQueryContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_mixedQBTQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(331);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public ForPatternContext forPattern() {
			return getRuleContext(ForPatternContext.class,0);
		}
		public WherePatternContext wherePattern() {
			return getRuleContext(WherePatternContext.class,0);
		}
		public ReturnPatternContext returnPattern() {
			return getRuleContext(ReturnPatternContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			forPattern();
			setState(335);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(334);
				wherePattern();
				}
			}

			setState(338);
			_la = _input.LA(1);
			if (_la==RETURN) {
				{
				setState(337);
				returnPattern();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForPatternContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(QBTQUERYParser.FOR, 0); }
		public List<PatternContext> pattern() {
			return getRuleContexts(PatternContext.class);
		}
		public PatternContext pattern(int i) {
			return getRuleContext(PatternContext.class,i);
		}
		public ForPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterForPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitForPattern(this);
		}
	}

	public final ForPatternContext forPattern() throws RecognitionException {
		ForPatternContext _localctx = new ForPatternContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_forPattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			match(FOR);
			setState(341);
			pattern();
			setState(346);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(342);
				match(T__1);
				setState(343);
				pattern();
				}
				}
				setState(348);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WherePatternContext extends ParserRuleContext {
		public MixedconditionContext mixedcondition() {
			return getRuleContext(MixedconditionContext.class,0);
		}
		public WherePatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wherePattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterWherePattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitWherePattern(this);
		}
	}

	public final WherePatternContext wherePattern() throws RecognitionException {
		WherePatternContext _localctx = new WherePatternContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_wherePattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(349);
			match(T__2);
			setState(350);
			mixedcondition(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnPatternContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(QBTQUERYParser.RETURN, 0); }
		public ConstructorContext constructor() {
			return getRuleContext(ConstructorContext.class,0);
		}
		public ReturnPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterReturnPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitReturnPattern(this);
		}
	}

	public final ReturnPatternContext returnPattern() throws RecognitionException {
		ReturnPatternContext _localctx = new ReturnPatternContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_returnPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(352);
			match(RETURN);
			setState(353);
			constructor();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PatternContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public ModelPatternContext modelPattern() {
			return getRuleContext(ModelPatternContext.class,0);
		}
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitPattern(this);
		}
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			annotation();
			setState(356);
			match(T__3);
			setState(357);
			match(T__4);
			setState(358);
			modelPattern();
			setState(359);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModelPatternContext extends ParserRuleContext {
		public JqPatternContext jqPattern() {
			return getRuleContext(JqPatternContext.class,0);
		}
		public KqPatternContext kqPattern() {
			return getRuleContext(KqPatternContext.class,0);
		}
		public XqPatternContext xqPattern() {
			return getRuleContext(XqPatternContext.class,0);
		}
		public RqPatternContext rqPattern() {
			return getRuleContext(RqPatternContext.class,0);
		}
		public ModelPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modelPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterModelPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitModelPattern(this);
		}
	}

	public final ModelPatternContext modelPattern() throws RecognitionException {
		ModelPatternContext _localctx = new ModelPatternContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_modelPattern);
		try {
			setState(365);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(361);
				jqPattern();
				}
				break;
			case FROM:
				enterOuterAlt(_localctx, 2);
				{
				setState(362);
				kqPattern();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 3);
				{
				setState(363);
				xqPattern();
				}
				break;
			case SELECT:
				enterOuterAlt(_localctx, 4);
				{
				setState(364);
				rqPattern();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JqPatternContext extends ParserRuleContext {
		public FormixedContext formixed() {
			return getRuleContext(FormixedContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public JqPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jqPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterJqPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitJqPattern(this);
		}
	}

	public final JqPatternContext jqPattern() throws RecognitionException {
		JqPatternContext _localctx = new JqPatternContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_jqPattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			formixed();
			setState(369);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(368);
				whereClause();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KqPatternContext extends ParserRuleContext {
		public FromClasueContext fromClasue() {
			return getRuleContext(FromClasueContext.class,0);
		}
		public KqPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kqPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterKqPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitKqPattern(this);
		}
	}

	public final KqPatternContext kqPattern() throws RecognitionException {
		KqPatternContext _localctx = new KqPatternContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_kqPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
			fromClasue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class XqPatternContext extends ParserRuleContext {
		public FlwrForWhereContext flwrForWhere() {
			return getRuleContext(FlwrForWhereContext.class,0);
		}
		public XqPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xqPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterXqPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitXqPattern(this);
		}
	}

	public final XqPatternContext xqPattern() throws RecognitionException {
		XqPatternContext _localctx = new XqPatternContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_xqPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373);
			flwrForWhere();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RqPatternContext extends ParserRuleContext {
		public SqlQueryContext sqlQuery() {
			return getRuleContext(SqlQueryContext.class,0);
		}
		public RqPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rqPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterRqPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitRqPattern(this);
		}
	}

	public final RqPatternContext rqPattern() throws RecognitionException {
		RqPatternContext _localctx = new RqPatternContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_rqPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			sqlQuery();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MixedconditionContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public List<MixedconditionContext> mixedcondition() {
			return getRuleContexts(MixedconditionContext.class);
		}
		public MixedconditionContext mixedcondition(int i) {
			return getRuleContext(MixedconditionContext.class,i);
		}
		public TerminalNode AND() { return getToken(QBTQUERYParser.AND, 0); }
		public MixedconditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mixedcondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterMixedcondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitMixedcondition(this);
		}
	}

	public final MixedconditionContext mixedcondition() throws RecognitionException {
		return mixedcondition(0);
	}

	private MixedconditionContext mixedcondition(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MixedconditionContext _localctx = new MixedconditionContext(_ctx, _parentState);
		MixedconditionContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_mixedcondition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(383);
			switch (_input.LA(1)) {
			case JQ:
			case KQ:
			case RQ:
			case XQ:
			case TQ:
			case STRINGRULE:
			case INTEGER:
				{
				setState(378);
				atom();
				}
				break;
			case T__6:
				{
				setState(379);
				match(T__6);
				setState(380);
				mixedcondition(0);
				setState(381);
				match(T__7);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(390);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MixedconditionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_mixedcondition);
					setState(385);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(386);
					match(AND);
					setState(387);
					mixedcondition(2);
					}
					} 
				}
				setState(392);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AtomContext extends ParserRuleContext {
		public List<TermmixedContext> termmixed() {
			return getRuleContexts(TermmixedContext.class);
		}
		public TermmixedContext termmixed(int i) {
			return getRuleContext(TermmixedContext.class,i);
		}
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitAtom(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_atom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393);
			termmixed();
			setState(394);
			match(T__0);
			setState(395);
			termmixed();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermmixedContext extends ParserRuleContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public PathExprContext pathExpr() {
			return getRuleContext(PathExprContext.class,0);
		}
		public TermmixedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termmixed; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterTermmixed(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitTermmixed(this);
		}
	}

	public final TermmixedContext termmixed() throws RecognitionException {
		TermmixedContext _localctx = new TermmixedContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_termmixed);
		try {
			setState(404);
			switch (_input.LA(1)) {
			case STRINGRULE:
			case INTEGER:
				enterOuterAlt(_localctx, 1);
				{
				setState(397);
				constant();
				}
				break;
			case JQ:
			case KQ:
			case RQ:
			case XQ:
			case TQ:
				enterOuterAlt(_localctx, 2);
				{
				setState(398);
				annotation();
				setState(399);
				match(T__3);
				setState(400);
				match(T__4);
				setState(401);
				pathExpr();
				setState(402);
				match(T__5);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public StringConstantContext stringConstant() {
			return getRuleContext(StringConstantContext.class,0);
		}
		public NumericConstantContext numericConstant() {
			return getRuleContext(NumericConstantContext.class,0);
		}
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_constant);
		try {
			setState(408);
			switch (_input.LA(1)) {
			case STRINGRULE:
				enterOuterAlt(_localctx, 1);
				{
				setState(406);
				stringConstant();
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(407);
				numericConstant();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathExprContext extends ParserRuleContext {
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public LookUpExpressionContext lookUpExpression() {
			return getRuleContext(LookUpExpressionContext.class,0);
		}
		public PathExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterPathExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitPathExpr(this);
		}
	}

	public final PathExprContext pathExpr() throws RecognitionException {
		PathExprContext _localctx = new PathExprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_pathExpr);
		try {
			setState(412);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(410);
				path();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(411);
				lookUpExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructorContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public ModelConstructorContext modelConstructor() {
			return getRuleContext(ModelConstructorContext.class,0);
		}
		public ConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitConstructor(this);
		}
	}

	public final ConstructorContext constructor() throws RecognitionException {
		ConstructorContext _localctx = new ConstructorContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_constructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(414);
			annotation();
			setState(415);
			match(T__3);
			setState(416);
			match(T__4);
			setState(417);
			modelConstructor();
			setState(418);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ModelConstructorContext extends ParserRuleContext {
		public JqConstructorContext jqConstructor() {
			return getRuleContext(JqConstructorContext.class,0);
		}
		public KqConstructorContext kqConstructor() {
			return getRuleContext(KqConstructorContext.class,0);
		}
		public XqConstructorContext xqConstructor() {
			return getRuleContext(XqConstructorContext.class,0);
		}
		public ModelConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modelConstructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterModelConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitModelConstructor(this);
		}
	}

	public final ModelConstructorContext modelConstructor() throws RecognitionException {
		ModelConstructorContext _localctx = new ModelConstructorContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_modelConstructor);
		try {
			setState(423);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(420);
				jqConstructor();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(421);
				kqConstructor();
				}
				break;
			case T__20:
				enterOuterAlt(_localctx, 3);
				{
				setState(422);
				xqConstructor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class JqConstructorContext extends ParserRuleContext {
		public RecordConstructContext recordConstruct() {
			return getRuleContext(RecordConstructContext.class,0);
		}
		public JqConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jqConstructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterJqConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitJqConstructor(this);
		}
	}

	public final JqConstructorContext jqConstructor() throws RecognitionException {
		JqConstructorContext _localctx = new JqConstructorContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_jqConstructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(425);
			recordConstruct();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KqConstructorContext extends ParserRuleContext {
		public SelectItemKQLContext selectItemKQL() {
			return getRuleContext(SelectItemKQLContext.class,0);
		}
		public KqConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kqConstructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterKqConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitKqConstructor(this);
		}
	}

	public final KqConstructorContext kqConstructor() throws RecognitionException {
		KqConstructorContext _localctx = new KqConstructorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_kqConstructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			selectItemKQL();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class XqConstructorContext extends ParserRuleContext {
		public FlwrReturnConstructContext flwrReturnConstruct() {
			return getRuleContext(FlwrReturnConstructContext.class,0);
		}
		public XqConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xqConstructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterXqConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitXqConstructor(this);
		}
	}

	public final XqConstructorContext xqConstructor() throws RecognitionException {
		XqConstructorContext _localctx = new XqConstructorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_xqConstructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(429);
			flwrReturnConstruct();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationContext extends ParserRuleContext {
		public TerminalNode JQ() { return getToken(QBTQUERYParser.JQ, 0); }
		public TerminalNode KQ() { return getToken(QBTQUERYParser.KQ, 0); }
		public TerminalNode RQ() { return getToken(QBTQUERYParser.RQ, 0); }
		public TerminalNode XQ() { return getToken(QBTQUERYParser.XQ, 0); }
		public TerminalNode TQ() { return getToken(QBTQUERYParser.TQ, 0); }
		public AnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitAnnotation(this);
		}
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_annotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(431);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << JQ) | (1L << KQ) | (1L << RQ) | (1L << XQ) | (1L << TQ))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringConstantContext extends ParserRuleContext {
		public TerminalNode STRINGRULE() { return getToken(QBTQUERYParser.STRINGRULE, 0); }
		public StringConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterStringConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitStringConstant(this);
		}
	}

	public final StringConstantContext stringConstant() throws RecognitionException {
		StringConstantContext _localctx = new StringConstantContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_stringConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(433);
			match(STRINGRULE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumericConstantContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(QBTQUERYParser.INTEGER, 0); }
		public NumericConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterNumericConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitNumericConstant(this);
		}
	}

	public final NumericConstantContext numericConstant() throws RecognitionException {
		NumericConstantContext _localctx = new NumericConstantContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_numericConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MainMapContext extends ParserRuleContext {
		public TerminalNode MAIN() { return getToken(QBTQUERYParser.MAIN, 0); }
		public TerminalNode INTEGER() { return getToken(QBTQUERYParser.INTEGER, 0); }
		public MainMapContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainMap; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterMainMap(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitMainMap(this);
		}
	}

	public final MainMapContext mainMap() throws RecognitionException {
		MainMapContext _localctx = new MainMapContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_mainMap);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(437);
			match(MAIN);
			setState(438);
			match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KqlqueryContext extends ParserRuleContext {
		public QueryNameContext queryName() {
			return getRuleContext(QueryNameContext.class,0);
		}
		public RedisKQLQueryContext redisKQLQuery() {
			return getRuleContext(RedisKQLQueryContext.class,0);
		}
		public TerminalNode EOF() { return getToken(QBTQUERYParser.EOF, 0); }
		public KqlqueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kqlquery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterKqlquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitKqlquery(this);
		}
	}

	public final KqlqueryContext kqlquery() throws RecognitionException {
		KqlqueryContext _localctx = new KqlqueryContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_kqlquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(440);
			queryName();
			setState(441);
			match(T__0);
			setState(442);
			redisKQLQuery();
			setState(443);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RedisKQLQueryContext extends ParserRuleContext {
		public SfwQueryContext sfwQuery() {
			return getRuleContext(SfwQueryContext.class,0);
		}
		public RedisKQLQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_redisKQLQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterRedisKQLQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitRedisKQLQuery(this);
		}
	}

	public final RedisKQLQueryContext redisKQLQuery() throws RecognitionException {
		RedisKQLQueryContext _localctx = new RedisKQLQueryContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_redisKQLQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(445);
			sfwQuery();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SfwQueryContext extends ParserRuleContext {
		public SelectClasueContext selectClasue() {
			return getRuleContext(SelectClasueContext.class,0);
		}
		public FromClasueContext fromClasue() {
			return getRuleContext(FromClasueContext.class,0);
		}
		public SfwQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sfwQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterSfwQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitSfwQuery(this);
		}
	}

	public final SfwQueryContext sfwQuery() throws RecognitionException {
		SfwQueryContext _localctx = new SfwQueryContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_sfwQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(447);
			selectClasue();
			setState(448);
			fromClasue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectClasueContext extends ParserRuleContext {
		public SelectStatementContext selectStatement() {
			return getRuleContext(SelectStatementContext.class,0);
		}
		public SelectClasueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectClasue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterSelectClasue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitSelectClasue(this);
		}
	}

	public final SelectClasueContext selectClasue() throws RecognitionException {
		SelectClasueContext _localctx = new SelectClasueContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_selectClasue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(450);
			selectStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectStatementContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(QBTQUERYParser.SELECT, 0); }
		public SelectItemKQLContext selectItemKQL() {
			return getRuleContext(SelectItemKQLContext.class,0);
		}
		public SelectStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterSelectStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitSelectStatement(this);
		}
	}

	public final SelectStatementContext selectStatement() throws RecognitionException {
		SelectStatementContext _localctx = new SelectStatementContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_selectStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(452);
			match(SELECT);
			setState(453);
			selectItemKQL();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectItemKQLContext extends ParserRuleContext {
		public ReturnVariableKQLContext returnVariableKQL() {
			return getRuleContext(ReturnVariableKQLContext.class,0);
		}
		public SelectItemKQLContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectItemKQL; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterSelectItemKQL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitSelectItemKQL(this);
		}
	}

	public final SelectItemKQLContext selectItemKQL() throws RecognitionException {
		SelectItemKQLContext _localctx = new SelectItemKQLContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_selectItemKQL);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(455);
			returnVariableKQL();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnVariableKQLContext extends ParserRuleContext {
		public VariableKQLContext variableKQL() {
			return getRuleContext(VariableKQLContext.class,0);
		}
		public ReturnVariableKQLContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnVariableKQL; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterReturnVariableKQL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitReturnVariableKQL(this);
		}
	}

	public final ReturnVariableKQLContext returnVariableKQL() throws RecognitionException {
		ReturnVariableKQLContext _localctx = new ReturnVariableKQLContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_returnVariableKQL);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			variableKQL();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FromClasueContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(QBTQUERYParser.FROM, 0); }
		public List<VarBindingContext> varBinding() {
			return getRuleContexts(VarBindingContext.class);
		}
		public VarBindingContext varBinding(int i) {
			return getRuleContext(VarBindingContext.class,i);
		}
		public FromClasueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fromClasue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterFromClasue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitFromClasue(this);
		}
	}

	public final FromClasueContext fromClasue() throws RecognitionException {
		FromClasueContext _localctx = new FromClasueContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_fromClasue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(459);
			match(FROM);
			setState(460);
			varBinding();
			setState(465);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(461);
				match(T__1);
				setState(462);
				varBinding();
				}
				}
				setState(467);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarBindingContext extends ParserRuleContext {
		public FromvariableBindingContext fromvariableBinding() {
			return getRuleContext(FromvariableBindingContext.class,0);
		}
		public TerminalNode IN() { return getToken(QBTQUERYParser.IN, 0); }
		public SourceKQLContext sourceKQL() {
			return getRuleContext(SourceKQLContext.class,0);
		}
		public VarBindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varBinding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterVarBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitVarBinding(this);
		}
	}

	public final VarBindingContext varBinding() throws RecognitionException {
		VarBindingContext _localctx = new VarBindingContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_varBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(468);
			fromvariableBinding();
			setState(469);
			match(IN);
			setState(470);
			sourceKQL();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FromvariableBindingContext extends ParserRuleContext {
		public VariableKQLContext variableKQL() {
			return getRuleContext(VariableKQLContext.class,0);
		}
		public FromvariableBindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fromvariableBinding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterFromvariableBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitFromvariableBinding(this);
		}
	}

	public final FromvariableBindingContext fromvariableBinding() throws RecognitionException {
		FromvariableBindingContext _localctx = new FromvariableBindingContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_fromvariableBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(472);
			variableKQL();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SourceKQLContext extends ParserRuleContext {
		public LookUpExpressionContext lookUpExpression() {
			return getRuleContext(LookUpExpressionContext.class,0);
		}
		public SourceKQLContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sourceKQL; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterSourceKQL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitSourceKQL(this);
		}
	}

	public final SourceKQLContext sourceKQL() throws RecognitionException {
		SourceKQLContext _localctx = new SourceKQLContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_sourceKQL);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474);
			lookUpExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LookUpExpressionContext extends ParserRuleContext {
		public LookUpExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lookUpExpression; }
	 
		public LookUpExpressionContext() { }
		public void copyFrom(LookUpExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class KeysMapLookUpContext extends LookUpExpressionContext {
		public TerminalNode KEYS() { return getToken(QBTQUERYParser.KEYS, 0); }
		public KeyVariableContext keyVariable() {
			return getRuleContext(KeyVariableContext.class,0);
		}
		public KeysMapLookUpContext(LookUpExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterKeysMapLookUp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitKeysMapLookUp(this);
		}
	}
	public static class VariableMapLookUpContext extends LookUpExpressionContext {
		public MapVariableContext mapVariable() {
			return getRuleContext(MapVariableContext.class,0);
		}
		public List<KeyKQLContext> keyKQL() {
			return getRuleContexts(KeyKQLContext.class);
		}
		public KeyKQLContext keyKQL(int i) {
			return getRuleContext(KeyKQLContext.class,i);
		}
		public VariableMapLookUpContext(LookUpExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterVariableMapLookUp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitVariableMapLookUp(this);
		}
	}
	public static class MainMapLookUpContext extends LookUpExpressionContext {
		public List<KeyKQLContext> keyKQL() {
			return getRuleContexts(KeyKQLContext.class);
		}
		public KeyKQLContext keyKQL(int i) {
			return getRuleContext(KeyKQLContext.class,i);
		}
		public MainMapLookUpContext(LookUpExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterMainMapLookUp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitMainMapLookUp(this);
		}
	}

	public final LookUpExpressionContext lookUpExpression() throws RecognitionException {
		LookUpExpressionContext _localctx = new LookUpExpressionContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_lookUpExpression);
		int _la;
		try {
			setState(507);
			switch (_input.LA(1)) {
			case T__8:
				_localctx = new MainMapLookUpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(476);
				match(T__8);
				setState(477);
				match(T__9);
				setState(478);
				keyKQL();
				setState(479);
				match(T__10);
				setState(486);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(480);
					match(T__9);
					setState(481);
					keyKQL();
					setState(482);
					match(T__10);
					}
					}
					setState(488);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case NAME:
				_localctx = new VariableMapLookUpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(489);
				mapVariable();
				setState(490);
				match(T__9);
				setState(491);
				keyKQL();
				setState(492);
				match(T__10);
				setState(499);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(493);
					match(T__9);
					setState(494);
					keyKQL();
					setState(495);
					match(T__10);
					}
					}
					setState(501);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case KEYS:
				_localctx = new KeysMapLookUpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(502);
				match(KEYS);
				setState(503);
				match(T__9);
				setState(504);
				keyVariable();
				setState(505);
				match(T__10);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MapVariableContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(QBTQUERYParser.NAME, 0); }
		public MapVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterMapVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitMapVariable(this);
		}
	}

	public final MapVariableContext mapVariable() throws RecognitionException {
		MapVariableContext _localctx = new MapVariableContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_mapVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(509);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeyKQLContext extends ParserRuleContext {
		public StringKeyContext stringKey() {
			return getRuleContext(StringKeyContext.class,0);
		}
		public VariableKeyContext variableKey() {
			return getRuleContext(VariableKeyContext.class,0);
		}
		public KeyKQLContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyKQL; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterKeyKQL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitKeyKQL(this);
		}
	}

	public final KeyKQLContext keyKQL() throws RecognitionException {
		KeyKQLContext _localctx = new KeyKQLContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_keyKQL);
		try {
			setState(513);
			switch (_input.LA(1)) {
			case STRINGRULE:
				enterOuterAlt(_localctx, 1);
				{
				setState(511);
				stringKey();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(512);
				variableKey();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringKeyContext extends ParserRuleContext {
		public TerminalNode STRINGRULE() { return getToken(QBTQUERYParser.STRINGRULE, 0); }
		public StringKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterStringKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitStringKey(this);
		}
	}

	public final StringKeyContext stringKey() throws RecognitionException {
		StringKeyContext _localctx = new StringKeyContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_stringKey);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(515);
			match(STRINGRULE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableKeyContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(QBTQUERYParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(QBTQUERYParser.NAME, i);
		}
		public VariableKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterVariableKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitVariableKey(this);
		}
	}

	public final VariableKeyContext variableKey() throws RecognitionException {
		VariableKeyContext _localctx = new VariableKeyContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_variableKey);
		try {
			setState(521);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(517);
				match(NAME);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(518);
				match(NAME);
				setState(519);
				match(T__11);
				setState(520);
				match(NAME);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeyVariableContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(QBTQUERYParser.NAME, 0); }
		public KeyVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterKeyVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitKeyVariable(this);
		}
	}

	public final KeyVariableContext keyVariable() throws RecognitionException {
		KeyVariableContext _localctx = new KeyVariableContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_keyVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(523);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MapNameContext extends ParserRuleContext {
		public MainMapContext mainMap() {
			return getRuleContext(MainMapContext.class,0);
		}
		public VariableKQLContext variableKQL() {
			return getRuleContext(VariableKQLContext.class,0);
		}
		public MapNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterMapName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitMapName(this);
		}
	}

	public final MapNameContext mapName() throws RecognitionException {
		MapNameContext _localctx = new MapNameContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_mapName);
		try {
			setState(527);
			switch (_input.LA(1)) {
			case MAIN:
				enterOuterAlt(_localctx, 1);
				{
				setState(525);
				mainMap();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(526);
				variableKQL();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableKQLContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(QBTQUERYParser.NAME, 0); }
		public VariableKQLContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableKQL; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterVariableKQL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitVariableKQL(this);
		}
	}

	public final VariableKQLContext variableKQL() throws RecognitionException {
		VariableKQLContext _localctx = new VariableKQLContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_variableKQL);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(529);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AqlqueryContext extends ParserRuleContext {
		public QueryNameContext queryName() {
			return getRuleContext(QueryNameContext.class,0);
		}
		public QueryAQLContext queryAQL() {
			return getRuleContext(QueryAQLContext.class,0);
		}
		public RootFieldNameContext rootFieldName() {
			return getRuleContext(RootFieldNameContext.class,0);
		}
		public AqlqueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aqlquery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterAqlquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitAqlquery(this);
		}
	}

	public final AqlqueryContext aqlquery() throws RecognitionException {
		AqlqueryContext _localctx = new AqlqueryContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_aqlquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(531);
			queryName();
			setState(532);
			match(T__0);
			setState(540);
			switch (_input.LA(1)) {
			case T__13:
				{
				setState(533);
				queryAQL();
				}
				break;
			case T__4:
				{
				setState(534);
				match(T__4);
				setState(535);
				rootFieldName();
				setState(536);
				match(T__3);
				setState(537);
				queryAQL();
				setState(538);
				match(T__5);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class QueryAQLContext extends ParserRuleContext {
		public ForClauseContext forClause() {
			return getRuleContext(ForClauseContext.class,0);
		}
		public ReturnClauseContext returnClause() {
			return getRuleContext(ReturnClauseContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public QueryAQLContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_queryAQL; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterQueryAQL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitQueryAQL(this);
		}
	}

	public final QueryAQLContext queryAQL() throws RecognitionException {
		QueryAQLContext _localctx = new QueryAQLContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_queryAQL);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(542);
			forClause();
			setState(544);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(543);
				whereClause();
				}
			}

			setState(546);
			returnClause();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RootFieldNameContext extends ParserRuleContext {
		public FieldNameContext fieldName() {
			return getRuleContext(FieldNameContext.class,0);
		}
		public RootFieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rootFieldName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterRootFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitRootFieldName(this);
		}
	}

	public final RootFieldNameContext rootFieldName() throws RecognitionException {
		RootFieldNameContext _localctx = new RootFieldNameContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_rootFieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(548);
			fieldName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnClauseContext extends ParserRuleContext {
		public RecordConstructContext recordConstruct() {
			return getRuleContext(RecordConstructContext.class,0);
		}
		public ReturnVarContext returnVar() {
			return getRuleContext(ReturnVarContext.class,0);
		}
		public ReturnConstantContext returnConstant() {
			return getRuleContext(ReturnConstantContext.class,0);
		}
		public ReturnClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterReturnClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitReturnClause(this);
		}
	}

	public final ReturnClauseContext returnClause() throws RecognitionException {
		ReturnClauseContext _localctx = new ReturnClauseContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_returnClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			match(T__12);
			setState(554);
			switch (_input.LA(1)) {
			case T__4:
				{
				setState(551);
				recordConstruct();
				}
				break;
			case NAME:
				{
				setState(552);
				returnVar();
				}
				break;
			case STRINGRULE:
			case INTEGER:
				{
				setState(553);
				returnConstant();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RecordConstructContext extends ParserRuleContext {
		public List<FieldBindingContext> fieldBinding() {
			return getRuleContexts(FieldBindingContext.class);
		}
		public FieldBindingContext fieldBinding(int i) {
			return getRuleContext(FieldBindingContext.class,i);
		}
		public RecordConstructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordConstruct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterRecordConstruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitRecordConstruct(this);
		}
	}

	public final RecordConstructContext recordConstruct() throws RecognitionException {
		RecordConstructContext _localctx = new RecordConstructContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_recordConstruct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(556);
			match(T__4);
			setState(557);
			fieldBinding();
			setState(562);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(558);
				match(T__1);
				setState(559);
				fieldBinding();
				}
				}
				setState(564);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(565);
			match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldBindingContext extends ParserRuleContext {
		public RecordConstructFieldNameContext recordConstructFieldName() {
			return getRuleContext(RecordConstructFieldNameContext.class,0);
		}
		public FieldValueContext fieldValue() {
			return getRuleContext(FieldValueContext.class,0);
		}
		public FieldBindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldBinding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterFieldBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitFieldBinding(this);
		}
	}

	public final FieldBindingContext fieldBinding() throws RecognitionException {
		FieldBindingContext _localctx = new FieldBindingContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_fieldBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(567);
			recordConstructFieldName();
			setState(568);
			match(T__3);
			setState(569);
			fieldValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RecordConstructFieldNameContext extends ParserRuleContext {
		public FieldNameContext fieldName() {
			return getRuleContext(FieldNameContext.class,0);
		}
		public RecordConstructFieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_recordConstructFieldName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterRecordConstructFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitRecordConstructFieldName(this);
		}
	}

	public final RecordConstructFieldNameContext recordConstructFieldName() throws RecognitionException {
		RecordConstructFieldNameContext _localctx = new RecordConstructFieldNameContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_recordConstructFieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(571);
			fieldName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldNameContext extends ParserRuleContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public FieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitFieldName(this);
		}
	}

	public final FieldNameContext fieldName() throws RecognitionException {
		FieldNameContext _localctx = new FieldNameContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_fieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(573);
			string();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldValueContext extends ParserRuleContext {
		public RecordConstructContext recordConstruct() {
			return getRuleContext(RecordConstructContext.class,0);
		}
		public ReturnVarContext returnVar() {
			return getRuleContext(ReturnVarContext.class,0);
		}
		public ReturnConstantContext returnConstant() {
			return getRuleContext(ReturnConstantContext.class,0);
		}
		public ReturnQueryContext returnQuery() {
			return getRuleContext(ReturnQueryContext.class,0);
		}
		public FieldValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterFieldValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitFieldValue(this);
		}
	}

	public final FieldValueContext fieldValue() throws RecognitionException {
		FieldValueContext _localctx = new FieldValueContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_fieldValue);
		try {
			setState(579);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(575);
				recordConstruct();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(576);
				returnVar();
				}
				break;
			case STRINGRULE:
			case INTEGER:
				enterOuterAlt(_localctx, 3);
				{
				setState(577);
				returnConstant();
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 4);
				{
				setState(578);
				returnQuery();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnVarContext extends ParserRuleContext {
		public VarAQLContext varAQL() {
			return getRuleContext(VarAQLContext.class,0);
		}
		public VarRQContext varRQ() {
			return getRuleContext(VarRQContext.class,0);
		}
		public ReturnVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterReturnVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitReturnVar(this);
		}
	}

	public final ReturnVarContext returnVar() throws RecognitionException {
		ReturnVarContext _localctx = new ReturnVarContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_returnVar);
		try {
			setState(583);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(581);
				varAQL();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(582);
				varRQ();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarRQContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode NAME() { return getToken(QBTQUERYParser.NAME, 0); }
		public VarRQContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varRQ; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterVarRQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitVarRQ(this);
		}
	}

	public final VarRQContext varRQ() throws RecognitionException {
		VarRQContext _localctx = new VarRQContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_varRQ);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(585);
			name();
			setState(586);
			match(T__11);
			setState(587);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(QBTQUERYParser.NAME, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitName(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(589);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnConstantContext extends ParserRuleContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public ReturnConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterReturnConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitReturnConstant(this);
		}
	}

	public final ReturnConstantContext returnConstant() throws RecognitionException {
		ReturnConstantContext _localctx = new ReturnConstantContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_returnConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(591);
			constant();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReturnQueryContext extends ParserRuleContext {
		public QueryAQLContext queryAQL() {
			return getRuleContext(QueryAQLContext.class,0);
		}
		public ReturnQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterReturnQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitReturnQuery(this);
		}
	}

	public final ReturnQueryContext returnQuery() throws RecognitionException {
		ReturnQueryContext _localctx = new ReturnQueryContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_returnQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(593);
			queryAQL();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public TermConstantContext termConstant() {
			return getRuleContext(TermConstantContext.class,0);
		}
		public TermVarContext termVar() {
			return getRuleContext(TermVarContext.class,0);
		}
		public TermPathContext termPath() {
			return getRuleContext(TermPathContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_term);
		try {
			setState(598);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(595);
				termConstant();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(596);
				termVar();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(597);
				termPath();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermVarContext extends ParserRuleContext {
		public VarAQLContext varAQL() {
			return getRuleContext(VarAQLContext.class,0);
		}
		public TermVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterTermVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitTermVar(this);
		}
	}

	public final TermVarContext termVar() throws RecognitionException {
		TermVarContext _localctx = new TermVarContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_termVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(600);
			varAQL();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermConstantContext extends ParserRuleContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public TermConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterTermConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitTermConstant(this);
		}
	}

	public final TermConstantContext termConstant() throws RecognitionException {
		TermConstantContext _localctx = new TermConstantContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_termConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(602);
			constant();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TermPathContext extends ParserRuleContext {
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public TermPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterTermPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitTermPath(this);
		}
	}

	public final TermPathContext termPath() throws RecognitionException {
		TermPathContext _localctx = new TermPathContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_termPath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(604);
			path();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode BETA() { return getToken(QBTQUERYParser.BETA, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitNumber(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(606);
			match(BETA);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StringContext extends ParserRuleContext {
		public TerminalNode STRINGRULE() { return getToken(QBTQUERYParser.STRINGRULE, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitString(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(608);
			match(STRINGRULE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathContext extends ParserRuleContext {
		public PathVarContext pathVar() {
			return getRuleContext(PathVarContext.class,0);
		}
		public List<StepContext> step() {
			return getRuleContexts(StepContext.class);
		}
		public StepContext step(int i) {
			return getRuleContext(StepContext.class,i);
		}
		public PathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_path; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitPath(this);
		}
	}

	public final PathContext path() throws RecognitionException {
		PathContext _localctx = new PathContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_path);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(610);
			pathVar();
			setState(612); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(611);
					step();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(614); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PathVarContext extends ParserRuleContext {
		public VarAQLContext varAQL() {
			return getRuleContext(VarAQLContext.class,0);
		}
		public PathVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterPathVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitPathVar(this);
		}
	}

	public final PathVarContext pathVar() throws RecognitionException {
		PathVarContext _localctx = new PathVarContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_pathVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(616);
			varAQL();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarAQLContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(QBTQUERYParser.NAME, 0); }
		public VarAQLContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varAQL; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterVarAQL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitVarAQL(this);
		}
	}

	public final VarAQLContext varAQL() throws RecognitionException {
		VarAQLContext _localctx = new VarAQLContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_varAQL);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(618);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StepContext extends ParserRuleContext {
		public ObjectStepContext objectStep() {
			return getRuleContext(ObjectStepContext.class,0);
		}
		public ArrayStepContext arrayStep() {
			return getRuleContext(ArrayStepContext.class,0);
		}
		public StepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_step; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterStep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitStep(this);
		}
	}

	public final StepContext step() throws RecognitionException {
		StepContext _localctx = new StepContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_step);
		try {
			setState(622);
			switch (_input.LA(1)) {
			case T__11:
				enterOuterAlt(_localctx, 1);
				{
				setState(620);
				objectStep();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(621);
				arrayStep();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectStepContext extends ParserRuleContext {
		public KeyAQLContext keyAQL() {
			return getRuleContext(KeyAQLContext.class,0);
		}
		public ObjectStepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectStep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterObjectStep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitObjectStep(this);
		}
	}

	public final ObjectStepContext objectStep() throws RecognitionException {
		ObjectStepContext _localctx = new ObjectStepContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_objectStep);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(624);
			match(T__11);
			setState(625);
			keyAQL();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayStepContext extends ParserRuleContext {
		public IndexContext index() {
			return getRuleContext(IndexContext.class,0);
		}
		public ArrayStepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayStep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterArrayStep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitArrayStep(this);
		}
	}

	public final ArrayStepContext arrayStep() throws RecognitionException {
		ArrayStepContext _localctx = new ArrayStepContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_arrayStep);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(627);
			match(T__9);
			setState(628);
			index();
			setState(629);
			match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeyAQLContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(QBTQUERYParser.NAME, 0); }
		public KeyAQLContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyAQL; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterKeyAQL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitKeyAQL(this);
		}
	}

	public final KeyAQLContext keyAQL() throws RecognitionException {
		KeyAQLContext _localctx = new KeyAQLContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_keyAQL);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(631);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IndexContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public IndexContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_index; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitIndex(this);
		}
	}

	public final IndexContext index() throws RecognitionException {
		IndexContext _localctx = new IndexContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_index);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(633);
			number();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForClauseContext extends ParserRuleContext {
		public List<BindingContext> binding() {
			return getRuleContexts(BindingContext.class);
		}
		public BindingContext binding(int i) {
			return getRuleContext(BindingContext.class,i);
		}
		public ForClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterForClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitForClause(this);
		}
	}

	public final ForClauseContext forClause() throws RecognitionException {
		ForClauseContext _localctx = new ForClauseContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_forClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(635);
			match(T__13);
			setState(636);
			binding();
			setState(641);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(637);
				match(T__1);
				setState(638);
				binding();
				}
				}
				setState(643);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FormixedContext extends ParserRuleContext {
		public List<ForClauseBindingVarContext> forClauseBindingVar() {
			return getRuleContexts(ForClauseBindingVarContext.class);
		}
		public ForClauseBindingVarContext forClauseBindingVar(int i) {
			return getRuleContext(ForClauseBindingVarContext.class,i);
		}
		public List<ForClauseBindingSourceContext> forClauseBindingSource() {
			return getRuleContexts(ForClauseBindingSourceContext.class);
		}
		public ForClauseBindingSourceContext forClauseBindingSource(int i) {
			return getRuleContext(ForClauseBindingSourceContext.class,i);
		}
		public FormixedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formixed; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterFormixed(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitFormixed(this);
		}
	}

	public final FormixedContext formixed() throws RecognitionException {
		FormixedContext _localctx = new FormixedContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_formixed);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(644);
			forClauseBindingVar();
			setState(645);
			match(T__14);
			setState(646);
			forClauseBindingSource();
			setState(654);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(647);
				match(T__1);
				setState(648);
				forClauseBindingVar();
				setState(649);
				match(T__14);
				setState(650);
				forClauseBindingSource();
				}
				}
				setState(656);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BindingContext extends ParserRuleContext {
		public ForClauseBindingVarContext forClauseBindingVar() {
			return getRuleContext(ForClauseBindingVarContext.class,0);
		}
		public ForClauseBindingSourceContext forClauseBindingSource() {
			return getRuleContext(ForClauseBindingSourceContext.class,0);
		}
		public BindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitBinding(this);
		}
	}

	public final BindingContext binding() throws RecognitionException {
		BindingContext _localctx = new BindingContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_binding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(657);
			forClauseBindingVar();
			setState(658);
			match(T__14);
			setState(659);
			forClauseBindingSource();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForClauseBindingVarContext extends ParserRuleContext {
		public VarAQLContext varAQL() {
			return getRuleContext(VarAQLContext.class,0);
		}
		public ForClauseBindingVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forClauseBindingVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterForClauseBindingVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitForClauseBindingVar(this);
		}
	}

	public final ForClauseBindingVarContext forClauseBindingVar() throws RecognitionException {
		ForClauseBindingVarContext _localctx = new ForClauseBindingVarContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_forClauseBindingVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(661);
			varAQL();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ForClauseBindingSourceContext extends ParserRuleContext {
		public SourceAQLContext sourceAQL() {
			return getRuleContext(SourceAQLContext.class,0);
		}
		public ForClauseBindingSourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forClauseBindingSource; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterForClauseBindingSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitForClauseBindingSource(this);
		}
	}

	public final ForClauseBindingSourceContext forClauseBindingSource() throws RecognitionException {
		ForClauseBindingSourceContext _localctx = new ForClauseBindingSourceContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_forClauseBindingSource);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(663);
			sourceAQL();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SourceAQLContext extends ParserRuleContext {
		public DataSetNameContext dataSetName() {
			return getRuleContext(DataSetNameContext.class,0);
		}
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public SourceAQLContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sourceAQL; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterSourceAQL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitSourceAQL(this);
		}
	}

	public final SourceAQLContext sourceAQL() throws RecognitionException {
		SourceAQLContext _localctx = new SourceAQLContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_sourceAQL);
		try {
			setState(668);
			switch (_input.LA(1)) {
			case T__15:
				enterOuterAlt(_localctx, 1);
				{
				setState(665);
				match(T__15);
				setState(666);
				dataSetName();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(667);
				path();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DataSetNameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(QBTQUERYParser.NAME, 0); }
		public DataSetNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataSetName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterDataSetName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitDataSetName(this);
		}
	}

	public final DataSetNameContext dataSetName() throws RecognitionException {
		DataSetNameContext _localctx = new DataSetNameContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_dataSetName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(670);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhereClauseContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public WhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitWhereClause(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(672);
			match(T__16);
			setState(673);
			condition(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public WhereCondSomeContext whereCondSome() {
			return getRuleContext(WhereCondSomeContext.class,0);
		}
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public WhereCondEqualityContext whereCondEquality() {
			return getRuleContext(WhereCondEqualityContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitCondition(this);
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
		int _startState = 164;
		enterRecursionRule(_localctx, 164, RULE_condition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(686);
			switch (_input.LA(1)) {
			case T__18:
				{
				setState(676);
				match(T__18);
				setState(677);
				whereCondSome();
				setState(678);
				match(T__19);
				setState(679);
				condition(2);
				}
				break;
			case NAME:
			case STRINGRULE:
			case INTEGER:
				{
				setState(681);
				whereCondEquality();
				}
				break;
			case T__6:
				{
				setState(682);
				match(T__6);
				setState(683);
				condition(0);
				setState(684);
				match(T__7);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(693);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConditionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_condition);
					setState(688);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(689);
					match(T__17);
					setState(690);
					condition(4);
					}
					} 
				}
				setState(695);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class WhereCondSomeContext extends ParserRuleContext {
		public List<WhereCondBindingContext> whereCondBinding() {
			return getRuleContexts(WhereCondBindingContext.class);
		}
		public WhereCondBindingContext whereCondBinding(int i) {
			return getRuleContext(WhereCondBindingContext.class,i);
		}
		public WhereCondSomeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereCondSome; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterWhereCondSome(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitWhereCondSome(this);
		}
	}

	public final WhereCondSomeContext whereCondSome() throws RecognitionException {
		WhereCondSomeContext _localctx = new WhereCondSomeContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_whereCondSome);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(696);
			whereCondBinding();
			setState(701);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(697);
				match(T__1);
				setState(698);
				whereCondBinding();
				}
				}
				setState(703);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhereCondBindingContext extends ParserRuleContext {
		public WhereCondBindingVarContext whereCondBindingVar() {
			return getRuleContext(WhereCondBindingVarContext.class,0);
		}
		public WhereCondBindingSourceContext whereCondBindingSource() {
			return getRuleContext(WhereCondBindingSourceContext.class,0);
		}
		public WhereCondBindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereCondBinding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterWhereCondBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitWhereCondBinding(this);
		}
	}

	public final WhereCondBindingContext whereCondBinding() throws RecognitionException {
		WhereCondBindingContext _localctx = new WhereCondBindingContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_whereCondBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(704);
			whereCondBindingVar();
			setState(705);
			match(T__14);
			setState(706);
			whereCondBindingSource();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhereCondBindingVarContext extends ParserRuleContext {
		public VarAQLContext varAQL() {
			return getRuleContext(VarAQLContext.class,0);
		}
		public WhereCondBindingVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereCondBindingVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterWhereCondBindingVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitWhereCondBindingVar(this);
		}
	}

	public final WhereCondBindingVarContext whereCondBindingVar() throws RecognitionException {
		WhereCondBindingVarContext _localctx = new WhereCondBindingVarContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_whereCondBindingVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(708);
			varAQL();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhereCondBindingSourceContext extends ParserRuleContext {
		public SourceAQLContext sourceAQL() {
			return getRuleContext(SourceAQLContext.class,0);
		}
		public WhereCondBindingSourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereCondBindingSource; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterWhereCondBindingSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitWhereCondBindingSource(this);
		}
	}

	public final WhereCondBindingSourceContext whereCondBindingSource() throws RecognitionException {
		WhereCondBindingSourceContext _localctx = new WhereCondBindingSourceContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_whereCondBindingSource);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(710);
			sourceAQL();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhereCondEqualityContext extends ParserRuleContext {
		public WhereCondEqualityLeftTermContext whereCondEqualityLeftTerm() {
			return getRuleContext(WhereCondEqualityLeftTermContext.class,0);
		}
		public WhereCondEqualityRightTermContext whereCondEqualityRightTerm() {
			return getRuleContext(WhereCondEqualityRightTermContext.class,0);
		}
		public WhereCondEqualityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereCondEquality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterWhereCondEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitWhereCondEquality(this);
		}
	}

	public final WhereCondEqualityContext whereCondEquality() throws RecognitionException {
		WhereCondEqualityContext _localctx = new WhereCondEqualityContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_whereCondEquality);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(712);
			whereCondEqualityLeftTerm();
			setState(713);
			match(T__0);
			setState(714);
			whereCondEqualityRightTerm();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhereCondEqualityLeftTermContext extends ParserRuleContext {
		public CtermContext cterm() {
			return getRuleContext(CtermContext.class,0);
		}
		public WhereCondEqualityLeftTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereCondEqualityLeftTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterWhereCondEqualityLeftTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitWhereCondEqualityLeftTerm(this);
		}
	}

	public final WhereCondEqualityLeftTermContext whereCondEqualityLeftTerm() throws RecognitionException {
		WhereCondEqualityLeftTermContext _localctx = new WhereCondEqualityLeftTermContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_whereCondEqualityLeftTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(716);
			cterm();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhereCondEqualityRightTermContext extends ParserRuleContext {
		public CtermContext cterm() {
			return getRuleContext(CtermContext.class,0);
		}
		public WhereCondEqualityRightTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereCondEqualityRightTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterWhereCondEqualityRightTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitWhereCondEqualityRightTerm(this);
		}
	}

	public final WhereCondEqualityRightTermContext whereCondEqualityRightTerm() throws RecognitionException {
		WhereCondEqualityRightTermContext _localctx = new WhereCondEqualityRightTermContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_whereCondEqualityRightTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(718);
			cterm();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CtermContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public CtermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cterm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterCterm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitCterm(this);
		}
	}

	public final CtermContext cterm() throws RecognitionException {
		CtermContext _localctx = new CtermContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_cterm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(720);
			term();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class XqueryContext extends ParserRuleContext {
		public QueryNameContext queryName() {
			return getRuleContext(QueryNameContext.class,0);
		}
		public FlwrContext flwr() {
			return getRuleContext(FlwrContext.class,0);
		}
		public OpenRootTagContext openRootTag() {
			return getRuleContext(OpenRootTagContext.class,0);
		}
		public CloseRootTagContext closeRootTag() {
			return getRuleContext(CloseRootTagContext.class,0);
		}
		public XqueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_xquery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterXquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitXquery(this);
		}
	}

	public final XqueryContext xquery() throws RecognitionException {
		XqueryContext _localctx = new XqueryContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_xquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(722);
			queryName();
			setState(723);
			match(T__0);
			setState(735);
			switch (_input.LA(1)) {
			case T__13:
				{
				setState(724);
				flwr();
				}
				break;
			case T__20:
				{
				setState(725);
				match(T__20);
				setState(726);
				openRootTag();
				setState(727);
				match(T__21);
				setState(728);
				match(T__4);
				setState(729);
				flwr();
				setState(730);
				match(T__5);
				setState(731);
				match(T__22);
				setState(732);
				closeRootTag();
				setState(733);
				match(T__21);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OpenRootTagContext extends ParserRuleContext {
		public TagContext tag() {
			return getRuleContext(TagContext.class,0);
		}
		public OpenRootTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_openRootTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterOpenRootTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitOpenRootTag(this);
		}
	}

	public final OpenRootTagContext openRootTag() throws RecognitionException {
		OpenRootTagContext _localctx = new OpenRootTagContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_openRootTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(737);
			tag();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CloseRootTagContext extends ParserRuleContext {
		public TagContext tag() {
			return getRuleContext(TagContext.class,0);
		}
		public CloseRootTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closeRootTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterCloseRootTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitCloseRootTag(this);
		}
	}

	public final CloseRootTagContext closeRootTag() throws RecognitionException {
		CloseRootTagContext _localctx = new CloseRootTagContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_closeRootTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(739);
			tag();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructContext extends ParserRuleContext {
		public ConstructEmptyTagContext constructEmptyTag() {
			return getRuleContext(ConstructEmptyTagContext.class,0);
		}
		public ConstructStringContext constructString() {
			return getRuleContext(ConstructStringContext.class,0);
		}
		public ConstructVarContext constructVar() {
			return getRuleContext(ConstructVarContext.class,0);
		}
		public ConstructFlwrContext constructFlwr() {
			return getRuleContext(ConstructFlwrContext.class,0);
		}
		public ConstructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_construct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterConstruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitConstruct(this);
		}
	}

	public final ConstructContext construct() throws RecognitionException {
		ConstructContext _localctx = new ConstructContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_construct);
		try {
			setState(745);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(741);
				constructEmptyTag();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(742);
				constructString();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(743);
				constructVar();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(744);
				constructFlwr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructEmptyTagContext extends ParserRuleContext {
		public TagContext tag() {
			return getRuleContext(TagContext.class,0);
		}
		public ConstructDelimeterContext constructDelimeter() {
			return getRuleContext(ConstructDelimeterContext.class,0);
		}
		public MkattrContext mkattr() {
			return getRuleContext(MkattrContext.class,0);
		}
		public ConstructEmptyTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructEmptyTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterConstructEmptyTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitConstructEmptyTag(this);
		}
	}

	public final ConstructEmptyTagContext constructEmptyTag() throws RecognitionException {
		ConstructEmptyTagContext _localctx = new ConstructEmptyTagContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_constructEmptyTag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(747);
			match(T__20);
			setState(748);
			tag();
			setState(750);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(749);
				mkattr();
				}
			}

			setState(752);
			match(T__23);
			setState(753);
			constructDelimeter();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructStringContext extends ParserRuleContext {
		public List<TagContext> tag() {
			return getRuleContexts(TagContext.class);
		}
		public TagContext tag(int i) {
			return getRuleContext(TagContext.class,i);
		}
		public ConstructDelimeterContext constructDelimeter() {
			return getRuleContext(ConstructDelimeterContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public MkattrContext mkattr() {
			return getRuleContext(MkattrContext.class,0);
		}
		public ConstructStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterConstructString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitConstructString(this);
		}
	}

	public final ConstructStringContext constructString() throws RecognitionException {
		ConstructStringContext _localctx = new ConstructStringContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_constructString);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(755);
			match(T__20);
			setState(756);
			tag();
			setState(758);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(757);
				mkattr();
				}
			}

			setState(760);
			match(T__21);
			setState(761);
			constructDelimeter();
			setState(762);
			string();
			setState(763);
			match(T__22);
			setState(764);
			tag();
			setState(765);
			match(T__21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructVarContext extends ParserRuleContext {
		public List<TagContext> tag() {
			return getRuleContexts(TagContext.class);
		}
		public TagContext tag(int i) {
			return getRuleContext(TagContext.class,i);
		}
		public ConstructDelimeterContext constructDelimeter() {
			return getRuleContext(ConstructDelimeterContext.class,0);
		}
		public VarXQContext varXQ() {
			return getRuleContext(VarXQContext.class,0);
		}
		public MkattrContext mkattr() {
			return getRuleContext(MkattrContext.class,0);
		}
		public ConstructVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterConstructVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitConstructVar(this);
		}
	}

	public final ConstructVarContext constructVar() throws RecognitionException {
		ConstructVarContext _localctx = new ConstructVarContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_constructVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(767);
			match(T__20);
			setState(768);
			tag();
			setState(770);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(769);
				mkattr();
				}
			}

			setState(772);
			match(T__21);
			setState(773);
			constructDelimeter();
			setState(774);
			match(T__4);
			setState(775);
			varXQ();
			setState(776);
			match(T__5);
			setState(777);
			match(T__22);
			setState(778);
			tag();
			setState(779);
			match(T__21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructFlwrContext extends ParserRuleContext {
		public ConstructFlwrOpenTagContext constructFlwrOpenTag() {
			return getRuleContext(ConstructFlwrOpenTagContext.class,0);
		}
		public ConstructDelimeterContext constructDelimeter() {
			return getRuleContext(ConstructDelimeterContext.class,0);
		}
		public List<ConstructFlwrTermContext> constructFlwrTerm() {
			return getRuleContexts(ConstructFlwrTermContext.class);
		}
		public ConstructFlwrTermContext constructFlwrTerm(int i) {
			return getRuleContext(ConstructFlwrTermContext.class,i);
		}
		public ConstructFlwrCloseTagContext constructFlwrCloseTag() {
			return getRuleContext(ConstructFlwrCloseTagContext.class,0);
		}
		public MkattrContext mkattr() {
			return getRuleContext(MkattrContext.class,0);
		}
		public ConstructFlwrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructFlwr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterConstructFlwr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitConstructFlwr(this);
		}
	}

	public final ConstructFlwrContext constructFlwr() throws RecognitionException {
		ConstructFlwrContext _localctx = new ConstructFlwrContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_constructFlwr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(781);
			match(T__20);
			setState(782);
			constructFlwrOpenTag();
			setState(784);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(783);
				mkattr();
				}
			}

			setState(786);
			match(T__21);
			setState(787);
			constructDelimeter();
			setState(788);
			constructFlwrTerm();
			setState(793);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(789);
				match(T__1);
				setState(790);
				constructFlwrTerm();
				}
				}
				setState(795);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(796);
			match(T__22);
			setState(797);
			constructFlwrCloseTag();
			setState(798);
			match(T__21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructFlwrTermContext extends ParserRuleContext {
		public FlwrContext flwr() {
			return getRuleContext(FlwrContext.class,0);
		}
		public ConstructContext construct() {
			return getRuleContext(ConstructContext.class,0);
		}
		public ConstructFlwrTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructFlwrTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterConstructFlwrTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitConstructFlwrTerm(this);
		}
	}

	public final ConstructFlwrTermContext constructFlwrTerm() throws RecognitionException {
		ConstructFlwrTermContext _localctx = new ConstructFlwrTermContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_constructFlwrTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(805);
			switch (_input.LA(1)) {
			case T__4:
				{
				setState(800);
				match(T__4);
				setState(801);
				flwr();
				setState(802);
				match(T__5);
				}
				break;
			case T__20:
				{
				setState(804);
				construct();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructDelimeterContext extends ParserRuleContext {
		public ConstructDelimeterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructDelimeter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterConstructDelimeter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitConstructDelimeter(this);
		}
	}

	public final ConstructDelimeterContext constructDelimeter() throws RecognitionException {
		ConstructDelimeterContext _localctx = new ConstructDelimeterContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_constructDelimeter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructFlwrOpenTagContext extends ParserRuleContext {
		public TagContext tag() {
			return getRuleContext(TagContext.class,0);
		}
		public ConstructFlwrOpenTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructFlwrOpenTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterConstructFlwrOpenTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitConstructFlwrOpenTag(this);
		}
	}

	public final ConstructFlwrOpenTagContext constructFlwrOpenTag() throws RecognitionException {
		ConstructFlwrOpenTagContext _localctx = new ConstructFlwrOpenTagContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_constructFlwrOpenTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(809);
			tag();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstructFlwrCloseTagContext extends ParserRuleContext {
		public TagContext tag() {
			return getRuleContext(TagContext.class,0);
		}
		public ConstructFlwrCloseTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructFlwrCloseTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterConstructFlwrCloseTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitConstructFlwrCloseTag(this);
		}
	}

	public final ConstructFlwrCloseTagContext constructFlwrCloseTag() throws RecognitionException {
		ConstructFlwrCloseTagContext _localctx = new ConstructFlwrCloseTagContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_constructFlwrCloseTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(811);
			tag();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TagContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(QBTQUERYParser.NAME, 0); }
		public TagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitTag(this);
		}
	}

	public final TagContext tag() throws RecognitionException {
		TagContext _localctx = new TagContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_tag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(813);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MkattrContext extends ParserRuleContext {
		public List<MkattrNameContext> mkattrName() {
			return getRuleContexts(MkattrNameContext.class);
		}
		public MkattrNameContext mkattrName(int i) {
			return getRuleContext(MkattrNameContext.class,i);
		}
		public List<AtermContext> aterm() {
			return getRuleContexts(AtermContext.class);
		}
		public AtermContext aterm(int i) {
			return getRuleContext(AtermContext.class,i);
		}
		public MkattrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mkattr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterMkattr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitMkattr(this);
		}
	}

	public final MkattrContext mkattr() throws RecognitionException {
		MkattrContext _localctx = new MkattrContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_mkattr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(815);
			match(T__9);
			setState(816);
			mkattrName();
			setState(817);
			match(T__0);
			setState(818);
			aterm();
			setState(826);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(819);
				match(T__1);
				setState(820);
				mkattrName();
				setState(821);
				match(T__0);
				setState(822);
				aterm();
				}
				}
				setState(828);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(829);
			match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MkattrNameContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public MkattrNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mkattrName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterMkattrName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitMkattrName(this);
		}
	}

	public final MkattrNameContext mkattrName() throws RecognitionException {
		MkattrNameContext _localctx = new MkattrNameContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_mkattrName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(831);
			name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtermContext extends ParserRuleContext {
		public AtermVarContext atermVar() {
			return getRuleContext(AtermVarContext.class,0);
		}
		public AtermStringContext atermString() {
			return getRuleContext(AtermStringContext.class,0);
		}
		public AtermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aterm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterAterm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitAterm(this);
		}
	}

	public final AtermContext aterm() throws RecognitionException {
		AtermContext _localctx = new AtermContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_aterm);
		try {
			setState(838);
			switch (_input.LA(1)) {
			case T__4:
				enterOuterAlt(_localctx, 1);
				{
				setState(833);
				match(T__4);
				setState(834);
				atermVar();
				setState(835);
				match(T__5);
				}
				break;
			case STRINGRULE:
				enterOuterAlt(_localctx, 2);
				{
				setState(837);
				atermString();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtermVarContext extends ParserRuleContext {
		public VarXQContext varXQ() {
			return getRuleContext(VarXQContext.class,0);
		}
		public AtermVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atermVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterAtermVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitAtermVar(this);
		}
	}

	public final AtermVarContext atermVar() throws RecognitionException {
		AtermVarContext _localctx = new AtermVarContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_atermVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(840);
			varXQ();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AtermStringContext extends ParserRuleContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public AtermStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atermString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterAtermString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitAtermString(this);
		}
	}

	public final AtermStringContext atermString() throws RecognitionException {
		AtermStringContext _localctx = new AtermStringContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_atermString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(842);
			string();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarXQContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(QBTQUERYParser.NAME, 0); }
		public VarXQContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varXQ; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterVarXQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitVarXQ(this);
		}
	}

	public final VarXQContext varXQ() throws RecognitionException {
		VarXQContext _localctx = new VarXQContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_varXQ);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(844);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FlwrContext extends ParserRuleContext {
		public FlwrForWhereContext flwrForWhere() {
			return getRuleContext(FlwrForWhereContext.class,0);
		}
		public FlwrReturnContext flwrReturn() {
			return getRuleContext(FlwrReturnContext.class,0);
		}
		public FlwrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flwr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterFlwr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitFlwr(this);
		}
	}

	public final FlwrContext flwr() throws RecognitionException {
		FlwrContext _localctx = new FlwrContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_flwr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(846);
			flwrForWhere();
			setState(847);
			flwrReturn();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FlwrForContext extends ParserRuleContext {
		public List<FlwrForVarContext> flwrForVar() {
			return getRuleContexts(FlwrForVarContext.class);
		}
		public FlwrForVarContext flwrForVar(int i) {
			return getRuleContext(FlwrForVarContext.class,i);
		}
		public List<FlwrForPContext> flwrForP() {
			return getRuleContexts(FlwrForPContext.class);
		}
		public FlwrForPContext flwrForP(int i) {
			return getRuleContext(FlwrForPContext.class,i);
		}
		public FlwrForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flwrFor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterFlwrFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitFlwrFor(this);
		}
	}

	public final FlwrForContext flwrFor() throws RecognitionException {
		FlwrForContext _localctx = new FlwrForContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_flwrFor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(849);
			match(T__13);
			setState(850);
			flwrForVar();
			setState(851);
			match(T__14);
			setState(852);
			flwrForP();
			setState(860);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(853);
				match(T__1);
				setState(854);
				flwrForVar();
				setState(855);
				match(T__14);
				setState(856);
				flwrForP();
				}
				}
				setState(862);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FlwrWhereContext extends ParserRuleContext {
		public FlwrWhereCondContext flwrWhereCond() {
			return getRuleContext(FlwrWhereCondContext.class,0);
		}
		public FlwrWhereContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flwrWhere; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterFlwrWhere(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitFlwrWhere(this);
		}
	}

	public final FlwrWhereContext flwrWhere() throws RecognitionException {
		FlwrWhereContext _localctx = new FlwrWhereContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_flwrWhere);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(863);
			match(T__16);
			setState(864);
			flwrWhereCond(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FlwrForWhereContext extends ParserRuleContext {
		public FlwrForContext flwrFor() {
			return getRuleContext(FlwrForContext.class,0);
		}
		public FlwrWhereContext flwrWhere() {
			return getRuleContext(FlwrWhereContext.class,0);
		}
		public FlwrForWhereContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flwrForWhere; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterFlwrForWhere(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitFlwrForWhere(this);
		}
	}

	public final FlwrForWhereContext flwrForWhere() throws RecognitionException {
		FlwrForWhereContext _localctx = new FlwrForWhereContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_flwrForWhere);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(866);
			flwrFor();
			setState(868);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(867);
				flwrWhere();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FlwrReturnContext extends ParserRuleContext {
		public FlwrReturnVarContext flwrReturnVar() {
			return getRuleContext(FlwrReturnVarContext.class,0);
		}
		public FlwrReturnStringContext flwrReturnString() {
			return getRuleContext(FlwrReturnStringContext.class,0);
		}
		public FlwrReturnConstructContext flwrReturnConstruct() {
			return getRuleContext(FlwrReturnConstructContext.class,0);
		}
		public FlwrReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flwrReturn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterFlwrReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitFlwrReturn(this);
		}
	}

	public final FlwrReturnContext flwrReturn() throws RecognitionException {
		FlwrReturnContext _localctx = new FlwrReturnContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_flwrReturn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(870);
			match(T__12);
			setState(874);
			switch (_input.LA(1)) {
			case NAME:
				{
				setState(871);
				flwrReturnVar();
				}
				break;
			case STRINGRULE:
				{
				setState(872);
				flwrReturnString();
				}
				break;
			case T__20:
				{
				setState(873);
				flwrReturnConstruct();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FlwrForVarContext extends ParserRuleContext {
		public VarXQContext varXQ() {
			return getRuleContext(VarXQContext.class,0);
		}
		public FlwrForVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flwrForVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterFlwrForVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitFlwrForVar(this);
		}
	}

	public final FlwrForVarContext flwrForVar() throws RecognitionException {
		FlwrForVarContext _localctx = new FlwrForVarContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_flwrForVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(876);
			varXQ();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FlwrForPContext extends ParserRuleContext {
		public PContext p() {
			return getRuleContext(PContext.class,0);
		}
		public FlwrForPContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flwrForP; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterFlwrForP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitFlwrForP(this);
		}
	}

	public final FlwrForPContext flwrForP() throws RecognitionException {
		FlwrForPContext _localctx = new FlwrForPContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_flwrForP);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(878);
			p();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FlwrWhereCondContext extends ParserRuleContext {
		public FlwrWhereCondSomeContext flwrWhereCondSome() {
			return getRuleContext(FlwrWhereCondSomeContext.class,0);
		}
		public List<FlwrWhereCondContext> flwrWhereCond() {
			return getRuleContexts(FlwrWhereCondContext.class);
		}
		public FlwrWhereCondContext flwrWhereCond(int i) {
			return getRuleContext(FlwrWhereCondContext.class,i);
		}
		public FlwrWhereCondEqualityContext flwrWhereCondEquality() {
			return getRuleContext(FlwrWhereCondEqualityContext.class,0);
		}
		public FlwrWhereCondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flwrWhereCond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterFlwrWhereCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitFlwrWhereCond(this);
		}
	}

	public final FlwrWhereCondContext flwrWhereCond() throws RecognitionException {
		return flwrWhereCond(0);
	}

	private FlwrWhereCondContext flwrWhereCond(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FlwrWhereCondContext _localctx = new FlwrWhereCondContext(_ctx, _parentState);
		FlwrWhereCondContext _prevctx = _localctx;
		int _startState = 234;
		enterRecursionRule(_localctx, 234, RULE_flwrWhereCond, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(890);
			switch (_input.LA(1)) {
			case T__18:
				{
				setState(881);
				flwrWhereCondSome();
				setState(882);
				match(T__19);
				setState(883);
				flwrWhereCond(1);
				}
				break;
			case NAME:
			case STRINGRULE:
			case INTEGER:
				{
				setState(885);
				flwrWhereCondEquality();
				}
				break;
			case T__6:
				{
				setState(886);
				match(T__6);
				setState(887);
				flwrWhereCond(0);
				setState(888);
				match(T__7);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(897);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new FlwrWhereCondContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_flwrWhereCond);
					setState(892);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(893);
					match(T__17);
					setState(894);
					flwrWhereCond(3);
					}
					} 
				}
				setState(899);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FlwrWhereCondSomeContext extends ParserRuleContext {
		public List<FlwrWhereCondVarContext> flwrWhereCondVar() {
			return getRuleContexts(FlwrWhereCondVarContext.class);
		}
		public FlwrWhereCondVarContext flwrWhereCondVar(int i) {
			return getRuleContext(FlwrWhereCondVarContext.class,i);
		}
		public List<FlwrWhereCondApContext> flwrWhereCondAp() {
			return getRuleContexts(FlwrWhereCondApContext.class);
		}
		public FlwrWhereCondApContext flwrWhereCondAp(int i) {
			return getRuleContext(FlwrWhereCondApContext.class,i);
		}
		public FlwrWhereCondSomeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flwrWhereCondSome; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterFlwrWhereCondSome(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitFlwrWhereCondSome(this);
		}
	}

	public final FlwrWhereCondSomeContext flwrWhereCondSome() throws RecognitionException {
		FlwrWhereCondSomeContext _localctx = new FlwrWhereCondSomeContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_flwrWhereCondSome);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(900);
			match(T__18);
			setState(901);
			flwrWhereCondVar();
			setState(902);
			match(T__14);
			setState(903);
			flwrWhereCondAp();
			setState(911);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(904);
				match(T__1);
				setState(905);
				flwrWhereCondVar();
				setState(906);
				match(T__14);
				setState(907);
				flwrWhereCondAp();
				}
				}
				setState(913);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FlwrWhereCondVarContext extends ParserRuleContext {
		public VarXQContext varXQ() {
			return getRuleContext(VarXQContext.class,0);
		}
		public FlwrWhereCondVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flwrWhereCondVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterFlwrWhereCondVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitFlwrWhereCondVar(this);
		}
	}

	public final FlwrWhereCondVarContext flwrWhereCondVar() throws RecognitionException {
		FlwrWhereCondVarContext _localctx = new FlwrWhereCondVarContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_flwrWhereCondVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(914);
			varXQ();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FlwrWhereCondApContext extends ParserRuleContext {
		public ApContext ap() {
			return getRuleContext(ApContext.class,0);
		}
		public FlwrWhereCondApContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flwrWhereCondAp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterFlwrWhereCondAp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitFlwrWhereCondAp(this);
		}
	}

	public final FlwrWhereCondApContext flwrWhereCondAp() throws RecognitionException {
		FlwrWhereCondApContext _localctx = new FlwrWhereCondApContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_flwrWhereCondAp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(916);
			ap();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FlwrWhereCondEqualityContext extends ParserRuleContext {
		public FlwrWhereCondEqualityLeftTermContext flwrWhereCondEqualityLeftTerm() {
			return getRuleContext(FlwrWhereCondEqualityLeftTermContext.class,0);
		}
		public FlwrWhereCondEqualityRightTermContext flwrWhereCondEqualityRightTerm() {
			return getRuleContext(FlwrWhereCondEqualityRightTermContext.class,0);
		}
		public FlwrWhereCondEqualityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flwrWhereCondEquality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterFlwrWhereCondEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitFlwrWhereCondEquality(this);
		}
	}

	public final FlwrWhereCondEqualityContext flwrWhereCondEquality() throws RecognitionException {
		FlwrWhereCondEqualityContext _localctx = new FlwrWhereCondEqualityContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_flwrWhereCondEquality);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(918);
			flwrWhereCondEqualityLeftTerm();
			setState(919);
			match(T__0);
			setState(920);
			flwrWhereCondEqualityRightTerm();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FlwrWhereCondEqualityLeftTermContext extends ParserRuleContext {
		public CtermContext cterm() {
			return getRuleContext(CtermContext.class,0);
		}
		public FlwrWhereCondEqualityLeftTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flwrWhereCondEqualityLeftTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterFlwrWhereCondEqualityLeftTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitFlwrWhereCondEqualityLeftTerm(this);
		}
	}

	public final FlwrWhereCondEqualityLeftTermContext flwrWhereCondEqualityLeftTerm() throws RecognitionException {
		FlwrWhereCondEqualityLeftTermContext _localctx = new FlwrWhereCondEqualityLeftTermContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_flwrWhereCondEqualityLeftTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(922);
			cterm();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FlwrWhereCondEqualityRightTermContext extends ParserRuleContext {
		public CtermContext cterm() {
			return getRuleContext(CtermContext.class,0);
		}
		public FlwrWhereCondEqualityRightTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flwrWhereCondEqualityRightTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterFlwrWhereCondEqualityRightTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitFlwrWhereCondEqualityRightTerm(this);
		}
	}

	public final FlwrWhereCondEqualityRightTermContext flwrWhereCondEqualityRightTerm() throws RecognitionException {
		FlwrWhereCondEqualityRightTermContext _localctx = new FlwrWhereCondEqualityRightTermContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_flwrWhereCondEqualityRightTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(924);
			cterm();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CtermApContext extends ParserRuleContext {
		public ApContext ap() {
			return getRuleContext(ApContext.class,0);
		}
		public CtermApContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctermAp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterCtermAp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitCtermAp(this);
		}
	}

	public final CtermApContext ctermAp() throws RecognitionException {
		CtermApContext _localctx = new CtermApContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_ctermAp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(926);
			ap();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CtermVarContext extends ParserRuleContext {
		public VarXQContext varXQ() {
			return getRuleContext(VarXQContext.class,0);
		}
		public CtermVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctermVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterCtermVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitCtermVar(this);
		}
	}

	public final CtermVarContext ctermVar() throws RecognitionException {
		CtermVarContext _localctx = new CtermVarContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_ctermVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(928);
			varXQ();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CtermStringContext extends ParserRuleContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public CtermStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctermString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterCtermString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitCtermString(this);
		}
	}

	public final CtermStringContext ctermString() throws RecognitionException {
		CtermStringContext _localctx = new CtermStringContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_ctermString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(930);
			string();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FlwrReturnVarContext extends ParserRuleContext {
		public VarXQContext varXQ() {
			return getRuleContext(VarXQContext.class,0);
		}
		public FlwrReturnVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flwrReturnVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterFlwrReturnVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitFlwrReturnVar(this);
		}
	}

	public final FlwrReturnVarContext flwrReturnVar() throws RecognitionException {
		FlwrReturnVarContext _localctx = new FlwrReturnVarContext(_ctx, getState());
		enterRule(_localctx, 254, RULE_flwrReturnVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(932);
			varXQ();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FlwrReturnStringContext extends ParserRuleContext {
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public FlwrReturnStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flwrReturnString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterFlwrReturnString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitFlwrReturnString(this);
		}
	}

	public final FlwrReturnStringContext flwrReturnString() throws RecognitionException {
		FlwrReturnStringContext _localctx = new FlwrReturnStringContext(_ctx, getState());
		enterRule(_localctx, 256, RULE_flwrReturnString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(934);
			string();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FlwrReturnConstructContext extends ParserRuleContext {
		public ConstructContext construct() {
			return getRuleContext(ConstructContext.class,0);
		}
		public FlwrReturnConstructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flwrReturnConstruct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterFlwrReturnConstruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitFlwrReturnConstruct(this);
		}
	}

	public final FlwrReturnConstructContext flwrReturnConstruct() throws RecognitionException {
		FlwrReturnConstructContext _localctx = new FlwrReturnConstructContext(_ctx, getState());
		enterRule(_localctx, 258, RULE_flwrReturnConstruct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(936);
			construct();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RpContext extends ParserRuleContext {
		public RpTagContext rpTag() {
			return getRuleContext(RpTagContext.class,0);
		}
		public RpAttrContext rpAttr() {
			return getRuleContext(RpAttrContext.class,0);
		}
		public RpTextContext rpText() {
			return getRuleContext(RpTextContext.class,0);
		}
		public List<RpContext> rp() {
			return getRuleContexts(RpContext.class);
		}
		public RpContext rp(int i) {
			return getRuleContext(RpContext.class,i);
		}
		public ChildContext child() {
			return getRuleContext(ChildContext.class,0);
		}
		public DescContext desc() {
			return getRuleContext(DescContext.class,0);
		}
		public RpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterRp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitRp(this);
		}
	}

	public final RpContext rp() throws RecognitionException {
		return rp(0);
	}

	private RpContext rp(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RpContext _localctx = new RpContext(_ctx, _parentState);
		RpContext _prevctx = _localctx;
		int _startState = 260;
		enterRecursionRule(_localctx, 260, RULE_rp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(942);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				{
				setState(939);
				rpTag();
				}
				break;
			case 2:
				{
				setState(940);
				rpAttr();
				}
				break;
			case 3:
				{
				setState(941);
				rpText();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(953);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_rp);
					setState(944);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(947);
					switch (_input.LA(1)) {
					case T__24:
						{
						setState(945);
						child();
						}
						break;
					case T__25:
						{
						setState(946);
						desc();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(949);
					rp(2);
					}
					} 
				}
				setState(955);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ChildContext extends ParserRuleContext {
		public ChildContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_child; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterChild(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitChild(this);
		}
	}

	public final ChildContext child() throws RecognitionException {
		ChildContext _localctx = new ChildContext(_ctx, getState());
		enterRule(_localctx, 262, RULE_child);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(956);
			match(T__24);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DescContext extends ParserRuleContext {
		public DescContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_desc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterDesc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitDesc(this);
		}
	}

	public final DescContext desc() throws RecognitionException {
		DescContext _localctx = new DescContext(_ctx, getState());
		enterRule(_localctx, 264, RULE_desc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(958);
			match(T__25);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RpTagContext extends ParserRuleContext {
		public TagContext tag() {
			return getRuleContext(TagContext.class,0);
		}
		public RpTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rpTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterRpTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitRpTag(this);
		}
	}

	public final RpTagContext rpTag() throws RecognitionException {
		RpTagContext _localctx = new RpTagContext(_ctx, getState());
		enterRule(_localctx, 266, RULE_rpTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(960);
			tag();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RpAttrContext extends ParserRuleContext {
		public TagContext tag() {
			return getRuleContext(TagContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public RpAttrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rpAttr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterRpAttr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitRpAttr(this);
		}
	}

	public final RpAttrContext rpAttr() throws RecognitionException {
		RpAttrContext _localctx = new RpAttrContext(_ctx, getState());
		enterRule(_localctx, 268, RULE_rpAttr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(962);
			tag();
			setState(963);
			match(T__26);
			setState(964);
			name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RpTextContext extends ParserRuleContext {
		public RpTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rpText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterRpText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitRpText(this);
		}
	}

	public final RpTextContext rpText() throws RecognitionException {
		RpTextContext _localctx = new RpTextContext(_ctx, getState());
		enterRule(_localctx, 270, RULE_rpText);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(966);
			match(T__27);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ApContext extends ParserRuleContext {
		public DocumentContext document() {
			return getRuleContext(DocumentContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public ChildContext child() {
			return getRuleContext(ChildContext.class,0);
		}
		public DescContext desc() {
			return getRuleContext(DescContext.class,0);
		}
		public VarXQContext varXQ() {
			return getRuleContext(VarXQContext.class,0);
		}
		public ApAttrContext apAttr() {
			return getRuleContext(ApAttrContext.class,0);
		}
		public ApContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ap; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterAp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitAp(this);
		}
	}

	public final ApContext ap() throws RecognitionException {
		ApContext _localctx = new ApContext(_ctx, getState());
		enterRule(_localctx, 272, RULE_ap);
		try {
			setState(983);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(968);
				document();
				setState(971);
				switch (_input.LA(1)) {
				case T__24:
					{
					setState(969);
					child();
					}
					break;
				case T__25:
					{
					setState(970);
					desc();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(973);
				rp(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(975);
				varXQ();
				setState(978);
				switch (_input.LA(1)) {
				case T__24:
					{
					setState(976);
					child();
					}
					break;
				case T__25:
					{
					setState(977);
					desc();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(980);
				rp(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(982);
				apAttr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DocumentContext extends ParserRuleContext {
		public SourceXQContext sourceXQ() {
			return getRuleContext(SourceXQContext.class,0);
		}
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitDocument(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 274, RULE_document);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(985);
			match(T__28);
			setState(986);
			sourceXQ();
			setState(987);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SourceXQContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(QBTQUERYParser.NAME, 0); }
		public SourceXQContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sourceXQ; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterSourceXQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitSourceXQ(this);
		}
	}

	public final SourceXQContext sourceXQ() throws RecognitionException {
		SourceXQContext _localctx = new SourceXQContext(_ctx, getState());
		enterRule(_localctx, 276, RULE_sourceXQ);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(989);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ApAttrContext extends ParserRuleContext {
		public VarXQContext varXQ() {
			return getRuleContext(VarXQContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public ApAttrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_apAttr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterApAttr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitApAttr(this);
		}
	}

	public final ApAttrContext apAttr() throws RecognitionException {
		ApAttrContext _localctx = new ApAttrContext(_ctx, getState());
		enterRule(_localctx, 278, RULE_apAttr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(991);
			varXQ();
			setState(992);
			match(T__26);
			setState(993);
			name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PContext extends ParserRuleContext {
		public ApContext ap() {
			return getRuleContext(ApContext.class,0);
		}
		public RpContext rp() {
			return getRuleContext(RpContext.class,0);
		}
		public PContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_p; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitP(this);
		}
	}

	public final PContext p() throws RecognitionException {
		PContext _localctx = new PContext(_ctx, getState());
		enterRule(_localctx, 280, RULE_p);
		try {
			setState(997);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(995);
				ap();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(996);
				rp(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RqQueryContext extends ParserRuleContext {
		public QueryNameContext queryName() {
			return getRuleContext(QueryNameContext.class,0);
		}
		public SqlQueryContext sqlQuery() {
			return getRuleContext(SqlQueryContext.class,0);
		}
		public TerminalNode EOF() { return getToken(QBTQUERYParser.EOF, 0); }
		public RqQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rqQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterRqQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitRqQuery(this);
		}
	}

	public final RqQueryContext rqQuery() throws RecognitionException {
		RqQueryContext _localctx = new RqQueryContext(_ctx, getState());
		enterRule(_localctx, 282, RULE_rqQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(999);
			queryName();
			setState(1000);
			match(T__0);
			setState(1001);
			sqlQuery();
			setState(1002);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SqlQueryContext extends ParserRuleContext {
		public SfwQueryRQContext sfwQueryRQ() {
			return getRuleContext(SfwQueryRQContext.class,0);
		}
		public SqlQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sqlQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterSqlQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitSqlQuery(this);
		}
	}

	public final SqlQueryContext sqlQuery() throws RecognitionException {
		SqlQueryContext _localctx = new SqlQueryContext(_ctx, getState());
		enterRule(_localctx, 284, RULE_sqlQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1004);
			sfwQueryRQ();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SfwQueryRQContext extends ParserRuleContext {
		public SelectClauseRQContext selectClauseRQ() {
			return getRuleContext(SelectClauseRQContext.class,0);
		}
		public FromWhereClausesRQContext fromWhereClausesRQ() {
			return getRuleContext(FromWhereClausesRQContext.class,0);
		}
		public SfwQueryRQContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sfwQueryRQ; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterSfwQueryRQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitSfwQueryRQ(this);
		}
	}

	public final SfwQueryRQContext sfwQueryRQ() throws RecognitionException {
		SfwQueryRQContext _localctx = new SfwQueryRQContext(_ctx, getState());
		enterRule(_localctx, 286, RULE_sfwQueryRQ);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1006);
			selectClauseRQ();
			setState(1007);
			fromWhereClausesRQ();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FromWhereClausesRQContext extends ParserRuleContext {
		public FromClauseRQContext fromClauseRQ() {
			return getRuleContext(FromClauseRQContext.class,0);
		}
		public WhereClauseRQContext whereClauseRQ() {
			return getRuleContext(WhereClauseRQContext.class,0);
		}
		public FromWhereClausesRQContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fromWhereClausesRQ; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterFromWhereClausesRQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitFromWhereClausesRQ(this);
		}
	}

	public final FromWhereClausesRQContext fromWhereClausesRQ() throws RecognitionException {
		FromWhereClausesRQContext _localctx = new FromWhereClausesRQContext(_ctx, getState());
		enterRule(_localctx, 288, RULE_fromWhereClausesRQ);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1009);
			fromClauseRQ();
			setState(1011);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(1010);
				whereClauseRQ();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectClauseRQContext extends ParserRuleContext {
		public SelectStatementRQContext selectStatementRQ() {
			return getRuleContext(SelectStatementRQContext.class,0);
		}
		public SelectClauseRQContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectClauseRQ; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterSelectClauseRQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitSelectClauseRQ(this);
		}
	}

	public final SelectClauseRQContext selectClauseRQ() throws RecognitionException {
		SelectClauseRQContext _localctx = new SelectClauseRQContext(_ctx, getState());
		enterRule(_localctx, 290, RULE_selectClauseRQ);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1013);
			selectStatementRQ();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectStatementRQContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(QBTQUERYParser.SELECT, 0); }
		public List<SelectItemRQContext> selectItemRQ() {
			return getRuleContexts(SelectItemRQContext.class);
		}
		public SelectItemRQContext selectItemRQ(int i) {
			return getRuleContext(SelectItemRQContext.class,i);
		}
		public SelectStatementRQContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectStatementRQ; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterSelectStatementRQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitSelectStatementRQ(this);
		}
	}

	public final SelectStatementRQContext selectStatementRQ() throws RecognitionException {
		SelectStatementRQContext _localctx = new SelectStatementRQContext(_ctx, getState());
		enterRule(_localctx, 292, RULE_selectStatementRQ);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1015);
			match(SELECT);
			setState(1016);
			selectItemRQ();
			setState(1021);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(1017);
				match(T__1);
				setState(1018);
				selectItemRQ();
				}
				}
				setState(1023);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SelectItemRQContext extends ParserRuleContext {
		public TermRQContext termRQ() {
			return getRuleContext(TermRQContext.class,0);
		}
		public TerminalNode NAME() { return getToken(QBTQUERYParser.NAME, 0); }
		public SelectItemRQContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectItemRQ; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterSelectItemRQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitSelectItemRQ(this);
		}
	}

	public final SelectItemRQContext selectItemRQ() throws RecognitionException {
		SelectItemRQContext _localctx = new SelectItemRQContext(_ctx, getState());
		enterRule(_localctx, 294, RULE_selectItemRQ);
		try {
			setState(1026);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1024);
				termRQ();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1025);
				match(NAME);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FromClauseRQContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(QBTQUERYParser.FROM, 0); }
		public List<RelationBindingContext> relationBinding() {
			return getRuleContexts(RelationBindingContext.class);
		}
		public RelationBindingContext relationBinding(int i) {
			return getRuleContext(RelationBindingContext.class,i);
		}
		public FromClauseRQContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fromClauseRQ; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterFromClauseRQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitFromClauseRQ(this);
		}
	}

	public final FromClauseRQContext fromClauseRQ() throws RecognitionException {
		FromClauseRQContext _localctx = new FromClauseRQContext(_ctx, getState());
		enterRule(_localctx, 296, RULE_fromClauseRQ);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1028);
			match(FROM);
			setState(1029);
			relationBinding();
			setState(1034);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(1030);
				match(T__1);
				setState(1031);
				relationBinding();
				}
				}
				setState(1036);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationBindingContext extends ParserRuleContext {
		public SourceContext source() {
			return getRuleContext(SourceContext.class,0);
		}
		public TerminalNode AS() { return getToken(QBTQUERYParser.AS, 0); }
		public VariableKQContext variableKQ() {
			return getRuleContext(VariableKQContext.class,0);
		}
		public RelationBindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationBinding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterRelationBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitRelationBinding(this);
		}
	}

	public final RelationBindingContext relationBinding() throws RecognitionException {
		RelationBindingContext _localctx = new RelationBindingContext(_ctx, getState());
		enterRule(_localctx, 298, RULE_relationBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1037);
			source();
			setState(1038);
			match(AS);
			setState(1039);
			variableKQ();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SourceContext extends ParserRuleContext {
		public RelationNameContext relationName() {
			return getRuleContext(RelationNameContext.class,0);
		}
		public SourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_source; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitSource(this);
		}
	}

	public final SourceContext source() throws RecognitionException {
		SourceContext _localctx = new SourceContext(_ctx, getState());
		enterRule(_localctx, 300, RULE_source);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1041);
			relationName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RelationNameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(QBTQUERYParser.NAME, 0); }
		public RelationNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterRelationName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitRelationName(this);
		}
	}

	public final RelationNameContext relationName() throws RecognitionException {
		RelationNameContext _localctx = new RelationNameContext(_ctx, getState());
		enterRule(_localctx, 302, RULE_relationName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1043);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableKQContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(QBTQUERYParser.NAME, 0); }
		public VariableKQContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableKQ; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterVariableKQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitVariableKQ(this);
		}
	}

	public final VariableKQContext variableKQ() throws RecognitionException {
		VariableKQContext _localctx = new VariableKQContext(_ctx, getState());
		enterRule(_localctx, 304, RULE_variableKQ);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1045);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhereClauseRQContext extends ParserRuleContext {
		public WhereStatementRQContext whereStatementRQ() {
			return getRuleContext(WhereStatementRQContext.class,0);
		}
		public WhereClauseRQContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereClauseRQ; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterWhereClauseRQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitWhereClauseRQ(this);
		}
	}

	public final WhereClauseRQContext whereClauseRQ() throws RecognitionException {
		WhereClauseRQContext _localctx = new WhereClauseRQContext(_ctx, getState());
		enterRule(_localctx, 306, RULE_whereClauseRQ);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1047);
			whereStatementRQ();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WhereStatementRQContext extends ParserRuleContext {
		public ConditionRQContext conditionRQ() {
			return getRuleContext(ConditionRQContext.class,0);
		}
		public WhereStatementRQContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereStatementRQ; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterWhereStatementRQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitWhereStatementRQ(this);
		}
	}

	public final WhereStatementRQContext whereStatementRQ() throws RecognitionException {
		WhereStatementRQContext _localctx = new WhereStatementRQContext(_ctx, getState());
		enterRule(_localctx, 308, RULE_whereStatementRQ);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1049);
			match(T__2);
			setState(1050);
			conditionRQ(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionRQContext extends ParserRuleContext {
		public EqualityContext equality() {
			return getRuleContext(EqualityContext.class,0);
		}
		public LikeExpressionContext likeExpression() {
			return getRuleContext(LikeExpressionContext.class,0);
		}
		public List<ConditionRQContext> conditionRQ() {
			return getRuleContexts(ConditionRQContext.class);
		}
		public ConditionRQContext conditionRQ(int i) {
			return getRuleContext(ConditionRQContext.class,i);
		}
		public TerminalNode AND() { return getToken(QBTQUERYParser.AND, 0); }
		public ConditionRQContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionRQ; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterConditionRQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitConditionRQ(this);
		}
	}

	public final ConditionRQContext conditionRQ() throws RecognitionException {
		return conditionRQ(0);
	}

	private ConditionRQContext conditionRQ(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionRQContext _localctx = new ConditionRQContext(_ctx, _parentState);
		ConditionRQContext _prevctx = _localctx;
		int _startState = 310;
		enterRecursionRule(_localctx, 310, RULE_conditionRQ, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1059);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				{
				setState(1053);
				equality();
				}
				break;
			case 2:
				{
				setState(1054);
				likeExpression();
				}
				break;
			case 3:
				{
				setState(1055);
				match(T__6);
				setState(1056);
				conditionRQ(0);
				setState(1057);
				match(T__7);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1066);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConditionRQContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_conditionRQ);
					setState(1061);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(1062);
					match(AND);
					setState(1063);
					conditionRQ(3);
					}
					} 
				}
				setState(1068);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TermRQContext extends ParserRuleContext {
		public RealtionContext realtion() {
			return getRuleContext(RealtionContext.class,0);
		}
		public TerminalNode NAME() { return getToken(QBTQUERYParser.NAME, 0); }
		public TerminalNode STRINGRULE() { return getToken(QBTQUERYParser.STRINGRULE, 0); }
		public TermRQContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termRQ; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterTermRQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitTermRQ(this);
		}
	}

	public final TermRQContext termRQ() throws RecognitionException {
		TermRQContext _localctx = new TermRQContext(_ctx, getState());
		enterRule(_localctx, 312, RULE_termRQ);
		try {
			setState(1074);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(1069);
				realtion();
				setState(1070);
				match(T__11);
				setState(1071);
				match(NAME);
				}
				break;
			case STRINGRULE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1073);
				match(STRINGRULE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EqualityContext extends ParserRuleContext {
		public LefttermRQContext lefttermRQ() {
			return getRuleContext(LefttermRQContext.class,0);
		}
		public RighttermRQContext righttermRQ() {
			return getRuleContext(RighttermRQContext.class,0);
		}
		public EqualityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitEquality(this);
		}
	}

	public final EqualityContext equality() throws RecognitionException {
		EqualityContext _localctx = new EqualityContext(_ctx, getState());
		enterRule(_localctx, 314, RULE_equality);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1076);
			lefttermRQ();
			setState(1077);
			match(T__0);
			setState(1078);
			righttermRQ();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LikeExpressionContext extends ParserRuleContext {
		public TermRQContext termRQ() {
			return getRuleContext(TermRQContext.class,0);
		}
		public TerminalNode LIKE() { return getToken(QBTQUERYParser.LIKE, 0); }
		public TerminalNode STRINGRULE() { return getToken(QBTQUERYParser.STRINGRULE, 0); }
		public LikeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_likeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterLikeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitLikeExpression(this);
		}
	}

	public final LikeExpressionContext likeExpression() throws RecognitionException {
		LikeExpressionContext _localctx = new LikeExpressionContext(_ctx, getState());
		enterRule(_localctx, 316, RULE_likeExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1080);
			termRQ();
			setState(1081);
			match(LIKE);
			setState(1082);
			match(STRINGRULE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LefttermRQContext extends ParserRuleContext {
		public TermRQContext termRQ() {
			return getRuleContext(TermRQContext.class,0);
		}
		public LefttermRQContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lefttermRQ; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterLefttermRQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitLefttermRQ(this);
		}
	}

	public final LefttermRQContext lefttermRQ() throws RecognitionException {
		LefttermRQContext _localctx = new LefttermRQContext(_ctx, getState());
		enterRule(_localctx, 318, RULE_lefttermRQ);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1084);
			termRQ();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RighttermRQContext extends ParserRuleContext {
		public TermRQContext termRQ() {
			return getRuleContext(TermRQContext.class,0);
		}
		public RighttermRQContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_righttermRQ; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterRighttermRQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitRighttermRQ(this);
		}
	}

	public final RighttermRQContext righttermRQ() throws RecognitionException {
		RighttermRQContext _localctx = new RighttermRQContext(_ctx, getState());
		enterRule(_localctx, 320, RULE_righttermRQ);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1086);
			termRQ();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RealtionContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(QBTQUERYParser.NAME, 0); }
		public RealtionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_realtion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).enterRealtion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTQUERYListener ) ((QBTQUERYListener)listener).exitRealtion(this);
		}
	}

	public final RealtionContext realtion() throws RecognitionException {
		RealtionContext _localctx = new RealtionContext(_ctx, getState());
		enterRule(_localctx, 322, RULE_realtion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1088);
			match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 13:
			return mixedcondition_sempred((MixedconditionContext)_localctx, predIndex);
		case 82:
			return condition_sempred((ConditionContext)_localctx, predIndex);
		case 117:
			return flwrWhereCond_sempred((FlwrWhereCondContext)_localctx, predIndex);
		case 130:
			return rp_sempred((RpContext)_localctx, predIndex);
		case 155:
			return conditionRQ_sempred((ConditionRQContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean mixedcondition_sempred(MixedconditionContext _localctx, int predIndex) {
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
	private boolean flwrWhereCond_sempred(FlwrWhereCondContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean rp_sempred(RpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean conditionRQ_sempred(ConditionRQContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3:\u0445\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\4\\\t\\\4]\t]\4^\t^\4_\t_\4"+
		"`\t`\4a\ta\4b\tb\4c\tc\4d\td\4e\te\4f\tf\4g\tg\4h\th\4i\ti\4j\tj\4k\t"+
		"k\4l\tl\4m\tm\4n\tn\4o\to\4p\tp\4q\tq\4r\tr\4s\ts\4t\tt\4u\tu\4v\tv\4"+
		"w\tw\4x\tx\4y\ty\4z\tz\4{\t{\4|\t|\4}\t}\4~\t~\4\177\t\177\4\u0080\t\u0080"+
		"\4\u0081\t\u0081\4\u0082\t\u0082\4\u0083\t\u0083\4\u0084\t\u0084\4\u0085"+
		"\t\u0085\4\u0086\t\u0086\4\u0087\t\u0087\4\u0088\t\u0088\4\u0089\t\u0089"+
		"\4\u008a\t\u008a\4\u008b\t\u008b\4\u008c\t\u008c\4\u008d\t\u008d\4\u008e"+
		"\t\u008e\4\u008f\t\u008f\4\u0090\t\u0090\4\u0091\t\u0091\4\u0092\t\u0092"+
		"\4\u0093\t\u0093\4\u0094\t\u0094\4\u0095\t\u0095\4\u0096\t\u0096\4\u0097"+
		"\t\u0097\4\u0098\t\u0098\4\u0099\t\u0099\4\u009a\t\u009a\4\u009b\t\u009b"+
		"\4\u009c\t\u009c\4\u009d\t\u009d\4\u009e\t\u009e\4\u009f\t\u009f\4\u00a0"+
		"\t\u00a0\4\u00a1\t\u00a1\4\u00a2\t\u00a2\4\u00a3\t\u00a3\3\2\3\2\3\2\3"+
		"\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\5\5\u0152\n\5\3\5\5\5\u0155\n\5\3\6\3\6"+
		"\3\6\3\6\7\6\u015b\n\6\f\6\16\6\u015e\13\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\5\n\u0170\n\n\3\13\3\13\5\13\u0174"+
		"\n\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0182"+
		"\n\17\3\17\3\17\3\17\7\17\u0187\n\17\f\17\16\17\u018a\13\17\3\20\3\20"+
		"\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0197\n\21\3\22\3\22"+
		"\5\22\u019b\n\22\3\23\3\23\5\23\u019f\n\23\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\25\3\25\3\25\5\25\u01aa\n\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31"+
		"\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36"+
		"\3\36\3\37\3\37\3\37\3 \3 \3!\3!\3!\3\"\3\"\3#\3#\3$\3$\3$\3$\7$\u01d2"+
		"\n$\f$\16$\u01d5\13$\3%\3%\3%\3%\3&\3&\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\3"+
		"(\7(\u01e7\n(\f(\16(\u01ea\13(\3(\3(\3(\3(\3(\3(\3(\3(\7(\u01f4\n(\f("+
		"\16(\u01f7\13(\3(\3(\3(\3(\3(\5(\u01fe\n(\3)\3)\3*\3*\5*\u0204\n*\3+\3"+
		"+\3,\3,\3,\3,\5,\u020c\n,\3-\3-\3.\3.\5.\u0212\n.\3/\3/\3\60\3\60\3\60"+
		"\3\60\3\60\3\60\3\60\3\60\3\60\5\60\u021f\n\60\3\61\3\61\5\61\u0223\n"+
		"\61\3\61\3\61\3\62\3\62\3\63\3\63\3\63\3\63\5\63\u022d\n\63\3\64\3\64"+
		"\3\64\3\64\7\64\u0233\n\64\f\64\16\64\u0236\13\64\3\64\3\64\3\65\3\65"+
		"\3\65\3\65\3\66\3\66\3\67\3\67\38\38\38\38\58\u0246\n8\39\39\59\u024a"+
		"\n9\3:\3:\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3>\5>\u0259\n>\3?\3?\3@\3@\3A"+
		"\3A\3B\3B\3C\3C\3D\3D\6D\u0267\nD\rD\16D\u0268\3E\3E\3F\3F\3G\3G\5G\u0271"+
		"\nG\3H\3H\3H\3I\3I\3I\3I\3J\3J\3K\3K\3L\3L\3L\3L\7L\u0282\nL\fL\16L\u0285"+
		"\13L\3M\3M\3M\3M\3M\3M\3M\3M\7M\u028f\nM\fM\16M\u0292\13M\3N\3N\3N\3N"+
		"\3O\3O\3P\3P\3Q\3Q\3Q\5Q\u029f\nQ\3R\3R\3S\3S\3S\3T\3T\3T\3T\3T\3T\3T"+
		"\3T\3T\3T\3T\5T\u02b1\nT\3T\3T\3T\7T\u02b6\nT\fT\16T\u02b9\13T\3U\3U\3"+
		"U\7U\u02be\nU\fU\16U\u02c1\13U\3V\3V\3V\3V\3W\3W\3X\3X\3Y\3Y\3Y\3Y\3Z"+
		"\3Z\3[\3[\3\\\3\\\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\3]\5]\u02e2\n]\3"+
		"^\3^\3_\3_\3`\3`\3`\3`\5`\u02ec\n`\3a\3a\3a\5a\u02f1\na\3a\3a\3a\3b\3"+
		"b\3b\5b\u02f9\nb\3b\3b\3b\3b\3b\3b\3b\3c\3c\3c\5c\u0305\nc\3c\3c\3c\3"+
		"c\3c\3c\3c\3c\3c\3d\3d\3d\5d\u0313\nd\3d\3d\3d\3d\3d\7d\u031a\nd\fd\16"+
		"d\u031d\13d\3d\3d\3d\3d\3e\3e\3e\3e\3e\5e\u0328\ne\3f\3f\3g\3g\3h\3h\3"+
		"i\3i\3j\3j\3j\3j\3j\3j\3j\3j\3j\7j\u033b\nj\fj\16j\u033e\13j\3j\3j\3k"+
		"\3k\3l\3l\3l\3l\3l\5l\u0349\nl\3m\3m\3n\3n\3o\3o\3p\3p\3p\3q\3q\3q\3q"+
		"\3q\3q\3q\3q\3q\7q\u035d\nq\fq\16q\u0360\13q\3r\3r\3r\3s\3s\5s\u0367\n"+
		"s\3t\3t\3t\3t\5t\u036d\nt\3u\3u\3v\3v\3w\3w\3w\3w\3w\3w\3w\3w\3w\3w\5"+
		"w\u037d\nw\3w\3w\3w\7w\u0382\nw\fw\16w\u0385\13w\3x\3x\3x\3x\3x\3x\3x"+
		"\3x\3x\7x\u0390\nx\fx\16x\u0393\13x\3y\3y\3z\3z\3{\3{\3{\3{\3|\3|\3}\3"+
		"}\3~\3~\3\177\3\177\3\u0080\3\u0080\3\u0081\3\u0081\3\u0082\3\u0082\3"+
		"\u0083\3\u0083\3\u0084\3\u0084\3\u0084\3\u0084\5\u0084\u03b1\n\u0084\3"+
		"\u0084\3\u0084\3\u0084\5\u0084\u03b6\n\u0084\3\u0084\3\u0084\7\u0084\u03ba"+
		"\n\u0084\f\u0084\16\u0084\u03bd\13\u0084\3\u0085\3\u0085\3\u0086\3\u0086"+
		"\3\u0087\3\u0087\3\u0088\3\u0088\3\u0088\3\u0088\3\u0089\3\u0089\3\u008a"+
		"\3\u008a\3\u008a\5\u008a\u03ce\n\u008a\3\u008a\3\u008a\3\u008a\3\u008a"+
		"\3\u008a\5\u008a\u03d5\n\u008a\3\u008a\3\u008a\3\u008a\5\u008a\u03da\n"+
		"\u008a\3\u008b\3\u008b\3\u008b\3\u008b\3\u008c\3\u008c\3\u008d\3\u008d"+
		"\3\u008d\3\u008d\3\u008e\3\u008e\5\u008e\u03e8\n\u008e\3\u008f\3\u008f"+
		"\3\u008f\3\u008f\3\u008f\3\u0090\3\u0090\3\u0091\3\u0091\3\u0091\3\u0092"+
		"\3\u0092\5\u0092\u03f6\n\u0092\3\u0093\3\u0093\3\u0094\3\u0094\3\u0094"+
		"\3\u0094\7\u0094\u03fe\n\u0094\f\u0094\16\u0094\u0401\13\u0094\3\u0095"+
		"\3\u0095\5\u0095\u0405\n\u0095\3\u0096\3\u0096\3\u0096\3\u0096\7\u0096"+
		"\u040b\n\u0096\f\u0096\16\u0096\u040e\13\u0096\3\u0097\3\u0097\3\u0097"+
		"\3\u0097\3\u0098\3\u0098\3\u0099\3\u0099\3\u009a\3\u009a\3\u009b\3\u009b"+
		"\3\u009c\3\u009c\3\u009c\3\u009d\3\u009d\3\u009d\3\u009d\3\u009d\3\u009d"+
		"\3\u009d\5\u009d\u0426\n\u009d\3\u009d\3\u009d\3\u009d\7\u009d\u042b\n"+
		"\u009d\f\u009d\16\u009d\u042e\13\u009d\3\u009e\3\u009e\3\u009e\3\u009e"+
		"\3\u009e\5\u009e\u0435\n\u009e\3\u009f\3\u009f\3\u009f\3\u009f\3\u00a0"+
		"\3\u00a0\3\u00a0\3\u00a0\3\u00a1\3\u00a1\3\u00a2\3\u00a2\3\u00a3\3\u00a3"+
		"\3\u00a3\2\7\34\u00a6\u00ec\u0106\u0138\u00a4\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtv"+
		"xz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094"+
		"\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac"+
		"\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4"+
		"\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc"+
		"\u00de\u00e0\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2\u00f4"+
		"\u00f6\u00f8\u00fa\u00fc\u00fe\u0100\u0102\u0104\u0106\u0108\u010a\u010c"+
		"\u010e\u0110\u0112\u0114\u0116\u0118\u011a\u011c\u011e\u0120\u0122\u0124"+
		"\u0126\u0128\u012a\u012c\u012e\u0130\u0132\u0134\u0136\u0138\u013a\u013c"+
		"\u013e\u0140\u0142\u0144\2\3\3\2#\'\u03f1\2\u0146\3\2\2\2\4\u014b\3\2"+
		"\2\2\6\u014d\3\2\2\2\b\u014f\3\2\2\2\n\u0156\3\2\2\2\f\u015f\3\2\2\2\16"+
		"\u0162\3\2\2\2\20\u0165\3\2\2\2\22\u016f\3\2\2\2\24\u0171\3\2\2\2\26\u0175"+
		"\3\2\2\2\30\u0177\3\2\2\2\32\u0179\3\2\2\2\34\u0181\3\2\2\2\36\u018b\3"+
		"\2\2\2 \u0196\3\2\2\2\"\u019a\3\2\2\2$\u019e\3\2\2\2&\u01a0\3\2\2\2(\u01a9"+
		"\3\2\2\2*\u01ab\3\2\2\2,\u01ad\3\2\2\2.\u01af\3\2\2\2\60\u01b1\3\2\2\2"+
		"\62\u01b3\3\2\2\2\64\u01b5\3\2\2\2\66\u01b7\3\2\2\28\u01ba\3\2\2\2:\u01bf"+
		"\3\2\2\2<\u01c1\3\2\2\2>\u01c4\3\2\2\2@\u01c6\3\2\2\2B\u01c9\3\2\2\2D"+
		"\u01cb\3\2\2\2F\u01cd\3\2\2\2H\u01d6\3\2\2\2J\u01da\3\2\2\2L\u01dc\3\2"+
		"\2\2N\u01fd\3\2\2\2P\u01ff\3\2\2\2R\u0203\3\2\2\2T\u0205\3\2\2\2V\u020b"+
		"\3\2\2\2X\u020d\3\2\2\2Z\u0211\3\2\2\2\\\u0213\3\2\2\2^\u0215\3\2\2\2"+
		"`\u0220\3\2\2\2b\u0226\3\2\2\2d\u0228\3\2\2\2f\u022e\3\2\2\2h\u0239\3"+
		"\2\2\2j\u023d\3\2\2\2l\u023f\3\2\2\2n\u0245\3\2\2\2p\u0249\3\2\2\2r\u024b"+
		"\3\2\2\2t\u024f\3\2\2\2v\u0251\3\2\2\2x\u0253\3\2\2\2z\u0258\3\2\2\2|"+
		"\u025a\3\2\2\2~\u025c\3\2\2\2\u0080\u025e\3\2\2\2\u0082\u0260\3\2\2\2"+
		"\u0084\u0262\3\2\2\2\u0086\u0264\3\2\2\2\u0088\u026a\3\2\2\2\u008a\u026c"+
		"\3\2\2\2\u008c\u0270\3\2\2\2\u008e\u0272\3\2\2\2\u0090\u0275\3\2\2\2\u0092"+
		"\u0279\3\2\2\2\u0094\u027b\3\2\2\2\u0096\u027d\3\2\2\2\u0098\u0286\3\2"+
		"\2\2\u009a\u0293\3\2\2\2\u009c\u0297\3\2\2\2\u009e\u0299\3\2\2\2\u00a0"+
		"\u029e\3\2\2\2\u00a2\u02a0\3\2\2\2\u00a4\u02a2\3\2\2\2\u00a6\u02b0\3\2"+
		"\2\2\u00a8\u02ba\3\2\2\2\u00aa\u02c2\3\2\2\2\u00ac\u02c6\3\2\2\2\u00ae"+
		"\u02c8\3\2\2\2\u00b0\u02ca\3\2\2\2\u00b2\u02ce\3\2\2\2\u00b4\u02d0\3\2"+
		"\2\2\u00b6\u02d2\3\2\2\2\u00b8\u02d4\3\2\2\2\u00ba\u02e3\3\2\2\2\u00bc"+
		"\u02e5\3\2\2\2\u00be\u02eb\3\2\2\2\u00c0\u02ed\3\2\2\2\u00c2\u02f5\3\2"+
		"\2\2\u00c4\u0301\3\2\2\2\u00c6\u030f\3\2\2\2\u00c8\u0327\3\2\2\2\u00ca"+
		"\u0329\3\2\2\2\u00cc\u032b\3\2\2\2\u00ce\u032d\3\2\2\2\u00d0\u032f\3\2"+
		"\2\2\u00d2\u0331\3\2\2\2\u00d4\u0341\3\2\2\2\u00d6\u0348\3\2\2\2\u00d8"+
		"\u034a\3\2\2\2\u00da\u034c\3\2\2\2\u00dc\u034e\3\2\2\2\u00de\u0350\3\2"+
		"\2\2\u00e0\u0353\3\2\2\2\u00e2\u0361\3\2\2\2\u00e4\u0364\3\2\2\2\u00e6"+
		"\u0368\3\2\2\2\u00e8\u036e\3\2\2\2\u00ea\u0370\3\2\2\2\u00ec\u037c\3\2"+
		"\2\2\u00ee\u0386\3\2\2\2\u00f0\u0394\3\2\2\2\u00f2\u0396\3\2\2\2\u00f4"+
		"\u0398\3\2\2\2\u00f6\u039c\3\2\2\2\u00f8\u039e\3\2\2\2\u00fa\u03a0\3\2"+
		"\2\2\u00fc\u03a2\3\2\2\2\u00fe\u03a4\3\2\2\2\u0100\u03a6\3\2\2\2\u0102"+
		"\u03a8\3\2\2\2\u0104\u03aa\3\2\2\2\u0106\u03b0\3\2\2\2\u0108\u03be\3\2"+
		"\2\2\u010a\u03c0\3\2\2\2\u010c\u03c2\3\2\2\2\u010e\u03c4\3\2\2\2\u0110"+
		"\u03c8\3\2\2\2\u0112\u03d9\3\2\2\2\u0114\u03db\3\2\2\2\u0116\u03df\3\2"+
		"\2\2\u0118\u03e1\3\2\2\2\u011a\u03e7\3\2\2\2\u011c\u03e9\3\2\2\2\u011e"+
		"\u03ee\3\2\2\2\u0120\u03f0\3\2\2\2\u0122\u03f3\3\2\2\2\u0124\u03f7\3\2"+
		"\2\2\u0126\u03f9\3\2\2\2\u0128\u0404\3\2\2\2\u012a\u0406\3\2\2\2\u012c"+
		"\u040f\3\2\2\2\u012e\u0413\3\2\2\2\u0130\u0415\3\2\2\2\u0132\u0417\3\2"+
		"\2\2\u0134\u0419\3\2\2\2\u0136\u041b\3\2\2\2\u0138\u0425\3\2\2\2\u013a"+
		"\u0434\3\2\2\2\u013c\u0436\3\2\2\2\u013e\u043a\3\2\2\2\u0140\u043e\3\2"+
		"\2\2\u0142\u0440\3\2\2\2\u0144\u0442\3\2\2\2\u0146\u0147\5\4\3\2\u0147"+
		"\u0148\7\3\2\2\u0148\u0149\5\6\4\2\u0149\u014a\7\2\2\3\u014a\3\3\2\2\2"+
		"\u014b\u014c\7/\2\2\u014c\5\3\2\2\2\u014d\u014e\5\b\5\2\u014e\7\3\2\2"+
		"\2\u014f\u0151\5\n\6\2\u0150\u0152\5\f\7\2\u0151\u0150\3\2\2\2\u0151\u0152"+
		"\3\2\2\2\u0152\u0154\3\2\2\2\u0153\u0155\5\16\b\2\u0154\u0153\3\2\2\2"+
		"\u0154\u0155\3\2\2\2\u0155\t\3\2\2\2\u0156\u0157\7 \2\2\u0157\u015c\5"+
		"\20\t\2\u0158\u0159\7\4\2\2\u0159\u015b\5\20\t\2\u015a\u0158\3\2\2\2\u015b"+
		"\u015e\3\2\2\2\u015c\u015a\3\2\2\2\u015c\u015d\3\2\2\2\u015d\13\3\2\2"+
		"\2\u015e\u015c\3\2\2\2\u015f\u0160\7\5\2\2\u0160\u0161\5\34\17\2\u0161"+
		"\r\3\2\2\2\u0162\u0163\7\"\2\2\u0163\u0164\5&\24\2\u0164\17\3\2\2\2\u0165"+
		"\u0166\5\60\31\2\u0166\u0167\7\6\2\2\u0167\u0168\7\7\2\2\u0168\u0169\5"+
		"\22\n\2\u0169\u016a\7\b\2\2\u016a\21\3\2\2\2\u016b\u0170\5\24\13\2\u016c"+
		"\u0170\5\26\f\2\u016d\u0170\5\30\r\2\u016e\u0170\5\32\16\2\u016f\u016b"+
		"\3\2\2\2\u016f\u016c\3\2\2\2\u016f\u016d\3\2\2\2\u016f\u016e\3\2\2\2\u0170"+
		"\23\3\2\2\2\u0171\u0173\5\u0098M\2\u0172\u0174\5\u00a4S\2\u0173\u0172"+
		"\3\2\2\2\u0173\u0174\3\2\2\2\u0174\25\3\2\2\2\u0175\u0176\5F$\2\u0176"+
		"\27\3\2\2\2\u0177\u0178\5\u00e4s\2\u0178\31\3\2\2\2\u0179\u017a\5\u011e"+
		"\u0090\2\u017a\33\3\2\2\2\u017b\u017c\b\17\1\2\u017c\u0182\5\36\20\2\u017d"+
		"\u017e\7\t\2\2\u017e\u017f\5\34\17\2\u017f\u0180\7\n\2\2\u0180\u0182\3"+
		"\2\2\2\u0181\u017b\3\2\2\2\u0181\u017d\3\2\2\2\u0182\u0188\3\2\2\2\u0183"+
		"\u0184\f\3\2\2\u0184\u0185\7(\2\2\u0185\u0187\5\34\17\4\u0186\u0183\3"+
		"\2\2\2\u0187\u018a\3\2\2\2\u0188\u0186\3\2\2\2\u0188\u0189\3\2\2\2\u0189"+
		"\35\3\2\2\2\u018a\u0188\3\2\2\2\u018b\u018c\5 \21\2\u018c\u018d\7\3\2"+
		"\2\u018d\u018e\5 \21\2\u018e\37\3\2\2\2\u018f\u0197\5\"\22\2\u0190\u0191"+
		"\5\60\31\2\u0191\u0192\7\6\2\2\u0192\u0193\7\7\2\2\u0193\u0194\5$\23\2"+
		"\u0194\u0195\7\b\2\2\u0195\u0197\3\2\2\2\u0196\u018f\3\2\2\2\u0196\u0190"+
		"\3\2\2\2\u0197!\3\2\2\2\u0198\u019b\5\62\32\2\u0199\u019b\5\64\33\2\u019a"+
		"\u0198\3\2\2\2\u019a\u0199\3\2\2\2\u019b#\3\2\2\2\u019c\u019f\5\u0086"+
		"D\2\u019d\u019f\5N(\2\u019e\u019c\3\2\2\2\u019e\u019d\3\2\2\2\u019f%\3"+
		"\2\2\2\u01a0\u01a1\5\60\31\2\u01a1\u01a2\7\6\2\2\u01a2\u01a3\7\7\2\2\u01a3"+
		"\u01a4\5(\25\2\u01a4\u01a5\7\b\2\2\u01a5\'\3\2\2\2\u01a6\u01aa\5*\26\2"+
		"\u01a7\u01aa\5,\27\2\u01a8\u01aa\5.\30\2\u01a9\u01a6\3\2\2\2\u01a9\u01a7"+
		"\3\2\2\2\u01a9\u01a8\3\2\2\2\u01aa)\3\2\2\2\u01ab\u01ac\5f\64\2\u01ac"+
		"+\3\2\2\2\u01ad\u01ae\5B\"\2\u01ae-\3\2\2\2\u01af\u01b0\5\u0104\u0083"+
		"\2\u01b0/\3\2\2\2\u01b1\u01b2\t\2\2\2\u01b2\61\3\2\2\2\u01b3\u01b4\7\60"+
		"\2\2\u01b4\63\3\2\2\2\u01b5\u01b6\7\61\2\2\u01b6\65\3\2\2\2\u01b7\u01b8"+
		"\7)\2\2\u01b8\u01b9\7\61\2\2\u01b9\67\3\2\2\2\u01ba\u01bb\5\4\3\2\u01bb"+
		"\u01bc\7\3\2\2\u01bc\u01bd\5:\36\2\u01bd\u01be\7\2\2\3\u01be9\3\2\2\2"+
		"\u01bf\u01c0\5<\37\2\u01c0;\3\2\2\2\u01c1\u01c2\5> \2\u01c2\u01c3\5F$"+
		"\2\u01c3=\3\2\2\2\u01c4\u01c5\5@!\2\u01c5?\3\2\2\2\u01c6\u01c7\7,\2\2"+
		"\u01c7\u01c8\5B\"\2\u01c8A\3\2\2\2\u01c9\u01ca\5D#\2\u01caC\3\2\2\2\u01cb"+
		"\u01cc\5\\/\2\u01ccE\3\2\2\2\u01cd\u01ce\7+\2\2\u01ce\u01d3\5H%\2\u01cf"+
		"\u01d0\7\4\2\2\u01d0\u01d2\5H%\2\u01d1\u01cf\3\2\2\2\u01d2\u01d5\3\2\2"+
		"\2\u01d3\u01d1\3\2\2\2\u01d3\u01d4\3\2\2\2\u01d4G\3\2\2\2\u01d5\u01d3"+
		"\3\2\2\2\u01d6\u01d7\5J&\2\u01d7\u01d8\7*\2\2\u01d8\u01d9\5L\'\2\u01d9"+
		"I\3\2\2\2\u01da\u01db\5\\/\2\u01dbK\3\2\2\2\u01dc\u01dd\5N(\2\u01ddM\3"+
		"\2\2\2\u01de\u01df\7\13\2\2\u01df\u01e0\7\f\2\2\u01e0\u01e1\5R*\2\u01e1"+
		"\u01e8\7\r\2\2\u01e2\u01e3\7\f\2\2\u01e3\u01e4\5R*\2\u01e4\u01e5\7\r\2"+
		"\2\u01e5\u01e7\3\2\2\2\u01e6\u01e2\3\2\2\2\u01e7\u01ea\3\2\2\2\u01e8\u01e6"+
		"\3\2\2\2\u01e8\u01e9\3\2\2\2\u01e9\u01fe\3\2\2\2\u01ea\u01e8\3\2\2\2\u01eb"+
		"\u01ec\5P)\2\u01ec\u01ed\7\f\2\2\u01ed\u01ee\5R*\2\u01ee\u01f5\7\r\2\2"+
		"\u01ef\u01f0\7\f\2\2\u01f0\u01f1\5R*\2\u01f1\u01f2\7\r\2\2\u01f2\u01f4"+
		"\3\2\2\2\u01f3\u01ef\3\2\2\2\u01f4\u01f7\3\2\2\2\u01f5\u01f3\3\2\2\2\u01f5"+
		"\u01f6\3\2\2\2\u01f6\u01fe\3\2\2\2\u01f7\u01f5\3\2\2\2\u01f8\u01f9\7\64"+
		"\2\2\u01f9\u01fa\7\f\2\2\u01fa\u01fb\5X-\2\u01fb\u01fc\7\r\2\2\u01fc\u01fe"+
		"\3\2\2\2\u01fd\u01de\3\2\2\2\u01fd\u01eb\3\2\2\2\u01fd\u01f8\3\2\2\2\u01fe"+
		"O\3\2\2\2\u01ff\u0200\7/\2\2\u0200Q\3\2\2\2\u0201\u0204\5T+\2\u0202\u0204"+
		"\5V,\2\u0203\u0201\3\2\2\2\u0203\u0202\3\2\2\2\u0204S\3\2\2\2\u0205\u0206"+
		"\7\60\2\2\u0206U\3\2\2\2\u0207\u020c\7/\2\2\u0208\u0209\7/\2\2\u0209\u020a"+
		"\7\16\2\2\u020a\u020c\7/\2\2\u020b\u0207\3\2\2\2\u020b\u0208\3\2\2\2\u020c"+
		"W\3\2\2\2\u020d\u020e\7/\2\2\u020eY\3\2\2\2\u020f\u0212\5\66\34\2\u0210"+
		"\u0212\5\\/\2\u0211\u020f\3\2\2\2\u0211\u0210\3\2\2\2\u0212[\3\2\2\2\u0213"+
		"\u0214\7/\2\2\u0214]\3\2\2\2\u0215\u0216\5\4\3\2\u0216\u021e\7\3\2\2\u0217"+
		"\u021f\5`\61\2\u0218\u0219\7\7\2\2\u0219\u021a\5b\62\2\u021a\u021b\7\6"+
		"\2\2\u021b\u021c\5`\61\2\u021c\u021d\7\b\2\2\u021d\u021f\3\2\2\2\u021e"+
		"\u0217\3\2\2\2\u021e\u0218\3\2\2\2\u021f_\3\2\2\2\u0220\u0222\5\u0096"+
		"L\2\u0221\u0223\5\u00a4S\2\u0222\u0221\3\2\2\2\u0222\u0223\3\2\2\2\u0223"+
		"\u0224\3\2\2\2\u0224\u0225\5d\63\2\u0225a\3\2\2\2\u0226\u0227\5l\67\2"+
		"\u0227c\3\2\2\2\u0228\u022c\7\17\2\2\u0229\u022d\5f\64\2\u022a\u022d\5"+
		"p9\2\u022b\u022d\5v<\2\u022c\u0229\3\2\2\2\u022c\u022a\3\2\2\2\u022c\u022b"+
		"\3\2\2\2\u022de\3\2\2\2\u022e\u022f\7\7\2\2\u022f\u0234\5h\65\2\u0230"+
		"\u0231\7\4\2\2\u0231\u0233\5h\65\2\u0232\u0230\3\2\2\2\u0233\u0236\3\2"+
		"\2\2\u0234\u0232\3\2\2\2\u0234\u0235\3\2\2\2\u0235\u0237\3\2\2\2\u0236"+
		"\u0234\3\2\2\2\u0237\u0238\7\b\2\2\u0238g\3\2\2\2\u0239\u023a\5j\66\2"+
		"\u023a\u023b\7\6\2\2\u023b\u023c\5n8\2\u023ci\3\2\2\2\u023d\u023e\5l\67"+
		"\2\u023ek\3\2\2\2\u023f\u0240\5\u0084C\2\u0240m\3\2\2\2\u0241\u0246\5"+
		"f\64\2\u0242\u0246\5p9\2\u0243\u0246\5v<\2\u0244\u0246\5x=\2\u0245\u0241"+
		"\3\2\2\2\u0245\u0242\3\2\2\2\u0245\u0243\3\2\2\2\u0245\u0244\3\2\2\2\u0246"+
		"o\3\2\2\2\u0247\u024a\5\u008aF\2\u0248\u024a\5r:\2\u0249\u0247\3\2\2\2"+
		"\u0249\u0248\3\2\2\2\u024aq\3\2\2\2\u024b\u024c\5t;\2\u024c\u024d\7\16"+
		"\2\2\u024d\u024e\7/\2\2\u024es\3\2\2\2\u024f\u0250\7/\2\2\u0250u\3\2\2"+
		"\2\u0251\u0252\5\"\22\2\u0252w\3\2\2\2\u0253\u0254\5`\61\2\u0254y\3\2"+
		"\2\2\u0255\u0259\5~@\2\u0256\u0259\5|?\2\u0257\u0259\5\u0080A\2\u0258"+
		"\u0255\3\2\2\2\u0258\u0256\3\2\2\2\u0258\u0257\3\2\2\2\u0259{\3\2\2\2"+
		"\u025a\u025b\5\u008aF\2\u025b}\3\2\2\2\u025c\u025d\5\"\22\2\u025d\177"+
		"\3\2\2\2\u025e\u025f\5\u0086D\2\u025f\u0081\3\2\2\2\u0260\u0261\7\67\2"+
		"\2\u0261\u0083\3\2\2\2\u0262\u0263\7\60\2\2\u0263\u0085\3\2\2\2\u0264"+
		"\u0266\5\u0088E\2\u0265\u0267\5\u008cG\2\u0266\u0265\3\2\2\2\u0267\u0268"+
		"\3\2\2\2\u0268\u0266\3\2\2\2\u0268\u0269\3\2\2\2\u0269\u0087\3\2\2\2\u026a"+
		"\u026b\5\u008aF\2\u026b\u0089\3\2\2\2\u026c\u026d\7/\2\2\u026d\u008b\3"+
		"\2\2\2\u026e\u0271\5\u008eH\2\u026f\u0271\5\u0090I\2\u0270\u026e\3\2\2"+
		"\2\u0270\u026f\3\2\2\2\u0271\u008d\3\2\2\2\u0272\u0273\7\16\2\2\u0273"+
		"\u0274\5\u0092J\2\u0274\u008f\3\2\2\2\u0275\u0276\7\f\2\2\u0276\u0277"+
		"\5\u0094K\2\u0277\u0278\7\r\2\2\u0278\u0091\3\2\2\2\u0279\u027a\7/\2\2"+
		"\u027a\u0093\3\2\2\2\u027b\u027c\5\u0082B\2\u027c\u0095\3\2\2\2\u027d"+
		"\u027e\7\20\2\2\u027e\u0283\5\u009aN\2\u027f\u0280\7\4\2\2\u0280\u0282"+
		"\5\u009aN\2\u0281\u027f\3\2\2\2\u0282\u0285\3\2\2\2\u0283\u0281\3\2\2"+
		"\2\u0283\u0284\3\2\2\2\u0284\u0097\3\2\2\2\u0285\u0283\3\2\2\2\u0286\u0287"+
		"\5\u009cO\2\u0287\u0288\7\21\2\2\u0288\u0290\5\u009eP\2\u0289\u028a\7"+
		"\4\2\2\u028a\u028b\5\u009cO\2\u028b\u028c\7\21\2\2\u028c\u028d\5\u009e"+
		"P\2\u028d\u028f\3\2\2\2\u028e\u0289\3\2\2\2\u028f\u0292\3\2\2\2\u0290"+
		"\u028e\3\2\2\2\u0290\u0291\3\2\2\2\u0291\u0099\3\2\2\2\u0292\u0290\3\2"+
		"\2\2\u0293\u0294\5\u009cO\2\u0294\u0295\7\21\2\2\u0295\u0296\5\u009eP"+
		"\2\u0296\u009b\3\2\2\2\u0297\u0298\5\u008aF\2\u0298\u009d\3\2\2\2\u0299"+
		"\u029a\5\u00a0Q\2\u029a\u009f\3\2\2\2\u029b\u029c\7\22\2\2\u029c\u029f"+
		"\5\u00a2R\2\u029d\u029f\5\u0086D\2\u029e\u029b\3\2\2\2\u029e\u029d\3\2"+
		"\2\2\u029f\u00a1\3\2\2\2\u02a0\u02a1\7/\2\2\u02a1\u00a3\3\2\2\2\u02a2"+
		"\u02a3\7\23\2\2\u02a3\u02a4\5\u00a6T\2\u02a4\u00a5\3\2\2\2\u02a5\u02a6"+
		"\bT\1\2\u02a6\u02a7\7\25\2\2\u02a7\u02a8\5\u00a8U\2\u02a8\u02a9\7\26\2"+
		"\2\u02a9\u02aa\5\u00a6T\4\u02aa\u02b1\3\2\2\2\u02ab\u02b1\5\u00b0Y\2\u02ac"+
		"\u02ad\7\t\2\2\u02ad\u02ae\5\u00a6T\2\u02ae\u02af\7\n\2\2\u02af\u02b1"+
		"\3\2\2\2\u02b0\u02a5\3\2\2\2\u02b0\u02ab\3\2\2\2\u02b0\u02ac\3\2\2\2\u02b1"+
		"\u02b7\3\2\2\2\u02b2\u02b3\f\5\2\2\u02b3\u02b4\7\24\2\2\u02b4\u02b6\5"+
		"\u00a6T\6\u02b5\u02b2\3\2\2\2\u02b6\u02b9\3\2\2\2\u02b7\u02b5\3\2\2\2"+
		"\u02b7\u02b8\3\2\2\2\u02b8\u00a7\3\2\2\2\u02b9\u02b7\3\2\2\2\u02ba\u02bf"+
		"\5\u00aaV\2\u02bb\u02bc\7\4\2\2\u02bc\u02be\5\u00aaV\2\u02bd\u02bb\3\2"+
		"\2\2\u02be\u02c1\3\2\2\2\u02bf\u02bd\3\2\2\2\u02bf\u02c0\3\2\2\2\u02c0"+
		"\u00a9\3\2\2\2\u02c1\u02bf\3\2\2\2\u02c2\u02c3\5\u00acW\2\u02c3\u02c4"+
		"\7\21\2\2\u02c4\u02c5\5\u00aeX\2\u02c5\u00ab\3\2\2\2\u02c6\u02c7\5\u008a"+
		"F\2\u02c7\u00ad\3\2\2\2\u02c8\u02c9\5\u00a0Q\2\u02c9\u00af\3\2\2\2\u02ca"+
		"\u02cb\5\u00b2Z\2\u02cb\u02cc\7\3\2\2\u02cc\u02cd\5\u00b4[\2\u02cd\u00b1"+
		"\3\2\2\2\u02ce\u02cf\5\u00b6\\\2\u02cf\u00b3\3\2\2\2\u02d0\u02d1\5\u00b6"+
		"\\\2\u02d1\u00b5\3\2\2\2\u02d2\u02d3\5z>\2\u02d3\u00b7\3\2\2\2\u02d4\u02d5"+
		"\5\4\3\2\u02d5\u02e1\7\3\2\2\u02d6\u02e2\5\u00dep\2\u02d7\u02d8\7\27\2"+
		"\2\u02d8\u02d9\5\u00ba^\2\u02d9\u02da\7\30\2\2\u02da\u02db\7\7\2\2\u02db"+
		"\u02dc\5\u00dep\2\u02dc\u02dd\7\b\2\2\u02dd\u02de\7\31\2\2\u02de\u02df"+
		"\5\u00bc_\2\u02df\u02e0\7\30\2\2\u02e0\u02e2\3\2\2\2\u02e1\u02d6\3\2\2"+
		"\2\u02e1\u02d7\3\2\2\2\u02e2\u00b9\3\2\2\2\u02e3\u02e4\5\u00d0i\2\u02e4"+
		"\u00bb\3\2\2\2\u02e5\u02e6\5\u00d0i\2\u02e6\u00bd\3\2\2\2\u02e7\u02ec"+
		"\5\u00c0a\2\u02e8\u02ec\5\u00c2b\2\u02e9\u02ec\5\u00c4c\2\u02ea\u02ec"+
		"\5\u00c6d\2\u02eb\u02e7\3\2\2\2\u02eb\u02e8\3\2\2\2\u02eb\u02e9\3\2\2"+
		"\2\u02eb\u02ea\3\2\2\2\u02ec\u00bf\3\2\2\2\u02ed\u02ee\7\27\2\2\u02ee"+
		"\u02f0\5\u00d0i\2\u02ef\u02f1\5\u00d2j\2\u02f0\u02ef\3\2\2\2\u02f0\u02f1"+
		"\3\2\2\2\u02f1\u02f2\3\2\2\2\u02f2\u02f3\7\32\2\2\u02f3\u02f4\5\u00ca"+
		"f\2\u02f4\u00c1\3\2\2\2\u02f5\u02f6\7\27\2\2\u02f6\u02f8\5\u00d0i\2\u02f7"+
		"\u02f9\5\u00d2j\2\u02f8\u02f7\3\2\2\2\u02f8\u02f9\3\2\2\2\u02f9\u02fa"+
		"\3\2\2\2\u02fa\u02fb\7\30\2\2\u02fb\u02fc\5\u00caf\2\u02fc\u02fd\5\u0084"+
		"C\2\u02fd\u02fe\7\31\2\2\u02fe\u02ff\5\u00d0i\2\u02ff\u0300\7\30\2\2\u0300"+
		"\u00c3\3\2\2\2\u0301\u0302\7\27\2\2\u0302\u0304\5\u00d0i\2\u0303\u0305"+
		"\5\u00d2j\2\u0304\u0303\3\2\2\2\u0304\u0305\3\2\2\2\u0305\u0306\3\2\2"+
		"\2\u0306\u0307\7\30\2\2\u0307\u0308\5\u00caf\2\u0308\u0309\7\7\2\2\u0309"+
		"\u030a\5\u00dco\2\u030a\u030b\7\b\2\2\u030b\u030c\7\31\2\2\u030c\u030d"+
		"\5\u00d0i\2\u030d\u030e\7\30\2\2\u030e\u00c5\3\2\2\2\u030f\u0310\7\27"+
		"\2\2\u0310\u0312\5\u00ccg\2\u0311\u0313\5\u00d2j\2\u0312\u0311\3\2\2\2"+
		"\u0312\u0313\3\2\2\2\u0313\u0314\3\2\2\2\u0314\u0315\7\30\2\2\u0315\u0316"+
		"\5\u00caf\2\u0316\u031b\5\u00c8e\2\u0317\u0318\7\4\2\2\u0318\u031a\5\u00c8"+
		"e\2\u0319\u0317\3\2\2\2\u031a\u031d\3\2\2\2\u031b\u0319\3\2\2\2\u031b"+
		"\u031c\3\2\2\2\u031c\u031e\3\2\2\2\u031d\u031b\3\2\2\2\u031e\u031f\7\31"+
		"\2\2\u031f\u0320\5\u00ceh\2\u0320\u0321\7\30\2\2\u0321\u00c7\3\2\2\2\u0322"+
		"\u0323\7\7\2\2\u0323\u0324\5\u00dep\2\u0324\u0325\7\b\2\2\u0325\u0328"+
		"\3\2\2\2\u0326\u0328\5\u00be`\2\u0327\u0322\3\2\2\2\u0327\u0326\3\2\2"+
		"\2\u0328\u00c9\3\2\2\2\u0329\u032a\3\2\2\2\u032a\u00cb\3\2\2\2\u032b\u032c"+
		"\5\u00d0i\2\u032c\u00cd\3\2\2\2\u032d\u032e\5\u00d0i\2\u032e\u00cf\3\2"+
		"\2\2\u032f\u0330\7/\2\2\u0330\u00d1\3\2\2\2\u0331\u0332\7\f\2\2\u0332"+
		"\u0333\5\u00d4k\2\u0333\u0334\7\3\2\2\u0334\u033c\5\u00d6l\2\u0335\u0336"+
		"\7\4\2\2\u0336\u0337\5\u00d4k\2\u0337\u0338\7\3\2\2\u0338\u0339\5\u00d6"+
		"l\2\u0339\u033b\3\2\2\2\u033a\u0335\3\2\2\2\u033b\u033e\3\2\2\2\u033c"+
		"\u033a\3\2\2\2\u033c\u033d\3\2\2\2\u033d\u033f\3\2\2\2\u033e\u033c\3\2"+
		"\2\2\u033f\u0340\7\r\2\2\u0340\u00d3\3\2\2\2\u0341\u0342\5t;\2\u0342\u00d5"+
		"\3\2\2\2\u0343\u0344\7\7\2\2\u0344\u0345\5\u00d8m\2\u0345\u0346\7\b\2"+
		"\2\u0346\u0349\3\2\2\2\u0347\u0349\5\u00dan\2\u0348\u0343\3\2\2\2\u0348"+
		"\u0347\3\2\2\2\u0349\u00d7\3\2\2\2\u034a\u034b\5\u00dco\2\u034b\u00d9"+
		"\3\2\2\2\u034c\u034d\5\u0084C\2\u034d\u00db\3\2\2\2\u034e\u034f\7/\2\2"+
		"\u034f\u00dd\3\2\2\2\u0350\u0351\5\u00e4s\2\u0351\u0352\5\u00e6t\2\u0352"+
		"\u00df\3\2\2\2\u0353\u0354\7\20\2\2\u0354\u0355\5\u00e8u\2\u0355\u0356"+
		"\7\21\2\2\u0356\u035e\5\u00eav\2\u0357\u0358\7\4\2\2\u0358\u0359\5\u00e8"+
		"u\2\u0359\u035a\7\21\2\2\u035a\u035b\5\u00eav\2\u035b\u035d\3\2\2\2\u035c"+
		"\u0357\3\2\2\2\u035d\u0360\3\2\2\2\u035e\u035c\3\2\2\2\u035e\u035f\3\2"+
		"\2\2\u035f\u00e1\3\2\2\2\u0360\u035e\3\2\2\2\u0361\u0362\7\23\2\2\u0362"+
		"\u0363\5\u00ecw\2\u0363\u00e3\3\2\2\2\u0364\u0366\5\u00e0q\2\u0365\u0367"+
		"\5\u00e2r\2\u0366\u0365\3\2\2\2\u0366\u0367\3\2\2\2\u0367\u00e5\3\2\2"+
		"\2\u0368\u036c\7\17\2\2\u0369\u036d\5\u0100\u0081\2\u036a\u036d\5\u0102"+
		"\u0082\2\u036b\u036d\5\u0104\u0083\2\u036c\u0369\3\2\2\2\u036c\u036a\3"+
		"\2\2\2\u036c\u036b\3\2\2\2\u036d\u00e7\3\2\2\2\u036e\u036f\5\u00dco\2"+
		"\u036f\u00e9\3\2\2\2\u0370\u0371\5\u011a\u008e\2\u0371\u00eb\3\2\2\2\u0372"+
		"\u0373\bw\1\2\u0373\u0374\5\u00eex\2\u0374\u0375\7\26\2\2\u0375\u0376"+
		"\5\u00ecw\3\u0376\u037d\3\2\2\2\u0377\u037d\5\u00f4{\2\u0378\u0379\7\t"+
		"\2\2\u0379\u037a\5\u00ecw\2\u037a\u037b\7\n\2\2\u037b\u037d\3\2\2\2\u037c"+
		"\u0372\3\2\2\2\u037c\u0377\3\2\2\2\u037c\u0378\3\2\2\2\u037d\u0383\3\2"+
		"\2\2\u037e\u037f\f\4\2\2\u037f\u0380\7\24\2\2\u0380\u0382\5\u00ecw\5\u0381"+
		"\u037e\3\2\2\2\u0382\u0385\3\2\2\2\u0383\u0381\3\2\2\2\u0383\u0384\3\2"+
		"\2\2\u0384\u00ed\3\2\2\2\u0385\u0383\3\2\2\2\u0386\u0387\7\25\2\2\u0387"+
		"\u0388\5\u00f0y\2\u0388\u0389\7\21\2\2\u0389\u0391\5\u00f2z\2\u038a\u038b"+
		"\7\4\2\2\u038b\u038c\5\u00f0y\2\u038c\u038d\7\21\2\2\u038d\u038e\5\u00f2"+
		"z\2\u038e\u0390\3\2\2\2\u038f\u038a\3\2\2\2\u0390\u0393\3\2\2\2\u0391"+
		"\u038f\3\2\2\2\u0391\u0392\3\2\2\2\u0392\u00ef\3\2\2\2\u0393\u0391\3\2"+
		"\2\2\u0394\u0395\5\u00dco\2\u0395\u00f1\3\2\2\2\u0396\u0397\5\u0112\u008a"+
		"\2\u0397\u00f3\3\2\2\2\u0398\u0399\5\u00f6|\2\u0399\u039a\7\3\2\2\u039a"+
		"\u039b\5\u00f8}\2\u039b\u00f5\3\2\2\2\u039c\u039d\5\u00b6\\\2\u039d\u00f7"+
		"\3\2\2\2\u039e\u039f\5\u00b6\\\2\u039f\u00f9\3\2\2\2\u03a0\u03a1\5\u0112"+
		"\u008a\2\u03a1\u00fb\3\2\2\2\u03a2\u03a3\5\u00dco\2\u03a3\u00fd\3\2\2"+
		"\2\u03a4\u03a5\5\u0084C\2\u03a5\u00ff\3\2\2\2\u03a6\u03a7\5\u00dco\2\u03a7"+
		"\u0101\3\2\2\2\u03a8\u03a9\5\u0084C\2\u03a9\u0103\3\2\2\2\u03aa\u03ab"+
		"\5\u00be`\2\u03ab\u0105\3\2\2\2\u03ac\u03ad\b\u0084\1\2\u03ad\u03b1\5"+
		"\u010c\u0087\2\u03ae\u03b1\5\u010e\u0088\2\u03af\u03b1\5\u0110\u0089\2"+
		"\u03b0\u03ac\3\2\2\2\u03b0\u03ae\3\2\2\2\u03b0\u03af\3\2\2\2\u03b1\u03bb"+
		"\3\2\2\2\u03b2\u03b5\f\3\2\2\u03b3\u03b6\5\u0108\u0085\2\u03b4\u03b6\5"+
		"\u010a\u0086\2\u03b5\u03b3\3\2\2\2\u03b5\u03b4\3\2\2\2\u03b6\u03b7\3\2"+
		"\2\2\u03b7\u03b8\5\u0106\u0084\4\u03b8\u03ba\3\2\2\2\u03b9\u03b2\3\2\2"+
		"\2\u03ba\u03bd\3\2\2\2\u03bb\u03b9\3\2\2\2\u03bb\u03bc\3\2\2\2\u03bc\u0107"+
		"\3\2\2\2\u03bd\u03bb\3\2\2\2\u03be\u03bf\7\33\2\2\u03bf\u0109\3\2\2\2"+
		"\u03c0\u03c1\7\34\2\2\u03c1\u010b\3\2\2\2\u03c2\u03c3\5\u00d0i\2\u03c3"+
		"\u010d\3\2\2\2\u03c4\u03c5\5\u00d0i\2\u03c5\u03c6\7\35\2\2\u03c6\u03c7"+
		"\5t;\2\u03c7\u010f\3\2\2\2\u03c8\u03c9\7\36\2\2\u03c9\u0111\3\2\2\2\u03ca"+
		"\u03cd\5\u0114\u008b\2\u03cb\u03ce\5\u0108\u0085\2\u03cc\u03ce\5\u010a"+
		"\u0086\2\u03cd\u03cb\3\2\2\2\u03cd\u03cc\3\2\2\2\u03ce\u03cf\3\2\2\2\u03cf"+
		"\u03d0\5\u0106\u0084\2\u03d0\u03da\3\2\2\2\u03d1\u03d4\5\u00dco\2\u03d2"+
		"\u03d5\5\u0108\u0085\2\u03d3\u03d5\5\u010a\u0086\2\u03d4\u03d2\3\2\2\2"+
		"\u03d4\u03d3\3\2\2\2\u03d5\u03d6\3\2\2\2\u03d6\u03d7\5\u0106\u0084\2\u03d7"+
		"\u03da\3\2\2\2\u03d8\u03da\5\u0118\u008d\2\u03d9\u03ca\3\2\2\2\u03d9\u03d1"+
		"\3\2\2\2\u03d9\u03d8\3\2\2\2\u03da\u0113\3\2\2\2\u03db\u03dc\7\37\2\2"+
		"\u03dc\u03dd\5\u0116\u008c\2\u03dd\u03de\7\n\2\2\u03de\u0115\3\2\2\2\u03df"+
		"\u03e0\7/\2\2\u03e0\u0117\3\2\2\2\u03e1\u03e2\5\u00dco\2\u03e2\u03e3\7"+
		"\35\2\2\u03e3\u03e4\5t;\2\u03e4\u0119\3\2\2\2\u03e5\u03e8\5\u0112\u008a"+
		"\2\u03e6\u03e8\5\u0106\u0084\2\u03e7\u03e5\3\2\2\2\u03e7\u03e6\3\2\2\2"+
		"\u03e8\u011b\3\2\2\2\u03e9\u03ea\5\4\3\2\u03ea\u03eb\7\3\2\2\u03eb\u03ec"+
		"\5\u011e\u0090\2\u03ec\u03ed\7\2\2\3\u03ed\u011d\3\2\2\2\u03ee\u03ef\5"+
		"\u0120\u0091\2\u03ef\u011f\3\2\2\2\u03f0\u03f1\5\u0124\u0093\2\u03f1\u03f2"+
		"\5\u0122\u0092\2\u03f2\u0121\3\2\2\2\u03f3\u03f5\5\u012a\u0096\2\u03f4"+
		"\u03f6\5\u0134\u009b\2\u03f5\u03f4\3\2\2\2\u03f5\u03f6\3\2\2\2\u03f6\u0123"+
		"\3\2\2\2\u03f7\u03f8\5\u0126\u0094\2\u03f8\u0125\3\2\2\2\u03f9\u03fa\7"+
		",\2\2\u03fa\u03ff\5\u0128\u0095\2\u03fb\u03fc\7\4\2\2\u03fc\u03fe\5\u0128"+
		"\u0095\2\u03fd\u03fb\3\2\2\2\u03fe\u0401\3\2\2\2\u03ff\u03fd\3\2\2\2\u03ff"+
		"\u0400\3\2\2\2\u0400\u0127\3\2\2\2\u0401\u03ff\3\2\2\2\u0402\u0405\5\u013a"+
		"\u009e\2\u0403\u0405\7/\2\2\u0404\u0402\3\2\2\2\u0404\u0403\3\2\2\2\u0405"+
		"\u0129\3\2\2\2\u0406\u0407\7+\2\2\u0407\u040c\5\u012c\u0097\2\u0408\u0409"+
		"\7\4\2\2\u0409\u040b\5\u012c\u0097\2\u040a\u0408\3\2\2\2\u040b\u040e\3"+
		"\2\2\2\u040c\u040a\3\2\2\2\u040c\u040d\3\2\2\2\u040d\u012b\3\2\2\2\u040e"+
		"\u040c\3\2\2\2\u040f\u0410\5\u012e\u0098\2\u0410\u0411\7-\2\2\u0411\u0412"+
		"\5\u0132\u009a\2\u0412\u012d\3\2\2\2\u0413\u0414\5\u0130\u0099\2\u0414"+
		"\u012f\3\2\2\2\u0415\u0416\7/\2\2\u0416\u0131\3\2\2\2\u0417\u0418\7/\2"+
		"\2\u0418\u0133\3\2\2\2\u0419\u041a\5\u0136\u009c\2\u041a\u0135\3\2\2\2"+
		"\u041b\u041c\7\5\2\2\u041c\u041d\5\u0138\u009d\2\u041d\u0137\3\2\2\2\u041e"+
		"\u041f\b\u009d\1\2\u041f\u0426\5\u013c\u009f\2\u0420\u0426\5\u013e\u00a0"+
		"\2\u0421\u0422\7\t\2\2\u0422\u0423\5\u0138\u009d\2\u0423\u0424\7\n\2\2"+
		"\u0424\u0426\3\2\2\2\u0425\u041e\3\2\2\2\u0425\u0420\3\2\2\2\u0425\u0421"+
		"\3\2\2\2\u0426\u042c\3\2\2\2\u0427\u0428\f\4\2\2\u0428\u0429\7(\2\2\u0429"+
		"\u042b\5\u0138\u009d\5\u042a\u0427\3\2\2\2\u042b\u042e\3\2\2\2\u042c\u042a"+
		"\3\2\2\2\u042c\u042d\3\2\2\2\u042d\u0139\3\2\2\2\u042e\u042c\3\2\2\2\u042f"+
		"\u0430\5\u0144\u00a3\2\u0430\u0431\7\16\2\2\u0431\u0432\7/\2\2\u0432\u0435"+
		"\3\2\2\2\u0433\u0435\7\60\2\2\u0434\u042f\3\2\2\2\u0434\u0433\3\2\2\2"+
		"\u0435\u013b\3\2\2\2\u0436\u0437\5\u0140\u00a1\2\u0437\u0438\7\3\2\2\u0438"+
		"\u0439\5\u0142\u00a2\2\u0439\u013d\3\2\2\2\u043a\u043b\5\u013a\u009e\2"+
		"\u043b\u043c\7.\2\2\u043c\u043d\7\60\2\2\u043d\u013f\3\2\2\2\u043e\u043f"+
		"\5\u013a\u009e\2\u043f\u0141\3\2\2\2\u0440\u0441\5\u013a\u009e\2\u0441"+
		"\u0143\3\2\2\2\u0442\u0443\7/\2\2\u0443\u0145\3\2\2\2A\u0151\u0154\u015c"+
		"\u016f\u0173\u0181\u0188\u0196\u019a\u019e\u01a9\u01d3\u01e8\u01f5\u01fd"+
		"\u0203\u020b\u0211\u021e\u0222\u022c\u0234\u0245\u0249\u0258\u0268\u0270"+
		"\u0283\u0290\u029e\u02b0\u02b7\u02bf\u02e1\u02eb\u02f0\u02f8\u0304\u0312"+
		"\u031b\u0327\u033c\u0348\u035e\u0366\u036c\u037c\u0383\u0391\u03b0\u03b5"+
		"\u03bb\u03cd\u03d4\u03d9\u03e7\u03f5\u03ff\u0404\u040c\u0425\u042c\u0434";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}