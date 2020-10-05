// Generated from NumPy.g4 by ANTLR 4.4

package hadad.base.compiler.model.nm;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class NumPyParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__27=1, T__26=2, T__25=3, T__24=4, T__23=5, T__22=6, T__21=7, T__20=8, 
		T__19=9, T__18=10, T__17=11, T__16=12, T__15=13, T__14=14, T__13=15, T__12=16, 
		T__11=17, T__10=18, T__9=19, T__8=20, T__7=21, T__6=22, T__5=23, T__4=24, 
		T__3=25, T__2=26, T__1=27, T__0=28, ID=29, WHITESPACE=30, STRING=31, INT=32, 
		MATRIX=33, ROWS=34, COLS=35, READ=36;
	public static final String[] tokenNames = {
		"<INVALID>", "'.linalg.inv('", "'.power('", "'.trace('", "'.sd('", "'.subtract('", 
		"'.linalg.norm('", "'.transpose('", "'='", "'.divide('", "'.avg('", "'.amax('", 
		"'('", "','", "'.var('", "'axis=0'", "'.sum('", "'.multiply('", "'.linalg.det('", 
		"'.diag('", "'.amin('", "':'", "'.add('", "'.matmul('", "'axis=1'", "')'", 
		"'import numpy as'", "'.mean('", "'.linalg.matrix_rank('", "ID", "WHITESPACE", 
		"STRING", "INT", "MATRIX", "ROWS", "COLS", "READ"
	};
	public static final int
		RULE_numPyQuery = 0, RULE_importstatement = 1, RULE_numPyScript = 2, RULE_numPyStatemnet = 3, 
		RULE_source = 4, RULE_numPyMatrixConstruction = 5, RULE_numPyMatrixConstructionMatrixSource = 6, 
		RULE_load = 7, RULE_mName = 8, RULE_sep = 9, RULE_numPyExpression = 10, 
		RULE_viewName = 11, RULE_matrixName = 12, RULE_matrixNameExpression = 13, 
		RULE_numericScalar = 14, RULE_filePath = 15;
	public static final String[] ruleNames = {
		"numPyQuery", "importstatement", "numPyScript", "numPyStatemnet", "source", 
		"numPyMatrixConstruction", "numPyMatrixConstructionMatrixSource", "load", 
		"mName", "sep", "numPyExpression", "viewName", "matrixName", "matrixNameExpression", 
		"numericScalar", "filePath"
	};

	@Override
	public String getGrammarFileName() { return "NumPy.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public NumPyParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class NumPyQueryContext extends ParserRuleContext {
		public ViewNameContext viewName() {
			return getRuleContext(ViewNameContext.class,0);
		}
		public NumPyScriptContext numPyScript() {
			return getRuleContext(NumPyScriptContext.class,0);
		}
		public ImportstatementContext importstatement() {
			return getRuleContext(ImportstatementContext.class,0);
		}
		public NumPyQueryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numPyQuery; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterNumPyQuery(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitNumPyQuery(this);
		}
	}

	public final NumPyQueryContext numPyQuery() throws RecognitionException {
		NumPyQueryContext _localctx = new NumPyQueryContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_numPyQuery);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32); viewName();
			setState(33); match(T__7);
			setState(34); importstatement();
			setState(35); numPyScript();
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public ImportstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterImportstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitImportstatement(this);
		}
	}

	public final ImportstatementContext importstatement() throws RecognitionException {
		ImportstatementContext _localctx = new ImportstatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_importstatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37); match(T__2);
			setState(38); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumPyScriptContext extends ParserRuleContext {
		public List<NumPyStatemnetContext> numPyStatemnet() {
			return getRuleContexts(NumPyStatemnetContext.class);
		}
		public NumPyStatemnetContext numPyStatemnet(int i) {
			return getRuleContext(NumPyStatemnetContext.class,i);
		}
		public NumPyScriptContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numPyScript; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterNumPyScript(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitNumPyScript(this);
		}
	}

	public final NumPyScriptContext numPyScript() throws RecognitionException {
		NumPyScriptContext _localctx = new NumPyScriptContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_numPyScript);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40); numPyStatemnet();
			setState(44);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(41); numPyStatemnet();
				}
				}
				setState(46);
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

	public static class NumPyStatemnetContext extends ParserRuleContext {
		public SourceContext source() {
			return getRuleContext(SourceContext.class,0);
		}
		public MatrixNameContext matrixName() {
			return getRuleContext(MatrixNameContext.class,0);
		}
		public NumPyStatemnetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numPyStatemnet; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterNumPyStatemnet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitNumPyStatemnet(this);
		}
	}

	public final NumPyStatemnetContext numPyStatemnet() throws RecognitionException {
		NumPyStatemnetContext _localctx = new NumPyStatemnetContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_numPyStatemnet);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47); matrixName();
			setState(48); match(T__20);
			setState(49); source();
			}
		}
		catch (RecognitionException re) {
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
		public NumPyExpressionContext numPyExpression() {
			return getRuleContext(NumPyExpressionContext.class,0);
		}
		public NumPyMatrixConstructionContext numPyMatrixConstruction() {
			return getRuleContext(NumPyMatrixConstructionContext.class,0);
		}
		public SourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_source; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitSource(this);
		}
	}

	public final SourceContext source() throws RecognitionException {
		SourceContext _localctx = new SourceContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_source);
		try {
			setState(53);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(51); numPyMatrixConstruction();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(52); numPyExpression();
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

	public static class NumPyMatrixConstructionContext extends ParserRuleContext {
		public NumPyMatrixConstructionMatrixSourceContext numPyMatrixConstructionMatrixSource() {
			return getRuleContext(NumPyMatrixConstructionMatrixSourceContext.class,0);
		}
		public NumPyMatrixConstructionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numPyMatrixConstruction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterNumPyMatrixConstruction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitNumPyMatrixConstruction(this);
		}
	}

	public final NumPyMatrixConstructionContext numPyMatrixConstruction() throws RecognitionException {
		NumPyMatrixConstructionContext _localctx = new NumPyMatrixConstructionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_numPyMatrixConstruction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55); numPyMatrixConstructionMatrixSource();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumPyMatrixConstructionMatrixSourceContext extends ParserRuleContext {
		public LoadContext load() {
			return getRuleContext(LoadContext.class,0);
		}
		public NumPyMatrixConstructionMatrixSourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numPyMatrixConstructionMatrixSource; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterNumPyMatrixConstructionMatrixSource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitNumPyMatrixConstructionMatrixSource(this);
		}
	}

	public final NumPyMatrixConstructionMatrixSourceContext numPyMatrixConstructionMatrixSource() throws RecognitionException {
		NumPyMatrixConstructionMatrixSourceContext _localctx = new NumPyMatrixConstructionMatrixSourceContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_numPyMatrixConstructionMatrixSource);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57); load();
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public TerminalNode STRING() { return getToken(NumPyParser.STRING, 0); }
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
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterLoad(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitLoad(this);
		}
	}

	public final LoadContext load() throws RecognitionException {
		LoadContext _localctx = new LoadContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_load);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59); match(ID);
			setState(60); match(T__16);
			setState(61); mName();
			setState(62); match(T__15);
			setState(63); sep();
			setState(64); match(T__20);
			setState(65); match(STRING);
			setState(66); match(T__3);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode STRING() { return getToken(NumPyParser.STRING, 0); }
		public MNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterMName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitMName(this);
		}
	}

	public final MNameContext mName() throws RecognitionException {
		MNameContext _localctx = new MNameContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_mName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68); match(STRING);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public SepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterSep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitSep(this);
		}
	}

	public final SepContext sep() throws RecognitionException {
		SepContext _localctx = new SepContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_sep);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70); match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumPyExpressionContext extends ParserRuleContext {
		public NumPyExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numPyExpression; }
	 
		public NumPyExpressionContext() { }
		public void copyFrom(NumPyExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ColumnsMaxExperssionContext extends NumPyExpressionContext {
		public Token op;
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public NumPyExpressionContext numPyExpression() {
			return getRuleContext(NumPyExpressionContext.class,0);
		}
		public ColumnsMaxExperssionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterColumnsMaxExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitColumnsMaxExperssion(this);
		}
	}
	public static class RowsMeansExperssionContext extends NumPyExpressionContext {
		public Token op;
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public NumPyExpressionContext numPyExpression() {
			return getRuleContext(NumPyExpressionContext.class,0);
		}
		public RowsMeansExperssionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterRowsMeansExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitRowsMeansExperssion(this);
		}
	}
	public static class VarExpressionContext extends NumPyExpressionContext {
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public NumPyExpressionContext numPyExpression() {
			return getRuleContext(NumPyExpressionContext.class,0);
		}
		public VarExpressionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterVarExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitVarExpression(this);
		}
	}
	public static class ColumnsSumExperssionContext extends NumPyExpressionContext {
		public Token op;
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public NumPyExpressionContext numPyExpression() {
			return getRuleContext(NumPyExpressionContext.class,0);
		}
		public ColumnsSumExperssionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterColumnsSumExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitColumnsSumExperssion(this);
		}
	}
	public static class RowsMinExperssionContext extends NumPyExpressionContext {
		public Token op;
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public NumPyExpressionContext numPyExpression() {
			return getRuleContext(NumPyExpressionContext.class,0);
		}
		public RowsMinExperssionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterRowsMinExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitRowsMinExperssion(this);
		}
	}
	public static class ColumnsVarExperssionContext extends NumPyExpressionContext {
		public Token op;
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public NumPyExpressionContext numPyExpression() {
			return getRuleContext(NumPyExpressionContext.class,0);
		}
		public ColumnsVarExperssionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterColumnsVarExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitColumnsVarExperssion(this);
		}
	}
	public static class MatrixAddExpressionContext extends NumPyExpressionContext {
		public NumPyExpressionContext left;
		public Token op;
		public NumPyExpressionContext right;
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public List<NumPyExpressionContext> numPyExpression() {
			return getRuleContexts(NumPyExpressionContext.class);
		}
		public NumPyExpressionContext numPyExpression(int i) {
			return getRuleContext(NumPyExpressionContext.class,i);
		}
		public MatrixAddExpressionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterMatrixAddExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitMatrixAddExpression(this);
		}
	}
	public static class MatrixMulElementwiseExpressionContext extends NumPyExpressionContext {
		public NumPyExpressionContext left;
		public Token op;
		public NumPyExpressionContext right;
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public List<NumPyExpressionContext> numPyExpression() {
			return getRuleContexts(NumPyExpressionContext.class);
		}
		public NumPyExpressionContext numPyExpression(int i) {
			return getRuleContext(NumPyExpressionContext.class,i);
		}
		public MatrixMulElementwiseExpressionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterMatrixMulElementwiseExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitMatrixMulElementwiseExpression(this);
		}
	}
	public static class RowsSumExperssionContext extends NumPyExpressionContext {
		public Token op;
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public NumPyExpressionContext numPyExpression() {
			return getRuleContext(NumPyExpressionContext.class,0);
		}
		public RowsSumExperssionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterRowsSumExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitRowsSumExperssion(this);
		}
	}
	public static class MatrixDetExpressionContext extends NumPyExpressionContext {
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public NumPyExpressionContext numPyExpression() {
			return getRuleContext(NumPyExpressionContext.class,0);
		}
		public MatrixDetExpressionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterMatrixDetExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitMatrixDetExpression(this);
		}
	}
	public static class MatrixMulExpressionContext extends NumPyExpressionContext {
		public NumPyExpressionContext left;
		public Token op;
		public NumPyExpressionContext right;
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public List<NumPyExpressionContext> numPyExpression() {
			return getRuleContexts(NumPyExpressionContext.class);
		}
		public NumPyExpressionContext numPyExpression(int i) {
			return getRuleContext(NumPyExpressionContext.class,i);
		}
		public MatrixMulExpressionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterMatrixMulExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitMatrixMulExpression(this);
		}
	}
	public static class MatrixDivisionContext extends NumPyExpressionContext {
		public NumPyExpressionContext left;
		public Token op;
		public NumPyExpressionContext right;
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public List<NumPyExpressionContext> numPyExpression() {
			return getRuleContexts(NumPyExpressionContext.class);
		}
		public NumPyExpressionContext numPyExpression(int i) {
			return getRuleContext(NumPyExpressionContext.class,i);
		}
		public MatrixDivisionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterMatrixDivision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitMatrixDivision(this);
		}
	}
	public static class AvgExpressionContext extends NumPyExpressionContext {
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public NumPyExpressionContext numPyExpression() {
			return getRuleContext(NumPyExpressionContext.class,0);
		}
		public AvgExpressionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterAvgExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitAvgExpression(this);
		}
	}
	public static class RowsVarExperssionContext extends NumPyExpressionContext {
		public Token op;
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public NumPyExpressionContext numPyExpression() {
			return getRuleContext(NumPyExpressionContext.class,0);
		}
		public RowsVarExperssionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterRowsVarExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitRowsVarExperssion(this);
		}
	}
	public static class MeanExpressionContext extends NumPyExpressionContext {
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public NumPyExpressionContext numPyExpression() {
			return getRuleContext(NumPyExpressionContext.class,0);
		}
		public MeanExpressionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterMeanExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitMeanExpression(this);
		}
	}
	public static class ColumnsMeansExperssionContext extends NumPyExpressionContext {
		public Token op;
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public NumPyExpressionContext numPyExpression() {
			return getRuleContext(NumPyExpressionContext.class,0);
		}
		public ColumnsMeansExperssionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterColumnsMeansExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitColumnsMeansExperssion(this);
		}
	}
	public static class ColumnsSdsExperssionContext extends NumPyExpressionContext {
		public Token op;
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public NumPyExpressionContext numPyExpression() {
			return getRuleContext(NumPyExpressionContext.class,0);
		}
		public ColumnsSdsExperssionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterColumnsSdsExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitColumnsSdsExperssion(this);
		}
	}
	public static class MatrixScalarDivisionContext extends NumPyExpressionContext {
		public NumPyExpressionContext left;
		public Token op;
		public NumericScalarContext right;
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public NumPyExpressionContext numPyExpression() {
			return getRuleContext(NumPyExpressionContext.class,0);
		}
		public NumericScalarContext numericScalar() {
			return getRuleContext(NumericScalarContext.class,0);
		}
		public MatrixScalarDivisionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterMatrixScalarDivision(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitMatrixScalarDivision(this);
		}
	}
	public static class ColumnsMinExperssionContext extends NumPyExpressionContext {
		public Token op;
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public NumPyExpressionContext numPyExpression() {
			return getRuleContext(NumPyExpressionContext.class,0);
		}
		public ColumnsMinExperssionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterColumnsMinExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitColumnsMinExperssion(this);
		}
	}
	public static class MatrixMulScalarExpressionContext extends NumPyExpressionContext {
		public NumericScalarContext left;
		public Token op;
		public NumPyExpressionContext right;
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public NumPyExpressionContext numPyExpression() {
			return getRuleContext(NumPyExpressionContext.class,0);
		}
		public NumericScalarContext numericScalar() {
			return getRuleContext(NumericScalarContext.class,0);
		}
		public MatrixMulScalarExpressionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterMatrixMulScalarExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitMatrixMulScalarExpression(this);
		}
	}
	public static class MatrixInvExpressionContext extends NumPyExpressionContext {
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public NumPyExpressionContext numPyExpression() {
			return getRuleContext(NumPyExpressionContext.class,0);
		}
		public MatrixInvExpressionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterMatrixInvExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitMatrixInvExpression(this);
		}
	}
	public static class MatrixNormExpressionContext extends NumPyExpressionContext {
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public NumPyExpressionContext numPyExpression() {
			return getRuleContext(NumPyExpressionContext.class,0);
		}
		public MatrixNormExpressionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterMatrixNormExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitMatrixNormExpression(this);
		}
	}
	public static class MinExperssionContext extends NumPyExpressionContext {
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public NumPyExpressionContext numPyExpression() {
			return getRuleContext(NumPyExpressionContext.class,0);
		}
		public MinExperssionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterMinExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitMinExperssion(this);
		}
	}
	public static class RowsSdsExperssionContext extends NumPyExpressionContext {
		public Token op;
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public NumPyExpressionContext numPyExpression() {
			return getRuleContext(NumPyExpressionContext.class,0);
		}
		public RowsSdsExperssionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterRowsSdsExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitRowsSdsExperssion(this);
		}
	}
	public static class RowsMaxExperssionContext extends NumPyExpressionContext {
		public Token op;
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public NumPyExpressionContext numPyExpression() {
			return getRuleContext(NumPyExpressionContext.class,0);
		}
		public RowsMaxExperssionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterRowsMaxExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitRowsMaxExperssion(this);
		}
	}
	public static class MatrixIdentifierContext extends NumPyExpressionContext {
		public MatrixNameExpressionContext matrixNameExpression() {
			return getRuleContext(MatrixNameExpressionContext.class,0);
		}
		public MatrixIdentifierContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterMatrixIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitMatrixIdentifier(this);
		}
	}
	public static class SDExperssionContext extends NumPyExpressionContext {
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public NumPyExpressionContext numPyExpression() {
			return getRuleContext(NumPyExpressionContext.class,0);
		}
		public SDExperssionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterSDExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitSDExperssion(this);
		}
	}
	public static class MatrixDiagonalExpressionContext extends NumPyExpressionContext {
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public NumPyExpressionContext numPyExpression() {
			return getRuleContext(NumPyExpressionContext.class,0);
		}
		public MatrixDiagonalExpressionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterMatrixDiagonalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitMatrixDiagonalExpression(this);
		}
	}
	public static class MatrixTraceExpressionContext extends NumPyExpressionContext {
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public NumPyExpressionContext numPyExpression() {
			return getRuleContext(NumPyExpressionContext.class,0);
		}
		public MatrixTraceExpressionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterMatrixTraceExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitMatrixTraceExpression(this);
		}
	}
	public static class MatrixTransposeExpressionContext extends NumPyExpressionContext {
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public NumPyExpressionContext numPyExpression() {
			return getRuleContext(NumPyExpressionContext.class,0);
		}
		public MatrixTransposeExpressionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterMatrixTransposeExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitMatrixTransposeExpression(this);
		}
	}
	public static class MaxExperssionContext extends NumPyExpressionContext {
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public NumPyExpressionContext numPyExpression() {
			return getRuleContext(NumPyExpressionContext.class,0);
		}
		public MaxExperssionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterMaxExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitMaxExperssion(this);
		}
	}
	public static class MatrixPowerExpressionContext extends NumPyExpressionContext {
		public Token op;
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public NumPyExpressionContext numPyExpression() {
			return getRuleContext(NumPyExpressionContext.class,0);
		}
		public NumericScalarContext numericScalar() {
			return getRuleContext(NumericScalarContext.class,0);
		}
		public MatrixPowerExpressionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterMatrixPowerExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitMatrixPowerExpression(this);
		}
	}
	public static class MatrixRankExpressionContext extends NumPyExpressionContext {
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public NumPyExpressionContext numPyExpression() {
			return getRuleContext(NumPyExpressionContext.class,0);
		}
		public MatrixRankExpressionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterMatrixRankExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitMatrixRankExpression(this);
		}
	}
	public static class MatrixSubExpressionContext extends NumPyExpressionContext {
		public Token op;
		public NumPyExpressionContext right;
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public List<NumPyExpressionContext> numPyExpression() {
			return getRuleContexts(NumPyExpressionContext.class);
		}
		public NumPyExpressionContext numPyExpression(int i) {
			return getRuleContext(NumPyExpressionContext.class,i);
		}
		public MatrixSubExpressionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterMatrixSubExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitMatrixSubExpression(this);
		}
	}
	public static class SumExperssionContext extends NumPyExpressionContext {
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public NumPyExpressionContext numPyExpression() {
			return getRuleContext(NumPyExpressionContext.class,0);
		}
		public SumExperssionContext(NumPyExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterSumExperssion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitSumExperssion(this);
		}
	}

	public final NumPyExpressionContext numPyExpression() throws RecognitionException {
		NumPyExpressionContext _localctx = new NumPyExpressionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_numPyExpression);
		try {
			setState(283);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new MatrixIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(72); matrixNameExpression();
				}
				break;
			case 2:
				_localctx = new MatrixMulExpressionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(73); match(ID);
				setState(74); match(T__5);
				setState(75); ((MatrixMulExpressionContext)_localctx).left = numPyExpression();
				setState(76); ((MatrixMulExpressionContext)_localctx).op = match(T__15);
				setState(77); ((MatrixMulExpressionContext)_localctx).right = numPyExpression();
				setState(78); match(T__3);
				}
				break;
			case 3:
				_localctx = new MatrixMulElementwiseExpressionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(80); match(ID);
				setState(81); match(T__11);
				setState(82); ((MatrixMulElementwiseExpressionContext)_localctx).left = numPyExpression();
				setState(83); ((MatrixMulElementwiseExpressionContext)_localctx).op = match(T__15);
				setState(84); ((MatrixMulElementwiseExpressionContext)_localctx).right = numPyExpression();
				setState(85); match(T__3);
				}
				break;
			case 4:
				_localctx = new MatrixMulScalarExpressionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(87); match(ID);
				setState(88); match(T__11);
				setState(89); ((MatrixMulScalarExpressionContext)_localctx).left = numericScalar();
				setState(90); ((MatrixMulScalarExpressionContext)_localctx).op = match(T__15);
				setState(91); ((MatrixMulScalarExpressionContext)_localctx).right = numPyExpression();
				setState(92); match(T__3);
				}
				break;
			case 5:
				_localctx = new MatrixAddExpressionContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(94); match(ID);
				setState(95); match(T__6);
				setState(96); ((MatrixAddExpressionContext)_localctx).left = numPyExpression();
				setState(97); ((MatrixAddExpressionContext)_localctx).op = match(T__15);
				setState(98); ((MatrixAddExpressionContext)_localctx).right = numPyExpression();
				setState(99); match(T__3);
				}
				break;
			case 6:
				_localctx = new MatrixDivisionContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(101); match(ID);
				setState(102); match(T__19);
				setState(103); ((MatrixDivisionContext)_localctx).left = numPyExpression();
				setState(104); ((MatrixDivisionContext)_localctx).op = match(T__15);
				setState(105); ((MatrixDivisionContext)_localctx).right = numPyExpression();
				setState(106); match(T__3);
				}
				break;
			case 7:
				_localctx = new MatrixScalarDivisionContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(108); match(ID);
				setState(109); match(T__19);
				setState(110); ((MatrixScalarDivisionContext)_localctx).left = numPyExpression();
				setState(111); ((MatrixScalarDivisionContext)_localctx).op = match(T__15);
				setState(112); ((MatrixScalarDivisionContext)_localctx).right = numericScalar();
				setState(113); match(T__3);
				}
				break;
			case 8:
				_localctx = new MatrixSubExpressionContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(115); match(ID);
				setState(116); match(T__23);
				setState(117); numPyExpression();
				setState(118); ((MatrixSubExpressionContext)_localctx).op = match(T__15);
				setState(119); ((MatrixSubExpressionContext)_localctx).right = numPyExpression();
				setState(120); match(T__3);
				}
				break;
			case 9:
				_localctx = new MatrixTransposeExpressionContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(122); match(ID);
				setState(123); match(T__21);
				setState(124); numPyExpression();
				setState(125); match(T__3);
				}
				break;
			case 10:
				_localctx = new MatrixTraceExpressionContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(127); match(ID);
				setState(128); match(T__25);
				setState(129); numPyExpression();
				setState(130); match(T__3);
				}
				break;
			case 11:
				_localctx = new MatrixDiagonalExpressionContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(132); match(ID);
				setState(133); match(T__9);
				setState(134); numPyExpression();
				setState(135); match(T__3);
				}
				break;
			case 12:
				_localctx = new MatrixPowerExpressionContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(137); match(ID);
				setState(138); match(T__26);
				setState(139); numPyExpression();
				setState(140); ((MatrixPowerExpressionContext)_localctx).op = match(T__15);
				setState(141); numericScalar();
				setState(142); match(T__3);
				}
				break;
			case 13:
				_localctx = new MatrixDetExpressionContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(144); match(ID);
				setState(145); match(T__10);
				setState(146); numPyExpression();
				setState(147); match(T__3);
				}
				break;
			case 14:
				_localctx = new MatrixInvExpressionContext(_localctx);
				enterOuterAlt(_localctx, 14);
				{
				setState(149); match(ID);
				setState(150); match(T__27);
				setState(151); numPyExpression();
				setState(152); match(T__3);
				}
				break;
			case 15:
				_localctx = new MatrixRankExpressionContext(_localctx);
				enterOuterAlt(_localctx, 15);
				{
				setState(154); match(ID);
				setState(155); match(T__0);
				setState(156); numPyExpression();
				setState(157); match(T__3);
				}
				break;
			case 16:
				_localctx = new MatrixNormExpressionContext(_localctx);
				enterOuterAlt(_localctx, 16);
				{
				setState(159); match(ID);
				setState(160); match(T__22);
				setState(161); numPyExpression();
				setState(162); match(T__3);
				}
				break;
			case 17:
				_localctx = new MeanExpressionContext(_localctx);
				enterOuterAlt(_localctx, 17);
				{
				setState(164); match(ID);
				setState(165); match(T__1);
				setState(166); numPyExpression();
				setState(167); match(T__3);
				}
				break;
			case 18:
				_localctx = new AvgExpressionContext(_localctx);
				enterOuterAlt(_localctx, 18);
				{
				setState(169); match(ID);
				setState(170); match(T__18);
				setState(171); numPyExpression();
				setState(172); match(T__3);
				}
				break;
			case 19:
				_localctx = new VarExpressionContext(_localctx);
				enterOuterAlt(_localctx, 19);
				{
				setState(174); match(ID);
				setState(175); match(T__14);
				setState(176); numPyExpression();
				setState(177); match(T__3);
				}
				break;
			case 20:
				_localctx = new SDExperssionContext(_localctx);
				enterOuterAlt(_localctx, 20);
				{
				setState(179); match(ID);
				setState(180); match(T__24);
				setState(181); numPyExpression();
				setState(182); match(T__3);
				}
				break;
			case 21:
				_localctx = new SumExperssionContext(_localctx);
				enterOuterAlt(_localctx, 21);
				{
				setState(184); match(ID);
				setState(185); match(T__12);
				setState(186); numPyExpression();
				setState(187); match(T__3);
				}
				break;
			case 22:
				_localctx = new MaxExperssionContext(_localctx);
				enterOuterAlt(_localctx, 22);
				{
				setState(189); match(ID);
				setState(190); match(T__17);
				setState(191); numPyExpression();
				setState(192); match(T__3);
				}
				break;
			case 23:
				_localctx = new MinExperssionContext(_localctx);
				enterOuterAlt(_localctx, 23);
				{
				setState(194); match(ID);
				setState(195); match(T__8);
				setState(196); numPyExpression();
				setState(197); match(T__3);
				}
				break;
			case 24:
				_localctx = new ColumnsMeansExperssionContext(_localctx);
				enterOuterAlt(_localctx, 24);
				{
				setState(199); match(ID);
				setState(200); match(T__1);
				setState(201); numPyExpression();
				setState(202); ((ColumnsMeansExperssionContext)_localctx).op = match(T__15);
				setState(203); ((ColumnsMeansExperssionContext)_localctx).op = match(T__13);
				setState(204); match(T__3);
				}
				break;
			case 25:
				_localctx = new ColumnsVarExperssionContext(_localctx);
				enterOuterAlt(_localctx, 25);
				{
				setState(206); match(ID);
				setState(207); match(T__14);
				setState(208); numPyExpression();
				setState(209); ((ColumnsVarExperssionContext)_localctx).op = match(T__15);
				setState(210); ((ColumnsVarExperssionContext)_localctx).op = match(T__13);
				setState(211); match(T__3);
				}
				break;
			case 26:
				_localctx = new ColumnsSdsExperssionContext(_localctx);
				enterOuterAlt(_localctx, 26);
				{
				setState(213); match(ID);
				setState(214); match(T__24);
				setState(215); numPyExpression();
				setState(216); ((ColumnsSdsExperssionContext)_localctx).op = match(T__15);
				setState(217); ((ColumnsSdsExperssionContext)_localctx).op = match(T__13);
				setState(218); match(T__3);
				}
				break;
			case 27:
				_localctx = new ColumnsSumExperssionContext(_localctx);
				enterOuterAlt(_localctx, 27);
				{
				setState(220); match(ID);
				setState(221); match(T__12);
				setState(222); numPyExpression();
				setState(223); ((ColumnsSumExperssionContext)_localctx).op = match(T__15);
				setState(224); ((ColumnsSumExperssionContext)_localctx).op = match(T__13);
				setState(225); match(T__3);
				}
				break;
			case 28:
				_localctx = new ColumnsMaxExperssionContext(_localctx);
				enterOuterAlt(_localctx, 28);
				{
				setState(227); match(ID);
				setState(228); match(T__17);
				setState(229); numPyExpression();
				setState(230); ((ColumnsMaxExperssionContext)_localctx).op = match(T__15);
				setState(231); ((ColumnsMaxExperssionContext)_localctx).op = match(T__13);
				setState(232); match(T__3);
				}
				break;
			case 29:
				_localctx = new ColumnsMinExperssionContext(_localctx);
				enterOuterAlt(_localctx, 29);
				{
				setState(234); match(ID);
				setState(235); match(T__8);
				setState(236); numPyExpression();
				setState(237); ((ColumnsMinExperssionContext)_localctx).op = match(T__15);
				setState(238); ((ColumnsMinExperssionContext)_localctx).op = match(T__13);
				setState(239); match(T__3);
				}
				break;
			case 30:
				_localctx = new RowsMeansExperssionContext(_localctx);
				enterOuterAlt(_localctx, 30);
				{
				setState(241); match(ID);
				setState(242); match(T__1);
				setState(243); numPyExpression();
				setState(244); ((RowsMeansExperssionContext)_localctx).op = match(T__15);
				setState(245); ((RowsMeansExperssionContext)_localctx).op = match(T__4);
				setState(246); match(T__3);
				}
				break;
			case 31:
				_localctx = new RowsVarExperssionContext(_localctx);
				enterOuterAlt(_localctx, 31);
				{
				setState(248); match(ID);
				setState(249); match(T__14);
				setState(250); numPyExpression();
				setState(251); ((RowsVarExperssionContext)_localctx).op = match(T__15);
				setState(252); ((RowsVarExperssionContext)_localctx).op = match(T__4);
				setState(253); match(T__3);
				}
				break;
			case 32:
				_localctx = new RowsSdsExperssionContext(_localctx);
				enterOuterAlt(_localctx, 32);
				{
				setState(255); match(ID);
				setState(256); match(T__24);
				setState(257); numPyExpression();
				setState(258); ((RowsSdsExperssionContext)_localctx).op = match(T__15);
				setState(259); ((RowsSdsExperssionContext)_localctx).op = match(T__4);
				setState(260); match(T__3);
				}
				break;
			case 33:
				_localctx = new RowsSumExperssionContext(_localctx);
				enterOuterAlt(_localctx, 33);
				{
				setState(262); match(ID);
				setState(263); match(T__12);
				setState(264); numPyExpression();
				setState(265); ((RowsSumExperssionContext)_localctx).op = match(T__15);
				setState(266); ((RowsSumExperssionContext)_localctx).op = match(T__4);
				setState(267); match(T__3);
				}
				break;
			case 34:
				_localctx = new RowsMaxExperssionContext(_localctx);
				enterOuterAlt(_localctx, 34);
				{
				setState(269); match(ID);
				setState(270); match(T__17);
				setState(271); numPyExpression();
				setState(272); ((RowsMaxExperssionContext)_localctx).op = match(T__15);
				setState(273); ((RowsMaxExperssionContext)_localctx).op = match(T__4);
				setState(274); match(T__3);
				}
				break;
			case 35:
				_localctx = new RowsMinExperssionContext(_localctx);
				enterOuterAlt(_localctx, 35);
				{
				setState(276); match(ID);
				setState(277); match(T__8);
				setState(278); numPyExpression();
				setState(279); ((RowsMinExperssionContext)_localctx).op = match(T__15);
				setState(280); ((RowsMinExperssionContext)_localctx).op = match(T__4);
				setState(281); match(T__3);
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
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public ViewNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_viewName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterViewName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitViewName(this);
		}
	}

	public final ViewNameContext viewName() throws RecognitionException {
		ViewNameContext _localctx = new ViewNameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_viewName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285); match(ID);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public MatrixNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrixName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterMatrixName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitMatrixName(this);
		}
	}

	public final MatrixNameContext matrixName() throws RecognitionException {
		MatrixNameContext _localctx = new MatrixNameContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_matrixName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287); match(ID);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode ID() { return getToken(NumPyParser.ID, 0); }
		public MatrixNameExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matrixNameExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterMatrixNameExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitMatrixNameExpression(this);
		}
	}

	public final MatrixNameExpressionContext matrixNameExpression() throws RecognitionException {
		MatrixNameExpressionContext _localctx = new MatrixNameExpressionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_matrixNameExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(289); match(ID);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode INT() { return getToken(NumPyParser.INT, 0); }
		public NumericScalarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericScalar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterNumericScalar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitNumericScalar(this);
		}
	}

	public final NumericScalarContext numericScalar() throws RecognitionException {
		NumericScalarContext _localctx = new NumericScalarContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_numericScalar);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291); match(INT);
			}
		}
		catch (RecognitionException re) {
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
		public TerminalNode STRING() { return getToken(NumPyParser.STRING, 0); }
		public FilePathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_filePath; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).enterFilePath(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NumPyListener ) ((NumPyListener)listener).exitFilePath(this);
		}
	}

	public final FilePathContext filePath() throws RecognitionException {
		FilePathContext _localctx = new FilePathContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_filePath);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293); match(STRING);
			}
		}
		catch (RecognitionException re) {
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3&\u012a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\7\4-\n\4\f\4\16\4\60\13\4\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\5\68\n\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u011e\n\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\3\21\3\21\3\21\2\2\22\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \2"+
		"\2\u013d\2\"\3\2\2\2\4\'\3\2\2\2\6*\3\2\2\2\b\61\3\2\2\2\n\67\3\2\2\2"+
		"\f9\3\2\2\2\16;\3\2\2\2\20=\3\2\2\2\22F\3\2\2\2\24H\3\2\2\2\26\u011d\3"+
		"\2\2\2\30\u011f\3\2\2\2\32\u0121\3\2\2\2\34\u0123\3\2\2\2\36\u0125\3\2"+
		"\2\2 \u0127\3\2\2\2\"#\5\30\r\2#$\7\27\2\2$%\5\4\3\2%&\5\6\4\2&\3\3\2"+
		"\2\2\'(\7\34\2\2()\7\37\2\2)\5\3\2\2\2*.\5\b\5\2+-\5\b\5\2,+\3\2\2\2-"+
		"\60\3\2\2\2.,\3\2\2\2./\3\2\2\2/\7\3\2\2\2\60.\3\2\2\2\61\62\5\32\16\2"+
		"\62\63\7\n\2\2\63\64\5\n\6\2\64\t\3\2\2\2\658\5\f\7\2\668\5\26\f\2\67"+
		"\65\3\2\2\2\67\66\3\2\2\28\13\3\2\2\29:\5\16\b\2:\r\3\2\2\2;<\5\20\t\2"+
		"<\17\3\2\2\2=>\7\37\2\2>?\7\16\2\2?@\5\22\n\2@A\7\17\2\2AB\5\24\13\2B"+
		"C\7\n\2\2CD\7!\2\2DE\7\33\2\2E\21\3\2\2\2FG\7!\2\2G\23\3\2\2\2HI\7\37"+
		"\2\2I\25\3\2\2\2J\u011e\5\34\17\2KL\7\37\2\2LM\7\31\2\2MN\5\26\f\2NO\7"+
		"\17\2\2OP\5\26\f\2PQ\7\33\2\2Q\u011e\3\2\2\2RS\7\37\2\2ST\7\23\2\2TU\5"+
		"\26\f\2UV\7\17\2\2VW\5\26\f\2WX\7\33\2\2X\u011e\3\2\2\2YZ\7\37\2\2Z[\7"+
		"\23\2\2[\\\5\36\20\2\\]\7\17\2\2]^\5\26\f\2^_\7\33\2\2_\u011e\3\2\2\2"+
		"`a\7\37\2\2ab\7\30\2\2bc\5\26\f\2cd\7\17\2\2de\5\26\f\2ef\7\33\2\2f\u011e"+
		"\3\2\2\2gh\7\37\2\2hi\7\13\2\2ij\5\26\f\2jk\7\17\2\2kl\5\26\f\2lm\7\33"+
		"\2\2m\u011e\3\2\2\2no\7\37\2\2op\7\13\2\2pq\5\26\f\2qr\7\17\2\2rs\5\36"+
		"\20\2st\7\33\2\2t\u011e\3\2\2\2uv\7\37\2\2vw\7\7\2\2wx\5\26\f\2xy\7\17"+
		"\2\2yz\5\26\f\2z{\7\33\2\2{\u011e\3\2\2\2|}\7\37\2\2}~\7\t\2\2~\177\5"+
		"\26\f\2\177\u0080\7\33\2\2\u0080\u011e\3\2\2\2\u0081\u0082\7\37\2\2\u0082"+
		"\u0083\7\5\2\2\u0083\u0084\5\26\f\2\u0084\u0085\7\33\2\2\u0085\u011e\3"+
		"\2\2\2\u0086\u0087\7\37\2\2\u0087\u0088\7\25\2\2\u0088\u0089\5\26\f\2"+
		"\u0089\u008a\7\33\2\2\u008a\u011e\3\2\2\2\u008b\u008c\7\37\2\2\u008c\u008d"+
		"\7\4\2\2\u008d\u008e\5\26\f\2\u008e\u008f\7\17\2\2\u008f\u0090\5\36\20"+
		"\2\u0090\u0091\7\33\2\2\u0091\u011e\3\2\2\2\u0092\u0093\7\37\2\2\u0093"+
		"\u0094\7\24\2\2\u0094\u0095\5\26\f\2\u0095\u0096\7\33\2\2\u0096\u011e"+
		"\3\2\2\2\u0097\u0098\7\37\2\2\u0098\u0099\7\3\2\2\u0099\u009a\5\26\f\2"+
		"\u009a\u009b\7\33\2\2\u009b\u011e\3\2\2\2\u009c\u009d\7\37\2\2\u009d\u009e"+
		"\7\36\2\2\u009e\u009f\5\26\f\2\u009f\u00a0\7\33\2\2\u00a0\u011e\3\2\2"+
		"\2\u00a1\u00a2\7\37\2\2\u00a2\u00a3\7\b\2\2\u00a3\u00a4\5\26\f\2\u00a4"+
		"\u00a5\7\33\2\2\u00a5\u011e\3\2\2\2\u00a6\u00a7\7\37\2\2\u00a7\u00a8\7"+
		"\35\2\2\u00a8\u00a9\5\26\f\2\u00a9\u00aa\7\33\2\2\u00aa\u011e\3\2\2\2"+
		"\u00ab\u00ac\7\37\2\2\u00ac\u00ad\7\f\2\2\u00ad\u00ae\5\26\f\2\u00ae\u00af"+
		"\7\33\2\2\u00af\u011e\3\2\2\2\u00b0\u00b1\7\37\2\2\u00b1\u00b2\7\20\2"+
		"\2\u00b2\u00b3\5\26\f\2\u00b3\u00b4\7\33\2\2\u00b4\u011e\3\2\2\2\u00b5"+
		"\u00b6\7\37\2\2\u00b6\u00b7\7\6\2\2\u00b7\u00b8\5\26\f\2\u00b8\u00b9\7"+
		"\33\2\2\u00b9\u011e\3\2\2\2\u00ba\u00bb\7\37\2\2\u00bb\u00bc\7\22\2\2"+
		"\u00bc\u00bd\5\26\f\2\u00bd\u00be\7\33\2\2\u00be\u011e\3\2\2\2\u00bf\u00c0"+
		"\7\37\2\2\u00c0\u00c1\7\r\2\2\u00c1\u00c2\5\26\f\2\u00c2\u00c3\7\33\2"+
		"\2\u00c3\u011e\3\2\2\2\u00c4\u00c5\7\37\2\2\u00c5\u00c6\7\26\2\2\u00c6"+
		"\u00c7\5\26\f\2\u00c7\u00c8\7\33\2\2\u00c8\u011e\3\2\2\2\u00c9\u00ca\7"+
		"\37\2\2\u00ca\u00cb\7\35\2\2\u00cb\u00cc\5\26\f\2\u00cc\u00cd\7\17\2\2"+
		"\u00cd\u00ce\7\21\2\2\u00ce\u00cf\7\33\2\2\u00cf\u011e\3\2\2\2\u00d0\u00d1"+
		"\7\37\2\2\u00d1\u00d2\7\20\2\2\u00d2\u00d3\5\26\f\2\u00d3\u00d4\7\17\2"+
		"\2\u00d4\u00d5\7\21\2\2\u00d5\u00d6\7\33\2\2\u00d6\u011e\3\2\2\2\u00d7"+
		"\u00d8\7\37\2\2\u00d8\u00d9\7\6\2\2\u00d9\u00da\5\26\f\2\u00da\u00db\7"+
		"\17\2\2\u00db\u00dc\7\21\2\2\u00dc\u00dd\7\33\2\2\u00dd\u011e\3\2\2\2"+
		"\u00de\u00df\7\37\2\2\u00df\u00e0\7\22\2\2\u00e0\u00e1\5\26\f\2\u00e1"+
		"\u00e2\7\17\2\2\u00e2\u00e3\7\21\2\2\u00e3\u00e4\7\33\2\2\u00e4\u011e"+
		"\3\2\2\2\u00e5\u00e6\7\37\2\2\u00e6\u00e7\7\r\2\2\u00e7\u00e8\5\26\f\2"+
		"\u00e8\u00e9\7\17\2\2\u00e9\u00ea\7\21\2\2\u00ea\u00eb\7\33\2\2\u00eb"+
		"\u011e\3\2\2\2\u00ec\u00ed\7\37\2\2\u00ed\u00ee\7\26\2\2\u00ee\u00ef\5"+
		"\26\f\2\u00ef\u00f0\7\17\2\2\u00f0\u00f1\7\21\2\2\u00f1\u00f2\7\33\2\2"+
		"\u00f2\u011e\3\2\2\2\u00f3\u00f4\7\37\2\2\u00f4\u00f5\7\35\2\2\u00f5\u00f6"+
		"\5\26\f\2\u00f6\u00f7\7\17\2\2\u00f7\u00f8\7\32\2\2\u00f8\u00f9\7\33\2"+
		"\2\u00f9\u011e\3\2\2\2\u00fa\u00fb\7\37\2\2\u00fb\u00fc\7\20\2\2\u00fc"+
		"\u00fd\5\26\f\2\u00fd\u00fe\7\17\2\2\u00fe\u00ff\7\32\2\2\u00ff\u0100"+
		"\7\33\2\2\u0100\u011e\3\2\2\2\u0101\u0102\7\37\2\2\u0102\u0103\7\6\2\2"+
		"\u0103\u0104\5\26\f\2\u0104\u0105\7\17\2\2\u0105\u0106\7\32\2\2\u0106"+
		"\u0107\7\33\2\2\u0107\u011e\3\2\2\2\u0108\u0109\7\37\2\2\u0109\u010a\7"+
		"\22\2\2\u010a\u010b\5\26\f\2\u010b\u010c\7\17\2\2\u010c\u010d\7\32\2\2"+
		"\u010d\u010e\7\33\2\2\u010e\u011e\3\2\2\2\u010f\u0110\7\37\2\2\u0110\u0111"+
		"\7\r\2\2\u0111\u0112\5\26\f\2\u0112\u0113\7\17\2\2\u0113\u0114\7\32\2"+
		"\2\u0114\u0115\7\33\2\2\u0115\u011e\3\2\2\2\u0116\u0117\7\37\2\2\u0117"+
		"\u0118\7\26\2\2\u0118\u0119\5\26\f\2\u0119\u011a\7\17\2\2\u011a\u011b"+
		"\7\32\2\2\u011b\u011c\7\33\2\2\u011c\u011e\3\2\2\2\u011dJ\3\2\2\2\u011d"+
		"K\3\2\2\2\u011dR\3\2\2\2\u011dY\3\2\2\2\u011d`\3\2\2\2\u011dg\3\2\2\2"+
		"\u011dn\3\2\2\2\u011du\3\2\2\2\u011d|\3\2\2\2\u011d\u0081\3\2\2\2\u011d"+
		"\u0086\3\2\2\2\u011d\u008b\3\2\2\2\u011d\u0092\3\2\2\2\u011d\u0097\3\2"+
		"\2\2\u011d\u009c\3\2\2\2\u011d\u00a1\3\2\2\2\u011d\u00a6\3\2\2\2\u011d"+
		"\u00ab\3\2\2\2\u011d\u00b0\3\2\2\2\u011d\u00b5\3\2\2\2\u011d\u00ba\3\2"+
		"\2\2\u011d\u00bf\3\2\2\2\u011d\u00c4\3\2\2\2\u011d\u00c9\3\2\2\2\u011d"+
		"\u00d0\3\2\2\2\u011d\u00d7\3\2\2\2\u011d\u00de\3\2\2\2\u011d\u00e5\3\2"+
		"\2\2\u011d\u00ec\3\2\2\2\u011d\u00f3\3\2\2\2\u011d\u00fa\3\2\2\2\u011d"+
		"\u0101\3\2\2\2\u011d\u0108\3\2\2\2\u011d\u010f\3\2\2\2\u011d\u0116\3\2"+
		"\2\2\u011e\27\3\2\2\2\u011f\u0120\7\37\2\2\u0120\31\3\2\2\2\u0121\u0122"+
		"\7\37\2\2\u0122\33\3\2\2\2\u0123\u0124\7\37\2\2\u0124\35\3\2\2\2\u0125"+
		"\u0126\7\"\2\2\u0126\37\3\2\2\2\u0127\u0128\7!\2\2\u0128!\3\2\2\2\5.\67"+
		"\u011d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}