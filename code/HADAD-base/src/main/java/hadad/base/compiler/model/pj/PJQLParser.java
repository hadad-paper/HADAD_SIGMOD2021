// Generated from PJQL.g4 by ANTLR 4.7.2

package hadad.base.compiler.model.pj;

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
		RULE_pjSelectStatement = 4, RULE_pjSelectItem = 5, RULE_pjRecordConstruct = 6, 
		RULE_pjFieldBinding = 7, RULE_pjRecordConstructFieldName = 8, RULE_pjFieldValue = 9, 
		RULE_pjSelectVar = 10, RULE_pjSelectConstant = 11, RULE_pjSelectQuery = 12, 
		RULE_pjFromWhereClause = 13, RULE_pjFromClause = 14, RULE_pjBinding = 15, 
		RULE_pjFromClauseBindingSource = 16, RULE_pjSource = 17, RULE_pjFromClauseBindingVar = 18, 
		RULE_pjWhereClause = 19, RULE_pjCondition = 20, RULE_pjWhereCondEquality = 21, 
		RULE_pjWhereCondEqualityLeftTerm = 22, RULE_pjWhereCondEqualityRightTerm = 23, 
		RULE_pjCTerm = 24, RULE_pjTerm = 25, RULE_pjTermVar = 26, RULE_pjTermConstant = 27, 
		RULE_pjTermPath = 28, RULE_pjPath = 29, RULE_pjPathVar = 30, RULE_pjStep = 31, 
		RULE_pjObjStep = 32, RULE_pjPathAttr = 33, RULE_pjVariable = 34, RULE_pjRelation = 35, 
		RULE_pjKey = 36, RULE_pjConstant = 37, RULE_attribute = 38;
	private static String[] makeRuleNames() {
		return new String[] {
			"pjqlQuery", "viewName", "pjQuery", "pjSelectClause", "pjSelectStatement", 
			"pjSelectItem", "pjRecordConstruct", "pjFieldBinding", "pjRecordConstructFieldName", 
			"pjFieldValue", "pjSelectVar", "pjSelectConstant", "pjSelectQuery", "pjFromWhereClause", 
			"pjFromClause", "pjBinding", "pjFromClauseBindingSource", "pjSource", 
			"pjFromClauseBindingVar", "pjWhereClause", "pjCondition", "pjWhereCondEquality", 
			"pjWhereCondEqualityLeftTerm", "pjWhereCondEqualityRightTerm", "pjCTerm", 
			"pjTerm", "pjTermVar", "pjTermConstant", "pjTermPath", "pjPath", "pjPathVar", 
			"pjStep", "pjObjStep", "pjPathAttr", "pjVariable", "pjRelation", "pjKey", 
			"pjConstant", "attribute"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'('", "','", "')'", "'->'", "'.'"
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
			setState(78);
			viewName();
			setState(79);
			match(T__0);
			setState(80);
			pjQuery();
			setState(81);
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
			setState(83);
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
			setState(85);
			pjFromWhereClause();
			setState(86);
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
			setState(88);
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
		public PjSelectItemContext pjSelectItem() {
			return getRuleContext(PjSelectItemContext.class,0);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(SELECT);
			setState(91);
			pjSelectItem();
			}
		}
		catch (RecognitionException re) {
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
			setState(96);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case JSONBUILDOBJECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				pjRecordConstruct();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				pjSelectVar();
				}
				break;
			case STRING:
			case INTEGER:
				enterOuterAlt(_localctx, 3);
				{
				setState(95);
				pjSelectConstant();
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
		enterRule(_localctx, 12, RULE_pjRecordConstruct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
			match(JSONBUILDOBJECT);
			setState(99);
			match(T__1);
			setState(100);
			pjFieldBinding();
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(101);
				match(T__2);
				setState(102);
				pjFieldBinding();
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(108);
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
		enterRule(_localctx, 14, RULE_pjFieldBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			pjRecordConstructFieldName();
			setState(111);
			match(T__2);
			setState(112);
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
		enterRule(_localctx, 16, RULE_pjRecordConstructFieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
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
		enterRule(_localctx, 18, RULE_pjFieldValue);
		try {
			setState(120);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case JSONBUILDOBJECT:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				pjRecordConstruct();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(117);
				pjSelectVar();
				}
				break;
			case STRING:
			case INTEGER:
				enterOuterAlt(_localctx, 3);
				{
				setState(118);
				pjSelectConstant();
				}
				break;
			case FROM:
				enterOuterAlt(_localctx, 4);
				{
				setState(119);
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
		enterRule(_localctx, 20, RULE_pjSelectVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
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
		enterRule(_localctx, 22, RULE_pjSelectConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
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
		enterRule(_localctx, 24, RULE_pjSelectQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
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
		enterRule(_localctx, 26, RULE_pjFromWhereClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			pjFromClause();
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(129);
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
		enterRule(_localctx, 28, RULE_pjFromClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(FROM);
			setState(133);
			pjBinding();
			setState(138);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__2) {
				{
				{
				setState(134);
				match(T__2);
				setState(135);
				pjBinding();
				}
				}
				setState(140);
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
		enterRule(_localctx, 30, RULE_pjBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			pjFromClauseBindingSource();
			setState(142);
			match(AS);
			setState(143);
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
		enterRule(_localctx, 32, RULE_pjFromClauseBindingSource);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
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
		enterRule(_localctx, 34, RULE_pjSource);
		try {
			setState(153);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				pjRelation();
				}
				break;
			case JSONARRAYELEMENTS:
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				match(JSONARRAYELEMENTS);
				setState(149);
				match(T__1);
				setState(150);
				pjPath();
				setState(151);
				match(T__3);
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
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).enterPjFromClauseBindingVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PJQLListener ) ((PJQLListener)listener).exitPjFromClauseBindingVar(this);
		}
	}

	public final PjFromClauseBindingVarContext pjFromClauseBindingVar() throws RecognitionException {
		PjFromClauseBindingVarContext _localctx = new PjFromClauseBindingVarContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_pjFromClauseBindingVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
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
		enterRule(_localctx, 38, RULE_pjWhereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(WHERE);
			setState(158);
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
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_pjCondition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
			case STRING:
			case INTEGER:
				{
				setState(161);
				pjWhereCondEquality();
				}
				break;
			case T__1:
				{
				setState(162);
				match(T__1);
				setState(163);
				pjCondition(0);
				setState(164);
				match(T__3);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(173);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PjConditionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_pjCondition);
					setState(168);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(169);
					match(AND);
					setState(170);
					pjCondition(3);
					}
					} 
				}
				setState(175);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		enterRule(_localctx, 42, RULE_pjWhereCondEquality);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			pjWhereCondEqualityLeftTerm();
			setState(177);
			match(T__0);
			setState(178);
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
		enterRule(_localctx, 44, RULE_pjWhereCondEqualityLeftTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
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
		enterRule(_localctx, 46, RULE_pjWhereCondEqualityRightTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
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
		enterRule(_localctx, 48, RULE_pjCTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
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
		enterRule(_localctx, 50, RULE_pjTerm);
		try {
			setState(189);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(186);
				pjTermConstant();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(187);
				pjTermVar();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(188);
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
		enterRule(_localctx, 52, RULE_pjTermVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(191);
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
		enterRule(_localctx, 54, RULE_pjTermConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
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
		enterRule(_localctx, 56, RULE_pjTermPath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
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
		enterRule(_localctx, 58, RULE_pjPath);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			pjPathVar();
			setState(199); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(198);
					pjStep();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(201); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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
		enterRule(_localctx, 60, RULE_pjPathVar);
		try {
			setState(205);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				pjVariable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(204);
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
		enterRule(_localctx, 62, RULE_pjStep);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(207);
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
		enterRule(_localctx, 64, RULE_pjObjStep);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209);
			match(T__4);
			setState(210);
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
		enterRule(_localctx, 66, RULE_pjPathAttr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			pjVariable();
			setState(213);
			match(T__5);
			setState(214);
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
		enterRule(_localctx, 68, RULE_pjVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(216);
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
		enterRule(_localctx, 70, RULE_pjRelation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
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
		enterRule(_localctx, 72, RULE_pjKey);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
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
		enterRule(_localctx, 74, RULE_pjConstant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
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
		enterRule(_localctx, 76, RULE_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
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
		case 20:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\31\u00e5\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\2\3\2\3\2"+
		"\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\5\7c\n\7\3\b\3\b"+
		"\3\b\3\b\3\b\7\bj\n\b\f\b\16\bm\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\5\13{\n\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\5\17"+
		"\u0085\n\17\3\20\3\20\3\20\3\20\7\20\u008b\n\20\f\20\16\20\u008e\13\20"+
		"\3\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u009c"+
		"\n\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u00a9"+
		"\n\26\3\26\3\26\3\26\7\26\u00ae\n\26\f\26\16\26\u00b1\13\26\3\27\3\27"+
		"\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33\5\33\u00c0\n\33"+
		"\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\6\37\u00ca\n\37\r\37\16\37\u00cb"+
		"\3 \3 \5 \u00d0\n \3!\3!\3\"\3\"\3\"\3#\3#\3#\3#\3$\3$\3%\3%\3&\3&\3\'"+
		"\3\'\3(\3(\3(\3\u00cb\3*)\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&"+
		"(*,.\60\62\64\668:<>@BDFHJLN\2\4\3\2\26\27\3\2\27\30\2\u00cc\2P\3\2\2"+
		"\2\4U\3\2\2\2\6W\3\2\2\2\bZ\3\2\2\2\n\\\3\2\2\2\fb\3\2\2\2\16d\3\2\2\2"+
		"\20p\3\2\2\2\22t\3\2\2\2\24z\3\2\2\2\26|\3\2\2\2\30~\3\2\2\2\32\u0080"+
		"\3\2\2\2\34\u0082\3\2\2\2\36\u0086\3\2\2\2 \u008f\3\2\2\2\"\u0093\3\2"+
		"\2\2$\u009b\3\2\2\2&\u009d\3\2\2\2(\u009f\3\2\2\2*\u00a8\3\2\2\2,\u00b2"+
		"\3\2\2\2.\u00b6\3\2\2\2\60\u00b8\3\2\2\2\62\u00ba\3\2\2\2\64\u00bf\3\2"+
		"\2\2\66\u00c1\3\2\2\28\u00c3\3\2\2\2:\u00c5\3\2\2\2<\u00c7\3\2\2\2>\u00cf"+
		"\3\2\2\2@\u00d1\3\2\2\2B\u00d3\3\2\2\2D\u00d6\3\2\2\2F\u00da\3\2\2\2H"+
		"\u00dc\3\2\2\2J\u00de\3\2\2\2L\u00e0\3\2\2\2N\u00e2\3\2\2\2PQ\5\4\3\2"+
		"QR\7\3\2\2RS\5\6\4\2ST\7\2\2\3T\3\3\2\2\2UV\7\26\2\2V\5\3\2\2\2WX\5\34"+
		"\17\2XY\5\b\5\2Y\7\3\2\2\2Z[\5\n\6\2[\t\3\2\2\2\\]\7\n\2\2]^\5\f\7\2^"+
		"\13\3\2\2\2_c\5\16\b\2`c\5\26\f\2ac\5\30\r\2b_\3\2\2\2b`\3\2\2\2ba\3\2"+
		"\2\2c\r\3\2\2\2de\7\22\2\2ef\7\4\2\2fk\5\20\t\2gh\7\5\2\2hj\5\20\t\2i"+
		"g\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2\2ln\3\2\2\2mk\3\2\2\2no\7\6\2\2"+
		"o\17\3\2\2\2pq\5\22\n\2qr\7\5\2\2rs\5\24\13\2s\21\3\2\2\2tu\5J&\2u\23"+
		"\3\2\2\2v{\5\16\b\2w{\5\26\f\2x{\5\30\r\2y{\5\32\16\2zv\3\2\2\2zw\3\2"+
		"\2\2zx\3\2\2\2zy\3\2\2\2{\25\3\2\2\2|}\5F$\2}\27\3\2\2\2~\177\5L\'\2\177"+
		"\31\3\2\2\2\u0080\u0081\5\6\4\2\u0081\33\3\2\2\2\u0082\u0084\5\36\20\2"+
		"\u0083\u0085\5(\25\2\u0084\u0083\3\2\2\2\u0084\u0085\3\2\2\2\u0085\35"+
		"\3\2\2\2\u0086\u0087\7\t\2\2\u0087\u008c\5 \21\2\u0088\u0089\7\5\2\2\u0089"+
		"\u008b\5 \21\2\u008a\u0088\3\2\2\2\u008b\u008e\3\2\2\2\u008c\u008a\3\2"+
		"\2\2\u008c\u008d\3\2\2\2\u008d\37\3\2\2\2\u008e\u008c\3\2\2\2\u008f\u0090"+
		"\5\"\22\2\u0090\u0091\7\24\2\2\u0091\u0092\5&\24\2\u0092!\3\2\2\2\u0093"+
		"\u0094\5$\23\2\u0094#\3\2\2\2\u0095\u009c\5H%\2\u0096\u0097\7\23\2\2\u0097"+
		"\u0098\7\4\2\2\u0098\u0099\5<\37\2\u0099\u009a\7\6\2\2\u009a\u009c\3\2"+
		"\2\2\u009b\u0095\3\2\2\2\u009b\u0096\3\2\2\2\u009c%\3\2\2\2\u009d\u009e"+
		"\5F$\2\u009e\'\3\2\2\2\u009f\u00a0\7\13\2\2\u00a0\u00a1\5*\26\2\u00a1"+
		")\3\2\2\2\u00a2\u00a3\b\26\1\2\u00a3\u00a9\5,\27\2\u00a4\u00a5\7\4\2\2"+
		"\u00a5\u00a6\5*\26\2\u00a6\u00a7\7\6\2\2\u00a7\u00a9\3\2\2\2\u00a8\u00a2"+
		"\3\2\2\2\u00a8\u00a4\3\2\2\2\u00a9\u00af\3\2\2\2\u00aa\u00ab\f\4\2\2\u00ab"+
		"\u00ac\7\25\2\2\u00ac\u00ae\5*\26\5\u00ad\u00aa\3\2\2\2\u00ae\u00b1\3"+
		"\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0+\3\2\2\2\u00b1\u00af"+
		"\3\2\2\2\u00b2\u00b3\5.\30\2\u00b3\u00b4\7\3\2\2\u00b4\u00b5\5\60\31\2"+
		"\u00b5-\3\2\2\2\u00b6\u00b7\5\62\32\2\u00b7/\3\2\2\2\u00b8\u00b9\5\62"+
		"\32\2\u00b9\61\3\2\2\2\u00ba\u00bb\5\64\33\2\u00bb\63\3\2\2\2\u00bc\u00c0"+
		"\58\35\2\u00bd\u00c0\5\66\34\2\u00be\u00c0\5:\36\2\u00bf\u00bc\3\2\2\2"+
		"\u00bf\u00bd\3\2\2\2\u00bf\u00be\3\2\2\2\u00c0\65\3\2\2\2\u00c1\u00c2"+
		"\5F$\2\u00c2\67\3\2\2\2\u00c3\u00c4\5L\'\2\u00c49\3\2\2\2\u00c5\u00c6"+
		"\5<\37\2\u00c6;\3\2\2\2\u00c7\u00c9\5> \2\u00c8\u00ca\5@!\2\u00c9\u00c8"+
		"\3\2\2\2\u00ca\u00cb\3\2\2\2\u00cb\u00cc\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc"+
		"=\3\2\2\2\u00cd\u00d0\5F$\2\u00ce\u00d0\5D#\2\u00cf\u00cd\3\2\2\2\u00cf"+
		"\u00ce\3\2\2\2\u00d0?\3\2\2\2\u00d1\u00d2\5B\"\2\u00d2A\3\2\2\2\u00d3"+
		"\u00d4\7\7\2\2\u00d4\u00d5\5J&\2\u00d5C\3\2\2\2\u00d6\u00d7\5F$\2\u00d7"+
		"\u00d8\7\b\2\2\u00d8\u00d9\5N(\2\u00d9E\3\2\2\2\u00da\u00db\7\26\2\2\u00db"+
		"G\3\2\2\2\u00dc\u00dd\7\26\2\2\u00ddI\3\2\2\2\u00de\u00df\t\2\2\2\u00df"+
		"K\3\2\2\2\u00e0\u00e1\t\3\2\2\u00e1M\3\2\2\2\u00e2\u00e3\7\26\2\2\u00e3"+
		"O\3\2\2\2\rbkz\u0084\u008c\u009b\u00a8\u00af\u00bf\u00cb\u00cf";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}