package fr.inria.cedar.ontosql.db;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sleepycat.je.Cursor;
import com.sleepycat.je.CursorConfig;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseEntry;
import com.sleepycat.je.DatabaseStats;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import com.sleepycat.je.LockMode;
import com.sleepycat.je.OperationStatus;
import com.sleepycat.je.StatsConfig;
import com.sleepycat.je.Transaction;
import com.sleepycat.je.TransactionConfig;

/**
 * Storage layer implementation for Berkeley DB.
 * @author Damian Bursztyn
 */
public class BerkeleyDB {
	public final String name;
	private final Map<String, Database> databases;
	private final Environment environment;

	/**
	 * Default constructor.
	 *
	 * @param name
	 * @param storagePath
	 * @throws BerkeleyDBException
	 */
	public BerkeleyDB(final String name, final String storageDirectory)
			throws BerkeleyDBException {
		this(name, storageDirectory, defaultEnvironmentConfig(),
				defaultDatabaseConfig());
	}

	public BerkeleyDB(final String name, final String storageDirectory,
			final EnvironmentConfig environmentConfig,
			final DatabaseConfig databaseConfig) throws BerkeleyDBException {
		this.name = name;
		final String fullStorageDirectory = storageDirectory + name + "/";
		if (!createPathIfNotExist(fullStorageDirectory)) {
			throw new BerkeleyDBException(
					"The storage dictionary for the database does not exists and couldn't be created.");
		}
		environment = new Environment(new File(fullStorageDirectory),
				environmentConfig);
		databases = new HashMap<String, Database>();
		for (final String databaseName : getDatabaseNames()) {
			openDatabase(databaseName, databaseConfig);
		}
	}

	public Transaction beginTransaction(Transaction parent,
			TransactionConfig txnConfig) {
		return environment.beginTransaction(parent, txnConfig);
	}

	public boolean containsDatabase(final String name) {
		return databases.containsKey(name);
	}

	public void openDatabase(final String name) throws BerkeleyDBException {
		openDatabase(name, defaultDatabaseConfig());
	}

	public void openDatabase(final String name,
			final DatabaseConfig databaseConfig) throws BerkeleyDBException {
		if (databases.containsKey(name)) {
			throw new BerkeleyDBException("The database " + name
					+ " already exists in the enviroment.");
		}
		databases.put(name,
				environment.openDatabase(null, name, databaseConfig));
	}

	public void closeDatabase(final String name) {
		databases.get(name).close();
		databases.remove(name);
	}

	public void truncateDatabase(final String name) {
		closeDatabase(name);
		environment.truncateDatabase(null, name, false);
	}

	public List<String> getDatabaseNames() {
		return environment.getDatabaseNames();
	}

	public Database getDatabase(final String name) {
		return databases.get(name);
	}

	public void close() {
		final Set<String> databasesName = new HashSet<String>(
				databases.keySet());
		for (final String databaseName : databasesName) {
			closeDatabase(databaseName);
		}
		environment.close();
	}

	public void syncDatabase(final String name) {
		databases.get(name).sync();
	}

	/**
	 * Counts the key/data pairs in the database.
	 * @return key/data pairs count.
	 */
	public final long count(final String name) {
		return databases.get(name).count();
	}

	/**
	 * Stores the key/data pair into the database.
	 * @param key
	 * @param data
	 */
	public final void put(final String name, DatabaseEntry key,
			DatabaseEntry data) {
		databases.get(name).put(null, key, data);
	}

	/**
	 * Retrieves the key/data pair with the given key.
	 * @param key
	 * @param data
	 * @return Operation status
	 */
	public final OperationStatus get(final String name, DatabaseEntry key,
			DatabaseEntry data) {
		return databases.get(name).get(null, key, data, null);
	}

	/**
	 * Retrieves all the stored key/data pairs.
	 * Exclude key/date pairs duplications.
	 * @return stored key/pars, excluding duplicates
	 */
	public final Map<DatabaseEntry, Collection<DatabaseEntry>> entries(
			final String name) {
		Map<DatabaseEntry, Collection<DatabaseEntry>> entries = new HashMap<DatabaseEntry, Collection<DatabaseEntry>>();
		Cursor cursor = openCursor(name, null, null);
		DatabaseEntry key = new DatabaseEntry();
		DatabaseEntry data = new DatabaseEntry();
		while (cursor.getNext(key, data, null) == OperationStatus.SUCCESS) {
			if (entries.containsKey(key)) {
				entries.get(key).add(data);
			} else {
				Set<DatabaseEntry> values = new HashSet<DatabaseEntry>();
				values.add(data);
				entries.put(key, values);
			}
			key = new DatabaseEntry();
			data = new DatabaseEntry();
		}
		cursor.close();

		return entries;
	}

	/**
	 * Opens a cursor for the database.
	 * @return
	 */
	public final Cursor openCursor(final String name, Transaction txn, CursorConfig cursorConfig) {
		return databases.get(name).openCursor(txn, cursorConfig);
	}

	/**
	 * Retrieves the key/data pair with the given key.
	 * @param key
	 * @param data
	 * @return Operation status
	 */
	public final OperationStatus getSearchKey(Cursor cursor, DatabaseEntry key, DatabaseEntry data, LockMode lockMode) {
		return cursor.getSearchKey(key, data, lockMode);
	}

	public DatabaseStats getStats(final String name) {
		return getStats(name, new StatsConfig());
	}

	public DatabaseStats getStats(final String name, final StatsConfig config) {
		return databases.get(name).getStats(config);
	}

	/**
	 * Checks for the storage path.
	 * Creates the directories if non existent.
	 * @param storagePath
	 * @return
	 */
	private static boolean createPathIfNotExist(final String storagePath) {
		final File f = new File(storagePath);
		if(!f.exists()) {
			return f.mkdirs();
		}
		return true;
	}

	/**
	 * Default environment configuration.
	 * @return Environment configuration.
	 */
	private static EnvironmentConfig defaultEnvironmentConfig() {
		final EnvironmentConfig envConfig = new EnvironmentConfig();
		envConfig.setAllowCreate(true);

		return envConfig;
	}

	/**
	 * Default database configuration.
	 * @return Database configuration.
	 */
	private static DatabaseConfig defaultDatabaseConfig() {
		final DatabaseConfig dbConfig = new DatabaseConfig();
		dbConfig.setAllowCreate(true);
		dbConfig.setSortedDuplicates(true);
		dbConfig.setDeferredWrite(true);

		return dbConfig;
	}
}
