// Generated from KQL.g4 by ANTLR 4.7.2

package hadad.base.compiler.model.rk;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class KQLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, FROM=11, SELECT=12, WHERE=13, IN=14, MAP=15, KEYS=16, LIST=17, 
		SET=18, MAIN=19, NAME=20, STRING=21, INTEGER=22, WHITESPACE=23;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "FROM", "SELECT", "WHERE", "IN", "MAP", "KEYS", "LIST", "SET", 
			"MAIN", "NAME", "STRING", "ESCAPE", "UNICODE", "HEX", "INTEGER", "WHITESPACE", 
			"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", 
			"O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
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


	public KQLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "KQL.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\31\u0118\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3\20"+
		"\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\25\3\25\7\25\u00ae\n\25\f\25\16\25\u00b1\13"+
		"\25\3\26\3\26\3\26\7\26\u00b6\n\26\f\26\16\26\u00b9\13\26\3\26\3\26\3"+
		"\26\3\26\7\26\u00bf\n\26\f\26\16\26\u00c2\13\26\3\26\5\26\u00c5\n\26\3"+
		"\27\3\27\3\27\5\27\u00ca\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31"+
		"\3\32\3\32\3\32\7\32\u00d7\n\32\f\32\16\32\u00da\13\32\5\32\u00dc\n\32"+
		"\3\33\6\33\u00df\n\33\r\33\16\33\u00e0\3\33\3\33\3\34\3\34\3\35\3\35\3"+
		"\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'"+
		"\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3"+
		"\62\3\62\3\63\3\63\3\64\3\64\3\65\3\65\2\2\66\3\3\5\4\7\5\t\6\13\7\r\b"+
		"\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26"+
		"+\27-\2/\2\61\2\63\30\65\31\67\29\2;\2=\2?\2A\2C\2E\2G\2I\2K\2M\2O\2Q"+
		"\2S\2U\2W\2Y\2[\2]\2_\2a\2c\2e\2g\2i\2\3\2$\5\2C\\aac|\4\2$$^^\4\2))^"+
		"^\13\2$$))\61\61^^ddhhppttvv\5\2\62;CHch\3\2\63;\3\2\62;\5\2\13\f\17\17"+
		"\"\"\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4"+
		"\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSs"+
		"s\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2"+
		"\\\\||\2\u0104\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\3k\3\2\2\2\5m\3\2\2\2\7o\3\2\2\2\tq\3\2\2\2\13s\3"+
		"\2\2\2\ru\3\2\2\2\17w\3\2\2\2\21y\3\2\2\2\23{\3\2\2\2\25}\3\2\2\2\27\177"+
		"\3\2\2\2\31\u0084\3\2\2\2\33\u008b\3\2\2\2\35\u0091\3\2\2\2\37\u0094\3"+
		"\2\2\2!\u0098\3\2\2\2#\u009d\3\2\2\2%\u00a2\3\2\2\2\'\u00a6\3\2\2\2)\u00ab"+
		"\3\2\2\2+\u00c4\3\2\2\2-\u00c6\3\2\2\2/\u00cb\3\2\2\2\61\u00d1\3\2\2\2"+
		"\63\u00db\3\2\2\2\65\u00de\3\2\2\2\67\u00e4\3\2\2\29\u00e6\3\2\2\2;\u00e8"+
		"\3\2\2\2=\u00ea\3\2\2\2?\u00ec\3\2\2\2A\u00ee\3\2\2\2C\u00f0\3\2\2\2E"+
		"\u00f2\3\2\2\2G\u00f4\3\2\2\2I\u00f6\3\2\2\2K\u00f8\3\2\2\2M\u00fa\3\2"+
		"\2\2O\u00fc\3\2\2\2Q\u00fe\3\2\2\2S\u0100\3\2\2\2U\u0102\3\2\2\2W\u0104"+
		"\3\2\2\2Y\u0106\3\2\2\2[\u0108\3\2\2\2]\u010a\3\2\2\2_\u010c\3\2\2\2a"+
		"\u010e\3\2\2\2c\u0110\3\2\2\2e\u0112\3\2\2\2g\u0114\3\2\2\2i\u0116\3\2"+
		"\2\2kl\7?\2\2l\4\3\2\2\2mn\7/\2\2n\6\3\2\2\2op\7@\2\2p\b\3\2\2\2qr\7}"+
		"\2\2r\n\3\2\2\2st\7.\2\2t\f\3\2\2\2uv\7\177\2\2v\16\3\2\2\2wx\7<\2\2x"+
		"\20\3\2\2\2yz\7\60\2\2z\22\3\2\2\2{|\7]\2\2|\24\3\2\2\2}~\7_\2\2~\26\3"+
		"\2\2\2\177\u0080\5A!\2\u0080\u0081\5Y-\2\u0081\u0082\5S*\2\u0082\u0083"+
		"\5O(\2\u0083\30\3\2\2\2\u0084\u0085\5[.\2\u0085\u0086\5? \2\u0086\u0087"+
		"\5M\'\2\u0087\u0088\5? \2\u0088\u0089\5;\36\2\u0089\u008a\5]/\2\u008a"+
		"\32\3\2\2\2\u008b\u008c\5c\62\2\u008c\u008d\5E#\2\u008d\u008e\5? \2\u008e"+
		"\u008f\5Y-\2\u008f\u0090\5? \2\u0090\34\3\2\2\2\u0091\u0092\5G$\2\u0092"+
		"\u0093\5Q)\2\u0093\36\3\2\2\2\u0094\u0095\5O(\2\u0095\u0096\5\67\34\2"+
		"\u0096\u0097\5U+\2\u0097 \3\2\2\2\u0098\u0099\5K&\2\u0099\u009a\5? \2"+
		"\u009a\u009b\5g\64\2\u009b\u009c\5[.\2\u009c\"\3\2\2\2\u009d\u009e\5M"+
		"\'\2\u009e\u009f\5G$\2\u009f\u00a0\5[.\2\u00a0\u00a1\5]/\2\u00a1$\3\2"+
		"\2\2\u00a2\u00a3\5[.\2\u00a3\u00a4\5? \2\u00a4\u00a5\5]/\2\u00a5&\3\2"+
		"\2\2\u00a6\u00a7\5O(\2\u00a7\u00a8\5\67\34\2\u00a8\u00a9\5G$\2\u00a9\u00aa"+
		"\5Q)\2\u00aa(\3\2\2\2\u00ab\u00af\t\2\2\2\u00ac\u00ae\t\2\2\2\u00ad\u00ac"+
		"\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00af\u00b0\3\2\2\2\u00b0"+
		"*\3\2\2\2\u00b1\u00af\3\2\2\2\u00b2\u00b7\7$\2\2\u00b3\u00b6\5-\27\2\u00b4"+
		"\u00b6\n\3\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6\u00b9\3\2"+
		"\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8\u00ba\3\2\2\2\u00b9"+
		"\u00b7\3\2\2\2\u00ba\u00c5\7$\2\2\u00bb\u00c0\7)\2\2\u00bc\u00bf\5-\27"+
		"\2\u00bd\u00bf\n\4\2\2\u00be\u00bc\3\2\2\2\u00be\u00bd\3\2\2\2\u00bf\u00c2"+
		"\3\2\2\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00c3\3\2\2\2\u00c2"+
		"\u00c0\3\2\2\2\u00c3\u00c5\7)\2\2\u00c4\u00b2\3\2\2\2\u00c4\u00bb\3\2"+
		"\2\2\u00c5,\3\2\2\2\u00c6\u00c9\7^\2\2\u00c7\u00ca\t\5\2\2\u00c8\u00ca"+
		"\5/\30\2\u00c9\u00c7\3\2\2\2\u00c9\u00c8\3\2\2\2\u00ca.\3\2\2\2\u00cb"+
		"\u00cc\7w\2\2\u00cc\u00cd\5\61\31\2\u00cd\u00ce\5\61\31\2\u00ce\u00cf"+
		"\5\61\31\2\u00cf\u00d0\5\61\31\2\u00d0\60\3\2\2\2\u00d1\u00d2\t\6\2\2"+
		"\u00d2\62\3\2\2\2\u00d3\u00dc\7\62\2\2\u00d4\u00d8\t\7\2\2\u00d5\u00d7"+
		"\t\b\2\2\u00d6\u00d5\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8"+
		"\u00d9\3\2\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00d3\3\2"+
		"\2\2\u00db\u00d4\3\2\2\2\u00dc\64\3\2\2\2\u00dd\u00df\t\t\2\2\u00de\u00dd"+
		"\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1"+
		"\u00e2\3\2\2\2\u00e2\u00e3\b\33\2\2\u00e3\66\3\2\2\2\u00e4\u00e5\t\n\2"+
		"\2\u00e58\3\2\2\2\u00e6\u00e7\t\13\2\2\u00e7:\3\2\2\2\u00e8\u00e9\t\f"+
		"\2\2\u00e9<\3\2\2\2\u00ea\u00eb\t\r\2\2\u00eb>\3\2\2\2\u00ec\u00ed\t\16"+
		"\2\2\u00ed@\3\2\2\2\u00ee\u00ef\t\17\2\2\u00efB\3\2\2\2\u00f0\u00f1\t"+
		"\20\2\2\u00f1D\3\2\2\2\u00f2\u00f3\t\21\2\2\u00f3F\3\2\2\2\u00f4\u00f5"+
		"\t\22\2\2\u00f5H\3\2\2\2\u00f6\u00f7\t\23\2\2\u00f7J\3\2\2\2\u00f8\u00f9"+
		"\t\24\2\2\u00f9L\3\2\2\2\u00fa\u00fb\t\25\2\2\u00fbN\3\2\2\2\u00fc\u00fd"+
		"\t\26\2\2\u00fdP\3\2\2\2\u00fe\u00ff\t\27\2\2\u00ffR\3\2\2\2\u0100\u0101"+
		"\t\30\2\2\u0101T\3\2\2\2\u0102\u0103\t\31\2\2\u0103V\3\2\2\2\u0104\u0105"+
		"\t\32\2\2\u0105X\3\2\2\2\u0106\u0107\t\33\2\2\u0107Z\3\2\2\2\u0108\u0109"+
		"\t\34\2\2\u0109\\\3\2\2\2\u010a\u010b\t\35\2\2\u010b^\3\2\2\2\u010c\u010d"+
		"\t\36\2\2\u010d`\3\2\2\2\u010e\u010f\t\37\2\2\u010fb\3\2\2\2\u0110\u0111"+
		"\t \2\2\u0111d\3\2\2\2\u0112\u0113\t!\2\2\u0113f\3\2\2\2\u0114\u0115\t"+
		"\"\2\2\u0115h\3\2\2\2\u0116\u0117\t#\2\2\u0117j\3\2\2\2\r\2\u00af\u00b5"+
		"\u00b7\u00be\u00c0\u00c4\u00c9\u00d8\u00db\u00e0\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}