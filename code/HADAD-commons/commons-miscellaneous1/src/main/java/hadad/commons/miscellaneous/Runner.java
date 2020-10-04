package hadad.commons.miscellaneous;

import org.apache.log4j.Logger;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.ParameterException;

/**
 * Base runner for programs that use JCommander (command line parameters
 * parser).
 */
public abstract class Runner {
	protected static final Logger log = Logger.getLogger(Runner.class);
	protected static JCommander jc;

	/**
	 * Parse the command line parameters and returns the settings.
	 * 
	 * @param programName
	 * @param parameters
	 *            Modified by the method to set command line parameters
	 * @param args
	 * @return settings
	 */
	protected static final Parameters parseCommendLine(
			final String programName, Parameters parameters, String[] args) {
		jc = new JCommander(parameters);
		jc.setProgramName("java -jar " + programName);
		try {
			jc.parse(args);
		} catch (ParameterException e) {
			displayUsage();
			handleException(e);
		}
		Debugger.setFlag(parameters.isVerbose());

		return parameters;
	}

	/**
	 * Displays usage.
	 */
	protected static final void displayUsage() {
		if (jc != null) {
			jc.usage();
		}
	}

	/**
	 * Logs the error message and prints the stack trace.
	 *
	 * @param e
	 */
	protected static final void logException(final Exception e) {
		log.error(e.getMessage());
		e.printStackTrace();
	}

	/**
	 * Prints the stack trace and exit.
	 *
	 * @param e
	 */
	protected static final void handleException(final Exception e) {
		logException(e);
		exit();
	}

	/**
	 * Exits without error
	 */
	protected static final void exit() {
		System.exit(0);
	}
}
