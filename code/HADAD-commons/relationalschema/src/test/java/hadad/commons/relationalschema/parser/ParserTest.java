package hadad.commons.relationalschema.parser;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.junit.Test;

import hadad.commons.relationalschema.AccessPattern;
import hadad.commons.relationalschema.Relation;
import hadad.commons.relationalschema.RelationalSchema;
import hadad.commons.relationalschema.parser.RelSchemaParser;

public class ParserTest {

	@Test
	public void SchemaTest() {
		ArrayList<RelationalSchema> parsed= null;
		try
		{
			InputStream is = getClass().getResourceAsStream("/SchemaTest");
			RelSchemaParser parser = new RelSchemaParser(is);
			parsed = parser.parse();
		} catch (Exception e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
		assertTrue(parsed.size() == 1);
		RelationalSchema schema = parsed.get(0);
		List<Relation> relations = schema.getRelations();
		assertTrue(relations.size()==3);
		assertTrue(relations.get(0).getName().equals("R"));
		assertTrue(relations.get(1).getName().equals("S"));
		assertTrue(relations.get(2).getName().equals("T"));
		assertTrue(relations.get(0).getArity() == 3);
		assertTrue(relations.get(1).getArity() == 4);
		assertTrue(relations.get(2).getArity() == 5);

		HashSet<AccessPattern> patsR = new HashSet<AccessPattern>();
		AccessPattern expected1 = new AccessPattern("iio");
		AccessPattern expected2 = new AccessPattern("ooi");
		AccessPattern expected3 = new AccessPattern("ooo");
		AccessPattern expected4 = new AccessPattern("oio");
		patsR.add(expected1);
		patsR.add(expected2);
		patsR.add(expected3);
		patsR.add(expected4);
		for(AccessPattern ac:relations.get(0).getAccPatterns()){
			assertTrue(patsR.contains(ac));
		}
		assertTrue(relations.get(1).getAccPatterns().toString(),relations.get(1).getAccPatterns().isEmpty());
		HashSet<AccessPattern> patsT = new HashSet<AccessPattern>();
		AccessPattern expected5 = new AccessPattern("oiioi");
		patsT.add(expected5);
		for(AccessPattern ac:relations.get(2).getAccPatterns()){
			assertTrue(patsT.contains(ac));
		}

	}
}
