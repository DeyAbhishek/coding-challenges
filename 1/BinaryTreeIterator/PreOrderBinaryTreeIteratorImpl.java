public class PreOrderBinaryTreeIteratorImpl implements PreOrderBinaryTreeIterator {  
   Stack<TreeNode> stack = new ArrayDeque<TreeNode>();  
   
   /** Constructor */  
   public PreOrderBinaryTreeIterator(TreeNode root) {  
     if (root != null) {  
       stack.push(root); // add to end of queue 
     }  
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
   
     TreeNode res = stack.pop(); // retrieve and remove the head of queue 
     if (res.right != null) stack.push(res.right);  
     if (res.left != null) stack.push(res.left);  
   
     return res.val;  
   }  
   
   @Override  
   public void remove() {  
     throw new UnsupportedOperationException("remove() is not supported.");  
   }  
 }  
 // This iterator takes extra spaces for the stack, which is O(h) at worst case, where h is the height of the tree.




  // With this iterator in hand, an pre-order traversal of a binary tree can be implemented as follows.
 public ArrayList<Integer> preorderTraversal(TreeNode root) {  
   PreOrderBinaryTreeIterator iterator = new PreOrderBinaryTreeIteratorImpl(root);  
   ArrayList<Integer> results = new ArrayList<Integer>();  
   while (iterator.hasNext()) {  
     results.add(iterator.next());  
   }  
   return results;  
 }
