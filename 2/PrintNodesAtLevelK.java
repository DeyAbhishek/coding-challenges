
public class PrintNodesAtLevelK{

    public static void main(String[] args){
	
		Node d = new Node(null, null, 40);
		Node c = new Node(null, null, 30);
		Node b = new Node(d, null, 20);
		Node a = new Node(b, c, 10);
		getNodesAtK(a, 1, 2);
	}
    
    private static void getNodesAtK(Node root, int level, int K){
    if(root == null) return;
    if(level < K){
    	if(root.left != null) getNodesAtK(root.left, level + 1, K);
    	if(root.right != null) getNodesAtK(root.right, level+1, K);
    }
    if(level == K){
    	System.out.print("  " + root.value);
    	return;
    }
    
    }
	
}

// Output:
//  20  30
