package hadad.commons.miscellaneous;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import hadad.commons.miscellaneous.CollectionsUtils;
import hadad.commons.miscellaneous.MathUtils;

public class PartitioningSequencesTest {

	@Test
	public void test() {
		int max = 7;
		final List<List<Integer>> sequences = CollectionsUtils.getSequences(max);

		int numPartitions = MathUtils.getNumberOfPartitions(max);

		if(sequences.size() != numPartitions)
			fail("The number of partitions should be " + numPartitions + 
					", found " + sequences.size() + "\n" + sequences);
		
		final List<Integer> s = sequences.get(numPartitions-1);
		
		for (int pos = 0; pos < max; pos++) {
			if(s.get(pos) != pos+1){
				fail("Invalid ending sequence " + s);		
			}
		}
	}
}