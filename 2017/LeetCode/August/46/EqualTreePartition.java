//Problem Statement: https://leetcode.com/problems/equal-tree-partition/description/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class EqualTreePartition {
    public boolean checkEqualTree(TreeNode root) {
        if (root == null) return false;
        
        //return false if the root has no child at all, i.e, a tree with only one node
        if (root.left == null && root.right == null) return false;  
        
        int sum = sum(root, new IntegerWrapper());
        if (sum % 2 != 0) return false;
        
        int half = sum / 2;
        return checkSum(root, half);
    }
    
    private boolean checkSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (sum(root, new IntegerWrapper()) == sum) return true;
        return checkSum(root.left, sum) || checkSum(root.right, sum);
    }
    
    private int sum(TreeNode root, IntegerWrapper iw) {
        if (root == null) return 0;
        iw.val += root.val;
        sum(root.left, iw);
        sum(root.right, iw);
        return iw.val;
    }
    
}

class IntegerWrapper {
    int val = 0;
}


/*
Given a binary tree with n nodes, your task is to check if it's possible to partition the tree to two trees which have the equal sum of values after removing exactly one edge on the original tree.

Example 1:
Input:     
    5
   / \
  10 10
    /  \
   2   3

Output: True
Explanation: 
    5
   / 
  10
      
Sum: 15

   10
  /  \
 2    3

Sum: 15
Example 2:
Input:     
    1
   / \
  2  10
    /  \
   2   20

Output: False
Explanation: You can't split the tree into two trees with equal sum after removing exactly one edge on the tree.
Note:
The range of tree node value is in the range of [-100000, 100000].
1 <= n <= 10000
*/
