package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StringExamples {

	public static void main(String[] args) {
		String str = "abbbcddddeffabbbbbb";
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		int i = 0;
		int end = str.length();
		Stack<Character> charStack = new Stack<Character>();
		while (i < end) {
			if (i < end - 1 && str.charAt(i) == str.charAt(i + 1)) {
				charStack.push(str.charAt(i));
			} else {
				while (!charStack.isEmpty()) {
					charStack.pop();
				}
			}
			if (map.containsKey(str.charAt(i)) && !charStack.isEmpty()) {
				int newcnt = map.get(str.charAt(i));
				map.put(str.charAt(i), newcnt + 1);

			}
			if (!map.containsKey(str.charAt(i)) && !charStack.isEmpty()) {
				map.put(str.charAt(i), 1);
				while (!charStack.isEmpty()) {
					charStack.pop();
				}
			}
			i++;
		}
		System.err.println(map);

	}

}
