public class FindMinimalSubstringContainingAllCharactersOfAGivenString {
	
	public static void main(String[] args) {
		System.out.println(
				findMinimalSubstringContaingAllCharacters("lets_test_with_py_thorn_of_rose", "python")); //py_thorn
		System.out.println(
				findMinimalSubstringContaingAllCharacters("abntphoy", "python"));
		
	}
	
	private static String findMinimalSubstringContaingAllCharacters(String str, String input) {
    //ToDo
    
		return null;
	}
	
	private boolean isComplete(HashMap<Integer, Integer> map) {
		for (Map.Entry<Integer, Integer>  entry : map.entrySet()) {
			if (entry.getValue() != 0) {
				return false;
			}
		}
		return true;
	}

}
