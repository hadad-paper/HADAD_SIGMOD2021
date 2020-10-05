// Generated from QBT.g4 by ANTLR 4.7.2

package hadad.base.compiler.model.qbt;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({ "all", "warnings", "unchecked", "unused", "cast" })
public class QBTLexer extends Lexer {
    static {
        RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
    public static final int T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9,
            T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15, T__15 = 16, T__16 = 17, T__17 = 18,
            T__18 = 19, T__19 = 20, T__20 = 21, T__21 = 22, T__22 = 23, T__23 = 24, T__24 = 25, FOR = 26, WHERE = 27,
            RETURN = 28, AJ = 29, RK = 30, PR = 31, SPPJ = 32, PJ = 33, SJ = 34, XQ = 35, TQ = 36, AND = 37, FROM = 38,
            IN = 39, SELECT = 40, AS = 41, LIKE = 42, QUERY = 43, JSONBUILDOBJECT = 44, JSONARRAYELEMENTS = 45,
            SOLRJSONBUILDOBJECT = 46, NAME = 47, STRING = 48, INTEGER = 49, WHITESPACE = 50, MAP = 51, KEYS = 52,
            LIST = 53, SET = 54, MAIN = 55, BETA = 56, WS = 57;
    public static String[] channelNames = { "DEFAULT_TOKEN_CHANNEL", "HIDDEN" };

    public static String[] modeNames = { "DEFAULT_MODE" };

    private static String[] makeRuleNames() {
        return new String[] { "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", "T__9", "T__10",
                "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", "T__17", "T__18", "T__19", "T__20", "T__21",
                "T__22", "T__23", "T__24", "FOR", "WHERE", "RETURN", "AJ", "RK", "PR", "SPPJ", "PJ", "SJ", "XQ", "TQ",
                "AND", "FROM", "IN", "SELECT", "AS", "LIKE", "QUERY", "JSONBUILDOBJECT", "JSONARRAYELEMENTS",
                "SOLRJSONBUILDOBJECT", "NAME", "STRING", "ESCAPE", "UNICODE", "HEX", "INTEGER", "WHITESPACE", "A", "B",
                "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W",
                "X", "Y", "Z", "MAP", "KEYS", "LIST", "SET", "MAIN", "BETA", "WS" };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[] { null, "'='", "','", "':'", "'{'", "'}'", "'('", "')'", "'-'", "'>'", "'.'", "'['", "']'",
                "'return'", "'for'", "'in'", "'dataset'", "'where'", "'and'", "'some'", "'satisfies'", "'/'", "'?q='",
                "'&'", "'fl='", "'->'" };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[] { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, "FOR", "WHERE", "RETURN", "AJ", "RK",
                "PR", "SPPJ", "PJ", "SJ", "XQ", "TQ", "AND", "FROM", "IN", "SELECT", "AS", "LIKE", "QUERY",
                "JSONBUILDOBJECT", "JSONARRAYELEMENTS", "SOLRJSONBUILDOBJECT", "NAME", "STRING", "INTEGER",
                "WHITESPACE", "MAP", "KEYS", "LIST", "SET", "MAIN", "BETA", "WS" };
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

    public QBTLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    @Override
    public String getGrammarFileName() {
        return "QBT.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public String[] getChannelNames() {
        return channelNames;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public static final String _serializedATN = "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2;\u0217\b\1\4\2\t"
            + "\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"
            + "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"
            + "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"
            + "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"
            + "\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"
            + ",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"
            + "\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="
            + "\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"
            + "\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\4O\tO\4P\tP\4Q\tQ\4R\tR\4S\tS\4T\tT"
            + "\4U\tU\4V\tV\4W\tW\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b"
            + "\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16"
            + "\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"
            + "\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\24"
            + "\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"
            + "\3\26\3\26\3\27\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32"
            + "\3\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35"
            + "\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3"
            + "!\3!\3\"\3\"\3\"\3#\3#\3#\3$\3$\3$\3%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3"
            + "\'\3\'\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3*\3*\3*\3+\3+\3+\3+\3+\3,\3,\3,"
            + "\3,\3,\3,\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3-\3.\3.\3.\3."
            + "\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3/\3/\3/\3/"
            + "\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3/\3\60\3\60\7\60\u018a\n\60\f\60\16\60"
            + "\u018d\13\60\3\61\3\61\3\61\7\61\u0192\n\61\f\61\16\61\u0195\13\61\3\61"
            + "\3\61\3\61\3\61\7\61\u019b\n\61\f\61\16\61\u019e\13\61\3\61\5\61\u01a1"
            + "\n\61\3\62\3\62\3\62\5\62\u01a6\n\62\3\63\3\63\3\63\3\63\3\63\3\63\3\64"
            + "\3\64\3\65\3\65\3\65\7\65\u01b3\n\65\f\65\16\65\u01b6\13\65\5\65\u01b8"
            + "\n\65\3\66\6\66\u01bb\n\66\r\66\16\66\u01bc\3\66\3\66\3\67\3\67\38\38"
            + "\39\39\3:\3:\3;\3;\3<\3<\3=\3=\3>\3>\3?\3?\3@\3@\3A\3A\3B\3B\3C\3C\3D"
            + "\3D\3E\3E\3F\3F\3G\3G\3H\3H\3I\3I\3J\3J\3K\3K\3L\3L\3M\3M\3N\3N\3O\3O"
            + "\3P\3P\3Q\3Q\3Q\3Q\3R\3R\3R\3R\3R\3S\3S\3S\3S\3S\3T\3T\3T\3T\3U\3U\3U"
            + "\3U\3U\3V\6V\u020d\nV\rV\16V\u020e\3W\6W\u0212\nW\rW\16W\u0213\3W\3W\2"
            + "\2X\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"
            + "\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"
            + ";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\2e\2g\2i\63k\64m\2"
            + "o\2q\2s\2u\2w\2y\2{\2}\2\177\2\u0081\2\u0083\2\u0085\2\u0087\2\u0089\2"
            + "\u008b\2\u008d\2\u008f\2\u0091\2\u0093\2\u0095\2\u0097\2\u0099\2\u009b"
            + "\2\u009d\2\u009f\2\u00a1\65\u00a3\66\u00a5\67\u00a78\u00a99\u00ab:\u00ad"
            + ";\3\2$\6\2\62;C\\aac|\4\2$$^^\4\2))^^\13\2$$))\61\61^^ddhhppttvv\5\2\62"
            + ";CHch\3\2\63;\3\2\62;\5\2\13\f\17\17\"\"\4\2CCcc\4\2DDdd\4\2EEee\4\2F"
            + "Fff\4\2GGgg\4\2HHhh\4\2IIii\4\2JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4"
            + "\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWw"
            + "w\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{{\4\2\\\\||\2\u0205\2\3\3\2\2\2\2\5\3"
            + "\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2"
            + "\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"
            + "\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'"
            + "\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63"
            + "\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2"
            + "?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3"
            + "\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2"
            + "\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2i\3\2\2\2\2"
            + "k\3\2\2\2\2\u00a1\3\2\2\2\2\u00a3\3\2\2\2\2\u00a5\3\2\2\2\2\u00a7\3\2"
            + "\2\2\2\u00a9\3\2\2\2\2\u00ab\3\2\2\2\2\u00ad\3\2\2\2\3\u00af\3\2\2\2\5"
            + "\u00b1\3\2\2\2\7\u00b3\3\2\2\2\t\u00b5\3\2\2\2\13\u00b7\3\2\2\2\r\u00b9"
            + "\3\2\2\2\17\u00bb\3\2\2\2\21\u00bd\3\2\2\2\23\u00bf\3\2\2\2\25\u00c1\3"
            + "\2\2\2\27\u00c3\3\2\2\2\31\u00c5\3\2\2\2\33\u00c7\3\2\2\2\35\u00ce\3\2"
            + "\2\2\37\u00d2\3\2\2\2!\u00d5\3\2\2\2#\u00dd\3\2\2\2%\u00e3\3\2\2\2\'\u00e7"
            + "\3\2\2\2)\u00ec\3\2\2\2+\u00f6\3\2\2\2-\u00f8\3\2\2\2/\u00fc\3\2\2\2\61"
            + "\u00fe\3\2\2\2\63\u0102\3\2\2\2\65\u0105\3\2\2\2\67\u0109\3\2\2\29\u010f"
            + "\3\2\2\2;\u0116\3\2\2\2=\u0119\3\2\2\2?\u011c\3\2\2\2A\u011f\3\2\2\2C"
            + "\u0124\3\2\2\2E\u0127\3\2\2\2G\u012a\3\2\2\2I\u012d\3\2\2\2K\u0130\3\2"
            + "\2\2M\u0134\3\2\2\2O\u0139\3\2\2\2Q\u013c\3\2\2\2S\u0143\3\2\2\2U\u0146"
            + "\3\2\2\2W\u014b\3\2\2\2Y\u0151\3\2\2\2[\u0161\3\2\2\2]\u0173\3\2\2\2_"
            + "\u0187\3\2\2\2a\u01a0\3\2\2\2c\u01a2\3\2\2\2e\u01a7\3\2\2\2g\u01ad\3\2"
            + "\2\2i\u01b7\3\2\2\2k\u01ba\3\2\2\2m\u01c0\3\2\2\2o\u01c2\3\2\2\2q\u01c4"
            + "\3\2\2\2s\u01c6\3\2\2\2u\u01c8\3\2\2\2w\u01ca\3\2\2\2y\u01cc\3\2\2\2{"
            + "\u01ce\3\2\2\2}\u01d0\3\2\2\2\177\u01d2\3\2\2\2\u0081\u01d4\3\2\2\2\u0083"
            + "\u01d6\3\2\2\2\u0085\u01d8\3\2\2\2\u0087\u01da\3\2\2\2\u0089\u01dc\3\2"
            + "\2\2\u008b\u01de\3\2\2\2\u008d\u01e0\3\2\2\2\u008f\u01e2\3\2\2\2\u0091"
            + "\u01e4\3\2\2\2\u0093\u01e6\3\2\2\2\u0095\u01e8\3\2\2\2\u0097\u01ea\3\2"
            + "\2\2\u0099\u01ec\3\2\2\2\u009b\u01ee\3\2\2\2\u009d\u01f0\3\2\2\2\u009f"
            + "\u01f2\3\2\2\2\u00a1\u01f4\3\2\2\2\u00a3\u01f8\3\2\2\2\u00a5\u01fd\3\2"
            + "\2\2\u00a7\u0202\3\2\2\2\u00a9\u0206\3\2\2\2\u00ab\u020c\3\2\2\2\u00ad"
            + "\u0211\3\2\2\2\u00af\u00b0\7?\2\2\u00b0\4\3\2\2\2\u00b1\u00b2\7.\2\2\u00b2"
            + "\6\3\2\2\2\u00b3\u00b4\7<\2\2\u00b4\b\3\2\2\2\u00b5\u00b6\7}\2\2\u00b6"
            + "\n\3\2\2\2\u00b7\u00b8\7\177\2\2\u00b8\f\3\2\2\2\u00b9\u00ba\7*\2\2\u00ba"
            + "\16\3\2\2\2\u00bb\u00bc\7+\2\2\u00bc\20\3\2\2\2\u00bd\u00be\7/\2\2\u00be"
            + "\22\3\2\2\2\u00bf\u00c0\7@\2\2\u00c0\24\3\2\2\2\u00c1\u00c2\7\60\2\2\u00c2"
            + "\26\3\2\2\2\u00c3\u00c4\7]\2\2\u00c4\30\3\2\2\2\u00c5\u00c6\7_\2\2\u00c6"
            + "\32\3\2\2\2\u00c7\u00c8\7t\2\2\u00c8\u00c9\7g\2\2\u00c9\u00ca\7v\2\2\u00ca"
            + "\u00cb\7w\2\2\u00cb\u00cc\7t\2\2\u00cc\u00cd\7p\2\2\u00cd\34\3\2\2\2\u00ce"
            + "\u00cf\7h\2\2\u00cf\u00d0\7q\2\2\u00d0\u00d1\7t\2\2\u00d1\36\3\2\2\2\u00d2"
            + "\u00d3\7k\2\2\u00d3\u00d4\7p\2\2\u00d4 \3\2\2\2\u00d5\u00d6\7f\2\2\u00d6"
            + "\u00d7\7c\2\2\u00d7\u00d8\7v\2\2\u00d8\u00d9\7c\2\2\u00d9\u00da\7u\2\2"
            + "\u00da\u00db\7g\2\2\u00db\u00dc\7v\2\2\u00dc\"\3\2\2\2\u00dd\u00de\7y"
            + "\2\2\u00de\u00df\7j\2\2\u00df\u00e0\7g\2\2\u00e0\u00e1\7t\2\2\u00e1\u00e2"
            + "\7g\2\2\u00e2$\3\2\2\2\u00e3\u00e4\7c\2\2\u00e4\u00e5\7p\2\2\u00e5\u00e6"
            + "\7f\2\2\u00e6&\3\2\2\2\u00e7\u00e8\7u\2\2\u00e8\u00e9\7q\2\2\u00e9\u00ea"
            + "\7o\2\2\u00ea\u00eb\7g\2\2\u00eb(\3\2\2\2\u00ec\u00ed\7u\2\2\u00ed\u00ee"
            + "\7c\2\2\u00ee\u00ef\7v\2\2\u00ef\u00f0\7k\2\2\u00f0\u00f1\7u\2\2\u00f1"
            + "\u00f2\7h\2\2\u00f2\u00f3\7k\2\2\u00f3\u00f4\7g\2\2\u00f4\u00f5\7u\2\2"
            + "\u00f5*\3\2\2\2\u00f6\u00f7\7\61\2\2\u00f7,\3\2\2\2\u00f8\u00f9\7A\2\2"
            + "\u00f9\u00fa\7s\2\2\u00fa\u00fb\7?\2\2\u00fb.\3\2\2\2\u00fc\u00fd\7(\2"
            + "\2\u00fd\60\3\2\2\2\u00fe\u00ff\7h\2\2\u00ff\u0100\7n\2\2\u0100\u0101"
            + "\7?\2\2\u0101\62\3\2\2\2\u0102\u0103\7/\2\2\u0103\u0104\7@\2\2\u0104\64"
            + "\3\2\2\2\u0105\u0106\5w<\2\u0106\u0107\5\u0089E\2\u0107\u0108\5\u008f"
            + "H\2\u0108\66\3\2\2\2\u0109\u010a\5\u0099M\2\u010a\u010b\5{>\2\u010b\u010c"
            + "\5u;\2\u010c\u010d\5\u008fH\2\u010d\u010e\5u;\2\u010e8\3\2\2\2\u010f\u0110"
            + "\5\u008fH\2\u0110\u0111\5u;\2\u0111\u0112\5\u0093J\2\u0112\u0113\5\u0095"
            + "K\2\u0113\u0114\5\u008fH\2\u0114\u0115\5\u0087D\2\u0115:\3\2\2\2\u0116"
            + "\u0117\5m\67\2\u0117\u0118\5\177@\2\u0118<\3\2\2\2\u0119\u011a\5\u008f"
            + "H\2\u011a\u011b\5\u0081A\2\u011b>\3\2\2\2\u011c\u011d\5\u008bF\2\u011d"
            + "\u011e\5\u008fH\2\u011e@\3\2\2\2\u011f\u0120\5\u0091I\2\u0120\u0121\5"
            + "\u008bF\2\u0121\u0122\5\u008bF\2\u0122\u0123\5\177@\2\u0123B\3\2\2\2\u0124"
            + "\u0125\5\u008bF\2\u0125\u0126\5\177@\2\u0126D\3\2\2\2\u0127\u0128\5\u0091"
            + "I\2\u0128\u0129\5\177@\2\u0129F\3\2\2\2\u012a\u012b\5\u009bN\2\u012b\u012c"
            + "\5\u008dG\2\u012cH\3\2\2\2\u012d\u012e\5\u0093J\2\u012e\u012f\5\u008d"
            + "G\2\u012fJ\3\2\2\2\u0130\u0131\5m\67\2\u0131\u0132\5\u0087D\2\u0132\u0133"
            + "\5s:\2\u0133L\3\2\2\2\u0134\u0135\5w<\2\u0135\u0136\5\u008fH\2\u0136\u0137"
            + "\5\u0089E\2\u0137\u0138\5\u0085C\2\u0138N\3\2\2\2\u0139\u013a\5}?\2\u013a"
            + "\u013b\5\u0087D\2\u013bP\3\2\2\2\u013c\u013d\5\u0091I\2\u013d\u013e\5"
            + "u;\2\u013e\u013f\5\u0083B\2\u013f\u0140\5u;\2\u0140\u0141\5q9\2\u0141"
            + "\u0142\5\u0093J\2\u0142R\3\2\2\2\u0143\u0144\5m\67\2\u0144\u0145\5\u0091"
            + "I\2\u0145T\3\2\2\2\u0146\u0147\5\u0083B\2\u0147\u0148\5}?\2\u0148\u0149"
            + "\5\u0081A\2\u0149\u014a\5u;\2\u014aV\3\2\2\2\u014b\u014c\5\u008dG\2\u014c"
            + "\u014d\5\u0095K\2\u014d\u014e\5u;\2\u014e\u014f\5\u008fH\2\u014f\u0150"
            + "\5\u009dO\2\u0150X\3\2\2\2\u0151\u0152\5\177@\2\u0152\u0153\5\u0091I\2"
            + "\u0153\u0154\5\u0089E\2\u0154\u0155\5\u0087D\2\u0155\u0156\5o8\2\u0156"
            + "\u0157\5\u0095K\2\u0157\u0158\5}?\2\u0158\u0159\5\u0083B\2\u0159\u015a"
            + "\5s:\2\u015a\u015b\5\u0089E\2\u015b\u015c\5o8\2\u015c\u015d\5\177@\2\u015d"
            + "\u015e\5u;\2\u015e\u015f\5q9\2\u015f\u0160\5\u0093J\2\u0160Z\3\2\2\2\u0161"
            + "\u0162\5\177@\2\u0162\u0163\5\u0091I\2\u0163\u0164\5\u0089E\2\u0164\u0165"
            + "\5\u0087D\2\u0165\u0166\5m\67\2\u0166\u0167\5\u008fH\2\u0167\u0168\5\u008f"
            + "H\2\u0168\u0169\5m\67\2\u0169\u016a\5\u009dO\2\u016a\u016b\5u;\2\u016b"
            + "\u016c\5\u0083B\2\u016c\u016d\5u;\2\u016d\u016e\5\u0085C\2\u016e\u016f"
            + "\5u;\2\u016f\u0170\5\u0087D\2\u0170\u0171\5\u0093J\2\u0171\u0172\5\u0091"
            + "I\2\u0172\\\3\2\2\2\u0173\u0174\5\u0091I\2\u0174\u0175\5\u0089E\2\u0175"
            + "\u0176\5\u0083B\2\u0176\u0177\5\u008fH\2\u0177\u0178\5\177@\2\u0178\u0179"
            + "\5\u0091I\2\u0179\u017a\5\u0089E\2\u017a\u017b\5\u0087D\2\u017b\u017c"
            + "\5o8\2\u017c\u017d\5\u0095K\2\u017d\u017e\5}?\2\u017e\u017f\5\u0083B\2"
            + "\u017f\u0180\5s:\2\u0180\u0181\5\u0089E\2\u0181\u0182\5o8\2\u0182\u0183"
            + "\5\177@\2\u0183\u0184\5u;\2\u0184\u0185\5q9\2\u0185\u0186\5\u0093J\2\u0186"
            + "^\3\2\2\2\u0187\u018b\t\2\2\2\u0188\u018a\t\2\2\2\u0189\u0188\3\2\2\2"
            + "\u018a\u018d\3\2\2\2\u018b\u0189\3\2\2\2\u018b\u018c\3\2\2\2\u018c`\3"
            + "\2\2\2\u018d\u018b\3\2\2\2\u018e\u0193\7$\2\2\u018f\u0192\5c\62\2\u0190"
            + "\u0192\n\3\2\2\u0191\u018f\3\2\2\2\u0191\u0190\3\2\2\2\u0192\u0195\3\2"
            + "\2\2\u0193\u0191\3\2\2\2\u0193\u0194\3\2\2\2\u0194\u0196\3\2\2\2\u0195"
            + "\u0193\3\2\2\2\u0196\u01a1\7$\2\2\u0197\u019c\7)\2\2\u0198\u019b\5c\62"
            + "\2\u0199\u019b\n\4\2\2\u019a\u0198\3\2\2\2\u019a\u0199\3\2\2\2\u019b\u019e"
            + "\3\2\2\2\u019c\u019a\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u019f\3\2\2\2\u019e"
            + "\u019c\3\2\2\2\u019f\u01a1\7)\2\2\u01a0\u018e\3\2\2\2\u01a0\u0197\3\2"
            + "\2\2\u01a1b\3\2\2\2\u01a2\u01a5\7^\2\2\u01a3\u01a6\t\5\2\2\u01a4\u01a6"
            + "\5e\63\2\u01a5\u01a3\3\2\2\2\u01a5\u01a4\3\2\2\2\u01a6d\3\2\2\2\u01a7"
            + "\u01a8\7w\2\2\u01a8\u01a9\5g\64\2\u01a9\u01aa\5g\64\2\u01aa\u01ab\5g\64"
            + "\2\u01ab\u01ac\5g\64\2\u01acf\3\2\2\2\u01ad\u01ae\t\6\2\2\u01aeh\3\2\2"
            + "\2\u01af\u01b8\7\62\2\2\u01b0\u01b4\t\7\2\2\u01b1\u01b3\t\b\2\2\u01b2"
            + "\u01b1\3\2\2\2\u01b3\u01b6\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b4\u01b5\3\2"
            + "\2\2\u01b5\u01b8\3\2\2\2\u01b6\u01b4\3\2\2\2\u01b7\u01af\3\2\2\2\u01b7"
            + "\u01b0\3\2\2\2\u01b8j\3\2\2\2\u01b9\u01bb\t\t\2\2\u01ba\u01b9\3\2\2\2"
            + "\u01bb\u01bc\3\2\2\2\u01bc\u01ba\3\2\2\2\u01bc\u01bd\3\2\2\2\u01bd\u01be"
            + "\3\2\2\2\u01be\u01bf\b\66\2\2\u01bfl\3\2\2\2\u01c0\u01c1\t\n\2\2\u01c1"
            + "n\3\2\2\2\u01c2\u01c3\t\13\2\2\u01c3p\3\2\2\2\u01c4\u01c5\t\f\2\2\u01c5"
            + "r\3\2\2\2\u01c6\u01c7\t\r\2\2\u01c7t\3\2\2\2\u01c8\u01c9\t\16\2\2\u01c9"
            + "v\3\2\2\2\u01ca\u01cb\t\17\2\2\u01cbx\3\2\2\2\u01cc\u01cd\t\20\2\2\u01cd"
            + "z\3\2\2\2\u01ce\u01cf\t\21\2\2\u01cf|\3\2\2\2\u01d0\u01d1\t\22\2\2\u01d1"
            + "~\3\2\2\2\u01d2\u01d3\t\23\2\2\u01d3\u0080\3\2\2\2\u01d4\u01d5\t\24\2"
            + "\2\u01d5\u0082\3\2\2\2\u01d6\u01d7\t\25\2\2\u01d7\u0084\3\2\2\2\u01d8"
            + "\u01d9\t\26\2\2\u01d9\u0086\3\2\2\2\u01da\u01db\t\27\2\2\u01db\u0088\3"
            + "\2\2\2\u01dc\u01dd\t\30\2\2\u01dd\u008a\3\2\2\2\u01de\u01df\t\31\2\2\u01df"
            + "\u008c\3\2\2\2\u01e0\u01e1\t\32\2\2\u01e1\u008e\3\2\2\2\u01e2\u01e3\t"
            + "\33\2\2\u01e3\u0090\3\2\2\2\u01e4\u01e5\t\34\2\2\u01e5\u0092\3\2\2\2\u01e6"
            + "\u01e7\t\35\2\2\u01e7\u0094\3\2\2\2\u01e8\u01e9\t\36\2\2\u01e9\u0096\3"
            + "\2\2\2\u01ea\u01eb\t\37\2\2\u01eb\u0098\3\2\2\2\u01ec\u01ed\t \2\2\u01ed"
            + "\u009a\3\2\2\2\u01ee\u01ef\t!\2\2\u01ef\u009c\3\2\2\2\u01f0\u01f1\t\""
            + "\2\2\u01f1\u009e\3\2\2\2\u01f2\u01f3\t#\2\2\u01f3\u00a0\3\2\2\2\u01f4"
            + "\u01f5\5\u0085C\2\u01f5\u01f6\5m\67\2\u01f6\u01f7\5\u008bF\2\u01f7\u00a2"
            + "\3\2\2\2\u01f8\u01f9\5\u0081A\2\u01f9\u01fa\5u;\2\u01fa\u01fb\5\u009d"
            + "O\2\u01fb\u01fc\5\u0091I\2\u01fc\u00a4\3\2\2\2\u01fd\u01fe\5\u0083B\2"
            + "\u01fe\u01ff\5}?\2\u01ff\u0200\5\u0091I\2\u0200\u0201\5\u0093J\2\u0201"
            + "\u00a6\3\2\2\2\u0202\u0203\5\u0091I\2\u0203\u0204\5u;\2\u0204\u0205\5"
            + "\u0093J\2\u0205\u00a8\3\2\2\2\u0206\u0207\5\u0085C\2\u0207\u0208\5m\67"
            + "\2\u0208\u0209\5}?\2\u0209\u020a\5\u0087D\2\u020a\u00aa\3\2\2\2\u020b"
            + "\u020d\t\b\2\2\u020c\u020b\3\2\2\2\u020d\u020e\3\2\2\2\u020e\u020c\3\2"
            + "\2\2\u020e\u020f\3\2\2\2\u020f\u00ac\3\2\2\2\u0210\u0212\t\t\2\2\u0211"
            + "\u0210\3\2\2\2\u0212\u0213\3\2\2\2\u0213\u0211\3\2\2\2\u0213\u0214\3\2"
            + "\2\2\u0214\u0215\3\2\2\2\u0215\u0216\bW\2\2\u0216\u00ae\3\2\2\2\17\2\u018b"
            + "\u0191\u0193\u019a\u019c\u01a0\u01a5\u01b4\u01b7\u01bc\u020e\u0213\3\b" + "\2\2";
    public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}