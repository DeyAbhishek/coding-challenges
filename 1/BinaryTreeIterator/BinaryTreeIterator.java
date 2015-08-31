// The below code is not originally mine.
// Source: http://www2.hawaii.edu/~esb/2010spring.ics211/TreeIterator.java.html



import java.util.Stack;
import java.util.Iterator;

public class BinaryTreeIterator<T> implements Iterator<T> {
    /* the class variables keep track of how much the iterator
     * has done so far, and what remains to be done.
     * root is null when the iterator has not been initialized,
     * or the entire tree has been visited.
     * the first stack keeps track of the last node to return
     * and all its ancestors
     * the second stack keeps track of whether the node visited
     * is to the left (false) or right (true) of its parent
     */
    protected BinaryNode<T> root = null;
    protected Stack<BinaryNode<T>> visiting = new Stack<BinaryNode<T>>();
    protected Stack<Boolean> visitingRightChild = new Stack<Boolean>();
    /* only one of these booleans can be true */
    boolean preorder = false;
    boolean inorder = true;
    boolean postorder = false;

    /* constructor for in-order traversal
     * @param	root of the tree to traverse
     */
    public TreeIterator(BinaryNode<T> root) {
	this.root = root;
	visiting = new Stack<BinaryNode<T>>();
	visitingRightChild = new Stack<Boolean>();
	preorder = false;
	inorder = true;
	postorder = false;
    }

    /* constructor for pre-order or post-order traversal
     * @param	root of the tree to traverse
     * @param	inPreorder true if pre-order, false if post-order
     */
    public TreeIterator(BinaryNode<T> root, boolean inPreorder) {
	this.root = root;
	visiting = new Stack<BinaryNode<T>>();
	visitingRightChild = new Stack<Boolean>();
	preorder = inPreorder;
	inorder = false;
	postorder = ! preorder;
    }

    public boolean hasNext() {
	return (root != null);
    }

    public T next() {
	if (! hasNext()) {
	    throw new java.util.NoSuchElementException("no more elements");
	}
	if (preorder) {
	    return preorderNext();
	} else if (inorder) {
	    return inorderNext();
	} else if (postorder) {
	    return postorderNext();
	} else {
	    assert(false);
	    return null;
	}
    }
    
     // return the node at the top of the stack, push the next node if any
    private T preorderNext() {
	if (visiting.empty()) {	// at beginning of iterator
	    visiting.push(root);
	}
	BinaryNode<T> node = visiting.pop();
	T result = node.getValue();
	// need to visit the left subtree first, then the right
	// since a stack is a LIFO, push the right subtree first, then
	// the left.  Only push non-null trees
	if (node.getRight() != null) {
	    visiting.push(node.getRight());
	}
	if (node.getLeft() != null) {
	    visiting.push(node.getLeft());
	}
	// may not have pushed anything.  If so, we are at the end
	if (visiting.empty()) { // no more nodes to visit
	    root = null;
	}
	return node.getValue();
    }

    /* find the leftmost node from this root, pushing all the
     * intermediate nodes onto the visiting stack
     * @param	node the root of the subtree for which we
     *		are trying to reach the leftmost node
     * @changes	visiting takes all nodes between node and the leftmost
     */
    private void pushLeftmostNode(BinaryNode<T> node) {
	// find the leftmost node
	if (node != null) {
	    visiting.push(node); // push this node
	    pushLeftmostNode(node.getLeft()); // recurse on next left node
	}
    }

    /* return the leftmost node that has not yet been visited
     * that node is normally on top of the stack
     * inorder traversal doesn't use the visitingRightChild stack
     */
    private T inorderNext() {
	if (visiting.empty()) {	// at beginning of iterator
	    // find the leftmost node, pushing all the intermediate nodes
	    // onto the visiting stack
	    pushLeftmostNode(root);
	} // now the leftmost unvisited node is on top of the visiting stack
	BinaryNode<T> node = visiting.pop();
	T result = node.getValue(); // this is the value to return
	// if the node has a right child, its leftmost node is next
	if (node.getRight() != null) {
	    BinaryNode<T> right = node.getRight();
	    // find the leftmost node of the right child
	    pushLeftmostNode (right);
	    // note "node" has been replaced on the stack by its right child
	} // else: no right subtree, go back up the stack
	  // next node on stack will be next returned
	if (visiting.empty()) { // no next node left
	    root = null;
	}
	return result;
    }
    
     /* find the leftmost node from this root, pushing all the
     * intermediate nodes onto the visiting stack
     * and also stating that each is a left child of its parent
     * @param	node the root of the subtree for which we
     *		are trying to reach the leftmost node
     * @changes	visiting takes all nodes between node and the leftmost
     */
    private void pushLeftmostNodeRecord(BinaryNode<T> node) {
	// find the leftmost node
	if (node != null) {
	    visiting.push(node); // push this node
	    visitingRightChild.push(false); // record that it is on the left
	    pushLeftmostNodeRecord(node.getLeft()); // continue looping
	}
    }

    // 
    private T postorderNext() {
	if (visiting.empty()) {	// at beginning of iterator
	    // find the leftmost node, pushing all the intermediate nodes
	    // onto the visiting stack
	    pushLeftmostNodeRecord(root);
	} // the node on top of the visiting stack is the next one to be
	  // visited, unless it has a right subtree
	if ((visiting.peek().getRight() == null) || // no right subtree, or
	    (visitingRightChild.peek())) { // right subtree already visited
	    // already visited right child, time to visit the node on top
	    T result = visiting.pop().getValue();
	    visitingRightChild.pop();
	    if (visiting.empty()) {
		root = null;
	    }
	    return result;
	} else { // now visit this node's right subtree
	    // pop false and push true for visiting right child
	    if (visitingRightChild.pop()) {
		assert(false);
	    }
	    visitingRightChild.push(true);
	    // now push everything down to the leftmost node
	    // in the right subtree
	    BinaryNode<T> right = visiting.peek().getRight();
	    assert(right != null);
	    pushLeftmostNodeRecord(right);
	    // use recursive call to visit that node
	    return postorderNext();
	}
    }

    /* not implemented */
    public void remove() {
	throw new java.lang.UnsupportedOperationException("remove");
    }

    /* give the entire state of the iterator: the tree and the two stacks */
    public String toString() {
	if (preorder) {
	    return "pre: " + toString(root) + "\n" + visiting + "\n";
	}
	if (inorder) {
	    return "in: " + toString(root) + "\n" + visiting + "\n";
	}
	if (postorder) {
	    return "post: " + toString(root) + "\n" + visiting + "\n" +
		visitingRightChild;
	}
	return "none of pre-order, in-order, or post-order are true";
    }
    
    private String toString(BinaryNode<T> node) {
	if (node == null) {
	    return "";
	} else {
	    return node.toString() + "(" + toString(node.getLeft()) + ", " +
		   toString(node.getRight()) + ")";
	}
    }

    /* unit test
     * @param	arguments, ignored
     */
    public static void main(String[] arguments) {
	BinaryNode<String> x = new BinaryNode<String>("x");
	BinaryNode<String> z = new BinaryNode<String>("z");
	BinaryNode<String> y = new BinaryNode<String>("y", x, z);
	testIterator(new TreeIterator<String>(y));

	testIterator(new TreeIterator<String>(y, true));
	testIterator(new TreeIterator<String>(y, false));

	BinaryNode<String> a = new BinaryNode<String>("a");
	BinaryNode<String> c = new BinaryNode<String>("c");
	BinaryNode<String> b = new BinaryNode<String>("b", a, null);
	BinaryNode<String> m = new BinaryNode<String>("m", b, y);
	testIterator(new TreeIterator<String>(m));

	testIterator(new TreeIterator<String>(m, true));
	testIterator(new TreeIterator<String>(m, false));

    }

    public static void testIterator(Iterator<String> it) {
	System.out.println("it = " + it);
	while (it.hasNext()) {
	    String result = it.next();
	    System.out.println("it.next gives " + result + "\n it = " + it);
	}
    }
}
