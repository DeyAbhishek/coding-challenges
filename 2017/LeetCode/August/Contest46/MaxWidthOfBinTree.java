// Problem Description: https://leetcode.com/problems/maximum-width-of-binary-tree/description/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class MaxWidthOfBinTree {
    public int widthOfBinaryTree(TreeNode root) {
        //index and level both starts from 0
        return widthHelper(root, 0, 0, new ArrayList<Integer>(), new ArrayList<Integer>());   
    }
    
    private int widthHelper(TreeNode node, int index, int level, List<Integer> beg, List<Integer> end) {
        if (node == null) {
            return 0;
        }
        
        if (beg.size() == level) {
            beg.add(index);
            end.add(index);
        } else {
            end.set(level, index);
        }
        
        int left = widthHelper(node.left, 2 * index, level + 1, beg, end);
        int right = widthHelper(node.right, 2 * index + 1, level + 1, beg, end);
        
        int current = end.get(level) - beg.get(level) + 1;
        
        return Math.max(current, Math.max(left, right));
    }
}

/*
Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

Example 1:
Input: 

           1
         /   \
        3     2
       / \     \  
      5   3     9 

Output: 4
Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
Example 2:
Input: 

          1
         /  
        3    
       / \       
      5   3     

Output: 2
Explanation: The maximum width existing in the third level with the length 2 (5,3).
Example 3:
Input: 

          1
         / \
        3   2 
       /        
      5      

Output: 2
Explanation: The maximum width existing in the second level with the length 2 (3,2).
Example 4:
Input: 

          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).


Note: Answer will in the range of 32-bit signed integer.
*/
