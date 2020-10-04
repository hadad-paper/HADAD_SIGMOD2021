package hadad.commons.miscellaneous;

import org.apache.log4j.Logger;

/**
 * Debug log message layer based on a flag.
 */
public final class Debugger {
	private final static Logger log = Logger.getLogger(Debugger.class);
	private static boolean flag;

	/**
	 * Logs the message if the (Debugger) flag is on.
	 *
	 * @param msg
	 */
	public static void log(final String msg) {
		if (flag) {
			log.debug(msg);
		}
	}

	/**
	 * Sets the verbose mode.
	 *
	 * @param flag
	 */
	public static void setFlag(final boolean flag) {
		Debugger.flag = flag;
	}

	/**
	 * Sets the verbose mode on.
	 */
	public static void turnOn() {
		flag = true;
	}

	/**
	 * Sets the verbose mode off.
	 */
	public static void turnOff() {
		flag = false;
	}
}
