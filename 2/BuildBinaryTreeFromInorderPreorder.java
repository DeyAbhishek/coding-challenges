public class BuildBinaryTreeFromInorderPreorder{

  public Node BuildBinaryTreeFromInorderPreorder(Node[] inorderArray, Node[] preorderArray, int inorderStart, 
                                                                              int inorderEnd, int preorderIndex){
    if(inorderStart > inorderEnd) return null;
    Node root = preorderArray[preorderIndex];
    if (inorderStart == inorderEnd) return root;
    int rootIndex = search(inorderArray, root);
    preorderIndex++;
    root.left = BuildBinaryTreeFromInorderPreorder(inorderArray, preorderArray, inorderStart, rootIndex - 1, int preorderIndex);
    root.right = BuildBinaryTreeFromInorderPreorder(inorderArray, preorderArray, rootIndex + 1, inorderEnd, preorderIndex);
    return root;
  
  } 
  // HOW TO USE:
  // BuildBinaryTreeFromInorderPreorder(inorderArray, preorderArray, 0, inorderArray.length - 1, 0)
}
