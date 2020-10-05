// Generated from XQuery.g4 by ANTLR 4.5.3

package hadad.base.compiler.model.xq;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class XQueryParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, ALPHA=28, BETA=29, WS=30;
	public static final int
		RULE_xquery = 0, RULE_viewName = 1, RULE_openRootTag = 2, RULE_closeRootTag = 3, 
		RULE_construct = 4, RULE_constructEmptyTag = 5, RULE_constructString = 6, 
		RULE_constructVar = 7, RULE_constructFlwr = 8, RULE_constructFlwrTerm = 9, 
		RULE_constructDelimeter = 10, RULE_constructFlwrOpenTag = 11, RULE_constructFlwrCloseTag = 12, 
		RULE_tag = 13, RULE_mkattr = 14, RULE_mkattrName = 15, RULE_string = 16, 
		RULE_name = 17, RULE_aterm = 18, RULE_atermVar = 19, RULE_atermString = 20, 
		RULE_var = 21, RULE_flwr = 22, RULE_flwrFor = 23, RULE_flwrWhere = 24, 
		RULE_flwrReturn = 25, RULE_flwrForWhere = 26, RULE_flwrForVar = 27, RULE_flwrForP = 28, 
		RULE_flwrWhereCond = 29, RULE_flwrWhereCondSome = 30, RULE_flwrWhereCondVar = 31, 
		RULE_flwrWhereCondAp = 32, RULE_flwrWhereCondEquality = 33, RULE_flwrWhereCondEqualityLeftTerm = 34, 
		RULE_flwrWhereCondEqualityRightTerm = 35, RULE_cterm = 36, RULE_ctermAp = 37, 
		RULE_ctermVar = 38, RULE_ctermString = 39, RULE_flwrReturnVar = 40, RULE_flwrReturnString = 41, 
		RULE_flwrReturnConstruct = 42, RULE_rp = 43, RULE_child = 44, RULE_desc = 45, 
		RULE_rpTag = 46, RULE_rpAttr = 47, RULE_rpText = 48, RULE_rpDot = 49, 
		RULE_ap = 50, RULE_document = 51, RULE_source = 52, RULE_apAttr = 53, 
		RULE_p = 54;
	public static final String[] ruleNames = {
		"xquery", "viewName", "openRootTag", "closeRootTag", "construct", "constructEmptyTag", 
		"constructString", "constructVar", "constructFlwr", "constructFlwrTerm", 
		"constructDelimeter", "constructFlwrOpenTag", "constructFlwrCloseTag", 
		"tag", "mkattr", "mkattrName", "string", "name", "aterm", "atermVar", 
		"atermString", "var", "flwr", "flwrFor", "flwrWhere", "flwrReturn", "flwrForWhere", 
		"flwrForVar", "flwrForP", "flwrWhereCond", "flwrWhereCondSome", "flwrWhereCondVar", 
		"flwrWhereCondAp", "flwrWhereCondEquality", "flwrWhereCondEqualityLeftTerm", 
		"flwrWhereCondEqualityRightTerm", "cterm", "ctermAp", "ctermVar", "ctermString", 
		"flwrReturnVar", "flwrReturnString", "flwrReturnConstruct", "rp", "child", 
		"desc", "rpTag", "rpAttr", "rpText", "rpDot", "ap", "document", "source", 
		"apAttr", "p"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'<'", "'>'", "'{'", "'}'", "'</'", "'/>'", "','", "'['", 
		"']'", "'\"'", "'$'", "'for'", "'in'", "'where'", "'return'", "'('", "')'", 
		"'and'", "'satisfies'", "'some'", "'/'", "'//'", "'@'", "'text()'", "'.'", 
		"'document('"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, "ALPHA", "BETA", "WS"
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
	public String getGrammarFileName() { return "XQuery.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public XQueryParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class XqueryContext extends ParserRuleContext {
		public ViewNameContext viewName() {
			return getRuleContext(ViewNameContext.class,0);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterXquery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitXquery(this);
		}
	}

	public final XqueryContext xquery() throws RecognitionException {
		XqueryContext _localctx = new XqueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_xquery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			viewName();
			setState(111);
			match(T__0);
			setState(123);
			switch (_input.LA(1)) {
			case T__12:
				{
				setState(112);
				flwr();
				}
				break;
			case T__1:
				{
				setState(113);
				match(T__1);
				setState(114);
				openRootTag();
				setState(115);
				match(T__2);
				setState(116);
				match(T__3);
				setState(117);
				flwr();
				setState(118);
				match(T__4);
				setState(119);
				match(T__5);
				setState(120);
				closeRootTag();
				setState(121);
				match(T__2);
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

	public static class ViewNameContext extends ParserRuleContext {
		public TerminalNode ALPHA() { return getToken(XQueryParser.ALPHA, 0); }
		public ViewNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_viewName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterViewName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitViewName(this);
		}
	}

	public final ViewNameContext viewName() throws RecognitionException {
		ViewNameContext _localctx = new ViewNameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_viewName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			match(ALPHA);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterOpenRootTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitOpenRootTag(this);
		}
	}

	public final OpenRootTagContext openRootTag() throws RecognitionException {
		OpenRootTagContext _localctx = new OpenRootTagContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_openRootTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterCloseRootTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitCloseRootTag(this);
		}
	}

	public final CloseRootTagContext closeRootTag() throws RecognitionException {
		CloseRootTagContext _localctx = new CloseRootTagContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_closeRootTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterConstruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitConstruct(this);
		}
	}

	public final ConstructContext construct() throws RecognitionException {
		ConstructContext _localctx = new ConstructContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_construct);
		try {
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				constructEmptyTag();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
				constructString();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(133);
				constructVar();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(134);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterConstructEmptyTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitConstructEmptyTag(this);
		}
	}

	public final ConstructEmptyTagContext constructEmptyTag() throws RecognitionException {
		ConstructEmptyTagContext _localctx = new ConstructEmptyTagContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_constructEmptyTag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(T__1);
			setState(138);
			tag();
			setState(140);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(139);
				mkattr();
				}
			}

			setState(142);
			match(T__6);
			setState(143);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterConstructString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitConstructString(this);
		}
	}

	public final ConstructStringContext constructString() throws RecognitionException {
		ConstructStringContext _localctx = new ConstructStringContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_constructString);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(T__1);
			setState(146);
			tag();
			setState(148);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(147);
				mkattr();
				}
			}

			setState(150);
			match(T__2);
			setState(151);
			constructDelimeter();
			setState(152);
			string();
			setState(153);
			match(T__5);
			setState(154);
			tag();
			setState(155);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
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
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterConstructVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitConstructVar(this);
		}
	}

	public final ConstructVarContext constructVar() throws RecognitionException {
		ConstructVarContext _localctx = new ConstructVarContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_constructVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			match(T__1);
			setState(158);
			tag();
			setState(160);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(159);
				mkattr();
				}
			}

			setState(162);
			match(T__2);
			setState(163);
			constructDelimeter();
			setState(164);
			match(T__3);
			setState(165);
			var();
			setState(166);
			match(T__4);
			setState(167);
			match(T__5);
			setState(168);
			tag();
			setState(169);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterConstructFlwr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitConstructFlwr(this);
		}
	}

	public final ConstructFlwrContext constructFlwr() throws RecognitionException {
		ConstructFlwrContext _localctx = new ConstructFlwrContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_constructFlwr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(T__1);
			setState(172);
			constructFlwrOpenTag();
			setState(174);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(173);
				mkattr();
				}
			}

			setState(176);
			match(T__2);
			setState(177);
			constructDelimeter();
			setState(178);
			constructFlwrTerm();
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(179);
				match(T__7);
				setState(180);
				constructFlwrTerm();
				}
				}
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(186);
			match(T__5);
			setState(187);
			constructFlwrCloseTag();
			setState(188);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterConstructFlwrTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitConstructFlwrTerm(this);
		}
	}

	public final ConstructFlwrTermContext constructFlwrTerm() throws RecognitionException {
		ConstructFlwrTermContext _localctx = new ConstructFlwrTermContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_constructFlwrTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(195);
			switch (_input.LA(1)) {
			case T__3:
				{
				setState(190);
				match(T__3);
				setState(191);
				flwr();
				setState(192);
				match(T__4);
				}
				break;
			case T__1:
				{
				setState(194);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterConstructDelimeter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitConstructDelimeter(this);
		}
	}

	public final ConstructDelimeterContext constructDelimeter() throws RecognitionException {
		ConstructDelimeterContext _localctx = new ConstructDelimeterContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_constructDelimeter);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterConstructFlwrOpenTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitConstructFlwrOpenTag(this);
		}
	}

	public final ConstructFlwrOpenTagContext constructFlwrOpenTag() throws RecognitionException {
		ConstructFlwrOpenTagContext _localctx = new ConstructFlwrOpenTagContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_constructFlwrOpenTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterConstructFlwrCloseTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitConstructFlwrCloseTag(this);
		}
	}

	public final ConstructFlwrCloseTagContext constructFlwrCloseTag() throws RecognitionException {
		ConstructFlwrCloseTagContext _localctx = new ConstructFlwrCloseTagContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_constructFlwrCloseTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
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
		public TerminalNode ALPHA() { return getToken(XQueryParser.ALPHA, 0); }
		public TagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitTag(this);
		}
	}

	public final TagContext tag() throws RecognitionException {
		TagContext _localctx = new TagContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_tag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(ALPHA);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterMkattr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitMkattr(this);
		}
	}

	public final MkattrContext mkattr() throws RecognitionException {
		MkattrContext _localctx = new MkattrContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_mkattr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(205);
			match(T__8);
			setState(206);
			mkattrName();
			setState(207);
			match(T__0);
			setState(208);
			aterm();
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(209);
				match(T__7);
				setState(210);
				mkattrName();
				setState(211);
				match(T__0);
				setState(212);
				aterm();
				}
				}
				setState(218);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(219);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterMkattrName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitMkattrName(this);
		}
	}

	public final MkattrNameContext mkattrName() throws RecognitionException {
		MkattrNameContext _localctx = new MkattrNameContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_mkattrName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
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

	public static class StringContext extends ParserRuleContext {
		public TerminalNode ALPHA() { return getToken(XQueryParser.ALPHA, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitString(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			match(T__10);
			setState(224);
			match(ALPHA);
			setState(225);
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

	public static class NameContext extends ParserRuleContext {
		public TerminalNode ALPHA() { return getToken(XQueryParser.ALPHA, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitName(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(ALPHA);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterAterm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitAterm(this);
		}
	}

	public final AtermContext aterm() throws RecognitionException {
		AtermContext _localctx = new AtermContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_aterm);
		try {
			setState(234);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(229);
				match(T__3);
				setState(230);
				atermVar();
				setState(231);
				match(T__4);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(233);
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
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public AtermVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atermVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterAtermVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitAtermVar(this);
		}
	}

	public final AtermVarContext atermVar() throws RecognitionException {
		AtermVarContext _localctx = new AtermVarContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_atermVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterAtermString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitAtermString(this);
		}
	}

	public final AtermStringContext atermString() throws RecognitionException {
		AtermStringContext _localctx = new AtermStringContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_atermString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
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

	public static class VarContext extends ParserRuleContext {
		public TerminalNode ALPHA() { return getToken(XQueryParser.ALPHA, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitVar(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(240);
			match(T__11);
			setState(241);
			match(ALPHA);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFlwr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFlwr(this);
		}
	}

	public final FlwrContext flwr() throws RecognitionException {
		FlwrContext _localctx = new FlwrContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_flwr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			flwrForWhere();
			setState(244);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFlwrFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFlwrFor(this);
		}
	}

	public final FlwrForContext flwrFor() throws RecognitionException {
		FlwrForContext _localctx = new FlwrForContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_flwrFor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(246);
			match(T__12);
			setState(247);
			flwrForVar();
			setState(248);
			match(T__13);
			setState(249);
			flwrForP();
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(250);
				match(T__7);
				setState(251);
				flwrForVar();
				setState(252);
				match(T__13);
				setState(253);
				flwrForP();
				}
				}
				setState(259);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFlwrWhere(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFlwrWhere(this);
		}
	}

	public final FlwrWhereContext flwrWhere() throws RecognitionException {
		FlwrWhereContext _localctx = new FlwrWhereContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_flwrWhere);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(T__14);
			setState(261);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFlwrReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFlwrReturn(this);
		}
	}

	public final FlwrReturnContext flwrReturn() throws RecognitionException {
		FlwrReturnContext _localctx = new FlwrReturnContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_flwrReturn);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(T__15);
			setState(267);
			switch (_input.LA(1)) {
			case T__11:
				{
				setState(264);
				flwrReturnVar();
				}
				break;
			case T__10:
				{
				setState(265);
				flwrReturnString();
				}
				break;
			case T__1:
				{
				setState(266);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFlwrForWhere(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFlwrForWhere(this);
		}
	}

	public final FlwrForWhereContext flwrForWhere() throws RecognitionException {
		FlwrForWhereContext _localctx = new FlwrForWhereContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_flwrForWhere);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			flwrFor();
			setState(271);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(270);
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

	public static class FlwrForVarContext extends ParserRuleContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public FlwrForVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flwrForVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFlwrForVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFlwrForVar(this);
		}
	}

	public final FlwrForVarContext flwrForVar() throws RecognitionException {
		FlwrForVarContext _localctx = new FlwrForVarContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_flwrForVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFlwrForP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFlwrForP(this);
		}
	}

	public final FlwrForPContext flwrForP() throws RecognitionException {
		FlwrForPContext _localctx = new FlwrForPContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_flwrForP);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(275);
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
		public FlwrWhereCondEqualityContext flwrWhereCondEquality() {
			return getRuleContext(FlwrWhereCondEqualityContext.class,0);
		}
		public List<FlwrWhereCondContext> flwrWhereCond() {
			return getRuleContexts(FlwrWhereCondContext.class);
		}
		public FlwrWhereCondContext flwrWhereCond(int i) {
			return getRuleContext(FlwrWhereCondContext.class,i);
		}
		public FlwrWhereCondSomeContext flwrWhereCondSome() {
			return getRuleContext(FlwrWhereCondSomeContext.class,0);
		}
		public FlwrWhereCondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flwrWhereCond; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFlwrWhereCond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFlwrWhereCond(this);
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
		int _startState = 58;
		enterRecursionRule(_localctx, 58, RULE_flwrWhereCond, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			switch (_input.LA(1)) {
			case T__10:
			case T__11:
			case T__26:
				{
				setState(278);
				flwrWhereCondEquality();
				}
				break;
			case T__16:
				{
				setState(279);
				match(T__16);
				setState(280);
				flwrWhereCond(0);
				setState(281);
				match(T__17);
				}
				break;
			case T__20:
				{
				setState(283);
				flwrWhereCondSome();
				setState(284);
				match(T__19);
				setState(285);
				flwrWhereCond(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(294);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new FlwrWhereCondContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_flwrWhereCond);
					setState(289);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(290);
					match(T__18);
					setState(291);
					flwrWhereCond(3);
					}
					} 
				}
				setState(296);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFlwrWhereCondSome(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFlwrWhereCondSome(this);
		}
	}

	public final FlwrWhereCondSomeContext flwrWhereCondSome() throws RecognitionException {
		FlwrWhereCondSomeContext _localctx = new FlwrWhereCondSomeContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_flwrWhereCondSome);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(297);
			match(T__20);
			setState(298);
			flwrWhereCondVar();
			setState(299);
			match(T__13);
			setState(300);
			flwrWhereCondAp();
			setState(308);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__7) {
				{
				{
				setState(301);
				match(T__7);
				setState(302);
				flwrWhereCondVar();
				setState(303);
				match(T__13);
				setState(304);
				flwrWhereCondAp();
				}
				}
				setState(310);
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
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public FlwrWhereCondVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flwrWhereCondVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFlwrWhereCondVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFlwrWhereCondVar(this);
		}
	}

	public final FlwrWhereCondVarContext flwrWhereCondVar() throws RecognitionException {
		FlwrWhereCondVarContext _localctx = new FlwrWhereCondVarContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_flwrWhereCondVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(311);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFlwrWhereCondAp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFlwrWhereCondAp(this);
		}
	}

	public final FlwrWhereCondApContext flwrWhereCondAp() throws RecognitionException {
		FlwrWhereCondApContext _localctx = new FlwrWhereCondApContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_flwrWhereCondAp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFlwrWhereCondEquality(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFlwrWhereCondEquality(this);
		}
	}

	public final FlwrWhereCondEqualityContext flwrWhereCondEquality() throws RecognitionException {
		FlwrWhereCondEqualityContext _localctx = new FlwrWhereCondEqualityContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_flwrWhereCondEquality);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315);
			flwrWhereCondEqualityLeftTerm();
			setState(316);
			match(T__0);
			setState(317);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFlwrWhereCondEqualityLeftTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFlwrWhereCondEqualityLeftTerm(this);
		}
	}

	public final FlwrWhereCondEqualityLeftTermContext flwrWhereCondEqualityLeftTerm() throws RecognitionException {
		FlwrWhereCondEqualityLeftTermContext _localctx = new FlwrWhereCondEqualityLeftTermContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_flwrWhereCondEqualityLeftTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFlwrWhereCondEqualityRightTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFlwrWhereCondEqualityRightTerm(this);
		}
	}

	public final FlwrWhereCondEqualityRightTermContext flwrWhereCondEqualityRightTerm() throws RecognitionException {
		FlwrWhereCondEqualityRightTermContext _localctx = new FlwrWhereCondEqualityRightTermContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_flwrWhereCondEqualityRightTerm);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(321);
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
		public CtermApContext ctermAp() {
			return getRuleContext(CtermApContext.class,0);
		}
		public CtermVarContext ctermVar() {
			return getRuleContext(CtermVarContext.class,0);
		}
		public CtermStringContext ctermString() {
			return getRuleContext(CtermStringContext.class,0);
		}
		public CtermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cterm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterCterm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitCterm(this);
		}
	}

	public final CtermContext cterm() throws RecognitionException {
		CtermContext _localctx = new CtermContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_cterm);
		try {
			setState(326);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(323);
				ctermAp();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(324);
				ctermVar();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(325);
				ctermString();
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterCtermAp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitCtermAp(this);
		}
	}

	public final CtermApContext ctermAp() throws RecognitionException {
		CtermApContext _localctx = new CtermApContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_ctermAp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
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
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public CtermVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ctermVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterCtermVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitCtermVar(this);
		}
	}

	public final CtermVarContext ctermVar() throws RecognitionException {
		CtermVarContext _localctx = new CtermVarContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_ctermVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterCtermString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitCtermString(this);
		}
	}

	public final CtermStringContext ctermString() throws RecognitionException {
		CtermStringContext _localctx = new CtermStringContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_ctermString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(332);
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
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public FlwrReturnVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flwrReturnVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFlwrReturnVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFlwrReturnVar(this);
		}
	}

	public final FlwrReturnVarContext flwrReturnVar() throws RecognitionException {
		FlwrReturnVarContext _localctx = new FlwrReturnVarContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_flwrReturnVar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFlwrReturnString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFlwrReturnString(this);
		}
	}

	public final FlwrReturnStringContext flwrReturnString() throws RecognitionException {
		FlwrReturnStringContext _localctx = new FlwrReturnStringContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_flwrReturnString);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(336);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterFlwrReturnConstruct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitFlwrReturnConstruct(this);
		}
	}

	public final FlwrReturnConstructContext flwrReturnConstruct() throws RecognitionException {
		FlwrReturnConstructContext _localctx = new FlwrReturnConstructContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_flwrReturnConstruct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
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
		public RpDotContext rpDot() {
			return getRuleContext(RpDotContext.class,0);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRp(this);
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
		int _startState = 86;
		enterRecursionRule(_localctx, 86, RULE_rp, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(341);
				rpTag();
				}
				break;
			case 2:
				{
				setState(342);
				rpAttr();
				}
				break;
			case 3:
				{
				setState(343);
				rpText();
				}
				break;
			case 4:
				{
				setState(344);
				rpDot();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(356);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new RpContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_rp);
					setState(347);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(350);
					switch (_input.LA(1)) {
					case T__21:
						{
						setState(348);
						child();
						}
						break;
					case T__22:
						{
						setState(349);
						desc();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(352);
					rp(2);
					}
					} 
				}
				setState(358);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterChild(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitChild(this);
		}
	}

	public final ChildContext child() throws RecognitionException {
		ChildContext _localctx = new ChildContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_child);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
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

	public static class DescContext extends ParserRuleContext {
		public DescContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_desc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterDesc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitDesc(this);
		}
	}

	public final DescContext desc() throws RecognitionException {
		DescContext _localctx = new DescContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_desc);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			match(T__22);
			}
		}
		catch (RecognitionException re) {
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRpTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRpTag(this);
		}
	}

	public final RpTagContext rpTag() throws RecognitionException {
		RpTagContext _localctx = new RpTagContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_rpTag);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRpAttr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRpAttr(this);
		}
	}

	public final RpAttrContext rpAttr() throws RecognitionException {
		RpAttrContext _localctx = new RpAttrContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_rpAttr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			tag();
			setState(366);
			match(T__23);
			setState(367);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRpText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRpText(this);
		}
	}

	public final RpTextContext rpText() throws RecognitionException {
		RpTextContext _localctx = new RpTextContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_rpText);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
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

	public static class RpDotContext extends ParserRuleContext {
		public RpDotContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rpDot; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterRpDot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitRpDot(this);
		}
	}

	public final RpDotContext rpDot() throws RecognitionException {
		RpDotContext _localctx = new RpDotContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_rpDot);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371);
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
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterAp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitAp(this);
		}
	}

	public final ApContext ap() throws RecognitionException {
		ApContext _localctx = new ApContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_ap);
		try {
			setState(388);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(373);
				document();
				setState(376);
				switch (_input.LA(1)) {
				case T__21:
					{
					setState(374);
					child();
					}
					break;
				case T__22:
					{
					setState(375);
					desc();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(378);
				rp(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(380);
				var();
				setState(383);
				switch (_input.LA(1)) {
				case T__21:
					{
					setState(381);
					child();
					}
					break;
				case T__22:
					{
					setState(382);
					desc();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(385);
				rp(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(387);
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
		public SourceContext source() {
			return getRuleContext(SourceContext.class,0);
		}
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitDocument(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_document);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(390);
			match(T__26);
			setState(391);
			source();
			setState(392);
			match(T__17);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode ALPHA() { return getToken(XQueryParser.ALPHA, 0); }
		public SourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_source; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitSource(this);
		}
	}

	public final SourceContext source() throws RecognitionException {
		SourceContext _localctx = new SourceContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_source);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			match(ALPHA);
			}
		}
		catch (RecognitionException re) {
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
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterApAttr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitApAttr(this);
		}
	}

	public final ApAttrContext apAttr() throws RecognitionException {
		ApAttrContext _localctx = new ApAttrContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_apAttr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
			var();
			setState(397);
			match(T__23);
			setState(398);
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
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).enterP(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof XQueryListener ) ((XQueryListener)listener).exitP(this);
		}
	}

	public final PContext p() throws RecognitionException {
		PContext _localctx = new PContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_p);
		try {
			setState(402);
			switch (_input.LA(1)) {
			case T__11:
			case T__26:
				enterOuterAlt(_localctx, 1);
				{
				setState(400);
				ap();
				}
				break;
			case T__24:
			case T__25:
			case ALPHA:
				enterOuterAlt(_localctx, 2);
				{
				setState(401);
				rp(0);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 29:
			return flwrWhereCond_sempred((FlwrWhereCondContext)_localctx, predIndex);
		case 43:
			return rp_sempred((RpContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean flwrWhereCond_sempred(FlwrWhereCondContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean rp_sempred(RpContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3 \u0197\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\5\2~\n\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\5\6\u008a\n\6\3\7\3\7\3\7\5\7\u008f\n\7\3\7\3\7\3\7\3\b\3\b\3\b\5\b"+
		"\u0097\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\5\t\u00a3\n\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\5\n\u00b1\n\n\3\n\3\n\3\n\3"+
		"\n\3\n\7\n\u00b8\n\n\f\n\16\n\u00bb\13\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\5\13\u00c6\n\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00d9\n\20\f\20\16\20\u00dc"+
		"\13\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\24"+
		"\3\24\3\24\5\24\u00ed\n\24\3\25\3\25\3\26\3\26\3\27\3\27\3\27\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u0102\n\31\f\31"+
		"\16\31\u0105\13\31\3\32\3\32\3\32\3\33\3\33\3\33\3\33\5\33\u010e\n\33"+
		"\3\34\3\34\5\34\u0112\n\34\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\3\37\3\37\3\37\3\37\5\37\u0122\n\37\3\37\3\37\3\37\7\37\u0127\n"+
		"\37\f\37\16\37\u012a\13\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \7 \u0135\n \f \16"+
		" \u0138\13 \3!\3!\3\"\3\"\3#\3#\3#\3#\3$\3$\3%\3%\3&\3&\3&\5&\u0149\n"+
		"&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3-\3-\3-\5-\u015c\n-\3-"+
		"\3-\3-\5-\u0161\n-\3-\3-\7-\u0165\n-\f-\16-\u0168\13-\3.\3.\3/\3/\3\60"+
		"\3\60\3\61\3\61\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\64\5\64\u017b"+
		"\n\64\3\64\3\64\3\64\3\64\3\64\5\64\u0182\n\64\3\64\3\64\3\64\5\64\u0187"+
		"\n\64\3\65\3\65\3\65\3\65\3\66\3\66\3\67\3\67\3\67\3\67\38\38\58\u0195"+
		"\n8\38\2\4<X9\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:<>@BDFHJLNPRTVXZ\\^`bdfhjln\2\2\u017f\2p\3\2\2\2\4\177\3\2\2\2\6"+
		"\u0081\3\2\2\2\b\u0083\3\2\2\2\n\u0089\3\2\2\2\f\u008b\3\2\2\2\16\u0093"+
		"\3\2\2\2\20\u009f\3\2\2\2\22\u00ad\3\2\2\2\24\u00c5\3\2\2\2\26\u00c7\3"+
		"\2\2\2\30\u00c9\3\2\2\2\32\u00cb\3\2\2\2\34\u00cd\3\2\2\2\36\u00cf\3\2"+
		"\2\2 \u00df\3\2\2\2\"\u00e1\3\2\2\2$\u00e5\3\2\2\2&\u00ec\3\2\2\2(\u00ee"+
		"\3\2\2\2*\u00f0\3\2\2\2,\u00f2\3\2\2\2.\u00f5\3\2\2\2\60\u00f8\3\2\2\2"+
		"\62\u0106\3\2\2\2\64\u0109\3\2\2\2\66\u010f\3\2\2\28\u0113\3\2\2\2:\u0115"+
		"\3\2\2\2<\u0121\3\2\2\2>\u012b\3\2\2\2@\u0139\3\2\2\2B\u013b\3\2\2\2D"+
		"\u013d\3\2\2\2F\u0141\3\2\2\2H\u0143\3\2\2\2J\u0148\3\2\2\2L\u014a\3\2"+
		"\2\2N\u014c\3\2\2\2P\u014e\3\2\2\2R\u0150\3\2\2\2T\u0152\3\2\2\2V\u0154"+
		"\3\2\2\2X\u015b\3\2\2\2Z\u0169\3\2\2\2\\\u016b\3\2\2\2^\u016d\3\2\2\2"+
		"`\u016f\3\2\2\2b\u0173\3\2\2\2d\u0175\3\2\2\2f\u0186\3\2\2\2h\u0188\3"+
		"\2\2\2j\u018c\3\2\2\2l\u018e\3\2\2\2n\u0194\3\2\2\2pq\5\4\3\2q}\7\3\2"+
		"\2r~\5.\30\2st\7\4\2\2tu\5\6\4\2uv\7\5\2\2vw\7\6\2\2wx\5.\30\2xy\7\7\2"+
		"\2yz\7\b\2\2z{\5\b\5\2{|\7\5\2\2|~\3\2\2\2}r\3\2\2\2}s\3\2\2\2~\3\3\2"+
		"\2\2\177\u0080\7\36\2\2\u0080\5\3\2\2\2\u0081\u0082\5\34\17\2\u0082\7"+
		"\3\2\2\2\u0083\u0084\5\34\17\2\u0084\t\3\2\2\2\u0085\u008a\5\f\7\2\u0086"+
		"\u008a\5\16\b\2\u0087\u008a\5\20\t\2\u0088\u008a\5\22\n\2\u0089\u0085"+
		"\3\2\2\2\u0089\u0086\3\2\2\2\u0089\u0087\3\2\2\2\u0089\u0088\3\2\2\2\u008a"+
		"\13\3\2\2\2\u008b\u008c\7\4\2\2\u008c\u008e\5\34\17\2\u008d\u008f\5\36"+
		"\20\2\u008e\u008d\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0090\3\2\2\2\u0090"+
		"\u0091\7\t\2\2\u0091\u0092\5\26\f\2\u0092\r\3\2\2\2\u0093\u0094\7\4\2"+
		"\2\u0094\u0096\5\34\17\2\u0095\u0097\5\36\20\2\u0096\u0095\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\7\5\2\2\u0099\u009a\5\26"+
		"\f\2\u009a\u009b\5\"\22\2\u009b\u009c\7\b\2\2\u009c\u009d\5\34\17\2\u009d"+
		"\u009e\7\5\2\2\u009e\17\3\2\2\2\u009f\u00a0\7\4\2\2\u00a0\u00a2\5\34\17"+
		"\2\u00a1\u00a3\5\36\20\2\u00a2\u00a1\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3"+
		"\u00a4\3\2\2\2\u00a4\u00a5\7\5\2\2\u00a5\u00a6\5\26\f\2\u00a6\u00a7\7"+
		"\6\2\2\u00a7\u00a8\5,\27\2\u00a8\u00a9\7\7\2\2\u00a9\u00aa\7\b\2\2\u00aa"+
		"\u00ab\5\34\17\2\u00ab\u00ac\7\5\2\2\u00ac\21\3\2\2\2\u00ad\u00ae\7\4"+
		"\2\2\u00ae\u00b0\5\30\r\2\u00af\u00b1\5\36\20\2\u00b0\u00af\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\u00b2\3\2\2\2\u00b2\u00b3\7\5\2\2\u00b3\u00b4\5\26"+
		"\f\2\u00b4\u00b9\5\24\13\2\u00b5\u00b6\7\n\2\2\u00b6\u00b8\5\24\13\2\u00b7"+
		"\u00b5\3\2\2\2\u00b8\u00bb\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2"+
		"\2\2\u00ba\u00bc\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00bd\7\b\2\2\u00bd"+
		"\u00be\5\32\16\2\u00be\u00bf\7\5\2\2\u00bf\23\3\2\2\2\u00c0\u00c1\7\6"+
		"\2\2\u00c1\u00c2\5.\30\2\u00c2\u00c3\7\7\2\2\u00c3\u00c6\3\2\2\2\u00c4"+
		"\u00c6\5\n\6\2\u00c5\u00c0\3\2\2\2\u00c5\u00c4\3\2\2\2\u00c6\25\3\2\2"+
		"\2\u00c7\u00c8\3\2\2\2\u00c8\27\3\2\2\2\u00c9\u00ca\5\34\17\2\u00ca\31"+
		"\3\2\2\2\u00cb\u00cc\5\34\17\2\u00cc\33\3\2\2\2\u00cd\u00ce\7\36\2\2\u00ce"+
		"\35\3\2\2\2\u00cf\u00d0\7\13\2\2\u00d0\u00d1\5 \21\2\u00d1\u00d2\7\3\2"+
		"\2\u00d2\u00da\5&\24\2\u00d3\u00d4\7\n\2\2\u00d4\u00d5\5 \21\2\u00d5\u00d6"+
		"\7\3\2\2\u00d6\u00d7\5&\24\2\u00d7\u00d9\3\2\2\2\u00d8\u00d3\3\2\2\2\u00d9"+
		"\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db\u00dd\3\2"+
		"\2\2\u00dc\u00da\3\2\2\2\u00dd\u00de\7\f\2\2\u00de\37\3\2\2\2\u00df\u00e0"+
		"\5$\23\2\u00e0!\3\2\2\2\u00e1\u00e2\7\r\2\2\u00e2\u00e3\7\36\2\2\u00e3"+
		"\u00e4\7\r\2\2\u00e4#\3\2\2\2\u00e5\u00e6\7\36\2\2\u00e6%\3\2\2\2\u00e7"+
		"\u00e8\7\6\2\2\u00e8\u00e9\5(\25\2\u00e9\u00ea\7\7\2\2\u00ea\u00ed\3\2"+
		"\2\2\u00eb\u00ed\5*\26\2\u00ec\u00e7\3\2\2\2\u00ec\u00eb\3\2\2\2\u00ed"+
		"\'\3\2\2\2\u00ee\u00ef\5,\27\2\u00ef)\3\2\2\2\u00f0\u00f1\5\"\22\2\u00f1"+
		"+\3\2\2\2\u00f2\u00f3\7\16\2\2\u00f3\u00f4\7\36\2\2\u00f4-\3\2\2\2\u00f5"+
		"\u00f6\5\66\34\2\u00f6\u00f7\5\64\33\2\u00f7/\3\2\2\2\u00f8\u00f9\7\17"+
		"\2\2\u00f9\u00fa\58\35\2\u00fa\u00fb\7\20\2\2\u00fb\u0103\5:\36\2\u00fc"+
		"\u00fd\7\n\2\2\u00fd\u00fe\58\35\2\u00fe\u00ff\7\20\2\2\u00ff\u0100\5"+
		":\36\2\u0100\u0102\3\2\2\2\u0101\u00fc\3\2\2\2\u0102\u0105\3\2\2\2\u0103"+
		"\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104\61\3\2\2\2\u0105\u0103\3\2\2"+
		"\2\u0106\u0107\7\21\2\2\u0107\u0108\5<\37\2\u0108\63\3\2\2\2\u0109\u010d"+
		"\7\22\2\2\u010a\u010e\5R*\2\u010b\u010e\5T+\2\u010c\u010e\5V,\2\u010d"+
		"\u010a\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010c\3\2\2\2\u010e\65\3\2\2"+
		"\2\u010f\u0111\5\60\31\2\u0110\u0112\5\62\32\2\u0111\u0110\3\2\2\2\u0111"+
		"\u0112\3\2\2\2\u0112\67\3\2\2\2\u0113\u0114\5,\27\2\u01149\3\2\2\2\u0115"+
		"\u0116\5n8\2\u0116;\3\2\2\2\u0117\u0118\b\37\1\2\u0118\u0122\5D#\2\u0119"+
		"\u011a\7\23\2\2\u011a\u011b\5<\37\2\u011b\u011c\7\24\2\2\u011c\u0122\3"+
		"\2\2\2\u011d\u011e\5> \2\u011e\u011f\7\26\2\2\u011f\u0120\5<\37\3\u0120"+
		"\u0122\3\2\2\2\u0121\u0117\3\2\2\2\u0121\u0119\3\2\2\2\u0121\u011d\3\2"+
		"\2\2\u0122\u0128\3\2\2\2\u0123\u0124\f\4\2\2\u0124\u0125\7\25\2\2\u0125"+
		"\u0127\5<\37\5\u0126\u0123\3\2\2\2\u0127\u012a\3\2\2\2\u0128\u0126\3\2"+
		"\2\2\u0128\u0129\3\2\2\2\u0129=\3\2\2\2\u012a\u0128\3\2\2\2\u012b\u012c"+
		"\7\27\2\2\u012c\u012d\5@!\2\u012d\u012e\7\20\2\2\u012e\u0136\5B\"\2\u012f"+
		"\u0130\7\n\2\2\u0130\u0131\5@!\2\u0131\u0132\7\20\2\2\u0132\u0133\5B\""+
		"\2\u0133\u0135\3\2\2\2\u0134\u012f\3\2\2\2\u0135\u0138\3\2\2\2\u0136\u0134"+
		"\3\2\2\2\u0136\u0137\3\2\2\2\u0137?\3\2\2\2\u0138\u0136\3\2\2\2\u0139"+
		"\u013a\5,\27\2\u013aA\3\2\2\2\u013b\u013c\5f\64\2\u013cC\3\2\2\2\u013d"+
		"\u013e\5F$\2\u013e\u013f\7\3\2\2\u013f\u0140\5H%\2\u0140E\3\2\2\2\u0141"+
		"\u0142\5J&\2\u0142G\3\2\2\2\u0143\u0144\5J&\2\u0144I\3\2\2\2\u0145\u0149"+
		"\5L\'\2\u0146\u0149\5N(\2\u0147\u0149\5P)\2\u0148\u0145\3\2\2\2\u0148"+
		"\u0146\3\2\2\2\u0148\u0147\3\2\2\2\u0149K\3\2\2\2\u014a\u014b\5f\64\2"+
		"\u014bM\3\2\2\2\u014c\u014d\5,\27\2\u014dO\3\2\2\2\u014e\u014f\5\"\22"+
		"\2\u014fQ\3\2\2\2\u0150\u0151\5,\27\2\u0151S\3\2\2\2\u0152\u0153\5\"\22"+
		"\2\u0153U\3\2\2\2\u0154\u0155\5\n\6\2\u0155W\3\2\2\2\u0156\u0157\b-\1"+
		"\2\u0157\u015c\5^\60\2\u0158\u015c\5`\61\2\u0159\u015c\5b\62\2\u015a\u015c"+
		"\5d\63\2\u015b\u0156\3\2\2\2\u015b\u0158\3\2\2\2\u015b\u0159\3\2\2\2\u015b"+
		"\u015a\3\2\2\2\u015c\u0166\3\2\2\2\u015d\u0160\f\3\2\2\u015e\u0161\5Z"+
		".\2\u015f\u0161\5\\/\2\u0160\u015e\3\2\2\2\u0160\u015f\3\2\2\2\u0161\u0162"+
		"\3\2\2\2\u0162\u0163\5X-\4\u0163\u0165\3\2\2\2\u0164\u015d\3\2\2\2\u0165"+
		"\u0168\3\2\2\2\u0166\u0164\3\2\2\2\u0166\u0167\3\2\2\2\u0167Y\3\2\2\2"+
		"\u0168\u0166\3\2\2\2\u0169\u016a\7\30\2\2\u016a[\3\2\2\2\u016b\u016c\7"+
		"\31\2\2\u016c]\3\2\2\2\u016d\u016e\5\34\17\2\u016e_\3\2\2\2\u016f\u0170"+
		"\5\34\17\2\u0170\u0171\7\32\2\2\u0171\u0172\5$\23\2\u0172a\3\2\2\2\u0173"+
		"\u0174\7\33\2\2\u0174c\3\2\2\2\u0175\u0176\7\34\2\2\u0176e\3\2\2\2\u0177"+
		"\u017a\5h\65\2\u0178\u017b\5Z.\2\u0179\u017b\5\\/\2\u017a\u0178\3\2\2"+
		"\2\u017a\u0179\3\2\2\2\u017b\u017c\3\2\2\2\u017c\u017d\5X-\2\u017d\u0187"+
		"\3\2\2\2\u017e\u0181\5,\27\2\u017f\u0182\5Z.\2\u0180\u0182\5\\/\2\u0181"+
		"\u017f\3\2\2\2\u0181\u0180\3\2\2\2\u0182\u0183\3\2\2\2\u0183\u0184\5X"+
		"-\2\u0184\u0187\3\2\2\2\u0185\u0187\5l\67\2\u0186\u0177\3\2\2\2\u0186"+
		"\u017e\3\2\2\2\u0186\u0185\3\2\2\2\u0187g\3\2\2\2\u0188\u0189\7\35\2\2"+
		"\u0189\u018a\5j\66\2\u018a\u018b\7\24\2\2\u018bi\3\2\2\2\u018c\u018d\7"+
		"\36\2\2\u018dk\3\2\2\2\u018e\u018f\5,\27\2\u018f\u0190\7\32\2\2\u0190"+
		"\u0191\5$\23\2\u0191m\3\2\2\2\u0192\u0195\5f\64\2\u0193\u0195\5X-\2\u0194"+
		"\u0192\3\2\2\2\u0194\u0193\3\2\2\2\u0195o\3\2\2\2\32}\u0089\u008e\u0096"+
		"\u00a2\u00b0\u00b9\u00c5\u00da\u00ec\u0103\u010d\u0111\u0121\u0128\u0136"+
		"\u0148\u015b\u0160\u0166\u017a\u0181\u0186\u0194";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}