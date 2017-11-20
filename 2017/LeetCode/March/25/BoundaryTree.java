/*
537. Complex Number Multiplication
Difficulty: Medium

Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. 
Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.

Left boundary is defined as the path from root to the left-most node. 
Right boundary is defined as the path from root to the right-most node. 
If the root doesn't have left subtree or right subtree, 
then the root itself is left boundary or right boundary. 
Note this definition only applies to the input binary tree, and not applies to any subtrees.

The left-most node is defined as a leaf node you could reach when you always firstly 
travel to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.

The right-most node is also defined by the same way with left and right exchanged.

Example 1
Input:
  1
   \
    2
   / \
  3   4

Ouput:
[1, 3, 4, 2]

Explanation:
The root doesn't have left subtree, so the root itself is left boundary.
The leaves are node 3 and 4.
The right boundary are node 1,2,4. Note the anti-clockwise direction means you should output reversed right boundary.
So order them in anti-clockwise without duplicates and we have [1,3,4,2].
Example 2
Input:
    ____1_____
   /          \
  2            3
 / \          / 
4   5        6   
   / \      / \
  7   8    9  10  
       
Ouput:
[1,2,4,7,8,9,10,6,3]

Explanation:
The left boundary are node 1,2,4. (4 is the left-most node according to definition)
The leaves are node 4,7,8,9,10.
The right boundary are node 1,3,6,10. (10 is the right-most node).
So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,10,6,3].
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
public class BoundaryTree {
  /*
  ALGO : 
  Points to be noted: 
    1. You will have to take into consideration that there can be winding path while computing both left and right path
    2. One of the edge cases: when root has no left child
    3. Compute left and right path first. Because you are going to include 
    all the nodes that you encounter while traversing the left anf right most path.
    And then avoid already included nodes while computing leaves.
  */
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null) return new ArrayList();
        List<TreeNode> visited = new ArrayList<TreeNode>();  // to avoid having a node more than once in result
        List<Integer> left = new ArrayList<Integer>();
        List<Integer> leaves = new ArrayList<Integer>();
        List<Integer> right = new ArrayList<Integer>();
        TreeNode current = root;
        // Part: 1 (LEFT PATH)
        if (root.left != null) {  
            // Part: 1.a
            // Root has left child
            // Then record the whole left path either straight or winding
            while (current != null) {
                left.add(current.val);
                visited.add(current);
                if (current.left != null) current = current.left;
                else current = current.right;  // winding path
            }
        } else {  
            // Part: 1.b
            // Root DOES NOT have left child
            // Then just record root and the left most LEAF node in the right subtree (if any) 
            left.add(current.val);
            visited.add(current);
            if (current.right != null) {
                current = current.right;
                while (!(current.left == null && current.right == null)) { // checking for leaf nodes
                    if (current.left != null) current = current.left;
                    else  current = current.right;   
                }
                if (current != null) {  // record left most leaf node if any
                    left.add(current.val);
                    visited.add(current);
                }
            }
        }
            
        // Part: 2 (RIGHT PATH)
        current = root.right;
        if (current != null) { // record the right path now (if any) which can be both either straight or winding
            while (current != null) {
                if (!visited.contains(current)) { 
                    right.add(current.val); 
                    visited.add(current);
                    
                }
                if (current.right != null) {
                    current = current.right;
                } else {
                    current = current.left;  // winding path
                }
            }
        }
        
        // Part: 3 (LEAVES: need to keep in mind that the leaves already part of left 
        // and right path should not be included in in this part)
        inorder(root, leaves, visited);  // now take all the leaves anti-clockwise
        
        // COMBINATION PART - Put everything together :)
        left.addAll(leaves);  // add leaves to left path
        Collections.reverse(right); // reverse the right path to get the path in anti-clockwise
        left.addAll(right); // add right path to the rest
        
        return left;
        
    }
    
    private void inorder(TreeNode root, List<Integer> leaves, List<TreeNode> visited) {
        if (root == null) return;
        inorder(root.left, leaves, visited);
        if (root.left == null && root.right == null 
              && !visited.contains(root)) {  // avoid nodes already included while computing left and right path
            leaves.add(root.val);
        }
        inorder(root.right, leaves, visited);
    }
}
