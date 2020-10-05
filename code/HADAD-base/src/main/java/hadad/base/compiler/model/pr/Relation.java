package hadad.base.compiler.model.pr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * A relation
 *
 *  Ioana Ileana
 *  Romain Primet
 */
public class Relation {
	/** The name of the relation */
	protected String name;

	protected List<String> attributes;
	protected List<Integer> types;
	/**
	 *  Constructor
	 *
	 *  @param name
	 *  			the name of the relation
	 *  @param attributes
	 *  			the attributes of the relation (columns in database lexicon).
	 *  @param types
	 *        the types, a collection of type codes as defined in java.sql.Types
	 *  Attribute ordering is significant and preserved.
	 */
	public Relation(String name, Collection<String> attributes, Collection<Integer> types)
	{
		if(attributes == null){
			throw new IllegalArgumentException("Expected non-null attributes");
		}
		if(types == null){
			throw new IllegalArgumentException("Expected non-null types");
		}
		if(attributes.size() != types.size()){
			throw new IllegalArgumentException("Expected attributes and types collections of the same length.");
		}
		this.name = name;
		this.attributes = new ArrayList<>(attributes);
		this.types = new ArrayList<Integer>(types);
	}

	/**
	 *  Gets the relation's name
	 *  @return the name of the relation
	 */
	public String getName()
	{
		return name;
	}

	/**
	 *  Gets the relation's arity
	 *  @return the arity of the relation
	 */
	public int getArity()
	{
		return attributes.size();
	}

  /**
	 * Returns the attributes for this Relation.
	 */
	public List<String> getAttributes(){
		return Collections.unmodifiableList(attributes);
	}

	public List<Integer> getTypes(){
		return Collections.unmodifiableList(types);
	}

	/**
	 * Returns the attribute at position 'index'.
	 */
	public String getAttributeAtPosition(int index){
		return attributes.get(index);
	}

  /**
	 * Returns the type at position 'index'
	 * @return a type code as defined in java.sql.Types
	 */
	public Integer getTypeAtPosition(int index){
		return types.get(index);
	}

	@Override
	public String toString() {
		final StringBuilder result = new StringBuilder();
		result.append(getName());
		result.append("(");
		result.append(attributes);
		result.append(")");
		return result.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, attributes, types);
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Relation)) {
			return false;
		}
		final Relation relation = (Relation) o;
		return name.equals(relation.name) && attributes.equals(relation.attributes) &&
		types.equals(relation.types);
	}
}
