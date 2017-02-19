import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 * Given String = AppleBee
 * Output: Yes => Apple, Bee
 * 
 * Given String = AppleeBee
 * Output: No
 *
 */
public class FindIfTheWholeWordCanBeBrokenIntoOneOrMoreDictionaryWords {
	
	public static void main(String[] args) {
		ArrayList<String> dictionary = new ArrayList<String>();
		dictionary.add("Apple");
		dictionary.add("Bee");
		Result result = getResult("BeeAppleBee", dictionary, "");
		System.out.println(result.words);
	}
	
	private static Result getResult(String input, ArrayList<String> dictionary, String str) {
		if (dictionary.contains(input)) {
			str += input;
			return new Result(str, true);
		}
		for (int i = 1; i < input.length(); i++) {
			
			boolean result1 = dictionary.contains(input.substring(0, i));
			Result result2 = null;
			boolean result = false;
			if (result1) {
				str += input.substring(0, i) + " ";
				result2 = getResult(input.substring(i), dictionary, str);
				result = result1 && result2.res;
				if (result) {
					str = result2.words;
					return new Result(str, true);
				}
			}
			
		}
		
		return new Result("", false);
	}

}
