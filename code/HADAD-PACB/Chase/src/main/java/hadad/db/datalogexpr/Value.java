package hadad.db.datalogexpr;

import java.util.Vector;

/**
 * This class represents a variable, which might be distinguished or Skolem, or
 * a constant, which might be numeric constant or a string.
 */
public class Value {

	private short numConstant;
	
	private boolean isNumConstant;

	private boolean isStrConstant;

	private String varConst;

	private boolean isSkolem;
	
	private Value representative;

	public final static char numDelimiter = '\'';

	public final static String strDelimiter = "\"";
	
	private final static String skolemPrefix = "SK_";
	
	private final static String constantPrefix = "CONST_";
	
	private final static String variablePrefix = "VAR_";
	
	private static int skolemNumber = 0;
	
	private static int constantNumber = 0;
	
	private static int variableNumber = 0;

	// Be careful with isNumConstant
	private Value() {
		numConstant = 0;
		varConst = null;

		isNumConstant = true;
		varConst = numDelimiter + ((Short)numConstant).toString() + numDelimiter;
		
		isStrConstant = false;
		isSkolem = false;
	}

	public Value(Value value) {
		numConstant = value.numConstant;
		if (value.varConst != null)
			varConst = new String(value.varConst);

		isNumConstant = value.isNumConstant;
		isStrConstant = value.isStrConstant;
		isSkolem = value.isSkolem;
	}

	/**
	 * This method creates a <code>Value</code> given a string. The string
	 * must be a variable and not a constant.
	 * 
	 * @param variable
	 *            the string on which the <code>Value</code> will be created
	 * @param isSkolem
	 *            if the variable is a Skolem function or not
	 * @throws DatalogException
	 *             when a constant is passed as parameter
	 */
	public static Value createVariable(String variable, boolean isSkolem)
			throws DatalogException {
		int index1, index2;

		index1 = variable.indexOf(numDelimiter);
		index2 = variable.indexOf(strDelimiter);
		if (index1 >= 0 || index2 >= 0)
			throw new DatalogException("Value constructor failed: "
					+ "Parameter is not a variable: " + variable);

		Value value = new Value();
		value.varConst = new String(variable);
		value.isNumConstant = false;
		value.isStrConstant = false;
		value.isSkolem = isSkolem;

		return value;
	}
	
	public static void restartVarIndex() {
		variableNumber = 0;
		//skolemNumber = 0;
		constantNumber = 0;
		
	}

	/**
	 * This method creates a <code>Value</code> given a string. The string can
	 * either represents a numerical constant or a string constant only.
	 * 
	 * @param strValue
	 *            the string on which the <code>Value</code> will be created
	 * @throws DatalogException
	 *             when an empty numerical constant is given, or the
	 *             <code>strValue</code> is not a constant.
	 */
	// TODO: Can this be made faster?
	// TODO: In the numeric constant we do not care about isNumConstant?
	public static Value createConstant(String strValue) throws DatalogException {
		int index, index2;

		// numerical constant
		index = strValue.indexOf(numDelimiter);
		if (index >= 0) {
			index2 = strValue.lastIndexOf(numDelimiter);
			if (index == index2)
				throw new DatalogException("Value constructor failed: "
						+ "Empty numerical constant found.");

			Value value = new Value();
			try {
				Short shortValue = (new Short(strValue.substring(index + 1,
						index2).trim()));
				value.numConstant = shortValue; //.shortValue();
				value.varConst = numDelimiter + ((Short)value.numConstant).toString() + numDelimiter;
//				value.varConst = shortValue.toString();
			} catch (NumberFormatException e) {
				throw new DatalogException("Value constructor failed: "
						+ "Malformed numerical constant: " + strValue);
			}

			return value;
		}

		// string constant
		index = strValue.indexOf(strDelimiter);
		if (index >= 0) {
			Value value = new Value();
			value.varConst = new String(strValue);
			value.isNumConstant = false;
			value.isStrConstant = true;

			return value;
		}

		throw new DatalogException("Value constructor failed: "
				+ "Parameter is not a constant: " + strValue);
	}
	
	public static Value createNumericConstant(Double numValue) {
		Value value = new Value();
		
		value.numConstant = numValue.shortValue();
		value.varConst = numDelimiter + ((Short)value.numConstant).toString() + numDelimiter;
//		value.varConst = numValue.toString();
		
		return value;
	}
	
	public static Value createStringConstant(String strValue) {
		Value value = new Value();
		
		value.varConst = new String(strValue);
		value.isNumConstant = false;
		value.isStrConstant = true;
		value.isSkolem = false;

		return value;
	}
	
	public static Value createFreshSkolem() {
		Value value = new Value();
		
		value.varConst = skolemPrefix + skolemNumber;
		skolemNumber++;
		
		value.isNumConstant = false;
		value.isStrConstant = false;
		value.isSkolem = true;
		
		return value;
	}

	public static Value createFreshVariable() {
		Value value = new Value();
		
		value.varConst = variablePrefix + variableNumber;
		variableNumber++;
		
		value.isNumConstant = false;
		value.isStrConstant = false;
		value.isSkolem = false;
		
		return value;
	}
	
	public static Value createFreshStringConstant() {
		String name = constantPrefix + constantNumber;
		constantNumber++;
		
		return createStringConstant(name);
	}
	
	/**
	 * 
	 * @return <code>true</code> when the value is a constant, either
	 *         numerical or string one
	 */
	public boolean isAnyConstant() {
		return isNumConstant || isStrConstant;

	}

	public boolean isNumConstant() {
		return isNumConstant;
	}

	public boolean isStrConstant() {
		return isStrConstant;
	}

	/**
	 * 
	 * @return <code>true</code> if the <code>Value</code> represents a
	 *         variable which is a Skolem function; <code>false</code>
	 *         otherwise.
	 */
	public boolean isSkolem() {
		return isSkolem;
	}

	public String getValueStr() {
//		if (isNumConstant)
//			if (varConst == null)
//				varConst = numDelimiter + ((Short)numConstant).toString() + numDelimiter;

		return varConst;
	}

	/**
	 * This method is much like the equals methods for strings; it looks to see
	 * that the value represents the same rather than that it has the same
	 * memory references
	 * 
	 * @param value
	 *            the <code>Value</code> to check
	 * @return <code>true</code> if equal; <code>false</code> otherwise.
	 */
	public boolean equals(Value value) {		
		if (value == null)
			return false;
		
		if (value.isNumConstant && isNumConstant)
			return (numConstant == value.numConstant);

		if (!value.isNumConstant && !isNumConstant)
			return varConst.equals(value.varConst);

		return false;
	}
	
	public boolean equals(Object obj) {
		if (!(obj instanceof Value))
			return false;
		
		return this.equals((Value)obj);
	}
	
	public int hashCode() {
		return varConst.hashCode();
	}

	/**
	 * This method checks to see if the vector contains this <code>Value</code>
	 * since the Vector.contains() function doesn't work right with
	 * <code>Value</code> although it does with Strings. Returns true if a
	 * vector contains the value, false otherwise.
	 * 
	 * @param vector
	 *            the <code>Vector</code> to check
	 * @return <code>true</code> if found; <code>false</code> otherwise.
	 */
	public boolean containedInVector(Vector<Value> vector) {
		int i;
		int size = vector.size();
		for (i = 0; i < size; i++) {
			if (this.equals((Value) vector.elementAt(i)))
				return true;
		}

		return false;
	}
	
	// Is it OK if we just point to the string of the representative instead of creating a new one?
	public Value getRepresentative() {
		if (representative == null)
			return this;
		
		representative = representative.getRepresentative();
		//varConst = representative.varConst;
		
		return representative;
	}
	
	public boolean equalsByRepresentative(Value other) {
		Value thisRepresentative = this.getRepresentative();
		Value otherRepresentative = other.getRepresentative();
		
		return otherRepresentative.equals(thisRepresentative);
	}
	
	// Returns true if it succeeded in equating the values and false
	// otherwise (if both are different constants)
	// TODO: Make it work if called for the same value (it should avoid cycles of representatives)
	public boolean equate(Value other) {
		Value thisRepresentative = this.getRepresentative();
		Value otherRepresentative = other.getRepresentative();
		
//		// If it is the same value (same representative), return false without
//		// doing anything
//		if (otherRepresentative.equals(thisRepresentative))
//			return false;
		
		if (otherRepresentative.isAnyConstant())
		{
			if (thisRepresentative.isAnyConstant())
				return otherRepresentative.equals(thisRepresentative);
			else
				thisRepresentative.representative = otherRepresentative;
		}	
		// Replace skolem with non-skolem!
		else if (otherRepresentative.isSkolem)
			otherRepresentative.representative = thisRepresentative;
		else
			thisRepresentative.representative = otherRepresentative;

		// Important!
		thisRepresentative = this.getRepresentative();
		
		this.varConst = thisRepresentative.varConst;
		this.isStrConstant = thisRepresentative.isStrConstant;
		this.isNumConstant = thisRepresentative.isNumConstant;
		this.isSkolem = thisRepresentative.isSkolem;
		
		other.varConst = thisRepresentative.varConst;
		other.isStrConstant = thisRepresentative.isStrConstant;
		other.isNumConstant = thisRepresentative.isNumConstant;
		other.isSkolem = thisRepresentative.isSkolem;
		
		return true;
	}
	
	public String toString() {
		return varConst;
	}

}
