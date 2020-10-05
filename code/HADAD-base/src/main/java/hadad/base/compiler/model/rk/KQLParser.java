// Generated from KQL.g4 by ANTLR 4.7.2

package hadad.base.compiler.model.rk;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class KQLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, FROM=11, SELECT=12, WHERE=13, IN=14, MAP=15, KEYS=16, LIST=17, 
		SET=18, MAIN=19, NAME=20, STRING=21, INTEGER=22, WHITESPACE=23;
	public static final int
		RULE_kqlquery = 0, RULE_viewName = 1, RULE_redisKQLQuery = 2, RULE_sfwQuery = 3, 
		RULE_rkSelectClasue = 4, RULE_rkSelectStatement = 5, RULE_rkSelectItem = 6, 
		RULE_rkReturnVariable = 7, RULE_mapConstructor = 8, RULE_rkAttribute = 9, 
		RULE_rkAttributeValue = 10, RULE_mapKey = 11, RULE_rkFromClasue = 12, 
		RULE_varBinding = 13, RULE_fromvariableBinding = 14, RULE_rkSource = 15, 
		RULE_rkLookUpExpression = 16, RULE_mainMap = 17, RULE_mapVariable = 18, 
		RULE_rkKey = 19, RULE_rkStringKey = 20, RULE_variableKey = 21, RULE_keyVariable = 22, 
		RULE_mapName = 23, RULE_rkVariable = 24;
	private static String[] makeRuleNames() {
		return new String[] {
			"kqlquery", "viewName", "redisKQLQuery", "sfwQuery", "rkSelectClasue", 
			"rkSelectStatement", "rkSelectItem", "rkReturnVariable", "mapConstructor", 
			"rkAttribute", "rkAttributeValue", "mapKey", "rkFromClasue", "varBinding", 
			"fromvariableBinding", "rkSource", "rkLookUpExpression", "mainMap", "mapVariable", 
			"rkKey", "rkStringKey", "variableKey", "keyVariable", "mapName", "rkVariable"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'-'", "'>'", "'{'", "','", "'}'", "':'", "'.'", "'['", 
			"']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "FROM", 
			"SELECT", "WHERE", "IN", "MAP", "KEYS", "LIST", "SET", "MAIN", "NAME", 
			"STRING", "INTEGER", "WHITESPACE"
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
	public String getGrammarFileName() { return "KQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public KQLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class KqlqueryContext extends ParserRuleContext {
		public ViewNameContext viewName() {
			return getRuleContext(ViewNameContext.class,0);
		}
		public RedisKQLQueryContext redisKQLQuery() {
			return getRuleContext(RedisKQLQueryContext.class,0);
		}
		public TerminalNode EOF() { return getToken(KQLParser.EOF, 0); }
		public KqlqueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kqlquery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).enterKqlquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).exitKqlquery(this);
		}
	}

	public final KqlqueryContext kqlquery() throws RecognitionException {
		KqlqueryContext _localctx = new KqlqueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_kqlquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			viewName();
			setState(51);
			match(T__0);
			setState(52);
			redisKQLQuery();
			setState(53);
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
		public TerminalNode NAME() { return getToken(KQLParser.NAME, 0); }
		public ViewNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_viewName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).enterViewName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).exitViewName(this);
		}
	}

	public final ViewNameContext viewName() throws RecognitionException {
		ViewNameContext _localctx = new ViewNameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_viewName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
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
			if ( listener instanceof KQLListener ) ((KQLListener)listener).enterRedisKQLQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).exitRedisKQLQuery(this);
		}
	}

	public final RedisKQLQueryContext redisKQLQuery() throws RecognitionException {
		RedisKQLQueryContext _localctx = new RedisKQLQueryContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_redisKQLQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
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
			if ( listener instanceof KQLListener ) ((KQLListener)listener).enterSfwQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).exitSfwQuery(this);
		}
	}

	public final SfwQueryContext sfwQuery() throws RecognitionException {
		SfwQueryContext _localctx = new SfwQueryContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sfwQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			rkSelectClasue();
			setState(60);
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
			if ( listener instanceof KQLListener ) ((KQLListener)listener).enterRkSelectClasue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).exitRkSelectClasue(this);
		}
	}

	public final RkSelectClasueContext rkSelectClasue() throws RecognitionException {
		RkSelectClasueContext _localctx = new RkSelectClasueContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_rkSelectClasue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
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
		public TerminalNode SELECT() { return getToken(KQLParser.SELECT, 0); }
		public RkSelectItemContext rkSelectItem() {
			return getRuleContext(RkSelectItemContext.class,0);
		}
		public RkSelectStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rkSelectStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).enterRkSelectStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).exitRkSelectStatement(this);
		}
	}

	public final RkSelectStatementContext rkSelectStatement() throws RecognitionException {
		RkSelectStatementContext _localctx = new RkSelectStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_rkSelectStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(SELECT);
			setState(65);
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
			if ( listener instanceof KQLListener ) ((KQLListener)listener).enterRkSelectItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).exitRkSelectItem(this);
		}
	}

	public final RkSelectItemContext rkSelectItem() throws RecognitionException {
		RkSelectItemContext _localctx = new RkSelectItemContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_rkSelectItem);
		try {
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				rkReturnVariable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
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
			if ( listener instanceof KQLListener ) ((KQLListener)listener).enterRkReturnVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).exitRkReturnVariable(this);
		}
	}

	public final RkReturnVariableContext rkReturnVariable() throws RecognitionException {
		RkReturnVariableContext _localctx = new RkReturnVariableContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_rkReturnVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
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
			if ( listener instanceof KQLListener ) ((KQLListener)listener).enterMapConstructor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).exitMapConstructor(this);
		}
	}

	public final MapConstructorContext mapConstructor() throws RecognitionException {
		MapConstructorContext _localctx = new MapConstructorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_mapConstructor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(73);
			mapKey();
			setState(74);
			match(T__1);
			setState(75);
			match(T__2);
			setState(76);
			match(T__3);
			setState(77);
			rkAttribute();
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(78);
				match(T__4);
				setState(79);
				rkAttribute();
				}
				}
				setState(84);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(85);
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
			if ( listener instanceof KQLListener ) ((KQLListener)listener).enterRkAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).exitRkAttribute(this);
		}
	}

	public final RkAttributeContext rkAttribute() throws RecognitionException {
		RkAttributeContext _localctx = new RkAttributeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_rkAttribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			rkStringKey();
			setState(88);
			match(T__6);
			setState(89);
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
			if ( listener instanceof KQLListener ) ((KQLListener)listener).enterRkAttributeValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).exitRkAttributeValue(this);
		}
	}

	public final RkAttributeValueContext rkAttributeValue() throws RecognitionException {
		RkAttributeValueContext _localctx = new RkAttributeValueContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_rkAttributeValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
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
		public List<TerminalNode> NAME() { return getTokens(KQLParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(KQLParser.NAME, i);
		}
		public TerminalNode STRING() { return getToken(KQLParser.STRING, 0); }
		public MapKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).enterMapKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).exitMapKey(this);
		}
	}

	public final MapKeyContext mapKey() throws RecognitionException {
		MapKeyContext _localctx = new MapKeyContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_mapKey);
		try {
			setState(98);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				match(NAME);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				match(NAME);
				setState(95);
				match(T__7);
				setState(96);
				match(NAME);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(97);
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
		public TerminalNode FROM() { return getToken(KQLParser.FROM, 0); }
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
			if ( listener instanceof KQLListener ) ((KQLListener)listener).enterRkFromClasue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).exitRkFromClasue(this);
		}
	}

	public final RkFromClasueContext rkFromClasue() throws RecognitionException {
		RkFromClasueContext _localctx = new RkFromClasueContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_rkFromClasue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(FROM);
			setState(101);
			varBinding();
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__4) {
				{
				{
				setState(102);
				match(T__4);
				setState(103);
				varBinding();
				}
				}
				setState(108);
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
		public TerminalNode IN() { return getToken(KQLParser.IN, 0); }
		public RkSourceContext rkSource() {
			return getRuleContext(RkSourceContext.class,0);
		}
		public VarBindingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varBinding; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).enterVarBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).exitVarBinding(this);
		}
	}

	public final VarBindingContext varBinding() throws RecognitionException {
		VarBindingContext _localctx = new VarBindingContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_varBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(109);
			fromvariableBinding();
			setState(110);
			match(IN);
			setState(111);
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
			if ( listener instanceof KQLListener ) ((KQLListener)listener).enterFromvariableBinding(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).exitFromvariableBinding(this);
		}
	}

	public final FromvariableBindingContext fromvariableBinding() throws RecognitionException {
		FromvariableBindingContext _localctx = new FromvariableBindingContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_fromvariableBinding);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
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
			if ( listener instanceof KQLListener ) ((KQLListener)listener).enterRkSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).exitRkSource(this);
		}
	}

	public final RkSourceContext rkSource() throws RecognitionException {
		RkSourceContext _localctx = new RkSourceContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_rkSource);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
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
		public TerminalNode KEYS() { return getToken(KQLParser.KEYS, 0); }
		public KeyVariableContext keyVariable() {
			return getRuleContext(KeyVariableContext.class,0);
		}
		public KeysMapLookUpContext(RkLookUpExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).enterKeysMapLookUp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).exitKeysMapLookUp(this);
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
			if ( listener instanceof KQLListener ) ((KQLListener)listener).enterVariableMapLookUp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).exitVariableMapLookUp(this);
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
			if ( listener instanceof KQLListener ) ((KQLListener)listener).enterMainMapLookUp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).exitMainMapLookUp(this);
		}
	}

	public final RkLookUpExpressionContext rkLookUpExpression() throws RecognitionException {
		RkLookUpExpressionContext _localctx = new RkLookUpExpressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_rkLookUpExpression);
		int _la;
		try {
			setState(148);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MAIN:
				_localctx = new MainMapLookUpContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				mainMap();
				setState(118);
				match(T__8);
				setState(119);
				rkKey();
				setState(120);
				match(T__9);
				setState(127);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(121);
					match(T__8);
					setState(122);
					rkKey();
					setState(123);
					match(T__9);
					}
					}
					setState(129);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case NAME:
				_localctx = new VariableMapLookUpContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				mapVariable();
				setState(131);
				match(T__8);
				setState(132);
				rkKey();
				setState(133);
				match(T__9);
				setState(140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(134);
					match(T__8);
					setState(135);
					rkKey();
					setState(136);
					match(T__9);
					}
					}
					setState(142);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case KEYS:
				_localctx = new KeysMapLookUpContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(143);
				match(KEYS);
				setState(144);
				match(T__8);
				setState(145);
				keyVariable();
				setState(146);
				match(T__9);
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
		public TerminalNode MAIN() { return getToken(KQLParser.MAIN, 0); }
		public MainMapContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mainMap; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).enterMainMap(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).exitMainMap(this);
		}
	}

	public final MainMapContext mainMap() throws RecognitionException {
		MainMapContext _localctx = new MainMapContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_mainMap);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
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
		public TerminalNode NAME() { return getToken(KQLParser.NAME, 0); }
		public MapVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).enterMapVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).exitMapVariable(this);
		}
	}

	public final MapVariableContext mapVariable() throws RecognitionException {
		MapVariableContext _localctx = new MapVariableContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_mapVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152);
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
			if ( listener instanceof KQLListener ) ((KQLListener)listener).enterRkKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).exitRkKey(this);
		}
	}

	public final RkKeyContext rkKey() throws RecognitionException {
		RkKeyContext _localctx = new RkKeyContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_rkKey);
		try {
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(154);
				rkStringKey();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(155);
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
		public TerminalNode STRING() { return getToken(KQLParser.STRING, 0); }
		public RkStringKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rkStringKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).enterRkStringKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).exitRkStringKey(this);
		}
	}

	public final RkStringKeyContext rkStringKey() throws RecognitionException {
		RkStringKeyContext _localctx = new RkStringKeyContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_rkStringKey);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
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
		public List<TerminalNode> NAME() { return getTokens(KQLParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(KQLParser.NAME, i);
		}
		public VariableKeyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableKey; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).enterVariableKey(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).exitVariableKey(this);
		}
	}

	public final VariableKeyContext variableKey() throws RecognitionException {
		VariableKeyContext _localctx = new VariableKeyContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_variableKey);
		try {
			setState(164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				match(NAME);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				match(NAME);
				setState(162);
				match(T__7);
				setState(163);
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
		public TerminalNode NAME() { return getToken(KQLParser.NAME, 0); }
		public KeyVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).enterKeyVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).exitKeyVariable(this);
		}
	}

	public final KeyVariableContext keyVariable() throws RecognitionException {
		KeyVariableContext _localctx = new KeyVariableContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_keyVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
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
			if ( listener instanceof KQLListener ) ((KQLListener)listener).enterMapName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).exitMapName(this);
		}
	}

	public final MapNameContext mapName() throws RecognitionException {
		MapNameContext _localctx = new MapNameContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_mapName);
		try {
			setState(170);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MAIN:
				enterOuterAlt(_localctx, 1);
				{
				setState(168);
				mainMap();
				}
				break;
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(169);
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
		public List<TerminalNode> NAME() { return getTokens(KQLParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(KQLParser.NAME, i);
		}
		public RkVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rkVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).enterRkVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof KQLListener ) ((KQLListener)listener).exitRkVariable(this);
		}
	}

	public final RkVariableContext rkVariable() throws RecognitionException {
		RkVariableContext _localctx = new RkVariableContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_rkVariable);
		try {
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				match(NAME);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				match(NAME);
				setState(174);
				match(T__7);
				setState(175);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\31\u00b5\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\7"+
		"\3\7\3\7\3\b\3\b\5\bH\n\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\nS\n\n"+
		"\f\n\16\nV\13\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\r\5\re\n\r\3\16\3\16\3\16\3\16\7\16k\n\16\f\16\16\16n\13\16\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\7\22\u0080\n\22\f\22\16\22\u0083\13\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\7\22\u008d\n\22\f\22\16\22\u0090\13\22\3\22\3\22\3\22\3\22"+
		"\3\22\5\22\u0097\n\22\3\23\3\23\3\24\3\24\3\25\3\25\5\25\u009f\n\25\3"+
		"\26\3\26\3\27\3\27\3\27\3\27\5\27\u00a7\n\27\3\30\3\30\3\31\3\31\5\31"+
		"\u00ad\n\31\3\32\3\32\3\32\3\32\5\32\u00b3\n\32\3\32\2\2\33\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\2\2\2\u00a8\2\64\3\2\2\2"+
		"\49\3\2\2\2\6;\3\2\2\2\b=\3\2\2\2\n@\3\2\2\2\fB\3\2\2\2\16G\3\2\2\2\20"+
		"I\3\2\2\2\22K\3\2\2\2\24Y\3\2\2\2\26]\3\2\2\2\30d\3\2\2\2\32f\3\2\2\2"+
		"\34o\3\2\2\2\36s\3\2\2\2 u\3\2\2\2\"\u0096\3\2\2\2$\u0098\3\2\2\2&\u009a"+
		"\3\2\2\2(\u009e\3\2\2\2*\u00a0\3\2\2\2,\u00a6\3\2\2\2.\u00a8\3\2\2\2\60"+
		"\u00ac\3\2\2\2\62\u00b2\3\2\2\2\64\65\5\4\3\2\65\66\7\3\2\2\66\67\5\6"+
		"\4\2\678\7\2\2\38\3\3\2\2\29:\7\26\2\2:\5\3\2\2\2;<\5\b\5\2<\7\3\2\2\2"+
		"=>\5\n\6\2>?\5\32\16\2?\t\3\2\2\2@A\5\f\7\2A\13\3\2\2\2BC\7\16\2\2CD\5"+
		"\16\b\2D\r\3\2\2\2EH\5\20\t\2FH\5\22\n\2GE\3\2\2\2GF\3\2\2\2H\17\3\2\2"+
		"\2IJ\5\62\32\2J\21\3\2\2\2KL\5\30\r\2LM\7\4\2\2MN\7\5\2\2NO\7\6\2\2OT"+
		"\5\24\13\2PQ\7\7\2\2QS\5\24\13\2RP\3\2\2\2SV\3\2\2\2TR\3\2\2\2TU\3\2\2"+
		"\2UW\3\2\2\2VT\3\2\2\2WX\7\b\2\2X\23\3\2\2\2YZ\5*\26\2Z[\7\t\2\2[\\\5"+
		"\26\f\2\\\25\3\2\2\2]^\5\20\t\2^\27\3\2\2\2_e\7\26\2\2`a\7\26\2\2ab\7"+
		"\n\2\2be\7\26\2\2ce\7\27\2\2d_\3\2\2\2d`\3\2\2\2dc\3\2\2\2e\31\3\2\2\2"+
		"fg\7\r\2\2gl\5\34\17\2hi\7\7\2\2ik\5\34\17\2jh\3\2\2\2kn\3\2\2\2lj\3\2"+
		"\2\2lm\3\2\2\2m\33\3\2\2\2nl\3\2\2\2op\5\36\20\2pq\7\20\2\2qr\5 \21\2"+
		"r\35\3\2\2\2st\5\62\32\2t\37\3\2\2\2uv\5\"\22\2v!\3\2\2\2wx\5$\23\2xy"+
		"\7\13\2\2yz\5(\25\2z\u0081\7\f\2\2{|\7\13\2\2|}\5(\25\2}~\7\f\2\2~\u0080"+
		"\3\2\2\2\177{\3\2\2\2\u0080\u0083\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082"+
		"\3\2\2\2\u0082\u0097\3\2\2\2\u0083\u0081\3\2\2\2\u0084\u0085\5&\24\2\u0085"+
		"\u0086\7\13\2\2\u0086\u0087\5(\25\2\u0087\u008e\7\f\2\2\u0088\u0089\7"+
		"\13\2\2\u0089\u008a\5(\25\2\u008a\u008b\7\f\2\2\u008b\u008d\3\2\2\2\u008c"+
		"\u0088\3\2\2\2\u008d\u0090\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2"+
		"\2\2\u008f\u0097\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0092\7\22\2\2\u0092"+
		"\u0093\7\13\2\2\u0093\u0094\5.\30\2\u0094\u0095\7\f\2\2\u0095\u0097\3"+
		"\2\2\2\u0096w\3\2\2\2\u0096\u0084\3\2\2\2\u0096\u0091\3\2\2\2\u0097#\3"+
		"\2\2\2\u0098\u0099\7\25\2\2\u0099%\3\2\2\2\u009a\u009b\7\26\2\2\u009b"+
		"\'\3\2\2\2\u009c\u009f\5*\26\2\u009d\u009f\5,\27\2\u009e\u009c\3\2\2\2"+
		"\u009e\u009d\3\2\2\2\u009f)\3\2\2\2\u00a0\u00a1\7\27\2\2\u00a1+\3\2\2"+
		"\2\u00a2\u00a7\7\26\2\2\u00a3\u00a4\7\26\2\2\u00a4\u00a5\7\n\2\2\u00a5"+
		"\u00a7\7\26\2\2\u00a6\u00a2\3\2\2\2\u00a6\u00a3\3\2\2\2\u00a7-\3\2\2\2"+
		"\u00a8\u00a9\7\26\2\2\u00a9/\3\2\2\2\u00aa\u00ad\5$\23\2\u00ab\u00ad\5"+
		"\62\32\2\u00ac\u00aa\3\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\61\3\2\2\2\u00ae"+
		"\u00b3\7\26\2\2\u00af\u00b0\7\26\2\2\u00b0\u00b1\7\n\2\2\u00b1\u00b3\7"+
		"\26\2\2\u00b2\u00ae\3\2\2\2\u00b2\u00af\3\2\2\2\u00b3\63\3\2\2\2\rGTd"+
		"l\u0081\u008e\u0096\u009e\u00a6\u00ac\u00b2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}