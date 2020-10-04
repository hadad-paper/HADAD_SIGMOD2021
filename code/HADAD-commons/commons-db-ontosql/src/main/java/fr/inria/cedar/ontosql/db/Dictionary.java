package fr.inria.cedar.ontosql.db;

/**
 * Dictionary-encoded dataset interface.
 * @author Damian Bursztyn
 */
public interface Dictionary {
	/**
	 * Attempts to get the key for the specified value.
	 * @param value
	 * @return the key for the given value.
	 * @throws DictionaryException
	 * @throws InexistentValueException
	 */
    Integer getKey(final String value) throws DictionaryException, InexistentValueException;

	/**
	 * Attempts to get the value for the specified key.
	 * @param key
	 * @return the value for the given key.
	 * @throws DictionaryException
	 * @throws InexistentKeyException
	 */
    String getValue(final Integer key) throws DictionaryException, InexistentKeyException;
	
	/**
	 * Attempts to indicate if the dictionary contains the given key.
	 * @param key
	 * @return true if the dictionary contains the given key, false otherwise.
	 * @throws DictionaryException
	 */
    boolean containsKey(final Integer key) throws DictionaryException;

	/**
	 * Attempts to indicate if the dictionary contains the given value.
	 * @param value
	 * @return true if the dictionary contains the given value, false otherwise.
	 * @throws DictionaryException
	 */
    boolean containsValue(final String value) throws DictionaryException;

	/**
	 * Attempts to indicate the dictionary size.
	 * @return dictionary size.
	 * @throws DictionaryException 
	 */
    int size() throws DictionaryException;

    void put(String value) throws DictionaryException;
}
