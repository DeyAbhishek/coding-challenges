// Find all valid substrings from a given string which are valid dictionary words

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class DictionaryWords {
	
	public static void main(String[] args) {
		String[] dictionary = {"apple", "bat", "cat", "dog", "elephant", "fox", "saw"};
		List<String> list = Arrays.asList(dictionary);
		HashSet<String> set = new HashSet<String>();
		String str = "hesawanelephant";
		System.out.println(contains(str, 0, str.length() - 1, list, map));
	}
	
	//This method returns all the valid dictionary words present in the given string
	private static void contains(String str, int beg, int end, List<String> dictionary, HashSet<String> memo) {
		
		if (beg >= end || beg < 0 || end < 0) {
			return;
		}
		if (memo.contains(str.substring(beg, end + 1))) {
			return;
		}
		if (dictionary.contains(str.substring(beg, end + 1))) {
			System.out.println(str.substring(beg, end + 1));
		}
		memo.add(str.substring(beg, end + 1));
		contains(str, beg, end - 1, dictionary, memo);
		contains(str, beg - 1, end - 1, dictionary, memo);
		contains(str, beg + 1, end - 1, dictionary, memo);
		contains(str, beg + 1, end, dictionary, memo);
	}
	
	
	// This is an additional method
	// It returns true if there is at least one valid dictionary word in the given string
	private static boolean contains(String str, int beg, int end, List<String> dictionary, HashMap<String, Boolean> memo) {
		
		if (beg >= end || beg < 0 || end < 0) {
			return false;
		}
		if (memo.containsKey(str.substring(beg, end + 1))) {
			return memo.get(str.substring(beg, end + 1)); 
		}
		if (dictionary.contains(str.substring(beg, end + 1))) {
			System.out.println(str.substring(beg, end + 1));
			return true;
		}
		boolean res = contains(str, beg, end - 1, dictionary, memo)
				|| contains(str, beg - 1, end - 1, dictionary, memo)
				|| contains(str, beg + 1, end - 1, dictionary, memo)
				|| contains(str, beg + 1, end, dictionary, memo);
		
			memo.put(str.substring(beg, end + 1), res);
		
		return res;
	}

}
