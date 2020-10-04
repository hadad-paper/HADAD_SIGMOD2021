package fr.inria.cedar.ontosql.db;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import com.sleepycat.bind.tuple.StringBinding;
import com.sleepycat.je.DatabaseEntry;

import fr.inria.cedar.ontosql.db.BerkeleyDB;
import fr.inria.cedar.ontosql.db.BerkeleyDBException;

/**
 * @author Damian Bursztyn
 */
public class BerkeleyDBTest {
	@Rule
	public TemporaryFolder folder = new TemporaryFolder();

	@Test
	public void testDuplicatedKeySupport() throws IOException,
	BerkeleyDBException {
		final File storageDirectory = folder.newFolder("BDB");
		final BerkeleyDB bdb = new BerkeleyDB("test",
				storageDirectory.getAbsolutePath());
		bdb.openDatabase("test1");
		bdb.openDatabase("test2");

		DatabaseEntry key = new DatabaseEntry();
		StringBinding.stringToEntry("key", key);
		DatabaseEntry value1 = new DatabaseEntry();
		StringBinding.stringToEntry("1", value1);
		DatabaseEntry value2 = new DatabaseEntry();
		StringBinding.stringToEntry("2", value2);
		bdb.put("test1", key, value1);
		bdb.put("test1", key, value2);
		DatabaseEntry value3 = new DatabaseEntry();
		StringBinding.stringToEntry("3", value3);
		bdb.put("test2", key, value3);

		assertEquals(bdb.count("test1"), 2);
		assertEquals(bdb.count("test2"), 1);
		for (Entry<DatabaseEntry, Collection<DatabaseEntry>> entry : bdb
				.entries("test1").entrySet()) {
			assertEquals(StringBinding.entryToString(entry.getKey()), "key");
			Iterator<DatabaseEntry> it = entry.getValue().iterator();
			assertEquals("1", StringBinding.entryToString(it.next()));
			assertEquals("2", StringBinding.entryToString(it.next()));
		}
		for (Entry<DatabaseEntry, Collection<DatabaseEntry>> entry : bdb
				.entries("test2").entrySet()) {
			assertEquals(StringBinding.entryToString(entry.getKey()), "key");
			Iterator<DatabaseEntry> it = entry.getValue().iterator();
			assertEquals("3", StringBinding.entryToString(it.next()));
		}
		bdb.close();
	}
}
