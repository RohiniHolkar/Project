package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SumOfInt {
	public static void main(String[] args) {
		System.out.println(summation(new int[] { 1, 6, 8, 5, 9, 4, 7, 2 }));
		
		pairofArrElem(new int [] {1,5,2,2,2,5,5,4}, 3);
	}

	private static void pairofArrElem(int[] a, int k) {
		Arrays.parallelSort(a);
		for(int i = 0; i < a.length ; i++) {
			while(i < a.length-1 && a[i] == a[i+1]) {
				i++;
			}
			if(Arrays.binarySearch(a, a[i] - k) >= 0){
				System.err.println("(" + a[i] +"," + (a[i] - k)+")");
			}
		}
	}

	private static List<Integer> summation(int[] arr) {
		List<Integer> summationList = new ArrayList<Integer>();
		Queue<Integer> intQ = new LinkedList<Integer>();
		for (int i : arr) {
			intQ.add(Integer.valueOf(i));
		}

		for (int i = 0; i < arr.length; i++) {
			int count = i;
			int sum = 0;
			if (!intQ.isEmpty()) {
				while (count >= 0 && !intQ.isEmpty()) {
					sum = sum + intQ.remove();
					count--;
				}
				summationList.add(sum);
			}
		}

		return summationList;
	}
}