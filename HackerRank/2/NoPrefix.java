// https://www.hackerrank.com/challenges/no-prefix-set

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        TrieNode root = new TrieNode();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i = 0;
        sc.nextLine();
        while (i < t) {
            String str = sc.nextLine();
            try{
                root.addWord(str);
            } catch (Exception ex) {
                System.out.println("BAD SET");
                System.out.println(ex.getMessage());
                return;
            }
            i++;
        }
        System.out.println("GOOD SET");
    }
    
    static class TrieNode {
	
	private char value;
	private HashMap<Character, TrieNode> children;
	private boolean terminate = false;
	
	public TrieNode() {  // This one is used only to create the root element.
		children = new HashMap<Character, TrieNode>();
	}
	
	public TrieNode(char value) {
		this();
		this.value = value;
	}
	
    public void addWord(String str) throws Exception {
        addWord(str, str, 0);
    }
        
	private void addWord(String str, String cache, int lengthCount) throws Exception {
		if (str.isEmpty() || str == null) {
			return;
		}
        
        if (this.terminates()) {
            throw new Exception(cache);      // This one takes care of the following type of inputs: 
                                             // add aab
                                             // add aabcd
                                             // aabcd is inserted after aab and aab is prefix of aabcd
                                             // So, it is a bad set and returns aabcd.
        }
        
        lengthCount++;
            
		if (!children.containsKey(str.charAt(0))) {
			children.put(str.charAt(0), new TrieNode(str.charAt(0)));
		} else {
            if (lengthCount == cache.length()) {
                throw new Exception(cache);  // This one takes care of the following type of inputs: 
                                             // add aabcd
                                             // add aab
                                             // aab is inserted after aabcd and aab is prefix of 
                                             // previously inserted aabcd
                                             // So, it is a bad set and returns aab.
                                             //
                                             // It alse takes care of a word being its own prefix
                                             // aad panther
                                             // aad panther
                                             // It is a bad set and returns panther (the second one, of course)
            }
        }
		TrieNode presentNode = children.get(str.charAt(0));
		if (str.length() == 1) {
			presentNode.terminate = true;
		} else {
			presentNode.addWord(str.substring(1), cache, lengthCount);
		}
	}	
	
	public boolean terminates() {
		return terminate;
	}
	 	
    }

}


/*
Given NN strings. Each string contains only lowercase letters from a−ja−j(both inclusive). The set of NN strings is said to be GOOD SET if no string is prefix of another string else, it is BAD SET. (If two strings are identical, they are considered prefixes of each other.)

For example, aab, abcde, aabcd is BAD SET because aab is prefix of aabcd.

Print GOOD SET if it satisfies the problem requirement. 
Else, print BAD SET and the first string for which the condition fails.

Input Format 
First line contains NN, the number of strings in the set. 
Then next NN lines follow, where ithith line contains ithith string.

Constraints 
1≤N≤1051≤N≤105 
1≤1≤ Length of the string ≤60≤60

Output Format 
Output GOOD SET if the set is valid. 
Else, output BAD SET followed by the first string for which the condition fails.

Sample Input00

7
aab
defgab
abcde
aabcde
cedaaa
bbbbbbbbbb
jabjjjad
Sample Output00

BAD SET
aabcde
Sample Input01

4
aab
aac
aacghgh
aabghgh
Sample Output01

BAD SET
aacghgh
Explanation 
aab is prefix of aabcde. So set is BAD SET and it fails at string aabcde.

*/
