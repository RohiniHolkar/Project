package practice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class Merge2Array {
	public static void main(String args[]) {
		int a1[] = {3,7,8,0,-1,7};
		int a2[] = {5,3,8,1,2,-9};
		int a4[] = new int[a1.length + a2.length];
		int a3[] = new int[a1.length + a2.length];
		int k =0;
		
		for(int i=0; i< a1.length; i++) {
			a3[k] = a1[i];
			k++;
		}
		for(int j=0; j< a2.length; j++) {
			a3[k] = a2[j];
			k++;
		}
		System.err.println(Arrays.toString(a3));
		Set<Integer> removeDup = new LinkedHashSet<Integer>();
		for(int j=0; j< a3.length; j++) {
			removeDup.add(a3[j]);
		}
		Iterator<Integer> itr = removeDup.iterator();
		int a5[] = new int[removeDup.size()];
		int i = 0;
		while(itr.hasNext()) {
			a5[i] = itr.next();
			i++;
		}
		System.err.println(Arrays.toString(a5));
		
		Arrays.sort(a5);
		System.err.println(Arrays.toString(a5));
		//java8
		a4 = IntStream.concat(IntStream.of(a1), IntStream.of(a2)).distinct().sorted().toArray();
		
		//System.err.println(Arrays.toString(a4));
	}
}
