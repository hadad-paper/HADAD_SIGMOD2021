// Generated from SPPJQL.g4 by ANTLR 4.7.2

package hadad.base.compiler.model.sppj;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SPPJQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, FROM=9, 
		SELECT=10, WHERE=11, IN=12, MAP=13, KEYS=14, LIST=15, SET=16, MAIN=17, 
		JSONBUILDOBJECT=18, JSONARRAYELEMENTS=19, AS=20, AND=21, NAME=22, STRING=23, 
		INTEGER=24, WHITESPACE=25;
	public static final int
		RULE_sppjqlQuery = 0, RULE_viewName = 1, RULE_sppjQuery = 2, RULE_sppjRootFieldName = 3, 
		RULE_sppjSelectClause = 4, RULE_sppjSelectStatement = 5, RULE_sppjSelectItem = 6, 
		RULE_sppjRecordConstruct = 7, RULE_sppjFieldBinding = 8, RULE_sppjRecordConstructFieldName = 9, 
		RULE_sppjFieldValue = 10, RULE_sppjSelectVar = 11, RULE_sppjSelectConstant = 12, 
		RULE_sppjSelectQuery = 13, RULE_sppjFromWhereClause = 14, RULE_sppjFromClause = 15, 
		RULE_sppjBinding = 16, RULE_sppjFromClauseBindingSource = 17, RULE_sppjSource = 18, 
		RULE_sppjFromClauseBindingVar = 19, RULE_sppjWhereClause = 20, RULE_sppjCondition = 21, 
		RULE_sppjWhereCondEquality = 22, RULE_sppjWhereCondEqualityLeftTerm = 23, 
		RULE_sppjWhereCondEqualityRightTerm = 24, RULE_sppjCTerm = 25, RULE_sppjTerm = 26, 
		RULE_sppjTermVar = 27, RULE_sppjTermConstant = 28, RULE_sppjTermPath = 29, 
		RULE_sppjPath = 30, RULE_sppjPathVar = 31, RULE_sppjStep = 32, RULE_sppjObjStep = 33, 
		RULE_sppjVariable = 34, RULE_dataSetName = 35, RULE_key = 36, RULE_sppjFieldName = 37, 
		RULE_sppjConstant = 38;
	private static String[] makeRuleNames() {
		return new String[] {
			"sppjqlQuery", "viewName", "sppjQuery", "sppjRootFieldName", "sppjSelectClause", 
			"sppjSelectStatement", "sppjSelectItem", "sppjRecordConstruct", "sppjFieldBinding", 
			"sppjRecordConstructFieldName", "sppjFieldValue", "sppjSelectVar", "sppjSelectConstant", 
			"sppjSelectQuery", "sppjFromWhereClause", "sppjFromClause", "sppjBinding", 
			"sppjFromClauseBindingSource", "sppjSource", "sppjFromClauseBindingVar", 
			"sppjWhereClause", "sppjCondition", "sppjWhereCondEquality", "sppjWhereCondEqualityLeftTerm", 
			"sppjWhereCondEqualityRightTerm", "sppjCTerm", "sppjTerm", "sppjTermVar", 
			"sppjTermConstant", "sppjTermPath", "sppjPath", "sppjPathVar", "sppjStep", 
			"sppjObjStep", "sppjVariable", "dataSetName", "key", "sppjFieldName", 
			"sppjConstant"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'{'", "':'", "'}'", "','", "'('", "')'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "FROM", "SELECT", 
			"WHERE", "IN", "MAP", "KEYS", "LIST", "SET", "MAIN", "JSONBUILDOBJECT", 
			"JSONARRAYELEMENTS", "AS", "AND", "NAME", "STRING", "INTEGER", "WHITESPACE"
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
	public String getGrammarFileName() { return "SPPJQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SPPJQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class SppjqlQueryContext extends ParserRuleContext {
		public ViewNameContext viewName() {
			return getRuleContext(ViewNameContext.class,0);
		}
		public SppjQueryContext sppjQuery() {
			return getRuleContext(SppjQueryContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SPPJQLParser.EOF, 0); }
		public SppjRootFieldNameContext sppjRootFieldName() {
			return getRuleContext(SppjRootFieldNameContext.class,0);
		}
		public SppjqlQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjqlQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjqlQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjqlQuery(this);
		}
	}

	public final SppjqlQueryContext sppjqlQuery() throws RecognitionException {
		SppjqlQueryContext _localctx = new SppjqlQueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sppjqlQuery);
		try {
			setState(89);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(78);
				viewName();
				setState(79);
				match(T__0);
				setState(80);
				sppjQuery();
				setState(81);
				match(EOF);
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(83);
				match(T__1);
				setState(84);
				sppjRootFieldName();
				setState(85);
				match(T__2);
				setState(86);
				sppjQuery();
				setState(87);
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

	public static class ViewNameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(SPPJQLParser.NAME, 0); }
		public ViewNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_viewName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterViewName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitViewName(this);
		}
	}

	public final ViewNameContext viewName() throws RecognitionException {
		ViewNameContext _localctx = new ViewNameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_viewName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
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

	public static class SppjQueryContext extends ParserRuleContext {
		public SppjFromWhereClauseContext sppjFromWhereClause() {
			return getRuleContext(SppjFromWhereClauseContext.class,0);
		}
		public SppjSelectClauseContext sppjSelectClause() {
			return getRuleContext(SppjSelectClauseContext.class,0);
		}
		public SppjQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjQuery(this);
		}
	}

	public final SppjQueryContext sppjQuery() throws RecognitionException {
		SppjQueryContext _localctx = new SppjQueryContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sppjQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			sppjFromWhereClause();
			setState(94);
			sppjSelectClause();
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjRootFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjRootFieldName(this);
		}
	}

	public final SppjRootFieldNameContext sppjRootFieldName() throws RecognitionException {
		SppjRootFieldNameContext _localctx = new SppjRootFieldNameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sppjRootFieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
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
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjSelectClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjSelectClause(this);
		}
	}

	public final SppjSelectClauseContext sppjSelectClause() throws RecognitionException {
		SppjSelectClauseContext _localctx = new SppjSelectClauseContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_sppjSelectClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98);
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
		public TerminalNode SELECT() { return getToken(SPPJQLParser.SELECT, 0); }
		public SppjSelectItemContext sppjSelectItem() {
			return getRuleContext(SppjSelectItemContext.class,0);
		}
		public SppjSelectStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjSelectStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjSelectStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjSelectStatement(this);
		}
	}

	public final SppjSelectStatementContext sppjSelectStatement() throws RecognitionException {
		SppjSelectStatementContext _localctx = new SppjSelectStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_sppjSelectStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(SELECT);
			setState(101);
			sppjSelectItem();
			}
		}
		catch (RecognitionException re) {
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
		public SppjRecordConstructContext sppjRecordConstruct() {
			return getRuleContext(SppjRecordConstructContext.class,0);
		}
		public SppjSelectVarContext sppjSelectVar() {
			return getRuleContext(SppjSelectVarContext.class,0);
		}
		public SppjSelectConstantContext sppjSelectConstant() {
			return getRuleContext(SppjSelectConstantContext.class,0);
		}
		public SppjSelectItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjSelectItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjSelectItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjSelectItem(this);
		}
	}

	public final SppjSelectItemContext sppjSelectItem() throws RecognitionException {
		SppjSelectItemContext _localctx = new SppjSelectItemContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sppjSelectItem);
		try {
			setState(106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				sppjRecordConstruct();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(104);
				sppjSelectVar();
				}
				break;
			case STRING:
			case INTEGER:
				enterOuterAlt(_localctx, 3);
				{
				setState(105);
				sppjSelectConstant();
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
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjRecordConstruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjRecordConstruct(this);
		}
	}

	public final SppjRecordConstructContext sppjRecordConstruct() throws RecognitionException {
		SppjRecordConstructContext _localctx = new SppjRecordConstructContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_sppjRecordConstruct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(T__1);
			setState(109);
			sppjFieldBinding();
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(110);
				match(T__4);
				setState(111);
				sppjFieldBinding();
				}
				}
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(117);
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
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjFieldBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjFieldBinding(this);
		}
	}

	public final SppjFieldBindingContext sppjFieldBinding() throws RecognitionException {
		SppjFieldBindingContext _localctx = new SppjFieldBindingContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_sppjFieldBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			sppjRecordConstructFieldName();
			setState(120);
			match(T__2);
			setState(121);
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
		public KeyContext key() {
			return getRuleContext(KeyContext.class,0);
		}
		public SppjRecordConstructFieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjRecordConstructFieldName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjRecordConstructFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjRecordConstructFieldName(this);
		}
	}

	public final SppjRecordConstructFieldNameContext sppjRecordConstructFieldName() throws RecognitionException {
		SppjRecordConstructFieldNameContext _localctx = new SppjRecordConstructFieldNameContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_sppjRecordConstructFieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
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
		public SppjSelectQueryContext sppjSelectQuery() {
			return getRuleContext(SppjSelectQueryContext.class,0);
		}
		public SppjFieldValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjFieldValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjFieldValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjFieldValue(this);
		}
	}

	public final SppjFieldValueContext sppjFieldValue() throws RecognitionException {
		SppjFieldValueContext _localctx = new SppjFieldValueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_sppjFieldValue);
		try {
			setState(129);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__1:
				enterOuterAlt(_localctx, 1);
				{
				setState(125);
				sppjRecordConstruct();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				sppjSelectVar();
				}
				break;
			case STRING:
			case INTEGER:
				enterOuterAlt(_localctx, 3);
				{
				setState(127);
				sppjSelectConstant();
				}
				break;
			case FROM:
				enterOuterAlt(_localctx, 4);
				{
				setState(128);
				sppjSelectQuery();
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
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjSelectVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjSelectVar(this);
		}
	}

	public final SppjSelectVarContext sppjSelectVar() throws RecognitionException {
		SppjSelectVarContext _localctx = new SppjSelectVarContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_sppjSelectVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
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
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjSelectConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjSelectConstant(this);
		}
	}

	public final SppjSelectConstantContext sppjSelectConstant() throws RecognitionException {
		SppjSelectConstantContext _localctx = new SppjSelectConstantContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_sppjSelectConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
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
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjSelectQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjSelectQuery(this);
		}
	}

	public final SppjSelectQueryContext sppjSelectQuery() throws RecognitionException {
		SppjSelectQueryContext _localctx = new SppjSelectQueryContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_sppjSelectQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
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
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjFromWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjFromWhereClause(this);
		}
	}

	public final SppjFromWhereClauseContext sppjFromWhereClause() throws RecognitionException {
		SppjFromWhereClauseContext _localctx = new SppjFromWhereClauseContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_sppjFromWhereClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			sppjFromClause();
			setState(139);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(138);
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
		public TerminalNode FROM() { return getToken(SPPJQLParser.FROM, 0); }
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
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjFromClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjFromClause(this);
		}
	}

	public final SppjFromClauseContext sppjFromClause() throws RecognitionException {
		SppjFromClauseContext _localctx = new SppjFromClauseContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_sppjFromClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			match(FROM);
			setState(142);
			sppjBinding();
			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(143);
				match(T__4);
				setState(144);
				sppjBinding();
				}
				}
				setState(149);
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
		public TerminalNode AS() { return getToken(SPPJQLParser.AS, 0); }
		public SppjFromClauseBindingVarContext sppjFromClauseBindingVar() {
			return getRuleContext(SppjFromClauseBindingVarContext.class,0);
		}
		public SppjBindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjBinding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjBinding(this);
		}
	}

	public final SppjBindingContext sppjBinding() throws RecognitionException {
		SppjBindingContext _localctx = new SppjBindingContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_sppjBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			sppjFromClauseBindingSource();
			setState(151);
			match(AS);
			setState(152);
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
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjFromClauseBindingSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjFromClauseBindingSource(this);
		}
	}

	public final SppjFromClauseBindingSourceContext sppjFromClauseBindingSource() throws RecognitionException {
		SppjFromClauseBindingSourceContext _localctx = new SppjFromClauseBindingSourceContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_sppjFromClauseBindingSource);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
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
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjSource(this);
		}
	}

	public final SppjSourceContext sppjSource() throws RecognitionException {
		SppjSourceContext _localctx = new SppjSourceContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_sppjSource);
		try {
			setState(158);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				dataSetName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
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
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjFromClauseBindingVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjFromClauseBindingVar(this);
		}
	}

	public final SppjFromClauseBindingVarContext sppjFromClauseBindingVar() throws RecognitionException {
		SppjFromClauseBindingVarContext _localctx = new SppjFromClauseBindingVarContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_sppjFromClauseBindingVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
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
		public TerminalNode WHERE() { return getToken(SPPJQLParser.WHERE, 0); }
		public SppjConditionContext sppjCondition() {
			return getRuleContext(SppjConditionContext.class,0);
		}
		public SppjWhereClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjWhereClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjWhereClause(this);
		}
	}

	public final SppjWhereClauseContext sppjWhereClause() throws RecognitionException {
		SppjWhereClauseContext _localctx = new SppjWhereClauseContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_sppjWhereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			match(WHERE);
			setState(163);
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
		public TerminalNode AND() { return getToken(SPPJQLParser.AND, 0); }
		public SppjConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjCondition(this);
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
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_sppjCondition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME:
			case STRING:
			case INTEGER:
				{
				setState(166);
				sppjWhereCondEquality();
				}
				break;
			case T__5:
				{
				setState(167);
				match(T__5);
				setState(168);
				sppjCondition(0);
				setState(169);
				match(T__6);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(178);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SppjConditionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_sppjCondition);
					setState(173);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(174);
					match(AND);
					setState(175);
					sppjCondition(3);
					}
					} 
				}
				setState(180);
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
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjWhereCondEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjWhereCondEquality(this);
		}
	}

	public final SppjWhereCondEqualityContext sppjWhereCondEquality() throws RecognitionException {
		SppjWhereCondEqualityContext _localctx = new SppjWhereCondEqualityContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_sppjWhereCondEquality);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			sppjWhereCondEqualityLeftTerm();
			setState(182);
			match(T__0);
			setState(183);
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
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjWhereCondEqualityLeftTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjWhereCondEqualityLeftTerm(this);
		}
	}

	public final SppjWhereCondEqualityLeftTermContext sppjWhereCondEqualityLeftTerm() throws RecognitionException {
		SppjWhereCondEqualityLeftTermContext _localctx = new SppjWhereCondEqualityLeftTermContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_sppjWhereCondEqualityLeftTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
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
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjWhereCondEqualityRightTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjWhereCondEqualityRightTerm(this);
		}
	}

	public final SppjWhereCondEqualityRightTermContext sppjWhereCondEqualityRightTerm() throws RecognitionException {
		SppjWhereCondEqualityRightTermContext _localctx = new SppjWhereCondEqualityRightTermContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_sppjWhereCondEqualityRightTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
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
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjCTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjCTerm(this);
		}
	}

	public final SppjCTermContext sppjCTerm() throws RecognitionException {
		SppjCTermContext _localctx = new SppjCTermContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_sppjCTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
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
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjTerm(this);
		}
	}

	public final SppjTermContext sppjTerm() throws RecognitionException {
		SppjTermContext _localctx = new SppjTermContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_sppjTerm);
		try {
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				sppjTermConstant();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				sppjTermVar();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(193);
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
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjTermVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjTermVar(this);
		}
	}

	public final SppjTermVarContext sppjTermVar() throws RecognitionException {
		SppjTermVarContext _localctx = new SppjTermVarContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_sppjTermVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
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
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjTermConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjTermConstant(this);
		}
	}

	public final SppjTermConstantContext sppjTermConstant() throws RecognitionException {
		SppjTermConstantContext _localctx = new SppjTermConstantContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_sppjTermConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
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
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjTermPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjTermPath(this);
		}
	}

	public final SppjTermPathContext sppjTermPath() throws RecognitionException {
		SppjTermPathContext _localctx = new SppjTermPathContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_sppjTermPath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
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
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjPath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjPath(this);
		}
	}

	public final SppjPathContext sppjPath() throws RecognitionException {
		SppjPathContext _localctx = new SppjPathContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_sppjPath);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			sppjPathVar();
			setState(204); 
			_errHandler.sync(this);
			_alt = 1+1;
			do {
				switch (_alt) {
				case 1+1:
					{
					{
					setState(203);
					sppjStep();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(206); 
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
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjPathVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjPathVar(this);
		}
	}

	public final SppjPathVarContext sppjPathVar() throws RecognitionException {
		SppjPathVarContext _localctx = new SppjPathVarContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_sppjPathVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
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
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjStep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjStep(this);
		}
	}

	public final SppjStepContext sppjStep() throws RecognitionException {
		SppjStepContext _localctx = new SppjStepContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_sppjStep);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
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
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjObjStep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjObjStep(this);
		}
	}

	public final SppjObjStepContext sppjObjStep() throws RecognitionException {
		SppjObjStepContext _localctx = new SppjObjStepContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_sppjObjStep);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212);
			match(T__7);
			setState(213);
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
		public TerminalNode NAME() { return getToken(SPPJQLParser.NAME, 0); }
		public SppjVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjVariable(this);
		}
	}

	public final SppjVariableContext sppjVariable() throws RecognitionException {
		SppjVariableContext _localctx = new SppjVariableContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_sppjVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
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

	public static class DataSetNameContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(SPPJQLParser.NAME, 0); }
		public DataSetNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dataSetName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterDataSetName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitDataSetName(this);
		}
	}

	public final DataSetNameContext dataSetName() throws RecognitionException {
		DataSetNameContext _localctx = new DataSetNameContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_dataSetName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(217);
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

	public static class KeyContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(SPPJQLParser.STRING, 0); }
		public TerminalNode NAME() { return getToken(SPPJQLParser.NAME, 0); }
		public KeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_key; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitKey(this);
		}
	}

	public final KeyContext key() throws RecognitionException {
		KeyContext _localctx = new KeyContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_key);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
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

	public static class SppjFieldNameContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(SPPJQLParser.STRING, 0); }
		public SppjFieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjFieldName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjFieldName(this);
		}
	}

	public final SppjFieldNameContext sppjFieldName() throws RecognitionException {
		SppjFieldNameContext _localctx = new SppjFieldNameContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_sppjFieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
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
		public TerminalNode INTEGER() { return getToken(SPPJQLParser.INTEGER, 0); }
		public TerminalNode STRING() { return getToken(SPPJQLParser.STRING, 0); }
		public SppjConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sppjConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).enterSppjConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SPPJQLListener ) ((SPPJQLListener)listener).exitSppjConstant(this);
		}
	}

	public final SppjConstantContext sppjConstant() throws RecognitionException {
		SppjConstantContext _localctx = new SppjConstantContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_sppjConstant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
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
		case 21:
			return sppjCondition_sempred((SppjConditionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean sppjCondition_sempred(SppjConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\33\u00e4\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\5\2\\\n\2\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\7\3\b\3\b\3\b\5\bm\n\b\3\t\3\t\3\t\3\t\7\ts\n\t\f\t\16\tv\13"+
		"\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\5\f\u0084\n\f\3\r"+
		"\3\r\3\16\3\16\3\17\3\17\3\20\3\20\5\20\u008e\n\20\3\21\3\21\3\21\3\21"+
		"\7\21\u0094\n\21\f\21\16\21\u0097\13\21\3\22\3\22\3\22\3\22\3\23\3\23"+
		"\3\24\3\24\5\24\u00a1\n\24\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\5\27\u00ae\n\27\3\27\3\27\3\27\7\27\u00b3\n\27\f\27\16\27\u00b6"+
		"\13\27\3\30\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34"+
		"\5\34\u00c5\n\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \6 \u00cf\n \r \16"+
		" \u00d0\3!\3!\3\"\3\"\3#\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3(\3\u00d0"+
		"\3,)\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@"+
		"BDFHJLN\2\4\3\2\30\31\3\2\31\32\2\u00cb\2[\3\2\2\2\4]\3\2\2\2\6_\3\2\2"+
		"\2\bb\3\2\2\2\nd\3\2\2\2\ff\3\2\2\2\16l\3\2\2\2\20n\3\2\2\2\22y\3\2\2"+
		"\2\24}\3\2\2\2\26\u0083\3\2\2\2\30\u0085\3\2\2\2\32\u0087\3\2\2\2\34\u0089"+
		"\3\2\2\2\36\u008b\3\2\2\2 \u008f\3\2\2\2\"\u0098\3\2\2\2$\u009c\3\2\2"+
		"\2&\u00a0\3\2\2\2(\u00a2\3\2\2\2*\u00a4\3\2\2\2,\u00ad\3\2\2\2.\u00b7"+
		"\3\2\2\2\60\u00bb\3\2\2\2\62\u00bd\3\2\2\2\64\u00bf\3\2\2\2\66\u00c4\3"+
		"\2\2\28\u00c6\3\2\2\2:\u00c8\3\2\2\2<\u00ca\3\2\2\2>\u00cc\3\2\2\2@\u00d2"+
		"\3\2\2\2B\u00d4\3\2\2\2D\u00d6\3\2\2\2F\u00d9\3\2\2\2H\u00db\3\2\2\2J"+
		"\u00dd\3\2\2\2L\u00df\3\2\2\2N\u00e1\3\2\2\2PQ\5\4\3\2QR\7\3\2\2RS\5\6"+
		"\4\2ST\7\2\2\3T\\\3\2\2\2UV\7\4\2\2VW\5\b\5\2WX\7\5\2\2XY\5\6\4\2YZ\7"+
		"\6\2\2Z\\\3\2\2\2[P\3\2\2\2[U\3\2\2\2\\\3\3\2\2\2]^\7\30\2\2^\5\3\2\2"+
		"\2_`\5\36\20\2`a\5\n\6\2a\7\3\2\2\2bc\5L\'\2c\t\3\2\2\2de\5\f\7\2e\13"+
		"\3\2\2\2fg\7\f\2\2gh\5\16\b\2h\r\3\2\2\2im\5\20\t\2jm\5\30\r\2km\5\32"+
		"\16\2li\3\2\2\2lj\3\2\2\2lk\3\2\2\2m\17\3\2\2\2no\7\4\2\2ot\5\22\n\2p"+
		"q\7\7\2\2qs\5\22\n\2rp\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2uw\3\2\2\2"+
		"vt\3\2\2\2wx\7\6\2\2x\21\3\2\2\2yz\5\24\13\2z{\7\5\2\2{|\5\26\f\2|\23"+
		"\3\2\2\2}~\5J&\2~\25\3\2\2\2\177\u0084\5\20\t\2\u0080\u0084\5\30\r\2\u0081"+
		"\u0084\5\32\16\2\u0082\u0084\5\34\17\2\u0083\177\3\2\2\2\u0083\u0080\3"+
		"\2\2\2\u0083\u0081\3\2\2\2\u0083\u0082\3\2\2\2\u0084\27\3\2\2\2\u0085"+
		"\u0086\5F$\2\u0086\31\3\2\2\2\u0087\u0088\5N(\2\u0088\33\3\2\2\2\u0089"+
		"\u008a\5\6\4\2\u008a\35\3\2\2\2\u008b\u008d\5 \21\2\u008c\u008e\5*\26"+
		"\2\u008d\u008c\3\2\2\2\u008d\u008e\3\2\2\2\u008e\37\3\2\2\2\u008f\u0090"+
		"\7\13\2\2\u0090\u0095\5\"\22\2\u0091\u0092\7\7\2\2\u0092\u0094\5\"\22"+
		"\2\u0093\u0091\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096"+
		"\3\2\2\2\u0096!\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u0099\5$\23\2\u0099"+
		"\u009a\7\26\2\2\u009a\u009b\5(\25\2\u009b#\3\2\2\2\u009c\u009d\5&\24\2"+
		"\u009d%\3\2\2\2\u009e\u00a1\5H%\2\u009f\u00a1\5> \2\u00a0\u009e\3\2\2"+
		"\2\u00a0\u009f\3\2\2\2\u00a1\'\3\2\2\2\u00a2\u00a3\5F$\2\u00a3)\3\2\2"+
		"\2\u00a4\u00a5\7\r\2\2\u00a5\u00a6\5,\27\2\u00a6+\3\2\2\2\u00a7\u00a8"+
		"\b\27\1\2\u00a8\u00ae\5.\30\2\u00a9\u00aa\7\b\2\2\u00aa\u00ab\5,\27\2"+
		"\u00ab\u00ac\7\t\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00a7\3\2\2\2\u00ad\u00a9"+
		"\3\2\2\2\u00ae\u00b4\3\2\2\2\u00af\u00b0\f\4\2\2\u00b0\u00b1\7\27\2\2"+
		"\u00b1\u00b3\5,\27\5\u00b2\u00af\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2"+
		"\3\2\2\2\u00b4\u00b5\3\2\2\2\u00b5-\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7"+
		"\u00b8\5\60\31\2\u00b8\u00b9\7\3\2\2\u00b9\u00ba\5\62\32\2\u00ba/\3\2"+
		"\2\2\u00bb\u00bc\5\64\33\2\u00bc\61\3\2\2\2\u00bd\u00be\5\64\33\2\u00be"+
		"\63\3\2\2\2\u00bf\u00c0\5\66\34\2\u00c0\65\3\2\2\2\u00c1\u00c5\5:\36\2"+
		"\u00c2\u00c5\58\35\2\u00c3\u00c5\5<\37\2\u00c4\u00c1\3\2\2\2\u00c4\u00c2"+
		"\3\2\2\2\u00c4\u00c3\3\2\2\2\u00c5\67\3\2\2\2\u00c6\u00c7\5F$\2\u00c7"+
		"9\3\2\2\2\u00c8\u00c9\5N(\2\u00c9;\3\2\2\2\u00ca\u00cb\5> \2\u00cb=\3"+
		"\2\2\2\u00cc\u00ce\5@!\2\u00cd\u00cf\5B\"\2\u00ce\u00cd\3\2\2\2\u00cf"+
		"\u00d0\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1?\3\2\2\2"+
		"\u00d2\u00d3\5F$\2\u00d3A\3\2\2\2\u00d4\u00d5\5D#\2\u00d5C\3\2\2\2\u00d6"+
		"\u00d7\7\n\2\2\u00d7\u00d8\5J&\2\u00d8E\3\2\2\2\u00d9\u00da\7\30\2\2\u00da"+
		"G\3\2\2\2\u00db\u00dc\7\30\2\2\u00dcI\3\2\2\2\u00dd\u00de\t\2\2\2\u00de"+
		"K\3\2\2\2\u00df\u00e0\7\31\2\2\u00e0M\3\2\2\2\u00e1\u00e2\t\3\2\2\u00e2"+
		"O\3\2\2\2\r[lt\u0083\u008d\u0095\u00a0\u00ad\u00b4\u00c4\u00d0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}