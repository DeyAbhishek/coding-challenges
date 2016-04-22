// https://www.hackerrank.com/challenges/contacts

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Contacts {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        TrieNode root = new TrieNode();
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i = 0;
        sc.nextLine();
        while (i < t) {
            String input = sc.nextLine();
            if(input.charAt(0) == 'a') {
                root.addWord(input.substring(4));
            } else {
                System.out.println(root.findOptimized(input.substring(5)));  //5, 8, 12
                //System.out.println(root.printwordsWithPrefix(input.substring(5)));  //prints all the words with this prefix
            }
            i++;
        }
        //System.out.println("Number of Words Present: " + root.numWords());
    }
    
    static class TrieNode {
	
	private char value;
	private HashMap<Character, TrieNode> children;
	private boolean terminate = false;
	
	private TrieNode parent; //OPTIONAL : needed if we implement removeWord method.
							 // parent = null for root
        
    private int numOfWords;
    private List<String> listOfWords = new ArrayList<String>();
	
	public TrieNode() {  // This one is used only to create the root element.
		children = new HashMap<Character, TrieNode>();
		parent = null;
        
        numOfWords = 0;
	}
	
	public TrieNode(char value) {
		this();
		this.value = value;
	}
	
	public void addWord(String str) {
		if (str.isEmpty() || str == null) {
			return;
		}
        numOfWords++;
        listOfWords.add(str);
		if (!children.containsKey(str.charAt(0))) {
			children.put(str.charAt(0), new TrieNode(str.charAt(0)));
		}
		TrieNode presentNode = children.get(str.charAt(0));
		presentNode.setParent(this);
		if (str.length() == 1) {
			presentNode.terminate = true;
            presentNode.numOfWords++;
            presentNode.listOfWords.add(str);
		} else {
			presentNode.addWord(str.substring(1));
		}
	}
	
	public void removeWord(String str) {
		if (str.isEmpty() || str == null) {
			return;
		}
		if (!children.containsKey(str.charAt(0))) {
			return;
		}
		//TODO
	}
	
	public TrieNode removeChild(char child) {
		if (!children.containsKey(child)) {
			return null;
		}
		TrieNode childNode = children.get(child);
		if (childNode.children.size() == 0) {  //remove the child only if the child has no children
			children.remove(child);
		    return childNode.parent;
		}
		return null;
	}
	
	public boolean terminates() {
		return terminate;
	}
	
	public void setTerminates(boolean terminates) {
		this.terminate = terminates;
	}
	
	public boolean hasChildNode(char child) {
		return children.containsKey(child);
	}
	
	public TrieNode getChildNode(char child) {
		return children.get(child);
	}

	public TrieNode getParent() {
		return parent;
	}

	public void setParent(TrieNode parent) {
		this.parent = parent;
	}
        //----------------------//
    public int numChildren() {
        return children.size();
    }
        
    public int find(String prefix){
        if (prefix.isEmpty() || prefix == null) {
			return 0;
		}
        TrieNode presentNode = this;
        if (!children.containsKey(prefix.charAt(0))) {
            return 0;
        } else {
            presentNode = children.get(prefix.charAt(0));
        }
        
        if(prefix.length() == 1) {
            return presentNode.numWords();
        } else {
            return presentNode.find(prefix.substring(1));
        }
    }
        
        public String toString() {
            Set<Character> set = children.keySet();
            String str = "";
            str += set.size() + "  ";
            for (Character c : set) {
                str += c + "   ";
            }
            return str;
        }
        
        public int numWords() {
            if (numChildren() == 0) {
                return 0;
            }
            int sum = 0;
            for (Character c : children.keySet()) {
                TrieNode presentTrieNode = children.get(c);
                if(presentTrieNode.terminates()) {
                    sum++;
                }
                sum += presentTrieNode.numWords();
            }
            return sum;
        }
        
       
        public int findOptimized(String prefix){
        if (prefix.isEmpty() || prefix == null) {
			return 0;
		}
        TrieNode presentNode = this;
        if (!children.containsKey(prefix.charAt(0))) {
            return 0;
        } else {
            presentNode = children.get(prefix.charAt(0));
        }
        
        if(prefix.length() == 1) {
            return presentNode.numOfWords;
        }  else {
            return presentNode.findOptimized(prefix.substring(1));
        }
    }
        
     public String printwordsWithPrefix(String prefix) {
        return printwordsWithPrefixHelper(prefix, "");
     }
        
     public String printwordsWithPrefixHelper(String prefix, String p){
        if (prefix.isEmpty() || prefix == null) {
			return "N/A";
		}
        TrieNode presentNode = this;
        if (!children.containsKey(prefix.charAt(0))) {
            return "N/A";
        } else {
            presentNode = children.get(prefix.charAt(0));
        }
        
        if(prefix.length() == 1) {
            String res = "";
            for(String s : presentNode.listOfWords) {
                res += p + prefix.substring(0, 1) + s + "  ";
            }
            return res;
        }  else {
            return presentNode.printwordsWithPrefixHelper(prefix.substring(1), p + prefix.substring(0,1));
        }
    }

	
}

}

/*
We are going to make our own contacts application. You are given the number of operations to perform, NN.
In any contacts application, two basic operations are add and find. The input will be one of the following:

add name
find partial
For the find operation, you will have to print the number of contacts who have a name starting with that partial name.

Input Format

The first line contains the integer NN, the number of operations to be performed. 
The next NN lines contains one of the two operations defined above.

Constraints

1≤N≤1051≤N≤105 
1≤Length(name)≤211≤Length(name)≤21 
1≤Length(partial)≤211≤Length(partial)≤21

The entire input consists of lowercase characters only.

Output Format

For each operation of type find partial, print the number of contacts starting with the string partial.

Sample Input

4
add hack
add hackerrank
find hac
find hak
Sample Output

2
0
Explanation

The names hack and hackerrank both start with the string hac. We have no name starting with the string hak.
*/
