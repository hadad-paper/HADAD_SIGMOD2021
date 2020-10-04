package hadad.commons.miscellaneous;

import java.io.File;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

/**
 * JCommander validator. Asserts that the argument is an existent directory.
 */
public final class ExistentDirectoryValidator implements IParameterValidator {
	@Override
	public void validate(final String name, final String value) throws ParameterException {
		final File f = new File(value);
		if (!f.exists() || !f.isDirectory()) {
			throw new ParameterException("Parameter " + name
					+ " should be an existent directory (found " + value + ")");
		}
	}
}
