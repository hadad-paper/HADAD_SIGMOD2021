package hadad.commons.miscellaneous;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableList;

/**
 * Class collecting utilities for Collections
 */
public class CollectionsUtils {

	/**
	 * Pretty print of a collection
	 * @param c collection to be printed
	 * @return pretty string representation the collection
	 */
	public static <T> String prettyPrint(Collection<T> c){
		return c.toString().replace("[", "[\n").replace("]", "\n]").replace(", ", ",\n");
	}
	
	/**
	 * Tests if two collections are equivalent
	 * @param a first collection
	 * @param b second collection
	 * @return true iff the two collections are identical
	 */
	public static <T extends Object> boolean areIdentical(Collection<T> a, 
			Collection<T> b){
		return a.containsAll(b) && b.containsAll(a);
	}

	/**
	 * Compute the intersection of two collections
	 * @param a first collection
	 * @param b second collection
	 * @return the intersection (set) of two collections
	 */
	public static <T extends Object> Set<T> computeIntersection(
			Collection<T> a, Collection<T> b){
		Set<T> res = new HashSet<>();

		for (T object : b)
			if(a.contains(object))
				res.add(object);

		return res;
	}
	
	/**
	 * Returns a random sampling of a percentage of a list
	 * @param c list to be used for sampling
	 * @param percentage of elements to be sampled
	 * @return sampling of the requested percentage of elements 
	 */
	public static <T> List<T> selectPercentage(
			List<T> c, int percentage){
		Collections.shuffle(c);
		return c.subList(0, c.size() * percentage/100);
	}
	
	/**
	 * Returns a random sampling of a percentage of a list
	 * @param c list to be used for sampling
	 * @param percentage of elements to be sampled
	 * @return sampling of the requested percentage of elements 
	 */
	public static <T> List<T> randomSample(List<T> items, int percentage){
		return randomSample(items, percentage, new Random());
	}

	/**
	 * Returns a random sampling of a percentage of a list
	 * @param c list to be used for sampling
	 * @param percentage of elements to be sampled
	 * @param rnd random number generator to be used during sampling
	 * @return sampling of the requested percentage of elements 
	 */
	public static <T> List<T> randomSample(List<T> items, int percentage, Random rnd){
		int m = items.size() * percentage / 100;
	    List<T> res = new ArrayList<T>(m);
	    int n = items.size();
	    for(int i=n-m;i<n;i++){
	        int pos = rnd.nextInt(i+1);
	        T item = items.get(pos);
	        if (res.contains(item))
	            res.add(items.get(i));
	        else
	            res.add(item);
	    }
	    return res;
	}
	
	/**
	 * Get the precision computed as |TP| / |comp|, where:
	 * true positive (TP) = in both collections
	 * true negative (TN) = in none of the collections
	 * false positive (FP) = in the computed collection but not in the expected one,
	 * false negative (FN) = in the expected collection but not in the computed one;
	 * @param comp computed collections of elements
	 * @param exp expected collections of elements
	 * @return the (Information Retrieval) precision of the computed elements against the expected ones 
	 */
	public static <T extends Object> float getPrecision(Collection<T> comp, Collection<T> exp){
		float num = computeIntersection(comp,exp).size();
		return num / comp.size();
	}

	/**
	 * Get the recall computed as |TP| / |exp|, where:
	 * true positive (TP) = in both collections
	 * true negative (TN) = in none of the collections
	 * false positive (FP) = in the computed collection but not in the expected one,
	 * false negative (FN) = in the expected collection but not in the computed one;
	 * @param comp computed collections of elements
	 * @param exp expected collections of elements
	 * @return the recall of the computed elements against the expected ones 
	 */
	public static <T extends Object> float getRecall(Collection<T> comp, Collection<T> exp){
		float num = computeIntersection(comp,exp).size();
		return num / exp.size();
	}

	/**
	 * Get the f-measure computed as 2 * precision * recall / (precision + recall)
	 * @param comp computed collections of elements
	 * @param exp expected collections of elements
	 * @return the f-measure of the computed elements against the expected ones 
	 */
	public static <T extends Object> float getFMeasure(Collection<T> comp, Collection<T> exp){
		float prec = getPrecision(comp,exp);
		float recall = getRecall(comp,exp);
		return getFMeasure(prec,  recall);
	}
	
	/**
	 * Get the f-measure as 2 * precision * recall / (precision + recall)
	 * @param prec precision
	 * @param prec recall 
	 * @return the f-measure of the computed elements against the expected ones 
	 */
	public static <T extends Object> float getFMeasure(float prec, float recall){
		return (2 * prec * recall) / (prec + recall);
	}

	/**
	 * Computes all the subsets of a given set.
	 * @param set the set for which we aim at computing all the subsets.
	 * @return all the subsets of a given set.
	 */
	public static <T> Set<Set<T>> getAllSubsets(final Set<T> set) {
		final Set<Set<T>> res = new HashSet<>();
		res.add(new HashSet<>());
		
		while(res.size() < Math.pow(2, set.size())){
			final Iterator<Set<T>> itr = res.iterator();
			final Set<Set<T>> newSubsets = new HashSet<>();
			
			while(itr.hasNext()){
				final Set<T> prevSubset = itr.next();
				for (final T elem : set) {
					final Set<T> subset = new HashSet<>(prevSubset);
					subset.add(elem);
					newSubsets.add(subset);
				}
			}
			res.addAll(newSubsets);
		}

		return res;
	}
	
	/**
	 * Compute the average of a list of double values
	 * @param x list of double values
	 * @return the average of a list of double values
	 */
	public static double getAvg(List<Double> x){
		double tot = 0;
		for (int i = 0; i < x.size(); i++)
			tot += x.get(i);
		return tot/x.size();
	}

	/**
	 * Compute the standard deviation of a list of double values
	 * @param avg the average of the list
	 * @param x list of double values
	 * @return the standard deviation of the list of double values
	 */
	public static double getStdDev(double avg, List<Double> x){
		double sd = 0;
		for (int i=0; i<x.size();i++)
			sd += Math.pow(x.get(i) - avg, 2);
		return Math.sqrt(sd/(x.size()-1));
	}
	
	/**
	 * Compute the standard deviation of a list of double values
	 * @param x list of double values
	 * @return the standard deviation of the list of double values
	 */
	public static double getStdDev(List<Double> x){
		double sd = 0;
		double avg = getAvg(x);
		for (int i=0; i<x.size();i++)
			sd += Math.pow(x.get(i) - avg, 2);
		return Math.sqrt(sd/(x.size()-1));
	}

	/**
	 * Returns the corresponding sorted list for the given set
	 * 
	 * @param set
	 *            whose elements are to be sorted
	 * @return sorted list for the given set
	 */
	public static <T extends Comparable<? super T>> List<T> sort(Set<T> set) {
		List<T> list = new ArrayList<T>(set);
		Collections.sort(list);
		return list;
	}
	
	public static <T> List<List<T>> computeCartesianProduct(final List<List<T>> lists){
		if(lists == null || lists.isEmpty())
			throw new IllegalArgumentException("Cannot compute the cartesian "
					+ "product over an empty or null list");
		
		final List<Iterator<T>> itrs = 
				lists.stream()
				.map(List::iterator)
				.collect(Collectors.toList());
		
		return getTuples(itrs,0);
	}
	
	private static <T> List<List<T>> getTuples(final List<Iterator<T>> itrs, final int i){
		final List<List<T>> lists = new LinkedList<>();
		
		if(i == itrs.size()-1){
			while(itrs.get(i).hasNext()){
				lists.add(ImmutableList.of(itrs.get(i).next()));
			}
		}
		else {
			final List<List<T>> lists2 = getTuples(itrs,i+1);
			while(itrs.get(i).hasNext()){
				final T n = itrs.get(i).next();
				
				for (List<T> l : lists2) {
					final List<T> newList = new ArrayList<>();
					newList.addAll(l);
					newList.add(0,n);
					lists.add(newList);
				}
			}
		}
		
		return lists;
	}
	
	public static <T> List<List<Set<T>>> getAllPartitions(final List<? extends T> c){

		int numPartitions = MathUtils.getNumberOfPartitions(c);
		
		final List<List<Set<T>>> res = new ArrayList<>(numPartitions);
		
		if(c.isEmpty())
			return res;		
		
		final List<List<Integer>> sequences = getSequences(c.size());
		
		for (final List<Integer> s : sequences) {
			final Map<Integer, Set<T>> pos2Set = new HashMap<>();
			
			for (int i = 0; i < s.size(); i++) {
				pos2Set.putIfAbsent(s.get(i), new HashSet<>());
				pos2Set.get(s.get(i)).add(c.get(i));
			}
			
			res.add(new ArrayList<>(pos2Set.values())); 
		}
		
		return res;
	}
	
	/**
	 * Returns the overlapping partitions of the given elements.
	 * @param elems the elements to be partitioned.
	 * @return the overlapping partitions.
	 */
	public static <T> List<List<List<T>>> computeOverlappingPartitionings(final List<T> elems){

		if(elems == null)
			throw new IllegalArgumentException("Cannot compute overlapping partitions "
					+ "elements starting from a null list");
		
		final Map<T, List<List<T>>> elemToPartitions = new HashMap<>();
		
		for (final List<T> partition : computeOverlappingPartitionsElements(elems)) {
			if(!partition.isEmpty()){
				final T e = partition.get(0);
				elemToPartitions.putIfAbsent(e, new ArrayList<>());
				elemToPartitions.get(e).add(partition);
			}
		}
		
		final List<List<List<T>>> partitionsOrderedList = 
				new ArrayList<>(elemToPartitions.size());
		
		for (final T elem : elems) {
			partitionsOrderedList.add(elemToPartitions.get(elem));
		}
		
		return computeCartesianProduct(partitionsOrderedList);
	}
	
	/**
	 * Returns the components of the overlapping partitions, where the first element of each 
	 * partition identifies the partition "position".
	 * @param elems the elements to be partitioned.
	 * @return the components of the overlapping partitions
	 */
	private static <T> List<List<T>> computeOverlappingPartitionsElements(final List<T> elems){
		if(elems == null)
			throw new IllegalArgumentException("Cannot compute overlapping partitions "
					+ "elements starting from a null list");
			
		if(elems.isEmpty()){
			List<List<T>> subComps = new ArrayList<>();
			subComps.add(new ArrayList<>());
			return subComps;
		}
		
		final T e = elems.get(elems.size()-1);
		final List<List<T>> subComps = 
				computeOverlappingPartitionsElements(elems.subList(0, elems.size()-1));

		final Set<Set<T>> seenOverlaps = new HashSet<>();
		
		final List<List<T>> newSubComps = new ArrayList<>();
				
		for (final List<T> subComp : subComps) {
			final Set<T> actualOverlap = new HashSet<>(subComp);
			
			if(!seenOverlaps.contains(actualOverlap)){
				List<T> newSubComp = new ArrayList<>(subComp.size()+1);
				newSubComp.add(e);
				newSubComp.addAll(subComp);
				newSubComps.add(newSubComp);
			}
			
			if(!subComp.isEmpty()){
				final List<T> newSubComp = new ArrayList<>(subComp.size()+1);
				newSubComp.addAll(subComp);
				newSubComp.add(e);
				newSubComps.add(newSubComp);
			}
		}
		
		subComps.addAll(newSubComps);
		
		return subComps;
	}
	
	public static List<List<Integer>> getSequences(final int max){
		if(max < 0)
			throw new IllegalArgumentException("Max cannot be lower than zero");
		
		final Integer [] init = new Integer[max];
		Arrays.fill(init, 1);
		
		List<Integer> actualSeq = Arrays.asList(init);

		int numPartitions = MathUtils.getNumberOfPartitions(max);
		
		final List<List<Integer>> res = new ArrayList<>(numPartitions);
		res.add(actualSeq);
		
		final int [] maxVals = new int[max];
		Arrays.fill(maxVals, 1);
		maxVals[0] = 0;
		
		for (int i = 1; i <= numPartitions+2; i++) {
			for (int pos = max-1; pos >= 0; pos--) {
				if(isIncrementable(max, maxVals, actualSeq.get(pos), pos)){
					actualSeq = new ArrayList<>(actualSeq);
					actualSeq.set(pos, actualSeq.get(pos) + 1);
					resetSuffix(actualSeq,pos);
					updateMaxVals(maxVals, actualSeq.get(pos), pos);
					res.add(actualSeq);
					break;
				}
			}
		}
		
		return res;
	}
	
	private static void updateMaxVals(final int [] maxVals, final int newVal, final int pos){		
		for (int i = pos+1; i < maxVals.length; i++) {
			maxVals[i] = Math.max(newVal, maxVals[pos]);
		}
	}
	
	private static void resetSuffix(final List<Integer> l, final int pos){
		for (int i = pos+1; i < l.size(); i++) {
			l.set(i, 1);
		}
	}
	
	private static boolean isIncrementable(final int max, final int [] maxVals, final int val, 
			final int pos){
		
		if(val >= max)
			return false;

		return val <= maxVals[pos];
	}
}