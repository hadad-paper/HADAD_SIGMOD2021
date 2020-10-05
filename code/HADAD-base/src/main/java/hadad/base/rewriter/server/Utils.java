package hadad.base.rewriter.server;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.Map;

import hadad.commons.conjunctivequery.ConjunctiveQuery;
import hadad.commons.conjunctivequery.parser.CQParser;
import hadad.commons.constraints.Constraint;
import hadad.commons.constraints.parser.ConstraintParser;
import hadad.commons.relationalschema.RelationalSchema;
import hadad.commons.relationalschema.parser.RelSchemaParser;
import hadad.base.rewriter.Context;

public final class Utils {
	public static List<Constraint> parseConstraints(final String fileName)
			throws IOException,
			hadad.commons.constraints.parser.ParseException {
		final FileReader fr = new FileReader(fileName);
		final ConstraintParser parser = new ConstraintParser(fr);
		final List<Constraint> constraints = parser.parse();
		fr.close();
		return constraints;
	}

	public static List<RelationalSchema> parseSchemas(final String fileName)
			throws IOException,
			hadad.commons.relationalschema.parser.ParseException {
		final FileReader fr = new FileReader(fileName);
		final RelSchemaParser parser = new RelSchemaParser(fr);
		final List<RelationalSchema> constraints = parser.parse();
		fr.close();
		return constraints;
	}

	public static Context parseContext(final String schemasFileName,
			final String forwardConstraintsFileName,
			final String backwardConstraintsFileName) throws IOException,
			hadad.commons.relationalschema.parser.ParseException,
			hadad.commons.constraints.parser.ParseException {
		final List<RelationalSchema> schemas = Utils
				.parseSchemas(schemasFileName);
		return new Context(schemas.get(0), schemas.get(1),
				Utils.parseConstraints(forwardConstraintsFileName),
				Utils.parseConstraints(backwardConstraintsFileName));
	}

	public static ConjunctiveQuery parseQuery(final String str)
			throws IllegalArgumentException,
			hadad.commons.conjunctivequery.parser.ParseException {
		final CQParser parser = new CQParser(new StringReader(str));
		final Map<String, ConjunctiveQuery> queries = parser.parse();
		if (queries.size() != 1) {
			throw new IllegalArgumentException(
					"The query string is not a valid RDF CQ.");
		}
		return queries.values().iterator().next();
	}
}
