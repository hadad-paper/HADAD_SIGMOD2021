package hadad.commons.miscellaneous;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

/**
 * Class collecting utilities for various management of files, 
 * filenames, and file paths
 */
public class FileUtils {

	/**
	 * Count how many lines a text file have
	 * @param filename the file for which we count the lines
	 * @return number of lines in the text file
	 * @throws IOException for errors while counting the lines
	 */
	public static int countLines(String filename) throws IOException {
	    InputStream is = new BufferedInputStream(new FileInputStream(filename));
	    try {
	        byte[] c = new byte[1024];
	        int count = 0;
	        int readChars = 0;
	        boolean endsWithoutNewLine = false;
	        while ((readChars = is.read(c)) != -1) {
	            for (int i = 0; i < readChars; ++i) {
	                if (c[i] == '\n')
	                    ++count;
	            }
	            endsWithoutNewLine = (c[readChars - 1] != '\n');
	        }
	        if(endsWithoutNewLine) {
	            ++count;
	        } 
	        return count;
	    } finally {
	        is.close();
	    }
	}
	
	/**
	 * Create recursively a path in the filesystem
	 * @param path the path to be created
	 * return true iff the pasth either existed already of it has been created successfully
	 */
	public static boolean createDirPath(String path){
		File outDir = new File(path);
		return outDir.exists() || outDir.mkdirs();
	}

	/**
	 * Print a string into a file
	 * @param str string to be printed
	 * @param filePath path and filename where the string has to be written
	 * @throws FileNotFoundException when the file does not exist
	 */
	public static void writeStringToFile(String str, String filePath) throws FileNotFoundException{
		try (PrintWriter tmpASP = new PrintWriter(filePath)){
			tmpASP.print(str);
		}
	}

	/**
	 * Reads a string from a text file
	 * @param filePath path and filename where the string has to be read
	 * @return the string representing the content of the text file
	 * @throws IOException when an error occurs during the file access
	 */
	public static String readStringFromFile(String filePath) throws IOException{
		StringBuilder sb = null;
		try(BufferedReader br = new BufferedReader(new FileReader(new File(filePath)))){
			sb = new StringBuilder();
			String line = br.readLine();

			while (line != null) {
				sb.append(line);
				sb.append('\n');
				line = br.readLine();
			}
		}
		return sb.toString();
	}

	/**
	 * Delete all files in a target directory
	 * @param dir directory where the files have to be deleted
	 * return true iff all the files have been correctly deleted, false otherwise
	 */
	public static boolean deleteAllFiles(String dir) {
		File [] tmpFiles = new File(dir).listFiles();
		boolean res = true;
		for (int i = 0; i < tmpFiles.length; i++)
			res = res && tmpFiles[i].delete();
		
		return res;
	}

	/**
	 * Return the filename without the extension, if any
	 * @param filename name of file for which we want to remove the extension
	 * @return the name of the file without the extension, if any
	 */
	public static String removeExtension(String filename) {
		int lastChar = filename.lastIndexOf('.');
		
		if(lastChar <= 0)
			return filename;
		
		return filename.substring(0,lastChar > 0 ? lastChar : filename.length());
	}

	/**
	 * Removes the path from a filename, if any
	 * @param filepath path and filename for which we aim at selecting the path
	 * @return the name of the file without the full path, if preprended
	 */
	public static String removePath(String filepath) {
		int firstChar = filepath.lastIndexOf('/');
		
		if(firstChar <= 0)
			return filepath;

		return filepath.substring(firstChar > 0 ? firstChar+1 : 0);
	}
	
	/**
	 * Removes path and extension from a filename
	 * @param filename for which we want to remove the path and extension
	 * @return filename without the path and extension
	 */
	public static String getFilenameNoExtensionFromFullPath(String filename) {
		return removePath(removeExtension(filename));
	}
	
	/**
	 * Concatenate different elements composing a filesystem path
	 * @param prefixHasSeparator if the first element has already the separator
	 * @param steps different steps composing the filesystem path
	 * @return a string representation with the system dependent escape character separating the steps of 
	 * a path
	 */
	public static String composePaths(boolean prefixHasSeparator, String ... steps){
		StringBuilder strBld = new StringBuilder();
		int c = 0;
		for (String step : steps)
			strBld.append(((c++ == 0 || prefixHasSeparator) ? "" : File.separatorChar) + step);
		
		return strBld.toString();
	}
	
	/**
	 * Concatenate different elements composing a filesystem path
	 * @param steps different steps composing the filesystem path
	 * @return a string representation with the system dependent escape character separating the steps of 
	 * a path
	 */
	public static String composePaths(String ... steps){
		return composePaths(false, steps);
	}

	/**
	 * Concatenate a prefix and suffix forming a filesystem path
	 * @param prefix of the path
	 * @param suffix of the path
	 * @return path composed by prefix + escapesymbol + suffix
	 */
	public static String composePaths(String prefix, String suffix){
		return composePaths(false, prefix, suffix);
	}	
	
	public static void serializeObject(String filepath, Object obj) 
			throws IOException {
		FileOutputStream fileOut = new FileOutputStream(filepath);
		ObjectOutputStream objOut = new ObjectOutputStream(fileOut);
		objOut.writeObject(obj);
		objOut.close();
		fileOut.close();
	}

	public static Object deserializeObject(String filepath) 
			throws IOException, ClassNotFoundException {
		FileInputStream fileIn = new FileInputStream(new File(filepath));
		ObjectInputStream in = new ObjectInputStream(fileIn);
		Object obj = in.readObject();
		in.close();
		fileIn.close();
		return obj;
	}
}