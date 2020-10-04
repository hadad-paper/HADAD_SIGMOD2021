package hadad.commons.miscellaneous;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Class collecting utilities for managing concurrency
 */
public class ConcurrencyUtils {

	/**
	 * Run a set of callable tasks enforcing a given timeout, returns their results
	 * @param unit timeunit for the timeout
	 * @param timeout timeout value
	 * @param tasks list of callables to be executed
	 * @return a list of results from the callables
	 * @throws InterruptedException if one (or more) of the callables is interrupted
	 * @throws ExecutionException if one (or more) of the callables experience an exepction during its execution
	 * @throws TimeoutException if one (or more) of the callables does not complete in the given time
	 */
	public static <T> List<T> runCallables(TimeUnit unit, int timeout, 
			Collection<? extends Callable<T>> tasks) 
					throws InterruptedException, ExecutionException, TimeoutException {
		return runCallables(unit, timeout, tasks, 
				Executors.newFixedThreadPool(JVMUtils.getNumberOfCores()));
	}

	/**
	 * Run a set of callable tasks enforcing a given timeout, returns their results
	 * @param unit timeunit for the timeout
	 * @param timeout timeout value
	 * @param tasks list of callables to be executed
	 * @param multiThreaded controls the level of multithreading (none of full)
	 * @return a list of results from the callables
	 * @throws InterruptedException if one (or more) of the callables is interrupted
	 * @throws ExecutionException if one (or more) of the callables experience an exepction during its execution
	 * @throws TimeoutException if one (or more) of the callables does not complete in the given time
	 */
	public static <T> List<T> runCallables(TimeUnit unit, int timeout, 
			Collection<? extends Callable<T>> tasks, boolean multiThreaded) 
					throws InterruptedException, ExecutionException, TimeoutException {
		return runCallables(unit, timeout, tasks, 
				Executors.newFixedThreadPool(multiThreaded ? JVMUtils.getNumberOfCores() : 1));
	}

	/**
	 * Run a set of callable tasks enforcing a given timeout, returns their results
	 * @param unit timeunit for the timeout
	 * @param timeout timeout value
	 * @param tasks list of callables to be executed
	 * @param executor to be used for running the callables
	 * @return a list of results from the callables
	 * @throws InterruptedException if one (or more) of the callables is interrupted
	 * @throws ExecutionException if one (or more) of the callables experience an exepction during its execution
	 * @throws TimeoutException if one (or more) of the callables does not complete in the given time
	 */
	public static <T> List<T> runCallables(TimeUnit unit, int timeout, 
			Collection<? extends Callable<T>> tasks, ExecutorService executor) 
					throws InterruptedException, ExecutionException, TimeoutException {

		if (timeout <= 0)
			timeout = Integer.MAX_VALUE;

		List<Future<T>> futures = new ArrayList<>(tasks.size());
		List<T> res = new ArrayList<>(futures.size());
				
		try {
			futures.addAll(executor.invokeAll(tasks, timeout, unit));
		
			executor.shutdown();

			for (Future<T> f : futures)
				res.add(f.get(timeout, unit));
			
		} finally {
			executor.shutdownNow();
		}
		return res;
	}
}
