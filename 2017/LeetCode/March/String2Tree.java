536. Construct Binary Tree from String My SubmissionsBack To Contest
You need to construct a binary tree from a string consisting of parenthesis and integers.

The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of parenthesis. The integer represents the root's value and a pair of parenthesis contains a child binary tree with the same structure.

You always start to construct the left child node of the parent first if it exists.

Example:
Input: "4(2(3)(1))(6(5))"
Output: return the tree root node representing the following tree:

       4
     /   \
    2     6
   / \   / 
  3   1 5   
Note:
There will only be '(', ')', '-' and '0' ~ '9' in the input string.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class String2Tree {
    public TreeNode str2tree(String s) {
        if (s.startsWith("(")) s=s.substring(1, s.length()-1);
        if (s.length()==0) return null;
        int index=s.indexOf("(");
        if (index==-1) index=s.length();
        int v=Integer.parseInt(s.substring(0,index));
        TreeNode treeNode=new TreeNode(v);
        if (index==s.length()) return treeNode;
        int cnt=1, j=0;
        for (j=index+1;;j++) {
            if (s.charAt(j)=='(') cnt++;
            if (s.charAt(j)==')') cnt--;
            if (cnt==0) break;
        }
        treeNode.left=str2tree(s.substring(index, j+1));
        treeNode.right=str2tree(s.substring(j+1));
        return treeNode;
    }
}
