// Generated from SJQL.g4 by ANTLR 4.4

package hadad.base.compiler.model.sj;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SJQLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__8=1, T__7=2, T__6=3, T__5=4, T__4=5, T__3=6, T__2=7, T__1=8, T__0=9, 
		QUERY=10, SOLRJSONBUILDOBJECT=11, NAME=12, STRING=13, INTEGER=14, WHITESPACE=15;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'"
	};
	public static final String[] ruleNames = {
		"T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", 
		"QUERY", "SOLRJSONBUILDOBJECT", "NAME", "STRING", "ESCAPE", "UNICODE", 
		"HEX", "INTEGER", "WHITESPACE", "A", "B", "C", "D", "E", "F", "G", "H", 
		"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", 
		"W", "X", "Y", "Z"
	};


	public SJQLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SJQL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\21\u00f8\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f"+
		"\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\7\r\u008e\n\r\f\r\16\r\u0091\13\r\3\16\3\16\3\16\7\16\u0096"+
		"\n\16\f\16\16\16\u0099\13\16\3\16\3\16\3\16\3\16\7\16\u009f\n\16\f\16"+
		"\16\16\u00a2\13\16\3\16\5\16\u00a5\n\16\3\17\3\17\3\17\5\17\u00aa\n\17"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22\3\22\7\22\u00b7\n\22"+
		"\f\22\16\22\u00ba\13\22\5\22\u00bc\n\22\3\23\6\23\u00bf\n\23\r\23\16\23"+
		"\u00c0\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31"+
		"\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3"+
		" \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3"+
		"+\3,\3,\3-\3-\2\2.\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r"+
		"\31\16\33\17\35\2\37\2!\2#\20%\21\'\2)\2+\2-\2/\2\61\2\63\2\65\2\67\2"+
		"9\2;\2=\2?\2A\2C\2E\2G\2I\2K\2M\2O\2Q\2S\2U\2W\2Y\2\3\2$\5\2C\\aac|\4"+
		"\2$$^^\4\2))^^\13\2$$))\61\61^^ddhhppttvv\5\2\62;CHch\3\2\63;\3\2\62;"+
		"\5\2\13\f\17\17\"\"\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4"+
		"\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQq"+
		"q\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2"+
		"ZZzz\4\2[[{{\4\2\\\\||\u00e4\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3"+
		"\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2"+
		"\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\3[\3\2\2\2\5]\3\2\2\2\7_\3\2\2\2\ta\3\2\2\2\13c\3\2\2\2\re\3\2\2"+
		"\2\17g\3\2\2\2\21k\3\2\2\2\23m\3\2\2\2\25q\3\2\2\2\27w\3\2\2\2\31\u008b"+
		"\3\2\2\2\33\u00a4\3\2\2\2\35\u00a6\3\2\2\2\37\u00ab\3\2\2\2!\u00b1\3\2"+
		"\2\2#\u00bb\3\2\2\2%\u00be\3\2\2\2\'\u00c4\3\2\2\2)\u00c6\3\2\2\2+\u00c8"+
		"\3\2\2\2-\u00ca\3\2\2\2/\u00cc\3\2\2\2\61\u00ce\3\2\2\2\63\u00d0\3\2\2"+
		"\2\65\u00d2\3\2\2\2\67\u00d4\3\2\2\29\u00d6\3\2\2\2;\u00d8\3\2\2\2=\u00da"+
		"\3\2\2\2?\u00dc\3\2\2\2A\u00de\3\2\2\2C\u00e0\3\2\2\2E\u00e2\3\2\2\2G"+
		"\u00e4\3\2\2\2I\u00e6\3\2\2\2K\u00e8\3\2\2\2M\u00ea\3\2\2\2O\u00ec\3\2"+
		"\2\2Q\u00ee\3\2\2\2S\u00f0\3\2\2\2U\u00f2\3\2\2\2W\u00f4\3\2\2\2Y\u00f6"+
		"\3\2\2\2[\\\7\61\2\2\\\4\3\2\2\2]^\7(\2\2^\6\3\2\2\2_`\7*\2\2`\b\3\2\2"+
		"\2ab\7+\2\2b\n\3\2\2\2cd\7<\2\2d\f\3\2\2\2ef\7.\2\2f\16\3\2\2\2gh\7h\2"+
		"\2hi\7n\2\2ij\7?\2\2j\20\3\2\2\2kl\7?\2\2l\22\3\2\2\2mn\7A\2\2no\7s\2"+
		"\2op\7?\2\2p\24\3\2\2\2qr\5G$\2rs\5O(\2st\5/\30\2tu\5I%\2uv\5W,\2v\26"+
		"\3\2\2\2wx\5K&\2xy\5C\"\2yz\5=\37\2z{\5I%\2{|\59\35\2|}\5K&\2}~\5C\"\2"+
		"~\177\5A!\2\177\u0080\5)\25\2\u0080\u0081\5O(\2\u0081\u0082\5\67\34\2"+
		"\u0082\u0083\5=\37\2\u0083\u0084\5-\27\2\u0084\u0085\5C\"\2\u0085\u0086"+
		"\5)\25\2\u0086\u0087\59\35\2\u0087\u0088\5/\30\2\u0088\u0089\5+\26\2\u0089"+
		"\u008a\5M\'\2\u008a\30\3\2\2\2\u008b\u008f\t\2\2\2\u008c\u008e\t\2\2\2"+
		"\u008d\u008c\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090"+
		"\3\2\2\2\u0090\32\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0097\7$\2\2\u0093"+
		"\u0096\5\35\17\2\u0094\u0096\n\3\2\2\u0095\u0093\3\2\2\2\u0095\u0094\3"+
		"\2\2\2\u0096\u0099\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098"+
		"\u009a\3\2\2\2\u0099\u0097\3\2\2\2\u009a\u00a5\7$\2\2\u009b\u00a0\7)\2"+
		"\2\u009c\u009f\5\35\17\2\u009d\u009f\n\4\2\2\u009e\u009c\3\2\2\2\u009e"+
		"\u009d\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2"+
		"\2\2\u00a1\u00a3\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a5\7)\2\2\u00a4"+
		"\u0092\3\2\2\2\u00a4\u009b\3\2\2\2\u00a5\34\3\2\2\2\u00a6\u00a9\7^\2\2"+
		"\u00a7\u00aa\t\5\2\2\u00a8\u00aa\5\37\20\2\u00a9\u00a7\3\2\2\2\u00a9\u00a8"+
		"\3\2\2\2\u00aa\36\3\2\2\2\u00ab\u00ac\7w\2\2\u00ac\u00ad\5!\21\2\u00ad"+
		"\u00ae\5!\21\2\u00ae\u00af\5!\21\2\u00af\u00b0\5!\21\2\u00b0 \3\2\2\2"+
		"\u00b1\u00b2\t\6\2\2\u00b2\"\3\2\2\2\u00b3\u00bc\7\62\2\2\u00b4\u00b8"+
		"\t\7\2\2\u00b5\u00b7\t\b\2\2\u00b6\u00b5\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8"+
		"\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bc\3\2\2\2\u00ba\u00b8\3\2"+
		"\2\2\u00bb\u00b3\3\2\2\2\u00bb\u00b4\3\2\2\2\u00bc$\3\2\2\2\u00bd\u00bf"+
		"\t\t\2\2\u00be\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0"+
		"\u00c1\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\b\23\2\2\u00c3&\3\2\2\2"+
		"\u00c4\u00c5\t\n\2\2\u00c5(\3\2\2\2\u00c6\u00c7\t\13\2\2\u00c7*\3\2\2"+
		"\2\u00c8\u00c9\t\f\2\2\u00c9,\3\2\2\2\u00ca\u00cb\t\r\2\2\u00cb.\3\2\2"+
		"\2\u00cc\u00cd\t\16\2\2\u00cd\60\3\2\2\2\u00ce\u00cf\t\17\2\2\u00cf\62"+
		"\3\2\2\2\u00d0\u00d1\t\20\2\2\u00d1\64\3\2\2\2\u00d2\u00d3\t\21\2\2\u00d3"+
		"\66\3\2\2\2\u00d4\u00d5\t\22\2\2\u00d58\3\2\2\2\u00d6\u00d7\t\23\2\2\u00d7"+
		":\3\2\2\2\u00d8\u00d9\t\24\2\2\u00d9<\3\2\2\2\u00da\u00db\t\25\2\2\u00db"+
		">\3\2\2\2\u00dc\u00dd\t\26\2\2\u00dd@\3\2\2\2\u00de\u00df\t\27\2\2\u00df"+
		"B\3\2\2\2\u00e0\u00e1\t\30\2\2\u00e1D\3\2\2\2\u00e2\u00e3\t\31\2\2\u00e3"+
		"F\3\2\2\2\u00e4\u00e5\t\32\2\2\u00e5H\3\2\2\2\u00e6\u00e7\t\33\2\2\u00e7"+
		"J\3\2\2\2\u00e8\u00e9\t\34\2\2\u00e9L\3\2\2\2\u00ea\u00eb\t\35\2\2\u00eb"+
		"N\3\2\2\2\u00ec\u00ed\t\36\2\2\u00edP\3\2\2\2\u00ee\u00ef\t\37\2\2\u00ef"+
		"R\3\2\2\2\u00f0\u00f1\t \2\2\u00f1T\3\2\2\2\u00f2\u00f3\t!\2\2\u00f3V"+
		"\3\2\2\2\u00f4\u00f5\t\"\2\2\u00f5X\3\2\2\2\u00f6\u00f7\t#\2\2\u00f7Z"+
		"\3\2\2\2\r\2\u008f\u0095\u0097\u009e\u00a0\u00a4\u00a9\u00b8\u00bb\u00c0"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}