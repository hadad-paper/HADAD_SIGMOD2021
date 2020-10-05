// Generated from QBTM.g4 by ANTLR 4.7.2

package hadad.base.qbt.walker;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QBTMParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, FOR=27, WHERE=28, RETURN=29, AJ=30, RK=31, PR=32, 
		SPPJ=33, PJ=34, SJ=35, XQ=36, TQ=37, AND=38, FROM=39, IN=40, SELECT=41, 
		VALUE=42, AS=43, LIKE=44, QUERY=45, USE=46, NAME=47, STRING=48, INTEGER=49, 
		WHITESPACE=50, MAP=51, KEYS=52, LIST=53, SET=54, MAIN=55, BETA=56, WS=57, 
		SELECTT=58, JSONBUILDOBJECT=59, JSONARRAYELEMENTS=60, INT=61;
	public static final int
		RULE_mixedqbt = 0, RULE_viewName = 1, RULE_qbtQuery = 2, RULE_qbtBlock = 3, 
		RULE_qbtForPattern = 4, RULE_qbtWherePattern = 5, RULE_qbtReturnPattern = 6, 
		RULE_qbtPattern = 7, RULE_modelPattern = 8, RULE_ajPattern = 9, RULE_rkPattern = 10, 
		RULE_prPattern = 11, RULE_sppjPattern = 12, RULE_pjPattern = 13, RULE_sjPattern = 14, 
		RULE_qbtCondition = 15, RULE_qbtAtom = 16, RULE_qbtTermLeft = 17, RULE_qbtTermRight = 18, 
		RULE_qbtTerm = 19, RULE_qbtVariable = 20, RULE_modelPathExpr = 21, RULE_constructor = 22, 
		RULE_modelConstructor = 23, RULE_ajConstructor = 24, RULE_rkConstructor = 25, 
		RULE_prConstructor = 26, RULE_sjConstructor = 27, RULE_sppjConstructor = 28, 
		RULE_annotation = 29, RULE_kqlquery = 30, RULE_redisKQLQuery = 31, RULE_sfwQuery = 32, 
		RULE_rkSelectClasue = 33, RULE_rkSelectStatement = 34, RULE_rkSelectItem = 35, 
		RULE_rkReturnVariable = 36, RULE_mapConstructor = 37, RULE_rkAttribute = 38, 
		RULE_rkAttributeValue = 39, RULE_mapKey = 40, RULE_rkFromClasue = 41, 
		RULE_varBinding = 42, RULE_fromvariableBinding = 43, RULE_rkSource = 44, 
		RULE_rkLookUpExpression = 45, RULE_mainMap = 46, RULE_mapVariable = 47, 
		RULE_rkKey = 48, RULE_rkStringKey = 49, RULE_variableKey = 50, RULE_keyVariable = 51, 
		RULE_mapName = 52, RULE_rkVariable = 53, RULE_aqlquery = 54, RULE_query = 55, 
		RULE_rootFieldName = 56, RULE_returnClause = 57, RULE_recordConstruct = 58, 
		RULE_fieldBinding = 59, RULE_recordConstructFieldName = 60, RULE_fieldName = 61, 
		RULE_fieldValue = 62, RULE_returnVar = 63, RULE_name = 64, RULE_returnConstant = 65, 
		RULE_returnQuery = 66, RULE_term = 67, RULE_termVar = 68, RULE_termConstant = 69, 
		RULE_termPath = 70, RULE_constant = 71, RULE_number = 72, RULE_path = 73, 
		RULE_pathVar = 74, RULE_var = 75, RULE_step = 76, RULE_objectStep = 77, 
		RULE_arrayStep = 78, RULE_key = 79, RULE_index = 80, RULE_forClause = 81, 
		RULE_binding = 82, RULE_forClauseBindingVar = 83, RULE_forClauseBindingSource = 84, 
		RULE_source = 85, RULE_dataSetName = 86, RULE_whereClause = 87, RULE_condition = 88, 
		RULE_whereCondSome = 89, RULE_whereCondBinding = 90, RULE_whereCondBindingVar = 91, 
		RULE_whereCondBindingSource = 92, RULE_whereCondEquality = 93, RULE_whereCondEqualityLeftTerm = 94, 
		RULE_whereCondEqualityRightTerm = 95, RULE_cterm = 96, RULE_forWhereClauses = 97, 
		RULE_rqQuery = 98, RULE_prQuery = 99, RULE_prSfwQuery = 100, RULE_prFromWhereClauses = 101, 
		RULE_prSelectClause = 102, RULE_prSelectStatement = 103, RULE_prSelectItem = 104, 
		RULE_prSelectVar = 105, RULE_prFromClause = 106, RULE_prRelationBinding = 107, 
		RULE_prSource = 108, RULE_prRelationName = 109, RULE_prVariable = 110, 
		RULE_prWhereClause = 111, RULE_prWhereStatement = 112, RULE_prCondition = 113, 
		RULE_prTerm = 114, RULE_prEquality = 115, RULE_prLikeExpression = 116, 
		RULE_prLeftterm = 117, RULE_prRightterm = 118, RULE_realtion = 119, RULE_sjqlquery = 120, 
		RULE_sjQuery = 121, RULE_sjCollectionName = 122, RULE_sjTextSearch = 123, 
		RULE_sjLeftTerm = 124, RULE_sjRightTerm = 125, RULE_sjTerm = 126, RULE_sjProjectFields = 127, 
		RULE_sjRecordConstruct = 128, RULE_sjAttribute = 129, RULE_sjFieldName = 130, 
		RULE_sjKeyName = 131, RULE_sjConstant = 132, RULE_pjqlQuery = 133, RULE_pjQuery = 134, 
		RULE_pjSelectClause = 135, RULE_pjSelectStatement = 136, RULE_pjSelectItem = 137, 
		RULE_pjRecordConstruct = 138, RULE_pjFieldBinding = 139, RULE_pjRecordConstructFieldName = 140, 
		RULE_pjFieldValue = 141, RULE_pjSelectVar = 142, RULE_pjPathScalar = 143, 
		RULE_pjSelectConstant = 144, RULE_pjSelectQuery = 145, RULE_cast = 146, 
		RULE_pjFromWhereClause = 147, RULE_pjFromClause = 148, RULE_pjBinding = 149, 
		RULE_pjFromClauseBindingSource = 150, RULE_pjSource = 151, RULE_pjFromClauseBindingVar = 152, 
		RULE_pjWhereClause = 153, RULE_pjCondition = 154, RULE_pjWhereCondEquality = 155, 
		RULE_pjWhereCondEqualityLeftTerm = 156, RULE_pjWhereCondEqualityRightTerm = 157, 
		RULE_pjCTerm = 158, RULE_pjTerm = 159, RULE_pjTermVar = 160, RULE_pjTermConstant = 161, 
		RULE_pjTermPath = 162, RULE_pjPath = 163, RULE_pjPathVar = 164, RULE_pjStep = 165, 
		RULE_pjObjStep = 166, RULE_pjStepScalar = 167, RULE_pjObjStepScalar = 168, 
		RULE_pjPathAttr = 169, RULE_pjVariable = 170, RULE_pjRelation = 171, RULE_pjKey = 172, 
		RULE_pjConstant = 173, RULE_attribute = 174, RULE_sppjqlQuery = 175, RULE_sppjQuery = 176, 
		RULE_sppjRootFieldName = 177, RULE_sppjSelectClause = 178, RULE_sppjSelectStatement = 179, 
		RULE_sppjSelectItem = 180, RULE_sppjRootRecordConstruct = 181, RULE_sppjRecordConstruct = 182, 
		RULE_sppjFieldBinding = 183, RULE_sppjRecordConstructFieldName = 184, 
		RULE_sppjFieldValue = 185, RULE_sppjSelectVar = 186, RULE_sppjSelectConstant = 187, 
		RULE_sppjSelectQuery = 188, RULE_sppjFromWhereClause = 189, RULE_sppjFromClause = 190, 
		RULE_sppjBinding = 191, RULE_sppjFromClauseBindingSource = 192, RULE_sppjSource = 193, 
		RULE_sppjFromClauseBindingVar = 194, RULE_sppjWhereClause = 195, RULE_sppjCondition = 196, 
		RULE_sppjWhereCondEquality = 197, RULE_sppjWhereCondEqualityLeftTerm = 198, 
		RULE_sppjWhereCondEqualityRightTerm = 199, RULE_sppjCTerm = 200, RULE_sppjTerm = 201, 
		RULE_sppjTermVar = 202, RULE_sppjTermConstant = 203, RULE_sppjTermPath = 204, 
		RULE_sppjPath = 205, RULE_sppjPathVar = 206, RULE_sppjStep = 207, RULE_sppjObjStep = 208, 
		RULE_sppjVariable = 209, RULE_sppjFieldName = 210, RULE_sppjConstant = 211;
	private static String[] makeRuleNames() {
		return new String[] {
			"mixedqbt", "viewName", "qbtQuery", "qbtBlock", "qbtForPattern", "qbtWherePattern", 
			"qbtReturnPattern", "qbtPattern", "modelPattern", "ajPattern", "rkPattern", 
			"prPattern", "sppjPattern", "pjPattern", "sjPattern", "qbtCondition", 
			"qbtAtom", "qbtTermLeft", "qbtTermRight", "qbtTerm", "qbtVariable", "modelPathExpr", 
			"constructor", "modelConstructor", "ajConstructor", "rkConstructor", 
			"prConstructor", "sjConstructor", "sppjConstructor", "annotation", "kqlquery", 
			"redisKQLQuery", "sfwQuery", "rkSelectClasue", "rkSelectStatement", "rkSelectItem", 
			"rkReturnVariable", "mapConstructor", "rkAttribute", "rkAttributeValue", 
			"mapKey", "rkFromClasue", "varBinding", "fromvariableBinding", "rkSource", 
			"rkLookUpExpression", "mainMap", "mapVariable", "rkKey", "rkStringKey", 
			"variableKey", "keyVariable", "mapName", "rkVariable", "aqlquery", "query", 
			"rootFieldName", "returnClause", "recordConstruct", "fieldBinding", "recordConstructFieldName", 
			"fieldName", "fieldValue", "returnVar", "name", "returnConstant", "returnQuery", 
			"term", "termVar", "termConstant", "termPath", "constant", "number", 
			"path", "pathVar", "var", "step", "objectStep", "arrayStep", "key", "index", 
			"forClause", "binding", "forClauseBindingVar", "forClauseBindingSource", 
			"source", "dataSetName", "whereClause", "condition", "whereCondSome", 
			"whereCondBinding", "whereCondBindingVar", "whereCondBindingSource", 
			"whereCondEquality", "whereCondEqualityLeftTerm", "whereCondEqualityRightTerm", 
			"cterm", "forWhereClauses", "rqQuery", "prQuery", "prSfwQuery", "prFromWhereClauses", 
			"prSelectClause", "prSelectStatement", "prSelectItem", "prSelectVar", 
			"prFromClause", "prRelationBinding", "prSource", "prRelationName", "prVariable", 
			"prWhereClause", "prWhereStatement", "prCondition", "prTerm", "prEquality", 
			"prLikeExpression", "prLeftterm", "prRightterm", "realtion", "sjqlquery", 
			"sjQuery", "sjCollectionName", "sjTextSearch", "sjLeftTerm", "sjRightTerm", 
			"sjTerm", "sjProjectFields", "sjRecordConstruct", "sjAttribute", "sjFieldName", 
			"sjKeyName", "sjConstant", "pjqlQuery", "pjQuery", "pjSelectClause", 
			"pjSelectStatement", "pjSelectItem", "pjRecordConstruct", "pjFieldBinding", 
			"pjRecordConstructFieldName", "pjFieldValue", "pjSelectVar", "pjPathScalar", 
			"pjSelectConstant", "pjSelectQuery", "cast", "pjFromWhereClause", "pjFromClause", 
			"pjBinding", "pjFromClauseBindingSource", "pjSource", "pjFromClauseBindingVar", 
			"pjWhereClause", "pjCondition", "pjWhereCondEquality", "pjWhereCondEqualityLeftTerm", 
			"pjWhereCondEqualityRightTerm", "pjCTerm", "pjTerm", "pjTermVar", "pjTermConstant", 
			"pjTermPath", "pjPath", "pjPathVar", "pjStep", "pjObjStep", "pjStepScalar", 
			"pjObjStepScalar", "pjPathAttr", "pjVariable", "pjRelation", "pjKey", 
			"pjConstant", "attribute", "sppjqlQuery", "sppjQuery", "sppjRootFieldName", 
			"sppjSelectClause", "sppjSelectStatement", "sppjSelectItem", "sppjRootRecordConstruct", 
			"sppjRecordConstruct", "sppjFieldBinding", "sppjRecordConstructFieldName", 
			"sppjFieldValue", "sppjSelectVar", "sppjSelectConstant", "sppjSelectQuery", 
			"sppjFromWhereClause", "sppjFromClause", "sppjBinding", "sppjFromClauseBindingSource", 
			"sppjSource", "sppjFromClauseBindingVar", "sppjWhereClause", "sppjCondition", 
			"sppjWhereCondEquality", "sppjWhereCondEqualityLeftTerm", "sppjWhereCondEqualityRightTerm", 
			"sppjCTerm", "sppjTerm", "sppjTermVar", "sppjTermConstant", "sppjTermPath", 
			"sppjPath", "sppjPathVar", "sppjStep", "sppjObjStep", "sppjVariable", 
			"sppjFieldName", "sppjConstant"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "','", "':'", "'{'", "'}'", "'('", "')'", "'->'", "'.'", 
			"'['", "']'", "'return'", "'for'", "'in'", "'dataset'", "'where'", "'and'", 
			"'some'", "'satisfies'", "'/'", "'?q='", "'&'", "'fl='", "'::INT '", 
			"'->>'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "FOR", "WHERE", "RETURN", "AJ", "RK", "PR", "SPPJ", 
			"PJ", "SJ", "XQ", "TQ", "AND", "FROM", "IN", "SELECT", "VALUE", "AS", 
			"LIKE", "QUERY", "USE", "NAME", "STRING", "INTEGER", "WHITESPACE", "MAP", 
			"KEYS", "LIST", "SET", "MAIN", "BETA", "WS", "SELECTT", "JSONBUILDOBJECT", 
			"JSONARRAYELEMENTS", "INT"
		};
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
	public String getGrammarFileName() { return "QBTM.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public QBTMParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class MixedqbtContext extends ParserRuleContext {
		public ViewNameContext viewName() {
			return getRuleContext(ViewNameContext.class,0);
		}
		public QbtQueryContext qbtQuery() {
			return getRuleContext(QbtQueryContext.class,0);
		}
		public TerminalNode EOF() { return getToken(QBTMParser.EOF, 0); }
		public MixedqbtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mixedqbt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterMixedqbt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitMixedqbt(this);
		}
	}

	public final MixedqbtContext mixedqbt() throws RecognitionException {
		MixedqbtContext _localctx = new MixedqbtContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_mixedqbt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(424);
			viewName();
			setState(425);
			match(T__0);
			setState(426);
			qbtQuery();
			setState(427);
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

	public static class ViewNameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(QBTMParser.NAME, 0); }
		public ViewNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_viewName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterViewName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitViewName(this);
		}
	}

	public final ViewNameContext viewName() throws RecognitionException {
		ViewNameContext _localctx = new ViewNameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_viewName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(429);
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

	public static class QbtQueryContext extends ParserRuleContext {
		public QbtBlockContext qbtBlock() {
			return getRuleContext(QbtBlockContext.class,0);
		}
		public QbtQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qbtQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterQbtQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitQbtQuery(this);
		}
	}

	public final QbtQueryContext qbtQuery() throws RecognitionException {
		QbtQueryContext _localctx = new QbtQueryContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_qbtQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(431);
			qbtBlock();
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

	public static class QbtBlockContext extends ParserRuleContext {
		public QbtForPatternContext qbtForPattern() {
			return getRuleContext(QbtForPatternContext.class,0);
		}
		public QbtReturnPatternContext qbtReturnPattern() {
			return getRuleContext(QbtReturnPatternContext.class,0);
		}
		public QbtWherePatternContext qbtWherePattern() {
			return getRuleContext(QbtWherePatternContext.class,0);
		}
		public QbtBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qbtBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterQbtBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitQbtBlock(this);
		}
	}

	public final QbtBlockContext qbtBlock() throws RecognitionException {
		QbtBlockContext _localctx = new QbtBlockContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_qbtBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(433);
			qbtForPattern();
			setState(435);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(434);
				qbtWherePattern();
				}
			}

			setState(437);
			qbtReturnPattern();
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

	public static class QbtForPatternContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(QBTMParser.FOR, 0); }
		public List<QbtPatternContext> qbtPattern() {
			return getRuleContexts(QbtPatternContext.class);
		}
		public QbtPatternContext qbtPattern(int i) {
			return getRuleContext(QbtPatternContext.class,i);
		}
		public QbtForPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qbtForPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterQbtForPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitQbtForPattern(this);
		}
	}

	public final QbtForPatternContext qbtForPattern() throws RecognitionException {
		QbtForPatternContext _localctx = new QbtForPatternContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_qbtForPattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(439);
			match(FOR);
			setState(440);
			qbtPattern();
			setState(445);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(441);
				match(T__1);
				setState(442);
				qbtPattern();
				}
				}
				setState(447);
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

	public static class QbtWherePatternContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(QBTMParser.WHERE, 0); }
		public QbtConditionContext qbtCondition() {
			return getRuleContext(QbtConditionContext.class,0);
		}
		public QbtWherePatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qbtWherePattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterQbtWherePattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitQbtWherePattern(this);
		}
	}

	public final QbtWherePatternContext qbtWherePattern() throws RecognitionException {
		QbtWherePatternContext _localctx = new QbtWherePatternContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_qbtWherePattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(448);
			match(WHERE);
			setState(449);
			qbtCondition(0);
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

	public static class QbtReturnPatternContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(QBTMParser.RETURN, 0); }
		public ConstructorContext constructor() {
			return getRuleContext(ConstructorContext.class,0);
		}
		public QbtReturnPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qbtReturnPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterQbtReturnPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitQbtReturnPattern(this);
		}
	}

	public final QbtReturnPatternContext qbtReturnPattern() throws RecognitionException {
		QbtReturnPatternContext _localctx = new QbtReturnPatternContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_qbtReturnPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(451);
			match(RETURN);
			setState(452);
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

	public static class QbtPatternContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public ModelPatternContext modelPattern() {
			return getRuleContext(ModelPatternContext.class,0);
		}
		public QbtPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qbtPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterQbtPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitQbtPattern(this);
		}
	}

	public final QbtPatternContext qbtPattern() throws RecognitionException {
		QbtPatternContext _localctx = new QbtPatternContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_qbtPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(454);
			annotation();
			setState(455);
			match(T__2);
			setState(456);
			match(T__3);
			setState(457);
			modelPattern();
			setState(458);
			match(T__4);
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
		public AjPatternContext ajPattern() {
			return getRuleContext(AjPatternContext.class,0);
		}
		public RkPatternContext rkPattern() {
			return getRuleContext(RkPatternContext.class,0);
		}
		public PrPatternContext prPattern() {
			return getRuleContext(PrPatternContext.class,0);
		}
		public SppjPatternContext sppjPattern() {
			return getRuleContext(SppjPatternContext.class,0);
		}
		public PjPatternContext pjPattern() {
			return getRuleContext(PjPatternContext.class,0);
		}
		public SjPatternContext sjPattern() {
			return getRuleContext(SjPatternContext.class,0);
		}
		public ModelPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modelPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterModelPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitModelPattern(this);
		}
	}

	public final ModelPatternContext modelPattern() throws RecognitionException {
		ModelPatternContext _localctx = new ModelPatternContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_modelPattern);
		try {
			setState(466);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(460);
				ajPattern();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(461);
				rkPattern();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(462);
				prPattern();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(463);
				sppjPattern();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(464);
				pjPattern();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(465);
				sjPattern();
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

	public static class AjPatternContext extends ParserRuleContext {
		public ForClauseContext forClause() {
			return getRuleContext(ForClauseContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public AjPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ajPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterAjPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitAjPattern(this);
		}
	}

	public final AjPatternContext ajPattern() throws RecognitionException {
		AjPatternContext _localctx = new AjPatternContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_ajPattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(468);
			forClause();
			setState(470);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(469);
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

	public static class RkPatternContext extends ParserRuleContext {
		public RkFromClasueContext rkFromClasue() {
			return getRuleContext(RkFromClasueContext.class,0);
		}
		public RkPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rkPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterRkPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitRkPattern(this);
		}
	}

	public final RkPatternContext rkPattern() throws RecognitionException {
		RkPatternContext _localctx = new RkPatternContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_rkPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(472);
			rkFromClasue();
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

	public static class PrPatternContext extends ParserRuleContext {
		public PrQueryContext prQuery() {
			return getRuleContext(PrQueryContext.class,0);
		}
		public PrPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPrPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPrPattern(this);
		}
	}

	public final PrPatternContext prPattern() throws RecognitionException {
		PrPatternContext _localctx = new PrPatternContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_prPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(474);
			prQuery();
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

	public static class SppjPatternContext extends ParserRuleContext {
		public SppjQueryContext sppjQuery() {
			return getRuleContext(SppjQueryContext.class,0);
		}
		public SppjPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjPattern(this);
		}
	}

	public final SppjPatternContext sppjPattern() throws RecognitionException {
		SppjPatternContext _localctx = new SppjPatternContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_sppjPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(476);
			sppjQuery();
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

	public static class PjPatternContext extends ParserRuleContext {
		public PjQueryContext pjQuery() {
			return getRuleContext(PjQueryContext.class,0);
		}
		public PjPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjPattern(this);
		}
	}

	public final PjPatternContext pjPattern() throws RecognitionException {
		PjPatternContext _localctx = new PjPatternContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_pjPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(478);
			pjQuery();
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

	public static class SjPatternContext extends ParserRuleContext {
		public SjQueryContext sjQuery() {
			return getRuleContext(SjQueryContext.class,0);
		}
		public SjPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sjPattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSjPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSjPattern(this);
		}
	}

	public final SjPatternContext sjPattern() throws RecognitionException {
		SjPatternContext _localctx = new SjPatternContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_sjPattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(480);
			sjQuery();
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

	public static class QbtConditionContext extends ParserRuleContext {
		public QbtAtomContext qbtAtom() {
			return getRuleContext(QbtAtomContext.class,0);
		}
		public List<QbtConditionContext> qbtCondition() {
			return getRuleContexts(QbtConditionContext.class);
		}
		public QbtConditionContext qbtCondition(int i) {
			return getRuleContext(QbtConditionContext.class,i);
		}
		public TerminalNode AND() { return getToken(QBTMParser.AND, 0); }
		public QbtConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qbtCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterQbtCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitQbtCondition(this);
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
			setState(488);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				{
				setState(483);
				qbtAtom();
				}
				break;
			case T__5:
				{
				setState(484);
				match(T__5);
				setState(485);
				qbtCondition(0);
				setState(486);
				match(T__6);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(495);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new QbtConditionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_qbtCondition);
					setState(490);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(491);
					match(AND);
					setState(492);
					qbtCondition(2);
					}
					} 
				}
				setState(497);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class QbtAtomContext extends ParserRuleContext {
		public QbtTermLeftContext qbtTermLeft() {
			return getRuleContext(QbtTermLeftContext.class,0);
		}
		public QbtTermRightContext qbtTermRight() {
			return getRuleContext(QbtTermRightContext.class,0);
		}
		public QbtAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qbtAtom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterQbtAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitQbtAtom(this);
		}
	}

	public final QbtAtomContext qbtAtom() throws RecognitionException {
		QbtAtomContext _localctx = new QbtAtomContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_qbtAtom);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(498);
			qbtTermLeft();
			setState(499);
			match(T__0);
			setState(500);
			qbtTermRight();
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

	public static class QbtTermLeftContext extends ParserRuleContext {
		public QbtTermContext qbtTerm() {
			return getRuleContext(QbtTermContext.class,0);
		}
		public QbtTermLeftContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qbtTermLeft; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterQbtTermLeft(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitQbtTermLeft(this);
		}
	}

	public final QbtTermLeftContext qbtTermLeft() throws RecognitionException {
		QbtTermLeftContext _localctx = new QbtTermLeftContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_qbtTermLeft);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(502);
			qbtTerm();
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

	public static class QbtTermRightContext extends ParserRuleContext {
		public QbtTermContext qbtTerm() {
			return getRuleContext(QbtTermContext.class,0);
		}
		public QbtTermRightContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qbtTermRight; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterQbtTermRight(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitQbtTermRight(this);
		}
	}

	public final QbtTermRightContext qbtTermRight() throws RecognitionException {
		QbtTermRightContext _localctx = new QbtTermRightContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_qbtTermRight);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(504);
			qbtTerm();
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

	public static class QbtTermContext extends ParserRuleContext {
		public QbtVariableContext qbtVariable() {
			return getRuleContext(QbtVariableContext.class,0);
		}
		public QbtTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qbtTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterQbtTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitQbtTerm(this);
		}
	}

	public final QbtTermContext qbtTerm() throws RecognitionException {
		QbtTermContext _localctx = new QbtTermContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_qbtTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(506);
			qbtVariable();
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

	public static class QbtVariableContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(QBTMParser.NAME, 0); }
		public QbtVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qbtVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterQbtVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitQbtVariable(this);
		}
	}

	public final QbtVariableContext qbtVariable() throws RecognitionException {
		QbtVariableContext _localctx = new QbtVariableContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_qbtVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(508);
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

	public static class ModelPathExprContext extends ParserRuleContext {
		public ModelPathExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modelPathExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterModelPathExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitModelPathExpr(this);
		}
	}

	public final ModelPathExprContext modelPathExpr() throws RecognitionException {
		ModelPathExprContext _localctx = new ModelPathExprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_modelPathExpr);
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
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitConstructor(this);
		}
	}

	public final ConstructorContext constructor() throws RecognitionException {
		ConstructorContext _localctx = new ConstructorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_constructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(512);
			annotation();
			setState(513);
			match(T__2);
			setState(514);
			match(T__3);
			setState(515);
			modelConstructor();
			setState(516);
			match(T__4);
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
		public RkConstructorContext rkConstructor() {
			return getRuleContext(RkConstructorContext.class,0);
		}
		public SppjConstructorContext sppjConstructor() {
			return getRuleContext(SppjConstructorContext.class,0);
		}
		public PrConstructorContext prConstructor() {
			return getRuleContext(PrConstructorContext.class,0);
		}
		public SjConstructorContext sjConstructor() {
			return getRuleContext(SjConstructorContext.class,0);
		}
		public ModelConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modelConstructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterModelConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitModelConstructor(this);
		}
	}

	public final ModelConstructorContext modelConstructor() throws RecognitionException {
		ModelConstructorContext _localctx = new ModelConstructorContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_modelConstructor);
		try {
			setState(523);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(519);
				rkConstructor();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(520);
				sppjConstructor();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(521);
				prConstructor();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(522);
				sjConstructor();
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

	public static class AjConstructorContext extends ParserRuleContext {
		public RecordConstructContext recordConstruct() {
			return getRuleContext(RecordConstructContext.class,0);
		}
		public AjConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ajConstructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterAjConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitAjConstructor(this);
		}
	}

	public final AjConstructorContext ajConstructor() throws RecognitionException {
		AjConstructorContext _localctx = new AjConstructorContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_ajConstructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(525);
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

	public static class RkConstructorContext extends ParserRuleContext {
		public MapConstructorContext mapConstructor() {
			return getRuleContext(MapConstructorContext.class,0);
		}
		public RkConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rkConstructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterRkConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitRkConstructor(this);
		}
	}

	public final RkConstructorContext rkConstructor() throws RecognitionException {
		RkConstructorContext _localctx = new RkConstructorContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_rkConstructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(527);
			mapConstructor();
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

	public static class PrConstructorContext extends ParserRuleContext {
		public List<PrVariableContext> prVariable() {
			return getRuleContexts(PrVariableContext.class);
		}
		public PrVariableContext prVariable(int i) {
			return getRuleContext(PrVariableContext.class,i);
		}
		public PrConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prConstructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPrConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPrConstructor(this);
		}
	}

	public final PrConstructorContext prConstructor() throws RecognitionException {
		PrConstructorContext _localctx = new PrConstructorContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_prConstructor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(529);
			prVariable();
			setState(534);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(530);
				match(T__1);
				setState(531);
				prVariable();
				}
				}
				setState(536);
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

	public static class SjConstructorContext extends ParserRuleContext {
		public SjRecordConstructContext sjRecordConstruct() {
			return getRuleContext(SjRecordConstructContext.class,0);
		}
		public SjConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sjConstructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSjConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSjConstructor(this);
		}
	}

	public final SjConstructorContext sjConstructor() throws RecognitionException {
		SjConstructorContext _localctx = new SjConstructorContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_sjConstructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(537);
			sjRecordConstruct();
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

	public static class SppjConstructorContext extends ParserRuleContext {
		public SppjRootRecordConstructContext sppjRootRecordConstruct() {
			return getRuleContext(SppjRootRecordConstructContext.class,0);
		}
		public SppjConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjConstructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjConstructor(this);
		}
	}

	public final SppjConstructorContext sppjConstructor() throws RecognitionException {
		SppjConstructorContext _localctx = new SppjConstructorContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_sppjConstructor);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(539);
			sppjRootRecordConstruct();
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
		public TerminalNode AJ() { return getToken(QBTMParser.AJ, 0); }
		public TerminalNode RK() { return getToken(QBTMParser.RK, 0); }
		public TerminalNode PR() { return getToken(QBTMParser.PR, 0); }
		public TerminalNode PJ() { return getToken(QBTMParser.PJ, 0); }
		public TerminalNode SPPJ() { return getToken(QBTMParser.SPPJ, 0); }
		public TerminalNode SJ() { return getToken(QBTMParser.SJ, 0); }
		public TerminalNode TQ() { return getToken(QBTMParser.TQ, 0); }
		public AnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitAnnotation(this);
		}
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_annotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(541);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << AJ) | (1L << RK) | (1L << PR) | (1L << SPPJ) | (1L << PJ) | (1L << SJ) | (1L << TQ))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public static class KqlqueryContext extends ParserRuleContext {
		public ViewNameContext viewName() {
			return getRuleContext(ViewNameContext.class,0);
		}
		public RedisKQLQueryContext redisKQLQuery() {
			return getRuleContext(RedisKQLQueryContext.class,0);
		}
		public TerminalNode EOF() { return getToken(QBTMParser.EOF, 0); }
		public KqlqueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kqlquery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterKqlquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitKqlquery(this);
		}
	}

	public final KqlqueryContext kqlquery() throws RecognitionException {
		KqlqueryContext _localctx = new KqlqueryContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_kqlquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(543);
			viewName();
			setState(544);
			match(T__0);
			setState(545);
			redisKQLQuery();
			setState(546);
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
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterRedisKQLQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitRedisKQLQuery(this);
		}
	}

	public final RedisKQLQueryContext redisKQLQuery() throws RecognitionException {
		RedisKQLQueryContext _localctx = new RedisKQLQueryContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_redisKQLQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(548);
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
		public RkSelectClasueContext rkSelectClasue() {
			return getRuleContext(RkSelectClasueContext.class,0);
		}
		public RkFromClasueContext rkFromClasue() {
			return getRuleContext(RkFromClasueContext.class,0);
		}
		public SfwQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sfwQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSfwQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSfwQuery(this);
		}
	}

	public final SfwQueryContext sfwQuery() throws RecognitionException {
		SfwQueryContext _localctx = new SfwQueryContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_sfwQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(550);
			rkSelectClasue();
			setState(551);
			rkFromClasue();
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

	public static class RkSelectClasueContext extends ParserRuleContext {
		public RkSelectStatementContext rkSelectStatement() {
			return getRuleContext(RkSelectStatementContext.class,0);
		}
		public RkSelectClasueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rkSelectClasue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterRkSelectClasue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitRkSelectClasue(this);
		}
	}

	public final RkSelectClasueContext rkSelectClasue() throws RecognitionException {
		RkSelectClasueContext _localctx = new RkSelectClasueContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_rkSelectClasue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(553);
			rkSelectStatement();
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

	public static class RkSelectStatementContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(QBTMParser.SELECT, 0); }
		public RkSelectItemContext rkSelectItem() {
			return getRuleContext(RkSelectItemContext.class,0);
		}
		public RkSelectStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rkSelectStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterRkSelectStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitRkSelectStatement(this);
		}
	}

	public final RkSelectStatementContext rkSelectStatement() throws RecognitionException {
		RkSelectStatementContext _localctx = new RkSelectStatementContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_rkSelectStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(555);
			match(SELECT);
			setState(556);
			rkSelectItem();
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

	public static class RkSelectItemContext extends ParserRuleContext {
		public RkReturnVariableContext rkReturnVariable() {
			return getRuleContext(RkReturnVariableContext.class,0);
		}
		public MapConstructorContext mapConstructor() {
			return getRuleContext(MapConstructorContext.class,0);
		}
		public RkSelectItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rkSelectItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterRkSelectItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitRkSelectItem(this);
		}
	}

	public final RkSelectItemContext rkSelectItem() throws RecognitionException {
		RkSelectItemContext _localctx = new RkSelectItemContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_rkSelectItem);
		try {
			setState(560);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(558);
				rkReturnVariable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(559);
				mapConstructor();
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

	public static class RkReturnVariableContext extends ParserRuleContext {
		public RkVariableContext rkVariable() {
			return getRuleContext(RkVariableContext.class,0);
		}
		public RkReturnVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rkReturnVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterRkReturnVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitRkReturnVariable(this);
		}
	}

	public final RkReturnVariableContext rkReturnVariable() throws RecognitionException {
		RkReturnVariableContext _localctx = new RkReturnVariableContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_rkReturnVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(562);
			rkVariable();
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

	public static class MapConstructorContext extends ParserRuleContext {
		public MapKeyContext mapKey() {
			return getRuleContext(MapKeyContext.class,0);
		}
		public List<RkAttributeContext> rkAttribute() {
			return getRuleContexts(RkAttributeContext.class);
		}
		public RkAttributeContext rkAttribute(int i) {
			return getRuleContext(RkAttributeContext.class,i);
		}
		public MapConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapConstructor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterMapConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitMapConstructor(this);
		}
	}

	public final MapConstructorContext mapConstructor() throws RecognitionException {
		MapConstructorContext _localctx = new MapConstructorContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_mapConstructor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(564);
			mapKey();
			setState(565);
			match(T__7);
			setState(566);
			match(T__3);
			setState(567);
			rkAttribute();
			setState(572);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(568);
				match(T__1);
				setState(569);
				rkAttribute();
				}
				}
				setState(574);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(575);
			match(T__4);
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

	public static class RkAttributeContext extends ParserRuleContext {
		public RkStringKeyContext rkStringKey() {
			return getRuleContext(RkStringKeyContext.class,0);
		}
		public RkAttributeValueContext rkAttributeValue() {
			return getRuleContext(RkAttributeValueContext.class,0);
		}
		public RkAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rkAttribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterRkAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitRkAttribute(this);
		}
	}

	public final RkAttributeContext rkAttribute() throws RecognitionException {
		RkAttributeContext _localctx = new RkAttributeContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_rkAttribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(577);
			rkStringKey();
			setState(578);
			match(T__2);
			setState(579);
			rkAttributeValue();
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

	public static class RkAttributeValueContext extends ParserRuleContext {
		public RkReturnVariableContext rkReturnVariable() {
			return getRuleContext(RkReturnVariableContext.class,0);
		}
		public RkAttributeValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rkAttributeValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterRkAttributeValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitRkAttributeValue(this);
		}
	}

	public final RkAttributeValueContext rkAttributeValue() throws RecognitionException {
		RkAttributeValueContext _localctx = new RkAttributeValueContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_rkAttributeValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(581);
			rkReturnVariable();
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

	public static class MapKeyContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(QBTMParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(QBTMParser.NAME, i);
		}
		public TerminalNode STRING() { return getToken(QBTMParser.STRING, 0); }
		public MapKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterMapKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitMapKey(this);
		}
	}

	public final MapKeyContext mapKey() throws RecognitionException {
		MapKeyContext _localctx = new MapKeyContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_mapKey);
		try {
			setState(588);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(583);
				match(NAME);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(584);
				match(NAME);
				setState(585);
				match(T__8);
				setState(586);
				match(NAME);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(587);
				match(STRING);
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

	public static class RkFromClasueContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(QBTMParser.FROM, 0); }
		public List<VarBindingContext> varBinding() {
			return getRuleContexts(VarBindingContext.class);
		}
		public VarBindingContext varBinding(int i) {
			return getRuleContext(VarBindingContext.class,i);
		}
		public RkFromClasueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rkFromClasue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterRkFromClasue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitRkFromClasue(this);
		}
	}

	public final RkFromClasueContext rkFromClasue() throws RecognitionException {
		RkFromClasueContext _localctx = new RkFromClasueContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_rkFromClasue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(590);
			match(FROM);
			setState(591);
			varBinding();
			setState(596);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(592);
				match(T__1);
				setState(593);
				varBinding();
				}
				}
				setState(598);
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
		public TerminalNode IN() { return getToken(QBTMParser.IN, 0); }
		public RkSourceContext rkSource() {
			return getRuleContext(RkSourceContext.class,0);
		}
		public VarBindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varBinding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterVarBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitVarBinding(this);
		}
	}

	public final VarBindingContext varBinding() throws RecognitionException {
		VarBindingContext _localctx = new VarBindingContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_varBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(599);
			fromvariableBinding();
			setState(600);
			match(IN);
			setState(601);
			rkSource();
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
		public RkVariableContext rkVariable() {
			return getRuleContext(RkVariableContext.class,0);
		}
		public FromvariableBindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fromvariableBinding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterFromvariableBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitFromvariableBinding(this);
		}
	}

	public final FromvariableBindingContext fromvariableBinding() throws RecognitionException {
		FromvariableBindingContext _localctx = new FromvariableBindingContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_fromvariableBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(603);
			rkVariable();
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

	public static class RkSourceContext extends ParserRuleContext {
		public RkLookUpExpressionContext rkLookUpExpression() {
			return getRuleContext(RkLookUpExpressionContext.class,0);
		}
		public RkSourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rkSource; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterRkSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitRkSource(this);
		}
	}

	public final RkSourceContext rkSource() throws RecognitionException {
		RkSourceContext _localctx = new RkSourceContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_rkSource);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(605);
			rkLookUpExpression();
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

	public static class RkLookUpExpressionContext extends ParserRuleContext {
		public RkLookUpExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rkLookUpExpression; }
	 
		public RkLookUpExpressionContext() { }
		public void copyFrom(RkLookUpExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class KeysMapLookUpContext extends RkLookUpExpressionContext {
		public TerminalNode KEYS() { return getToken(QBTMParser.KEYS, 0); }
		public KeyVariableContext keyVariable() {
			return getRuleContext(KeyVariableContext.class,0);
		}
		public KeysMapLookUpContext(RkLookUpExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterKeysMapLookUp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitKeysMapLookUp(this);
		}
	}
	public static class VariableMapLookUpContext extends RkLookUpExpressionContext {
		public MapVariableContext mapVariable() {
			return getRuleContext(MapVariableContext.class,0);
		}
		public List<RkKeyContext> rkKey() {
			return getRuleContexts(RkKeyContext.class);
		}
		public RkKeyContext rkKey(int i) {
			return getRuleContext(RkKeyContext.class,i);
		}
		public VariableMapLookUpContext(RkLookUpExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterVariableMapLookUp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitVariableMapLookUp(this);
		}
	}
	public static class MainMapLookUpContext extends RkLookUpExpressionContext {
		public MainMapContext mainMap() {
			return getRuleContext(MainMapContext.class,0);
		}
		public List<RkKeyContext> rkKey() {
			return getRuleContexts(RkKeyContext.class);
		}
		public RkKeyContext rkKey(int i) {
			return getRuleContext(RkKeyContext.class,i);
		}
		public MainMapLookUpContext(RkLookUpExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterMainMapLookUp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitMainMapLookUp(this);
		}
	}

	public final RkLookUpExpressionContext rkLookUpExpression() throws RecognitionException {
		RkLookUpExpressionContext _localctx = new RkLookUpExpressionContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_rkLookUpExpression);
		int _la;
		try {
			setState(638);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MAIN:
				_localctx = new MainMapLookUpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(607);
				mainMap();
				setState(608);
				match(T__9);
				setState(609);
				rkKey();
				setState(610);
				match(T__10);
				setState(617);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(611);
					match(T__9);
					setState(612);
					rkKey();
					setState(613);
					match(T__10);
					}
					}
					setState(619);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case NAME:
				_localctx = new VariableMapLookUpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(620);
				mapVariable();
				setState(621);
				match(T__9);
				setState(622);
				rkKey();
				setState(623);
				match(T__10);
				setState(630);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(624);
					match(T__9);
					setState(625);
					rkKey();
					setState(626);
					match(T__10);
					}
					}
					setState(632);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case KEYS:
				_localctx = new KeysMapLookUpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(633);
				match(KEYS);
				setState(634);
				match(T__9);
				setState(635);
				keyVariable();
				setState(636);
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

	public static class MainMapContext extends ParserRuleContext {
		public TerminalNode MAIN() { return getToken(QBTMParser.MAIN, 0); }
		public MainMapContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainMap; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterMainMap(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitMainMap(this);
		}
	}

	public final MainMapContext mainMap() throws RecognitionException {
		MainMapContext _localctx = new MainMapContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_mainMap);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(640);
			match(MAIN);
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
		public TerminalNode NAME() { return getToken(QBTMParser.NAME, 0); }
		public MapVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterMapVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitMapVariable(this);
		}
	}

	public final MapVariableContext mapVariable() throws RecognitionException {
		MapVariableContext _localctx = new MapVariableContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_mapVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(642);
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

	public static class RkKeyContext extends ParserRuleContext {
		public RkStringKeyContext rkStringKey() {
			return getRuleContext(RkStringKeyContext.class,0);
		}
		public VariableKeyContext variableKey() {
			return getRuleContext(VariableKeyContext.class,0);
		}
		public RkKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rkKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterRkKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitRkKey(this);
		}
	}

	public final RkKeyContext rkKey() throws RecognitionException {
		RkKeyContext _localctx = new RkKeyContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_rkKey);
		try {
			setState(646);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(644);
				rkStringKey();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(645);
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

	public static class RkStringKeyContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(QBTMParser.STRING, 0); }
		public RkStringKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rkStringKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterRkStringKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitRkStringKey(this);
		}
	}

	public final RkStringKeyContext rkStringKey() throws RecognitionException {
		RkStringKeyContext _localctx = new RkStringKeyContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_rkStringKey);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(648);
			match(STRING);
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
		public List<TerminalNode> NAME() { return getTokens(QBTMParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(QBTMParser.NAME, i);
		}
		public VariableKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterVariableKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitVariableKey(this);
		}
	}

	public final VariableKeyContext variableKey() throws RecognitionException {
		VariableKeyContext _localctx = new VariableKeyContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_variableKey);
		try {
			setState(654);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(650);
				match(NAME);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(651);
				match(NAME);
				setState(652);
				match(T__8);
				setState(653);
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
		public TerminalNode NAME() { return getToken(QBTMParser.NAME, 0); }
		public KeyVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterKeyVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitKeyVariable(this);
		}
	}

	public final KeyVariableContext keyVariable() throws RecognitionException {
		KeyVariableContext _localctx = new KeyVariableContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_keyVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(656);
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
		public RkVariableContext rkVariable() {
			return getRuleContext(RkVariableContext.class,0);
		}
		public MapNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterMapName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitMapName(this);
		}
	}

	public final MapNameContext mapName() throws RecognitionException {
		MapNameContext _localctx = new MapNameContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_mapName);
		try {
			setState(660);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MAIN:
				enterOuterAlt(_localctx, 1);
				{
				setState(658);
				mainMap();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(659);
				rkVariable();
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

	public static class RkVariableContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(QBTMParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(QBTMParser.NAME, i);
		}
		public RkVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rkVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterRkVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitRkVariable(this);
		}
	}

	public final RkVariableContext rkVariable() throws RecognitionException {
		RkVariableContext _localctx = new RkVariableContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_rkVariable);
		try {
			setState(666);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(662);
				match(NAME);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(663);
				match(NAME);
				setState(664);
				match(T__8);
				setState(665);
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

	public static class AqlqueryContext extends ParserRuleContext {
		public ViewNameContext viewName() {
			return getRuleContext(ViewNameContext.class,0);
		}
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
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
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterAqlquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitAqlquery(this);
		}
	}

	public final AqlqueryContext aqlquery() throws RecognitionException {
		AqlqueryContext _localctx = new AqlqueryContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_aqlquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(668);
			viewName();
			setState(669);
			match(T__0);
			setState(677);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				{
				setState(670);
				query();
				}
				break;
			case T__3:
				{
				setState(671);
				match(T__3);
				setState(672);
				rootFieldName();
				setState(673);
				match(T__2);
				setState(674);
				query();
				setState(675);
				match(T__4);
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

	public static class QueryContext extends ParserRuleContext {
		public ForWhereClausesContext forWhereClauses() {
			return getRuleContext(ForWhereClausesContext.class,0);
		}
		public ReturnClauseContext returnClause() {
			return getRuleContext(ReturnClauseContext.class,0);
		}
		public QueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_query; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitQuery(this);
		}
	}

	public final QueryContext query() throws RecognitionException {
		QueryContext _localctx = new QueryContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_query);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(679);
			forWhereClauses();
			setState(680);
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
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterRootFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitRootFieldName(this);
		}
	}

	public final RootFieldNameContext rootFieldName() throws RecognitionException {
		RootFieldNameContext _localctx = new RootFieldNameContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_rootFieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(682);
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
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterReturnClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitReturnClause(this);
		}
	}

	public final ReturnClauseContext returnClause() throws RecognitionException {
		ReturnClauseContext _localctx = new ReturnClauseContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_returnClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(684);
			match(T__11);
			setState(688);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				{
				setState(685);
				recordConstruct();
				}
				break;
			case NAME:
				{
				setState(686);
				returnVar();
				}
				break;
			case STRING:
			case BETA:
				{
				setState(687);
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
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterRecordConstruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitRecordConstruct(this);
		}
	}

	public final RecordConstructContext recordConstruct() throws RecognitionException {
		RecordConstructContext _localctx = new RecordConstructContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_recordConstruct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(690);
			match(T__3);
			setState(691);
			fieldBinding();
			setState(696);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(692);
				match(T__1);
				setState(693);
				fieldBinding();
				}
				}
				setState(698);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(699);
			match(T__4);
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
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterFieldBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitFieldBinding(this);
		}
	}

	public final FieldBindingContext fieldBinding() throws RecognitionException {
		FieldBindingContext _localctx = new FieldBindingContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_fieldBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(701);
			recordConstructFieldName();
			setState(702);
			match(T__2);
			setState(703);
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
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterRecordConstructFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitRecordConstructFieldName(this);
		}
	}

	public final RecordConstructFieldNameContext recordConstructFieldName() throws RecognitionException {
		RecordConstructFieldNameContext _localctx = new RecordConstructFieldNameContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_recordConstructFieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(705);
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
		public TerminalNode STRING() { return getToken(QBTMParser.STRING, 0); }
		public FieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitFieldName(this);
		}
	}

	public final FieldNameContext fieldName() throws RecognitionException {
		FieldNameContext _localctx = new FieldNameContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_fieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(707);
			match(STRING);
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
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterFieldValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitFieldValue(this);
		}
	}

	public final FieldValueContext fieldValue() throws RecognitionException {
		FieldValueContext _localctx = new FieldValueContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_fieldValue);
		try {
			setState(713);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(709);
				recordConstruct();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(710);
				returnVar();
				}
				break;
			case STRING:
			case BETA:
				enterOuterAlt(_localctx, 3);
				{
				setState(711);
				returnConstant();
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 4);
				{
				setState(712);
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
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode NAME() { return getToken(QBTMParser.NAME, 0); }
		public ReturnVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterReturnVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitReturnVar(this);
		}
	}

	public final ReturnVarContext returnVar() throws RecognitionException {
		ReturnVarContext _localctx = new ReturnVarContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_returnVar);
		try {
			setState(720);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(715);
				var();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(716);
				name();
				setState(717);
				match(T__8);
				setState(718);
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

	public static class NameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(QBTMParser.NAME, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitName(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(722);
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
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterReturnConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitReturnConstant(this);
		}
	}

	public final ReturnConstantContext returnConstant() throws RecognitionException {
		ReturnConstantContext _localctx = new ReturnConstantContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_returnConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(724);
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
		public QueryContext query() {
			return getRuleContext(QueryContext.class,0);
		}
		public ReturnQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterReturnQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitReturnQuery(this);
		}
	}

	public final ReturnQueryContext returnQuery() throws RecognitionException {
		ReturnQueryContext _localctx = new ReturnQueryContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_returnQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(726);
			query();
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
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_term);
		try {
			setState(731);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(728);
				termConstant();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(729);
				termVar();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(730);
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
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode NAME() { return getToken(QBTMParser.NAME, 0); }
		public TermVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterTermVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitTermVar(this);
		}
	}

	public final TermVarContext termVar() throws RecognitionException {
		TermVarContext _localctx = new TermVarContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_termVar);
		try {
			setState(738);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(733);
				var();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(734);
				name();
				setState(735);
				match(T__8);
				setState(736);
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
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterTermConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitTermConstant(this);
		}
	}

	public final TermConstantContext termConstant() throws RecognitionException {
		TermConstantContext _localctx = new TermConstantContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_termConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(740);
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
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterTermPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitTermPath(this);
		}
	}

	public final TermPathContext termPath() throws RecognitionException {
		TermPathContext _localctx = new TermPathContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_termPath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(742);
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

	public static class ConstantContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode STRING() { return getToken(QBTMParser.STRING, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_constant);
		try {
			setState(746);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BETA:
				enterOuterAlt(_localctx, 1);
				{
				setState(744);
				number();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(745);
				match(STRING);
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

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode BETA() { return getToken(QBTMParser.BETA, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitNumber(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(748);
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
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPath(this);
		}
	}

	public final PathContext path() throws RecognitionException {
		PathContext _localctx = new PathContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_path);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(750);
			pathVar();
			setState(752); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(751);
					step();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(754); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
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
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public PathVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pathVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPathVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPathVar(this);
		}
	}

	public final PathVarContext pathVar() throws RecognitionException {
		PathVarContext _localctx = new PathVarContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_pathVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(756);
			var();
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

	public static class VarContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(QBTMParser.NAME, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitVar(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(758);
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
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterStep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitStep(this);
		}
	}

	public final StepContext step() throws RecognitionException {
		StepContext _localctx = new StepContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_step);
		try {
			setState(762);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				setState(760);
				objectStep();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 2);
				{
				setState(761);
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
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public ObjectStepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectStep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterObjectStep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitObjectStep(this);
		}
	}

	public final ObjectStepContext objectStep() throws RecognitionException {
		ObjectStepContext _localctx = new ObjectStepContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_objectStep);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(764);
			match(T__8);
			setState(765);
			key();
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
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterArrayStep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitArrayStep(this);
		}
	}

	public final ArrayStepContext arrayStep() throws RecognitionException {
		ArrayStepContext _localctx = new ArrayStepContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_arrayStep);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(767);
			match(T__9);
			setState(768);
			index();
			setState(769);
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

	public static class KeyContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(QBTMParser.NAME, 0); }
		public KeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_key; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitKey(this);
		}
	}

	public final KeyContext key() throws RecognitionException {
		KeyContext _localctx = new KeyContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_key);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(771);
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
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterIndex(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitIndex(this);
		}
	}

	public final IndexContext index() throws RecognitionException {
		IndexContext _localctx = new IndexContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_index);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(773);
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
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterForClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitForClause(this);
		}
	}

	public final ForClauseContext forClause() throws RecognitionException {
		ForClauseContext _localctx = new ForClauseContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_forClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(775);
			match(T__12);
			setState(776);
			binding();
			setState(781);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(777);
				match(T__1);
				setState(778);
				binding();
				}
				}
				setState(783);
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
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitBinding(this);
		}
	}

	public final BindingContext binding() throws RecognitionException {
		BindingContext _localctx = new BindingContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_binding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(784);
			forClauseBindingVar();
			setState(785);
			match(T__13);
			setState(786);
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
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public ForClauseBindingVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forClauseBindingVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterForClauseBindingVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitForClauseBindingVar(this);
		}
	}

	public final ForClauseBindingVarContext forClauseBindingVar() throws RecognitionException {
		ForClauseBindingVarContext _localctx = new ForClauseBindingVarContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_forClauseBindingVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(788);
			var();
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
		public SourceContext source() {
			return getRuleContext(SourceContext.class,0);
		}
		public ForClauseBindingSourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forClauseBindingSource; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterForClauseBindingSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitForClauseBindingSource(this);
		}
	}

	public final ForClauseBindingSourceContext forClauseBindingSource() throws RecognitionException {
		ForClauseBindingSourceContext _localctx = new ForClauseBindingSourceContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_forClauseBindingSource);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(790);
			source();
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
		public DataSetNameContext dataSetName() {
			return getRuleContext(DataSetNameContext.class,0);
		}
		public PathContext path() {
			return getRuleContext(PathContext.class,0);
		}
		public SourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_source; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSource(this);
		}
	}

	public final SourceContext source() throws RecognitionException {
		SourceContext _localctx = new SourceContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_source);
		try {
			setState(795);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				setState(792);
				match(T__14);
				setState(793);
				dataSetName();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(794);
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
		public TerminalNode NAME() { return getToken(QBTMParser.NAME, 0); }
		public DataSetNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataSetName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterDataSetName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitDataSetName(this);
		}
	}

	public final DataSetNameContext dataSetName() throws RecognitionException {
		DataSetNameContext _localctx = new DataSetNameContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_dataSetName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(797);
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
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitWhereClause(this);
		}
	}

	public final WhereClauseContext whereClause() throws RecognitionException {
		WhereClauseContext _localctx = new WhereClauseContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_whereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(799);
			match(T__15);
			setState(800);
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
		public WhereCondEqualityContext whereCondEquality() {
			return getRuleContext(WhereCondEqualityContext.class,0);
		}
		public WhereCondSomeContext whereCondSome() {
			return getRuleContext(WhereCondSomeContext.class,0);
		}
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitCondition(this);
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
		int _startState = 176;
		enterRecursionRule(_localctx, 176, RULE_condition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(813);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
			case STRING:
			case BETA:
				{
				setState(803);
				whereCondEquality();
				}
				break;
			case T__17:
				{
				setState(804);
				match(T__17);
				setState(805);
				whereCondSome();
				setState(806);
				match(T__18);
				setState(807);
				condition(2);
				}
				break;
			case T__5:
				{
				setState(809);
				match(T__5);
				setState(810);
				condition(0);
				setState(811);
				match(T__6);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(820);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConditionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_condition);
					setState(815);
					if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
					setState(816);
					match(T__16);
					setState(817);
					condition(4);
					}
					} 
				}
				setState(822);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterWhereCondSome(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitWhereCondSome(this);
		}
	}

	public final WhereCondSomeContext whereCondSome() throws RecognitionException {
		WhereCondSomeContext _localctx = new WhereCondSomeContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_whereCondSome);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(823);
			whereCondBinding();
			setState(828);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(824);
				match(T__1);
				setState(825);
				whereCondBinding();
				}
				}
				setState(830);
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
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterWhereCondBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitWhereCondBinding(this);
		}
	}

	public final WhereCondBindingContext whereCondBinding() throws RecognitionException {
		WhereCondBindingContext _localctx = new WhereCondBindingContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_whereCondBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(831);
			whereCondBindingVar();
			setState(832);
			match(T__13);
			setState(833);
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
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public WhereCondBindingVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereCondBindingVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterWhereCondBindingVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitWhereCondBindingVar(this);
		}
	}

	public final WhereCondBindingVarContext whereCondBindingVar() throws RecognitionException {
		WhereCondBindingVarContext _localctx = new WhereCondBindingVarContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_whereCondBindingVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(835);
			var();
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
		public SourceContext source() {
			return getRuleContext(SourceContext.class,0);
		}
		public WhereCondBindingSourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whereCondBindingSource; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterWhereCondBindingSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitWhereCondBindingSource(this);
		}
	}

	public final WhereCondBindingSourceContext whereCondBindingSource() throws RecognitionException {
		WhereCondBindingSourceContext _localctx = new WhereCondBindingSourceContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_whereCondBindingSource);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(837);
			source();
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
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterWhereCondEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitWhereCondEquality(this);
		}
	}

	public final WhereCondEqualityContext whereCondEquality() throws RecognitionException {
		WhereCondEqualityContext _localctx = new WhereCondEqualityContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_whereCondEquality);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(839);
			whereCondEqualityLeftTerm();
			setState(840);
			match(T__0);
			setState(841);
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
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterWhereCondEqualityLeftTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitWhereCondEqualityLeftTerm(this);
		}
	}

	public final WhereCondEqualityLeftTermContext whereCondEqualityLeftTerm() throws RecognitionException {
		WhereCondEqualityLeftTermContext _localctx = new WhereCondEqualityLeftTermContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_whereCondEqualityLeftTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(843);
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
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterWhereCondEqualityRightTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitWhereCondEqualityRightTerm(this);
		}
	}

	public final WhereCondEqualityRightTermContext whereCondEqualityRightTerm() throws RecognitionException {
		WhereCondEqualityRightTermContext _localctx = new WhereCondEqualityRightTermContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_whereCondEqualityRightTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(845);
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
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterCterm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitCterm(this);
		}
	}

	public final CtermContext cterm() throws RecognitionException {
		CtermContext _localctx = new CtermContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_cterm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(847);
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

	public static class ForWhereClausesContext extends ParserRuleContext {
		public ForClauseContext forClause() {
			return getRuleContext(ForClauseContext.class,0);
		}
		public WhereClauseContext whereClause() {
			return getRuleContext(WhereClauseContext.class,0);
		}
		public ForWhereClausesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forWhereClauses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterForWhereClauses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitForWhereClauses(this);
		}
	}

	public final ForWhereClausesContext forWhereClauses() throws RecognitionException {
		ForWhereClausesContext _localctx = new ForWhereClausesContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_forWhereClauses);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(849);
			forClause();
			setState(851);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__15) {
				{
				setState(850);
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

	public static class RqQueryContext extends ParserRuleContext {
		public ViewNameContext viewName() {
			return getRuleContext(ViewNameContext.class,0);
		}
		public PrQueryContext prQuery() {
			return getRuleContext(PrQueryContext.class,0);
		}
		public TerminalNode EOF() { return getToken(QBTMParser.EOF, 0); }
		public RqQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rqQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterRqQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitRqQuery(this);
		}
	}

	public final RqQueryContext rqQuery() throws RecognitionException {
		RqQueryContext _localctx = new RqQueryContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_rqQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(853);
			viewName();
			setState(854);
			match(T__0);
			setState(855);
			prQuery();
			setState(856);
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

	public static class PrQueryContext extends ParserRuleContext {
		public PrSfwQueryContext prSfwQuery() {
			return getRuleContext(PrSfwQueryContext.class,0);
		}
		public PrQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPrQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPrQuery(this);
		}
	}

	public final PrQueryContext prQuery() throws RecognitionException {
		PrQueryContext _localctx = new PrQueryContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_prQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(858);
			prSfwQuery();
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

	public static class PrSfwQueryContext extends ParserRuleContext {
		public PrSelectClauseContext prSelectClause() {
			return getRuleContext(PrSelectClauseContext.class,0);
		}
		public PrFromWhereClausesContext prFromWhereClauses() {
			return getRuleContext(PrFromWhereClausesContext.class,0);
		}
		public PrSfwQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prSfwQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPrSfwQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPrSfwQuery(this);
		}
	}

	public final PrSfwQueryContext prSfwQuery() throws RecognitionException {
		PrSfwQueryContext _localctx = new PrSfwQueryContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_prSfwQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(860);
			prSelectClause();
			setState(861);
			prFromWhereClauses();
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

	public static class PrFromWhereClausesContext extends ParserRuleContext {
		public PrFromClauseContext prFromClause() {
			return getRuleContext(PrFromClauseContext.class,0);
		}
		public PrWhereClauseContext prWhereClause() {
			return getRuleContext(PrWhereClauseContext.class,0);
		}
		public PrFromWhereClausesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prFromWhereClauses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPrFromWhereClauses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPrFromWhereClauses(this);
		}
	}

	public final PrFromWhereClausesContext prFromWhereClauses() throws RecognitionException {
		PrFromWhereClausesContext _localctx = new PrFromWhereClausesContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_prFromWhereClauses);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(863);
			prFromClause();
			setState(865);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(864);
				prWhereClause();
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

	public static class PrSelectClauseContext extends ParserRuleContext {
		public PrSelectStatementContext prSelectStatement() {
			return getRuleContext(PrSelectStatementContext.class,0);
		}
		public PrSelectClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prSelectClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPrSelectClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPrSelectClause(this);
		}
	}

	public final PrSelectClauseContext prSelectClause() throws RecognitionException {
		PrSelectClauseContext _localctx = new PrSelectClauseContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_prSelectClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(867);
			prSelectStatement();
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

	public static class PrSelectStatementContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(QBTMParser.SELECT, 0); }
		public List<PrSelectItemContext> prSelectItem() {
			return getRuleContexts(PrSelectItemContext.class);
		}
		public PrSelectItemContext prSelectItem(int i) {
			return getRuleContext(PrSelectItemContext.class,i);
		}
		public PrSelectStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prSelectStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPrSelectStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPrSelectStatement(this);
		}
	}

	public final PrSelectStatementContext prSelectStatement() throws RecognitionException {
		PrSelectStatementContext _localctx = new PrSelectStatementContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_prSelectStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(869);
			match(SELECT);
			setState(870);
			prSelectItem();
			setState(875);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(871);
				match(T__1);
				setState(872);
				prSelectItem();
				}
				}
				setState(877);
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

	public static class PrSelectItemContext extends ParserRuleContext {
		public PrSelectItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prSelectItem; }
	 
		public PrSelectItemContext() { }
		public void copyFrom(PrSelectItemContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PrNameContext extends PrSelectItemContext {
		public TerminalNode NAME() { return getToken(QBTMParser.NAME, 0); }
		public PrNameContext(PrSelectItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPrName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPrName(this);
		}
	}
	public static class PrSelectPathLabelContext extends PrSelectItemContext {
		public PrTermContext prTerm() {
			return getRuleContext(PrTermContext.class,0);
		}
		public TerminalNode AS() { return getToken(QBTMParser.AS, 0); }
		public PrSelectVarContext prSelectVar() {
			return getRuleContext(PrSelectVarContext.class,0);
		}
		public PrSelectPathLabelContext(PrSelectItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPrSelectPathLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPrSelectPathLabel(this);
		}
	}

	public final PrSelectItemContext prSelectItem() throws RecognitionException {
		PrSelectItemContext _localctx = new PrSelectItemContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_prSelectItem);
		try {
			setState(883);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				_localctx = new PrSelectPathLabelContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(878);
				prTerm();
				setState(879);
				match(AS);
				setState(880);
				prSelectVar();
				}
				break;
			case 2:
				_localctx = new PrNameContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(882);
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

	public static class PrSelectVarContext extends ParserRuleContext {
		public PrVariableContext prVariable() {
			return getRuleContext(PrVariableContext.class,0);
		}
		public PrSelectVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prSelectVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPrSelectVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPrSelectVar(this);
		}
	}

	public final PrSelectVarContext prSelectVar() throws RecognitionException {
		PrSelectVarContext _localctx = new PrSelectVarContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_prSelectVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(885);
			prVariable();
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

	public static class PrFromClauseContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(QBTMParser.FROM, 0); }
		public List<PrRelationBindingContext> prRelationBinding() {
			return getRuleContexts(PrRelationBindingContext.class);
		}
		public PrRelationBindingContext prRelationBinding(int i) {
			return getRuleContext(PrRelationBindingContext.class,i);
		}
		public PrFromClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prFromClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPrFromClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPrFromClause(this);
		}
	}

	public final PrFromClauseContext prFromClause() throws RecognitionException {
		PrFromClauseContext _localctx = new PrFromClauseContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_prFromClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(887);
			match(FROM);
			setState(888);
			prRelationBinding();
			setState(893);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(889);
				match(T__1);
				setState(890);
				prRelationBinding();
				}
				}
				setState(895);
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

	public static class PrRelationBindingContext extends ParserRuleContext {
		public PrSourceContext prSource() {
			return getRuleContext(PrSourceContext.class,0);
		}
		public TerminalNode AS() { return getToken(QBTMParser.AS, 0); }
		public PrVariableContext prVariable() {
			return getRuleContext(PrVariableContext.class,0);
		}
		public PrRelationBindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prRelationBinding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPrRelationBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPrRelationBinding(this);
		}
	}

	public final PrRelationBindingContext prRelationBinding() throws RecognitionException {
		PrRelationBindingContext _localctx = new PrRelationBindingContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_prRelationBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(896);
			prSource();
			setState(897);
			match(AS);
			setState(898);
			prVariable();
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

	public static class PrSourceContext extends ParserRuleContext {
		public PrRelationNameContext prRelationName() {
			return getRuleContext(PrRelationNameContext.class,0);
		}
		public PrSourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prSource; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPrSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPrSource(this);
		}
	}

	public final PrSourceContext prSource() throws RecognitionException {
		PrSourceContext _localctx = new PrSourceContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_prSource);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(900);
			prRelationName();
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

	public static class PrRelationNameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(QBTMParser.NAME, 0); }
		public PrRelationNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prRelationName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPrRelationName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPrRelationName(this);
		}
	}

	public final PrRelationNameContext prRelationName() throws RecognitionException {
		PrRelationNameContext _localctx = new PrRelationNameContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_prRelationName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(902);
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

	public static class PrVariableContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(QBTMParser.NAME, 0); }
		public PrVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPrVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPrVariable(this);
		}
	}

	public final PrVariableContext prVariable() throws RecognitionException {
		PrVariableContext _localctx = new PrVariableContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_prVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(904);
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

	public static class PrWhereClauseContext extends ParserRuleContext {
		public PrWhereStatementContext prWhereStatement() {
			return getRuleContext(PrWhereStatementContext.class,0);
		}
		public PrWhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prWhereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPrWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPrWhereClause(this);
		}
	}

	public final PrWhereClauseContext prWhereClause() throws RecognitionException {
		PrWhereClauseContext _localctx = new PrWhereClauseContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_prWhereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(906);
			prWhereStatement();
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

	public static class PrWhereStatementContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(QBTMParser.WHERE, 0); }
		public PrConditionContext prCondition() {
			return getRuleContext(PrConditionContext.class,0);
		}
		public PrWhereStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prWhereStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPrWhereStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPrWhereStatement(this);
		}
	}

	public final PrWhereStatementContext prWhereStatement() throws RecognitionException {
		PrWhereStatementContext _localctx = new PrWhereStatementContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_prWhereStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(908);
			match(WHERE);
			setState(909);
			prCondition(0);
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

	public static class PrConditionContext extends ParserRuleContext {
		public PrEqualityContext prEquality() {
			return getRuleContext(PrEqualityContext.class,0);
		}
		public PrLikeExpressionContext prLikeExpression() {
			return getRuleContext(PrLikeExpressionContext.class,0);
		}
		public List<PrConditionContext> prCondition() {
			return getRuleContexts(PrConditionContext.class);
		}
		public PrConditionContext prCondition(int i) {
			return getRuleContext(PrConditionContext.class,i);
		}
		public TerminalNode AND() { return getToken(QBTMParser.AND, 0); }
		public PrConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPrCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPrCondition(this);
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
		int _startState = 226;
		enterRecursionRule(_localctx, 226, RULE_prCondition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(918);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				{
				setState(912);
				prEquality();
				}
				break;
			case 2:
				{
				setState(913);
				prLikeExpression();
				}
				break;
			case 3:
				{
				setState(914);
				match(T__5);
				setState(915);
				prCondition(0);
				setState(916);
				match(T__6);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(925);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PrConditionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_prCondition);
					setState(920);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(921);
					match(AND);
					setState(922);
					prCondition(3);
					}
					} 
				}
				setState(927);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
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

	public static class PrTermContext extends ParserRuleContext {
		public RealtionContext realtion() {
			return getRuleContext(RealtionContext.class,0);
		}
		public TerminalNode NAME() { return getToken(QBTMParser.NAME, 0); }
		public TerminalNode STRING() { return getToken(QBTMParser.STRING, 0); }
		public PrTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPrTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPrTerm(this);
		}
	}

	public final PrTermContext prTerm() throws RecognitionException {
		PrTermContext _localctx = new PrTermContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_prTerm);
		try {
			setState(933);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(928);
				realtion();
				setState(929);
				match(T__8);
				setState(930);
				match(NAME);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(932);
				match(STRING);
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

	public static class PrEqualityContext extends ParserRuleContext {
		public PrLefttermContext prLeftterm() {
			return getRuleContext(PrLefttermContext.class,0);
		}
		public PrRighttermContext prRightterm() {
			return getRuleContext(PrRighttermContext.class,0);
		}
		public PrEqualityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prEquality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPrEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPrEquality(this);
		}
	}

	public final PrEqualityContext prEquality() throws RecognitionException {
		PrEqualityContext _localctx = new PrEqualityContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_prEquality);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(935);
			prLeftterm();
			setState(936);
			match(T__0);
			setState(937);
			prRightterm();
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

	public static class PrLikeExpressionContext extends ParserRuleContext {
		public PrTermContext prTerm() {
			return getRuleContext(PrTermContext.class,0);
		}
		public TerminalNode LIKE() { return getToken(QBTMParser.LIKE, 0); }
		public TerminalNode STRING() { return getToken(QBTMParser.STRING, 0); }
		public PrLikeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prLikeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPrLikeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPrLikeExpression(this);
		}
	}

	public final PrLikeExpressionContext prLikeExpression() throws RecognitionException {
		PrLikeExpressionContext _localctx = new PrLikeExpressionContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_prLikeExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(939);
			prTerm();
			setState(940);
			match(LIKE);
			setState(941);
			match(STRING);
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

	public static class PrLefttermContext extends ParserRuleContext {
		public PrTermContext prTerm() {
			return getRuleContext(PrTermContext.class,0);
		}
		public PrLefttermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prLeftterm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPrLeftterm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPrLeftterm(this);
		}
	}

	public final PrLefttermContext prLeftterm() throws RecognitionException {
		PrLefttermContext _localctx = new PrLefttermContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_prLeftterm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(943);
			prTerm();
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

	public static class PrRighttermContext extends ParserRuleContext {
		public PrTermContext prTerm() {
			return getRuleContext(PrTermContext.class,0);
		}
		public PrRighttermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prRightterm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPrRightterm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPrRightterm(this);
		}
	}

	public final PrRighttermContext prRightterm() throws RecognitionException {
		PrRighttermContext _localctx = new PrRighttermContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_prRightterm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(945);
			prTerm();
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
		public TerminalNode NAME() { return getToken(QBTMParser.NAME, 0); }
		public RealtionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_realtion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterRealtion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitRealtion(this);
		}
	}

	public final RealtionContext realtion() throws RecognitionException {
		RealtionContext _localctx = new RealtionContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_realtion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(947);
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

	public static class SjqlqueryContext extends ParserRuleContext {
		public ViewNameContext viewName() {
			return getRuleContext(ViewNameContext.class,0);
		}
		public SjQueryContext sjQuery() {
			return getRuleContext(SjQueryContext.class,0);
		}
		public TerminalNode EOF() { return getToken(QBTMParser.EOF, 0); }
		public SjqlqueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sjqlquery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSjqlquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSjqlquery(this);
		}
	}

	public final SjqlqueryContext sjqlquery() throws RecognitionException {
		SjqlqueryContext _localctx = new SjqlqueryContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_sjqlquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(949);
			viewName();
			setState(950);
			match(T__0);
			setState(951);
			sjQuery();
			setState(952);
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

	public static class SjQueryContext extends ParserRuleContext {
		public SjCollectionNameContext sjCollectionName() {
			return getRuleContext(SjCollectionNameContext.class,0);
		}
		public TerminalNode QUERY() { return getToken(QBTMParser.QUERY, 0); }
		public SjProjectFieldsContext sjProjectFields() {
			return getRuleContext(SjProjectFieldsContext.class,0);
		}
		public SjTextSearchContext sjTextSearch() {
			return getRuleContext(SjTextSearchContext.class,0);
		}
		public SjQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sjQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSjQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSjQuery(this);
		}
	}

	public final SjQueryContext sjQuery() throws RecognitionException {
		SjQueryContext _localctx = new SjQueryContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_sjQuery);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(954);
			sjCollectionName();
			setState(955);
			match(T__19);
			setState(956);
			match(QUERY);
			setState(957);
			match(T__20);
			setState(959);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAME) | (1L << STRING) | (1L << INTEGER))) != 0)) {
				{
				setState(958);
				sjTextSearch();
				}
			}

			setState(961);
			match(T__21);
			setState(962);
			sjProjectFields();
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

	public static class SjCollectionNameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(QBTMParser.NAME, 0); }
		public SjCollectionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sjCollectionName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSjCollectionName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSjCollectionName(this);
		}
	}

	public final SjCollectionNameContext sjCollectionName() throws RecognitionException {
		SjCollectionNameContext _localctx = new SjCollectionNameContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_sjCollectionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(964);
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

	public static class SjTextSearchContext extends ParserRuleContext {
		public SjLeftTermContext sjLeftTerm() {
			return getRuleContext(SjLeftTermContext.class,0);
		}
		public SjRightTermContext sjRightTerm() {
			return getRuleContext(SjRightTermContext.class,0);
		}
		public SjTextSearchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sjTextSearch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSjTextSearch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSjTextSearch(this);
		}
	}

	public final SjTextSearchContext sjTextSearch() throws RecognitionException {
		SjTextSearchContext _localctx = new SjTextSearchContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_sjTextSearch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(966);
			sjLeftTerm();
			setState(967);
			match(T__2);
			setState(968);
			sjRightTerm();
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

	public static class SjLeftTermContext extends ParserRuleContext {
		public SjTermContext sjTerm() {
			return getRuleContext(SjTermContext.class,0);
		}
		public SjLeftTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sjLeftTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSjLeftTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSjLeftTerm(this);
		}
	}

	public final SjLeftTermContext sjLeftTerm() throws RecognitionException {
		SjLeftTermContext _localctx = new SjLeftTermContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_sjLeftTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(970);
			sjTerm();
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

	public static class SjRightTermContext extends ParserRuleContext {
		public SjTermContext sjTerm() {
			return getRuleContext(SjTermContext.class,0);
		}
		public SjRightTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sjRightTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSjRightTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSjRightTerm(this);
		}
	}

	public final SjRightTermContext sjRightTerm() throws RecognitionException {
		SjRightTermContext _localctx = new SjRightTermContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_sjRightTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(972);
			sjTerm();
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

	public static class SjTermContext extends ParserRuleContext {
		public SjFieldNameContext sjFieldName() {
			return getRuleContext(SjFieldNameContext.class,0);
		}
		public SjConstantContext sjConstant() {
			return getRuleContext(SjConstantContext.class,0);
		}
		public SjTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sjTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSjTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSjTerm(this);
		}
	}

	public final SjTermContext sjTerm() throws RecognitionException {
		SjTermContext _localctx = new SjTermContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_sjTerm);
		try {
			setState(976);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(974);
				sjFieldName();
				}
				break;
			case STRING:
			case INTEGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(975);
				sjConstant();
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

	public static class SjProjectFieldsContext extends ParserRuleContext {
		public List<SjFieldNameContext> sjFieldName() {
			return getRuleContexts(SjFieldNameContext.class);
		}
		public SjFieldNameContext sjFieldName(int i) {
			return getRuleContext(SjFieldNameContext.class,i);
		}
		public SjProjectFieldsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sjProjectFields; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSjProjectFields(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSjProjectFields(this);
		}
	}

	public final SjProjectFieldsContext sjProjectFields() throws RecognitionException {
		SjProjectFieldsContext _localctx = new SjProjectFieldsContext(_ctx, getState());
		enterRule(_localctx, 254, RULE_sjProjectFields);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(978);
			match(T__22);
			setState(979);
			sjFieldName();
			setState(984);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(980);
				match(T__1);
				setState(981);
				sjFieldName();
				}
				}
				setState(986);
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

	public static class SjRecordConstructContext extends ParserRuleContext {
		public List<SjAttributeContext> sjAttribute() {
			return getRuleContexts(SjAttributeContext.class);
		}
		public SjAttributeContext sjAttribute(int i) {
			return getRuleContext(SjAttributeContext.class,i);
		}
		public SjRecordConstructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sjRecordConstruct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSjRecordConstruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSjRecordConstruct(this);
		}
	}

	public final SjRecordConstructContext sjRecordConstruct() throws RecognitionException {
		SjRecordConstructContext _localctx = new SjRecordConstructContext(_ctx, getState());
		enterRule(_localctx, 256, RULE_sjRecordConstruct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(987);
			match(T__3);
			setState(988);
			sjAttribute();
			setState(993);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(989);
				match(T__1);
				setState(990);
				sjAttribute();
				}
				}
				setState(995);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(996);
			match(T__4);
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

	public static class SjAttributeContext extends ParserRuleContext {
		public SjKeyNameContext sjKeyName() {
			return getRuleContext(SjKeyNameContext.class,0);
		}
		public SjFieldNameContext sjFieldName() {
			return getRuleContext(SjFieldNameContext.class,0);
		}
		public SjAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sjAttribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSjAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSjAttribute(this);
		}
	}

	public final SjAttributeContext sjAttribute() throws RecognitionException {
		SjAttributeContext _localctx = new SjAttributeContext(_ctx, getState());
		enterRule(_localctx, 258, RULE_sjAttribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(998);
			sjKeyName();
			setState(999);
			match(T__2);
			setState(1000);
			sjFieldName();
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

	public static class SjFieldNameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(QBTMParser.NAME, 0); }
		public SjFieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sjFieldName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSjFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSjFieldName(this);
		}
	}

	public final SjFieldNameContext sjFieldName() throws RecognitionException {
		SjFieldNameContext _localctx = new SjFieldNameContext(_ctx, getState());
		enterRule(_localctx, 260, RULE_sjFieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1002);
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

	public static class SjKeyNameContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(QBTMParser.STRING, 0); }
		public SjKeyNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sjKeyName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSjKeyName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSjKeyName(this);
		}
	}

	public final SjKeyNameContext sjKeyName() throws RecognitionException {
		SjKeyNameContext _localctx = new SjKeyNameContext(_ctx, getState());
		enterRule(_localctx, 262, RULE_sjKeyName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1004);
			match(STRING);
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

	public static class SjConstantContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(QBTMParser.STRING, 0); }
		public TerminalNode INTEGER() { return getToken(QBTMParser.INTEGER, 0); }
		public SjConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sjConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSjConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSjConstant(this);
		}
	}

	public final SjConstantContext sjConstant() throws RecognitionException {
		SjConstantContext _localctx = new SjConstantContext(_ctx, getState());
		enterRule(_localctx, 264, RULE_sjConstant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1006);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==INTEGER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public static class PjqlQueryContext extends ParserRuleContext {
		public ViewNameContext viewName() {
			return getRuleContext(ViewNameContext.class,0);
		}
		public PjQueryContext pjQuery() {
			return getRuleContext(PjQueryContext.class,0);
		}
		public TerminalNode EOF() { return getToken(QBTMParser.EOF, 0); }
		public PjqlQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjqlQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjqlQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjqlQuery(this);
		}
	}

	public final PjqlQueryContext pjqlQuery() throws RecognitionException {
		PjqlQueryContext _localctx = new PjqlQueryContext(_ctx, getState());
		enterRule(_localctx, 266, RULE_pjqlQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1008);
			viewName();
			setState(1009);
			match(T__0);
			setState(1010);
			pjQuery();
			setState(1011);
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

	public static class PjQueryContext extends ParserRuleContext {
		public PjSelectClauseContext pjSelectClause() {
			return getRuleContext(PjSelectClauseContext.class,0);
		}
		public PjFromWhereClauseContext pjFromWhereClause() {
			return getRuleContext(PjFromWhereClauseContext.class,0);
		}
		public PjQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjQuery(this);
		}
	}

	public final PjQueryContext pjQuery() throws RecognitionException {
		PjQueryContext _localctx = new PjQueryContext(_ctx, getState());
		enterRule(_localctx, 268, RULE_pjQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1013);
			pjSelectClause();
			setState(1014);
			pjFromWhereClause();
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

	public static class PjSelectClauseContext extends ParserRuleContext {
		public PjSelectStatementContext pjSelectStatement() {
			return getRuleContext(PjSelectStatementContext.class,0);
		}
		public PjSelectClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjSelectClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjSelectClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjSelectClause(this);
		}
	}

	public final PjSelectClauseContext pjSelectClause() throws RecognitionException {
		PjSelectClauseContext _localctx = new PjSelectClauseContext(_ctx, getState());
		enterRule(_localctx, 270, RULE_pjSelectClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1016);
			pjSelectStatement();
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

	public static class PjSelectStatementContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(QBTMParser.SELECT, 0); }
		public List<PjSelectItemContext> pjSelectItem() {
			return getRuleContexts(PjSelectItemContext.class);
		}
		public PjSelectItemContext pjSelectItem(int i) {
			return getRuleContext(PjSelectItemContext.class,i);
		}
		public PjSelectStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjSelectStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjSelectStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjSelectStatement(this);
		}
	}

	public final PjSelectStatementContext pjSelectStatement() throws RecognitionException {
		PjSelectStatementContext _localctx = new PjSelectStatementContext(_ctx, getState());
		enterRule(_localctx, 272, RULE_pjSelectStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1018);
			match(SELECT);
			setState(1019);
			pjSelectItem();
			setState(1024);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(1020);
				match(T__1);
				setState(1021);
				pjSelectItem();
				}
				}
				setState(1026);
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

	public static class PjSelectItemContext extends ParserRuleContext {
		public PjSelectItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjSelectItem; }
	 
		public PjSelectItemContext() { }
		public void copyFrom(PjSelectItemContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PjSelectVarLabelContext extends PjSelectItemContext {
		public PjSelectVarContext pjSelectVar() {
			return getRuleContext(PjSelectVarContext.class,0);
		}
		public PjSelectVarLabelContext(PjSelectItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjSelectVarLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjSelectVarLabel(this);
		}
	}
	public static class PjSelectConstantLabelContext extends PjSelectItemContext {
		public PjSelectConstantContext pjSelectConstant() {
			return getRuleContext(PjSelectConstantContext.class,0);
		}
		public PjSelectConstantLabelContext(PjSelectItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjSelectConstantLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjSelectConstantLabel(this);
		}
	}
	public static class PjRecordConstructLabelContext extends PjSelectItemContext {
		public PjRecordConstructContext pjRecordConstruct() {
			return getRuleContext(PjRecordConstructContext.class,0);
		}
		public PjRecordConstructLabelContext(PjSelectItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjRecordConstructLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjRecordConstructLabel(this);
		}
	}
	public static class PjPathScalarLabelContext extends PjSelectItemContext {
		public PjPathScalarContext pjPathScalar() {
			return getRuleContext(PjPathScalarContext.class,0);
		}
		public TerminalNode AS() { return getToken(QBTMParser.AS, 0); }
		public PjSelectVarContext pjSelectVar() {
			return getRuleContext(PjSelectVarContext.class,0);
		}
		public PjPathScalarLabelContext(PjSelectItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjPathScalarLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjPathScalarLabel(this);
		}
	}

	public final PjSelectItemContext pjSelectItem() throws RecognitionException {
		PjSelectItemContext _localctx = new PjSelectItemContext(_ctx, getState());
		enterRule(_localctx, 274, RULE_pjSelectItem);
		try {
			setState(1034);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				_localctx = new PjRecordConstructLabelContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1027);
				pjRecordConstruct();
				}
				break;
			case 2:
				_localctx = new PjSelectVarLabelContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1028);
				pjSelectVar();
				}
				break;
			case 3:
				_localctx = new PjSelectConstantLabelContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1029);
				pjSelectConstant();
				}
				break;
			case 4:
				_localctx = new PjPathScalarLabelContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(1030);
				pjPathScalar();
				setState(1031);
				match(AS);
				setState(1032);
				pjSelectVar();
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

	public static class PjRecordConstructContext extends ParserRuleContext {
		public TerminalNode JSONBUILDOBJECT() { return getToken(QBTMParser.JSONBUILDOBJECT, 0); }
		public List<PjFieldBindingContext> pjFieldBinding() {
			return getRuleContexts(PjFieldBindingContext.class);
		}
		public PjFieldBindingContext pjFieldBinding(int i) {
			return getRuleContext(PjFieldBindingContext.class,i);
		}
		public PjRecordConstructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjRecordConstruct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjRecordConstruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjRecordConstruct(this);
		}
	}

	public final PjRecordConstructContext pjRecordConstruct() throws RecognitionException {
		PjRecordConstructContext _localctx = new PjRecordConstructContext(_ctx, getState());
		enterRule(_localctx, 276, RULE_pjRecordConstruct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1036);
			match(JSONBUILDOBJECT);
			setState(1037);
			match(T__5);
			setState(1038);
			pjFieldBinding();
			setState(1043);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(1039);
				match(T__1);
				setState(1040);
				pjFieldBinding();
				}
				}
				setState(1045);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1046);
			match(T__6);
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

	public static class PjFieldBindingContext extends ParserRuleContext {
		public PjRecordConstructFieldNameContext pjRecordConstructFieldName() {
			return getRuleContext(PjRecordConstructFieldNameContext.class,0);
		}
		public PjFieldValueContext pjFieldValue() {
			return getRuleContext(PjFieldValueContext.class,0);
		}
		public PjFieldBindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjFieldBinding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjFieldBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjFieldBinding(this);
		}
	}

	public final PjFieldBindingContext pjFieldBinding() throws RecognitionException {
		PjFieldBindingContext _localctx = new PjFieldBindingContext(_ctx, getState());
		enterRule(_localctx, 278, RULE_pjFieldBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1048);
			pjRecordConstructFieldName();
			setState(1049);
			match(T__1);
			setState(1050);
			pjFieldValue();
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

	public static class PjRecordConstructFieldNameContext extends ParserRuleContext {
		public PjKeyContext pjKey() {
			return getRuleContext(PjKeyContext.class,0);
		}
		public PjRecordConstructFieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjRecordConstructFieldName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjRecordConstructFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjRecordConstructFieldName(this);
		}
	}

	public final PjRecordConstructFieldNameContext pjRecordConstructFieldName() throws RecognitionException {
		PjRecordConstructFieldNameContext _localctx = new PjRecordConstructFieldNameContext(_ctx, getState());
		enterRule(_localctx, 280, RULE_pjRecordConstructFieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1052);
			pjKey();
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

	public static class PjFieldValueContext extends ParserRuleContext {
		public PjRecordConstructContext pjRecordConstruct() {
			return getRuleContext(PjRecordConstructContext.class,0);
		}
		public PjSelectVarContext pjSelectVar() {
			return getRuleContext(PjSelectVarContext.class,0);
		}
		public PjSelectConstantContext pjSelectConstant() {
			return getRuleContext(PjSelectConstantContext.class,0);
		}
		public PjSelectQueryContext pjSelectQuery() {
			return getRuleContext(PjSelectQueryContext.class,0);
		}
		public PjFieldValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjFieldValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjFieldValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjFieldValue(this);
		}
	}

	public final PjFieldValueContext pjFieldValue() throws RecognitionException {
		PjFieldValueContext _localctx = new PjFieldValueContext(_ctx, getState());
		enterRule(_localctx, 282, RULE_pjFieldValue);
		try {
			setState(1058);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case JSONBUILDOBJECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1054);
				pjRecordConstruct();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(1055);
				pjSelectVar();
				}
				break;
			case STRING:
			case INTEGER:
				enterOuterAlt(_localctx, 3);
				{
				setState(1056);
				pjSelectConstant();
				}
				break;
			case SELECT:
				enterOuterAlt(_localctx, 4);
				{
				setState(1057);
				pjSelectQuery();
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

	public static class PjSelectVarContext extends ParserRuleContext {
		public PjVariableContext pjVariable() {
			return getRuleContext(PjVariableContext.class,0);
		}
		public PjSelectVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjSelectVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjSelectVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjSelectVar(this);
		}
	}

	public final PjSelectVarContext pjSelectVar() throws RecognitionException {
		PjSelectVarContext _localctx = new PjSelectVarContext(_ctx, getState());
		enterRule(_localctx, 284, RULE_pjSelectVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1060);
			pjVariable();
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

	public static class PjPathScalarContext extends ParserRuleContext {
		public PjPathVarContext pjPathVar() {
			return getRuleContext(PjPathVarContext.class,0);
		}
		public PjObjStepScalarContext pjObjStepScalar() {
			return getRuleContext(PjObjStepScalarContext.class,0);
		}
		public CastContext cast() {
			return getRuleContext(CastContext.class,0);
		}
		public PjPathScalarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjPathScalar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjPathScalar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjPathScalar(this);
		}
	}

	public final PjPathScalarContext pjPathScalar() throws RecognitionException {
		PjPathScalarContext _localctx = new PjPathScalarContext(_ctx, getState());
		enterRule(_localctx, 286, RULE_pjPathScalar);
		try {
			setState(1071);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(1062);
				pjPathVar();
				setState(1063);
				pjObjStepScalar();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(1065);
				match(T__5);
				setState(1066);
				pjPathVar();
				setState(1067);
				pjObjStepScalar();
				setState(1068);
				match(T__6);
				setState(1069);
				cast();
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

	public static class PjSelectConstantContext extends ParserRuleContext {
		public PjConstantContext pjConstant() {
			return getRuleContext(PjConstantContext.class,0);
		}
		public PjSelectConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjSelectConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjSelectConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjSelectConstant(this);
		}
	}

	public final PjSelectConstantContext pjSelectConstant() throws RecognitionException {
		PjSelectConstantContext _localctx = new PjSelectConstantContext(_ctx, getState());
		enterRule(_localctx, 288, RULE_pjSelectConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1073);
			pjConstant();
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

	public static class PjSelectQueryContext extends ParserRuleContext {
		public PjQueryContext pjQuery() {
			return getRuleContext(PjQueryContext.class,0);
		}
		public PjSelectQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjSelectQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjSelectQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjSelectQuery(this);
		}
	}

	public final PjSelectQueryContext pjSelectQuery() throws RecognitionException {
		PjSelectQueryContext _localctx = new PjSelectQueryContext(_ctx, getState());
		enterRule(_localctx, 290, RULE_pjSelectQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1075);
			pjQuery();
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

	public static class CastContext extends ParserRuleContext {
		public CastContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cast; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterCast(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitCast(this);
		}
	}

	public final CastContext cast() throws RecognitionException {
		CastContext _localctx = new CastContext(_ctx, getState());
		enterRule(_localctx, 292, RULE_cast);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1077);
			match(T__23);
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

	public static class PjFromWhereClauseContext extends ParserRuleContext {
		public PjFromClauseContext pjFromClause() {
			return getRuleContext(PjFromClauseContext.class,0);
		}
		public PjWhereClauseContext pjWhereClause() {
			return getRuleContext(PjWhereClauseContext.class,0);
		}
		public PjFromWhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjFromWhereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjFromWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjFromWhereClause(this);
		}
	}

	public final PjFromWhereClauseContext pjFromWhereClause() throws RecognitionException {
		PjFromWhereClauseContext _localctx = new PjFromWhereClauseContext(_ctx, getState());
		enterRule(_localctx, 294, RULE_pjFromWhereClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1079);
			pjFromClause();
			setState(1081);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(1080);
				pjWhereClause();
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

	public static class PjFromClauseContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(QBTMParser.FROM, 0); }
		public List<PjBindingContext> pjBinding() {
			return getRuleContexts(PjBindingContext.class);
		}
		public PjBindingContext pjBinding(int i) {
			return getRuleContext(PjBindingContext.class,i);
		}
		public PjFromClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjFromClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjFromClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjFromClause(this);
		}
	}

	public final PjFromClauseContext pjFromClause() throws RecognitionException {
		PjFromClauseContext _localctx = new PjFromClauseContext(_ctx, getState());
		enterRule(_localctx, 296, RULE_pjFromClause);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1083);
			match(FROM);
			setState(1084);
			pjBinding();
			setState(1089);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1085);
					match(T__1);
					setState(1086);
					pjBinding();
					}
					} 
				}
				setState(1091);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
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

	public static class PjBindingContext extends ParserRuleContext {
		public PjFromClauseBindingSourceContext pjFromClauseBindingSource() {
			return getRuleContext(PjFromClauseBindingSourceContext.class,0);
		}
		public TerminalNode AS() { return getToken(QBTMParser.AS, 0); }
		public PjFromClauseBindingVarContext pjFromClauseBindingVar() {
			return getRuleContext(PjFromClauseBindingVarContext.class,0);
		}
		public PjBindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjBinding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjBinding(this);
		}
	}

	public final PjBindingContext pjBinding() throws RecognitionException {
		PjBindingContext _localctx = new PjBindingContext(_ctx, getState());
		enterRule(_localctx, 298, RULE_pjBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1092);
			pjFromClauseBindingSource();
			setState(1093);
			match(AS);
			setState(1094);
			pjFromClauseBindingVar();
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

	public static class PjFromClauseBindingSourceContext extends ParserRuleContext {
		public PjSourceContext pjSource() {
			return getRuleContext(PjSourceContext.class,0);
		}
		public PjFromClauseBindingSourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjFromClauseBindingSource; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjFromClauseBindingSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjFromClauseBindingSource(this);
		}
	}

	public final PjFromClauseBindingSourceContext pjFromClauseBindingSource() throws RecognitionException {
		PjFromClauseBindingSourceContext _localctx = new PjFromClauseBindingSourceContext(_ctx, getState());
		enterRule(_localctx, 300, RULE_pjFromClauseBindingSource);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1096);
			pjSource();
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

	public static class PjSourceContext extends ParserRuleContext {
		public PjRelationContext pjRelation() {
			return getRuleContext(PjRelationContext.class,0);
		}
		public TerminalNode JSONARRAYELEMENTS() { return getToken(QBTMParser.JSONARRAYELEMENTS, 0); }
		public PjPathContext pjPath() {
			return getRuleContext(PjPathContext.class,0);
		}
		public PjSourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjSource; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjSource(this);
		}
	}

	public final PjSourceContext pjSource() throws RecognitionException {
		PjSourceContext _localctx = new PjSourceContext(_ctx, getState());
		enterRule(_localctx, 302, RULE_pjSource);
		try {
			setState(1104);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(1098);
				pjRelation();
				}
				break;
			case JSONARRAYELEMENTS:
				enterOuterAlt(_localctx, 2);
				{
				setState(1099);
				match(JSONARRAYELEMENTS);
				setState(1100);
				match(T__5);
				setState(1101);
				pjPath();
				setState(1102);
				match(T__6);
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

	public static class PjFromClauseBindingVarContext extends ParserRuleContext {
		public PjVariableContext pjVariable() {
			return getRuleContext(PjVariableContext.class,0);
		}
		public PjFromClauseBindingVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjFromClauseBindingVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjFromClauseBindingVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjFromClauseBindingVar(this);
		}
	}

	public final PjFromClauseBindingVarContext pjFromClauseBindingVar() throws RecognitionException {
		PjFromClauseBindingVarContext _localctx = new PjFromClauseBindingVarContext(_ctx, getState());
		enterRule(_localctx, 304, RULE_pjFromClauseBindingVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1106);
			pjVariable();
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

	public static class PjWhereClauseContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(QBTMParser.WHERE, 0); }
		public PjConditionContext pjCondition() {
			return getRuleContext(PjConditionContext.class,0);
		}
		public PjWhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjWhereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjWhereClause(this);
		}
	}

	public final PjWhereClauseContext pjWhereClause() throws RecognitionException {
		PjWhereClauseContext _localctx = new PjWhereClauseContext(_ctx, getState());
		enterRule(_localctx, 306, RULE_pjWhereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1108);
			match(WHERE);
			setState(1109);
			pjCondition(0);
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

	public static class PjConditionContext extends ParserRuleContext {
		public PjWhereCondEqualityContext pjWhereCondEquality() {
			return getRuleContext(PjWhereCondEqualityContext.class,0);
		}
		public List<PjConditionContext> pjCondition() {
			return getRuleContexts(PjConditionContext.class);
		}
		public PjConditionContext pjCondition(int i) {
			return getRuleContext(PjConditionContext.class,i);
		}
		public TerminalNode AND() { return getToken(QBTMParser.AND, 0); }
		public PjConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjCondition(this);
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
		int _startState = 308;
		enterRecursionRule(_localctx, 308, RULE_pjCondition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1117);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
			case STRING:
			case INTEGER:
				{
				setState(1112);
				pjWhereCondEquality();
				}
				break;
			case T__5:
				{
				setState(1113);
				match(T__5);
				setState(1114);
				pjCondition(0);
				setState(1115);
				match(T__6);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(1124);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PjConditionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_pjCondition);
					setState(1119);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(1120);
					match(AND);
					setState(1121);
					pjCondition(3);
					}
					} 
				}
				setState(1126);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
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

	public static class PjWhereCondEqualityContext extends ParserRuleContext {
		public PjWhereCondEqualityLeftTermContext pjWhereCondEqualityLeftTerm() {
			return getRuleContext(PjWhereCondEqualityLeftTermContext.class,0);
		}
		public PjWhereCondEqualityRightTermContext pjWhereCondEqualityRightTerm() {
			return getRuleContext(PjWhereCondEqualityRightTermContext.class,0);
		}
		public PjWhereCondEqualityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjWhereCondEquality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjWhereCondEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjWhereCondEquality(this);
		}
	}

	public final PjWhereCondEqualityContext pjWhereCondEquality() throws RecognitionException {
		PjWhereCondEqualityContext _localctx = new PjWhereCondEqualityContext(_ctx, getState());
		enterRule(_localctx, 310, RULE_pjWhereCondEquality);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1127);
			pjWhereCondEqualityLeftTerm();
			setState(1128);
			match(T__0);
			setState(1129);
			pjWhereCondEqualityRightTerm();
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

	public static class PjWhereCondEqualityLeftTermContext extends ParserRuleContext {
		public PjCTermContext pjCTerm() {
			return getRuleContext(PjCTermContext.class,0);
		}
		public PjWhereCondEqualityLeftTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjWhereCondEqualityLeftTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjWhereCondEqualityLeftTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjWhereCondEqualityLeftTerm(this);
		}
	}

	public final PjWhereCondEqualityLeftTermContext pjWhereCondEqualityLeftTerm() throws RecognitionException {
		PjWhereCondEqualityLeftTermContext _localctx = new PjWhereCondEqualityLeftTermContext(_ctx, getState());
		enterRule(_localctx, 312, RULE_pjWhereCondEqualityLeftTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1131);
			pjCTerm();
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

	public static class PjWhereCondEqualityRightTermContext extends ParserRuleContext {
		public PjCTermContext pjCTerm() {
			return getRuleContext(PjCTermContext.class,0);
		}
		public PjWhereCondEqualityRightTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjWhereCondEqualityRightTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjWhereCondEqualityRightTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjWhereCondEqualityRightTerm(this);
		}
	}

	public final PjWhereCondEqualityRightTermContext pjWhereCondEqualityRightTerm() throws RecognitionException {
		PjWhereCondEqualityRightTermContext _localctx = new PjWhereCondEqualityRightTermContext(_ctx, getState());
		enterRule(_localctx, 314, RULE_pjWhereCondEqualityRightTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1133);
			pjCTerm();
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

	public static class PjCTermContext extends ParserRuleContext {
		public PjTermContext pjTerm() {
			return getRuleContext(PjTermContext.class,0);
		}
		public PjCTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjCTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjCTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjCTerm(this);
		}
	}

	public final PjCTermContext pjCTerm() throws RecognitionException {
		PjCTermContext _localctx = new PjCTermContext(_ctx, getState());
		enterRule(_localctx, 316, RULE_pjCTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1135);
			pjTerm();
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

	public static class PjTermContext extends ParserRuleContext {
		public PjTermConstantContext pjTermConstant() {
			return getRuleContext(PjTermConstantContext.class,0);
		}
		public PjTermVarContext pjTermVar() {
			return getRuleContext(PjTermVarContext.class,0);
		}
		public PjTermPathContext pjTermPath() {
			return getRuleContext(PjTermPathContext.class,0);
		}
		public PjTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjTerm(this);
		}
	}

	public final PjTermContext pjTerm() throws RecognitionException {
		PjTermContext _localctx = new PjTermContext(_ctx, getState());
		enterRule(_localctx, 318, RULE_pjTerm);
		try {
			setState(1140);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,56,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1137);
				pjTermConstant();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1138);
				pjTermVar();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1139);
				pjTermPath();
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

	public static class PjTermVarContext extends ParserRuleContext {
		public PjVariableContext pjVariable() {
			return getRuleContext(PjVariableContext.class,0);
		}
		public PjTermVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjTermVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjTermVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjTermVar(this);
		}
	}

	public final PjTermVarContext pjTermVar() throws RecognitionException {
		PjTermVarContext _localctx = new PjTermVarContext(_ctx, getState());
		enterRule(_localctx, 320, RULE_pjTermVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1142);
			pjVariable();
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

	public static class PjTermConstantContext extends ParserRuleContext {
		public PjConstantContext pjConstant() {
			return getRuleContext(PjConstantContext.class,0);
		}
		public PjTermConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjTermConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjTermConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjTermConstant(this);
		}
	}

	public final PjTermConstantContext pjTermConstant() throws RecognitionException {
		PjTermConstantContext _localctx = new PjTermConstantContext(_ctx, getState());
		enterRule(_localctx, 322, RULE_pjTermConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1144);
			pjConstant();
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

	public static class PjTermPathContext extends ParserRuleContext {
		public PjPathContext pjPath() {
			return getRuleContext(PjPathContext.class,0);
		}
		public PjTermPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjTermPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjTermPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjTermPath(this);
		}
	}

	public final PjTermPathContext pjTermPath() throws RecognitionException {
		PjTermPathContext _localctx = new PjTermPathContext(_ctx, getState());
		enterRule(_localctx, 324, RULE_pjTermPath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1146);
			pjPath();
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

	public static class PjPathContext extends ParserRuleContext {
		public PjPathVarContext pjPathVar() {
			return getRuleContext(PjPathVarContext.class,0);
		}
		public List<PjStepContext> pjStep() {
			return getRuleContexts(PjStepContext.class);
		}
		public PjStepContext pjStep(int i) {
			return getRuleContext(PjStepContext.class,i);
		}
		public PjPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjPath(this);
		}
	}

	public final PjPathContext pjPath() throws RecognitionException {
		PjPathContext _localctx = new PjPathContext(_ctx, getState());
		enterRule(_localctx, 326, RULE_pjPath);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1148);
			pjPathVar();
			setState(1150); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(1149);
					pjStep();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1152); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,57,_ctx);
			} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class PjPathVarContext extends ParserRuleContext {
		public PjVariableContext pjVariable() {
			return getRuleContext(PjVariableContext.class,0);
		}
		public PjPathAttrContext pjPathAttr() {
			return getRuleContext(PjPathAttrContext.class,0);
		}
		public PjPathVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjPathVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjPathVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjPathVar(this);
		}
	}

	public final PjPathVarContext pjPathVar() throws RecognitionException {
		PjPathVarContext _localctx = new PjPathVarContext(_ctx, getState());
		enterRule(_localctx, 328, RULE_pjPathVar);
		try {
			setState(1156);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,58,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1154);
				pjVariable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1155);
				pjPathAttr();
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

	public static class PjStepContext extends ParserRuleContext {
		public PjObjStepContext pjObjStep() {
			return getRuleContext(PjObjStepContext.class,0);
		}
		public PjStepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjStep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjStep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjStep(this);
		}
	}

	public final PjStepContext pjStep() throws RecognitionException {
		PjStepContext _localctx = new PjStepContext(_ctx, getState());
		enterRule(_localctx, 330, RULE_pjStep);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1158);
			pjObjStep();
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

	public static class PjObjStepContext extends ParserRuleContext {
		public PjKeyContext pjKey() {
			return getRuleContext(PjKeyContext.class,0);
		}
		public PjObjStepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjObjStep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjObjStep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjObjStep(this);
		}
	}

	public final PjObjStepContext pjObjStep() throws RecognitionException {
		PjObjStepContext _localctx = new PjObjStepContext(_ctx, getState());
		enterRule(_localctx, 332, RULE_pjObjStep);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1160);
			match(T__7);
			setState(1161);
			pjKey();
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

	public static class PjStepScalarContext extends ParserRuleContext {
		public PjObjStepScalarContext pjObjStepScalar() {
			return getRuleContext(PjObjStepScalarContext.class,0);
		}
		public PjStepScalarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjStepScalar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjStepScalar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjStepScalar(this);
		}
	}

	public final PjStepScalarContext pjStepScalar() throws RecognitionException {
		PjStepScalarContext _localctx = new PjStepScalarContext(_ctx, getState());
		enterRule(_localctx, 334, RULE_pjStepScalar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1163);
			pjObjStepScalar();
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

	public static class PjObjStepScalarContext extends ParserRuleContext {
		public PjKeyContext pjKey() {
			return getRuleContext(PjKeyContext.class,0);
		}
		public PjObjStepScalarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjObjStepScalar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjObjStepScalar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjObjStepScalar(this);
		}
	}

	public final PjObjStepScalarContext pjObjStepScalar() throws RecognitionException {
		PjObjStepScalarContext _localctx = new PjObjStepScalarContext(_ctx, getState());
		enterRule(_localctx, 336, RULE_pjObjStepScalar);
		try {
			setState(1169);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__24:
				enterOuterAlt(_localctx, 1);
				{
				setState(1165);
				match(T__24);
				setState(1166);
				pjKey();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(1167);
				match(T__7);
				setState(1168);
				pjKey();
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

	public static class PjPathAttrContext extends ParserRuleContext {
		public PjVariableContext pjVariable() {
			return getRuleContext(PjVariableContext.class,0);
		}
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public PjPathAttrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjPathAttr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjPathAttr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjPathAttr(this);
		}
	}

	public final PjPathAttrContext pjPathAttr() throws RecognitionException {
		PjPathAttrContext _localctx = new PjPathAttrContext(_ctx, getState());
		enterRule(_localctx, 338, RULE_pjPathAttr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1171);
			pjVariable();
			setState(1172);
			match(T__8);
			setState(1173);
			attribute();
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

	public static class PjVariableContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(QBTMParser.NAME, 0); }
		public PjVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjVariable(this);
		}
	}

	public final PjVariableContext pjVariable() throws RecognitionException {
		PjVariableContext _localctx = new PjVariableContext(_ctx, getState());
		enterRule(_localctx, 340, RULE_pjVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1175);
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

	public static class PjRelationContext extends ParserRuleContext {
		public List<TerminalNode> NAME() { return getTokens(QBTMParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(QBTMParser.NAME, i);
		}
		public PjRelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjRelation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjRelation(this);
		}
	}

	public final PjRelationContext pjRelation() throws RecognitionException {
		PjRelationContext _localctx = new PjRelationContext(_ctx, getState());
		enterRule(_localctx, 342, RULE_pjRelation);
		try {
			setState(1181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1177);
				match(NAME);
				setState(1178);
				match(T__8);
				setState(1179);
				match(NAME);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1180);
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

	public static class PjKeyContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(QBTMParser.STRING, 0); }
		public TerminalNode NAME() { return getToken(QBTMParser.NAME, 0); }
		public PjKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjKey(this);
		}
	}

	public final PjKeyContext pjKey() throws RecognitionException {
		PjKeyContext _localctx = new PjKeyContext(_ctx, getState());
		enterRule(_localctx, 344, RULE_pjKey);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1183);
			_la = _input.LA(1);
			if ( !(_la==NAME || _la==STRING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public static class PjConstantContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(QBTMParser.INTEGER, 0); }
		public TerminalNode STRING() { return getToken(QBTMParser.STRING, 0); }
		public PjConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterPjConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitPjConstant(this);
		}
	}

	public final PjConstantContext pjConstant() throws RecognitionException {
		PjConstantContext _localctx = new PjConstantContext(_ctx, getState());
		enterRule(_localctx, 346, RULE_pjConstant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1185);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==INTEGER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public static class AttributeContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(QBTMParser.NAME, 0); }
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitAttribute(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 348, RULE_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1187);
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

	public static class SppjqlQueryContext extends ParserRuleContext {
		public ViewNameContext viewName() {
			return getRuleContext(ViewNameContext.class,0);
		}
		public SppjQueryContext sppjQuery() {
			return getRuleContext(SppjQueryContext.class,0);
		}
		public TerminalNode EOF() { return getToken(QBTMParser.EOF, 0); }
		public SppjRootFieldNameContext sppjRootFieldName() {
			return getRuleContext(SppjRootFieldNameContext.class,0);
		}
		public SppjqlQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjqlQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjqlQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjqlQuery(this);
		}
	}

	public final SppjqlQueryContext sppjqlQuery() throws RecognitionException {
		SppjqlQueryContext _localctx = new SppjqlQueryContext(_ctx, getState());
		enterRule(_localctx, 350, RULE_sppjqlQuery);
		try {
			setState(1202);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(1189);
				viewName();
				setState(1190);
				match(T__0);
				setState(1191);
				sppjQuery();
				setState(1192);
				match(EOF);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				setState(1194);
				match(T__3);
				setState(1195);
				sppjRootFieldName();
				setState(1196);
				match(T__2);
				setState(1197);
				match(T__5);
				setState(1198);
				sppjQuery();
				setState(1199);
				match(T__6);
				setState(1200);
				match(T__4);
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

	public static class SppjQueryContext extends ParserRuleContext {
		public TerminalNode USE() { return getToken(QBTMParser.USE, 0); }
		public TerminalNode NAME() { return getToken(QBTMParser.NAME, 0); }
		public SppjSelectClauseContext sppjSelectClause() {
			return getRuleContext(SppjSelectClauseContext.class,0);
		}
		public SppjFromWhereClauseContext sppjFromWhereClause() {
			return getRuleContext(SppjFromWhereClauseContext.class,0);
		}
		public SppjQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjQuery(this);
		}
	}

	public final SppjQueryContext sppjQuery() throws RecognitionException {
		SppjQueryContext _localctx = new SppjQueryContext(_ctx, getState());
		enterRule(_localctx, 352, RULE_sppjQuery);
		try {
			setState(1213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case USE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1204);
				match(USE);
				setState(1205);
				match(NAME);
				setState(1206);
				match(T__25);
				setState(1207);
				sppjSelectClause();
				setState(1208);
				sppjFromWhereClause();
				}
				break;
			case SELECT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1210);
				sppjSelectClause();
				setState(1211);
				sppjFromWhereClause();
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

	public static class SppjRootFieldNameContext extends ParserRuleContext {
		public SppjFieldNameContext sppjFieldName() {
			return getRuleContext(SppjFieldNameContext.class,0);
		}
		public SppjRootFieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjRootFieldName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjRootFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjRootFieldName(this);
		}
	}

	public final SppjRootFieldNameContext sppjRootFieldName() throws RecognitionException {
		SppjRootFieldNameContext _localctx = new SppjRootFieldNameContext(_ctx, getState());
		enterRule(_localctx, 354, RULE_sppjRootFieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1215);
			sppjFieldName();
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

	public static class SppjSelectClauseContext extends ParserRuleContext {
		public SppjSelectStatementContext sppjSelectStatement() {
			return getRuleContext(SppjSelectStatementContext.class,0);
		}
		public SppjSelectClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjSelectClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjSelectClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjSelectClause(this);
		}
	}

	public final SppjSelectClauseContext sppjSelectClause() throws RecognitionException {
		SppjSelectClauseContext _localctx = new SppjSelectClauseContext(_ctx, getState());
		enterRule(_localctx, 356, RULE_sppjSelectClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1217);
			sppjSelectStatement();
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

	public static class SppjSelectStatementContext extends ParserRuleContext {
		public TerminalNode SELECT() { return getToken(QBTMParser.SELECT, 0); }
		public TerminalNode VALUE() { return getToken(QBTMParser.VALUE, 0); }
		public List<SppjSelectItemContext> sppjSelectItem() {
			return getRuleContexts(SppjSelectItemContext.class);
		}
		public SppjSelectItemContext sppjSelectItem(int i) {
			return getRuleContext(SppjSelectItemContext.class,i);
		}
		public SppjSelectStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjSelectStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjSelectStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjSelectStatement(this);
		}
	}

	public final SppjSelectStatementContext sppjSelectStatement() throws RecognitionException {
		SppjSelectStatementContext _localctx = new SppjSelectStatementContext(_ctx, getState());
		enterRule(_localctx, 358, RULE_sppjSelectStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1219);
			match(SELECT);
			setState(1220);
			match(VALUE);
			setState(1221);
			sppjSelectItem();
			setState(1226);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(1222);
				match(T__1);
				setState(1223);
				sppjSelectItem();
				}
				}
				setState(1228);
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

	public static class SppjSelectItemContext extends ParserRuleContext {
		public SppjSelectItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjSelectItem; }
	 
		public SppjSelectItemContext() { }
		public void copyFrom(SppjSelectItemContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SppjRecordConstructLabelContext extends SppjSelectItemContext {
		public SppjRecordConstructContext sppjRecordConstruct() {
			return getRuleContext(SppjRecordConstructContext.class,0);
		}
		public SppjRecordConstructLabelContext(SppjSelectItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjRecordConstructLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjRecordConstructLabel(this);
		}
	}
	public static class SppjSelectPathLabelContext extends SppjSelectItemContext {
		public SppjPathContext sppjPath() {
			return getRuleContext(SppjPathContext.class,0);
		}
		public TerminalNode AS() { return getToken(QBTMParser.AS, 0); }
		public SppjSelectVarContext sppjSelectVar() {
			return getRuleContext(SppjSelectVarContext.class,0);
		}
		public SppjSelectPathLabelContext(SppjSelectItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjSelectPathLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjSelectPathLabel(this);
		}
	}
	public static class SppjSelectVarLabeLContext extends SppjSelectItemContext {
		public SppjSelectVarContext sppjSelectVar() {
			return getRuleContext(SppjSelectVarContext.class,0);
		}
		public SppjSelectVarLabeLContext(SppjSelectItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjSelectVarLabeL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjSelectVarLabeL(this);
		}
	}
	public static class SppjSelectConstantLabelContext extends SppjSelectItemContext {
		public SppjSelectConstantContext sppjSelectConstant() {
			return getRuleContext(SppjSelectConstantContext.class,0);
		}
		public SppjSelectConstantLabelContext(SppjSelectItemContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjSelectConstantLabel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjSelectConstantLabel(this);
		}
	}

	public final SppjSelectItemContext sppjSelectItem() throws RecognitionException {
		SppjSelectItemContext _localctx = new SppjSelectItemContext(_ctx, getState());
		enterRule(_localctx, 360, RULE_sppjSelectItem);
		try {
			setState(1236);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,64,_ctx) ) {
			case 1:
				_localctx = new SppjRecordConstructLabelContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1229);
				sppjRecordConstruct();
				}
				break;
			case 2:
				_localctx = new SppjSelectVarLabeLContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1230);
				sppjSelectVar();
				}
				break;
			case 3:
				_localctx = new SppjSelectConstantLabelContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1231);
				sppjSelectConstant();
				}
				break;
			case 4:
				_localctx = new SppjSelectPathLabelContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(1232);
				sppjPath();
				setState(1233);
				match(AS);
				setState(1234);
				sppjSelectVar();
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

	public static class SppjRootRecordConstructContext extends ParserRuleContext {
		public List<SppjFieldBindingContext> sppjFieldBinding() {
			return getRuleContexts(SppjFieldBindingContext.class);
		}
		public SppjFieldBindingContext sppjFieldBinding(int i) {
			return getRuleContext(SppjFieldBindingContext.class,i);
		}
		public SppjRootRecordConstructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjRootRecordConstruct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjRootRecordConstruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjRootRecordConstruct(this);
		}
	}

	public final SppjRootRecordConstructContext sppjRootRecordConstruct() throws RecognitionException {
		SppjRootRecordConstructContext _localctx = new SppjRootRecordConstructContext(_ctx, getState());
		enterRule(_localctx, 362, RULE_sppjRootRecordConstruct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1238);
			match(T__3);
			setState(1239);
			sppjFieldBinding();
			setState(1244);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(1240);
				match(T__1);
				setState(1241);
				sppjFieldBinding();
				}
				}
				setState(1246);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1247);
			match(T__4);
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

	public static class SppjRecordConstructContext extends ParserRuleContext {
		public List<SppjFieldBindingContext> sppjFieldBinding() {
			return getRuleContexts(SppjFieldBindingContext.class);
		}
		public SppjFieldBindingContext sppjFieldBinding(int i) {
			return getRuleContext(SppjFieldBindingContext.class,i);
		}
		public SppjRecordConstructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjRecordConstruct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjRecordConstruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjRecordConstruct(this);
		}
	}

	public final SppjRecordConstructContext sppjRecordConstruct() throws RecognitionException {
		SppjRecordConstructContext _localctx = new SppjRecordConstructContext(_ctx, getState());
		enterRule(_localctx, 364, RULE_sppjRecordConstruct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1249);
			match(T__3);
			setState(1250);
			sppjFieldBinding();
			setState(1255);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(1251);
				match(T__1);
				setState(1252);
				sppjFieldBinding();
				}
				}
				setState(1257);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1258);
			match(T__4);
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

	public static class SppjFieldBindingContext extends ParserRuleContext {
		public SppjRecordConstructFieldNameContext sppjRecordConstructFieldName() {
			return getRuleContext(SppjRecordConstructFieldNameContext.class,0);
		}
		public SppjFieldValueContext sppjFieldValue() {
			return getRuleContext(SppjFieldValueContext.class,0);
		}
		public SppjFieldBindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjFieldBinding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjFieldBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjFieldBinding(this);
		}
	}

	public final SppjFieldBindingContext sppjFieldBinding() throws RecognitionException {
		SppjFieldBindingContext _localctx = new SppjFieldBindingContext(_ctx, getState());
		enterRule(_localctx, 366, RULE_sppjFieldBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1260);
			sppjRecordConstructFieldName();
			setState(1261);
			match(T__2);
			setState(1262);
			sppjFieldValue();
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

	public static class SppjRecordConstructFieldNameContext extends ParserRuleContext {
		public SppjFieldNameContext sppjFieldName() {
			return getRuleContext(SppjFieldNameContext.class,0);
		}
		public SppjRecordConstructFieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjRecordConstructFieldName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjRecordConstructFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjRecordConstructFieldName(this);
		}
	}

	public final SppjRecordConstructFieldNameContext sppjRecordConstructFieldName() throws RecognitionException {
		SppjRecordConstructFieldNameContext _localctx = new SppjRecordConstructFieldNameContext(_ctx, getState());
		enterRule(_localctx, 368, RULE_sppjRecordConstructFieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1264);
			sppjFieldName();
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

	public static class SppjFieldValueContext extends ParserRuleContext {
		public SppjRecordConstructContext sppjRecordConstruct() {
			return getRuleContext(SppjRecordConstructContext.class,0);
		}
		public SppjSelectVarContext sppjSelectVar() {
			return getRuleContext(SppjSelectVarContext.class,0);
		}
		public SppjSelectConstantContext sppjSelectConstant() {
			return getRuleContext(SppjSelectConstantContext.class,0);
		}
		public SppjPathContext sppjPath() {
			return getRuleContext(SppjPathContext.class,0);
		}
		public SppjQueryContext sppjQuery() {
			return getRuleContext(SppjQueryContext.class,0);
		}
		public SppjFieldValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjFieldValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjFieldValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjFieldValue(this);
		}
	}

	public final SppjFieldValueContext sppjFieldValue() throws RecognitionException {
		SppjFieldValueContext _localctx = new SppjFieldValueContext(_ctx, getState());
		enterRule(_localctx, 370, RULE_sppjFieldValue);
		try {
			setState(1274);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1266);
				sppjRecordConstruct();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1267);
				sppjSelectVar();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1268);
				sppjSelectConstant();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1269);
				sppjPath();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1270);
				match(T__5);
				setState(1271);
				sppjQuery();
				setState(1272);
				match(T__6);
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

	public static class SppjSelectVarContext extends ParserRuleContext {
		public SppjVariableContext sppjVariable() {
			return getRuleContext(SppjVariableContext.class,0);
		}
		public SppjSelectVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjSelectVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjSelectVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjSelectVar(this);
		}
	}

	public final SppjSelectVarContext sppjSelectVar() throws RecognitionException {
		SppjSelectVarContext _localctx = new SppjSelectVarContext(_ctx, getState());
		enterRule(_localctx, 372, RULE_sppjSelectVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1276);
			sppjVariable();
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

	public static class SppjSelectConstantContext extends ParserRuleContext {
		public SppjConstantContext sppjConstant() {
			return getRuleContext(SppjConstantContext.class,0);
		}
		public SppjSelectConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjSelectConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjSelectConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjSelectConstant(this);
		}
	}

	public final SppjSelectConstantContext sppjSelectConstant() throws RecognitionException {
		SppjSelectConstantContext _localctx = new SppjSelectConstantContext(_ctx, getState());
		enterRule(_localctx, 374, RULE_sppjSelectConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1278);
			sppjConstant();
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

	public static class SppjSelectQueryContext extends ParserRuleContext {
		public SppjQueryContext sppjQuery() {
			return getRuleContext(SppjQueryContext.class,0);
		}
		public SppjSelectQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjSelectQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjSelectQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjSelectQuery(this);
		}
	}

	public final SppjSelectQueryContext sppjSelectQuery() throws RecognitionException {
		SppjSelectQueryContext _localctx = new SppjSelectQueryContext(_ctx, getState());
		enterRule(_localctx, 376, RULE_sppjSelectQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1280);
			sppjQuery();
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

	public static class SppjFromWhereClauseContext extends ParserRuleContext {
		public SppjFromClauseContext sppjFromClause() {
			return getRuleContext(SppjFromClauseContext.class,0);
		}
		public SppjWhereClauseContext sppjWhereClause() {
			return getRuleContext(SppjWhereClauseContext.class,0);
		}
		public SppjFromWhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjFromWhereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjFromWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjFromWhereClause(this);
		}
	}

	public final SppjFromWhereClauseContext sppjFromWhereClause() throws RecognitionException {
		SppjFromWhereClauseContext _localctx = new SppjFromWhereClauseContext(_ctx, getState());
		enterRule(_localctx, 378, RULE_sppjFromWhereClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1282);
			sppjFromClause();
			setState(1284);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(1283);
				sppjWhereClause();
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

	public static class SppjFromClauseContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(QBTMParser.FROM, 0); }
		public List<SppjBindingContext> sppjBinding() {
			return getRuleContexts(SppjBindingContext.class);
		}
		public SppjBindingContext sppjBinding(int i) {
			return getRuleContext(SppjBindingContext.class,i);
		}
		public SppjFromClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjFromClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjFromClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjFromClause(this);
		}
	}

	public final SppjFromClauseContext sppjFromClause() throws RecognitionException {
		SppjFromClauseContext _localctx = new SppjFromClauseContext(_ctx, getState());
		enterRule(_localctx, 380, RULE_sppjFromClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1286);
			match(FROM);
			setState(1287);
			sppjBinding();
			setState(1292);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(1288);
				match(T__1);
				setState(1289);
				sppjBinding();
				}
				}
				setState(1294);
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

	public static class SppjBindingContext extends ParserRuleContext {
		public SppjFromClauseBindingSourceContext sppjFromClauseBindingSource() {
			return getRuleContext(SppjFromClauseBindingSourceContext.class,0);
		}
		public TerminalNode AS() { return getToken(QBTMParser.AS, 0); }
		public SppjFromClauseBindingVarContext sppjFromClauseBindingVar() {
			return getRuleContext(SppjFromClauseBindingVarContext.class,0);
		}
		public SppjBindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjBinding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjBinding(this);
		}
	}

	public final SppjBindingContext sppjBinding() throws RecognitionException {
		SppjBindingContext _localctx = new SppjBindingContext(_ctx, getState());
		enterRule(_localctx, 382, RULE_sppjBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1295);
			sppjFromClauseBindingSource();
			setState(1296);
			match(AS);
			setState(1297);
			sppjFromClauseBindingVar();
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

	public static class SppjFromClauseBindingSourceContext extends ParserRuleContext {
		public SppjSourceContext sppjSource() {
			return getRuleContext(SppjSourceContext.class,0);
		}
		public SppjFromClauseBindingSourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjFromClauseBindingSource; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjFromClauseBindingSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjFromClauseBindingSource(this);
		}
	}

	public final SppjFromClauseBindingSourceContext sppjFromClauseBindingSource() throws RecognitionException {
		SppjFromClauseBindingSourceContext _localctx = new SppjFromClauseBindingSourceContext(_ctx, getState());
		enterRule(_localctx, 384, RULE_sppjFromClauseBindingSource);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1299);
			sppjSource();
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

	public static class SppjSourceContext extends ParserRuleContext {
		public DataSetNameContext dataSetName() {
			return getRuleContext(DataSetNameContext.class,0);
		}
		public SppjPathContext sppjPath() {
			return getRuleContext(SppjPathContext.class,0);
		}
		public SppjSourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjSource; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjSource(this);
		}
	}

	public final SppjSourceContext sppjSource() throws RecognitionException {
		SppjSourceContext _localctx = new SppjSourceContext(_ctx, getState());
		enterRule(_localctx, 386, RULE_sppjSource);
		try {
			setState(1303);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1301);
				dataSetName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1302);
				sppjPath();
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

	public static class SppjFromClauseBindingVarContext extends ParserRuleContext {
		public SppjVariableContext sppjVariable() {
			return getRuleContext(SppjVariableContext.class,0);
		}
		public SppjFromClauseBindingVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjFromClauseBindingVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjFromClauseBindingVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjFromClauseBindingVar(this);
		}
	}

	public final SppjFromClauseBindingVarContext sppjFromClauseBindingVar() throws RecognitionException {
		SppjFromClauseBindingVarContext _localctx = new SppjFromClauseBindingVarContext(_ctx, getState());
		enterRule(_localctx, 388, RULE_sppjFromClauseBindingVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1305);
			sppjVariable();
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

	public static class SppjWhereClauseContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(QBTMParser.WHERE, 0); }
		public SppjConditionContext sppjCondition() {
			return getRuleContext(SppjConditionContext.class,0);
		}
		public SppjWhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjWhereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjWhereClause(this);
		}
	}

	public final SppjWhereClauseContext sppjWhereClause() throws RecognitionException {
		SppjWhereClauseContext _localctx = new SppjWhereClauseContext(_ctx, getState());
		enterRule(_localctx, 390, RULE_sppjWhereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1307);
			match(WHERE);
			setState(1308);
			sppjCondition(0);
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

	public static class SppjConditionContext extends ParserRuleContext {
		public SppjWhereCondEqualityContext sppjWhereCondEquality() {
			return getRuleContext(SppjWhereCondEqualityContext.class,0);
		}
		public List<SppjConditionContext> sppjCondition() {
			return getRuleContexts(SppjConditionContext.class);
		}
		public SppjConditionContext sppjCondition(int i) {
			return getRuleContext(SppjConditionContext.class,i);
		}
		public TerminalNode AND() { return getToken(QBTMParser.AND, 0); }
		public SppjConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjCondition(this);
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
		int _startState = 392;
		enterRecursionRule(_localctx, 392, RULE_sppjCondition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1316);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
			case STRING:
			case INTEGER:
				{
				setState(1311);
				sppjWhereCondEquality();
				}
				break;
			case T__5:
				{
				setState(1312);
				match(T__5);
				setState(1313);
				sppjCondition(0);
				setState(1314);
				match(T__6);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(1323);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SppjConditionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_sppjCondition);
					setState(1318);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(1319);
					match(AND);
					setState(1320);
					sppjCondition(3);
					}
					} 
				}
				setState(1325);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
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

	public static class SppjWhereCondEqualityContext extends ParserRuleContext {
		public SppjWhereCondEqualityLeftTermContext sppjWhereCondEqualityLeftTerm() {
			return getRuleContext(SppjWhereCondEqualityLeftTermContext.class,0);
		}
		public SppjWhereCondEqualityRightTermContext sppjWhereCondEqualityRightTerm() {
			return getRuleContext(SppjWhereCondEqualityRightTermContext.class,0);
		}
		public SppjWhereCondEqualityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjWhereCondEquality; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjWhereCondEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjWhereCondEquality(this);
		}
	}

	public final SppjWhereCondEqualityContext sppjWhereCondEquality() throws RecognitionException {
		SppjWhereCondEqualityContext _localctx = new SppjWhereCondEqualityContext(_ctx, getState());
		enterRule(_localctx, 394, RULE_sppjWhereCondEquality);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1326);
			sppjWhereCondEqualityLeftTerm();
			setState(1327);
			match(T__0);
			setState(1328);
			sppjWhereCondEqualityRightTerm();
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

	public static class SppjWhereCondEqualityLeftTermContext extends ParserRuleContext {
		public SppjCTermContext sppjCTerm() {
			return getRuleContext(SppjCTermContext.class,0);
		}
		public SppjWhereCondEqualityLeftTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjWhereCondEqualityLeftTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjWhereCondEqualityLeftTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjWhereCondEqualityLeftTerm(this);
		}
	}

	public final SppjWhereCondEqualityLeftTermContext sppjWhereCondEqualityLeftTerm() throws RecognitionException {
		SppjWhereCondEqualityLeftTermContext _localctx = new SppjWhereCondEqualityLeftTermContext(_ctx, getState());
		enterRule(_localctx, 396, RULE_sppjWhereCondEqualityLeftTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1330);
			sppjCTerm();
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

	public static class SppjWhereCondEqualityRightTermContext extends ParserRuleContext {
		public SppjCTermContext sppjCTerm() {
			return getRuleContext(SppjCTermContext.class,0);
		}
		public SppjWhereCondEqualityRightTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjWhereCondEqualityRightTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjWhereCondEqualityRightTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjWhereCondEqualityRightTerm(this);
		}
	}

	public final SppjWhereCondEqualityRightTermContext sppjWhereCondEqualityRightTerm() throws RecognitionException {
		SppjWhereCondEqualityRightTermContext _localctx = new SppjWhereCondEqualityRightTermContext(_ctx, getState());
		enterRule(_localctx, 398, RULE_sppjWhereCondEqualityRightTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1332);
			sppjCTerm();
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

	public static class SppjCTermContext extends ParserRuleContext {
		public SppjTermContext sppjTerm() {
			return getRuleContext(SppjTermContext.class,0);
		}
		public SppjCTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjCTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjCTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjCTerm(this);
		}
	}

	public final SppjCTermContext sppjCTerm() throws RecognitionException {
		SppjCTermContext _localctx = new SppjCTermContext(_ctx, getState());
		enterRule(_localctx, 400, RULE_sppjCTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1334);
			sppjTerm();
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

	public static class SppjTermContext extends ParserRuleContext {
		public SppjTermConstantContext sppjTermConstant() {
			return getRuleContext(SppjTermConstantContext.class,0);
		}
		public SppjTermVarContext sppjTermVar() {
			return getRuleContext(SppjTermVarContext.class,0);
		}
		public SppjTermPathContext sppjTermPath() {
			return getRuleContext(SppjTermPathContext.class,0);
		}
		public SppjTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjTerm(this);
		}
	}

	public final SppjTermContext sppjTerm() throws RecognitionException {
		SppjTermContext _localctx = new SppjTermContext(_ctx, getState());
		enterRule(_localctx, 402, RULE_sppjTerm);
		try {
			setState(1339);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1336);
				sppjTermConstant();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1337);
				sppjTermVar();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1338);
				sppjTermPath();
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

	public static class SppjTermVarContext extends ParserRuleContext {
		public SppjVariableContext sppjVariable() {
			return getRuleContext(SppjVariableContext.class,0);
		}
		public SppjTermVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjTermVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjTermVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjTermVar(this);
		}
	}

	public final SppjTermVarContext sppjTermVar() throws RecognitionException {
		SppjTermVarContext _localctx = new SppjTermVarContext(_ctx, getState());
		enterRule(_localctx, 404, RULE_sppjTermVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1341);
			sppjVariable();
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

	public static class SppjTermConstantContext extends ParserRuleContext {
		public SppjConstantContext sppjConstant() {
			return getRuleContext(SppjConstantContext.class,0);
		}
		public SppjTermConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjTermConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjTermConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjTermConstant(this);
		}
	}

	public final SppjTermConstantContext sppjTermConstant() throws RecognitionException {
		SppjTermConstantContext _localctx = new SppjTermConstantContext(_ctx, getState());
		enterRule(_localctx, 406, RULE_sppjTermConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1343);
			sppjConstant();
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

	public static class SppjTermPathContext extends ParserRuleContext {
		public SppjPathContext sppjPath() {
			return getRuleContext(SppjPathContext.class,0);
		}
		public SppjTermPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjTermPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjTermPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjTermPath(this);
		}
	}

	public final SppjTermPathContext sppjTermPath() throws RecognitionException {
		SppjTermPathContext _localctx = new SppjTermPathContext(_ctx, getState());
		enterRule(_localctx, 408, RULE_sppjTermPath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1345);
			sppjPath();
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

	public static class SppjPathContext extends ParserRuleContext {
		public SppjPathVarContext sppjPathVar() {
			return getRuleContext(SppjPathVarContext.class,0);
		}
		public List<SppjStepContext> sppjStep() {
			return getRuleContexts(SppjStepContext.class);
		}
		public SppjStepContext sppjStep(int i) {
			return getRuleContext(SppjStepContext.class,i);
		}
		public SppjPathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjPath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjPath(this);
		}
	}

	public final SppjPathContext sppjPath() throws RecognitionException {
		SppjPathContext _localctx = new SppjPathContext(_ctx, getState());
		enterRule(_localctx, 410, RULE_sppjPath);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1347);
			sppjPathVar();
			setState(1349); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(1348);
					sppjStep();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1351); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
			} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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

	public static class SppjPathVarContext extends ParserRuleContext {
		public SppjVariableContext sppjVariable() {
			return getRuleContext(SppjVariableContext.class,0);
		}
		public SppjPathVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjPathVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjPathVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjPathVar(this);
		}
	}

	public final SppjPathVarContext sppjPathVar() throws RecognitionException {
		SppjPathVarContext _localctx = new SppjPathVarContext(_ctx, getState());
		enterRule(_localctx, 412, RULE_sppjPathVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1353);
			sppjVariable();
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

	public static class SppjStepContext extends ParserRuleContext {
		public SppjObjStepContext sppjObjStep() {
			return getRuleContext(SppjObjStepContext.class,0);
		}
		public SppjStepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjStep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjStep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjStep(this);
		}
	}

	public final SppjStepContext sppjStep() throws RecognitionException {
		SppjStepContext _localctx = new SppjStepContext(_ctx, getState());
		enterRule(_localctx, 414, RULE_sppjStep);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1355);
			sppjObjStep();
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

	public static class SppjObjStepContext extends ParserRuleContext {
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public SppjObjStepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjObjStep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjObjStep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjObjStep(this);
		}
	}

	public final SppjObjStepContext sppjObjStep() throws RecognitionException {
		SppjObjStepContext _localctx = new SppjObjStepContext(_ctx, getState());
		enterRule(_localctx, 416, RULE_sppjObjStep);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1357);
			match(T__8);
			setState(1358);
			key();
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

	public static class SppjVariableContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(QBTMParser.NAME, 0); }
		public SppjVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjVariable(this);
		}
	}

	public final SppjVariableContext sppjVariable() throws RecognitionException {
		SppjVariableContext _localctx = new SppjVariableContext(_ctx, getState());
		enterRule(_localctx, 418, RULE_sppjVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1360);
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

	public static class SppjFieldNameContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(QBTMParser.STRING, 0); }
		public SppjFieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjFieldName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjFieldName(this);
		}
	}

	public final SppjFieldNameContext sppjFieldName() throws RecognitionException {
		SppjFieldNameContext _localctx = new SppjFieldNameContext(_ctx, getState());
		enterRule(_localctx, 420, RULE_sppjFieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1362);
			match(STRING);
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

	public static class SppjConstantContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(QBTMParser.INTEGER, 0); }
		public TerminalNode STRING() { return getToken(QBTMParser.STRING, 0); }
		public SppjConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).enterSppjConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof QBTMListener ) ((QBTMListener)listener).exitSppjConstant(this);
		}
	}

	public final SppjConstantContext sppjConstant() throws RecognitionException {
		SppjConstantContext _localctx = new SppjConstantContext(_ctx, getState());
		enterRule(_localctx, 422, RULE_sppjConstant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1364);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==INTEGER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 15:
			return qbtCondition_sempred((QbtConditionContext)_localctx, predIndex);
		case 88:
			return condition_sempred((ConditionContext)_localctx, predIndex);
		case 113:
			return prCondition_sempred((PrConditionContext)_localctx, predIndex);
		case 154:
			return pjCondition_sempred((PjConditionContext)_localctx, predIndex);
		case 196:
			return sppjCondition_sempred((SppjConditionContext)_localctx, predIndex);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3?\u0559\4\2\t\2\4"+
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
		"\t\u00a0\4\u00a1\t\u00a1\4\u00a2\t\u00a2\4\u00a3\t\u00a3\4\u00a4\t\u00a4"+
		"\4\u00a5\t\u00a5\4\u00a6\t\u00a6\4\u00a7\t\u00a7\4\u00a8\t\u00a8\4\u00a9"+
		"\t\u00a9\4\u00aa\t\u00aa\4\u00ab\t\u00ab\4\u00ac\t\u00ac\4\u00ad\t\u00ad"+
		"\4\u00ae\t\u00ae\4\u00af\t\u00af\4\u00b0\t\u00b0\4\u00b1\t\u00b1\4\u00b2"+
		"\t\u00b2\4\u00b3\t\u00b3\4\u00b4\t\u00b4\4\u00b5\t\u00b5\4\u00b6\t\u00b6"+
		"\4\u00b7\t\u00b7\4\u00b8\t\u00b8\4\u00b9\t\u00b9\4\u00ba\t\u00ba\4\u00bb"+
		"\t\u00bb\4\u00bc\t\u00bc\4\u00bd\t\u00bd\4\u00be\t\u00be\4\u00bf\t\u00bf"+
		"\4\u00c0\t\u00c0\4\u00c1\t\u00c1\4\u00c2\t\u00c2\4\u00c3\t\u00c3\4\u00c4"+
		"\t\u00c4\4\u00c5\t\u00c5\4\u00c6\t\u00c6\4\u00c7\t\u00c7\4\u00c8\t\u00c8"+
		"\4\u00c9\t\u00c9\4\u00ca\t\u00ca\4\u00cb\t\u00cb\4\u00cc\t\u00cc\4\u00cd"+
		"\t\u00cd\4\u00ce\t\u00ce\4\u00cf\t\u00cf\4\u00d0\t\u00d0\4\u00d1\t\u00d1"+
		"\4\u00d2\t\u00d2\4\u00d3\t\u00d3\4\u00d4\t\u00d4\4\u00d5\t\u00d5\3\2\3"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\5\5\u01b6\n\5\3\5\3\5\3\6\3\6\3"+
		"\6\3\6\7\6\u01be\n\6\f\6\16\6\u01c1\13\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\5\n\u01d5\n\n\3\13\3\13\5\13"+
		"\u01d9\n\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3"+
		"\21\3\21\3\21\3\21\5\21\u01eb\n\21\3\21\3\21\3\21\7\21\u01f0\n\21\f\21"+
		"\16\21\u01f3\13\21\3\22\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3"+
		"\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3"+
		"\31\5\31\u020e\n\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\7\34\u0217\n\34"+
		"\f\34\16\34\u021a\13\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3 \3 \3 \3"+
		"!\3!\3\"\3\"\3\"\3#\3#\3$\3$\3$\3%\3%\5%\u0233\n%\3&\3&\3\'\3\'\3\'\3"+
		"\'\3\'\3\'\7\'\u023d\n\'\f\'\16\'\u0240\13\'\3\'\3\'\3(\3(\3(\3(\3)\3"+
		")\3*\3*\3*\3*\3*\5*\u024f\n*\3+\3+\3+\3+\7+\u0255\n+\f+\16+\u0258\13+"+
		"\3,\3,\3,\3,\3-\3-\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\7/\u026a\n/\f/\16/\u026d"+
		"\13/\3/\3/\3/\3/\3/\3/\3/\3/\7/\u0277\n/\f/\16/\u027a\13/\3/\3/\3/\3/"+
		"\3/\5/\u0281\n/\3\60\3\60\3\61\3\61\3\62\3\62\5\62\u0289\n\62\3\63\3\63"+
		"\3\64\3\64\3\64\3\64\5\64\u0291\n\64\3\65\3\65\3\66\3\66\5\66\u0297\n"+
		"\66\3\67\3\67\3\67\3\67\5\67\u029d\n\67\38\38\38\38\38\38\38\38\38\58"+
		"\u02a8\n8\39\39\39\3:\3:\3;\3;\3;\3;\5;\u02b3\n;\3<\3<\3<\3<\7<\u02b9"+
		"\n<\f<\16<\u02bc\13<\3<\3<\3=\3=\3=\3=\3>\3>\3?\3?\3@\3@\3@\3@\5@\u02cc"+
		"\n@\3A\3A\3A\3A\3A\5A\u02d3\nA\3B\3B\3C\3C\3D\3D\3E\3E\3E\5E\u02de\nE"+
		"\3F\3F\3F\3F\3F\5F\u02e5\nF\3G\3G\3H\3H\3I\3I\5I\u02ed\nI\3J\3J\3K\3K"+
		"\6K\u02f3\nK\rK\16K\u02f4\3L\3L\3M\3M\3N\3N\5N\u02fd\nN\3O\3O\3O\3P\3"+
		"P\3P\3P\3Q\3Q\3R\3R\3S\3S\3S\3S\7S\u030e\nS\fS\16S\u0311\13S\3T\3T\3T"+
		"\3T\3U\3U\3V\3V\3W\3W\3W\5W\u031e\nW\3X\3X\3Y\3Y\3Y\3Z\3Z\3Z\3Z\3Z\3Z"+
		"\3Z\3Z\3Z\3Z\3Z\5Z\u0330\nZ\3Z\3Z\3Z\7Z\u0335\nZ\fZ\16Z\u0338\13Z\3[\3"+
		"[\3[\7[\u033d\n[\f[\16[\u0340\13[\3\\\3\\\3\\\3\\\3]\3]\3^\3^\3_\3_\3"+
		"_\3_\3`\3`\3a\3a\3b\3b\3c\3c\5c\u0356\nc\3d\3d\3d\3d\3d\3e\3e\3f\3f\3"+
		"f\3g\3g\5g\u0364\ng\3h\3h\3i\3i\3i\3i\7i\u036c\ni\fi\16i\u036f\13i\3j"+
		"\3j\3j\3j\3j\5j\u0376\nj\3k\3k\3l\3l\3l\3l\7l\u037e\nl\fl\16l\u0381\13"+
		"l\3m\3m\3m\3m\3n\3n\3o\3o\3p\3p\3q\3q\3r\3r\3r\3s\3s\3s\3s\3s\3s\3s\5"+
		"s\u0399\ns\3s\3s\3s\7s\u039e\ns\fs\16s\u03a1\13s\3t\3t\3t\3t\3t\5t\u03a8"+
		"\nt\3u\3u\3u\3u\3v\3v\3v\3v\3w\3w\3x\3x\3y\3y\3z\3z\3z\3z\3z\3{\3{\3{"+
		"\3{\3{\5{\u03c2\n{\3{\3{\3{\3|\3|\3}\3}\3}\3}\3~\3~\3\177\3\177\3\u0080"+
		"\3\u0080\5\u0080\u03d3\n\u0080\3\u0081\3\u0081\3\u0081\3\u0081\7\u0081"+
		"\u03d9\n\u0081\f\u0081\16\u0081\u03dc\13\u0081\3\u0082\3\u0082\3\u0082"+
		"\3\u0082\7\u0082\u03e2\n\u0082\f\u0082\16\u0082\u03e5\13\u0082\3\u0082"+
		"\3\u0082\3\u0083\3\u0083\3\u0083\3\u0083\3\u0084\3\u0084\3\u0085\3\u0085"+
		"\3\u0086\3\u0086\3\u0087\3\u0087\3\u0087\3\u0087\3\u0087\3\u0088\3\u0088"+
		"\3\u0088\3\u0089\3\u0089\3\u008a\3\u008a\3\u008a\3\u008a\7\u008a\u0401"+
		"\n\u008a\f\u008a\16\u008a\u0404\13\u008a\3\u008b\3\u008b\3\u008b\3\u008b"+
		"\3\u008b\3\u008b\3\u008b\5\u008b\u040d\n\u008b\3\u008c\3\u008c\3\u008c"+
		"\3\u008c\3\u008c\7\u008c\u0414\n\u008c\f\u008c\16\u008c\u0417\13\u008c"+
		"\3\u008c\3\u008c\3\u008d\3\u008d\3\u008d\3\u008d\3\u008e\3\u008e\3\u008f"+
		"\3\u008f\3\u008f\3\u008f\5\u008f\u0425\n\u008f\3\u0090\3\u0090\3\u0091"+
		"\3\u0091\3\u0091\3\u0091\3\u0091\3\u0091\3\u0091\3\u0091\3\u0091\5\u0091"+
		"\u0432\n\u0091\3\u0092\3\u0092\3\u0093\3\u0093\3\u0094\3\u0094\3\u0095"+
		"\3\u0095\5\u0095\u043c\n\u0095\3\u0096\3\u0096\3\u0096\3\u0096\7\u0096"+
		"\u0442\n\u0096\f\u0096\16\u0096\u0445\13\u0096\3\u0097\3\u0097\3\u0097"+
		"\3\u0097\3\u0098\3\u0098\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099\3\u0099"+
		"\5\u0099\u0453\n\u0099\3\u009a\3\u009a\3\u009b\3\u009b\3\u009b\3\u009c"+
		"\3\u009c\3\u009c\3\u009c\3\u009c\3\u009c\5\u009c\u0460\n\u009c\3\u009c"+
		"\3\u009c\3\u009c\7\u009c\u0465\n\u009c\f\u009c\16\u009c\u0468\13\u009c"+
		"\3\u009d\3\u009d\3\u009d\3\u009d\3\u009e\3\u009e\3\u009f\3\u009f\3\u00a0"+
		"\3\u00a0\3\u00a1\3\u00a1\3\u00a1\5\u00a1\u0477\n\u00a1\3\u00a2\3\u00a2"+
		"\3\u00a3\3\u00a3\3\u00a4\3\u00a4\3\u00a5\3\u00a5\6\u00a5\u0481\n\u00a5"+
		"\r\u00a5\16\u00a5\u0482\3\u00a6\3\u00a6\5\u00a6\u0487\n\u00a6\3\u00a7"+
		"\3\u00a7\3\u00a8\3\u00a8\3\u00a8\3\u00a9\3\u00a9\3\u00aa\3\u00aa\3\u00aa"+
		"\3\u00aa\5\u00aa\u0494\n\u00aa\3\u00ab\3\u00ab\3\u00ab\3\u00ab\3\u00ac"+
		"\3\u00ac\3\u00ad\3\u00ad\3\u00ad\3\u00ad\5\u00ad\u04a0\n\u00ad\3\u00ae"+
		"\3\u00ae\3\u00af\3\u00af\3\u00b0\3\u00b0\3\u00b1\3\u00b1\3\u00b1\3\u00b1"+
		"\3\u00b1\3\u00b1\3\u00b1\3\u00b1\3\u00b1\3\u00b1\3\u00b1\3\u00b1\3\u00b1"+
		"\5\u00b1\u04b5\n\u00b1\3\u00b2\3\u00b2\3\u00b2\3\u00b2\3\u00b2\3\u00b2"+
		"\3\u00b2\3\u00b2\3\u00b2\5\u00b2\u04c0\n\u00b2\3\u00b3\3\u00b3\3\u00b4"+
		"\3\u00b4\3\u00b5\3\u00b5\3\u00b5\3\u00b5\3\u00b5\7\u00b5\u04cb\n\u00b5"+
		"\f\u00b5\16\u00b5\u04ce\13\u00b5\3\u00b6\3\u00b6\3\u00b6\3\u00b6\3\u00b6"+
		"\3\u00b6\3\u00b6\5\u00b6\u04d7\n\u00b6\3\u00b7\3\u00b7\3\u00b7\3\u00b7"+
		"\7\u00b7\u04dd\n\u00b7\f\u00b7\16\u00b7\u04e0\13\u00b7\3\u00b7\3\u00b7"+
		"\3\u00b8\3\u00b8\3\u00b8\3\u00b8\7\u00b8\u04e8\n\u00b8\f\u00b8\16\u00b8"+
		"\u04eb\13\u00b8\3\u00b8\3\u00b8\3\u00b9\3\u00b9\3\u00b9\3\u00b9\3\u00ba"+
		"\3\u00ba\3\u00bb\3\u00bb\3\u00bb\3\u00bb\3\u00bb\3\u00bb\3\u00bb\3\u00bb"+
		"\5\u00bb\u04fd\n\u00bb\3\u00bc\3\u00bc\3\u00bd\3\u00bd\3\u00be\3\u00be"+
		"\3\u00bf\3\u00bf\5\u00bf\u0507\n\u00bf\3\u00c0\3\u00c0\3\u00c0\3\u00c0"+
		"\7\u00c0\u050d\n\u00c0\f\u00c0\16\u00c0\u0510\13\u00c0\3\u00c1\3\u00c1"+
		"\3\u00c1\3\u00c1\3\u00c2\3\u00c2\3\u00c3\3\u00c3\5\u00c3\u051a\n\u00c3"+
		"\3\u00c4\3\u00c4\3\u00c5\3\u00c5\3\u00c5\3\u00c6\3\u00c6\3\u00c6\3\u00c6"+
		"\3\u00c6\3\u00c6\5\u00c6\u0527\n\u00c6\3\u00c6\3\u00c6\3\u00c6\7\u00c6"+
		"\u052c\n\u00c6\f\u00c6\16\u00c6\u052f\13\u00c6\3\u00c7\3\u00c7\3\u00c7"+
		"\3\u00c7\3\u00c8\3\u00c8\3\u00c9\3\u00c9\3\u00ca\3\u00ca\3\u00cb\3\u00cb"+
		"\3\u00cb\5\u00cb\u053e\n\u00cb\3\u00cc\3\u00cc\3\u00cd\3\u00cd\3\u00ce"+
		"\3\u00ce\3\u00cf\3\u00cf\6\u00cf\u0548\n\u00cf\r\u00cf\16\u00cf\u0549"+
		"\3\u00d0\3\u00d0\3\u00d1\3\u00d1\3\u00d2\3\u00d2\3\u00d2\3\u00d3\3\u00d3"+
		"\3\u00d4\3\u00d4\3\u00d5\3\u00d5\3\u00d5\4\u0482\u0549\7 \u00b2\u00e4"+
		"\u0136\u018a\u00d6\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60"+
		"\62\64\668:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086"+
		"\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e"+
		"\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6"+
		"\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce"+
		"\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc\u00de\u00e0\u00e2\u00e4\u00e6"+
		"\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2\u00f4\u00f6\u00f8\u00fa\u00fc\u00fe"+
		"\u0100\u0102\u0104\u0106\u0108\u010a\u010c\u010e\u0110\u0112\u0114\u0116"+
		"\u0118\u011a\u011c\u011e\u0120\u0122\u0124\u0126\u0128\u012a\u012c\u012e"+
		"\u0130\u0132\u0134\u0136\u0138\u013a\u013c\u013e\u0140\u0142\u0144\u0146"+
		"\u0148\u014a\u014c\u014e\u0150\u0152\u0154\u0156\u0158\u015a\u015c\u015e"+
		"\u0160\u0162\u0164\u0166\u0168\u016a\u016c\u016e\u0170\u0172\u0174\u0176"+
		"\u0178\u017a\u017c\u017e\u0180\u0182\u0184\u0186\u0188\u018a\u018c\u018e"+
		"\u0190\u0192\u0194\u0196\u0198\u019a\u019c\u019e\u01a0\u01a2\u01a4\u01a6"+
		"\u01a8\2\5\4\2 %\'\'\3\2\62\63\3\2\61\62\2\u04e9\2\u01aa\3\2\2\2\4\u01af"+
		"\3\2\2\2\6\u01b1\3\2\2\2\b\u01b3\3\2\2\2\n\u01b9\3\2\2\2\f\u01c2\3\2\2"+
		"\2\16\u01c5\3\2\2\2\20\u01c8\3\2\2\2\22\u01d4\3\2\2\2\24\u01d6\3\2\2\2"+
		"\26\u01da\3\2\2\2\30\u01dc\3\2\2\2\32\u01de\3\2\2\2\34\u01e0\3\2\2\2\36"+
		"\u01e2\3\2\2\2 \u01ea\3\2\2\2\"\u01f4\3\2\2\2$\u01f8\3\2\2\2&\u01fa\3"+
		"\2\2\2(\u01fc\3\2\2\2*\u01fe\3\2\2\2,\u0200\3\2\2\2.\u0202\3\2\2\2\60"+
		"\u020d\3\2\2\2\62\u020f\3\2\2\2\64\u0211\3\2\2\2\66\u0213\3\2\2\28\u021b"+
		"\3\2\2\2:\u021d\3\2\2\2<\u021f\3\2\2\2>\u0221\3\2\2\2@\u0226\3\2\2\2B"+
		"\u0228\3\2\2\2D\u022b\3\2\2\2F\u022d\3\2\2\2H\u0232\3\2\2\2J\u0234\3\2"+
		"\2\2L\u0236\3\2\2\2N\u0243\3\2\2\2P\u0247\3\2\2\2R\u024e\3\2\2\2T\u0250"+
		"\3\2\2\2V\u0259\3\2\2\2X\u025d\3\2\2\2Z\u025f\3\2\2\2\\\u0280\3\2\2\2"+
		"^\u0282\3\2\2\2`\u0284\3\2\2\2b\u0288\3\2\2\2d\u028a\3\2\2\2f\u0290\3"+
		"\2\2\2h\u0292\3\2\2\2j\u0296\3\2\2\2l\u029c\3\2\2\2n\u029e\3\2\2\2p\u02a9"+
		"\3\2\2\2r\u02ac\3\2\2\2t\u02ae\3\2\2\2v\u02b4\3\2\2\2x\u02bf\3\2\2\2z"+
		"\u02c3\3\2\2\2|\u02c5\3\2\2\2~\u02cb\3\2\2\2\u0080\u02d2\3\2\2\2\u0082"+
		"\u02d4\3\2\2\2\u0084\u02d6\3\2\2\2\u0086\u02d8\3\2\2\2\u0088\u02dd\3\2"+
		"\2\2\u008a\u02e4\3\2\2\2\u008c\u02e6\3\2\2\2\u008e\u02e8\3\2\2\2\u0090"+
		"\u02ec\3\2\2\2\u0092\u02ee\3\2\2\2\u0094\u02f0\3\2\2\2\u0096\u02f6\3\2"+
		"\2\2\u0098\u02f8\3\2\2\2\u009a\u02fc\3\2\2\2\u009c\u02fe\3\2\2\2\u009e"+
		"\u0301\3\2\2\2\u00a0\u0305\3\2\2\2\u00a2\u0307\3\2\2\2\u00a4\u0309\3\2"+
		"\2\2\u00a6\u0312\3\2\2\2\u00a8\u0316\3\2\2\2\u00aa\u0318\3\2\2\2\u00ac"+
		"\u031d\3\2\2\2\u00ae\u031f\3\2\2\2\u00b0\u0321\3\2\2\2\u00b2\u032f\3\2"+
		"\2\2\u00b4\u0339\3\2\2\2\u00b6\u0341\3\2\2\2\u00b8\u0345\3\2\2\2\u00ba"+
		"\u0347\3\2\2\2\u00bc\u0349\3\2\2\2\u00be\u034d\3\2\2\2\u00c0\u034f\3\2"+
		"\2\2\u00c2\u0351\3\2\2\2\u00c4\u0353\3\2\2\2\u00c6\u0357\3\2\2\2\u00c8"+
		"\u035c\3\2\2\2\u00ca\u035e\3\2\2\2\u00cc\u0361\3\2\2\2\u00ce\u0365\3\2"+
		"\2\2\u00d0\u0367\3\2\2\2\u00d2\u0375\3\2\2\2\u00d4\u0377\3\2\2\2\u00d6"+
		"\u0379\3\2\2\2\u00d8\u0382\3\2\2\2\u00da\u0386\3\2\2\2\u00dc\u0388\3\2"+
		"\2\2\u00de\u038a\3\2\2\2\u00e0\u038c\3\2\2\2\u00e2\u038e\3\2\2\2\u00e4"+
		"\u0398\3\2\2\2\u00e6\u03a7\3\2\2\2\u00e8\u03a9\3\2\2\2\u00ea\u03ad\3\2"+
		"\2\2\u00ec\u03b1\3\2\2\2\u00ee\u03b3\3\2\2\2\u00f0\u03b5\3\2\2\2\u00f2"+
		"\u03b7\3\2\2\2\u00f4\u03bc\3\2\2\2\u00f6\u03c6\3\2\2\2\u00f8\u03c8\3\2"+
		"\2\2\u00fa\u03cc\3\2\2\2\u00fc\u03ce\3\2\2\2\u00fe\u03d2\3\2\2\2\u0100"+
		"\u03d4\3\2\2\2\u0102\u03dd\3\2\2\2\u0104\u03e8\3\2\2\2\u0106\u03ec\3\2"+
		"\2\2\u0108\u03ee\3\2\2\2\u010a\u03f0\3\2\2\2\u010c\u03f2\3\2\2\2\u010e"+
		"\u03f7\3\2\2\2\u0110\u03fa\3\2\2\2\u0112\u03fc\3\2\2\2\u0114\u040c\3\2"+
		"\2\2\u0116\u040e\3\2\2\2\u0118\u041a\3\2\2\2\u011a\u041e\3\2\2\2\u011c"+
		"\u0424\3\2\2\2\u011e\u0426\3\2\2\2\u0120\u0431\3\2\2\2\u0122\u0433\3\2"+
		"\2\2\u0124\u0435\3\2\2\2\u0126\u0437\3\2\2\2\u0128\u0439\3\2\2\2\u012a"+
		"\u043d\3\2\2\2\u012c\u0446\3\2\2\2\u012e\u044a\3\2\2\2\u0130\u0452\3\2"+
		"\2\2\u0132\u0454\3\2\2\2\u0134\u0456\3\2\2\2\u0136\u045f\3\2\2\2\u0138"+
		"\u0469\3\2\2\2\u013a\u046d\3\2\2\2\u013c\u046f\3\2\2\2\u013e\u0471\3\2"+
		"\2\2\u0140\u0476\3\2\2\2\u0142\u0478\3\2\2\2\u0144\u047a\3\2\2\2\u0146"+
		"\u047c\3\2\2\2\u0148\u047e\3\2\2\2\u014a\u0486\3\2\2\2\u014c\u0488\3\2"+
		"\2\2\u014e\u048a\3\2\2\2\u0150\u048d\3\2\2\2\u0152\u0493\3\2\2\2\u0154"+
		"\u0495\3\2\2\2\u0156\u0499\3\2\2\2\u0158\u049f\3\2\2\2\u015a\u04a1\3\2"+
		"\2\2\u015c\u04a3\3\2\2\2\u015e\u04a5\3\2\2\2\u0160\u04b4\3\2\2\2\u0162"+
		"\u04bf\3\2\2\2\u0164\u04c1\3\2\2\2\u0166\u04c3\3\2\2\2\u0168\u04c5\3\2"+
		"\2\2\u016a\u04d6\3\2\2\2\u016c\u04d8\3\2\2\2\u016e\u04e3\3\2\2\2\u0170"+
		"\u04ee\3\2\2\2\u0172\u04f2\3\2\2\2\u0174\u04fc\3\2\2\2\u0176\u04fe\3\2"+
		"\2\2\u0178\u0500\3\2\2\2\u017a\u0502\3\2\2\2\u017c\u0504\3\2\2\2\u017e"+
		"\u0508\3\2\2\2\u0180\u0511\3\2\2\2\u0182\u0515\3\2\2\2\u0184\u0519\3\2"+
		"\2\2\u0186\u051b\3\2\2\2\u0188\u051d\3\2\2\2\u018a\u0526\3\2\2\2\u018c"+
		"\u0530\3\2\2\2\u018e\u0534\3\2\2\2\u0190\u0536\3\2\2\2\u0192\u0538\3\2"+
		"\2\2\u0194\u053d\3\2\2\2\u0196\u053f\3\2\2\2\u0198\u0541\3\2\2\2\u019a"+
		"\u0543\3\2\2\2\u019c\u0545\3\2\2\2\u019e\u054b\3\2\2\2\u01a0\u054d\3\2"+
		"\2\2\u01a2\u054f\3\2\2\2\u01a4\u0552\3\2\2\2\u01a6\u0554\3\2\2\2\u01a8"+
		"\u0556\3\2\2\2\u01aa\u01ab\5\4\3\2\u01ab\u01ac\7\3\2\2\u01ac\u01ad\5\6"+
		"\4\2\u01ad\u01ae\7\2\2\3\u01ae\3\3\2\2\2\u01af\u01b0\7\61\2\2\u01b0\5"+
		"\3\2\2\2\u01b1\u01b2\5\b\5\2\u01b2\7\3\2\2\2\u01b3\u01b5\5\n\6\2\u01b4"+
		"\u01b6\5\f\7\2\u01b5\u01b4\3\2\2\2\u01b5\u01b6\3\2\2\2\u01b6\u01b7\3\2"+
		"\2\2\u01b7\u01b8\5\16\b\2\u01b8\t\3\2\2\2\u01b9\u01ba\7\35\2\2\u01ba\u01bf"+
		"\5\20\t\2\u01bb\u01bc\7\4\2\2\u01bc\u01be\5\20\t\2\u01bd\u01bb\3\2\2\2"+
		"\u01be\u01c1\3\2\2\2\u01bf\u01bd\3\2\2\2\u01bf\u01c0\3\2\2\2\u01c0\13"+
		"\3\2\2\2\u01c1\u01bf\3\2\2\2\u01c2\u01c3\7\36\2\2\u01c3\u01c4\5 \21\2"+
		"\u01c4\r\3\2\2\2\u01c5\u01c6\7\37\2\2\u01c6\u01c7\5.\30\2\u01c7\17\3\2"+
		"\2\2\u01c8\u01c9\5<\37\2\u01c9\u01ca\7\5\2\2\u01ca\u01cb\7\6\2\2\u01cb"+
		"\u01cc\5\22\n\2\u01cc\u01cd\7\7\2\2\u01cd\21\3\2\2\2\u01ce\u01d5\5\24"+
		"\13\2\u01cf\u01d5\5\26\f\2\u01d0\u01d5\5\30\r\2\u01d1\u01d5\5\32\16\2"+
		"\u01d2\u01d5\5\34\17\2\u01d3\u01d5\5\36\20\2\u01d4\u01ce\3\2\2\2\u01d4"+
		"\u01cf\3\2\2\2\u01d4\u01d0\3\2\2\2\u01d4\u01d1\3\2\2\2\u01d4\u01d2\3\2"+
		"\2\2\u01d4\u01d3\3\2\2\2\u01d5\23\3\2\2\2\u01d6\u01d8\5\u00a4S\2\u01d7"+
		"\u01d9\5\u00b0Y\2\u01d8\u01d7\3\2\2\2\u01d8\u01d9\3\2\2\2\u01d9\25\3\2"+
		"\2\2\u01da\u01db\5T+\2\u01db\27\3\2\2\2\u01dc\u01dd\5\u00c8e\2\u01dd\31"+
		"\3\2\2\2\u01de\u01df\5\u0162\u00b2\2\u01df\33\3\2\2\2\u01e0\u01e1\5\u010e"+
		"\u0088\2\u01e1\35\3\2\2\2\u01e2\u01e3\5\u00f4{\2\u01e3\37\3\2\2\2\u01e4"+
		"\u01e5\b\21\1\2\u01e5\u01eb\5\"\22\2\u01e6\u01e7\7\b\2\2\u01e7\u01e8\5"+
		" \21\2\u01e8\u01e9\7\t\2\2\u01e9\u01eb\3\2\2\2\u01ea\u01e4\3\2\2\2\u01ea"+
		"\u01e6\3\2\2\2\u01eb\u01f1\3\2\2\2\u01ec\u01ed\f\3\2\2\u01ed\u01ee\7("+
		"\2\2\u01ee\u01f0\5 \21\4\u01ef\u01ec\3\2\2\2\u01f0\u01f3\3\2\2\2\u01f1"+
		"\u01ef\3\2\2\2\u01f1\u01f2\3\2\2\2\u01f2!\3\2\2\2\u01f3\u01f1\3\2\2\2"+
		"\u01f4\u01f5\5$\23\2\u01f5\u01f6\7\3\2\2\u01f6\u01f7\5&\24\2\u01f7#\3"+
		"\2\2\2\u01f8\u01f9\5(\25\2\u01f9%\3\2\2\2\u01fa\u01fb\5(\25\2\u01fb\'"+
		"\3\2\2\2\u01fc\u01fd\5*\26\2\u01fd)\3\2\2\2\u01fe\u01ff\7\61\2\2\u01ff"+
		"+\3\2\2\2\u0200\u0201\3\2\2\2\u0201-\3\2\2\2\u0202\u0203\5<\37\2\u0203"+
		"\u0204\7\5\2\2\u0204\u0205\7\6\2\2\u0205\u0206\5\60\31\2\u0206\u0207\7"+
		"\7\2\2\u0207/\3\2\2\2\u0208\u020e\3\2\2\2\u0209\u020e\5\64\33\2\u020a"+
		"\u020e\5:\36\2\u020b\u020e\5\66\34\2\u020c\u020e\58\35\2\u020d\u0208\3"+
		"\2\2\2\u020d\u0209\3\2\2\2\u020d\u020a\3\2\2\2\u020d\u020b\3\2\2\2\u020d"+
		"\u020c\3\2\2\2\u020e\61\3\2\2\2\u020f\u0210\5v<\2\u0210\63\3\2\2\2\u0211"+
		"\u0212\5L\'\2\u0212\65\3\2\2\2\u0213\u0218\5\u00dep\2\u0214\u0215\7\4"+
		"\2\2\u0215\u0217\5\u00dep\2\u0216\u0214\3\2\2\2\u0217\u021a\3\2\2\2\u0218"+
		"\u0216\3\2\2\2\u0218\u0219\3\2\2\2\u0219\67\3\2\2\2\u021a\u0218\3\2\2"+
		"\2\u021b\u021c\5\u0102\u0082\2\u021c9\3\2\2\2\u021d\u021e\5\u016c\u00b7"+
		"\2\u021e;\3\2\2\2\u021f\u0220\t\2\2\2\u0220=\3\2\2\2\u0221\u0222\5\4\3"+
		"\2\u0222\u0223\7\3\2\2\u0223\u0224\5@!\2\u0224\u0225\7\2\2\3\u0225?\3"+
		"\2\2\2\u0226\u0227\5B\"\2\u0227A\3\2\2\2\u0228\u0229\5D#\2\u0229\u022a"+
		"\5T+\2\u022aC\3\2\2\2\u022b\u022c\5F$\2\u022cE\3\2\2\2\u022d\u022e\7+"+
		"\2\2\u022e\u022f\5H%\2\u022fG\3\2\2\2\u0230\u0233\5J&\2\u0231\u0233\5"+
		"L\'\2\u0232\u0230\3\2\2\2\u0232\u0231\3\2\2\2\u0233I\3\2\2\2\u0234\u0235"+
		"\5l\67\2\u0235K\3\2\2\2\u0236\u0237\5R*\2\u0237\u0238\7\n\2\2\u0238\u0239"+
		"\7\6\2\2\u0239\u023e\5N(\2\u023a\u023b\7\4\2\2\u023b\u023d\5N(\2\u023c"+
		"\u023a\3\2\2\2\u023d\u0240\3\2\2\2\u023e\u023c\3\2\2\2\u023e\u023f\3\2"+
		"\2\2\u023f\u0241\3\2\2\2\u0240\u023e\3\2\2\2\u0241\u0242\7\7\2\2\u0242"+
		"M\3\2\2\2\u0243\u0244\5d\63\2\u0244\u0245\7\5\2\2\u0245\u0246\5P)\2\u0246"+
		"O\3\2\2\2\u0247\u0248\5J&\2\u0248Q\3\2\2\2\u0249\u024f\7\61\2\2\u024a"+
		"\u024b\7\61\2\2\u024b\u024c\7\13\2\2\u024c\u024f\7\61\2\2\u024d\u024f"+
		"\7\62\2\2\u024e\u0249\3\2\2\2\u024e\u024a\3\2\2\2\u024e\u024d\3\2\2\2"+
		"\u024fS\3\2\2\2\u0250\u0251\7)\2\2\u0251\u0256\5V,\2\u0252\u0253\7\4\2"+
		"\2\u0253\u0255\5V,\2\u0254\u0252\3\2\2\2\u0255\u0258\3\2\2\2\u0256\u0254"+
		"\3\2\2\2\u0256\u0257\3\2\2\2\u0257U\3\2\2\2\u0258\u0256\3\2\2\2\u0259"+
		"\u025a\5X-\2\u025a\u025b\7*\2\2\u025b\u025c\5Z.\2\u025cW\3\2\2\2\u025d"+
		"\u025e\5l\67\2\u025eY\3\2\2\2\u025f\u0260\5\\/\2\u0260[\3\2\2\2\u0261"+
		"\u0262\5^\60\2\u0262\u0263\7\f\2\2\u0263\u0264\5b\62\2\u0264\u026b\7\r"+
		"\2\2\u0265\u0266\7\f\2\2\u0266\u0267\5b\62\2\u0267\u0268\7\r\2\2\u0268"+
		"\u026a\3\2\2\2\u0269\u0265\3\2\2\2\u026a\u026d\3\2\2\2\u026b\u0269\3\2"+
		"\2\2\u026b\u026c\3\2\2\2\u026c\u0281\3\2\2\2\u026d\u026b\3\2\2\2\u026e"+
		"\u026f\5`\61\2\u026f\u0270\7\f\2\2\u0270\u0271\5b\62\2\u0271\u0278\7\r"+
		"\2\2\u0272\u0273\7\f\2\2\u0273\u0274\5b\62\2\u0274\u0275\7\r\2\2\u0275"+
		"\u0277\3\2\2\2\u0276\u0272\3\2\2\2\u0277\u027a\3\2\2\2\u0278\u0276\3\2"+
		"\2\2\u0278\u0279\3\2\2\2\u0279\u0281\3\2\2\2\u027a\u0278\3\2\2\2\u027b"+
		"\u027c\7\66\2\2\u027c\u027d\7\f\2\2\u027d\u027e\5h\65\2\u027e\u027f\7"+
		"\r\2\2\u027f\u0281\3\2\2\2\u0280\u0261\3\2\2\2\u0280\u026e\3\2\2\2\u0280"+
		"\u027b\3\2\2\2\u0281]\3\2\2\2\u0282\u0283\79\2\2\u0283_\3\2\2\2\u0284"+
		"\u0285\7\61\2\2\u0285a\3\2\2\2\u0286\u0289\5d\63\2\u0287\u0289\5f\64\2"+
		"\u0288\u0286\3\2\2\2\u0288\u0287\3\2\2\2\u0289c\3\2\2\2\u028a\u028b\7"+
		"\62\2\2\u028be\3\2\2\2\u028c\u0291\7\61\2\2\u028d\u028e\7\61\2\2\u028e"+
		"\u028f\7\13\2\2\u028f\u0291\7\61\2\2\u0290\u028c\3\2\2\2\u0290\u028d\3"+
		"\2\2\2\u0291g\3\2\2\2\u0292\u0293\7\61\2\2\u0293i\3\2\2\2\u0294\u0297"+
		"\5^\60\2\u0295\u0297\5l\67\2\u0296\u0294\3\2\2\2\u0296\u0295\3\2\2\2\u0297"+
		"k\3\2\2\2\u0298\u029d\7\61\2\2\u0299\u029a\7\61\2\2\u029a\u029b\7\13\2"+
		"\2\u029b\u029d\7\61\2\2\u029c\u0298\3\2\2\2\u029c\u0299\3\2\2\2\u029d"+
		"m\3\2\2\2\u029e\u029f\5\4\3\2\u029f\u02a7\7\3\2\2\u02a0\u02a8\5p9\2\u02a1"+
		"\u02a2\7\6\2\2\u02a2\u02a3\5r:\2\u02a3\u02a4\7\5\2\2\u02a4\u02a5\5p9\2"+
		"\u02a5\u02a6\7\7\2\2\u02a6\u02a8\3\2\2\2\u02a7\u02a0\3\2\2\2\u02a7\u02a1"+
		"\3\2\2\2\u02a8o\3\2\2\2\u02a9\u02aa\5\u00c4c\2\u02aa\u02ab\5t;\2\u02ab"+
		"q\3\2\2\2\u02ac\u02ad\5|?\2\u02ads\3\2\2\2\u02ae\u02b2\7\16\2\2\u02af"+
		"\u02b3\5v<\2\u02b0\u02b3\5\u0080A\2\u02b1\u02b3\5\u0084C\2\u02b2\u02af"+
		"\3\2\2\2\u02b2\u02b0\3\2\2\2\u02b2\u02b1\3\2\2\2\u02b3u\3\2\2\2\u02b4"+
		"\u02b5\7\6\2\2\u02b5\u02ba\5x=\2\u02b6\u02b7\7\4\2\2\u02b7\u02b9\5x=\2"+
		"\u02b8\u02b6\3\2\2\2\u02b9\u02bc\3\2\2\2\u02ba\u02b8\3\2\2\2\u02ba\u02bb"+
		"\3\2\2\2\u02bb\u02bd\3\2\2\2\u02bc\u02ba\3\2\2\2\u02bd\u02be\7\7\2\2\u02be"+
		"w\3\2\2\2\u02bf\u02c0\5z>\2\u02c0\u02c1\7\5\2\2\u02c1\u02c2\5~@\2\u02c2"+
		"y\3\2\2\2\u02c3\u02c4\5|?\2\u02c4{\3\2\2\2\u02c5\u02c6\7\62\2\2\u02c6"+
		"}\3\2\2\2\u02c7\u02cc\5v<\2\u02c8\u02cc\5\u0080A\2\u02c9\u02cc\5\u0084"+
		"C\2\u02ca\u02cc\5\u0086D\2\u02cb\u02c7\3\2\2\2\u02cb\u02c8\3\2\2\2\u02cb"+
		"\u02c9\3\2\2\2\u02cb\u02ca\3\2\2\2\u02cc\177\3\2\2\2\u02cd\u02d3\5\u0098"+
		"M\2\u02ce\u02cf\5\u0082B\2\u02cf\u02d0\7\13\2\2\u02d0\u02d1\7\61\2\2\u02d1"+
		"\u02d3\3\2\2\2\u02d2\u02cd\3\2\2\2\u02d2\u02ce\3\2\2\2\u02d3\u0081\3\2"+
		"\2\2\u02d4\u02d5\7\61\2\2\u02d5\u0083\3\2\2\2\u02d6\u02d7\5\u0090I\2\u02d7"+
		"\u0085\3\2\2\2\u02d8\u02d9\5p9\2\u02d9\u0087\3\2\2\2\u02da\u02de\5\u008c"+
		"G\2\u02db\u02de\5\u008aF\2\u02dc\u02de\5\u008eH\2\u02dd\u02da\3\2\2\2"+
		"\u02dd\u02db\3\2\2\2\u02dd\u02dc\3\2\2\2\u02de\u0089\3\2\2\2\u02df\u02e5"+
		"\5\u0098M\2\u02e0\u02e1\5\u0082B\2\u02e1\u02e2\7\13\2\2\u02e2\u02e3\7"+
		"\61\2\2\u02e3\u02e5\3\2\2\2\u02e4\u02df\3\2\2\2\u02e4\u02e0\3\2\2\2\u02e5"+
		"\u008b\3\2\2\2\u02e6\u02e7\5\u0090I\2\u02e7\u008d\3\2\2\2\u02e8\u02e9"+
		"\5\u0094K\2\u02e9\u008f\3\2\2\2\u02ea\u02ed\5\u0092J\2\u02eb\u02ed\7\62"+
		"\2\2\u02ec\u02ea\3\2\2\2\u02ec\u02eb\3\2\2\2\u02ed\u0091\3\2\2\2\u02ee"+
		"\u02ef\7:\2\2\u02ef\u0093\3\2\2\2\u02f0\u02f2\5\u0096L\2\u02f1\u02f3\5"+
		"\u009aN\2\u02f2\u02f1\3\2\2\2\u02f3\u02f4\3\2\2\2\u02f4\u02f2\3\2\2\2"+
		"\u02f4\u02f5\3\2\2\2\u02f5\u0095\3\2\2\2\u02f6\u02f7\5\u0098M\2\u02f7"+
		"\u0097\3\2\2\2\u02f8\u02f9\7\61\2\2\u02f9\u0099\3\2\2\2\u02fa\u02fd\5"+
		"\u009cO\2\u02fb\u02fd\5\u009eP\2\u02fc\u02fa\3\2\2\2\u02fc\u02fb\3\2\2"+
		"\2\u02fd\u009b\3\2\2\2\u02fe\u02ff\7\13\2\2\u02ff\u0300\5\u00a0Q\2\u0300"+
		"\u009d\3\2\2\2\u0301\u0302\7\f\2\2\u0302\u0303\5\u00a2R\2\u0303\u0304"+
		"\7\r\2\2\u0304\u009f\3\2\2\2\u0305\u0306\7\61\2\2\u0306\u00a1\3\2\2\2"+
		"\u0307\u0308\5\u0092J\2\u0308\u00a3\3\2\2\2\u0309\u030a\7\17\2\2\u030a"+
		"\u030f\5\u00a6T\2\u030b\u030c\7\4\2\2\u030c\u030e\5\u00a6T\2\u030d\u030b"+
		"\3\2\2\2\u030e\u0311\3\2\2\2\u030f\u030d\3\2\2\2\u030f\u0310\3\2\2\2\u0310"+
		"\u00a5\3\2\2\2\u0311\u030f\3\2\2\2\u0312\u0313\5\u00a8U\2\u0313\u0314"+
		"\7\20\2\2\u0314\u0315\5\u00aaV\2\u0315\u00a7\3\2\2\2\u0316\u0317\5\u0098"+
		"M\2\u0317\u00a9\3\2\2\2\u0318\u0319\5\u00acW\2\u0319\u00ab\3\2\2\2\u031a"+
		"\u031b\7\21\2\2\u031b\u031e\5\u00aeX\2\u031c\u031e\5\u0094K\2\u031d\u031a"+
		"\3\2\2\2\u031d\u031c\3\2\2\2\u031e\u00ad\3\2\2\2\u031f\u0320\7\61\2\2"+
		"\u0320\u00af\3\2\2\2\u0321\u0322\7\22\2\2\u0322\u0323\5\u00b2Z\2\u0323"+
		"\u00b1\3\2\2\2\u0324\u0325\bZ\1\2\u0325\u0330\5\u00bc_\2\u0326\u0327\7"+
		"\24\2\2\u0327\u0328\5\u00b4[\2\u0328\u0329\7\25\2\2\u0329\u032a\5\u00b2"+
		"Z\4\u032a\u0330\3\2\2\2\u032b\u032c\7\b\2\2\u032c\u032d\5\u00b2Z\2\u032d"+
		"\u032e\7\t\2\2\u032e\u0330\3\2\2\2\u032f\u0324\3\2\2\2\u032f\u0326\3\2"+
		"\2\2\u032f\u032b\3\2\2\2\u0330\u0336\3\2\2\2\u0331\u0332\f\5\2\2\u0332"+
		"\u0333\7\23\2\2\u0333\u0335\5\u00b2Z\6\u0334\u0331\3\2\2\2\u0335\u0338"+
		"\3\2\2\2\u0336\u0334\3\2\2\2\u0336\u0337\3\2\2\2\u0337\u00b3\3\2\2\2\u0338"+
		"\u0336\3\2\2\2\u0339\u033e\5\u00b6\\\2\u033a\u033b\7\4\2\2\u033b\u033d"+
		"\5\u00b6\\\2\u033c\u033a\3\2\2\2\u033d\u0340\3\2\2\2\u033e\u033c\3\2\2"+
		"\2\u033e\u033f\3\2\2\2\u033f\u00b5\3\2\2\2\u0340\u033e\3\2\2\2\u0341\u0342"+
		"\5\u00b8]\2\u0342\u0343\7\20\2\2\u0343\u0344\5\u00ba^\2\u0344\u00b7\3"+
		"\2\2\2\u0345\u0346\5\u0098M\2\u0346\u00b9\3\2\2\2\u0347\u0348\5\u00ac"+
		"W\2\u0348\u00bb\3\2\2\2\u0349\u034a\5\u00be`\2\u034a\u034b\7\3\2\2\u034b"+
		"\u034c\5\u00c0a\2\u034c\u00bd\3\2\2\2\u034d\u034e\5\u00c2b\2\u034e\u00bf"+
		"\3\2\2\2\u034f\u0350\5\u00c2b\2\u0350\u00c1\3\2\2\2\u0351\u0352\5\u0088"+
		"E\2\u0352\u00c3\3\2\2\2\u0353\u0355\5\u00a4S\2\u0354\u0356\5\u00b0Y\2"+
		"\u0355\u0354\3\2\2\2\u0355\u0356\3\2\2\2\u0356\u00c5\3\2\2\2\u0357\u0358"+
		"\5\4\3\2\u0358\u0359\7\3\2\2\u0359\u035a\5\u00c8e\2\u035a\u035b\7\2\2"+
		"\3\u035b\u00c7\3\2\2\2\u035c\u035d\5\u00caf\2\u035d\u00c9\3\2\2\2\u035e"+
		"\u035f\5\u00ceh\2\u035f\u0360\5\u00ccg\2\u0360\u00cb\3\2\2\2\u0361\u0363"+
		"\5\u00d6l\2\u0362\u0364\5\u00e0q\2\u0363\u0362\3\2\2\2\u0363\u0364\3\2"+
		"\2\2\u0364\u00cd\3\2\2\2\u0365\u0366\5\u00d0i\2\u0366\u00cf\3\2\2\2\u0367"+
		"\u0368\7+\2\2\u0368\u036d\5\u00d2j\2\u0369\u036a\7\4\2\2\u036a\u036c\5"+
		"\u00d2j\2\u036b\u0369\3\2\2\2\u036c\u036f\3\2\2\2\u036d\u036b\3\2\2\2"+
		"\u036d\u036e\3\2\2\2\u036e\u00d1\3\2\2\2\u036f\u036d\3\2\2\2\u0370\u0371"+
		"\5\u00e6t\2\u0371\u0372\7-\2\2\u0372\u0373\5\u00d4k\2\u0373\u0376\3\2"+
		"\2\2\u0374\u0376\7\61\2\2\u0375\u0370\3\2\2\2\u0375\u0374\3\2\2\2\u0376"+
		"\u00d3\3\2\2\2\u0377\u0378\5\u00dep\2\u0378\u00d5\3\2\2\2\u0379\u037a"+
		"\7)\2\2\u037a\u037f\5\u00d8m\2\u037b\u037c\7\4\2\2\u037c\u037e\5\u00d8"+
		"m\2\u037d\u037b\3\2\2\2\u037e\u0381\3\2\2\2\u037f\u037d\3\2\2\2\u037f"+
		"\u0380\3\2\2\2\u0380\u00d7\3\2\2\2\u0381\u037f\3\2\2\2\u0382\u0383\5\u00da"+
		"n\2\u0383\u0384\7-\2\2\u0384\u0385\5\u00dep\2\u0385\u00d9\3\2\2\2\u0386"+
		"\u0387\5\u00dco\2\u0387\u00db\3\2\2\2\u0388\u0389\7\61\2\2\u0389\u00dd"+
		"\3\2\2\2\u038a\u038b\7\61\2\2\u038b\u00df\3\2\2\2\u038c\u038d\5\u00e2"+
		"r\2\u038d\u00e1\3\2\2\2\u038e\u038f\7\36\2\2\u038f\u0390\5\u00e4s\2\u0390"+
		"\u00e3\3\2\2\2\u0391\u0392\bs\1\2\u0392\u0399\5\u00e8u\2\u0393\u0399\5"+
		"\u00eav\2\u0394\u0395\7\b\2\2\u0395\u0396\5\u00e4s\2\u0396\u0397\7\t\2"+
		"\2\u0397\u0399\3\2\2\2\u0398\u0391\3\2\2\2\u0398\u0393\3\2\2\2\u0398\u0394"+
		"\3\2\2\2\u0399\u039f\3\2\2\2\u039a\u039b\f\4\2\2\u039b\u039c\7(\2\2\u039c"+
		"\u039e\5\u00e4s\5\u039d\u039a\3\2\2\2\u039e\u03a1\3\2\2\2\u039f\u039d"+
		"\3\2\2\2\u039f\u03a0\3\2\2\2\u03a0\u00e5\3\2\2\2\u03a1\u039f\3\2\2\2\u03a2"+
		"\u03a3\5\u00f0y\2\u03a3\u03a4\7\13\2\2\u03a4\u03a5\7\61\2\2\u03a5\u03a8"+
		"\3\2\2\2\u03a6\u03a8\7\62\2\2\u03a7\u03a2\3\2\2\2\u03a7\u03a6\3\2\2\2"+
		"\u03a8\u00e7\3\2\2\2\u03a9\u03aa\5\u00ecw\2\u03aa\u03ab\7\3\2\2\u03ab"+
		"\u03ac\5\u00eex\2\u03ac\u00e9\3\2\2\2\u03ad\u03ae\5\u00e6t\2\u03ae\u03af"+
		"\7.\2\2\u03af\u03b0\7\62\2\2\u03b0\u00eb\3\2\2\2\u03b1\u03b2\5\u00e6t"+
		"\2\u03b2\u00ed\3\2\2\2\u03b3\u03b4\5\u00e6t\2\u03b4\u00ef\3\2\2\2\u03b5"+
		"\u03b6\7\61\2\2\u03b6\u00f1\3\2\2\2\u03b7\u03b8\5\4\3\2\u03b8\u03b9\7"+
		"\3\2\2\u03b9\u03ba\5\u00f4{\2\u03ba\u03bb\7\2\2\3\u03bb\u00f3\3\2\2\2"+
		"\u03bc\u03bd\5\u00f6|\2\u03bd\u03be\7\26\2\2\u03be\u03bf\7/\2\2\u03bf"+
		"\u03c1\7\27\2\2\u03c0\u03c2\5\u00f8}\2\u03c1\u03c0\3\2\2\2\u03c1\u03c2"+
		"\3\2\2\2\u03c2\u03c3\3\2\2\2\u03c3\u03c4\7\30\2\2\u03c4\u03c5\5\u0100"+
		"\u0081\2\u03c5\u00f5\3\2\2\2\u03c6\u03c7\7\61\2\2\u03c7\u00f7\3\2\2\2"+
		"\u03c8\u03c9\5\u00fa~\2\u03c9\u03ca\7\5\2\2\u03ca\u03cb\5\u00fc\177\2"+
		"\u03cb\u00f9\3\2\2\2\u03cc\u03cd\5\u00fe\u0080\2\u03cd\u00fb\3\2\2\2\u03ce"+
		"\u03cf\5\u00fe\u0080\2\u03cf\u00fd\3\2\2\2\u03d0\u03d3\5\u0106\u0084\2"+
		"\u03d1\u03d3\5\u010a\u0086\2\u03d2\u03d0\3\2\2\2\u03d2\u03d1\3\2\2\2\u03d3"+
		"\u00ff\3\2\2\2\u03d4\u03d5\7\31\2\2\u03d5\u03da\5\u0106\u0084\2\u03d6"+
		"\u03d7\7\4\2\2\u03d7\u03d9\5\u0106\u0084\2\u03d8\u03d6\3\2\2\2\u03d9\u03dc"+
		"\3\2\2\2\u03da\u03d8\3\2\2\2\u03da\u03db\3\2\2\2\u03db\u0101\3\2\2\2\u03dc"+
		"\u03da\3\2\2\2\u03dd\u03de\7\6\2\2\u03de\u03e3\5\u0104\u0083\2\u03df\u03e0"+
		"\7\4\2\2\u03e0\u03e2\5\u0104\u0083\2\u03e1\u03df\3\2\2\2\u03e2\u03e5\3"+
		"\2\2\2\u03e3\u03e1\3\2\2\2\u03e3\u03e4\3\2\2\2\u03e4\u03e6\3\2\2\2\u03e5"+
		"\u03e3\3\2\2\2\u03e6\u03e7\7\7\2\2\u03e7\u0103\3\2\2\2\u03e8\u03e9\5\u0108"+
		"\u0085\2\u03e9\u03ea\7\5\2\2\u03ea\u03eb\5\u0106\u0084\2\u03eb\u0105\3"+
		"\2\2\2\u03ec\u03ed\7\61\2\2\u03ed\u0107\3\2\2\2\u03ee\u03ef\7\62\2\2\u03ef"+
		"\u0109\3\2\2\2\u03f0\u03f1\t\3\2\2\u03f1\u010b\3\2\2\2\u03f2\u03f3\5\4"+
		"\3\2\u03f3\u03f4\7\3\2\2\u03f4\u03f5\5\u010e\u0088\2\u03f5\u03f6\7\2\2"+
		"\3\u03f6\u010d\3\2\2\2\u03f7\u03f8\5\u0110\u0089\2\u03f8\u03f9\5\u0128"+
		"\u0095\2\u03f9\u010f\3\2\2\2\u03fa\u03fb\5\u0112\u008a\2\u03fb\u0111\3"+
		"\2\2\2\u03fc\u03fd\7+\2\2\u03fd\u0402\5\u0114\u008b\2\u03fe\u03ff\7\4"+
		"\2\2\u03ff\u0401\5\u0114\u008b\2\u0400\u03fe\3\2\2\2\u0401\u0404\3\2\2"+
		"\2\u0402\u0400\3\2\2\2\u0402\u0403\3\2\2\2\u0403\u0113\3\2\2\2\u0404\u0402"+
		"\3\2\2\2\u0405\u040d\5\u0116\u008c\2\u0406\u040d\5\u011e\u0090\2\u0407"+
		"\u040d\5\u0122\u0092\2\u0408\u0409\5\u0120\u0091\2\u0409\u040a\7-\2\2"+
		"\u040a\u040b\5\u011e\u0090\2\u040b\u040d\3\2\2\2\u040c\u0405\3\2\2\2\u040c"+
		"\u0406\3\2\2\2\u040c\u0407\3\2\2\2\u040c\u0408\3\2\2\2\u040d\u0115\3\2"+
		"\2\2\u040e\u040f\7=\2\2\u040f\u0410\7\b\2\2\u0410\u0415\5\u0118\u008d"+
		"\2\u0411\u0412\7\4\2\2\u0412\u0414\5\u0118\u008d\2\u0413\u0411\3\2\2\2"+
		"\u0414\u0417\3\2\2\2\u0415\u0413\3\2\2\2\u0415\u0416\3\2\2\2\u0416\u0418"+
		"\3\2\2\2\u0417\u0415\3\2\2\2\u0418\u0419\7\t\2\2\u0419\u0117\3\2\2\2\u041a"+
		"\u041b\5\u011a\u008e\2\u041b\u041c\7\4\2\2\u041c\u041d\5\u011c\u008f\2"+
		"\u041d\u0119\3\2\2\2\u041e\u041f\5\u015a\u00ae\2\u041f\u011b\3\2\2\2\u0420"+
		"\u0425\5\u0116\u008c\2\u0421\u0425\5\u011e\u0090\2\u0422\u0425\5\u0122"+
		"\u0092\2\u0423\u0425\5\u0124\u0093\2\u0424\u0420\3\2\2\2\u0424\u0421\3"+
		"\2\2\2\u0424\u0422\3\2\2\2\u0424\u0423\3\2\2\2\u0425\u011d\3\2\2\2\u0426"+
		"\u0427\5\u0156\u00ac\2\u0427\u011f\3\2\2\2\u0428\u0429\5\u014a\u00a6\2"+
		"\u0429\u042a\5\u0152\u00aa\2\u042a\u0432\3\2\2\2\u042b\u042c\7\b\2\2\u042c"+
		"\u042d\5\u014a\u00a6\2\u042d\u042e\5\u0152\u00aa\2\u042e\u042f\7\t\2\2"+
		"\u042f\u0430\5\u0126\u0094\2\u0430\u0432\3\2\2\2\u0431\u0428\3\2\2\2\u0431"+
		"\u042b\3\2\2\2\u0432\u0121\3\2\2\2\u0433\u0434\5\u015c\u00af\2\u0434\u0123"+
		"\3\2\2\2\u0435\u0436\5\u010e\u0088\2\u0436\u0125\3\2\2\2\u0437\u0438\7"+
		"\32\2\2\u0438\u0127\3\2\2\2\u0439\u043b\5\u012a\u0096\2\u043a\u043c\5"+
		"\u0134\u009b\2\u043b\u043a\3\2\2\2\u043b\u043c\3\2\2\2\u043c\u0129\3\2"+
		"\2\2\u043d\u043e\7)\2\2\u043e\u0443\5\u012c\u0097\2\u043f\u0440\7\4\2"+
		"\2\u0440\u0442\5\u012c\u0097\2\u0441\u043f\3\2\2\2\u0442\u0445\3\2\2\2"+
		"\u0443\u0441\3\2\2\2\u0443\u0444\3\2\2\2\u0444\u012b\3\2\2\2\u0445\u0443"+
		"\3\2\2\2\u0446\u0447\5\u012e\u0098\2\u0447\u0448\7-\2\2\u0448\u0449\5"+
		"\u0132\u009a\2\u0449\u012d\3\2\2\2\u044a\u044b\5\u0130\u0099\2\u044b\u012f"+
		"\3\2\2\2\u044c\u0453\5\u0158\u00ad\2\u044d\u044e\7>\2\2\u044e\u044f\7"+
		"\b\2\2\u044f\u0450\5\u0148\u00a5\2\u0450\u0451\7\t\2\2\u0451\u0453\3\2"+
		"\2\2\u0452\u044c\3\2\2\2\u0452\u044d\3\2\2\2\u0453\u0131\3\2\2\2\u0454"+
		"\u0455\5\u0156\u00ac\2\u0455\u0133\3\2\2\2\u0456\u0457\7\36\2\2\u0457"+
		"\u0458\5\u0136\u009c\2\u0458\u0135\3\2\2\2\u0459\u045a\b\u009c\1\2\u045a"+
		"\u0460\5\u0138\u009d\2\u045b\u045c\7\b\2\2\u045c\u045d\5\u0136\u009c\2"+
		"\u045d\u045e\7\t\2\2\u045e\u0460\3\2\2\2\u045f\u0459\3\2\2\2\u045f\u045b"+
		"\3\2\2\2\u0460\u0466\3\2\2\2\u0461\u0462\f\4\2\2\u0462\u0463\7(\2\2\u0463"+
		"\u0465\5\u0136\u009c\5\u0464\u0461\3\2\2\2\u0465\u0468\3\2\2\2\u0466\u0464"+
		"\3\2\2\2\u0466\u0467\3\2\2\2\u0467\u0137\3\2\2\2\u0468\u0466\3\2\2\2\u0469"+
		"\u046a\5\u013a\u009e\2\u046a\u046b\7\3\2\2\u046b\u046c\5\u013c\u009f\2"+
		"\u046c\u0139\3\2\2\2\u046d\u046e\5\u013e\u00a0\2\u046e\u013b\3\2\2\2\u046f"+
		"\u0470\5\u013e\u00a0\2\u0470\u013d\3\2\2\2\u0471\u0472\5\u0140\u00a1\2"+
		"\u0472\u013f\3\2\2\2\u0473\u0477\5\u0144\u00a3\2\u0474\u0477\5\u0142\u00a2"+
		"\2\u0475\u0477\5\u0146\u00a4\2\u0476\u0473\3\2\2\2\u0476\u0474\3\2\2\2"+
		"\u0476\u0475\3\2\2\2\u0477\u0141\3\2\2\2\u0478\u0479\5\u0156\u00ac\2\u0479"+
		"\u0143\3\2\2\2\u047a\u047b\5\u015c\u00af\2\u047b\u0145\3\2\2\2\u047c\u047d"+
		"\5\u0148\u00a5\2\u047d\u0147\3\2\2\2\u047e\u0480\5\u014a\u00a6\2\u047f"+
		"\u0481\5\u014c\u00a7\2\u0480\u047f\3\2\2\2\u0481\u0482\3\2\2\2\u0482\u0483"+
		"\3\2\2\2\u0482\u0480\3\2\2\2\u0483\u0149\3\2\2\2\u0484\u0487\5\u0156\u00ac"+
		"\2\u0485\u0487\5\u0154\u00ab\2\u0486\u0484\3\2\2\2\u0486\u0485\3\2\2\2"+
		"\u0487\u014b\3\2\2\2\u0488\u0489\5\u014e\u00a8\2\u0489\u014d\3\2\2\2\u048a"+
		"\u048b\7\n\2\2\u048b\u048c\5\u015a\u00ae\2\u048c\u014f\3\2\2\2\u048d\u048e"+
		"\5\u0152\u00aa\2\u048e\u0151\3\2\2\2\u048f\u0490\7\33\2\2\u0490\u0494"+
		"\5\u015a\u00ae\2\u0491\u0492\7\n\2\2\u0492\u0494\5\u015a\u00ae\2\u0493"+
		"\u048f\3\2\2\2\u0493\u0491\3\2\2\2\u0494\u0153\3\2\2\2\u0495\u0496\5\u0156"+
		"\u00ac\2\u0496\u0497\7\13\2\2\u0497\u0498\5\u015e\u00b0\2\u0498\u0155"+
		"\3\2\2\2\u0499\u049a\7\61\2\2\u049a\u0157\3\2\2\2\u049b\u049c\7\61\2\2"+
		"\u049c\u049d\7\13\2\2\u049d\u04a0\7\61\2\2\u049e\u04a0\7\61\2\2\u049f"+
		"\u049b\3\2\2\2\u049f\u049e\3\2\2\2\u04a0\u0159\3\2\2\2\u04a1\u04a2\t\4"+
		"\2\2\u04a2\u015b\3\2\2\2\u04a3\u04a4\t\3\2\2\u04a4\u015d\3\2\2\2\u04a5"+
		"\u04a6\7\61\2\2\u04a6\u015f\3\2\2\2\u04a7\u04a8\5\4\3\2\u04a8\u04a9\7"+
		"\3\2\2\u04a9\u04aa\5\u0162\u00b2\2\u04aa\u04ab\7\2\2\3\u04ab\u04b5\3\2"+
		"\2\2\u04ac\u04ad\7\6\2\2\u04ad\u04ae\5\u0164\u00b3\2\u04ae\u04af\7\5\2"+
		"\2\u04af\u04b0\7\b\2\2\u04b0\u04b1\5\u0162\u00b2\2\u04b1\u04b2\7\t\2\2"+
		"\u04b2\u04b3\7\7\2\2\u04b3\u04b5\3\2\2\2\u04b4\u04a7\3\2\2\2\u04b4\u04ac"+
		"\3\2\2\2\u04b5\u0161\3\2\2\2\u04b6\u04b7\7\60\2\2\u04b7\u04b8\7\61\2\2"+
		"\u04b8\u04b9\7\34\2\2\u04b9\u04ba\5\u0166\u00b4\2\u04ba\u04bb\5\u017c"+
		"\u00bf\2\u04bb\u04c0\3\2\2\2\u04bc\u04bd\5\u0166\u00b4\2\u04bd\u04be\5"+
		"\u017c\u00bf\2\u04be\u04c0\3\2\2\2\u04bf\u04b6\3\2\2\2\u04bf\u04bc\3\2"+
		"\2\2\u04c0\u0163\3\2\2\2\u04c1\u04c2\5\u01a6\u00d4\2\u04c2\u0165\3\2\2"+
		"\2\u04c3\u04c4\5\u0168\u00b5\2\u04c4\u0167\3\2\2\2\u04c5\u04c6\7+\2\2"+
		"\u04c6\u04c7\7,\2\2\u04c7\u04cc\5\u016a\u00b6\2\u04c8\u04c9\7\4\2\2\u04c9"+
		"\u04cb\5\u016a\u00b6\2\u04ca\u04c8\3\2\2\2\u04cb\u04ce\3\2\2\2\u04cc\u04ca"+
		"\3\2\2\2\u04cc\u04cd\3\2\2\2\u04cd\u0169\3\2\2\2\u04ce\u04cc\3\2\2\2\u04cf"+
		"\u04d7\5\u016e\u00b8\2\u04d0\u04d7\5\u0176\u00bc\2\u04d1\u04d7\5\u0178"+
		"\u00bd\2\u04d2\u04d3\5\u019c\u00cf\2\u04d3\u04d4\7-\2\2\u04d4\u04d5\5"+
		"\u0176\u00bc\2\u04d5\u04d7\3\2\2\2\u04d6\u04cf\3\2\2\2\u04d6\u04d0\3\2"+
		"\2\2\u04d6\u04d1\3\2\2\2\u04d6\u04d2\3\2\2\2\u04d7\u016b\3\2\2\2\u04d8"+
		"\u04d9\7\6\2\2\u04d9\u04de\5\u0170\u00b9\2\u04da\u04db\7\4\2\2\u04db\u04dd"+
		"\5\u0170\u00b9\2\u04dc\u04da\3\2\2\2\u04dd\u04e0\3\2\2\2\u04de\u04dc\3"+
		"\2\2\2\u04de\u04df\3\2\2\2\u04df\u04e1\3\2\2\2\u04e0\u04de\3\2\2\2\u04e1"+
		"\u04e2\7\7\2\2\u04e2\u016d\3\2\2\2\u04e3\u04e4\7\6\2\2\u04e4\u04e9\5\u0170"+
		"\u00b9\2\u04e5\u04e6\7\4\2\2\u04e6\u04e8\5\u0170\u00b9\2\u04e7\u04e5\3"+
		"\2\2\2\u04e8\u04eb\3\2\2\2\u04e9\u04e7\3\2\2\2\u04e9\u04ea\3\2\2\2\u04ea"+
		"\u04ec\3\2\2\2\u04eb\u04e9\3\2\2\2\u04ec\u04ed\7\7\2\2\u04ed\u016f\3\2"+
		"\2\2\u04ee\u04ef\5\u0172\u00ba\2\u04ef\u04f0\7\5\2\2\u04f0\u04f1\5\u0174"+
		"\u00bb\2\u04f1\u0171\3\2\2\2\u04f2\u04f3\5\u01a6\u00d4\2\u04f3\u0173\3"+
		"\2\2\2\u04f4\u04fd\5\u016e\u00b8\2\u04f5\u04fd\5\u0176\u00bc\2\u04f6\u04fd"+
		"\5\u0178\u00bd\2\u04f7\u04fd\5\u019c\u00cf\2\u04f8\u04f9\7\b\2\2\u04f9"+
		"\u04fa\5\u0162\u00b2\2\u04fa\u04fb\7\t\2\2\u04fb\u04fd\3\2\2\2\u04fc\u04f4"+
		"\3\2\2\2\u04fc\u04f5\3\2\2\2\u04fc\u04f6\3\2\2\2\u04fc\u04f7\3\2\2\2\u04fc"+
		"\u04f8\3\2\2\2\u04fd\u0175\3\2\2\2\u04fe\u04ff\5\u01a4\u00d3\2\u04ff\u0177"+
		"\3\2\2\2\u0500\u0501\5\u01a8\u00d5\2\u0501\u0179\3\2\2\2\u0502\u0503\5"+
		"\u0162\u00b2\2\u0503\u017b\3\2\2\2\u0504\u0506\5\u017e\u00c0\2\u0505\u0507"+
		"\5\u0188\u00c5\2\u0506\u0505\3\2\2\2\u0506\u0507\3\2\2\2\u0507\u017d\3"+
		"\2\2\2\u0508\u0509\7)\2\2\u0509\u050e\5\u0180\u00c1\2\u050a\u050b\7\4"+
		"\2\2\u050b\u050d\5\u0180\u00c1\2\u050c\u050a\3\2\2\2\u050d\u0510\3\2\2"+
		"\2\u050e\u050c\3\2\2\2\u050e\u050f\3\2\2\2\u050f\u017f\3\2\2\2\u0510\u050e"+
		"\3\2\2\2\u0511\u0512\5\u0182\u00c2\2\u0512\u0513\7-\2\2\u0513\u0514\5"+
		"\u0186\u00c4\2\u0514\u0181\3\2\2\2\u0515\u0516\5\u0184\u00c3\2\u0516\u0183"+
		"\3\2\2\2\u0517\u051a\5\u00aeX\2\u0518\u051a\5\u019c\u00cf\2\u0519\u0517"+
		"\3\2\2\2\u0519\u0518\3\2\2\2\u051a\u0185\3\2\2\2\u051b\u051c\5\u01a4\u00d3"+
		"\2\u051c\u0187\3\2\2\2\u051d\u051e\7\36\2\2\u051e\u051f\5\u018a\u00c6"+
		"\2\u051f\u0189\3\2\2\2\u0520\u0521\b\u00c6\1\2\u0521\u0527\5\u018c\u00c7"+
		"\2\u0522\u0523\7\b\2\2\u0523\u0524\5\u018a\u00c6\2\u0524\u0525\7\t\2\2"+
		"\u0525\u0527\3\2\2\2\u0526\u0520\3\2\2\2\u0526\u0522\3\2\2\2\u0527\u052d"+
		"\3\2\2\2\u0528\u0529\f\4\2\2\u0529\u052a\7(\2\2\u052a\u052c\5\u018a\u00c6"+
		"\5\u052b\u0528\3\2\2\2\u052c\u052f\3\2\2\2\u052d\u052b\3\2\2\2\u052d\u052e"+
		"\3\2\2\2\u052e\u018b\3\2\2\2\u052f\u052d\3\2\2\2\u0530\u0531\5\u018e\u00c8"+
		"\2\u0531\u0532\7\3\2\2\u0532\u0533\5\u0190\u00c9\2\u0533\u018d\3\2\2\2"+
		"\u0534\u0535\5\u0192\u00ca\2\u0535\u018f\3\2\2\2\u0536\u0537\5\u0192\u00ca"+
		"\2\u0537\u0191\3\2\2\2\u0538\u0539\5\u0194\u00cb\2\u0539\u0193\3\2\2\2"+
		"\u053a\u053e\5\u0198\u00cd\2\u053b\u053e\5\u0196\u00cc\2\u053c\u053e\5"+
		"\u019a\u00ce\2\u053d\u053a\3\2\2\2\u053d\u053b\3\2\2\2\u053d\u053c\3\2"+
		"\2\2\u053e\u0195\3\2\2\2\u053f\u0540\5\u01a4\u00d3\2\u0540\u0197\3\2\2"+
		"\2\u0541\u0542\5\u01a8\u00d5\2\u0542\u0199\3\2\2\2\u0543\u0544\5\u019c"+
		"\u00cf\2\u0544\u019b\3\2\2\2\u0545\u0547\5\u019e\u00d0\2\u0546\u0548\5"+
		"\u01a0\u00d1\2\u0547\u0546\3\2\2\2\u0548\u0549\3\2\2\2\u0549\u054a\3\2"+
		"\2\2\u0549\u0547\3\2\2\2\u054a\u019d\3\2\2\2\u054b\u054c\5\u01a4\u00d3"+
		"\2\u054c\u019f\3\2\2\2\u054d\u054e\5\u01a2\u00d2\2\u054e\u01a1\3\2\2\2"+
		"\u054f\u0550\7\13\2\2\u0550\u0551\5\u00a0Q\2\u0551\u01a3\3\2\2\2\u0552"+
		"\u0553\7\61\2\2\u0553\u01a5\3\2\2\2\u0554\u0555\7\62\2\2\u0555\u01a7\3"+
		"\2\2\2\u0556\u0557\t\3\2\2\u0557\u01a9\3\2\2\2M\u01b5\u01bf\u01d4\u01d8"+
		"\u01ea\u01f1\u020d\u0218\u0232\u023e\u024e\u0256\u026b\u0278\u0280\u0288"+
		"\u0290\u0296\u029c\u02a7\u02b2\u02ba\u02cb\u02d2\u02dd\u02e4\u02ec\u02f4"+
		"\u02fc\u030f\u031d\u032f\u0336\u033e\u0355\u0363\u036d\u0375\u037f\u0398"+
		"\u039f\u03a7\u03c1\u03d2\u03da\u03e3\u0402\u040c\u0415\u0424\u0431\u043b"+
		"\u0443\u0452\u045f\u0466\u0476\u0482\u0486\u0493\u049f\u04b4\u04bf\u04cc"+
		"\u04d6\u04de\u04e9\u04fc\u0506\u050e\u0519\u0526\u052d\u053d\u0549";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}