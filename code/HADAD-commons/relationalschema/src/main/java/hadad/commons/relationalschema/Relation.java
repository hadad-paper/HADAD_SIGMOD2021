package hadad.commons.relationalschema;

import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * A relation
 *
 */
public class Relation implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/** The name of the relation */
	private String name;

	/** The arity of the relation */
	private int arity;

	private Set<AccessPattern> accPatterns;
	/**
	 *  Constructor
	 *
	 *  @param name
	 *  			the name of the relation
	 *  @param arity
	 *  			the arity of the relation
	 */
	public Relation(String name, int arity)
	{
		this.name = name;
		this.arity = arity;
		this.accPatterns = new HashSet<AccessPattern>();

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
		return arity;
	}

	public void addAll(Collection<AccessPattern> accPats){
		this.accPatterns.addAll(accPats);
	}

	public void add(AccessPattern accPat){
		this.accPatterns.add(accPat);
	}

	public Collection<AccessPattern> getAccPatterns(){
		return accPatterns;
	}

	@Override
	public String toString() {
		final StringBuilder result = new StringBuilder();
		result.append(getName());
		result.append("(");
		result.append(getArity());
		result.append(")");
		return result.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, arity, accPatterns);
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Relation)) {
			return false;
		}
		final Relation relation = (Relation) o;
		return name.equals(relation.name) && arity == relation.arity
				&& accPatterns.equals(relation.accPatterns);
	}
}