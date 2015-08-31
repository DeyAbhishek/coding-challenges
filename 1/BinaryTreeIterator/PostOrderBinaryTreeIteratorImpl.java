public class PostOrderBinaryTreeIteratorImpl implements PostOrderBinaryTreeIterator {  
   Stack<TreeNode> stack = new Stack<TreeNode>();  
   
   /** find the first leaf in a tree rooted at cur and store intermediate nodes */  
   private void findNextLeaf(TreeNode cur) {  
     while (cur != null) {  
       stack.push(cur);  
       if (cur.left != null) {  
         cur = cur.left;  
       } else {  
         cur = cur.right;  
       }  
     }  
   }  
   
   /** Constructor */  
   public PostOrderBinaryTreeIterator(TreeNode root) {  
     findNextLeaf(root);  
   }  
   
   /** {@inheritDoc} */  
   @Override  
   public boolean hasNext() {  
     return !stack.isEmpty();  
   }  
   
   /** {@inheritDoc} */  
   @Override  
   public Integer next() {  
     if (!hasNext()) {  
       throw new NoSuchElementException("All nodes have been visited!");  
     }  
   
     TreeNode res = stack.pop();  
     if (!stack.isEmpty()) {  
       TreeNode top = stack.peek();  
       if (res == top.left) {  
         findNextLeaf(top.right); // find next leaf in right sub-tree 
       }  
     }  
   
     return res.val;  
   }  
   
   @Override  
   public void remove() {  
     throw new UnsupportedOperationException("remove() is not supported.");  
   }  
   }
   // This iterator takes extra spaces for the queue, which is O(h) at worst case, where h is the height of the tree.

  // With this iterator in hand, an post-order traversal of a binary tree can be implemented as follows.
   public ArrayList<Integer> postorderTraversal(TreeNode root) {  
   PostOrderBinaryTreeIterator iterator = new PostOrderBinaryTreeIteratorImpl(root);  
   ArrayList<Integer> results = new ArrayList<Integer>();  
   while (iterator.hasNext()) {  
     results.add(iterator.next());  
   }  
   return results;  
 }
