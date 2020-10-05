package hadad.base.rewriting.decoder.rm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import hadad.commons.conjunctivequery.ConjunctiveQuery;

/** Temp implementation. TODO: to be refactored and generalized **/
public final class RMGen {
	private static final String GEN_PATH = "generated/RM/";
	private static final String TEMP_PATH = "src/main/resources/template/RM/temp1";

	public static void run(final String id, final ConjunctiveQuery rw) throws IOException {
		final RMTranslator rmTanslator = new RMTranslator(rw);
		//TODO:fix this 
		if (!(id.equals("P2.14") || id.equals("P2.20"))) {
			File out = new File(GEN_PATH + id + ".R");
			if (out.exists()) {
				out.delete();
				out = new File(GEN_PATH + id + ".R");
			}

			FileWriter writer = new FileWriter(out);
			writer.write(FileUtils.readFileToString(new File(TEMP_PATH)) + "\n");
			final StringBuilder str = new StringBuilder();
			str.append(rmTanslator.translate());
			writer.write(str.toString());
			writer.close();
		}
	}
}
