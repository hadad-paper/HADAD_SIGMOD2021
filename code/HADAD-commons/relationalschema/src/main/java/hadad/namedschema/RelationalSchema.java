package hadad.namedschema;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;



/**
 * A relational schema
 */
public class RelationalSchema implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Map<String, Relation> relations;

	/**
	 * Constructor
	 *
	 * @param relations
	 * 					The relations in the schema
	 */
	public RelationalSchema(final Collection<Relation> relations) {
		this.relations = new HashMap<String, Relation>();
		relations.stream().forEach(r -> this.relations.put(r.getName(), r));
	}

	/**
	 * Returns the relations in the schema
	 * @return the relations in the schema
	 */
	public Collection<Relation> getRelations() {
		return Collections.unmodifiableCollection(relations.values());
	}

  /**
	 * Gets a relation by name.
	 * @return the relation whose name is 'name', or null if there is no such
	 * relation.
	 */
	public Relation getRelationByName(String name){
		return relations.get(name);
	}

	@Override
	public String toString() {
		final StringBuilder result = new StringBuilder("[");
		for (Relation r : getRelations()) {
			result.append(r);
			result.append(',');
		}
		if (relations.size()!=0) {
			result.deleteCharAt(result.length() - 1);
		}
		result.append("]");
		return result.toString();
	}
}
