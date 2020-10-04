package hadad.commons.db;

/**
 * Dictionary-encoded dataset interface.
 */
public interface Dictionary {
	/**
	 * Attempts to get the key for the specified value.
	 * @param value
	 * @return the key for the given value.
	 * @throws DictionaryException
	 * @throws InexistentValueException
	 */
	public Integer getKey(final String value) throws DictionaryException, InexistentValueException;

	/**
	 * Attempts to get the value for the specified key.
	 * @param key
	 * @return the value for the given key.
	 * @throws DictionaryException
	 * @throws InexistentKeyException
	 */
	public String getValue(final Integer key) throws DictionaryException, InexistentKeyException;
	
	/**
	 * Attempts to indicate if the dictionary contains the given key.
	 * @param key
	 * @return true if the dictionary contains the given key, false otherwise.
	 * @throws DictionaryException
	 */
	public boolean containsKey(final Integer key) throws DictionaryException;

	/**
	 * Attempts to indicate if the dictionary contains the given value.
	 * @param value
	 * @return true if the dictionary contains the given value, false otherwise.
	 * @throws DictionaryException
	 */
	public boolean containsValue(final String value) throws DictionaryException;

	/**
	 * Attempts to indicate the dictionary size.
	 * @return dictionary size.
	 * @throws DictionaryException 
	 */
	public int size() throws DictionaryException;
}
