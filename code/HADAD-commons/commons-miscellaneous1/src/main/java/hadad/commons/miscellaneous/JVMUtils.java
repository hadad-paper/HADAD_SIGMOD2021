package hadad.commons.miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import hadad.commons.miscellaneous.enums.OS;

/**
 * Class collecting utilities for managing different aspects of the JVM
 */
public class JVMUtils {

	private static final Runtime runtime = Runtime.getRuntime();
	private static final int gcIterations = 2;
	//	private static final int gcWaitTime = 250;

	/**
	 * Gets the operating system enumeration value associated to the 
	 * one running the current JVM
	 */
	public static OS getOS() {
		
		String osStr = System.getProperty("os.name", 
				"generic").toLowerCase(Locale.ENGLISH);
		
		OS os = OS.UNKNOWN;

		if (osStr.contains("mac") || osStr.contains("darwin"))
			os = OS.MACOS;
		else if (osStr.contains("win"))
			os = OS.WIN;
		else if (osStr.contains("nux"))
			os = OS.LINUX;
		else
			os = OS.UNKNOWN;
				
		return os;
	}
	
	/**
	 * Gets the parameters with which the JVM has been started
	 * @return the list of parameters with which the JVM has been started
	 */
	public static List<String> getJVMParams(){
		RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
		List<String> arguments = runtimeMxBean.getInputArguments();
		
		return arguments;
	}

	/**
	 * Retrieves the number of cores available on the maching
	 * @return the number of cores available on the maching
	 */
	public static int getNumberOfCores(){
		return Runtime.getRuntime().availableProcessors();
	}

	/**
	 * Computes the amount of used memory in MB, possibly calling the GC 
	 * for improving the accuracy of the estimation
	 * @param callGC if true tries to call the GC to clean unused memory
	 * @param preCallGC call the GC before/after reading the used memory 
	 * @param sleepMs sleep interval in ms between GC calls
	 * @return the amount of used memory in MB
	 */
	public static double getUsedMemory(boolean callGC, boolean preCallGC, int sleepMs){
		if(callGC == false)
			return getUsedMemory();

		if(preCallGC){
			for (int i = 0; i < gcIterations; i++) {
				System.gc();
				try {
					Thread.sleep(sleepMs);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

		double mem = getUsedMemory();

		if(!preCallGC){
			for (int i = 0; i < gcIterations; i++) {
				System.gc();
				try {
					Thread.sleep(sleepMs);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		return mem;
	}

	/**
	 * Gets the amount of used memory
	 * @return the amount of used memory in MB
	 */
	public static double getUsedMemory(){
		return (runtime.totalMemory() - runtime.freeMemory())/1024/1024;
	}


	/**
	 * Gets the percentage of used memory
	 * @return the percentage of used memory
	 */
	public static int getPercentageFreeMem(){
		return new Long(runtime.freeMemory() / runtime.maxMemory()).intValue();
	}

	/**
	 * Prints the used memory with an attempt to call the GC
	 * @param minMB minimum usage in MB for calling the GC
	 * @param sleepMs sleep interval between multiple GC calls
	 */
	public static void getUsedMemoryAndCleanLight(int minMB, int sleepMs) {
		if(getUsedMemory() < minMB)
			return;

		System.out.println("Used Memory (pre): " + getUsedMemory());
		System.out.println("Used Memory (post): " + getUsedMemory(true,true,sleepMs));
	}

	/**
	 * Prints the used memory calling also the GC
	 * @param minMB minimum usage in MB for calling the GC
	 * @param sleepMs sleep interval between multiple GC calls
	 */
	public static void getUsedMemoryAndClean(int minMB, int sleepMs) {
		if(getUsedMemory() < minMB)
			return;

		System.out.println("Used Memory (pre): " + getUsedMemory(false,false,sleepMs));
		System.out.println("Used Memory (post): " + getUsedMemory(true,true,sleepMs));
	}

	/**
	 * Runs an external program using a ProcessBuilder
	 * @param params parameters for the external process (OS dependant)
	 * @param showOutput true if the output of the program has to be shown, false otherwise  
	 * @return a string representing the std output of the external program 
	 */
	public static String runExternalProcess(String [] params, boolean showOutput){
		return runExternalProcess(params, showOutput, Collections.singleton(0));
	}

	/**
	 * Runs an external program using a ProcessBuilder
	 * @param params parameters for the external process (OS dependant)
	 * @param showOutput true if the output of the program has to be shown, false otherwise
	 * @param legalExitCodes the set of exit codes for normal executions 
	 * @return a string representing the std output of the external program 
	 */
	public static String runExternalProcess(String [] params, boolean showOutput, Set<Integer> legalExitCodes){
		
		StringBuilder output = new StringBuilder();
		ProcessBuilder pb = new ProcessBuilder(params);
		Process proc = null;

		try {
			pb.redirectErrorStream(true);
			
			if(showOutput){
				pb.inheritIO();
				proc = pb.start();
			}
			else {
				proc = pb.start();
				BufferedReader reader = 
		                new BufferedReader(new InputStreamReader(proc.getInputStream()));
				String line = null;
				while ( (line = reader.readLine()) != null) {
				   output.append(line);
				   output.append(System.getProperty("line.separator"));
				}
			}

			proc.waitFor();
			
			int exitValue = proc.exitValue();

			String errStr = null;

			if(!legalExitCodes.contains(exitValue))
				errStr = "Unknown exit value: " + exitValue + 
						"\nParams: " + Arrays.toString(params) + 
						"\nConsole: " + output.toString();
			
			if(errStr != null)
				System.err.println(errStr);
		}
		catch(IOException | InterruptedException e){
			e.printStackTrace();
		}

		return output.toString();
	}
}
