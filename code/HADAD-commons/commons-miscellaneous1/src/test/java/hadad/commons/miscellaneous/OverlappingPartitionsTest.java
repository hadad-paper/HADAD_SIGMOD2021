package hadad.commons.miscellaneous;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.ImmutableList;

import hadad.commons.miscellaneous.CollectionsUtils;

public class OverlappingPartitionsTest {

	@Test
	public void test() {

		final List<List<List<Integer>>> partitions1 = ImmutableList.of(ImmutableList.of(ImmutableList.of(1)));

		List<List<List<Integer>>> lists = 
				ImmutableList.of(
						ImmutableList.of(
							ImmutableList.of(1), 
							ImmutableList.of(1,2)							
						),
						ImmutableList.of(
							ImmutableList.of(2),
							ImmutableList.of(2,1)
						)
				);

		final List<List<List<Integer>>> partitions2 = 
				CollectionsUtils.computeCartesianProduct(lists);
		
		lists = ImmutableList.of(
					ImmutableList.of(
							ImmutableList.of(1),
							ImmutableList.of(1,2),
							ImmutableList.of(1,2,3),
							ImmutableList.of(1,3)
					),				
					ImmutableList.of(
							ImmutableList.of(2),
							ImmutableList.of(2,1),
							ImmutableList.of(2,3),
							ImmutableList.of(2,1,3)
					),
					ImmutableList.of(
							ImmutableList.of(3),
							ImmutableList.of(3,1),
							ImmutableList.of(3,2),
							ImmutableList.of(3,1,2)
					)
				);
		
		final List<List<List<Integer>>> partitions3 = 
				CollectionsUtils.computeCartesianProduct(lists);
		
		List<List<List<Integer>>> computedPartitions = 
				CollectionsUtils.computeOverlappingPartitionings(ImmutableList.of(1)); 
		
		if(!computedPartitions.equals(partitions1))
			fail("Obtained " + computedPartitions + ", expecting " + partitions1);
		
		computedPartitions = CollectionsUtils.computeOverlappingPartitionings(ImmutableList.of(1,2)); 
		
		if(!computedPartitions.equals(partitions2))
			fail("Obtained " + computedPartitions + ", expecting " + partitions2);
					
		computedPartitions = CollectionsUtils.computeOverlappingPartitionings(ImmutableList.of(1,2,3)); 
		
		if(!computedPartitions.containsAll(partitions3))
			fail("Obtained " + computedPartitions + " that should include " + partitions3);					
	}
}