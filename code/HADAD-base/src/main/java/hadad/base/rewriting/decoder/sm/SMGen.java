package hadad.base.rewriting.decoder.sm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import hadad.commons.conjunctivequery.ConjunctiveQuery;

/** Temp implementation. TODO: to be refactored and generalized **/
public final class SMGen {
	private static final String GEN_PATH = "generated/SM/";
	private static final String TEMP_PATH = "src/main/resources/template/SM/temp1";
	private static final String DML_QUERY = "val dmlTextQuery =";

	public static void run(final String id, final ConjunctiveQuery rw) throws IOException {
		final SMTranslator smTanslator = new SMTranslator(rw);
		//TODO:fix this 
		if (!(id.equals("P2.14") || id.equals("P2.20"))) {
			File out = new File(GEN_PATH + id + ".scala");
			if (out.exists()) {
				out.delete();
				out = new File(GEN_PATH + id + ".scala");
			}

			FileWriter writer = new FileWriter(out);
			writer.write(FileUtils.readFileToString(new File(TEMP_PATH)) + "\n");
			final StringBuilder str = new StringBuilder();
			str.append(DML_QUERY);
			str.append("\"\"\"");
			str.append(smTanslator.translate());
			str.append("\"\"\"");
			str.append("\n");
			str.append("val scriptQ=");
			str.append("dml(dmlTextQuery)");
			str.append("\n");
			str.append("val resQ = ml.execute(scriptQ)");
			writer.write(str.toString());
			writer.close();
		}
	}
}
