package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class StringAnagram {

	public static void main(String[] args) {
		String strArray[]  = {"cat", "dog", "tac", "god", "act"};
		
		printAnagramList(strArray);
	}

	private static void printAnagramList(String[] strArray) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		for(String str : strArray) {
			char[] strCharArr = str.toCharArray();
			String word = str;
			Arrays.sort(strCharArr);
			String newWord = new String(strCharArr);
			
			if(map.containsKey(newWord)) {
				map.get(newWord).add(word);
			}else {
				List<String> wordList = new ArrayList<String>();
				wordList.add(word);
				map.put(newWord, wordList);
			}
		}
		for(String key : map.keySet()) {
			List<String> values = map.get(key);
			if(values.size() > 1) {
				System.err.println(values);
			}
		}
	}

}
