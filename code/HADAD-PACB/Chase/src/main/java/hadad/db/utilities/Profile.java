package hadad.db.utilities;

import java.util.Hashtable;
import java.util.Iterator;

/** 
 * This class builds a profile for the execution time.
 * 
 */

public class Profile {

	private static Hashtable<String, Timer> timers = new Hashtable<String, Timer>();

	public static void reset() {
		Iterator<Timer> iter = timers.values().iterator();

		while (iter.hasNext())
			iter.next().reset();
	}

	public static void addTimer(String timer) {
		timers.put(timer, new Timer());
	}

	public static void start(String timer) {
		if (timers.containsKey(timer))
			timers.get(timer).start();
	}

	public static void stop(String timer) {
		if (timers.containsKey(timer))
			timers.get(timer).stop();
	}
	
	public static void reset(String timer) {
		if (!timers.containsKey(timer))
			addTimer(timer);
		
		timers.get(timer).reset();
	}

	public static void incCounter(String timer) {
		if (timers.containsKey(timer))
			timers.get(timer).incCounter();
	}

	public static void setCounter(String timer, int i) {
		if (timers.containsKey(timer))
			timers.get(timer).setCounter(i);
	}

	public static long getTime(String timer) {
		if (timers.containsKey(timer))
			return timers.get(timer).getTime();

		return 0;
	}

	public static int getCount(String timer) {
		if (timers.containsKey(timer))
			return timers.get(timer).getCount();

		return 0;
	}

}
