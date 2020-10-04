package hadad.commons.miscellaneous;

import java.io.File;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

/**
 * JCommander validator. Asserts that the argument is an existent file name
 */
public final class ExistentFileValidator implements IParameterValidator {
	@Override
	public void validate(final String name, final String value) throws ParameterException {
		final File f = new File(value);
		if(!f.exists()) {
			throw new ParameterException("Parameter " + name + " should be an existent file (found " + value +")");
		}
	}
}
