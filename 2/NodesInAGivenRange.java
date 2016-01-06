// Write a function that counts the nodes in BS-tree whose values fit in the given range.

public int CountNodesForRange(Node root, int min_range, int max_range) {
    if (root == NULL) return 0;
    return CountNodesForRange(root.left, min_range, max_range) +
           CountNodesForRange(root.right, min_range, max_range) +
           (root.value >= min_range && root.value <= max_range ? 1 : 0);
}
