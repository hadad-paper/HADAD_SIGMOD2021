// Generated from R.g4 by ANTLR 4.4

package hadad.base.compiler.model.rm;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class RParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__46=1, T__45=2, T__44=3, T__43=4, T__42=5, T__41=6, T__40=7, T__39=8, 
		T__38=9, T__37=10, T__36=11, T__35=12, T__34=13, T__33=14, T__32=15, T__31=16, 
		T__30=17, T__29=18, T__28=19, T__27=20, T__26=21, T__25=22, T__24=23, 
		T__23=24, T__22=25, T__21=26, T__20=27, T__19=28, T__18=29, T__17=30, 
		T__16=31, T__15=32, T__14=33, T__13=34, T__12=35, T__11=36, T__10=37, 
		T__9=38, T__8=39, T__7=40, T__6=41, T__5=42, T__4=43, T__3=44, T__2=45, 
		T__1=46, T__0=47, ID=48, WHITESPACE=49, STRING=50, INT=51, MATRIX=52, 
		ROWS=53, COLS=54, READ=55, FALSE=56, TRUE=57;
	public static final String[] tokenNames = {
		"<INVALID>", "'t('", "'/'", "'rowMeans('", "'diag('", "'cumprod('", "'mean('", 
		"'solve('", "'colMaxs('", "'cummin('", "'rowSds('", "'det('", "'colVars('", 
		"'||'", "';'", "'colMins('", "'&&'", "'='", "'^'", "'rowSums('", "'sd('", 
		"'colSds('", "'&'", "'var('", "'('", "'*'", "','", "'rowMins('", "'.'", 
		"'<-'", "'sum('", "'%*%'", "'colMeans('", "'FALSE'", "':'", "'cumsum('", 
		"'trace('", "'|'", "'avg('", "'colSums('", "'cummax('", "')'", "'rowMaxs('", 
		"'%/%'", "'+'", "'-'", "'TRUE'", "'rowVars('", "ID", "WHITESPACE", "STRING", 
		"INT", "MATRIX", "ROWS", "COLS", "READ", "FALSE", "TRUE"
	};
	public static final int
		RULE_rQuery = 0, RULE_rScript = 1, RULE_rStatemnet = 2, RULE_source = 3, 
		RULE_rMatrixConstruction = 4, RULE_rMatrixConstructionMatrixSource = 5, 
		RULE_asMatrix = 6, RULE_asTable = 7, RULE_mName = 8, RULE_header = 9, 
		RULE_flag = 10, RULE_sep = 11, RULE_readMM = 12, RULE_rExpression = 13, 
		RULE_viewName = 14, RULE_matrixName = 15, RULE_matrixNameExpression = 16, 
		RULE_numericScalar = 17, RULE_filePath = 18;
	public static final String[] ruleNames = {
		"rQuery", "rScript", "rStatemnet", "source", "rMatrixConstruction", "rMatrixConstructionMatrixSource", 
		"asMatrix", "asTable", "mName", "header", "flag", "sep", "readMM", "rExpression", 
		"viewName", "matrixName", "matrixNameExpression", "numericScalar", "filePath"
	};

	@Override
	public String getGrammarFileName() { return "R.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public RParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class RQueryContext extends ParserRuleContext {
		public ViewNameContext viewName() {
			return getRuleContext(ViewNameContext.class,0);
		}
		public RScriptContext rScript() {
			return getRuleContext(RScriptContext.class,0);
		}
		public RQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterRQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitRQuery(this);
		}
	}

	public final RQueryContext rQuery() throws RecognitionException {
		RQueryContext _localctx = new RQueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_rQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38); viewName();
			setState(39); match(T__13);
			setState(40); rScript();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RScriptContext extends ParserRuleContext {
		public RStatemnetContext rStatemnet(int i) {
			return getRuleContext(RStatemnetContext.class,i);
		}
		public List<RStatemnetContext> rStatemnet() {
			return getRuleContexts(RStatemnetContext.class);
		}
		public RScriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rScript; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterRScript(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitRScript(this);
		}
	}

	public final RScriptContext rScript() throws RecognitionException {
		RScriptContext _localctx = new RScriptContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_rScript);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42); rStatemnet();
			setState(43); match(T__33);
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(44); rStatemnet();
				setState(45); match(T__33);
				}
				}
				setState(51);
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

	public static class RStatemnetContext extends ParserRuleContext {
		public SourceContext source() {
			return getRuleContext(SourceContext.class,0);
		}
		public MatrixNameContext matrixName() {
			return getRuleContext(MatrixNameContext.class,0);
		}
		public RStatemnetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rStatemnet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterRStatemnet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitRStatemnet(this);
		}
	}

	public final RStatemnetContext rStatemnet() throws RecognitionException {
		RStatemnetContext _localctx = new RStatemnetContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_rStatemnet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52); matrixName();
			setState(53); match(T__18);
			setState(54); source();
			}
		}
		catch (RecognitionException re) {
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
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public RMatrixConstructionContext rMatrixConstruction() {
			return getRuleContext(RMatrixConstructionContext.class,0);
		}
		public SourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_source; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitSource(this);
		}
	}

	public final SourceContext source() throws RecognitionException {
		SourceContext _localctx = new SourceContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_source);
		try {
			setState(58);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(56); rMatrixConstruction();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(57); rExpression(0);
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

	public static class RMatrixConstructionContext extends ParserRuleContext {
		public RMatrixConstructionMatrixSourceContext rMatrixConstructionMatrixSource() {
			return getRuleContext(RMatrixConstructionMatrixSourceContext.class,0);
		}
		public RMatrixConstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rMatrixConstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterRMatrixConstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitRMatrixConstruction(this);
		}
	}

	public final RMatrixConstructionContext rMatrixConstruction() throws RecognitionException {
		RMatrixConstructionContext _localctx = new RMatrixConstructionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_rMatrixConstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60); rMatrixConstructionMatrixSource();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RMatrixConstructionMatrixSourceContext extends ParserRuleContext {
		public AsMatrixContext asMatrix() {
			return getRuleContext(AsMatrixContext.class,0);
		}
		public FlagContext flag() {
			return getRuleContext(FlagContext.class,0);
		}
		public ReadMMContext readMM() {
			return getRuleContext(ReadMMContext.class,0);
		}
		public HeaderContext header() {
			return getRuleContext(HeaderContext.class,0);
		}
		public TerminalNode STRING() { return getToken(RParser.STRING, 0); }
		public MNameContext mName() {
			return getRuleContext(MNameContext.class,0);
		}
		public SepContext sep() {
			return getRuleContext(SepContext.class,0);
		}
		public AsTableContext asTable() {
			return getRuleContext(AsTableContext.class,0);
		}
		public RMatrixConstructionMatrixSourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rMatrixConstructionMatrixSource; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterRMatrixConstructionMatrixSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitRMatrixConstructionMatrixSource(this);
		}
	}

	public final RMatrixConstructionMatrixSourceContext rMatrixConstructionMatrixSource() throws RecognitionException {
		RMatrixConstructionMatrixSourceContext _localctx = new RMatrixConstructionMatrixSourceContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_rMatrixConstructionMatrixSource);
		try {
			setState(86);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(62); asMatrix();
				setState(63); match(T__23);
				setState(64); asTable();
				setState(65); match(T__23);
				setState(66); mName();
				setState(67); match(T__21);
				setState(68); header();
				setState(69); match(T__30);
				setState(70); flag();
				setState(71); match(T__21);
				setState(72); sep();
				setState(73); match(T__30);
				setState(74); match(STRING);
				setState(75); match(T__6);
				setState(76); match(T__6);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(78); asMatrix();
				setState(79); match(T__23);
				setState(80); readMM();
				setState(81); match(T__23);
				setState(82); mName();
				setState(83); match(T__6);
				setState(84); match(T__6);
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

	public static class AsMatrixContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(RParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(RParser.ID, i);
		}
		public AsMatrixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asMatrix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterAsMatrix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitAsMatrix(this);
		}
	}

	public final AsMatrixContext asMatrix() throws RecognitionException {
		AsMatrixContext _localctx = new AsMatrixContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_asMatrix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88); match(ID);
			setState(89); match(T__19);
			setState(90); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AsTableContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(RParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(RParser.ID, i);
		}
		public AsTableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asTable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterAsTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitAsTable(this);
		}
	}

	public final AsTableContext asTable() throws RecognitionException {
		AsTableContext _localctx = new AsTableContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_asTable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92); match(ID);
			setState(93); match(T__19);
			setState(94); match(ID);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode STRING() { return getToken(RParser.STRING, 0); }
		public MNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterMName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitMName(this);
		}
	}

	public final MNameContext mName() throws RecognitionException {
		MNameContext _localctx = new MNameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_mName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(96); match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class HeaderContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(RParser.ID, 0); }
		public HeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitHeader(this);
		}
	}

	public final HeaderContext header() throws RecognitionException {
		HeaderContext _localctx = new HeaderContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(98); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FlagContext extends ParserRuleContext {
		public FlagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_flag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterFlag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitFlag(this);
		}
	}

	public final FlagContext flag() throws RecognitionException {
		FlagContext _localctx = new FlagContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_flag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			_la = _input.LA(1);
			if ( !(_la==T__14 || _la==T__1) ) {
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

	public static class SepContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(RParser.ID, 0); }
		public SepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterSep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitSep(this);
		}
	}

	public final SepContext sep() throws RecognitionException {
		SepContext _localctx = new SepContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_sep);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ReadMMContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(RParser.ID, 0); }
		public ReadMMContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_readMM; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterReadMM(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitReadMM(this);
		}
	}

	public final ReadMMContext readMM() throws RecognitionException {
		ReadMMContext _localctx = new ReadMMContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_readMM);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class RExpressionContext extends ParserRuleContext {
		public RExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rExpression; }
	 
		public RExpressionContext() { }
		public void copyFrom(RExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RowsMeansExperssionContext extends RExpressionContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public RowsMeansExperssionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterRowsMeansExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitRowsMeansExperssion(this);
		}
	}
	public static class AtomicExpressionContext extends RExpressionContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public AtomicExpressionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterAtomicExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitAtomicExpression(this);
		}
	}
	public static class VarExpressionContext extends RExpressionContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public VarExpressionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterVarExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitVarExpression(this);
		}
	}
	public static class ColumnsSumExperssionContext extends RExpressionContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public ColumnsSumExperssionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterColumnsSumExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitColumnsSumExperssion(this);
		}
	}
	public static class CumProdExperssionContext extends RExpressionContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public CumProdExperssionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterCumProdExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitCumProdExperssion(this);
		}
	}
	public static class ColumnsVarExperssionContext extends RExpressionContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public ColumnsVarExperssionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterColumnsVarExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitColumnsVarExperssion(this);
		}
	}
	public static class CumMinExperssionContext extends RExpressionContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public CumMinExperssionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterCumMinExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitCumMinExperssion(this);
		}
	}
	public static class MatrixAddExpressionContext extends RExpressionContext {
		public RExpressionContext left;
		public Token op;
		public RExpressionContext right;
		public List<RExpressionContext> rExpression() {
			return getRuleContexts(RExpressionContext.class);
		}
		public RExpressionContext rExpression(int i) {
			return getRuleContext(RExpressionContext.class,i);
		}
		public MatrixAddExpressionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterMatrixAddExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitMatrixAddExpression(this);
		}
	}
	public static class RowsMaxsExperssionContext extends RExpressionContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public RowsMaxsExperssionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterRowsMaxsExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitRowsMaxsExperssion(this);
		}
	}
	public static class MatrixMulElementwiseExpressionContext extends RExpressionContext {
		public RExpressionContext left;
		public Token op;
		public RExpressionContext right;
		public List<RExpressionContext> rExpression() {
			return getRuleContexts(RExpressionContext.class);
		}
		public RExpressionContext rExpression(int i) {
			return getRuleContext(RExpressionContext.class,i);
		}
		public MatrixMulElementwiseExpressionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterMatrixMulElementwiseExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitMatrixMulElementwiseExpression(this);
		}
	}
	public static class RowsSumExperssionContext extends RExpressionContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public RowsSumExperssionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterRowsSumExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitRowsSumExperssion(this);
		}
	}
	public static class MatrixDetExpressionContext extends RExpressionContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public MatrixDetExpressionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterMatrixDetExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitMatrixDetExpression(this);
		}
	}
	public static class ColumnsMaxsExperssionContext extends RExpressionContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public ColumnsMaxsExperssionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterColumnsMaxsExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitColumnsMaxsExperssion(this);
		}
	}
	public static class MatrixMulExpressionContext extends RExpressionContext {
		public RExpressionContext left;
		public Token op;
		public RExpressionContext right;
		public List<RExpressionContext> rExpression() {
			return getRuleContexts(RExpressionContext.class);
		}
		public RExpressionContext rExpression(int i) {
			return getRuleContext(RExpressionContext.class,i);
		}
		public MatrixMulExpressionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterMatrixMulExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitMatrixMulExpression(this);
		}
	}
	public static class AvgExpressionContext extends RExpressionContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public AvgExpressionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterAvgExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitAvgExpression(this);
		}
	}
	public static class MatrixDivisionContext extends RExpressionContext {
		public RExpressionContext left;
		public Token op;
		public RExpressionContext right;
		public List<RExpressionContext> rExpression() {
			return getRuleContexts(RExpressionContext.class);
		}
		public RExpressionContext rExpression(int i) {
			return getRuleContext(RExpressionContext.class,i);
		}
		public MatrixDivisionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterMatrixDivision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitMatrixDivision(this);
		}
	}
	public static class RowsVarExperssionContext extends RExpressionContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public RowsVarExperssionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterRowsVarExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitRowsVarExperssion(this);
		}
	}
	public static class MeanExpressionContext extends RExpressionContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public MeanExpressionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterMeanExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitMeanExpression(this);
		}
	}
	public static class CumSumExperssionContext extends RExpressionContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public CumSumExperssionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterCumSumExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitCumSumExperssion(this);
		}
	}
	public static class ColumnsMeansExperssionContext extends RExpressionContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public ColumnsMeansExperssionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterColumnsMeansExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitColumnsMeansExperssion(this);
		}
	}
	public static class ColumnsSdsExperssionContext extends RExpressionContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public ColumnsSdsExperssionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterColumnsSdsExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitColumnsSdsExperssion(this);
		}
	}
	public static class MatrixScalarDivisionContext extends RExpressionContext {
		public RExpressionContext left;
		public Token op;
		public NumericScalarContext right;
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public NumericScalarContext numericScalar() {
			return getRuleContext(NumericScalarContext.class,0);
		}
		public MatrixScalarDivisionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterMatrixScalarDivision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitMatrixScalarDivision(this);
		}
	}
	public static class MatrixMulScalarExpressionContext extends RExpressionContext {
		public NumericScalarContext left;
		public Token op;
		public RExpressionContext right;
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public NumericScalarContext numericScalar() {
			return getRuleContext(NumericScalarContext.class,0);
		}
		public MatrixMulScalarExpressionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterMatrixMulScalarExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitMatrixMulScalarExpression(this);
		}
	}
	public static class BooleanAndExpressionContext extends RExpressionContext {
		public RExpressionContext left;
		public Token op;
		public RExpressionContext right;
		public List<RExpressionContext> rExpression() {
			return getRuleContexts(RExpressionContext.class);
		}
		public RExpressionContext rExpression(int i) {
			return getRuleContext(RExpressionContext.class,i);
		}
		public BooleanAndExpressionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterBooleanAndExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitBooleanAndExpression(this);
		}
	}
	public static class CumMaxExperssionContext extends RExpressionContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public CumMaxExperssionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterCumMaxExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitCumMaxExperssion(this);
		}
	}
	public static class ColumnsMinsExperssionContext extends RExpressionContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public ColumnsMinsExperssionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterColumnsMinsExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitColumnsMinsExperssion(this);
		}
	}
	public static class RowsSdsExperssionContext extends RExpressionContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public RowsSdsExperssionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterRowsSdsExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitRowsSdsExperssion(this);
		}
	}
	public static class RowssMinsExperssionContext extends RExpressionContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public RowssMinsExperssionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterRowssMinsExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitRowssMinsExperssion(this);
		}
	}
	public static class MatrixIdentifierContext extends RExpressionContext {
		public MatrixNameExpressionContext matrixNameExpression() {
			return getRuleContext(MatrixNameExpressionContext.class,0);
		}
		public MatrixIdentifierContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterMatrixIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitMatrixIdentifier(this);
		}
	}
	public static class SDExperssionContext extends RExpressionContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public SDExperssionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterSDExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitSDExperssion(this);
		}
	}
	public static class MatrixInverseExpressionContext extends RExpressionContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public MatrixInverseExpressionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterMatrixInverseExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitMatrixInverseExpression(this);
		}
	}
	public static class MatrixDiagonalExpressionContext extends RExpressionContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public MatrixDiagonalExpressionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterMatrixDiagonalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitMatrixDiagonalExpression(this);
		}
	}
	public static class MatrixTraceExpressionContext extends RExpressionContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public MatrixTraceExpressionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterMatrixTraceExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitMatrixTraceExpression(this);
		}
	}
	public static class MatrixTransposeExpressionContext extends RExpressionContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public MatrixTransposeExpressionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterMatrixTransposeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitMatrixTransposeExpression(this);
		}
	}
	public static class MatrixPowerExpressionContext extends RExpressionContext {
		public Token op;
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public MatrixPowerExpressionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterMatrixPowerExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitMatrixPowerExpression(this);
		}
	}
	public static class MatrixSubExpressionContext extends RExpressionContext {
		public RExpressionContext left;
		public Token op;
		public RExpressionContext right;
		public List<RExpressionContext> rExpression() {
			return getRuleContexts(RExpressionContext.class);
		}
		public RExpressionContext rExpression(int i) {
			return getRuleContext(RExpressionContext.class,i);
		}
		public MatrixSubExpressionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterMatrixSubExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitMatrixSubExpression(this);
		}
	}
	public static class SumExperssionContext extends RExpressionContext {
		public RExpressionContext rExpression() {
			return getRuleContext(RExpressionContext.class,0);
		}
		public SumExperssionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterSumExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitSumExperssion(this);
		}
	}
	public static class BooleanOrExpressionContext extends RExpressionContext {
		public RExpressionContext left;
		public Token op;
		public RExpressionContext right;
		public List<RExpressionContext> rExpression() {
			return getRuleContexts(RExpressionContext.class);
		}
		public RExpressionContext rExpression(int i) {
			return getRuleContext(RExpressionContext.class,i);
		}
		public BooleanOrExpressionContext(RExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterBooleanOrExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitBooleanOrExpression(this);
		}
	}

	public final RExpressionContext rExpression() throws RecognitionException {
		return rExpression(0);
	}

	private RExpressionContext rExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RExpressionContext _localctx = new RExpressionContext(_ctx, _parentState);
		RExpressionContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_rExpression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(220);
			switch (_input.LA(1)) {
			case INT:
				{
				_localctx = new MatrixMulScalarExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(107); ((MatrixMulScalarExpressionContext)_localctx).left = numericScalar();
				setState(108); ((MatrixMulScalarExpressionContext)_localctx).op = match(T__22);
				setState(109); ((MatrixMulScalarExpressionContext)_localctx).right = rExpression(35);
				}
				break;
			case ID:
				{
				_localctx = new MatrixIdentifierContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(111); matrixNameExpression();
				}
				break;
			case T__46:
				{
				_localctx = new MatrixTransposeExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(112); match(T__46);
				setState(113); rExpression(0);
				setState(114); match(T__6);
				}
				break;
			case T__11:
				{
				_localctx = new MatrixTraceExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(116); match(T__11);
				setState(117); rExpression(0);
				setState(118); match(T__6);
				}
				break;
			case T__43:
				{
				_localctx = new MatrixDiagonalExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(120); match(T__43);
				setState(121); rExpression(0);
				setState(122); match(T__6);
				}
				break;
			case T__40:
				{
				_localctx = new MatrixInverseExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(124); match(T__40);
				setState(125); rExpression(0);
				setState(126); match(T__6);
				}
				break;
			case T__36:
				{
				_localctx = new MatrixDetExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(128); match(T__36);
				setState(129); rExpression(0);
				setState(130); match(T__6);
				}
				break;
			case T__23:
				{
				_localctx = new AtomicExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(132); match(T__23);
				setState(133); rExpression(0);
				setState(134); match(T__6);
				}
				break;
			case T__41:
				{
				_localctx = new MeanExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(136); match(T__41);
				setState(137); rExpression(0);
				setState(138); match(T__6);
				}
				break;
			case T__9:
				{
				_localctx = new AvgExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(140); match(T__9);
				setState(141); rExpression(0);
				setState(142); match(T__6);
				}
				break;
			case T__24:
				{
				_localctx = new VarExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(144); match(T__24);
				setState(145); rExpression(0);
				setState(146); match(T__6);
				}
				break;
			case T__27:
				{
				_localctx = new SDExperssionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(148); match(T__27);
				setState(149); rExpression(0);
				setState(150); match(T__6);
				}
				break;
			case T__8:
				{
				_localctx = new ColumnsSumExperssionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(152); match(T__8);
				setState(153); rExpression(0);
				setState(154); match(T__6);
				}
				break;
			case T__15:
				{
				_localctx = new ColumnsMeansExperssionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(156); match(T__15);
				setState(157); rExpression(0);
				setState(158); match(T__6);
				}
				break;
			case T__35:
				{
				_localctx = new ColumnsVarExperssionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(160); match(T__35);
				setState(161); rExpression(0);
				setState(162); match(T__6);
				}
				break;
			case T__26:
				{
				_localctx = new ColumnsSdsExperssionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(164); match(T__26);
				setState(165); rExpression(0);
				setState(166); match(T__6);
				}
				break;
			case T__39:
				{
				_localctx = new ColumnsMaxsExperssionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(168); match(T__39);
				setState(169); rExpression(0);
				setState(170); match(T__6);
				}
				break;
			case T__32:
				{
				_localctx = new ColumnsMinsExperssionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(172); match(T__32);
				setState(173); rExpression(0);
				setState(174); match(T__6);
				}
				break;
			case T__28:
				{
				_localctx = new RowsSumExperssionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(176); match(T__28);
				setState(177); rExpression(0);
				setState(178); match(T__6);
				}
				break;
			case T__44:
				{
				_localctx = new RowsMeansExperssionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(180); match(T__44);
				setState(181); rExpression(0);
				setState(182); match(T__6);
				}
				break;
			case T__0:
				{
				_localctx = new RowsVarExperssionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(184); match(T__0);
				setState(185); rExpression(0);
				setState(186); match(T__6);
				}
				break;
			case T__37:
				{
				_localctx = new RowsSdsExperssionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(188); match(T__37);
				setState(189); rExpression(0);
				setState(190); match(T__6);
				}
				break;
			case T__5:
				{
				_localctx = new RowsMaxsExperssionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(192); match(T__5);
				setState(193); rExpression(0);
				setState(194); match(T__6);
				}
				break;
			case T__20:
				{
				_localctx = new RowssMinsExperssionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(196); match(T__20);
				setState(197); rExpression(0);
				setState(198); match(T__6);
				}
				break;
			case T__12:
				{
				_localctx = new CumSumExperssionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(200); match(T__12);
				setState(201); rExpression(0);
				setState(202); match(T__6);
				}
				break;
			case T__42:
				{
				_localctx = new CumProdExperssionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(204); match(T__42);
				setState(205); rExpression(0);
				setState(206); match(T__6);
				}
				break;
			case T__38:
				{
				_localctx = new CumMinExperssionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(208); match(T__38);
				setState(209); rExpression(0);
				setState(210); match(T__6);
				}
				break;
			case T__7:
				{
				_localctx = new CumMaxExperssionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(212); match(T__7);
				setState(213); rExpression(0);
				setState(214); match(T__6);
				}
				break;
			case T__17:
				{
				_localctx = new SumExperssionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(216); match(T__17);
				setState(217); rExpression(0);
				setState(218); match(T__6);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(250);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(248);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new MatrixMulExpressionContext(new RExpressionContext(_parentctx, _parentState));
						((MatrixMulExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_rExpression);
						setState(222);
						if (!(precpred(_ctx, 37))) throw new FailedPredicateException(this, "precpred(_ctx, 37)");
						setState(223); ((MatrixMulExpressionContext)_localctx).op = match(T__16);
						setState(224); ((MatrixMulExpressionContext)_localctx).right = rExpression(38);
						}
						break;
					case 2:
						{
						_localctx = new MatrixMulElementwiseExpressionContext(new RExpressionContext(_parentctx, _parentState));
						((MatrixMulElementwiseExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_rExpression);
						setState(225);
						if (!(precpred(_ctx, 36))) throw new FailedPredicateException(this, "precpred(_ctx, 36)");
						setState(226); ((MatrixMulElementwiseExpressionContext)_localctx).op = match(T__22);
						setState(227); ((MatrixMulElementwiseExpressionContext)_localctx).right = rExpression(37);
						}
						break;
					case 3:
						{
						_localctx = new MatrixAddExpressionContext(new RExpressionContext(_parentctx, _parentState));
						((MatrixAddExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_rExpression);
						setState(228);
						if (!(precpred(_ctx, 34))) throw new FailedPredicateException(this, "precpred(_ctx, 34)");
						setState(229); ((MatrixAddExpressionContext)_localctx).op = match(T__3);
						setState(230); ((MatrixAddExpressionContext)_localctx).right = rExpression(35);
						}
						break;
					case 4:
						{
						_localctx = new MatrixDivisionContext(new RExpressionContext(_parentctx, _parentState));
						((MatrixDivisionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_rExpression);
						setState(231);
						if (!(precpred(_ctx, 33))) throw new FailedPredicateException(this, "precpred(_ctx, 33)");
						setState(232); ((MatrixDivisionContext)_localctx).op = match(T__4);
						setState(233); ((MatrixDivisionContext)_localctx).right = rExpression(34);
						}
						break;
					case 5:
						{
						_localctx = new MatrixSubExpressionContext(new RExpressionContext(_parentctx, _parentState));
						((MatrixSubExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_rExpression);
						setState(234);
						if (!(precpred(_ctx, 31))) throw new FailedPredicateException(this, "precpred(_ctx, 31)");
						setState(235); ((MatrixSubExpressionContext)_localctx).op = match(T__2);
						setState(236); ((MatrixSubExpressionContext)_localctx).right = rExpression(32);
						}
						break;
					case 6:
						{
						_localctx = new BooleanAndExpressionContext(new RExpressionContext(_parentctx, _parentState));
						((BooleanAndExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_rExpression);
						setState(237);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(238);
						((BooleanAndExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__31 || _la==T__25) ) {
							((BooleanAndExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(239); ((BooleanAndExpressionContext)_localctx).right = rExpression(24);
						}
						break;
					case 7:
						{
						_localctx = new BooleanOrExpressionContext(new RExpressionContext(_parentctx, _parentState));
						((BooleanOrExpressionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_rExpression);
						setState(240);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(241);
						((BooleanOrExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__34 || _la==T__10) ) {
							((BooleanOrExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						consume();
						setState(242); ((BooleanOrExpressionContext)_localctx).right = rExpression(23);
						}
						break;
					case 8:
						{
						_localctx = new MatrixScalarDivisionContext(new RExpressionContext(_parentctx, _parentState));
						((MatrixScalarDivisionContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_rExpression);
						setState(243);
						if (!(precpred(_ctx, 32))) throw new FailedPredicateException(this, "precpred(_ctx, 32)");
						setState(244); ((MatrixScalarDivisionContext)_localctx).op = match(T__45);
						setState(245); ((MatrixScalarDivisionContext)_localctx).right = numericScalar();
						}
						break;
					case 9:
						{
						_localctx = new MatrixPowerExpressionContext(new RExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rExpression);
						setState(246);
						if (!(precpred(_ctx, 27))) throw new FailedPredicateException(this, "precpred(_ctx, 27)");
						setState(247); ((MatrixPowerExpressionContext)_localctx).op = match(T__29);
						}
						break;
					}
					} 
				}
				setState(252);
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

	public static class ViewNameContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(RParser.ID, 0); }
		public ViewNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_viewName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterViewName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitViewName(this);
		}
	}

	public final ViewNameContext viewName() throws RecognitionException {
		ViewNameContext _localctx = new ViewNameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_viewName);
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
		public TerminalNode ID() { return getToken(RParser.ID, 0); }
		public MatrixNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrixName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterMatrixName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitMatrixName(this);
		}
	}

	public final MatrixNameContext matrixName() throws RecognitionException {
		MatrixNameContext _localctx = new MatrixNameContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_matrixName);
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
		public TerminalNode ID() { return getToken(RParser.ID, 0); }
		public MatrixNameExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrixNameExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterMatrixNameExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitMatrixNameExpression(this);
		}
	}

	public final MatrixNameExpressionContext matrixNameExpression() throws RecognitionException {
		MatrixNameExpressionContext _localctx = new MatrixNameExpressionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_matrixNameExpression);
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
		public TerminalNode INT() { return getToken(RParser.INT, 0); }
		public NumericScalarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericScalar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterNumericScalar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitNumericScalar(this);
		}
	}

	public final NumericScalarContext numericScalar() throws RecognitionException {
		NumericScalarContext _localctx = new NumericScalarContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_numericScalar);
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
		public TerminalNode STRING() { return getToken(RParser.STRING, 0); }
		public FilePathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filePath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).enterFilePath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof RListener ) ((RListener)listener).exitFilePath(this);
		}
	}

	public final FilePathContext filePath() throws RecognitionException {
		FilePathContext _localctx = new FilePathContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_filePath);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 13: return rExpression_sempred((RExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean rExpression_sempred(RExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 37);
		case 1: return precpred(_ctx, 36);
		case 2: return precpred(_ctx, 34);
		case 3: return precpred(_ctx, 33);
		case 4: return precpred(_ctx, 31);
		case 5: return precpred(_ctx, 23);
		case 6: return precpred(_ctx, 22);
		case 7: return precpred(_ctx, 32);
		case 8: return precpred(_ctx, 27);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3;\u010a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\7\3\62\n\3\f"+
		"\3\16\3\65\13\3\3\4\3\4\3\4\3\4\3\5\3\5\5\5=\n\5\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\5\7Y\n\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13"+
		"\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00df\n\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00fb\n\17\f\17\16\17\u00fe"+
		"\13\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\24\2\3\34\25"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&\2\5\4\2##\60\60\4\2\22\22"+
		"\30\30\4\2\17\17\'\'\u011e\2(\3\2\2\2\4,\3\2\2\2\6\66\3\2\2\2\b<\3\2\2"+
		"\2\n>\3\2\2\2\fX\3\2\2\2\16Z\3\2\2\2\20^\3\2\2\2\22b\3\2\2\2\24d\3\2\2"+
		"\2\26f\3\2\2\2\30h\3\2\2\2\32j\3\2\2\2\34\u00de\3\2\2\2\36\u00ff\3\2\2"+
		"\2 \u0101\3\2\2\2\"\u0103\3\2\2\2$\u0105\3\2\2\2&\u0107\3\2\2\2()\5\36"+
		"\20\2)*\7$\2\2*+\5\4\3\2+\3\3\2\2\2,-\5\6\4\2-\63\7\20\2\2./\5\6\4\2/"+
		"\60\7\20\2\2\60\62\3\2\2\2\61.\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63"+
		"\64\3\2\2\2\64\5\3\2\2\2\65\63\3\2\2\2\66\67\5 \21\2\678\7\37\2\289\5"+
		"\b\5\29\7\3\2\2\2:=\5\n\6\2;=\5\34\17\2<:\3\2\2\2<;\3\2\2\2=\t\3\2\2\2"+
		">?\5\f\7\2?\13\3\2\2\2@A\5\16\b\2AB\7\32\2\2BC\5\20\t\2CD\7\32\2\2DE\5"+
		"\22\n\2EF\7\34\2\2FG\5\24\13\2GH\7\23\2\2HI\5\26\f\2IJ\7\34\2\2JK\5\30"+
		"\r\2KL\7\23\2\2LM\7\64\2\2MN\7+\2\2NO\7+\2\2OY\3\2\2\2PQ\5\16\b\2QR\7"+
		"\32\2\2RS\5\32\16\2ST\7\32\2\2TU\5\22\n\2UV\7+\2\2VW\7+\2\2WY\3\2\2\2"+
		"X@\3\2\2\2XP\3\2\2\2Y\r\3\2\2\2Z[\7\62\2\2[\\\7\36\2\2\\]\7\62\2\2]\17"+
		"\3\2\2\2^_\7\62\2\2_`\7\36\2\2`a\7\62\2\2a\21\3\2\2\2bc\7\64\2\2c\23\3"+
		"\2\2\2de\7\62\2\2e\25\3\2\2\2fg\t\2\2\2g\27\3\2\2\2hi\7\62\2\2i\31\3\2"+
		"\2\2jk\7\62\2\2k\33\3\2\2\2lm\b\17\1\2mn\5$\23\2no\7\33\2\2op\5\34\17"+
		"%p\u00df\3\2\2\2q\u00df\5\"\22\2rs\7\3\2\2st\5\34\17\2tu\7+\2\2u\u00df"+
		"\3\2\2\2vw\7&\2\2wx\5\34\17\2xy\7+\2\2y\u00df\3\2\2\2z{\7\6\2\2{|\5\34"+
		"\17\2|}\7+\2\2}\u00df\3\2\2\2~\177\7\t\2\2\177\u0080\5\34\17\2\u0080\u0081"+
		"\7+\2\2\u0081\u00df\3\2\2\2\u0082\u0083\7\r\2\2\u0083\u0084\5\34\17\2"+
		"\u0084\u0085\7+\2\2\u0085\u00df\3\2\2\2\u0086\u0087\7\32\2\2\u0087\u0088"+
		"\5\34\17\2\u0088\u0089\7+\2\2\u0089\u00df\3\2\2\2\u008a\u008b\7\b\2\2"+
		"\u008b\u008c\5\34\17\2\u008c\u008d\7+\2\2\u008d\u00df\3\2\2\2\u008e\u008f"+
		"\7(\2\2\u008f\u0090\5\34\17\2\u0090\u0091\7+\2\2\u0091\u00df\3\2\2\2\u0092"+
		"\u0093\7\31\2\2\u0093\u0094\5\34\17\2\u0094\u0095\7+\2\2\u0095\u00df\3"+
		"\2\2\2\u0096\u0097\7\26\2\2\u0097\u0098\5\34\17\2\u0098\u0099\7+\2\2\u0099"+
		"\u00df\3\2\2\2\u009a\u009b\7)\2\2\u009b\u009c\5\34\17\2\u009c\u009d\7"+
		"+\2\2\u009d\u00df\3\2\2\2\u009e\u009f\7\"\2\2\u009f\u00a0\5\34\17\2\u00a0"+
		"\u00a1\7+\2\2\u00a1\u00df\3\2\2\2\u00a2\u00a3\7\16\2\2\u00a3\u00a4\5\34"+
		"\17\2\u00a4\u00a5\7+\2\2\u00a5\u00df\3\2\2\2\u00a6\u00a7\7\27\2\2\u00a7"+
		"\u00a8\5\34\17\2\u00a8\u00a9\7+\2\2\u00a9\u00df\3\2\2\2\u00aa\u00ab\7"+
		"\n\2\2\u00ab\u00ac\5\34\17\2\u00ac\u00ad\7+\2\2\u00ad\u00df\3\2\2\2\u00ae"+
		"\u00af\7\21\2\2\u00af\u00b0\5\34\17\2\u00b0\u00b1\7+\2\2\u00b1\u00df\3"+
		"\2\2\2\u00b2\u00b3\7\25\2\2\u00b3\u00b4\5\34\17\2\u00b4\u00b5\7+\2\2\u00b5"+
		"\u00df\3\2\2\2\u00b6\u00b7\7\5\2\2\u00b7\u00b8\5\34\17\2\u00b8\u00b9\7"+
		"+\2\2\u00b9\u00df\3\2\2\2\u00ba\u00bb\7\61\2\2\u00bb\u00bc\5\34\17\2\u00bc"+
		"\u00bd\7+\2\2\u00bd\u00df\3\2\2\2\u00be\u00bf\7\f\2\2\u00bf\u00c0\5\34"+
		"\17\2\u00c0\u00c1\7+\2\2\u00c1\u00df\3\2\2\2\u00c2\u00c3\7,\2\2\u00c3"+
		"\u00c4\5\34\17\2\u00c4\u00c5\7+\2\2\u00c5\u00df\3\2\2\2\u00c6\u00c7\7"+
		"\35\2\2\u00c7\u00c8\5\34\17\2\u00c8\u00c9\7+\2\2\u00c9\u00df\3\2\2\2\u00ca"+
		"\u00cb\7%\2\2\u00cb\u00cc\5\34\17\2\u00cc\u00cd\7+\2\2\u00cd\u00df\3\2"+
		"\2\2\u00ce\u00cf\7\7\2\2\u00cf\u00d0\5\34\17\2\u00d0\u00d1\7+\2\2\u00d1"+
		"\u00df\3\2\2\2\u00d2\u00d3\7\13\2\2\u00d3\u00d4\5\34\17\2\u00d4\u00d5"+
		"\7+\2\2\u00d5\u00df\3\2\2\2\u00d6\u00d7\7*\2\2\u00d7\u00d8\5\34\17\2\u00d8"+
		"\u00d9\7+\2\2\u00d9\u00df\3\2\2\2\u00da\u00db\7 \2\2\u00db\u00dc\5\34"+
		"\17\2\u00dc\u00dd\7+\2\2\u00dd\u00df\3\2\2\2\u00del\3\2\2\2\u00deq\3\2"+
		"\2\2\u00der\3\2\2\2\u00dev\3\2\2\2\u00dez\3\2\2\2\u00de~\3\2\2\2\u00de"+
		"\u0082\3\2\2\2\u00de\u0086\3\2\2\2\u00de\u008a\3\2\2\2\u00de\u008e\3\2"+
		"\2\2\u00de\u0092\3\2\2\2\u00de\u0096\3\2\2\2\u00de\u009a\3\2\2\2\u00de"+
		"\u009e\3\2\2\2\u00de\u00a2\3\2\2\2\u00de\u00a6\3\2\2\2\u00de\u00aa\3\2"+
		"\2\2\u00de\u00ae\3\2\2\2\u00de\u00b2\3\2\2\2\u00de\u00b6\3\2\2\2\u00de"+
		"\u00ba\3\2\2\2\u00de\u00be\3\2\2\2\u00de\u00c2\3\2\2\2\u00de\u00c6\3\2"+
		"\2\2\u00de\u00ca\3\2\2\2\u00de\u00ce\3\2\2\2\u00de\u00d2\3\2\2\2\u00de"+
		"\u00d6\3\2\2\2\u00de\u00da\3\2\2\2\u00df\u00fc\3\2\2\2\u00e0\u00e1\f\'"+
		"\2\2\u00e1\u00e2\7!\2\2\u00e2\u00fb\5\34\17(\u00e3\u00e4\f&\2\2\u00e4"+
		"\u00e5\7\33\2\2\u00e5\u00fb\5\34\17\'\u00e6\u00e7\f$\2\2\u00e7\u00e8\7"+
		".\2\2\u00e8\u00fb\5\34\17%\u00e9\u00ea\f#\2\2\u00ea\u00eb\7-\2\2\u00eb"+
		"\u00fb\5\34\17$\u00ec\u00ed\f!\2\2\u00ed\u00ee\7/\2\2\u00ee\u00fb\5\34"+
		"\17\"\u00ef\u00f0\f\31\2\2\u00f0\u00f1\t\3\2\2\u00f1\u00fb\5\34\17\32"+
		"\u00f2\u00f3\f\30\2\2\u00f3\u00f4\t\4\2\2\u00f4\u00fb\5\34\17\31\u00f5"+
		"\u00f6\f\"\2\2\u00f6\u00f7\7\4\2\2\u00f7\u00fb\5$\23\2\u00f8\u00f9\f\35"+
		"\2\2\u00f9\u00fb\7\24\2\2\u00fa\u00e0\3\2\2\2\u00fa\u00e3\3\2\2\2\u00fa"+
		"\u00e6\3\2\2\2\u00fa\u00e9\3\2\2\2\u00fa\u00ec\3\2\2\2\u00fa\u00ef\3\2"+
		"\2\2\u00fa\u00f2\3\2\2\2\u00fa\u00f5\3\2\2\2\u00fa\u00f8\3\2\2\2\u00fb"+
		"\u00fe\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd\35\3\2\2"+
		"\2\u00fe\u00fc\3\2\2\2\u00ff\u0100\7\62\2\2\u0100\37\3\2\2\2\u0101\u0102"+
		"\7\62\2\2\u0102!\3\2\2\2\u0103\u0104\7\62\2\2\u0104#\3\2\2\2\u0105\u0106"+
		"\7\65\2\2\u0106%\3\2\2\2\u0107\u0108\7\64\2\2\u0108\'\3\2\2\2\b\63<X\u00de"+
		"\u00fa\u00fc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}