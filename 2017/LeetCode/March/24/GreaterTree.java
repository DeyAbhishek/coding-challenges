/* 
//Link: http://www.geeksforgeeks.org/transform-bst-sum-tree/
//Link : https://leetcode.com/contest/leetcode-weekly-contest-24/problems/convert-bst-to-greater-tree/
538. Convert BST to Greater Tree

Difficulty : Medium

Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
*/

public class GreaterTree {
    public TreeNode convertBST(TreeNode root) {
        return convert(root, new IntegerWrapper());
    }
    
    private TreeNode convert(TreeNode root, IntegerWrapper iw) {
        if (root == null) return null;
        convert(root.right, iw);
        root.val += iw.value;
        iw.value = root.val;
        convert(root.left, iw);
        return root;
    }
    
    private class IntegerWrapper {
        public int value = 0;
    }
}
