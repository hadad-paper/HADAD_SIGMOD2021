package hadad.base.compiler;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.io.Writer;
import java.util.Collection;

import org.apache.commons.io.FileUtils;

import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.conjunctivequery.parser.CQParser;
import hadad.commons.conjunctivequery.parser.ParseException;
import hadad.commons.constraints.Constraint;
import hadad.commons.relationalschema.RelationalSchema;
import hadad.base.rewriter.Comment;

public class Utils {
	private static final String CHARSET = "utf-8";

	public static ConjunctiveQuery parseQuery(final File file)
	        throws ParseException, IllegalArgumentException, IOException {
		return parseQuery(FileUtils.readFileToString(file));
	}

	public static ConjunctiveQuery parseQuery(final String str) throws ParseException, IllegalArgumentException {
		final Collection<ConjunctiveQuery> queries = parseQueries(str);
		if (queries.size() != 1) {
			throw new IllegalArgumentException("The query string is not a valid RDF CQ.");
		}
		return queries.iterator().next();
	}

	public static Collection<ConjunctiveQuery> parseQueries(final File file) throws ParseException, IOException {
		return parseQueries(FileUtils.readFileToString(file));
	}

	public static Collection<ConjunctiveQuery> parseQueries(final String str) throws ParseException {
		final CQParser parser = new CQParser(new StringReader(str));
		return parser.parse().values();
	}

	public static void writeConstraints(final String fileName, final Collection<? extends Constraint> constraints)
	        throws IOException {
		final File file = new File(fileName);
		if (file.exists()) {
			file.delete();
		}
		file.createNewFile();
		final Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), CHARSET));
		try {
			for (final Constraint constraint : constraints) {
				writer.write(constraint.toString() + (constraint instanceof Comment ? "" : ";\n"));
			}
		} catch (IOException e) {
			throw e;
		} finally {
			writer.close();
		}
	}

	public static void writeSchemas(final String fileName, final RelationalSchema sourceSchema,
	        final RelationalSchema targetSchema) throws IOException {
		final File file = new File(fileName);
		if (file.exists()) {
			file.delete();
		}
		file.createNewFile();
		final Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), CHARSET));
		try {
			writer.write(sourceSchema.toString() + "\n");
			writer.write(targetSchema.toString());
		} catch (IOException e) {
			throw e;
		} finally {
			writer.close();
		}
	}

	public static void writeQuery(final String fileName, final ConjunctiveQuery query) throws IOException {
		final File file = new File(fileName);
		if (file.exists()) {
			file.delete();
		}
		file.createNewFile();
		final Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName), CHARSET));
		try {
			writer.write(query.toString());
		} catch (IOException e) {
			throw e;
		} finally {
			writer.close();
		}
	}
}
