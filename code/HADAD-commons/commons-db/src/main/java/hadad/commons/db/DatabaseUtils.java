package hadad.commons.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

/**
 * Useful and common database related methods.
 */
public class DatabaseUtils {
	private static final Logger log = Logger.getLogger(DatabaseUtils.class);

	/**
	 * Attempts to close the given connection.
	 * 
	 * @param c
	 *            the connection to be close
	 */
	public static void tryClose(final Connection c) {
		try {
			if (c != null && !c.isClosed()) {
				c.close();
			}
		} catch(Exception e) {
			log.error("Failed to close connection.", e);
		}
	}

	/**
	 * Attempts to close the given prepared statement.
	 * 
	 * @param ps
	 *            the prepared statement to be close
	 */
	public static void tryClose(final PreparedStatement ps) {
		try {
			if (ps != null && !ps.isClosed()) {
				ps.close();
			}
		} catch(Exception e) {
			log.error("Failed to close prepared statement.", e);
		}
	}

	/**
	 * Attempts to close the given statement.
	 * 
	 * @param s
	 *            the statement to be close
	 */
	public static void tryClose(final Statement s) {
		try {
			if (s != null && !s.isClosed()) {
				s.close();
			}
		} catch(Exception e) {
			log.error("Failed to close statement.", e);
		}
	}

	/**
	 * Attempts to close the given resultset.
	 * 
	 * @param rs
	 *            the resultset to be close
	 */
	public static void tryClose(final ResultSet rs) {
		try {
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		} catch(Exception e) {
			log.error("Failed to close resultset.", e);
		}
	}
}
