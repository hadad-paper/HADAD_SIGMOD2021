package hadad.commons.miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class Cache<K, V> {
	private Map<K, V> cache;
	private int hits;
	private int misses;

	/**
	 * Default constructor.
	 */
	public Cache() {
		reset();
	}

	/**
	 * Reset the counter.
	 */
	public void reset() {
		cache = new HashMap<K, V>();
		hits = 0;
		misses = 0;
	}

	/**
	 * Returns the value to which the specified key is mapped, or null if this
	 * cache contains no mapping for the key. Increments the hits/misses
	 * counters accordingly.
	 *
	 * @param key
	 *            the key whose associated value is to be returned
	 * @return the value to which the specified key is mapped, or null if this
	 *         cache contains no mapping for the key
	 */
	public V get(final K key) {
		if (cache.containsKey(key)) {
			hits++;
		} else {
			misses++;
		}
		return cache.get(key);
	}

	/**
	 * Associates the specified value with the specified key in this cache.
	 *
	 * @param key
	 *            key with which the specified value is to be associated
	 * @param value
	 *            value to be associated with the specified key
	 */
	public void put(final K key, final V value) {
		cache.put(key, value);
	}

	/**
	 * Return the counted hits.
	 *
	 * @return counted hits
	 */
	public int getHitsCount() {
		return hits;
	}

	/**
	 * Return the counted misses.
	 *
	 * @return counted misses
	 */
	public int getMissesCount() {
		return misses;
	}
}
