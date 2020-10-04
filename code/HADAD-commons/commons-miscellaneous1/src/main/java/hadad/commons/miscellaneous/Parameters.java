package hadad.commons.miscellaneous;

import com.beust.jcommander.Parameter;

/**
 * Base JCommander (command line) parameters for programs that use properties
 * file.
 */
public class Parameters {
	@Parameter(names = "--help", help = true)
	private boolean help;
	@Parameter(names = { "-v", "-verbose" }, description = "Verbose")
	private boolean verbose;
	@Parameter(names = { "-pf", "-properties_file" }, validateWith = ExistentFileValidator.class, description = "Properties file name")
	private String propertiesFileName;

	public final boolean isHelp() {
		return help;
	}

	public final void setHelp(final boolean help) {
		this.help = help;
	}

	public final boolean isVerbose() {
		return verbose;
	}

	public final void setVerbose(final boolean verbose) {
		this.verbose = verbose;
	}

	public final boolean hasPropertiesFileName() {
		return propertiesFileName != null;
	}

	public final String getPropertiesFileName() {
		return propertiesFileName;
	}

	public final void setPropertiesFileName(final String propertiesFileName) {
		this.propertiesFileName = propertiesFileName;
	}
}
