// Generated from SQL.g4 by ANTLR 4.7.2

package hadad.base.compiler.model.pr;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SQLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, FROM=6, SELECT=7, WHERE=8, AS=9, 
		AND=10, LIKE=11, NAME=12, STRING=13, INTEGER=14, WHITESPACE=15;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "FROM", "SELECT", "WHERE", "AS", 
			"AND", "LIKE", "NAME", "STRING", "ESCAPE", "UNICODE", "HEX", "INTEGER", 
			"WHITESPACE", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", 
			"L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", 
			"Z"
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


	public SQLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SQL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\21\u00f9\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7"+
		"\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\7\r\u0086\n\r\f\r\16\r"+
		"\u0089\13\r\3\16\3\16\3\16\7\16\u008e\n\16\f\16\16\16\u0091\13\16\3\16"+
		"\3\16\3\16\3\16\7\16\u0097\n\16\f\16\16\16\u009a\13\16\3\16\3\16\3\16"+
		"\3\16\7\16\u00a0\n\16\f\16\16\16\u00a3\13\16\3\16\5\16\u00a6\n\16\3\17"+
		"\3\17\3\17\5\17\u00ab\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22"+
		"\3\22\3\22\7\22\u00b8\n\22\f\22\16\22\u00bb\13\22\5\22\u00bd\n\22\3\23"+
		"\6\23\u00c0\n\23\r\23\16\23\u00c1\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3"+
		"\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3"+
		"\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3"+
		"\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\2\2.\3\3\5\4\7\5\t\6\13\7\r"+
		"\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\2\37\2!\2#\20%\21\'\2)\2+"+
		"\2-\2/\2\61\2\63\2\65\2\67\29\2;\2=\2?\2A\2C\2E\2G\2I\2K\2M\2O\2Q\2S\2"+
		"U\2W\2Y\2\3\2%\6\2\62;C\\aac|\4\2$$^^\4\2))^^\4\2\'\'^^\13\2$$))\61\61"+
		"^^ddhhppttvv\5\2\62;CHch\3\2\63;\3\2\62;\5\2\13\f\17\17\"\"\4\2CCcc\4"+
		"\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLl"+
		"l\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2"+
		"UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\2\u00e8"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3[\3\2\2\2\5]\3\2\2\2"+
		"\7_\3\2\2\2\ta\3\2\2\2\13c\3\2\2\2\re\3\2\2\2\17j\3\2\2\2\21q\3\2\2\2"+
		"\23w\3\2\2\2\25z\3\2\2\2\27~\3\2\2\2\31\u0083\3\2\2\2\33\u00a5\3\2\2\2"+
		"\35\u00a7\3\2\2\2\37\u00ac\3\2\2\2!\u00b2\3\2\2\2#\u00bc\3\2\2\2%\u00bf"+
		"\3\2\2\2\'\u00c5\3\2\2\2)\u00c7\3\2\2\2+\u00c9\3\2\2\2-\u00cb\3\2\2\2"+
		"/\u00cd\3\2\2\2\61\u00cf\3\2\2\2\63\u00d1\3\2\2\2\65\u00d3\3\2\2\2\67"+
		"\u00d5\3\2\2\29\u00d7\3\2\2\2;\u00d9\3\2\2\2=\u00db\3\2\2\2?\u00dd\3\2"+
		"\2\2A\u00df\3\2\2\2C\u00e1\3\2\2\2E\u00e3\3\2\2\2G\u00e5\3\2\2\2I\u00e7"+
		"\3\2\2\2K\u00e9\3\2\2\2M\u00eb\3\2\2\2O\u00ed\3\2\2\2Q\u00ef\3\2\2\2S"+
		"\u00f1\3\2\2\2U\u00f3\3\2\2\2W\u00f5\3\2\2\2Y\u00f7\3\2\2\2[\\\7?\2\2"+
		"\\\4\3\2\2\2]^\7.\2\2^\6\3\2\2\2_`\7*\2\2`\b\3\2\2\2ab\7+\2\2b\n\3\2\2"+
		"\2cd\7\60\2\2d\f\3\2\2\2ef\5\61\31\2fg\5I%\2gh\5C\"\2hi\5? \2i\16\3\2"+
		"\2\2jk\5K&\2kl\5/\30\2lm\5=\37\2mn\5/\30\2no\5+\26\2op\5M\'\2p\20\3\2"+
		"\2\2qr\5S*\2rs\5\65\33\2st\5/\30\2tu\5I%\2uv\5/\30\2v\22\3\2\2\2wx\5\'"+
		"\24\2xy\5K&\2y\24\3\2\2\2z{\5\'\24\2{|\5A!\2|}\5-\27\2}\26\3\2\2\2~\177"+
		"\5=\37\2\177\u0080\5\67\34\2\u0080\u0081\5;\36\2\u0081\u0082\5/\30\2\u0082"+
		"\30\3\2\2\2\u0083\u0087\t\2\2\2\u0084\u0086\t\2\2\2\u0085\u0084\3\2\2"+
		"\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\32"+
		"\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008f\7$\2\2\u008b\u008e\5\35\17\2"+
		"\u008c\u008e\n\3\2\2\u008d\u008b\3\2\2\2\u008d\u008c\3\2\2\2\u008e\u0091"+
		"\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2\2\2\u0091"+
		"\u008f\3\2\2\2\u0092\u00a6\7$\2\2\u0093\u0098\7)\2\2\u0094\u0097\5\35"+
		"\17\2\u0095\u0097\n\4\2\2\u0096\u0094\3\2\2\2\u0096\u0095\3\2\2\2\u0097"+
		"\u009a\3\2\2\2\u0098\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009b\3\2"+
		"\2\2\u009a\u0098\3\2\2\2\u009b\u00a6\7)\2\2\u009c\u00a1\7\'\2\2\u009d"+
		"\u00a0\5\35\17\2\u009e\u00a0\n\5\2\2\u009f\u009d\3\2\2\2\u009f\u009e\3"+
		"\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2"+
		"\u00a4\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a6\7\'\2\2\u00a5\u008a\3\2"+
		"\2\2\u00a5\u0093\3\2\2\2\u00a5\u009c\3\2\2\2\u00a6\34\3\2\2\2\u00a7\u00aa"+
		"\7^\2\2\u00a8\u00ab\t\6\2\2\u00a9\u00ab\5\37\20\2\u00aa\u00a8\3\2\2\2"+
		"\u00aa\u00a9\3\2\2\2\u00ab\36\3\2\2\2\u00ac\u00ad\7w\2\2\u00ad\u00ae\5"+
		"!\21\2\u00ae\u00af\5!\21\2\u00af\u00b0\5!\21\2\u00b0\u00b1\5!\21\2\u00b1"+
		" \3\2\2\2\u00b2\u00b3\t\7\2\2\u00b3\"\3\2\2\2\u00b4\u00bd\7\62\2\2\u00b5"+
		"\u00b9\t\b\2\2\u00b6\u00b8\t\t\2\2\u00b7\u00b6\3\2\2\2\u00b8\u00bb\3\2"+
		"\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb"+
		"\u00b9\3\2\2\2\u00bc\u00b4\3\2\2\2\u00bc\u00b5\3\2\2\2\u00bd$\3\2\2\2"+
		"\u00be\u00c0\t\n\2\2\u00bf\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00bf"+
		"\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\u00c3\3\2\2\2\u00c3\u00c4\b\23\2\2"+
		"\u00c4&\3\2\2\2\u00c5\u00c6\t\13\2\2\u00c6(\3\2\2\2\u00c7\u00c8\t\f\2"+
		"\2\u00c8*\3\2\2\2\u00c9\u00ca\t\r\2\2\u00ca,\3\2\2\2\u00cb\u00cc\t\16"+
		"\2\2\u00cc.\3\2\2\2\u00cd\u00ce\t\17\2\2\u00ce\60\3\2\2\2\u00cf\u00d0"+
		"\t\20\2\2\u00d0\62\3\2\2\2\u00d1\u00d2\t\21\2\2\u00d2\64\3\2\2\2\u00d3"+
		"\u00d4\t\22\2\2\u00d4\66\3\2\2\2\u00d5\u00d6\t\23\2\2\u00d68\3\2\2\2\u00d7"+
		"\u00d8\t\24\2\2\u00d8:\3\2\2\2\u00d9\u00da\t\25\2\2\u00da<\3\2\2\2\u00db"+
		"\u00dc\t\26\2\2\u00dc>\3\2\2\2\u00dd\u00de\t\27\2\2\u00de@\3\2\2\2\u00df"+
		"\u00e0\t\30\2\2\u00e0B\3\2\2\2\u00e1\u00e2\t\31\2\2\u00e2D\3\2\2\2\u00e3"+
		"\u00e4\t\32\2\2\u00e4F\3\2\2\2\u00e5\u00e6\t\33\2\2\u00e6H\3\2\2\2\u00e7"+
		"\u00e8\t\34\2\2\u00e8J\3\2\2\2\u00e9\u00ea\t\35\2\2\u00eaL\3\2\2\2\u00eb"+
		"\u00ec\t\36\2\2\u00ecN\3\2\2\2\u00ed\u00ee\t\37\2\2\u00eeP\3\2\2\2\u00ef"+
		"\u00f0\t \2\2\u00f0R\3\2\2\2\u00f1\u00f2\t!\2\2\u00f2T\3\2\2\2\u00f3\u00f4"+
		"\t\"\2\2\u00f4V\3\2\2\2\u00f5\u00f6\t#\2\2\u00f6X\3\2\2\2\u00f7\u00f8"+
		"\t$\2\2\u00f8Z\3\2\2\2\17\2\u0087\u008d\u008f\u0096\u0098\u009f\u00a1"+
		"\u00a5\u00aa\u00b9\u00bc\u00c1\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}