package hadad.commons.miscellaneous;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.ImmutableSet;

import hadad.commons.miscellaneous.CollectionsUtils;

public class AllSubsetsTest {

	final Set<Integer> set1 = ImmutableSet.of(1,2,3,4);
	final Set<Integer> emptySet = ImmutableSet.of();
		
	@Test
	public void test() {
		
		final Set<Set<Integer>> expectedRes1 = new HashSet<>();
		
		expectedRes1.add(emptySet);
		
		expectedRes1.add(ImmutableSet.of(1));
		expectedRes1.add(ImmutableSet.of(2));
		expectedRes1.add(ImmutableSet.of(3));
		expectedRes1.add(ImmutableSet.of(4));
	
		expectedRes1.add(ImmutableSet.of(1,2));
		expectedRes1.add(ImmutableSet.of(1,3));
		expectedRes1.add(ImmutableSet.of(1,4));
		expectedRes1.add(ImmutableSet.of(2,3));
		expectedRes1.add(ImmutableSet.of(2,4));
		expectedRes1.add(ImmutableSet.of(3,4));

		expectedRes1.add(ImmutableSet.of(1,2,3));
		expectedRes1.add(ImmutableSet.of(1,2,4));
		expectedRes1.add(ImmutableSet.of(1,3,4));
		expectedRes1.add(ImmutableSet.of(2,3,4));

		expectedRes1.add(ImmutableSet.of(1,2,3,4));
				
		final Set<Set<Integer>> compRes = CollectionsUtils.getAllSubsets(set1); 
		
		if(expectedRes1.size() != compRes.size())
			fail("Expected result size " + expectedRes1.size() + ", got " + compRes.size());
			
		for (final Set<Integer> s : compRes) {
			if(!expectedRes1.contains(s)){
				fail(s + " was not expected");
			}
		}
		
		final Set<Set<Integer>> compResEmpty = CollectionsUtils.getAllSubsets(emptySet);
		
		if(compResEmpty.size() != 1){
			fail("Expected result size 1, got " + compResEmpty.size());
		}
		
		if(!compResEmpty.iterator().next().equals(emptySet)){
			fail("The only subset of the empty set should be itself, got " + compResEmpty);
		}
	}
}
