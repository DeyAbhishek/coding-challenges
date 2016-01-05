// Given two binary tree, write a function which returns true if
// both the tree have the same result for their Inorder traversal, otherwise return false.
// You will have to check both the trees at the same time, i.e,
// if they  do not have the same inorder traversal then at the very first MISMATCH you should stop
// traversing both the trees immediately and should return false.
// You are NOT allowed to produce the result of the inorder
// traversal of any one or both the trees first and then compare.

SOLUTION:

// First create an Inorder Iterator for binary tree.
// Refer to  https://github.com/DeyAbhishek/CodingChallenges/tree/master/1/BinaryTreeIterator
// Then using hasNext() and next() you can compare both the trees simultaneously.

/*
bool same_inorder(node *a,node *b) {
    bst_iterator ita(a),itb(b);
    while (ita.has_next()&&itb.has_next()) {
        node *ca=ita.next();
        node *cb=itb.next();
        if (ca->val!=cb->val)
            return false;
    }
    return !ita.has_next()&&!itb.has_next();
}
*/
