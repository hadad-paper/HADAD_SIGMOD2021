package hadad.commons.miscellaneous;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Class collecting utilities time management
 */
public class TimeUtils {
	private static final DateFormat dateFormat = 
			new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private static final DateFormat compactDateFormat = 
			new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	/**
	 * The actual time in nanoseconds
	 * @return the actual time in nanoseconds
	 */
	public static long getNanoSec(){
		return System.nanoTime();
	}

	/**
	 * The actual time in milliseconds
	 * @return the actual time in nanoseconds
	 */
	// you always need nanoTime because it measures elapsed-time (no 
	// skew corrections), currentTimeMillis measures wall-clock time!
	public static long getMSec(){
		return getNanoSec()/1000/1000;
		//return System.currentTimeMillis();
	}

	/**
	 * The difference between the actual time and a past time, in milliseconds
	 * @param start the original point in the past
	 * @return actualtime - past (in milliseconds)
	 */
	public static long getDiffMSec(long start){
		//return ((System.nanoTime() - start)/1000);
		return getMSec() - start;
	}

	/**
	 * Pretty string representation of the current time
	 * @return string representation of the current time
	 */
	public static String getCurrTime(){
		return dateFormat.format(Calendar.getInstance().getTime());
	}

	/**
	 * Compact string representation of the current time
	 * @return compact string representation of the current time
	 */
	public static String getCompactCurrTime(){
		return compactDateFormat.format(Calendar.getInstance().getTime());
	}

	public static boolean isTimeoutExpired(long start, long timeout){
		return timeout > 0 && timeout < TimeUtils.getDiffMSec(start);
	}
}
