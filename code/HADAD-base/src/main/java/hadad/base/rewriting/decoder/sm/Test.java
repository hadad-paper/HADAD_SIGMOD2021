package hadad.base.rewriting.decoder.sm;

import java.io.File;
import java.io.FileWriter;

import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.base.compiler.Utils;

/** Temporary Main Test **/
public class Test {
    private static final File INPUT_QUERY_FILE = new File("src/main/resources/testSM/decoderTest");

    public static void main(String[] args) throws Exception {
        final ConjunctiveQuery rewriting = Utils.parseQuery((INPUT_QUERY_FILE));
        final SMTranslator smTanslator = new SMTranslator(rewriting);
        for (int i = 0; i < 20; i++) {
            System.out.println(smTanslator.translate());
        }
        long time = System.nanoTime();
        final String decodedRW = smTanslator.translate();
        File rw = new File("src/main/resources/RW.out");
        if (rw.exists()) {
            rw.delete();
            rw = new File("src/main/resources/RW.out");
        }
        //Template string
        FileWriter writer = new FileWriter(rw);
        writer.write(decodedRW);
        writer.close();
        long end = System.nanoTime();
        System.out.println("\n" + ((end - time) * 1e-9));

    }

}
