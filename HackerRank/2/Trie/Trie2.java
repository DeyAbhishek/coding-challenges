import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Trie2 {

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
            } else if (input.charAt(0) == 'r') {
                root.removeWord(input.substring(5));
            } else {
                //System.out.println(root.findOptimized(input.substring(5)));
                /*System.out.println("Number of Words with the prefix : " + input.substring(5) 
                                   + "  -->  " + root.findOptimized(input.substring(5)));  //5, 8, 12
                
                //root.removeWord(input.substring(5));
                
                System.out.println("Words with the prefix : " + input.substring(5) 
                                   + "  -->  " + root.printwordsWithPrefix(input.substring(5)));
                System.out.println("Prefix -> " + root.checkPrefix(input.substring(5)));
                System.out.println("Complete Word ->" + root.checkWord(input.substring(5)));
                System.out.println();*/
                System.out.println("Prefix -> " + root.checkPrefix(input.substring(5)));
                System.out.println("Complete Word ->" + root.checkWord(input.substring(5)));
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
    private List<String> listOfWords = new ArrayList<String>(); // list of all words having this as prefix
        //If a prefix is also a word (having terminate == true) then the prix will also be in in this list as 
        //the word is the prefix of its own
	
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
        
        if (checkWord(str)) {
            System.out.println(str + " is already present in the dictionar. Duplicate entry not allowed.");
            return;
        }
        
        numOfWords++;  //a new word is getting added. so increment
        listOfWords.add(str);  //a new word is getting added. so add this word.
        //Basically str is the part of the word after the prefix
        
		if (!children.containsKey(str.charAt(0))) {
			children.put(str.charAt(0), new TrieNode(str.charAt(0)));
		}
		TrieNode presentNode = children.get(str.charAt(0));
		presentNode.setParent(this);
		if (str.length() == 1) {
			presentNode.terminate = true;
            
            presentNode.numOfWords++;  //since a word is the prefix of itself
            presentNode.listOfWords.add(str);  //since a word is the prefix of itself
            
		} else {
			presentNode.addWord(str.substring(1));
		}
        //System.out.println("Word Added: " + str);
	}
	
	public void removeWord(String str) {
        System.out.println("Before Removing " + str + " the dictionary conatins the following words: " + Arrays.toString(listOfWords.toArray()));
		if (str.isEmpty() || str == null) {
			return;
		}
		if (!children.containsKey(str.charAt(0))) {
			return;
		}
		//TODO
        int len = str.length();
        TrieNode lastNode = this;
        for (int i = 0; i < len; i++) {
            //System.out.println("---- > > >  1");
            lastNode = lastNode.children.get(str.charAt(i));
            if (lastNode == null) {
                System.out.println("Dictionary does not contain " + str);
                return;
            }
        }
        
        if (!lastNode.terminates()) {
            System.out.println(str + " is not a complete word. It is only a prefix to some other complete word. We can only remove dictionary words which form a complete word.");
            return;
        }
         //System.out.println(lastNode.value);
        TrieNode parentNode = lastNode;
        
        int lastIndex = str. length() - 1;  // used to remove deleted words from listOfWords
        
        while (parentNode.parent != null && parentNode.children.size() == 0) {  // parentNode.children.size() == 0 because
                                                                         // we cannot delete a node
                                                                         // if it has some other child too
              //System.out.println("---- > > >  22");
            TrieNode t = parentNode;
            parentNode = parentNode.parent;
            parentNode.children.remove(t.value);  // for this we need to have the contraint parentNode.parent != null
                                                   // so that there is no NullPointerException
            t.parent = null;
            //System.out.println(parentNode.value + "   "  + parentNode.terminates());
            parentNode.numOfWords--;  //**
            lastIndex--;
            if(parentNode.terminates()) {
                break;
            }
        }
        lastIndex++;  //this one needs to be incremented here to be used in str.substring() in the following while loop
        while (parentNode != null) {  //decrementing the word count for all the remaining parent node
            parentNode.numOfWords--;
            parentNode.listOfWords.remove(str.substring(lastIndex--));
            parentNode = parentNode.parent;
        }
        
        System.out.println("After Removing " + str + " the dictionary contains the following words: " + Arrays.toString(listOfWords.toArray()));
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
        
       /*
        * Optimized version of the find method
        */
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
            int index = 0;
            for(String s : presentNode.listOfWords) {
                if(presentNode.terminates() && index++ == 0) {
                    res += p + s + "  ";  // see comments where listOfWords is declared
                    continue;
                }
                res += p + prefix.substring(0, 1) + s + "  ";
            }
            return res;
        }  else {
            return presentNode.printwordsWithPrefixHelper(prefix.substring(1), p + prefix.substring(0,1));
        }
    }
        
        
        /*
         * Checks if word is present in the chained dictionary
         */
        public boolean checkWord(String word) {
            //System.out.println("---------Checking If Word  " + word);
            return checkWord(word, false);
        }
        
        /*
         * Checks if word is present as a prefix to any word in the dictionary
         */
        public boolean checkPrefix(String word) {
            return checkWord(word, true);
        }
        
        
        public boolean checkWord(String prefix, boolean isPrefix) { //isPrefix is true for Prefix
            if (prefix.isEmpty() || prefix == null) {
                return false;
            }
            TrieNode presentNode = this;
            if (!children.containsKey(prefix.charAt(0))) {
                return false;
            } else {
                presentNode = children.get(prefix.charAt(0));
            }
            if (prefix.length() == 1) {
                /*if (isPrefix) {
                    System.out.println(prefix + "  " + presentNode.value + "  " + isPrefix +  "  " + presentNode.terminates());
                }*/
                return isPrefix || presentNode.terminates();
            } else {
                return presentNode.checkWord(prefix.substring(1), isPrefix);
            }
            
        }

	
}

}
