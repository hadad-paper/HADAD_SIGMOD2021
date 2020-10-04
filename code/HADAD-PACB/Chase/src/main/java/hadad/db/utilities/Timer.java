package hadad.db.utilities;

/** 
 * This class represents a timer with start, stop and count capabilities.
 * 
 */

public class Timer {

	private boolean started = false;

	private long startTime = 0;

	private long totalTime = 0;

	private int counter = 0;

	public void reset() {
		started = false;
		startTime = 0;
		totalTime = 0;
		counter = 0;
	}

	public void start() {
		if (!started) {
			startTime = System.nanoTime(); //System.currentTimeMillis();
			started = true;
		}
	}

	public void stop() {
		totalTime += (System.nanoTime() - startTime)/1000000; //System.currentTimeMillis() - startTime;
		startTime = 0;
		started = false;
	}

	public void incCounter() {
		counter++;
	}

	public void setCounter(int i) {
		counter = i;
	}

	public long getTime() {
		return totalTime;
	}

	public int getCount() {
		return counter;
	}

}
