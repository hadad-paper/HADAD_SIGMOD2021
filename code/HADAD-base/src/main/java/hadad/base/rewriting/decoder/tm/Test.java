package hadad.base.rewriting.decoder.tm;

import java.io.File;

import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.base.compiler.Utils;

/** Temporary Main Test **/
public class Test {
    private static final File INPUT_QUERY_FILE = new File("src/main/resources/testTM/decoderTest");

    public static void main(String[] args) throws Exception {
        final ConjunctiveQuery rewriting = Utils.parseQuery((INPUT_QUERY_FILE));
        final TMTranslator smTanslator = new TMTranslator(rewriting);
        System.out.print(smTanslator.translate());
    }

}
