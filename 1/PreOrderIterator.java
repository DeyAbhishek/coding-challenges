/** Returns a preorder iterator for this tree. */
 public LinkedTreeIterator preorderIterator() {
 return new PreorderIterator();
 }
 /*** inner class for a preorder iterator ***/
 private class PreorderIterator implements LinkedTreeIterator {
 private Node nextNode;
 private PreorderIterator() {
 // The traversal starts with the root node.
 nextNode = root;
 }
 public boolean hasNext() {
 return (nextNode != null);
 }
 public int next() {
 if (nextNode == null)
 throw new NoSuchElementException();
 // Store a copy of the key to be returned.
 int key = nextNode.key;

 // Advance nextNode.
 if (nextNode.left != null)
 nextNode = nextNode.left;
 else if (nextNode.right != null)
 nextNode = nextNode.right;
 else {
 // We've just visited a leaf node.
 // Go back up the tree until we find a node
 // with a right child that we haven't seen yet.
 Node parent = nextNode.parent;
 Node child = nextNode;
 while (parent != null &&
 (parent.right == child || parent.right == null)) {
 child = parent;
 parent = parent.parent;
 }
 if (parent == null)
 nextNode = null; // the traversal is complete
 else
 nextNode = parent.right;
 }
 return key;
 }
 }
 
