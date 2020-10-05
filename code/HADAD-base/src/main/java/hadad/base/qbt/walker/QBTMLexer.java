// Generated from QBTM.g4 by ANTLR 4.7.2

package hadad.base.qbt.walker;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QBTMLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, FOR=27, WHERE=28, RETURN=29, AJ=30, RK=31, PR=32, 
		SPPJ=33, PJ=34, SJ=35, XQ=36, TQ=37, AND=38, FROM=39, IN=40, SELECT=41, 
		VALUE=42, AS=43, LIKE=44, QUERY=45, USE=46, NAME=47, STRING=48, INTEGER=49, 
		WHITESPACE=50, MAP=51, KEYS=52, LIST=53, SET=54, MAIN=55, BETA=56, WS=57, 
		SELECTT=58, JSONBUILDOBJECT=59, JSONARRAYELEMENTS=60, INT=61;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
			"T__25", "FOR", "WHERE", "RETURN", "AJ", "RK", "PR", "SPPJ", "PJ", "SJ", 
			"XQ", "TQ", "AND", "FROM", "IN", "SELECT", "VALUE", "AS", "LIKE", "QUERY", 
			"USE", "NAME", "STRING", "ESCAPE", "UNICODE", "HEX", "INTEGER", "WHITESPACE", 
			"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", 
			"O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "MAP", "KEYS", 
			"LIST", "SET", "MAIN", "BETA", "WS", "SELECTT", "JSONBUILDOBJECT", "JSONARRAYELEMENTS", 
			"INT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'='", "','", "':'", "'{'", "'}'", "'('", "')'", "'->'", "'.'", 
			"'['", "']'", "'return'", "'for'", "'in'", "'dataset'", "'where'", "'and'", 
			"'some'", "'satisfies'", "'/'", "'?q='", "'&'", "'fl='", "'::INT '", 
			"'->>'", "';'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, "FOR", "WHERE", "RETURN", "AJ", "RK", "PR", "SPPJ", 
			"PJ", "SJ", "XQ", "TQ", "AND", "FROM", "IN", "SELECT", "VALUE", "AS", 
			"LIKE", "QUERY", "USE", "NAME", "STRING", "INTEGER", "WHITESPACE", "MAP", 
			"KEYS", "LIST", "SET", "MAIN", "BETA", "WS", "SELECTT", "JSONBUILDOBJECT", 
			"JSONARRAYELEMENTS", "INT"
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


	public QBTMLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "QBTM.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2?\u022e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"+
		"\4U\tU\4V\tV\4W\tW\4X\tX\4Y\tY\4Z\tZ\4[\t[\3\2\3\2\3\3\3\3\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3"+
		"#\3#\3#\3$\3$\3$\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3"+
		")\3)\3*\3*\3*\3*\3*\3*\3*\3+\3+\3+\3+\3+\3+\3,\3,\3,\3-\3-\3-\3-\3-\3"+
		".\3.\3.\3.\3.\3.\3/\3/\3/\3/\3\60\6\60\u016e\n\60\r\60\16\60\u016f\3\60"+
		"\7\60\u0173\n\60\f\60\16\60\u0176\13\60\3\61\3\61\3\61\7\61\u017b\n\61"+
		"\f\61\16\61\u017e\13\61\3\61\3\61\3\61\3\61\7\61\u0184\n\61\f\61\16\61"+
		"\u0187\13\61\3\61\5\61\u018a\n\61\3\62\3\62\3\62\5\62\u018f\n\62\3\63"+
		"\3\63\3\63\3\63\3\63\3\63\3\64\3\64\3\65\3\65\3\65\7\65\u019c\n\65\f\65"+
		"\16\65\u019f\13\65\5\65\u01a1\n\65\3\66\6\66\u01a4\n\66\r\66\16\66\u01a5"+
		"\3\66\3\66\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3"+
		"@\3@\3A\3A\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3"+
		"K\3L\3L\3M\3M\3N\3N\3O\3O\3P\3P\3Q\3Q\3Q\3Q\3R\3R\3R\3R\3R\3S\3S\3S\3"+
		"S\3S\3T\3T\3T\3T\3U\3U\3U\3U\3U\3V\6V\u01f6\nV\rV\16V\u01f7\3W\6W\u01fb"+
		"\nW\rW\16W\u01fc\3W\3W\3X\3X\3X\3X\3X\3X\3X\3X\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3"+
		"Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Y\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3Z\3"+
		"Z\3Z\3Z\3Z\3[\3[\3[\3[\2\2\\\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13"+
		"\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61"+
		"\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61"+
		"a\62c\2e\2g\2i\63k\64m\2o\2q\2s\2u\2w\2y\2{\2}\2\177\2\u0081\2\u0083\2"+
		"\u0085\2\u0087\2\u0089\2\u008b\2\u008d\2\u008f\2\u0091\2\u0093\2\u0095"+
		"\2\u0097\2\u0099\2\u009b\2\u009d\2\u009f\2\u00a1\65\u00a3\66\u00a5\67"+
		"\u00a78\u00a99\u00ab:\u00ad;\u00af<\u00b1=\u00b3>\u00b5?\3\2%\5\2C\\a"+
		"ac|\6\2\62;C\\aac|\4\2$$^^\4\2))^^\13\2$$))\61\61^^ddhhppttvv\5\2\62;"+
		"CHch\3\2\63;\3\2\62;\5\2\13\f\17\17\"\"\4\2CCcc\4\2DDdd\4\2EEee\4\2FF"+
		"ff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2"+
		"OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4"+
		"\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\2\u021d\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2"+
		"Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2i\3\2\2\2\2k\3"+
		"\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2\2\2"+
		"\2\u00a9\3\2\2\2\2\u00ab\3\2\2\2\2\u00ad\3\2\2\2\2\u00af\3\2\2\2\2\u00b1"+
		"\3\2\2\2\2\u00b3\3\2\2\2\2\u00b5\3\2\2\2\3\u00b7\3\2\2\2\5\u00b9\3\2\2"+
		"\2\7\u00bb\3\2\2\2\t\u00bd\3\2\2\2\13\u00bf\3\2\2\2\r\u00c1\3\2\2\2\17"+
		"\u00c3\3\2\2\2\21\u00c5\3\2\2\2\23\u00c8\3\2\2\2\25\u00ca\3\2\2\2\27\u00cc"+
		"\3\2\2\2\31\u00ce\3\2\2\2\33\u00d5\3\2\2\2\35\u00d9\3\2\2\2\37\u00dc\3"+
		"\2\2\2!\u00e4\3\2\2\2#\u00ea\3\2\2\2%\u00ee\3\2\2\2\'\u00f3\3\2\2\2)\u00fd"+
		"\3\2\2\2+\u00ff\3\2\2\2-\u0103\3\2\2\2/\u0105\3\2\2\2\61\u0109\3\2\2\2"+
		"\63\u0110\3\2\2\2\65\u0114\3\2\2\2\67\u0116\3\2\2\29\u011a\3\2\2\2;\u0120"+
		"\3\2\2\2=\u0127\3\2\2\2?\u012a\3\2\2\2A\u012d\3\2\2\2C\u0130\3\2\2\2E"+
		"\u0135\3\2\2\2G\u0138\3\2\2\2I\u013b\3\2\2\2K\u013e\3\2\2\2M\u0141\3\2"+
		"\2\2O\u0145\3\2\2\2Q\u014a\3\2\2\2S\u014d\3\2\2\2U\u0154\3\2\2\2W\u015a"+
		"\3\2\2\2Y\u015d\3\2\2\2[\u0162\3\2\2\2]\u0168\3\2\2\2_\u016d\3\2\2\2a"+
		"\u0189\3\2\2\2c\u018b\3\2\2\2e\u0190\3\2\2\2g\u0196\3\2\2\2i\u01a0\3\2"+
		"\2\2k\u01a3\3\2\2\2m\u01a9\3\2\2\2o\u01ab\3\2\2\2q\u01ad\3\2\2\2s\u01af"+
		"\3\2\2\2u\u01b1\3\2\2\2w\u01b3\3\2\2\2y\u01b5\3\2\2\2{\u01b7\3\2\2\2}"+
		"\u01b9\3\2\2\2\177\u01bb\3\2\2\2\u0081\u01bd\3\2\2\2\u0083\u01bf\3\2\2"+
		"\2\u0085\u01c1\3\2\2\2\u0087\u01c3\3\2\2\2\u0089\u01c5\3\2\2\2\u008b\u01c7"+
		"\3\2\2\2\u008d\u01c9\3\2\2\2\u008f\u01cb\3\2\2\2\u0091\u01cd\3\2\2\2\u0093"+
		"\u01cf\3\2\2\2\u0095\u01d1\3\2\2\2\u0097\u01d3\3\2\2\2\u0099\u01d5\3\2"+
		"\2\2\u009b\u01d7\3\2\2\2\u009d\u01d9\3\2\2\2\u009f\u01db\3\2\2\2\u00a1"+
		"\u01dd\3\2\2\2\u00a3\u01e1\3\2\2\2\u00a5\u01e6\3\2\2\2\u00a7\u01eb\3\2"+
		"\2\2\u00a9\u01ef\3\2\2\2\u00ab\u01f5\3\2\2\2\u00ad\u01fa\3\2\2\2\u00af"+
		"\u0200\3\2\2\2\u00b1\u0208\3\2\2\2\u00b3\u0218\3\2\2\2\u00b5\u022a\3\2"+
		"\2\2\u00b7\u00b8\7?\2\2\u00b8\4\3\2\2\2\u00b9\u00ba\7.\2\2\u00ba\6\3\2"+
		"\2\2\u00bb\u00bc\7<\2\2\u00bc\b\3\2\2\2\u00bd\u00be\7}\2\2\u00be\n\3\2"+
		"\2\2\u00bf\u00c0\7\177\2\2\u00c0\f\3\2\2\2\u00c1\u00c2\7*\2\2\u00c2\16"+
		"\3\2\2\2\u00c3\u00c4\7+\2\2\u00c4\20\3\2\2\2\u00c5\u00c6\7/\2\2\u00c6"+
		"\u00c7\7@\2\2\u00c7\22\3\2\2\2\u00c8\u00c9\7\60\2\2\u00c9\24\3\2\2\2\u00ca"+
		"\u00cb\7]\2\2\u00cb\26\3\2\2\2\u00cc\u00cd\7_\2\2\u00cd\30\3\2\2\2\u00ce"+
		"\u00cf\7t\2\2\u00cf\u00d0\7g\2\2\u00d0\u00d1\7v\2\2\u00d1\u00d2\7w\2\2"+
		"\u00d2\u00d3\7t\2\2\u00d3\u00d4\7p\2\2\u00d4\32\3\2\2\2\u00d5\u00d6\7"+
		"h\2\2\u00d6\u00d7\7q\2\2\u00d7\u00d8\7t\2\2\u00d8\34\3\2\2\2\u00d9\u00da"+
		"\7k\2\2\u00da\u00db\7p\2\2\u00db\36\3\2\2\2\u00dc\u00dd\7f\2\2\u00dd\u00de"+
		"\7c\2\2\u00de\u00df\7v\2\2\u00df\u00e0\7c\2\2\u00e0\u00e1\7u\2\2\u00e1"+
		"\u00e2\7g\2\2\u00e2\u00e3\7v\2\2\u00e3 \3\2\2\2\u00e4\u00e5\7y\2\2\u00e5"+
		"\u00e6\7j\2\2\u00e6\u00e7\7g\2\2\u00e7\u00e8\7t\2\2\u00e8\u00e9\7g\2\2"+
		"\u00e9\"\3\2\2\2\u00ea\u00eb\7c\2\2\u00eb\u00ec\7p\2\2\u00ec\u00ed\7f"+
		"\2\2\u00ed$\3\2\2\2\u00ee\u00ef\7u\2\2\u00ef\u00f0\7q\2\2\u00f0\u00f1"+
		"\7o\2\2\u00f1\u00f2\7g\2\2\u00f2&\3\2\2\2\u00f3\u00f4\7u\2\2\u00f4\u00f5"+
		"\7c\2\2\u00f5\u00f6\7v\2\2\u00f6\u00f7\7k\2\2\u00f7\u00f8\7u\2\2\u00f8"+
		"\u00f9\7h\2\2\u00f9\u00fa\7k\2\2\u00fa\u00fb\7g\2\2\u00fb\u00fc\7u\2\2"+
		"\u00fc(\3\2\2\2\u00fd\u00fe\7\61\2\2\u00fe*\3\2\2\2\u00ff\u0100\7A\2\2"+
		"\u0100\u0101\7s\2\2\u0101\u0102\7?\2\2\u0102,\3\2\2\2\u0103\u0104\7(\2"+
		"\2\u0104.\3\2\2\2\u0105\u0106\7h\2\2\u0106\u0107\7n\2\2\u0107\u0108\7"+
		"?\2\2\u0108\60\3\2\2\2\u0109\u010a\7<\2\2\u010a\u010b\7<\2\2\u010b\u010c"+
		"\7K\2\2\u010c\u010d\7P\2\2\u010d\u010e\7V\2\2\u010e\u010f\7\"\2\2\u010f"+
		"\62\3\2\2\2\u0110\u0111\7/\2\2\u0111\u0112\7@\2\2\u0112\u0113\7@\2\2\u0113"+
		"\64\3\2\2\2\u0114\u0115\7=\2\2\u0115\66\3\2\2\2\u0116\u0117\5w<\2\u0117"+
		"\u0118\5\u0089E\2\u0118\u0119\5\u008fH\2\u01198\3\2\2\2\u011a\u011b\5"+
		"\u0099M\2\u011b\u011c\5{>\2\u011c\u011d\5u;\2\u011d\u011e\5\u008fH\2\u011e"+
		"\u011f\5u;\2\u011f:\3\2\2\2\u0120\u0121\5\u008fH\2\u0121\u0122\5u;\2\u0122"+
		"\u0123\5\u0093J\2\u0123\u0124\5\u0095K\2\u0124\u0125\5\u008fH\2\u0125"+
		"\u0126\5\u0087D\2\u0126<\3\2\2\2\u0127\u0128\5m\67\2\u0128\u0129\5\177"+
		"@\2\u0129>\3\2\2\2\u012a\u012b\5\u008fH\2\u012b\u012c\5\u0081A\2\u012c"+
		"@\3\2\2\2\u012d\u012e\5\u008bF\2\u012e\u012f\5\u008fH\2\u012fB\3\2\2\2"+
		"\u0130\u0131\5\u0091I\2\u0131\u0132\5\u008bF\2\u0132\u0133\5\u008bF\2"+
		"\u0133\u0134\5\177@\2\u0134D\3\2\2\2\u0135\u0136\5\u008bF\2\u0136\u0137"+
		"\5\177@\2\u0137F\3\2\2\2\u0138\u0139\5\u0091I\2\u0139\u013a\5\177@\2\u013a"+
		"H\3\2\2\2\u013b\u013c\5\u009bN\2\u013c\u013d\5\u008dG\2\u013dJ\3\2\2\2"+
		"\u013e\u013f\5\u0093J\2\u013f\u0140\5\u008dG\2\u0140L\3\2\2\2\u0141\u0142"+
		"\5m\67\2\u0142\u0143\5\u0087D\2\u0143\u0144\5s:\2\u0144N\3\2\2\2\u0145"+
		"\u0146\5w<\2\u0146\u0147\5\u008fH\2\u0147\u0148\5\u0089E\2\u0148\u0149"+
		"\5\u0085C\2\u0149P\3\2\2\2\u014a\u014b\5}?\2\u014b\u014c\5\u0087D\2\u014c"+
		"R\3\2\2\2\u014d\u014e\5\u0091I\2\u014e\u014f\5u;\2\u014f\u0150\5\u0083"+
		"B\2\u0150\u0151\5u;\2\u0151\u0152\5q9\2\u0152\u0153\5\u0093J\2\u0153T"+
		"\3\2\2\2\u0154\u0155\5\u0097L\2\u0155\u0156\5m\67\2\u0156\u0157\5\u0083"+
		"B\2\u0157\u0158\5\u0095K\2\u0158\u0159\5u;\2\u0159V\3\2\2\2\u015a\u015b"+
		"\5m\67\2\u015b\u015c\5\u0091I\2\u015cX\3\2\2\2\u015d\u015e\5\u0083B\2"+
		"\u015e\u015f\5}?\2\u015f\u0160\5\u0081A\2\u0160\u0161\5u;\2\u0161Z\3\2"+
		"\2\2\u0162\u0163\5\u008dG\2\u0163\u0164\5\u0095K\2\u0164\u0165\5u;\2\u0165"+
		"\u0166\5\u008fH\2\u0166\u0167\5\u009dO\2\u0167\\\3\2\2\2\u0168\u0169\5"+
		"\u0095K\2\u0169\u016a\5\u0091I\2\u016a\u016b\5u;\2\u016b^\3\2\2\2\u016c"+
		"\u016e\t\2\2\2\u016d\u016c\3\2\2\2\u016e\u016f\3\2\2\2\u016f\u016d\3\2"+
		"\2\2\u016f\u0170\3\2\2\2\u0170\u0174\3\2\2\2\u0171\u0173\t\3\2\2\u0172"+
		"\u0171\3\2\2\2\u0173\u0176\3\2\2\2\u0174\u0172\3\2\2\2\u0174\u0175\3\2"+
		"\2\2\u0175`\3\2\2\2\u0176\u0174\3\2\2\2\u0177\u017c\7$\2\2\u0178\u017b"+
		"\5c\62\2\u0179\u017b\n\4\2\2\u017a\u0178\3\2\2\2\u017a\u0179\3\2\2\2\u017b"+
		"\u017e\3\2\2\2\u017c\u017a\3\2\2\2\u017c\u017d\3\2\2\2\u017d\u017f\3\2"+
		"\2\2\u017e\u017c\3\2\2\2\u017f\u018a\7$\2\2\u0180\u0185\7)\2\2\u0181\u0184"+
		"\5c\62\2\u0182\u0184\n\5\2\2\u0183\u0181\3\2\2\2\u0183\u0182\3\2\2\2\u0184"+
		"\u0187\3\2\2\2\u0185\u0183\3\2\2\2\u0185\u0186\3\2\2\2\u0186\u0188\3\2"+
		"\2\2\u0187\u0185\3\2\2\2\u0188\u018a\7)\2\2\u0189\u0177\3\2\2\2\u0189"+
		"\u0180\3\2\2\2\u018ab\3\2\2\2\u018b\u018e\7^\2\2\u018c\u018f\t\6\2\2\u018d"+
		"\u018f\5e\63\2\u018e\u018c\3\2\2\2\u018e\u018d\3\2\2\2\u018fd\3\2\2\2"+
		"\u0190\u0191\7w\2\2\u0191\u0192\5g\64\2\u0192\u0193\5g\64\2\u0193\u0194"+
		"\5g\64\2\u0194\u0195\5g\64\2\u0195f\3\2\2\2\u0196\u0197\t\7\2\2\u0197"+
		"h\3\2\2\2\u0198\u01a1\7\62\2\2\u0199\u019d\t\b\2\2\u019a\u019c\t\t\2\2"+
		"\u019b\u019a\3\2\2\2\u019c\u019f\3\2\2\2\u019d\u019b\3\2\2\2\u019d\u019e"+
		"\3\2\2\2\u019e\u01a1\3\2\2\2\u019f\u019d\3\2\2\2\u01a0\u0198\3\2\2\2\u01a0"+
		"\u0199\3\2\2\2\u01a1j\3\2\2\2\u01a2\u01a4\t\n\2\2\u01a3\u01a2\3\2\2\2"+
		"\u01a4\u01a5\3\2\2\2\u01a5\u01a3\3\2\2\2\u01a5\u01a6\3\2\2\2\u01a6\u01a7"+
		"\3\2\2\2\u01a7\u01a8\b\66\2\2\u01a8l\3\2\2\2\u01a9\u01aa\t\13\2\2\u01aa"+
		"n\3\2\2\2\u01ab\u01ac\t\f\2\2\u01acp\3\2\2\2\u01ad\u01ae\t\r\2\2\u01ae"+
		"r\3\2\2\2\u01af\u01b0\t\16\2\2\u01b0t\3\2\2\2\u01b1\u01b2\t\17\2\2\u01b2"+
		"v\3\2\2\2\u01b3\u01b4\t\20\2\2\u01b4x\3\2\2\2\u01b5\u01b6\t\21\2\2\u01b6"+
		"z\3\2\2\2\u01b7\u01b8\t\22\2\2\u01b8|\3\2\2\2\u01b9\u01ba\t\23\2\2\u01ba"+
		"~\3\2\2\2\u01bb\u01bc\t\24\2\2\u01bc\u0080\3\2\2\2\u01bd\u01be\t\25\2"+
		"\2\u01be\u0082\3\2\2\2\u01bf\u01c0\t\26\2\2\u01c0\u0084\3\2\2\2\u01c1"+
		"\u01c2\t\27\2\2\u01c2\u0086\3\2\2\2\u01c3\u01c4\t\30\2\2\u01c4\u0088\3"+
		"\2\2\2\u01c5\u01c6\t\31\2\2\u01c6\u008a\3\2\2\2\u01c7\u01c8\t\32\2\2\u01c8"+
		"\u008c\3\2\2\2\u01c9\u01ca\t\33\2\2\u01ca\u008e\3\2\2\2\u01cb\u01cc\t"+
		"\34\2\2\u01cc\u0090\3\2\2\2\u01cd\u01ce\t\35\2\2\u01ce\u0092\3\2\2\2\u01cf"+
		"\u01d0\t\36\2\2\u01d0\u0094\3\2\2\2\u01d1\u01d2\t\37\2\2\u01d2\u0096\3"+
		"\2\2\2\u01d3\u01d4\t \2\2\u01d4\u0098\3\2\2\2\u01d5\u01d6\t!\2\2\u01d6"+
		"\u009a\3\2\2\2\u01d7\u01d8\t\"\2\2\u01d8\u009c\3\2\2\2\u01d9\u01da\t#"+
		"\2\2\u01da\u009e\3\2\2\2\u01db\u01dc\t$\2\2\u01dc\u00a0\3\2\2\2\u01dd"+
		"\u01de\5\u0085C\2\u01de\u01df\5m\67\2\u01df\u01e0\5\u008bF\2\u01e0\u00a2"+
		"\3\2\2\2\u01e1\u01e2\5\u0081A\2\u01e2\u01e3\5u;\2\u01e3\u01e4\5\u009d"+
		"O\2\u01e4\u01e5\5\u0091I\2\u01e5\u00a4\3\2\2\2\u01e6\u01e7\5\u0083B\2"+
		"\u01e7\u01e8\5}?\2\u01e8\u01e9\5\u0091I\2\u01e9\u01ea\5\u0093J\2\u01ea"+
		"\u00a6\3\2\2\2\u01eb\u01ec\5\u0091I\2\u01ec\u01ed\5u;\2\u01ed\u01ee\5"+
		"\u0093J\2\u01ee\u00a8\3\2\2\2\u01ef\u01f0\5\u0085C\2\u01f0\u01f1\5m\67"+
		"\2\u01f1\u01f2\5}?\2\u01f2\u01f3\5\u0087D\2\u01f3\u00aa\3\2\2\2\u01f4"+
		"\u01f6\t\t\2\2\u01f5\u01f4\3\2\2\2\u01f6\u01f7\3\2\2\2\u01f7\u01f5\3\2"+
		"\2\2\u01f7\u01f8\3\2\2\2\u01f8\u00ac\3\2\2\2\u01f9\u01fb\t\n\2\2\u01fa"+
		"\u01f9\3\2\2\2\u01fb\u01fc\3\2\2\2\u01fc\u01fa\3\2\2\2\u01fc\u01fd\3\2"+
		"\2\2\u01fd\u01fe\3\2\2\2\u01fe\u01ff\bW\2\2\u01ff\u00ae\3\2\2\2\u0200"+
		"\u0201\5\u0091I\2\u0201\u0202\5u;\2\u0202\u0203\5\u0083B\2\u0203\u0204"+
		"\5u;\2\u0204\u0205\5q9\2\u0205\u0206\5\u0093J\2\u0206\u0207\5\u0093J\2"+
		"\u0207\u00b0\3\2\2\2\u0208\u0209\5\177@\2\u0209\u020a\5\u0091I\2\u020a"+
		"\u020b\5\u0089E\2\u020b\u020c\5\u0087D\2\u020c\u020d\5o8\2\u020d\u020e"+
		"\5\u0095K\2\u020e\u020f\5}?\2\u020f\u0210\5\u0083B\2\u0210\u0211\5s:\2"+
		"\u0211\u0212\5\u0089E\2\u0212\u0213\5o8\2\u0213\u0214\5\177@\2\u0214\u0215"+
		"\5u;\2\u0215\u0216\5q9\2\u0216\u0217\5\u0093J\2\u0217\u00b2\3\2\2\2\u0218"+
		"\u0219\5\177@\2\u0219\u021a\5\u0091I\2\u021a\u021b\5\u0089E\2\u021b\u021c"+
		"\5\u0087D\2\u021c\u021d\5m\67\2\u021d\u021e\5\u008fH\2\u021e\u021f\5\u008f"+
		"H\2\u021f\u0220\5m\67\2\u0220\u0221\5\u009dO\2\u0221\u0222\5u;\2\u0222"+
		"\u0223\5\u0083B\2\u0223\u0224\5u;\2\u0224\u0225\5\u0085C\2\u0225\u0226"+
		"\5u;\2\u0226\u0227\5\u0087D\2\u0227\u0228\5\u0093J\2\u0228\u0229\5\u0091"+
		"I\2\u0229\u00b4\3\2\2\2\u022a\u022b\5}?\2\u022b\u022c\5\u0087D\2\u022c"+
		"\u022d\5\u0093J\2\u022d\u00b6\3\2\2\2\20\2\u016f\u0174\u017a\u017c\u0183"+
		"\u0185\u0189\u018e\u019d\u01a0\u01a5\u01f7\u01fc\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}