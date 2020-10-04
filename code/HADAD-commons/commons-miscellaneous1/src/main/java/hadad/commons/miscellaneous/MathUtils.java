package hadad.commons.miscellaneous;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Class collecting utilities for Collections
 */
public class MathUtils {

	// adapted from http://www.brpreiss.com/books/opus5/html/page460.html
	public static int binomialCoefficient(final int n, final int m){
		if(m > n)
			throw new IllegalArgumentException("Illegal parameters, m cannot be "
					+ "greater than n, but found " + m + " > " + n);
		
		int [] b = new int [n+1];
		b[0] = 1;
		
		for (int i = 1; i <= n; ++i) {
			b[i] = 1;
			for (int j =i-1; j > 0; --j) {
				b[j] += b[j-1];
			}
		}
		return b[m];
	}

	public static int bellNumber(final int n){
		int [] res = new int[n+1];
		
		res[0] = 1;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				res[i] += res[j]*binomialCoefficient(i-1, j);
			}
		}
		
		return res[n];
	}
	
	public static int getNumberOfPartitions(final int max){
		return bellNumber(max);
	}
	
	public static <T> int getNumberOfPartitions(final Collection<? extends T> c){
		return getNumberOfPartitions(c.size());
	}

	/**
	 * Returns a list of consecutive integers in the range [start,end)
	 * @param start the start of the sequence
	 * @param end the end of the sequence (excluded)
	 * @return a list of consecutive integers in the range [start,end)
	 */
	public static List<Integer> getSequenceOfIntegers(int start, int end) {
		final List<Integer> seq = new ArrayList<>(end-start);
		
		for (int i = start; i < end; i++) {
			seq.add(i);
		}
		
		return seq;
	}
}
