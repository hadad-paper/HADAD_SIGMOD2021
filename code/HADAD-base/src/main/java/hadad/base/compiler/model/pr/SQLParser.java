// Generated from SQL.g4 by ANTLR 4.7.2

package hadad.base.compiler.model.pr;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, FROM=6, SELECT=7, WHERE=8, AS=9, 
		AND=10, LIKE=11, NAME=12, STRING=13, INTEGER=14, WHITESPACE=15;
	public static final int
		RULE_rqQuery = 0, RULE_viewName = 1, RULE_prQuery = 2, RULE_prSfwQuery = 3, 
		RULE_prFromWhereClauses = 4, RULE_prSelectClause = 5, RULE_prSelectStatement = 6, 
		RULE_prSelectItem = 7, RULE_prFromClause = 8, RULE_prRelationBinding = 9, 
		RULE_prSource = 10, RULE_prRelationName = 11, RULE_prVariable = 12, RULE_prWhereClause = 13, 
		RULE_prWhereStatement = 14, RULE_prCondition = 15, RULE_prTerm = 16, RULE_prEquality = 17, 
		RULE_prLikeExpression = 18, RULE_prLeftterm = 19, RULE_prRightterm = 20, 
		RULE_realtion = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"rqQuery", "viewName", "prQuery", "prSfwQuery", "prFromWhereClauses", 
			"prSelectClause", "prSelectStatement", "prSelectItem", "prFromClause", 
			"prRelationBinding", "prSource", "prRelationName", "prVariable", "prWhereClause", 
			"prWhereStatement", "prCondition", "prTerm", "prEquality", "prLikeExpression", 
			"prLeftterm", "prRightterm", "realtion"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "','", "'('", "')'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "FROM", "SELECT", "WHERE", "AS", 
			"AND", "LIKE", "NAME", "STRING", "INTEGER", "WHITESPACE"
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
	public String getGrammarFileName() { return "SQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class RqQueryContext extends ParserRuleContext {
		public ViewNameContext viewName() {
			return getRuleContext(ViewNameContext.class,0);
		}
		public PrQueryContext prQuery() {
			return getRuleContext(PrQueryContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SQLParser.EOF, 0); }
		public RqQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rqQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterRqQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitRqQuery(this);
		}
	}

	public final RqQueryContext rqQuery() throws RecognitionException {
		RqQueryContext _localctx = new RqQueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_rqQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			viewName();
			setState(45);
			match(T__0);
			setState(46);
			prQuery();
			setState(47);
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
		public TerminalNode NAME() { return getToken(SQLParser.NAME, 0); }
		public ViewNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_viewName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterViewName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitViewName(this);
		}
	}

	public final ViewNameContext viewName() throws RecognitionException {
		ViewNameContext _localctx = new ViewNameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_viewName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
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
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterPrQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitPrQuery(this);
		}
	}

	public final PrQueryContext prQuery() throws RecognitionException {
		PrQueryContext _localctx = new PrQueryContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_prQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
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
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterPrSfwQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitPrSfwQuery(this);
		}
	}

	public final PrSfwQueryContext prSfwQuery() throws RecognitionException {
		PrSfwQueryContext _localctx = new PrSfwQueryContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_prSfwQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			prSelectClause();
			setState(54);
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
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterPrFromWhereClauses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitPrFromWhereClauses(this);
		}
	}

	public final PrFromWhereClausesContext prFromWhereClauses() throws RecognitionException {
		PrFromWhereClausesContext _localctx = new PrFromWhereClausesContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_prFromWhereClauses);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			prFromClause();
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WHERE) {
				{
				setState(57);
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
		public TerminalNode SELECT() { return getToken(SQLParser.SELECT, 0); }
		public PrSelectStatementContext prSelectStatement() {
			return getRuleContext(PrSelectStatementContext.class,0);
		}
		public PrSelectClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prSelectClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterPrSelectClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitPrSelectClause(this);
		}
	}

	public final PrSelectClauseContext prSelectClause() throws RecognitionException {
		PrSelectClauseContext _localctx = new PrSelectClauseContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_prSelectClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			match(SELECT);
			setState(61);
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
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterPrSelectStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitPrSelectStatement(this);
		}
	}

	public final PrSelectStatementContext prSelectStatement() throws RecognitionException {
		PrSelectStatementContext _localctx = new PrSelectStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_prSelectStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			prSelectItem();
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(64);
				match(T__1);
				setState(65);
				prSelectItem();
				}
				}
				setState(70);
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
		public PrTermContext prTerm() {
			return getRuleContext(PrTermContext.class,0);
		}
		public TerminalNode NAME() { return getToken(SQLParser.NAME, 0); }
		public PrSelectItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prSelectItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterPrSelectItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitPrSelectItem(this);
		}
	}

	public final PrSelectItemContext prSelectItem() throws RecognitionException {
		PrSelectItemContext _localctx = new PrSelectItemContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_prSelectItem);
		try {
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				prTerm();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
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

	public static class PrFromClauseContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(SQLParser.FROM, 0); }
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
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterPrFromClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitPrFromClause(this);
		}
	}

	public final PrFromClauseContext prFromClause() throws RecognitionException {
		PrFromClauseContext _localctx = new PrFromClauseContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_prFromClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(FROM);
			setState(76);
			prRelationBinding();
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(77);
				match(T__1);
				setState(78);
				prRelationBinding();
				}
				}
				setState(83);
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
		public TerminalNode AS() { return getToken(SQLParser.AS, 0); }
		public PrVariableContext prVariable() {
			return getRuleContext(PrVariableContext.class,0);
		}
		public PrRelationBindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prRelationBinding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterPrRelationBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitPrRelationBinding(this);
		}
	}

	public final PrRelationBindingContext prRelationBinding() throws RecognitionException {
		PrRelationBindingContext _localctx = new PrRelationBindingContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_prRelationBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			prSource();
			setState(85);
			match(AS);
			setState(86);
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
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterPrSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitPrSource(this);
		}
	}

	public final PrSourceContext prSource() throws RecognitionException {
		PrSourceContext _localctx = new PrSourceContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_prSource);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
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
		public TerminalNode NAME() { return getToken(SQLParser.NAME, 0); }
		public PrRelationNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prRelationName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterPrRelationName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitPrRelationName(this);
		}
	}

	public final PrRelationNameContext prRelationName() throws RecognitionException {
		PrRelationNameContext _localctx = new PrRelationNameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_prRelationName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
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
		public TerminalNode NAME() { return getToken(SQLParser.NAME, 0); }
		public PrVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterPrVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitPrVariable(this);
		}
	}

	public final PrVariableContext prVariable() throws RecognitionException {
		PrVariableContext _localctx = new PrVariableContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_prVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
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
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterPrWhereClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitPrWhereClause(this);
		}
	}

	public final PrWhereClauseContext prWhereClause() throws RecognitionException {
		PrWhereClauseContext _localctx = new PrWhereClauseContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_prWhereClause);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
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
		public TerminalNode WHERE() { return getToken(SQLParser.WHERE, 0); }
		public PrConditionContext prCondition() {
			return getRuleContext(PrConditionContext.class,0);
		}
		public PrWhereStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prWhereStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterPrWhereStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitPrWhereStatement(this);
		}
	}

	public final PrWhereStatementContext prWhereStatement() throws RecognitionException {
		PrWhereStatementContext _localctx = new PrWhereStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_prWhereStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96);
			match(WHERE);
			setState(97);
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
		public TerminalNode AND() { return getToken(SQLParser.AND, 0); }
		public PrConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterPrCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitPrCondition(this);
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
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_prCondition, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(100);
				prEquality();
				}
				break;
			case 2:
				{
				setState(101);
				prLikeExpression();
				}
				break;
			case 3:
				{
				setState(102);
				match(T__2);
				setState(103);
				prCondition(0);
				setState(104);
				match(T__3);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(113);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PrConditionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_prCondition);
					setState(108);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(109);
					match(AND);
					setState(110);
					prCondition(3);
					}
					} 
				}
				setState(115);
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

	public static class PrTermContext extends ParserRuleContext {
		public RealtionContext realtion() {
			return getRuleContext(RealtionContext.class,0);
		}
		public TerminalNode NAME() { return getToken(SQLParser.NAME, 0); }
		public TerminalNode STRING() { return getToken(SQLParser.STRING, 0); }
		public PrTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterPrTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitPrTerm(this);
		}
	}

	public final PrTermContext prTerm() throws RecognitionException {
		PrTermContext _localctx = new PrTermContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_prTerm);
		try {
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				realtion();
				setState(117);
				match(T__4);
				setState(118);
				match(NAME);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				match(NAME);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(121);
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
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterPrEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitPrEquality(this);
		}
	}

	public final PrEqualityContext prEquality() throws RecognitionException {
		PrEqualityContext _localctx = new PrEqualityContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_prEquality);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			prLeftterm();
			setState(125);
			match(T__0);
			setState(126);
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
		public TerminalNode LIKE() { return getToken(SQLParser.LIKE, 0); }
		public TerminalNode STRING() { return getToken(SQLParser.STRING, 0); }
		public PrLikeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prLikeExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterPrLikeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitPrLikeExpression(this);
		}
	}

	public final PrLikeExpressionContext prLikeExpression() throws RecognitionException {
		PrLikeExpressionContext _localctx = new PrLikeExpressionContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_prLikeExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			prTerm();
			setState(129);
			match(LIKE);
			setState(130);
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
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterPrLeftterm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitPrLeftterm(this);
		}
	}

	public final PrLefttermContext prLeftterm() throws RecognitionException {
		PrLefttermContext _localctx = new PrLefttermContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_prLeftterm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
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
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterPrRightterm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitPrRightterm(this);
		}
	}

	public final PrRighttermContext prRightterm() throws RecognitionException {
		PrRighttermContext _localctx = new PrRighttermContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_prRightterm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
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
		public TerminalNode NAME() { return getToken(SQLParser.NAME, 0); }
		public RealtionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_realtion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).enterRealtion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SQLListener ) ((SQLListener)listener).exitRealtion(this);
		}
	}

	public final RealtionContext realtion() throws RecognitionException {
		RealtionContext _localctx = new RealtionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_realtion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
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
		case 15:
			return prCondition_sempred((PrConditionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean prCondition_sempred(PrConditionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\21\u008d\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3\2\3\2"+
		"\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\5\6=\n\6\3\7\3\7\3\7\3\b\3\b\3\b"+
		"\7\bE\n\b\f\b\16\bH\13\b\3\t\3\t\5\tL\n\t\3\n\3\n\3\n\3\n\7\nR\n\n\f\n"+
		"\16\nU\13\n\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21m\n\21\3\21\3\21"+
		"\3\21\7\21r\n\21\f\21\16\21u\13\21\3\22\3\22\3\22\3\22\3\22\3\22\5\22"+
		"}\n\22\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\27"+
		"\3\27\3\27\2\3 \30\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,\2\2"+
		"\2\177\2.\3\2\2\2\4\63\3\2\2\2\6\65\3\2\2\2\b\67\3\2\2\2\n:\3\2\2\2\f"+
		">\3\2\2\2\16A\3\2\2\2\20K\3\2\2\2\22M\3\2\2\2\24V\3\2\2\2\26Z\3\2\2\2"+
		"\30\\\3\2\2\2\32^\3\2\2\2\34`\3\2\2\2\36b\3\2\2\2 l\3\2\2\2\"|\3\2\2\2"+
		"$~\3\2\2\2&\u0082\3\2\2\2(\u0086\3\2\2\2*\u0088\3\2\2\2,\u008a\3\2\2\2"+
		"./\5\4\3\2/\60\7\3\2\2\60\61\5\6\4\2\61\62\7\2\2\3\62\3\3\2\2\2\63\64"+
		"\7\16\2\2\64\5\3\2\2\2\65\66\5\b\5\2\66\7\3\2\2\2\678\5\f\7\289\5\n\6"+
		"\29\t\3\2\2\2:<\5\22\n\2;=\5\34\17\2<;\3\2\2\2<=\3\2\2\2=\13\3\2\2\2>"+
		"?\7\t\2\2?@\5\16\b\2@\r\3\2\2\2AF\5\20\t\2BC\7\4\2\2CE\5\20\t\2DB\3\2"+
		"\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\17\3\2\2\2HF\3\2\2\2IL\5\"\22\2JL"+
		"\7\16\2\2KI\3\2\2\2KJ\3\2\2\2L\21\3\2\2\2MN\7\b\2\2NS\5\24\13\2OP\7\4"+
		"\2\2PR\5\24\13\2QO\3\2\2\2RU\3\2\2\2SQ\3\2\2\2ST\3\2\2\2T\23\3\2\2\2U"+
		"S\3\2\2\2VW\5\26\f\2WX\7\13\2\2XY\5\32\16\2Y\25\3\2\2\2Z[\5\30\r\2[\27"+
		"\3\2\2\2\\]\7\16\2\2]\31\3\2\2\2^_\7\16\2\2_\33\3\2\2\2`a\5\36\20\2a\35"+
		"\3\2\2\2bc\7\n\2\2cd\5 \21\2d\37\3\2\2\2ef\b\21\1\2fm\5$\23\2gm\5&\24"+
		"\2hi\7\5\2\2ij\5 \21\2jk\7\6\2\2km\3\2\2\2le\3\2\2\2lg\3\2\2\2lh\3\2\2"+
		"\2ms\3\2\2\2no\f\4\2\2op\7\f\2\2pr\5 \21\5qn\3\2\2\2ru\3\2\2\2sq\3\2\2"+
		"\2st\3\2\2\2t!\3\2\2\2us\3\2\2\2vw\5,\27\2wx\7\7\2\2xy\7\16\2\2y}\3\2"+
		"\2\2z}\7\16\2\2{}\7\17\2\2|v\3\2\2\2|z\3\2\2\2|{\3\2\2\2}#\3\2\2\2~\177"+
		"\5(\25\2\177\u0080\7\3\2\2\u0080\u0081\5*\26\2\u0081%\3\2\2\2\u0082\u0083"+
		"\5\"\22\2\u0083\u0084\7\r\2\2\u0084\u0085\7\17\2\2\u0085\'\3\2\2\2\u0086"+
		"\u0087\5\"\22\2\u0087)\3\2\2\2\u0088\u0089\5\"\22\2\u0089+\3\2\2\2\u008a"+
		"\u008b\7\16\2\2\u008b-\3\2\2\2\t<FKSls|";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}