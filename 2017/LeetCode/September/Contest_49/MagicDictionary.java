/*
676. Implement Magic Dictionary My SubmissionsBack to Contest
User Accepted: 157
User Tried: 189
Total Accepted: 157
Total Submissions: 203
Difficulty: Medium
Implement a magic directory with buildDict, and search methods.

For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.

For the method search, you'll be given a word, and judge whether if you modify exactly 
one character into another character in this word, the modified word is in the dictionary you just built.

Example 1:
Input: buildDict(["hello", "leetcode"]), Output: Null
Input: search("hello"), Output: False
Input: search("hhllo"), Output: True
Input: search("hell"), Output: False
Input: search("leetcoded"), Output: False
Note:
You may assume that all the inputs are consist of lowercase letters a-z.
For contest purpose, the test data is rather small by now. You could think about highly efficient 
algorithm after the contest.
Please remember to RESET your class variables declared in class MagicDictionary, as static/class
variables are persisted across multiple test cases. Please see here for more details.
*
class MagicDictionary {
     
    TrieNode root;
    TrieNode lastNode;
    int miss;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        root = new TrieNode();
        lastNode = root;
        miss = 0;
        Arrays.stream(dict).forEach(s -> insertWord(s));
    }
    
    private void insertWord(String word) {
        TrieNode node = lastNode.map.get(word.charAt(0));
        if (node == null) {
            node = new TrieNode();
            node.c = word.charAt(0);
            lastNode.map.put(word.charAt(0), node);
        }
        if (word.length() == 1) {
            node.terminate = true;
            lastNode = root;
            return;
        }
        lastNode = node;
        insertWord(word.substring(1));
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        int index = 0;
        int childNodes = 0;
        for (char c : word.toCharArray()) {
            TrieNode node = lastNode.map.get(c);
            if (node != null) lastNode = node;
            index++;
            if (node == null) {
                childNodes = lastNode.map.size();
                for (Map.Entry<Character, TrieNode> entry : lastNode.map.entrySet()) {
                    lastNode = entry.getValue();
                    if (!exists(lastNode, word.substring(index))) {
                        childNodes--;
                    } else {
                        return true;
                    }
                }
            }
        }
        lastNode = root;
        return childNodes != 0;
    }
    
    private boolean exists(TrieNode root, String word) {
       TrieNode node = root.map.get(word.charAt(0));
        if (node == null) {
             return false;
        }
        if (word.length() == 1) {
            return node.terminate == true;
        }
        return exists(node, word.substring(1));
    }
}

class TrieNode {
    char c;
    public Map<Character, TrieNode> map = new HashMap();
    boolean terminate;
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
