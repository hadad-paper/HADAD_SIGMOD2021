// Generated from SJQL.g4 by ANTLR 4.4

package hadad.base.compiler.model.sj;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SJQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__8=1, T__7=2, T__6=3, T__5=4, T__4=5, T__3=6, T__2=7, T__1=8, T__0=9, 
		QUERY=10, SOLRJSONBUILDOBJECT=11, NAME=12, STRING=13, INTEGER=14, WHITESPACE=15;
	public static final String[] tokenNames = {
		"<INVALID>", "'/'", "'&'", "'('", "')'", "':'", "','", "'fl='", "'='", 
		"'?q='", "QUERY", "SOLRJSONBUILDOBJECT", "NAME", "STRING", "INTEGER", 
		"WHITESPACE"
	};
	public static final int
		RULE_sjqlquery = 0, RULE_viewName = 1, RULE_sjQuery = 2, RULE_sjCollectionName = 3, 
		RULE_sjTextSearch = 4, RULE_sjLeftTerm = 5, RULE_sjRightTerm = 6, RULE_sjTerm = 7, 
		RULE_sjProjectFields = 8, RULE_sjRecordConstruct = 9, RULE_sjFieldBinding = 10, 
		RULE_sjRecordConstructFieldName = 11, RULE_sjKeyName = 12, RULE_sjFieldValue = 13, 
		RULE_sjFieldName = 14, RULE_sjVar = 15, RULE_sjConstant = 16;
	public static final String[] ruleNames = {
		"sjqlquery", "viewName", "sjQuery", "sjCollectionName", "sjTextSearch", 
		"sjLeftTerm", "sjRightTerm", "sjTerm", "sjProjectFields", "sjRecordConstruct", 
		"sjFieldBinding", "sjRecordConstructFieldName", "sjKeyName", "sjFieldValue", 
		"sjFieldName", "sjVar", "sjConstant"
	};

	@Override
	public String getGrammarFileName() { return "SJQL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SJQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SjqlqueryContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(SJQLParser.EOF, 0); }
		public SjQueryContext sjQuery() {
			return getRuleContext(SjQueryContext.class,0);
		}
		public ViewNameContext viewName() {
			return getRuleContext(ViewNameContext.class,0);
		}
		public SjqlqueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sjqlquery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).enterSjqlquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).exitSjqlquery(this);
		}
	}

	public final SjqlqueryContext sjqlquery() throws RecognitionException {
		SjqlqueryContext _localctx = new SjqlqueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sjqlquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(34); viewName();
			setState(35); match(T__1);
			setState(36); sjQuery();
			setState(37); match(EOF);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode NAME() { return getToken(SJQLParser.NAME, 0); }
		public ViewNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_viewName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).enterViewName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).exitViewName(this);
		}
	}

	public final ViewNameContext viewName() throws RecognitionException {
		ViewNameContext _localctx = new ViewNameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_viewName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(39); match(NAME);
			}
		}
		catch (RecognitionException re) {
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
		public SjTextSearchContext sjTextSearch() {
			return getRuleContext(SjTextSearchContext.class,0);
		}
		public SjCollectionNameContext sjCollectionName() {
			return getRuleContext(SjCollectionNameContext.class,0);
		}
		public SjProjectFieldsContext sjProjectFields() {
			return getRuleContext(SjProjectFieldsContext.class,0);
		}
		public TerminalNode QUERY() { return getToken(SJQLParser.QUERY, 0); }
		public SjQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sjQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).enterSjQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).exitSjQuery(this);
		}
	}

	public final SjQueryContext sjQuery() throws RecognitionException {
		SjQueryContext _localctx = new SjQueryContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sjQuery);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41); sjCollectionName();
			setState(42); match(T__8);
			setState(43); match(QUERY);
			setState(44); match(T__0);
			setState(46);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NAME) | (1L << STRING) | (1L << INTEGER))) != 0)) {
				{
				setState(45); sjTextSearch();
				}
			}

			setState(48); match(T__7);
			setState(49); sjProjectFields();
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode NAME() { return getToken(SJQLParser.NAME, 0); }
		public SjCollectionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sjCollectionName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).enterSjCollectionName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).exitSjCollectionName(this);
		}
	}

	public final SjCollectionNameContext sjCollectionName() throws RecognitionException {
		SjCollectionNameContext _localctx = new SjCollectionNameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sjCollectionName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51); match(NAME);
			}
		}
		catch (RecognitionException re) {
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
		public SjRightTermContext sjRightTerm() {
			return getRuleContext(SjRightTermContext.class,0);
		}
		public SjLeftTermContext sjLeftTerm() {
			return getRuleContext(SjLeftTermContext.class,0);
		}
		public SjTextSearchContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sjTextSearch; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).enterSjTextSearch(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).exitSjTextSearch(this);
		}
	}

	public final SjTextSearchContext sjTextSearch() throws RecognitionException {
		SjTextSearchContext _localctx = new SjTextSearchContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_sjTextSearch);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53); sjLeftTerm();
			setState(54); match(T__4);
			setState(55); sjRightTerm();
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).enterSjLeftTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).exitSjLeftTerm(this);
		}
	}

	public final SjLeftTermContext sjLeftTerm() throws RecognitionException {
		SjLeftTermContext _localctx = new SjLeftTermContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_sjLeftTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57); sjTerm();
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).enterSjRightTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).exitSjRightTerm(this);
		}
	}

	public final SjRightTermContext sjRightTerm() throws RecognitionException {
		SjRightTermContext _localctx = new SjRightTermContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sjRightTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59); sjTerm();
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).enterSjTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).exitSjTerm(this);
		}
	}

	public final SjTermContext sjTerm() throws RecognitionException {
		SjTermContext _localctx = new SjTermContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_sjTerm);
		try {
			setState(63);
			switch (_input.LA(1)) {
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(61); sjFieldName();
				}
				break;
			case STRING:
			case INTEGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(62); sjConstant();
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
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).enterSjProjectFields(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).exitSjProjectFields(this);
		}
	}

	public final SjProjectFieldsContext sjProjectFields() throws RecognitionException {
		SjProjectFieldsContext _localctx = new SjProjectFieldsContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_sjProjectFields);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65); match(T__2);
			setState(66); sjFieldName();
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(67); match(T__3);
				setState(68); sjFieldName();
				}
				}
				setState(73);
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
		public SjFieldBindingContext sjFieldBinding(int i) {
			return getRuleContext(SjFieldBindingContext.class,i);
		}
		public List<SjFieldBindingContext> sjFieldBinding() {
			return getRuleContexts(SjFieldBindingContext.class);
		}
		public TerminalNode SOLRJSONBUILDOBJECT() { return getToken(SJQLParser.SOLRJSONBUILDOBJECT, 0); }
		public SjRecordConstructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sjRecordConstruct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).enterSjRecordConstruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).exitSjRecordConstruct(this);
		}
	}

	public final SjRecordConstructContext sjRecordConstruct() throws RecognitionException {
		SjRecordConstructContext _localctx = new SjRecordConstructContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_sjRecordConstruct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74); match(SOLRJSONBUILDOBJECT);
			setState(75); match(T__6);
			setState(76); sjFieldBinding();
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(77); match(T__3);
				setState(78); sjFieldBinding();
				}
				}
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(84); match(T__5);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SjFieldBindingContext extends ParserRuleContext {
		public SjFieldValueContext sjFieldValue() {
			return getRuleContext(SjFieldValueContext.class,0);
		}
		public SjRecordConstructFieldNameContext sjRecordConstructFieldName() {
			return getRuleContext(SjRecordConstructFieldNameContext.class,0);
		}
		public SjFieldBindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sjFieldBinding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).enterSjFieldBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).exitSjFieldBinding(this);
		}
	}

	public final SjFieldBindingContext sjFieldBinding() throws RecognitionException {
		SjFieldBindingContext _localctx = new SjFieldBindingContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_sjFieldBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86); sjRecordConstructFieldName();
			setState(87); match(T__4);
			setState(88); sjFieldValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SjRecordConstructFieldNameContext extends ParserRuleContext {
		public SjKeyNameContext sjKeyName() {
			return getRuleContext(SjKeyNameContext.class,0);
		}
		public SjRecordConstructFieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sjRecordConstructFieldName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).enterSjRecordConstructFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).exitSjRecordConstructFieldName(this);
		}
	}

	public final SjRecordConstructFieldNameContext sjRecordConstructFieldName() throws RecognitionException {
		SjRecordConstructFieldNameContext _localctx = new SjRecordConstructFieldNameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_sjRecordConstructFieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90); sjKeyName();
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode STRING() { return getToken(SJQLParser.STRING, 0); }
		public SjKeyNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sjKeyName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).enterSjKeyName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).exitSjKeyName(this);
		}
	}

	public final SjKeyNameContext sjKeyName() throws RecognitionException {
		SjKeyNameContext _localctx = new SjKeyNameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_sjKeyName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92); match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SjFieldValueContext extends ParserRuleContext {
		public SjVarContext sjVar() {
			return getRuleContext(SjVarContext.class,0);
		}
		public SjFieldValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sjFieldValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).enterSjFieldValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).exitSjFieldValue(this);
		}
	}

	public final SjFieldValueContext sjFieldValue() throws RecognitionException {
		SjFieldValueContext _localctx = new SjFieldValueContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_sjFieldValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94); sjVar();
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode NAME() { return getToken(SJQLParser.NAME, 0); }
		public SjFieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sjFieldName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).enterSjFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).exitSjFieldName(this);
		}
	}

	public final SjFieldNameContext sjFieldName() throws RecognitionException {
		SjFieldNameContext _localctx = new SjFieldNameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_sjFieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96); match(NAME);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SjVarContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(SJQLParser.NAME, 0); }
		public SjVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sjVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).enterSjVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).exitSjVar(this);
		}
	}

	public final SjVarContext sjVar() throws RecognitionException {
		SjVarContext _localctx = new SjVarContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_sjVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98); match(NAME);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode INTEGER() { return getToken(SJQLParser.INTEGER, 0); }
		public TerminalNode STRING() { return getToken(SJQLParser.STRING, 0); }
		public SjConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sjConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).enterSjConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SJQLListener ) ((SJQLListener)listener).exitSjConstant(this);
		}
	}

	public final SjConstantContext sjConstant() throws RecognitionException {
		SjConstantContext _localctx = new SjConstantContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_sjConstant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			_la = _input.LA(1);
			if ( !(_la==STRING || _la==INTEGER) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\21i\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22\3\2\3"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\4\3\4\3\4\5\4\61\n\4\3\4\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\5\tB\n\t\3\n\3\n\3\n\3\n"+
		"\7\nH\n\n\f\n\16\nK\13\n\3\13\3\13\3\13\3\13\3\13\7\13R\n\13\f\13\16\13"+
		"U\13\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\3\21\3\21\3\22\3\22\3\22\2\2\23\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"\2\3\3\2\17\20[\2$\3\2\2\2\4)\3\2\2\2\6+\3\2\2\2\b\65\3\2\2\2\n\67"+
		"\3\2\2\2\f;\3\2\2\2\16=\3\2\2\2\20A\3\2\2\2\22C\3\2\2\2\24L\3\2\2\2\26"+
		"X\3\2\2\2\30\\\3\2\2\2\32^\3\2\2\2\34`\3\2\2\2\36b\3\2\2\2 d\3\2\2\2\""+
		"f\3\2\2\2$%\5\4\3\2%&\7\n\2\2&\'\5\6\4\2\'(\7\2\2\3(\3\3\2\2\2)*\7\16"+
		"\2\2*\5\3\2\2\2+,\5\b\5\2,-\7\3\2\2-.\7\f\2\2.\60\7\13\2\2/\61\5\n\6\2"+
		"\60/\3\2\2\2\60\61\3\2\2\2\61\62\3\2\2\2\62\63\7\4\2\2\63\64\5\22\n\2"+
		"\64\7\3\2\2\2\65\66\7\16\2\2\66\t\3\2\2\2\678\5\f\7\289\7\7\2\29:\5\16"+
		"\b\2:\13\3\2\2\2;<\5\20\t\2<\r\3\2\2\2=>\5\20\t\2>\17\3\2\2\2?B\5\36\20"+
		"\2@B\5\"\22\2A?\3\2\2\2A@\3\2\2\2B\21\3\2\2\2CD\7\t\2\2DI\5\36\20\2EF"+
		"\7\b\2\2FH\5\36\20\2GE\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2J\23\3\2\2"+
		"\2KI\3\2\2\2LM\7\r\2\2MN\7\5\2\2NS\5\26\f\2OP\7\b\2\2PR\5\26\f\2QO\3\2"+
		"\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TV\3\2\2\2US\3\2\2\2VW\7\6\2\2W\25\3"+
		"\2\2\2XY\5\30\r\2YZ\7\7\2\2Z[\5\34\17\2[\27\3\2\2\2\\]\5\32\16\2]\31\3"+
		"\2\2\2^_\7\17\2\2_\33\3\2\2\2`a\5 \21\2a\35\3\2\2\2bc\7\16\2\2c\37\3\2"+
		"\2\2de\7\16\2\2e!\3\2\2\2fg\t\2\2\2g#\3\2\2\2\6\60AIS";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}