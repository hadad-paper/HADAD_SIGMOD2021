// Generated from PJQL.g4 by ANTLR 4.7.2

package hadad.base.compiler.model.pj.full;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class PJQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, FROM=7, SELECT=8, WHERE=9, 
		IN=10, MAP=11, KEYS=12, LIST=13, SET=14, MAIN=15, JSONBUILDOBJECT=16, 
		JSONARRAYELEMENTS=17, AS=18, AND=19, NAME=20, STRING=21, INTEGER=22, WHITESPACE=23;
	public static final int
		RULE_pjqlQuery = 0, RULE_viewName = 1, RULE_pjQuery = 2, RULE_pjSelectClause = 3, 
		RULE_pjSelectStatement = 4, RULE_pjSelectItem = 5, RULE_pjPathSelect = 6, 
		RULE_pjRecordConstruct = 7, RULE_pjFieldBinding = 8, RULE_pjRecordConstructFieldName = 9, 
		RULE_pjFieldValue = 10, RULE_pjSelectVar = 11, RULE_pjSelectConstant = 12, 
		RULE_pjSelectQuery = 13, RULE_pjFromWhereClause = 14, RULE_pjFromClause = 15, 
		RULE_pjBinding = 16, RULE_pjFromClauseBindingSource = 17, RULE_pjSource = 18, 
		RULE_pjFromClauseBindingVar = 19, RULE_pjWhereClause = 20, RULE_pjCondition = 21, 
		RULE_pjWhereCondEquality = 22, RULE_pjWhereCondEqualityLeftTerm = 23, 
		RULE_pjWhereCondEqualityRightTerm = 24, RULE_pjCTerm = 25, RULE_pjTerm = 26, 
		RULE_pjTermVar = 27, RULE_pjTermConstant = 28, RULE_pjTermPath = 29, RULE_pjPath = 30, 
		RULE_pjPathVar = 31, RULE_pjStep = 32, RULE_pjObjStep = 33, RULE_pjPathAttr = 34, 
		RULE_pjVariable = 35, RULE_pjRelation = 36, RULE_pjKey = 37, RULE_pjConstant = 38, 
		RULE_attribute = 39;
	private static String[] makeRuleNames() {
		return new String[] {
			"pjqlQuery", "viewName", "pjQuery", "pjSelectClause", "pjSelectStatement", 
			"pjSelectItem", "pjPathSelect", "pjRecordConstruct", "pjFieldBinding", 
			"pjRecordConstructFieldName", "pjFieldValue", "pjSelectVar", "pjSelectConstant", 
			"pjSelectQuery", "pjFromWhereClause", "pjFromClause", "pjBinding", "pjFromClauseBindingSource", 
			"pjSource", "pjFromClauseBindingVar", "pjWhereClause", "pjCondition", 
			"pjWhereCondEquality", "pjWhereCondEqualityLeftTerm", "pjWhereCondEqualityRightTerm", 
			"pjCTerm", "pjTerm", "pjTermVar", "pjTermConstant", "pjTermPath", "pjPath", 
			"pjPathVar", "pjStep", "pjObjStep", "pjPathAttr", "pjVariable", "pjRelation", 
			"pjKey", "pjConstant", "attribute"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "','", "'('", "')'", "'->'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "FROM", "SELECT", "WHERE", 
			"IN", "MAP", "KEYS", "LIST", "SET", "MAIN", "JSONBUILDOBJECT", "JSONARRAYELEMENTS", 
			"AS", "AND", "NAME", "STRING", "INTEGER", "WHITESPACE"
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
	public String getGrammarFileName() { return "PJQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PJQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class PjqlQueryContext extends ParserRuleContext {
		public ViewNameContext viewName() {
			return getRuleContext(ViewNameContext.class,0);
		}
		public PjQueryContext pjQuery() {
			return getRuleContext(PjQueryContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PJQLParser.EOF, 0); }
		public PjqlQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjqlQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjqlQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjqlQuery(this);
		}
	}

	public final PjqlQueryContext pjqlQuery() throws RecognitionException {
		PjqlQueryContext _localctx = new PjqlQueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_pjqlQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			viewName();
			setState(81);
			match(T__0);
			setState(82);
			pjQuery();
			setState(83);
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
		public TerminalNode NAME() { return getToken(PJQLParser.NAME, 0); }
		public ViewNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_viewName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterViewName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitViewName(this);
		}
	}

	public final ViewNameContext viewName() throws RecognitionException {
		ViewNameContext _localctx = new ViewNameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_viewName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
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

	public static class PjQueryContext extends ParserRuleContext {
		public PjFromWhereClauseContext pjFromWhereClause() {
			return getRuleContext(PjFromWhereClauseContext.class,0);
		}
		public PjSelectClauseContext pjSelectClause() {
			return getRuleContext(PjSelectClauseContext.class,0);
		}
		public PjQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjQuery(this);
		}
	}

	public final PjQueryContext pjQuery() throws RecognitionException {
		PjQueryContext _localctx = new PjQueryContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_pjQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			pjFromWhereClause();
			setState(88);
			pjSelectClause();
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjSelectClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjSelectClause(this);
		}
	}

	public final PjSelectClauseContext pjSelectClause() throws RecognitionException {
		PjSelectClauseContext _localctx = new PjSelectClauseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_pjSelectClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
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
		public TerminalNode SELECT() { return getToken(PJQLParser.SELECT, 0); }
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
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjSelectStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjSelectStatement(this);
		}
	}

	public final PjSelectStatementContext pjSelectStatement() throws RecognitionException {
		PjSelectStatementContext _localctx = new PjSelectStatementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_pjSelectStatement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			match(SELECT);
			setState(93);
			pjSelectItem();
			setState(98);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(94);
					match(T__1);
					setState(95);
					pjSelectItem();
					}
					} 
				}
				setState(100);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,0,_ctx);
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
		public PjRecordConstructContext pjRecordConstruct() {
			return getRuleContext(PjRecordConstructContext.class,0);
		}
		public PjSelectVarContext pjSelectVar() {
			return getRuleContext(PjSelectVarContext.class,0);
		}
		public PjSelectConstantContext pjSelectConstant() {
			return getRuleContext(PjSelectConstantContext.class,0);
		}
		public PjPathSelectContext pjPathSelect() {
			return getRuleContext(PjPathSelectContext.class,0);
		}
		public PjSelectItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjSelectItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjSelectItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjSelectItem(this);
		}
	}

	public final PjSelectItemContext pjSelectItem() throws RecognitionException {
		PjSelectItemContext _localctx = new PjSelectItemContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_pjSelectItem);
		try {
			setState(105);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				pjRecordConstruct();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				pjSelectVar();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(103);
				pjSelectConstant();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(104);
				pjPathSelect();
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

	public static class PjPathSelectContext extends ParserRuleContext {
		public PjPathContext pjPath() {
			return getRuleContext(PjPathContext.class,0);
		}
		public TerminalNode AS() { return getToken(PJQLParser.AS, 0); }
		public PjVariableContext pjVariable() {
			return getRuleContext(PjVariableContext.class,0);
		}
		public PjPathSelectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjPathSelect; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjPathSelect(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjPathSelect(this);
		}
	}

	public final PjPathSelectContext pjPathSelect() throws RecognitionException {
		PjPathSelectContext _localctx = new PjPathSelectContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_pjPathSelect);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			pjPath();
			setState(108);
			match(AS);
			setState(109);
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

	public static class PjRecordConstructContext extends ParserRuleContext {
		public TerminalNode JSONBUILDOBJECT() { return getToken(PJQLParser.JSONBUILDOBJECT, 0); }
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
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjRecordConstruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjRecordConstruct(this);
		}
	}

	public final PjRecordConstructContext pjRecordConstruct() throws RecognitionException {
		PjRecordConstructContext _localctx = new PjRecordConstructContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_pjRecordConstruct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(JSONBUILDOBJECT);
			setState(112);
			match(T__2);
			setState(113);
			pjFieldBinding();
			setState(118);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(114);
				match(T__1);
				setState(115);
				pjFieldBinding();
				}
				}
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(121);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjFieldBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjFieldBinding(this);
		}
	}

	public final PjFieldBindingContext pjFieldBinding() throws RecognitionException {
		PjFieldBindingContext _localctx = new PjFieldBindingContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_pjFieldBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			pjRecordConstructFieldName();
			setState(124);
			match(T__1);
			setState(125);
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
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjRecordConstructFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjRecordConstructFieldName(this);
		}
	}

	public final PjRecordConstructFieldNameContext pjRecordConstructFieldName() throws RecognitionException {
		PjRecordConstructFieldNameContext _localctx = new PjRecordConstructFieldNameContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_pjRecordConstructFieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
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
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjFieldValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjFieldValue(this);
		}
	}

	public final PjFieldValueContext pjFieldValue() throws RecognitionException {
		PjFieldValueContext _localctx = new PjFieldValueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_pjFieldValue);
		try {
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case JSONBUILDOBJECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				pjRecordConstruct();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				pjSelectVar();
				}
				break;
			case STRING:
			case INTEGER:
				enterOuterAlt(_localctx, 3);
				{
				setState(131);
				pjSelectConstant();
				}
				break;
			case FROM:
				enterOuterAlt(_localctx, 4);
				{
				setState(132);
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
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjSelectVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjSelectVar(this);
		}
	}

	public final PjSelectVarContext pjSelectVar() throws RecognitionException {
		PjSelectVarContext _localctx = new PjSelectVarContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_pjSelectVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
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
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjSelectConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjSelectConstant(this);
		}
	}

	public final PjSelectConstantContext pjSelectConstant() throws RecognitionException {
		PjSelectConstantContext _localctx = new PjSelectConstantContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_pjSelectConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
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
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjSelectQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjSelectQuery(this);
		}
	}

	public final PjSelectQueryContext pjSelectQuery() throws RecognitionException {
		PjSelectQueryContext _localctx = new PjSelectQueryContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_pjSelectQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
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
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjFromWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjFromWhereClause(this);
		}
	}

	public final PjFromWhereClauseContext pjFromWhereClause() throws RecognitionException {
		PjFromWhereClauseContext _localctx = new PjFromWhereClauseContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_pjFromWhereClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			pjFromClause();
			setState(143);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(142);
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
		public TerminalNode FROM() { return getToken(PJQLParser.FROM, 0); }
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
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjFromClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjFromClause(this);
		}
	}

	public final PjFromClauseContext pjFromClause() throws RecognitionException {
		PjFromClauseContext _localctx = new PjFromClauseContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_pjFromClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(FROM);
			setState(146);
			pjBinding();
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(147);
				match(T__1);
				setState(148);
				pjBinding();
				}
				}
				setState(153);
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

	public static class PjBindingContext extends ParserRuleContext {
		public PjFromClauseBindingSourceContext pjFromClauseBindingSource() {
			return getRuleContext(PjFromClauseBindingSourceContext.class,0);
		}
		public TerminalNode AS() { return getToken(PJQLParser.AS, 0); }
		public PjFromClauseBindingVarContext pjFromClauseBindingVar() {
			return getRuleContext(PjFromClauseBindingVarContext.class,0);
		}
		public PjBindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjBinding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjBinding(this);
		}
	}

	public final PjBindingContext pjBinding() throws RecognitionException {
		PjBindingContext _localctx = new PjBindingContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_pjBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			pjFromClauseBindingSource();
			setState(155);
			match(AS);
			setState(156);
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
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjFromClauseBindingSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjFromClauseBindingSource(this);
		}
	}

	public final PjFromClauseBindingSourceContext pjFromClauseBindingSource() throws RecognitionException {
		PjFromClauseBindingSourceContext _localctx = new PjFromClauseBindingSourceContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_pjFromClauseBindingSource);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
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
		public TerminalNode JSONARRAYELEMENTS() { return getToken(PJQLParser.JSONARRAYELEMENTS, 0); }
		public PjPathContext pjPath() {
			return getRuleContext(PjPathContext.class,0);
		}
		public PjSourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjSource; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjSource(this);
		}
	}

	public final PjSourceContext pjSource() throws RecognitionException {
		PjSourceContext _localctx = new PjSourceContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_pjSource);
		try {
			setState(167);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				pjRelation();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				match(JSONARRAYELEMENTS);
				setState(162);
				match(T__2);
				setState(163);
				pjPath();
				setState(164);
				match(T__3);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(166);
				pjPath();
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
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjFromClauseBindingVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjFromClauseBindingVar(this);
		}
	}

	public final PjFromClauseBindingVarContext pjFromClauseBindingVar() throws RecognitionException {
		PjFromClauseBindingVarContext _localctx = new PjFromClauseBindingVarContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_pjFromClauseBindingVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
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
		public TerminalNode WHERE() { return getToken(PJQLParser.WHERE, 0); }
		public PjConditionContext pjCondition() {
			return getRuleContext(PjConditionContext.class,0);
		}
		public PjWhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjWhereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjWhereClause(this);
		}
	}

	public final PjWhereClauseContext pjWhereClause() throws RecognitionException {
		PjWhereClauseContext _localctx = new PjWhereClauseContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_pjWhereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(WHERE);
			setState(172);
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
		public TerminalNode AND() { return getToken(PJQLParser.AND, 0); }
		public PjConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjCondition(this);
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
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_pjCondition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
			case STRING:
			case INTEGER:
				{
				setState(175);
				pjWhereCondEquality();
				}
				break;
			case T__2:
				{
				setState(176);
				match(T__2);
				setState(177);
				pjCondition(0);
				setState(178);
				match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(187);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PjConditionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_pjCondition);
					setState(182);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(183);
					match(AND);
					setState(184);
					pjCondition(3);
					}
					} 
				}
				setState(189);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjWhereCondEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjWhereCondEquality(this);
		}
	}

	public final PjWhereCondEqualityContext pjWhereCondEquality() throws RecognitionException {
		PjWhereCondEqualityContext _localctx = new PjWhereCondEqualityContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_pjWhereCondEquality);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			pjWhereCondEqualityLeftTerm();
			setState(191);
			match(T__0);
			setState(192);
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
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjWhereCondEqualityLeftTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjWhereCondEqualityLeftTerm(this);
		}
	}

	public final PjWhereCondEqualityLeftTermContext pjWhereCondEqualityLeftTerm() throws RecognitionException {
		PjWhereCondEqualityLeftTermContext _localctx = new PjWhereCondEqualityLeftTermContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_pjWhereCondEqualityLeftTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
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
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjWhereCondEqualityRightTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjWhereCondEqualityRightTerm(this);
		}
	}

	public final PjWhereCondEqualityRightTermContext pjWhereCondEqualityRightTerm() throws RecognitionException {
		PjWhereCondEqualityRightTermContext _localctx = new PjWhereCondEqualityRightTermContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_pjWhereCondEqualityRightTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
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
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjCTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjCTerm(this);
		}
	}

	public final PjCTermContext pjCTerm() throws RecognitionException {
		PjCTermContext _localctx = new PjCTermContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_pjCTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
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
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjTerm(this);
		}
	}

	public final PjTermContext pjTerm() throws RecognitionException {
		PjTermContext _localctx = new PjTermContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_pjTerm);
		try {
			setState(203);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(200);
				pjTermConstant();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				pjTermVar();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(202);
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
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjTermVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjTermVar(this);
		}
	}

	public final PjTermVarContext pjTermVar() throws RecognitionException {
		PjTermVarContext _localctx = new PjTermVarContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_pjTermVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
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
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjTermConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjTermConstant(this);
		}
	}

	public final PjTermConstantContext pjTermConstant() throws RecognitionException {
		PjTermConstantContext _localctx = new PjTermConstantContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_pjTermConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
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
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjTermPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjTermPath(this);
		}
	}

	public final PjTermPathContext pjTermPath() throws RecognitionException {
		PjTermPathContext _localctx = new PjTermPathContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_pjTermPath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
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
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjPath(this);
		}
	}

	public final PjPathContext pjPath() throws RecognitionException {
		PjPathContext _localctx = new PjPathContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_pjPath);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(211);
			pjPathVar();
			setState(213); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(212);
					pjStep();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(215); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
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
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjPathVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjPathVar(this);
		}
	}

	public final PjPathVarContext pjPathVar() throws RecognitionException {
		PjPathVarContext _localctx = new PjPathVarContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_pjPathVar);
		try {
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(217);
				pjVariable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
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
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjStep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjStep(this);
		}
	}

	public final PjStepContext pjStep() throws RecognitionException {
		PjStepContext _localctx = new PjStepContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_pjStep);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
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
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjObjStep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjObjStep(this);
		}
	}

	public final PjObjStepContext pjObjStep() throws RecognitionException {
		PjObjStepContext _localctx = new PjObjStepContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_pjObjStep);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(T__4);
			setState(224);
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
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjPathAttr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjPathAttr(this);
		}
	}

	public final PjPathAttrContext pjPathAttr() throws RecognitionException {
		PjPathAttrContext _localctx = new PjPathAttrContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_pjPathAttr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(226);
			pjVariable();
			setState(227);
			match(T__5);
			setState(228);
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
		public TerminalNode NAME() { return getToken(PJQLParser.NAME, 0); }
		public PjVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjVariable(this);
		}
	}

	public final PjVariableContext pjVariable() throws RecognitionException {
		PjVariableContext _localctx = new PjVariableContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_pjVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
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
		public TerminalNode NAME() { return getToken(PJQLParser.NAME, 0); }
		public PjRelationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjRelation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjRelation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjRelation(this);
		}
	}

	public final PjRelationContext pjRelation() throws RecognitionException {
		PjRelationContext _localctx = new PjRelationContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_pjRelation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
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

	public static class PjKeyContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(PJQLParser.STRING, 0); }
		public TerminalNode NAME() { return getToken(PJQLParser.NAME, 0); }
		public PjKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjKey(this);
		}
	}

	public final PjKeyContext pjKey() throws RecognitionException {
		PjKeyContext _localctx = new PjKeyContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_pjKey);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
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
		public TerminalNode INTEGER() { return getToken(PJQLParser.INTEGER, 0); }
		public TerminalNode STRING() { return getToken(PJQLParser.STRING, 0); }
		public PjConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pjConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjConstant(this);
		}
	}

	public final PjConstantContext pjConstant() throws RecognitionException {
		PjConstantContext _localctx = new PjConstantContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_pjConstant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
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
		public TerminalNode NAME() { return getToken(PJQLParser.NAME, 0); }
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitAttribute(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
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
		case 21:
			return pjCondition_sempred((PjConditionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean pjCondition_sempred(PjConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\31\u00f3\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\2\3"+
		"\2\3\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\7\6c\n\6\f\6\16\6f"+
		"\13\6\3\7\3\7\3\7\3\7\5\7l\n\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\7\t"+
		"w\n\t\f\t\16\tz\13\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\5\f\u0088\n\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\5\20\u0092\n\20\3"+
		"\21\3\21\3\21\3\21\7\21\u0098\n\21\f\21\16\21\u009b\13\21\3\22\3\22\3"+
		"\22\3\22\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00aa\n\24"+
		"\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\5\27\u00b7\n\27"+
		"\3\27\3\27\3\27\7\27\u00bc\n\27\f\27\16\27\u00bf\13\27\3\30\3\30\3\30"+
		"\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\5\34\u00ce\n\34\3\35"+
		"\3\35\3\36\3\36\3\37\3\37\3 \3 \6 \u00d8\n \r \16 \u00d9\3!\3!\5!\u00de"+
		"\n!\3\"\3\"\3#\3#\3#\3$\3$\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3)\3"+
		"\u00d9\3,*\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66"+
		"8:<>@BDFHJLNP\2\4\3\2\26\27\3\2\27\30\2\u00dc\2R\3\2\2\2\4W\3\2\2\2\6"+
		"Y\3\2\2\2\b\\\3\2\2\2\n^\3\2\2\2\fk\3\2\2\2\16m\3\2\2\2\20q\3\2\2\2\22"+
		"}\3\2\2\2\24\u0081\3\2\2\2\26\u0087\3\2\2\2\30\u0089\3\2\2\2\32\u008b"+
		"\3\2\2\2\34\u008d\3\2\2\2\36\u008f\3\2\2\2 \u0093\3\2\2\2\"\u009c\3\2"+
		"\2\2$\u00a0\3\2\2\2&\u00a9\3\2\2\2(\u00ab\3\2\2\2*\u00ad\3\2\2\2,\u00b6"+
		"\3\2\2\2.\u00c0\3\2\2\2\60\u00c4\3\2\2\2\62\u00c6\3\2\2\2\64\u00c8\3\2"+
		"\2\2\66\u00cd\3\2\2\28\u00cf\3\2\2\2:\u00d1\3\2\2\2<\u00d3\3\2\2\2>\u00d5"+
		"\3\2\2\2@\u00dd\3\2\2\2B\u00df\3\2\2\2D\u00e1\3\2\2\2F\u00e4\3\2\2\2H"+
		"\u00e8\3\2\2\2J\u00ea\3\2\2\2L\u00ec\3\2\2\2N\u00ee\3\2\2\2P\u00f0\3\2"+
		"\2\2RS\5\4\3\2ST\7\3\2\2TU\5\6\4\2UV\7\2\2\3V\3\3\2\2\2WX\7\26\2\2X\5"+
		"\3\2\2\2YZ\5\36\20\2Z[\5\b\5\2[\7\3\2\2\2\\]\5\n\6\2]\t\3\2\2\2^_\7\n"+
		"\2\2_d\5\f\7\2`a\7\4\2\2ac\5\f\7\2b`\3\2\2\2cf\3\2\2\2db\3\2\2\2de\3\2"+
		"\2\2e\13\3\2\2\2fd\3\2\2\2gl\5\20\t\2hl\5\30\r\2il\5\32\16\2jl\5\16\b"+
		"\2kg\3\2\2\2kh\3\2\2\2ki\3\2\2\2kj\3\2\2\2l\r\3\2\2\2mn\5> \2no\7\24\2"+
		"\2op\5H%\2p\17\3\2\2\2qr\7\22\2\2rs\7\5\2\2sx\5\22\n\2tu\7\4\2\2uw\5\22"+
		"\n\2vt\3\2\2\2wz\3\2\2\2xv\3\2\2\2xy\3\2\2\2y{\3\2\2\2zx\3\2\2\2{|\7\6"+
		"\2\2|\21\3\2\2\2}~\5\24\13\2~\177\7\4\2\2\177\u0080\5\26\f\2\u0080\23"+
		"\3\2\2\2\u0081\u0082\5L\'\2\u0082\25\3\2\2\2\u0083\u0088\5\20\t\2\u0084"+
		"\u0088\5\30\r\2\u0085\u0088\5\32\16\2\u0086\u0088\5\34\17\2\u0087\u0083"+
		"\3\2\2\2\u0087\u0084\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0086\3\2\2\2\u0088"+
		"\27\3\2\2\2\u0089\u008a\5H%\2\u008a\31\3\2\2\2\u008b\u008c\5N(\2\u008c"+
		"\33\3\2\2\2\u008d\u008e\5\6\4\2\u008e\35\3\2\2\2\u008f\u0091\5 \21\2\u0090"+
		"\u0092\5*\26\2\u0091\u0090\3\2\2\2\u0091\u0092\3\2\2\2\u0092\37\3\2\2"+
		"\2\u0093\u0094\7\t\2\2\u0094\u0099\5\"\22\2\u0095\u0096\7\4\2\2\u0096"+
		"\u0098\5\"\22\2\u0097\u0095\3\2\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3"+
		"\2\2\2\u0099\u009a\3\2\2\2\u009a!\3\2\2\2\u009b\u0099\3\2\2\2\u009c\u009d"+
		"\5$\23\2\u009d\u009e\7\24\2\2\u009e\u009f\5(\25\2\u009f#\3\2\2\2\u00a0"+
		"\u00a1\5&\24\2\u00a1%\3\2\2\2\u00a2\u00aa\5J&\2\u00a3\u00a4\7\23\2\2\u00a4"+
		"\u00a5\7\5\2\2\u00a5\u00a6\5> \2\u00a6\u00a7\7\6\2\2\u00a7\u00aa\3\2\2"+
		"\2\u00a8\u00aa\5> \2\u00a9\u00a2\3\2\2\2\u00a9\u00a3\3\2\2\2\u00a9\u00a8"+
		"\3\2\2\2\u00aa\'\3\2\2\2\u00ab\u00ac\5H%\2\u00ac)\3\2\2\2\u00ad\u00ae"+
		"\7\13\2\2\u00ae\u00af\5,\27\2\u00af+\3\2\2\2\u00b0\u00b1\b\27\1\2\u00b1"+
		"\u00b7\5.\30\2\u00b2\u00b3\7\5\2\2\u00b3\u00b4\5,\27\2\u00b4\u00b5\7\6"+
		"\2\2\u00b5\u00b7\3\2\2\2\u00b6\u00b0\3\2\2\2\u00b6\u00b2\3\2\2\2\u00b7"+
		"\u00bd\3\2\2\2\u00b8\u00b9\f\4\2\2\u00b9\u00ba\7\25\2\2\u00ba\u00bc\5"+
		",\27\5\u00bb\u00b8\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd"+
		"\u00be\3\2\2\2\u00be-\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00c1\5\60\31"+
		"\2\u00c1\u00c2\7\3\2\2\u00c2\u00c3\5\62\32\2\u00c3/\3\2\2\2\u00c4\u00c5"+
		"\5\64\33\2\u00c5\61\3\2\2\2\u00c6\u00c7\5\64\33\2\u00c7\63\3\2\2\2\u00c8"+
		"\u00c9\5\66\34\2\u00c9\65\3\2\2\2\u00ca\u00ce\5:\36\2\u00cb\u00ce\58\35"+
		"\2\u00cc\u00ce\5<\37\2\u00cd\u00ca\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00cc"+
		"\3\2\2\2\u00ce\67\3\2\2\2\u00cf\u00d0\5H%\2\u00d09\3\2\2\2\u00d1\u00d2"+
		"\5N(\2\u00d2;\3\2\2\2\u00d3\u00d4\5> \2\u00d4=\3\2\2\2\u00d5\u00d7\5@"+
		"!\2\u00d6\u00d8\5B\"\2\u00d7\u00d6\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00da"+
		"\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da?\3\2\2\2\u00db\u00de\5H%\2\u00dc\u00de"+
		"\5F$\2\u00dd\u00db\3\2\2\2\u00dd\u00dc\3\2\2\2\u00deA\3\2\2\2\u00df\u00e0"+
		"\5D#\2\u00e0C\3\2\2\2\u00e1\u00e2\7\7\2\2\u00e2\u00e3\5L\'\2\u00e3E\3"+
		"\2\2\2\u00e4\u00e5\5H%\2\u00e5\u00e6\7\b\2\2\u00e6\u00e7\5P)\2\u00e7G"+
		"\3\2\2\2\u00e8\u00e9\7\26\2\2\u00e9I\3\2\2\2\u00ea\u00eb\7\26\2\2\u00eb"+
		"K\3\2\2\2\u00ec\u00ed\t\2\2\2\u00edM\3\2\2\2\u00ee\u00ef\t\3\2\2\u00ef"+
		"O\3\2\2\2\u00f0\u00f1\7\26\2\2\u00f1Q\3\2\2\2\16dkx\u0087\u0091\u0099"+
		"\u00a9\u00b6\u00bd\u00cd\u00d9\u00dd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}