package hadad.base.rewriting.decoder.nm;

import java.io.File;

import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.base.compiler.Utils;

/** Temporary Main Test **/
public class Test {
    private static final File INPUT_QUERY_FILE = new File("src/main/resources/testNM/decoderTest");

    public static void main(String[] args) throws Exception {
        final ConjunctiveQuery rewriting = Utils.parseQuery((INPUT_QUERY_FILE));
        final NMTranslator smTanslator = new NMTranslator(rewriting);
        System.out.print(smTanslator.translate());
    }

}
