// Generated from SPPJQL.g4 by ANTLR 4.7.2

package hadad.base.compiler.model.sppj;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SPPJQLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, FROM=9, 
		SELECT=10, WHERE=11, IN=12, MAP=13, KEYS=14, LIST=15, SET=16, MAIN=17, 
		JSONBUILDOBJECT=18, JSONARRAYELEMENTS=19, AS=20, AND=21, NAME=22, STRING=23, 
		INTEGER=24, WHITESPACE=25;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "FROM", 
			"SELECT", "WHERE", "IN", "MAP", "KEYS", "LIST", "SET", "MAIN", "JSONBUILDOBJECT", 
			"JSONARRAYELEMENTS", "AS", "AND", "NAME", "STRING", "ESCAPE", "UNICODE", 
			"HEX", "INTEGER", "WHITESPACE", "A", "B", "C", "D", "E", "F", "G", "H", 
			"I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", 
			"W", "X", "Y", "Z"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "'{'", "':'", "'}'", "','", "'('", "')'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "FROM", "SELECT", 
			"WHERE", "IN", "MAP", "KEYS", "LIST", "SET", "MAIN", "JSONBUILDOBJECT", 
			"JSONARRAYELEMENTS", "AS", "AND", "NAME", "STRING", "INTEGER", "WHITESPACE"
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


	public SPPJQLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SPPJQL.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\33\u0141\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\4\65\t\65\4\66\t\66\4\67\t\67\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\27\3\27\7\27\u00d7\n\27\f\27\16\27\u00da\13\27"+
		"\3\30\3\30\3\30\7\30\u00df\n\30\f\30\16\30\u00e2\13\30\3\30\3\30\3\30"+
		"\3\30\7\30\u00e8\n\30\f\30\16\30\u00eb\13\30\3\30\5\30\u00ee\n\30\3\31"+
		"\3\31\3\31\5\31\u00f3\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\34"+
		"\3\34\3\34\7\34\u0100\n\34\f\34\16\34\u0103\13\34\5\34\u0105\n\34\3\35"+
		"\6\35\u0108\n\35\r\35\16\35\u0109\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 "+
		"\3!\3!\3\"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3"+
		"+\3,\3,\3-\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64"+
		"\3\64\3\65\3\65\3\66\3\66\3\67\3\67\2\28\3\3\5\4\7\5\t\6\13\7\r\b\17\t"+
		"\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27"+
		"-\30/\31\61\2\63\2\65\2\67\329\33;\2=\2?\2A\2C\2E\2G\2I\2K\2M\2O\2Q\2"+
		"S\2U\2W\2Y\2[\2]\2_\2a\2c\2e\2g\2i\2k\2m\2\3\2$\5\2C\\aac|\4\2$$^^\4\2"+
		"))^^\13\2$$))\61\61^^ddhhppttvv\5\2\62;CHch\3\2\63;\3\2\62;\5\2\13\f\17"+
		"\17\"\"\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJ"+
		"jj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2"+
		"SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4"+
		"\2\\\\||\2\u012d\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\3o\3\2\2\2\5q\3\2\2\2\7s\3\2"+
		"\2\2\tu\3\2\2\2\13w\3\2\2\2\ry\3\2\2\2\17{\3\2\2\2\21}\3\2\2\2\23\177"+
		"\3\2\2\2\25\u0084\3\2\2\2\27\u008b\3\2\2\2\31\u0091\3\2\2\2\33\u0094\3"+
		"\2\2\2\35\u0098\3\2\2\2\37\u009d\3\2\2\2!\u00a2\3\2\2\2#\u00a6\3\2\2\2"+
		"%\u00ab\3\2\2\2\'\u00bb\3\2\2\2)\u00cd\3\2\2\2+\u00d0\3\2\2\2-\u00d4\3"+
		"\2\2\2/\u00ed\3\2\2\2\61\u00ef\3\2\2\2\63\u00f4\3\2\2\2\65\u00fa\3\2\2"+
		"\2\67\u0104\3\2\2\29\u0107\3\2\2\2;\u010d\3\2\2\2=\u010f\3\2\2\2?\u0111"+
		"\3\2\2\2A\u0113\3\2\2\2C\u0115\3\2\2\2E\u0117\3\2\2\2G\u0119\3\2\2\2I"+
		"\u011b\3\2\2\2K\u011d\3\2\2\2M\u011f\3\2\2\2O\u0121\3\2\2\2Q\u0123\3\2"+
		"\2\2S\u0125\3\2\2\2U\u0127\3\2\2\2W\u0129\3\2\2\2Y\u012b\3\2\2\2[\u012d"+
		"\3\2\2\2]\u012f\3\2\2\2_\u0131\3\2\2\2a\u0133\3\2\2\2c\u0135\3\2\2\2e"+
		"\u0137\3\2\2\2g\u0139\3\2\2\2i\u013b\3\2\2\2k\u013d\3\2\2\2m\u013f\3\2"+
		"\2\2op\7?\2\2p\4\3\2\2\2qr\7}\2\2r\6\3\2\2\2st\7<\2\2t\b\3\2\2\2uv\7\177"+
		"\2\2v\n\3\2\2\2wx\7.\2\2x\f\3\2\2\2yz\7*\2\2z\16\3\2\2\2{|\7+\2\2|\20"+
		"\3\2\2\2}~\7\60\2\2~\22\3\2\2\2\177\u0080\5E#\2\u0080\u0081\5]/\2\u0081"+
		"\u0082\5W,\2\u0082\u0083\5S*\2\u0083\24\3\2\2\2\u0084\u0085\5_\60\2\u0085"+
		"\u0086\5C\"\2\u0086\u0087\5Q)\2\u0087\u0088\5C\"\2\u0088\u0089\5? \2\u0089"+
		"\u008a\5a\61\2\u008a\26\3\2\2\2\u008b\u008c\5g\64\2\u008c\u008d\5I%\2"+
		"\u008d\u008e\5C\"\2\u008e\u008f\5]/\2\u008f\u0090\5C\"\2\u0090\30\3\2"+
		"\2\2\u0091\u0092\5K&\2\u0092\u0093\5U+\2\u0093\32\3\2\2\2\u0094\u0095"+
		"\5S*\2\u0095\u0096\5;\36\2\u0096\u0097\5Y-\2\u0097\34\3\2\2\2\u0098\u0099"+
		"\5O(\2\u0099\u009a\5C\"\2\u009a\u009b\5k\66\2\u009b\u009c\5_\60\2\u009c"+
		"\36\3\2\2\2\u009d\u009e\5Q)\2\u009e\u009f\5K&\2\u009f\u00a0\5_\60\2\u00a0"+
		"\u00a1\5a\61\2\u00a1 \3\2\2\2\u00a2\u00a3\5_\60\2\u00a3\u00a4\5C\"\2\u00a4"+
		"\u00a5\5a\61\2\u00a5\"\3\2\2\2\u00a6\u00a7\5S*\2\u00a7\u00a8\5;\36\2\u00a8"+
		"\u00a9\5K&\2\u00a9\u00aa\5U+\2\u00aa$\3\2\2\2\u00ab\u00ac\5M\'\2\u00ac"+
		"\u00ad\5_\60\2\u00ad\u00ae\5W,\2\u00ae\u00af\5U+\2\u00af\u00b0\5=\37\2"+
		"\u00b0\u00b1\5c\62\2\u00b1\u00b2\5K&\2\u00b2\u00b3\5Q)\2\u00b3\u00b4\5"+
		"A!\2\u00b4\u00b5\5W,\2\u00b5\u00b6\5=\37\2\u00b6\u00b7\5M\'\2\u00b7\u00b8"+
		"\5C\"\2\u00b8\u00b9\5? \2\u00b9\u00ba\5a\61\2\u00ba&\3\2\2\2\u00bb\u00bc"+
		"\5M\'\2\u00bc\u00bd\5_\60\2\u00bd\u00be\5W,\2\u00be\u00bf\5U+\2\u00bf"+
		"\u00c0\5;\36\2\u00c0\u00c1\5]/\2\u00c1\u00c2\5]/\2\u00c2\u00c3\5;\36\2"+
		"\u00c3\u00c4\5k\66\2\u00c4\u00c5\5C\"\2\u00c5\u00c6\5Q)\2\u00c6\u00c7"+
		"\5C\"\2\u00c7\u00c8\5S*\2\u00c8\u00c9\5C\"\2\u00c9\u00ca\5U+\2\u00ca\u00cb"+
		"\5a\61\2\u00cb\u00cc\5_\60\2\u00cc(\3\2\2\2\u00cd\u00ce\5;\36\2\u00ce"+
		"\u00cf\5_\60\2\u00cf*\3\2\2\2\u00d0\u00d1\5;\36\2\u00d1\u00d2\5U+\2\u00d2"+
		"\u00d3\5A!\2\u00d3,\3\2\2\2\u00d4\u00d8\t\2\2\2\u00d5\u00d7\t\2\2\2\u00d6"+
		"\u00d5\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6\3\2\2\2\u00d8\u00d9\3\2"+
		"\2\2\u00d9.\3\2\2\2\u00da\u00d8\3\2\2\2\u00db\u00e0\7$\2\2\u00dc\u00df"+
		"\5\61\31\2\u00dd\u00df\n\3\2\2\u00de\u00dc\3\2\2\2\u00de\u00dd\3\2\2\2"+
		"\u00df\u00e2\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e3"+
		"\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e3\u00ee\7$\2\2\u00e4\u00e9\7)\2\2\u00e5"+
		"\u00e8\5\61\31\2\u00e6\u00e8\n\4\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e6\3"+
		"\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea"+
		"\u00ec\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ee\7)\2\2\u00ed\u00db\3\2"+
		"\2\2\u00ed\u00e4\3\2\2\2\u00ee\60\3\2\2\2\u00ef\u00f2\7^\2\2\u00f0\u00f3"+
		"\t\5\2\2\u00f1\u00f3\5\63\32\2\u00f2\u00f0\3\2\2\2\u00f2\u00f1\3\2\2\2"+
		"\u00f3\62\3\2\2\2\u00f4\u00f5\7w\2\2\u00f5\u00f6\5\65\33\2\u00f6\u00f7"+
		"\5\65\33\2\u00f7\u00f8\5\65\33\2\u00f8\u00f9\5\65\33\2\u00f9\64\3\2\2"+
		"\2\u00fa\u00fb\t\6\2\2\u00fb\66\3\2\2\2\u00fc\u0105\7\62\2\2\u00fd\u0101"+
		"\t\7\2\2\u00fe\u0100\t\b\2\2\u00ff\u00fe\3\2\2\2\u0100\u0103\3\2\2\2\u0101"+
		"\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0105\3\2\2\2\u0103\u0101\3\2"+
		"\2\2\u0104\u00fc\3\2\2\2\u0104\u00fd\3\2\2\2\u01058\3\2\2\2\u0106\u0108"+
		"\t\t\2\2\u0107\u0106\3\2\2\2\u0108\u0109\3\2\2\2\u0109\u0107\3\2\2\2\u0109"+
		"\u010a\3\2\2\2\u010a\u010b\3\2\2\2\u010b\u010c\b\35\2\2\u010c:\3\2\2\2"+
		"\u010d\u010e\t\n\2\2\u010e<\3\2\2\2\u010f\u0110\t\13\2\2\u0110>\3\2\2"+
		"\2\u0111\u0112\t\f\2\2\u0112@\3\2\2\2\u0113\u0114\t\r\2\2\u0114B\3\2\2"+
		"\2\u0115\u0116\t\16\2\2\u0116D\3\2\2\2\u0117\u0118\t\17\2\2\u0118F\3\2"+
		"\2\2\u0119\u011a\t\20\2\2\u011aH\3\2\2\2\u011b\u011c\t\21\2\2\u011cJ\3"+
		"\2\2\2\u011d\u011e\t\22\2\2\u011eL\3\2\2\2\u011f\u0120\t\23\2\2\u0120"+
		"N\3\2\2\2\u0121\u0122\t\24\2\2\u0122P\3\2\2\2\u0123\u0124\t\25\2\2\u0124"+
		"R\3\2\2\2\u0125\u0126\t\26\2\2\u0126T\3\2\2\2\u0127\u0128\t\27\2\2\u0128"+
		"V\3\2\2\2\u0129\u012a\t\30\2\2\u012aX\3\2\2\2\u012b\u012c\t\31\2\2\u012c"+
		"Z\3\2\2\2\u012d\u012e\t\32\2\2\u012e\\\3\2\2\2\u012f\u0130\t\33\2\2\u0130"+
		"^\3\2\2\2\u0131\u0132\t\34\2\2\u0132`\3\2\2\2\u0133\u0134\t\35\2\2\u0134"+
		"b\3\2\2\2\u0135\u0136\t\36\2\2\u0136d\3\2\2\2\u0137\u0138\t\37\2\2\u0138"+
		"f\3\2\2\2\u0139\u013a\t \2\2\u013ah\3\2\2\2\u013b\u013c\t!\2\2\u013cj"+
		"\3\2\2\2\u013d\u013e\t\"\2\2\u013el\3\2\2\2\u013f\u0140\t#\2\2\u0140n"+
		"\3\2\2\2\r\2\u00d8\u00de\u00e0\u00e7\u00e9\u00ed\u00f2\u0101\u0104\u0109"+
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