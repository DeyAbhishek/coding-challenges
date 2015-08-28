import java.util.*;


public class RemoveDuplicatesFromWord {

	public static void main(String[] args){
	System.out.println(removeDuplicates(""));  // null
	System.out.println(removeDuplicates(new String()));  // null
	System.out.println(removeDuplicates("Treat"));  // Trea
	}
	


	private static String removeDuplicates(String input){
		if(input.isEmpty() || input == null) return null;
		String str = input.toLowerCase();
		Set<Character> set = new HashSet<Character>();
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while(i < str.length()){
			if(!set.contains(str.charAt(i))){
				set.add(str.charAt(i));
				sb.append(input.charAt(i));
			}
			i++;
		}
		return sb.toString();
	}
	
	
}
	

// Output:
//
// null
// null
// Trea
