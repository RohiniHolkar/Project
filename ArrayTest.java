package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class ArrayTest {
	public static void main(String args[]) {
		int arr[] = { 6, 1, 2, 1, 2, 1, 2, 1, 8, 8, 8, 8, 8, 8, 8 };

		Map<Integer, Integer> occMap = new HashMap<Integer, Integer>();

		List<Integer> intList = new ArrayList<Integer>(arr.length);

		for (int i : arr) {
			intList.add(i);
		}

		for (Integer i : intList) {
			if (occMap.containsKey(i)) {
				Integer val = occMap.get(i);
				occMap.put(i, val + 1);
			} else {
				occMap.put(i, 1);
			}

		}
		System.err.println(occMap);

		Set<Map.Entry<Integer, Integer>> sortedMap = occMap.entrySet();
		Map<Integer, Integer> linkedHashMap = new LinkedHashMap<Integer, Integer>();
		List<Entry<Integer, Integer>> valList = new ArrayList<Entry<Integer, Integer>>();
		
		for (Entry<Integer, Integer> entry : sortedMap) {
			valList.add(entry);
		}
		Comparator<Entry<Integer, Integer>> valueComparator = new Comparator<Entry<Integer, Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> e1, Entry<Integer, Integer> e2) {
				Integer v1 = e1.getValue();
				Integer v2 = e2.getValue();
				return v1.compareTo(v2);
			}
		};

		Collections.sort(valList, valueComparator);
		Collections.sort(valList, Collections.reverseOrder(valueComparator));
		for (Entry<Integer, Integer> entry : valList) {
			linkedHashMap.put(entry.getKey(), entry.getValue());
		}
		System.err.println(linkedHashMap);
		
		List<Integer> topValList = new ArrayList<Integer>();
		for(Integer val : linkedHashMap.keySet()) {
			topValList.add(val);
		}
		
		System.err.println(topValList.stream().limit(2).collect(Collectors.toList()));
	}
}