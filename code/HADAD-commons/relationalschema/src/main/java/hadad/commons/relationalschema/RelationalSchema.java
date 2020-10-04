package hadad.commons.relationalschema;

import java.util.List;



/**
 * A relational schema
 *
 */
public class RelationalSchema implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** The relations in the schema */
	private List<Relation> relations;

	/**
	 * Constructor
	 *
	 * @param relations
	 * 					The relations in the schema
	 */
	public RelationalSchema(final List<Relation> relations) {
		this.relations = relations;
	}

	/**
	 * Returns the relations in the schema
	 * @return the relations in the schema
	 */
	public List<Relation> getRelations() {
		return relations;
	}

	@Override
	public String toString() {
		final StringBuilder result = new StringBuilder();
		for (Relation r: relations) {
			result.append(r);
			result.append(',');
		}
		if (relations.size()!=0) {
			result.deleteCharAt(result.length() - 1);
		}
		result.append(";");
		return result.toString();
	}
}


