package hadad.commons.miscellaneous;

import java.util.ArrayList;
import java.util.List;

/**
 * Class collecting utilities for bit manipulation
 */
public class BitUtils {

	/**
	 * Returns the "positions" (in the binary representation) of 
	 * the set bits of a given integer
	 * @param number the number for which we aim at computing the set bits
	 * @return Returns the "positions" (in the binary representation) of 
	 * the set bits of a given integer
	 */
	public static List<Integer> setBitPositions(int number) {
	    final List<Integer> positions = new ArrayList<>();
	    int position = 0;
	    while (number != 0) {
	        if ((number & 1) != 0) {
	            positions.add(position);
	        }
	        ++position;
	        number >>>= 1;
	    }
	    return positions;
	}
}
