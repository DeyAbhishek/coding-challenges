// The below code is not originally mine.
// Source: http://n00tc0d3r.blogspot.com/2013/08/implement-iterator-for-binarytree-i-in.html

 public class InOrderBinaryTreeIteratorImpl implements InOrderBinaryTreeIterator {  
   Stack<TreeNode> stack = new Stack<TreeNode>();  
   
   /** Push node cur and all of its left children into stack */  
   private void pushLeftChildren(TreeNode cur) {  
     while (cur != null) {  
       stack.push(cur);  
       cur = cur.left;  
     }  
     
   
   
   private class InOrderBinaryTreeIterator<Integer> extends Iterator<Integer>{
   /** Constructor */  
   public InOrderBinaryTreeIterator(TreeNode root) {  
     pushLeftChildren(root);  
   }  
   
     
   @Override  
   public boolean hasNext() {  
     return !stack.isEmpty();  
   }  
   
    
   @Override  
   public Integer next() {  
     if (!hasNext()) {  
       throw new NoSuchElementException("All nodes have been visited!");  
     }  
   
     TreeNode res = stack.pop();  
     pushLeftChildren(res.right);  
   
     return res.val;  
   }  
   
   @Override  
   public void remove() {  
     throw new UnsupportedOperationException("remove() is not supported.");  
   }  
 } 
   }
 // This iterator takes extra spaces for the stack, which is O(h) at worst case, where h is the height of the tree.


// With this iterator in hand, an in-order traversal of a binary tree can be implemented as follows.
 public ArrayList<Integer> inorderTraversal(TreeNode root) {  
   InOrderBinaryTreeIterator iterator = new InOrderBinaryTreeIteratorImpl(root); 
   ArrayList<Integer> results = new ArrayList<Integer>();
   while (iterator.hasNext()) {   
     results.add(iterator.next());  
   }   
   return results;    
 }
