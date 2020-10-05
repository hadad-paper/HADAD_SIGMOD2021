// Generated from AQL.g4 by ANTLR 4.7.2

package hadad.base.compiler.model.aj;

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
public class AQLLexer extends Lexer {
    static {
        RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
    public static final int T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9,
            T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15, T__15 = 16, T__16 = 17, T__17 = 18,
            NAME = 19, BETA = 20, WS = 21, STRING = 22;
    public static String[] channelNames = { "DEFAULT_TOKEN_CHANNEL", "HIDDEN" };

    public static String[] modeNames = { "DEFAULT_MODE" };

    private static String[] makeRuleNames() {
        return new String[] { "T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", "T__9", "T__10",
                "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", "T__17", "NAME", "BETA", "WS", "STRING", "ESCAPE",
                "UNICODE", "HEX" };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[] { null, "'='", "'{'", "':'", "'}'", "'return'", "','", "'.'", "'['", "']'", "'for'", "'in'",
                "'dataset'", "'where'", "'and'", "'some'", "'satisfies'", "'('", "')'" };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[] { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, "NAME", "BETA", "WS", "STRING" };
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

    public AQLLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    @Override
    public String getGrammarFileName() {
        return "AQL.g4";
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

    public static final String _serializedATN = "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\30\u00b0\b\1\4\2"
            + "\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"
            + "\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"
            + "\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"
            + "\t\31\4\32\t\32\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3"
            + "\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f"
            + "\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3"
            + "\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3"
            + "\21\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\6\24z\n\24\r\24\16\24{\3\24"
            + "\7\24\177\n\24\f\24\16\24\u0082\13\24\3\25\6\25\u0085\n\25\r\25\16\25"
            + "\u0086\3\26\6\26\u008a\n\26\r\26\16\26\u008b\3\26\3\26\3\27\3\27\3\27"
            + "\7\27\u0093\n\27\f\27\16\27\u0096\13\27\3\27\3\27\3\27\3\27\7\27\u009c"
            + "\n\27\f\27\16\27\u009f\13\27\3\27\5\27\u00a2\n\27\3\30\3\30\3\30\5\30"
            + "\u00a7\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\2\2\33\3\3\5\4\7\5"
            + "\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"
            + "%\24\'\25)\26+\27-\30/\2\61\2\63\2\3\2\n\5\2C\\aac|\6\2\62;C\\aac|\3\2"
            + "\62;\5\2\13\f\17\17\"\"\4\2$$^^\4\2))^^\13\2$$))\61\61^^ddhhppttvv\5\2"
            + "\62;CHch\2\u00b6\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"
            + "\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"
            + "\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"
            + "!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"
            + "\2\2\2\3\65\3\2\2\2\5\67\3\2\2\2\79\3\2\2\2\t;\3\2\2\2\13=\3\2\2\2\rD"
            + "\3\2\2\2\17F\3\2\2\2\21H\3\2\2\2\23J\3\2\2\2\25L\3\2\2\2\27P\3\2\2\2\31"
            + "S\3\2\2\2\33[\3\2\2\2\35a\3\2\2\2\37e\3\2\2\2!j\3\2\2\2#t\3\2\2\2%v\3"
            + "\2\2\2\'y\3\2\2\2)\u0084\3\2\2\2+\u0089\3\2\2\2-\u00a1\3\2\2\2/\u00a3"
            + "\3\2\2\2\61\u00a8\3\2\2\2\63\u00ae\3\2\2\2\65\66\7?\2\2\66\4\3\2\2\2\67"
            + "8\7}\2\28\6\3\2\2\29:\7<\2\2:\b\3\2\2\2;<\7\177\2\2<\n\3\2\2\2=>\7t\2"
            + "\2>?\7g\2\2?@\7v\2\2@A\7w\2\2AB\7t\2\2BC\7p\2\2C\f\3\2\2\2DE\7.\2\2E\16"
            + "\3\2\2\2FG\7\60\2\2G\20\3\2\2\2HI\7]\2\2I\22\3\2\2\2JK\7_\2\2K\24\3\2"
            + "\2\2LM\7h\2\2MN\7q\2\2NO\7t\2\2O\26\3\2\2\2PQ\7k\2\2QR\7p\2\2R\30\3\2"
            + "\2\2ST\7f\2\2TU\7c\2\2UV\7v\2\2VW\7c\2\2WX\7u\2\2XY\7g\2\2YZ\7v\2\2Z\32"
            + "\3\2\2\2[\\\7y\2\2\\]\7j\2\2]^\7g\2\2^_\7t\2\2_`\7g\2\2`\34\3\2\2\2ab"
            + "\7c\2\2bc\7p\2\2cd\7f\2\2d\36\3\2\2\2ef\7u\2\2fg\7q\2\2gh\7o\2\2hi\7g"
            + "\2\2i \3\2\2\2jk\7u\2\2kl\7c\2\2lm\7v\2\2mn\7k\2\2no\7u\2\2op\7h\2\2p"
            + "q\7k\2\2qr\7g\2\2rs\7u\2\2s\"\3\2\2\2tu\7*\2\2u$\3\2\2\2vw\7+\2\2w&\3"
            + "\2\2\2xz\t\2\2\2yx\3\2\2\2z{\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\u0080\3\2\2"
            + "\2}\177\t\3\2\2~}\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081"
            + "\3\2\2\2\u0081(\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0085\t\4\2\2\u0084"
            + "\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2"
            + "\2\2\u0087*\3\2\2\2\u0088\u008a\t\5\2\2\u0089\u0088\3\2\2\2\u008a\u008b"
            + "\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008d\3\2\2\2\u008d"
            + "\u008e\b\26\2\2\u008e,\3\2\2\2\u008f\u0094\7$\2\2\u0090\u0093\5/\30\2"
            + "\u0091\u0093\n\6\2\2\u0092\u0090\3\2\2\2\u0092\u0091\3\2\2\2\u0093\u0096"
            + "\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095\u0097\3\2\2\2\u0096"
            + "\u0094\3\2\2\2\u0097\u00a2\7$\2\2\u0098\u009d\7)\2\2\u0099\u009c\5/\30"
            + "\2\u009a\u009c\n\7\2\2\u009b\u0099\3\2\2\2\u009b\u009a\3\2\2\2\u009c\u009f"
            + "\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a0\3\2\2\2\u009f"
            + "\u009d\3\2\2\2\u00a0\u00a2\7)\2\2\u00a1\u008f\3\2\2\2\u00a1\u0098\3\2"
            + "\2\2\u00a2.\3\2\2\2\u00a3\u00a6\7^\2\2\u00a4\u00a7\t\b\2\2\u00a5\u00a7"
            + "\5\61\31\2\u00a6\u00a4\3\2\2\2\u00a6\u00a5\3\2\2\2\u00a7\60\3\2\2\2\u00a8"
            + "\u00a9\7w\2\2\u00a9\u00aa\5\63\32\2\u00aa\u00ab\5\63\32\2\u00ab\u00ac"
            + "\5\63\32\2\u00ac\u00ad\5\63\32\2\u00ad\62\3\2\2\2\u00ae\u00af\t\t\2\2"
            + "\u00af\64\3\2\2\2\r\2{\u0080\u0086\u008b\u0092\u0094\u009b\u009d\u00a1" + "\u00a6\3\b\2\2";
    public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}