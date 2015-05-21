package package1;

public class Node {

		public Node right;  //intentionally kept public
		public Node left;  //intentionally kept public
		public int value;  //intentionally kept public
		public Node(Node left, Node right, int value){
			this.left = left;
			this.right = right;
			this.value = value;
		}
	
}
