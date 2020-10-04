package hadad.commons.miscellaneous;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableList;

import hadad.commons.miscellaneous.CollectionsUtils;

public class CartesianProductTest {

	final List<Integer> a = ImmutableList.of(1,2,3);
	final List<Integer> b = ImmutableList.of(4,5);
	final List<Integer> c = ImmutableList.of(6,7);
		
	@Test
	public void test() {
		
		final List<List<Integer>> expectedRes = new ArrayList<>();
				
		expectedRes.add(ImmutableList.of(1,4,6));
		expectedRes.add(ImmutableList.of(1,4,7));
		expectedRes.add(ImmutableList.of(1,5,6));
		expectedRes.add(ImmutableList.of(1,5,7));

		expectedRes.add(ImmutableList.of(2,4,6));
		expectedRes.add(ImmutableList.of(2,4,7));
		expectedRes.add(ImmutableList.of(2,5,6));
		expectedRes.add(ImmutableList.of(2,5,7));

		expectedRes.add(ImmutableList.of(3,4,6));
		expectedRes.add(ImmutableList.of(3,4,7));
		expectedRes.add(ImmutableList.of(3,5,6));
		expectedRes.add(ImmutableList.of(3,5,7));

		
		final List<List<Integer>> lists = new ArrayList<>();
		lists.add(a);
		lists.add(b);
		lists.add(c);
		
		final List<List<Integer>> compRes = CollectionsUtils.computeCartesianProduct(lists); 
		
		if(expectedRes.size() != compRes.size())
			fail("Expected result size " + expectedRes.size() + ", got " + compRes.size());
			
		for (final List<Integer> l : compRes) {
			if(!expectedRes.contains(l)){
				fail(l + " was not expected");
			}
		}
	}
}
