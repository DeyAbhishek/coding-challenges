import java.util.Iterator;
import jss2.exceptions.*;

public class LinkedBinaryTree<T> implements BinaryTreeADT<T> 
{

   protected int count;
   protected BinaryTreeNode<T> root; 

   //================================================================
   //  Creates an empty binary tree.
   //================================================================
   public LinkedBinaryTree() 
   {
      count = 0;
      root = null;
   }  // constructor LinkedBinaryTree

   //================================================================
   //  Creates a binary tree with the specified element as its root.
   //================================================================
   public LinkedBinaryTree (T element) 
   {
      count = 1;
      root = new BinaryTreeNode<T> (element);
   }  // constructor LinkedBinaryTree

   //================================================================
   //  Constructs a binary tree from the two specified binary trees.
   //================================================================
   public LinkedBinaryTree (T element, LinkedBinaryTree<T> leftSubtree,
                                 LinkedBinaryTree<T> rightSubtree) 
   {

	 root = new BinaryTreeNode<T> (element);
	 count = 1;
	 if (leftSubtree != null)
	 {
		count = count + leftSubtree.size();
		root.left = leftSubtree.root;
	 }//if
	 else
		root.left = null;
	 if (rightSubtree !=null)
	 {
		count = count + rightSubtree.size(); 
	 	root.right = rightSubtree.root;
	 }//if
	 else
		root.right = null;
 
   }  // constructor LinkedBinaryTree
   
   //================================================================
   //  Removes the left subtree of this binary tree.
   //================================================================
   public void removeLeftSubtree() 
   {
      if (root.left != null)
		count = count - root.left.numChildren() - 1;
      root.left = null;
   }  // method removeLeftSubtree

   //================================================================
   //  Removes the right subtree of this binary tree.
   //================================================================
   public void removeRightSubtree() 
   {
     if (root.right != null)
		count = count - root.right.numChildren() - 1; 
      root.right = null;
   }  // method removeRightSubtree
   
   //================================================================
   //  Deletes all nodes from the binary tree.
   //================================================================
   public void removeAllElements() 
   {
      count = 0;
      root = null;
   }  // method removeAllElements
   
   //================================================================
   //  Returns true if the binary tree is empty and false otherwise.
   //================================================================
   public boolean isEmpty() 
   {
      return (count == 0);
   }  // method isEmpty

   //================================================================
   //  Returns true if the binary tree is empty and false otherwise.
   //================================================================
   public int size() 
   {
      return count;
   }  // method size
   
   //================================================================
   //  Returns true if the tree contains an element that matches the
   //  specified target element and false otherwise.
   //================================================================
   public boolean contains (T targetElement) 
   {

      T temp;
      boolean found = false;

      try 
	 {
         temp = find (targetElement);
         found = true;
      }//try
  
      catch (Exception ElementNotFoundException) 
	 {
         found = false;
      }//catch

      return found;

   }  // method contains

   //================================================================
   //  Returns a reference to the specified target element if it is
   //  found in the binary tree.  Throws a NoSuchElementException if
   //  the specified target element is not found in the binary tree.
   //================================================================
   public T find(T targetElement) throws ElementNotFoundException {
     BinaryTreeNode<T> current = findagain( targetElement, root );
     if( current == null )
       throw new ElementNotFoundException("binarytree");
     return (current.element);
   } // method find
   //================================================================
   //  Returns a reference to the specified target element if it is
   //  found in the binary tree.
   //================================================================
   private BinaryTreeNode<T> findagain(T targetElement, BinaryTreeNode<T> next) {
     if (next == null) {
       return null;
     }
     if (next.element.equals(targetElement)) {
       return next;
     }
     BinaryTreeNode<T> temp = findagain(targetElement, next.left);
     if (temp == null) {
       temp = findagain(targetElement, next.right);
     }
     return temp;
   } // method findagain
 

   //================================================================
   //  Returns a string representation of the binary tree.
   //================================================================
   public String toString() 
   {
      ArrayUnorderedList<T> templist = new ArrayUnorderedList<T>();
      preorder (root, templist);
      return templist.toString();
   }  // method toString

   //================================================================
   //  Performs an inorder traversal on the binary tree by calling an
   //  overloaded, recursive inorder method that starts with
   //  the root.
   //================================================================
   public Iterator<T> iteratorInOrder() 
   {
      ArrayUnorderedList<T> templist = new ArrayUnorderedList<T>();
      inorder (root, templist);
      return templist.iterator();
   }  // method inorder

   //================================================================
   //  Performs a recursive inorder traversal.
   //================================================================
   protected void inorder (BinaryTreeNode<T> node, ArrayUnorderedList<T> templist) 
   {

      if (node != null) 
 	 {
         inorder (node.left, templist);
         templist.addToRear(node.element);
         inorder (node.right, templist);
      }//if

   }  // method inorder

   //================================================================
   //  Performs an preorder traversal on the binary tree by calling an
   //  overloaded, recursive preorder method that starts with
   //  the root.
   //================================================================
   public Iterator<T> iteratorPreOrder() 
   {
      ArrayUnorderedList<T> templist = new ArrayUnorderedList<T>();
      preorder (root, templist);
       return templist.iterator();
   }  // method preorder

   //================================================================
   //  Performs a recursive preorder traversal.
   //================================================================
   protected void preorder (BinaryTreeNode<T> node, ArrayUnorderedList<T> templist) 
   {

      if (node != null) 
	 {
         templist.addToRear(node.element);
         preorder (node.left, templist);
         preorder (node.right, templist);
      }//if

   }  // method preorder

   //================================================================
   //  Performs an postorder traversal on the binary tree by calling
   //  an overloaded, recursive postorder method that starts
   //  with the root.
   //================================================================
   public Iterator<T> iteratorPostOrder() 
   {
      ArrayUnorderedList<T> templist = new ArrayUnorderedList<T>();
      postorder (root, templist);
      return templist.iterator();
   }  // method postorder

   //================================================================
   //  Performs a recursive postorder traversal.
   //================================================================
   protected void postorder (BinaryTreeNode<T> node, ArrayUnorderedList<T> templist) 
   {

      if (node != null) 
	 {
         postorder (node.left, templist);
         postorder (node.right, templist);
         templist.addToRear(node.element);
      }//if

   }  // method postorder

   //================================================================
   //  Performs a levelorder traversal on the binary tree, using a
   //  templist.
   //================================================================
   public Iterator<T> iteratorLevelOrder() 
   {

      ArrayUnorderedList<T> nodes = new ArrayUnorderedList<T>();
      ArrayUnorderedList<T> templist = new ArrayUnorderedList<T>();
      BinaryTreeNode<T> current;

      nodes.addToRear (root.element);

      while (! nodes.isEmpty()) 
	 {
         current = (BinaryTreeNode<T>)nodes.removeFirst();

         if (current != null) 
         {
            templist.addToRear(current.element);
            nodes.addToRear (current.left.element);
            nodes.addToRear (current.right.element);
         }//if
         else
            templist.addToRear(null);
      }//while
      return templist.iterator();
   }  // method levelorder
}  // class BinaryTree
