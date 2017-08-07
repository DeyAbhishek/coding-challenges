/*
654. Maximum Binary Tree 
Difficulty: Medium
Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
Note:
The size of the given array will be in the range [1,1000].
*/


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MaximumBinaryTree {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>(); // mapping element to their indices
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        return constructMaxBinTree(nums, 0, nums.length - 1);
    }
    
    private TreeNode constructMaxBinTree(int[] nums, int beg, int end) {
        if (beg > end) return null;
        if (beg == end) return new TreeNode(nums[beg]);
        int max = getMax(nums, beg, end);
        int index = map.get(max);
        TreeNode root = new TreeNode(nums[index]);
        root.left = constructMaxBinTree(nums, beg, index - 1);
        root.right = constructMaxBinTree(nums, index + 1, end);
        return root;
    }
    
    private int getMax(int[] nums, int beg, int end) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = beg; i <= end; i++) {
            list.add(nums[i]);
        }
        System.out.println(list.size());
        Collections.sort(list);
        return list.get(list.size() - 1);
    }
      
}
