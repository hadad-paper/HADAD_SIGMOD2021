// Generated from TFM.g4 by ANTLR 4.4

package hadad.base.compiler.model.tm;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class TFMParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__31=1, T__30=2, T__29=3, T__28=4, T__27=5, T__26=6, T__25=7, T__24=8, 
		T__23=9, T__22=10, T__21=11, T__20=12, T__19=13, T__18=14, T__17=15, T__16=16, 
		T__15=17, T__14=18, T__13=19, T__12=20, T__11=21, T__10=22, T__9=23, T__8=24, 
		T__7=25, T__6=26, T__5=27, T__4=28, T__3=29, T__2=30, T__1=31, T__0=32, 
		ID=33, WHITESPACE=34, STRING=35, INT=36, MATRIX=37, ROWS=38, COLS=39, 
		READ=40;
	public static final String[] tokenNames = {
		"<INVALID>", "'tf.norm('", "'tf.add('", "'tf.linalg.adjoint('", "'Graph()'", 
		"'tf.reduce_mean('", "'run'", "'{'", "'}'", "'='", "'tf.linalg.matrix_rank('", 
		"'('", "'placeholder'", "','", "'axis=0'", "'global_variables_initializer()'", 
		"'.'", "'tf.linalg.det('", "'import tensorflow as'", "'tf.matmul('", "'tf.divide('", 
		"'tf.math.matmul('", "'tf.linalg.diag('", "':'", "'tf.linalg.trace('", 
		"'tf.transpose('", "'tf.reduce_sum('", "'axis=1'", "'tf.linalg.inv('", 
		"'as_default()'", "')'", "'tf.math.scalar_mul('", "'Session()'", "ID", 
		"WHITESPACE", "STRING", "INT", "MATRIX", "ROWS", "COLS", "READ"
	};
	public static final int
		RULE_tfmQuery = 0, RULE_importstatement = 1, RULE_tfmScript = 2, RULE_tfmStatemnet = 3, 
		RULE_source = 4, RULE_tfmMatrixConstruction = 5, RULE_tfmMatrixConstructionMatrixSource = 6, 
		RULE_sesionRun = 7, RULE_load = 8, RULE_mName = 9, RULE_sep = 10, RULE_tfGraphInit = 11, 
		RULE_val = 12, RULE_shape = 13, RULE_keyVal = 14, RULE_pair = 15, RULE_withStatement = 16, 
		RULE_with = 17, RULE_gName = 18, RULE_as = 19, RULE_sess = 20, RULE_tfmExpression = 21, 
		RULE_viewName = 22, RULE_matrixName = 23, RULE_matrixNameExpression = 24, 
		RULE_numericScalar = 25, RULE_filePath = 26;
	public static final String[] ruleNames = {
		"tfmQuery", "importstatement", "tfmScript", "tfmStatemnet", "source", 
		"tfmMatrixConstruction", "tfmMatrixConstructionMatrixSource", "sesionRun", 
		"load", "mName", "sep", "tfGraphInit", "val", "shape", "keyVal", "pair", 
		"withStatement", "with", "gName", "as", "sess", "tfmExpression", "viewName", 
		"matrixName", "matrixNameExpression", "numericScalar", "filePath"
	};

	@Override
	public String getGrammarFileName() { return "TFM.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TFMParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class TfmQueryContext extends ParserRuleContext {
		public ViewNameContext viewName() {
			return getRuleContext(ViewNameContext.class,0);
		}
		public TfmScriptContext tfmScript() {
			return getRuleContext(TfmScriptContext.class,0);
		}
		public ImportstatementContext importstatement() {
			return getRuleContext(ImportstatementContext.class,0);
		}
		public TfmQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tfmQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterTfmQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitTfmQuery(this);
		}
	}

	public final TfmQueryContext tfmQuery() throws RecognitionException {
		TfmQueryContext _localctx = new TfmQueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_tfmQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54); viewName();
			setState(55); match(T__9);
			setState(56); importstatement();
			setState(57); tfmScript();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImportstatementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TFMParser.ID, 0); }
		public ImportstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterImportstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitImportstatement(this);
		}
	}

	public final ImportstatementContext importstatement() throws RecognitionException {
		ImportstatementContext _localctx = new ImportstatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_importstatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59); match(T__14);
			setState(60); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TfmScriptContext extends ParserRuleContext {
		public TfmStatemnetContext tfmStatemnet(int i) {
			return getRuleContext(TfmStatemnetContext.class,i);
		}
		public List<TfmStatemnetContext> tfmStatemnet() {
			return getRuleContexts(TfmStatemnetContext.class);
		}
		public TfmScriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tfmScript; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterTfmScript(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitTfmScript(this);
		}
	}

	public final TfmScriptContext tfmScript() throws RecognitionException {
		TfmScriptContext _localctx = new TfmScriptContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tfmScript);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62); tfmStatemnet();
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(63); tfmStatemnet();
				}
				}
				setState(68);
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

	public static class TfmStatemnetContext extends ParserRuleContext {
		public SourceContext source() {
			return getRuleContext(SourceContext.class,0);
		}
		public SesionRunContext sesionRun() {
			return getRuleContext(SesionRunContext.class,0);
		}
		public WithStatementContext withStatement() {
			return getRuleContext(WithStatementContext.class,0);
		}
		public MatrixNameContext matrixName() {
			return getRuleContext(MatrixNameContext.class,0);
		}
		public TfmStatemnetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tfmStatemnet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterTfmStatemnet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitTfmStatemnet(this);
		}
	}

	public final TfmStatemnetContext tfmStatemnet() throws RecognitionException {
		TfmStatemnetContext _localctx = new TfmStatemnetContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tfmStatemnet);
		try {
			setState(75);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(69); matrixName();
				setState(70); match(T__23);
				setState(71); source();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(73); withStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(74); sesionRun();
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

	public static class SourceContext extends ParserRuleContext {
		public TfmMatrixConstructionContext tfmMatrixConstruction() {
			return getRuleContext(TfmMatrixConstructionContext.class,0);
		}
		public TfmExpressionContext tfmExpression() {
			return getRuleContext(TfmExpressionContext.class,0);
		}
		public TfGraphInitContext tfGraphInit() {
			return getRuleContext(TfGraphInitContext.class,0);
		}
		public SourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_source; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitSource(this);
		}
	}

	public final SourceContext source() throws RecognitionException {
		SourceContext _localctx = new SourceContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_source);
		try {
			setState(80);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(77); tfmMatrixConstruction();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(78); tfmExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(79); tfGraphInit();
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

	public static class TfmMatrixConstructionContext extends ParserRuleContext {
		public TfmMatrixConstructionMatrixSourceContext tfmMatrixConstructionMatrixSource() {
			return getRuleContext(TfmMatrixConstructionMatrixSourceContext.class,0);
		}
		public TfmMatrixConstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tfmMatrixConstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterTfmMatrixConstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitTfmMatrixConstruction(this);
		}
	}

	public final TfmMatrixConstructionContext tfmMatrixConstruction() throws RecognitionException {
		TfmMatrixConstructionContext _localctx = new TfmMatrixConstructionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_tfmMatrixConstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82); tfmMatrixConstructionMatrixSource();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TfmMatrixConstructionMatrixSourceContext extends ParserRuleContext {
		public LoadContext load() {
			return getRuleContext(LoadContext.class,0);
		}
		public TfmMatrixConstructionMatrixSourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tfmMatrixConstructionMatrixSource; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterTfmMatrixConstructionMatrixSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitTfmMatrixConstructionMatrixSource(this);
		}
	}

	public final TfmMatrixConstructionMatrixSourceContext tfmMatrixConstructionMatrixSource() throws RecognitionException {
		TfmMatrixConstructionMatrixSourceContext _localctx = new TfmMatrixConstructionMatrixSourceContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_tfmMatrixConstructionMatrixSource);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84); load();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SesionRunContext extends ParserRuleContext {
		public List<KeyValContext> keyVal() {
			return getRuleContexts(KeyValContext.class);
		}
		public List<TerminalNode> ID() { return getTokens(TFMParser.ID); }
		public KeyValContext keyVal(int i) {
			return getRuleContext(KeyValContext.class,i);
		}
		public TerminalNode ID(int i) {
			return getToken(TFMParser.ID, i);
		}
		public SesionRunContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sesionRun; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterSesionRun(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitSesionRun(this);
		}
	}

	public final SesionRunContext sesionRun() throws RecognitionException {
		SesionRunContext _localctx = new SesionRunContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_sesionRun);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86); match(ID);
			setState(87); match(T__16);
			setState(88); match(T__26);
			setState(89); match(T__21);
			setState(90); match(ID);
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(91); match(T__19);
				setState(92); match(ID);
				setState(93); match(T__23);
				setState(94); keyVal();
				}
				}
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(100); match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LoadContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TFMParser.ID, 0); }
		public TerminalNode STRING() { return getToken(TFMParser.STRING, 0); }
		public MNameContext mName() {
			return getRuleContext(MNameContext.class,0);
		}
		public SepContext sep() {
			return getRuleContext(SepContext.class,0);
		}
		public LoadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_load; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterLoad(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitLoad(this);
		}
	}

	public final LoadContext load() throws RecognitionException {
		LoadContext _localctx = new LoadContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_load);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102); match(ID);
			setState(103); match(T__21);
			setState(104); mName();
			setState(105); match(T__19);
			setState(106); sep();
			setState(107); match(T__23);
			setState(108); match(STRING);
			setState(109); match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MNameContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(TFMParser.STRING, 0); }
		public MNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterMName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitMName(this);
		}
	}

	public final MNameContext mName() throws RecognitionException {
		MNameContext _localctx = new MNameContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_mName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111); match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SepContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TFMParser.ID, 0); }
		public SepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterSep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitSep(this);
		}
	}

	public final SepContext sep() throws RecognitionException {
		SepContext _localctx = new SepContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_sep);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TfGraphInitContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(TFMParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(TFMParser.ID, i);
		}
		public ValContext val() {
			return getRuleContext(ValContext.class,0);
		}
		public TfGraphInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tfGraphInit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterTfGraphInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitTfGraphInit(this);
		}
	}

	public final TfGraphInitContext tfGraphInit() throws RecognitionException {
		TfGraphInitContext _localctx = new TfGraphInitContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_tfGraphInit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115); match(ID);
			setState(116); match(T__16);
			setState(117);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__28) | (1L << T__20) | (1L << T__17))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(126);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(118); match(T__21);
				setState(119); match(ID);
				setState(120); match(T__19);
				setState(121); match(ID);
				setState(122); match(T__23);
				setState(123); val();
				setState(124); match(T__2);
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

	public static class ValContext extends ParserRuleContext {
		public ShapeContext shape() {
			return getRuleContext(ShapeContext.class,0);
		}
		public ValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_val; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitVal(this);
		}
	}

	public final ValContext val() throws RecognitionException {
		ValContext _localctx = new ValContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_val);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128); shape();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ShapeContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(TFMParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(TFMParser.ID, i);
		}
		public ShapeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shape; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterShape(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitShape(this);
		}
	}

	public final ShapeContext shape() throws RecognitionException {
		ShapeContext _localctx = new ShapeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_shape);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130); match(ID);
			setState(131); match(T__16);
			setState(132); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeyValContext extends ParserRuleContext {
		public PairContext pair(int i) {
			return getRuleContext(PairContext.class,i);
		}
		public List<PairContext> pair() {
			return getRuleContexts(PairContext.class);
		}
		public KeyValContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyVal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterKeyVal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitKeyVal(this);
		}
	}

	public final KeyValContext keyVal() throws RecognitionException {
		KeyValContext _localctx = new KeyValContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_keyVal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134); match(T__25);
			setState(135); pair();
			setState(140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__19) {
				{
				{
				setState(136); match(T__19);
				setState(137); pair();
				}
				}
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(143); match(T__24);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PairContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(TFMParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(TFMParser.ID, i);
		}
		public PairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterPair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitPair(this);
		}
	}

	public final PairContext pair() throws RecognitionException {
		PairContext _localctx = new PairContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_pair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145); match(ID);
			setState(146); match(T__9);
			setState(147); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WithStatementContext extends ParserRuleContext {
		public WithContext with() {
			return getRuleContext(WithContext.class,0);
		}
		public SessContext sess() {
			return getRuleContext(SessContext.class,0);
		}
		public GNameContext gName() {
			return getRuleContext(GNameContext.class,0);
		}
		public AsContext as() {
			return getRuleContext(AsContext.class,0);
		}
		public WithStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_withStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterWithStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitWithStatement(this);
		}
	}

	public final WithStatementContext withStatement() throws RecognitionException {
		WithStatementContext _localctx = new WithStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_withStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149); with();
			setState(150); gName();
			setState(151); match(T__16);
			setState(152);
			_la = _input.LA(1);
			if ( !(_la==T__3 || _la==T__0) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(156);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(153); as();
				setState(154); sess();
				}
			}

			setState(158); match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class WithContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TFMParser.ID, 0); }
		public WithContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_with; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterWith(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitWith(this);
		}
	}

	public final WithContext with() throws RecognitionException {
		WithContext _localctx = new WithContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_with);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class GNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TFMParser.ID, 0); }
		public GNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterGName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitGName(this);
		}
	}

	public final GNameContext gName() throws RecognitionException {
		GNameContext _localctx = new GNameContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_gName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AsContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TFMParser.ID, 0); }
		public AsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_as; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterAs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitAs(this);
		}
	}

	public final AsContext as() throws RecognitionException {
		AsContext _localctx = new AsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_as);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SessContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TFMParser.ID, 0); }
		public SessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterSess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitSess(this);
		}
	}

	public final SessContext sess() throws RecognitionException {
		SessContext _localctx = new SessContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_sess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TfmExpressionContext extends ParserRuleContext {
		public TfmExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tfmExpression; }
	 
		public TfmExpressionContext() { }
		public void copyFrom(TfmExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class MatrixAdjointExpressionContext extends TfmExpressionContext {
		public TfmExpressionContext tfmExpression() {
			return getRuleContext(TfmExpressionContext.class,0);
		}
		public MatrixAdjointExpressionContext(TfmExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterMatrixAdjointExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitMatrixAdjointExpression(this);
		}
	}
	public static class MatrixNormExpressionContext extends TfmExpressionContext {
		public TfmExpressionContext tfmExpression() {
			return getRuleContext(TfmExpressionContext.class,0);
		}
		public MatrixNormExpressionContext(TfmExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterMatrixNormExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitMatrixNormExpression(this);
		}
	}
	public static class ColumnsSumExperssionContext extends TfmExpressionContext {
		public Token op;
		public TfmExpressionContext tfmExpression() {
			return getRuleContext(TfmExpressionContext.class,0);
		}
		public ColumnsSumExperssionContext(TfmExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterColumnsSumExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitColumnsSumExperssion(this);
		}
	}
	public static class MatrixIdentifierContext extends TfmExpressionContext {
		public MatrixNameExpressionContext matrixNameExpression() {
			return getRuleContext(MatrixNameExpressionContext.class,0);
		}
		public MatrixIdentifierContext(TfmExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterMatrixIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitMatrixIdentifier(this);
		}
	}
	public static class MatrixAddExpressionContext extends TfmExpressionContext {
		public TfmExpressionContext left;
		public Token op;
		public TfmExpressionContext right;
		public TfmExpressionContext tfmExpression(int i) {
			return getRuleContext(TfmExpressionContext.class,i);
		}
		public List<TfmExpressionContext> tfmExpression() {
			return getRuleContexts(TfmExpressionContext.class);
		}
		public MatrixAddExpressionContext(TfmExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterMatrixAddExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitMatrixAddExpression(this);
		}
	}
	public static class MatrixMulElementwiseExpressionContext extends TfmExpressionContext {
		public TfmExpressionContext left;
		public Token op;
		public TfmExpressionContext right;
		public TfmExpressionContext tfmExpression(int i) {
			return getRuleContext(TfmExpressionContext.class,i);
		}
		public List<TfmExpressionContext> tfmExpression() {
			return getRuleContexts(TfmExpressionContext.class);
		}
		public MatrixMulElementwiseExpressionContext(TfmExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterMatrixMulElementwiseExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitMatrixMulElementwiseExpression(this);
		}
	}
	public static class MatrixDiagonalExpressionContext extends TfmExpressionContext {
		public TfmExpressionContext tfmExpression() {
			return getRuleContext(TfmExpressionContext.class,0);
		}
		public MatrixDiagonalExpressionContext(TfmExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterMatrixDiagonalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitMatrixDiagonalExpression(this);
		}
	}
	public static class RowsSumExperssionContext extends TfmExpressionContext {
		public Token op;
		public TfmExpressionContext tfmExpression() {
			return getRuleContext(TfmExpressionContext.class,0);
		}
		public RowsSumExperssionContext(TfmExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterRowsSumExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitRowsSumExperssion(this);
		}
	}
	public static class MatrixDetExpressionContext extends TfmExpressionContext {
		public TfmExpressionContext tfmExpression() {
			return getRuleContext(TfmExpressionContext.class,0);
		}
		public MatrixDetExpressionContext(TfmExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterMatrixDetExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitMatrixDetExpression(this);
		}
	}
	public static class MatrixMulExpressionContext extends TfmExpressionContext {
		public TfmExpressionContext left;
		public Token op;
		public TfmExpressionContext right;
		public TfmExpressionContext tfmExpression(int i) {
			return getRuleContext(TfmExpressionContext.class,i);
		}
		public List<TfmExpressionContext> tfmExpression() {
			return getRuleContexts(TfmExpressionContext.class);
		}
		public MatrixMulExpressionContext(TfmExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterMatrixMulExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitMatrixMulExpression(this);
		}
	}
	public static class MatrixDivisionContext extends TfmExpressionContext {
		public TfmExpressionContext left;
		public Token op;
		public TfmExpressionContext right;
		public TfmExpressionContext tfmExpression(int i) {
			return getRuleContext(TfmExpressionContext.class,i);
		}
		public List<TfmExpressionContext> tfmExpression() {
			return getRuleContexts(TfmExpressionContext.class);
		}
		public MatrixDivisionContext(TfmExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterMatrixDivision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitMatrixDivision(this);
		}
	}
	public static class MatrixTraceExpressionContext extends TfmExpressionContext {
		public TfmExpressionContext tfmExpression() {
			return getRuleContext(TfmExpressionContext.class,0);
		}
		public MatrixTraceExpressionContext(TfmExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterMatrixTraceExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitMatrixTraceExpression(this);
		}
	}
	public static class MeanExpressionContext extends TfmExpressionContext {
		public TfmExpressionContext tfmExpression() {
			return getRuleContext(TfmExpressionContext.class,0);
		}
		public MeanExpressionContext(TfmExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterMeanExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitMeanExpression(this);
		}
	}
	public static class MatrixTransposeExpressionContext extends TfmExpressionContext {
		public TfmExpressionContext tfmExpression() {
			return getRuleContext(TfmExpressionContext.class,0);
		}
		public MatrixTransposeExpressionContext(TfmExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterMatrixTransposeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitMatrixTransposeExpression(this);
		}
	}
	public static class MatrixRankExpressionContext extends TfmExpressionContext {
		public TfmExpressionContext tfmExpression() {
			return getRuleContext(TfmExpressionContext.class,0);
		}
		public MatrixRankExpressionContext(TfmExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterMatrixRankExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitMatrixRankExpression(this);
		}
	}
	public static class MatrixMulScalarExpressionContext extends TfmExpressionContext {
		public NumericScalarContext left;
		public Token op;
		public TfmExpressionContext right;
		public TfmExpressionContext tfmExpression() {
			return getRuleContext(TfmExpressionContext.class,0);
		}
		public NumericScalarContext numericScalar() {
			return getRuleContext(NumericScalarContext.class,0);
		}
		public MatrixMulScalarExpressionContext(TfmExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterMatrixMulScalarExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitMatrixMulScalarExpression(this);
		}
	}
	public static class MatrixInvExpressionContext extends TfmExpressionContext {
		public TfmExpressionContext tfmExpression() {
			return getRuleContext(TfmExpressionContext.class,0);
		}
		public MatrixInvExpressionContext(TfmExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterMatrixInvExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitMatrixInvExpression(this);
		}
	}
	public static class SumExperssionContext extends TfmExpressionContext {
		public TfmExpressionContext tfmExpression() {
			return getRuleContext(TfmExpressionContext.class,0);
		}
		public SumExperssionContext(TfmExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterSumExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitSumExperssion(this);
		}
	}

	public final TfmExpressionContext tfmExpression() throws RecognitionException {
		TfmExpressionContext _localctx = new TfmExpressionContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_tfmExpression);
		try {
			setState(251);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				_localctx = new MatrixIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(168); matrixNameExpression();
				}
				break;
			case 2:
				_localctx = new MatrixMulExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(169); match(T__13);
				setState(170); ((MatrixMulExpressionContext)_localctx).left = tfmExpression();
				setState(171); ((MatrixMulExpressionContext)_localctx).op = match(T__19);
				setState(172); ((MatrixMulExpressionContext)_localctx).right = tfmExpression();
				setState(173); match(T__2);
				}
				break;
			case 3:
				_localctx = new MatrixMulElementwiseExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(175); match(T__11);
				setState(176); ((MatrixMulElementwiseExpressionContext)_localctx).left = tfmExpression();
				setState(177); ((MatrixMulElementwiseExpressionContext)_localctx).op = match(T__19);
				setState(178); ((MatrixMulElementwiseExpressionContext)_localctx).right = tfmExpression();
				setState(179); match(T__2);
				}
				break;
			case 4:
				_localctx = new MatrixMulScalarExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(181); match(T__1);
				setState(182); ((MatrixMulScalarExpressionContext)_localctx).left = numericScalar();
				setState(183); ((MatrixMulScalarExpressionContext)_localctx).op = match(T__19);
				setState(184); ((MatrixMulScalarExpressionContext)_localctx).right = tfmExpression();
				setState(185); match(T__2);
				}
				break;
			case 5:
				_localctx = new MatrixAddExpressionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(187); match(T__30);
				setState(188); ((MatrixAddExpressionContext)_localctx).left = tfmExpression();
				setState(189); ((MatrixAddExpressionContext)_localctx).op = match(T__19);
				setState(190); ((MatrixAddExpressionContext)_localctx).right = tfmExpression();
				setState(191); match(T__2);
				}
				break;
			case 6:
				_localctx = new MatrixDivisionContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(193); match(T__12);
				setState(194); ((MatrixDivisionContext)_localctx).left = tfmExpression();
				setState(195); ((MatrixDivisionContext)_localctx).op = match(T__19);
				setState(196); ((MatrixDivisionContext)_localctx).right = tfmExpression();
				setState(197); match(T__2);
				}
				break;
			case 7:
				_localctx = new MatrixTransposeExpressionContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(199); match(T__7);
				setState(200); tfmExpression();
				setState(201); match(T__2);
				}
				break;
			case 8:
				_localctx = new MatrixTraceExpressionContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(203); match(T__8);
				setState(204); tfmExpression();
				setState(205); match(T__2);
				}
				break;
			case 9:
				_localctx = new MatrixDiagonalExpressionContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(207); match(T__10);
				setState(208); tfmExpression();
				setState(209); match(T__2);
				}
				break;
			case 10:
				_localctx = new MatrixAdjointExpressionContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(211); match(T__29);
				setState(212); tfmExpression();
				setState(213); match(T__2);
				}
				break;
			case 11:
				_localctx = new MatrixDetExpressionContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(215); match(T__15);
				setState(216); tfmExpression();
				setState(217); match(T__2);
				}
				break;
			case 12:
				_localctx = new MatrixInvExpressionContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(219); match(T__4);
				setState(220); tfmExpression();
				setState(221); match(T__2);
				}
				break;
			case 13:
				_localctx = new MatrixRankExpressionContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(223); match(T__22);
				setState(224); tfmExpression();
				setState(225); match(T__2);
				}
				break;
			case 14:
				_localctx = new MatrixNormExpressionContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(227); match(T__31);
				setState(228); tfmExpression();
				setState(229); match(T__2);
				}
				break;
			case 15:
				_localctx = new MeanExpressionContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(231); match(T__27);
				setState(232); tfmExpression();
				setState(233); match(T__2);
				}
				break;
			case 16:
				_localctx = new ColumnsSumExperssionContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(235); match(T__6);
				setState(236); tfmExpression();
				setState(237); ((ColumnsSumExperssionContext)_localctx).op = match(T__19);
				setState(238); ((ColumnsSumExperssionContext)_localctx).op = match(T__18);
				setState(239); match(T__2);
				}
				break;
			case 17:
				_localctx = new RowsSumExperssionContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(241); match(T__6);
				setState(242); tfmExpression();
				setState(243); ((RowsSumExperssionContext)_localctx).op = match(T__19);
				setState(244); ((RowsSumExperssionContext)_localctx).op = match(T__5);
				setState(245); match(T__2);
				}
				break;
			case 18:
				_localctx = new SumExperssionContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(247); match(T__6);
				setState(248); tfmExpression();
				setState(249); match(T__2);
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

	public static class ViewNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TFMParser.ID, 0); }
		public ViewNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_viewName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterViewName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitViewName(this);
		}
	}

	public final ViewNameContext viewName() throws RecognitionException {
		ViewNameContext _localctx = new ViewNameContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_viewName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(253); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MatrixNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TFMParser.ID, 0); }
		public MatrixNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrixName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterMatrixName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitMatrixName(this);
		}
	}

	public final MatrixNameContext matrixName() throws RecognitionException {
		MatrixNameContext _localctx = new MatrixNameContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_matrixName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(255); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MatrixNameExpressionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(TFMParser.ID, 0); }
		public MatrixNameExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrixNameExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterMatrixNameExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitMatrixNameExpression(this);
		}
	}

	public final MatrixNameExpressionContext matrixNameExpression() throws RecognitionException {
		MatrixNameExpressionContext _localctx = new MatrixNameExpressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_matrixNameExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumericScalarContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(TFMParser.INT, 0); }
		public NumericScalarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericScalar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterNumericScalar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitNumericScalar(this);
		}
	}

	public final NumericScalarContext numericScalar() throws RecognitionException {
		NumericScalarContext _localctx = new NumericScalarContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_numericScalar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(259); match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FilePathContext extends ParserRuleContext {
		public TerminalNode STRING() { return getToken(TFMParser.STRING, 0); }
		public FilePathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filePath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).enterFilePath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TFMListener ) ((TFMListener)listener).exitFilePath(this);
		}
	}

	public final FilePathContext filePath() throws RecognitionException {
		FilePathContext _localctx = new FilePathContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_filePath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261); match(STRING);
			}
		}
		catch (RecognitionException re) {
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3*\u010a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4"+
		"\7\4C\n\4\f\4\16\4F\13\4\3\5\3\5\3\5\3\5\3\5\3\5\5\5N\n\5\3\6\3\6\3\6"+
		"\5\6S\n\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\tb\n\t"+
		"\f\t\16\te\13\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0081\n\r\3\16"+
		"\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\7\20\u008d\n\20\f\20\16"+
		"\20\u0090\13\20\3\20\3\20\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\5\22\u009f\n\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\5\27\u00fe\n\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34"+
		"\2\2\35\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66\2"+
		"\4\5\2\6\6\16\16\21\21\4\2\37\37\"\"\u0108\28\3\2\2\2\4=\3\2\2\2\6@\3"+
		"\2\2\2\bM\3\2\2\2\nR\3\2\2\2\fT\3\2\2\2\16V\3\2\2\2\20X\3\2\2\2\22h\3"+
		"\2\2\2\24q\3\2\2\2\26s\3\2\2\2\30u\3\2\2\2\32\u0082\3\2\2\2\34\u0084\3"+
		"\2\2\2\36\u0088\3\2\2\2 \u0093\3\2\2\2\"\u0097\3\2\2\2$\u00a2\3\2\2\2"+
		"&\u00a4\3\2\2\2(\u00a6\3\2\2\2*\u00a8\3\2\2\2,\u00fd\3\2\2\2.\u00ff\3"+
		"\2\2\2\60\u0101\3\2\2\2\62\u0103\3\2\2\2\64\u0105\3\2\2\2\66\u0107\3\2"+
		"\2\289\5.\30\29:\7\31\2\2:;\5\4\3\2;<\5\6\4\2<\3\3\2\2\2=>\7\24\2\2>?"+
		"\7#\2\2?\5\3\2\2\2@D\5\b\5\2AC\5\b\5\2BA\3\2\2\2CF\3\2\2\2DB\3\2\2\2D"+
		"E\3\2\2\2E\7\3\2\2\2FD\3\2\2\2GH\5\60\31\2HI\7\13\2\2IJ\5\n\6\2JN\3\2"+
		"\2\2KN\5\"\22\2LN\5\20\t\2MG\3\2\2\2MK\3\2\2\2ML\3\2\2\2N\t\3\2\2\2OS"+
		"\5\f\7\2PS\5,\27\2QS\5\30\r\2RO\3\2\2\2RP\3\2\2\2RQ\3\2\2\2S\13\3\2\2"+
		"\2TU\5\16\b\2U\r\3\2\2\2VW\5\22\n\2W\17\3\2\2\2XY\7#\2\2YZ\7\22\2\2Z["+
		"\7\b\2\2[\\\7\r\2\2\\c\7#\2\2]^\7\17\2\2^_\7#\2\2_`\7\13\2\2`b\5\36\20"+
		"\2a]\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2df\3\2\2\2ec\3\2\2\2fg\7 \2"+
		"\2g\21\3\2\2\2hi\7#\2\2ij\7\r\2\2jk\5\24\13\2kl\7\17\2\2lm\5\26\f\2mn"+
		"\7\13\2\2no\7%\2\2op\7 \2\2p\23\3\2\2\2qr\7%\2\2r\25\3\2\2\2st\7#\2\2"+
		"t\27\3\2\2\2uv\7#\2\2vw\7\22\2\2w\u0080\t\2\2\2xy\7\r\2\2yz\7#\2\2z{\7"+
		"\17\2\2{|\7#\2\2|}\7\13\2\2}~\5\32\16\2~\177\7 \2\2\177\u0081\3\2\2\2"+
		"\u0080x\3\2\2\2\u0080\u0081\3\2\2\2\u0081\31\3\2\2\2\u0082\u0083\5\34"+
		"\17\2\u0083\33\3\2\2\2\u0084\u0085\7#\2\2\u0085\u0086\7\22\2\2\u0086\u0087"+
		"\7#\2\2\u0087\35\3\2\2\2\u0088\u0089\7\t\2\2\u0089\u008e\5 \21\2\u008a"+
		"\u008b\7\17\2\2\u008b\u008d\5 \21\2\u008c\u008a\3\2\2\2\u008d\u0090\3"+
		"\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090"+
		"\u008e\3\2\2\2\u0091\u0092\7\n\2\2\u0092\37\3\2\2\2\u0093\u0094\7#\2\2"+
		"\u0094\u0095\7\31\2\2\u0095\u0096\7#\2\2\u0096!\3\2\2\2\u0097\u0098\5"+
		"$\23\2\u0098\u0099\5&\24\2\u0099\u009a\7\22\2\2\u009a\u009e\t\3\2\2\u009b"+
		"\u009c\5(\25\2\u009c\u009d\5*\26\2\u009d\u009f\3\2\2\2\u009e\u009b\3\2"+
		"\2\2\u009e\u009f\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a1\7\31\2\2\u00a1"+
		"#\3\2\2\2\u00a2\u00a3\7#\2\2\u00a3%\3\2\2\2\u00a4\u00a5\7#\2\2\u00a5\'"+
		"\3\2\2\2\u00a6\u00a7\7#\2\2\u00a7)\3\2\2\2\u00a8\u00a9\7#\2\2\u00a9+\3"+
		"\2\2\2\u00aa\u00fe\5\62\32\2\u00ab\u00ac\7\25\2\2\u00ac\u00ad\5,\27\2"+
		"\u00ad\u00ae\7\17\2\2\u00ae\u00af\5,\27\2\u00af\u00b0\7 \2\2\u00b0\u00fe"+
		"\3\2\2\2\u00b1\u00b2\7\27\2\2\u00b2\u00b3\5,\27\2\u00b3\u00b4\7\17\2\2"+
		"\u00b4\u00b5\5,\27\2\u00b5\u00b6\7 \2\2\u00b6\u00fe\3\2\2\2\u00b7\u00b8"+
		"\7!\2\2\u00b8\u00b9\5\64\33\2\u00b9\u00ba\7\17\2\2\u00ba\u00bb\5,\27\2"+
		"\u00bb\u00bc\7 \2\2\u00bc\u00fe\3\2\2\2\u00bd\u00be\7\4\2\2\u00be\u00bf"+
		"\5,\27\2\u00bf\u00c0\7\17\2\2\u00c0\u00c1\5,\27\2\u00c1\u00c2\7 \2\2\u00c2"+
		"\u00fe\3\2\2\2\u00c3\u00c4\7\26\2\2\u00c4\u00c5\5,\27\2\u00c5\u00c6\7"+
		"\17\2\2\u00c6\u00c7\5,\27\2\u00c7\u00c8\7 \2\2\u00c8\u00fe\3\2\2\2\u00c9"+
		"\u00ca\7\33\2\2\u00ca\u00cb\5,\27\2\u00cb\u00cc\7 \2\2\u00cc\u00fe\3\2"+
		"\2\2\u00cd\u00ce\7\32\2\2\u00ce\u00cf\5,\27\2\u00cf\u00d0\7 \2\2\u00d0"+
		"\u00fe\3\2\2\2\u00d1\u00d2\7\30\2\2\u00d2\u00d3\5,\27\2\u00d3\u00d4\7"+
		" \2\2\u00d4\u00fe\3\2\2\2\u00d5\u00d6\7\5\2\2\u00d6\u00d7\5,\27\2\u00d7"+
		"\u00d8\7 \2\2\u00d8\u00fe\3\2\2\2\u00d9\u00da\7\23\2\2\u00da\u00db\5,"+
		"\27\2\u00db\u00dc\7 \2\2\u00dc\u00fe\3\2\2\2\u00dd\u00de\7\36\2\2\u00de"+
		"\u00df\5,\27\2\u00df\u00e0\7 \2\2\u00e0\u00fe\3\2\2\2\u00e1\u00e2\7\f"+
		"\2\2\u00e2\u00e3\5,\27\2\u00e3\u00e4\7 \2\2\u00e4\u00fe\3\2\2\2\u00e5"+
		"\u00e6\7\3\2\2\u00e6\u00e7\5,\27\2\u00e7\u00e8\7 \2\2\u00e8\u00fe\3\2"+
		"\2\2\u00e9\u00ea\7\7\2\2\u00ea\u00eb\5,\27\2\u00eb\u00ec\7 \2\2\u00ec"+
		"\u00fe\3\2\2\2\u00ed\u00ee\7\34\2\2\u00ee\u00ef\5,\27\2\u00ef\u00f0\7"+
		"\17\2\2\u00f0\u00f1\7\20\2\2\u00f1\u00f2\7 \2\2\u00f2\u00fe\3\2\2\2\u00f3"+
		"\u00f4\7\34\2\2\u00f4\u00f5\5,\27\2\u00f5\u00f6\7\17\2\2\u00f6\u00f7\7"+
		"\35\2\2\u00f7\u00f8\7 \2\2\u00f8\u00fe\3\2\2\2\u00f9\u00fa\7\34\2\2\u00fa"+
		"\u00fb\5,\27\2\u00fb\u00fc\7 \2\2\u00fc\u00fe\3\2\2\2\u00fd\u00aa\3\2"+
		"\2\2\u00fd\u00ab\3\2\2\2\u00fd\u00b1\3\2\2\2\u00fd\u00b7\3\2\2\2\u00fd"+
		"\u00bd\3\2\2\2\u00fd\u00c3\3\2\2\2\u00fd\u00c9\3\2\2\2\u00fd\u00cd\3\2"+
		"\2\2\u00fd\u00d1\3\2\2\2\u00fd\u00d5\3\2\2\2\u00fd\u00d9\3\2\2\2\u00fd"+
		"\u00dd\3\2\2\2\u00fd\u00e1\3\2\2\2\u00fd\u00e5\3\2\2\2\u00fd\u00e9\3\2"+
		"\2\2\u00fd\u00ed\3\2\2\2\u00fd\u00f3\3\2\2\2\u00fd\u00f9\3\2\2\2\u00fe"+
		"-\3\2\2\2\u00ff\u0100\7#\2\2\u0100/\3\2\2\2\u0101\u0102\7#\2\2\u0102\61"+
		"\3\2\2\2\u0103\u0104\7#\2\2\u0104\63\3\2\2\2\u0105\u0106\7&\2\2\u0106"+
		"\65\3\2\2\2\u0107\u0108\7%\2\2\u0108\67\3\2\2\2\nDMRc\u0080\u008e\u009e"+
		"\u00fd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}