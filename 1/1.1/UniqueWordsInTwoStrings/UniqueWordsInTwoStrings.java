// Return a list of words that exists in one sentence but not on the other one.
// for example s1 = "I am happy" s2 = "I am old", you have to return ["happy", "old"] 

import java.util.ArrayList;
import java.util.Arrays;


public class UniqueWordsInTwoStrings {
	
	public static void main(String[] args) {
		String str1 = "I am happy";
		String str2 = "I  am                          Bro";
		String[] arr1 = str1.split("\\s+");
		String[] arr2 = str2.split("\\s+");
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		for (String str : arr1) {
			list1.add(str);
		}
		for (String str : arr2) {
			list2.add(str);
		}
		ArrayList<String> list3 = new ArrayList<String>();
		list3.addAll(list1);
		list3.addAll(list2);
		list1.retainAll(list2);
		list3.removeAll(list1);
		System.out.println(list3.toString());
	}

}

// O/P
// [happy, Bro]
